package gaia.helpers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelLoaderHelper {
	private ModelLoaderHelper() {
	}

	public static void registerItem(Block block) {
		Item item = Item.getItemFromBlock(block);
		registerItem(item);
	}

	public static void registerItem(Item item) {
		if (item.getHasSubtypes()) {
			NonNullList<ItemStack> subItems = NonNullList.create();
			// noinspection ConstantConditions
			item.getSubItems(item.getCreativeTab(), subItems);

			for (ItemStack stack : subItems) {
				registerItem(item, stack.getMetadata());
			}
		} else {
			registerItem(item, 0);
		}
	}

	private static void registerItem(Item item, int meta) {
		registerItem(item, meta, "inventory");
	}

	private static void registerItem(Item item, int meta, String variant) {
		// noinspection ConstantConditions
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), variant));
	}

	public static void registerItem(Item item, String... variants) {
		for (int meta = 0; meta < variants.length; meta++) {
			registerItem(item, meta, variants[meta]);
		}
	}

	public static void registerItem(Item item, ModelResourceLocation... modelLocations) {
		for (int meta = 0; meta < modelLocations.length; meta++) {
			ModelLoader.setCustomModelResourceLocation(item, meta, modelLocations[meta]);
		}
	}

	public static ModelResourceLocation getSuffixedLocation(Item item, String suffix) {
		// noinspection ConstantConditions
		return new ModelResourceLocation(item.getRegistryName().getNamespace() + ":" + item.getRegistryName().getPath() + suffix, "inventory");
	}
}
