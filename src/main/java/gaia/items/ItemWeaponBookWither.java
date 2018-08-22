package gaia.items;

import gaia.init.Sounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWeaponBookWither extends ItemWeaponBook {
	public ItemWeaponBookWither() {
		super("weapon_book_wither");
		setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses() * 3.48F));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
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

		tooltip.add(I18n.format("effect.wither") + " (0:04)");
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		host.playSound(Sounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.WITHER, 80, 0));
		return true;
	}
}
