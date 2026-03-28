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
		this.tag(EntityTypeTags.BEEHIVE_INHABITORS).add(GaiaRegistry.BEE.getEntityType());

		this.tag(MOB_ATTACK_BLACKLIST).add(
				GaiaRegistry.BEE.getEntityType(), GaiaRegistry.CENTAUR.getEntityType(),
				GaiaRegistry.COBBLE_GOLEM.getEntityType(), GaiaRegistry.CYCLOPS.getEntityType(),
				GaiaRegistry.DRYAD.getEntityType(), GaiaRegistry.GOBLIN.getEntityType(),
				GaiaRegistry.HUNTER.getEntityType(), GaiaRegistry.MERMAID.getEntityType(),
				GaiaRegistry.SATYRESS.getEntityType(), GaiaRegistry.WIZARD_HARPY.getEntityType(),
				GaiaRegistry.YUKI_ONNA.getEntityType()
		);

		this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(
				GaiaRegistry.CECAELIA.getEntityType(),
				GaiaRegistry.MERMAID.getEntityType(),
				GaiaRegistry.MINOTAUR.getEntityType(),
				GaiaRegistry.SHARKO.getEntityType(),
				GaiaRegistry.VALKYRIE.getEntityType()
		);

		this.tag(EntityTypeTags.ARTHROPOD).add(
				GaiaRegistry.ANT_SALVAGER.getEntityType(),
				GaiaRegistry.ANT_WORKER.getEntityType(),
				GaiaRegistry.ARACHNE.getEntityType(),
				GaiaRegistry.BEE.getEntityType(),
				GaiaRegistry.GRAVEMITE.getEntityType()
		);

		this.tag(EntityTypeTags.UNDEAD).add(
				GaiaRegistry.BONE_KNIGHT.getEntityType(),
				GaiaRegistry.FLESH_LICH.getEntityType(),
				GaiaRegistry.YUKI_ONNA.getEntityType(),
				GaiaRegistry.MUMMY.getEntityType(),
				GaiaRegistry.BANSHEE.getEntityType(),
				GaiaRegistry.WITHER_COW.getEntityType()
		);
	}
}
