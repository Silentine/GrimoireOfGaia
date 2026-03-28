package gaia.item.weapon;

import gaia.entity.projectile.MagicProjectile;
import gaia.registry.GaiaSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.Tags;

import java.util.function.Consumer;

public class MagicStaffItem extends Item {

	public MagicStaffItem(Properties properties) {
		super(properties.repairable(Tags.Items.GEMS_LAPIS));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (livingEntity instanceof Player player) {
			stack.hurtAndBreak(1, player, player.getUsedItemHand().asEquipmentSlot());

			if (level instanceof ServerLevel serverLevel) {
				livingEntity.playSound(GaiaSounds.GAIA_SHOOT.get(), 1.0F, 1.0F / (livingEntity.getRandom().nextFloat() * 0.4F + 0.8F));

				MagicProjectile magic = new MagicProjectile(level, livingEntity, Vec3.ZERO);
				if (magic != null) {
					magic.setOwner(livingEntity);
					magic.setDamage(4.0F);
					magic.setPos(livingEntity.getX(), livingEntity.getY(0.5D) + 0.5D, livingEntity.getZ());
					magic.setOwner(livingEntity);
					magic.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
					serverLevel.addFreshEntity(magic);
				}
			}

			player.playSound(SoundEvents.CHICKEN_EGG, 0.5F, level.getRandom().nextFloat() * 0.1F + 0.9F);
		} else {
			stack.shrink(1);
		}
		return super.finishUsingItem(stack, level, livingEntity);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		player.startUsingItem(hand);
		return InteractionResult.CONSUME;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		builder.accept(Component.translatable("text.grimoireofgaia.magic_staff.desc").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
		return 30;
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack stack) {
		return ItemUseAnimation.BOW;
	}

	@Override
	public boolean isPrimaryItemFor(ItemStack stack, Holder<Enchantment> enchantment) {
		return enchantment != Enchantments.MENDING && super.isPrimaryItemFor(stack, enchantment);
	}
}
