package gaia.registry;

import gaia.GrimoireOfGaia;
import gaia.config.GaiaSpawningConfig;
import gaia.config.SpawningInfo;
import gaia.entity.Anubis;
import gaia.entity.Centaur;
import gaia.entity.Creep;
import gaia.entity.Cyclops;
import gaia.entity.Dryad;
import gaia.entity.Dullahan;
import gaia.entity.GaiaHorse;
import gaia.entity.Harpy;
import gaia.entity.Hunter;
import gaia.entity.Kobold;
import gaia.entity.Matango;
import gaia.entity.NineTails;
import gaia.entity.Shaman;
import gaia.entity.Siren;
import gaia.entity.SludgeGirl;
import gaia.entity.Sporeling;
import gaia.entity.Succubus;
import gaia.entity.Werecat;
import gaia.entity.YukiOnna;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GrimoireOfGaia.MOD_ID)
public class GaiaSpawning {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void addSpawn(BiomeLoadingEvent event) {
		addSpawn(GaiaRegistry.ANUBIS.getEntityType(), GaiaSpawningConfig.COMMON.anubisSpawning, event);
		addSpawn(GaiaRegistry.CENTAUR.getEntityType(), GaiaSpawningConfig.COMMON.centaurSpawning, event);
		addSpawn(GaiaRegistry.CREEP.getEntityType(), GaiaSpawningConfig.COMMON.creepSpawning, event);
		addSpawn(GaiaRegistry.CYCLOPS.getEntityType(), GaiaSpawningConfig.COMMON.cyclopsSpawning, event);
		addSpawn(GaiaRegistry.DRYAD.getEntityType(), GaiaSpawningConfig.COMMON.dryadSpawning, event);
		addSpawn(GaiaRegistry.DULLAHAN.getEntityType(), GaiaSpawningConfig.COMMON.dullahanSpawning, event);
		addSpawn(GaiaRegistry.HARPY.getEntityType(), GaiaSpawningConfig.COMMON.harpySpawning, event);
		addSpawn(GaiaRegistry.HUNTER.getEntityType(), GaiaSpawningConfig.COMMON.hunterSpawning, event);
		addSpawn(GaiaRegistry.KOBOLD.getEntityType(), GaiaSpawningConfig.COMMON.koboldSpawning, event);
		addSpawn(GaiaRegistry.MATANGO.getEntityType(), GaiaSpawningConfig.COMMON.matangoSpawning, event);
		addSpawn(GaiaRegistry.NINE_TAILS.getEntityType(), GaiaSpawningConfig.COMMON.nineTailsSpawning, event);
		addSpawn(GaiaRegistry.SHAMAN.getEntityType(), GaiaSpawningConfig.COMMON.shamanSpawning, event);
		addSpawn(GaiaRegistry.SIREN.getEntityType(), GaiaSpawningConfig.COMMON.sirenSpawning, event);
		addSpawn(GaiaRegistry.SLUDGE_GIRL.getEntityType(), GaiaSpawningConfig.COMMON.sludgeGirlSpawning, event);
		addSpawn(GaiaRegistry.SUCCUBUS.getEntityType(), GaiaSpawningConfig.COMMON.succubusSpawning, event);
		addSpawn(GaiaRegistry.WERECAT.getEntityType(), GaiaSpawningConfig.COMMON.werecatSpawning, event);
		addSpawn(GaiaRegistry.YUKI_ONNA.getEntityType(), GaiaSpawningConfig.COMMON.yukiOnnaSpawning, event);
	}

	private static void addSpawn(EntityType<?> entityType, SpawningInfo info, BiomeLoadingEvent event) {
		if (!info.isDisabled()) {
			if (info.invertList.get() ? !info.spawnBiomes.get().contains(event.getName().toString()) : info.spawnBiomes.get().contains(event.getName().toString())) {
				event.getSpawns().addSpawn(MobCategory.MONSTER,
						new SpawnerData(entityType, info.weight.get(), info.minGroup.get(), info.maxGroup.get()));
			}
		}
	}

