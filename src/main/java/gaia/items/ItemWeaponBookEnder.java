package gaia.items;

import java.util.List;

import gaia.ItemGroupGaia;
import gaia.init.GaiaSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemWeaponBookEnder extends ItemWeaponBook {
	
	public ItemWeaponBookEnder(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder.group(ItemGroupGaia.INSTANCE));
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

		tooltip.add(new TextComponentTranslation("effect.minecraft.blindness").appendSibling(new TextComponentString(" (0:04)")));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack itemStackIn = player.getHeldItem(hand);

		itemStackIn.damageItem(5, player);
		player.addExhaustion(5.0F);

		world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F,
				0.4F / (random.nextFloat() * 0.4F + 0.8F));
		player.getCooldownTracker()
				.setCooldown(this, 60);

		if (!world.isRemote) {
			EntityEnderPearl entitysnowball = new EntityEnderPearl(world, player);
			entitysnowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(entitysnowball);
		}

		//noinspection ConstantConditions - registered items have id and thus shouldn't return null
		player.addStat(StatList.ITEM_USED.get(this));
		return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		host.playSound(GaiaSounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return Items.ENDER_PEARL == repair.getItem();
	}
}
