package gaia.items;

import gaia.init.GaiaItems;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import baubles.api.BaubleType;
import baubles.api.IBauble;

//TODO Make item appear in 3rd person when placed into Baubles slot

@InterfaceList({
	@Interface(iface="baubles.api.IBauble", modid="Baubles", striprefs=true),
	@Interface(iface="baubles.api.BaubleType", modid="Baubles", striprefs=true)})

public class ItemAccessoryBauble extends Item implements IBauble {

	private ItemStack renderStack;

	public ItemAccessoryBauble(String name) {
		this.setHasSubtypes(true);
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
//		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.WIP.tag")));
		tooltip.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickEquip"));
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 1; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
	
	/**
	 * @see EntityLiving
	 */
	public static EntityEquipmentSlot getSlotForItemStack(ItemStack stack) {
		return 
				stack.getItem() != GaiaItems.AccessoryBauble ? 
				EntityEquipmentSlot.MAINHAND 
				: 
				EntityEquipmentSlot.HEAD;
	}

	/**
	 * @see ItemArmor
	 */
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		EntityEquipmentSlot entityequipmentslot = getSlotForItemStack(itemStackIn);
		ItemStack itemstack = playerIn.getItemStackFromSlot(entityequipmentslot);

		if (itemstack == null) {
			playerIn.setItemStackToSlot(entityequipmentslot, itemStackIn.copy());
			itemStackIn.stackSize = 0;
			return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
		} else {
			return new ActionResult(EnumActionResult.FAIL, itemStackIn);
		}
	}

	//==================== Bauble ===================//
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.HEAD;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
}
