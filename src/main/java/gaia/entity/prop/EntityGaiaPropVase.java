package gaia.entity.prop;

import gaia.entity.EntityMobProp;
import gaia.entity.GaiaLootTableList;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumLightType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class EntityGaiaPropVase extends EntityMobProp {

    private static final String MOB_TYPE_TAG = "MobType";
    private static final String ROTATION_TAG = "Rotation";
    private static final String DROP_TAG = "Drop";

    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaPropVase.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> ROTATION = EntityDataManager.createKey(EntityGaiaPropVase.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DROP = EntityDataManager.createKey(EntityGaiaPropVase.class, DataSerializers.VARINT);

    private BlockPos blockPosition;

    public EntityGaiaPropVase(World worldIn) {
        super(GaiaEntities.VASE, worldIn);
        setSize(0.8F, 0.8F);
        experienceValue = 0;
        prevRenderYawOffset = 180.0F;
        renderYawOffset = 180.0F;
        isImmuneToFire = true;
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata, @Nullable NBTTagCompound itemNbt) {
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

        if (!this.world.isRemote) {
            int i = MathHelper.floor(this.posX);
            int j = MathHelper.floor(this.posY);
            int k = MathHelper.floor(this.posZ);

            if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) >= 2.0F) {
                setTextureType(1);
            }
        }

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

        return super.onInitialSpawn(difficulty, livingdata, itemNbt);
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
        this.getDataManager().register(SKIN, 0);
        this.getDataManager().register(ROTATION, 0);
        this.getDataManager().register(DROP, 0);
    }

    public int getTextureType() {
        return dataManager.get(SKIN);
    }

    private void setTextureType(int par1) {
        dataManager.set(SKIN, par1);
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
    public void writeAdditional(NBTTagCompound compound) {
        super.writeAdditional(compound);
        compound.setByte(MOB_TYPE_TAG, (byte) getTextureType());
        compound.setByte(ROTATION_TAG, (byte) getRotation());
        compound.setByte(DROP_TAG, (byte) getDrop());
    }

    @Override
    public void readAdditional(NBTTagCompound compound) {
        super.readAdditional(compound);
        if (compound.hasKey(MOB_TYPE_TAG)) {
            byte b0 = compound.getByte(MOB_TYPE_TAG);
            setTextureType(b0);
        }

        if (compound.hasKey(ROTATION_TAG)) {
            byte b1 = compound.getByte(ROTATION_TAG);
            setRotation(b1);
        }

        if (compound.hasKey(DROP_TAG)) {
            byte b2 = compound.getByte(DROP_TAG);
            setDrop(b2);
        }
    }

    protected void playParticleEffect(boolean play) {
        IParticleData enumparticletypes = Particles.HEART;

        if (!play) {
            enumparticletypes = Particles.EXPLOSION;
        }

        for (int i = 0; i < 7; ++i) {
            double d0 = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;
            world.spawnParticle(enumparticletypes, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, d0, d1, d2);
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

    @Nullable
    protected ResourceLocation getLootTable() {
        return GaiaLootTableList.ENTITIES_GAIA_VASE;
    }

    @Override
    protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
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
                            entityDropItem(GaiaItems.PICKUP_HEART, 1);
                        }
                        break;
                }
            }
        }
    }

    private void spawnExp(int k) {
        int i = 3 + world.rand.nextInt(k) + world.rand.nextInt(k);

        while (i > 0) {
            int j = EntityXPOrb.getXPSplit(i);
            i -= j;
            world.spawnEntity(new EntityXPOrb(world, posX, posY, posZ, j));
        }
    }

    @Override
    protected void onDeathUpdate() {
        remove();
    }

    /* IMMUNITIES */
    @Override
    public boolean isPotionApplicable(PotionEffect potioneffectIn) {
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

    /**
     * @see EntityMob
     */
    protected boolean isValidLightLevel() {
        BlockPos blockpos = new BlockPos(this.posX, this.getBoundingBox().minY, this.posZ);
        if (this.world.getLightFor(EnumLightType.SKY, blockpos) > this.rand.nextInt(32)) {
            return false;
        } else {
            int i = this.world.isThundering() ? this.world.getNeighborAwareLightSubtracted(blockpos, 10) : this.world.getLight(blockpos);
            return i <= this.rand.nextInt(8);
        }
    }

    /* SPAWN CONDITIONS */
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, boolean value) {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.posY);
        int k = MathHelper.floor(this.posZ);

        if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
            return super.canSpawn(worldIn, value);
        } else {
            return posY < 32.0D && world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.canSpawn(worldIn, value);
        }
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