package gaia.datagen.client.compat;

import gaia.GrimoireOfGaia;
import gaia.datagen.server.GaiaAdvancementProvider;
import gaia.registry.GaiaRegistry;
import gaia.registry.helper.MobReg;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import xyz.brassgoggledcoders.patchouliprovider.BookBuilder;
import xyz.brassgoggledcoders.patchouliprovider.CategoryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.EntryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.PatchouliBookProvider;
import xyz.brassgoggledcoders.patchouliprovider.page.EntityPageBuilder;

import java.util.Arrays;
import java.util.function.Consumer;

public class GaiaPatchouliProvider extends PatchouliBookProvider {
	public GaiaPatchouliProvider(DataGenerator gen) {
		super(gen, GrimoireOfGaia.MOD_ID, "en_us");
	}

	@Override
	protected void addBooks(Consumer<BookBuilder> consumer) {
		//Initialize the book builder
		BookBuilder bookBuilder = createBookBuilder("gaiapedia",
				prefix("name"), prefix("landing"))
				.setSubtitle(prefix("subtitle"))
				.setCreativeTab("statues.items")
				.setModel("patchouli:book_red")
				.setBookTexture("patchouli:textures/gui/book_red.png")
				.setShowProgress(true)
//				.setUseBlockyFont(true)
				.setI18n(true)
				.setVersion("Alpha 30")
				.addMacro("$(item)", "$(#b0b)")
				.addMacro("$(mob)", "$(#e50)")
				.addMacro("$(thing)", "$(#490)")
				.setUseResourcePack(true);

		//Info category
		CategoryBuilder assistCategory = bookBuilder.addCategory("assist", prefix("category.assist.name"),
				prefix("category.assist.desc"), new ItemStack(Items.OAK_SAPLING));

		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.CENTAUR, 0.75F, 0.0F,
				Items.LEATHER, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.BAG_ARROWS.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.COBBLE_GOLEM, 1.0F, 0.0F,
				Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get());

