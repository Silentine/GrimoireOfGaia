package gaia.items;

import gaia.Gaia;
import gaia.entity.item.EntityGaiaBox;
import gaia.entity.item.EntityGaiaBoxEnd;
import gaia.entity.item.EntityGaiaBoxNether;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see ItemAppleGold
 */
public class ItemBox extends Item {

	public ItemBox(String name) {
        this.setHasSubtypes(true);
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickUse"));
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 3; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		player.playSound(SoundEvents.BLOCK_CHEST_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		if (!world.isRemote) {
			if (stack.getMetadata() == 0) {
				EntityGaiaBox spawnEntity = new EntityGaiaBox(world);
				spawnEntity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,0); 
				world.spawnEntityInWorld(spawnEntity);
			} else if (stack.getMetadata() == 1) {
				EntityGaiaBoxNether spawnEntity = new EntityGaiaBoxNether(world);
				spawnEntity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,0); 
				world.spawnEntityInWorld(spawnEntity);	
			} else if (stack.getMetadata() == 2) {
				EntityGaiaBoxEnd spawnEntity = new EntityGaiaBoxEnd(world);
				spawnEntity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,0); 
				world.spawnEntityInWorld(spawnEntity);	
			}
		}

		return new ActionResult(EnumActionResult.SUCCESS, stack);
	}
}
