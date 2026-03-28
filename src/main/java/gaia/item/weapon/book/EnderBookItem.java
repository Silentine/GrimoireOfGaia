package gaia.item.weapon.book;

import gaia.registry.GaiaSounds;
import gaia.util.RandomUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;

import java.util.function.Consumer;

public class EnderBookItem extends WeaponBookItem {
	public EnderBookItem(ToolMaterial material, Properties properties) {
		super(material, properties.repairable(Tags.Items.ENDER_PEARLS));
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
		builder.accept(Component.translatable(MobEffects.BLINDNESS.value().getDescriptionId()).append(" II (0:04)"));
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);

		if (!level.isClientSide()) {
			stack.hurtAndBreak(5, player, EquipmentSlot.MAINHAND);
		}
		player.causeFoodExhaustion(5.0F);
		level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL,
				0.5F, 0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F));

		if (!level.isClientSide()) {
			ThrownEnderpearl enderpearl = new ThrownEnderpearl(level, player, Items.ENDER_PEARL.getDefaultInstance());
			enderpearl.setItem(new ItemStack(Items.ENDER_PEARL));
			enderpearl.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
			level.addFreshEntity(enderpearl);
		}

		player.getCooldowns().addCooldown(stack, 60);
		player.awardStat(Stats.ITEM_USED.get(this));

		return InteractionResult.SUCCESS;
	}

	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		super.hurtEnemy(stack, target, attacker);

		attacker.level().playSound((Player) null, attacker.getX(), attacker.getY(), attacker.getZ(), GaiaSounds.BOOK_HIT.get(), SoundSource.NEUTRAL,
				1.0F, 1.0F);
		target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 1));
	}
}
