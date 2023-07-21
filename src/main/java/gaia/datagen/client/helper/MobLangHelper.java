package gaia.datagen.client.helper;

import gaia.registry.helper.MobReg;

@SuppressWarnings("ClassCanBeRecord")
public class MobLangHelper {
	private final MobReg<?> mobReg;
	private final String name;
	private final String spawnEgg;
	private final String say;
	private final String hurt;
	private final String death;
	private final String step;
	private final String attack;

	public MobReg<?> getMobReg() {
		return mobReg;
	}

	public String getName() {
		return name;
	}

	public String getSpawnEgg() {
		return spawnEgg;
	}

	public String getSay() {
		return say;
	}

	public String getHurt() {
		return hurt;
	}

	public String getDeath() {
		return death;
	}

	public String getStep() {
		return step;
	}

	public String getAttack() {
		return attack;
	}

	public MobLangHelper(MobReg<?> mobReg, String name, String spawnEgg, String say, String hurt, String death, String step, String attack) {
		this.mobReg = mobReg;
		this.name = name;
		this.spawnEgg = spawnEgg;
		this.say = say;
		this.hurt = hurt;
		this.death = death;
		this.step = step;
		this.attack = attack;
	}

	public static class Builder {
		private final MobReg<?> mobReg;
		private final String name;
		private String spawnEgg = "";
		private String say = " speaks";
		private String hurt = " hurts";
		private String death = " dies";
		private String step = " steps";
		private String attack = " attacks";

		public Builder(MobReg<?> reg, String name) {
			this.mobReg = reg;
			this.name = name;
		}

		public Builder withSpawnEgg(String spawnEgg) {
			this.spawnEgg = spawnEgg;
			return this;
		}

		public Builder withSay(String say) {
			this.say = " " + say;
			return this;
		}

		public Builder withHurt(String hurt) {
			this.hurt = " " + hurt;
			return this;
		}

		public Builder withDeath(String death) {
			this.death = " " + death;
			return this;
		}

		public Builder withStep(String step) {
			this.step = " " + step;
			return this;
		}

		public Builder withAttack(String attack) {
			this.attack = " " + attack;
			return this;
		}

		public MobLangHelper build() {
			return new MobLangHelper(mobReg, name, spawnEgg, say, hurt, death, step, attack);
		}
	}
}
