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

public class ItemFoodCoalfish extends ItemFood {

	public ItemFoodCoalfish(int par2, float par3, boolean par4, String name) {
		super(par2, par3, par4);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(180)}));
		par3List.add(I18n.translateToLocal("effect.waterBreathing") + " (2:00)");
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {     
		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 2400, 0));
	}
}
