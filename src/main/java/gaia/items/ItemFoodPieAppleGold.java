package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodPieAppleGold extends ItemFood {
	String texture;

	public ItemFoodPieAppleGold(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.FoodPieAppleGold");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.GainExperience"));
		par3List.add(I18n.translateToLocal("potion.absorption") + " (2:00)");
		par3List.add(I18n.translateToLocal("potion.regeneration") + " (IV)" + " (0:20)");
		par3List.add(I18n.translateToLocal("potion.resistance") + " (5:00)");
		par3List.add(I18n.translateToLocal("potion.fireResistance") + " (5:00)");
	}

	//PotionEffect is a direct copy of ItemAppleGold
	//Gained experience is 100% more
	protected void onFoodEaten(ItemStack par1ItemStack, World par2world, EntityPlayer par3EntityPlayer) {
		EntityXPOrb entity = new EntityXPOrb(par2world, par3EntityPlayer.posX, par3EntityPlayer.posY + 1, par3EntityPlayer.posZ, itemRand.nextInt(28) + 12);
		spawnEntity(par3EntityPlayer.posX, par3EntityPlayer.posY + 1, par3EntityPlayer.posZ, entity, par2world, par3EntityPlayer);
		
		par3EntityPlayer.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 4));
		par3EntityPlayer.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
	}
	
    public static void spawnEntity (double x, double y, double z, Entity entity, World world, EntityPlayer player) {
        if (!world.isRemote) {
            world.spawnEntityInWorld(entity);
        }
    }
}