package gaia.item.weapon;

import gaia.Reference;
import gaia.registry.GaiaRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SummonStaffItem extends Item {

	private final Supplier<EntityType<? extends Mob>> typeSupplier;

	public SummonStaffItem(Properties properties, Supplier<EntityType<? extends Mob>> typeSupplier, @NotNull Item repairIngredient) {
		super(properties.repairable(repairIngredient));
		this.typeSupplier = typeSupplier;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (livingEntity instanceof Player player) {
			stack.hurtAndBreak(1, player, player.getUsedItemHand().asEquipmentSlot());

			if (level instanceof ServerLevel serverLevel) {
				BlockPos spawnPos = BlockPos.containing(player.getEyePosition()).relative(player.getDirection());
				Mob summon = typeSupplier.get().create(level, EntitySpawnReason.MOB_SUMMONED);
				summon.snapTo(spawnPos, 0.0F, 0.0F);
				EventHooks.finalizeMobSpawn(summon, serverLevel, serverLevel.getCurrentDifficultyAt(spawnPos), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
				summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaiaRegistry.HEADGEAR_BOLT.get()));
				summon.setDropChance(EquipmentSlot.MAINHAND, 0);
				summon.setDropChance(EquipmentSlot.OFFHAND, 0);
				summon.setDropChance(EquipmentSlot.FEET, 0);
				summon.setDropChance(EquipmentSlot.LEGS, 0);
				summon.setDropChance(EquipmentSlot.CHEST, 0);
				summon.setDropChance(EquipmentSlot.HEAD, 0);

				CompoundTag tag = summon.getPersistentData();
				tag.putBoolean(Reference.SUMMONED_TAG, true);
				tag.store(Reference.SUMMONER_TAG, UUIDUtil.CODEC, livingEntity.getUUID());

				summon.targetSelector.getAvailableGoals().removeIf(goal -> goal.getGoal() instanceof NearestAttackableTargetGoal<?>);
				summon.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(summon, Monster.class, true, (living, serverLevel1) -> {
					return !tag.contains(Reference.SUMMONED_TAG) && (living instanceof Monster && !(living instanceof NeutralMob) ||
							(living instanceof NeutralMob neutralMob && neutralMob.getPersistentAngerTarget().equals(livingEntity.getUUID())));
				}));
				level.addFreshEntity(summon);
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
		return InteractionResult.SUCCESS;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		builder.accept(Component.translatable("text.grimoireofgaia.summoning_staff.desc", Component.translatable(typeSupplier.get().getDescriptionId()).getString()).withStyle(ChatFormatting.GRAY));
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
