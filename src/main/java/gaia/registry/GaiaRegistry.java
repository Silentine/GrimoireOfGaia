package gaia.registry;

import gaia.GrimoireOfGaia;
import gaia.block.DecorationBlock;
import gaia.entity.AntWorker;
import gaia.entity.Anubis;
import gaia.entity.Arachne;
import gaia.entity.Banshee;
import gaia.entity.Bee;
import gaia.entity.Centaur;
import gaia.entity.Creep;
import gaia.entity.Cyclops;
import gaia.entity.Dryad;
import gaia.entity.Dullahan;
import gaia.entity.GaiaHorse;
import gaia.entity.Goblin;
import gaia.entity.GoblinFeral;
import gaia.entity.Harpy;
import gaia.entity.Hunter;
import gaia.entity.Kobold;
import gaia.entity.Matango;
import gaia.entity.NineTails;
import gaia.entity.Oni;
import gaia.entity.Orc;
import gaia.entity.Satyress;
import gaia.entity.Shaman;
import gaia.entity.Siren;
import gaia.entity.SludgeGirl;
import gaia.entity.Sporeling;
import gaia.entity.Spriggan;
import gaia.entity.Succubus;
import gaia.entity.Werecat;
import gaia.entity.YukiOnna;
import gaia.entity.projectile.BombProjectile;
import gaia.entity.projectile.GaiaSmallFireball;
import gaia.entity.projectile.MagicProjectile;
import gaia.entity.projectile.PoisonProjectile;
import gaia.entity.projectile.WebProjectile;
import gaia.entity.prop.AntHill;
import gaia.item.ExperienceItem;
import gaia.item.LootableItem;
import gaia.item.MemoryBookItem;
import gaia.item.accessory.KnucklesItem;
import gaia.item.armor.HeadgearItem;
import gaia.item.edible.EdibleEffectItem;
import gaia.item.edible.HoneydewItem;
import gaia.item.edible.TaprootItem;
import gaia.item.edible.XPEdibleItem;
import gaia.item.fuel.FireshardItem;
import gaia.item.fuel.FuelItem;
import gaia.item.fuel.GigaGearItem;
import gaia.item.fuel.SoulfireItem;
import gaia.item.shield.TieredShieldItem;
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
import gaia.registry.helper.MobReg;
import gaia.registry.helper.PropReg;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GaiaRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GrimoireOfGaia.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GrimoireOfGaia.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, GrimoireOfGaia.MOD_ID);

	public static final MobReg<AntWorker> ANT_WORKER = new MobReg<>("ant", EntityType.Builder.<AntWorker>of(AntWorker::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x303030, 0x8a7264, false);
	public static final MobReg<Anubis> ANUBIS = new MobReg<>("anubis", EntityType.Builder.<Anubis>of(Anubis::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x353535, 0xb19534, true);
	public static final MobReg<Arachne> ARACHNE = new MobReg<>("arachne", EntityType.Builder.<Arachne>of(Arachne::new, MobCategory.MONSTER).sized(1.4F, 1.6F).clientTrackingRange(8), 3815994, 11013646);
	public static final MobReg<Banshee> BANSHEE = new MobReg<>("banshee", EntityType.Builder.<Banshee>of(Banshee::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0xeed2e8, 0xc6b0ed);
	public static final MobReg<Bee> BEE = new MobReg<>("bee", EntityType.Builder.<Bee>of(Bee::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0xc9b161, 0x353535);
	public static final MobReg<Centaur> CENTAUR = new MobReg<>("centaur", EntityType.Builder.<Centaur>of(Centaur::new, MobCategory.MONSTER).sized(1.3964844F, 1.99F).clientTrackingRange(8), 0x8d4f41, 0x353535, true);
	public static final MobReg<Creep> CREEP = new MobReg<>("creep", EntityType.Builder.<Creep>of(Creep::new, MobCategory.MONSTER).sized(0.75F, 0.75F).clientTrackingRange(8), 7917159, 2053400);
	public static final MobReg<Cyclops> CYCLOPS = new MobReg<>("cyclops", EntityType.Builder.<Cyclops>of(Cyclops::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 4936602, 3487029);
	public static final MobReg<Dryad> DRYAD = new MobReg<>("dryad", EntityType.Builder.<Dryad>of(Dryad::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 10255437, 5681460);
	public static final MobReg<Dullahan> DULLAHAN = new MobReg<>("dullahan", EntityType.Builder.<Dullahan>of(Dullahan::new, MobCategory.MONSTER).sized(0.6F, 1.6F).clientTrackingRange(8), 0x824fab, 0xa4452d);
	public static final MobReg<Goblin> GOBLIN = new MobReg<>("goblin", EntityType.Builder.<Goblin>of(Goblin::new, MobCategory.MONSTER).sized(0.6F, 1.6F).clientTrackingRange(8), 0x718a60, 0x8d4f41);
	public static final MobReg<GoblinFeral> GOBLIN_FERAL = new MobReg<>("goblin_feral", EntityType.Builder.<GoblinFeral>of(GoblinFeral::new, MobCategory.MONSTER).sized(0.6F, 1.6F).clientTrackingRange(8), 0x718a60, 0x8a1d3e);
	public static final MobReg<Harpy> HARPY = new MobReg<>("harpy", EntityType.Builder.<Harpy>of(Harpy::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0xc9b161, 0xa5884e);
	public static final MobReg<Hunter> HUNTER = new MobReg<>("hunter", EntityType.Builder.<Hunter>of(Hunter::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0xae6b3c, 0x353535);
	public static final MobReg<Kobold> KOBOLD = new MobReg<>("kobold", EntityType.Builder.<Kobold>of(Kobold::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x938dab, 0xafa7c1);
	public static final MobReg<Matango> MATANGO = new MobReg<>("matango", EntityType.Builder.<Matango>of(Matango::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0xab1311, 0xd8d8d8);
	public static final MobReg<NineTails> NINE_TAILS = new MobReg<>("nine_tails", EntityType.Builder.<NineTails>of(NineTails::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 11809844, 13218145);
	public static final MobReg<Oni> ONI = new MobReg<>("oni", EntityType.Builder.<Oni>of(Oni::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x8b302d, 0xc9b161);
	public static final MobReg<Orc> ORC = new MobReg<>("orc", EntityType.Builder.<Orc>of(Orc::new, MobCategory.MONSTER).sized(0.8F, 2.2F).clientTrackingRange(8), 0x718a60, 0xc0d696);
	public static final MobReg<Satyress> SATYRESS = new MobReg<>("satyress", EntityType.Builder.<Satyress>of(Satyress::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x707b4f, 0xa4452d);
	public static final MobReg<Shaman> SHAMAN = new MobReg<>("shaman", EntityType.Builder.<Shaman>of(Shaman::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0xae6b3c, 0x56b134);
	public static final MobReg<Siren> SIREN = new MobReg<>("siren", EntityType.Builder.<Siren>of(Siren::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x29bc55, 0x48a0de);
	public static final MobReg<SludgeGirl> SLUDGE_GIRL = new MobReg<>("sludge_girl", EntityType.Builder.<SludgeGirl>of(SludgeGirl::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 6595667, 7715172);
	public static final MobReg<Sporeling> SPORELING = new MobReg<>("sporeling", EntityType.Builder.<Sporeling>of(Sporeling::new, MobCategory.MONSTER).sized(0.25F, 0.50F).clientTrackingRange(8), 0xc32826, 0x977251);
	public static final MobReg<Spriggan> SPRIGGAN = new MobReg<>("spriggan", EntityType.Builder.<Spriggan>of(Spriggan::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x7c623e, 0xc2dda5);
	public static final MobReg<Succubus> SUCCUBUS = new MobReg<>("succubus", EntityType.Builder.<Succubus>of(Succubus::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 4079166, 13218145, true);
	public static final MobReg<Werecat> WERECAT = new MobReg<>("werecat", EntityType.Builder.<Werecat>of(Werecat::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 0x7a7e8a, 0xdddadb);
	public static final MobReg<YukiOnna> YUKI_ONNA = new MobReg<>("yuki_onna", EntityType.Builder.<YukiOnna>of(YukiOnna::new, MobCategory.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8), 6781114, 13817330);

	public static final MobReg<GaiaHorse> HORSE = new MobReg<>("horse", EntityType.Builder.<GaiaHorse>of(GaiaHorse::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).clientTrackingRange(10), 0x252525, 0x3a3a3a);

	//Props
	public static final PropReg<AntHill> ANT_HILL = new PropReg<>("ant_hill", EntityType.Builder.<AntHill>of(AntHill::new, MobCategory.CREATURE).sized(1.0F, 0.5F).clientTrackingRange(10), 0xe4dea7, 0x545454);

	//Projectiles
	public static final RegistryObject<EntityType<GaiaSmallFireball>> SMALL_FIREBALL = ENTITIES.register("small_fireball", () ->
			EntityType.Builder.<GaiaSmallFireball>of(GaiaSmallFireball::new, MobCategory.MISC)
					.sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10)
					.setCustomClientFactory(GaiaSmallFireball::new).build("small_fireball"));
	public static final RegistryObject<EntityType<MagicProjectile>> MAGIC = ENTITIES.register("magic", () ->
			EntityType.Builder.<MagicProjectile>of(MagicProjectile::new, MobCategory.MISC)
					.sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10)
					.setCustomClientFactory(MagicProjectile::new).build("magic"));
	public static final RegistryObject<EntityType<WebProjectile>> WEB = ENTITIES.register("web", () ->
			EntityType.Builder.<WebProjectile>of(WebProjectile::new, MobCategory.MISC)
					.sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10)
					.setCustomClientFactory(WebProjectile::new).build("web"));

	public static final RegistryObject<EntityType<PoisonProjectile>> POISON = ENTITIES.register("poison", () ->
			EntityType.Builder.<PoisonProjectile>of(PoisonProjectile::new, MobCategory.MISC)
					.sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10)
					.setCustomClientFactory(PoisonProjectile::new).build("poison"));
	public static final RegistryObject<EntityType<BombProjectile>> BOMB = ENTITIES.register("bomb", () ->
			EntityType.Builder.<BombProjectile>of(BombProjectile::new, MobCategory.MISC)
					.sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10)
					.setCustomClientFactory(BombProjectile::new).build("bomb"));


	//Blocks
	public static final RegistryObject<Block> BUST_GORGON = BLOCKS.register("bust_gorgon", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BUST_MINOTAUR = BLOCKS.register("bust_minotaur", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BUST_SPHINX = BLOCKS.register("bust_sphinx", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BUST_VALKYRIE = BLOCKS.register("bust_valkyrie", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BUST_VAMPIRE = BLOCKS.register("bust_vampire", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DECO_GARDEN_GNOME = BLOCKS.register("deco_garden_gnome", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(0.8F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DECO_MANDRAGORA_POT = BLOCKS.register("deco_mandragora_pot", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(0.8F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DECO_NEST_HARPY = BLOCKS.register("deco_nest_harpy", () -> new DecorationBlock(Block.Properties.of(Material.STONE).strength(0.8F, 6F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DOLL_CREEPER_GIRL = BLOCKS.register("doll_creeper_girl", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> DOLL_DRYAD = BLOCKS.register("doll_dryad", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> DOLL_DULLAHAN = BLOCKS.register("doll_dullahan", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> DOLL_ENDER_GIRL = BLOCKS.register("doll_ender_girl", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> DOLL_MAID = BLOCKS.register("doll_maid", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> DOLL_MERMAID = BLOCKS.register("doll_mermaid", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> DOLL_NINE_TAILS = BLOCKS.register("doll_nine_tails", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> DOLL_SLIME_GIRL = BLOCKS.register("doll_slime_girl", () -> new DecorationBlock(Block.Properties.of(Material.WOOL).strength(0.8F, 6F).sound(SoundType.WOOL)));

	//BlockItems
	public static final RegistryObject<Item> BUST_GORGON_ITEM = ITEMS.register("bust_gorgon", () -> new BlockItem(BUST_GORGON.get(), itemBuilder()));
	public static final RegistryObject<Item> BUST_MINOTAUR_ITEM = ITEMS.register("bust_minotaur", () -> new BlockItem(BUST_MINOTAUR.get(), itemBuilder()));
	public static final RegistryObject<Item> BUST_SPHINX_ITEM = ITEMS.register("bust_sphinx", () -> new BlockItem(BUST_SPHINX.get(), itemBuilder()));
	public static final RegistryObject<Item> BUST_VALKYRIE_ITEM = ITEMS.register("bust_valkyrie", () -> new BlockItem(BUST_VALKYRIE.get(), itemBuilder()));
	public static final RegistryObject<Item> BUST_VAMPIRE_ITEM = ITEMS.register("bust_vampire", () -> new BlockItem(BUST_VAMPIRE.get(), itemBuilder()));
	public static final RegistryObject<Item> DECO_GARDEN_GNOME_ITEM = ITEMS.register("deco_garden_gnome", () -> new BlockItem(DECO_GARDEN_GNOME.get(), itemBuilder()));
	public static final RegistryObject<Item> DECO_MANDRAGORA_POT_ITEM = ITEMS.register("deco_mandragora_pot", () -> new BlockItem(DECO_MANDRAGORA_POT.get(), itemBuilder()));
	public static final RegistryObject<Item> DECO_NEST_HARPY_ITEM = ITEMS.register("deco_nest_harpy", () -> new BlockItem(DECO_NEST_HARPY.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_CREEPER_GIRL_ITEM = ITEMS.register("doll_creeper_girl", () -> new BlockItem(DOLL_CREEPER_GIRL.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_DRYAD_ITEM = ITEMS.register("doll_dryad", () -> new BlockItem(DOLL_DRYAD.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_DULLAHAN_ITEM = ITEMS.register("doll_dullahan", () -> new BlockItem(DOLL_DULLAHAN.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_ENDER_GIRL_ITEM = ITEMS.register("doll_ender_girl", () -> new BlockItem(DOLL_ENDER_GIRL.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_MAID_ITEM = ITEMS.register("doll_maid", () -> new BlockItem(DOLL_MAID.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_MERMAID_ITEM = ITEMS.register("doll_mermaid", () -> new BlockItem(DOLL_MERMAID.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_NINE_TAILS_ITEM = ITEMS.register("doll_nine_tails", () -> new BlockItem(DOLL_NINE_TAILS.get(), itemBuilder()));
	public static final RegistryObject<Item> DOLL_SLIME_GIRL_ITEM = ITEMS.register("doll_slime_girl", () -> new BlockItem(DOLL_SLIME_GIRL.get(), itemBuilder()));

	//Items
	public static final RegistryObject<Item> BOOK_OF_MEMORY = ITEMS.register("book_of_memory", () -> new MemoryBookItem(itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK = ITEMS.register("weapon_book", () -> new WeaponBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_FREEZING = ITEMS.register("weapon_book_freezing", () -> new FreezingBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_NIGHTMARE = ITEMS.register("weapon_book_nightmare", () -> new NightmareBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_METAL = ITEMS.register("weapon_book_metal", () -> new MetalBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_ENDER = ITEMS.register("weapon_book_ender", () -> new EnderBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_HUNGER = ITEMS.register("weapon_book_hunger", () -> new HungerBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_BATTLE = ITEMS.register("weapon_book_battle", () -> new BattleBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_NATURE = ITEMS.register("weapon_book_nature", () -> new NatureBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> WEAPON_BOOK_WITHER = ITEMS.register("weapon_book_wither", () -> new WitherBookItem(GaiaTiers.BOOK, itemBuilder().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> WEAPON_BOOK_BUFF = ITEMS.register("weapon_book_buff", () -> new BuffBookItem(itemBuilder().durability(64).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> CURSED_METAL_SWORD = ITEMS.register("cursed_metal_sword", () -> new SwordItem(GaiaTiers.CURSED_METAL, 3, -2.2F, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> METAL_CLUB = ITEMS.register("metal_club", () -> new SwordItem(Tiers.IRON, 4, -2.3F, itemBuilder().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> EXPERIENCE_IRON = ITEMS.register("experience_iron", () -> new ExperienceItem(itemBuilder().rarity(Rarity.RARE), 1));
	public static final RegistryObject<Item> EXPERIENCE_GOLD = ITEMS.register("experience_gold", () -> new ExperienceItem(itemBuilder().rarity(Rarity.RARE), 2));
	public static final RegistryObject<Item> EXPERIENCE_DIAMOND = ITEMS.register("experience_diamond", () -> new ExperienceItem(itemBuilder().rarity(Rarity.RARE), 4));
	public static final RegistryObject<Item> FAN = ITEMS.register("fan", () -> new FanItem(itemBuilder()));
	public static final RegistryObject<Item> FAN_FIRE = ITEMS.register("fan_fire", () -> new FireFanItem(itemBuilder()));
	public static final RegistryObject<Item> FAN_ICE = ITEMS.register("fan_ice", () -> new IceFanItem(itemBuilder()));
	public static final RegistryObject<Item> FIRESHARD = ITEMS.register("fireshard", () -> new FireshardItem(itemBuilder()));
	public static final RegistryObject<Item> FUR = ITEMS.register("fur", () -> new Item(itemBuilder()));
	public static final RegistryObject<Item> GIGA_GEAR = ITEMS.register("giga_gear", () -> new GigaGearItem(itemBuilder().stacksTo(1).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> GOLDEN_APPLE_PIE = ITEMS.register("golden_apple_pie", () -> new XPEdibleItem(itemBuilder().stacksTo(1).food(GaiaFoods.GOLDEN_APPLY_PIE).rarity(Rarity.RARE), (rand) -> rand.nextInt(32) + 16));
	public static final RegistryObject<Item> GOLDEN_APPLE_PIE_SLICE = ITEMS.register("golden_apple_pie_slice", () -> new EdibleEffectItem(itemBuilder().stacksTo(64).food(GaiaFoods.GOLDEN_APPLY_PIE_SLICE).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> HONEYDEW = ITEMS.register("honeydew", () -> new HoneydewItem(itemBuilder().stacksTo(64).food(GaiaFoods.HONEYDEW).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> HEADGEAR_BOOK = ITEMS.register("headgear_book", () -> new HeadgearItem(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> HEADGEAR_MOB = ITEMS.register("headgear_mob", () -> new HeadgearItem(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> HEADGEAR_BOLT = ITEMS.register("headgear_bolt", () -> new HeadgearItem(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> HEADGEAR_ARROW = ITEMS.register("headgear_arrow", () -> new HeadgearItem(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> HEADGEAR_DOLL = ITEMS.register("headgear_doll", () -> new HeadgearItem(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> HEADGEAR_EARS_ELF = ITEMS.register("headgear_ears_elf", () -> new HeadgearItem(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> KNUCKLES = ITEMS.register("knuckles", () -> new KnucklesItem(itemBuilder()));
	public static final RegistryObject<Item> MEAT = ITEMS.register("meat", () -> new Item(itemBuilder().food(GaiaFoods.MEAT)));
	public static final RegistryObject<Item> METAL_DAGGER = ITEMS.register("metal_dagger", () -> new SwordItem(Tiers.IRON, 0, -3.0F, itemBuilder()));
	public static final RegistryObject<Item> QUILL = ITEMS.register("quill", () -> new Item(itemBuilder()));
	public static final RegistryObject<Item> ROTTEN_HEART = ITEMS.register("rotten_heart", () -> new EdibleEffectItem(itemBuilder().food(GaiaFoods.ROTTEN_HEART).stacksTo(1)));
	public static final RegistryObject<Item> SOULFIRE = ITEMS.register("soulfire", () -> new SoulfireItem(itemBuilder()));
	public static final RegistryObject<Item> STONE_COAL = ITEMS.register("stone_coal", () -> new FuelItem(itemBuilder(), 3600));
	public static final RegistryObject<Item> TAPROOT = ITEMS.register("taproot", () -> new TaprootItem(itemBuilder().food(GaiaFoods.TAPROOT)));
	public static final RegistryObject<Item> ZOMBIE_STAFF = ITEMS.register("zombie_staff", () -> new SummonStaffItem(itemBuilder().rarity(Rarity.RARE).durability(10), () -> EntityType.ZOMBIE));
	public static final RegistryObject<Item> SKELETON_STAFF = ITEMS.register("skeleton_staff", () -> new SummonStaffItem(itemBuilder().rarity(Rarity.RARE).durability(10), () -> EntityType.SKELETON));
	public static final RegistryObject<Item> CAVE_SPIDER_STAFF = ITEMS.register("cave_spider_staff", () -> new SummonStaffItem(itemBuilder().rarity(Rarity.RARE).durability(10), () -> EntityType.CAVE_SPIDER));
	public static final RegistryObject<Item> MAGIC_STAFF = ITEMS.register("magic_staff", () -> new MagicStaffItem(itemBuilder().rarity(Rarity.RARE).durability(64), () -> EntityType.CAVE_SPIDER));
	public static final RegistryObject<Item> PROJECTILE_MAGIC = ITEMS.register("projectile_magic", () -> new Item(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> PROJECTILE_WEB = ITEMS.register("projectile_web", () -> new Item(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> PROJECTILE_BOMB = ITEMS.register("projectile_bomb", () -> new BombItem(itemBuilder().stacksTo(1)));
	public static final RegistryObject<Item> PROJECTILE_POISON = ITEMS.register("projectile_poison", () -> new Item(itemBuilder().stacksTo(1)));

	public static final RegistryObject<Item> STONE_SHIELD = ITEMS.register("stone_shield", () -> new TieredShieldItem(itemBuilder().rarity(Rarity.UNCOMMON).durability(150), () -> Ingredient.of(Tags.Items.COBBLESTONE)));
	public static final RegistryObject<Item> IRON_SHIELD = ITEMS.register("iron_shield", () -> new TieredShieldItem(itemBuilder().rarity(Rarity.UNCOMMON).durability(336), () -> Ingredient.of(Tags.Items.INGOTS_IRON)));
	public static final RegistryObject<Item> GOLD_SHIELD = ITEMS.register("gold_shield", () -> new TieredShieldItem(itemBuilder().rarity(Rarity.UNCOMMON).durability(260), () -> Ingredient.of(Tags.Items.INGOTS_GOLD)));

	//Lootable Item
	public static final RegistryObject<Item> BAG_ARROWS = ITEMS.register("bag_arrows", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BAG_ARROW, GaiaSounds.BAG_OPEN::get));
	public static final RegistryObject<Item> BAG_BOOK = ITEMS.register("bag_book", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BAG_BOOK, GaiaSounds.BAG_OPEN::get));
	public static final RegistryObject<Item> BAG_RECORD = ITEMS.register("bag_record", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BAG_RECORD, GaiaSounds.BAG_OPEN::get));
	public static final RegistryObject<Item> BOX_DIAMOND = ITEMS.register("box_diamond", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BOXES_DIAMOND, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> BOX_END = ITEMS.register("box_end", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BOXES_END, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> BOX_GOLD = ITEMS.register("box_gold", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BOXES_GOLD, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> BOX_HAT = ITEMS.register("box_hat", () -> new LootableItem(itemBuilder(), GaiaLootTables.BOXES_HAT, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> BOX_IRON = ITEMS.register("box_iron", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BOXES_IRON, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> BOX_NETHER = ITEMS.register("box_nether", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BOXES_NETHER, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> BOX_OLD = ITEMS.register("box_old", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), GaiaLootTables.BOXES_OLD, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> BOX_OVERWORLD = ITEMS.register("box_overworld", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE).rarity(Rarity.RARE), GaiaLootTables.BOXES_OVERWORLD, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> CHEST_DESERT = ITEMS.register("chest_desert", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), BuiltInLootTables.DESERT_PYRAMID, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> CHEST_DUNGEON = ITEMS.register("chest_dungeon", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), BuiltInLootTables.SIMPLE_DUNGEON, GaiaSounds.BOX_OPEN::get));
	public static final RegistryObject<Item> CHEST_JUNGLE = ITEMS.register("chest_jungle", () -> new LootableItem(itemBuilder().rarity(Rarity.RARE), BuiltInLootTables.JUNGLE_TEMPLE, GaiaSounds.BOX_OPEN::get));

	private static Item.Properties itemBuilder() {
		return new Item.Properties().tab(GaiaTabs.GAIA_TAB);
	}
}
