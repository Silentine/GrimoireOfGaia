package gaia.item.edible;

import gaia.entity.AbstractGaiaEntity;
import gaia.registry.GaiaRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class MonsterFeedItem extends Item {
	public MonsterFeedItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		builder.accept(Component.translatable("text.grimoireofgaia.monster_feed.desc"));
		if (itemStack.is(GaiaRegistry.MONSTER_FEED.get())) {
			builder.accept(Component.translatable("text.grimoireofgaia.food_monster_feed.desc"));
		} else {
			builder.accept(Component.translatable("text.grimoireofgaia.premium_food_monster_feed.desc"));
		}
		builder.accept(Component.translatable("item.grimoireofgaia.food_monster_feed2.desc"));
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
		if (livingEntity instanceof AbstractGaiaEntity gaiaEntity) {
			if (!gaiaEntity.isFriendly()) {
				gaiaEntity.level().broadcastEntityEvent(gaiaEntity, (byte) 8);
				if (!player.getAbilities().instabuild) {
					stack.shrink(1);
				}
				gaiaEntity.setFriendly(true, player.getUUID());
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}
