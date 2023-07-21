package gaia.entity.trader;

import gaia.registry.GaiaRegistry;
import gaia.util.GaiaMerchantTrades;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SlimeGirl extends GaiaMerchant {
	public SlimeGirl(EntityType<? extends AbstractVillager> entityType, Level level) {
		super(entityType, level);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.SLIME_GIRL.getSay();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return GaiaRegistry.SLIME_GIRL.getHurt();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.SLIME_GIRL.getDeath();
	}

	@Override
	public Int2ObjectMap<VillagerTrades.ItemListing[]> getTrades() {
		return GaiaMerchantTrades.SLIME_GIRL_TRADES;
	}

	@Override
	protected void updateTrades() {
		VillagerTrades.ItemListing[] itemListings = getTrades().get(1);
		VillagerTrades.ItemListing[] itemListings1 = getTrades().get(2);
		if (itemListings != null && itemListings1 != null) {
			MerchantOffers merchantoffers = this.getOffers();
			this.addOffersFromItemListings(merchantoffers, itemListings, 4);
			this.addOffersFromItemListings(merchantoffers, itemListings1, 5);
		}
	}
}
