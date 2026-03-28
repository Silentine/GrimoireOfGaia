package gaia.attachment.friended;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
import org.jspecify.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public record Friended(boolean isFriendly, Optional<UUID> friendedBy) {
	public static final MapCodec<Friended> MAP_CODEC = RecordCodecBuilder.mapCodec(
			i -> i.group(
							Codec.BOOL.fieldOf("isFriendly").forGetter(o -> o.isFriendly),
							UUIDUtil.CODEC.lenientOptionalFieldOf("friendedBy").forGetter(o -> o.friendedBy)
					)
					.apply(i, Friended::new)
	);

	public Friended() {
		this(false, Optional.empty());
	}

	/**
	 * Creates a new {@link Friended} instance with the given values.
	 */
	public static class Builder {
		private boolean friended;
		@Nullable
		private Optional<UUID> friendedBy = Optional.empty();

		public Builder() {
		}

		public Builder setFriended(boolean friended) {
			this.friended = friended;
			return this;
		}

		public Builder setFriendedBy(@Nullable UUID friendedBy) {
			this.friendedBy = Optional.ofNullable(friendedBy);
			return this;
		}

		public Friended build() {
			return new Friended(friended, friendedBy);
		}
	}
}
