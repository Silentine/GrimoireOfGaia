package gaia.items;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import gaia.Gaia;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAccessoryRingJump extends Item implements IBauble{
	String texture;

	public ItemAccessoryRingJump(String texture) {
		this.texture = texture;
		this.setMaxStackSize(1);
		this.setUnlocalizedName("GrimoireOfGaia.AccessoryRingJump");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.EPIC;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("potion.jump"));
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
		EntityPlayer player = (EntityPlayer)par3Entity;

		for(int i = 0; i < 9; ++i) {
			if(player.inventory.getStackInSlot(i) == par1ItemStack) {
				this.doEffect(player, par1ItemStack);
				break;
			}
		}
	}

	public void doEffect(EntityPlayer player, ItemStack item) {		
		//player.addPotionEffect(new PotionEffect(Potion.jump.id, 0, 0));
		//player.jumpMovementFactor = 0.015F;
		
		if (!player.isPotionActive(Potion.jump)) {
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 60, 0, true, false));		
		}
		player.jumpMovementFactor = 0.015F;
	}
	
	public void doParticle(EntityPlayer player, ItemStack item) {
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 20, 0));
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {		
		this.doEffect((EntityPlayer)player, itemstack);	
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		this.doParticle((EntityPlayer)player, itemstack);	
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		this.doParticle((EntityPlayer)player, itemstack);	
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
}
