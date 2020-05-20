package gaia.entity.prop;

import gaia.entity.AbstractMobPropEntity;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class GaiaPropVaseNetherEntity extends AbstractMobPropEntity {

    private static final String ROTATION_TAG = "Rotation";
    private static final String DROP_TAG = "Drop";

    private static final DataParameter<Integer> ROTATION = EntityDataManager.createKey(GaiaPropVaseNetherEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DROP = EntityDataManager.createKey(GaiaPropVaseNetherEntity.class, DataSerializers.VARINT);

    private BlockPos blockPosition;

    public GaiaPropVaseNetherEntity(EntityType<? extends GaiaPropVaseNetherEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue = 0;
        prevRenderYawOffset = 180.0F;
        renderYawOffset = 180.0F;
    }

    public GaiaPropVaseNetherEntity(World worldIn) {
        this(GaiaEntities.VASE_NETHER.get(), worldIn);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT itemNbt) {
        renderYawOffset = 180.0F;
        prevRenderYawOffset = 180.0F;
        rotationYaw = 180.0F;
        prevRotationYaw = 180.0F;
        rotationYawHead = 180.0F;
        prevRotationYawHead = 180.0F;

//		BlockPos blockpos = new BlockPos(this);
//
//		if (getBlockPathWeight(blockpos) == 10F) {
//			setTextureType(1);
//		}

        switch (rand.nextInt(5)) {
            case 0:
                setRotation(0);
                break;
            case 1:
                setRotation(1);
                break;
            case 2:
                setRotation(2);
                break;
            case 3:
                setRotation(3);
                break;
            case 4:
                setRotation(4);
                break;
        }

        switch (rand.nextInt(3)) {
            case 0:
                setDrop(0);
                break;
            case 1:
                setDrop(1);
                break;
            case 2:
                setDrop(2);
                break;
        }

        return super.onInitialSpawn(worldIn, difficulty, reason, livingdata, itemNbt);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

//	public float getBlockPathWeight(BlockPos pos) {
//		return this.world.getBlockState(pos.down()).getBlock() == Blocks.STONE ? 10.0F : super.getBlockPathWeight(pos);
//	}

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(ROTATION, 0);
        this.getDataManager().register(DROP, 0);
    }

    public int getRotation() {
        return dataManager.get(ROTATION);
    }

    private void setRotation(int par1) {
        dataManager.set(ROTATION, par1);
    }

    public int getDrop() {
        return dataManager.get(DROP);
    }

    private void setDrop(int par1) {
        dataManager.set(DROP, par1);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte(ROTATION_TAG, (byte) getRotation());
        compound.putByte(DROP_TAG, (byte) getDrop());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        if (compound.contains(ROTATION_TAG)) {
            byte b1 = compound.getByte(ROTATION_TAG);
            setRotation(b1);
        }

        if (compound.contains(DROP_TAG)) {
            byte b2 = compound.getByte(DROP_TAG);
            setDrop(b2);
        }
    }

    protected void playParticleEffect(boolean play) {
        IParticleData enumparticletypes = ParticleTypes.HEART;

        if (!play) {
            enumparticletypes = ParticleTypes.EXPLOSION;
        }

        for (int i = 0; i < 7; ++i) {
            double d0 = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;
            world.addParticle(enumparticletypes, getPosX() + (double) (rand.nextFloat() * getWidth() * 2.0F) - (double) getWidth(), getPosY() + 0.5D + (double) (rand.nextFloat() * getHeight()), getPosZ() + (double) (rand.nextFloat() * getWidth() * 2.0F) - (double) getWidth(), d0, d1, d2);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 7) {
            playParticleEffect(true);
        } else if (id == 6) {
            playParticleEffect(false);
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GLASS_BREAK;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int dropArrow = 1 + rand.nextInt(3 + lootingModifier);
            int dropHeart = 1 + rand.nextInt(5);

            if (!world.isRemote) {
                switch (getDrop()) {
                    case 0:
                        world.setEntityState(this, (byte) 6);
                        for (int i = 0; i < dropArrow; ++i) {
                            entityDropItem(Items.ARROW, 1);
                        }
                        break;
                    case 1:
                        world.setEntityState(this, (byte) 6);
                        spawnExp(1 + rand.nextInt(5));
                        break;
                    case 2:
                        world.setEntityState(this, (byte) 7);
                        for (int i = 0; i < dropHeart; ++i) {
                            entityDropItem(GaiaItems.PICKUP_HEART.get(), 1);
                        }
                        break;
                }
            }
        }
    }

    private void spawnExp(int k) {
        int i = 3 + world.rand.nextInt(k) + world.rand.nextInt(k);

        while (i > 0) {
            int j = ExperienceOrbEntity.getXPSplit(i);
            i -= j;
            world.addEntity(new ExperienceOrbEntity(world, getPosX(), getPosY(), getPosZ(), j));
        }
    }

    @Override
    protected void onDeathUpdate() {
        remove();
    }

    /* IMMUNITIES */
    @Override
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        return false;
    }
    /* IMMUNITIES */

    @Override
    protected void collideWithEntity(Entity entityIn) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    /* SPAWN CONDITIONS */

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    /* SPAWN CONDITIONS */

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox() {
        return isAlive() ? getBoundingBox() : null;
    }

    @Override
    public int getVerticalFaceSpeed() {
        return 180;
    }

    @Override
    public int getHorizontalFaceSpeed() {
        return 180;
    }

    @Override
    public void applyEntityCollision(Entity entityIn) {
    }

    @Override
    public float getCollisionBorderSize() {
        return 0.0F;
    }
}