package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMiscWeaponEnchanted extends Item {
	String texture;

	public ItemMiscWeaponEnchanted(String texture) {
		this.texture = texture;
		this.setHasSubtypes(true);
		this.setUnlocalizedName("GrimoireOfGaia.MiscWeaponEnchanted");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("item.GrimoireOfGaia.MiscWeaponEnchanted.desc"));
	}

	/*public IIcon[] icons = new IIcon[2];

	@Override
	public void registerIcons(IIconRegister reg) {
		this.icons[0] = reg.registerIcon("gaia:" + "MiscWeaponFanIce");
		this.icons[1] = reg.registerIcon("gaia:" + "MiscWeaponFanFire");
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > 1) meta = 0;
		return this.icons[meta];
	}*/

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 2; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
}
