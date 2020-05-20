package gaia.item.weapons;

import gaia.init.GaiaSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemWeaponBookEnder extends ItemWeaponBook {
	
	public ItemWeaponBookEnder(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
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

		tooltip.add(new TranslationTextComponent("effect.minecraft.blindness").appendSibling(new StringTextComponent(" (0:04)")));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack itemStackIn = player.getHeldItem(hand);

		itemStackIn.damageItem(5, player, (entity) -> { entity.sendBreakAnimation(hand); });
		player.addExhaustion(5.0F);

		world.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F,
				0.4F / (random.nextFloat() * 0.4F + 0.8F));
		player.getCooldownTracker()
				.setCooldown(this, 60);

		if (!world.isRemote) {
			EnderPearlEntity entitysnowball = new EnderPearlEntity(world, player);
			entitysnowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.addEntity(entitysnowball);
		}

		//noinspection ConstantConditions - registered items have id and thus shouldn't return null
		player.addStat(Stats.ITEM_USED.get(this));
		return new ActionResult<>(ActionResultType.SUCCESS, itemStackIn);
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity host) {
		stack.damageItem(1, host, (entity) -> { entity.sendBreakAnimation(host.getActiveHand()); });
		host.playSound(GaiaSounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 80, 0));
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return Items.ENDER_PEARL == repair.getItem();
	}
}
