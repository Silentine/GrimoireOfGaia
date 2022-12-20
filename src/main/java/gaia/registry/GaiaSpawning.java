package gaia.registry;

import gaia.GrimoireOfGaia;
import gaia.config.GaiaSpawningConfig;
import gaia.config.SpawningInfo;
import gaia.entity.AntSalvager;
import gaia.entity.AntWorker;
import gaia.entity.Anubis;
import gaia.entity.Arachne;
import gaia.entity.Banshee;
import gaia.entity.Bee;
import gaia.entity.Behender;
import gaia.entity.BoneKnight;
import gaia.entity.Centaur;
import gaia.entity.CobbleGolem;
import gaia.entity.CobblestoneGolem;
import gaia.entity.Creep;
import gaia.entity.Cyclops;
import gaia.entity.Deathword;
import gaia.entity.Dryad;
import gaia.entity.Dullahan;
import gaia.entity.EnderDragonGirl;
import gaia.entity.EnderEye;
import gaia.entity.FleshLich;
import gaia.entity.GaiaHorse;
import gaia.entity.GelatinousSlime;
import gaia.entity.Goblin;
import gaia.entity.GoblinFeral;
import gaia.entity.Harpy;
import gaia.entity.Hunter;
import gaia.entity.Kobold;
import gaia.entity.Matango;
import gaia.entity.Mermaid;
import gaia.entity.Mimic;
import gaia.entity.Minotaurus;
import gaia.entity.Naga;
import gaia.entity.NineTails;
import gaia.entity.Oni;
import gaia.entity.Orc;
import gaia.entity.Satyress;
import gaia.entity.Shaman;
import gaia.entity.Siren;
import gaia.entity.SludgeGirl;
import gaia.entity.Sphinx;
import gaia.entity.Sporeling;
import gaia.entity.Spriggan;
import gaia.entity.Succubus;
import gaia.entity.Werecat;
import gaia.entity.Witch;
import gaia.entity.WitherCow;
import gaia.entity.WizardHarpy;
import gaia.entity.YukiOnna;
import gaia.entity.prop.AntHill;
import gaia.entity.prop.Chest;
import gaia.util.BiomeHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = GrimoireOfGaia.MOD_ID)
public class GaiaSpawning {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void addSpawn(BiomeLoadingEvent event) {
		addSpawn(GaiaRegistry.ANT_HILL.getEntityType(), GaiaSpawningConfig.COMMON.antHillSpawning, event);
		addSpawn(GaiaRegistry.ANT_SALVAGER.getEntityType(), GaiaSpawningConfig.COMMON.antSalvagerSpawning, event);
		addSpawn(GaiaRegistry.ANUBIS.getEntityType(), GaiaSpawningConfig.COMMON.anubisSpawning, event);
		addSpawn(GaiaRegistry.ARACHNE.getEntityType(), GaiaSpawningConfig.COMMON.arachneSpawning, event);
		addSpawn(GaiaRegistry.BANSHEE.getEntityType(), GaiaSpawningConfig.COMMON.bansheeSpawning, event);
		addSpawn(GaiaRegistry.BEE.getEntityType(), GaiaSpawningConfig.COMMON.beeSpawning, event);
		addSpawn(GaiaRegistry.BEHENDER.getEntityType(), GaiaSpawningConfig.COMMON.behenderSpawning, event);
		addSpawn(GaiaRegistry.BONE_KNIGHT.getEntityType(), GaiaSpawningConfig.COMMON.boneKnightSpawning, event);
		addSpawn(GaiaRegistry.CENTAUR.getEntityType(), GaiaSpawningConfig.COMMON.centaurSpawning, event);
		addSpawn(GaiaRegistry.CHEST.getEntityType(), GaiaSpawningConfig.COMMON.mimicSpawning, event);
		addSpawn(GaiaRegistry.COBBLESTONE_GOLEM.getEntityType(), GaiaSpawningConfig.COMMON.cobblestoneGolemSpawning, event);
		addSpawn(GaiaRegistry.COBBLE_GOLEM.getEntityType(), GaiaSpawningConfig.COMMON.cobbleGolemSpawning, event);
		addSpawn(GaiaRegistry.CREEP.getEntityType(), GaiaSpawningConfig.COMMON.creepSpawning, event);
		addSpawn(GaiaRegistry.CYCLOPS.getEntityType(), GaiaSpawningConfig.COMMON.cyclopsSpawning, event);
		addSpawn(GaiaRegistry.DEATHWORD.getEntityType(), GaiaSpawningConfig.COMMON.deathwordSpawning, event);
		addSpawn(GaiaRegistry.DRYAD.getEntityType(), GaiaSpawningConfig.COMMON.dryadSpawning, event);
		addSpawn(GaiaRegistry.DULLAHAN.getEntityType(), GaiaSpawningConfig.COMMON.dullahanSpawning, event);
		addSpawn(GaiaRegistry.ENDER_DRAGON_GIRL.getEntityType(), GaiaSpawningConfig.COMMON.enderDragonGirlSpawning, event);
		addSpawn(GaiaRegistry.ENDER_EYE.getEntityType(), GaiaSpawningConfig.COMMON.enderEyeSpawning, event);
		addSpawn(GaiaRegistry.FLESH_LICH.getEntityType(), GaiaSpawningConfig.COMMON.fleshLichSpawning, event);
		addSpawn(GaiaRegistry.GELATINOUS_SLIME.getEntityType(), GaiaSpawningConfig.COMMON.gelatinousSlimeSpawning, event);
		addSpawn(GaiaRegistry.GOBLIN.getEntityType(), GaiaSpawningConfig.COMMON.goblinSpawning, event);
		addSpawn(GaiaRegistry.HARPY.getEntityType(), GaiaSpawningConfig.COMMON.harpySpawning, event);
		addSpawn(GaiaRegistry.HUNTER.getEntityType(), GaiaSpawningConfig.COMMON.hunterSpawning, event);
		addSpawn(GaiaRegistry.KOBOLD.getEntityType(), GaiaSpawningConfig.COMMON.koboldSpawning, event);
		addSpawn(GaiaRegistry.MATANGO.getEntityType(), GaiaSpawningConfig.COMMON.matangoSpawning, event);
		addSpawn(GaiaRegistry.MERMAID.getEntityType(), GaiaSpawningConfig.COMMON.mermaidSpawning, event);
		addSpawn(GaiaRegistry.MINOTAURUS.getEntityType(), GaiaSpawningConfig.COMMON.minotaurusSpawning, event);
		addSpawn(GaiaRegistry.NAGA.getEntityType(), GaiaSpawningConfig.COMMON.nagaSpawning, event);
		addSpawn(GaiaRegistry.NINE_TAILS.getEntityType(), GaiaSpawningConfig.COMMON.nineTailsSpawning, event);
		addSpawn(GaiaRegistry.ONI.getEntityType(), GaiaSpawningConfig.COMMON.oniSpawning, event);
		addSpawn(GaiaRegistry.ORC.getEntityType(), GaiaSpawningConfig.COMMON.orcSpawning, event);
		addSpawn(GaiaRegistry.SATYRESS.getEntityType(), GaiaSpawningConfig.COMMON.satyressSpawning, event);
		addSpawn(GaiaRegistry.SHAMAN.getEntityType(), GaiaSpawningConfig.COMMON.shamanSpawning, event);
		addSpawn(GaiaRegistry.SIREN.getEntityType(), GaiaSpawningConfig.COMMON.sirenSpawning, event);
		addSpawn(GaiaRegistry.SLUDGE_GIRL.getEntityType(), GaiaSpawningConfig.COMMON.sludgeGirlSpawning, event);
		addSpawn(GaiaRegistry.SPHINX.getEntityType(), GaiaSpawningConfig.COMMON.sphinxSpawning, event);
		addSpawn(GaiaRegistry.SPRIGGAN.getEntityType(), GaiaSpawningConfig.COMMON.sprigganSpawning, event);
		addSpawn(GaiaRegistry.SUCCUBUS.getEntityType(), GaiaSpawningConfig.COMMON.succubusSpawning, event);
		addSpawn(GaiaRegistry.WERECAT.getEntityType(), GaiaSpawningConfig.COMMON.werecatSpawning, event);
		addSpawn(GaiaRegistry.WITCH.getEntityType(), GaiaSpawningConfig.COMMON.witchSpawning, event);
		addSpawn(GaiaRegistry.WITHER_COW.getEntityType(), GaiaSpawningConfig.COMMON.witherCowSpawning, event);
		addSpawn(GaiaRegistry.WIZARD_HARPY.getEntityType(), GaiaSpawningConfig.COMMON.wizardHarpySpawning, event);
		addSpawn(GaiaRegistry.YUKI_ONNA.getEntityType(), GaiaSpawningConfig.COMMON.yukiOnnaSpawning, event);
	}

