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
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@InterfaceList({
	@Interface(iface="baubles.api.BaubleType", modid="Baubles", striprefs=true)})

public class ItemAccessoryTrinketLevitation extends ItemAccessoryBauble {

    public ItemAccessoryTrinketLevitation(String name) {
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
        return BaubleType.CHARM;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
        tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Trinket.tag")));

        if (shiftPressed) {
            tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.InventoryTrinket")));
            tooltip.add(I18n.format("text.grimoireofgaia.InventoryImmunity") + " " + I18n.format("effect.levitation"));
            tooltip.add(I18n.format("effect.moveSlowdown"));
        } else {
            tooltip.add(TextFormatting.ITALIC + (I18n.format("text.grimoireofgaia.HoldShift")));
        }
    }

    @Override
    public void doEffect(EntityLivingBase player, ItemStack item) {
        if (player.getActivePotionEffect(MobEffects.LEVITATION) != null) {
            player.removePotionEffect(MobEffects.LEVITATION);
        }

        if (player.getActivePotionEffect(MobEffects.SLOWNESS) != null) {
            player.removePotionEffect(MobEffects.SLOWNESS);
        }

        player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, Integer.MAX_VALUE, 1, true, true));
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        PotionEffect effect = player.getActivePotionEffect(MobEffects.SLOWNESS);
        if (effect != null && player instanceof EntityPlayer && effect.getAmplifier() == 1) {
            player.removePotionEffect(MobEffects.SLOWNESS);
        }
    }
}
