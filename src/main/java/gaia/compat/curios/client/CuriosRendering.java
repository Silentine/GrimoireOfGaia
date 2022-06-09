package gaia.compat.curios.client;

import gaia.item.armor.HeadgearItem;
import gaia.registry.GaiaRegistry;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class CuriosRendering {

	public static void onRenderSetup() {
		for (RegistryObject<Item> registryObject : GaiaRegistry.ITEMS.getEntries()) {
			if (registryObject.isPresent() && registryObject.get() instanceof HeadgearItem headgearItem) {
				CuriosRendererRegistry.register(headgearItem, HeadgearRenderer::new);
			}
		}
	}
}
