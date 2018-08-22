package gaia.items;

import gaia.init.GaiaItems;
import gaia.init.Sounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWeaponBookBuff extends ItemBase {
	public ItemWeaponBookBuff() {
		super("weapon_book_buff");
		maxStackSize = 1;
		setMaxDamage(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		final EntityPlayer player = Minecraft.getMinecraft().player;
		if (player == null) {
			return;
		}
		if (player.getHeldItemOffhand() == stack) {
			tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.BlessOffhand")));
		} else {
			tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.BlessMainhand")));
		}

		tooltip.add(I18n.format("effect.damageBoost") + " (1:00)");
		tooltip.add(I18n.format("effect.resistance") + " (1:00)");
		tooltip.add(I18n.format("effect.regeneration") + " (IV)" + " (0:04)");
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		host.playSound(Sounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 600, 0));
		target.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 0));
		target.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 3));
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		if ((double) state.getBlockHardness(worldIn, pos) != 0.0D) {
			stack.damageItem(2, entityLiving);
		}

		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == GaiaItems.MISC_QUILL;
	}
}
