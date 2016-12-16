package gaia.items;

import gaia.Gaia;
import gaia.init.Sounds;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

public class ItemBoxGold extends Gaia_Lootable {

	public ItemBoxGold(String name) {
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{
		player.playSound(Sounds.bag_open, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		Random random = new Random();
		int i = random.nextInt(11);
		switch(i) {
		case 0:
			return loot(Items.GOLD_INGOT);
		case 1:
			return loot(Items.GOLDEN_AXE);
		case 2:
			return loot(Items.GOLDEN_PICKAXE);
		case 3:
			return loot(Items.GOLDEN_SHOVEL);
		case 4:
			return loot(Items.GOLDEN_SWORD);
		case 5:
			return loot(Items.GOLDEN_HELMET);
		case 6:
			return loot(Items.GOLDEN_CHESTPLATE);
		case 7:
			return loot(Items.GOLDEN_LEGGINGS);
		case 8:
			return loot(Items.GOLDEN_BOOTS);
		case 9:
			return loot(Blocks.GOLD_BLOCK);
		case 10:
			return loot(Items.GOLDEN_HORSE_ARMOR);
		default:
			return new ActionResult(EnumActionResult.SUCCESS, stack);
		}
	}
}
