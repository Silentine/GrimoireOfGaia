package gaia.proxy;

import gaia.GaiaConfig;
import gaia.GaiaReference;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.EntityMobPassiveBase;
import gaia.init.GaiaConfigGeneration;
import gaia.items.ItemWeaponBookBattle;
import gaia.items.ItemWeaponBookBuff;
import gaia.items.ItemWeaponBookEnder;
import gaia.items.ItemWeaponBookFreezing;
import gaia.items.ItemWeaponBookHunger;
import gaia.items.ItemWeaponBookMetal;
import gaia.items.ItemWeaponBookNature;
import gaia.items.ItemWeaponBookNightmare;
import gaia.items.ItemWeaponBookWither;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {
	public void registerRenders() {}

	public void registerItemsRender() {}

	public void registerBlocksRender() {}

	public void registerHandlers() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.getModID().equals(GaiaReference.MOD_ID))
			GaiaConfigGeneration.syncConfig();
	}

	@SubscribeEvent
	public void Gaia_Spawn_Debug(CheckSpawn event) {
		if (GaiaConfig.Debug_Spawn) {
			if (event.getEntity() instanceof EntityMobPassiveBase || event.getEntity() instanceof EntityMobHostileBase) {
				EntityLiving living = (EntityLiving)event.getEntity();
				if (living.getCanSpawnHere())
					event.setResult(Event.Result.ALLOW);
				else 
					event.setResult(Event.Result.DENY);
			} else {
				event.setResult(Event.Result.DENY);
			}
		}
	}

	/** Source
	 * <li>http://jabelarminecraft.blogspot.com/p/minecraft-forge-172-event-handling.html
	 */
	@SubscribeEvent
	public void Gaia_Weapon_Books(AttackEntityEvent event) {
		if (event.getTarget() == null || event.getEntityPlayer() == null) {return;}		
		EntityPlayer player = event.getEntityPlayer();
		Entity mob = event.getTarget();
		if (player.getHeldItemOffhand() == null) {return;}
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
		
		if (offHand.getItem() instanceof ItemWeaponBookFreezing) {
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
	public void damageBook(EntityPlayer player, ItemStack stack) {
		//Creative check
		if (player.capabilities.isCreativeMode) {return;}		
		stack.damageItem(2, player);
		
		//Manually send an update to destroy the item
		//otherwise client doesn't sync correctly here
		if (stack.getItemDamage() <= 0) {
			player.inventory.setInventorySlotContents(40, null);
		}
	}
}
