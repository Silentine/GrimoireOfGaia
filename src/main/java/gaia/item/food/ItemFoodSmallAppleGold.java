package gaia.item.food;

import gaia.init.GaiaFoods;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFoodSmallAppleGold extends Item {

	public ItemFoodSmallAppleGold(Item.Properties builder) {
		super(builder.maxStackSize(64).food(GaiaFoods.SMALL_APPLE_GOLD));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.UNCOMMON;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("effect.minecraft.absorption").appendSibling(new StringTextComponent(" (2:00)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.regeneration").appendSibling(new StringTextComponent(" (IV)").appendSibling(new StringTextComponent(" (0:04)"))));
		tooltip.add(new TranslationTextComponent("effect.minecraft.resistance").appendSibling(new StringTextComponent(" (0:50)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.fire_resistance").appendSibling(new StringTextComponent(" (0:50)")));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity)entity;
			player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 2400, 0));
			player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 4));
			player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1000, 0));
			player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 1000, 0));
		}
		return super.onItemUseFinish(stack, worldIn, entity);
	}
}
