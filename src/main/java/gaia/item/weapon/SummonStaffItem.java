package gaia.item.weapon;

import gaia.Reference;
import gaia.registry.GaiaRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeI18n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class SummonStaffItem extends Item {

	private final Supplier<EntityType<? extends Mob>> typeSupplier;
	private final Supplier<Ingredient> repairIngredient;

	public SummonStaffItem(Properties properties, Supplier<EntityType<? extends Mob>> typeSupplier, @NotNull Supplier<Ingredient> repairIngredient) {
		super(properties);
		this.typeSupplier = typeSupplier;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairIngredient.get().test(repairStack);
	}

	@Override
	public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
		super.releaseUsing(stack, level, livingEntity, timeLeft);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (livingEntity instanceof Player player) {
			stack.hurtAndBreak(1, player, (p) -> {
				p.broadcastBreakEvent(player.getUsedItemHand());
			});

			if (!level.isClientSide) {
				BlockPos spawnPos = new BlockPos(player.getEyePosition()).relative(player.getDirection());
				Mob summon = typeSupplier.get().create(level);
				summon.moveTo(spawnPos, 0.0F, 0.0F);
				summon.finalizeSpawn((ServerLevel) level, level.getCurrentDifficultyAt(spawnPos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
				summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaiaRegistry.HEADGEAR_BOLT.get()));
				summon.setDropChance(EquipmentSlot.MAINHAND, 0);
				summon.setDropChance(EquipmentSlot.OFFHAND, 0);
				summon.setDropChance(EquipmentSlot.FEET, 0);
				summon.setDropChance(EquipmentSlot.LEGS, 0);
				summon.setDropChance(EquipmentSlot.CHEST, 0);
				summon.setDropChance(EquipmentSlot.HEAD, 0);

				CompoundTag tag = summon.getPersistentData();
				tag.putBoolean(Reference.SUMMONED_TAG, true);
				tag.putUUID(Reference.SUMMONER_TAG, livingEntity.getUUID());

				summon.targetSelector.getAvailableGoals().removeIf(goal -> goal.getGoal() instanceof NearestAttackableTargetGoal<?>);
				summon.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(summon, Monster.class, true, living -> {
					return !tag.contains(Reference.SUMMONED_TAG) && (living instanceof Monster && !(living instanceof NeutralMob) ||
							(living instanceof NeutralMob neutralMob && neutralMob.getPersistentAngerTarget().equals(livingEntity.getUUID())));
				}));
				level.addFreshEntity(summon);
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
		list.add(Component.translatable("text.grimoireofgaia.summoning_staff.desc", ForgeI18n.getPattern(typeSupplier.get().getDescriptionId())).withStyle(ChatFormatting.GRAY));
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
