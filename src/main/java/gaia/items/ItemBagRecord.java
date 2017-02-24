package gaia.items;

import gaia.Gaia;
import gaia.init.Sounds;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBagRecord extends Gaia_Lootable {

	public ItemBagRecord(String name) {
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

	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		player.playSound(Sounds.bag_open, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		Random random = new Random();
		int i = random.nextInt(12);
		switch(i) {
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
			return new ActionResult(EnumActionResult.SUCCESS, stack);
		}
	}
}
