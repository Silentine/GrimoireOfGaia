package gaia.items;

import gaia.init.Sounds;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
import java.util.Random;

public class ItemBagRecord extends ItemGaiaLootable {

	public ItemBagRecord(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.RightClickUse"));
	}

	@Override
	public @Nonnull
	ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);

		player.playSound(Sounds.bag_open, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random random = new Random();
		int i = random.nextInt(12);
		switch (i) {
			case 0:
				return loot(Items.RECORD_13);
			case 1:
				return loot(Items.RECORD_CAT);
			case 2:
				return loot(Items.RECORD_BLOCKS);
			case 3:
				return loot(Items.RECORD_CHIRP);
			case 4:
				return loot(Items.RECORD_FAR);
			case 5:
				return loot(Items.RECORD_MALL);
			case 6:
				return loot(Items.RECORD_MELLOHI);
			case 7:
				return loot(Items.RECORD_STAL);
			case 8:
				return loot(Items.RECORD_STRAD);
			case 9:
				return loot(Items.RECORD_WARD);
			case 10:
				return loot(Items.RECORD_11);
			case 11:
				return loot(Items.RECORD_WAIT);
			default:
				return new ActionResult<>(EnumActionResult.SUCCESS, stack);
		}
	}
}
