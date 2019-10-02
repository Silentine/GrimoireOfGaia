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

public class ItemFoodPieAppleGold extends ItemFoodBase {
	public ItemFoodPieAppleGold(Item.Properties builder) {
		super(builder.maxStackSize(1).food(GaiaFoods.PIE_APPLE_GOLD));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.GainExperience"));
		tooltip.add(new TranslationTextComponent("effect.minecraft.absorption").appendSibling(new StringTextComponent(" (2:00)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.regeneration").appendSibling(new StringTextComponent(" (IV)").appendSibling(new StringTextComponent(" (0:20)"))));
		tooltip.add(new TranslationTextComponent("effect.minecraft.resistance").appendSibling(new StringTextComponent(" (5:00)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.fire_resistance").appendSibling(new StringTextComponent(" (5:00)")));
	}

	// EffectInstance is a direct copy of ItemAppleGold
	// Gained experience is 100% more

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
		if(entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity)entity;
			rewardEXP(player, random.nextInt(32) + 16);
			player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 2400, 0));
			player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 600, 4));
			player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 6000, 0));
			player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 0));
		}

		return super.onItemUseFinish(stack, worldIn, entity);
	}
}
