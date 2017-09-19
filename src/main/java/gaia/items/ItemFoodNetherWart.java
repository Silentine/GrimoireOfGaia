package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nullable;

public class ItemFoodNetherWart extends GaiaItemFood {

    public ItemFoodNetherWart(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);

        this.setPotionEffect(new PotionEffect(MobEffects.SPEED, 30, 0), 0.4F);
        this.setSecondPotionEffect(new PotionEffect(MobEffects.HASTE, 30, 0), 0.4F);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("(40%) " + I18n.format("effect.moveSpeed") + " (0:30)");
        tooltip.add("(40%) " + I18n.format("effect.digSpeed") + " (0:30)");
    }
}
