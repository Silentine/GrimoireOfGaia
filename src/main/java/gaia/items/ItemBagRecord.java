package gaia.items;

import gaia.Gaia;
import gaia.init.Sounds;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBagRecord extends Item {
	String texture;

	public ItemBagRecord(String texture) {
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.BagRecord");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		entityplayer.playSound(Sounds.bag_open, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		Random random = new Random();
		int i = random.nextInt(12);
		switch(i) {
		case 0:
			return new ItemStack(Items.RECORD_13);
		case 1:
			return new ItemStack(Items.RECORD_CAT);
		case 2:
			return new ItemStack(Items.RECORD_BLOCKS);
		case 3:
			return new ItemStack(Items.RECORD_CHIRP);
		case 4:
			return new ItemStack(Items.RECORD_FAR);
		case 5:
			return new ItemStack(Items.RECORD_MALL);
		case 6:
			return new ItemStack(Items.RECORD_MELLOHI);
		case 7:
			return new ItemStack(Items.RECORD_STAL);
		case 8:
			return new ItemStack(Items.RECORD_STRAD);
		case 9:
			return new ItemStack(Items.RECORD_WARD);
		case 10:
			return new ItemStack(Items.RECORD_11);
		case 11:
			return new ItemStack(Items.RECORD_WAIT);
		default:
			return itemstack;
		}
	}
}
