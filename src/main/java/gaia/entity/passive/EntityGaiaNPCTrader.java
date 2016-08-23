package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.Trade;
import gaia.init.GaiaItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityGaiaNPCTrader extends EntityMobMerchant {

	public EntityGaiaNPCTrader(World var1) {
		super(var1);
	}
	/** TODO ICHATCOMPONENT 
	public IChatComponent getDisplayName() {
		 String s = "Trader";
		 ChatComponentText chatcomponenttext = new ChatComponentText(s);
		 return chatcomponenttext;
    }
	**/
	public ITextComponent getDisplayName() {
		 String s = "Trader";
		 TextComponentTranslation text = new TextComponentTranslation(s);
		 return text;
	}
	@Override
	protected SoundEvent getAmbientSound(){
		return "grimoireofgaia:passive_say";
	}

	@Override
	protected SoundEvent getHurtSound(){
		return "grimoireofgaia:passive_hurt";
	}

	@Override
	protected SoundEvent getDeathSound(){
		return "grimoireofgaia:passive_death";
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(1) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.SpawnTrader, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 1, 0)));	
		
		//Buy List
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 0), new ItemStack(GaiaItem.BoxIron, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 4, 0), new ItemStack(GaiaItem.BoxGold, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 8, 0), new ItemStack(GaiaItem.BoxDiamond, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 6, 0), new ItemStack(GaiaItem.BagBook, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 0), new ItemStack(GaiaItem.BagOre, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 2, 0), new ItemStack(GaiaItem.BagRecord, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 6, 0), new ItemStack(GaiaItem.MiscBook, 1, 0)));
		
		//Sell List
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscGigaGear, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 8, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscRing, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 6, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscRing, 1, 1), new ItemStack(GaiaItem.MiscCurrency, 6, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscRing, 1, 2), new ItemStack(GaiaItem.MiscCurrency, 6, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscRing, 1, 3), new ItemStack(GaiaItem.MiscCurrency, 6, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.Spawn, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.SpawnCreeperGirl, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.SpawnSlimeGirl, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.SpawnEnderGirl, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.SpawnTrader, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.SpawnHolstaurus, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.SpawnWeresheep, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.PropWeapon, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.PropWeapon, 1, 1), new ItemStack(GaiaItem.MiscCurrency, 2, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.FanFire, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.FanIce, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookBattle, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookHunger, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookNature, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookWither, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookEnder, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookFreezing, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookBuff, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookNightmare, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.BookMetal, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 4, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItem.AccessoryCursed, 1, 0), new ItemStack(GaiaItem.MiscCurrency, 8, 0)));
	}
}
