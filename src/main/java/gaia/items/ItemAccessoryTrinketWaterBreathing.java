package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.Range;
import org.lwjgl.input.Keyboard;

import baubles.api.BaubleType;
import gaia.helpers.ModelLoaderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAccessoryTrinketWaterBreathing extends ItemAccessoryBauble {

	public ItemAccessoryTrinketWaterBreathing() {
		super("accessory_trinket_water_breathing");
		setMaxStackSize(1);
		setHasSubtypes(true);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BODY;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Trinket.tag")));

		if (shiftPressed) {
			if (!isBaublesLoaded) {
				tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.InventoryTrinket")));
			}

			tooltip.add(I18n.format(I18n.format("effect.waterBreathing") + " (0:20)"));
		} else {
			tooltip.add(TextFormatting.ITALIC + (I18n.format("text.grimoireofgaia.HoldShift")));
		}
	}

	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(8, 8);
	}

	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
		if (item.getItemDamage() == 0 && player.getActivePotionEffect(MobEffects.WATER_BREATHING) == null && player.isWet()) {
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20 * 20, 0, true, false));
			item.setItemDamage(1);
		} else if (item.getItemDamage() == 1 && !player.isWet()) {
			player.removePotionEffect(MobEffects.WATER_BREATHING);
			item.setItemDamage(0);
		}
	}

	/* SUBITEMS */
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 2; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this, "variant=available", "variant=unavailable");
	}

	@Override
	public void applyModifier(EntityLivingBase player, ItemStack item) {
	}

	@Override
	public void removeModifier(EntityLivingBase player, ItemStack item) {
	}

	/* SUBITEMS */

//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//		ItemStack itemstack = playerIn.getHeldItem(handIn);
//
//		if (!worldIn.isRemote) {
//			if (playerIn.isWet()) {
//				if (playerIn.getActivePotionEffect(MobEffects.WATER_BREATHING) == null) {
//					playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20 * 10, 1, true, false));
//					playerIn.getCooldownTracker().setCooldown(this, 60);
//				}
//			}
//		}
//
//		playerIn.addStat(StatList.getObjectUseStats(this));
//		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
//	}
}
