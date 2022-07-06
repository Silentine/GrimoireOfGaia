package gaia.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class GaiaFoods {
	public static final FoodProperties TAPROOT = (new FoodProperties.Builder()).nutrition(0).saturationMod(0).build();
	public static final FoodProperties MEAT = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).meat().build();
	public static final FoodProperties ROTTEN_HEART = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 10 * 20, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 30 * 20, 0), 0.8F).meat().build();

	public static final FoodProperties GOLDEN_APPLY_PIE = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 4), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F).build();

	public static final FoodProperties GOLDEN_APPLY_PIE_SLICE = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 80, 4), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0), 1.0F).build();

	public static final FoodProperties HONEYDEW = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10 * 20, 0), 0.2F)
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20, 0), 0.2F).build();
}
