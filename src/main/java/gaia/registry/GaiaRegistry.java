package gaia.registry;

import gaia.GrimoireOfGaia;
import gaia.block.DecorationBlock;
import gaia.entity.AntSalvager;
import gaia.entity.AntWorker;
import gaia.entity.Anubis;
import gaia.entity.Arachne;
import gaia.entity.Banshee;
import gaia.entity.Bee;
import gaia.entity.Behender;
import gaia.entity.BoneKnight;
import gaia.entity.Cecaelia;
import gaia.entity.Centaur;
import gaia.entity.CobbleGolem;
import gaia.entity.CobblestoneGolem;
import gaia.entity.Creep;
import gaia.entity.Cyclops;
import gaia.entity.Deathword;
import gaia.entity.Dryad;
import gaia.entity.Dullahan;
import gaia.entity.Dwarf;
import gaia.entity.EnderDragonGirl;
import gaia.entity.EnderEye;
import gaia.entity.FleshLich;
import gaia.entity.GaiaHorse;
import gaia.entity.GelatinousSlime;
import gaia.entity.Goblin;
import gaia.entity.GoblinFeral;
import gaia.entity.GraveMite;
import gaia.entity.Gryphon;
import gaia.entity.Harpy;
import gaia.entity.Hunter;
import gaia.entity.Kobold;
import gaia.entity.Mandragora;
import gaia.entity.Matango;
import gaia.entity.Mermaid;
import gaia.entity.Mimic;
import gaia.entity.Minotaur;
import gaia.entity.Minotaurus;
import gaia.entity.Mummy;
import gaia.entity.Naga;
import gaia.entity.NineTails;
import gaia.entity.Oni;
import gaia.entity.Orc;
import gaia.entity.Satyress;
import gaia.entity.Shaman;
import gaia.entity.Sharko;
import gaia.entity.Siren;
import gaia.entity.SludgeGirl;
import gaia.entity.Sphinx;
import gaia.entity.Sporeling;
import gaia.entity.Spriggan;
import gaia.entity.Succubus;
import gaia.entity.Toad;
import gaia.entity.Valkyrie;
import gaia.entity.Werecat;
import gaia.entity.Witch;
import gaia.entity.WitherCow;
import gaia.entity.WizardHarpy;
import gaia.entity.YukiOnna;
import gaia.entity.projectile.BombProjectile;
import gaia.entity.projectile.BubbleProjectile;
import gaia.entity.projectile.GaiaSmallFireball;
import gaia.entity.projectile.MagicProjectile;
import gaia.entity.projectile.PoisonProjectile;
import gaia.entity.projectile.RandomMagicProjectile;
import gaia.entity.projectile.WebProjectile;
import gaia.entity.prop.AntHill;
import gaia.entity.prop.Chest;
import gaia.entity.prop.CyanFlower;
import gaia.entity.trader.CreeperGirl;
import gaia.entity.trader.EnderGirl;
import gaia.entity.trader.SlimeGirl;
import gaia.entity.trader.Trader;
import gaia.item.ExperienceItem;
import gaia.item.LootableItem;
import gaia.item.MemoryBookItem;
import gaia.item.accessory.HeavyBarbellItem;
import gaia.item.accessory.KnucklesItem;
import gaia.item.accessory.RingItem;
import gaia.item.accessory.SeashellHairpinItem;
import gaia.item.armor.HeadgearItem;
import gaia.item.edible.EdibleEffectItem;
import gaia.item.edible.HoneydewItem;
import gaia.item.edible.MandrakeItem;
import gaia.item.edible.MonsterFeedItem;
import gaia.item.edible.TaprootItem;
import gaia.item.edible.WartJamItem;
import gaia.item.edible.XPEdibleItem;
import gaia.item.fuel.FireshardItem;
import gaia.item.fuel.FuelItem;
import gaia.item.fuel.GigaGearItem;
import gaia.item.fuel.SoulfireItem;
import gaia.item.weapon.BombItem;
import gaia.item.weapon.FanItem;
import gaia.item.weapon.FireFanItem;
import gaia.item.weapon.IceFanItem;
import gaia.item.weapon.MagicStaffItem;
import gaia.item.weapon.SummonStaffItem;
import gaia.item.weapon.book.BattleBookItem;
import gaia.item.weapon.book.BuffBookItem;
import gaia.item.weapon.book.EnderBookItem;
import gaia.item.weapon.book.FreezingBookItem;
import gaia.item.weapon.book.HungerBookItem;
import gaia.item.weapon.book.MetalBookItem;
import gaia.item.weapon.book.NatureBookItem;
import gaia.item.weapon.book.NightmareBookItem;
import gaia.item.weapon.book.WeaponBookItem;
import gaia.item.weapon.book.WitherBookItem;
import gaia.registry.helper.GaiaMobType;
import gaia.registry.helper.MobReg;
import gaia.registry.helper.PropReg;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class GaiaRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GrimoireOfGaia.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GrimoireOfGaia.MOD_ID);
	public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(GrimoireOfGaia.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GrimoireOfGaia.MOD_ID);

	public static final MobReg<AntSalvager> ANT_SALVAGER = new MobReg.Builder<>("ant_salvager", EntityType.Builder.of(AntSalvager::new, MobCategory.MONSTER).sized(0.5F, 0.5F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<AntWorker> ANT_WORKER = new MobReg.Builder<>("ant", EntityType.Builder.of(AntWorker::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Anubis> ANUBIS = new MobReg.Builder<>("anubis", EntityType.Builder.of(Anubis::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().withGender().build();
	public static final MobReg<Arachne> ARACHNE = new MobReg.Builder<>("arachne", EntityType.Builder.of(Arachne::new, MobCategory.MONSTER).sized(1.4F, 1.6F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Banshee> BANSHEE = new MobReg.Builder<>("banshee", EntityType.Builder.of(Banshee::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Bee> BEE = new MobReg.Builder<>("bee", GaiaMobType.ASSIST, EntityType.Builder.of(Bee::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Behender> BEHENDER = new MobReg.Builder<>("behender", EntityType.Builder.of(Behender::new, MobCategory.MONSTER).sized(1.5F, 1.6F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<BoneKnight> BONE_KNIGHT = new MobReg.Builder<>("bone_knight", EntityType.Builder.of(BoneKnight::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().withStep().build();
	public static final MobReg<Cecaelia> CECAELIA = new MobReg.Builder<>("cecaelia", EntityType.Builder.of(Cecaelia::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Centaur> CENTAUR = new MobReg.Builder<>("centaur", GaiaMobType.ASSIST, EntityType.Builder.of(Centaur::new, MobCategory.MONSTER).sized(1.3964844F, 1.99F).clientTrackingRange(8)).withDefaultSounds().withGender().build();
	public static final MobReg<CobbleGolem> COBBLE_GOLEM = new MobReg.Builder<>("cobble_golem", GaiaMobType.ASSIST, EntityType.Builder.of(CobbleGolem::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withAttack().withStep().withDeath().build();
	public static final MobReg<CobblestoneGolem> COBBLESTONE_GOLEM = new MobReg.Builder<>("cobblestone_golem", EntityType.Builder.of(CobblestoneGolem::new, MobCategory.MONSTER).sized(1.4F, 2.2F).clientTrackingRange(8)).withAttack().withStep().withDeath().build();
	public static final MobReg<Creep> CREEP = new MobReg.Builder<>("creep", EntityType.Builder.of(Creep::new, MobCategory.MONSTER).sized(0.75F, 0.75F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Cyclops> CYCLOPS = new MobReg.Builder<>("cyclops", GaiaMobType.ASSIST, EntityType.Builder.of(Cyclops::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Deathword> DEATHWORD = new MobReg.Builder<>("deathword", GaiaMobType.AGGRESSIVE, EntityType.Builder.of(Deathword::new, MobCategory.MONSTER).sized(0.6F, 0.6F).clientTrackingRange(8)).build();
	public static final MobReg<Dryad> DRYAD = new MobReg.Builder<>("dryad", GaiaMobType.ASSIST, EntityType.Builder.of(Dryad::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Dullahan> DULLAHAN = new MobReg.Builder<>("dullahan", EntityType.Builder.of(Dullahan::new, MobCategory.MONSTER).sized(0.6F, 1.6F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Dwarf> DWARF = new MobReg.Builder<>("dwarf", GaiaMobType.ASSIST, EntityType.Builder.of(Dwarf::new, MobCategory.MONSTER).sized(0.5F, 1.5F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<EnderDragonGirl> ENDER_DRAGON_GIRL = new MobReg.Builder<>("ender_dragon_girl", GaiaMobType.ASSIST, EntityType.Builder.of(EnderDragonGirl::new, MobCategory.MONSTER).sized(0.6F, 2.2F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<EnderEye> ENDER_EYE = new MobReg.Builder<>("ender_eye", EntityType.Builder.of(EnderEye::new, MobCategory.MONSTER).sized(1.0F, 1.0F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<FleshLich> FLESH_LICH = new MobReg.Builder<>("flesh_lich", EntityType.Builder.of(FleshLich::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().withStep().build();
	public static final MobReg<GelatinousSlime> GELATINOUS_SLIME = new MobReg.Builder<>("gelatinous_slime", EntityType.Builder.of(GelatinousSlime::new, MobCategory.MONSTER).sized(1.75F, 1.75F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Goblin> GOBLIN = new MobReg.Builder<>("goblin", GaiaMobType.ASSIST, EntityType.Builder.of(Goblin::new, MobCategory.MONSTER).sized(0.6F, 1.6F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<GoblinFeral> GOBLIN_FERAL = new MobReg.Builder<>("goblin_feral", EntityType.Builder.of(GoblinFeral::new, MobCategory.MONSTER).sized(0.6F, 1.6F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Gryphon> GRYPHON = new MobReg.Builder<>("gryphon", GaiaMobType.ASSIST, EntityType.Builder.of(Gryphon::new, MobCategory.MONSTER).sized(1.2F, 1.8F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Harpy> HARPY = new MobReg.Builder<>("harpy", EntityType.Builder.of(Harpy::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Hunter> HUNTER = new MobReg.Builder<>("hunter", GaiaMobType.ASSIST, EntityType.Builder.of(Hunter::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Kobold> KOBOLD = new MobReg.Builder<>("kobold", EntityType.Builder.of(Kobold::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Mandragora> MANDRAGORA = new MobReg.Builder<>("mandragora", EntityType.Builder.of(Mandragora::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Matango> MATANGO = new MobReg.Builder<>("matango", EntityType.Builder.of(Matango::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Mermaid> MERMAID = new MobReg.Builder<>("mermaid", GaiaMobType.ASSIST, EntityType.Builder.of(Mermaid::new, MobCategory.MONSTER).eyeHeight(0.9F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Mimic> MIMIC = new MobReg.Builder<>("mimic", EntityType.Builder.of(Mimic::new, MobCategory.MONSTER).sized(1.0F, 1.0F).eyeHeight(0.5F).clientTrackingRange(8)).build();
	public static final MobReg<Minotaur> MINOTAUR = new MobReg.Builder<>("minotaur", EntityType.Builder.of(Minotaur::new, MobCategory.MONSTER).sized(1.4F, 3.0F).clientTrackingRange(8)).withDefaultSounds().withStep().build();
	public static final MobReg<Minotaurus> MINOTAURUS = new MobReg.Builder<>("minotaurus", EntityType.Builder.of(Minotaurus::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Mummy> MUMMY = new MobReg.Builder<>("mummy", EntityType.Builder.of(Mummy::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Naga> NAGA = new MobReg.Builder<>("naga", EntityType.Builder.of(Naga::new, MobCategory.MONSTER).sized(1.0F, 2.2F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<NineTails> NINE_TAILS = new MobReg.Builder<>("nine_tails", EntityType.Builder.of(NineTails::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Oni> ONI = new MobReg.Builder<>("oni", EntityType.Builder.of(Oni::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Orc> ORC = new MobReg.Builder<>("orc", EntityType.Builder.of(Orc::new, MobCategory.MONSTER).sized(0.8F, 2.2F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Satyress> SATYRESS = new MobReg.Builder<>("satyress", GaiaMobType.ASSIST, EntityType.Builder.of(Satyress::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Shaman> SHAMAN = new MobReg.Builder<>("shaman", EntityType.Builder.of(Shaman::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Sharko> SHARKO = new MobReg.Builder<>("sharko", EntityType.Builder.of(Sharko::new, MobCategory.MONSTER).sized(1.4F, 2.0F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Siren> SIREN = new MobReg.Builder<>("siren", EntityType.Builder.of(Siren::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<SludgeGirl> SLUDGE_GIRL = new MobReg.Builder<>("sludge_girl", EntityType.Builder.of(SludgeGirl::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Sphinx> SPHINX = new MobReg.Builder<>("sphinx", EntityType.Builder.of(Sphinx::new, MobCategory.MONSTER).sized(1.2F, 1.8F).eyeHeight(0.45F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Sporeling> SPORELING = new MobReg.Builder<>("sporeling", EntityType.Builder.of(Sporeling::new, MobCategory.MONSTER).sized(0.25F, 0.50F).eyeHeight(0.45F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Spriggan> SPRIGGAN = new MobReg.Builder<>("spriggan", EntityType.Builder.of(Spriggan::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Succubus> SUCCUBUS = new MobReg.Builder<>("succubus", EntityType.Builder.of(Succubus::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().withGender().build();
	public static final MobReg<Toad> TOAD = new MobReg.Builder<>("toad", EntityType.Builder.of(Toad::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Valkyrie> VALKYRIE = new MobReg.Builder<>("valkyrie", GaiaMobType.ASSIST, EntityType.Builder.of(Valkyrie::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Werecat> WERECAT = new MobReg.Builder<>("werecat", EntityType.Builder.of(Werecat::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<Witch> WITCH = new MobReg.Builder<>("witch", EntityType.Builder.of(Witch::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<WitherCow> WITHER_COW = new MobReg.Builder<>("wither_cow", EntityType.Builder.of(WitherCow::new, MobCategory.MONSTER).sized(0.9F, 1.4F).eyeHeight(0.45F).clientTrackingRange(8).fireImmune()).withDefaultSounds().withStep().build();
	public static final MobReg<WizardHarpy> WIZARD_HARPY = new MobReg.Builder<>("wizard_harpy", GaiaMobType.ASSIST, EntityType.Builder.of(WizardHarpy::new, MobCategory.MONSTER).sized(0.6F, 1.99F).eyeHeight(0.99F).clientTrackingRange(8)).withDefaultSounds().build();
	public static final MobReg<YukiOnna> YUKI_ONNA = new MobReg.Builder<>("yuki_onna", GaiaMobType.ASSIST, EntityType.Builder.of(YukiOnna::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8)).withDefaultSounds().build();

	public static final MobReg<Trader> TRADER = new MobReg.Builder<>("trader", GaiaMobType.PASSIVE, EntityType.Builder.of(Trader::new, MobCategory.CREATURE).sized(0.6F, 1.99F).clientTrackingRange(8)).traderEgg().withDefaultSounds().build();
	public static final MobReg<CreeperGirl> CREEPER_GIRL = new MobReg.Builder<>("creeper_girl", GaiaMobType.PASSIVE, EntityType.Builder.of(CreeperGirl::new, MobCategory.CREATURE).sized(0.6F, 1.99F).clientTrackingRange(8)).traderEgg().withDefaultSounds().build();
	public static final MobReg<EnderGirl> ENDER_GIRL = new MobReg.Builder<>("ender_girl", GaiaMobType.PASSIVE, EntityType.Builder.of(EnderGirl::new, MobCategory.CREATURE).sized(0.6F, 1.99F).clientTrackingRange(8)).traderEgg().withDefaultSounds().build();
	//	public static final MobReg<Holstaurus> HOLSTAURUS = new MobReg.Builder<>("holstaurus", GaiaMobType.PASSIVE, EntityType.Builder.of(Holstaurus::new, MobCategory.CREATURE).sized(0.6F, 1.99F).clientTrackingRange(8)).traderEgg().withDefaultSounds().build();
	public static final MobReg<SlimeGirl> SLIME_GIRL = new MobReg.Builder<>("slime_girl", GaiaMobType.PASSIVE, EntityType.Builder.of(SlimeGirl::new, MobCategory.CREATURE).sized(0.6F, 1.99F).clientTrackingRange(8)).traderEgg().withDefaultSounds().build();
//	public static final MobReg<Weresheep> WERESHEEP = new MobReg.Builder<>("weresheep", GaiaMobType.PASSIVE, EntityType.Builder.of(Weresheep::new, MobCategory.CREATURE).sized(0.6F, 1.99F).clientTrackingRange(8)).traderEgg().withDefaultSounds().build();

	public static final MobReg<GaiaHorse> HORSE = new MobReg.Builder<>("horse", GaiaMobType.PASSIVE, EntityType.Builder.of(GaiaHorse::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).clientTrackingRange(10)).withDefaultSounds().build();
	public static final MobReg<GraveMite> GRAVEMITE = new MobReg.Builder<>("gravemite", GaiaMobType.AGGRESSIVE, EntityType.Builder.of(GraveMite::new, MobCategory.CREATURE).sized(0.4F, 0.3F).clientTrackingRange(10)).withDefaultSounds().withStep().build();

	//Props
	public static final PropReg<AntHill> ANT_HILL = new PropReg<>("ant_hill", EntityType.Builder.of(AntHill::new, MobCategory.CREATURE).sized(1.0F, 0.5F).clientTrackingRange(10));
	public static final PropReg<Chest> CHEST = new PropReg<>("chest", EntityType.Builder.of(Chest::new, MobCategory.CREATURE).sized(0.8F, 0.8F).clientTrackingRange(10));
	public static final PropReg<CyanFlower> CYAN_FLOWER = new PropReg<>("cyan_flower", EntityType.Builder.of(CyanFlower::new, MobCategory.CREATURE).sized(0.8F, 0.8F).clientTrackingRange(10));

	//Projectiles

	public static final Supplier<EntityType<GaiaSmallFireball>> SMALL_FIREBALL = ENTITIES.registerEntityType("small_fireball",
			GaiaSmallFireball::new,
			MobCategory.MISC,
			builder -> builder
					.sized(0.3125F, 0.3125F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.noLootTable()
	);
	public static final Supplier<EntityType<MagicProjectile>> MAGIC = ENTITIES.registerEntityType("magic",
			MagicProjectile::new,
			MobCategory.MISC,
			builder -> builder
					.sized(0.3125F, 0.3125F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.noLootTable()
	);
	public static final Supplier<EntityType<RandomMagicProjectile>> RANDOM_MAGIC = ENTITIES.registerEntityType("random_magic",
			RandomMagicProjectile::new,
			MobCategory.MISC,
			builder -> builder
					.sized(0.3125F, 0.3125F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.noLootTable()
	);
	public static final Supplier<EntityType<WebProjectile>> WEB = ENTITIES.registerEntityType("web",
			WebProjectile::new,
			MobCategory.MISC,
			builder -> builder
					.sized(0.3125F, 0.3125F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.noLootTable()
	);
	public static final Supplier<EntityType<PoisonProjectile>> POISON = ENTITIES.registerEntityType("poison",
			PoisonProjectile::new,
			MobCategory.MISC,
			builder -> builder
					.sized(0.3125F, 0.3125F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.noLootTable()
	);
	public static final Supplier<EntityType<BombProjectile>> BOMB = ENTITIES.registerEntityType("bomb",
			BombProjectile::new,
			MobCategory.MISC,
			builder -> builder
					.sized(0.3125F, 0.3125F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.noLootTable()
	);
	public static final Supplier<EntityType<BubbleProjectile>> BUBBLE = ENTITIES.registerEntityType("bubble",
			BubbleProjectile::new,
			MobCategory.MISC,
			builder -> builder
					.sized(0.3125F, 0.3125F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.noLootTable()
	);


	//Blocks
	public static final DeferredBlock<DecorationBlock> BUST_GORGON = BLOCKS.registerBlock("bust_gorgon", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> BUST_MINOTAUR = BLOCKS.registerBlock("bust_minotaur", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> BUST_SPHINX = BLOCKS.registerBlock("bust_sphinx", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> BUST_VALKYRIE = BLOCKS.registerBlock("bust_valkyrie", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> BUST_VAMPIRE = BLOCKS.registerBlock("bust_vampire", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> DECO_GARDEN_GNOME = BLOCKS.registerBlock("deco_garden_gnome", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(0.8F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> DECO_MANDRAGORA_POT = BLOCKS.registerBlock("deco_mandragora_pot", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(0.8F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> DECO_NEST_HARPY = BLOCKS.registerBlock("deco_nest_harpy", (properties) -> new DecorationBlock(properties.mapColor(MapColor.STONE).strength(0.8F, 6F).sound(SoundType.STONE)));
	public static final DeferredBlock<DecorationBlock> DOLL_CREEPER_GIRL = BLOCKS.registerBlock("doll_creeper_girl", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<DecorationBlock> DOLL_DRYAD = BLOCKS.registerBlock("doll_dryad", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<DecorationBlock> DOLL_DULLAHAN = BLOCKS.registerBlock("doll_dullahan", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<DecorationBlock> DOLL_ENDER_GIRL = BLOCKS.registerBlock("doll_ender_girl", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<DecorationBlock> DOLL_MAID = BLOCKS.registerBlock("doll_maid", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<DecorationBlock> DOLL_MERMAID = BLOCKS.registerBlock("doll_mermaid", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<DecorationBlock> DOLL_NINE_TAILS = BLOCKS.registerBlock("doll_nine_tails", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<DecorationBlock> DOLL_SLIME_GIRL = BLOCKS.registerBlock("doll_slime_girl", (properties) -> new DecorationBlock(properties.mapColor(MapColor.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final DeferredBlock<Block> PEARL_BLOCK = BLOCKS.registerBlock("pearl_block", (properties) -> new Block(properties.mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(0.8F)));


	//BlockItems
	public static final DeferredItem<BlockItem> BUST_GORGON_ITEM = ITEMS.registerSimpleBlockItem(BUST_GORGON);
	public static final DeferredItem<BlockItem> BUST_MINOTAUR_ITEM = ITEMS.registerSimpleBlockItem(BUST_MINOTAUR);
	public static final DeferredItem<BlockItem> BUST_SPHINX_ITEM = ITEMS.registerSimpleBlockItem(BUST_SPHINX);
	public static final DeferredItem<BlockItem> BUST_VALKYRIE_ITEM = ITEMS.registerSimpleBlockItem(BUST_VALKYRIE);
	public static final DeferredItem<BlockItem> BUST_VAMPIRE_ITEM = ITEMS.registerSimpleBlockItem(BUST_VAMPIRE);
	public static final DeferredItem<BlockItem> DECO_GARDEN_GNOME_ITEM = ITEMS.registerSimpleBlockItem(DECO_GARDEN_GNOME);
	public static final DeferredItem<BlockItem> DECO_MANDRAGORA_POT_ITEM = ITEMS.registerSimpleBlockItem(DECO_MANDRAGORA_POT);
	public static final DeferredItem<BlockItem> DECO_NEST_HARPY_ITEM = ITEMS.registerSimpleBlockItem(DECO_NEST_HARPY);
	public static final DeferredItem<BlockItem> DOLL_CREEPER_GIRL_ITEM = ITEMS.registerSimpleBlockItem(DOLL_CREEPER_GIRL);
	public static final DeferredItem<BlockItem> DOLL_DRYAD_ITEM = ITEMS.registerSimpleBlockItem(DOLL_DRYAD);
	public static final DeferredItem<BlockItem> DOLL_DULLAHAN_ITEM = ITEMS.registerSimpleBlockItem(DOLL_DULLAHAN);
	public static final DeferredItem<BlockItem> DOLL_ENDER_GIRL_ITEM = ITEMS.registerSimpleBlockItem(DOLL_ENDER_GIRL);
	public static final DeferredItem<BlockItem> DOLL_MAID_ITEM = ITEMS.registerSimpleBlockItem(DOLL_MAID);
	public static final DeferredItem<BlockItem> DOLL_MERMAID_ITEM = ITEMS.registerSimpleBlockItem(DOLL_MERMAID);
	public static final DeferredItem<BlockItem> DOLL_NINE_TAILS_ITEM = ITEMS.registerSimpleBlockItem(DOLL_NINE_TAILS);
	public static final DeferredItem<BlockItem> DOLL_SLIME_GIRL_ITEM = ITEMS.registerSimpleBlockItem(DOLL_SLIME_GIRL);
	public static final DeferredItem<BlockItem> PEARL_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(PEARL_BLOCK);

	//Items
	public static final DeferredItem<MemoryBookItem> BOOK_OF_MEMORY = ITEMS.registerItem("book_of_memory", (properties) -> new MemoryBookItem(properties.rarity(Rarity.RARE)));
	public static final DeferredItem<Item> BROOM = ITEMS.registerItem("broom", (properties) -> new Item(properties.rarity(Rarity.RARE)));
	public static final DeferredItem<WeaponBookItem> WEAPON_BOOK = ITEMS.registerItem("weapon_book", (properties) -> new WeaponBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<FreezingBookItem> WEAPON_BOOK_FREEZING = ITEMS.registerItem("weapon_book_freezing", (properties) -> new FreezingBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<NightmareBookItem> WEAPON_BOOK_NIGHTMARE = ITEMS.registerItem("weapon_book_nightmare", (properties) -> new NightmareBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<MetalBookItem> WEAPON_BOOK_METAL = ITEMS.registerItem("weapon_book_metal", (properties) -> new MetalBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<EnderBookItem> WEAPON_BOOK_ENDER = ITEMS.registerItem("weapon_book_ender", (properties) -> new EnderBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<HungerBookItem> WEAPON_BOOK_HUNGER = ITEMS.registerItem("weapon_book_hunger", (properties) -> new HungerBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<BattleBookItem> WEAPON_BOOK_BATTLE = ITEMS.registerItem("weapon_book_battle", (properties) -> new BattleBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<NatureBookItem> WEAPON_BOOK_NATURE = ITEMS.registerItem("weapon_book_nature", (properties) -> new NatureBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.RARE)));
	public static final DeferredItem<WitherBookItem> WEAPON_BOOK_WITHER = ITEMS.registerItem("weapon_book_wither", (properties) -> new WitherBookItem(GaiaTiers.BOOK, properties.rarity(Rarity.EPIC)));
	public static final DeferredItem<Item> QUILL = ITEMS.registerItem("quill", Item::new);
	public static final DeferredItem<BuffBookItem> WEAPON_BOOK_BUFF = ITEMS.registerItem("weapon_book_buff", (properties) -> new BuffBookItem(properties.durability(64).rarity(Rarity.RARE)));
	public static final DeferredItem<Item> CURSED_METAL_SWORD = ITEMS.registerItem("cursed_metal_sword", (properties) -> new Item(properties.sword(GaiaTiers.CURSED_METAL, 3, -2.2F).rarity(Rarity.RARE)));
	public static final DeferredItem<Item> METAL_CLUB = ITEMS.registerItem("metal_club", (properties) -> new Item(properties.sword(ToolMaterial.IRON, 4, -2.8F).rarity(Rarity.RARE)));
	public static final DeferredItem<ExperienceItem> EXPERIENCE_IRON = ITEMS.registerItem("experience_iron", (properties) -> new ExperienceItem(properties.rarity(Rarity.RARE), 1));
	public static final DeferredItem<ExperienceItem> EXPERIENCE_GOLD = ITEMS.registerItem("experience_gold", (properties) -> new ExperienceItem(properties.rarity(Rarity.RARE), 2));
	public static final DeferredItem<ExperienceItem> EXPERIENCE_DIAMOND = ITEMS.registerItem("experience_diamond", (properties) -> new ExperienceItem(properties.rarity(Rarity.RARE), 4));
	public static final DeferredItem<Item> ELYTRA_FRAGMENT = ITEMS.registerItem("elytra_fragment", Item::new);
	public static final DeferredItem<Item> TOTEM_FRAGMENT = ITEMS.registerItem("totem_of_undying_fragment", Item::new);
	public static final DeferredItem<Item> DIAMOND_SHARD = ITEMS.registerItem("diamond_shard", Item::new);
	public static final DeferredItem<Item> EMERALD_SHARD = ITEMS.registerItem("emerald_shard", Item::new);
	public static final DeferredItem<Item> SHINY_PEARL = ITEMS.registerItem("shiny_pearl", Item::new);
	public static final DeferredItem<FanItem> FAN = ITEMS.registerItem("fan", FanItem::new);
	public static final DeferredItem<SoulfireItem> SOULFIRE = ITEMS.registerItem("soulfire", SoulfireItem::new);
	public static final DeferredItem<FireFanItem> FAN_FIRE = ITEMS.registerItem("fan_fire", (properties) -> new FireFanItem(properties.attributes(IceFanItem.createAttributes(7))));
	public static final DeferredItem<IceFanItem> FAN_ICE = ITEMS.registerItem("fan_ice", (properties) -> new IceFanItem(properties.attributes(IceFanItem.createAttributes(0))));
	public static final DeferredItem<FireshardItem> FIRESHARD = ITEMS.registerItem("fireshard", FireshardItem::new);
	public static final DeferredItem<Item> FUR = ITEMS.registerItem("fur", Item::new);
	public static final DeferredItem<GigaGearItem> GIGA_GEAR = ITEMS.registerItem("giga_gear", (properties) -> new GigaGearItem(properties.stacksTo(1).rarity(Rarity.EPIC)));
	public static final DeferredItem<XPEdibleItem> GOLDEN_APPLE_PIE = ITEMS.registerItem("golden_apple_pie", (properties) -> new XPEdibleItem(properties.stacksTo(1).food(GaiaFoods.GOLDEN_APPLY_PIE, GaiaFoods.GOLDEN_APPLY_PIE_CONSUMABLE).rarity(Rarity.RARE), (rand) -> rand.nextInt(32) + 16));
	public static final DeferredItem<EdibleEffectItem> GOLDEN_APPLE_PIE_SLICE = ITEMS.registerItem("golden_apple_pie_slice", (properties) -> new EdibleEffectItem(properties.stacksTo(64).food(GaiaFoods.GOLDEN_APPLY_PIE_SLICE, GaiaFoods.GOLDEN_APPLY_PIE_SLICE_CONSUMABLE).rarity(Rarity.UNCOMMON)));
	public static final DeferredItem<MandrakeItem> MANDRAKE = ITEMS.registerItem("mandrake", (properties) -> new MandrakeItem(properties.stacksTo(16).food(GaiaFoods.MANDRAKE, GaiaFoods.MANDRAKE_CONSUMABLE).rarity(Rarity.UNCOMMON)));
	public static final DeferredItem<Item> MINOTAUR_HAMMER = ITEMS.registerItem("minotaur_hammer", (properties) -> new Item(properties.sword(ToolMaterial.IRON, 8, -2.8F)));
	public static final DeferredItem<HoneydewItem> HONEYDEW = ITEMS.registerItem("honeydew", (properties) -> new HoneydewItem(properties.stacksTo(64).food(GaiaFoods.HONEYDEW, GaiaFoods.HONEYDEW_CONSUMABLE).rarity(Rarity.UNCOMMON)));
	public static final DeferredItem<HeadgearItem> HEADGEAR_BOOK = ITEMS.registerItem("headgear_book", (properties) -> new HeadgearItem(properties.stacksTo(1)));
	public static final DeferredItem<HeadgearItem> HEADGEAR_MOB = ITEMS.registerItem("headgear_mob", (properties) -> new HeadgearItem(properties.stacksTo(1)));
	public static final DeferredItem<HeadgearItem> HEADGEAR_BOLT = ITEMS.registerItem("headgear_bolt", (properties) -> new HeadgearItem(properties.stacksTo(1)));
	public static final DeferredItem<HeadgearItem> HEADGEAR_ARROW = ITEMS.registerItem("headgear_arrow", (properties) -> new HeadgearItem(properties.stacksTo(1)));
	public static final DeferredItem<HeadgearItem> HEADGEAR_DOLL = ITEMS.registerItem("headgear_doll", (properties) -> new HeadgearItem(properties.stacksTo(1)));
	public static final DeferredItem<HeadgearItem> HEADGEAR_EARS_ELF = ITEMS.registerItem("headgear_ears_elf", (properties) -> new HeadgearItem(properties.stacksTo(1)));
	public static final DeferredItem<KnucklesItem> KNUCKLES = ITEMS.registerItem("knuckles", (properties) -> new KnucklesItem(properties.stacksTo(1)));
	public static final DeferredItem<SeashellHairpinItem> SEASHELL_HAIRPIN = ITEMS.registerItem("seashell_hairpin", (properties) -> new SeashellHairpinItem(properties.durability(1)));
	public static final DeferredItem<RingItem> RING_OF_SPEED = ITEMS.registerItem("ring_of_speed", (properties) -> new RingItem(properties,
			List.of(() -> new MobEffectInstance(MobEffects.SPEED, 5 * 20, 1, true, false))));
	public static final DeferredItem<RingItem> RING_OF_HASTE = ITEMS.registerItem("ring_of_haste", (properties) -> new RingItem(properties,
			List.of(() -> new MobEffectInstance(MobEffects.HASTE, 5 * 20, 1, true, false))));
	public static final DeferredItem<RingItem> RING_OF_JUMP = ITEMS.registerItem("ring_of_jump", (properties) -> new RingItem(properties,
			List.of(() -> new MobEffectInstance(MobEffects.JUMP_BOOST, 5 * 20, 1, true, false))));
	public static final DeferredItem<RingItem> RING_OF_NIGHT = ITEMS.registerItem("ring_of_night", (properties) -> new RingItem(properties,
			List.of(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 15 * 20, 1, true, false))));
	public static final DeferredItem<HeavyBarbellItem> HEAVY_BARBELL = ITEMS.registerItem("heavy_barbell", HeavyBarbellItem::new);
	public static final DeferredItem<Item> MEAT = ITEMS.registerItem("meat", (properties) -> new Item(properties.food(GaiaFoods.MEAT)));
	public static final DeferredItem<Item> METAL_DAGGER = ITEMS.registerItem("metal_dagger", (properties) -> new Item(properties.sword(ToolMaterial.IRON, 0, -2.0F)));
	public static final DeferredItem<MonsterFeedItem> MONSTER_FEED = ITEMS.registerItem("monster_feed", (properties) -> new MonsterFeedItem(properties.stacksTo(4).food(GaiaFoods.MONSTER_FEED)));
	public static final DeferredItem<MonsterFeedItem> PREMIUM_MONSTER_FEED = ITEMS.registerItem("premium_monster_feed", (properties) -> new MonsterFeedItem(properties.stacksTo(1).food(GaiaFoods.PREMIUM_MONSTER_FEED)));
	public static final DeferredItem<EdibleEffectItem> ROTTEN_HEART = ITEMS.registerItem("rotten_heart", (properties) -> new EdibleEffectItem(properties.food(GaiaFoods.ROTTEN_HEART, GaiaFoods.ROTTEN_HEART_CONSUMABLE).stacksTo(1)));
	public static final DeferredItem<FuelItem> STONE_COAL = ITEMS.registerItem("stone_coal", FuelItem::new);
	public static final DeferredItem<TaprootItem> TAPROOT = ITEMS.registerItem("taproot", (properties) -> new TaprootItem(properties.food(GaiaFoods.TAPROOT)));
	public static final DeferredItem<SummonStaffItem> ZOMBIE_STAFF = ITEMS.registerItem("zombie_staff", (properties) -> new SummonStaffItem(properties.rarity(Rarity.RARE).durability(10), () -> EntityType.ZOMBIE, Items.ROTTEN_FLESH));
	public static final DeferredItem<SummonStaffItem> SKELETON_STAFF = ITEMS.registerItem("skeleton_staff", (properties) -> new SummonStaffItem(properties.rarity(Rarity.RARE).durability(10), () -> EntityType.SKELETON, Items.BONE));
	public static final DeferredItem<SummonStaffItem> CAVE_SPIDER_STAFF = ITEMS.registerItem("cave_spider_staff", (properties) -> new SummonStaffItem(properties.rarity(Rarity.RARE).durability(10), () -> EntityType.CAVE_SPIDER, Items.SPIDER_EYE));
	public static final DeferredItem<MagicStaffItem> MAGIC_STAFF = ITEMS.registerItem("magic_staff", (properties) -> new MagicStaffItem(properties.rarity(Rarity.RARE).durability(64)));
	public static final DeferredItem<Item> PROJECTILE_MAGIC = ITEMS.registerItem("projectile_magic", (properties) -> new Item(properties.stacksTo(1)));
	public static final DeferredItem<Item> PROJECTILE_RANDOM_MAGIC = ITEMS.registerItem("projectile_random_magic", (properties) -> new Item(properties.stacksTo(1)));
	public static final DeferredItem<Item> PROJECTILE_WEB = ITEMS.registerItem("projectile_web", (properties) -> new Item(properties.stacksTo(1)));
	public static final DeferredItem<BombItem> PROJECTILE_BOMB = ITEMS.registerItem("projectile_bomb", (properties) -> new BombItem(properties.stacksTo(1)));
	public static final DeferredItem<Item> PROJECTILE_POISON = ITEMS.registerItem("projectile_poison", (properties) -> new Item(properties.stacksTo(1)));
	public static final DeferredItem<Item> PROJECTILE_BUBBLE = ITEMS.registerItem("projectile_bubble", (properties) -> new Item(properties.stacksTo(1)));
	public static final DeferredItem<WartJamItem> NETHER_WART_JAM = ITEMS.registerItem("nether_wart_jam", (properties) -> new WartJamItem(properties.food(GaiaFoods.NETHER_WART_JAM, GaiaFoods.NETHER_WART_JAM_CONSUMABLE)));
	public static final DeferredItem<EdibleEffectItem> WITHERED_BRAIN = ITEMS.registerItem("withered_brain", (properties) -> new EdibleEffectItem(properties.stacksTo(1).food(GaiaFoods.WITHERED_BRAIN, GaiaFoods.WITHERED_BRAIN_CONSUMABLE)));

	public static final DeferredItem<ShieldItem> STONE_SHIELD = ITEMS.registerItem("stone_shield", (properties) -> new ShieldItem(properties.rarity(Rarity.UNCOMMON).durability(150).repairable(Tags.Items.COBBLESTONES)));
	public static final DeferredItem<ShieldItem> IRON_SHIELD = ITEMS.registerItem("iron_shield", (properties) -> new ShieldItem(properties.rarity(Rarity.UNCOMMON).durability(336).repairable(Tags.Items.INGOTS_IRON)));
	public static final DeferredItem<ShieldItem> GOLD_SHIELD = ITEMS.registerItem("gold_shield", (properties) -> new ShieldItem(properties.rarity(Rarity.UNCOMMON).durability(260).repairable(Tags.Items.INGOTS_GOLD)));
	public static final DeferredItem<ShieldItem> BONE_SHIELD = ITEMS.registerItem("bone_shield", (properties) -> new ShieldItem(properties.rarity(Rarity.UNCOMMON).durability(200).repairable(Tags.Items.BONES)));

	//Lootable Item
	public static final DeferredItem<LootableItem> BAG_ARROWS = ITEMS.registerItem("bag_arrows", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BAG_ARROW, GaiaSounds.BAG_OPEN));
	public static final DeferredItem<LootableItem> BAG_BOOK = ITEMS.registerItem("bag_book", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BAG_BOOK, GaiaSounds.BAG_OPEN));
	public static final DeferredItem<LootableItem> BAG_RECORD = ITEMS.registerItem("bag_record", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BAG_RECORD, GaiaSounds.BAG_OPEN));
	public static final DeferredItem<LootableItem> BOX_DIAMOND = ITEMS.registerItem("box_diamond", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BOXES_DIAMOND, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_END = ITEMS.registerItem("box_end", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BOXES_END, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_GOLD = ITEMS.registerItem("box_gold", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BOXES_GOLD, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_HAT = ITEMS.registerItem("box_hat", (properties) -> new LootableItem(properties, GaiaLootTables.BOXES_HAT, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_IRON = ITEMS.registerItem("box_iron", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BOXES_IRON, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_NETHER = ITEMS.registerItem("box_nether", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BOXES_NETHER, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_OLD = ITEMS.registerItem("box_old", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), GaiaLootTables.BOXES_OLD, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_OVERWORLD = ITEMS.registerItem("box_overworld", (properties) -> new LootableItem(properties.rarity(Rarity.RARE).rarity(Rarity.RARE), GaiaLootTables.BOXES_OVERWORLD, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> BOX_EGG = ITEMS.registerItem("box_egg", (properties) -> new LootableItem(properties.rarity(Rarity.RARE).rarity(Rarity.RARE), GaiaLootTables.BOXES_EGG, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> CHEST_DESERT = ITEMS.registerItem("chest_desert", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), BuiltInLootTables.DESERT_PYRAMID, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> CHEST_DUNGEON = ITEMS.registerItem("chest_dungeon", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), BuiltInLootTables.SIMPLE_DUNGEON, GaiaSounds.BOX_OPEN));
	public static final DeferredItem<LootableItem> CHEST_JUNGLE = ITEMS.registerItem("chest_jungle", (properties) -> new LootableItem(properties.rarity(Rarity.RARE), BuiltInLootTables.JUNGLE_TEMPLE, GaiaSounds.BOX_OPEN));

	//Merchant Item
	public static final DeferredItem<Item> TRADER_TOKEN = ITEMS.registerItem("trader_token", Item::new);
	public static final DeferredItem<Item> HOLSTAURUS_TOKEN = ITEMS.registerItem("holstaurus_token", Item::new);
	public static final DeferredItem<Item> WERESHEEP_TOKEN = ITEMS.registerItem("weresheep_token", Item::new);

	public static final Supplier<CreativeModeTab> GAIA_TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(GaiaRegistry.DOLL_DRYAD.get()))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.title(Component.translatable("itemGroup.grimoireofgaia"))
			.displayItems((features, output) -> {
				List<ItemStack> stacks = GaiaRegistry.ITEMS.getEntries().stream()
						.map(reg -> new ItemStack(reg.get())).toList();
				output.acceptAll(stacks);
			}).build());
}
