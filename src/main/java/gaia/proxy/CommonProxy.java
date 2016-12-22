package gaia.proxy;

import gaia.ConfigGaia;
import gaia.GaiaReference;
import gaia.entity.EntityMobAssist;
import gaia.entity.EntityMobBase;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.init.GaiaConfigGeneration;
import gaia.items.ItemWeaponBookNature;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {
	public void registerRenders() {
	}

	public void registerItemsRender() {
	}

	public void registerBlocksRender() {
	}

	public void registerHandlers() {
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.getModID().equals(GaiaReference.MOD_ID))
			GaiaConfigGeneration.syncConfig();
	}
	/** Prevents vanilla mobs from spawning for testing **/
	@SubscribeEvent
	public void Gaia_Spawn_Debug(CheckSpawn e){
		if(ConfigGaia.Spawn_Debug_Mode){
			if(e.getEntity() instanceof EntityMobAssist ||
					e.getEntity() instanceof EntityMobBase){
				e.setResult(Event.Result.ALLOW);
			}
			else{
				e.setResult(Event.Result.DENY);
			}
		}
	}
	
	/**http://jabelarminecraft.blogspot.com/p/minecraft-forge-172-event-handling.html**/
	@SubscribeEvent
	public void Gaia_Weapon_Books(AttackEntityEvent e){
		
		if(e.getTarget() == null || e.getEntityPlayer() == null){return;}		
		EntityPlayer player = e.getEntityPlayer();
		Entity mob = e.getTarget();
		if(player.getHeldItemOffhand() == null){return;}
		ItemStack offhand = player.getHeldItemOffhand();
		
		
		if(offhand.getItem() instanceof ItemWeaponBookNature){
			//note, appears a fair amount of mobs(including vanilla) are immune to poison
			//don't be a dork like me and trouble-shoot something that works perfectly well :^)
			((EntityLivingBase) mob).addPotionEffect(new PotionEffect(MobEffects.POISON, 80, 0));
		}
		
	}
	
	
}
