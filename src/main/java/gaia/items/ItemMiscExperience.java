package gaia.items;

import java.util.List;

import gaia.init.GaiaItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemMiscExperience extends ItemBase {
	public ItemMiscExperience(Item.Properties builder) {
		super(builder); //"misc_experience");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_IRON)) {
			tooltip.add(new TextComponentTranslation("item.grimoireofgaia.FoodExperienceIron.desc"));
		} else if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_GOLD)) {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.GainLevels", 2));
		} else if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_DIAMOND)) {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.GainLevels", 4));
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase living) {
		if (living instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) living;
			player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}

			if (!world.isRemote) {
				if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_IRON)) {
					player.addExperienceLevel(random.nextInt(2) + 1);
				} else if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_GOLD)) {
					player.addExperienceLevel(random.nextInt(3) + 2);
				} else if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_DIAMOND)) {
					player.addExperienceLevel(random.nextInt(5) + 4);
				}
			}
		} else {
			stack.shrink(1);
		}

		return stack;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 16;
	}

	@Override
	public EnumAction getUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);
		player.setActiveHand(handIn);
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
}
