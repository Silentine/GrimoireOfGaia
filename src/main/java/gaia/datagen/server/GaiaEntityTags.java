package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class GaiaEntityTags extends EntityTypeTagsProvider {
	public GaiaEntityTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider, GrimoireOfGaia.MOD_ID);
	}

	public static final TagKey<EntityType<?>> MOB_ATTACK_BLACKLIST = TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("minecolonies", "mob_attack_blacklist"));

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(EntityTypeTags.BEEHIVE_INHABITORS).add(GaiaRegistry.BEE.getEntityType().builtInRegistryHolder().key());

		this.tag(MOB_ATTACK_BLACKLIST).add(
				GaiaRegistry.BEE.getEntityType().builtInRegistryHolder().key(), GaiaRegistry.CENTAUR.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.COBBLE_GOLEM.getEntityType().builtInRegistryHolder().key(), GaiaRegistry.CYCLOPS.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.DRYAD.getEntityType().builtInRegistryHolder().key(), GaiaRegistry.GOBLIN.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.HUNTER.getEntityType().builtInRegistryHolder().key(), GaiaRegistry.MERMAID.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.SATYRESS.getEntityType().builtInRegistryHolder().key(), GaiaRegistry.WIZARD_HARPY.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.YUKI_ONNA.getEntityType().builtInRegistryHolder().key()
		);

		this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(
				GaiaRegistry.CECAELIA.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.MERMAID.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.MINOTAUR.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.SHARKO.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.VALKYRIE.getEntityType().builtInRegistryHolder().key()
		);

		this.tag(EntityTypeTags.ARTHROPOD).add(
				GaiaRegistry.ANT_SALVAGER.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.ANT_WORKER.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.ARACHNE.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.BEE.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.GRAVEMITE.getEntityType().builtInRegistryHolder().key()
		);

		this.tag(EntityTypeTags.UNDEAD).add(
				GaiaRegistry.BONE_KNIGHT.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.FLESH_LICH.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.YUKI_ONNA.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.MUMMY.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.BANSHEE.getEntityType().builtInRegistryHolder().key(),
				GaiaRegistry.WITHER_COW.getEntityType().builtInRegistryHolder().key()
		);
	}
}
