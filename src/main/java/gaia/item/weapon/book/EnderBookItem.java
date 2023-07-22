package gaia.item.weapon.book;

import gaia.registry.GaiaSounds;
import gaia.util.RandomUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnderBookItem extends WeaponBookItem {
	public EnderBookItem(Tier tier, Properties properties) {
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
		list.add(Component.translatable(MobEffects.BLINDNESS.getDescriptionId()).append(" II (0:04)"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);

		if (!level.isClientSide) {
			stack.hurtAndBreak(5, player, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		}
		player.causeFoodExhaustion(5.0F);
		level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL,
				0.5F, 0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F));

		if (!level.isClientSide) {
			ThrownEnderpearl enderpearl = new ThrownEnderpearl(level, player);
			enderpearl.setItem(new ItemStack(Items.ENDER_PEARL));
			enderpearl.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
			level.addFreshEntity(enderpearl);
		}

		player.getCooldowns().addCooldown(this, 60);
		player.awardStat(Stats.ITEM_USED.get(this));

		return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		super.hurtEnemy(stack, target, attacker);

		attacker.level.playSound((Player) null, attacker.getX(), attacker.getY(), attacker.getZ(), GaiaSounds.BOOK_HIT.get(), SoundSource.NEUTRAL,
				1.0F, 1.0F);
		target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 1));

		return true;
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairStack.is(Tags.Items.ENDER_PEARLS);
	}
}
