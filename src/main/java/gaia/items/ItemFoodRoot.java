package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFoodRoot extends ItemFoodBase {

	public ItemFoodRoot(Item.Properties builder) {
		super(builder.maxStackSize(16), 0, 0.0F, false); //"food_root"
		setAlwaysEdible();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.NegativeStatus.desc"));
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote)
		{
			player.func_195061_cb();
		}
		super.onFoodEaten(stack, world, player);
	}
}
