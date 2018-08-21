package gaia.items;

import javax.annotation.Nonnull;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@InterfaceList({
	@Interface(iface="baubles.api.IBauble", modid="Baubles", striprefs=true),
	@Interface(iface="baubles.api.BaubleType", modid="Baubles", striprefs=true)})

public class ItemAccessoryRing extends Item implements IBauble {

    public ItemAccessoryRing(String name) {
        setHasSubtypes(true);
        setRegistryName(GaiaReference.MOD_ID, name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!this.isInCreativeTab(tab)) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName() + "_" + stack.getItemDamage();
    }

	public void doEffect(EntityPlayer player, ItemStack item) {}
	
  //==================== Bauble ===================//
  	@Override
  	public BaubleType getBaubleType(ItemStack itemstack) {
  		return BaubleType.RING;
  	}

  	@Override
  	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
  		this.doEffect((EntityPlayer)player, itemstack);	
  	}

  	@Override
  	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

  	@Override
  	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}

  	@Override
  	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
  		return true;
  	}

  	@Override
  	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
  		return true;
  	}
}
