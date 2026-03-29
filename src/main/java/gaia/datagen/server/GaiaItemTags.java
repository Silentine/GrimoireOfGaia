package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class GaiaItemTags extends ItemTagsProvider {
	public static final TagKey<Item> HEAD = ItemTags.create(Identifier.fromNamespaceAndPath("curios", "head"));
	public static final TagKey<Item> BODY = ItemTags.create(Identifier.fromNamespaceAndPath("curios", "body"));
	public static final TagKey<Item> HANDS = ItemTags.create(Identifier.fromNamespaceAndPath("curios", "hands"));
	public static final TagKey<Item> NECKLACE = ItemTags.create(Identifier.fromNamespaceAndPath("curios", "necklace"));
	public static final TagKey<Item> RING = ItemTags.create(Identifier.fromNamespaceAndPath("curios", "ring"));

	public GaiaItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider, GrimoireOfGaia.MOD_ID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(GaiaTags.DIMENSIONAL_BOXES).add(GaiaRegistry.BOX_OVERWORLD.get(), GaiaRegistry.BOX_NETHER.get(), GaiaRegistry.BOX_END.get());
		this.tag(GaiaTags.GOLDEN_TOOLS).add(Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_PICKAXE, Items.GOLDEN_HOE, Items.GOLDEN_SWORD);
		this.tag(GaiaTags.RECORDS).add(Items.MUSIC_DISC_13, Items.MUSIC_DISC_CAT, Items.MUSIC_DISC_BLOCKS, Items.MUSIC_DISC_CHIRP,
				Items.MUSIC_DISC_FAR, Items.MUSIC_DISC_MALL, Items.MUSIC_DISC_MELLOHI, Items.MUSIC_DISC_STAL, Items.MUSIC_DISC_STRAD,
				Items.MUSIC_DISC_WARD, Items.MUSIC_DISC_11, Items.MUSIC_DISC_WAIT, Items.MUSIC_DISC_OTHERSIDE, Items.MUSIC_DISC_PIGSTEP);

		this.tag(HEAD).add(GaiaRegistry.HEADGEAR_BOOK.get(), GaiaRegistry.HEADGEAR_MOB.get(), GaiaRegistry.HEADGEAR_BOLT.get(),
				GaiaRegistry.HEADGEAR_ARROW.get(), GaiaRegistry.HEADGEAR_DOLL.get(), GaiaRegistry.HEADGEAR_EARS_ELF.get());
		this.tag(BODY).add(GaiaRegistry.SEASHELL_HAIRPIN.get());
		this.tag(HANDS).add(GaiaRegistry.KNUCKLES.get());
		this.tag(NECKLACE).add(GaiaRegistry.HEAVY_BARBELL.get());
		this.tag(RING).add(GaiaRegistry.RING_OF_SPEED.get(), GaiaRegistry.RING_OF_HASTE.get(), GaiaRegistry.RING_OF_JUMP.get(), GaiaRegistry.RING_OF_NIGHT.get());

		this.tag(GaiaTags.NUGGETS_DIAMOND).add(GaiaRegistry.DIAMOND_SHARD.get());
		this.tag(GaiaTags.NUGGETS_EMERALD).add(GaiaRegistry.EMERALD_SHARD.get());
		this.tag(Tags.Items.NUGGETS).addTags(GaiaTags.NUGGETS_DIAMOND, GaiaTags.NUGGETS_EMERALD);

		this.tag(Tags.Items.TOOLS_SHIELD).add(
				GaiaRegistry.BONE_SHIELD.get(), GaiaRegistry.STONE_SHIELD.get(),
				GaiaRegistry.IRON_SHIELD.get(), GaiaRegistry.GOLD_SHIELD.get()
		);
		this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(
				GaiaRegistry.BONE_SHIELD.get(), GaiaRegistry.STONE_SHIELD.get(),
				GaiaRegistry.IRON_SHIELD.get(), GaiaRegistry.GOLD_SHIELD.get()
		);
	}
}
