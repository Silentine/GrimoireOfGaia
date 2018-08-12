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

public class ItemFoodMandrake extends ItemFoodBase {

	public ItemFoodMandrake() {
		super("food_mandrake", 0, 0.0F, false);
		setAlwaysEdible();
		maxStackSize = 16;
		setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 30, 0), 0.8F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.HeartsGain", 2));
		tooltip.add(I18n.format("text.grimoireofgaia.HungerLose", 4));
		tooltip.add("(80%) " + I18n.format("effect.confusion") + " (0:20)");
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.heal(4.0F);
		player.addExhaustion(40.0F);
	}
}
