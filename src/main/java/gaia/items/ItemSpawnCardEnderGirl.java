package gaia.items;

import java.util.List;

import gaia.Gaia;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnCardEnderGirl extends Item {
	String texture;

	public ItemSpawnCardEnderGirl(String texture) {

		this.texture = texture;
		this.maxStackSize = 16;
		this.setUnlocalizedName("GrimoireOfGaia.SpawnCardEnderGirl");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("item.GrimoireOfGaia.SpawnEnderGirl.desc"));
	}

	public ItemStack onItemUseFinish(ItemStack par1ItemStack, World world, EntityPlayer entityplayer) {
		if(!entityplayer.capabilities.isCreativeMode) {
			--par1ItemStack.stackSize;
		}

		world.playSoundAtEntity(entityplayer, "grimoireofgaia:book_hit", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!world.isRemote) {
			EntityGaiaNPCEnderGirl entityspawning = new EntityGaiaNPCEnderGirl(world);
			entityspawning.setLocationAndAngles(entityplayer.posX + 0.5, entityplayer.posY, entityplayer.posZ + 0.5, 0,0); 
			world.spawnEntityInWorld(entityspawning);
		}

		return par1ItemStack;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 16;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.BOW;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
}
