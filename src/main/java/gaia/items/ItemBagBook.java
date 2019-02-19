package gaia.items;

import java.util.List;
import java.util.Random;

import gaia.init.GaiaSounds;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
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

public class ItemBagBook extends ItemBase {
	public ItemBagBook(Item.Properties builder) {
		super(builder.maxStackSize(1)); //"bag_book");
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
		player.playSound(GaiaSounds.BAG_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random rand = new Random();
		ItemStack book = new ItemStack(Items.BOOK);
		book = EnchantmentHelper.addRandomEnchantment(rand, book, 5 + rand.nextInt(15), true);

		return new ActionResult<>(EnumActionResult.SUCCESS, book);
	}
}
