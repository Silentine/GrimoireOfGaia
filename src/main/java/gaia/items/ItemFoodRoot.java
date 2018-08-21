package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodRoot extends ItemFood {

    public void clearNegativePotions(EntityPlayer entityplayer) {
        entityplayer.removePotionEffect(MobEffects.SLOWNESS);
        entityplayer.removePotionEffect(MobEffects.MINING_FATIGUE);
        entityplayer.removePotionEffect(MobEffects.NAUSEA);
        entityplayer.removePotionEffect(MobEffects.BLINDNESS);
        entityplayer.removePotionEffect(MobEffects.HUNGER);
        entityplayer.removePotionEffect(MobEffects.WEAKNESS);
        entityplayer.removePotionEffect(MobEffects.POISON);
        entityplayer.removePotionEffect(MobEffects.WITHER);
    }

    public ItemFoodRoot(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        this.setMaxStackSize(16);
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.NegativeStatus.desc"));
    }

    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        this.clearNegativePotions(player);
    }
}
