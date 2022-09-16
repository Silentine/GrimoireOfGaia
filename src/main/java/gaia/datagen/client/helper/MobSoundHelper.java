package gaia.datagen.client.helper;

import gaia.GrimoireOfGaia;
import gaia.registry.helper.GaiaSoundType;
import gaia.registry.helper.MobReg;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinition.Sound;
import net.minecraftforge.common.data.SoundDefinition.SoundType;

public class MobSoundHelper {
	private final MobReg<?> mobReg;
	private final SoundDefinition.Sound[] say;
	private final SoundDefinition.Sound[] hurt;
	private final SoundDefinition.Sound[] death;
	private final SoundDefinition.Sound[] step;
	private final SoundDefinition.Sound[] sayMale;
	private final SoundDefinition.Sound[] hurtMale;
	private final SoundDefinition.Sound[] deathMale;
	private final SoundDefinition.Sound[] stepMale;

	public MobReg<?> getMobReg() {
		return mobReg;
	}

	public SoundDefinition.Sound[] getSay() {
		return say;
	}

	public SoundDefinition.Sound[] getHurt() {
		return hurt;
	}

	public SoundDefinition.Sound[] getDeath() {
		return death;
	}

	public SoundDefinition.Sound[] getStep() {
		return step;
	}

	public SoundDefinition.Sound[] getMaleSay() {
		return sayMale;
	}

	public SoundDefinition.Sound[] getMaleHurt() {
		return hurtMale;
	}

	public SoundDefinition.Sound[] getMaleDeath() {
		return deathMale;
	}

	public SoundDefinition.Sound[] getMaleStep() {
		return stepMale;
	}

	public MobSoundHelper(MobReg<?> mobReg,
						  SoundDefinition.Sound[] say, SoundDefinition.Sound[] hurt, SoundDefinition.Sound[] death, SoundDefinition.Sound[] step,
						  SoundDefinition.Sound[] sayMale, SoundDefinition.Sound[] hurtMale, SoundDefinition.Sound[] deathMale, SoundDefinition.Sound[] stepMale) {
		this.mobReg = mobReg;
		this.say = say;
		this.hurt = hurt;
		this.death = death;
		this.step = step;
		this.sayMale = sayMale;
		this.hurtMale = hurtMale;
		this.deathMale = deathMale;
		this.stepMale = stepMale;
	}

	public static class Builder {
		private final MobReg<?> mobReg;
		private SoundDefinition.Sound[] say = new SoundDefinition.Sound[]{};
		private SoundDefinition.Sound[] hurt = new SoundDefinition.Sound[]{};
		private SoundDefinition.Sound[] death = new SoundDefinition.Sound[]{};
		private SoundDefinition.Sound[] step = new SoundDefinition.Sound[]{};
		private SoundDefinition.Sound[] sayMale = new SoundDefinition.Sound[]{};
		private SoundDefinition.Sound[] hurtMale = new SoundDefinition.Sound[]{};
		private SoundDefinition.Sound[] deathMale = new SoundDefinition.Sound[]{};
		private SoundDefinition.Sound[] stepMale = new SoundDefinition.Sound[]{};

		public Builder(MobReg<?> reg) {
			this.mobReg = reg;

		}

		public Builder withDefaults() {
			String base = "aggressive_";
			GaiaSoundType mobType = mobReg.getGaiaSoundType();
			if (mobType == GaiaSoundType.ASSIST) {
				base = "assist_";
			} else if (mobType == GaiaSoundType.PASSIVE) {
				base = "passive_";
			}

			if (mobReg.getSay() != null) {
				this.say = new Sound[]{
						sound(base + "say1"),
						sound(base + "say2"),
						sound(base + "say3")};
			}

			if (mobReg.getHurt() != null) {
				this.hurt = new Sound[]{
						sound(base + "hurt1"),
						sound(base + "hurt2"),
						sound(base + "hurt3")};
			}

			if (mobReg.getDeath() != null) {
				this.death = new Sound[]{
						sound(base + "death")};
			}
			return this;
		}

		public Builder withSay(Sound... sounds) {
			this.say = sounds;
			return this;
		}

		public Builder withHurt(Sound... sounds) {
			this.hurt = sounds;
			return this;
		}

		public Builder withDeath(Sound... sounds) {
			this.death = sounds;
			return this;
		}

		public Builder withStep(Sound... sounds) {
			this.step = sounds;
			return this;
		}

		public Builder withSayMale(Sound... sounds) {
			this.sayMale = sounds;
			return this;
		}

		public Builder withHurtMale(Sound... sounds) {
			this.hurtMale = sounds;
			return this;
		}

		public Builder withDeathMale(Sound... sounds) {
			this.deathMale = sounds;
			return this;
		}

		public Builder withStepMale(Sound... sounds) {
			this.stepMale = sounds;
			return this;
		}

		private SoundDefinition.Sound sound(String name) {
			return SoundDefinition.Sound.sound(new ResourceLocation(GrimoireOfGaia.MOD_ID, name), SoundType.SOUND);
		}

		public MobSoundHelper build() {
			return new MobSoundHelper(mobReg, say, hurt, death, step, sayMale, hurtMale, deathMale, stepMale);
		}
	}
}
