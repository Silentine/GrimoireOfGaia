package gaia.init;

import com.google.common.collect.ImmutableSet;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaMummy;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyress;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaSummonButler;
import gaia.entity.monster.EntityGaiaSummonSporeling;
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Set;

public class GaiaEntities {
	private GaiaEntities() {}

	public static final Set<EntityEntry> SPAWN_EGG_ENTITIES = ImmutableSet.of(
			createEntityEntry("Ant", EntityGaiaAnt.class, 0x303030, 0x8a7264),
			createEntityEntry("Anubis", EntityGaiaAnubis.class, 0x353535, 0xb19534),
			createEntityEntry("Arachne", EntityGaiaArachne.class, 3815994, 11013646),
			createEntityEntry("Banshee", EntityGaiaBanshee.class, 0xeed2e8, 0xc6b0ed),
			createEntityEntry("Baphomet", EntityGaiaBaphomet.class, 3559756, 14197864),
			createEntityEntry("BoneKnight", EntityGaiaBoneKnight.class, 4602533, 13619151),
			createEntityEntry("Centaur", EntityGaiaCentaur.class, 0x8d4f41, 0x353535),
			createEntityEntry("Chest", EntityGaiaPropChestMimic.class, 11237677, 4274991),
			createEntityEntry("CobbleGolem", EntityGaiaCobbleGolem.class, 11513775, 11513775),
			createEntityEntry("CobblestoneGolem", EntityGaiaCobblestoneGolem.class, 11513775, 11513775),
			createEntityEntry("Creep", EntityGaiaCreep.class, 7917159, 2053400),
			createEntityEntry("Cyclops", EntityGaiaCyclops.class, 4936602, 3487029),
			createEntityEntry("CyanFlower", EntityGaiaPropFlowerCyan.class, 1073920, 4045287),
			createEntityEntry("Dhampir", EntityGaiaDhampir.class, 0x9c1c2b, 0xc9b161),
			createEntityEntry("Dryad", EntityGaiaDryad.class, 10255437, 5681460),
			createEntityEntry("Dullahan", EntityGaiaDullahan.class, 0x824fab, 0xa4452d),
			createEntityEntry("Dwarf", EntityGaiaDwarf.class, 0x969696, 0xf09942),
			createEntityEntry("EnderDragonGirl", EntityGaiaEnderDragonGirl.class, 3158064, 14711290),
			createEntityEntry("EnderEye", EntityGaiaEnderEye.class, 2039583, 3158064),
			createEntityEntry("FleshLich", EntityGaiaFleshLich.class, 0x00cccc, 0x799c65),
			createEntityEntry("FutakuchiOnna", EntityGaiaFutakuchiOnna.class, 0x4e3738, 0xb43434),
			createEntityEntry("Gryphon", EntityGaiaGryphon.class, 0xf09942, 0xe2e2e2),
			createEntityEntry("Harpy", EntityGaiaHarpy.class, 0xc9b161, 0xa5884e),
			createEntityEntry("Hunter", EntityGaiaHunter.class, 0xae6b3c, 0x353535),
			createEntityEntry("Kobold", EntityGaiaKobold.class, 0x938dab, 0xafa7c1),
			createEntityEntry("Matango", EntityGaiaMatango.class, 0xab1311, 0xd8d8d8),
			createEntityEntry("Mermaid", EntityGaiaMermaid.class, 0x5c70b1, 0xa4452d),
			createEntityEntry("Minotaur", EntityGaiaMinotaur.class, 0x8d4f41, 0xd54242),
			createEntityEntry("Minotaurus", EntityGaiaMinotaurus.class, 0x8d4f41, 0xa9a9a9),
			createEntityEntry("Mummy", EntityGaiaMummy.class, 0xdcd7c1, 0xc9b161),
			createEntityEntry("Naga", EntityGaiaNaga.class, 0x29bc55, 0xccb63f),
			createEntityEntry("NineTails", EntityGaiaNineTails.class, 11809844, 13218145),
			createEntityEntry("Sahuagin", EntityGaiaSahuagin.class, 0x5c70b1, 0x84a498),
			createEntityEntry("Satyress", EntityGaiaSatyress.class, 0x707b4f, 0xa4452d),
			createEntityEntry("Selkie", EntityGaiaSelkie.class, 9082818, 13488612),
			createEntityEntry("Shaman", EntityGaiaShaman.class, 0xae6b3c, 0x56b134),
			createEntityEntry("Sharko", EntityGaiaSharko.class, 0x84a498, 0x5c70b1),
			createEntityEntry("Siren", EntityGaiaSiren.class, 0x29bc55, 0x48a0de),
			createEntityEntry("SludgeGirl", EntityGaiaSludgeGirl.class, 6595667, 7715172),
			createEntityEntry("Sphinx", EntityGaiaSphinx.class, 0xf09942, 0x353535),
			createEntityEntry("Spriggan", EntityGaiaSpriggan.class, 0x7c623e, 0xc2dda5),
			createEntityEntry("Succubus", EntityGaiaSuccubus.class, 4079166, 13218145),
			createEntityEntry("Toad", EntityGaiaToad.class, 0x355d2b, 0x779f5a),
			createEntityEntry("Valkyrie", EntityGaiaValkyrie.class, 0xc9b161, 0xd54242),
			createEntityEntry("Vampire", EntityGaiaVampire.class, 0xc23021, 0xc9b161),
			createEntityEntry("Werecat", EntityGaiaWerecat.class, 0x7a7e8a, 0xdddadb),
			createEntityEntry("Witch", EntityGaiaWitch.class, 0x303030, 0x943dbb),
			createEntityEntry("WitherCow", EntityGaiaWitherCow.class, 5791069, 16777215),
			createEntityEntry("Yeti", EntityGaiaYeti.class, 16448250, 7895160),
			createEntityEntry("Yuki-Onna", EntityGaiaYukiOnna.class, 6781114, 13817330)
	);

