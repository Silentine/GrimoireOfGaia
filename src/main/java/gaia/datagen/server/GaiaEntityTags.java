package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GaiaEntityTags extends EntityTypeTagsProvider {
	public GaiaEntityTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, GrimoireOfGaia.MOD_ID, existingFileHelper);
	}

	public static final TagKey<EntityType<?>> MOB_ATTACK_BLACKLIST = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("minecolonies", "mob_attack_blacklist"));

	@Override
	protected void addTags() {
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
