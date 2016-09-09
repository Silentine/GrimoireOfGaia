package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItem;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Multimap;

public class ItemWeaponFanIce extends Item {
	private int weaponDamage;
	String texture;

	public ItemWeaponFanIce(String texture) {
		this.setMaxDamage(780);
		this.weaponDamage = 0;
		this.maxStackSize = 1;
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.WeaponFanIce");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	/*
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Tool modifier", (double)this.weaponDamage, 0));
		return multimap;
	}
	*/
	public Multimap getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap multimap = super.getAttributeModifiers(slot, stack);
		multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier( "Tool modifier", (double)this.weaponDamage, 0));
		return multimap;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("effect.moveSlowdown") + " IV" + " (0:05)");
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 3));
		return true;
	}
		
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		//stack.addEnchantment(Enchantment.knockback, 2);
		stack.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 2);
	}

	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		ItemStack is = new ItemStack(par1, 1, 0);
		//TODO
		//is.addEnchantment(Enchantment.knockback, 2);
		is.addEnchantment(Enchantment.getEnchantmentByID(18), 2);
		par3List.add(is);
	}

	public boolean isFull3D() {
		return true;
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BLOCK;
	}

	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}
	/* TODO
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	*/
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

	public boolean getIsRepairable(ItemStack stack, ItemStack par2ItemStack) {
		return GaiaItem.MiscSoulFire == par2ItemStack.getItem()?true:super.getIsRepairable(stack, par2ItemStack);
	}
}
