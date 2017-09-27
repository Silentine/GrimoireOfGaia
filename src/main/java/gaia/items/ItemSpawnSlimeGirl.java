package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemSpawnSlimeGirl extends Item {

    public ItemSpawnSlimeGirl(String name) {
        this.maxStackSize = 16;
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
        tooltip.add(I18n.format("item.grimoireofgaia.SpawnSlimeGirl.desc"));
    }

    @Override
    public @Nonnull
            EnumActionResult
            onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        final ItemStack stack = playerIn.getHeldItem(hand);

        pos = pos.offset(facing);

        if (!playerIn.canPlayerEdit(pos, facing, stack)) {
            return EnumActionResult.FAIL;
        } else {
            if (!playerIn.capabilities.isCreativeMode) {
                stack.shrink(1);
            }

            if (worldIn.isAirBlock(pos)) {
                if (!worldIn.isRemote) {
                    EntityGaiaNPCSlimeGirl spawnEntity = new EntityGaiaNPCSlimeGirl(worldIn);
                    spawnEntity.setLocationAndAngles(playerIn.posX + 0.5, playerIn.posY, playerIn.posZ + 0.5, 0, 0);
                    worldIn.spawnEntity(spawnEntity);
                }
            }

            return EnumActionResult.SUCCESS;
        }
    }
}
