package gaia.items;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodCoalfish extends ItemFood {

    public ItemFoodCoalfish(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);

        setRegistryName(GaiaReference.MOD_ID, name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.FuelForSeconds", TileEntityFurnace.getItemBurnTime(stack)));
        tooltip.add(I18n.format("effect.waterBreathing") + " (2:00)");
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, @Nonnull EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 2400, 0));
    }
    
    @Override
    public int getItemBurnTime(ItemStack itemStack) {
    	return 180;
    }
}
