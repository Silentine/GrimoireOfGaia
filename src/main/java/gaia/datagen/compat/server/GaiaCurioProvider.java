package gaia.datagen.compat.server;

import gaia.GrimoireOfGaia;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;

import java.util.concurrent.CompletableFuture;

public class GaiaCurioProvider extends CuriosDataProvider {
	public GaiaCurioProvider(PackOutput output, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> registries) {
		super(GrimoireOfGaia.MOD_ID, output, fileHelper, registries);
	}

	@Override
	public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
		createSlot("hands").size(1);
		createSlot("body").size(1);
		createSlot("head").size(1);
		createSlot("necklace").size(1);
		createSlot("ring").size(1);

		createEntities("player_gaia_curios")
				.addSlots("hands", "body", "head", "necklace", "ring")
				.addPlayer();
	}
}