		ItemStack sharpnessBook = new ItemStack(Items.ENCHANTED_BOOK);
		EnchantedBookItem.addEnchantment(sharpnessBook, new EnchantmentInstance(Enchantments.SHARPNESS, 1));
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.CYCLOPS, 1.0F, 0.0F,
				new ItemStack(GaiaRegistry.FUR.get()), new ItemStack(Items.IRON_NUGGET),
				new ItemStack(GaiaRegistry.BOX_IRON.get()), sharpnessBook, new ItemStack(GaiaRegistry.KNUCKLES.get()));

		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.DRYAD, 1.0F, 0.0F,
				GaiaRegistry.TAPROOT.get(), Items.DARK_OAK_LOG, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.DOLL_DRYAD_ITEM.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.DWARF, 0.75F, 0.0F,
				GaiaRegistry.BOX_OVERWORLD.get(), GaiaRegistry.BOX_GOLD.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.ENDER_DRAGON_GIRL, 1.0F, 0.0F,
				Items.ENDER_PEARL, Items.GOLD_NUGGET, GaiaRegistry.BOX_END.get(), GaiaRegistry.BAG_BOOK.get(),
				GaiaRegistry.DOLL_ENDER_GIRL_ITEM.get(), GaiaRegistry.ELYTRA_FRAGMENT.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.GOBLIN, 1.0F, 0.0F,
				Items.IRON_NUGGET, GaiaRegistry.MEAT.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.GRYPHON, 0.75F, 0.0F,
				Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.BEE, 1.0F, 0.0F,
				GaiaRegistry.HONEYDEW.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.HUNTER, 1.0F, 0.0F,
				GaiaRegistry.BOX_IRON.get(), GaiaRegistry.BAG_ARROWS.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.MERMAID, 1.0F, 0.0F,
				GaiaRegistry.SHINY_PEARL.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.SATYRESS, 1.0F, 0.0F,
				GaiaRegistry.MEAT.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.VALKYRIE, 1.0F, 0.0F,
				GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get(), GaiaRegistry.DIAMOND_SHARD.get(), GaiaRegistry.EMERALD_SHARD.get(),
				GaiaRegistry.BOX_DIAMOND.get(), GaiaRegistry.BUST_VALKYRIE_ITEM.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.WIZARD_HARPY, 1.0F, 0.0F,
				GaiaRegistry.SOULFIRE.get(), GaiaRegistry.BOOK_OF_MEMORY.get());
		assistCategory = addExtendedMobEntry(assistCategory, "assist", GaiaRegistry.YUKI_ONNA, 1.0F, 0.0F,
				GaiaRegistry.FUR.get(), GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.FAN_ICE.get());

		bookBuilder = assistCategory.build();

		//Hostile category
		CategoryBuilder hostileCategory = bookBuilder.addCategory("hostile", prefix("category.hostile.name"),
				prefix("category.hostile.desc"), "minecraft:stone_axe");

		ItemStack lootingBook = new ItemStack(Items.ENCHANTED_BOOK);
		EnchantedBookItem.addEnchantment(lootingBook, new EnchantmentInstance(Enchantments.MOB_LOOTING, 1));
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.ANT_SALVAGER, 0.5F, -0.5F,
				new ItemStack(GaiaRegistry.MEAT.get()), new ItemStack(Items.IRON_NUGGET), new ItemStack(GaiaRegistry.BAG_BOOK.get()), lootingBook);

		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.ANT_WORKER, 1.0F, 0.0F,
				Items.GREEN_DYE, GaiaRegistry.HONEYDEW.get(), Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.ANUBIS, 1.0F, 0.0F,
				Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.BOOK_OF_MEMORY.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.ARACHNE, 1.0F, 0.0F,
				GaiaRegistry.STONE_COAL.get(), Items.GOLD_NUGGET, GaiaRegistry.BOX_OVERWORLD.get(), GaiaRegistry.BOOK_OF_MEMORY.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.BANSHEE, 0.8F, 0.0F,
				GaiaRegistry.SOULFIRE.get(), Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.WEAPON_BOOK_NIGHTMARE.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.BEHENDER, 1.0F, -0.5F,
				Items.ENDER_PEARL, Items.GOLD_NUGGET, GaiaRegistry.BOX_END.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.WEAPON_BOOK_ENDER.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.BONE_KNIGHT, 1.0F, 0.0F,
				Items.REDSTONE, Items.GOLD_NUGGET, GaiaRegistry.BOX_OVERWORLD.get(), Items.REDSTONE_BLOCK, Items.SKELETON_SKULL);

		ItemStack fishingLuckBook = new ItemStack(Items.ENCHANTED_BOOK);
		EnchantedBookItem.addEnchantment(fishingLuckBook, new EnchantmentInstance(Enchantments.FISHING_LUCK, 1));
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.CECAELIA, 1.0F, 0.0F,
				new ItemStack(GaiaRegistry.SHINY_PEARL.get()), new ItemStack(Items.CLAY), new ItemStack(Items.IRON_NUGGET), fishingLuckBook);

		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.COBBLESTONE_GOLEM, 1.0F, 0.0F,
				Items.IRON_NUGGET, Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(),
				GaiaRegistry.CHEST_JUNGLE.get(), GaiaRegistry.TOTEM_FRAGMENT.get(), GaiaRegistry.WEAPON_BOOK_METAL.get());

		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.CREEP, 0.5F, 0.0F,
				Items.GUNPOWDER, Items.IRON_NUGGET, GaiaRegistry.BOX_OVERWORLD.get(), GaiaRegistry.DOLL_CREEPER_GIRL_ITEM.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.DEATHWORD, 1.0F, 0.0F,
				Items.PAPER, Items.BOOK, Items.IRON_NUGGET, GaiaRegistry.BOX_OVERWORLD.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.WEAPON_BOOK.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.DULLAHAN, 1.0F, 0.0F,
				GaiaRegistry.SOULFIRE.get(), Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.DOLL_DULLAHAN_ITEM.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.ENDER_EYE, 1.0F, 0.0F,
				Items.ENDER_PEARL, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.DOLL_ENDER_GIRL_ITEM.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.FLESH_LICH, 1.0F, 0.0F,
				Items.LAPIS_LAZULI, Items.GOLD_NUGGET, GaiaRegistry.BOX_OVERWORLD.get(), Items.LAPIS_BLOCK, Items.ZOMBIE_HEAD);
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.GELATINOUS_SLIME, 0.5F, 0.0F,
				Items.SLIME_BALL, Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.DOLL_SLIME_GIRL_ITEM.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.GOBLIN_FERAL, 1.0F, 0.0F,
				Items.IRON_NUGGET);
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.HARPY, 1.0F, 0.0F,
				Items.FEATHER, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.DECO_NEST_HARPY_ITEM.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.KOBOLD, 1.0F, 0.0F,
				GaiaRegistry.FUR.get(), Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.BAG_ARROWS.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.MATANGO, 1.0F, 0.0F,
				Items.RED_MUSHROOM, Items.BROWN_MUSHROOM, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get());
		hostileCategory = addExtendedLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.MIMIC, 1.0F, 0.0F,
				Items.IRON_NUGGET, GaiaRegistry.BOX_OVERWORLD.get(), GaiaRegistry.PREMIUM_MONSTER_FEED.get(),
				GaiaRegistry.BAG_RECORD.get(), GaiaRegistry.WEAPON_BOOK_HUNGER.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.MINOTAURUS, 1.0F, 0.0F,
				Items.LEATHER, Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.WEAPON_BOOK_BATTLE.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.NAGA, 1.0F, 0.0F,
				Items.COD, Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.NINE_TAILS, 1.0F, 0.0F,
				GaiaRegistry.SOULFIRE.get(), Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(),
				GaiaRegistry.FAN_FIRE.get(), GaiaRegistry.DOLL_NINE_TAILS_ITEM.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.ONI, 1.0F, 0.0F,
				new ItemStack(GaiaRegistry.SOULFIRE.get()), new ItemStack(Items.IRON_NUGGET), new ItemStack(GaiaRegistry.BOX_IRON.get()), sharpnessBook);
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.ORC, 1.0F, 0.0F,
				GaiaRegistry.MEAT.get(), Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.BAG_BOOK.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SHAMAN, 0.75F, 0.0F,
				GaiaRegistry.ROTTEN_HEART.get(), Items.IRON_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(),
				GaiaRegistry.BOOK_OF_MEMORY.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SHARKO, 1.0F, 0.0F,
				GaiaRegistry.SHINY_PEARL.get(), Items.PRISMARINE_SHARD, Items.GOLD_NUGGET, GaiaRegistry.BOX_OVERWORLD.get(),
				GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.WEAPON_BOOK_BUFF.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SIREN, 1.0F, 0.0F,
				Items.COD, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get(), GaiaRegistry.BAG_ARROWS.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SLUDGE_GIRL, 0.9F, 0.0F,
				Items.SLIME_BALL, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SPHINX, 1.0F, 0.0F,
				GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get(), GaiaRegistry.DIAMOND_SHARD.get(), GaiaRegistry.EMERALD_SHARD.get(),
				GaiaRegistry.BOX_DIAMOND.get(), GaiaRegistry.BUST_SPHINX_ITEM.get(), GaiaRegistry.CHEST_DESERT.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SPORELING, 1.0F, 0.0F,
				Items.AIR);
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SPRIGGAN, 1.0F, 0.0F,
				GaiaRegistry.TAPROOT.get(), Items.OAK_LOG, Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(),
				GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.WEAPON_BOOK_NATURE.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.SUCCUBUS, 1.0F, 0.0F,
				GaiaRegistry.FIRESHARD.get(), Items.QUARTZ, Items.GLOWSTONE_DUST, Items.IRON_NUGGET, GaiaRegistry.BOX_NETHER.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.TOAD, 1.0F, 0.0F,
				Items.SLIME_BALL, Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.WERECAT, 1.0F, 0.0F,
				GaiaRegistry.MEAT.get(), Items.IRON_NUGGET, GaiaRegistry.BOX_IRON.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.WITCH, 0.75F, 0.0F,
				GaiaRegistry.NETHER_WART_JAM.get(), Items.GOLD_NUGGET, GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(),
				GaiaRegistry.BOOK_OF_MEMORY.get(), GaiaRegistry.DECO_MANDRAGORA_POT_ITEM.get());
		hostileCategory = addLockedMobEntry(hostileCategory, "hostile", GaiaRegistry.WITHER_COW, 1.0F, 0.0F,
				GaiaRegistry.WITHERED_BRAIN.get(), Items.QUARTZ, Items.GLOWSTONE_DUST, Items.IRON_NUGGET, GaiaRegistry.BOX_NETHER.get());

		bookBuilder = hostileCategory.build();

