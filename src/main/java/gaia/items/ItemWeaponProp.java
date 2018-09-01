package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import gaia.helpers.ModelLoaderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponProp extends ItemBase {

	public ItemWeaponProp() {
		super("weapon_prop");
		maxStackSize = 1;
		setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Prop.tag")));
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		if (!(host instanceof EntityPlayer) || !((EntityPlayer) host).capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		return true;
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

	/* SUBITEMS */
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this, 
				"variant=ender", 
				"variant=blaze", 
				"variant=dagger", 
				"variant=fan"
				);
	}
	/* SUBITEMS */
}
