package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;

/** 
 * Used for debugging health related coding
 * @see ItemSword
 */
public class ItemWeaponDebug extends Item {

	private float attackDamage;

	public ItemWeaponDebug(String name) {
		this.attackDamage = 500;
		this.maxStackSize = 1;
		this.setMaxDamage(780);
//		this.setCreativeTab(Gaia.tabGaia);
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}
	
	/** https://github.com/Flaxbeard/Cyberware/blob/4bae328ee0a714900094d3f203b3281af3e048c4/src/main/java/flaxbeard/cyberware/common/handler/CyberwareMenuHandler.java **/
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.Debug.tag")));
		if (shiftPressed) {
			tooltip.add(I18n.translateToLocal("item.GrimoireOfGaia.WeaponDebug.desc"));
		} else {
			tooltip.add(TextFormatting.ITALIC + (I18n.translateToLocal("text.GrimoireOfGaia.HoldShift")));
		}
	}
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		EntityPlayer player = (EntityPlayer)entityIn;

		for (int i = 0; i < 9; ++i) {
			if (player.inventory.getStackInSlot(i) == stack) {
				this.doEffect(player, stack);
				break;
			}
		}
	}

	public void doEffect(EntityPlayer player, ItemStack item) {	
		if (!player.isPotionActive(MobEffects.REGENERATION)) {
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 4, true, false));		
		}
	}
}
