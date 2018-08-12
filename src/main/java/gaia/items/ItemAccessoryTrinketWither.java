package gaia.items;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAccessoryTrinketWither extends ItemAccessoryBauble {
	public ItemAccessoryTrinketWither() {
		super("accessory_trinket_wither");
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.CHARM;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Trinket.tag")));

		if (shiftPressed) {
			tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.InventoryTrinket")));
			tooltip.add(I18n.format("text.grimoireofgaia.InventoryImmunity") + " " + I18n.format("effect.wither"));
			tooltip.add(I18n.format("text.grimoireofgaia.InventoryImmunity") + " " + I18n.format("effect.regeneration"));
		} else {
			tooltip.add(TextFormatting.ITALIC + (I18n.format("text.grimoireofgaia.HoldShift")));
		}
	}

	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
		if (player.getActivePotionEffect(MobEffects.WITHER) != null) {
			player.removePotionEffect(MobEffects.WITHER);
		}

		if (player.getActivePotionEffect(MobEffects.REGENERATION) != null) {
			player.removePotionEffect(MobEffects.REGENERATION);
		}
	}
}
