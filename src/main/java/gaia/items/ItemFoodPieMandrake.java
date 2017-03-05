package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFoodPieMandrake extends ItemFood {

	String texture;

	public ItemFoodPieMandrake(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.FoodPieMandrake");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocalFormatted("text.GrimoireOfGaia.GainExperience"));
		par3List.add(StatCollector.translateToLocal("potion.nightVision") + " (3:00)");
		par3List.add(StatCollector.translateToLocal("potion.waterBreathing") + " (3:00)");
	}
	
	protected void onFoodEaten(ItemStack par1ItemStack, World par2world, EntityPlayer par3EntityPlayer) {
		EntityXPOrb entity = new EntityXPOrb(par2world, par3EntityPlayer.posX, par3EntityPlayer.posY + 1, par3EntityPlayer.posZ, itemRand.nextInt(14) + 6);
		spawnEntity(par3EntityPlayer.posX, par3EntityPlayer.posY + 1, par3EntityPlayer.posZ, entity, par2world, par3EntityPlayer);
        
		par3EntityPlayer.heal(4.0F);
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 3600, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 3600, 0));
	}
	
    public static void spawnEntity (double x, double y, double z, Entity entity, World world, EntityPlayer player) {
        if (!world.isRemote) {
            world.spawnEntityInWorld(entity);
        }
    }
}
