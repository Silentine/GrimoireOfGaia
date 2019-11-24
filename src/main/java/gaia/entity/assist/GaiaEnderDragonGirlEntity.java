package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IEnderMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class GaiaEnderDragonGirlEntity extends AbstractMobAssistEntity implements IEnderMob {
    private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final AttributeModifier ATTACKING_SPEED_BOOST = (new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", EntityAttributes.ATTACK_SPEED_BOOST, Operation.ADDITION)).setSaved(false);
    private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(GaiaEnderDragonGirlEntity.class, DataSerializers.BOOLEAN);

    private int targetChangeTime;

    public GaiaEnderDragonGirlEntity(EntityType<? extends GaiaEnderDragonGirlEntity> entityType, World world) {
        super(entityType, world);

        stepHeight = 1.0F;
        setPathPriority(PathNodeType.WATER, -1.0F);
    }

    public GaiaEnderDragonGirlEntity(World world) {
        this(GaiaEntities.ENDER_DRAGON_GIRL, world);
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    private void setCombatTask() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
    }

    @Override
    public void giveSpecificTasks() {
        super.giveSpecificTasks();
        this.targetSelector.addGoal(2, new GaiaEnderDragonGirlEntity.FindPlayerGoal(this));
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!(source instanceof IndirectEntityDamageSource) && source != DamageSource.FIREWORKS) {
            boolean flag = super.attackEntityFrom(source, damage);
            if (source.isUnblockable() && this.rand.nextInt(10) != 0) {
                this.teleportRandomly();
            }

            return flag;
        } else {
            float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);

            for(int i = 0; i < 64; ++i) {
                if (this.teleportRandomly()) {
                    return true;
                }
            }

            return super.attackEntityFrom(source, attackDamage);
        }
    }

    /**
     * Teleport the enderman to a random nearby position
     */
    protected boolean teleportRandomly() {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
        double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
        return this.teleportTo(d0, d1, d2);
    }

    /**
     * Teleport the enderman to another entity
     */
    private boolean teleportToEntity(Entity p_70816_1_) {
        Vec3d vec3d = new Vec3d(this.posX - p_70816_1_.posX, this.getBoundingBox().minY + (double)(this.getHeight() / 2.0F) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
        vec3d = vec3d.normalize();
        double d0 = 16.0D;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
        double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3d.y * 16.0D;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
        return this.teleportTo(d1, d2, d3);
    }

    /**
     * Teleport the enderman
     */
    private boolean teleportTo(double x, double y, double z) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while(blockpos$mutableblockpos.getY() > 0 && !this.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        if (!this.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
            return false;
        } else {
            net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
            if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
            boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag) {
                this.world.playSound((PlayerEntity)null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
                this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return flag;
        }
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public void livingTick() {
        if (world.isRemote) {
            for (int i = 0; i < 2; ++i) {
                world.addParticle(ParticleTypes.PORTAL, posX + (rand.nextDouble() - 0.5D) * getWidth(), posY + rand.nextDouble() * getHeight() - 0.25D, posZ + (rand.nextDouble() - 0.5D) * getWidth(), (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
            }
        }

        isJumping = false;
        super.livingTick();
    }

    @Override
    protected void updateAITasks() {
        if (this.isInWaterRainOrBubbleColumn()) {
            this.attackEntityFrom(DamageSource.DROWN, 1.0F);
        }

        if (this.world.isDaytime() && this.ticksExisted >= this.targetChangeTime + 600) {
            float f = this.getBrightness();
            if (f > 0.5F && this.world.isSkyLightMax(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
                this.setAttackTarget((LivingEntity)null);
                this.teleportRandomly();
            }
        }

        super.updateAITasks();
    }

    @Override
    public void setAttackTarget(@Nullable LivingEntity livingEntity) {
        super.setAttackTarget(livingEntity);
        IAttributeInstance iattributeinstance = getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

        if (livingEntity == null) {
            targetChangeTime = 0;
            this.dataManager.set(SCREAMING, Boolean.valueOf(false));
            iattributeinstance.removeModifier(ATTACKING_SPEED_BOOST);
        } else {
            targetChangeTime = ticksExisted;
            this.dataManager.set(SCREAMING, Boolean.valueOf(true));

            if (!iattributeinstance.hasModifier(ATTACKING_SPEED_BOOST)) {
                iattributeinstance.applyModifier(ATTACKING_SPEED_BOOST);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return isScreaming() ? SoundEvents.ENTITY_ENDERMAN_SCREAM : SoundEvents.ENTITY_ENDERMAN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_ENDERMAN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMAN_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3 + lootingModifier);

            for (int i = 0; i < drop; ++i) {
                entityDropItem(Items.ENDER_PEARL, 1);
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
                        entityDropItem(new ItemStack(GaiaItems.BOX_END, 1), 0.0F);
                    case 1:
                        entityDropItem(GaiaItems.BAG_BOOK, 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.WEAPON_BOOK_ENDER, 1);
            }

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.SPAWN_ENDER_GIRL, 1);
            }

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(Items.ELYTRA, 1);
            }
        }
    }

    @Override
    public void fall(float p_180430_1_, float p_180430_2_) {
    }

    @Override
    public void setMotionMultiplier(BlockState blockState, Vec3d motion) {
        if (blockState.getBlock() != Blocks.COBWEB) {
            super.setMotionMultiplier(blockState, motion);
        }
    }

    @Override
    public float getEyeHeight(Pose pose) {
        return 1.9F;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(SCREAMING, Boolean.valueOf(false));
    }

    public boolean isScreaming() {
        return (getDataManager().get(SCREAMING));
    }

    public void setScreaming(boolean screaming) {
        getDataManager().set(SCREAMING, screaming);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_2;
    }

    private boolean shouldAttackPlayer(PlayerEntity player) {
        ItemStack itemstack = player.inventory.armorInventory.get(3);
        if (itemstack.getItem() == Blocks.CARVED_PUMPKIN.asItem()) {
            return false;
        } else {
            Vec3d vec3d = player.getLook(1.0F).normalize();
            Vec3d vec3d1 = new Vec3d(this.posX - player.posX, this.getBoundingBox().minY + (double)this.getEyeHeight() - (player.posY + (double)player.getEyeHeight()), this.posZ - player.posZ);
            double d0 = vec3d1.length();
            vec3d1 = vec3d1.normalize();
            double d1 = vec3d.dotProduct(vec3d1);
            return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
        }
    }

    //Goals
    static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        private final GaiaEnderDragonGirlEntity dragonGirl;
        private PlayerEntity player;
        private int aggroTime;
        private int teleportTime;
        private final EntityPredicate field_220791_m;
        private final EntityPredicate field_220792_n = (new EntityPredicate()).setLineOfSiteRequired();

        public FindPlayerGoal(GaiaEnderDragonGirlEntity entity) {
            super(entity, PlayerEntity.class, false);
            this.dragonGirl = entity;
            this.field_220791_m = (new EntityPredicate()).setDistance(this.getTargetDistance()).setCustomPredicate((p_220790_1_) -> {
                return entity.shouldAttackPlayer((PlayerEntity)p_220790_1_);
            });
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            this.player = this.dragonGirl.world.getClosestPlayer(this.field_220791_m, this.dragonGirl);
            return this.player != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.aggroTime = 5;
            this.teleportTime = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.player = null;
            super.resetTask();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            if (this.player != null) {
                if (!this.dragonGirl.shouldAttackPlayer(this.player)) {
                    return false;
                } else {
                    this.dragonGirl.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.nearestTarget != null && this.field_220792_n.canTarget(this.dragonGirl, this.nearestTarget) ? true : super.shouldContinueExecuting();
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.player != null) {
                if (--this.aggroTime <= 0) {
                    this.nearestTarget = this.player;
                    this.player = null;
                    super.startExecuting();
                }
            } else {
                if (this.nearestTarget != null && !this.dragonGirl.isPassenger()) {
                    if (this.dragonGirl.shouldAttackPlayer((PlayerEntity)this.nearestTarget)) {
                        if (this.nearestTarget.getDistanceSq(this.dragonGirl) < 16.0D) {
                            this.dragonGirl.teleportRandomly();
                        }

                        this.teleportTime = 0;
                    } else if (this.nearestTarget.getDistanceSq(this.dragonGirl) > 256.0D && this.teleportTime++ >= 30 && this.dragonGirl.teleportToEntity(this.nearestTarget)) {
                        this.teleportTime = 0;
                    }
                }

                super.tick();
            }

        }
    }
}
