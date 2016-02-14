package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMiscRing extends Item {
	String texture;

	public ItemMiscRing(String texture) {
		this.texture = texture;
        this.setHasSubtypes(true);
		this.setUnlocalizedName("GrimoireOfGaia.MiscRing");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	public IIcon[] icons = new IIcon[4];

	@Override
	public void registerIcons(IIconRegister reg) {
		this.icons[0] = reg.registerIcon("gaia:" + "MiscRingSpeed");
		this.icons[1] = reg.registerIcon("gaia:" + "MiscRingHaste");
		this.icons[2] = reg.registerIcon("gaia:" + "MiscRingJump");
		this.icons[3] = reg.registerIcon("gaia:" + "MiscRingNight");
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > 3) meta = 0;
		return this.icons[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 4; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
}
