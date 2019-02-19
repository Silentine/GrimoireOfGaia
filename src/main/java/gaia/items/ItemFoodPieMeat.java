package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFoodPieMeat extends ItemFoodGaia {
	public ItemFoodPieMeat(Item.Properties builder) {
		super(builder.maxStackSize(1), 8, 0.8F, true); //"food_pie_meat"
		setPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 30 * 20, 0), 1.0F);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.GainExperience"));
		tooltip.add(new TextComponentTranslation("effect.minecraft.slowness").appendSibling(new TextComponentString(" (0:30)")));
	}

	@Override
	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		rewardEXP(player, random.nextInt(8) + 4);
	}
}