	private static void addSpawn(EntityType<?> entityType, SpawningInfo info, BiomeLoadingEvent event) {
		if (!info.isDisabled()) {
			ResourceKey<Biome> biomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
			if (!info.spawnBiomes.get().isEmpty()) {
				String biomeName = event.getName().toString();
				if (info.invertList.get() ? !info.spawnBiomes.get().contains(biomeName) : info.spawnBiomes.get().contains(biomeName)) {
					event.getSpawns().addSpawn(MobCategory.MONSTER, new SpawnerData(entityType, info.weight.get(), info.minGroup.get(), info.maxGroup.get()));
					if (info.logAdditions.get()) {
						GrimoireOfGaia.LOGGER.info("Added " + entityType.getRegistryName() + " to " + biomeKey.location());
					}
				}
			}

			if (!info.spawnBiomeDictionary.get().isEmpty()) {
				List<SpawnerData> spawnerDataList = event.getSpawns().getSpawner(MobCategory.MONSTER);
				if (!spawnerDataList.stream().anyMatch(data -> data.type == entityType)) {
					for (String biome : info.spawnBiomeDictionary.get()) {
						boolean validBiome = true;
						if (biome.contains(",")) {
							String[] tags = biome.split(",");
							if (!BiomeHelper.matchesDictionary(tags, biomeKey)) {
								validBiome = false;
							}
						} else {
							if (!BiomeHelper.matchesDictionary(biome, biomeKey)) {
								validBiome = false;
							}
						}

						if (validBiome) {
							event.getSpawns().addSpawn(MobCategory.MONSTER, new SpawnerData(entityType, info.weight.get(), info.minGroup.get(), info.maxGroup.get()));
							if (info.logAdditions.get()) {
								GrimoireOfGaia.LOGGER.info("Added " + entityType.getRegistryName() + " to " + biomeKey.location());
							}
						}
					}
				}
			}
		}
	}

