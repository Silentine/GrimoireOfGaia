package gaia.item.weapons;

import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemWeaponBookBuff extends Item {
	public ItemWeaponBookBuff(Item.Properties builder) {
		super(builder.maxStackSize(1).defaultMaxDamage(64)); //"weapon_book_buff");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		final PlayerEntity player = Minecraft.getInstance().player;
		if (player == null) {
			return;
		}
		if (player.getHeldItemOffhand() == stack) {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.BlessOffhand").applyTextStyle(TextFormatting.YELLOW));
		} else {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.BlessMainhand").applyTextStyle(TextFormatting.YELLOW));
		}

		tooltip.add(new TranslationTextComponent("effect.minecraft.strength").appendSibling(new StringTextComponent(" (1:00)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.resistance").appendSibling(new StringTextComponent(" (1:00)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.regeneration").appendSibling(new StringTextComponent(" (IV)")).appendSibling(new StringTextComponent(" (0:04)")));
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity host) {
		stack.damageItem(1, host, (entity) -> { entity.sendBreakAnimation(host.getActiveHand()); });
		host.playSound(GaiaSounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new EffectInstance(Effects.STRENGTH, 600, 0));
		target.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 600, 0));
		target.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 3));
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		if ((double) state.getBlockHardness(worldIn, pos) != 0.0D) {
			stack.damageItem(2, entityLiving, (entity) -> { entity.sendBreakAnimation(entityLiving.getActiveHand()); });
		}

		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == GaiaItems.MISC_QUILL.get();
	}
}
