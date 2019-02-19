package gaia.handlers;

import gaia.Gaia;
import gaia.GaiaConfig;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.EntityMobPassive;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DimensionHandler {
    @SubscribeEvent
    public static void onSpawnCheck(final LivingSpawnEvent.CheckSpawn event)
    {
        if (event.getEntity() instanceof EntityMobPassive || event.getEntity() instanceof EntityMobHostileBase) {
            if(!GaiaConfig.COMMON.dimensionBlacklist.get().isEmpty())
            {
                event.setResult(Event.Result.DEFAULT);
                for (String id : GaiaConfig.COMMON.dimensionBlacklist.get()) {
                    if(!id.isEmpty())
                    {
                        int i = Integer.valueOf(id);
                        if (i == event.getWorld().getDimension().getType().getId()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }
            }
        }
    }
}
