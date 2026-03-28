package gaia.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootableItem extends Item {
	private final ResourceKey<LootTable> lootTable;
	private final Supplier<SoundEvent> openSoundSupplier;

	public LootableItem(Properties properties, ResourceKey<LootTable> lootTable, Supplier<SoundEvent> openSoundSupplier) {
		super(properties);
		this.lootTable = lootTable;
		this.openSoundSupplier = openSoundSupplier;
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		final ItemStack stack = player.getItemInHand(hand);

		player.playSound(openSoundSupplier.get(), 0.5F, level.getRandom().nextFloat() * 0.1F + 0.9F);

		if (level instanceof ServerLevel serverLevel) {
			LootTable lootTable = level.getServer().reloadableRegistries().getLootTable(this.lootTable);
			LootParams.Builder builder = (new LootParams.Builder(serverLevel))
					.withParameter(LootContextParams.ORIGIN, player.position());
			if (player != null) {
				builder.withLuck(player.getLuck());
			}
			List<ItemStack> lootStacks = lootTable.getRandomItems(builder.create(LootContextParamSets.CHEST));
			//TODO: Maybe add a UI?
			for (ItemStack lootStack : lootStacks) {
				if (player.getInventory().add(lootStack)) {
					player.spawnAtLocation(serverLevel, lootStack);
				}
			}
		}

		if (!player.getAbilities().instabuild) {
			stack.shrink(1);
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		builder.accept(Component.translatable("text.grimoireofgaia.right_click_use"));
	}
}
