package gaia.handlers;

import gaia.GaiaReference;
import gaia.items.ItemWeaponBookBattle;
import gaia.items.ItemWeaponBookBuff;
import gaia.items.ItemWeaponBookEnder;
import gaia.items.ItemWeaponBookHunger;
import gaia.items.ItemWeaponBookMetal;
import gaia.items.ItemWeaponBookNature;
import gaia.items.ItemWeaponBookNightmare;
import gaia.items.ItemWeaponBookWither;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GaiaEventHandler {
    @SubscribeEvent
    public static void onAttackWithWeaponBooks(AttackEntityEvent event) {
        if (event.getTarget() == null || event.getEntityPlayer() == null) {
            return;
        }
        EntityPlayer player = event.getEntityPlayer();
        Entity mob = event.getTarget();
        if (player.getHeldItemOffhand().isEmpty()) {
            return;
        }
        ItemStack offHand = player.getHeldItemOffhand();

        if (offHand.getItem() instanceof ItemWeaponBookBattle) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 80, 0));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookBuff) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 600, 0));
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 0));
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 3));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookEnder) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookEnder) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80, 0));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookHunger) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 80, 0));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookMetal) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 80, 0));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookNature) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.POISON, 80, 0));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookNightmare) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 80, 0));
            damageBook(player, offHand);
        }

        if (offHand.getItem() instanceof ItemWeaponBookWither) {
            ((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.WITHER, 80, 0));
            damageBook(player, offHand);
        }
    }

    /**
     * Method used for handling book damage while in off-hand slot
     */
    private static void damageBook(EntityPlayer player, ItemStack stack) {
        // Creative check
        if (player.abilities.isCreativeMode) {
            return;
        }
        stack.damageItem(2, player);

        // Manually send an update to destroy the item otherwise client doesn't sync correctly here
        if (stack.getDamage() <= 0) {
            player.inventory.removeStackFromSlot(40);
        }
    }
}
