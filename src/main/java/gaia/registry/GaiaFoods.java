package gaia.registry;

import java.util.List;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class GaiaFoods {
	public static final FoodProperties TAPROOT = (new FoodProperties.Builder()).nutrition(0).saturationModifier(0).build();
	public static final FoodProperties MEAT = (new FoodProperties.Builder()).nutrition(6).saturationModifier(1.2F).build();
	public static final FoodProperties ROTTEN_HEART = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.0F).alwaysEdible().build();
	public static final Consumable ROTTEN_HEART_CONSUMABLE = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 10 * 20, 0)))
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 30 * 20, 0), 0.8F))
			.build();
	
	public static final FoodProperties GOLDEN_APPLY_PIE = (new FoodProperties.Builder()).nutrition(12).saturationModifier(0.8F).alwaysEdible().build();
	public static final Consumable GOLDEN_APPLY_PIE_CONSUMABLE = Consumables.defaultFood()
			.onConsume(
					new ApplyStatusEffectsConsumeEffect(
							List.of(
									new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0),
									new MobEffectInstance(MobEffects.REGENERATION, 600, 4),
									new MobEffectInstance(MobEffects.RESISTANCE, 6000, 0),
									new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0)
							)
					)
			)
			.build();

	public static final FoodProperties GOLDEN_APPLY_PIE_SLICE = (new FoodProperties.Builder()).nutrition(12).saturationModifier(0.8F).alwaysEdible().build();
	public static final Consumable GOLDEN_APPLY_PIE_SLICE_CONSUMABLE = Consumables.defaultFood()
			.onConsume(
					new ApplyStatusEffectsConsumeEffect(
							List.of(
									new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0),
									new MobEffectInstance(MobEffects.REGENERATION, 80, 4),
									new MobEffectInstance(MobEffects.RESISTANCE, 1000, 0),
									new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0)
							)
					)
			)
			.build();

	public static final FoodProperties HONEYDEW = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).alwaysEdible().build();
	public static final Consumable HONEYDEW_CONSUMABLE = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 10 * 20, 0), 0.2F))
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 10 * 20, 0), 0.2F))
			.build();

	public static final FoodProperties NETHER_WART_JAM = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).alwaysEdible().build();
	public static final Consumable NETHER_WART_JAM_CONSUMABLE = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 30 * 20, 0), 0.4F))
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 30 * 20, 0), 0.4F))
			.build();

	public static final FoodProperties WITHERED_BRAIN = (new FoodProperties.Builder()).nutrition(8).saturationModifier(0.8F).build();
	public static final Consumable WITHERED_BRAIN_CONSUMABLE = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WITHER, 10 * 20, 0), 0.6F))
			.build();
	public static final FoodProperties MONSTER_FEED = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.2F).build();
	public static final FoodProperties PREMIUM_MONSTER_FEED = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.6F).build();
	public static final FoodProperties MANDRAKE = (new FoodProperties.Builder()).nutrition(0).saturationModifier(0.0F).alwaysEdible().build();
	public static final Consumable MANDRAKE_CONSUMABLE = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 20 * 20, 0), 0.8F))
			.build();
}
