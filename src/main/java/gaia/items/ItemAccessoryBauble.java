package gaia.items;

import org.apache.commons.lang3.Range;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

@Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public abstract class ItemAccessoryBauble extends ItemBase implements IBauble {
	ItemAccessoryBauble(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
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

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		if (!(entityIn instanceof EntityPlayer))
			return;

		EntityPlayer player = (EntityPlayer) entityIn;
		Range<Integer> range = getActiveSlotRange();
		for (int i = range.getMinimum(); i <= range.getMaximum(); ++i) {
			if (player.inventory.getStackInSlot(i) == stack) {
				doEffect(player, stack);
				break;
			}
		}
	}

	public abstract void doEffect(EntityLivingBase player, ItemStack item);

	protected abstract Range<Integer> getActiveSlotRange();

	/** Baubles **/
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (player instanceof EntityPlayer && !player.world.isRemote) {
			doEffect(player, itemstack);
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
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
}
