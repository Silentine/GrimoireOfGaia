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
		this.tag(GaiaTags.DIMENSIONAL_BOXES).add(GaiaRegistry.BOX_OVERWORLD.getKey(), GaiaRegistry.BOX_NETHER.getKey(), GaiaRegistry.BOX_END.getKey());
		this.tag(GaiaTags.GOLDEN_TOOLS).add(Items.GOLDEN_AXE.builtInRegistryHolder().getKey(), Items.GOLDEN_SHOVEL.builtInRegistryHolder().getKey(), Items.GOLDEN_PICKAXE.builtInRegistryHolder().getKey(), Items.GOLDEN_HOE.builtInRegistryHolder().getKey(), Items.GOLDEN_SWORD.builtInRegistryHolder().getKey());
		this.tag(GaiaTags.RECORDS).add(Items.MUSIC_DISC_13.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_CAT.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_BLOCKS.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_CHIRP.builtInRegistryHolder().getKey(),
				Items.MUSIC_DISC_FAR.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_MALL.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_MELLOHI.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_STAL.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_STRAD.builtInRegistryHolder().getKey(),
				Items.MUSIC_DISC_WARD.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_11.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_WAIT.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_OTHERSIDE.builtInRegistryHolder().getKey(), Items.MUSIC_DISC_PIGSTEP.builtInRegistryHolder().getKey());

		this.tag(HEAD).add(GaiaRegistry.HEADGEAR_BOOK.getKey(), GaiaRegistry.HEADGEAR_MOB.getKey(), GaiaRegistry.HEADGEAR_BOLT.getKey(),
				GaiaRegistry.HEADGEAR_ARROW.getKey(), GaiaRegistry.HEADGEAR_DOLL.getKey(), GaiaRegistry.HEADGEAR_EARS_ELF.getKey());
		this.tag(BODY).add(GaiaRegistry.SEASHELL_HAIRPIN.getKey());
		this.tag(HANDS).add(GaiaRegistry.KNUCKLES.getKey());
		this.tag(NECKLACE).add(GaiaRegistry.HEAVY_BARBELL.getKey());
		this.tag(RING).add(GaiaRegistry.RING_OF_SPEED.getKey(), GaiaRegistry.RING_OF_HASTE.getKey(), GaiaRegistry.RING_OF_JUMP.getKey(), GaiaRegistry.RING_OF_NIGHT.getKey());

		this.tag(GaiaTags.NUGGETS_DIAMOND).add(GaiaRegistry.DIAMOND_SHARD.getKey());
		this.tag(GaiaTags.NUGGETS_EMERALD).add(GaiaRegistry.EMERALD_SHARD.getKey());
		this.tag(Tags.Items.NUGGETS).addTags(GaiaTags.NUGGETS_DIAMOND, GaiaTags.NUGGETS_EMERALD);

		this.tag(Tags.Items.TOOLS_SHIELD).add(
				GaiaRegistry.BONE_SHIELD.getKey(), GaiaRegistry.STONE_SHIELD.getKey(),
				GaiaRegistry.IRON_SHIELD.getKey(), GaiaRegistry.GOLD_SHIELD.getKey()
		);
		this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(
				GaiaRegistry.BONE_SHIELD.getKey(), GaiaRegistry.STONE_SHIELD.getKey(),
				GaiaRegistry.IRON_SHIELD.getKey(), GaiaRegistry.GOLD_SHIELD.getKey()
		);

		this.tag(GaiaTags.BOOK_REPAIR_ITEMS).add(GaiaRegistry.QUILL.getKey());
		this.tag(GaiaTags.CURSED_METAL_REPAIR_ITEMS).addTag(Tags.Items.OBSIDIANS_NORMAL);
	}
}
