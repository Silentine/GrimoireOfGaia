package gaia.items;

import gaia.helpers.LootHelper;
import gaia.helpers.ModelLoaderHelper;
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
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemChest extends ItemBase {
	public ItemChest() {
		super("chest");
		setHasSubtypes(true);
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

	/* SUBITEMS */
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 3; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this,
				ModelLoaderHelper.getSuffixedLocation(this, "_dungeon"),
				ModelLoaderHelper.getSuffixedLocation(this, "_jungle"),
				ModelLoaderHelper.getSuffixedLocation(this, "_desert")
		);
	}
	/* SUBITEMS */
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);

		player.playSound(SoundEvents.BLOCK_CHEST_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		if (!player.capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (!world.isRemote) {
			if (stack.getMetadata() == 0) {
				LootHelper.dropRandomLootAtPlayersPos(world, player, LootTableList.CHESTS_SIMPLE_DUNGEON, 2);
			} else if (stack.getMetadata() == 1) {
				LootHelper.dropRandomLootAtPlayersPos(world, player, LootTableList.CHESTS_JUNGLE_TEMPLE, 2);
			} else if (stack.getMetadata() == 2) {
				LootHelper.dropRandomLootAtPlayersPos(world, player, LootTableList.CHESTS_DESERT_PYRAMID, 2);
			}
		}

		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
}
