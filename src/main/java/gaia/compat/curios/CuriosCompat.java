package gaia.compat.curios;

import gaia.item.accessory.AbstractAccessoryItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CuriosCompat {

	public static void sendImc(InterModEnqueueEvent event) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("charm")
				.size(1).build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("body")
				.size(1).build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("head")
				.size(1).build());
	}

	public static ICapabilityProvider getCapability(ItemStack stack) {
		ICurio curio = new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				if (stack.getItem() instanceof AbstractAccessoryItem accessoryItem) {
					accessoryItem.onEquip(slotContext.entity(), stack);
				}
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				if (stack.getItem() instanceof AbstractAccessoryItem accessoryItem) {
					accessoryItem.onUnequip(slotContext.entity(), stack);
				}
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				if (stack.getItem() instanceof AbstractAccessoryItem accessoryItem) {
					accessoryItem.onTick(slotContext.entity(), stack);
				}
			}

			@Override
			public boolean canEquipFromUse(SlotContext ctx) {
				return true;
			}
		};

		ICapabilityProvider provider = new ICapabilityProvider() {
			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

			@Nonnull
			@Override
			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap,
													 @Nullable Direction side) {
				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
			}
		};
		return provider;
	}
}
