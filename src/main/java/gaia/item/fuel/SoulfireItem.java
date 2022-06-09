package gaia.item.fuel;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoulfireItem extends FuelItem {

	public SoulfireItem(Properties properties) {
		super(properties, 11600);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();
		Level level = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
			BlockPos relativePos = blockpos.relative(context.getClickedFace());
			if (BaseFireBlock.canBePlacedAt(level, relativePos, context.getHorizontalDirection())) {
				level.playSound(player, relativePos, SoundEvents.GHAST_SCREAM, SoundSource.PLAYERS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
				BlockState blockstate1 = BaseFireBlock.getState(level, relativePos);
				level.setBlock(relativePos, blockstate1, 11);
				level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
				ItemStack stack = context.getItemInHand();
				if (player instanceof ServerPlayer) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, relativePos, stack);
					stack.hurtAndBreak(1, player, (p_41300_) -> {
						p_41300_.broadcastBreakEvent(context.getHand());
					});
				}

				return InteractionResult.sidedSuccess(level.isClientSide());
			} else {
				return InteractionResult.FAIL;
			}
		} else {
			level.playSound(player, blockpos, SoundEvents.GHAST_SCREAM, SoundSource.PLAYERS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
			level.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.TRUE), 11);
			level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
			if (player != null) {
				context.getItemInHand().hurtAndBreak(1, player, (p_41303_) -> {
					p_41303_.broadcastBreakEvent(context.getHand());
				});
			}

			return InteractionResult.sidedSuccess(level.isClientSide());
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.add(new TranslatableComponent("text.grimoireofgaia.soulfire.desc").withStyle(ChatFormatting.ITALIC));
	}
}
