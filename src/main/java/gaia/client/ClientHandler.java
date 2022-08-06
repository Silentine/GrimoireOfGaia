package gaia.client;

import gaia.GrimoireOfGaia;
import gaia.client.model.AntWorkerModel;
import gaia.client.model.AnubisModel;
import gaia.client.model.ArachneModel;
import gaia.client.model.BansheeModel;
import gaia.client.model.BeeModel;
import gaia.client.model.CentaurModel;
import gaia.client.model.CreepModel;
import gaia.client.model.CyclopsModel;
import gaia.client.model.DryadModel;
import gaia.client.model.DullahanModel;
import gaia.client.model.GoblinModel;
import gaia.client.model.HarpyModel;
import gaia.client.model.HunterModel;
import gaia.client.model.KoboldModel;
import gaia.client.model.MatangoModel;
import gaia.client.model.NineTailsModel;
import gaia.client.model.OniModel;
import gaia.client.model.OrcModel;
import gaia.client.model.SatyressModel;
import gaia.client.model.ShamanModel;
import gaia.client.model.SirenModel;
import gaia.client.model.SludgeGirlModel;
import gaia.client.model.SporelingModel;
import gaia.client.model.SprigganModel;
import gaia.client.model.SuccubusModel;
import gaia.client.model.WerecatModel;
import gaia.client.model.YukiOnnaModel;
import gaia.client.model.prop.AntHillModel;
import gaia.client.renderer.AntWorkerRenderer;
import gaia.client.renderer.AnubisRenderer;
import gaia.client.renderer.ArachneRenderer;
import gaia.client.renderer.BansheeRenderer;
import gaia.client.renderer.BeeRenderer;
import gaia.client.renderer.CentaurRenderer;
import gaia.client.renderer.CreepRenderer;
import gaia.client.renderer.CyclopsRenderer;
import gaia.client.renderer.DryadRenderer;
import gaia.client.renderer.DullahanRenderer;
import gaia.client.renderer.GaiaHorseRenderer;
import gaia.client.renderer.GoblinFeralRenderer;
import gaia.client.renderer.GoblinRenderer;
import gaia.client.renderer.HarpyRenderer;
import gaia.client.renderer.HunterRenderer;
import gaia.client.renderer.KoboldRenderer;
import gaia.client.renderer.MatangoRenderer;
import gaia.client.renderer.NineTailsRenderer;
import gaia.client.renderer.OniRenderer;
import gaia.client.renderer.OrcRenderer;
import gaia.client.renderer.SatyressRenderer;
import gaia.client.renderer.ShamanRenderer;
import gaia.client.renderer.SirenRenderer;
import gaia.client.renderer.SludgeGirlRenderer;
import gaia.client.renderer.SporelingRenderer;
import gaia.client.renderer.SprigganRenderer;
import gaia.client.renderer.SuccubusRenderer;
import gaia.client.renderer.WerecatRenderer;
import gaia.client.renderer.YukiOnnaRenderer;
import gaia.client.renderer.prop.AntHillRenderer;
import gaia.entity.Arachne;
import gaia.registry.GaiaRegistry;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {
	public static final float tinyShadow = 0.25F;
	public static final float smallShadow = 0.4F;
	public static final float medShadow = 0.5F;
	public static final float largeShadow = 0.7F;

	public static final ModelLayerLocation ANT_HILL = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ant_hill"), "main");
	public static final ModelLayerLocation ANT_WORKER = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ant_worker"), "main");
	public static final ModelLayerLocation ANUBIS = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "anubis"), "main");
	public static final ModelLayerLocation ARACHNE = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "arachne"), "main");
	public static final ModelLayerLocation BANSHEE = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "banshee"), "main");
	public static final ModelLayerLocation BEE = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "bee"), "main");
	public static final ModelLayerLocation CENTAUR = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "centaur"), "main");
	public static final ModelLayerLocation CREEP = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "creep"), "main");
	public static final ModelLayerLocation CREEP_ARMOR = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "creep"), "armor");
	public static final ModelLayerLocation CYCLOPS = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "cyclops"), "main");
	public static final ModelLayerLocation DRYAD = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "dryad"), "main");
	public static final ModelLayerLocation DULLAHAN = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "dullahan"), "main");
	public static final ModelLayerLocation GOBLIN = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "goblin"), "main");
	public static final ModelLayerLocation GOBLIN_FERAL = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "goblin"), "feral");
	public static final ModelLayerLocation HARPY = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "harpy"), "main");
	public static final ModelLayerLocation HUNTER = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "hunter"), "main");
	public static final ModelLayerLocation KOBOLD = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "kobold"), "main");
	public static final ModelLayerLocation MATANGO = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "matango"), "main");
	public static final ModelLayerLocation NINE_TAILS = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "nine_tails"), "main");
	public static final ModelLayerLocation ONI = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "oni"), "main");
	public static final ModelLayerLocation ORC = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "orc"), "main");
	public static final ModelLayerLocation SATYRESS = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "satyress"), "main");
	public static final ModelLayerLocation SHAMAN = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "shaman"), "main");
	public static final ModelLayerLocation SIREN = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "siren"), "main");
	public static final ModelLayerLocation SLUDGE_GIRL = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "sludge_girl"), "main");
	public static final ModelLayerLocation SPORELING = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "sporeling"), "main");
	public static final ModelLayerLocation SPRIGGAN = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "spriggan"), "main");
	public static final ModelLayerLocation SUCCUBUS = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "succubus"), "main");
	public static final ModelLayerLocation WERECAT = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "werecat"), "main");
	public static final ModelLayerLocation YUKI_ONNA = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "yuki_onna"), "main");

	public static final ModelLayerLocation HORSE = new ModelLayerLocation(new ResourceLocation(GrimoireOfGaia.MOD_ID, "horse"), "main");


	public static void onClientSetup(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.BUST_GORGON.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.BUST_SPHINX.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.BUST_VALKYRIE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.BUST_VAMPIRE.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_CREEPER_GIRL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_ENDER_GIRL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_SLIME_GIRL.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_MAID.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_DULLAHAN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_MERMAID.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_NINE_TAILS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DOLL_DRYAD.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DECO_GARDEN_GNOME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DECO_MANDRAGORA_POT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.BUST_MINOTAUR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(GaiaRegistry.DECO_NEST_HARPY.get(), RenderType.cutout());

		if (ModList.get().isLoaded("curios")) {
			gaia.compat.curios.client.CuriosRendering.onRenderSetup();
		}

		ClientRegistry.registerEntityShader(Arachne.class, new ResourceLocation("shaders/post/spider.json"));

		ItemProperties.register(GaiaRegistry.STONE_SHIELD.get(), new ResourceLocation("blocking"), (stack, level, livingEntity, i) ->
				livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F);
		ItemProperties.register(GaiaRegistry.IRON_SHIELD.get(), new ResourceLocation("blocking"), (stack, level, livingEntity, i) ->
				livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F);
		ItemProperties.register(GaiaRegistry.GOLD_SHIELD.get(), new ResourceLocation("blocking"), (stack, level, livingEntity, i) ->
				livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F);
	}

	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GaiaRegistry.ANT_HILL.getEntityType(), AntHillRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.ANT_WORKER.getEntityType(), AntWorkerRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.ANUBIS.getEntityType(), AnubisRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.ARACHNE.getEntityType(), ArachneRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.BANSHEE.getEntityType(), BansheeRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.BEE.getEntityType(), BeeRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.CENTAUR.getEntityType(), CentaurRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.CREEP.getEntityType(), CreepRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.CYCLOPS.getEntityType(), CyclopsRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.DRYAD.getEntityType(), DryadRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.DULLAHAN.getEntityType(), DullahanRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.GOBLIN.getEntityType(), GoblinRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.GOBLIN_FERAL.getEntityType(), GoblinFeralRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.HARPY.getEntityType(), HarpyRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.HUNTER.getEntityType(), HunterRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.KOBOLD.getEntityType(), KoboldRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.MATANGO.getEntityType(), MatangoRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.NINE_TAILS.getEntityType(), NineTailsRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.ONI.getEntityType(), OniRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.ORC.getEntityType(), OrcRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.SATYRESS.getEntityType(), SatyressRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.SHAMAN.getEntityType(), ShamanRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.SIREN.getEntityType(), SirenRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.SLUDGE_GIRL.getEntityType(), SludgeGirlRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.SPORELING.getEntityType(), SporelingRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.SPRIGGAN.getEntityType(), SprigganRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.SUCCUBUS.getEntityType(), SuccubusRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.WERECAT.getEntityType(), WerecatRenderer::new);
		event.registerEntityRenderer(GaiaRegistry.YUKI_ONNA.getEntityType(), YukiOnnaRenderer::new);

		event.registerEntityRenderer(GaiaRegistry.HORSE.getEntityType(), GaiaHorseRenderer::new);

		event.registerEntityRenderer(GaiaRegistry.SMALL_FIREBALL.get(), (context) -> new ThrownItemRenderer<>(context, 0.75F, true));
		event.registerEntityRenderer(GaiaRegistry.MAGIC.get(), (context) -> new ThrownItemRenderer<>(context, 0.75F, true));
		event.registerEntityRenderer(GaiaRegistry.WEB.get(), (context) -> new ThrownItemRenderer<>(context, 0.75F, true));
		event.registerEntityRenderer(GaiaRegistry.BOMB.get(), (context) -> new ThrownItemRenderer<>(context, 0.75F, true));
		event.registerEntityRenderer(GaiaRegistry.POISON.get(), (context) -> new ThrownItemRenderer<>(context, 0.75F, true));
	}

	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ANT_HILL, AntHillModel::createBodyLayer);
		event.registerLayerDefinition(ANT_WORKER, AntWorkerModel::createBodyLayer);
		event.registerLayerDefinition(ANUBIS, AnubisModel::createBodyLayer);
		event.registerLayerDefinition(ARACHNE, ArachneModel::createBodyLayer);
		event.registerLayerDefinition(BANSHEE, BansheeModel::createBodyLayer);
		event.registerLayerDefinition(BEE, BeeModel::createBodyLayer);
		event.registerLayerDefinition(CENTAUR, CentaurModel::createBodyLayer);
		event.registerLayerDefinition(CREEP, () -> CreepModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(CREEP_ARMOR, () -> CreepModel.createBodyLayer(new CubeDeformation(2.0F)));
		event.registerLayerDefinition(CYCLOPS, CyclopsModel::createBodyLayer);
		event.registerLayerDefinition(DRYAD, DryadModel::createBodyLayer);
		event.registerLayerDefinition(DULLAHAN, DullahanModel::createBodyLayer);
		event.registerLayerDefinition(GOBLIN, GoblinModel::createBodyLayer);
		event.registerLayerDefinition(GOBLIN_FERAL, GoblinModel::createBodyLayer);
		event.registerLayerDefinition(HARPY, HarpyModel::createBodyLayer);
		event.registerLayerDefinition(HUNTER, HunterModel::createBodyLayer);
		event.registerLayerDefinition(KOBOLD, KoboldModel::createBodyLayer);
		event.registerLayerDefinition(MATANGO, MatangoModel::createBodyLayer);
		event.registerLayerDefinition(NINE_TAILS, NineTailsModel::createBodyLayer);
		event.registerLayerDefinition(ONI, OniModel::createBodyLayer);
		event.registerLayerDefinition(ORC, OrcModel::createBodyLayer);
		event.registerLayerDefinition(SATYRESS, SatyressModel::createBodyLayer);
		event.registerLayerDefinition(SHAMAN, ShamanModel::createBodyLayer);
		event.registerLayerDefinition(SIREN, SirenModel::createBodyLayer);
		event.registerLayerDefinition(SLUDGE_GIRL, SludgeGirlModel::createBodyLayer);
		event.registerLayerDefinition(SPORELING, SporelingModel::createBodyLayer);
		event.registerLayerDefinition(SPRIGGAN, SprigganModel::createBodyLayer);
		event.registerLayerDefinition(SUCCUBUS, SuccubusModel::createBodyLayer);
		event.registerLayerDefinition(WERECAT, WerecatModel::createBodyLayer);
		event.registerLayerDefinition(YUKI_ONNA, YukiOnnaModel::createBodyLayer);

		event.registerLayerDefinition(HORSE, () -> LayerDefinition.create(HorseModel.createBodyMesh(CubeDeformation.NONE), 64, 64));
	}
}
