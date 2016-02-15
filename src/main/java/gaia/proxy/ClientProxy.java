package gaia.proxy;

import gaia.init.GaiaItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders(){
		//GaiaBlock.registerRenders();
		GaiaItem.registerRenders();
		//RenderingRegistry.registerEntityRenderingHandler(EntityGaiaAnubis.class, new RenderGaiaAnubis());
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
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustSphinx.class, new TileRenderBustSphinx());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustValkyrie.class, new TileRenderBustValkyrie());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustVampire.class, new TileRenderBustVampire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollCreeperGirl.class, new TileRenderDollCreeperGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollEnderGirl.class, new TileRenderDollEnderGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollSlimeGirl.class, new TileRenderDollSlimeGirl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollMaid.class, new TileRenderDollMaid());*/
		
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
	}
}
