package gaia.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;

//@Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public abstract class ItemAccessoryBauble extends ItemBase { //implements IBauble {

	ItemAccessoryBauble(Item.Properties builder) {
		super(builder.maxStackSize(1));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

//		ItemStack toEquip = stack.split(1);

		if(ModList.get().isLoaded("baubles"))
		{
//			if (canEquip(toEquip, player)) {
//				IItemHandlerModifiable baubles = BaublesApi.getBaublesHandler(player);
//				for (int i = 0; i < baubles.getSlots(); i++) {
//					ItemStack simulate = baubles.insertItem(i, toEquip, true);
//					if (simulate.isEmpty()) {
//						ItemStack stackInSlot = baubles.getStackInSlot(i);
//						if (stackInSlot.isEmpty() || ((IBauble) stackInSlot.getItem()).canUnequip(stackInSlot, player)) {
//							if (!world.isRemote) {
//								baubles.setStackInSlot(i, toEquip);
//							}
//
//							if (!stackInSlot.isEmpty()) {
//								((IBauble) stackInSlot.getItem()).onUnequipped(stackInSlot, player);
//								return ActionResult.newResult(EnumActionResult.SUCCESS, stackInSlot.copy());
//							}
//							break;
//						}
//					}
//				}
//			}
		}

		return ActionResult.newResult(EnumActionResult.PASS, stack);
	}

//	@Override
//	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
//		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
//		if (!(entityIn instanceof EntityPlayer))
//			return;
//
//		EntityPlayer player = (EntityPlayer) entityIn;
//		Range<Integer> range = getActiveSlotRange();
//		for (int i = range.getMinimum(); i <= range.getMaximum(); ++i) {
//			if (player.inventory.getStackInSlot(i) == stack) {
//				doEffect(player, stack);
//				break;
//			}
//		}
//	}

//	public abstract void doEffect(EntityLivingBase player, ItemStack item);

//	protected abstract Range<Integer> getActiveSlotRange();

	/** Baubles **/
//	@Override
//	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
//		if (player instanceof EntityPlayer && !player.world.isRemote) {
//			doEffect(player, itemstack);
//		}
//	}

//	@Override
//	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
//	}

//	@Override
//	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
//	}
	
//	@Override
//	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
//		return true;
//	}

//	@Override
//	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
//		return true;
//	}
}
