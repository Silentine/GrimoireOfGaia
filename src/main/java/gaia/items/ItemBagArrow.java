package gaia.items;

import java.util.List;

import gaia.entity.GaiaLootTableList;
import gaia.helpers.LootHelper;
import gaia.init.GaiaSounds;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBagArrow extends ItemBase {
	public ItemBagArrow(Item.Properties builder) {
		super(builder.maxStackSize(1)); //"bag_arrow");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.RightClickUse"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);

		player.playSound(GaiaSounds.BAG_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		if (!player.abilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (!world.isRemote) {
			LootHelper.dropLootAtPlayersPos(world, player, GaiaLootTableList.BAG_ARROW);
		}

		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
}
