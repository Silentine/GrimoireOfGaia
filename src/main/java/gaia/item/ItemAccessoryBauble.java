package gaia.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import org.apache.commons.lang3.Range;

//@Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public abstract class ItemAccessoryBauble extends Item { //implements IBauble {

	ItemAccessoryBauble(Item.Properties builder) {
		super(builder.maxStackSize(1));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
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
//								return ActionResult.newResult(ActionResultType.SUCCESS, stackInSlot.copy());
//							}
//							break;
//						}
//					}
//				}
//			}
		}
        
		return ActionResult.resultPass(stack);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		if (!(entityIn instanceof PlayerEntity))
			return;

		PlayerEntity player = (PlayerEntity) entityIn;
		Range<Integer> range = getActiveSlotRange();
		for (int i = range.getMinimum(); i <= range.getMaximum(); ++i) {
			if (player.inventory.getStackInSlot(i) == stack) {
				doEffect(player, stack);
				break;
			}
		}
	}

	public abstract void doEffect(LivingEntity player, ItemStack item);

	protected abstract Range<Integer> getActiveSlotRange();

	/** Baubles **/
//	@Override
//	public void onWornTick(ItemStack itemstack, LivingEntity player) {
//		if (player instanceof PlayerEntity && !player.world.isRemote) {
//			doEffect(player, itemstack);
//		}
//	}

//	@Override
//	public void onEquipped(ItemStack itemstack, LivingEntity player) {
//	}

//	@Override
//	public void onUnequipped(ItemStack itemstack, LivingEntity player) {
//	}
	
//	@Override
//	public boolean canEquip(ItemStack itemstack, LivingEntity player) {
//		return true;
//	}

//	@Override
//	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
//		return true;
//	}
}
