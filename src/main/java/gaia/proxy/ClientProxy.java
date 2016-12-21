package gaia.proxy;

import gaia.GaiaReference;
import gaia.entity.monster.EntityExampleMob;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCockatrice;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaJorogumo;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyr;
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
import gaia.entity.monster.EntityGaiaSwamper;
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
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.init.GaiaBlock;
import gaia.init.GaiaItem;
import gaia.items.ItemGaiaSpawnEgg;
import gaia.renderer.RenderExampleMob;
import gaia.renderer.RenderGaiaAnubis;
import gaia.renderer.RenderGaiaBanshee;
import gaia.renderer.RenderGaiaBaphomet;
import gaia.renderer.RenderGaiaBoneKnight;
import gaia.renderer.RenderGaiaCentaur;
import gaia.renderer.RenderGaiaCobbleGolem;
import gaia.renderer.RenderGaiaCobblestoneGolem;
import gaia.renderer.RenderGaiaCockatrice;
import gaia.renderer.RenderGaiaCreep;
import gaia.renderer.RenderGaiaCyclops;
import gaia.renderer.RenderGaiaDhampir;
import gaia.renderer.RenderGaiaDryad;
import gaia.renderer.RenderGaiaDullahan;
import gaia.renderer.RenderGaiaEnderDragonGirl;
import gaia.renderer.RenderGaiaEnderEye;
import gaia.renderer.RenderGaiaFleshLich;
import gaia.renderer.RenderGaiaFutakuchiOnna;
import gaia.renderer.RenderGaiaGryphon;
import gaia.renderer.RenderGaiaHarpy;
import gaia.renderer.RenderGaiaHunter;
import gaia.renderer.RenderGaiaJorogumo;
import gaia.renderer.RenderGaiaMandragora;
import gaia.renderer.RenderGaiaMatango;
import gaia.renderer.RenderGaiaMermaid;
import gaia.renderer.RenderGaiaMimic;
import gaia.renderer.RenderGaiaMinotaur;
import gaia.renderer.RenderGaiaMinotaurus;
import gaia.renderer.RenderGaiaNPCCreeperGirl;
import gaia.renderer.RenderGaiaNPCEnderGirl;
import gaia.renderer.RenderGaiaNPCHolstaurus;
import gaia.renderer.RenderGaiaNPCSlimeGirl;
import gaia.renderer.RenderGaiaNPCTrader;
import gaia.renderer.RenderGaiaNPCWeresheep;
import gaia.renderer.RenderGaiaNaga;
import gaia.renderer.RenderGaiaNineTails;
import gaia.renderer.RenderGaiaProjectileMagic;
import gaia.renderer.RenderGaiaPropFlowerCyan;
import gaia.renderer.RenderGaiaSahuagin;
import gaia.renderer.RenderGaiaSatyr;
import gaia.renderer.RenderGaiaSelkie;
import gaia.renderer.RenderGaiaShaman;
import gaia.renderer.RenderGaiaSharko;
import gaia.renderer.RenderGaiaSiren;
import gaia.renderer.RenderGaiaSludgeGirl;
import gaia.renderer.RenderGaiaSphinx;
import gaia.renderer.RenderGaiaSpriggan;
import gaia.renderer.RenderGaiaSuccubus;
import gaia.renderer.RenderGaiaSummonButler;
import gaia.renderer.RenderGaiaSummonSporeling;
import gaia.renderer.RenderGaiaSwamper;
import gaia.renderer.RenderGaiaValkyrie;
import gaia.renderer.RenderGaiaVampire;
import gaia.renderer.RenderGaiaWerecat;
import gaia.renderer.RenderGaiaWitch;
import gaia.renderer.RenderGaiaWitherCow;
import gaia.renderer.RenderGaiaYeti;
import gaia.renderer.RenderGaiaYukiOnna;
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
	
	/**Register Entity Renders
	 * Shortcut method
	 * @param entityClass The Entity
	 * @param renderer The Renderer to assign**/
	public static void reg_Mob (Class<? extends Entity> entityClass, Render<? extends Entity> renderer){
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
	}
		
	//@Override	
	public void registerRenders(){
		super.registerRenders();
		
		register_entityRenders();
		item_reg.colorEggs();
	}
	
	@Override
	public void registerHandlers(){
		super.registerHandlers();
		
		MinecraftForge.EVENT_BUS.register(new ParticleHandler());
	}
	
	
	public void register_entityRenders(){	
		float tiny = 0.25F;
		float small = 0.4F;
		float med = 0.5F;
		float large = 0.7F;
		
		reg_Mob(EntityGaiaAnubis.class, new RenderGaiaAnubis(small));
		reg_Mob(EntityGaiaBanshee.class, new RenderGaiaBanshee(med));
		reg_Mob(EntityGaiaBaphomet.class, new RenderGaiaBaphomet(small));
		reg_Mob(EntityGaiaBoneKnight.class, new RenderGaiaBoneKnight(med));
		reg_Mob(EntityGaiaCreep.class, new RenderGaiaCreep(med));	
		reg_Mob(EntityGaiaCentaur.class, new RenderGaiaCentaur(med));
		reg_Mob(EntityGaiaCobbleGolem.class, new RenderGaiaCobbleGolem(large));
		reg_Mob(EntityGaiaCobblestoneGolem.class, new RenderGaiaCobblestoneGolem(large));
		reg_Mob(EntityGaiaCockatrice.class, new RenderGaiaCockatrice(small));
		reg_Mob(EntityGaiaCyclops.class, new RenderGaiaCyclops(small));
		reg_Mob(EntityGaiaDhampir.class, new RenderGaiaDhampir(small));
		reg_Mob(EntityGaiaDryad.class, new RenderGaiaDryad(small));
		reg_Mob(EntityGaiaDullahan.class, new RenderGaiaDullahan(small));
		reg_Mob(EntityGaiaEnderDragonGirl.class, new RenderGaiaEnderDragonGirl(small));
		reg_Mob(EntityGaiaEnderEye.class, new RenderGaiaEnderEye(small));
		reg_Mob(EntityGaiaFleshLich.class, new RenderGaiaFleshLich(med));
		reg_Mob(EntityGaiaFutakuchiOnna.class, new RenderGaiaFutakuchiOnna(small));
		reg_Mob(EntityGaiaPropFlowerCyan.class, new RenderGaiaPropFlowerCyan(0.0F));
		reg_Mob(EntityGaiaGryphon.class, new RenderGaiaGryphon(large));
		reg_Mob(EntityGaiaJorogumo.class, new RenderGaiaJorogumo(large));
		reg_Mob(EntityGaiaHarpy.class, new RenderGaiaHarpy(small));
		reg_Mob(EntityGaiaHunter.class, new RenderGaiaHunter(small));
		reg_Mob(EntityGaiaMandragora.class, new RenderGaiaMandragora(tiny));
		reg_Mob(EntityGaiaMatango.class, new RenderGaiaMatango(small));
		reg_Mob(EntityGaiaMermaid.class, new RenderGaiaMermaid(small));
		reg_Mob(EntityGaiaMimic.class, new RenderGaiaMimic(med));
		reg_Mob(EntityGaiaMinotaur.class, new RenderGaiaMinotaur(large));
		reg_Mob(EntityGaiaMinotaurus.class, new RenderGaiaMinotaurus(small));
		reg_Mob(EntityGaiaNaga.class, new RenderGaiaNaga(med));
		reg_Mob(EntityGaiaNineTails.class, new RenderGaiaNineTails(small));
		
		reg_Mob(EntityExampleMob.class, new RenderExampleMob(small));
		
		reg_Mob(EntityGaiaNPCCreeperGirl.class, new RenderGaiaNPCCreeperGirl(small));
		reg_Mob(EntityGaiaNPCSlimeGirl.class, new RenderGaiaNPCSlimeGirl(small));	
		reg_Mob(EntityGaiaNPCEnderGirl.class, new RenderGaiaNPCEnderGirl(small));
		reg_Mob(EntityGaiaNPCTrader.class, new RenderGaiaNPCTrader(small));
		reg_Mob(EntityGaiaNPCHolstaurus.class, new RenderGaiaNPCHolstaurus(small));
		reg_Mob(EntityGaiaNPCWeresheep.class, new RenderGaiaNPCWeresheep(small));
	
		reg_Mob(EntityGaiaSahuagin.class, new RenderGaiaSahuagin(small));
		reg_Mob(EntityGaiaSatyr.class, new RenderGaiaSatyr(small));
		reg_Mob(EntityGaiaSelkie.class, new RenderGaiaSelkie(small));
		reg_Mob(EntityGaiaShaman.class, new RenderGaiaShaman(small));
		reg_Mob(EntityGaiaSharko.class, new RenderGaiaSharko(large));
		reg_Mob(EntityGaiaSiren.class, new RenderGaiaSiren(small));
		reg_Mob(EntityGaiaSludgeGirl.class, new RenderGaiaSludgeGirl(small));
		reg_Mob(EntityGaiaSphinx.class, new RenderGaiaSphinx(large));
		reg_Mob(EntityGaiaSpriggan.class, new RenderGaiaSpriggan(small));
		reg_Mob(EntityGaiaSuccubus.class, new RenderGaiaSuccubus(small));
		reg_Mob(EntityGaiaSummonButler.class, new RenderGaiaSummonButler(small));
		reg_Mob(EntityGaiaSummonSporeling.class, new RenderGaiaSummonSporeling(tiny));
		reg_Mob(EntityGaiaSwamper.class, new RenderGaiaSwamper(med));
		reg_Mob(EntityGaiaValkyrie.class, new RenderGaiaValkyrie(med));
		reg_Mob(EntityGaiaVampire.class, new RenderGaiaVampire(med));
		reg_Mob(EntityGaiaWerecat.class, new RenderGaiaWerecat(small));
		reg_Mob(EntityGaiaWitch.class, new RenderGaiaWitch(med));
		reg_Mob(EntityGaiaWitherCow.class, new RenderGaiaWitherCow(med));
		reg_Mob(EntityGaiaYeti.class, new RenderGaiaYeti(large));
		reg_Mob(EntityGaiaYukiOnna.class, new RenderGaiaYukiOnna(small));

		reg_Mob(EntityGaiaProjectileMagic.class, new RenderGaiaProjectileMagic(Randy, GaiaItem.PropWeapon, Item));
				
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustSphinx.class, new TileRenderBustSphinx());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustValkyrie.class, new TileRenderBustValkyrie());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustVampire.class, new TileRenderBustVampire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollCreeperGirl.class, new TileRenderDollCreeperGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollEnderGirl.class, new TileRenderDollEnderGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollSlimeGirl.class, new TileRenderDollSlimeGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollMaid.class, new TileRenderDollMaid());
		
		//TODO Fix 1st Person 3D items
	    /*
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookFreezing, new RenderWeaponBookFreezing());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookNightmare, new RenderWeaponBookNightmare());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookMetal, new RenderWeaponBookMetal());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookEnder, new RenderWeaponBookEnder());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookHunger, new RenderWeaponBookHunger());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookBattle, new RenderWeaponBookBattle());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookNature, new RenderWeaponBookNature());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookWither, new RenderWeaponBookWither());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookBuff, new RenderWeaponBookBuff());
	    */
	}
	
	
	
	
	@Override
	public void registerBlocksRender(){
		GaiaBlock.registerRenders();
	}
	
	@Override
	public void registerItemsRender(){		
		item_reg.registerRenders();
		item_reg.registerRenders_meta();
	}
	
	/** Register default Item Models **/
	public static void registerRender(Item item) {		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GaiaReference.MOD_PATH+ item.getUnlocalizedName().substring(5).toLowerCase(Locale.US), "inventory"));
	}
	
	/**Register Item Model for meta data reliant objects
	 * Shortcut method
	 * @param pathname item filename that is nested in grimoireofgaia:textures/items/<pathname>**/
	public static void reg_Meta(Item item, int metadata, String pathname){
			ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(GaiaReference.MOD_PATH+pathname.toLowerCase(), "inventory"));	
	}
		
	/** Registry for item models **/
	public static class item_reg extends GaiaItem{
	
		public static void registerRenders() {
			registerRender(Shard);				
			registerRender(FoodMeat);
			registerRender(FoodRottenHeart);
			registerRender(FoodRoot);
			registerRender(FoodIce);
			registerRender(FoodCoalfish);
			registerRender(FoodNetherWart);
			registerRender(FoodSmallAppleGold);
			registerRender(FoodMandrake);
			registerRender(FoodWither);
			registerRender(FoodPieMandrake);
			registerRender(FoodPieMeat);
			registerRender(FoodPieAppleGold);
			registerRender(MiscSoulFire);
			registerRender(MiscSoulFiery);
			registerRender(MiscGigaGear);
			registerRender(MiscBook);
			registerRender(MiscRing);
			registerRender(MiscFurnaceFuel);
			registerRender(MiscCurrency);
			registerRender(MiscWeaponEnchanted);
			registerRender(Spawn);
			registerRender(SpawnCreeperGirl);
			registerRender(SpawnSlimeGirl);
			registerRender(SpawnEnderGirl);
			registerRender(SpawnTrader);
			registerRender(SpawnHolstaurus);
			registerRender(SpawnWeresheep);
			registerRender(BoxIron);
			registerRender(BoxGold);
			registerRender(BoxDiamond);
			registerRender(BagOre);
			registerRender(BagBook);
			registerRender(BagRecord);
			registerRender(BoxOld);
			registerRender(PropWeapon);
			registerRender(PropWeaponInvisible);
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
        
        // Misc Enchanted Weapon
        reg_Meta(MiscWeaponEnchanted, 0, "MiscWeaponFanIce");
        reg_Meta(MiscWeaponEnchanted, 1, "MiscWeaponFanFire");
       
        // Prop Weapon
        reg_Meta(PropWeapon, 0, "WeaponPropEnder");
        reg_Meta(PropWeapon, 1, "WeaponPropBlaze");
        reg_Meta(PropWeapon, 2, "WeaponPropSpear");
        reg_Meta(PropWeapon, 3, "WeaponPropDagger");
        reg_Meta(PropWeapon, 4, "WeaponPropProjectile");
        
        // Should get it's list count to iterate through dynamically in the future
        for (int i = 0; i < 52; ++i) {
        	ModelLoader.setCustomModelResourceLocation(SpawnEgg, i, new ModelResourceLocation("minecraft:spawn_egg", "inventory"));
        }
        ModelLoader.setCustomModelResourceLocation(SpawnEgg, 200, new ModelResourceLocation("minecraft:spawn_egg", "inventory"));
        
		}
      
	
	public static void colorEggs(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(ItemGaiaSpawnEgg.getItemColor(), GaiaItem.SpawnEgg);
		}
	}
}
