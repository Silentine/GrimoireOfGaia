package gaia.items;

import gaia.entity.GaiaLootTableList;
import gaia.helpers.LootHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemBox extends ItemBase {
	public ItemBox(String name) {
		super(name);
		setHasSubtypes(true);
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
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 3; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public @Nonnull
	String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "_" + stack.getItemDamage();
	}

	@Override
	public @Nonnull
	ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);

		player.playSound(SoundEvents.BLOCK_CHEST_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		if (!player.capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (!world.isRemote) {
			if (stack.getMetadata() == 0) {
				LootHelper.dropLootAtPlayersPos(world, player, GaiaLootTableList.BOXES_OVERWORLD);
			} else if (stack.getMetadata() == 1) {
				LootHelper.dropLootAtPlayersPos(world, player, GaiaLootTableList.BOXES_NETHER);
			} else if (stack.getMetadata() == 2) {
				LootHelper.dropLootAtPlayersPos(world, player, GaiaLootTableList.BOXES_END);
			}
		}

		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
}
