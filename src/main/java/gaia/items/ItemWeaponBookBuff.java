package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItems;
import gaia.init.Sounds;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** 
 * @see ItemSword
 */
public class ItemWeaponBookBuff extends Item {
	
	private float attackDamage;

	public ItemWeaponBookBuff(String name) {
		this.attackDamage = 0;
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (playerIn.getHeldItemOffhand() == stack)
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.BlessOffhand")));
		else
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.BlessMainhand")));

		tooltip.add(I18n.translateToLocal("effect.damageBoost") + " (1:00)");
		tooltip.add(I18n.translateToLocal("effect.resistance") + " (1:00)");
		tooltip.add(I18n.translateToLocal("effect.regeneration") + " (IV)" + " (0:04)");
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		EntityPlayer player = host instanceof EntityPlayer ? (EntityPlayer)host : null;
        player.playSound(Sounds.book_hit, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 600, 0));
		target.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 0));
		target.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 3));
		return true;
	}

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D) {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == GaiaItems.MiscQuill;
    }
}
