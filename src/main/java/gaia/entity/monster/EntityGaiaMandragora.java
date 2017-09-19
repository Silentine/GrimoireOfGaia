package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaMandragora extends EntityMobHostileDay {

    private int shovelAttack;

    public EntityGaiaMandragora(World worldIn) {
        super(worldIn);

        this.setSize(0.5F, 1.0F);
        this.experienceValue = EntityAttributes.experienceValue1;
        this.stepHeight = 1.0F;

        this.shovelAttack = 0;
    }

    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed0, true));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(2, new EntityAILookIdle(this));
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

        float input = damage;
        Entity entity = source.getTrueSource();

        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack itemstack = player.getHeldItem(getActiveHand());
            if (itemstack != null) {

                if (itemstack.getItem() instanceof ItemSpade) {
                    damage = input * 1.5F;
                    this.shovelAttack += 1;
                }
            }
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
                byte byte1 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 20;
                    byte1 = 10;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 30;
                    byte1 = 20;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 3));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, byte0 * 20, 0));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, byte1 * 20, 0));
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
            this.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 10 * 20, 0));
        }

        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor(this.posX);
            int j = MathHelper.floor(this.posY - 0.20000000298023224D);
            int k = MathHelper.floor(this.posZ);
            IBlockState iblockstate = this.world.getBlockState(new BlockPos(i, j, k));

            if (iblockstate.getMaterial() != Material.AIR) {
                this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK,
                        this.posX + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width,
                        this.getEntityBoundingBox().minY + 0.1D,
                        this.posZ + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width,
                        4.0D * ((double) this.rand.nextFloat() - 0.5D), 0.5D,
                        ((double) this.rand.nextFloat() - 0.5D) * 4.0D, new int[] {Block.getStateId(iblockstate)});
            }
        }

        if (this.isBurning()) {
            this.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
            this.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
        }

        super.onLivingUpdate();
    }

    protected SoundEvent getAmbientSound() {
        return Sounds.aggressive_say;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return Sounds.aggressive_hurt;
    }

    protected SoundEvent getDeathSound() {
        return Sounds.aggressive_death;
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                this.dropItem(GaiaItems.FoodRoot, 1);
            }

            if (this.shovelAttack >= 4) {
                if ((this.rand.nextInt(8) == 0)) {
                    this.dropItem(GaiaItems.FoodMandrake, 1);
                }
            } else {
                if ((this.rand.nextInt(16) == 0)) {
                    this.dropItem(GaiaItems.FoodMandrake, 1);
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
                        this.dropItem(GaiaItems.BoxIron, 1);
                }
            }
        }
    }

    @Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        ItemStack WEAPON_CUSTOM = new ItemStack(GaiaItems.PropWeaponEnchanted, 1);
        WEAPON_CUSTOM.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 1);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, WEAPON_CUSTOM);

        return livingdata;
    }

    // ================= Immunities =================//
    public boolean isPotionApplicable(PotionEffect potioneffectIn) {
        return potioneffectIn.getPotion() == MobEffects.POISON
                ? false
                : super.isPotionApplicable(potioneffectIn);
    }
    // ==============================================//

    public boolean getCanSpawnHere() {
        return this.posY < 0.0D && super.getCanSpawnHere();
    }
}
