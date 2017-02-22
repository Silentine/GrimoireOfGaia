package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.Trade;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityGaiaNPCTrader extends EntityMobMerchant {

	public EntityGaiaNPCTrader(World var1) {
		super(var1);
	}

	public ITextComponent getDisplayName() {
		String s = "entity.grimoireofgaia.Trader.name";
		TextComponentTranslation text = new TextComponentTranslation(s);
		return text;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.passive_say;
	}

	@Override
	protected SoundEvent getHurtSound() {
		return Sounds.passive_hurt;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.passive_death;
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(1) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItems.SpawnTrader, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 1)));	
		
		//Buy List
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 1, 1), new ItemStack(GaiaItems.BoxIron, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 4, 1), new ItemStack(GaiaItems.BoxGold, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 8, 1), new ItemStack(GaiaItems.BoxDiamond, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 6, 1), new ItemStack(GaiaItems.BagBook, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 1, 1), new ItemStack(GaiaItems.BagOre, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 2, 1), new ItemStack(GaiaItems.BagRecord, 1, 0)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscCurrency, 6, 1), new ItemStack(GaiaItems.MiscBook, 1, 0)));
		
		//Sell List
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscGigaGear, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 8, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscRing, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 6, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscRing, 1, 1), new ItemStack(GaiaItems.MiscCurrency, 6, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscRing, 1, 2), new ItemStack(GaiaItems.MiscCurrency, 6, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.MiscRing, 1, 3), new ItemStack(GaiaItems.MiscCurrency, 6, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.Spawn, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.SpawnCreeperGirl, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.SpawnSlimeGirl, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.SpawnEnderGirl, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.SpawnTrader, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.SpawnHolstaurus, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.SpawnWeresheep, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.PropWeapon, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.PropWeapon, 1, 1), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.FanFire, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.FanIce, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookBattle, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookHunger, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookNature, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookWither, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookEnder, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookFreezing, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookBuff, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookNightmare, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.BookMetal, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new Trade(new ItemStack(GaiaItems.AccessoryCursed, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 8, 1)));
	}
}
