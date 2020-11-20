package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.helpers.ModelLoaderHelper;
import gaia.proxy.IClientRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponPropItemSword extends ItemSword implements IClientRegister {

	public ItemWeaponPropItemSword(ToolMaterial material, String name) {
		super(material);

		setCreativeTab(CreativeTabGaia.INSTANCE);
		setRegistryName(GaiaReference.MOD_ID, name);
		setTranslationKey(GaiaReference.MOD_ID + "." + name);
		Gaia.proxy.addClientRegister(this);
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
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this);
	}
}
