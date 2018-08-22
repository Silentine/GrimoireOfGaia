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

public class ItemFoodPieAppleGold extends ItemFoodGaia {
	public ItemFoodPieAppleGold() {
		super("food_pie_apple_gold", 12, 0.8F, true);
		maxStackSize = 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.GainExperience"));
		tooltip.add(I18n.format("effect.absorption") + " (2:00)");
		tooltip.add(I18n.format("effect.regeneration") + " (IV)" + " (0:20)");
		tooltip.add(I18n.format("effect.resistance") + " (5:00)");
		tooltip.add(I18n.format("effect.fireResistance") + " (5:00)");
	}

	// PotionEffect is a direct copy of ItemAppleGold
	// Gained experience is 100% more
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		rewardEXP(player, itemRand.nextInt(32) + 16);
		player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 4));
		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
	}
}
