package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItems;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBook extends ItemSword {

	private float attackDamage;
	private final Item.ToolMaterial material;

	public ItemWeaponBook(String name) {
		super(Item.ToolMaterial.IRON);
		this.material = Item.ToolMaterial.IRON;
		this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses()*3.48F));
		this.setCreativeTab(Gaia.tabGaia);
		this.attackDamage = Item.ToolMaterial.IRON.getDamageVsEntity();
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == GaiaItems.MiscQuill;
    }
}
