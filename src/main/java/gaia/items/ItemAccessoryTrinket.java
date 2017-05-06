package gaia.items;

import gaia.Gaia;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import baubles.api.BaubleType;
import baubles.api.IBauble;

@InterfaceList({
	@Interface(iface="baubles.api.IBauble", modid="Baubles", striprefs=true),
	@Interface(iface="baubles.api.BaubleType", modid="Baubles", striprefs=true)})

public class ItemAccessoryTrinket extends Item implements IBauble {
	
	public ItemAccessoryTrinket() {
		this.setMaxStackSize(1);
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		EntityPlayer player = (EntityPlayer)entityIn;
		
		if (!(entityIn instanceof EntityPlayer))
			return;
		
		int i = 8;

		if (player.inventory.getStackInSlot(i) == stack) {
			this.doEffect(player, stack);
		}
	}

	public void doEffect(EntityPlayer player, ItemStack item) {}

	//==================== Bauble ===================//
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.CHARM;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		this.doEffect((EntityPlayer)player, itemstack);	
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
}
