package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;


public class EntityGaiaNPCTrader extends EntityMobMerchant {

	public EntityGaiaNPCTrader(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public EntityType<?> getType() {
		return GaiaEntities.TRADER_NPC;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.TRADER_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.TRADER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.TRADER_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0) {
				entityDropItem(new ItemStack(GaiaItems.SPAWN_TRADER, 1), 0.0F);
			}
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 1)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 1), new ItemStack(GaiaItems.BOX_IRON, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2), new ItemStack(GaiaItems.BOX_GOLD, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4), new ItemStack(GaiaItems.BOX_DIAMOND, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4), new ItemStack(GaiaItems.BAG_BOOK, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2), new ItemStack(GaiaItems.BAG_RECORD, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4), new ItemStack(GaiaItems.MISC_BOOK, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2), new ItemStack(GaiaItems.CHEST_DUNGEON)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2), new ItemStack(GaiaItems.CHEST_JUNGLE, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2), new ItemStack(GaiaItems.CHEST_TEMPLE, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4), new ItemStack(GaiaItems.BOX_HAT, 1)));

		// Sell List
		// Materials
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_GIGA_GEAR, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SHARD_MISC, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING_SPEED, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING_HASTE, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING_JUMP, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_RING_NIGHT, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));

		// Miscellaneous
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_CREEPER_GIRL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_SLIME_GIRL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_ENDER_GIRL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_TRADER, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_HOLSTAURUS, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.SPAWN_WERESHEEP, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX_IRON, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX_GOLD, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX_DIAMOND, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOX_OLD, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));

		// Combat
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_FAN_FIRE, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_FAN_ICE, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));

		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_FREEZING, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_NIGHTMARE, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_METAL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_ENDER, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_HUNGER, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_BATTLE, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_NATURE, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.WEAPON_BOOK_WITHER, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.BOOK_BUFF, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));

		// Accessory
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_TRINKET_POISON, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_TRINKET_WITHER, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_TRINKET_LEVITATION, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.ACCESSORY_CURSED, 1), new ItemStack(GaiaItems.MISC_CURRENCY_TRADER, 4)));
	}
}
