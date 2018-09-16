package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodCoalfish extends ItemFoodBase {

	private int fuelTimeTicks = 3600;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemFoodCoalfish() {
		super("food_coalfish", 120 * 20, 0.4F, true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(I18n.format("effect.waterBreathing") + " (2:00)");
	}

	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 2400, 0));
	}

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
