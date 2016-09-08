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
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBoxDiamond extends Item {
	String texture;

	public ItemBoxDiamond(String texture) {
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.BoxDiamond");
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
		int i = random.nextInt(11);
		switch(i) {
		case 0:
			return new ItemStack(Items.DIAMOND);
		case 1:
			return new ItemStack(Items.DIAMOND_AXE);
		case 2:
			return new ItemStack(Items.DIAMOND_PICKAXE);
		case 3:
			return new ItemStack(Items.DIAMOND_SHOVEL);
		case 4:
			return new ItemStack(Items.DIAMOND_SWORD);
		case 5:
			return new ItemStack(Items.DIAMOND_HELMET);
		case 6:
			return new ItemStack(Items.DIAMOND_CHESTPLATE);
		case 7:
			return new ItemStack(Items.DIAMOND_LEGGINGS);
		case 8:
			return new ItemStack(Items.DIAMOND_BOOTS);
		case 9:
			return new ItemStack(Blocks.DIAMOND_BLOCK);
		case 10:
			return new ItemStack(Items.DIAMOND_HORSE_ARMOR);
		default:
			return itemstack;
		}
	}
}
