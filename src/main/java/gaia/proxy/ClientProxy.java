package gaia.proxy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAntRanger;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBee;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCecaelia;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDeathword;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaGelatinousSlime;
import gaia.entity.monster.EntityGaiaGoblin;
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
import gaia.entity.monster.EntityGaiaOni;
import gaia.entity.monster.EntityGaiaOrc;
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
import gaia.entity.projectile.EntityGaiaProjectileBubble;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectilePoison;
import gaia.entity.projectile.EntityGaiaProjectileWeb;
import gaia.init.GaiaItems;
import gaia.renderer.RenderGaiaProjectile;
import gaia.renderer.entity.RenderGaiaAnt;
import gaia.renderer.entity.RenderGaiaAntRanger;
import gaia.renderer.entity.RenderGaiaAnubis;
import gaia.renderer.entity.RenderGaiaArachne;
import gaia.renderer.entity.RenderGaiaBanshee;
import gaia.renderer.entity.RenderGaiaBaphomet;
import gaia.renderer.entity.RenderGaiaBee;
import gaia.renderer.entity.RenderGaiaBoneKnight;
import gaia.renderer.entity.RenderGaiaCecaelia;
import gaia.renderer.entity.RenderGaiaCentaur;
import gaia.renderer.entity.RenderGaiaCobbleGolem;
import gaia.renderer.entity.RenderGaiaCobblestoneGolem;
import gaia.renderer.entity.RenderGaiaCreep;
import gaia.renderer.entity.RenderGaiaCyclops;
import gaia.renderer.entity.RenderGaiaDeathword;
import gaia.renderer.entity.RenderGaiaDhampir;
import gaia.renderer.entity.RenderGaiaDryad;
import gaia.renderer.entity.RenderGaiaDullahan;
import gaia.renderer.entity.RenderGaiaDwarf;
import gaia.renderer.entity.RenderGaiaEnderDragonGirl;
import gaia.renderer.entity.RenderGaiaEnderEye;
import gaia.renderer.entity.RenderGaiaFleshLich;
import gaia.renderer.entity.RenderGaiaGelatinousSlime;
import gaia.renderer.entity.RenderGaiaGoblin;
import gaia.renderer.entity.RenderGaiaGryphon;
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
import gaia.renderer.entity.RenderGaiaOni;
import gaia.renderer.entity.RenderGaiaOrc;
import gaia.renderer.entity.RenderGaiaPropChestMimic;
import gaia.renderer.entity.RenderGaiaPropFlowerCyan;
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
import gaia.renderer.entity.layers.LayerHeadgear;
import gaia.renderer.tileentity.TileRenderBust;
import gaia.tileentity.TileEntityBust;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	private final Set<IClientRegister> clientRegisters = new HashSet<>();

	@Override
	public void addClientRegister(IClientRegister register) {
		clientRegisters.add(register);
	}

	public ClientProxy() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event) {
		for (IClientRegister register : clientRegisters) {
			register.registerClient();
		}
	}

	@Override
	public void registerHandlers() {
	}

	@Override
	public void registerRenders() {
		float tiny = 0.25F;
		float small = 0.4F;
		float med = 0.5F;
		float large = 0.7F;

		// Mob
//		RenderingRegistry.registerEntityRenderingHandler(EntityDebugMob.class, renderManager -> new RenderDebugMob(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaAnt.class, renderManager -> new RenderGaiaAnt(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaAntRanger.class, renderManager -> new RenderGaiaAntRanger(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaAnubis.class, renderManager -> new RenderGaiaAnubis(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaArachne.class, renderManager -> new RenderGaiaArachne(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBanshee.class, renderManager -> new RenderGaiaBanshee(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBaphomet.class, renderManager -> new RenderGaiaBaphomet(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBee.class, renderManager -> new RenderGaiaBee(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBoneKnight.class, renderManager -> new RenderGaiaBoneKnight(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCecaelia.class, renderManager -> new RenderGaiaCecaelia(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCentaur.class, renderManager -> new RenderGaiaCentaur(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobbleGolem.class, renderManager -> new RenderGaiaCobbleGolem(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobblestoneGolem.class, renderManager -> new RenderGaiaCobblestoneGolem(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCreep.class, renderManager -> new RenderGaiaCreep(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCyclops.class, renderManager -> new RenderGaiaCyclops(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDeathword.class, renderManager -> new RenderGaiaDeathword(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDhampir.class, renderManager -> new RenderGaiaDhampir(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDryad.class, renderManager -> new RenderGaiaDryad(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDullahan.class, renderManager -> new RenderGaiaDullahan(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDwarf.class, renderManager -> new RenderGaiaDwarf(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaEnderDragonGirl.class, renderManager -> new RenderGaiaEnderDragonGirl(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaEnderEye.class, renderManager -> new RenderGaiaEnderEye(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaFleshLich.class, renderManager -> new RenderGaiaFleshLich(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaGelatinousSlime.class, renderManager -> new RenderGaiaGelatinousSlime(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaGoblin.class, renderManager -> new RenderGaiaGoblin(renderManager, tiny));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaGryphon.class, renderManager -> new RenderGaiaGryphon(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHarpy.class, renderManager -> new RenderGaiaHarpy(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHunter.class, renderManager -> new RenderGaiaHunter(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaKobold.class, renderManager -> new RenderGaiaKobold(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMandragora.class, renderManager -> new RenderGaiaMandragora(renderManager, tiny));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMatango.class, renderManager -> new RenderGaiaMatango(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMermaid.class, renderManager -> new RenderGaiaMermaid(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMimic.class, renderManager -> new RenderGaiaMimic(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMinotaur.class, renderManager -> new RenderGaiaMinotaur(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMinotaurus.class, renderManager -> new RenderGaiaMinotaurus(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMummy.class, renderManager -> new RenderGaiaMummy(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNaga.class, renderManager -> new RenderGaiaNaga(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNineTails.class, renderManager -> new RenderGaiaNineTails(renderManager, small));
		// NPC
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCCreeperGirl.class, renderManager -> new RenderGaiaNPCCreeperGirl(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCSlimeGirl.class, renderManager -> new RenderGaiaNPCSlimeGirl(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCEnderGirl.class, renderManager -> new RenderGaiaNPCEnderGirl(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCTrader.class, renderManager -> new RenderGaiaNPCTrader(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCHolstaurus.class, renderManager -> new RenderGaiaNPCHolstaurus(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCWeresheep.class, renderManager -> new RenderGaiaNPCWeresheep(renderManager, small));
		// Mob
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaOni.class, renderManager -> new RenderGaiaOni(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaOrc.class, renderManager -> new RenderGaiaOrc(renderManager, med));
		// Prop
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaPropChestMimic.class, renderManager -> new RenderGaiaPropChestMimic(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaPropFlowerCyan.class, renderManager -> new RenderGaiaPropFlowerCyan(renderManager, small));
		// Mob
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSatyress.class, renderManager -> new RenderGaiaSatyress(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSelkie.class, renderManager -> new RenderGaiaSelkie(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaShaman.class, renderManager -> new RenderGaiaShaman(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSharko.class, renderManager -> new RenderGaiaSharko(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSiren.class, renderManager -> new RenderGaiaSiren(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSludgeGirl.class, renderManager -> new RenderGaiaSludgeGirl(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSphinx.class, renderManager -> new RenderGaiaSphinx(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSpriggan.class, renderManager -> new RenderGaiaSpriggan(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSuccubus.class, renderManager -> new RenderGaiaSuccubus(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSummonButler.class, renderManager -> new RenderGaiaSummonButler(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSummonSporeling.class, renderManager -> new RenderGaiaSummonSporeling(renderManager, tiny));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaToad.class, renderManager -> new RenderGaiaToad(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaValkyrie.class, renderManager -> new RenderGaiaValkyrie(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaVampire.class, renderManager -> new RenderGaiaVampire(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWerecat.class, renderManager -> new RenderGaiaWerecat(renderManager, small));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitch.class, renderManager -> new RenderGaiaWitch(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitherCow.class, renderManager -> new RenderGaiaWitherCow(renderManager, med));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYeti.class, renderManager -> new RenderGaiaYeti(renderManager, large));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYukiOnna.class, renderManager -> new RenderGaiaYukiOnna(renderManager, small));
		// Projectile
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaProjectileBubble.class, renderManager -> new RenderGaiaProjectile(renderManager, GaiaItems.WEAPON_PROP_PROJECTILE_BUBBLE));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaProjectileMagic.class, renderManager -> new RenderGaiaProjectile(renderManager, GaiaItems.WEAPON_PROP_PROJECTILE_MAGIC));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaProjectilePoison.class, renderManager -> new RenderGaiaProjectile(renderManager, GaiaItems.WEAPON_PROP_PROJECTILE_POISON));
		RenderingRegistry.registerEntityRenderingHandler(EntityGaiaProjectileWeb.class, renderManager -> new RenderGaiaProjectile(renderManager, GaiaItems.WEAPON_PROP_PROJECTILE_WEB));
	}

	@Override
	public void registerTileRenders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBust.class, new TileRenderBust());
	}

	/**
	 * @reference 
	 * https://github.com/gigaherz/ToolBelt/blob/master/src/main/java/gigaherz/toolbelt/client/ClientProxy.java
	 */
	@Override
	public void registerLayerRenders() {
		if (Loader.isModLoaded("baubles")) {
			Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
			// Used for default player model
			RenderPlayer render = skinMap.get("default");
			render.addLayer(new LayerHeadgear(render.getMainModel().bipedHead));
			// Used for slim player model
			render = skinMap.get("slim");
			render.addLayer(new LayerHeadgear(render.getMainModel().bipedHead));
		}
	}
}
