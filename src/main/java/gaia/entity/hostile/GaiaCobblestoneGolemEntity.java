package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GaiaCobblestoneGolemEntity extends AbstractMobHostileEntity {

    private int attackTimer;

    public GaiaCobblestoneGolemEntity(EntityType<? extends GaiaCobblestoneGolemEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;
        setPathPriority(PathNodeType.WATER, -1.0F);
    }

    public GaiaCobblestoneGolemEntity(World world) {
        this(GaiaEntities.COBBLESTONE_GOLEM.get(), world);
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    public void setAttackTask() {
        goalSelector.addGoal(0, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_0, true));
    }

    @Override
    public double wanderSpeed() {
        return 0.5D;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
        getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_0);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float input = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);
        Entity entity = source.getTrueSource();

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack itemstack = player.getHeldItem(getActiveHand());
            if (itemstack.getItem() instanceof PickaxeItem) {
                input = input + 5;
            }
        }

        return super.attackEntityFrom(source, input);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        attackTimer = 10;
        world.setEntityState(this, (byte) 4);
        boolean attackEntity = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) 7 + rand.nextInt(15));
        if (attackEntity) {
            Vec3d motion = getMotion();
            double motionY = motion.getY();
            motionY += 0.6000000059604645D;
            setMotion(motion.x, motionY, motion.z);
        }

        playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return attackEntity;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            attackTimer = 10;
            playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public int getAttackTimer() {
        return attackTimer;
    }

    @Override
    public void livingTick() {
        super.livingTick();

        if (attackTimer > 0) {
            --attackTimer;
        }

        Vec3d motion = getMotion();
        if (motion.x * motion.x + motion.z * motion.z > 2.500000277905201E-7D && rand.nextInt(5) == 0) {
            int i = MathHelper.floor(getPosX());
            int j = MathHelper.floor(getPosY() - 0.20000000298023224D);
            int k = MathHelper.floor(getPosZ());
            BlockState BlockState = world.getBlockState(new BlockPos(i, j, k));

            if (BlockState.getMaterial() != Material.AIR) {
                world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, BlockState), getPosX() + (rand.nextDouble() - 0.5D) * getWidth(), getBoundingBox().minY + 0.1D, getPosZ() + (rand.nextDouble() - 0.5D) * getWidth(), 4.0D * (rand.nextDouble() - 0.5D), 0.5D, (rand.nextDouble() - 0.5D) * 4.0D);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.NONE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BLOCK_STONE_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3 + lootingModifier);

            for (int i = 0; i < drop; ++i) {
                entityDropItem(Items.IRON_NUGGET, 1);
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
                        entityDropItem(GaiaItems.BOX_GOLD.get(), 1);
                    case 1:
                        entityDropItem(GaiaItems.BAG_BOOK.get(), 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(new ItemStack(GaiaItems.CHEST_JUNGLE.get()), 1);
            }

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(new ItemStack(GaiaItems.SHARD_MISC.get()), 1);
            }
        }
    }

    @Override
    public boolean isPotionApplicable(EffectInstance instance) {
        return instance.getPotion() == Effects.POISON || instance.getPotion() == Effects.INSTANT_DAMAGE ? false : super.isPotionApplicable(instance);
    }

    @Override
    protected float applyPotionDamageCalculations(DamageSource source, float damage) {
        damage = super.applyPotionDamageCalculations(source, damage);

        if (source.getTrueSource() == this) {
            damage = 0.0F;
        }

        if (source.isMagicDamage()) {
            damage = (float) ((double) damage * 0.15D);
        }

        return damage;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_2;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }
}