	public static void entityAttributes() {
		SpawnPlacements.register(GaiaRegistry.ANT_HILL.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AntHill::checkAntHillSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ANT_WORKER.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AntWorker::checkAntWorkerSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ANT_SALVAGER.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AntSalvager::checkAntSalvagerSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ARACHNE.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Arachne::checkArachneSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ANUBIS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Anubis::checkAnubisSpawnRules);
		SpawnPlacements.register(GaiaRegistry.BANSHEE.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Banshee::checkBansheeSpawnRules);
		SpawnPlacements.register(GaiaRegistry.BEE.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Bee::checkBeeSpawnRules);
		SpawnPlacements.register(GaiaRegistry.BEHENDER.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Behender::checkBehenderSpawnRules);
		SpawnPlacements.register(GaiaRegistry.BONE_KNIGHT.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BoneKnight::checkBoneKnightSpawnRules);
		SpawnPlacements.register(GaiaRegistry.CENTAUR.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Centaur::checkCentaurSpawnRules);
		SpawnPlacements.register(GaiaRegistry.CHEST.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Chest::checkChestSpawnRules);
		SpawnPlacements.register(GaiaRegistry.COBBLE_GOLEM.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CobbleGolem::checkCobbleGolemSpawnRules);
		SpawnPlacements.register(GaiaRegistry.COBBLESTONE_GOLEM.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CobblestoneGolem::checkCobblestoneGolemSpawnRules);
		SpawnPlacements.register(GaiaRegistry.CREEP.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Creep::checkCreepSpawnRules);
		SpawnPlacements.register(GaiaRegistry.CYCLOPS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cyclops::checkCyclopsSpawnRules);
		SpawnPlacements.register(GaiaRegistry.DEATHWORD.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Deathword::checkDeathwordSpawnRules);
		SpawnPlacements.register(GaiaRegistry.DRYAD.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dryad::checkDryadSpawnRules);
		SpawnPlacements.register(GaiaRegistry.DULLAHAN.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dullahan::checkDullahanSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ENDER_EYE.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EnderEye::checkEnderEyeSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ENDER_DRAGON_GIRL.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EnderDragonGirl::checkEnderDragonGirlSpawnRules);
		SpawnPlacements.register(GaiaRegistry.FLESH_LICH.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FleshLich::checkFleshLichSpawnRules);
		SpawnPlacements.register(GaiaRegistry.GELATINOUS_SLIME.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GelatinousSlime::checkGelatinousSlimeSpawnRules);
		SpawnPlacements.register(GaiaRegistry.GOBLIN.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Goblin::checkGoblinSpawnRules);
		SpawnPlacements.register(GaiaRegistry.GOBLIN_FERAL.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GoblinFeral::checkGoblinFeralSpawnRules);
		SpawnPlacements.register(GaiaRegistry.HARPY.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Harpy::checkHarpySpawnRules);
		SpawnPlacements.register(GaiaRegistry.HUNTER.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Hunter::checkHunterSpawnRules);
		SpawnPlacements.register(GaiaRegistry.KOBOLD.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Kobold::checkKoboldSpawnRules);
		SpawnPlacements.register(GaiaRegistry.MATANGO.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Matango::checkMatangoSpawnRules);
		SpawnPlacements.register(GaiaRegistry.MERMAID.getEntityType(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mermaid::checkMermaidSpawnRules);
		SpawnPlacements.register(GaiaRegistry.MINOTAURUS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Minotaurus::checkMinotaurusSpawnRules);
		SpawnPlacements.register(GaiaRegistry.MIMIC.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mimic::checkMimicSpawnRules);
		SpawnPlacements.register(GaiaRegistry.NAGA.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Naga::checkNagaSpawnRules);
		SpawnPlacements.register(GaiaRegistry.NINE_TAILS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NineTails::checkNineTailsSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ONI.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Oni::checkOniSpawnRules);
		SpawnPlacements.register(GaiaRegistry.ORC.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Orc::checkOrcSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SATYRESS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Satyress::checkSatyressSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SHAMAN.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Shaman::checkShamanSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SIREN.getEntityType(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Siren::checkSirenSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SLUDGE_GIRL.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SludgeGirl::checkSludgeGirlSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SPHINX.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Sphinx::checkSphinxSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SPORELING.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Sporeling::checkSporelingSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SPRIGGAN.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Spriggan::checkSprigganSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SUCCUBUS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Succubus::checkSuccubusSpawnRules);
		SpawnPlacements.register(GaiaRegistry.WERECAT.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Werecat::checkWerecatSpawnRules);
		SpawnPlacements.register(GaiaRegistry.WITCH.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Witch::checkWitchSpawnRules);
		SpawnPlacements.register(GaiaRegistry.WITHER_COW.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WitherCow::checkWitherCowSpawnRules);
		SpawnPlacements.register(GaiaRegistry.WIZARD_HARPY.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WizardHarpy::checkWizardHarpySpawnRules);
		SpawnPlacements.register(GaiaRegistry.YUKI_ONNA.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, YukiOnna::checkYukiOnnaSpawnRules);

		SpawnPlacements.register(GaiaRegistry.HORSE.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
	}

	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(GaiaRegistry.ANT_HILL.getEntityType(), AntHill.createAttributes().build());
		event.put(GaiaRegistry.ANT_WORKER.getEntityType(), AntWorker.createAttributes().build());
		event.put(GaiaRegistry.ANT_SALVAGER.getEntityType(), AntSalvager.createAttributes().build());
		event.put(GaiaRegistry.ANUBIS.getEntityType(), Anubis.createAttributes().build());
		event.put(GaiaRegistry.ARACHNE.getEntityType(), Arachne.createAttributes().build());
		event.put(GaiaRegistry.BANSHEE.getEntityType(), Banshee.createAttributes().build());
		event.put(GaiaRegistry.BEE.getEntityType(), Bee.createAttributes().build());
		event.put(GaiaRegistry.BEHENDER.getEntityType(), Behender.createAttributes().build());
		event.put(GaiaRegistry.BONE_KNIGHT.getEntityType(), BoneKnight.createAttributes().build());
		event.put(GaiaRegistry.CENTAUR.getEntityType(), Centaur.createAttributes().build());
		event.put(GaiaRegistry.CHEST.getEntityType(), Chest.createAttributes().build());
		event.put(GaiaRegistry.COBBLE_GOLEM.getEntityType(), CobbleGolem.createAttributes().build());
		event.put(GaiaRegistry.COBBLESTONE_GOLEM.getEntityType(), CobblestoneGolem.createAttributes().build());
		event.put(GaiaRegistry.CREEP.getEntityType(), Creep.createAttributes().build());
		event.put(GaiaRegistry.CYCLOPS.getEntityType(), Cyclops.createAttributes().build());
		event.put(GaiaRegistry.DEATHWORD.getEntityType(), Deathword.createAttributes().build());
		event.put(GaiaRegistry.DRYAD.getEntityType(), Dryad.createAttributes().build());
		event.put(GaiaRegistry.DULLAHAN.getEntityType(), Dullahan.createAttributes().build());
		event.put(GaiaRegistry.ENDER_EYE.getEntityType(), EnderEye.createAttributes().build());
		event.put(GaiaRegistry.ENDER_DRAGON_GIRL.getEntityType(), EnderDragonGirl.createAttributes().build());
		event.put(GaiaRegistry.FLESH_LICH.getEntityType(), FleshLich.createAttributes().build());
		event.put(GaiaRegistry.GELATINOUS_SLIME.getEntityType(), GelatinousSlime.createAttributes().build());
		event.put(GaiaRegistry.GOBLIN.getEntityType(), Goblin.createAttributes().build());
		event.put(GaiaRegistry.GOBLIN_FERAL.getEntityType(), GoblinFeral.createAttributes().build());
		event.put(GaiaRegistry.HARPY.getEntityType(), Harpy.createAttributes().build());
		event.put(GaiaRegistry.HUNTER.getEntityType(), Hunter.createAttributes().build());
		event.put(GaiaRegistry.KOBOLD.getEntityType(), Kobold.createAttributes().build());
		event.put(GaiaRegistry.MATANGO.getEntityType(), Matango.createAttributes().build());
		event.put(GaiaRegistry.MERMAID.getEntityType(), Mermaid.createAttributes().build());
		event.put(GaiaRegistry.MINOTAURUS.getEntityType(), Minotaurus.createAttributes().build());
		event.put(GaiaRegistry.MIMIC.getEntityType(), Mimic.createAttributes().build());
		event.put(GaiaRegistry.NAGA.getEntityType(), Naga.createAttributes().build());
		event.put(GaiaRegistry.NINE_TAILS.getEntityType(), NineTails.createAttributes().build());
		event.put(GaiaRegistry.ONI.getEntityType(), Oni.createAttributes().build());
		event.put(GaiaRegistry.ORC.getEntityType(), Orc.createAttributes().build());
		event.put(GaiaRegistry.SATYRESS.getEntityType(), Satyress.createAttributes().build());
		event.put(GaiaRegistry.SHAMAN.getEntityType(), Shaman.createAttributes().build());
		event.put(GaiaRegistry.SIREN.getEntityType(), Siren.createAttributes().build());
		event.put(GaiaRegistry.SLUDGE_GIRL.getEntityType(), SludgeGirl.createAttributes().build());
		event.put(GaiaRegistry.SPHINX.getEntityType(), Sphinx.createAttributes().build());
		event.put(GaiaRegistry.SPORELING.getEntityType(), Sporeling.createAttributes().build());
		event.put(GaiaRegistry.SPRIGGAN.getEntityType(), Spriggan.createAttributes().build());
		event.put(GaiaRegistry.SUCCUBUS.getEntityType(), Succubus.createAttributes().build());
		event.put(GaiaRegistry.WERECAT.getEntityType(), Werecat.createAttributes().build());
		event.put(GaiaRegistry.WITCH.getEntityType(), Witch.createAttributes().build());
		event.put(GaiaRegistry.WITHER_COW.getEntityType(), WitherCow.createAttributes().build());
		event.put(GaiaRegistry.WIZARD_HARPY.getEntityType(), WizardHarpy.createAttributes().build());
		event.put(GaiaRegistry.YUKI_ONNA.getEntityType(), YukiOnna.createAttributes().build());

		event.put(GaiaRegistry.HORSE.getEntityType(), GaiaHorse.createBaseHorseAttributes().build());
	}
}
