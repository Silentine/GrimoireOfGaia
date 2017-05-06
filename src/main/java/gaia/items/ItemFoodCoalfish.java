package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodCoalfish extends ItemFood {

	public ItemFoodCoalfish(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(180)}));
		tooltip.add(I18n.translateToLocal("effect.waterBreathing") + " (2:00)");
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {     
		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 2400, 0));
	}
}
