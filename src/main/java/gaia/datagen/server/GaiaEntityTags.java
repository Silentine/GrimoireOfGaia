package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GaiaEntityTags extends EntityTypeTagsProvider {
	public GaiaEntityTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, GrimoireOfGaia.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(EntityTypeTags.BEEHIVE_INHABITORS).add(GaiaRegistry.BEE.getEntityType());
	}
}
