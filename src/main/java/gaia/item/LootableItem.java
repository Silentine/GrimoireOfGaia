package gaia.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class LootableItem extends Item {
	private final ResourceLocation lootTable;
	private final Supplier<SoundEvent> openSoundSupplier;

	public LootableItem(Properties properties, ResourceLocation lootTable, Supplier<SoundEvent> openSoundSupplier) {
		super(properties);
		this.lootTable = lootTable;
		this.openSoundSupplier = openSoundSupplier;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		final ItemStack stack = player.getItemInHand(hand);

		player.playSound(openSoundSupplier.get(), 0.5F, level.random.nextFloat() * 0.1F + 0.9F);

		if (!player.getAbilities().instabuild) {
			stack.shrink(1);
		}

		if (!level.isClientSide) {
			LootTable lootTable = level.getServer().getLootData().getLootTable(this.lootTable);
			LootParams.Builder builder = (new LootParams.Builder((ServerLevel) level))
					.withParameter(LootContextParams.ORIGIN, player.position());
			if (player != null) {
				builder.withLuck(player.getLuck());
			}
			List<ItemStack> lootStacks = lootTable.getRandomItems(builder.create(LootContextParamSets.CHEST));
			//TODO: Maybe add a UI?
			for (ItemStack lootStack : lootStacks) {
				ItemHandlerHelper.giveItemToPlayer(player, lootStack);
			}
		}

		return InteractionResultHolder.success(stack);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.add(Component.translatable("text.grimoireofgaia.right_click_use"));
	}
}
