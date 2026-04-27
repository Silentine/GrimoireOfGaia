package gaia.item.edible.consume_effects;

import com.mojang.serialization.MapCodec;
import gaia.registry.GaiaConsumeEffects;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public record ClearNegativeStatusEffectsConsumeEffect() implements ConsumeEffect {
	public static final ClearNegativeStatusEffectsConsumeEffect INSTANCE = new ClearNegativeStatusEffectsConsumeEffect();
	public static final MapCodec<ClearNegativeStatusEffectsConsumeEffect> CODEC = MapCodec.unit(INSTANCE);
	public static final StreamCodec<RegistryFriendlyByteBuf, ClearNegativeStatusEffectsConsumeEffect> STREAM_CODEC = StreamCodec.unit(INSTANCE);

	@Override
	public ConsumeEffect.Type<ClearNegativeStatusEffectsConsumeEffect> getType() {
		return GaiaConsumeEffects.CLEAR_NEGATIVE_EFFECTS.get();
	}

	@Override
	public boolean apply(Level level, ItemStack stack, LivingEntity user) {
		List<Holder<MobEffect>> effectsToRemove = new ArrayList<>();
		for (MobEffectInstance instance : user.getActiveEffects()) {
			if (instance.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
				effectsToRemove.add(instance.getEffect());
			}
		}
		effectsToRemove.forEach(user::removeEffect);
		return true;
	}
}