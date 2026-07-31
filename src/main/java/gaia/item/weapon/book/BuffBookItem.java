package gaia.item.weapon.book;

import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.RandomUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class BuffBookItem extends GaiaBookItem {
	public BuffBookItem(Properties properties) {
		super(properties.repairable(GaiaRegistry.QUILL.get()));
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {

		final Player player = RandomUtil.getPlayer();
		if (player == null) {
			return;
		}
		if (player.getOffhandItem() == itemStack) {
			builder.accept(Component.translatable("text.grimoireofgaia.bless.off_hand").withStyle(ChatFormatting.YELLOW));
		} else {
			builder.accept(Component.translatable("text.grimoireofgaia.bless.main_hand").withStyle(ChatFormatting.YELLOW));
		}

		builder.accept(Component.translatable(MobEffects.STRENGTH.value().getDescriptionId()).append(" I(1:00)"));
		builder.accept(Component.translatable(MobEffects.RESISTANCE.value().getDescriptionId()).append(" (1:00)"));
		builder.accept(Component.translatable(MobEffects.REGENERATION.value().getDescriptionId()).append(" IV (0:04)"));
	}

	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		executeHurtEffect(stack, target, attacker);
	}

	@Override
	public void executeHurtEffect(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);

		attacker.level().playSound((Player) null, attacker.getX(), attacker.getY(), attacker.getZ(), GaiaSounds.BOOK_HIT.get(), SoundSource.NEUTRAL,
				1.0F, 1.0F);
		target.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 600, 0));
		target.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 600, 0));
		target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 3));
	}

	public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity livingEntity) {
		if (state.getDestroySpeed(level, pos) != 0.0F) {
			stack.hurtAndBreak(2, livingEntity, EquipmentSlot.MAINHAND);
		}

		return true;
	}
}
