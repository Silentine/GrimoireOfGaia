package gaia.items;

import gaia.Gaia;
import gaia.init.Sounds;

import java.util.List;
import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBagBook extends Item {

	public ItemBagBook(String name) {
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickUse"));
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer player, EnumHand hand) {	
		//TODO remove testing line * world.addWeatherEffect(new EntityLightningBolt(world, player.posX, player.posY, player.posZ, false));
		player.playSound(Sounds.bag_open, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		/** TODO Check
		Enchantment enchantment = Enchantment.enchantmentsBookList[itemRand.nextInt(Enchantment.enchantmentsBookList.length)];
		int k = MathHelper.getRandomIntegerInRange(itemRand, enchantment.getMinLevel(), enchantment.getMaxLevel());
		ItemStack book = Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(enchantment, k));
		 **/

		Random rand = new Random();
		ItemStack book = new ItemStack(Items.BOOK);
		book = EnchantmentHelper.addRandomEnchantment(rand, book, 5 + rand.nextInt(15), true);

		return new ActionResult(EnumActionResult.SUCCESS, book);
	}
}
