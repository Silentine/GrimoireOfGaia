package gaia.proxy;

import gaia.GaiaReference;
import gaia.entity.monster.EntityDebugMob;
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
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.items.ItemGaiaSpawnEgg;
import gaia.renderer.RenderGaiaProjectileMagic;
import gaia.renderer.entity.RenderDebugMob;
import gaia.renderer.entity.RenderGaiaAnt;
import gaia.renderer.entity.RenderGaiaAnubis;
import gaia.renderer.entity.RenderGaiaArachne;
import gaia.renderer.entity.RenderGaiaBanshee;
import gaia.renderer.entity.RenderGaiaBaphomet;
import gaia.renderer.entity.RenderGaiaBoneKnight;
import gaia.renderer.entity.RenderGaiaCentaur;
import gaia.renderer.entity.RenderGaiaCobbleGolem;
import gaia.renderer.entity.RenderGaiaCobblestoneGolem;
import gaia.renderer.entity.RenderGaiaCreep;
import gaia.renderer.entity.RenderGaiaCyclops;
import gaia.renderer.entity.RenderGaiaDhampir;
import gaia.renderer.entity.RenderGaiaDryad;
import gaia.renderer.entity.RenderGaiaDullahan;
import gaia.renderer.entity.RenderGaiaDwarf;
import gaia.renderer.entity.RenderGaiaEnderDragonGirl;
import gaia.renderer.entity.RenderGaiaEnderEye;
import gaia.renderer.entity.RenderGaiaFleshLich;
import gaia.renderer.entity.RenderGaiaFutakuchiOnna;
import gaia.renderer.entity.RenderGaiaHarpy;
import gaia.renderer.entity.RenderGaiaHunter;
import gaia.renderer.entity.RenderGaiaKobold;
import gaia.renderer.entity.RenderGaiaMandragora;
import gaia.renderer.entity.RenderGaiaMatango;
import gaia.renderer.entity.RenderGaiaMermaid;
import gaia.renderer.entity.RenderGaiaMimic;
import gaia.renderer.entity.RenderGaiaMinotaur;
import gaia.renderer.entity.RenderGaiaMinotaurus;
import gaia.renderer.entity.RenderGaiaMummy;
import gaia.renderer.entity.RenderGaiaNPCCreeperGirl;
import gaia.renderer.entity.RenderGaiaNPCEnderGirl;
import gaia.renderer.entity.RenderGaiaNPCHolstaurus;
import gaia.renderer.entity.RenderGaiaNPCSlimeGirl;
import gaia.renderer.entity.RenderGaiaNPCTrader;
import gaia.renderer.entity.RenderGaiaNPCWeresheep;
import gaia.renderer.entity.RenderGaiaNaga;
import gaia.renderer.entity.RenderGaiaNineTails;
import gaia.renderer.entity.RenderGaiaPropChestMimic;
import gaia.renderer.entity.RenderGaiaPropFlowerCyan;
import gaia.renderer.entity.RenderGaiaSahuagin;
import gaia.renderer.entity.RenderGaiaSatyress;
import gaia.renderer.entity.RenderGaiaSelkie;
import gaia.renderer.entity.RenderGaiaShaman;
import gaia.renderer.entity.RenderGaiaSharko;
import gaia.renderer.entity.RenderGaiaSiren;
import gaia.renderer.entity.RenderGaiaSludgeGirl;
import gaia.renderer.entity.RenderGaiaSphinx;
import gaia.renderer.entity.RenderGaiaSpriggan;
import gaia.renderer.entity.RenderGaiaSuccubus;
import gaia.renderer.entity.RenderGaiaSummonButler;
import gaia.renderer.entity.RenderGaiaSummonSporeling;
import gaia.renderer.entity.RenderGaiaToad;
import gaia.renderer.entity.RenderGaiaValkyrie;
import gaia.renderer.entity.RenderGaiaVampire;
import gaia.renderer.entity.RenderGaiaWerecat;
import gaia.renderer.entity.RenderGaiaWitch;
import gaia.renderer.entity.RenderGaiaWitherCow;
import gaia.renderer.entity.RenderGaiaYeti;
import gaia.renderer.entity.RenderGaiaYukiOnna;
import gaia.renderer.particle.ParticleHandler;
import gaia.renderer.tileentity.TileRenderBustSphinx;
import gaia.renderer.tileentity.TileRenderBustValkyrie;
import gaia.renderer.tileentity.TileRenderBustVampire;
import gaia.renderer.tileentity.TileRenderDollCreeperGirl;
import gaia.renderer.tileentity.TileRenderDollEnderGirl;
import gaia.renderer.tileentity.TileRenderDollMaid;
import gaia.renderer.tileentity.TileRenderDollSlimeGirl;
import gaia.tileentity.TileEntityBustSphinx;
import gaia.tileentity.TileEntityBustValkyrie;
import gaia.tileentity.TileEntityBustVampire;
import gaia.tileentity.TileEntityDollCreeperGirl;
import gaia.tileentity.TileEntityDollEnderGirl;
import gaia.tileentity.TileEntityDollMaid;
import gaia.tileentity.TileEntityDollSlimeGirl;

