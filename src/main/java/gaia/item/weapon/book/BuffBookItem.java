package gaia.item.weapon.book;

import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.RandomUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BuffBookItem extends Item {
	public BuffBookItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);

		final Player player = RandomUtil.getPlayer();
		if (player == null) {
			return;
		}
		if (player.getOffhandItem() == stack) {
			list.add(new TranslatableComponent("text.grimoireofgaia.bless.off_hand").withStyle(ChatFormatting.YELLOW));
		} else {
			list.add(new TranslatableComponent("text.grimoireofgaia.bless.main_hand").withStyle(ChatFormatting.YELLOW));
		}

		list.add(new TranslatableComponent(MobEffects.DAMAGE_BOOST.getDescriptionId()).append(" I(1:00)"));
		list.add(new TranslatableComponent(MobEffects.DAMAGE_RESISTANCE.getDescriptionId()).append(" (1:00)"));
		list.add(new TranslatableComponent(MobEffects.REGENERATION.getDescriptionId()).append(" IV (0:04)"));
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (livingEntity) -> {
			livingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});

		attacker.level.playSound((Player) null, attacker.getX(), attacker.getY(), attacker.getZ(), GaiaSounds.BOOK_HIT.get(), SoundSource.NEUTRAL,
				1.0F, 1.0F);
		target.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0));
		target.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0));
		target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 3));

		return true;
	}

	public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity livingEntity) {
		if (state.getDestroySpeed(level, pos) != 0.0F) {
			stack.hurtAndBreak(2, livingEntity, (p_43276_) -> {
				p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		}

		return true;
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairStack.is(GaiaRegistry.QUILL.get());
	}
}
