package gaia.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
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

import javax.annotation.Nullable;
import java.util.List;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public class ItemAccessorySkull extends ItemBase implements IBauble {
	public ItemAccessorySkull() {
		super("accessory_skull");
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
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.GrimoireOfGaia.WIP.tag")));
		tooltip.add(I18n.format("text.GrimoireOfGaia.RightClickEquip"));
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}
		for (int i = 0; i < 1; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "_" + stack.getItemDamage();
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemStack) {
		return BaubleType.HEAD;
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
}
