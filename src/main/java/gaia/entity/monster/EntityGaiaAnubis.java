package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import gaia.renderer.particle.ParticleWarning;
import net.minecraft.client.Minecraft;
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
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
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

public class EntityGaiaAnubis extends EntityMobHostileBase implements IRangedAttackMob {

    private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.attackSpeed2, 20, 60, 15.0F);
    private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true);

    private int switchHealth;
    private int spawn;
    private int spawnTimer;
    private int spawnLevel3;
    private int spawnLevel3Chance;

    public EntityGaiaAnubis(World worldIn) {
        super(worldIn);

        this.experienceValue = EntityAttributes.experienceValue2;
        this.stepHeight = 1.0F;

        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);

        this.switchHealth = 0;
        this.spawn = 0;
        this.spawnTimer = 0;

        this.spawnLevel3 = 0;
        this.spawnLevel3Chance = 0;
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        // this.tasks.addTask(1, new RESERVED);
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
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

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (damage > EntityAttributes.baseDefense2) {
            damage = EntityAttributes.baseDefense2;

            if (GaiaConfig.SpawnLevel3) {
                this.spawnLevel3Chance += (int) (GaiaConfig.SpawnLevel3Chance * 0.05);
            }
        }

        return super.attackEntityFrom(source, damage);
    }

    @Override
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
        super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        Ranged.magic(target, this, distanceFactor);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof EntityLivingBase) {
                byte byte0 = 0;
                byte byte1 = 0;

                if (world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 5;
                    byte1 = 10;
                } else if (world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 10;
                    byte1 = 20;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, byte1 * 20, 0));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
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

        EntitySkeleton spawnMob;
        if (this.getHealth() < EntityAttributes.maxHealth2 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0) {

            this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.STICK));

            if (this.spawnTimer != 30) {
                this.spawnTimer += 1;
            }

            if (this.spawnTimer == 30) {
                this.world.setEntityState(this, (byte) 12);
                this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.EGG));

                if (!this.world.isRemote) {
                    spawnMob = new EntitySkeleton(this.world);
                    spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                    spawnMob.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData) null);
                    spawnMob.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.PUMPKIN));
                    this.world.spawnEntity(spawnMob);
                }

                this.spawnTimer = 0;
                this.spawn = 1;
            }
        }

        if (this.getHealth() < EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1) {

            this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.STICK));

            if (this.spawnTimer != 30) {
                this.spawnTimer += 1;
            }

            if (this.spawnTimer == 30) {
                this.world.setEntityState(this, (byte) 12);
                this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.EGG));

                if (!this.world.isRemote) {
                    spawnMob = new EntitySkeleton(this.world);
                    spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                    spawnMob.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData) null);
                    spawnMob.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.PUMPKIN));
                    this.world.spawnEntity(spawnMob);
                }

                if (GaiaConfig.SpawnLevel3) {
                    if (spawnLevel3Chance > (int) (GaiaConfig.SpawnLevel3Chance * 0.5)) {
                        this.spawnLevel3Chance = (int) (GaiaConfig.SpawnLevel3Chance * 0.5);
                    }

                    if ((this.rand.nextInt(GaiaConfig.SpawnLevel3Chance - this.spawnLevel3Chance) == 0 || this.rand.nextInt(1) > 0)) {
                        this.spawnLevel3 = 1;
                    }
                }

                this.spawnTimer = 0;
                this.spawn = 2;
            }
        }

        if (spawnLevel3 == 1) {
            this.world.setEntityState(this, (byte) 13);

            this.attackEntityFrom(DamageSource.GENERIC, EntityAttributes.maxHealth2 * 0.01F);
        }

        super.onLivingUpdate();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 12) {
            this.spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
        } else if (id == 13) {
            for (int i = 0; i < 1; ++i) {
                ParticleWarning particleCustom = new ParticleWarning(this.world,
                        this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                        this.posY + 1.0D + (double) (this.rand.nextFloat() * this.height),
                        this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
            }
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
                if (!(mob instanceof EntityGaiaAnubis)) {
                    if (mob instanceof EntityZombie) {
                        mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
                    }
                    if (mob instanceof EntitySkeleton) {
                        mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
                    }
                }
            }
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
    protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
        super.dropLoot(wasRecentlyHit, lootingModifier, source);

        dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_WITCH;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
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

        // Boss
        if (spawnLevel3 == 1) {
            spawnLevel3();
        }
    }

    protected void spawnLevel3() {
        EntityGaiaSphinx spawnLevel3;
        spawnLevel3 = new EntityGaiaSphinx(this.world);
        spawnLevel3.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        spawnLevel3.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(spawnLevel3)), (IEntityLivingData) null);
        this.world.spawnEntity(spawnLevel3);
    }

    @Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        this.tasks.removeTask(this.aiAttackOnCollide);
        this.tasks.addTask(1, this.aiArrowAttack);

        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 0));

        return livingdata;
    }

    public boolean getCanSpawnHere() {
        return this.posY > 60.0D && super.getCanSpawnHere();
    }
}
