package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nullable;

public class ItemMiscBook extends Item {

    public ItemMiscBook(String name) {
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.GrimoireOfGaia.GainLevels"));
    }

    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase living) {
        EntityPlayer player = living instanceof EntityPlayer ? (EntityPlayer) living : null;
        player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

        if (!player.capabilities.isCreativeMode) {
            stack.shrink(1);
            ;
        }

        if (!world.isRemote) {
            player.addExperienceLevel(10);
        }

        return stack;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 16;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.setActiveHand(hand);
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }
}
