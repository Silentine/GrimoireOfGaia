package gaia.item;

import gaia.init.GaiaItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemMiscExperience extends Item {
	public ItemMiscExperience(Item.Properties builder) {
		super(builder); //"misc_experience");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
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
			tooltip.add(new TranslationTextComponent("item.grimoireofgaia.FoodExperienceIron.desc"));
		} else if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_GOLD)) {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.GainLevels", 2));
		} else if (stack.getItem().equals(GaiaItems.MISC_EXPERIENCE_DIAMOND)) {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.GainLevels", 4));
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity living) {
		if (living instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) living;
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
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);
		player.setActiveHand(handIn);
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}
}
