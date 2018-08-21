package gaia.items;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see ItemMiscSoulFiery
 */
public class ItemMiscSoulFiery extends Item {

    public ItemMiscSoulFiery(String name) {
        setRegistryName(GaiaReference.MOD_ID, name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.FuelForSeconds", TileEntityFurnace.getItemBurnTime(stack)));
        tooltip.add(TextFormatting.ITALIC + I18n.format("item.grimoireofgaia.MiscSoulFiery.desc"));
    }

    @Override
    public @Nonnull EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX,
            float hitY, float hitZ) {
        final ItemStack stack = player.getHeldItem(hand);

        if (!player.capabilities.isCreativeMode) {
            stack.shrink(1);
        }

        pos = pos.offset(facing);

        if (!player.canPlayerEdit(pos, facing, stack)) {
            return EnumActionResult.FAIL;
        } else {
            if (world.isAirBlock(pos)) {
                world.playSound(player, player.getPosition(), SoundEvents.ENTITY_GHAST_SCREAM, SoundCategory.PLAYERS, 0.4F, 0.8F);
                world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
            }

            stack.damageItem(1, player);

            return EnumActionResult.SUCCESS;
        }
    }
    
    @Override
    public int getItemBurnTime(ItemStack itemStack) {
    	return 1000;
    }
}
