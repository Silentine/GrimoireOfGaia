package gaia.datagen.client.compat;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import xyz.brassgoggledcoders.patchouliprovider.BookBuilder;
import xyz.brassgoggledcoders.patchouliprovider.CategoryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.EntryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.PatchouliBookProvider;

import java.util.Arrays;
import java.util.function.Consumer;

public class GaiaPatchouliProvider extends PatchouliBookProvider {
	public GaiaPatchouliProvider(DataGenerator gen) {
		super(gen, GrimoireOfGaia.MOD_ID, "en_us");
	}

	@Override
	protected void addBooks(Consumer<BookBuilder> consumer) {
		//Initialize the book builder
		BookBuilder bookBuilder = createBookBuilder("grimoireofgaia",
				prefix("name"), prefix("landing"))
				.setSubtitle(prefix("subtitle"))
				.setCreativeTab("statues.items")
				.setModel("patchouli:book_red")
				.setBookTexture("patchouli:textures/gui/book_red.png")
				.setShowProgress(true)
				.setUseBlockyFont(true)
				.setI18n(true)
				.setVersion("Alpha 30")
				.addMacro("$(item)", "$(#b0b)")
				.addMacro("$(mob)", "$(#e50)")
				.addMacro("$(thing)", "$(#490)")
				.setUseResourcePack(true);

		//Info category
		CategoryBuilder assistCategory = bookBuilder.addCategory("assist", prefix("category.assist.name"),
				prefix("category.assist.desc"), new ItemStack(Items.OAK_SAPLING));

		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.CENTAUR.getEntityType().getRegistryName(),
				GaiaRegistry.BOX_IRON.get(), GaiaRegistry.BAG_ARROWS.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.COBBLE_GOLEM.getEntityType().getRegistryName(),
				GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.COBBLESTONE_GOLEM.getEntityType().getRegistryName(),
				GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.CYCLOPS.getEntityType().getRegistryName(),
				GaiaRegistry.FUR.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.DRYAD.getEntityType().getRegistryName(),
				GaiaRegistry.TAPROOT.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.DWARF.getEntityType().getRegistryName(),
				GaiaRegistry.BOX_OVERWORLD.get(), GaiaRegistry.BOX_GOLD.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.GOBLIN.getEntityType().getRegistryName(),
				Items.IRON_NUGGET, GaiaRegistry.MEAT.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.BEE.getEntityType().getRegistryName(),
				GaiaRegistry.HONEYDEW.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.HUNTER.getEntityType().getRegistryName(),
				GaiaRegistry.BOX_IRON.get(), GaiaRegistry.BAG_ARROWS.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.MERMAID.getEntityType().getRegistryName(),
				GaiaRegistry.SHINY_PEARL.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.SATYRESS.getEntityType().getRegistryName(),
				GaiaRegistry.MEAT.get(), GaiaRegistry.BOX_IRON.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.WIZARD_HARPY.getEntityType().getRegistryName(),
				GaiaRegistry.SOULFIRE.get(), GaiaRegistry.BOOK_OF_MEMORY.get());
		assistCategory = addMobEntry(assistCategory, "assist", GaiaRegistry.YUKI_ONNA.getEntityType().getRegistryName(),
				GaiaRegistry.FUR.get(), GaiaRegistry.BOX_GOLD.get(), GaiaRegistry.BAG_BOOK.get(), GaiaRegistry.FAN_ICE.get());

//		assistCategory = addMobEntry(assistCategory, "hostile", GaiaRegistry.SLUDGE_GIRL.getEntityType().getRegistryName());

		bookBuilder = assistCategory.build();

		//Finish book
		bookBuilder.build(consumer);
	}

	private CategoryBuilder addMobEntry(CategoryBuilder builder, String category, ResourceLocation entityLocation,
										ItemStack... drops) {
		String path = entityLocation.getPath();
		String entryPrefix = "entry." + path;
		//Add Entry
		EntryBuilder entryBuilder = builder.addEntry(category + "/" + path, prefix(entryPrefix + ".name"),
						new ResourceLocation(entityLocation.getNamespace(), path + "_spawn_egg").toString())
				.addTextPage(prefix(entryPrefix + ".info")).build()
				.addEntityPage(entityLocation).setText(prefix(entryPrefix + ".info2"))
				.setScale(0.75F).build();
		if (drops.length > 0) {
			for (ItemStack stack : drops) {
				entryBuilder.addSpotlightPage(stack)
						.setLinkRecipe(true)
						.setText(prefix(entryPrefix + ".drop." + stack.getItem().getRegistryName().getPath() + ".info"))
						.build();
			}
		}

		return entryBuilder.build();
	}

	private CategoryBuilder addMobEntry(CategoryBuilder builder, String category, ResourceLocation entityLocation,
										Item... drops) {
		return addMobEntry(builder, category, entityLocation, Arrays.stream(drops).map(item -> new ItemStack(item)).toList().toArray(new ItemStack[]{}));
	}

	private CategoryBuilder addMobEntry(CategoryBuilder builder, String category, ResourceLocation entityLocation) {
		return addMobEntry(builder, category, entityLocation, new ItemStack[]{});
	}

	private String prefix(String name) {
		return "info.grimoireofgaia.book." + name;
	}
}
