package gaia.entity.monster;

import java.util.UUID;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaDryad extends EntityMobPassiveDay {

    private static final UUID MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    private static final AttributeModifier MODIFIER = (new AttributeModifier(MODIFIER_UUID, "Attacking speed penalty", -0.05D, 0)).setSaved(false);

    private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true);
    private EntityAIAvoidEntity<EntityPlayer> aiAvoid = new EntityAIAvoidEntity<>(this, EntityPlayer.class, 20.0F, EntityAttributes.attackSpeed2, EntityAttributes.attackSpeed3);

    private int switchHealth;
    private int axeAttack;

    private byte stamina;
    private byte staminaTimer;

    public EntityGaiaDryad(World worldIn) {
        super(worldIn);

        this.experienceValue = EntityAttributes.experienceValue1;
        this.stepHeight = 1.0F;

        this.switchHealth = 0;
        this.axeAttack = 0;
        
        this.stamina = (30 * 4);
        this.staminaTimer = 0;
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        // this.tasks.addTask(1, new RESERVED);
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth1);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed1);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage1);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor1);
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

                if (itemstack.getItem() instanceof ItemAxe) {
                    damage = input * 1.5F;
                    this.axeAttack += 1;
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

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 5;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 10;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 20, 0));
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

        if (this.isBurning()) {
            this.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
            this.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
        }

        if ((this.getHealth() < EntityAttributes.maxHealth1 * 0.25F) && (this.switchHealth == 0)) {
            if (this.rand.nextInt(4) == 0) {
                this.tasks.removeTask(this.aiMeleeAttack);
                this.tasks.addTask(1, this.aiAvoid);
                this.switchHealth = 1;
            } else {
                this.switchHealth = 1;
            }
        }

        if (this.switchHealth == 1) {
            if (this.ticksExisted % 10 == 0) {
                this.world.setEntityState(this, (byte) 8);
            }
        }

        if ((this.getHealth() > EntityAttributes.maxHealth1 * 0.25F) && (this.switchHealth == 1)) {
            this.tasks.addTask(1, this.aiMeleeAttack);
            this.tasks.removeTask(this.aiAvoid);
            this.switchHealth = 0;
        }

        //Rough stamina system
        IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
            if (this.staminaTimer > 0) {
                this.staminaTimer = 0;
            }

            if (this.stamina > 0) {
                this.stamina -= 1;
            }
            
            if ((this.stamina <= 0) && (!iattributeinstance.hasModifier(MODIFIER))) {
                iattributeinstance.applyModifier(MODIFIER);
            }
        } else if (this.stamina < (30 * 4)) {
            if (this.staminaTimer < (10 * 4)) {
                this.staminaTimer += 1;
            } else {
                this.stamina = (30 * 4);
                
                if (iattributeinstance.hasModifier(MODIFIER)) {
                    iattributeinstance.removeModifier(MODIFIER);
                }
            }
        }

        super.onLivingUpdate();
    }

    protected SoundEvent getAmbientSound() {
        return Sounds.assist_say;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return Sounds.assist_hurt;
    }

    protected SoundEvent getDeathSound() {
        return Sounds.assist_death;
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                this.dropItem(GaiaItems.FoodRoot, 1);
            }

            if (this.axeAttack >= 4) {
                if ((this.rand.nextInt(2) == 0)) {
                    this.dropItem(Item.getItemFromBlock(Blocks.LOG), this.rand.nextInt(2) + 1);
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
        this.tasks.addTask(1, this.aiMeleeAttack);

        if (this.world.rand.nextInt(4) == 0) {
            this.setTextureType(1);
        }

        // TEMP Method used instead of isChild
        if (this.world.rand.nextInt(10) == 0) {
            this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.EGG));
        }

        return livingdata;
    }

    public float getEyeHeight() {
        float f;

        ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

        if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
            f = 1.74F;
        } else {
            f = (float) ((double) 1.74F - 0.81D);
        }

        return f;
    }

    private static final DataParameter<Integer> SKIN = EntityDataManager.<Integer>createKey(EntityGaiaDryad.class, DataSerializers.VARINT);

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(SKIN, Integer.valueOf(0));
    }

    public int getTextureType() {
        return ((Integer) this.dataManager.get(SKIN)).intValue();
    }

    public void setTextureType(int par1) {
        this.dataManager.set(SKIN, Integer.valueOf(par1));
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        if (par1NBTTagCompound.hasKey("MobType")) {
            byte b0 = par1NBTTagCompound.getByte("MobType");
            this.setTextureType(b0);
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("MobType", (byte) this.getTextureType());
    }

    public boolean getCanSpawnHere() {
        return this.posY > 60.0D && super.getCanSpawnHere();
    }
}
