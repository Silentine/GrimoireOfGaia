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

public class ItemFoodPieMeat extends ItemFoodGaia {
	public ItemFoodPieMeat() {
		super("food_pie_meat", 8, 0.8F, true);
		maxStackSize = 1;
		setPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 30 * 20, 0), 1.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.GainExperience"));
		tooltip.add(I18n.format("effect.moveSlowdown") + " (0:30)");
	}

	@Override
	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		rewardEXP(player, itemRand.nextInt(8) + 4);
	}
}
