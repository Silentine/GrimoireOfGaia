//package gaia.entity.trader;
//
//import gaia.registry.GaiaRegistry;
//import gaia.util.GaiaMerchantTrades;
//import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.npc.AbstractVillager;
//import net.minecraft.world.entity.npc.VillagerTrades;
//import net.minecraft.world.item.trading.MerchantOffer;
//import net.minecraft.world.item.trading.MerchantOffers;
//import net.minecraft.world.level.Level;
//import org.jetbrains.annotations.Nullable;
//
//public class Weresheep extends GaiaMerchant {
//	public Weresheep(EntityType<? extends AbstractVillager> entityType, Level level) {
//		super(entityType, level);
//	}
//
//	@Nullable
//	@Override
//	protected SoundEvent getAmbientSound() {
//		return GaiaRegistry.WERESHEEP.getSay();
//	}
//
//	@Nullable
//	@Override
//	protected SoundEvent getHurtSound(DamageSource source) {
//		return GaiaRegistry.WERESHEEP.getHurt();
//	}
//
//	@Nullable
//	@Override
//	protected SoundEvent getDeathSound() {
//		return GaiaRegistry.WERESHEEP.getDeath();
//	}
//
//	@Override
//	public Int2ObjectMap<VillagerTrades.ItemListing[]> getTrades() {
//		return GaiaMerchantTrades.WERESHEEP_TRADES;
//	}
//
//	@Override
//	protected void updateTrades() {
//		VillagerTrades.ItemListing[] itemListings = getTrades().get(1);
//		VillagerTrades.ItemListing[] itemListings1 = getTrades().get(2);
//		VillagerTrades.ItemListing[] itemListings2 = getTrades().get(3);
//		if (itemListings != null && itemListings1 != null) {
//			MerchantOffers merchantoffers = this.getOffers();
//			this.addOffersFromItemListings(merchantoffers, itemListings, 10);
//			VillagerTrades.ItemListing villagertrades$itemlisting = itemListings2[0];
//			MerchantOffer stringBuyOffer = villagertrades$itemlisting.getOffer(this, this.random);
//			if (stringBuyOffer != null) {
//				merchantoffers.add(stringBuyOffer);
//			}
//			this.addOffersFromItemListings(merchantoffers, itemListings1, 10);
//		}
//	}
//}
