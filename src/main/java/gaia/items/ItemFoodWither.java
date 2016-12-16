package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;

public class ItemFoodWither extends ItemFood {
	String texture;

	public ItemFoodWither(int par2, float par3, boolean par4, String name) {
		super(par2, par3, par4);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.WITHER, 10, 0), 0.6F);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add("(60%) " + I18n.translateToLocal("effect.wither") + " (0:10)");
	}
}
