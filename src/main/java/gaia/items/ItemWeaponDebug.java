package gaia.items;

import gaia.Gaia;
import gaia.init.Sounds;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Multimap;

/** 
 * Used for debugging health related coding
 * @see ItemSword
 */
public class ItemWeaponDebug extends Item {

	private float attackDamage;

	public ItemWeaponDebug(String name) {
		//this.attackDamage = 500;
		this.attackDamage = 0;
		this.maxStackSize = 1;
		this.setMaxDamage(Item.ToolMaterial.IRON.getMaxUses());
		this.setCreativeTab(Gaia.tabGaia);
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		EntityPlayer player = host instanceof EntityPlayer ? (EntityPlayer)host : null;
		player.playSound(Sounds.book_hit, 1.0F, 1.0F);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		if ((double)state.getBlockHardness(worldIn, pos) != 0.0D) {
			stack.damageItem(2, entityLiving);
		}

		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
		}

		return multimap;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(TextFormatting.BOLD + (I18n.translateToLocal("text.GrimoireOfGaia.Debug")));
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.WeaponDebug.desc"));
	}


	/*
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
		if (!player.isPotionActive(MobEffects.REGENERATION)) {
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 60, 4, true, false));		
		}
	}
	 */
}
