package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaValidateTargetPlayerGoal;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GaiaDryadEntity extends AbstractMobAssistEntity implements ISwimmingMob {
    private static final String MOB_TYPE_TAG = "MobType";
    private static final String IS_CHILD_TAG = "IsBaby";
    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaDryadEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>createKey(GaiaDryadEntity.class, DataSerializers.BOOLEAN);

    private final MeleeAttackGoal meleeAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true);
    private final AvoidEntityGoal<PlayerEntity> aiAvoid = new AvoidEntityGoal<>(this, PlayerEntity.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
    private final AvoidEntityGoal<CreatureEntity> aiAvoidCreature = new AvoidEntityGoal<>(this, CreatureEntity.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
    private final AvoidEntityGoal<MobEntity> aiAvoidMob = new AvoidEntityGoal<>(this, MobEntity.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
    private final GaiaValidateTargetPlayerGoal targetPlayerGoal = new GaiaValidateTargetPlayerGoal(this);

    private int switchHealth;
    private int axeAttack;

    private byte inWaterTimer;

    public GaiaDryadEntity(EntityType<? extends GaiaDryadEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        switchHealth = 0;
        axeAttack = 0;

        inWaterTimer = 0;
    }

    public GaiaDryadEntity(World world) {
        this(GaiaEntities.DRYAD, world);
    }

    @Override
    public int getGaiaTier() {
        return 1;
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

    private void setCombatTask(int id) {
        switch (id) {
            default:
                goalSelector.removeGoal(aiAvoid);
                goalSelector.removeGoal(aiAvoidCreature);
                goalSelector.removeGoal(aiAvoidMob);
                goalSelector.addGoal(1, meleeAttackGoal);
            case 1:
                goalSelector.removeGoal(meleeAttackGoal);
                goalSelector.addGoal(1, aiAvoid);
                goalSelector.addGoal(1, aiAvoidCreature);
                goalSelector.addGoal(1, aiAvoidMob);
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(meleeAttackGoal);
        goalSelector.removeGoal(aiAvoid);

        setCombatTask(0);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        float input = Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        Entity entity = source.getTrueSource();

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack itemstack = player.getHeldItem(getActiveHand());

            if (itemstack.getItem() instanceof AxeItem) {
                input = input * 1.5F;
                axeAttack += 1;
            }
        }

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
        if (!world.isRemote) {
            if (isWet()) {
                if (inWaterTimer <= 100) {
                    ++inWaterTimer;
                } else {
                    world.setEntityState(this, (byte) 8);
                    heal(EntityAttributes.MAX_HEALTH_1 * 0.10F);
                    addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5 * 20, 0));
                    inWaterTimer = 0;
                }
            }
        }

        if (isBurning()) {
            addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 0));
            addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 0));
        }

        /* FLEE DATA */
        if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 0)) {
            switch (rand.nextInt(2)) {
                case 0:
                    setCombatTask(1);
                    setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.FEATHER));
                    switchHealth = 1;
                    break;
                case 1:
                    switchHealth = 2;
                    break;
            }
        }

        if ((getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 1)) {
            setCombatTask(0);
            setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);

            switchHealth = 0;
        }
        /* FLEE DATA */

        super.livingTick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.DRYAD_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.DRYAD_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.DRYAD_DEATH;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GaiaLootTables.ENTITIES_GAIA_DRYAD;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_ROOT, 1);
            }

            if (axeAttack >= 4 && (rand.nextInt(2) == 0)) {
                Tag<Item> logs = ItemTags.getCollection().get(new ResourceLocation("logs"));
                entityDropItem(logs.getRandomElement(rand));
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
                entityDropItem(GaiaItems.BOX_IRON, 1);
            }
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        if (world.rand.nextInt(4) == 0) {
            setTextureType(1);
        }

        setChild(true, 10);

        setCombatTask();

        return entityData;
    }

    private void setChild(boolean isRandom, int chance) {
        if (isRandom) {
            if (world.rand.nextInt(chance) == 0) {
                setChild(true);
            }
        } else {
            setChild(true);
        }
    }

    @Override
    public float getEyeHeight(Pose pose) {
        float f;

        ItemStack itemstack = getItemStackFromSlot(EquipmentSlotType.CHEST);

        if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
            f = 1.74F;
        } else {
            f = 1.74F - 0.81F;
        }

        return f;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(SKIN, 0);
        dataManager.register(IS_CHILD, false);
    }

    public int getTextureType() {
        return dataManager.get(SKIN);
    }

    private void setTextureType(int id) {
        dataManager.set(SKIN, id);
    }

    public boolean isChild() {
        return (getDataManager().get(IS_CHILD));
    }

    public void setChild(boolean isChild) {
        getDataManager().set(IS_CHILD, isChild);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt(MOB_TYPE_TAG, (byte) getTextureType());
        compound.putBoolean(IS_CHILD_TAG, isChild());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            int type = compound.getInt(MOB_TYPE_TAG);
            setTextureType(type);
        }
        if (compound.contains(IS_CHILD_TAG)) {
            boolean isChild = compound.getBoolean(IS_CHILD_TAG);
            setChild(isChild);
        }
        setCombatTask();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return posY > 60.0D && super.canSpawn(worldIn, reason);
    }
}
