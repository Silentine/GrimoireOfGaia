package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.entity.GaiaLootTableList;
import gaia.entity.item.EntityGaiaAgeable;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
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

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @see ItemAppleGold
 */
public class ItemBox extends Item {

    public ItemBox(String name) {
        this.setHasSubtypes(true);
        this.maxStackSize = 1;
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
        tooltip.add(I18n.format("text.grimoireofgaia.RightClickUse"));
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
    public @Nonnull
            String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + stack.getItemDamage();
    }

    @Override
    public @Nonnull ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand handIn) {
        final ItemStack stack = player.getHeldItem(handIn);

        player.playSound(SoundEvents.BLOCK_CHEST_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

        if (!player.capabilities.isCreativeMode) {
            stack.shrink(1);
        }

        if (!world.isRemote) {
            if (stack.getMetadata() == 0) {
                EntityGaiaAgeable spawnEntity = new EntityGaiaAgeable(world, GaiaLootTableList.BOXES_OVERWORLD);
                spawnEntity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
                world.spawnEntity(spawnEntity);
            } else if (stack.getMetadata() == 1) {
                EntityGaiaAgeable spawnEntity = new EntityGaiaAgeable(world, GaiaLootTableList.BOXES_NETHER);
                spawnEntity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
                world.spawnEntity(spawnEntity);
            } else if (stack.getMetadata() == 2) {
                EntityGaiaAgeable spawnEntity = new EntityGaiaAgeable(world, GaiaLootTableList.BOXES_END);
                spawnEntity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
                world.spawnEntity(spawnEntity);
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
