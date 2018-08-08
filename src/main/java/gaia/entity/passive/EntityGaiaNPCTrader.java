package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaNPCTrader extends EntityMobMerchant {

	public EntityGaiaNPCTrader(World var1) {
		super(var1);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.PASSIVE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.PASSIVE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.PASSIVE_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit && (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
			entityDropItem(new ItemStack(GaiaItems.SpawnTrader, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 1)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 1, 1), new ItemStack(GaiaItems.BoxIron, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 2, 1), new ItemStack(GaiaItems.BoxGold, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 4, 1), new ItemStack(GaiaItems.BoxDiamond, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 4, 1), new ItemStack(GaiaItems.BagBook, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 1, 1), new ItemStack(GaiaItems.BagOre, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 2, 1), new ItemStack(GaiaItems.BagRecord, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 4, 1), new ItemStack(GaiaItems.MiscBook, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 2, 1), new ItemStack(GaiaItems.Chest, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 2, 1), new ItemStack(GaiaItems.Chest, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 2, 1), new ItemStack(GaiaItems.Chest, 1, 2)));

		// Sell List
		// Materials
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscGigaGear, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscRing, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscRing, 1, 1), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscRing, 1, 2), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscRing, 1, 3), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));

		// Miscellaneous
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.Spawn, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SpawnCreeperGirl, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SpawnSlimeGirl, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SpawnEnderGirl, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SpawnTrader, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SpawnHolstaurus, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SpawnWeresheep, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.Box, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.Box, 1, 1), new ItemStack(GaiaItems.MiscCurrency, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.Box, 1, 2), new ItemStack(GaiaItems.MiscCurrency, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BoxOld, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));

		// Combat
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.FanFire, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.FanIce, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));

		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookBase, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookFreezing, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookNightmare, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookMetal, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookEnder, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookHunger, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookBattle, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookNature, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookWither, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BookBuff, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));

		// Accessory
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.AccessoryTrinketPoison, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.AccessoryTrinketWither, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.AccessoryTrinketLevitation, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.AccessoryCursed, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 4, 1)));
	}
}
