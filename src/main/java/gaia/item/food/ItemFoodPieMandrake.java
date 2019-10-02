package gaia.item.food;

import gaia.init.GaiaFoods;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFoodPieMandrake extends ItemFoodBase {
	public ItemFoodPieMandrake(Item.Properties builder) {
		super(builder.maxStackSize(1).food(GaiaFoods.PIE_MANDRAKE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.GainExperience"));
		tooltip.add(new TranslationTextComponent("effect.minecraft.night_vision").appendSibling(new StringTextComponent(" (3:00)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.water_breathing").appendSibling(new StringTextComponent(" (3:00)")));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity)entity;
			rewardEXP(player, random.nextInt(16) + 8);
			player.heal(4.0F);
			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 3600, 0));
			player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 3600, 0));
		}
		return super.onItemUseFinish(stack, worldIn, entity);

	}
}
