package gaia.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class GaiaFoods {
    public static final Food COAL_FISH = (new Food.Builder()).hunger(4).saturation(0.4F).effect(new EffectInstance(Effects.WATER_BREATHING, 2400, 0),1.0F).meat().build();
    public static final Food HONEY = (new Food.Builder()).hunger(4).saturation(0.4F).effect(new EffectInstance(Effects.SPEED, 10 * 20, 0), 0.2F).effect(new EffectInstance(Effects.HASTE, 10 * 20, 0), 0.2F).build();
    public static final Food MANDRAKE = (new Food.Builder()).hunger(0).saturation(0.0F).setAlwaysEdible().effect(new EffectInstance(Effects.NAUSEA, 20 * 20, 0), 0.8F).build();
    public static final Food MONSTER_FEED = (new Food.Builder()).hunger(2).saturation(0.2F).meat().build();
    public static final Food MONSTER_FEED_PREMIUM = (new Food.Builder()).hunger(4).saturation(0.2F).meat().build();
    public static final Food NETHER_WART = (new Food.Builder()).hunger(4).saturation(0.4F).effect(new EffectInstance(Effects.SPEED, 30 * 20, 0), 0.4F).effect(new EffectInstance(Effects.HASTE, 30 * 20, 0), 0.4F).build();
    public static final Food PIE_APPLE_GOLD = (new Food.Builder()).hunger(12).saturation(0.8F).build();
    public static final Food PIE_MANDRAKE = (new Food.Builder()).hunger(8).saturation(0.8F).build();
    public static final Food PIE_MEAT = (new Food.Builder()).hunger(8).saturation(0.8F).meat().effect(new EffectInstance(Effects.SLOWNESS, 30 * 20, 0), 1.0F).build();
    public static final Food ROOT = (new Food.Builder()).hunger(0).saturation(0.0F).setAlwaysEdible().build();
    public static final Food ROTTEN_HEART = (new Food.Builder()).hunger(4).saturation(0.0F).meat().effect(new EffectInstance(Effects.REGENERATION, 10 * 20, 0), 1.0F).effect(new EffectInstance(Effects.HUNGER, 30 * 20, 0), 0.8F).setAlwaysEdible().build();
    public static final Food SMALL_APPLE_GOLD = (new Food.Builder()).hunger(1).saturation(0.4F).setAlwaysEdible().build();
    public static final Food WITHER = (new Food.Builder()).hunger(8).saturation(0.8F).meat().effect(new EffectInstance(Effects.WITHER, 10 * 20, 0), 0.6F).build();
    public static final Food MEAT = (new Food.Builder()).hunger(6).saturation(1.2F).meat().build();
}
