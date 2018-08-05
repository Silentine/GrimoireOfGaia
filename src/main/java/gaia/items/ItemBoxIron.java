package gaia.items;

import gaia.entity.GaiaLootTableList;
import gaia.helpers.LootHelper;
import gaia.init.Sounds;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemBoxIron extends ItemBase {

	public ItemBoxIron(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.RightClickUse"));
	}

	@Override
	public @Nonnull
	ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);

		player.playSound(Sounds.bag_open, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		if (!player.capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (!world.isRemote) {
			LootHelper.dropLootAtPlayersPos(world, player, GaiaLootTableList.BOXES_IRON);
		}

		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
}
