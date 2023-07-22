package gaia.handler;

import gaia.Reference;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DropHandler {

	@SubscribeEvent
	public void onLivingDrop(LivingDropsEvent event) {
		LivingEntity livingEntity = event.getEntity();
		if (livingEntity.getPersistentData().contains(Reference.SUMMONED_TAG)) {
			event.getDrops().clear();
		}
	}
}
