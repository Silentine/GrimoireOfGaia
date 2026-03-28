package gaia.item.weapon.book;

import gaia.registry.GaiaSounds;
import gaia.util.RandomUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class WitherBookItem extends WeaponBookItem {
	public WitherBookItem(ToolMaterial material, Properties properties) {
		super(material, properties);
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
		builder.accept(Component.translatable(MobEffects.WITHER.value().getDescriptionId()).append(" II (0:04)"));
	}

	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		super.hurtEnemy(stack, target, attacker);

		attacker.level().playSound((Player) null, attacker.getX(), attacker.getY(), attacker.getZ(), GaiaSounds.BOOK_HIT.get(), SoundSource.NEUTRAL,
				1.0F, 1.0F);
		target.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 1));
	}
}
