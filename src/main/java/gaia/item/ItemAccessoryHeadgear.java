package gaia.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

/**
 * UNDER CONSTRUCTION
 */
//@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public class ItemAccessoryHeadgear extends Item { //implements IBauble {

	public ItemAccessoryHeadgear(Item.Properties builder) {
		super(builder);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.WIP.tag").applyTextStyle(TextFormatting.BOLD));
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.Headgear.tag").applyTextStyle(TextFormatting.YELLOW));
		if (stack.getDamage() == 0) {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.Prop.tag").applyTextStyle(TextFormatting.YELLOW));
		}
	}

	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
		return armorType == EquipmentSlotType.HEAD;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		ItemStack currentArmorStack = playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD);

		if (currentArmorStack.isEmpty()) {
			playerIn.setItemStackToSlot(EquipmentSlotType.HEAD, itemstack.copy());
			itemstack.setCount(0);
			return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
		} else {
			return new ActionResult<>(ActionResultType.FAIL, itemstack);
		}
	}

	/* BAUBLES */
//	@Override
//	public BaubleType getBaubleType(ItemStack itemStack) {
//		return BaubleType.HEAD;
//	}
	/* BAUBLES */
}
