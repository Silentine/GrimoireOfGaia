package gaia.items;

import gaia.init.Sounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWeaponBookEnder extends ItemWeaponBook {
	public ItemWeaponBookEnder() {
		super("weapon_book_ender");
		setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses() * 3.48F));
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

		tooltip.add(I18n.format("effect.blindness") + " (0:04)");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack itemStackIn = player.getHeldItem(hand);

		itemStackIn.damageItem(5, player);
		player.addExhaustion(5.0F);

		world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F,
				0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		player.getCooldownTracker()
				.setCooldown(this, 60);

		if (!world.isRemote) {
			EntityEnderPearl entitysnowball = new EntityEnderPearl(world, player);
			entitysnowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(entitysnowball);
		}

		//noinspection ConstantConditions - registered items have id and thus shouldn't return null
		player.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		host.playSound(Sounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return Items.ENDER_PEARL == repair.getItem();
	}
}
