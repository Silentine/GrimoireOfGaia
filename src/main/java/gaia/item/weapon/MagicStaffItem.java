package gaia.item.weapon;

import gaia.entity.projectile.MagicProjectile;
import gaia.registry.GaiaSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class MagicStaffItem extends Item {

	public MagicStaffItem(Properties properties, Supplier<EntityType<? extends Mob>> typeSupplier) {
		super(properties);
	}

	@Override
	public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
		super.releaseUsing(stack, level, livingEntity, timeLeft);
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairStack.is(Tags.Items.GEMS_LAPIS);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (livingEntity instanceof Player player) {
			stack.hurtAndBreak(1, player, (p) -> {
				p.broadcastBreakEvent(player.getUsedItemHand());
			});

			if (!level.isClientSide) {
				livingEntity.playSound(GaiaSounds.GAIA_SHOOT.get(), 1.0F, 1.0F / (livingEntity.getRandom().nextFloat() * 0.4F + 0.8F));

				MagicProjectile magic = new MagicProjectile(level);
				magic.setOwner(livingEntity);
				magic.setDamage(4.0F);
				magic.setPos(livingEntity.getX(), livingEntity.getY(0.5D) + 0.5D, livingEntity.getZ());
				magic.setOwner(livingEntity);
				magic.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
				livingEntity.level().addFreshEntity(magic);
			}

			player.playSound(SoundEvents.CHICKEN_EGG, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
		} else {
			stack.shrink(1);
		}
		return super.finishUsingItem(stack, level, livingEntity);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemstack = player.getItemInHand(interactionHand);
		player.startUsingItem(interactionHand);
		return InteractionResultHolder.consume(itemstack);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.add(Component.translatable("text.grimoireofgaia.magic_staff.desc").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 30;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment != Enchantments.MENDING && super.canApplyAtEnchantingTable(stack, enchantment);
	}
}
