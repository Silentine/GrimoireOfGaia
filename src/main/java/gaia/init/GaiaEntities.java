package gaia.init;

import com.google.common.base.Preconditions;
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
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GaiaEntities {

//	public static final EntityType<EntityDebugMob> DEBUG_MOB = register("debug_mob", EntityType.Builder.create(EntityDebugMob::new, EntityDebugMob::new));
	public static final EntityType<GaiaAntEntity> ANT = register("ant", EntityType.Builder.<GaiaAntEntity>create(GaiaAntEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaAntRangerEntity> ANT_RANGER = register("ant_ranger", EntityType.Builder.<GaiaAntRangerEntity>create(GaiaAntRangerEntity::new, EntityClassification.MONSTER)
			.size(0.5F, 0.5F));
	public static final EntityType<GaiaAnubisEntity> ANUBIS = register("anubis", EntityType.Builder.create(GaiaAnubisEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaArachneEntity> ARACHNE = register("arachne", EntityType.Builder.<GaiaArachneEntity>create(GaiaArachneEntity::new, EntityClassification.MONSTER)
			.size(1.4F, 1.6F));
	public static final EntityType<GaiaBansheeEntity> BANSHEE = register("banshee", EntityType.Builder.<GaiaBansheeEntity>create(GaiaBansheeEntity::new, EntityClassification.MONSTER)
			.immuneToFire());
	public static final EntityType<GaiaBaphometEntity> BAPHOMET = register("baphomet", EntityType.Builder.<GaiaBaphometEntity>create(GaiaBaphometEntity::new, EntityClassification.MONSTER)
			.immuneToFire());
	public static final EntityType<GaiaBeeEntity> BEE = register("bee", EntityType.Builder.<GaiaBeeEntity>create(GaiaBeeEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaBoneKnightEntity> BONE_KNIGHT = register("bone_knight", EntityType.Builder.<GaiaBoneKnightEntity>create(GaiaBoneKnightEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaCecaeliaEntity> CECEALIA = register("cecaelia", EntityType.Builder.<GaiaCecaeliaEntity>create(GaiaCecaeliaEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaCentaurEntity> CENTAUR = register("centaur", EntityType.Builder.<GaiaCentaurEntity>create(GaiaCentaurEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaCobbleGolemEntity> COBBLE_GOLEM = register("cobble_golem", EntityType.Builder.<GaiaCobbleGolemEntity>create(GaiaCobbleGolemEntity::new, EntityClassification.MONSTER)
			.immuneToFire());
	public static final EntityType<GaiaCobblestoneGolemEntity> COBBLESTONE_GOLEM = register("cobblestone_golem", EntityType.Builder.<GaiaCobblestoneGolemEntity>create(GaiaCobblestoneGolemEntity::new, EntityClassification.MONSTER)
			.size(1.4F, 2.2F).immuneToFire());
	public static final EntityType<GaiaCreepEntity> CREEP = register("creep", EntityType.Builder.<GaiaCreepEntity>create(GaiaCreepEntity::new, EntityClassification.MONSTER)
			.size(0.75F, 0.75F));
	public static final EntityType<GaiaCyclopsEntity> CYCLOPS = register("cyclops", EntityType.Builder.<GaiaCyclopsEntity>create(GaiaCyclopsEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaDeathwordEntity> DEATHWORD = register("deathword", EntityType.Builder.<GaiaDeathwordEntity>create(GaiaDeathwordEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaDhampirEntity> DHAMPIR = register("dhampir", EntityType.Builder.<GaiaDhampirEntity>create(GaiaDhampirEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaDryadEntity> DRYAD = register("dryad", EntityType.Builder.create(GaiaDryadEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaDullahanEntity> DULLAHAN = register("dullahan", EntityType.Builder.create(GaiaDullahanEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaDwarfEntity> DWARF = register("dwarf", EntityType.Builder.<GaiaDwarfEntity>create(GaiaDwarfEntity::new, EntityClassification.MONSTER)
			.size(0.5F, 1.5F));
	public static final EntityType<GaiaEnderDragonGirlEntity> ENDER_DRAGON_GIRL = register("ender_dragon_girl", EntityType.Builder.<GaiaEnderDragonGirlEntity>create(GaiaEnderDragonGirlEntity::new, EntityClassification.MONSTER)
			.size(0.6F, 2.2F).immuneToFire());
	public static final EntityType<GaiaEnderEyeEntity> ENDER_EYE = register("ender_eye", EntityType.Builder.<GaiaEnderEyeEntity>create(GaiaEnderEyeEntity::new, EntityClassification.MONSTER)
			.size(1.0F, 2.4F).immuneToFire());
	public static final EntityType<GaiaFleshLichEntity> FLESH_LICH = register("flesh_lich", EntityType.Builder.<GaiaFleshLichEntity>create(GaiaFleshLichEntity::new, EntityClassification.MONSTER)
	.immuneToFire());
	public static final EntityType<GaiaGelatinousSlimeEntity> GELATINOUS_SLIME = register("gelatinous_slime", EntityType.Builder.<GaiaGelatinousSlimeEntity>create(GaiaGelatinousSlimeEntity::new, EntityClassification.MONSTER)
	.size(1.75F, 1.75F));
	public static final EntityType<GaiaGoblinEntity> GOBLIN = register("goblin", EntityType.Builder.<GaiaGoblinEntity>create(GaiaGoblinEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaGoblinFeralEntity> GOBLIN_FERAL = register("goblin_feral",EntityType.Builder.<GaiaGoblinFeralEntity>create(GaiaGoblinFeralEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaGryphonEntity> GRYPHON = register("gryphon", EntityType.Builder.<GaiaGryphonEntity>create(GaiaGryphonEntity::new, EntityClassification.MONSTER)
	.size(1.2F, 1.8F));
	public static final EntityType<GaiaHarpyEntity> HARPY = register("harpy", EntityType.Builder.<GaiaHarpyEntity>create(GaiaHarpyEntity::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaHunterEntity> HUNTER = register("hunter", EntityType.Builder.<GaiaHunterEntity>create(GaiaHunterEntity::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaKikimora> KIKIMORA = register("kikimora", EntityType.Builder.create(EntityGaiaKikimora::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaKobold> KOBOLD = register("kobold", EntityType.Builder.create(EntityGaiaKobold::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaMatango> MATANGO = register("matango", EntityType.Builder.create(EntityGaiaMatango::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaMermaid> MERMAID = register("mermaid", EntityType.Builder.create(EntityGaiaMermaid::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaMinotaur> MINOTAUR = register("minotaur", EntityType.Builder.create(EntityGaiaMinotaur::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaMinotaurus> MINOTAURUS = register("minotaurus", EntityType.Builder.create(EntityGaiaMinotaurus::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaMummy> MUMMY = register("mummy", EntityType.Builder.create(EntityGaiaMummy::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaNaga> NAGA = register("naga", EntityType.Builder.create(EntityGaiaNaga::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaNineTails> NINE_TAILS = register("nine_tails", EntityType.Builder.create(EntityGaiaNineTails::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaOni> ONI = register("oni", EntityType.Builder.create(EntityGaiaOni::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaOrc> ORC = register("orc", EntityType.Builder.create(EntityGaiaOrc::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaSatyress> SATYRESS = register("satyress", EntityType.Builder.create(EntityGaiaSatyress::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaSelkie> SELKIE = register("selkie", EntityType.Builder.create(EntityGaiaSelkie::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaShaman> SHAMAN = register("shaman", EntityType.Builder.create(EntityGaiaShaman::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaSharko> SHARKO = register("sharko", EntityType.Builder.create(EntityGaiaSharko::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaSiren> SIREN = register("siren", EntityType.Builder.create(EntityGaiaSiren::new, EntityClassification.MONSTER));
//	public static final EntityType<EntityGaiaSludgeGirl> SLUDGE_GIRL = register("sludge_girl", EntityType.Builder.create(EntityGaiaSludgeGirl::new, EntityClassification.MONSTER));
	public static final EntityType<GaiaSphinxEntity> SPHINX = register("sphinx", EntityType.Builder.<GaiaSphinxEntity>create(GaiaSphinxEntity::new, EntityClassification.MONSTER)
		.size(1.2F, 1.8F).immuneToFire());
//	public static final EntityType<EntityGaiaSpriggan> SPRIGGAN = register("spriggan", EntityType.Builder.create(EntityGaiaSpriggan::new, EntityGaiaSpriggan::new));
//	public static final EntityType<EntityGaiaSuccubus> SUCCUBUS = register("succubus", EntityType.Builder.create(EntityGaiaSuccubus::new, EntityGaiaSuccubus::new));
//	public static final EntityType<EntityGaiaToad> TOAD = register("toad", EntityType.Builder.create(EntityGaiaToad::new, EntityGaiaToad::new));
//	public static final EntityType<EntityGaiaValkyrie> VALKYRIE = register("valkyrie", EntityType.Builder.create(EntityGaiaValkyrie::new, EntityGaiaValkyrie::new));
//	public static final EntityType<EntityGaiaVampire> VAMPIRE = register("vampire", EntityType.Builder.create(EntityGaiaVampire::new, EntityGaiaVampire::new));
//	public static final EntityType<EntityGaiaWerecat> WERECAT = register("werecat", EntityType.Builder.create(EntityGaiaWerecat::new, EntityGaiaWerecat::new));
//	public static final EntityType<EntityGaiaWitch> WITCH = register("witch", EntityType.Builder.create(EntityGaiaWitch::new, EntityGaiaWitch::new));
//	public static final EntityType<EntityGaiaWitherCow> WITHER_COW = register("wither_cow", EntityType.Builder.create(EntityGaiaWitherCow::new, EntityGaiaWitherCow::new));
//	public static final EntityType<EntityGaiaYeti> YETI = register("yeti", EntityType.Builder.create(EntityGaiaYeti::new, EntityGaiaYeti::new));
//	public static final EntityType<EntityGaiaYukiOnna> YUKI_ONNA = register("yuki_onna", EntityType.Builder.create(EntityGaiaYukiOnna::new, EntityGaiaYukiOnna::new));
//
//	public static final EntityType<EntityGaiaNPCCreeperGirl> CREEPER_GIRL_NPC = register("creeper_girl", EntityType.Builder.create(EntityGaiaNPCCreeperGirl::new, EntityGaiaNPCCreeperGirl::new));
//	public static final EntityType<EntityGaiaNPCSlimeGirl> SLUDGE_GIRL_NPC = register("slime_girl", EntityType.Builder.create(EntityGaiaNPCSlimeGirl::new, EntityGaiaNPCSlimeGirl::new));
//	public static final EntityType<EntityGaiaNPCEnderGirl> ENDER_GIRL_NPC = register("ender_girl", EntityType.Builder.create(EntityGaiaNPCEnderGirl::new, EntityGaiaNPCEnderGirl::new));
//	public static final EntityType<EntityGaiaNPCTrader> TRADER_NPC = register("trader", EntityType.Builder.create(EntityGaiaNPCTrader::new, EntityGaiaNPCTrader::new));
//	public static final EntityType<EntityGaiaNPCHolstaurus> HOLSTAURUS_NPC = register("holstaurus", EntityType.Builder.create(EntityGaiaNPCHolstaurus::new, EntityGaiaNPCHolstaurus::new));
//	public static final EntityType<EntityGaiaNPCWeresheep> WERESHEEP_NPC = register("weresheep", EntityType.Builder.create(EntityGaiaNPCWeresheep::new, EntityGaiaNPCWeresheep::new));
//
	public static final EntityType<GaiaMandragoraEntity> MANDRAGORA = register("mandragora", EntityType.Builder.<GaiaMandragoraEntity>create(GaiaMandragoraEntity::new, EntityClassification.MONSTER)
.size(0.75F, 1.0F));
	public static final EntityType<GaiaMimicEntity> MIMIC = register("mimic", EntityType.Builder.<GaiaMimicEntity>create(GaiaMimicEntity::new, EntityClassification.MONSTER));
//
//	public static final EntityType<EntityGaiaSummonButler> BUTLER = register("butler", EntityType.Builder.create(EntityGaiaSummonButler::new, EntityGaiaSummonButler::new));
//	public static final EntityType<EntityGaiaSummonSporeling> SPORELING = register("sporeling", EntityType.Builder.create(EntityGaiaSummonSporeling::new, EntityGaiaSummonSporeling::new));

	public static final EntityType<GaiaProjectileBubbleEntity> BUBBLE_PROJECTILE = registerProjectile("bubble", EntityType.Builder.<GaiaProjectileBubbleEntity>create(GaiaProjectileBubbleEntity::new, EntityClassification.MISC)
			.size(0.3125F, 0.3125F)
			.setCustomClientFactory(GaiaProjectileBubbleEntity::new));
	public static final EntityType<GaiaProjectileMagicEntity> MAGIC_PROJECTILE = registerProjectile("magic", EntityType.Builder.<GaiaProjectileMagicEntity>create(GaiaProjectileMagicEntity::new, EntityClassification.MISC)
			.size(0.3125F, 0.3125F)
			.setCustomClientFactory(GaiaProjectileMagicEntity::new));
	public static final EntityType<GaiaProjectilePoisonEntity> POISON_PROJECTILE = registerProjectile("poison", EntityType.Builder.<GaiaProjectilePoisonEntity>create(GaiaProjectilePoisonEntity::new, EntityClassification.MISC)
			.size(0.3125F, 0.3125F)
			.setCustomClientFactory(GaiaProjectilePoisonEntity::new));
	public static final EntityType<GaiaProjectileSmallFireballEntity> FIREBALL_PROJECTILE = registerProjectile("small_fireball", EntityType.Builder.<GaiaProjectileSmallFireballEntity>create(GaiaProjectileSmallFireballEntity::new, EntityClassification.MISC)
			.size(0.3125F, 0.3125F)
			.setCustomClientFactory(GaiaProjectileSmallFireballEntity::new));
	public static final EntityType<GaiaProjectileWebEntity> WEB_PROJECTILE = registerProjectile("web", EntityType.Builder.<GaiaProjectileWebEntity>create(GaiaProjectileWebEntity::new, EntityClassification.MISC)
			.size(0.3125F, 0.3125F)
			.setCustomClientFactory(GaiaProjectileWebEntity::new));
	public static final EntityType<GaiaProjectileBombEntity> BOMB_PROJECTILE = registerProjectile("bomb", EntityType.Builder.<GaiaProjectileBombEntity>create(GaiaProjectileBombEntity::new, EntityClassification.MISC)
			.size(0.3125F, 0.3125F)
			.setCustomClientFactory(GaiaProjectileBombEntity::new));

	//Prop
	public static final EntityType<GaiaPropChestMimicEntity> CHEST = register("chest", EntityType.Builder.<GaiaPropChestMimicEntity>create(GaiaPropChestMimicEntity::new, EntityClassification.MISC).size(0.8F, 0.8F), false);
	public static final EntityType<GaiaPropFlowerCyanEntity> CYAN_FLOWER = register("cyan_flower", EntityType.Builder.<GaiaPropFlowerCyanEntity>create(GaiaPropFlowerCyanEntity::new, EntityClassification.MISC).size(0.8F, 0.8F), false);
	public static final EntityType<GaiaPropCampfireEntity> CAMPFIRE = register("campfire", EntityType.Builder.<GaiaPropCampfireEntity>create(GaiaPropCampfireEntity::new, EntityClassification.MISC).size(0.8F, 0.8F));
	public static final EntityType<GaiaPropVaseEntity> VASE = register("vase", EntityType.Builder.<GaiaPropVaseEntity>create(GaiaPropVaseEntity::new, EntityClassification.MISC).immuneToFire().size(0.8F, 0.8F), false);
	public static final EntityType<GaiaPropVaseNetherEntity> VASE_NETHER = register("vase_nether", EntityType.Builder.<GaiaPropVaseNetherEntity>create(GaiaPropVaseNetherEntity::new, EntityClassification.MISC).immuneToFire().size(0.8F, 0.8F), false);

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates) {
		EntityType<T> entityType = builder.setTrackingRange(64).setUpdateInterval(3).setShouldReceiveVelocityUpdates(sendVelocityUpdates).build("");
		ResourceLocation name = new ResourceLocation(GaiaReference.MOD_ID, id);
		entityType.setRegistryName(name);

		return entityType;
	}
	public static <T extends Entity> EntityType<T> registerProjectile(String id, EntityType.Builder<T> builder) {
		EntityType<T> entityType = builder.setTrackingRange(4).setUpdateInterval(10).build("");
		ResourceLocation name = new ResourceLocation(GaiaReference.MOD_ID, id);
		entityType.setRegistryName(name);

		return entityType;
	}
	
	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
        return register(id, builder, true);
	}

	public static void register(EntityType<?> entityType, RegistryEvent.Register<EntityType<?>> event) {
        Preconditions.checkNotNull(entityType, "registryName");
        event.getRegistry().register(entityType);
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
	{
//		register(DEBUG_MOB, event); //TODO: DISABLE BEFORE BUILD
		//Props
		register(CHEST, event);
		register(CAMPFIRE, event);
		register(CYAN_FLOWER, event);
		register(VASE, event);
		register(VASE_NETHER, event);

		//Projectiles
		register(BUBBLE_PROJECTILE, event);
		register(MAGIC_PROJECTILE, event);
		register(POISON_PROJECTILE, event);
		register(FIREBALL_PROJECTILE, event);
		register(WEB_PROJECTILE, event);
		register(BOMB_PROJECTILE, event);

		//Mobs
		register(ANT, event);
		register(ANT_RANGER, event);
		register(ANUBIS, event);
		register(ARACHNE, event);
		register(BANSHEE, event);
		register(BAPHOMET, event);
		register(BEE, event);
		register(BONE_KNIGHT, event);
		register(CECEALIA, event);
		register(CENTAUR, event);
		register(COBBLE_GOLEM, event);
		register(COBBLESTONE_GOLEM, event);
		register(CREEP, event);
		register(CYCLOPS, event);
		register(DEATHWORD, event);
		register(DHAMPIR, event);
		register(DRYAD, event);
		register(DULLAHAN, event);
		register(DWARF, event);
		register(ENDER_DRAGON_GIRL, event);
		register(ENDER_EYE, event);
		register(FLESH_LICH, event);
		register(GELATINOUS_SLIME, event);
		register(GOBLIN, event);
		register(GOBLIN_FERAL, event);
		register(GRYPHON, event);
		register(HARPY, event);
		register(HUNTER, event);
//		register(KIKIMORA, event);
//		register(KOBOLD, event);
//		register(MATANGO, event);
//		register(MERMAID, event);
//		register(MINOTAUR, event);
//		register(MINOTAURUS, event);
//		register(MUMMY, event);
//		register(NAGA, event);
//		register(NINE_TAILS, event);
//		register(ONI, event);
//		register(ORC, event);
//		register(SATYRESS, event);
//		register(SELKIE, event);
//		register(SHAMAN, event);
//		register(SHARKO, event);
//		register(SIREN, event);
//		register(SLUDGE_GIRL, event);
		register(SPHINX, event);
//		register(SPRIGGAN, event);
//		register(SUCCUBUS, event);
//		register(TOAD, event);
//		register(VALKYRIE, event);
//		register(VAMPIRE, event);
//		register(WERECAT, event);
//		register(WITCH, event);
//		register(WITHER_COW, event);
//		register(YETI, event);
//		register(YUKI_ONNA, event);
//		register(CREEPER_GIRL_NPC, event);
//		register(SLUDGE_GIRL_NPC, event);
//		register(ENDER_GIRL_NPC, event);
//		register(TRADER_NPC, event);
//		register(HOLSTAURUS_NPC, event);
//		register(WERESHEEP_NPC, event);
		register(MANDRAGORA, event);
		register(MIMIC, event);
//		register(BUTLER, event);
//		register(SPORELING, event);
	}

}
