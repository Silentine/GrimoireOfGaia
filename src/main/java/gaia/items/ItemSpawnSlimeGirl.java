package gaia.items;

import gaia.Gaia;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.init.Sounds;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnSlimeGirl extends Item {
	String texture;

	public ItemSpawnSlimeGirl(String texture) {
		this.texture = texture;
		this.maxStackSize = 16;
		this.setUnlocalizedName("GrimoireOfGaia.SpawnSlimeGirl");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.SpawnSlimeGirl.desc"));
	}

	@Nullable
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase living)
	{	
		EntityPlayer player = living instanceof EntityPlayer ? (EntityPlayer)living : null;
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		world.playSound(player, player.getPosition(), Sounds.book_hit, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isRemote) {
			EntityGaiaNPCSlimeGirl entityspawning = new EntityGaiaNPCSlimeGirl(world);
			entityspawning.setLocationAndAngles(player.posX + 0.5, player.posY, player.posZ + 0.5, 0,0); 
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
	
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