//		assistCategory = addMobEntry(assistCategory, "hostile", GaiaRegistry.COBBLESTONE_GOLEM,
//				GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get());
//		assistCategory = addMobEntry(assistCategory, "hostile", GaiaRegistry.SPHINX,
//				GaiaRegistry.HONEYDEW.get(), GaiaRegistry.BOX_IRON.get());
//		assistCategory = addMobEntry(assistCategory, "hostile", GaiaRegistry.SLUDGE_GIRL);

		//Finish book
		bookBuilder.build(consumer);
	}

	private CategoryBuilder addMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
										boolean extraPage, float scale, float offset, ItemStack... drops) {
		String path = mobReg.getName();
		String entryPrefix = "entry." + path;
		//Add Entry
		EntryBuilder entryBuilder = builder.addEntry(category + "/" + path, prefix(entryPrefix + ".name"),
						mobReg.getSpawnEgg().getId().toString())
				.addTextPage(prefix(entryPrefix + ".info")).build();
		EntityPageBuilder entityBuilder = entryBuilder.addEntityPage(mobReg.getEntityType().getRegistryName()).setText(prefix(entryPrefix + ".info2"));
		if (scale != 1.0F) {
			entityBuilder.setScale(scale);
		}
		if (offset != 0.0F) {
			entityBuilder.setOffset(offset);
		}
		entityBuilder.build();
		if (extraPage) {
			entryBuilder.addTextPage(prefix(entryPrefix + ".info3")).build();
		}
		for (ItemStack stack : drops) {
			if (stack.getItem() == Items.AIR) break;
			entryBuilder.addSpotlightPage(stack)
					.setLinkRecipe(true)
					.setText(prefix("drop." + stack.getItem().getRegistryName().getPath() + ".info"))
					.build();
		}

		return entryBuilder.build();
	}

	private CategoryBuilder addMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
										float scale, float offset, ItemStack... drops) {
		return addMobEntry(builder, category, mobReg, false, scale, offset, drops);
	}

	private CategoryBuilder addMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
										float scale, float offset, Item... drops) {
		return addMobEntry(builder, category, mobReg, false, scale, offset,
				Arrays.stream(drops).map(item -> new ItemStack(item)).toList().toArray(new ItemStack[]{}));
	}

	private CategoryBuilder addExtendedMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
												float scale, float offset, Item... drops) {
		return addMobEntry(builder, category, mobReg, true, scale, offset,
				Arrays.stream(drops).map(item -> new ItemStack(item)).toList().toArray(new ItemStack[]{}));
	}

	private CategoryBuilder addLockedMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
											  boolean extraPage, float scale, float offset, ItemStack... drops) {
		String path = mobReg.getName();
		String entryPrefix = "entry." + path;
		String advancement = GaiaAdvancementProvider.entityTypeAdvancementMap.get(mobReg.getEntityType()).getId().toString();
		//Add Entry
		EntryBuilder entryBuilder = builder.addEntry(category + "/" + path, prefix(entryPrefix + ".name"),
						mobReg.getSpawnEgg().getId().toString())
				.setAdvancement(advancement)
				.addTextPage(prefix(entryPrefix + ".info")).build();

		EntityPageBuilder entityBuilder = entryBuilder.addEntityPage(mobReg.getEntityType().getRegistryName()).setText(prefix(entryPrefix + ".info2"));
		if (scale != 1.0F) {
			entityBuilder.setScale(scale);
		}
		if (offset != 0.0F) {
			entityBuilder.setOffset(offset);
		}
		entityBuilder.build();
		if (extraPage) {
			entryBuilder.addTextPage(prefix(entryPrefix + ".info3")).build();
		}
		for (ItemStack stack : drops) {
			if (stack.getItem() == Items.AIR) break;
			entryBuilder.addSpotlightPage(stack)
					.setLinkRecipe(true)
					.setText(prefix("drop." + stack.getItem().getRegistryName().getPath() + ".info"))
					.build();
		}

		return entryBuilder.build();
	}

	private CategoryBuilder addLockedMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
											  float scale, float offset, ItemStack... drops) {
		return addLockedMobEntry(builder, category, mobReg, false, scale, offset, drops);
	}

	private CategoryBuilder addLockedMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
											  float scale, float offset, Item... drops) {
		return addLockedMobEntry(builder, category, mobReg, false, scale, offset,
				Arrays.stream(drops).map(item -> new ItemStack(item)).toList().toArray(new ItemStack[]{}));
	}

	private CategoryBuilder addExtendedLockedMobEntry(CategoryBuilder builder, String category, MobReg<? extends LivingEntity> mobReg,
													  float scale, float offset, Item... drops) {
		return addLockedMobEntry(builder, category, mobReg, true, scale, offset,
				Arrays.stream(drops).map(item -> new ItemStack(item)).toList().toArray(new ItemStack[]{}));
	}

	private String prefix(String name) {
		return "info.grimoireofgaia.book." + name;
	}
}
