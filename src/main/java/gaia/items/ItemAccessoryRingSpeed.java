package gaia.items;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import baubles.api.BaubleType;
import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAccessoryRingSpeed extends ItemAccessoryBauble {

    public ItemAccessoryRingSpeed(String name) {
        setMaxStackSize(1);
        setRegistryName(GaiaReference.MOD_ID, name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    @Nonnull
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
        tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Accessory.tag")));

        if (shiftPressed) {
            tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.InventoryAccessory")));
            tooltip.add(I18n.format("effect.moveSpeed"));
        } else {
            tooltip.add(TextFormatting.ITALIC + (I18n.format("text.grimoireofgaia.HoldShift")));
        }
    }

    @Override
    public void doEffect(EntityLivingBase player, ItemStack item) {
        if (player.getActivePotionEffect(MobEffects.SPEED) != null) {
            player.removePotionEffect(MobEffects.SPEED);
        }

        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, Integer.MAX_VALUE, 1, true, true));
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        PotionEffect effect = player.getActivePotionEffect(MobEffects.SPEED);
        if (effect != null && player instanceof EntityPlayer && effect.getAmplifier() == 1) {
            player.removePotionEffect(MobEffects.SPEED);
        }
    }
}
