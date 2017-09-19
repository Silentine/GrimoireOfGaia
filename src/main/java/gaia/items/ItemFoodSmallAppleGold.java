package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nullable;

public class ItemFoodSmallAppleGold extends ItemFood {

    public ItemFoodSmallAppleGold(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        this.maxStackSize = 64;
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("effect.absorption") + " (2:00)");
        tooltip.add(I18n.format("effect.regeneration") + " (IV)" + " (0:04)");
        tooltip.add(I18n.format("effect.resistance") + " (0:50)");
        tooltip.add(I18n.format("effect.fireResistance") + " (0:50)");
    }

    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 4));
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1000, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1000, 0));
    }
}
