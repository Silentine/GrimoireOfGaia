package gaia.items;

import java.util.List;
import java.util.Random;

import gaia.init.GaiaSounds;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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

public class ItemBagRecord extends ItemGaiaLootable {
	public ItemBagRecord(Item.Properties builder) {
		super(builder.maxStackSize(1)); //"bag_record");
		//setMaxStackSize(1);
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

		Random random = new Random();
		int i = random.nextInt(12);
		switch (i) {
			case 0:
				return loot(Items.MUSIC_DISC_13);
			case 1:
				return loot(Items.MUSIC_DISC_CAT);
			case 2:
				return loot(Items.MUSIC_DISC_BLOCKS);
			case 3:
				return loot(Items.MUSIC_DISC_CHIRP);
			case 4:
				return loot(Items.MUSIC_DISC_FAR);
			case 5:
				return loot(Items.MUSIC_DISC_MALL);
			case 6:
				return loot(Items.MUSIC_DISC_MELLOHI);
			case 7:
				return loot(Items.MUSIC_DISC_STAL);
			case 8:
				return loot(Items.MUSIC_DISC_STRAD);
			case 9:
				return loot(Items.MUSIC_DISC_WARD);
			case 10:
				return loot(Items.MUSIC_DISC_11);
			case 11:
				return loot(Items.MUSIC_DISC_WAIT);
			default:
				return new ActionResult<>(EnumActionResult.SUCCESS, stack);
		}
	}
}
