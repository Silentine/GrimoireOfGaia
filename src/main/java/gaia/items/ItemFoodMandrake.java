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
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodMandrake extends ItemFood {

    public ItemFoodMandrake(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        this.maxStackSize = 16;
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);

        this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 30, 0), 0.8F);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.HeartsGain", new Object[] {Integer.valueOf(2)}));
        tooltip.add(I18n.format("text.grimoireofgaia.HungerLose", new Object[] {Integer.valueOf(4)}));
        tooltip.add("(80%) " + I18n.format("effect.confusion") + " (0:20)");
    }

    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.heal(4.0F);
        player.addExhaustion(40.0F);
    }
}
