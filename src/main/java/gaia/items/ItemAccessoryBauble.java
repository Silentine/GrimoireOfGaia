package gaia.items;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import gaia.helpers.ItemNBTHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

public abstract class ItemAccessoryBauble extends ItemBase implements IBauble {
	private static final String TAG_HASHCODE = "playerHashcode";

	ItemAccessoryBauble(String name) {
		super(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 1; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		ItemStack toEquip = stack.splitStack(1);

		if (canEquip(toEquip, player)) {
			IItemHandlerModifiable baubles = BaublesApi.getBaublesHandler(player);
			for (int i = 0; i < baubles.getSlots(); i++) {
				ItemStack simulate = baubles.insertItem(i, toEquip, true);
				if (simulate.isEmpty()) {
					ItemStack stackInSlot = baubles.getStackInSlot(i);
					if (stackInSlot.isEmpty() || ((IBauble) stackInSlot.getItem()).canUnequip(stackInSlot, player)) {
						if (!world.isRemote) {
							baubles.setStackInSlot(i, toEquip);
						}

						if (!stackInSlot.isEmpty()) {
							((IBauble) stackInSlot.getItem()).onUnequipped(stackInSlot, player);
							return ActionResult.newResult(EnumActionResult.SUCCESS, stackInSlot.copy());
						}
						break;
					}
				}
			}
		}

		return ActionResult.newResult(EnumActionResult.PASS, stack);
	}

	// ==================== Bauble ===================//
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (getLastPlayerHashcode(itemstack) != player.hashCode()) {
			setLastPlayerHashcode(itemstack, player.hashCode());
		}

		if (player instanceof EntityPlayer && !player.world.isRemote) {
			doEffect(player, itemstack);
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		setLastPlayerHashcode(itemstack, player.hashCode());
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
	// =======================================//

	public void doEffect(EntityLivingBase player, ItemStack item) {
	}

	private static int getLastPlayerHashcode(ItemStack stack) {
		return ItemNBTHelper.getInt(stack, TAG_HASHCODE, 0);
	}

	private static void setLastPlayerHashcode(ItemStack stack, int hash) {
		ItemNBTHelper.setInt(stack, TAG_HASHCODE, hash);
	}
}
