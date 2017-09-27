package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nullable;

public class EntityGaiaShaman extends EntityMobHostileBase implements IRangedAttackMob {

    private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.attackSpeed2, 20, 60, 15.0F);
    private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true);

    private int switchHealth;
    private int spawn;

    public EntityGaiaShaman(World worldIn) {
        super(worldIn);

        this.experienceValue = EntityAttributes.experienceValue2;
        this.stepHeight = 1.0F;
        this.switchHealth = 0;
        this.spawn = 0;
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        // this.tasks.addTask(1, new RESERVED);
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

    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        Ranged.magic(target, this, distanceFactor);
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof EntityLivingBase) {
                byte byte0 = 0;
                byte byte1 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 5;
                    byte1 = 10;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 10;
                    byte1 = 20;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 20, 0));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte1 * 20, 0));
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

    public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
        return par1PotionEffect.getPotion() == MobEffects.POISON
                ? false
                : super.isPotionApplicable(par1PotionEffect);
    }

    public void onLivingUpdate() {
        this.beaconMonster(MobEffects.RESISTANCE, 300, 1, 6);

        if ((this.getHealth() < EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 0)) {
            this.tasks.removeTask(this.aiArrowAttack);
            this.tasks.addTask(1, this.aiAttackOnCollide);
            this.switchHealth = 1;
        }

        if ((this.getHealth() > EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 1)) {
            this.tasks.removeTask(this.aiAttackOnCollide);
            this.tasks.addTask(1, this.aiArrowAttack);
            this.switchHealth = 0;
        }

        EntityZombie spawnMob;
        if (this.getHealth() < EntityAttributes.maxHealth2 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0) {
            this.world.setEntityState(this, (byte) 12);

            if (!this.world.isRemote) {
                spawnMob = new EntityZombie(this.world);
                spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                spawnMob.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData) null);
                spawnMob.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.PUMPKIN));
                this.world.spawnEntity(spawnMob);
            }
            this.spawn = 1;
        }

        if (this.getHealth() < EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1) {
            this.world.setEntityState(this, (byte) 12);

            if (!this.world.isRemote) {
                spawnMob = new EntityZombie(this.world);
                spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                spawnMob.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData) null);
                spawnMob.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.PUMPKIN));
                this.world.spawnEntity(spawnMob);
            }
            this.spawn = 2;
        }

        super.onLivingUpdate();
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 12) {
            this.spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @SideOnly(Side.CLIENT)
    private void spawnParticles(EnumParticleTypes particleType) {
        for (int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.spawnParticle(particleType,
                    this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                    this.posY + 1.0D + (double) (this.rand.nextFloat() * this.height),
                    this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2, new int[0]);
        }
    }

    public void beaconMonster(Potion effect, int duration, int power, int range) {
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
                if (!(mob instanceof EntityGaiaShaman)) {
                    if (mob instanceof EntityZombie) {
                        mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
                    } else if (mob instanceof EntitySkeleton) {
                        mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
                    }
                }
            }
        }
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

    protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
        super.dropLoot(wasRecentlyHit, lootingModifier, source);
        this.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_WITCH;
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            int var3 = this.rand.nextInt(3 + lootingModifier);

            for (int var4 = 0; var4 < var3; ++var4) {
                this.dropItem(GaiaItems.FoodRottenHeart, 1);
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
                        this.dropItem(GaiaItems.BoxGold, 1);
                        break;
                    case 1:
                        this.dropItem(GaiaItems.BagBook, 1);
                        break;
                    case 2:
                        this.dropItem(GaiaItems.MiscBook, 1);
                }
            }
        }
    }

    @Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        this.tasks.removeTask(this.aiAttackOnCollide);
        this.tasks.addTask(1, this.aiArrowAttack);

        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 0));
        this.setEnchantmentBasedOnDifficulty(difficulty);

        return livingdata;
    }

    public boolean getCanSpawnHere() {
        return this.posY > 60.0D && super.getCanSpawnHere();
    }
}
