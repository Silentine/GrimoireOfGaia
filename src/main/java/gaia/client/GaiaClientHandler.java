package gaia.client;

import gaia.client.renderer.monster.GaiaAntRangerRenderer;
import gaia.client.renderer.monster.GaiaAntRenderer;
import gaia.client.renderer.monster.GaiaAnubisRenderer;
import gaia.client.renderer.monster.GaiaArachneRenderer;
import gaia.client.renderer.monster.GaiaBansheeRenderer;
import gaia.client.renderer.monster.GaiaBaphometRenderer;
import gaia.client.renderer.monster.GaiaBeeRenderer;
import gaia.client.renderer.monster.GaiaBoneKnightRenderer;
import gaia.client.renderer.monster.GaiaCecaeliaRenderer;
import gaia.client.renderer.monster.GaiaCentaurRenderer;
import gaia.client.renderer.monster.GaiaCobbleGolemRenderer;
import gaia.client.renderer.monster.GaiaCobblestoneGolemRenderer;
import gaia.client.renderer.monster.GaiaCreepRenderer;
import gaia.client.renderer.monster.GaiaCyclopsRenderer;
import gaia.client.renderer.monster.GaiaDeathwordRenderer;
import gaia.client.renderer.monster.GaiaDhampirRenderer;
import gaia.client.renderer.monster.GaiaDryadRenderer;
import gaia.client.renderer.monster.GaiaDullahanRenderer;
import gaia.client.renderer.monster.GaiaDwarfRenderer;
import gaia.client.renderer.monster.GaiaEnderDragonGirlRenderer;
import gaia.client.renderer.monster.GaiaEnderEyeRenderer;
import gaia.client.renderer.monster.GaiaFleshLichRenderer;
import gaia.client.renderer.monster.GaiaGelatinousSlimeRenderer;
import gaia.client.renderer.monster.GaiaGoblinFeralRenderer;
import gaia.client.renderer.monster.GaiaGoblinRenderer;
import gaia.client.renderer.monster.GaiaGryphonRenderer;
import gaia.client.renderer.monster.GaiaHarpyRenderer;
import gaia.client.renderer.monster.GaiaHunterRenderer;
import gaia.client.renderer.monster.GaiaKikimoraRenderer;
import gaia.client.renderer.monster.GaiaKoboldRenderer;
import gaia.client.renderer.monster.GaiaMandragoraRenderer;
import gaia.client.renderer.monster.GaiaMimicRenderer;
import gaia.client.renderer.monster.GaiaSphinxRenderer;
import gaia.client.renderer.prop.GaiaPropCampfireRenderer;
import gaia.client.renderer.prop.GaiaPropChestMimicRenderer;
import gaia.client.renderer.prop.GaiaPropFlowerCyanRenderer;
import gaia.client.renderer.prop.GaiaPropVaseNetherRenderer;
import gaia.client.renderer.prop.GaiaPropVaseRenderer;
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
import gaia.entity.assist.GaiaKikimoraEntity;
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
import gaia.entity.hostile.GaiaKoboldEntity;
import gaia.entity.hostile.GaiaMandragoraEntity;
import gaia.entity.hostile.GaiaMimicEntity;
import gaia.entity.hostile.GaiaSphinxEntity;
import gaia.entity.projectile.GaiaProjectileBombEntity;
import gaia.entity.projectile.GaiaProjectileBubbleEntity;
import gaia.entity.projectile.GaiaProjectileMagicEntity;
import gaia.entity.projectile.GaiaProjectilePoisonEntity;
import gaia.entity.projectile.GaiaProjectileWebEntity;
import gaia.entity.prop.GaiaPropCampfireEntity;
import gaia.entity.prop.GaiaPropChestMimicEntity;
import gaia.entity.prop.GaiaPropFlowerCyanEntity;
import gaia.entity.prop.GaiaPropVaseEntity;
import gaia.entity.prop.GaiaPropVaseNetherEntity;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.item.ItemGaiaSpawnEgg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class GaiaClientHandler {
    private static final float tiny = 0.25F;
    private static final float small = 0.4F;
    private static final float med = 0.5F;
    private static final float large = 0.7F;

    public static void registerRenders(final FMLClientSetupEvent event) {
        //Props
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.CAMPFIRE.get(), renderManager -> new GaiaPropCampfireRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.CHEST.get(), renderManager -> new GaiaPropChestMimicRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.CYAN_FLOWER.get(), renderManager -> new GaiaPropFlowerCyanRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.VASE.get(), renderManager -> new GaiaPropVaseRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.VASE_NETHER.get(), renderManager -> new GaiaPropVaseNetherRenderer(renderManager));

        //Projectiles
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.BOMB_PROJECTILE.get(), renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F, true));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.BUBBLE_PROJECTILE.get(), renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F, true));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.MAGIC_PROJECTILE.get(), renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F, true));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.POISON_PROJECTILE.get(), renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F, true));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.WEB_PROJECTILE.get(), renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F, true));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.FIREBALL_PROJECTILE.get(), renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F, true));

        //Mobs
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.ANT.get() , renderManager -> new GaiaAntRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.ANT_RANGER.get() , renderManager -> new GaiaAntRangerRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.ANUBIS.get() , renderManager -> new GaiaAnubisRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.ARACHNE.get() , renderManager -> new GaiaArachneRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.BANSHEE.get() , renderManager -> new GaiaBansheeRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.BAPHOMET.get() , renderManager -> new GaiaBaphometRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.BEE.get() , renderManager -> new GaiaBeeRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.BONE_KNIGHT.get() , renderManager -> new GaiaBoneKnightRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.CECAELIA.get() , renderManager -> new GaiaCecaeliaRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.CENTAUR.get() , renderManager -> new GaiaCentaurRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.COBBLE_GOLEM.get() , renderManager -> new GaiaCobbleGolemRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.COBBLESTONE_GOLEM.get() , renderManager -> new GaiaCobblestoneGolemRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.CREEP.get() , renderManager -> new GaiaCreepRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.CYCLOPS.get() , renderManager -> new GaiaCyclopsRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.DEATHWORD.get() , renderManager -> new GaiaDeathwordRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.DHAMPIR.get() , renderManager -> new GaiaDhampirRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.DRYAD.get() , renderManager -> new GaiaDryadRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.DULLAHAN.get() , renderManager -> new GaiaDullahanRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.DWARF.get() , renderManager -> new GaiaDwarfRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.ENDER_DRAGON_GIRL.get() , renderManager -> new GaiaEnderDragonGirlRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.ENDER_EYE.get() , renderManager -> new GaiaEnderEyeRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.FLESH_LICH.get() , renderManager -> new GaiaFleshLichRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.GELATINOUS_SLIME.get() , renderManager -> new GaiaGelatinousSlimeRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.GOBLIN.get() , renderManager -> new GaiaGoblinRenderer(renderManager, tiny));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.GOBLIN_FERAL.get() , renderManager -> new GaiaGoblinFeralRenderer(renderManager, tiny));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.GRYPHON.get() , renderManager -> new GaiaGryphonRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.HARPY.get() , renderManager -> new GaiaHarpyRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.HUNTER.get() , renderManager -> new GaiaHunterRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.KIKIMORA.get() , renderManager -> new GaiaKikimoraRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.KOBOLD.get() , renderManager -> new GaiaKoboldRenderer(renderManager, small));

        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.MANDRAGORA.get(), renderManager -> new GaiaMandragoraRenderer(renderManager, tiny));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.MIMIC.get(), renderManager -> new GaiaMimicRenderer(renderManager, med));

        RenderingRegistry.registerEntityRenderingHandler(GaiaEntities.SPHINX.get(), renderManager -> new GaiaSphinxRenderer(renderManager, large));

        RenderTypeLookup.setRenderLayer(GaiaBlocks.BUST_SPHINX.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.BUST_VALKYRIE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.BUST_VAMPIRE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.BUST_MINOTAUR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.DOLL_CREEPER_GIRL.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.DOLL_ENDER_GIRL.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.DOLL_SLIME_GIRL.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.DOLL_MAID.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.DECO_GARDEN_GNOME.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.DECO_MANDRAGORA_POT.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.DECO_NEST_HARPY.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(GaiaBlocks.WEB_TEMP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GaiaBlocks.FIRE_CAMP.get(), RenderType.getCutout());
    }

    public static void registerItemColors(final ColorHandlerEvent.Item event) {
        ItemColors colors = event.getItemColors();

        for(ItemGaiaSpawnEgg spawneggitem : ItemGaiaSpawnEgg.getEggs()) {
            colors.register((p_198141_1_, p_198141_2_) -> {
                return spawneggitem.getColor(p_198141_2_);
            }, spawneggitem);
        }
    }
}