	private static EntityEntry createEntityEntry(String name, Class<? extends Entity> cls, int primaryColorIn, int secondaryColorIn) {
		EntityEntry entityEntry = new EntityEntry(cls, name);
		entityEntry.setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, name));
		entityEntry.setEgg(new EntityEggInfo(new ResourceLocation(GaiaReference.MOD_PREFIX + name.toLowerCase()), primaryColorIn, secondaryColorIn));
		return entityEntry;
	}

	@SuppressWarnings({"unused", "squid:S1118"}) //used in registration reflection
	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
			Gaia.LOGGER.info("Registering entities...");
			IForgeRegistry<EntityEntry> registry = event.getRegistry();

			initNoSpawnEggEntities(registry);

			for (EntityEntry entry : SPAWN_EGG_ENTITIES) {
				registry.register(entry);
			}

			Gaia.LOGGER.info("Entity registration complete.");
		}

		private static void initNoSpawnEggEntities(IForgeRegistry<EntityEntry> registry) {
			// NPC
			createEntityEntry("CreeperGirl", EntityGaiaNPCCreeperGirl.class, registry);
			createEntityEntry("SlimeGirl", EntityGaiaNPCSlimeGirl.class, registry);
			createEntityEntry("EnderGirl", EntityGaiaNPCEnderGirl.class, registry);
			createEntityEntry("Trader", EntityGaiaNPCTrader.class, registry);
			createEntityEntry("Holstaurus", EntityGaiaNPCHolstaurus.class, registry);
			createEntityEntry("Weresheep", EntityGaiaNPCWeresheep.class, registry);

			// Spawn
			createEntityEntry("Mandragora", EntityGaiaMandragora.class, registry);
			createEntityEntry("Mimic", EntityGaiaMimic.class, registry);
			createEntityEntry("Butler", EntityGaiaSummonButler.class, registry);
			createEntityEntry("Sporeling", EntityGaiaSummonSporeling.class, registry);

			// Projectiles
			createEntityEntry("SmallFireball", EntityGaiaProjectileSmallFireball.class, registry);
			createEntityEntry("Magic", EntityGaiaProjectileMagic.class, registry);
		}

		private static void createEntityEntry(String name, Class<? extends Entity> cls, IForgeRegistry<EntityEntry> registry) {
			EntityEntry entityEntry = new EntityEntry(cls, name);
			entityEntry.setRegistryName(new ResourceLocation(GaiaReference.MOD_PREFIX + name.toLowerCase()));
			registry.register(entityEntry);
		}
	}
}
