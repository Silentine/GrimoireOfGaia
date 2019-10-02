package gaia.handlers;

import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SpawnHandler {
    @SubscribeEvent
    public void onSpawn(final LivingSpawnEvent.CheckSpawn event)
    {
//        if (event.getEntity() instanceof EntityMobAssist || event.getEntity() instanceof EntityMobHostileBase) {
//            Gaia.LOGGER.debug(event.getEntity().getName().getString() + " is trying to spawn.");
//            Gaia.LOGGER.debug(GaiaConfig.COMMON.dimensionBlacklist.get());
//            if(!GaiaConfig.COMMON.dimensionBlacklist.get().isEmpty())
//            {
//                event.setResult(Event.Result.DEFAULT);
//                for (String id : GaiaConfig.COMMON.dimensionBlacklist.get()) {
//                    if(!id.isEmpty())
//                    {
//                        int i = Integer.valueOf(id);
//                        if (i == event.getWorld().getDimension().getType().getId()) {
//                            event.setResult(Event.Result.DENY);
//                        }
//                    }
//                }
//            }
//        }
    }
}