	public static void entityAttributes() {
		SpawnPlacements.register(GaiaRegistry.ANUBIS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Anubis::checkAnubisSpawnRules);
		SpawnPlacements.register(GaiaRegistry.CENTAUR.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Centaur::checkCentaurSpawnRules);
		SpawnPlacements.register(GaiaRegistry.CREEP.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Creep::checkCreepSpawnRules);
		SpawnPlacements.register(GaiaRegistry.CYCLOPS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cyclops::checkCyclopsSpawnRules);
		SpawnPlacements.register(GaiaRegistry.DRYAD.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dryad::checkDryadSpawnRules);
		SpawnPlacements.register(GaiaRegistry.DULLAHAN.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dullahan::checkDullahanSpawnRules);
		SpawnPlacements.register(GaiaRegistry.HARPY.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Harpy::checkHarpySpawnRules);
		SpawnPlacements.register(GaiaRegistry.HUNTER.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Hunter::checkHunterSpawnRules);
		SpawnPlacements.register(GaiaRegistry.KOBOLD.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Kobold::checkKoboldSpawnRules);
		SpawnPlacements.register(GaiaRegistry.MATANGO.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Matango::checkMatangoSpawnRules);
		SpawnPlacements.register(GaiaRegistry.NINE_TAILS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NineTails::checkNineTailsSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SHAMAN.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Shaman::checkShamanSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SIREN.getEntityType(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Siren::checkSirenSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SLUDGE_GIRL.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SludgeGirl::checkSludgeGirlSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SPORELING.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Sporeling::checkSporelingSpawnRules);
		SpawnPlacements.register(GaiaRegistry.SUCCUBUS.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Succubus::checkSuccubusSpawnRules);
		SpawnPlacements.register(GaiaRegistry.WERECAT.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Werecat::checkWerecatSpawnRules);
		SpawnPlacements.register(GaiaRegistry.YUKI_ONNA.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, YukiOnna::checkYukiOnnaSpawnRules);

		SpawnPlacements.register(GaiaRegistry.HORSE.getEntityType(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
	}

	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(GaiaRegistry.ANUBIS.getEntityType(), Anubis.createAttributes().build());
		event.put(GaiaRegistry.CENTAUR.getEntityType(), Centaur.createAttributes().build());
		event.put(GaiaRegistry.CREEP.getEntityType(), Creep.createAttributes().build());
		event.put(GaiaRegistry.CYCLOPS.getEntityType(), Cyclops.createAttributes().build());
		event.put(GaiaRegistry.DRYAD.getEntityType(), Dryad.createAttributes().build());
		event.put(GaiaRegistry.DULLAHAN.getEntityType(), Dullahan.createAttributes().build());
		event.put(GaiaRegistry.HARPY.getEntityType(), Harpy.createAttributes().build());
		event.put(GaiaRegistry.HUNTER.getEntityType(), Hunter.createAttributes().build());
		event.put(GaiaRegistry.KOBOLD.getEntityType(), Kobold.createAttributes().build());
		event.put(GaiaRegistry.MATANGO.getEntityType(), Matango.createAttributes().build());
		event.put(GaiaRegistry.NINE_TAILS.getEntityType(), NineTails.createAttributes().build());
		event.put(GaiaRegistry.SHAMAN.getEntityType(), Shaman.createAttributes().build());
		event.put(GaiaRegistry.SIREN.getEntityType(), Siren.createAttributes().build());
		event.put(GaiaRegistry.SLUDGE_GIRL.getEntityType(), SludgeGirl.createAttributes().build());
		event.put(GaiaRegistry.SPORELING.getEntityType(), Sporeling.createAttributes().build());
		event.put(GaiaRegistry.SUCCUBUS.getEntityType(), Succubus.createAttributes().build());
		event.put(GaiaRegistry.WERECAT.getEntityType(), Werecat.createAttributes().build());
		event.put(GaiaRegistry.YUKI_ONNA.getEntityType(), YukiOnna.createAttributes().build());

		event.put(GaiaRegistry.HORSE.getEntityType(), GaiaHorse.createBaseHorseAttributes().build());
	}
}
