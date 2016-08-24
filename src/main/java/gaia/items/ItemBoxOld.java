package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItem;
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

public class ItemBoxOld extends Item {
	String texture;

	public ItemBoxOld(String texture) {
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.BoxOld");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		entityplayer.playSound(Sounds.box_open2, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		Random random = new Random();
		int i = random.nextInt(6);
		switch(i) {
		case 0:
			return new ItemStack(GaiaItem.MiscGigaGear);
		case 1:
			return new ItemStack(GaiaItem.Spawn);
		case 2:
			return new ItemStack(Items.SADDLE);
		case 3:
			return new ItemStack(Items.SADDLE);
		case 4:
			return new ItemStack(Items.NAME_TAG);
		case 5:
			return new ItemStack(Items.NAME_TAG);
		default:
			return itemstack;
		}
	}
}
