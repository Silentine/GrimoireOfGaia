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
				this.spawnItem(item);
			} else if (item.get() instanceof ForgeSpawnEggItem) {
				this.withExistingParent(item.getId().getPath(), new ResourceLocation("item/template_spawn_egg"));
			}
		}

		this.withBlockParent(GaiaRegistry.BUST_GORGON);
		this.withBlockParent(GaiaRegistry.BUST_MINOTAUR);
		this.withBlockParent(GaiaRegistry.BUST_SPHINX);
		this.withBlockParent(GaiaRegistry.BUST_VALKYRIE);
		this.withBlockParent(GaiaRegistry.BUST_VAMPIRE);
		this.withBlockParent(GaiaRegistry.DECO_GARDEN_GNOME);
		this.withBlockParent(GaiaRegistry.DECO_MANDRAGORA_POT);
		this.withBlockParent(GaiaRegistry.DECO_NEST_HARPY);
		this.withBlockParent(GaiaRegistry.DOLL_CREEPER_GIRL);
		this.withBlockParent(GaiaRegistry.DOLL_DRYAD);
		this.withBlockParent(GaiaRegistry.DOLL_DULLAHAN);
		this.withBlockParent(GaiaRegistry.DOLL_ENDER_GIRL);
		this.withBlockParent(GaiaRegistry.DOLL_MAID);
		this.withBlockParent(GaiaRegistry.DOLL_MERMAID);
		this.withBlockParent(GaiaRegistry.DOLL_NINE_TAILS);
		this.withBlockParent(GaiaRegistry.DOLL_SLIME_GIRL);
		this.withBlockParent(GaiaRegistry.PEARL_BLOCK);

		this.generatedItem(GaiaRegistry.BOOK_OF_MEMORY);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_FREEZING);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_NIGHTMARE);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_METAL);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_ENDER);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_HUNGER);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_BATTLE);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_NATURE);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_WITHER);
		this.generatedBook(GaiaRegistry.WEAPON_BOOK_BUFF);
		this.handheldItem(GaiaRegistry.CURSED_METAL_SWORD, "weapon");
		this.handheldItem(GaiaRegistry.METAL_CLUB, "weapon");
		this.generatedItem(GaiaRegistry.EXPERIENCE_IRON);
		this.generatedItem(GaiaRegistry.EXPERIENCE_GOLD);
		this.generatedItem(GaiaRegistry.EXPERIENCE_DIAMOND);
		this.generatedItem(GaiaRegistry.ELYTRA_FRAGMENT);
		this.generatedItem(GaiaRegistry.TOTEM_FRAGMENT);
		this.generatedItem(GaiaRegistry.DIAMOND_SHARD);
		this.generatedItem(GaiaRegistry.EMERALD_SHARD);
		this.generatedItem(GaiaRegistry.SHINY_PEARL);
		this.generatedItem(GaiaRegistry.FIRESHARD);
		this.generatedItem(GaiaRegistry.FUR);
		this.generatedItem(GaiaRegistry.GIGA_GEAR);
		this.generatedItem(GaiaRegistry.GOLDEN_APPLE_PIE);
		this.generatedItem(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE);
		this.generatedItem(GaiaRegistry.MANDRAKE);
		this.generatedItem(GaiaRegistry.HONEYDEW);
		this.generatedItem(GaiaRegistry.KNUCKLES, "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_SPEED, "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_HASTE, "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_JUMP, "accessory");
		this.generatedItem(GaiaRegistry.RING_OF_NIGHT, "accessory");
		this.generatedItem(GaiaRegistry.HEAVY_BARBELL, "accessory");
		this.generatedItem(GaiaRegistry.MEAT);
		this.generatedItem(GaiaRegistry.MONSTER_FEED);
		this.generatedItem(GaiaRegistry.PREMIUM_MONSTER_FEED);
		this.handheldItem(GaiaRegistry.METAL_DAGGER, "weapon");
		this.generatedItem(GaiaRegistry.QUILL);
		this.generatedItem(GaiaRegistry.ROTTEN_HEART);
		this.generatedItem(GaiaRegistry.SOULFIRE);
		this.generatedItem(GaiaRegistry.STONE_COAL);
		this.generatedItem(GaiaRegistry.TAPROOT);
		this.handheldItem(GaiaRegistry.ZOMBIE_STAFF, "weapon", "summoning_staff");
		this.handheldItem(GaiaRegistry.SKELETON_STAFF, "weapon", "summoning_staff");
		this.handheldItem(GaiaRegistry.CAVE_SPIDER_STAFF, "weapon", "summoning_staff");
		this.handheldItem(GaiaRegistry.MAGIC_STAFF, "weapon", "summoning_staff");
		this.parentItem(GaiaRegistry.FAN_FIRE, modLoc("item/fan"), "weapon/fan");
		this.parentItem(GaiaRegistry.FAN_ICE, modLoc("item/fan"), "weapon/fan");
		this.generatedItem(GaiaRegistry.NETHER_WART_JAM);
		this.generatedItem(GaiaRegistry.WITHERED_BRAIN);

		this.generatedBox(GaiaRegistry.BOX_DIAMOND);
		this.generatedBox(GaiaRegistry.BOX_END);
		this.generatedBox(GaiaRegistry.BOX_GOLD);
		this.generatedBox(GaiaRegistry.BOX_IRON);
		this.generatedBox(GaiaRegistry.BOX_NETHER);
		this.generatedBox(GaiaRegistry.BOX_OVERWORLD);
		this.generatedBox(GaiaRegistry.CHEST_DESERT);
		this.generatedBox(GaiaRegistry.CHEST_DUNGEON);
		this.generatedBox(GaiaRegistry.CHEST_JUNGLE);
		this.generatedItem(GaiaRegistry.BAG_ARROWS, "bag");
		this.generatedItem(GaiaRegistry.BAG_BOOK, "bag");
		this.generatedItem(GaiaRegistry.BAG_RECORD, "bag");
		this.generatedItem(GaiaRegistry.BOX_HAT, "box");
		this.generatedItem(GaiaRegistry.BOX_OLD, "box");
		this.generatedItem(GaiaRegistry.BOX_EGG, "spawn");

		this.generatedItem(GaiaRegistry.TRADER_TOKEN);
		this.generatedItem(GaiaRegistry.HOLSTAURUS_TOKEN);
		this.generatedItem(GaiaRegistry.WERESHEEP_TOKEN);
	}

	private void withBlockParent(RegistryObject<Block> registryObject) {
		ResourceLocation location = registryObject.getId();
		withExistingParent(location.getPath(), modLoc("block/" + location.getPath()));
	}

	private void generatedItem(RegistryObject<Item> registryObject) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), new ResourceLocation("item/generated"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + location.getPath()));
	}

	private void spawnItem(RegistryObject<Item> registryObject) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), new ResourceLocation("item/generated"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/spawn/" + location.getPath()));
	}

	private void handheldItem(RegistryObject<Item> registryObject, String subFolder) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + location.getPath()));
	}

	private void handheldItem(RegistryObject<Item> registryObject, String subFolder, String textureName) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + textureName));
	}

	private void generatedItem(RegistryObject<Item> registryObject, String subFolder) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), new ResourceLocation("item/generated"),
				"layer0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + location.getPath()));
	}

	private void parentItem(RegistryObject<Item> registryObject, ResourceLocation parent, String subFolder) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), parent,
				"0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/" + subFolder + "/" + location.getPath()));
	}

	private void generatedBox(RegistryObject<Item> registryObject) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/chest"),
				"0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/box/" + location.getPath()));
	}

	private void generatedBook(RegistryObject<Item> registryObject) {
		ResourceLocation location = registryObject.getId();
		singleTexture(location.getPath(), new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/weapon_book"),
				"0", new ResourceLocation(GrimoireOfGaia.MOD_ID, "item/weapon/book/" + location.getPath()));
	}
}
