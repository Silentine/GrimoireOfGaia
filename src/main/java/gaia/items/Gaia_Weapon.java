package gaia.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
//TODO
public class Gaia_Weapon extends ItemSword{

	public Gaia_Weapon(ToolMaterial material) {
		super(material);
		this.maxStackSize = 1;
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack par2ItemStack) {
		return Items.BOOK == par2ItemStack.getItem()?true:super.getIsRepairable(stack, par2ItemStack);
	}
	
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72;
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

}
