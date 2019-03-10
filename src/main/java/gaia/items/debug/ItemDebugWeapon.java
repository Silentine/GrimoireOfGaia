package gaia.items.debug;

import java.util.List;

import com.google.common.collect.Multimap;

import gaia.items.ItemBase;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * DEBUG weapon
 * 
 * Disable item in GaiaItems before release.
 */
public class ItemDebugWeapon extends ItemBase {
	private int attackDamage;

	public ItemDebugWeapon(Item.Properties builder) {
		super(builder.maxStackSize(1).defaultMaxDamage(780)); //"debug_weapon");
//		setMaxDamage(780);
		attackDamage = 256;

//		setCreativeTab(null);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	/**
	 * @reference https://github.com/Flaxbeard/Cyberware/blob/master/src/main/java/flaxbeard/cyberware/common/handler/CyberwareMenuHandler.java
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = GuiScreen.isShiftKeyDown();
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.Debug.tag").applyTextStyle(TextFormatting.YELLOW));

		if (shiftPressed) {
			tooltip.add(new TextComponentTranslation("item.grimoireofgaia.weapon_debug.desc"));
			tooltip.add(new TextComponentTranslation("effect.minecraft.regeneration"));
		} else {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.HoldShift").applyTextStyle(TextFormatting.ITALIC));
		}
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot, ItemStack itemStack) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot, itemStack);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) attackDamage, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
		}

		return multimap;
	}

//	@Override
//	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
//		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
//		EntityPlayer player = (EntityPlayer) entityIn;
//
//		for (int i = 0; i < 9; ++i) {
//			if (player.inventory.getStackInSlot(i) == stack) {
//
//				doEffect(player);
//
//				break;
//			}
//		}
//	}

//	@Override
//	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
//		if (!isInCreativeTab(tab)) {
//			return;
//		}
//
//		ItemStack stack = new ItemStack(this, 1, 0);
//		stack.addEnchantment(Enchantments.LOOTING, 10);
//		items.add(stack);
//	}
	
//	public void doEffect(EntityPlayer player) {
//		if (!player.isPotionActive(MobEffects.REGENERATION)) {
//			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 4, true, false));
//		}
//	}
}
