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

public class ItemFoodWither extends ItemFoodBase {
	public ItemFoodWither() {
		super("food_wither", 8, 0.8F, true);
		setPotionEffect(new PotionEffect(MobEffects.WITHER, 10, 0), 0.6F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("(60%) " + I18n.format("effect.wither") + " (0:10)");
	}
}
