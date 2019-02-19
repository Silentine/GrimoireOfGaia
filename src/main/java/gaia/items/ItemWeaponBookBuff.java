package gaia.items;

import java.util.List;

import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemWeaponBookBuff extends ItemBase {
	public ItemWeaponBookBuff(Item.Properties builder) {
		super(builder.maxStackSize(1).defaultMaxDamage(64)); //"weapon_book_buff");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
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
		
		tooltip.add(new TextComponentTranslation("effect.minecraft.strength").appendSibling(new TextComponentString(" (1:00)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.resistance").appendSibling(new TextComponentString(" (1:00)")));
		tooltip.add(new TextComponentTranslation("effect.minecraft.regeneration").appendSibling(new TextComponentString(" (IV)")).appendSibling(new TextComponentString(" (0:04)")));
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		host.playSound(GaiaSounds.BOOK_HIT, 1.0F, 1.0F);
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
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == GaiaItems.MISC_QUILL;
	}
}
