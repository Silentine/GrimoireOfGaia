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

public class ItemFoodMandrake extends ItemFood {
	String texture;

	public ItemFoodMandrake(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.maxStackSize = 16;
		this.setUnlocalizedName("GrimoireOfGaia.FoodMandrake");
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 30, 0), 0.8F);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.RecoverHearts", new Object[]{Integer.valueOf(2)}));
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.LoseHunger", new Object[]{Integer.valueOf(4)}));
		par3List.add("(80%) " + I18n.translateToLocal("potion.confusion") + " (0:20)");
	}

	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.heal(4.0F);
		player.addExhaustion(40.0F);
	}
}
