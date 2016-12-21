package gaia.proxy;

import gaia.ConfigGaia;
import gaia.GaiaReference;
import gaia.entity.EntityMobAssist;
import gaia.entity.EntityMobBase;
import gaia.init.GaiaConfigGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
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
}
