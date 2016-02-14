package gaia.entity.passive;

import gaia.GaiaItem;
import gaia.entity.EntityMobMerchant;
import gaia.entity.Trade;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityGaiaNPCEnderGirl extends EntityMobMerchant {

	public EntityGaiaNPCEnderGirl(World var1) {
		super(var1);
	}
	
	@Override
	protected String getLivingSound() {
		return "gaia:passive_say";
	}

	@Override
	protected String getHurtSound() {
		return "gaia:passive_hurt";
	}

	@Override
	protected String getDeathSound() {
		return "gaia:passive_death";
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if(par1 && (this.rand.nextInt(1) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.SpawnCardEnderGirl, 1, 1), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 1), new ItemStack(Items.ender_pearl, 1, 0)));	
		//Buy List
		recipes.add(new Trade(new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.bone, 8, 0)));
		recipes.add(new Trade(new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.rotten_flesh, 16, 0)));
		recipes.add(new Trade(new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.gunpowder, 4, 0)));
		recipes.add(new Trade(new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.spider_eye, 4, 0)));
		recipes.add(new Trade(new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.string, 8, 0)));
		//Sell List
		recipes.add(new Trade(new ItemStack(Items.bone, 16, 0), new ItemStack(Items.ender_pearl, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.gunpowder, 8, 0), new ItemStack(Items.ender_pearl, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.rotten_flesh, 24, 0), new ItemStack(Items.ender_pearl, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.string, 16, 0), new ItemStack(Items.ender_pearl, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.slime_ball, 8, 0), new ItemStack(Items.ender_pearl, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.spider_eye, 8, 0), new ItemStack(Items.ender_pearl, 1, 0)));
	}
}
