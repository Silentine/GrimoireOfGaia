package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemMiscSoulFire extends ItemBase {

	private int fuelTimeTicks = 11600;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemMiscSoulFire(Item.Properties builder) {
		super(builder); //"misc_soul_fire");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(new TextComponentTranslation("item.grimoireofgaia.misc_soul_fire.desc").applyTextStyle(TextFormatting.ITALIC));
	}

	@Override
	public EnumActionResult onItemUse(ItemUseContext context) {
		EntityPlayer player = context.getPlayer();
		World world = context.getWorld();
		ItemStack stack = context.getItem();

		if (!player.abilities.isCreativeMode) {
			stack.shrink(1);
		}

		BlockPos offsetPos = context.getPos().offset(context.getFace());

		if (!player.canPlayerEdit(offsetPos, context.getFace(), stack)) {
			return EnumActionResult.FAIL;
		} else {
			if (world.isAirBlock(offsetPos)) {
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_GHAST_SCREAM, SoundCategory.PLAYERS, 0.4F, 0.8F);
				world.setBlockState(offsetPos, Blocks.FIRE.getDefaultState());
			}

			stack.damageItem(1, player);

			return EnumActionResult.SUCCESS;
		}
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
