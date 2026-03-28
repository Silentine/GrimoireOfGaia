package gaia.entity.trader;

import gaia.registry.GaiaRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class EnderGirl extends GaiaMerchant {
	public EnderGirl(EntityType<? extends AbstractVillager> entityType, Level level) {
		super(entityType, level);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.ENDER_GIRL.getSay();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return GaiaRegistry.ENDER_GIRL.getHurt();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.ENDER_GIRL.getDeath();
	}

//	@Override
//	public Int2ObjectMap<VillagerTrades.ItemListing[]> getTrades() {
//		return GaiaMerchantTrades.ENDER_GIRL_TRADES;
//	}
//
//	@Override
//	protected void updateTrades() {
//		VillagerTrades.ItemListing[] itemListings = getTrades().get(1);
//		VillagerTrades.ItemListing[] itemListings1 = getTrades().get(2);
//		if (itemListings != null && itemListings1 != null) {
//			MerchantOffers merchantoffers = this.getOffers();
//			this.addOffersFromItemListings(merchantoffers, itemListings, 4);
//			this.addOffersFromItemListings(merchantoffers, itemListings1, 5);
//		}
//	}
}
