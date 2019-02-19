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

public class ItemFoodCoalfish extends ItemFoodBase {

	private int fuelTimeTicks = 3600;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemFoodCoalfish(Item.Properties builder) {
		super(builder, 4, 0.4F, true); //"food_coalfish"
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(new TextComponentTranslation("effect.minecraft.water_breathing").appendSibling(new TextComponentString(" (2:00)")));
	}

	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 2400, 0));
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
