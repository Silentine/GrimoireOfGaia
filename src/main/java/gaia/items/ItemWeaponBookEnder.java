package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBookEnder extends ItemSword {
	private float weaponDamage;
	private final Item.ToolMaterial toolMaterial;
	String texture;

	public ItemWeaponBookEnder(String texture) {
		super(Item.ToolMaterial.IRON);
		this.toolMaterial = Item.ToolMaterial.IRON;
		this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses()*3.48F));
		this.weaponDamage = Item.ToolMaterial.IRON.getDamageVsEntity();
		this.texture = texture;
		this.setUnlocalizedName(texture);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}

	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
		par1ItemStack.damageItem(5, par3EntityPlayer);
		par3EntityPlayer.addExhaustion(5.0F);
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!par2World.isRemote) {
			par2World.spawnEntityInWorld(new EntityEnderPearl(par2World, par3EntityPlayer));
		}
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("potion.blindness") + " (0:04)");
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		par2EntityLiving.addPotionEffect(new PotionEffect(Potion.blindness.id, 80, 0));
		return true;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.BOW;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return Items.ender_pearl == par2ItemStack.getItem()?true:super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}
