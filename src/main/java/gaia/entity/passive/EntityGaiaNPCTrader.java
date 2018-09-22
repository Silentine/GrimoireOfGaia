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

	public EntityGaiaNPCTrader(World worldIn) {
		super(worldIn);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.TRADER_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.TRADER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.TRADER_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit && (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
			entityDropItem(new ItemStack(GaiaItems.SPAWN_TRADER, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 1)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 1), new ItemStack(GaiaItems.BOX_IRON, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1), new ItemStack(GaiaItems.BOX_GOLD, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1), new ItemStack(GaiaItems.BOX_DIAMOND, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1), new ItemStack(GaiaItems.BAG_BOOK, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1), new ItemStack(GaiaItems.BAG_RECORD, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1), new ItemStack(GaiaItems.MISC_BOOK, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1), new ItemStack(GaiaItems.CHEST, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1), new ItemStack(GaiaItems.CHEST, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1), new ItemStack(GaiaItems.CHEST, 1, 2)));

		// Sell List
		// Materials
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_GIGA_GEAR, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SHARD_MISC, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING, 1, 1), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING, 1, 2), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING, 1, 3), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));

		// Miscellaneous
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_CREEPER_GIRL, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_SLIME_GIRL, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_ENDER_GIRL, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_TRADER, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_HOLSTAURUS, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_WERESHEEP, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX, 1, 1), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX, 1, 2), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX_OLD, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));

		// Combat
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_FAN_FIRE, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_FAN_ICE, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));

		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_FREEZING, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_NIGHTMARE, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_METAL, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_ENDER, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_HUNGER, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_BATTLE, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_NATURE, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_WITHER, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOOK_BUFF, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));

		// Accessory
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_TRINKET_POISON, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_TRINKET_WITHER, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_TRINKET_LEVITATION, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_CURSED, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 4, 1)));
	}
}