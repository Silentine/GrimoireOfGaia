package gaia.entity;

import javax.annotation.Nonnull;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

//Adapted from DivineRPG code
public abstract class EntityMobMerchant extends EntityVillager implements INpc, IMerchant {

    private int randomTickDivider;
    private Village villageObj;
    private String lastBuyingPlayer;
    private EntityPlayer buyingPlayer;
    private MerchantRecipeList buyingList;
    private int timeUntilReset;
    private boolean needsInitilization;
    private int wealth;
    private String buyersName;
    private float buying;

    public EntityMobMerchant(World worldIn) {
        super(worldIn);

        randomTickDivider = 0;
        villageObj = null;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.maxHealth1);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed1);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return null;
    }

    @Override
    public boolean processInteract(EntityPlayer player, @Nonnull EnumHand hand) {
        final ItemStack stack = player.getHeldItem(hand);
        final boolean flag = stack != ItemStack.EMPTY && stack.getItem() == Items.SPAWN_EGG;

        if (!flag && isEntityAlive() && !isTrading() && !isChild() && !player.isSneaking()) {
            if (!world.isRemote && (buyingList == null || !buyingList.isEmpty())) {
                setCustomer(player);
                String name = getCustomNameTag();
                if (null == name || name.length() < 1) {
                    name = getCommandSenderEntity()
                            .getName();
                }
                player.displayVillagerTradeGui(this);
            }

            player.addStat(StatList.TALKED_TO_VILLAGER);
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    public abstract void addRecipies(MerchantRecipeList list);

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

        compound.setInteger("Profession", getProfession());
        compound.setInteger("Riches", wealth);

        if (buyingList != null) {
            compound.setTag("Offers", buyingList.getRecipiesAsTags());
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        setProfession(compound.getInteger("Profession"));
        wealth = compound.getInteger("Riches");

        if (compound.hasKey("Offers")) {
            NBTTagCompound offerCompound = compound.getCompoundTag("Offers");
            buyingList = new GaiaTradeList(offerCompound);
        }
    }

    @Override
    public void useRecipe(@Nonnull MerchantRecipe recipe) {
        recipe.incrementToolUses();
        livingSoundTime = -getTalkInterval();
        int i = 3 + rand.nextInt(4);

        if (recipe.getToolUses() == 1 || rand.nextInt(5) == 0) {
            timeUntilReset = 40;
            needsInitilization = true;
            // TODO Will need to come back to this, mating code got changed
            // TODO isWillingToMate = true;

            if (buyingPlayer != null) {
                lastBuyingPlayer = buyingPlayer.getName();
            } else {
                lastBuyingPlayer = null;
            }

            i += 5;
        }

        if (recipe.getItemToBuy()
                .getItem() == Items.EMERALD) {
            wealth += recipe.getItemToBuy()
                    .getMaxStackSize();
        }

        if (recipe.getRewardsExp()) {
            world.spawnEntity(new EntityXPOrb(world, posX, posY + 0.5D, posZ, i));
        }
    }

    public void func_110297_a_(ItemStack itemstack) {
    }

    @Override
    public MerchantRecipeList getRecipes(EntityPlayer var1) {
        if (buyingList == null) {
            addDefaultEquipmentAndRecipies(75);
        }

        return buyingList;
    }

    private void addDefaultEquipmentAndRecipies(int par1) {
        if (buyingList != null) {
            buying = MathHelper.sqrt(buyingList.size()) * 0.2F;
        } else {
            buying = 0.0F;
        }

        MerchantRecipeList rec = new MerchantRecipeList();
        addRecipies(rec);
        if (buyingList == null) {
            buyingList = new MerchantRecipeList();
        }

        for (int var3 = 0; var3 < par1 && var3 < rec.size(); ++var3) {
            buyingList.add((MerchantRecipe) rec.get(var3));
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        return posY < 0.0D && super.getCanSpawnHere();
    }
}
