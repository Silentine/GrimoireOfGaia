package gaia.compat.curios.client;

import gaia.item.armor.HeadgearItem;
import gaia.registry.GaiaRegistry;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CuriosRendering {

	public static void onRenderSetup() {
		for (DeferredHolder<Item, ? extends Item> registryObject : GaiaRegistry.ITEMS.getEntries()) {
			if (registryObject.isBound() && registryObject.get() instanceof HeadgearItem headgearItem) {
				ICurioRenderer.register(headgearItem, HeadgearRenderer::new);
			}
		}
	}
}
