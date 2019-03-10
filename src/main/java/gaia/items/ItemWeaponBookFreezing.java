package gaia.items;

import gaia.init.GaiaSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
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

public class ItemWeaponBookFreezing extends ItemWeaponBook {
	
	public ItemWeaponBookFreezing(ToolMaterial material, String name) {
		super(material, name);
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

		tooltip.add(I18n.format("effect.moveSlowdown") + " II" + " (0:04)");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		stack.damageItem(5, player);
		player.addExhaustion(5.0F);

		world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F,
				0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		player.getCooldownTracker().setCooldown(this, 60);

		if (!world.isRemote) {
			EntitySnowball snowball = new EntitySnowball(world, player);
			snowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(snowball);
		}

		StatBase statBase = StatList.getObjectUseStats(this);
		if (statBase != null) {
			player.addStat(statBase);
		}

		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		super.hitEntity(stack, target, attacker);

		attacker.playSound(GaiaSounds.BOOK_HIT, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80, 1));

		return true;
	}
}
