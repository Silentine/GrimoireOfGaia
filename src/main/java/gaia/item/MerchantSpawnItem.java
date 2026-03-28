package gaia.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

public class MerchantSpawnItem extends Item {
	private final Supplier<? extends EntityType<? extends Mob>> typeSupplier;

	public MerchantSpawnItem(Supplier<? extends EntityType<? extends Mob>> type, Properties properties) {
		super(properties);

		this.typeSupplier = type;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		if (!(level instanceof ServerLevel)) {
			return InteractionResult.SUCCESS;
		} else {
			ItemStack itemstack = context.getItemInHand();
			BlockPos blockpos = context.getClickedPos();
			Direction direction = context.getClickedFace();
			BlockState blockstate = level.getBlockState(blockpos);
			BlockPos blockpos1;
			if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
				blockpos1 = blockpos;
			} else {
				blockpos1 = blockpos.relative(direction);
			}

			EntityType<?> entitytype = typeSupplier.get();
			if (entitytype.spawn((ServerLevel) level, itemstack, context.getPlayer(), blockpos1, EntitySpawnReason.SPAWN_ITEM_USE, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
				itemstack.shrink(1);
				level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
			}

			return InteractionResult.CONSUME;
		}
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);
		BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
		if (hitResult.getType() != HitResult.Type.BLOCK) {
			return InteractionResult.PASS;
		} else if (level instanceof ServerLevel) {
			BlockPos pos = hitResult.getBlockPos();
			if (!(level.getBlockState(pos).getBlock() instanceof LiquidBlock)) {
				return InteractionResult.PASS;
			} else if (level.mayInteract(player, pos) && player.mayUseItemAt(pos, hitResult.getDirection(), itemStack)) {
				InteractionResult result = spawnMob(player, itemStack, level, pos, false, false);
				if (result == InteractionResult.SUCCESS) {
					player.awardStat(Stats.ITEM_USED.get(this));
				}

				return result;
			} else {
				return InteractionResult.FAIL;
			}
		} else {
			return InteractionResult.SUCCESS;
		}
	}

	private InteractionResult spawnMob(
			@Nullable LivingEntity user, ItemStack itemStack, Level level, BlockPos spawnPos, boolean tryMoveDown, boolean movedUp
	) {
		EntityType<?> type = typeSupplier.get();
		if (type == null) {
			return InteractionResult.FAIL;
		} else if (!type.isAllowedInPeaceful() && level.getDifficulty() == Difficulty.PEACEFUL) {
			return InteractionResult.FAIL;
		} else {
			if (type.spawn((ServerLevel)level, itemStack, user, spawnPos, EntitySpawnReason.SPAWN_ITEM_USE, tryMoveDown, movedUp) != null) {
				itemStack.consume(1, user);
				level.gameEvent(user, GameEvent.ENTITY_PLACE, spawnPos);
			}

			return InteractionResult.SUCCESS;
		}
	}
}
