package gaia.registry;

import gaia.GrimoireOfGaia;
import gaia.item.edible.consume_effects.ClearNegativeStatusEffectsConsumeEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GaiaConsumeEffects {
	public static final DeferredRegister<ConsumeEffect.Type<?>> CONSUME_EFFECT_TYPES = DeferredRegister.create(Registries.CONSUME_EFFECT_TYPE, GrimoireOfGaia.MOD_ID);

	public static final Supplier<ConsumeEffect.Type<ClearNegativeStatusEffectsConsumeEffect>> CLEAR_NEGATIVE_EFFECTS =
			CONSUME_EFFECT_TYPES.register("clear_negative_effects", () -> new ConsumeEffect.Type<>(
					ClearNegativeStatusEffectsConsumeEffect.CODEC,
					ClearNegativeStatusEffectsConsumeEffect.STREAM_CODEC
			));

}
