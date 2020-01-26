package gaia.items;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.apache.commons.lang3.Range;
import org.lwjgl.input.Keyboard;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAccessoryCharmDamageIron extends ItemAccessoryBauble {

	private static int damage = 2;
	private static final AttributeModifier BOOST = new AttributeModifier(UUID.fromString("d2cc095e-1f15-49a9-a32b-993e7f5c4910"), "GoG Iron Damage boost", 2.0D, 0);
	
	public ItemAccessoryCharmDamageIron() {
		super("accessory_charm_damage_iron");
		setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.CHARM;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Charm.tag")));

		if (shiftPressed) {
			if (!isBaublesLoaded) {
				tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.InventoryCharm")));
			}
			tooltip.add(I18n.format("text.grimoireofgaia.CharmDamage", damage));
		} else {
			tooltip.add(TextFormatting.ITALIC + (I18n.format("text.grimoireofgaia.HoldShift")));
		}
	}

	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(7, 7);
	}
	
	@Override
	public boolean isModifier() {
		return true;
	}
	
	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
	}

	@Override
	public void applyModifier(EntityLivingBase player, ItemStack item) {
		ModifiableAttributeInstance attribute = (ModifiableAttributeInstance) player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		if (!attribute.hasModifier(BOOST)) {
			attribute.applyModifier(BOOST);
		}
	}

	@Override
	public void removeModifier(EntityLivingBase player, ItemStack item) {
		ModifiableAttributeInstance attribute = (ModifiableAttributeInstance) player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		if (attribute.hasModifier(BOOST)) {
			attribute.removeModifier(BOOST);
		}
	}
}
