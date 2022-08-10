package gaia.item.edible;

import gaia.entity.AbstractGaiaEntity;
import gaia.registry.GaiaRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MonsterFeedItem extends Item {
	public MonsterFeedItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.add(new TranslatableComponent("text.grimoireofgaia.monster_feed.desc"));
		if (stack.is(GaiaRegistry.MONSTER_FEED.get())) {
			list.add(new TranslatableComponent("text.grimoireofgaia.food_monster_feed.desc"));
		} else {
			list.add(new TranslatableComponent("text.grimoireofgaia.premium_food_monster_feed.desc"));
		}
		list.add(new TranslatableComponent("item.grimoireofgaia.food_monster_feed2.desc"));
	}

	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
		if (livingEntity instanceof AbstractGaiaEntity gaiaEntity) {
			if (!gaiaEntity.isFriendly()) {
				gaiaEntity.level.broadcastEntityEvent(gaiaEntity, (byte) 8);
				if (!player.getAbilities().instabuild) {
					stack.shrink(1);
				}
				gaiaEntity.setFriendly(true, player.getUUID());
				return InteractionResult.sidedSuccess(player.level.isClientSide);
			}
		}
		return InteractionResult.PASS;
	}
}
