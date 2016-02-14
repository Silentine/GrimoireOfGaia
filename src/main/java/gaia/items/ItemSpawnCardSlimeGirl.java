package gaia.items;

import java.util.List;

import gaia.Gaia;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnCardSlimeGirl extends Item {
	String texture;

	public ItemSpawnCardSlimeGirl(String texture) {

		this.texture = texture;
		this.maxStackSize = 16;
		this.setUnlocalizedName("GrimoireOfGaia.SpawnCardSlimeGirl");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("item.GrimoireOfGaia.SpawnSlimeGirl.desc"));
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World world, EntityPlayer entityplayer) {
		if(!entityplayer.capabilities.isCreativeMode) {
			--par1ItemStack.stackSize;
		}

		world.playSoundAtEntity(entityplayer, "gaia:book_hit", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!world.isRemote) {
			EntityGaiaNPCSlimeGirl entityspawning = new EntityGaiaNPCSlimeGirl(world);
			entityspawning.setPosition(entityplayer.posX + 0.0D, entityplayer.posY + 0.0D, entityplayer.posZ + 0.0D);
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

	/*public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}*/
}
