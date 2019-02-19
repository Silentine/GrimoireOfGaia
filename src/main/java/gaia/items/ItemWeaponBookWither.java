package gaia.items;

import java.util.List;

import gaia.ItemGroupGaia;
import gaia.init.GaiaSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemWeaponBookWither extends ItemWeaponBook {
	
	public ItemWeaponBookWither(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder.group(ItemGroupGaia.INSTANCE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		final EntityPlayer player = Minecraft.getInstance().player;
		if (player == null) {
			return;
		}
		if (player.getHeldItemOffhand() == stack) {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.BlessOffhand").applyTextStyle(TextFormatting.YELLOW));
		} else {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.BlessMainhand").applyTextStyle(TextFormatting.YELLOW));
		}

		tooltip.add(new TextComponentTranslation("effect.minecraft.wither").appendSibling(new TextComponentString(" (0:04)")));
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		host.playSound(GaiaSounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.WITHER, 80, 0));
		return true;
	}
}
