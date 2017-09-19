package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaWitherCow extends EntityMobHostileBase {

    public EntityGaiaWitherCow(World worldIn) {
        super(worldIn);

        this.experienceValue = EntityAttributes.experienceValue1;
        this.stepHeight = 1.0F;
        this.isImmuneToFire = true;
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed0, true));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
                .setBaseValue((double) EntityAttributes.maxHealth1);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE)
                .setBaseValue(EntityAttributes.followrange);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                .setBaseValue(EntityAttributes.moveSpeed0);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
                .setBaseValue((double) EntityAttributes.attackDamage1);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR)
                .setBaseValue(EntityAttributes.rateArmor1);

        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE)
                .setBaseValue(1.00D);
    }

    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (damage > EntityAttributes.baseDefense1) {
            damage = EntityAttributes.baseDefense1;
        }

        return super.attackEntityFrom(source, damage);
    }

    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
        super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback1);
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 5;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 10;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, byte0 * 20, 0));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean isAIDisabled() {
        return false;
    }

    public void onLivingUpdate() {
        this.beaconDebuff(MobEffects.SLOWNESS, 5 * 10, 0, 2);

        for (int i = 0; i < 2; ++i) {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL,
                    this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
                    this.posY + this.rand.nextDouble() * (double) this.height,
                    this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
        }
        super.onLivingUpdate();
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    public void onDeath(DamageSource cause) {
        this.lingeringEffect(this, MobEffects.WITHER, PotionTypes.EMPTY, 200, 0, this.getPosition());
        super.onDeath(cause);
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            if ((this.rand.nextInt(8) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                this.dropItem(GaiaItems.FoodWither, 1);
            }

            if ((this.rand.nextInt(8) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                if ((this.rand.nextInt(2) == 0)) {
                    this.dropItem(Items.QUARTZ, 1);
                } else {
                    this.dropItem(Items.GLOWSTONE_DUST, 1);
                }
            }

            // Nuggets/Fragments
            int var11 = this.rand.nextInt(3) + 1;

            for (int var12 = 0; var12 < var11; ++var12) {
                ItemShard.Drop_Nugget(this, 0);
            }

            if (GaiaConfig.AdditionalOre) {
                int var13 = this.rand.nextInt(3) + 1;

                for (int var14 = 0; var14 < var13; ++var14) {
                    ItemShard.Drop_Nugget(this, 4);
                }
            }

            // Rare
            if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                switch (this.rand.nextInt(1)) {
                    case 0:
                        this.entityDropItem(new ItemStack(GaiaItems.Box, 1, 1), 0.0F);
                }
            }
        }
    }

    // ================= Immunities =================//
    public boolean isPotionApplicable(PotionEffect potioneffectIn) {
        return potioneffectIn.getPotion() == MobEffects.WITHER
                ? false
                : super.isPotionApplicable(potioneffectIn);
    }
    // ==============================================//
}
