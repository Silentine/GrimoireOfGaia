package gaia.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFoodRottenHeart extends ItemFoodGaia {

	public ItemFoodRottenHeart() {
		super("food_rotten_heart", 4, 0.0F, true);
		setAlwaysEdible();
		maxStackSize = 1;

		setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10, 0), 1.0F);
		setSecondPotionEffect(new PotionEffect(MobEffects.HUNGER, 30, 0), 0.8F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("effect.regeneration") + " (0:10)");
		tooltip.add("(80%) " + I18n.format("effect.hunger") + " (0:30)");
	}
}
