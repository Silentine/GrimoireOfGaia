package gaia.items;

import gaia.helpers.ModelLoaderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMiscExperience extends ItemBase {
	public ItemMiscExperience() {
		super("misc_experience");
		setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (stack.getItemDamage() == 0) {
			tooltip.add(I18n.format("item.grimoireofgaia.FoodExperienceIron.desc"));
		} else if (stack.getMetadata() == 1) {
			tooltip.add(I18n.format("text.grimoireofgaia.GainLevels", 2));
		} else if (stack.getMetadata() == 2) {
			tooltip.add(I18n.format("text.grimoireofgaia.GainLevels", 4));
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase living) {
		if (living instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) living;
			player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

			if (!player.capabilities.isCreativeMode) {
				stack.shrink(1);
			}

			if (!world.isRemote) {
				if (stack.getMetadata() == 0) {
					player.addExperienceLevel(itemRand.nextInt(2) + 1);
				} else if (stack.getMetadata() == 1) {
					player.addExperienceLevel(itemRand.nextInt(3) + 2);
				} else if (stack.getMetadata() == 2) {
					player.addExperienceLevel(itemRand.nextInt(5) + 4);
				}
			}
		} else {
			stack.shrink(1);
		}

		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 16;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		final ItemStack stack = player.getHeldItem(handIn);
		player.setActiveHand(handIn);
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
	
	/* SUBITEMS */
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 3; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this, 
				"variant=iron", 
				"variant=gold", 
				"variant=diamond"
				);
	}
	/* SUBITEMS */
}
