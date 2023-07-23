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
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HungerBookItem extends WeaponBookItem {
	public HungerBookItem(Tier tier, Properties properties) {
		super(tier, properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);

		final Player player = RandomUtil.getPlayer();
		if (player == null) {
			return;
		}
		if (player.getOffhandItem() == stack) {
			list.add(Component.translatable("text.grimoireofgaia.bless.off_hand").withStyle(ChatFormatting.YELLOW));
		} else {
			list.add(Component.translatable("text.grimoireofgaia.bless.main_hand").withStyle(ChatFormatting.YELLOW));
		}
		list.add(Component.translatable(MobEffects.HUNGER.getDescriptionId()).append(" II (0:04)"));
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		super.hurtEnemy(stack, target, attacker);

		attacker.level().playSound((Player) null, attacker.getX(), attacker.getY(), attacker.getZ(), GaiaSounds.BOOK_HIT.get(), SoundSource.NEUTRAL,
				1.0F, 1.0F);
		target.addEffect(new MobEffectInstance(MobEffects.HUNGER, 80, 1));

		return true;
	}
}
