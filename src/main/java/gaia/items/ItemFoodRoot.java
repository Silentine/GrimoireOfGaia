package gaia.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFoodRoot extends ItemFoodBase {

	private void clearNegativePotions(EntityPlayer entityplayer) {
		entityplayer.removePotionEffect(MobEffects.SLOWNESS);
		entityplayer.removePotionEffect(MobEffects.MINING_FATIGUE);
		entityplayer.removePotionEffect(MobEffects.NAUSEA);
		entityplayer.removePotionEffect(MobEffects.BLINDNESS);
		entityplayer.removePotionEffect(MobEffects.HUNGER);
		entityplayer.removePotionEffect(MobEffects.WEAKNESS);
		entityplayer.removePotionEffect(MobEffects.POISON);
		entityplayer.removePotionEffect(MobEffects.WITHER);
	}

	public ItemFoodRoot() {
		super("food_root", 4, 0.0F, false);
		setAlwaysEdible();
		setMaxStackSize(16);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.NegativeStatus.desc"));
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		clearNegativePotions(player);
	}
}
