package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFoodPieMeat extends ItemFood {

	String texture;

	public ItemFoodPieMeat(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.FoodPieMeat");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack stack, EntityPlayer world, List list, boolean par4) {
		list.add(StatCollector.translateToLocalFormatted("text.GrimoireOfGaia.GainExperience"));
		list.add(StatCollector.translateToLocal("potion.moveSlowdown") + " (0:30)");
	}
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        EntityXPOrb entity = new EntityXPOrb(world, player.posX, player.posY + 1, player.posZ, itemRand.nextInt(14) + 6);
        spawnEntity(player.posX, player.posY + 1, player.posZ, entity, world, player);
        
        player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 0));
	}
	
    public static void spawnEntity (double x, double y, double z, Entity entity, World world, EntityPlayer player) {
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(entity);
        }
    }
    
	/*
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		if(!par2World.isRemote) {
			par3EntityPlayer.heal(6.0F);
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 3600, 0));
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 3600, 0));
		}

		return new ItemStack(Items.bowl);
	}
	*/

	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}
}
