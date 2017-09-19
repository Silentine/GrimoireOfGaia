package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaGryphon extends EntityMobPassiveDay {

    public EntityGaiaGryphon(World worldIn) {
        super(worldIn);

        this.setSize(1.2F, 1.8F);
        this.experienceValue = EntityAttributes.experienceValue1;
        this.stepHeight = 1.0F;
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(2, new EntityGaiaGryphon.AILeapAttack(this));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
                .setBaseValue((double) EntityAttributes.maxHealth1);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE)
                .setBaseValue(EntityAttributes.followrange);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                .setBaseValue(EntityAttributes.moveSpeed1);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
                .setBaseValue((double) EntityAttributes.attackDamage1);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR)
                .setBaseValue(EntityAttributes.rateArmor1);
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

    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (entity instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 5;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 10;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte0 * 20, 0));
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
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.8D;
        }

        super.onLivingUpdate();
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                this.dropItem(Items.FEATHER, 1);
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
                        this.dropItem(GaiaItems.BoxIron, 1);
                }
            }
        }
    }

    public float GryphonScaleAmount() {
        return 1.25F;
    }

    static class AILeapAttack extends EntityAIAttackMelee {

        public AILeapAttack(EntityGaiaGryphon entity) {
            super(entity, EntityAttributes.attackSpeed1, true);
        }

        protected double getAttackReachSqr(EntityLivingBase attackTarget) {
            return (double) (4.0F + attackTarget.width);
        }
    }

    // ================= Immunities =================//
    public void fall(float distance, float damageMultiplier) {
    }
    // ==============================================//

    public boolean getCanSpawnHere() {
        return this.posY > 80.0D && super.getCanSpawnHere();
    }
}
