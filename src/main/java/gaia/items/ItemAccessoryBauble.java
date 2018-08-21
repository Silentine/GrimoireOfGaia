package gaia.items;

import javax.annotation.Nonnull;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import gaia.helpers.ItemNBTHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

@InterfaceList({
	@Interface(iface="baubles.api.IBauble", modid="Baubles", striprefs=true),
	@Interface(iface="baubles.api.BaubleType", modid="Baubles", striprefs=true)})

public abstract class ItemAccessoryBauble extends Item implements IBauble {

    private static final String TAG_HASHCODE = "playerHashcode";

    @Override
    @SideOnly(Side.CLIENT)
    public @Nonnull
            EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!this.isInCreativeTab(tab)) {
            return;
        }

        for (int i = 0; i < 1; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
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
        if (player != null) {
            setLastPlayerHashcode(itemstack, player.hashCode());
        }
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

    public static int getLastPlayerHashcode(ItemStack stack) {
        return ItemNBTHelper.getInt(stack, TAG_HASHCODE, 0);
    }

    public static void setLastPlayerHashcode(ItemStack stack, int hash) {
        ItemNBTHelper.setInt(stack, TAG_HASHCODE, hash);
    }
}
