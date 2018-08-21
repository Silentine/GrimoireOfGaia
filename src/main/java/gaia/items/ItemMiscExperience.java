package gaia.items;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see ItemAppleGold
 */
public class ItemMiscExperience extends Item {

    public ItemMiscExperience(String name) {
        this.setHasSubtypes(true);
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

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
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!this.isInCreativeTab(tab)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + stack.getItemDamage();
    }

    @Override
    public @Nonnull
            ItemStack onItemUseFinish(@Nonnull ItemStack stack, World world, EntityLivingBase living) {
        EntityPlayer player = living instanceof EntityPlayer
                ? (EntityPlayer) living
                : null;
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

        return stack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 16;
    }

    @Override
    public @Nonnull
            EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public @Nonnull
            ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand handIn) {
        final ItemStack stack = player.getHeldItem(handIn);
        player.setActiveHand(handIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
