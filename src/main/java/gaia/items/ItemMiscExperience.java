package gaia.items;

import gaia.Gaia;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see ItemAppleGold
 */
public class ItemMiscExperience extends Item {

	public ItemMiscExperience(String name) {
        this.setHasSubtypes(true);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (stack.getItemDamage() == 0) 
			tooltip.add(I18n.translateToLocalFormatted("item.GrimoireOfGaia.FoodExperienceIron.desc"));
		else if (stack.getMetadata() == 1) 
			tooltip.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.GainLevels", new Object[]{Integer.valueOf(2)}));
		else if (stack.getMetadata() == 2) 
			tooltip.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.GainLevels", new Object[]{Integer.valueOf(4)}));
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
	
	@Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase living) {
		EntityPlayer player = living instanceof EntityPlayer ? (EntityPlayer)living : null;
		player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		if (!world.isRemote) {
			if (stack.getMetadata() == 0) 
				player.addExperienceLevel(itemRand.nextInt(2) + 1);
			else if (stack.getMetadata() == 1) 
				player.addExperienceLevel(itemRand.nextInt(3) + 2);
			else if (stack.getMetadata() == 2)
				player.addExperienceLevel(itemRand.nextInt(5) + 4);
		}

		return stack;
	}

	public int getMaxItemUseDuration(ItemStack stack) {
		return 16;
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}