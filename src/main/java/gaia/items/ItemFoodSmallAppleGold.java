package gaia.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFoodSmallAppleGold extends ItemFoodBase {

	public ItemFoodSmallAppleGold() {
		super("food_small_apple_gold", 1, 0.4F, false);
		setAlwaysEdible();
		maxStackSize = 64;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("effect.absorption") + " (2:00)");
		tooltip.add(I18n.format("effect.regeneration") + " (IV)" + " (0:04)");
		tooltip.add(I18n.format("effect.resistance") + " (0:50)");
		tooltip.add(I18n.format("effect.fireResistance") + " (0:50)");
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 4));
		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1000, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1000, 0));
	}
}
