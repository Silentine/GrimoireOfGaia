package gaia.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFoodPieMandrake extends ItemFoodGaia {
	public ItemFoodPieMandrake() {
		super("food_pie_mandrake", 8, 0.8F, false);
		maxStackSize = 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.GainExperience"));
		tooltip.add(I18n.format("effect.nightVision") + " (3:00)");
		tooltip.add(I18n.format("effect.waterBreathing") + " (3:00)");
	}

	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		rewardEXP(player, itemRand.nextInt(16) + 8);
		player.heal(4.0F);
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 3600, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 3600, 0));
	}
}
