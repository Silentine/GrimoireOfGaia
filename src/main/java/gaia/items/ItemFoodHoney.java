package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFoodHoney extends ItemFoodGaia {

	public ItemFoodHoney(Item.Properties builder) {
		super(builder, 4, 0.4F, false); //"food_honey"
		setPotionEffect(new PotionEffect(MobEffects.SPEED, 10 * 20, 0), 0.2F);
		setSecondPotionEffect(new PotionEffect(MobEffects.HASTE, 10 * 20, 0), 0.2F);
	}
	
	@Override
	public EnumAction getUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentString("(20%) ").appendSibling(new TextComponentTranslation("effect.minecraft.speed")).appendSibling(new TextComponentString(" (0:10)")));
		tooltip.add(new TextComponentString("(20%) ").appendSibling(new TextComponentTranslation("effect.minecraft.haste")).appendSibling(new TextComponentString(" (0:10)")));
	}
}
