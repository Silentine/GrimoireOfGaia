package gaia.handler;

import gaia.item.weapon.book.GaiaBookItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class BookHandler {
	@SubscribeEvent
	public static void onHurt(LivingDamageEvent.Post event) {
		DamageSource damageSource = event.getSource();
		if (damageSource.getDirectEntity() instanceof LivingEntity livingEntity) {
			ItemStack offhandItem = livingEntity.getOffhandItem();
			if (offhandItem.getItem() instanceof GaiaBookItem book) {
				book.executeHurtEffect(offhandItem, event.getEntity(), livingEntity);
			}
		}
	}
}
