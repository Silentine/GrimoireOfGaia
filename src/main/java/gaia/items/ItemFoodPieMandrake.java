package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodPieMandrake extends GaiaItemFood {

    public ItemFoodPieMandrake(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        this.maxStackSize = 1;
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.GainExperience"));
        tooltip.add(I18n.format("effect.nightVision") + " (3:00)");
        tooltip.add(I18n.format("effect.waterBreathing") + " (3:00)");
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        rewardEXP(player, itemRand.nextInt(16) + 8);
        player.heal(4.0F);
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 3600, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 3600, 0));
    }
}
