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

public class ItemFoodPieAppleGold extends ItemFoodGaia {
	public ItemFoodPieAppleGold(Item.Properties builder) {
		super(builder.maxStackSize(1), 12, 0.8F, true); //"food_pie_apple_gold"
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.GainExperience"));
		tooltip.add(new TextComponentTranslation("effect.minecraft.absorption").appendSibling(new TextComponentString(" (2:00)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.regeneration").appendSibling(new TextComponentString(" (IV)").appendSibling(new TextComponentString(" (0:20)"))));
		tooltip.add(new TextComponentTranslation("effect.minecraft.resistance").appendSibling(new TextComponentString(" (5:00)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.fire_resistance").appendSibling(new TextComponentString(" (5:00)")));
	}

	// PotionEffect is a direct copy of ItemAppleGold
	// Gained experience is 100% more
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		rewardEXP(player, random.nextInt(32) + 16);
		player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 4));
		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
	}
}
