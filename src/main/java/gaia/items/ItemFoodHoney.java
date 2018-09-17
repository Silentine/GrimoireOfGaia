package gaia.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFoodHoney extends ItemFoodGaia {

	public ItemFoodHoney() {
		super("food_honey", 4, 0.4F, false);
		setPotionEffect(new PotionEffect(MobEffects.SPEED, 10 * 20, 0), 0.2F);
		setSecondPotionEffect(new PotionEffect(MobEffects.HASTE, 10 * 20, 0), 0.2F);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("(20%) " + I18n.format("effect.moveSpeed") + " (0:10)");
		tooltip.add("(20%) " + I18n.format("effect.digSpeed") + " (0:10)");
	}
}
