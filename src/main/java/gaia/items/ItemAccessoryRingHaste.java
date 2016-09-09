package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@InterfaceList({
	@Interface(iface="baubles.api.IBauble", modid="Baubles", striprefs=true),
	@Interface(iface="baubles.api.BaubleType", modid="Baubles", striprefs=true)})

public class ItemAccessoryRingHaste extends Item //implements IBauble
{
	String texture;

	public ItemAccessoryRingHaste(String texture) {
		this.texture = texture;
		this.setMaxStackSize(1);
		this.setUnlocalizedName("GrimoireOfGaia.AccessoryRingHaste");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("potion.digSpeed"));
	}

	public void onUpdate(ItemStack stack, World world, Entity par3Entity, int par4, boolean par5) {
		super.onUpdate(stack, world, par3Entity, par4, par5);
		EntityPlayer player = (EntityPlayer)par3Entity;

		for (int i = 0; i < 9; ++i) {
			if (player.inventory.getStackInSlot(i) == stack) {
				this.doEffect(player, stack);
				break;
			}
		}
	}

	public void doEffect(EntityPlayer player, ItemStack item) {	
		if (!player.isPotionActive(MobEffects.HASTE)) {
			player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 60, 0, true, false));		
			}
	}
	/*
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		
		this.doEffect((EntityPlayer)player, itemstack);	
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20, 0));
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
	*/
}
