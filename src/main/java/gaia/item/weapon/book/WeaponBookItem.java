package gaia.item.weapon.book;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class WeaponBookItem extends SwordItem {
	public WeaponBookItem(Tier tier, Properties properties) {
		super(tier, 3, -2.4F, properties);
	}
}
