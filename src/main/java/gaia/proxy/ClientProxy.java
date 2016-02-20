package gaia.proxy;

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
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaJorogumo;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyr;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaSummonButler;
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
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.init.GaiaBlock;
import gaia.init.GaiaItem;
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
import gaia.renderer.RenderGaiaFleshLich;
import gaia.renderer.RenderGaiaFutakuchiOnna;
import gaia.renderer.RenderGaiaGryphon;
import gaia.renderer.RenderGaiaHarpy;
import gaia.renderer.RenderGaiaHunter;
import gaia.renderer.RenderGaiaJorogumo;
import gaia.renderer.RenderGaiaKobold;
import gaia.renderer.RenderGaiaMandragora;
import gaia.renderer.RenderGaiaMermaid;
import gaia.renderer.RenderGaiaMimic;
import gaia.renderer.RenderGaiaMinotaur;
import gaia.renderer.RenderGaiaNPCCreeperGirl;
import gaia.renderer.RenderGaiaNPCEnderGirl;
import gaia.renderer.RenderGaiaNPCHolstaurus;
import gaia.renderer.RenderGaiaNPCTrader;
import gaia.renderer.RenderGaiaNaga;
import gaia.renderer.RenderGaiaNineTails;
import gaia.renderer.RenderGaiaSahuagin;
import gaia.renderer.RenderGaiaSatyr;
import gaia.renderer.RenderGaiaShaman;
import gaia.renderer.RenderGaiaSharko;
import gaia.renderer.RenderGaiaSiren;
import gaia.renderer.RenderGaiaSphinx;
import gaia.renderer.RenderGaiaSpriggan;
import gaia.renderer.RenderGaiaSuccubus;
import gaia.renderer.RenderGaiaSummonButler;
import gaia.renderer.RenderGaiaSwamper;
import gaia.renderer.RenderGaiaValkyrie;
import gaia.renderer.RenderGaiaVampire;
import gaia.renderer.RenderGaiaWerecat;
import gaia.renderer.RenderGaiaWitch;
import gaia.renderer.RenderGaiaWitherCow;
import gaia.renderer.RenderGaiaYeti;
import gaia.renderer.RenderGaiaYukiOnna;
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
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	//@Override	
	public void registerRenders(){
		
		super.registerRenders();
		
		
		/**	MOVED GaiaItem.registerRenders(); TO REGISTER ITEM RENDERER BELOW**/
		GaiaBlock.registerRenders();	
		
		float tiny = 0.25F;
		float small = 0.4F;
		float med = 0.5F;
		float large = 0.7F;
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaAnubis.class, new RenderGaiaAnubis(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBaphomet.class, new RenderGaiaBaphomet(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCockatrice.class, new RenderGaiaCockatrice(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSharko.class, new RenderGaiaSharko(large));		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDullahan.class, new RenderGaiaDullahan(small));		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaShaman.class, new RenderGaiaShaman(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaKobold.class, new RenderGaiaKobold(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBoneKnight.class, new RenderGaiaBoneKnight(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitherCow.class, new RenderGaiaWitherCow(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaFutakuchiOnna.class, new RenderGaiaFutakuchiOnna(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNaga.class, new RenderGaiaNaga(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSahuagin.class, new RenderGaiaSahuagin(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSiren.class, new RenderGaiaSiren(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSpriggan.class, new RenderGaiaSpriggan(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSummonButler.class, new RenderGaiaSummonButler(small));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCreep.class, new RenderGaiaCreep(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDhampir.class, new RenderGaiaDhampir(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaJorogumo.class, new RenderGaiaJorogumo(large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMimic.class, new RenderGaiaMimic(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMinotaur.class, new RenderGaiaMinotaur(large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaVampire.class, new RenderGaiaVampire(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWerecat.class, new RenderGaiaWerecat(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBanshee.class, new RenderGaiaBanshee(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCentaur.class, new RenderGaiaCentaur(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSphinx.class, new RenderGaiaSphinx(large));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYeti.class, new RenderGaiaYeti(large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYukiOnna.class, new RenderGaiaYukiOnna(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSuccubus.class, new RenderGaiaSuccubus(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSwamper.class, new RenderGaiaSwamper(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNineTails.class, new RenderGaiaNineTails(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHarpy.class, new RenderGaiaHarpy(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHunter.class, new RenderGaiaHunter(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaFleshLich.class, new RenderGaiaFleshLich(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSatyr.class, new RenderGaiaSatyr(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaGryphon.class, new RenderGaiaGryphon(large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDryad.class, new RenderGaiaDryad(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCyclops.class, new RenderGaiaCyclops(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMermaid.class, new RenderGaiaMermaid(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaValkyrie.class, new RenderGaiaValkyrie(med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobbleGolem.class, new RenderGaiaCobbleGolem(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobblestoneGolem.class, new RenderGaiaCobblestoneGolem(large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitch.class, new RenderGaiaWitch(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMandragora.class, new RenderGaiaMandragora(tiny));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCCreeperGirl.class, new RenderGaiaNPCCreeperGirl(small));		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCHolstaurus.class, new RenderGaiaNPCHolstaurus(small));		
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCTrader.class, new RenderGaiaNPCTrader(small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCEnderGirl.class, new RenderGaiaNPCEnderGirl(small));
		
		/*RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBanshee.class, new RenderGaiaBanshee());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBaphomet.class, new RenderGaiaBaphomet());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBoneKnight.class, new RenderGaiaBoneKnight());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSummonButler.class, new RenderGaiaSummonButler());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCreep.class, new RenderGaiaCreep());	
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCentaur.class, new RenderGaiaCentaur());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobbleGolem.class, new RenderGaiaCobbleGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobblestoneGolem.class, new RenderGaiaCobblestoneGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCockatrice.class, new RenderGaiaCockatrice());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCyclops.class, new RenderGaiaCyclops());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDhampir.class, new RenderGaiaDhampir());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDryad.class, new RenderGaiaDryad());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDullahan.class, new RenderGaiaDullahan());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaEnderDragonGirl.class, new RenderGaiaEnderDragonGirl());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaEnderEye.class, new RenderGaiaEnderEye());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaFleshLich.class, new RenderGaiaFleshLich());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaFutakuchiOnna.class, new RenderGaiaFutakuchiOnna());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaPropFlowerCyan.class, new RenderGaiaPropFlowerCyan());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaGryphon.class, new RenderGaiaGryphon());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaJorogumo.class, new RenderGaiaJorogumo());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaKobold.class, new RenderGaiaKobold());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHarpy.class, new RenderGaiaHarpy());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHunter.class, new RenderGaiaHunter());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMandragora.class, new RenderGaiaMandragora());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMermaid.class, new RenderGaiaMermaid());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMimic.class, new RenderGaiaMimic());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMinotaur.class, new RenderGaiaMinotaur());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMinotaurus.class, new RenderGaiaMinotaurus());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNaga.class, new RenderGaiaNaga());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNineTails.class, new RenderGaiaNineTails());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCCreeperGirl.class, new RenderGaiaNPCCreeperGirl());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCEnderGirl.class, new RenderGaiaNPCEnderGirl());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCHolstaurus.class, new RenderGaiaNPCHolstaurus());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCSlimeGirl.class, new RenderGaiaNPCSlimeGirl());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCTrader.class, new RenderGaiaNPCTrader());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSahuagin.class, new RenderGaiaSahuagin());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSatyr.class, new RenderGaiaSatyr());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSelkie.class, new RenderGaiaSelkie());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaShaman.class, new RenderGaiaShaman());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSharko.class, new RenderGaiaSharko());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSiren.class, new RenderGaiaSiren());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSludgeGirl.class, new RenderGaiaSludgeGirl());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSphinx.class, new RenderGaiaSphinx());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSpriggan.class, new RenderGaiaSpriggan());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSuccubus.class, new RenderGaiaSuccubus());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSwamper.class, new RenderGaiaSwamper());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaValkyrie.class, new RenderGaiaValkyrie());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaVampire.class, new RenderGaiaVampire());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWerecat.class, new RenderGaiaWerecat());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitch.class, new RenderGaiaWitch());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitherCow.class, new RenderGaiaWitherCow());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYeti.class, new RenderGaiaYeti());
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYukiOnna.class, new RenderGaiaYukiOnna());

		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaProjectileMagic.class, new RenderGaiaProjectileMagic(1));
		*/
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustSphinx.class, new TileRenderBustSphinx());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustValkyrie.class, new TileRenderBustValkyrie());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustVampire.class, new TileRenderBustVampire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollCreeperGirl.class, new TileRenderDollCreeperGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollEnderGirl.class, new TileRenderDollEnderGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollSlimeGirl.class, new TileRenderDollSlimeGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollMaid.class, new TileRenderDollMaid());
		/*
	    /*MinecraftForgeClient.registerItemRenderer(GaiaItem.BookFreezing, new RenderWeaponBookFreezing());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookNightmare, new RenderWeaponBookNightmare());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookMetal, new RenderWeaponBookMetal());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookEnder, new RenderWeaponBookEnder());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookHunger, new RenderWeaponBookHunger());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookBattle, new RenderWeaponBookBattle());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookNature, new RenderWeaponBookNature());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookWither, new RenderWeaponBookWither());
	    MinecraftForgeClient.registerItemRenderer(GaiaItem.BookBuff, new RenderWeaponBookBuff());*/
	}
		
	@Override
	public void registerItemsRender(){
		
		GaiaItem.registerRenders();
		
		
		// Shards
		ModelLoader.setCustomModelResourceLocation(GaiaItem.Shard, 0, new ModelResourceLocation("gaia:ShardIron", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.Shard, 1, new ModelResourceLocation("gaia:ShardGold", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.Shard, 2, new ModelResourceLocation("gaia:ShardDiamond", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.Shard, 3, new ModelResourceLocation("gaia:ShardEmerald", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.Shard, 4, new ModelResourceLocation("gaia:ShardNetherStar", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.Shard, 5, new ModelResourceLocation("gaia:ShardEnderPearl", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.Shard, 6, new ModelResourceLocation("gaia:ShardBlazeRod", "inventory"));
        
        // Misc Ring
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscRing, 0, new ModelResourceLocation("gaia:MiscRingSpeed", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscRing, 1, new ModelResourceLocation("gaia:MiscRingHaste", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscRing, 2, new ModelResourceLocation("gaia:MiscRingJump", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscRing, 3, new ModelResourceLocation("gaia:MiscRingNight", "inventory"));
        
        // Misc Currency
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscCurrency, 0, new ModelResourceLocation("gaia:MiscCurrency", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscCurrency, 1, new ModelResourceLocation("gaia:MiscCurrencyMulti", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscCurrency, 2, new ModelResourceLocation("gaia:MiscCurrencyExtra", "inventory"));
        
     // Misc Enchanted Weapon
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscWeaponEnchanted, 0, new ModelResourceLocation("gaia:MiscWeaponFanIce", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.MiscWeaponEnchanted, 1, new ModelResourceLocation("gaia:MiscWeaponFanFire", "inventory"));
        
        // Prop Weapon
        ModelLoader.setCustomModelResourceLocation(GaiaItem.PropWeapon, 0, new ModelResourceLocation("gaia:WeaponPropEnder", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.PropWeapon, 1, new ModelResourceLocation("gaia:WeaponPropBlaze", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.PropWeapon, 2, new ModelResourceLocation("gaia:WeaponPropSpear", "inventory"));
        ModelLoader.setCustomModelResourceLocation(GaiaItem.PropWeapon, 3, new ModelResourceLocation("gaia:WeaponPropDagger", "inventory"));
	}
}
