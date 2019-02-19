package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFoodSmallAppleGold extends ItemFoodBase {

	public ItemFoodSmallAppleGold(Item.Properties builder) {
		super(builder.maxStackSize(64), 1, 0.4F, false); //"food_small_apple_gold"
		setAlwaysEdible();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("effect.minecraft.absorption").appendSibling(new TextComponentString(" (2:00)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.regeneration").appendSibling(new TextComponentString(" (IV)").appendSibling(new TextComponentString(" (0:04)"))));
		tooltip.add(new TextComponentTranslation("effect.minecraft.resistance").appendSibling(new TextComponentString(" (0:50)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.fire_resistance").appendSibling(new TextComponentString(" (0:50)")));
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 4));
		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1000, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1000, 0));
	}
}
