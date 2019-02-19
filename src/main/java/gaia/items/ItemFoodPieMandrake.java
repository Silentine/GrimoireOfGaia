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

public class ItemFoodPieMandrake extends ItemFoodGaia {
	public ItemFoodPieMandrake(Item.Properties builder) {
		super(builder.maxStackSize(1), 8, 0.8F, false); //"food_pie_mandrake"
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.GainExperience"));
		tooltip.add(new TextComponentTranslation("effect.minecraft.night_vision").appendSibling(new TextComponentString(" (3:00)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.water_breathing").appendSibling(new TextComponentString(" (3:00)")));
	}

	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		rewardEXP(player, random.nextInt(16) + 8);
		player.heal(4.0F);
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 3600, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 3600, 0));
	}
}
