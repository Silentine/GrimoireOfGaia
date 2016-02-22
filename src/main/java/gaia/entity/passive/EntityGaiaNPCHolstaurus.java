package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.Trade;
import gaia.init.GaiaItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityGaiaNPCHolstaurus extends EntityMobMerchant {

	public EntityGaiaNPCHolstaurus(World var1) {
		super(var1);
	}
	
	public IChatComponent getDisplayName()
    {
		 String s = "Holstaurus";
		 ChatComponentText chatcomponenttext = new ChatComponentText(s);
		 return chatcomponenttext;
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
            this.entityDropItem(new ItemStack(GaiaItem.SpawnCardHolstaurus, 1, 1), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 1), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));	
		//Buy List
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Items.wheat_seeds, 8, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Items.pumpkin_seeds, 16, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 2, 2), new ItemStack(Items.melon_seeds, 16, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 16, 2), new ItemStack(Items.cake, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 8, 2), new ItemStack(Items.pumpkin_pie, 1, 0)));
		//Sell List
		recipes.add(new Trade(new ItemStack(Items.wheat, 8, 0), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.pumpkin, 2, 0), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.melon_block, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 2)));
		recipes.add(new Trade(new ItemStack(Items.egg, 8, 0), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Items.sugar, 16, 0), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
	}
}
