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
import gaia.item.ItemGaiaSpawnEgg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
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
        RenderingRegistry.registerEntityRenderingHandler(GaiaPropCampfireEntity.class, renderManager -> new GaiaPropCampfireRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaPropChestMimicEntity.class, renderManager -> new GaiaPropChestMimicRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaPropFlowerCyanEntity.class, renderManager -> new GaiaPropFlowerCyanRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaPropVaseEntity.class, renderManager -> new GaiaPropVaseRenderer(renderManager));
        RenderingRegistry.registerEntityRenderingHandler(GaiaPropVaseNetherEntity.class, renderManager -> new GaiaPropVaseNetherRenderer(renderManager));

        //Projectiles
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(GaiaProjectileBombEntity.class, renderManager -> new SpriteRenderer<>(renderManager, itemRenderer, 2.0F));
        RenderingRegistry.registerEntityRenderingHandler(GaiaProjectileBubbleEntity.class, renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F));
        RenderingRegistry.registerEntityRenderingHandler(GaiaProjectileMagicEntity.class, renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F));
        RenderingRegistry.registerEntityRenderingHandler(GaiaProjectilePoisonEntity.class, renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F));
        RenderingRegistry.registerEntityRenderingHandler(GaiaProjectileWebEntity.class, renderManager -> new SpriteRenderer(renderManager, itemRenderer, 2.0F));

        //Mobs
        RenderingRegistry.registerEntityRenderingHandler(GaiaAntEntity.class, renderManager -> new GaiaAntRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaAntRangerEntity.class, renderManager -> new GaiaAntRangerRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaAnubisEntity.class, renderManager -> new GaiaAnubisRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaArachneEntity.class, renderManager -> new GaiaArachneRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaBansheeEntity.class, renderManager -> new GaiaBansheeRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaBaphometEntity.class, renderManager -> new GaiaBaphometRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaBeeEntity.class, renderManager -> new GaiaBeeRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaBoneKnightEntity.class, renderManager -> new GaiaBoneKnightRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaCecaeliaEntity.class, renderManager -> new GaiaCecaeliaRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaCentaurEntity.class, renderManager -> new GaiaCentaurRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaCobbleGolemEntity.class, renderManager -> new GaiaCobbleGolemRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaCobblestoneGolemEntity.class, renderManager -> new GaiaCobblestoneGolemRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaCreepEntity.class, renderManager -> new GaiaCreepRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaCyclopsEntity.class, renderManager -> new GaiaCyclopsRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaDeathwordEntity.class, renderManager -> new GaiaDeathwordRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaDhampirEntity.class, renderManager -> new GaiaDhampirRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaDryadEntity.class, renderManager -> new GaiaDryadRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaDullahanEntity.class, renderManager -> new GaiaDullahanRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaDwarfEntity.class, renderManager -> new GaiaDwarfRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEnderDragonGirlEntity.class, renderManager -> new GaiaEnderDragonGirlRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaEnderEyeEntity.class, renderManager -> new GaiaEnderEyeRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaFleshLichEntity.class, renderManager -> new GaiaFleshLichRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaGelatinousSlimeEntity.class, renderManager -> new GaiaGelatinousSlimeRenderer(renderManager, large));
        RenderingRegistry.registerEntityRenderingHandler(GaiaGoblinEntity.class, renderManager -> new GaiaGoblinRenderer(renderManager, tiny));
        RenderingRegistry.registerEntityRenderingHandler(GaiaGoblinFeralEntity.class, renderManager -> new GaiaGoblinFeralRenderer(renderManager, tiny));
        RenderingRegistry.registerEntityRenderingHandler(GaiaGryphonEntity.class, renderManager -> new GaiaGryphonRenderer(renderManager, med));
        RenderingRegistry.registerEntityRenderingHandler(GaiaHarpyEntity.class, renderManager -> new GaiaHarpyRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaHunterEntity.class, renderManager -> new GaiaHunterRenderer(renderManager, small));
        RenderingRegistry.registerEntityRenderingHandler(GaiaKikimoraEntity.class, renderManager -> new GaiaKikimoraRenderer(renderManager, small));

        RenderingRegistry.registerEntityRenderingHandler(GaiaMandragoraEntity.class, renderManager -> new GaiaMandragoraRenderer(renderManager, tiny));
        RenderingRegistry.registerEntityRenderingHandler(GaiaMimicEntity.class, renderManager -> new GaiaMimicRenderer(renderManager, med));

        RenderingRegistry.registerEntityRenderingHandler(GaiaSphinxEntity.class, renderManager -> new GaiaSphinxRenderer(renderManager, large));
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
