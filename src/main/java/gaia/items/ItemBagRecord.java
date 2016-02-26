package gaia.items;

import java.util.List;
import java.util.Random;

import gaia.Gaia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
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
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		world.playSoundAtEntity(entityplayer, "grimoireofgaia:bag_open", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		Random random = new Random();
		int i = random.nextInt(12);
		switch(i) {
		case 0:
			return new ItemStack(Items.record_13);
		case 1:
			return new ItemStack(Items.record_cat);
		case 2:
			return new ItemStack(Items.record_blocks);
		case 3:
			return new ItemStack(Items.record_chirp);
		case 4:
			return new ItemStack(Items.record_far);
		case 5:
			return new ItemStack(Items.record_mall);
		case 6:
			return new ItemStack(Items.record_mellohi);
		case 7:
			return new ItemStack(Items.record_stal);
		case 8:
			return new ItemStack(Items.record_strad);
		case 9:
			return new ItemStack(Items.record_ward);
		case 10:
			return new ItemStack(Items.record_11);
		case 11:
			return new ItemStack(Items.record_wait);
		default:
			return itemstack;
		}
	}
}
