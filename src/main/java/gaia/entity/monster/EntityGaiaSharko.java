package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaSharko extends EntityMobHostileBase {

    private int buffEffect;

    public EntityGaiaSharko(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 2.0F);
        this.experienceValue = EntityAttributes.experienceValue2;
        this.stepHeight = 1.0F;
        this.buffEffect = 0;

        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
                .setBaseValue((double) EntityAttributes.maxHealth2);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE)
                .setBaseValue(EntityAttributes.followrange);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                .setBaseValue(EntityAttributes.moveSpeed2);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
                .setBaseValue((double) EntityAttributes.attackDamage2);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR)
                .setBaseValue(EntityAttributes.rateArmor2);
    }

    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (damage > EntityAttributes.baseDefense2) {
            damage = EntityAttributes.baseDefense2;
        }

        return super.attackEntityFrom(source, damage);
    }

    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
        super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 10;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 20;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 2));
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
        if (this.isInWater()) {
            this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 0));
        }

        if (this.isWet()) {
            this.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10 * 20, 0));
        }

        if (this.getHealth() > EntityAttributes.maxHealth2 * 0.25F && this.buffEffect == 1) {
            this.buffEffect = 0;
        } else if (this.getHealth() <= EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.buffEffect == 0) {
            this.world.setEntityState(this, (byte) 10);

            this.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20 * 60, 0));

            this.buffEffect = 1;
        }

        super.onLivingUpdate();
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            int var3 = this.rand.nextInt(3 + lootingModifier);

            for (int var4 = 0; var4 < var3; ++var4) {
                this.dropItem(GaiaItems.FoodCoalfish, 1);
            }

            if ((this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                this.dropItem(Items.PRISMARINE_SHARD, 1);
            }

            // Nuggets/Fragments
            int var11 = this.rand.nextInt(3) + 1;

            for (int var12 = 0; var12 < var11; ++var12) {
                ItemShard.Drop_Nugget(this, 1);
            }

            if (GaiaConfig.AdditionalOre) {
                int var13 = this.rand.nextInt(3) + 1;

                for (int var14 = 0; var14 < var13; ++var14) {
                    ItemShard.Drop_Nugget(this, 5);
                }
            }

            // Rare
            if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                switch (this.rand.nextInt(3)) {
                    case 0:
                        this.entityDropItem(new ItemStack(GaiaItems.Box, 1, 0), 0.0F);
                        break;
                    case 1:
                        this.dropItem(GaiaItems.BagBook, 1);
                        break;
                    case 2:
                        this.dropItem(GaiaItems.BookBuff, 1);
                }
            }
        }
    }

    @Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        ItemStack BOOTS_SWIMMING = new ItemStack(Items.LEATHER_BOOTS);
        this.setItemStackToSlot(EntityEquipmentSlot.FEET, BOOTS_SWIMMING);
        BOOTS_SWIMMING.addEnchantment(Enchantment.getEnchantmentByLocation("depth_strider"), 3);

        return livingdata;
    }

    public float SharkoScaleAmount() {
        return 1.25F;
    }

    // ================= Immunities =================//
    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean isPushedByWater() {
        return false;
    }
    // ==============================================//

    public boolean getCanSpawnHere() {
        return this.posY < 32.0D && super.getCanSpawnHere();
    }
}
