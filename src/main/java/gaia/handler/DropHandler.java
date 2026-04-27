package gaia.handler;

import gaia.Reference;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

@EventBusSubscriber
public class DropHandler {

	@SubscribeEvent
	public static void onLivingDrop(LivingDropsEvent event) {
		LivingEntity livingEntity = event.getEntity();
		if (livingEntity.getPersistentData().contains(Reference.SUMMONED_TAG)) {
			event.getDrops().clear();
		}
	}
}
