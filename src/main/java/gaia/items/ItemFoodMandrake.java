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

public class ItemFoodMandrake extends ItemFoodBase {

	public ItemFoodMandrake(Item.Properties builder) {
		super(builder.maxStackSize(16), 0, 0.0F, false); //"food_mandrake"
		setAlwaysEdible();
		setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20 * 20, 0), 0.8F);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.HeartsGain", 2));
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.HungerLose", 4));
		tooltip.add(new TextComponentString("(80%) ").appendSibling(new TextComponentTranslation("effect.minecraft.nausea")).appendSibling(new TextComponentString(" (0:20)")));

	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		player.heal(4.0F);
		player.addExhaustion(40.0F);
	}
}
