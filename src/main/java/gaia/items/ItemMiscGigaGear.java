package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemMiscGigaGear extends Item {

    public ItemMiscGigaGear(String name) {
        setMaxStackSize(1);
        setRegistryName(GaiaReference.MOD_ID, name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.FuelForSeconds", TileEntityFurnace.getItemBurnTime(stack)));
        tooltip.add(TextFormatting.ITALIC + I18n.format("item.grimoireofgaia.MiscGigaGear.desc"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public @Nonnull EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }
}
