package gaia.entity.monster;

import javax.annotation.Nonnull;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
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
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaAnt extends EntityMobHostileDay implements GaiaIRangedAttackMob {

    private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.attackSpeed1, 20, 15.0F);
    private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed1, true);

    private static final DataParameter<Integer> SKIN = EntityDataManager.<Integer>createKey(EntityGaiaAnt.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> HOLDING_BOW = EntityDataManager.<Boolean>createKey(EntityGaiaAnt.class, DataSerializers.BOOLEAN);
    private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
    private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);

    private int mobClass;

    public EntityGaiaAnt(World worldIn) {
        super(worldIn);

        this.experienceValue = EntityAttributes.experienceValue1;
        this.stepHeight = 1.0F;

        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);

        this.mobClass = 0;

        if (worldIn != null && !worldIn.isRemote) {
            this.setCombatTask();
        }
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        // this.tasks.addTask(1, new RESERVED);
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    @Override
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

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (damage > EntityAttributes.baseDefense1) {
            damage = EntityAttributes.baseDefense1;
        }

        return super.attackEntityFrom(source, damage);
    }

    @Override
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
        super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback1);
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (this.getMobType() == 1 && entityIn instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 5;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 10;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public void setItemStackToSlot(EntityEquipmentSlot par1, ItemStack par2ItemStack) {
        super.setItemStackToSlot(par1, par2ItemStack);
        if (!this.world.isRemote && par1.getIndex() == 0) {
            this.setCombatTask();
        }
    }

    public void setCombatTask() {
        tasks.removeTask(aiAttackOnCollide);
        tasks.removeTask(aiArrowAttack);

        ItemStack itemstack = getHeldItemMainhand();

        if (itemstack.getItem() == Items.BOW) {
            tasks.addTask(1, aiArrowAttack);
        } else {
            tasks.addTask(1, aiAttackOnCollide);
        }
    }

    public int getTextureType() {
        return dataManager.get(SKIN);
    }

    public void setTextureType(int par1) {
        this.dataManager.set(SKIN, par1);
    }

    public int getMobType() {
        return dataManager.get(SKIN);
    }

    public void setMobType(int par1) {
        this.dataManager.set(SKIN, par1);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        if (par1NBTTagCompound.hasKey("MobType")) {
            byte b0 = par1NBTTagCompound.getByte("MobType");
            this.setMobType(b0);
        }

        this.setCombatTask();
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("MobType", (byte) this.getMobType());
    }

    // ================= Archer data =================//
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        Ranged.RangedAttack(target, this, distanceFactor);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(SKIN, Integer.valueOf(0));
        this.dataManager.register(HOLDING_BOW, Boolean.valueOf(false));
    }

    @Override
    public boolean canAttackClass(Class <? extends EntityLivingBase > cls) {
        return super.canAttackClass(cls) && cls != EntityGaiaAnt.class;
    }

    @SideOnly(Side.CLIENT)
    public boolean isHoldingBow() {
        return ((Boolean) this.dataManager.get(HOLDING_BOW)).booleanValue();
    }

    public void setHoldingBow(boolean swingingArms) {
        this.dataManager.set(HOLDING_BOW, Boolean.valueOf(swingingArms));
    }
    // ===============================================//

    protected SoundEvent getAmbientSound() {
        return Sounds.aggressive_say;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return Sounds.aggressive_hurt;
    }

    protected SoundEvent getDeathSound() {
        return Sounds.aggressive_death;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            if (this.mobClass == 1) {
                if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                    this.dropItem(Items.ARROW, 1);
                }
            } else {
                if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                    this.dropItem(GaiaItems.FoodMeat, 1);
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
                if (mobClass == 1) {
                    switch (this.rand.nextInt(2)) {
                        case 0:
                            this.dropItem(GaiaItems.BoxIron, 1);
                            break;
                        case 1:
                            this.dropItem(GaiaItems.BagArrow, 1);
                    }
                } else {
                    switch (this.rand.nextInt(1)) {
                        case 0:
                            this.dropItem(GaiaItems.BoxIron, 1);
                            break;
                    }
                }
            }
        }
    }

    @Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        if (this.world.rand.nextInt(2) == 0) {
            this.tasks.addTask(1, this.aiArrowAttack);
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
            this.setEnchantmentBasedOnDifficulty(difficulty);

            if (this.world.rand.nextInt(2) == 0) {
                if (this.world.rand.nextInt(2) == 0) {
                    this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
                } else {
                    this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM_2);
                }
            }

            this.setTextureType(1);
            this.mobClass = 1;
        } else {
            this.tasks.addTask(1, this.aiAttackOnCollide);
            this.setEquipmentBasedOnDifficulty(difficulty);
            this.setEnchantmentBasedOnDifficulty(difficulty);
            this.setMobType(1);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
                    .setBaseValue((double) EntityAttributes.attackDamage1);
            this.setTextureType(0);
            this.mobClass = 0;
        }

        return livingdata;
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        int i = this.rand.nextInt(3);

        if (i == 0) {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
        } else {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
        }
    }

    @Override
    public @Nonnull EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    // ================= Immunities =================//
    @Override
    public boolean isPotionApplicable(@Nonnull PotionEffect potioneffectIn) {
        return potioneffectIn.getPotion() != MobEffects.POISON && super.isPotionApplicable(potioneffectIn);
    }
    // ==============================================//

    public boolean getCanSpawnHere() {
        return this.posY > 60.0D && super.getCanSpawnHere();
    }

}
