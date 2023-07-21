package gaia.datagen.client;

import gaia.GrimoireOfGaia;
import gaia.item.MerchantSpawnItem;
import gaia.registry.GaiaRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class GaiaItemModels extends ItemModelProvider {
	public GaiaItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, GrimoireOfGaia.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		for (RegistryObject<Item> item : GaiaRegistry.ITEMS.getEntries()) {
			if (item.get() instanceof MerchantSpawnItem) {
				this.spawnItem(item.get());
			} else if (item.get() instanceof ForgeSpawnEggItem) {
				this.withExistingParent(item.get().getRegistryName().getPath(), new ResourceLocation("item/template_spawn_egg"));
			}
		}

		this.withBlockParent(GaiaRegistry.BUST_GORGON.get());
		this.withBlockParent(GaiaRegistry.BUST_MINOTAUR.get());
		this.withBlockParent(GaiaRegistry.BUST_SPHINX.get());
		this.withBlockParent(GaiaRegistry.BUST_VALKYRIE.get());
		this.withBlockParent(GaiaRegistry.BUST_VAMPIRE.get());
		this.withBlockParent(GaiaRegistry.DECO_GARDEN_GNOME.get());
		this.withBlockParent(GaiaRegistry.DECO_MANDRAGORA_POT.get());
		this.withBlockParent(GaiaRegistry.DECO_NEST_HARPY.get());
		this.withBlockParent(GaiaRegistry.DOLL_CREEPER_GIRL.get());
		this.withBlockParent(GaiaRegistry.DOLL_DRYAD.get());
		this.withBlockParent(GaiaRegistry.DOLL_DULLAHAN.get());
		this.withBlockParent(GaiaRegistry.DOLL_ENDER_GIRL.get());
		this.withBlockParent(GaiaRegistry.DOLL_MAID.get());
		this.withBlockParent(GaiaRegistry.DOLL_MERMAID.get());
		this.withBlockParent(GaiaRegistry.DOLL_NINE_TAILS.get());
		this.withBlockParent(GaiaRegistry.DOLL_SLIME_GIRL.get());
		this.withBlockParent(GaiaRegistry.PEARL_BLOCK.get());

		this.generatedItem(GaiaRegistry.BOOK_OF_MEMORY.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_FREEZING.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_NIGHTMARE.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_METAL.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_ENDER.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_HUNGER.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_BATTLE.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_NATURE.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_WITHER.get());
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_BUFF.get());
		this.handheldItem(GaiaRegistry.CURSED_METAL_SWORD.get(), "weapon");
		this.handheldItem(GaiaRegistry.METAL_CLUB.get(), "weapon");
		this.generatedItem(GaiaRegistry.EXPERIENCE_IRON.get());
		this.generatedItem(GaiaRegistry.EXPERIENCE_GOLD.get());
		this.generatedItem(GaiaRegistry.EXPERIENCE_DIAMOND.get());
		this.generatedItem(GaiaRegistry.ELYTRA_FRAGMENT.get());
		this.generatedItem(GaiaRegistry.TOTEM_FRAGMENT.get());
		this.generatedItem(GaiaRegistry.DIAMOND_SHARD.get());
		this.generatedItem(GaiaRegistry.EMERALD_SHARD.get());
		this.generatedItem(GaiaRegistry.SHINY_PEARL.get());
		this.generatedItem(GaiaRegistry.FIRESHARD.get());
		this.generatedItem(GaiaRegistry.FUR.get());
		this.generatedItem(GaiaRegistry.GIGA_GEAR.get());
		this.generatedItem(GaiaRegistry.GOLDEN_APPLE_PIE.get());
		this.generatedItem(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get());
		this.generatedItem(GaiaRegistry.MANDRAKE.get());
		this.generatedItem(GaiaRegistry.HONEYDEW.get());
		this.generatedItem(GaiaRegistry.KNUCKLES.get(), "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_SPEED.get(), "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_HASTE.get(), "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_JUMP.get(), "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_NIGHT.get(), "accessory");
		this.generatedItem(GaiaRegistry.HEAVY_BARBELL.get(), "accessory");
		this.generatedItem(GaiaRegistry.MEAT.get());
		this.generatedItem(GaiaRegistry.MONSTER_FEED.get());
		this.generatedItem(GaiaRegistry.PREMIUM_MONSTER_FEED.get());
		this.handheldItem(GaiaRegistry.METAL_DAGGER.get(), "weapon");
		this.generatedItem(GaiaRegistry.QUILL.get());
		this.generatedItem(GaiaRegistry.ROTTEN_HEART.get());
		this.generatedItem(GaiaRegistry.SOULFIRE.get());
		this.generatedItem(GaiaRegistry.STONE_COAL.get());
		this.generatedItem(GaiaRegistry.TAPROOT.get());
		this.handheldItem(GaiaRegistry.ZOMBIE_STAFF.get(), "weapon", "summoning_staff");
		this.handheldItem(GaiaRegistry.SKELETON_STAFF.get(), "weapon", "summoning_staff");
		this.handheldItem(GaiaRegistry.CAVE_SPIDER_STAFF.get(), "weapon", "summoning_staff");
		this.handheldItem(GaiaRegistry.MAGIC_STAFF.get(), "weapon", "summoning_staff");
		this.parentItem(GaiaRegistry.FAN_FIRE.get(), modLoc("item/fan"), "weapon/fan");
		this.parentItem(GaiaRegistry.FAN_ICE.get(), modLoc("item/fan"), "weapon/fan");
		this.generatedItem(GaiaRegistry.NETHER_WART_JAM.get());
		this.generatedItem(GaiaRegistry.WITHERED_BRAIN.get());

		this.generatedBox(GaiaRegistry.BOX_DIAMOND.get());
		this.generatedBox(GaiaRegistry.BOX_END.get());
		this.generatedBox(GaiaRegistry.BOX_GOLD.get());
		this.generatedBox(GaiaRegistry.BOX_IRON.get());
		this.generatedBox(GaiaRegistry.BOX_NETHER.get());
		this.generatedBox(GaiaRegistry.BOX_OVERWORLD.get());
		this.generatedBox(GaiaRegistry.CHEST_DESERT.get());
		this.generatedBox(GaiaRegistry.CHEST_DUNGEON.get());
		this.generatedBox(GaiaRegistry.CHEST_JUNGLE.get());
		this.generatedItem(GaiaRegistry.BAG_ARROWS.get(), "bag");
		this.generatedItem(GaiaRegistry.BAG_BOOK.get(), "bag");
		this.generatedItem(GaiaRegistry.BAG_RECORD.get(), "bag");
		this.generatedItem(GaiaRegistry.BOX_HAT.get(), "box");
		this.generatedItem(GaiaRegistry.BOX_OLD.get(), "box");
		this.generatedItem(GaiaRegistry.BOX_EGG.get(), "spawn");

		this.generatedItem(GaiaRegistry.TRADER_TOKEN.get());
		this.generatedItem(GaiaRegistry.HOLSTAURUS_TOKEN.get());
		this.generatedItem(GaiaRegistry.WERESHEEP_TOKEN.get());
	}

	private void withBlockParent(Block block) {
		ResourceLocation location = block.getRegistryName();
		withExistingParent(location.getPath(), modLoc("block/" + location.getPath()));
	}

	private void generatedItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), new ResourceLocation("item/generated"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + location.getPath()));
	}

	private void spawnItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), new ResourceLocation("item/generated"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/spawn/" + location.getPath()));
	}

	private void handheldItem(Item item, String subFolder) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + location.getPath()));
	}

	private void handheldItem(Item item, String subFolder, String textureName) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + textureName));
	}

	private void generatedItem(Item item, String subFolder) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), new ResourceLocation("item/generated"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + location.getPath()));
	}

	private void parentItem(Item item, ResourceLocation parent, String subFolder) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), parent,
				"0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + location.getPath()));
	}

	private void generatedBox(Item item) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/chest"),
				"0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/box/" + location.getPath()));
	}

	private void generatedBook(Item item) {
		ResourceLocation location = item.getRegistryName();
		singleTexture(location.getPath(), new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/weapon_book"),
				"0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/weapon/book/" + location.getPath()));
	}
}
