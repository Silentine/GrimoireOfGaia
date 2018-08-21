package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodIce extends ItemFood {

    public ItemFoodIce(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);

        setRegistryName(GaiaReference.MOD_ID, name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabGaia.INSTANCE);
        setPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 400), 1.0F);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("effect.fireResistance") + " (0:20)");
    }
}
