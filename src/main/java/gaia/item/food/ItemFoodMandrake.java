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

public class ItemFoodMandrake extends ItemFoodBase {

	public ItemFoodMandrake(Item.Properties builder) {
		super(builder.maxStackSize(16).food(GaiaFoods.MANDRAKE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.HeartsGain", 2));
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.HungerLose", 4));
		tooltip.add(new StringTextComponent("(80%) ").appendSibling(new TranslationTextComponent("effect.minecraft.nausea")).appendSibling(new StringTextComponent(" (0:20)")));

	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
		if(entity instanceof PlayerEntity) {
			PlayerEntity player = ((PlayerEntity) entity);
			player.heal(4.0F);
			player.addExhaustion(40.0F);
		}
		return super.onItemUseFinish(stack, world, entity);
	}
}
