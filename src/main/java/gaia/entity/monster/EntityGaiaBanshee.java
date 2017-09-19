package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class EntityGaiaBanshee extends EntityMobHostileBase {

    public EntityGaiaBanshee(World worldIn) {
        super(worldIn);

        experienceValue = EntityAttributes.experienceValue2;
        stepHeight = 1.0F;
        isImmuneToFire = true;
    }

    @Override
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true));
        tasks.addTask(2, new EntityAIWander(this, 1.0D));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(3, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
                .setBaseValue((double) EntityAttributes.maxHealth2);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE)
                .setBaseValue(EntityAttributes.followrange);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                .setBaseValue(EntityAttributes.moveSpeed2);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
                .setBaseValue((double) EntityAttributes.attackDamage2);
        getEntityAttribute(SharedMonsterAttributes.ARMOR)
                .setBaseValue(EntityAttributes.rateArmor2);
    }

    @Override
    public boolean attackEntityFrom(@Nonnull DamageSource source, float damage) {
        if (damage > EntityAttributes.baseDefense2) {
            damage = EntityAttributes.baseDefense2;
        }

        return super.attackEntityFrom(source, damage);
    }

    @Override
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
        super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            entityIn.setFire(6);
        }
        return true;
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    public void onLivingUpdate() {
        if (!onGround && motionY < 0.0D) {
            motionY *= 0.8D;
        }

        if (world.isDaytime() && !world.isRemote) {
            float f = getBrightness();

            if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canSeeSky(getPosition())) {
                world.setEntityState(this, (byte) 13);
                attackEntityFrom(DamageSource.OUT_OF_WORLD, EntityAttributes.maxHealth2 * 0.25F);
            }
        }

        for (int var2 = 0; var2 < 2; ++var2) {
            world.spawnParticle(EnumParticleTypes.PORTAL,
                    posX + (rand.nextDouble() - 0.5D) * (double) width,
                    posY + rand.nextDouble() * (double) height,
                    posZ + (rand.nextDouble() - 0.5D) * (double) width, 0.0D, 0.0D, 0.0D);
        }

        super.onLivingUpdate();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 13) {
            spawnParticles(EnumParticleTypes.SMOKE_NORMAL);
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @SideOnly(Side.CLIENT)
    private void spawnParticles(EnumParticleTypes particleType) {
        for (int i = 0; i < 5; ++i) {
            double d0 = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;

            world.spawnParticle(particleType,
                    posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width,
                    posY + 1.0D + (double) (rand.nextFloat() * height),
                    posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, d0, d1, d2);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Sounds.aggressive_say;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return Sounds.aggressive_hurt;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Sounds.aggressive_death;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        playSound(Sounds.none, 1.0F, 1.0F);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            int var3 = rand.nextInt(3 + lootingModifier);

            for (int var4 = 0; var4 < var3; ++var4) {
                dropItem(GaiaItems.MiscSoulFire, 1);
            }

            // Nuggets/Fragments
            int var11 = rand.nextInt(3) + 1;

            for (int var12 = 0; var12 < var11; ++var12) {
                ItemShard.Drop_Nugget(this, 1);
            }

            if (GaiaConfig.AdditionalOre) {
                int var13 = rand.nextInt(3) + 1;

                for (int var14 = 0; var14 < var13; ++var14) {
                    ItemShard.Drop_Nugget(this, 5);
                }
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.rateraredrop) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                switch (rand.nextInt(3)) {
                    case 0:
                        dropItem(GaiaItems.BoxGold, 1);
                        break;
                    case 1:
                        dropItem(GaiaItems.BagBook, 1);
                        break;
                    case 2:
                        dropItem(GaiaItems.BookNightmare, 1);
                }
            }
        }
    }

    @Override
    public @Nonnull EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    // ================= Immunities =================//
    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public void setInWeb() {
    }
    // ==============================================//

    @Override
    public boolean getCanSpawnHere() {
        return posY > 60.0D && super.getCanSpawnHere();
    }
}
