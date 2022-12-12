package gaia.item.accessory;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractAccessoryItem extends Item {
	public AbstractAccessoryItem(Properties properties) {
		super(properties.rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.add(new TranslatableComponent("text.grimoireofgaia.charm.tag").withStyle(ChatFormatting.YELLOW));
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return ModList.get().isLoaded("curios");
	}

	public boolean isModifier() {
		return false;
	}

	public abstract void doEffect(LivingEntity player, ItemStack stack);

	public abstract void applyModifier(LivingEntity player, ItemStack stack);

	public abstract void removeModifier(LivingEntity player, ItemStack stack);

	public void onEquip(LivingEntity livingEntity, ItemStack stack) {
		if (isModifier()) {
			applyModifier(livingEntity, stack);
		}
	}

	public void onUnequip(LivingEntity livingEntity, ItemStack stack) {
		if (isModifier()) {
			removeModifier(livingEntity, stack);
		}
	}

	public void onTick(LivingEntity livingEntity, ItemStack stack) {
		doEffect(livingEntity, stack);
	}

	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		if (ModList.get().isLoaded("curios")) {
			return gaia.compat.curios.CuriosCompat.getCapability(stack);
		}
		return super.initCapabilities(stack, nbt);
	}
}
