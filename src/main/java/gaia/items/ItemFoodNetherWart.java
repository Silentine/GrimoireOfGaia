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

public class ItemFoodNetherWart extends ItemFoodGaia {

	public ItemFoodNetherWart() {
		super("food_nether_wart", 4, 0.4F, false);
		setPotionEffect(new PotionEffect(MobEffects.SPEED, 30, 0), 0.4F);
		setSecondPotionEffect(new PotionEffect(MobEffects.HASTE, 30, 0), 0.4F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("(40%) " + I18n.format("effect.moveSpeed") + " (0:30)");
		tooltip.add("(40%) " + I18n.format("effect.digSpeed") + " (0:30)");
	}
}
