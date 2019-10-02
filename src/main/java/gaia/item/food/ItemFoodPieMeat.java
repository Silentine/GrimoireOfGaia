package gaia.item.food;

import gaia.init.GaiaFoods;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFoodPieMeat extends ItemFoodBase {
	public ItemFoodPieMeat(Item.Properties builder) {
		super(builder.maxStackSize(1).food(GaiaFoods.PIE_MEAT));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.GainExperience"));
		tooltip.add(new TranslationTextComponent("effect.minecraft.slowness").appendSibling(new StringTextComponent(" (0:30)")));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity)entity;
			rewardEXP(player, random.nextInt(8) + 4);
		}
		return super.onItemUseFinish(stack, worldIn, entity);
	}
}
