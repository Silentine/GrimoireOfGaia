package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaRangedBowAttackGoal;
import gaia.entity.goals.GaiaValidateTargetPlayerGoal;
import gaia.entity.types.IDayMob;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GaiaCentaurEntity extends AbstractMobAssistEntity implements IDayMob, ISwimmingMob, IRangedAttackMob {
    private static final String MOB_TYPE_TAG = "MobType";
    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaCentaurEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> MALE = EntityDataManager.<Boolean>createKey(GaiaCentaurEntity.class, DataSerializers.BOOLEAN);

    private final GaiaRangedBowAttackGoal rangedAttackGoal = new GaiaRangedBowAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);
    private final MeleeAttackGoal collideAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true) {
        public void resetTask() {
            super.resetTask();
            GaiaCentaurEntity.this.setAggroed(false);
        }

        public void startExecuting() {
            super.startExecuting();
            GaiaCentaurEntity.this.setAggroed(true);
        }
    };

    private final AvoidEntityGoal<PlayerEntity> aiAvoid = new AvoidEntityGoal<>(this, PlayerEntity.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
    private final AvoidEntityGoal<CreatureEntity> aiAvoidCreature = new AvoidEntityGoal<>(this, CreatureEntity.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
    private final AvoidEntityGoal<MobEntity> aiAvoidMob = new AvoidEntityGoal<>(this, MobEntity.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);

    private final GaiaValidateTargetPlayerGoal targetPlayerGoal = new GaiaValidateTargetPlayerGoal(this);

    private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.SLOWNESS);
    private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.WEAKNESS);

    private int fullHealth;
    private int regenerateHealth;

    private boolean isFriendly;

    public GaiaCentaurEntity(EntityType<? extends GaiaCentaurEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;
        fullHealth = 0;
        regenerateHealth = 0;
    }

    public GaiaCentaurEntity(World world) {
        this(GaiaEntities.CENTAUR.get(), world);
    }

    @Override
    public void setValidateTargetPlayerTask() {
        if (this.world != null && !this.world.isRemote) {
            if (GaiaConfig.COMMON.passiveHostileAllMobs.get()) {
                this.targetSelector.addGoal(2, targetPlayerGoal);
            }

            if(this.isNeutral()) {
                this.targetSelector.removeGoal(this.targetPlayerGoal);
            }
        }
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if (target.isAlive()) {
            RangedHelper.rangedAttack(target, this, distanceFactor);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public boolean isTameable() {
        return true;
    }

    @Override
    public void livingTick() {
        goalSelector.removeGoal(this.attackNearestPlayerGoal);

        if (isNeutral() && !isFriendly) {
            setCombatTask(2);
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD.get()));
            setItemStackToSlot(EquipmentSlotType.OFFHAND, ItemStack.EMPTY);
            isFriendly = true;
        }

        /* REGENERATE DATA */
        if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.25F) && (fullHealth == 0)) {
            ItemStack stacky = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION, 1), Potions.REGENERATION);
            setItemStackToSlot(EquipmentSlotType.MAINHAND, stacky);
            setCombatTask(1);
            setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.FEATHER));

            fullHealth = 1;
        }

        if ((getHealth() < EntityAttributes.MAX_HEALTH_1) && (fullHealth == 1)) {
            if (regenerateHealth <= 100) {
                ++regenerateHealth;
            } else {
                playSound(SoundEvents.ENTITY_GENERIC_DRINK, 0.15F, 1.0F);
                addPotionEffect(new EffectInstance(Effects.REGENERATION, 360, 3));
                regenerateHealth = 0;
            }
        } else if ((getHealth() >= EntityAttributes.MAX_HEALTH_1) && (fullHealth == 1)) {
            if (!isNeutral()) {
                setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
                setCombatTask(0);
            } else {
                setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD.get()));
                setCombatTask(2);
            }

            removePotionEffect(Effects.REGENERATION);
            setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.EGG));

            fullHealth = 0;
            regenerateHealth = 0;
        }
        /* REGENERATE DATA */

        super.livingTick();
    }

    private void setCombatTask(int id) {
        switch(id) {
            default:
                if (!isNeutral()) {
                    goalSelector.removeGoal(aiAvoid);
                    goalSelector.removeGoal(aiAvoidCreature);
                    goalSelector.removeGoal(aiAvoidMob);
                    goalSelector.addGoal(1, rangedAttackGoal);
                }
            case 1:
                goalSelector.removeGoal(rangedAttackGoal);
                goalSelector.removeGoal(collideAttackGoal);
                goalSelector.addGoal(1, aiAvoid);
                goalSelector.addGoal(1, aiAvoidCreature);
                goalSelector.addGoal(1, aiAvoidMob);
            case 2:
                goalSelector.removeGoal(aiAvoid);
                goalSelector.removeGoal(aiAvoidCreature);
                goalSelector.removeGoal(aiAvoidMob);
                goalSelector.addGoal(1, collideAttackGoal);
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(collideAttackGoal);
        goalSelector.removeGoal(rangedAttackGoal);
        ItemStack itemstack = getHeldItemMainhand();

        if (itemstack.getItem() instanceof BowItem) {
            int i = 20;

            if (this.world.getDifficulty() != Difficulty.HARD) {
                i = 40;
            }

            rangedAttackGoal.setAttackCooldown(i);
            setCombatTask(0);
        } else {
            setCombatTask(2);
        }
    }

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != GaiaEntities.CENTAUR.get();
    }

    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(MALE, false);
        dataManager.register(SKIN, 0);
    }

    public boolean isMale() {
        return (this.dataManager.get(MALE));
    }

    public void setMale() {
        this.dataManager.set(MALE, true);
        setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.STICK));
    }

    public int getTextureType() {
        return dataManager.get(SKIN);
    }

    private void setTextureType(int par1) {
        dataManager.set(SKIN, par1);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte(MOB_TYPE_TAG, (byte) getTextureType());
        compound.putBoolean("male", isMale());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            byte b0 = compound.getByte(MOB_TYPE_TAG);
            setTextureType(b0);
            dataManager.set(MALE, compound.getBoolean("male"));
        }

        setCombatTask();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.CENTAUR_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.CENTAUR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.CENTAUR_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(Items.LEATHER, 1);
            }

            // Nuggets/Fragments
            int dropNugget = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNugget; ++i) {
                entityDropItem(Items.IRON_NUGGET, 1);
            }

            if (GaiaConfig.COMMON.additionalOre.get()) {
                int dropNuggetAlt = rand.nextInt(3) + 1;

                for (int i = 0; i < dropNuggetAlt; ++i) {
                    ItemShard.dropNugget(this, 4);
                }
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BOX_IRON.get(), 1);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BAG_ARROW.get(), 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        if (world.rand.nextInt(4) == 0) {
            setMale();
            setTextureType(2);
        }

        if (!this.world.isRemote) {
            int i = MathHelper.floor(this.getPosX());
            int j = MathHelper.floor(this.getPosY());
            int k = MathHelper.floor(this.getPosZ());

            if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
                if (isMale()) {
                    setTextureType(3);
                } else {
                    setTextureType(1);
                }
            }
        }

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
        setEnchantmentBasedOnDifficulty(difficulty);

        if (world.rand.nextInt(2) == 0) {
            if (world.rand.nextInt(2) == 0) {
                setItemStackToSlot(EquipmentSlotType.OFFHAND, TIPPED_ARROW_CUSTOM);
            } else {
                setItemStackToSlot(EquipmentSlotType.OFFHAND, TIPPED_ARROW_CUSTOM_2);
            }
        }

        setCombatTask();

        return entityData;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }
}
