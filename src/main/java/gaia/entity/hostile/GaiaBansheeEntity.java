package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class GaiaBansheeEntity extends AbstractMobHostileEntity implements ISwimmingMob {

    protected static final DataParameter<Byte> VEX_FLAGS = EntityDataManager.<Byte>createKey(GaiaBansheeEntity.class, DataSerializers.BYTE);

    private BlockPos boundOrigin;

    public GaiaBansheeEntity(EntityType<? extends GaiaBansheeEntity> entityType, World world) {
        super(entityType, world);
        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;

        this.moveController = new GaiaBansheeEntity.MoveHelperController(this);
    }

    public GaiaBansheeEntity(World world) {
        this(GaiaEntities.BANSHEE, world);
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    public void setAttackTask() {
        this.goalSelector.addGoal(4, new GaiaBansheeEntity.ChargeAttackGoal());
        this.goalSelector.addGoal(8, new GaiaBansheeEntity.MoveRandomGoal());
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        Entity entity = source.getImmediateSource();

        if (entity instanceof ArrowEntity) {
            damage += 2;
        }

        if (entity instanceof SpectralArrowEntity) {
            damage += 4;
        }
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            entityIn.setFire(6);
        }
        return true;
    }

    @Override
    public void livingTick() {
        if (world.isDaytime() && !world.isRemote) {
            float f = getBrightness();

            if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canBlockSeeSky(getPosition())) {
                world.setEntityState(this, (byte) 11);

                attackEntityFrom(DamageSource.IN_WALL, EntityAttributes.MAX_HEALTH_2 * 0.25F);
            }
        }

        for (int i = 0; i < 2; ++i) {
            world.addParticle(ParticleTypes.PORTAL, posX + (rand.nextDouble() - 0.5D) * getWidth(), posY + rand.nextDouble() * getHeight(), posZ + (rand.nextDouble() - 0.5D) * getWidth(), 0.0D, 0.0D, 0.0D);
        }

        super.livingTick();
    }

    @Override
    public void move(MoverType type, Vec3d pos) {
        super.move(type, pos);
        this.doBlockCollisions();
    }

    @Override
    public void tick() {
        this.noClip = true;
        super.tick();
        this.noClip = false;
        this.setNoGravity(true);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(VEX_FLAGS, Byte.valueOf((byte) 0));
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        if (compound.contains("BoundX")) {
            this.boundOrigin = new BlockPos(compound.getInt("BoundX"), compound.getInt("BoundY"), compound.getInt("BoundZ"));
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        if (this.boundOrigin != null) {
            compound.putInt("BoundX", this.boundOrigin.getX());
            compound.putInt("BoundY", this.boundOrigin.getY());
            compound.putInt("BoundZ", this.boundOrigin.getZ());
        }
    }

    @Nullable
    public BlockPos getBoundOrigin() {
        return this.boundOrigin;
    }

    public void setBoundOrigin(@Nullable BlockPos boundOriginIn) {
        this.boundOrigin = boundOriginIn;
    }

    private boolean getVexFlag(int mask) {
        int i = ((Byte) this.dataManager.get(VEX_FLAGS)).byteValue();
        return (i & mask) != 0;
    }

    private void setVexFlag(int mask, boolean value) {
        int i = ((Byte) this.dataManager.get(VEX_FLAGS)).byteValue();

        if (value) {
            i = i | mask;
        } else {
            i = i & ~mask;
        }

        this.dataManager.set(VEX_FLAGS, Byte.valueOf((byte) (i & 255)));
    }

    public boolean isCharging() {
        return this.getVexFlag(1);
    }

    public void setCharging(boolean charging) {
        this.setVexFlag(1, charging);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.BANSHEE_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.BANSHEE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.BANSHEE_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(GaiaSounds.NONE, 1.0F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3 + lootingModifier);

            for (int i = 0; i < drop; ++i) {
                entityDropItem(GaiaItems.MISC_SOUL_FIRE, 1);
            }

            // Nuggets/Fragments
            int dropNugget = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNugget; ++i) {
                entityDropItem(Items.GOLD_NUGGET, 1);
            }

            if (GaiaConfig.COMMON.additionalOre.get()) {
                int dropNuggetAlt = rand.nextInt(3) + 1;

                for (int i = 0; i < dropNuggetAlt; ++i) {
                    ItemShard.dropNugget(this, 5);
                }
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                switch (rand.nextInt(2)) {
                    case 0:
                        entityDropItem(GaiaItems.BOX_GOLD, 1);
                    case 1:
                        entityDropItem(GaiaItems.BAG_BOOK, 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.WEAPON_BOOK_NIGHTMARE, 1);
            }
        }
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
    }

    /* SPAWN CONDITIONS */
    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_2;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }

    class MoveRandomGoal extends Goal {
        public MoveRandomGoal() {
            this.setMutexFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean shouldExecute() {
            return !GaiaBansheeEntity.this.getMoveHelper().isUpdating() && GaiaBansheeEntity.this.rand.nextInt(7) == 0;
        }

        public boolean shouldContinueExecuting() {
            return false;
        }

        public void tick() {
            BlockPos lvt_1_1_ = GaiaBansheeEntity.this.getBoundOrigin();
            if (lvt_1_1_ == null) {
                lvt_1_1_ = new BlockPos(GaiaBansheeEntity.this);
            }

            for(int lvt_2_1_ = 0; lvt_2_1_ < 3; ++lvt_2_1_) {
                BlockPos lvt_3_1_ = lvt_1_1_.add(GaiaBansheeEntity.this.rand.nextInt(15) - 7, GaiaBansheeEntity.this.rand.nextInt(11) - 5, GaiaBansheeEntity.this.rand.nextInt(15) - 7);
                if (GaiaBansheeEntity.this.world.isAirBlock(lvt_3_1_)) {
                    GaiaBansheeEntity.this.moveController.setMoveTo((double)lvt_3_1_.getX() + 0.5D, (double)lvt_3_1_.getY() + 0.5D, (double)lvt_3_1_.getZ() + 0.5D, 0.25D);
                    if (GaiaBansheeEntity.this.getAttackTarget() == null) {
                        GaiaBansheeEntity.this.getLookController().setLookPosition((double)lvt_3_1_.getX() + 0.5D, (double)lvt_3_1_.getY() + 0.5D, (double)lvt_3_1_.getZ() + 0.5D, 180.0F, 20.0F);
                    }
                    break;
                }
            }

        }
    }

    class ChargeAttackGoal extends Goal {
        public ChargeAttackGoal() {
            this.setMutexFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean shouldExecute() {
            if (GaiaBansheeEntity.this.getAttackTarget() != null && !GaiaBansheeEntity.this.getMoveHelper().isUpdating() && GaiaBansheeEntity.this.rand.nextInt(7) == 0) {
                return GaiaBansheeEntity.this.getDistanceSq(GaiaBansheeEntity.this.getAttackTarget()) > 4.0D;
            } else {
                return false;
            }
        }

        public boolean shouldContinueExecuting() {
            return GaiaBansheeEntity.this.getMoveHelper().isUpdating() && GaiaBansheeEntity.this.isCharging() && GaiaBansheeEntity.this.getAttackTarget() != null && GaiaBansheeEntity.this.getAttackTarget().isAlive();
        }

        public void startExecuting() {
            LivingEntity lvt_1_1_ = GaiaBansheeEntity.this.getAttackTarget();
            Vec3d lvt_2_1_ = lvt_1_1_.getEyePosition(1.0F);
            GaiaBansheeEntity.this.moveController.setMoveTo(lvt_2_1_.x, lvt_2_1_.y, lvt_2_1_.z, 1.0D);
            GaiaBansheeEntity.this.setCharging(true);
            GaiaBansheeEntity.this.playSound(SoundEvents.ENTITY_VEX_CHARGE, 1.0F, 1.0F);
        }

        public void resetTask() {
            GaiaBansheeEntity.this.setCharging(false);
        }

        public void tick() {
            LivingEntity lvt_1_1_ = GaiaBansheeEntity.this.getAttackTarget();
            if (GaiaBansheeEntity.this.getBoundingBox().intersects(lvt_1_1_.getBoundingBox())) {
                GaiaBansheeEntity.this.attackEntityAsMob(lvt_1_1_);
                GaiaBansheeEntity.this.setCharging(false);
            } else {
                double lvt_2_1_ = GaiaBansheeEntity.this.getDistanceSq(lvt_1_1_);
                if (lvt_2_1_ < 9.0D) {
                    Vec3d lvt_4_1_ = lvt_1_1_.getEyePosition(1.0F);
                    GaiaBansheeEntity.this.moveController.setMoveTo(lvt_4_1_.x, lvt_4_1_.y, lvt_4_1_.z, 1.0D);
                }
            }

        }
    }

    class MoveHelperController extends MovementController {
        public MoveHelperController(GaiaBansheeEntity p_i47230_2_) {
            super(p_i47230_2_);
        }

        public void tick() {
            if (this.action == Action.MOVE_TO) {
                Vec3d lvt_1_1_ = new Vec3d(this.posX - GaiaBansheeEntity.this.posX, this.posY - GaiaBansheeEntity.this.posY, this.posZ - GaiaBansheeEntity.this.posZ);
                double lvt_2_1_ = lvt_1_1_.length();
                if (lvt_2_1_ < GaiaBansheeEntity.this.getBoundingBox().getAverageEdgeLength()) {
                    this.action = Action.WAIT;
                    GaiaBansheeEntity.this.setMotion(GaiaBansheeEntity.this.getMotion().scale(0.5D));
                } else {
                    GaiaBansheeEntity.this.setMotion(GaiaBansheeEntity.this.getMotion().add(lvt_1_1_.scale(this.speed * 0.05D / lvt_2_1_)));
                    if (GaiaBansheeEntity.this.getAttackTarget() == null) {
                        Vec3d lvt_4_1_ = GaiaBansheeEntity.this.getMotion();
                        GaiaBansheeEntity.this.rotationYaw = -((float) MathHelper.atan2(lvt_4_1_.x, lvt_4_1_.z)) * 57.295776F;
                        GaiaBansheeEntity.this.renderYawOffset = GaiaBansheeEntity.this.rotationYaw;
                    } else {
                        double lvt_4_2_ = GaiaBansheeEntity.this.getAttackTarget().posX - GaiaBansheeEntity.this.posX;
                        double lvt_6_1_ = GaiaBansheeEntity.this.getAttackTarget().posZ - GaiaBansheeEntity.this.posZ;
                        GaiaBansheeEntity.this.rotationYaw = -((float)MathHelper.atan2(lvt_4_2_, lvt_6_1_)) * 57.295776F;
                        GaiaBansheeEntity.this.renderYawOffset = GaiaBansheeEntity.this.rotationYaw;
                    }
                }

            }
        }
    }
}
