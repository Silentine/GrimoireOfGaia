package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaLeapAtTargetGoal;
import gaia.entity.types.IDayMob;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaHarpyEntity extends AbstractMobHostileEntity implements IDayMob {
    private static final String MOB_TYPE_TAG = "MobType";
    private static final String IS_CHILD_TAG = "IsBaby";
    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaHarpyEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>createKey(GaiaHarpyEntity.class, DataSerializers.BOOLEAN);

    private GaiaLeapAtTargetGoal leapAtTargetGoal = new GaiaLeapAtTargetGoal(this, 0.4F);
    private MeleeAttackGoal meleeAttackGoal = new GaiaHarpyEntity.LeapAttackGoal(this);
    private AvoidEntityGoal<PlayerEntity> avoidPlayerGoal = new AvoidEntityGoal<>(this, PlayerEntity.class, 20.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);

    private int switchHealth;

    public GaiaHarpyEntity(EntityType<? extends GaiaHarpyEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        switchHealth = 0;
    }

    @Override
    public void setAttackTask() {
        goalSelector.removeGoal(meleeAttackGoal);
        goalSelector.removeGoal(leapAtTargetGoal);

        setCombatTask(0);
    }

    private void setCombatTask(int id) {
        switch(id) {
            default:
                goalSelector.removeGoal(leapAtTargetGoal);
                goalSelector.removeGoal(meleeAttackGoal);
                goalSelector.addGoal(2, avoidPlayerGoal);
            case 1:
                goalSelector.addGoal(1, leapAtTargetGoal);
                goalSelector.addGoal(2, meleeAttackGoal);
                goalSelector.removeGoal(avoidPlayerGoal);
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(meleeAttackGoal);
        goalSelector.removeGoal(avoidPlayerGoal);

        setCombatTask(0);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(SKIN, 0);
        this.getDataManager().register(IS_CHILD, false);
    }

    public int getTextureType() {
        return getDataManager().get(SKIN);
    }

    private void setTextureType(int type) {
        getDataManager().set(SKIN, type);
    }

    public boolean isChild() {
        return getDataManager().get(IS_CHILD);
    }

    public void setChild(boolean isChild) {
        getDataManager().set(IS_CHILD, isChild);
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
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt(MOB_TYPE_TAG, getTextureType());
        compound.putBoolean(IS_CHILD_TAG, isChild());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            setTextureType(compound.getInt(MOB_TYPE_TAG));
        }
        if (compound.contains(IS_CHILD_TAG)) {
            setChild(compound.getBoolean(IS_CHILD_TAG));
        }
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.SLOWNESS, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
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
            setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.EGG));

            switchHealth = 0;
        }
        /* FLEE DATA */

        if (!onGround && getMotion().getY() < 0.0D) {
            Vec3d motion = getMotion();
            double motionY = motion.getY();
            motionY *= 0.8D;
            setMotion(motion.x, motionY, motion.z);
        }

        super.livingTick();
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.HARPY_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.HARPY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.HARPY_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(Items.FEATHER, 1);
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
            ItemStack itemstack = getItemStackFromSlot(EquipmentSlotType.CHEST);

            if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
                if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                    entityDropItem(GaiaBlocks.DECO_NEST_HARPY.get(), 1);
                }
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        if (!this.world.isRemote) {
            int i = MathHelper.floor(this.getPosX());
            int j = MathHelper.floor(this.getPosY());
            int k = MathHelper.floor(this.getPosZ());

            if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
                setTextureType(2);
            } else if (world.rand.nextInt(4) == 0) {
                setTextureType(1);
            }
        }

        // TEMP Method used instead of isChild
        setChild(true, 10);

        if (!isChild()) {
            ItemStack weaponCustom = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED.get(), 1);
            weaponCustom.addEnchantment(Enchantments.KNOCKBACK, 2);
            setItemStackToSlot(EquipmentSlotType.MAINHAND, weaponCustom);
        }

        setCombatTask();

        return entityData;
    }

    @Override
    public float getEyeHeight(Pose pose) {
        ItemStack itemstack = getItemStackFromSlot(EquipmentSlotType.CHEST);

        if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
            return 1.74F;
        } else {
            return 1.74F - 0.81F;
        }
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }

    static class LeapAttackGoal extends MeleeAttackGoal {

        LeapAttackGoal(GaiaHarpyEntity entity) {
            super(entity, EntityAttributes.ATTACK_SPEED_1, true);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 4.0D + attackTarget.getWidth();
        }
    }
}
