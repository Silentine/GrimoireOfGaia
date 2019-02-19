package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
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

public class ItemFoodRottenHeart extends ItemFoodGaia {

	public ItemFoodRottenHeart(Item.Properties builder) {
		super(builder.maxStackSize(1), 4, 0.0F, true); //"food_rotten_heart"
		setAlwaysEdible();

		setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 0), 1.0F);
		setSecondPotionEffect(new PotionEffect(MobEffects.HUNGER, 30 * 20, 0), 0.8F);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("effect.minecraft.regeneration").appendSibling(new TextComponentString(" (0:10)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.hunger").appendSibling(new TextComponentString(" (0:30)")));
	}
}
