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

public class ItemFoodMandrake extends ItemFood {

	public ItemFoodMandrake(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.maxStackSize = 16;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 30, 0), 0.8F);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.HeartsGain", new Object[]{Integer.valueOf(2)}));
		tooltip.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.HungerLose", new Object[]{Integer.valueOf(4)}));
		tooltip.add("(80%) " + I18n.translateToLocal("effect.confusion") + " (0:20)");
	}

	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.heal(4.0F);
		player.addExhaustion(40.0F);
	}
}
