package gaia.items;

import gaia.Gaia;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnCreeperGirl extends Item {
	String texture;

	public ItemSpawnCreeperGirl(String texture) {
		this.texture = texture;
		this.maxStackSize = 16;
		this.setUnlocalizedName("GrimoireOfGaia.SpawnCreeperGirl");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.SpawnCreeperGirl.desc"));
	}

	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer entityplayer) {
		if (!entityplayer.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		world.playSoundAtEntity(entityplayer, "grimoireofgaia:book_hit", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isRemote) {
			EntityGaiaNPCCreeperGirl entityspawning = new EntityGaiaNPCCreeperGirl(world);
			entityspawning.setLocationAndAngles(entityplayer.posX + 0.5, entityplayer.posY, entityplayer.posZ + 0.5, 0,0); 
			world.spawnEntityInWorld(entityspawning);
		}

		return stack;
	}

	public int getMaxItemUseDuration(ItemStack stack) {
		return 16;
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
}
