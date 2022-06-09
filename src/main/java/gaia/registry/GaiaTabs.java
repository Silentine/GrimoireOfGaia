package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class GaiaTabs {
	public static final CreativeModeTab GAIA_TAB = new CreativeModeTab(GrimoireOfGaia.MOD_ID) {
		public @Nonnull ItemStack makeIcon() {
			return new ItemStack(GaiaRegistry.DOLL_DRYAD.get());
		}
	};
}
