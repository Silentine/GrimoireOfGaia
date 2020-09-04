package gaia.entity.assist;

import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaRangedBowAttackGoal;
import gaia.entity.types.IDayMob;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShieldProp;
import gaia.util.RangedHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class GaiaGoblinFeralEntity extends AbstractMobAssistEntity implements IDayMob, ISwimmingMob, IRangedAttackMob {

    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 30;
    private int explosionRadius = 3;
    private float explosionPower = 1.0F;
    private static final String MOB_TYPE_TAG = "MobType";
    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaGoblinFeralEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(GaiaGoblinFeralEntity.class, DataSerializers.BOOLEAN);

    private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.SLOWNESS);

    private final GaiaRangedBowAttackGoal rangedAttackGoal = new GaiaRangedBowAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);
    private final MeleeAttackGoal collideAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true) {
        public void resetTask() {
            super.resetTask();
            GaiaGoblinFeralEntity.this.setAggroed(false);
        }

        public void startExecuting() {
            super.startExecuting();
            GaiaGoblinFeralEntity.this.setAggroed(true);
        }
    };

    public GaiaGoblinFeralEntity(EntityType<? extends GaiaGoblinFeralEntity> entityType, World world) {
        super(entityType, world);

        stepHeight = 1.0F;
        setCanPickUpLoot(true);
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void setGaiaAttributes() {
        getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1 * 0.5);
        getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
        getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
        getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1 * 0.5);
        getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if (target.isAlive()) {
            RangedHelper.rangedAttack(target, this, distanceFactor);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        if (hasShield()) {
            Entity entity = source.getImmediateSource();
            return !(entity instanceof ArrowEntity) && super.attackEntityFrom(source, attackDamage);
        } else {
            return super.attackEntityFrom(source, attackDamage);
        }
    }

    private boolean hasShield() {
        ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);

        return itemstack.getItem() instanceof ShieldItem || itemstack.getItem() instanceof ItemShieldProp;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (getTextureType() == 2 && entity instanceof LivingEntity) {
                goalSelector.removeGoal(collideAttackGoal);
                ignite();
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
        super.setItemStackToSlot(slotIn, stack);
        if (!world.isRemote && slotIn.getIndex() == 0) {
            setCombatTask();
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(collideAttackGoal);
        goalSelector.removeGoal(rangedAttackGoal);
        ItemStack itemstack = getHeldItemMainhand();

        if (itemstack.getItem() == Items.BOW) {
            int i = 20;

            if (this.world.getDifficulty() != Difficulty.HARD) {
                i = 40;
            }

            rangedAttackGoal.setAttackCooldown(i);
            goalSelector.addGoal(1, rangedAttackGoal);
        } else {
            goalSelector.addGoal(1, collideAttackGoal);
        }
    }

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != GaiaEntities.GOBLIN_FERAL.get();
    }

    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(SKIN, 0);
        dataManager.register(IGNITED, Boolean.FALSE);
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
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            byte b0 = compound.getByte(MOB_TYPE_TAG);
            setTextureType(b0);
        }

        setCombatTask();
    }

    @Override
    public void tick() {
        if (hasIgnited()) {
            if (isAlive()) {
                lastActiveTime = timeSinceIgnited;

                int i = 1;

                if (i > 0 && timeSinceIgnited == 0) {
                    playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
                }

                timeSinceIgnited += i;

                if (timeSinceIgnited < 0) {
                    timeSinceIgnited = 0;
                }

                if (timeSinceIgnited >= fuseTime) {
                    timeSinceIgnited = fuseTime;
                    explode();
                }
            }
        }

        super.tick();
    }

    private boolean hasIgnited() {
        return dataManager.get(IGNITED);
    }

    private void ignite() {
        dataManager.set(IGNITED, true);
    }

    private void explode() {
        if (!world.isRemote) {
            world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), (float) explosionRadius * explosionPower, Mode.NONE);
            remove();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getCreeperFlashIntensity(float partialTickTime) {
        return (lastActiveTime + (timeSinceIgnited - lastActiveTime) * partialTickTime) / (fuseTime - 2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.GOBLIN_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.GOBLIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.GOBLIN_DEATH;
    }

    @Override
    public void onDeath(DamageSource cause) {
        if (getTextureType() == 2) {
            explode();
        }
        super.onDeath(cause);
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        switch (getTextureType()) {
            case 0:
                return GaiaLootTables.ENTITIES_GAIA_GOBLIN_FERAL_MELEE;
            case 1:
                return GaiaLootTables.ENTITIES_GAIA_GOBLIN_FERAL_RANGED;
            case 2:
                return GaiaLootTables.ENTITIES_GAIA_GOBLIN_FERAL_BOMBER;
            default:
                return LootTables.EMPTY;
        }
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                entityDropItem(Items.IRON_NUGGET, 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        if (world.rand.nextInt(4) == 0) {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
            setEnchantmentBasedOnDifficulty(difficulty);

            setTextureType(1);
        } else {
            if (world.rand.nextInt(4) == 0) {
                setTextureType(2);
            } else {
                setEquipmentBasedOnDifficulty(difficulty);

                setTextureType(0);
            }
        }

        setCombatTask();

        return entityData;
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        if (rand.nextInt(4) == 0) {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD.get()));
        } else {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_AXE_WOOD.get()));
        }
        setEnchantmentBasedOnDifficulty(difficulty);
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
