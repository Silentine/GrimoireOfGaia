package gaia.init;

import gaia.GaiaReference;
import gaia.entity.assist.GaiaBeeEntity;
import gaia.entity.assist.GaiaCentaurEntity;
import gaia.entity.assist.GaiaCobbleGolemEntity;
import gaia.entity.assist.GaiaCyclopsEntity;
import gaia.entity.assist.GaiaDryadEntity;
import gaia.entity.assist.GaiaDwarfEntity;
import gaia.entity.assist.GaiaEnderDragonGirlEntity;
import gaia.entity.assist.GaiaEnderEyeEntity;
import gaia.entity.assist.GaiaGoblinEntity;
import gaia.entity.assist.GaiaGoblinFeralEntity;
import gaia.entity.assist.GaiaGryphonEntity;
import gaia.entity.assist.GaiaHunterEntity;
import gaia.entity.assist.GaiaKikimoraEntity;
import gaia.entity.hostile.GaiaAntEntity;
import gaia.entity.hostile.GaiaAntRangerEntity;
import gaia.entity.hostile.GaiaAnubisEntity;
import gaia.entity.hostile.GaiaArachneEntity;
import gaia.entity.hostile.GaiaBansheeEntity;
import gaia.entity.hostile.GaiaBaphometEntity;
import gaia.entity.hostile.GaiaBoneKnightEntity;
import gaia.entity.hostile.GaiaCecaeliaEntity;
import gaia.entity.hostile.GaiaCobblestoneGolemEntity;
import gaia.entity.hostile.GaiaCreepEntity;
import gaia.entity.hostile.GaiaDeathwordEntity;
import gaia.entity.hostile.GaiaDhampirEntity;
import gaia.entity.hostile.GaiaDullahanEntity;
import gaia.entity.hostile.GaiaFleshLichEntity;
import gaia.entity.hostile.GaiaGelatinousSlimeEntity;
import gaia.entity.hostile.GaiaHarpyEntity;
import gaia.entity.hostile.GaiaMandragoraEntity;
import gaia.entity.hostile.GaiaMimicEntity;
import gaia.entity.hostile.GaiaSphinxEntity;
import gaia.entity.projectile.GaiaProjectileBombEntity;
import gaia.entity.projectile.GaiaProjectileBubbleEntity;
import gaia.entity.projectile.GaiaProjectileMagicEntity;
import gaia.entity.projectile.GaiaProjectilePoisonEntity;
import gaia.entity.projectile.GaiaProjectileSmallFireballEntity;
import gaia.entity.projectile.GaiaProjectileWebEntity;
import gaia.entity.prop.GaiaPropCampfireEntity;
import gaia.entity.prop.GaiaPropChestMimicEntity;
import gaia.entity.prop.GaiaPropFlowerCyanEntity;
import gaia.entity.prop.GaiaPropVaseEntity;
import gaia.entity.prop.GaiaPropVaseNetherEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GaiaEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, GaiaReference.MOD_ID);

