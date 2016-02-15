package gaia;

import gaia.init.GaiaConfigGeneration;
import gaia.init.GaiaItem;
import gaia.items.GaiaItemHandlerFuel;
import gaia.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
		modid = GaiaReference.MOD_ID, 
		name = GaiaReference.MOD_NAME, 
		version = GaiaReference.VERSION)
/*
@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
		)
*/

public class Gaia 
{
	@Instance(GaiaReference.MOD_ID)
	public static Gaia instance = new Gaia();
	@SidedProxy
	(clientSide = GaiaReference.CLIENT_PROXY_CLASS, 
	serverSide = GaiaReference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static CreativeTabs tabGaia = new CreativeTabs("tabGaia") 
	{
		@Override
		public Item getTabIconItem() {
			return GaiaItem.FoodBerryHealth;
		}

	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
    	GaiaConfigGeneration.configOptions(cfg);
		
		//GaiaBlock.init();
    	GaiaItem.init();
    	GaiaItem.register();
    	GaiaItem.oreRegistration();
		//proxy.registerRenderingFactories();
    	proxy.registerRenders();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) 
	{

		GameRegistry.registerFuelHandler(new GaiaItemHandlerFuel());
		GaiaItem.addRecipes();
		
		/*ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaEntity.class, 0, body, spots);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaAnubis.class, 1, 0x353535, 0xb19534);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaBanshee.class, 2, 0xeed2e8, 0xc6b0ed);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaBaphomet.class, 3, 3559756, 14197864);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaBoneKnight.class, 4, 4602533, 13619151);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCentaur.class, 5, 0x8d4f41, 0x353535);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCobbleGolem.class, 6, 11513775, 11513775);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCobblestoneGolem.class, 7, 11513775, 11513775);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCockatrice.class, 8, 0xc9b161, 0xe2e2e2);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCreep.class, 9, 7917159, 2053400);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCyclops.class, 10, 4936602, 3487029);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaDhampir.class, 11, 0x9c1c2b, 0xc9b161);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaDryad.class, 12, 10255437, 5681460);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaDullahan.class, 13, 0x824fab, 0xa4452d);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaEnderDragonGirl.class, 14, 3158064, 14711290);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaEnderEye.class, 15, 2039583, 3158064);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaFleshLich.class, 17, 0x00cccc, 0x799c65);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaPropFlowerCyan.class, 16, 1073920, 4045287);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaFutakuchiOnna.class, 19, 0x4e3738, 0xb43434);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaGryphon.class, 18, 0xf09942, 0xe2e2e2);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaHarpy.class, 21, 0xc9b161, 0xa5884e);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaHunter.class, 20, 0xae6b3c, 0x353535);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaJorogumo.class, 23, 3815994, 11013646);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaKobold.class, 22, 0x73718d, 0xdec89e);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMermaid.class, 25, 0x5c70b1, 0xa4452d);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMimic.class, 24, 11237677, 4274991);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMinotaur.class, 27, 0x8d4f41, 0xd54242);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMinotaurus.class, 29, 0x8d4f41, 0xa9a9a9);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaNaga.class, 28, 0x29bc55, 0xccb63f);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaNineTails.class, 31, 11809844, 13218145);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSahuagin.class, 30, 0x5c70b1, 0x84a498);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSatyr.class, 34, 0x707b4f, 0xa4452d);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSelkie.class, 35, 9082818, 13488612);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaShaman.class, 32, 0xae6b3c, 0x56b134);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSharko.class, 33, 0x84a498, 0x5c70b1);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSiren.class, 38, 0x29bc55, 0x48a0de);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSludgeGirl.class, 39, 6595667, 7715172);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSphinx.class, 36, 0xf09942, 0x353535);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSpriggan.class, 37, 4010013, 8151614);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSuccubus.class, 42, 4079166, 13218145);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSwamper.class, 43, 0x516d30, 0x4f8a48);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaValkyrie.class, 40, 0xc9b161, 0xd54242);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaVampire.class, 41, 0xc23021, 0xc9b161);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaWerecat.class, 46, 0x7a7e8a, 0xdddadb);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaWitch.class, 47, 0x303030, 0x943dbb);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaWitherCow.class, 44, 5791069, 16777215);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaYeti.class, 45, 16448250, 7895160);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaYukiOnna.class, 51, 6781114, 13817330);*/

	}
	
	/*
	//debug, remove before compile/release
	MinecraftForge.EVENT_BUS.register(this);
	@SubscribeEvent
	public void postInit(CommandReceivedEvent event) {
		if ("out".equals(event.command)) {
			event.handled = true;
			System.out.println("test");
		}
		if ("butcher".equals(event.command)) {
			event.handled = true;
			EntityPlayer p = (EntityPlayer)event.sender;
			World w = p.worldObj;
			List<Entity> list = w.loadedEntityList;
			for (Entity e : list) {
				if (e instanceof EntityPlayer) continue;
				e.setDead();
			}
		}
		if ("listitems".equals(event.command)) {
			event.handled = true;
			Iterator<String> it = Item.itemRegistry.getKeys().iterator();
			while (it.hasNext()) {
				String s = it.next();
				if (!s.startsWith("minecraft:")) {
					System.out.println(s);	
				}

			}
		}

		if ("spawnall".equals(event.command)) {
			event.handled = true;
			spawnCreatures((EntityPlayer)event.sender);
		}

	}

	public static void spawnCreatures(EntityPlayer player) {
		World world = player.worldObj;
		double posX = player.posX;
		double posY = player.posY;
		double posZ = player.posZ;
		posY+=1.38D;
		for (ModContainer c : EntityRegistry.instance().entityRegistrations.keySet()) {
			System.out.println("modcontainer "+c);
			List<EntityRegistration> l = EntityRegistry.instance().entityRegistrations.get(c);
			for (EntityRegistration r : l) {
				posX+=1.08D;
				try {
					EntityLiving entity = (EntityLiving)r.getEntityClass().getConstructor(new Class[]{World.class}).newInstance(new Object[]{world});
					entity.setLocationAndAngles(posX, posY, posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
					entity.rotationYawHead = entity.rotationYaw;
					entity.renderYawOffset = entity.rotationYaw;
					entity.onSpawnWithEgg((IEntityLivingData)null);
					if (!world.spawnEntityInWorld(entity)) {
						System.err.println("Failed to spawn "+r.getEntityName()+" - "+r.getEntityClass());
					}
				} catch (Exception var11) {
					System.err.println("Failed to spawn "+r.getEntityName()+" - "+r.getEntityClass());
					var11.printStackTrace();
				}

			}
		}
	}
	*/
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}
