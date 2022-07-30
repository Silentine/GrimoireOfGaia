package gaia.capability.friended;

import gaia.capability.CapabilityHandler;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FriendedCapability implements IFriended, ICapabilitySerializable<CompoundTag>, ICapabilityProvider {
	private boolean friended = false;
	private boolean changed = false;

	@Override
	public boolean isFriendly() {
		return friended;
	}

	@Override
	public boolean isChanged() {
		return changed;
	}

	@Override
	public void setFriendly(boolean value) {
		this.friended = value;
		this.setChanged(true);
	}

	@Override
	public void setChanged(boolean value) {
		this.changed = value;
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag tag = new CompoundTag();
		tag.putBoolean("friended", this.isFriendly());
		return tag;
	}

	@Override
	public void deserializeNBT(CompoundTag tag) {
		this.setFriendly(tag.getBoolean("friended"));
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return CapabilityHandler.CAPABILITY_FRIENDED.orEmpty(cap, LazyOptional.of(() -> this));
	}

	public final Capability<IFriended> getCapability() {
		return CapabilityHandler.CAPABILITY_FRIENDED;
	}
}
