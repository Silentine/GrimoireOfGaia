package gaia.entity;

import gaia.GaiaConfig;
import gaia.renderer.particle.ParticleBuff;
import gaia.renderer.particle.ParticleDrop;
import gaia.renderer.particle.ParticleHeal;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * This is a direct copy of EntityMobHostileBase
 *
 * @see EntityMobHostileBase
 */
public abstract class EntityMobPassiveBase extends EntityMobPassive {

    public EntityMobPassiveBase(World worldIn) {
        super(worldIn);
    }

    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (GaiaConfig.BaseDamage) {
                if (entity instanceof EntityPlayer && GaiaConfig.ShieldsBlockPiercing) {
                    EntityPlayer player = (EntityPlayer) entity;
                    ItemStack itemstack = player.isHandActive()
                            ? player.getActiveItemStack()
                            : null;
                    if (itemstack != null && itemstack.getItem() == Items.SHIELD) {
                        return true;
                    }
                }

                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 2, 0));
            }
            return true;
        } else {
            return false;
        }
    }

    /*
     * public boolean attackEntityFrom(DamageSource source, float damage) { if
     * (damage > EntityAttributes.baseDefenseBase) { damage =
     * EntityAttributes.baseDefenseBase; } return super.attackEntityFrom(source,
     * damage); }
     */

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 8) {
            for (int i = 0; i < 8; ++i) {
                ParticleDrop particleCustom = new ParticleDrop(this.world,
                        this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                        this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
                        this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
            }
        } else if (id == 9) {
            for (int i = 0; i < 8; ++i) {
                ParticleHeal particleCustom = new ParticleHeal(this.world,
                        this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                        this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
                        this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
            }
        } else if (id == 10) {
            for (int i = 0; i < 8; ++i) {
                ParticleBuff particleCustom = new ParticleBuff(this.world,
                        this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                        this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
                        this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
            }
        } else if (id == 11) {
            for (int i = 0; i < 8; ++i) {
                this.world.spawnParticle(EnumParticleTypes.HEART,
                        this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                        this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
                        this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        } else {
            super.handleStatusUpdate(id);
        }
    }

    /**
     * Adapted from @TileEntityBeacon
     *
     * @param effect Potion Effect to Implement
     * @param duration Duration of potion effect in ticks (20 ticks = 1 second)
     * @param power Level of the potion
     * @param range Size of the Aura in meters (blocks)
     * @see TileEntityBeacon
     */
    public void beaconDebuff(Potion effect, int duration, int power, int range) {
        if (!this.world.isRemote) {
            double d0 = (double) (range);

            int k = (int) this.posX;
            int l = (int) this.posY;
            int i1 = (int) this.posZ;

            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) k, (double) l, (double) i1, (double) (k + 1), (double) (l + 1), (double) (i1 +
                    1))).grow(d0)
                            .expand(0.0D, 0.0D, 0.0D);
            List<EntityLivingBase> moblist = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

            for (EntityLivingBase mob : moblist) {
                if (!(mob instanceof EntityMob)) {
                    if (mob instanceof IMob || mob instanceof EntityPlayer) {
                        mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
                    }
                }
            }
        }
    }

    /**
     * Adapted from @EntityPotion
     *
     * @param SoureMob The mob creating the cloud
     * @param effect Potion Effect to Implement (@MobEffects.class)
     * @param type Type of potion (I think for rendering) (@PotionTypes.class)
     * @param duration Duration of potion effect in ticks (20 ticks = 1 second)
     * @param power Level of the potion
     * @param pos Position to spawn effect
     * @see EntityPotion
     */
    public void lingeringEffect(EntityLivingBase SoureMob, Potion effect, PotionType type, int duration, int power, BlockPos pos) {
        EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(SoureMob.world, pos.getX(), pos.getY(), pos.getZ());
        entityareaeffectcloud.setOwner(SoureMob);
        entityareaeffectcloud.setRadius(3.0F);
        entityareaeffectcloud.setRadiusOnUse(-0.5F);
        entityareaeffectcloud.setWaitTime(10);
        entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float) entityareaeffectcloud.getDuration());
        entityareaeffectcloud.setPotion(type);

        entityareaeffectcloud.addEffect(new PotionEffect(effect, duration, power));

        SoureMob.world.spawnEntity(entityareaeffectcloud);
    }

    /**
     * Used to adjust the motionY when a mob is hit.
     */
    public void knockBack(Entity entity, float par2, double par3, double par5, double par6) {
        if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE)
                .getAttributeValue()) {
            this.isAirBorne = true;
            float f1 = MathHelper.sqrt(par3 * par3 + par5 * par5);
            float f2 = 0.4F;
            this.motionX /= 2.0D;
            this.motionY /= 2.0D;
            this.motionZ /= 2.0D;
            this.motionX -= par3 / (double) f1 * (double) f2;
            this.motionY += (double) f2;
            this.motionZ -= par5 / (double) f1 * (double) f2;
            if (this.motionY > par6) {
                this.motionY = par6;
            }
        }
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1iEntityLivingData) {
        return null;
    }
}
