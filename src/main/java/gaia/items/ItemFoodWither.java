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

public class ItemFoodWither extends ItemFoodBase {
	public ItemFoodWither(Item.Properties builder) {
		super(builder, 8, 0.8F, true); //"food_wither"
		setPotionEffect(new PotionEffect(MobEffects.WITHER, 10 * 20, 0), 0.6F);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentString("(60%) ").appendSibling(new TextComponentTranslation("effect.minecraft.wither")).appendSibling(new TextComponentString(" (0:10)")));
	}
}
