package gaia.datagen.client;

import gaia.GrimoireOfGaia;
import gaia.entity.type.IAssistMob;
import gaia.entity.type.IPassiveMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.registry.helper.MobReg;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class GaiaSoundProvider extends SoundDefinitionsProvider {

	public GaiaSoundProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, GrimoireOfGaia.MOD_ID, helper);
	}

	@Override
	public void registerSounds() {
		this.add(GaiaSounds.BAG_OPEN, definition()
				.subtitle(modSubtitle(GaiaSounds.BAG_OPEN.getId()))
				.with(sound(modLoc("item/bag_open"))));

		this.add(GaiaSounds.BOOK_HIT, definition()
				.subtitle(modSubtitle(GaiaSounds.BOOK_HIT.getId()))
				.with(sound(modLoc("item/book_hit1")),
						sound(modLoc("item/book_hit2")),
						sound(modLoc("item/book_hit3")),
						sound(modLoc("item/book_hit4"))
				));

		this.add(GaiaSounds.METAL_BOOK_HIT, definition()
				.subtitle(modSubtitle(GaiaSounds.BOOK_HIT.getId()))
				.with(
						sound(new ResourceLocation("step/stone1")),
						sound(new ResourceLocation("step/stone2")),
						sound(new ResourceLocation("step/stone3")),
						sound(new ResourceLocation("step/stone4")),
						sound(new ResourceLocation("step/stone5")),
						sound(new ResourceLocation("step/stone6"))
				));

		this.add(GaiaSounds.BOX_OPEN, definition()
				.subtitle(modSubtitle(GaiaSounds.BOX_OPEN.getId()))
				.with(sound(modLoc("item/box_open1")),
						sound(modLoc("item/box_open2"))
				));

		this.add(GaiaRegistry.CREEP.getSay(), definition()
				.subtitle(modSubtitle(GaiaRegistry.CREEP.getSay().getLocation()))
				.with(sound(modLoc("none"))));
		this.add(GaiaRegistry.CREEP.getHurt(), definition()
				.subtitle(modSubtitle(GaiaRegistry.CREEP.getHurt().getLocation()))
				.with(
						sound(new ResourceLocation("mob/creeper/say1")),
						sound(new ResourceLocation("mob/creeper/say2")),
						sound(new ResourceLocation("mob/creeper/say3")),
						sound(new ResourceLocation("mob/creeper/say4"))
				));
		this.add(GaiaRegistry.CREEP.getDeath(), definition()
				.subtitle(modSubtitle(GaiaRegistry.CREEP.getDeath().getLocation()))
				.with(sound(new ResourceLocation("mob/creeper/death"))));
		this.add(GaiaSounds.CREEP_PRIMED, definition()
				.subtitle(modSubtitle(GaiaSounds.CREEP_PRIMED.getId()))
				.with(sound(new ResourceLocation("random/fuse"))));
		this.add(GaiaSounds.GOBLIN_FERAL_PRIMED, definition()
				.subtitle(modSubtitle(GaiaSounds.GOBLIN_FERAL_PRIMED.getId()))
				.with(sound(new ResourceLocation("random/fuse"))));
		this.add(GaiaSounds.GAIA_SHOOT, definition()
				.subtitle(modSubtitle(GaiaSounds.GAIA_SHOOT.getId()))
				.with(sound(new ResourceLocation("mob/ghast/fireball4"))));
		this.add(GaiaSounds.BOMB_THROW, definition()
				.subtitle(modSubtitle(GaiaSounds.BOMB_THROW.getId()))
				.with(sound(new ResourceLocation("mob/ghast/fireball4"))));
		this.add(GaiaSounds.ANT_HILL_DEATH, definition()
				.subtitle(modSubtitle(GaiaSounds.ANT_HILL_DEATH.getId()))
				.with(sound(modLoc("none"))));

		this.generateMobSound();

		this.add(GaiaRegistry.HORSE.getSay(), definition()
				.subtitle(modSubtitle(GaiaRegistry.HORSE.getSay().getLocation()))
				.with(
						sound(new ResourceLocation("mob/horse/zombie/idle1")),
						sound(new ResourceLocation("mob/horse/zombie/idle2")),
						sound(new ResourceLocation("mob/horse/zombie/idle3"))
				));
		this.add(GaiaRegistry.HORSE.getHurt(), definition()
				.subtitle(modSubtitle(GaiaRegistry.HORSE.getHurt().getLocation()))
				.with(
						sound(new ResourceLocation("mob/horse/zombie/hit1")),
						sound(new ResourceLocation("mob/horse/zombie/hit2")),
						sound(new ResourceLocation("mob/horse/zombie/hit3")),
						sound(new ResourceLocation("mob/horse/zombie/hit4"))
				));
		this.add(GaiaRegistry.HORSE.getDeath(), definition()
				.subtitle(modSubtitle(GaiaRegistry.HORSE.getDeath().getLocation()))
				.with(sound(new ResourceLocation("mob/horse/zombie/death"))));

		this.add(GaiaRegistry.BONE_KNIGHT.getSay(), definition()
				.subtitle(modSubtitle(GaiaRegistry.BONE_KNIGHT.getSay().getLocation()))
				.with(
						sound(new ResourceLocation("mob/skeleton/say1")),
						sound(new ResourceLocation("mob/skeleton/say2")),
						sound(new ResourceLocation("mob/skeleton/say3"))
				));
		this.add(GaiaRegistry.BONE_KNIGHT.getHurt(), definition()
				.subtitle(modSubtitle(GaiaRegistry.BONE_KNIGHT.getHurt().getLocation()))
				.with(
						sound(new ResourceLocation("mob/skeleton/hurt1")),
						sound(new ResourceLocation("mob/skeleton/hurt2")),
						sound(new ResourceLocation("mob/skeleton/hurt3")),
						sound(new ResourceLocation("mob/skeleton/hurt4"))
				));
		this.add(GaiaRegistry.BONE_KNIGHT.getDeath(), definition()
				.subtitle(modSubtitle(GaiaRegistry.BONE_KNIGHT.getDeath().getLocation()))
				.with(
						sound(new ResourceLocation("mob/skeleton/death"))
				));
		this.add(GaiaRegistry.BONE_KNIGHT.getStep(), definition()
				.subtitle(modSubtitle(GaiaRegistry.BONE_KNIGHT.getStep().getLocation()))
				.with(
						sound(new ResourceLocation("mob/skeleton/step1")),
						sound(new ResourceLocation("mob/skeleton/step2")),
						sound(new ResourceLocation("mob/skeleton/step3")),
						sound(new ResourceLocation("mob/skeleton/step4"))
				));

		this.add(GaiaRegistry.FLESH_LICH.getSay(), definition()
				.subtitle(modSubtitle(GaiaRegistry.FLESH_LICH.getSay().getLocation()))
				.with(
						sound(new ResourceLocation("mob/zombie/say1")),
						sound(new ResourceLocation("mob/zombie/say2")),
						sound(new ResourceLocation("mob/zombie/say3"))
				));
		this.add(GaiaRegistry.FLESH_LICH.getHurt(), definition()
				.subtitle(modSubtitle(GaiaRegistry.FLESH_LICH.getHurt().getLocation()))
				.with(
						sound(new ResourceLocation("mob/zombie/hurt1")),
						sound(new ResourceLocation("mob/zombie/hurt2"))
				));
		this.add(GaiaRegistry.FLESH_LICH.getDeath(), definition()
				.subtitle(modSubtitle(GaiaRegistry.FLESH_LICH.getDeath().getLocation()))
				.with(
						sound(new ResourceLocation("mob/zombie/death"))
				));
		this.add(GaiaRegistry.FLESH_LICH.getStep(), definition()
				.subtitle(modSubtitle(GaiaRegistry.FLESH_LICH.getStep().getLocation()))
				.with(
						sound(new ResourceLocation("mob/zombie/step1")),
						sound(new ResourceLocation("mob/zombie/step2")),
						sound(new ResourceLocation("mob/zombie/step3")),
						sound(new ResourceLocation("mob/zombie/step4")),
						sound(new ResourceLocation("mob/zombie/step5"))
				));

		this.add(GaiaRegistry.COBBLE_GOLEM.getStep(), definition()
				.subtitle(modSubtitle(GaiaRegistry.COBBLE_GOLEM.getStep().getLocation()))
				.with(
						sound(new ResourceLocation("mob/irongolem/walk1")),
						sound(new ResourceLocation("mob/irongolem/walk2")),
						sound(new ResourceLocation("mob/irongolem/walk3")),
						sound(new ResourceLocation("mob/irongolem/walk4"))
				));
		this.add(GaiaRegistry.COBBLE_GOLEM.getAttack(), definition()
				.subtitle(modSubtitle(GaiaRegistry.COBBLE_GOLEM.getAttack().getLocation()))
				.with(
						sound(new ResourceLocation("mob/irongolem/throw"))
				));

		this.add(GaiaRegistry.COBBLESTONE_GOLEM.getStep(), definition()
				.subtitle(modSubtitle(GaiaRegistry.COBBLESTONE_GOLEM.getStep().getLocation()))
				.with(
						sound(new ResourceLocation("mob/irongolem/walk1")),
						sound(new ResourceLocation("mob/irongolem/walk2")),
						sound(new ResourceLocation("mob/irongolem/walk3")),
						sound(new ResourceLocation("mob/irongolem/walk4"))
				));
		this.add(GaiaRegistry.COBBLESTONE_GOLEM.getAttack(), definition()
				.subtitle(modSubtitle(GaiaRegistry.COBBLESTONE_GOLEM.getAttack().getLocation()))
				.with(
						sound(new ResourceLocation("mob/irongolem/throw"))
				));
	}

	public void generateMobSound() {
		this.setupMobSounds(GaiaRegistry.ANT_WORKER);
		this.setupMobSounds(GaiaRegistry.ANT_SALVAGER);
		this.setupMobSounds(GaiaRegistry.ANUBIS);
		this.setupMobSounds(GaiaRegistry.ARACHNE);
		this.setupMobSounds(GaiaRegistry.BANSHEE);
		this.setupMobSounds(GaiaRegistry.BEE);
		this.setupMobSounds(GaiaRegistry.CENTAUR);
		this.setupMobSounds(GaiaRegistry.CYCLOPS);
		this.setupMobSounds(GaiaRegistry.DRYAD);
		this.setupMobSounds(GaiaRegistry.DULLAHAN);
		this.setupMobSounds(GaiaRegistry.GOBLIN);
		this.setupMobSounds(GaiaRegistry.GOBLIN_FERAL);
		this.setupMobSounds(GaiaRegistry.HARPY);
		this.setupMobSounds(GaiaRegistry.HUNTER);
		this.setupMobSounds(GaiaRegistry.KOBOLD);
		this.setupMobSounds(GaiaRegistry.MATANGO);
		this.setupMobSounds(GaiaRegistry.MINOTAURUS);
		this.setupMobSounds(GaiaRegistry.NINE_TAILS);
		this.setupMobSounds(GaiaRegistry.ONI);
		this.setupMobSounds(GaiaRegistry.ORC);
		this.setupMobSounds(GaiaRegistry.SATYRESS);
		this.setupMobSounds(GaiaRegistry.SHAMAN);
		this.setupMobSounds(GaiaRegistry.SIREN);
		this.setupMobSounds(GaiaRegistry.SLUDGE_GIRL);
		this.setupMobSounds(GaiaRegistry.SPORELING);
		this.setupMobSounds(GaiaRegistry.SPRIGGAN);
		this.setupMobSounds(GaiaRegistry.SUCCUBUS);
		this.setupMobSounds(GaiaRegistry.WERECAT);
		this.setupMobSounds(GaiaRegistry.WITCH);
		this.setupMobSounds(GaiaRegistry.WIZARD_HARPY);
		this.setupMobSounds(GaiaRegistry.YUKI_ONNA);
	}

	public void setupMobSounds(MobReg<?> mobReg) {
		boolean generateOptional = false;
		if (generateOptional) { //Only true if the sound pack needs updating
			this.setupOptionalMobSounds(mobReg);
		} else {
			if (mobReg.getSay() != null)
				this.add(mobReg.getSay(), definition()
						.subtitle(modSubtitle(mobReg.getSay().getLocation()))
						.with(sound(modLoc("none"))));
			if (mobReg.getHurt() != null)
				this.add(mobReg.getHurt(), definition()
						.subtitle(modSubtitle(mobReg.getHurt().getLocation()))
						.with(sound(modLoc("none"))));
			if (mobReg.getDeath() != null)
				this.add(mobReg.getDeath(), definition()
						.subtitle(modSubtitle(mobReg.getDeath().getLocation()))
						.with(sound(modLoc("none"))));

			if (mobReg.hasGender()) {
				if (mobReg.getMaleSay() != null)
					this.add(mobReg.getMaleSay(), definition()
							.subtitle(modSubtitle(mobReg.getMaleSay().getLocation()))
							.with(sound(modLoc("none"))));
				if (mobReg.getMaleHurt() != null)
					this.add(mobReg.getMaleHurt(), definition()
							.subtitle(modSubtitle(mobReg.getMaleHurt().getLocation()))
							.with(sound(modLoc("none"))));
				if (mobReg.getMaleDeath() != null)
					this.add(mobReg.getMaleDeath(), definition()
							.subtitle(modSubtitle(mobReg.getMaleDeath().getLocation()))
							.with(sound(modLoc("none"))));
			}
		}
	}

	public void setupOptionalMobSounds(MobReg<?> mobReg) {
		EntityType<?> type = mobReg.getEntityType();
		String base = "anime/aggressive_";
		if (type.getBaseClass().isInstance(IAssistMob.class)) {
			base = "anime/assist_";
		} else if (type.getBaseClass().isInstance(IPassiveMob.class)) {
			base = "anime/passive_";
		}

		if (mobReg.getSay() != null)
			this.add(mobReg.getSay(), definition()
					.subtitle(modSubtitle(mobReg.getSay().getLocation()))
					.with(sound(modLoc("none"))));
		if (mobReg.getHurt() != null)
			this.add(mobReg.getHurt(), definition()
					.subtitle(modSubtitle(mobReg.getHurt().getLocation()))
					.with(sound(modLoc(base + "hurt1")),
							sound(modLoc(base + "hurt2")),
							sound(modLoc(base + "hurt3"))));
		if (mobReg.getDeath() != null)
			this.add(mobReg.getDeath(), definition()
					.subtitle(modSubtitle(mobReg.getDeath().getLocation()))
					.with(sound(modLoc(base + "death"))));

		if (mobReg.hasGender()) {
			if (mobReg.getMaleSay() != null)
				this.add(mobReg.getMaleSay(), definition()
						.subtitle(modSubtitle(mobReg.getMaleSay().getLocation()))
						.with(sound(modLoc("none"))));
			if (mobReg.getMaleHurt() != null)
				this.add(mobReg.getMaleHurt(), definition()
						.subtitle(modSubtitle(mobReg.getMaleHurt().getLocation()))
						.with(sound(modLoc(base + "hurt1")),
								sound(modLoc(base + "hurt2")),
								sound(modLoc(base + "hurt3"))));
			if (mobReg.getMaleDeath() != null)
				this.add(mobReg.getMaleDeath(), definition()
						.subtitle(modSubtitle(mobReg.getMaleDeath().getLocation()))
						.with(sound(modLoc(base + "death"))));
		}
	}

	public String modSubtitle(ResourceLocation id) {
		return GrimoireOfGaia.MOD_ID + ".subtitle." + id.getPath();
	}

	public ResourceLocation modLoc(String name) {
		return new ResourceLocation(GrimoireOfGaia.MOD_ID, name);
	}
}
