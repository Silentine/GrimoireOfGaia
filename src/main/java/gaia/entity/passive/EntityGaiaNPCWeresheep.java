package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.Trade;
import gaia.init.GaiaItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityGaiaNPCWeresheep extends EntityMobMerchant {

	public EntityGaiaNPCWeresheep(World var1) {
		super(var1);
	}
	/** TODO ICHATCOMPONENT 
	public IChatComponent getDisplayName() {
		 String s = "Weresheep";
		 ChatComponentText chatcomponenttext = new ChatComponentText(s);
		 return chatcomponenttext;
    }
	**/
	public ITextComponent getDisplayName() {
		 String s = "Weresheep";
		 TextComponentTranslation text = new TextComponentTranslation(s);
		 return text;
	}
	@Override
	protected String getLivingSound() {
		return "grimoireofgaia:passive_say";
	}

	@Override
	protected String getHurtSound() {
		return "grimoireofgaia:passive_hurt";
	}

	@Override
	protected String getDeathSound() {
		return "grimoireofgaia:passive_death";
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(1) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.SpawnWeresheep, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));	
		
		//Buy List
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 2)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 3)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 4)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 5)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 6)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 7)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 8)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 9)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 10)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 11)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 12)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 13)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 14)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 2), new ItemStack(Blocks.WOOL, 1, 15)));
		
		//Sell List
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 1), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 2), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 3), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 4), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 5), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 6), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 7), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 8), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 9), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 10), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 11), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 12), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 13), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 14), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
		recipes.add(new Trade(new ItemStack(Blocks.WOOL, 1, 15), new ItemStack(GaiaItem.MiscCurrency, 1, 2)));
	}
}
