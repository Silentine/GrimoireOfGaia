package gaia.items;

import java.util.List;

import com.google.common.collect.Multimap;

import gaia.Gaia;
import gaia.init.GaiaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponFanFire extends Item {
	private int weaponDamage;
	String texture;

	public ItemWeaponFanFire(String texture) {
		this.setMaxDamage(780);
		this.weaponDamage = 8;
		this.maxStackSize = 1;
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.WeaponFanFire");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}

	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.weaponDamage, 0));
		return multimap;
	}
	
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par1ItemStack.addEnchantment(Enchantment.fireAspect, 2);
		par1ItemStack.addEnchantment(Enchantment.knockback, 1);
	}

	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		ItemStack is = new ItemStack(par1, 1, 0);
		is.addEnchantment(Enchantment.fireAspect, 2);
		is.addEnchantment(Enchantment.knockback, 1);
		par3List.add(is);
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		return true;
	}

	public boolean isFull3D() {
		return true;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.BLOCK;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return GaiaItem.MiscSoulFiery == par2ItemStack.getItem()?true:super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	/*public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}*/
}
