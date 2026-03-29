package gaia.datagen.client;

import gaia.GrimoireOfGaia;
import gaia.item.MerchantSpawnItem;
import gaia.registry.GaiaRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class GaiaModels extends ModelProvider {
	public GaiaModels(PackOutput packOutput) {
		super(packOutput, GrimoireOfGaia.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		generateHorizontal(blockModels, GaiaRegistry.BUST_GORGON);
		generateHorizontal(blockModels, GaiaRegistry.BUST_MINOTAUR);
		generateHorizontal(blockModels, GaiaRegistry.BUST_SPHINX);
		generateHorizontal(blockModels, GaiaRegistry.BUST_VALKYRIE);
		generateHorizontal(blockModels, GaiaRegistry.BUST_VAMPIRE);
		generateHorizontal(blockModels, GaiaRegistry.DECO_GARDEN_GNOME);
		generateHorizontal(blockModels, GaiaRegistry.DECO_MANDRAGORA_POT);
		generateHorizontal(blockModels, GaiaRegistry.DECO_NEST_HARPY);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_CREEPER_GIRL);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_DRYAD);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_DULLAHAN);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_ENDER_GIRL);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_MAID);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_MERMAID);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_NINE_TAILS);
		generateHorizontal(blockModels, GaiaRegistry.DOLL_SLIME_GIRL);
		blockModels.createTrivialBlock(GaiaRegistry.PEARL_BLOCK.get(), TexturedModel.TOP_BOTTOM_WITH_WALL);

		for (DeferredHolder<Item, ? extends Item> item : GaiaRegistry.ITEMS.getEntries()) {
			if (item.get() instanceof MerchantSpawnItem) {
				this.spawnItem(itemModels, item);
			} else if (item.get() instanceof SpawnEggItem) {
				itemModels.generateFlatItem(item.get(), Items.EGG, ModelTemplates.FLAT_ITEM);
//				this.withExistingParent(item.getId().getPath(), Identifier.parse("item/template_spawn_egg"));
			}
		}

		itemModels.declareCustomModelItem(GaiaRegistry.BROOM.get());
		itemModels.declareCustomModelItem(GaiaRegistry.WEAPON_BOOK.get());
		itemModels.declareCustomModelItem(GaiaRegistry.MINOTAUR_HAMMER.get());
		itemModels.declareCustomModelItem(GaiaRegistry.HEADGEAR_BOOK.get());
		itemModels.declareCustomModelItem(GaiaRegistry.HEADGEAR_MOB.get());
		itemModels.declareCustomModelItem(GaiaRegistry.HEADGEAR_BOLT.get());
		itemModels.declareCustomModelItem(GaiaRegistry.HEADGEAR_ARROW.get());
		itemModels.declareCustomModelItem(GaiaRegistry.HEADGEAR_DOLL.get());
		itemModels.declareCustomModelItem(GaiaRegistry.HEADGEAR_EARS_ELF.get());
		itemModels.declareCustomModelItem(GaiaRegistry.SEASHELL_HAIRPIN.get());
		itemModels.declareCustomModelItem(GaiaRegistry.PROJECTILE_MAGIC.get());
		itemModels.declareCustomModelItem(GaiaRegistry.PROJECTILE_RANDOM_MAGIC.get());
		itemModels.declareCustomModelItem(GaiaRegistry.PROJECTILE_WEB.get());
		itemModels.declareCustomModelItem(GaiaRegistry.PROJECTILE_BOMB.get());
		itemModels.declareCustomModelItem(GaiaRegistry.PROJECTILE_POISON.get());
		itemModels.declareCustomModelItem(GaiaRegistry.PROJECTILE_BUBBLE.get());
		itemModels.declareCustomModelItem(GaiaRegistry.FAN.get());
		itemModels.generateShield(GaiaRegistry.STONE_SHIELD.get());
		itemModels.generateShield(GaiaRegistry.IRON_SHIELD.get());
		itemModels.generateShield(GaiaRegistry.GOLD_SHIELD.get());
		itemModels.generateShield(GaiaRegistry.BONE_SHIELD.get());

		this.generatedItem(itemModels, GaiaRegistry.BOOK_OF_MEMORY);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_FREEZING);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_NIGHTMARE);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_METAL);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_ENDER);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_HUNGER);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_BATTLE);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_NATURE);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_WITHER);
		this.generatedBook(itemModels, GaiaRegistry.WEAPON_BOOK_BUFF);
		this.handheldItem(itemModels, GaiaRegistry.CURSED_METAL_SWORD);
		this.handheldItem(itemModels, GaiaRegistry.METAL_CLUB);
		this.generatedItem(itemModels, GaiaRegistry.EXPERIENCE_IRON);
		this.generatedItem(itemModels, GaiaRegistry.EXPERIENCE_GOLD);
		this.generatedItem(itemModels, GaiaRegistry.EXPERIENCE_DIAMOND);
		this.generatedItem(itemModels, GaiaRegistry.ELYTRA_FRAGMENT);
		this.generatedItem(itemModels, GaiaRegistry.TOTEM_FRAGMENT);
		this.generatedItem(itemModels, GaiaRegistry.DIAMOND_SHARD);
		this.generatedItem(itemModels, GaiaRegistry.EMERALD_SHARD);
		this.generatedItem(itemModels, GaiaRegistry.SHINY_PEARL);
		this.generatedItem(itemModels, GaiaRegistry.FIRESHARD);
		this.generatedItem(itemModels, GaiaRegistry.FUR);
		this.generatedItem(itemModels, GaiaRegistry.GIGA_GEAR);
		this.generatedItem(itemModels, GaiaRegistry.GOLDEN_APPLE_PIE);
		this.generatedItem(itemModels, GaiaRegistry.GOLDEN_APPLE_PIE_SLICE);
		this.generatedItem(itemModels, GaiaRegistry.MANDRAKE);
		this.generatedItem(itemModels, GaiaRegistry.HONEYDEW);
		this.generatedItem(itemModels, GaiaRegistry.KNUCKLES);
		this.generatedItem(itemModels, GaiaRegistry.RING_OF_SPEED);
		this.generatedItem(itemModels, GaiaRegistry.RING_OF_HASTE);
		this.generatedItem(itemModels, GaiaRegistry.RING_OF_JUMP);
		this.generatedItem(itemModels, GaiaRegistry.RING_OF_NIGHT);
		this.generatedItem(itemModels, GaiaRegistry.HEAVY_BARBELL);
		this.generatedItem(itemModels, GaiaRegistry.MEAT);
		this.generatedItem(itemModels, GaiaRegistry.MONSTER_FEED);
		this.generatedItem(itemModels, GaiaRegistry.PREMIUM_MONSTER_FEED);
		this.handheldItem(itemModels, GaiaRegistry.METAL_DAGGER);
		this.generatedItem(itemModels, GaiaRegistry.QUILL);
		this.generatedItem(itemModels, GaiaRegistry.ROTTEN_HEART);
		this.generatedItem(itemModels, GaiaRegistry.SOULFIRE);
		this.generatedItem(itemModels, GaiaRegistry.STONE_COAL);
		this.generatedItem(itemModels, GaiaRegistry.TAPROOT);

		this.handheldItem(itemModels, GaiaRegistry.ZOMBIE_STAFF);
		this.handheldItem(itemModels, GaiaRegistry.SKELETON_STAFF);
		this.handheldItem(itemModels, GaiaRegistry.CAVE_SPIDER_STAFF);
		this.handheldItem(itemModels, GaiaRegistry.MAGIC_STAFF);

		this.parentItem(itemModels, GaiaRegistry.FAN_FIRE, modLocation("fan"));
		this.parentItem(itemModels, GaiaRegistry.FAN_ICE, modLocation("fan"));
		this.generatedItem(itemModels, GaiaRegistry.NETHER_WART_JAM);
		this.generatedItem(itemModels, GaiaRegistry.WITHERED_BRAIN);

		this.generatedBox(itemModels, GaiaRegistry.BOX_DIAMOND);
		this.generatedBox(itemModels, GaiaRegistry.BOX_END);
		this.generatedBox(itemModels, GaiaRegistry.BOX_GOLD);
		this.generatedBox(itemModels, GaiaRegistry.BOX_IRON);
		this.generatedBox(itemModels, GaiaRegistry.BOX_NETHER);
		this.generatedBox(itemModels, GaiaRegistry.BOX_OVERWORLD);
		this.generatedBox(itemModels, GaiaRegistry.CHEST_DESERT);
		this.generatedBox(itemModels, GaiaRegistry.CHEST_DUNGEON);
		this.generatedBox(itemModels, GaiaRegistry.CHEST_JUNGLE);
		this.generatedItem(itemModels, GaiaRegistry.BAG_ARROWS);
		this.generatedItem(itemModels, GaiaRegistry.BAG_BOOK);
		this.generatedItem(itemModels, GaiaRegistry.BAG_RECORD);
		this.generatedItem(itemModels, GaiaRegistry.BOX_HAT);
		this.generatedItem(itemModels, GaiaRegistry.BOX_OLD);
		this.generatedItem(itemModels, GaiaRegistry.BOX_EGG);

		this.generatedItem(itemModels, GaiaRegistry.TRADER_TOKEN);
		this.generatedItem(itemModels, GaiaRegistry.HOLSTAURUS_TOKEN);
		this.generatedItem(itemModels, GaiaRegistry.WERESHEEP_TOKEN);
	}

	private static void generateHorizontal(BlockModelGenerators blockModels, DeferredHolder<Block, ? extends Block> registryObject) {
		blockModels.blockStateOutput.accept(
				MultiVariantGenerator.dispatch(
						registryObject.get(),
						BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(registryObject.get()))
				).with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING_ALT)
		);
	}

	public static final ModelTemplate CHEST = ModelTemplates.createItem("grimoireofgaia:chest", TextureSlot.LAYER0);
	public static final ModelTemplate BOOK = ModelTemplates.createItem("grimoireofgaia:weapon_book", TextureSlot.LAYER0);

	private void generatedItem(ItemModelGenerators itemModels, DeferredHolder<Item, ? extends Item> registryObject) {
		itemModels.generateFlatItem(registryObject.get(), ModelTemplates.FLAT_ITEM);
	}

	private void spawnItem(ItemModelGenerators itemModels, DeferredHolder<Item, ? extends Item> registryObject) {
		itemModels.generateFlatItem(registryObject.get(), ModelTemplates.FLAT_ITEM);
//		Identifier location = registryObject.getId();
//		singleTexture(location.getPath(), Identifier.parse("item/generated"),
//				"layer0", Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "item/spawn/" + location.getPath()));
	}

	private void handheldItem(ItemModelGenerators itemModels, DeferredHolder<Item, ? extends Item> registryObject) {
		itemModels.generateFlatItem(registryObject.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	private void parentItem(ItemModelGenerators itemModels, DeferredHolder<Item, ? extends Item> registryObject, Identifier parent) {
		ModelTemplate PARENT_TEMPLATE = ModelTemplates.createItem(parent.toString(), TextureSlot.LAYER0);
		itemModels.itemModelOutput.accept(registryObject.get(), ItemModelUtils.plainModel(
				PARENT_TEMPLATE.create(
						ModelLocationUtils.getModelLocation(registryObject.get()),
						TextureMapping.layer0(new Material(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "item/" + registryObject.getId().getPath()))),
						itemModels.modelOutput
				)
		));
	}

	private void generatedBox(ItemModelGenerators itemModels, DeferredHolder<Item, ? extends Item> registryObject) {
		itemModels.generateFlatItem(registryObject.get(), CHEST);
	}

	private void generatedBook(ItemModelGenerators itemModels, DeferredHolder<Item, ? extends Item> registryObject) {
		itemModels.generateFlatItem(registryObject.get(), BOOK);
	}
}
