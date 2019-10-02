package gaia.item.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemWeaponBookMetal extends ItemWeaponBook {

	public ItemWeaponBookMetal(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		final PlayerEntity player = Minecraft.getInstance().player;
		if (player == null) {
			return;
		}
		if (player.getHeldItemOffhand() == stack) {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.BlessOffhand").applyTextStyle(TextFormatting.YELLOW));
		} else {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.BlessMainhand").applyTextStyle(TextFormatting.YELLOW));
		}

		tooltip.add(new TranslationTextComponent("effect.minecraft.nausea").appendSibling(new StringTextComponent(" (0:04)")));
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity host) {
		stack.damageItem(1, host, (entity) -> { entity.sendBreakAnimation(host.getActiveHand()); });
		host.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new EffectInstance(Effects.NAUSEA, 80, 0));
		return true;
	}
}
