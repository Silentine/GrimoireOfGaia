package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodPieAppleGold extends GaiaItemFood {

    public ItemFoodPieAppleGold(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        this.maxStackSize = 1;
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.GainExperience"));
        tooltip.add(I18n.format("effect.absorption") + " (2:00)");
        tooltip.add(I18n.format("effect.regeneration") + " (IV)" + " (0:20)");
        tooltip.add(I18n.format("effect.resistance") + " (5:00)");
        tooltip.add(I18n.format("effect.fireResistance") + " (5:00)");
    }

    // PotionEffect is a direct copy of ItemAppleGold
    // Gained experience is 100% more
    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        rewardEXP(player, itemRand.nextInt(32) + 16);
        player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 4));
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
    }
}
