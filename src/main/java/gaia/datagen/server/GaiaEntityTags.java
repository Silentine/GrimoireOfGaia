package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class GaiaEntityTags extends EntityTypeTagsProvider {
	public GaiaEntityTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, GrimoireOfGaia.MOD_ID, existingFileHelper);
	}

	public static final TagKey<EntityType<?>> MOB_ATTACK_BLACKLIST = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecolonies", "mob_attack_blacklist"));

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
	}
}
