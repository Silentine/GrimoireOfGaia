package gaia.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

/**
 * UNDER CONSTRUCTION
 */
//@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public class ItemAccessoryHeadgear extends ItemBase { //implements IBauble {

	public ItemAccessoryHeadgear(Item.Properties builder) {
		super(builder);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.WIP.tag").applyTextStyle(TextFormatting.BOLD));
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.Headgear.tag").applyTextStyle(TextFormatting.YELLOW));
		if (stack.getDamage() == 0) {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.Prop.tag").applyTextStyle(TextFormatting.YELLOW));
		}
	}

	@Override
	public boolean canEquip(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
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

	/* BAUBLES */
//	@Override
//	public BaubleType getBaubleType(ItemStack itemStack) {
//		return BaubleType.HEAD;
//	}
	/* BAUBLES */
}
