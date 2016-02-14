package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFoodBerryFire extends ItemFood {
	String texture;

	public ItemFoodBerryFire(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.setMaxStackSize(16);
		this.setUnlocalizedName("GrimoireOfGaia.FoodBerryFire");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("potion.moveSpeed") + " (0:20)");
	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 400, 0));
	}

	/*public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}*/
}
