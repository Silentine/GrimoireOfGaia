package gaia.item.weapon.book;

import net.minecraft.world.item.ToolMaterial;

public class WeaponBookItem extends GaiaBookItem {
	public WeaponBookItem(ToolMaterial material, Properties properties) {
		super(properties.sword(material, 3, -2.4F));
	}
}
