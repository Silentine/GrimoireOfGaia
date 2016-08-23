package gaia.entity;

import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;

import java.util.Iterator;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

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

	public EntityMobMerchant(World var1) {
		super(var1);
		this.randomTickDivider = 0;
		this.villageObj = null;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth1);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound(){
		return null;
	}

	@Override
	protected SoundEvent getDeathSound(){
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(){
		return null;
	}

	@Override
	protected void updateAITick() {
		if (this.randomTickDivider-- <= 0) {
			this.randomTickDivider = 70 + this.rand.nextInt(50);
			this.villageObj = this.worldObj.villageCollectionObj.getNearestVillage(this.getPosition(), 32);
			if (this.villageObj == null) {
				this.detachHome();
			} else {
				this.villageObj.setDefaultPlayerReputation(30);
			}
		}

		if (this.timeUntilReset > 0) {
			if (this.timeUntilReset <= 0) {
				if (this.buyingList.size() > 1) {
					Iterator iterator = this.buyingList.iterator();
					if (needsInitilization){
						while (iterator.hasNext()) {
							MerchantRecipe merchantrecipe = (MerchantRecipe)iterator.next();
							if (merchantrecipe.isRecipeDisabled()) {
								merchantrecipe.increaseMaxTradeUses(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
							}
						}
					}
					this.addDefaultEquipmentAndRecipies(75);
					this.needsInitilization = false;
					if (this.villageObj != null && this.lastBuyingPlayer != null) {
						this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 30);
					}
				}
				this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0));
			}
		}
		super.updateAITick();
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack var2 = player.inventory.getCurrentItem();
		boolean var3 = var2 != null && var2.getItem() == Items.spawn_egg;
		if (!var3 && this.isEntityAlive() && !this.isTrading() && !this.isChild()) {
			if (!this.worldObj.isRemote) {
				this.setCustomer(player);
				String name = this.getCustomNameTag();
				if (null == name || name.length() < 1) {
					name = this.getCommandSenderEntity().getName();
				}

				player.displayVillagerTradeGui(this);
			}

			return true;
		} else {
			return super.interact(player);
		}
	}

	public abstract void addRecipies(MerchantRecipeList list);

	@Override
	public void writeEntityToNBT(NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
		var1.setInteger("Profession", this.getProfession());
		var1.setInteger("Riches", this.wealth);

		if (this.buyingList != null) {
			var1.setTag("Offers", this.buyingList.getRecipiesAsTags());
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
		this.setProfession(var1.getInteger("Profession"));
		this.wealth = var1.getInteger("Riches");

		if (var1.hasKey("Offers")) {
			NBTTagCompound var2 = var1.getCompoundTag("Offers");
			if (this instanceof EntityGaiaNPCCreeperGirl || this instanceof EntityGaiaNPCEnderGirl || this instanceof EntityGaiaNPCHolstaurus || this instanceof EntityGaiaNPCSlimeGirl || this instanceof EntityGaiaNPCTrader) this.buyingList = new TradeList(var2);
			else this.buyingList = new MerchantRecipeList(var2);
		}
	}

	@Override
	public void useRecipe(MerchantRecipe recipe) {
		recipe.incrementToolUses();
		this.livingSoundTime = -this.getTalkInterval();
		int i = 3 + this.rand.nextInt(4);

		if (recipe.getToolUses() == 1 || this.rand.nextInt(5) == 0) {
			this.timeUntilReset = 40;
			this.needsInitilization = true;
			//TODO Will need to come back to this, mating code got changed
			//TODO this.isWillingToMate = true;

			if (this.buyingPlayer != null) {
				this.lastBuyingPlayer = this.buyingPlayer.getName();
			} else {
				this.lastBuyingPlayer = null;
			}

			i += 5;
		}

		if (recipe.getItemToBuy().getItem() == Items.EMERALD) {
			this.wealth += recipe.getItemToBuy().stackSize;
		}

		if (recipe.getRewardsExp()) {
			this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY + 0.5D, this.posZ, i));
		}
	}

	public void func_110297_a_(ItemStack itemstack) {}

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer var1) {
		if (this.buyingList == null) {
			this.addDefaultEquipmentAndRecipies(75);
		}
		return this.buyingList;
	}

	private void addDefaultEquipmentAndRecipies(int par1) {
		if (this.buyingList != null) {
			this.buying = MathHelper.sqrt_float(this.buyingList.size()) * 0.2F;
		} else {
			this.buying = 0.0F;
		}

		MerchantRecipeList rec = new MerchantRecipeList();
		addRecipies(rec);
		if (this.buyingList == null) {
			this.buyingList = new MerchantRecipeList();
		}

		for (int var3 = 0; var3 < par1 && var3 < rec.size(); ++var3) {
			this.buyingList.add((MerchantRecipe)rec.get(var3));
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY < 0.0D && super.getCanSpawnHere();
	}
}