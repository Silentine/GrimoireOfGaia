package gaia.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
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
			if (entitytype.spawn((ServerLevel) level, itemstack, context.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
				itemstack.shrink(1);
				level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
			}

			return InteractionResult.CONSUME;
		}
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
		if (hitresult.getType() != HitResult.Type.BLOCK) {
			return InteractionResultHolder.pass(itemstack);
		} else if (!(level instanceof ServerLevel)) {
			return InteractionResultHolder.success(itemstack);
		} else {
			BlockHitResult blockhitresult = (BlockHitResult) hitresult;
			BlockPos blockpos = blockhitresult.getBlockPos();
			if (!(level.getBlockState(blockpos).getBlock() instanceof LiquidBlock)) {
				return InteractionResultHolder.pass(itemstack);
			} else if (level.mayInteract(player, blockpos) && player.mayUseItemAt(blockpos, blockhitresult.getDirection(), itemstack)) {
				EntityType<?> entitytype = typeSupplier.get();
				Entity entity = entitytype.spawn((ServerLevel) level, itemstack, player, blockpos, MobSpawnType.SPAWN_EGG, false, false);
				if (entity == null) {
					return InteractionResultHolder.pass(itemstack);
				} else {
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					player.awardStat(Stats.ITEM_USED.get(this));
					level.gameEvent(player, GameEvent.ENTITY_PLACE, entity.position());
					return InteractionResultHolder.consume(itemstack);
				}
			} else {
				return InteractionResultHolder.fail(itemstack);
			}
		}
	}
}