import java.util.Locale;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	static RenderManager Randy = Minecraft.getMinecraft().getRenderManager();	
	static RenderItem Item = Minecraft.getMinecraft().getRenderItem();

	/**
	 * Registers entity renders
	 * <p>Shortcut method
	 * @param entityClass entity
	 * @param renderer renderer to assign
	 */
	public static void regMob (Class<? extends Entity> entityClass, Render<? extends Entity> renderer) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
	}

	//@Override	
	public void registerRenders() {
		super.registerRenders();

		register_entityRenders();
		item_reg.colorEggs();
	}

	@Override
	public void registerHandlers() {
		super.registerHandlers();

		MinecraftForge.EVENT_BUS.register(new ParticleHandler());
	}

	public void register_entityRenders() {	
		float tiny = 0.25F;
		float small = 0.4F;
		float med = 0.5F;
		float large = 0.7F;
		
		//Debug
		regMob(EntityDebugMob.class, new RenderDebugMob(small));
		//Mob
		regMob(EntityGaiaAnt.class, new RenderGaiaAnt(small));
		regMob(EntityGaiaAnubis.class, new RenderGaiaAnubis(small));
		regMob(EntityGaiaArachne.class, new RenderGaiaArachne(large));
		regMob(EntityGaiaBanshee.class, new RenderGaiaBanshee(med));
		regMob(EntityGaiaBaphomet.class, new RenderGaiaBaphomet(small));
		regMob(EntityGaiaBoneKnight.class, new RenderGaiaBoneKnight(med));
		regMob(EntityGaiaCreep.class, new RenderGaiaCreep(med));	
		regMob(EntityGaiaCentaur.class, new RenderGaiaCentaur(med));
		regMob(EntityGaiaCobbleGolem.class, new RenderGaiaCobbleGolem(large));
		regMob(EntityGaiaCobblestoneGolem.class, new RenderGaiaCobblestoneGolem(large));
		regMob(EntityGaiaCyclops.class, new RenderGaiaCyclops(small));
		regMob(EntityGaiaDhampir.class, new RenderGaiaDhampir(small));
		regMob(EntityGaiaDryad.class, new RenderGaiaDryad(small));
		regMob(EntityGaiaDullahan.class, new RenderGaiaDullahan(small));
		regMob(EntityGaiaDwarf.class, new RenderGaiaDwarf(large));
		regMob(EntityGaiaEnderDragonGirl.class, new RenderGaiaEnderDragonGirl(small));
		regMob(EntityGaiaEnderEye.class, new RenderGaiaEnderEye(small));
		regMob(EntityGaiaFleshLich.class, new RenderGaiaFleshLich(med));
		regMob(EntityGaiaFutakuchiOnna.class, new RenderGaiaFutakuchiOnna(small));
		regMob(EntityGaiaHarpy.class, new RenderGaiaHarpy(small));
		regMob(EntityGaiaHunter.class, new RenderGaiaHunter(small));
		regMob(EntityGaiaKobold.class, new RenderGaiaKobold(small));
		regMob(EntityGaiaMandragora.class, new RenderGaiaMandragora(tiny));
		regMob(EntityGaiaMatango.class, new RenderGaiaMatango(small));
		regMob(EntityGaiaMermaid.class, new RenderGaiaMermaid(small));
		regMob(EntityGaiaMimic.class, new RenderGaiaMimic(med));
		regMob(EntityGaiaMinotaur.class, new RenderGaiaMinotaur(large));
		regMob(EntityGaiaMinotaurus.class, new RenderGaiaMinotaurus(small));
		regMob(EntityGaiaMummy.class, new RenderGaiaMummy(small));
		regMob(EntityGaiaNaga.class, new RenderGaiaNaga(med));
		regMob(EntityGaiaNineTails.class, new RenderGaiaNineTails(small));
		//NPC
		regMob(EntityGaiaNPCCreeperGirl.class, new RenderGaiaNPCCreeperGirl(small));
		regMob(EntityGaiaNPCSlimeGirl.class, new RenderGaiaNPCSlimeGirl(small));	
		regMob(EntityGaiaNPCEnderGirl.class, new RenderGaiaNPCEnderGirl(small));
		regMob(EntityGaiaNPCTrader.class, new RenderGaiaNPCTrader(small));
		regMob(EntityGaiaNPCHolstaurus.class, new RenderGaiaNPCHolstaurus(small));
		regMob(EntityGaiaNPCWeresheep.class, new RenderGaiaNPCWeresheep(small));
		//Prop
		regMob(EntityGaiaPropChestMimic.class, new RenderGaiaPropChestMimic(0.0F));
		regMob(EntityGaiaPropFlowerCyan.class, new RenderGaiaPropFlowerCyan(0.0F));
		//Mob
		regMob(EntityGaiaSahuagin.class, new RenderGaiaSahuagin(small));
		regMob(EntityGaiaSatyress.class, new RenderGaiaSatyress(small));
		regMob(EntityGaiaSelkie.class, new RenderGaiaSelkie(small));
		regMob(EntityGaiaShaman.class, new RenderGaiaShaman(small));
		regMob(EntityGaiaSharko.class, new RenderGaiaSharko(large));
		regMob(EntityGaiaSiren.class, new RenderGaiaSiren(small));
		regMob(EntityGaiaSludgeGirl.class, new RenderGaiaSludgeGirl(small));
		regMob(EntityGaiaSphinx.class, new RenderGaiaSphinx(large));
		regMob(EntityGaiaSpriggan.class, new RenderGaiaSpriggan(small));
		regMob(EntityGaiaSuccubus.class, new RenderGaiaSuccubus(small));
		regMob(EntityGaiaSummonButler.class, new RenderGaiaSummonButler(small));
		regMob(EntityGaiaSummonSporeling.class, new RenderGaiaSummonSporeling(tiny));
		regMob(EntityGaiaToad.class, new RenderGaiaToad(med));
		regMob(EntityGaiaValkyrie.class, new RenderGaiaValkyrie(med));
		regMob(EntityGaiaVampire.class, new RenderGaiaVampire(med));
		regMob(EntityGaiaWerecat.class, new RenderGaiaWerecat(small));
		regMob(EntityGaiaWitch.class, new RenderGaiaWitch(med));
		regMob(EntityGaiaWitherCow.class, new RenderGaiaWitherCow(med));
		regMob(EntityGaiaYeti.class, new RenderGaiaYeti(large));
		regMob(EntityGaiaYukiOnna.class, new RenderGaiaYukiOnna(small));
		//Projectile
		regMob(EntityGaiaProjectileMagic.class, new RenderGaiaProjectileMagic(Randy, GaiaItems.PropWeaponProjectile, Item));
		//Block
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustSphinx.class, new TileRenderBustSphinx());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustValkyrie.class, new TileRenderBustValkyrie());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustVampire.class, new TileRenderBustVampire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollCreeperGirl.class, new TileRenderDollCreeperGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollEnderGirl.class, new TileRenderDollEnderGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollSlimeGirl.class, new TileRenderDollSlimeGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollMaid.class, new TileRenderDollMaid());
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpawnGuard.class, new TileRenderSpawnGuard());
	}

	@Override
	public void registerBlocksRender() {
		GaiaBlocks.registerRenders();
	}

	@Override
	public void registerItemsRender() {		
		item_reg.registerRenders();
		item_reg.registerRenders_meta();
	}

	/** 
	 * Register default Item Models 
	 */
	public static void registerRender(Item item) {		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GaiaReference.MOD_PATH+ item.getUnlocalizedName().substring(5).toLowerCase(Locale.US), "inventory"));
	}

	/**
	 * Register Item Model for meta data reliant objects
	 * <p>Shortcut method
	 * @param pathname item filename that is nested in grimoireofgaia:textures/items/<pathname>
	 */
	public static void reg_Meta(Item item, int metadata, String pathname) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(GaiaReference.MOD_PATH+pathname.toLowerCase(), "inventory"));	
	}

	/** 
	 * Registry for item models 
	 */
	public static class item_reg extends GaiaItems {

		public static void registerRenders() {
			registerRender(Shard);				
			registerRender(FoodMeat);
			registerRender(FoodRottenHeart);
			registerRender(FoodRoot);
			registerRender(FoodCoalfish);
			registerRender(FoodNetherWart);
			registerRender(FoodSmallAppleGold);
			registerRender(FoodExperience);
			registerRender(FoodMandrake);
			registerRender(FoodWither);
			registerRender(FoodPieMandrake);
			registerRender(FoodPieMeat);
			registerRender(FoodPieAppleGold);
			registerRender(MiscSoulFire);
			registerRender(MiscSoulFiery);
			registerRender(MiscGigaGear);
			registerRender(MiscFur);
			registerRender(MiscBook);
			registerRender(MiscQuill);
			registerRender(MiscRing);
			registerRender(MiscFurnaceFuel);
			registerRender(MiscCurrency);
			registerRender(Spawn);
			registerRender(SpawnCreeperGirl);
			registerRender(SpawnSlimeGirl);
			registerRender(SpawnEnderGirl);
			registerRender(SpawnTrader);
			registerRender(SpawnHolstaurus);
			registerRender(SpawnWeresheep);
			registerRender(SpawnTame);
			registerRender(BoxIron);
			registerRender(BoxGold);
			registerRender(BoxDiamond);
			registerRender(BagOre);
			registerRender(BagBook);
			registerRender(BagRecord);
			registerRender(BoxOld);
			registerRender(PropWeapon);
			registerRender(PropWeaponProjectile);
			registerRender(PropWeaponEnchanted);
			registerRender(FanIce);
			registerRender(FanFire);
			registerRender(BookFreezing);
			registerRender(BookNightmare);
			registerRender(BookMetal);
			registerRender(BookEnder);
			registerRender(BookHunger);
			registerRender(BookBattle);
			registerRender(BookNature);
			registerRender(BookWither);
			registerRender(BookBuff);
			registerRender(Debug);
			registerRender(AccessoryRingSpeed);
			registerRender(AccessoryRingHaste);
			registerRender(AccessoryRingJump);
			registerRender(AccessoryRingNight);		
			registerRender(AccessoryCursed);
			registerRender(SpawnEgg);
		}

		public static void registerRenders_meta() {

			// Shards
			reg_Meta(Shard, 0, "ShardIron");
			reg_Meta(Shard, 1, "ShardGold");
			reg_Meta(Shard, 2, "ShardDiamond");
			reg_Meta(Shard, 3, "ShardEmerald");        
			reg_Meta(Shard, 4, "ShardCopper");
			reg_Meta(Shard, 5, "ShardSilver");

			// Misc Ring
			reg_Meta(MiscRing, 0, "MiscRingSpeed");
			reg_Meta(MiscRing, 1, "MiscRingHaste");
			reg_Meta(MiscRing, 2, "MiscRingJump");
			reg_Meta(MiscRing, 3, "MiscRingNight");

			// Misc Currency
			reg_Meta(MiscCurrency, 0, "MiscCurrency_0");
			reg_Meta(MiscCurrency, 1, "MiscCurrency_1");
			reg_Meta(MiscCurrency, 2, "MiscCurrency_2");
			reg_Meta(MiscCurrency, 3, "MiscCurrency_3");

			// Prop Weapon
			reg_Meta(PropWeapon, 0, "WeaponPropEnder");
			reg_Meta(PropWeapon, 1, "WeaponPropBlaze");
			reg_Meta(PropWeapon, 2, "WeaponPropSpear");
			reg_Meta(PropWeapon, 3, "WeaponPropDagger");
			reg_Meta(PropWeapon, 4, "WeaponPropFan");
			
			// Prop Projectile
			reg_Meta(PropWeaponProjectile, 0, "WeaponPropProjectile");

			// Should get it's list count to iterate through dynamically in the future
			for (int i = 0; i < 52; ++i) {
				ModelLoader.setCustomModelResourceLocation(SpawnEgg, i, new ModelResourceLocation("minecraft:spawn_egg", "inventory"));
			}

			ModelLoader.setCustomModelResourceLocation(SpawnEgg, 200, new ModelResourceLocation("minecraft:spawn_egg", "inventory"));
		}

		public static void colorEggs() {
			Minecraft.getMinecraft().getItemColors().registerItemColorHandler(ItemGaiaSpawnEgg.getItemColor(), GaiaItems.SpawnEgg);
		}
	}
}
