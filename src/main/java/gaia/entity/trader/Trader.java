package gaia.entity.trader;

import gaia.registry.GaiaRegistry;
import gaia.util.GaiaMerchantTrades;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Trader extends GaiaMerchant {
	public Trader(EntityType<? extends AbstractVillager> entityType, Level level) {
		super(entityType, level);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.TRADER.getSay();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return GaiaRegistry.TRADER.getHurt();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.TRADER.getDeath();
	}

	@Override
	public Int2ObjectMap<VillagerTrades.ItemListing[]> getTrades() {
		return GaiaMerchantTrades.MERCHANT_TRADES;
	}
}
