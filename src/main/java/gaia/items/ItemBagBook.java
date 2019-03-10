package gaia.items;

import gaia.init.GaiaSounds;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
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

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemBagBook extends ItemBase {
	public ItemBagBook() {
		super("bag_book");
		maxStackSize = 1;
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
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		player.playSound(GaiaSounds.BAG_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random rand = new Random();
		ItemStack book = new ItemStack(Items.BOOK);
		book = EnchantmentHelper.addRandomEnchantment(rand, book, 5 + rand.nextInt(15), true);

		return new ActionResult<>(EnumActionResult.SUCCESS, book);
	}
}
