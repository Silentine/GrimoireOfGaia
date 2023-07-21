package gaia.util;

import com.google.common.collect.ImmutableMap;
import gaia.registry.GaiaRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.Random;

public class GaiaMerchantTrades {
	public static final Int2ObjectMap<VillagerTrades.ItemListing[]> MERCHANT_TRADES = toIntMap(ImmutableMap.of(
			1, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.GIGA_GEAR.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.TOTEM_FRAGMENT.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.RING_OF_SPEED.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.RING_OF_HASTE.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.RING_OF_JUMP.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.RING_OF_NIGHT.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.BOX_EGG.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.CREEPER_GIRL.getSpawnEgg().get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.SLIME_GIRL.getSpawnEgg().get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.ENDER_GIRL.getSpawnEgg().get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.TRADER.getSpawnEgg().get(), 1, 2, 10, 5),
//					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.HOLSTAURUS.getSpawnEgg().get(), 1, 2, 10, 5),
//					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WERESHEEP.getSpawnEgg().get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.BOX_OVERWORLD.get(), 1, 1, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.BOX_NETHER.get(), 1, 1, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.BOX_END.get(), 1, 1, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.BOX_OLD.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.FAN_FIRE.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.FAN_ICE.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_FREEZING.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_NIGHTMARE.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_METAL.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_ENDER.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_HUNGER.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_BATTLE.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_NATURE.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WEAPON_BOOK_WITHER.get(), 1, 2, 10, 5),
//					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.TOADSTONE.get(), 1, 2, 10, 5),
//					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.WITHERED_HEART.get(), 1, 2, 10, 5),
//					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.BALL_AND_CHAIN.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForMerchantToken(GaiaRegistry.HEAVY_BARBELL.get(), 1, 2, 10, 5)
			},
			2, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.BOX_IRON.get(), 1, 1, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.BOX_GOLD.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.BOX_DIAMOND.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.BAG_BOOK.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.BAG_RECORD.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.BOOK_OF_MEMORY.get(), 1, 4, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.CHEST_DUNGEON.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.CHEST_JUNGLE.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.CHEST_DESERT.get(), 1, 2, 10, 5),
					new GaiaMerchantTrades.MerchantTokenForItem(GaiaRegistry.BOX_HAT.get(), 1, 4, 10, 5)
			}));

	public static final Int2ObjectMap<VillagerTrades.ItemListing[]> CREEPER_GIRL_TRADES = toIntMap(ImmutableMap.of(
			1, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemsToItems(Items.GUNPOWDER, 1, Items.BONE, 2, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.GUNPOWDER, 1, Items.ROTTEN_FLESH, 4, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.GUNPOWDER, 1, Items.SPIDER_EYE, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.GUNPOWDER, 1, Items.STRING, 2, 10, 5)
			},
			2, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemsToItems(Items.BONE, 4, Items.GUNPOWDER, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ENDER_PEARL, 1, Items.GUNPOWDER, 2, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ROTTEN_FLESH, 6, Items.GUNPOWDER, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.STRING, 4, Items.GUNPOWDER, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SLIME_BALL, 2, Items.GUNPOWDER, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SPIDER_EYE, 2, Items.GUNPOWDER, 1, 10, 5)
			}));

	public static final Int2ObjectMap<VillagerTrades.ItemListing[]> SLIME_GIRL_TRADES = toIntMap(ImmutableMap.of(
			1, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemsToItems(Items.SLIME_BALL, 1, Items.BONE, 2, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SLIME_BALL, 1, Items.ROTTEN_FLESH, 4, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SLIME_BALL, 1, Items.GUNPOWDER, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SLIME_BALL, 1, Items.SPIDER_EYE, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SLIME_BALL, 1, Items.STRING, 2, 10, 5)
			},
			2, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemsToItems(Items.BONE, 4, Items.SLIME_BALL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ENDER_PEARL, 1, Items.SLIME_BALL, 2, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.GUNPOWDER, 2, Items.SLIME_BALL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ROTTEN_FLESH, 6, Items.SLIME_BALL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.STRING, 4, Items.SLIME_BALL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SPIDER_EYE, 2, Items.SLIME_BALL, 1, 10, 5)
			}));

	public static final Int2ObjectMap<VillagerTrades.ItemListing[]> ENDER_GIRL_TRADES = toIntMap(ImmutableMap.of(
			1, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemsToItems(Items.ENDER_PEARL, 1, Items.BONE, 8, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ENDER_PEARL, 1, Items.ROTTEN_FLESH, 16, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ENDER_PEARL, 1, Items.GUNPOWDER, 4, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ENDER_PEARL, 1, Items.SPIDER_EYE, 4, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ENDER_PEARL, 1, Items.STRING, 8, 10, 5)
			},
			2, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemsToItems(Items.BONE, 16, Items.ENDER_PEARL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.GUNPOWDER, 8, Items.ENDER_PEARL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.ROTTEN_FLESH, 24, Items.ENDER_PEARL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.STRING, 16, Items.ENDER_PEARL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SLIME_BALL, 8, Items.ENDER_PEARL, 1, 10, 5),
					new GaiaMerchantTrades.ItemsToItems(Items.SPIDER_EYE, 8, Items.ENDER_PEARL, 1, 10, 5)
			}));

	public static final Int2ObjectMap<VillagerTrades.ItemListing[]> HOLSTAURUS_TRADES = toIntMap(ImmutableMap.of(
			1, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.HolstaurusTokenForItem(Items.WHEAT_SEEDS, 8, 1, 10, 5),
					new GaiaMerchantTrades.HolstaurusTokenForItem(Items.BEETROOT_SEEDS, 8, 1, 10, 5),
					new GaiaMerchantTrades.HolstaurusTokenForItem(Items.PUMPKIN_SEEDS, 16, 1, 10, 5),
					new GaiaMerchantTrades.HolstaurusTokenForItem(Items.MELON_SEEDS, 16, 2, 10, 5),
					new GaiaMerchantTrades.HolstaurusTokenForItem(Items.CAKE, 1, 16, 10, 5),
					new GaiaMerchantTrades.HolstaurusTokenForItem(Items.PUMPKIN_PIE, 1, 8, 10, 5),
					new GaiaMerchantTrades.EnchantedItemForEmeralds(Items.IRON_HOE, GaiaRegistry.HOLSTAURUS_TOKEN.get(), 16, 10, 5)
			},
			2, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemForHolstaurusToken(Items.WHEAT, 8, 1, 10, 5),
					new GaiaMerchantTrades.ItemForHolstaurusToken(Items.PUMPKIN, 2, 1, 10, 5),
					new GaiaMerchantTrades.ItemForHolstaurusToken(Items.MELON, 1, 2, 10, 5),
					new GaiaMerchantTrades.ItemForHolstaurusToken(Items.EGG, 8, 1, 10, 5),
					new GaiaMerchantTrades.ItemForHolstaurusToken(Items.SUGAR, 16, 1, 10, 5)
			}));

	public static final Int2ObjectMap<VillagerTrades.ItemListing[]> WERESHEEP_TRADES = toIntMap(ImmutableMap.of(
			1, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.WHITE_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.ORANGE_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.MAGENTA_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.LIGHT_BLUE_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.YELLOW_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.LIME_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.PINK_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.GRAY_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.LIGHT_GRAY_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.CYAN_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.PURPLE_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.BLUE_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.BROWN_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.GREEN_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.RED_WOOL, 1, 1, 10, 5),
					new GaiaMerchantTrades.WeresheepTokenForItem(Items.BLACK_WOOL, 1, 1, 10, 5)
			},
			2, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.WHITE_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.ORANGE_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.MAGENTA_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.LIGHT_BLUE_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.YELLOW_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.LIME_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.PINK_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.GRAY_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.LIGHT_GRAY_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.CYAN_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.PURPLE_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.BLUE_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.BROWN_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.GREEN_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.RED_WOOL, 1, 4, 10, 5),
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.BLACK_WOOL, 1, 4, 10, 5)
			},
			3, new VillagerTrades.ItemListing[]{
					new GaiaMerchantTrades.ItemForWeresheepToken(Items.STRING, 4, 4, 10, 5)
			}));

	static class ItemsToItems implements VillagerTrades.ItemListing {
		private final ItemStack fromItem;
		private final int fromCount;
		private final ItemStack toItem;
		private final int toCount;
		private final int maxUses;
		private final int XP;
		private final float priceMultiplier;

		public ItemsToItems(ItemLike fromItem, int fromCount, ItemLike toItem, int toCount, int maxUses, int xp) {
			this.fromItem = new ItemStack(fromItem);
			this.fromCount = fromCount;
			this.toItem = new ItemStack(toItem);
			this.toCount = toCount;
			this.maxUses = maxUses;
			this.XP = xp;
			this.priceMultiplier = 0.05F;
		}

		@Nullable
		public MerchantOffer getOffer(Entity entity, Random random) {
			return new MerchantOffer(
					new ItemStack(this.fromItem.getItem(), this.fromCount),
					new ItemStack(this.toItem.getItem(), this.toCount),
					this.maxUses, this.XP, this.priceMultiplier);
		}
	}

	static class MerchantTokenForItem extends ItemsToItems {

		public MerchantTokenForItem(ItemLike toItem, int toCount, int tokenCount, int maxUses, int xp) {
			super(GaiaRegistry.TRADER_TOKEN.get(), tokenCount, toItem, toCount, maxUses, xp);
		}
	}

	static class ItemForMerchantToken extends ItemsToItems {

		public ItemForMerchantToken(ItemLike fromItem, int fromCount, int tokenCount, int maxUses, int xp) {
			super(fromItem, fromCount, GaiaRegistry.TRADER_TOKEN.get(), tokenCount, maxUses, xp);
		}
	}

	static class HolstaurusTokenForItem extends ItemsToItems {

		public HolstaurusTokenForItem(ItemLike toItem, int toCount, int tokenCount, int maxUses, int xp) {
			super(GaiaRegistry.TRADER_TOKEN.get(), tokenCount, toItem, toCount, maxUses, xp);
		}
	}

	static class ItemForHolstaurusToken extends ItemsToItems {

		public ItemForHolstaurusToken(ItemLike fromItem, int fromCount, int tokenCount, int maxUses, int xp) {
			super(fromItem, fromCount, GaiaRegistry.HOLSTAURUS_TOKEN.get(), tokenCount, maxUses, xp);
		}
	}

	static class WeresheepTokenForItem extends ItemsToItems {

		public WeresheepTokenForItem(ItemLike toItem, int toCount, int tokenCount, int maxUses, int xp) {
			super(GaiaRegistry.TRADER_TOKEN.get(), tokenCount, toItem, toCount, maxUses, xp);
		}
	}

	static class ItemForWeresheepToken extends ItemsToItems {

		public ItemForWeresheepToken(ItemLike fromItem, int fromCount, int tokenCount, int maxUses, int xp) {
			super(fromItem, fromCount, GaiaRegistry.WERESHEEP_TOKEN.get(), tokenCount, maxUses, xp);
		}
	}

	static class EnchantedItemForEmeralds implements VillagerTrades.ItemListing {
		private final ItemStack itemStack;
		private final ItemLike token;
		private final int tokenCost;
		private final int maxUses;
		private final int XP;
		private final float priceMultiplier;

		public EnchantedItemForEmeralds(Item item, ItemLike token, int tokenCost, int maxUses, int xp) {
			this.itemStack = new ItemStack(item);
			this.token = token;
			this.tokenCost = tokenCost;
			this.maxUses = maxUses;
			this.XP = xp;
			this.priceMultiplier = 0.05F;
		}

		public MerchantOffer getOffer(Entity entity, Random random) {
			int i = 5 + random.nextInt(15);
			ItemStack itemstack = EnchantmentHelper.enchantItem(random, new ItemStack(this.itemStack.getItem()), i, false);
			int j = Math.min(this.tokenCost + i, 64);
			ItemStack tokenStack = new ItemStack(token, j);
			return new MerchantOffer(tokenStack, itemstack, this.maxUses, this.XP, this.priceMultiplier);
		}
	}

	private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> map) {
		return new Int2ObjectOpenHashMap<>(map);
	}
}
