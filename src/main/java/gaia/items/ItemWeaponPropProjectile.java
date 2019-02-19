package gaia.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemWeaponPropProjectile extends ItemWeaponProp {
	
	public ItemWeaponPropProjectile(Item.Properties builder) {
		super(builder);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		if (!(host instanceof EntityPlayer) || !((EntityPlayer) host).abilities.isCreativeMode) {
			stack.shrink(1);
		}

		return true;
	}
}