//	public static final RegistryObject<EntityType<EntityDebugMob>> DEBUG_MOB = ENTITIES.register("debug_mob", () -> register("debug_mob", EntityType.Builder.create(EntityDebugMob::new, EntityDebugMob::new));
	public static final RegistryObject<EntityType<GaiaAntEntity>> ANT = ENTITIES.register("ant", () -> register("ant", EntityType.Builder.<GaiaAntEntity>create(GaiaAntEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaAntRangerEntity>> ANT_RANGER = ENTITIES.register("ant_ranger", () -> register("ant_ranger", EntityType.Builder.<GaiaAntRangerEntity>create(GaiaAntRangerEntity::new, EntityClassification.MONSTER).size(0.5F, 0.5F)));
	public static final RegistryObject<EntityType<GaiaAnubisEntity>> ANUBIS = ENTITIES.register("anubis", () -> register("anubis", EntityType.Builder.create(GaiaAnubisEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaArachneEntity>> ARACHNE = ENTITIES.register("arachne", () -> register("arachne", EntityType.Builder.<GaiaArachneEntity>create(GaiaArachneEntity::new, EntityClassification.MONSTER).size(1.4F, 1.6F)));
	public static final RegistryObject<EntityType<GaiaBansheeEntity>> BANSHEE = ENTITIES.register("banshee", () -> register("banshee", EntityType.Builder.<GaiaBansheeEntity>create(GaiaBansheeEntity::new, EntityClassification.MONSTER).immuneToFire()));
	public static final RegistryObject<EntityType<GaiaBaphometEntity>> BAPHOMET = ENTITIES.register("baphomet", () -> register("baphomet", EntityType.Builder.<GaiaBaphometEntity>create(GaiaBaphometEntity::new, EntityClassification.MONSTER).immuneToFire()));
	public static final RegistryObject<EntityType<GaiaBeeEntity>> BEE = ENTITIES.register("bee", () -> register("bee", EntityType.Builder.<GaiaBeeEntity>create(GaiaBeeEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaBoneKnightEntity>> BONE_KNIGHT = ENTITIES.register("bone_knight", () -> register("bone_knight", EntityType.Builder.<GaiaBoneKnightEntity>create(GaiaBoneKnightEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaCecaeliaEntity>> CECEALIA = ENTITIES.register("cecaelia", () -> register("cecaelia", EntityType.Builder.<GaiaCecaeliaEntity>create(GaiaCecaeliaEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaCentaurEntity>> CENTAUR = ENTITIES.register("centaur", () -> register("centaur", EntityType.Builder.<GaiaCentaurEntity>create(GaiaCentaurEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaCobbleGolemEntity>> COBBLE_GOLEM = ENTITIES.register("cobble_golem", () -> register("cobble_golem", EntityType.Builder.<GaiaCobbleGolemEntity>create(GaiaCobbleGolemEntity::new, EntityClassification.MONSTER).immuneToFire()));
	public static final RegistryObject<EntityType<GaiaCobblestoneGolemEntity>> COBBLESTONE_GOLEM = ENTITIES.register("cobblestone_golem", () -> register("cobblestone_golem", EntityType.Builder.<GaiaCobblestoneGolemEntity>create(GaiaCobblestoneGolemEntity::new, EntityClassification.MONSTER).size(1.4F, 2.2F).immuneToFire()));
	public static final RegistryObject<EntityType<GaiaCreepEntity>> CREEP = ENTITIES.register("creep", () -> register("creep", EntityType.Builder.<GaiaCreepEntity>create(GaiaCreepEntity::new, EntityClassification.MONSTER).size(0.75F, 0.75F)));
	public static final RegistryObject<EntityType<GaiaCyclopsEntity>> CYCLOPS = ENTITIES.register("cyclops", () -> register("cyclops", EntityType.Builder.<GaiaCyclopsEntity>create(GaiaCyclopsEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaDeathwordEntity>> DEATHWORD = ENTITIES.register("deathword", () -> register("deathword", EntityType.Builder.<GaiaDeathwordEntity>create(GaiaDeathwordEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaDhampirEntity>> DHAMPIR = ENTITIES.register("dhampir", () -> register("dhampir", EntityType.Builder.<GaiaDhampirEntity>create(GaiaDhampirEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaDryadEntity>> DRYAD = ENTITIES.register("dryad", () -> register("dryad", EntityType.Builder.create(GaiaDryadEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaDullahanEntity>> DULLAHAN = ENTITIES.register("dullahan", () -> register("dullahan", EntityType.Builder.create(GaiaDullahanEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaDwarfEntity>> DWARF = ENTITIES.register("dwarf", () -> register("dwarf", EntityType.Builder.<GaiaDwarfEntity>create(GaiaDwarfEntity::new, EntityClassification.MONSTER).size(0.5F, 1.5F)));
	public static final RegistryObject<EntityType<GaiaEnderDragonGirlEntity>> ENDER_DRAGON_GIRL = ENTITIES.register("ender_dragon_girl", () -> register("ender_dragon_girl", EntityType.Builder.<GaiaEnderDragonGirlEntity>create(GaiaEnderDragonGirlEntity::new, EntityClassification.MONSTER).size(0.6F, 2.2F).immuneToFire()));
	public static final RegistryObject<EntityType<GaiaEnderEyeEntity>> ENDER_EYE = ENTITIES.register("ender_eye", () -> register("ender_eye", EntityType.Builder.<GaiaEnderEyeEntity>create(GaiaEnderEyeEntity::new, EntityClassification.MONSTER).size(1.0F, 2.4F).immuneToFire()));
	public static final RegistryObject<EntityType<GaiaFleshLichEntity>> FLESH_LICH = ENTITIES.register("flesh_lich", () -> register("flesh_lich", EntityType.Builder.<GaiaFleshLichEntity>create(GaiaFleshLichEntity::new, EntityClassification.MONSTER).immuneToFire()));
	public static final RegistryObject<EntityType<GaiaGelatinousSlimeEntity>> GELATINOUS_SLIME = ENTITIES.register("gelatinous_slime", () -> register("gelatinous_slime", EntityType.Builder.<GaiaGelatinousSlimeEntity>create(GaiaGelatinousSlimeEntity::new, EntityClassification.MONSTER).size(1.75F, 1.75F)));
	public static final RegistryObject<EntityType<GaiaGoblinEntity>> GOBLIN = ENTITIES.register("goblin", () -> register("goblin", EntityType.Builder.<GaiaGoblinEntity>create(GaiaGoblinEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaGoblinFeralEntity>> GOBLIN_FERAL = ENTITIES.register("goblin_feral", () -> register("goblin_feral", EntityType.Builder.<GaiaGoblinFeralEntity>create(GaiaGoblinFeralEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaGryphonEntity>> GRYPHON = ENTITIES.register("gryphon", () -> register("gryphon", EntityType.Builder.<GaiaGryphonEntity>create(GaiaGryphonEntity::new, EntityClassification.MONSTER).size(1.2F, 1.8F)));
	public static final RegistryObject<EntityType<GaiaHarpyEntity>> HARPY = ENTITIES.register("harpy", () -> register("harpy", EntityType.Builder.<GaiaHarpyEntity>create(GaiaHarpyEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaHunterEntity>> HUNTER = ENTITIES.register("hunter", () -> register("hunter", EntityType.Builder.<GaiaHunterEntity>create(GaiaHunterEntity::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaKikimoraEntity>> KIKIMORA = ENTITIES.register("kikimora", () -> register("kikimora", EntityType.Builder.create(GaiaKikimoraEntity::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaKobold>> KOBOLD = ENTITIES.register("kobold", () -> register("kobold", EntityType.Builder.create(EntityGaiaKobold::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaMatango>> MATANGO = ENTITIES.register("matango", () -> register("matango", EntityType.Builder.create(EntityGaiaMatango::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaMermaid>> MERMAID = ENTITIES.register("mermaid", () -> register("mermaid", EntityType.Builder.create(EntityGaiaMermaid::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaMinotaur>> MINOTAUR = ENTITIES.register("minotaur", () -> register("minotaur", EntityType.Builder.create(EntityGaiaMinotaur::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaMinotaurus>> MINOTAURUS = ENTITIES.register("minotaurus", () -> register("minotaurus", EntityType.Builder.create(EntityGaiaMinotaurus::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaMummy>> MUMMY = ENTITIES.register("mummy", () -> register("mummy", EntityType.Builder.create(EntityGaiaMummy::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaNaga>> NAGA = ENTITIES.register("naga", () -> register("naga", EntityType.Builder.create(EntityGaiaNaga::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaNineTails>> NINE_TAILS = ENTITIES.register("nine_tails", () -> register("nine_tails", EntityType.Builder.create(EntityGaiaNineTails::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaOni>> ONI = ENTITIES.register("oni", () -> register("oni", EntityType.Builder.create(EntityGaiaOni::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaOrc>> ORC = ENTITIES.register("orc", () -> register("orc", EntityType.Builder.create(EntityGaiaOrc::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaSatyress>> SATYRESS = ENTITIES.register("satyress", () -> register("satyress", EntityType.Builder.create(EntityGaiaSatyress::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaSelkie>> SELKIE = ENTITIES.register("selkie", () -> register("selkie", EntityType.Builder.create(EntityGaiaSelkie::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaShaman>> SHAMAN = ENTITIES.register("shaman", () -> register("shaman", EntityType.Builder.create(EntityGaiaShaman::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaSharko>> SHARKO = ENTITIES.register("sharko", () -> register("sharko", EntityType.Builder.create(EntityGaiaSharko::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaSiren>> SIREN = ENTITIES.register("siren", () -> register("siren", EntityType.Builder.create(EntityGaiaSiren::new, EntityClassification.MONSTER)));
//	public static final RegistryObject<EntityType<EntityGaiaSludgeGirl>> SLUDGE_GIRL = ENTITIES.register("sludge_girl", () -> register("sludge_girl", EntityType.Builder.create(EntityGaiaSludgeGirl::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<GaiaSphinxEntity>> SPHINX = ENTITIES.register("sphinx", () -> register("sphinx", EntityType.Builder.<GaiaSphinxEntity>create(GaiaSphinxEntity::new, EntityClassification.MONSTER).size(1.2F, 1.8F).immuneToFire()));
//	public static final RegistryObject<EntityType<EntityGaiaSpriggan>> SPRIGGAN = ENTITIES.register("spriggan", () -> register("spriggan", EntityType.Builder.create(EntityGaiaSpriggan::new, EntityGaiaSpriggan::new)));
//	public static final RegistryObject<EntityType<EntityGaiaSuccubus>> SUCCUBUS = ENTITIES.register("succubus", () -> register("succubus", EntityType.Builder.create(EntityGaiaSuccubus::new, EntityGaiaSuccubus::new)));
//	public static final RegistryObject<EntityType<EntityGaiaToad>> TOAD = ENTITIES.register("toad", () -> register("toad", EntityType.Builder.create(EntityGaiaToad::new, EntityGaiaToad::new)));
//	public static final RegistryObject<EntityType<EntityGaiaValkyrie>> VALKYRIE = ENTITIES.register("valkyrie", () -> register("valkyrie", EntityType.Builder.create(EntityGaiaValkyrie::new, EntityGaiaValkyrie::new)));
//	public static final RegistryObject<EntityType<EntityGaiaVampire>> VAMPIRE = ENTITIES.register("vampire", () -> register("vampire", EntityType.Builder.create(EntityGaiaVampire::new, EntityGaiaVampire::new)));
//	public static final RegistryObject<EntityType<EntityGaiaWerecat>> WERECAT = ENTITIES.register("werecat", () -> register("werecat", EntityType.Builder.create(EntityGaiaWerecat::new, EntityGaiaWerecat::new)));
//	public static final RegistryObject<EntityType<EntityGaiaWitch>> WITCH = ENTITIES.register("witch", () -> register("witch", EntityType.Builder.create(EntityGaiaWitch::new, EntityGaiaWitch::new)));
//	public static final RegistryObject<EntityType<EntityGaiaWitherCow>> WITHER_COW = ENTITIES.register("wither_cow", () -> register("wither_cow", EntityType.Builder.create(EntityGaiaWitherCow::new, EntityGaiaWitherCow::new)));
//	public static final RegistryObject<EntityType<EntityGaiaYeti>> YETI = ENTITIES.register("yeti", () -> register("yeti", EntityType.Builder.create(EntityGaiaYeti::new, EntityGaiaYeti::new)));
//	public static final RegistryObject<EntityType<EntityGaiaYukiOnna>> YUKI_ONNA = ENTITIES.register("yuki_onna", () -> register("yuki_onna", EntityType.Builder.create(EntityGaiaYukiOnna::new, EntityGaiaYukiOnna::new)));

	/**
	 * NPCS
	 */
//	public static final RegistryObject<EntityType<EntityGaiaNPCCreeperGirl>> CREEPER_GIRL_NPC = ENTITIES.register("creeper_girl", () -> register("creeper_girl", EntityType.Builder.create(EntityGaiaNPCCreeperGirl::new, EntityGaiaNPCCreeperGirl::new)));
//	public static final RegistryObject<EntityType<EntityGaiaNPCSlimeGirl>> SLUDGE_GIRL_NPC = ENTITIES.register("slime_girl", () -> register("slime_girl", EntityType.Builder.create(EntityGaiaNPCSlimeGirl::new, EntityGaiaNPCSlimeGirl::new)));
//	public static final RegistryObject<EntityType<EntityGaiaNPCEnderGirl>> ENDER_GIRL_NPC = ENTITIES.register("ender_girl", () -> register("ender_girl", EntityType.Builder.create(EntityGaiaNPCEnderGirl::new, EntityGaiaNPCEnderGirl::new)));
//	public static final RegistryObject<EntityType<EntityGaiaNPCTrader>> TRADER_NPC = ENTITIES.register("trader", () -> register("trader", EntityType.Builder.create(EntityGaiaNPCTrader::new, EntityGaiaNPCTrader::new)));
//	public static final RegistryObject<EntityType<EntityGaiaNPCHolstaurus>> HOLSTAURUS_NPC = ENTITIES.register("holstaurus", () -> register("holstaurus", EntityType.Builder.create(EntityGaiaNPCHolstaurus::new, EntityGaiaNPCHolstaurus::new)));
//	public static final RegistryObject<EntityType<EntityGaiaNPCWeresheep>> WERESHEEP_NPC = ENTITIES.register("weresheep", () -> register("weresheep", EntityType.Builder.create(EntityGaiaNPCWeresheep::new, EntityGaiaNPCWeresheep::new)));
//
	public static final RegistryObject<EntityType<GaiaMandragoraEntity>> MANDRAGORA = ENTITIES.register("mandragora", () -> register("mandragora", EntityType.Builder.<GaiaMandragoraEntity>create(GaiaMandragoraEntity::new, EntityClassification.MONSTER).size(0.75F, 1.0F)));
	public static final RegistryObject<EntityType<GaiaMimicEntity>> MIMIC = ENTITIES.register("mimic", () -> register("mimic", EntityType.Builder.<GaiaMimicEntity>create(GaiaMimicEntity::new, EntityClassification.MONSTER)));
//
//	public static final RegistryObject<EntityType<EntityGaiaSummonButler>> BUTLER = ENTITIES.register("butler", () -> register("butler", EntityType.Builder.create(EntityGaiaSummonButler::new, EntityGaiaSummonButler::new)));
//	public static final RegistryObject<EntityType<EntityGaiaSummonSporeling>> SPORELING = ENTITIES.register("sporeling", () -> register("sporeling", EntityType.Builder.create(EntityGaiaSummonSporeling::new, EntityGaiaSummonSporeling::new));

	/**
	 * Projectiles
	 */
	public static final RegistryObject<EntityType<GaiaProjectileBubbleEntity>> BUBBLE_PROJECTILE = ENTITIES.register("bubble", () -> registerProjectile("bubble", EntityType.Builder.<GaiaProjectileBubbleEntity>create(GaiaProjectileBubbleEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).setCustomClientFactory(GaiaProjectileBubbleEntity::new)));
	public static final RegistryObject<EntityType<GaiaProjectileMagicEntity>> MAGIC_PROJECTILE = ENTITIES.register("magic", () -> registerProjectile("magic", EntityType.Builder.<GaiaProjectileMagicEntity>create(GaiaProjectileMagicEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).setCustomClientFactory(GaiaProjectileMagicEntity::new)));
	public static final RegistryObject<EntityType<GaiaProjectilePoisonEntity>> POISON_PROJECTILE = ENTITIES.register("poison", () -> registerProjectile("poison", EntityType.Builder.<GaiaProjectilePoisonEntity>create(GaiaProjectilePoisonEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).setCustomClientFactory(GaiaProjectilePoisonEntity::new)));
	public static final RegistryObject<EntityType<GaiaProjectileSmallFireballEntity>> FIREBALL_PROJECTILE = ENTITIES.register("small_fireball", () -> registerProjectile("small_fireball", EntityType.Builder.<GaiaProjectileSmallFireballEntity>create(GaiaProjectileSmallFireballEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).setCustomClientFactory(GaiaProjectileSmallFireballEntity::new)));
	public static final RegistryObject<EntityType<GaiaProjectileWebEntity>> WEB_PROJECTILE = ENTITIES.register("web", () -> registerProjectile("web", EntityType.Builder.<GaiaProjectileWebEntity>create(GaiaProjectileWebEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).setCustomClientFactory(GaiaProjectileWebEntity::new)));
	public static final RegistryObject<EntityType<GaiaProjectileBombEntity>> BOMB_PROJECTILE = ENTITIES.register("bomb", () -> registerProjectile("bomb", EntityType.Builder.<GaiaProjectileBombEntity>create(GaiaProjectileBombEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).setCustomClientFactory(GaiaProjectileBombEntity::new)));

	/**
	 * Props
	 */
	public static final RegistryObject<EntityType<GaiaPropChestMimicEntity>> CHEST = ENTITIES.register("chest", () -> register("chest", EntityType.Builder.<GaiaPropChestMimicEntity>create(GaiaPropChestMimicEntity::new, EntityClassification.MISC).size(0.8F, 0.8F), false));
	public static final RegistryObject<EntityType<GaiaPropFlowerCyanEntity>> CYAN_FLOWER = ENTITIES.register("cyan_flower", () -> register("cyan_flower", EntityType.Builder.<GaiaPropFlowerCyanEntity>create(GaiaPropFlowerCyanEntity::new, EntityClassification.MISC).size(0.8F, 0.8F), false));
	public static final RegistryObject<EntityType<GaiaPropCampfireEntity>> CAMPFIRE = ENTITIES.register("campfire", () -> register("campfire", EntityType.Builder.<GaiaPropCampfireEntity>create(GaiaPropCampfireEntity::new, EntityClassification.MISC).size(0.8F, 0.8F)));
	public static final RegistryObject<EntityType<GaiaPropVaseEntity>> VASE = ENTITIES.register("vase", () -> register("vase", EntityType.Builder.<GaiaPropVaseEntity>create(GaiaPropVaseEntity::new, EntityClassification.MISC).immuneToFire().size(0.8F, 0.8F), false));
	public static final RegistryObject<EntityType<GaiaPropVaseNetherEntity>> VASE_NETHER = ENTITIES.register("vase_nether", () -> register("vase_nether", EntityType.Builder.<GaiaPropVaseNetherEntity>create(GaiaPropVaseNetherEntity::new, EntityClassification.MISC).immuneToFire().size(0.8F, 0.8F), false));

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates) {
		return builder.setTrackingRange(64).setUpdateInterval(3).setShouldReceiveVelocityUpdates(sendVelocityUpdates).build(id);
	}
	public static <T extends Entity> EntityType<T> registerProjectile(String id, EntityType.Builder<T> builder) {
		return builder.setTrackingRange(4).setUpdateInterval(10).build(id);
	}
	
	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
        return register(id, builder, true);
	}
}
