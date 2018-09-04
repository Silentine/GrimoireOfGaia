package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import gaia.helpers.ModelLoaderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * UNDER CONSTRUCTION
 */
@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public class ItemAccessoryHeadgear extends ItemBase implements IBauble {

	public ItemAccessoryHeadgear() {
		super("accessory_headgear");
		setHasSubtypes(true);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.BOLD + I18n.format("text.grimoireofgaia.WIP.tag"));
		tooltip.add(TextFormatting.YELLOW + I18n.format("text.grimoireofgaia.Headgear.tag"));
		if (stack.getItemDamage() == 0) {
			tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Prop.tag")));
		}
	}

	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return armorType == EntityEquipmentSlot.HEAD;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		ItemStack currentArmorStack = playerIn.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		if (currentArmorStack.isEmpty()) {
			playerIn.setItemStackToSlot(EntityEquipmentSlot.HEAD, itemstack.copy());
			itemstack.setCount(0);
			return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
		} else {
			return new ActionResult<>(EnumActionResult.FAIL, itemstack);
		}
	}

	/* SUBITEMS */
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}
		for (int i = 0; i < 3; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this,
				ModelLoaderHelper.getSuffixedLocation(this, "_mob"),
				ModelLoaderHelper.getSuffixedLocation(this, "_arrow"),
				ModelLoaderHelper.getSuffixedLocation(this, "_doll")
		);
	}
	/* SUBITEMS */

	/* BAUBLES */
	@Override
	public BaubleType getBaubleType(ItemStack itemStack) {
		return BaubleType.HEAD;
	}
	/* BAUBLES */
}
