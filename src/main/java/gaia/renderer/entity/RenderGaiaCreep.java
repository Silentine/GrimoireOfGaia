package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.model.ModelGaiaCreep;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * @see RenderCreeper
 */
@SideOnly(Side.CLIENT)
public class RenderGaiaCreep extends RenderLiving<EntityLiving> {

    private static final ResourceLocation armoredCreeperTextures = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/creep.png");
    private ModelBase GaiaCreepModel = new ModelGaiaCreep(2.0F);

    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaCreep(float shadowSize) {
        super(rend, new ModelGaiaCreep(), shadowSize);
        this.addLayer(new Charged_Layer(this));
    }

    protected void updateCreepScale(EntityGaiaCreep entity, float par2) {
        float f1 = entity.getCreeperFlashIntensity(par2);
        float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f1 > 1.0F) {
            f1 = 1.0F;
        }

        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GL11.glScalef(f3, f4, f3);
    }

    protected int updateCreepColorMultiplier(EntityGaiaCreep entity, float par2, float par3) {
        float f2 = entity.getCreeperFlashIntensity(par3);
        if ((int) (f2 * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int i = (int) (f2 * 0.2F * 255.0F);
            if (i < 0) {
                i = 0;
            }

            if (i > 255) {
                i = 255;
            }

            short short1 = 255;
            short short2 = 255;
            short short3 = 255;
            return i << 24 | short1 << 16 | short2 << 8 | short3;
        }
    }

    protected int func_77061_b(EntityGaiaCreep entity, int par2, float par3) {
        return -1;
    }

    protected void preRenderCallback(EntityLiving par1EntityLivingBase, float par2) {
        this.updateCreepScale((EntityGaiaCreep) par1EntityLivingBase, par2);
    }

    protected int getColorMultiplier(EntityLiving par1EntityLivingBase, float par2, float par3) {
        return this.updateCreepColorMultiplier((EntityGaiaCreep) par1EntityLivingBase, par2, par3);
    }

    protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
        return this.func_77061_b((EntityGaiaCreep) par1EntityLivingBase, par2, par3);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }

    @SideOnly(Side.CLIENT)
    public static class Charged_Layer implements LayerRenderer<EntityGaiaCreep> {

        private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
        private final RenderGaiaCreep creeperRenderer;
        private final ModelGaiaCreep creeperModel = new ModelGaiaCreep(2.0F);

        public Charged_Layer(RenderGaiaCreep creeperRendererIn) {
            this.creeperRenderer = creeperRendererIn;
        }

        public void doRenderLayer(EntityGaiaCreep entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
                float netHeadYaw, float headPitch, float scale) {
            if (entitylivingbaseIn.getPowered()) {
                boolean flag = entitylivingbaseIn.isInvisible();
                GlStateManager.depthMask(!flag);
                this.creeperRenderer.bindTexture(LIGHTNING_TEXTURE);
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                float f = (float) entitylivingbaseIn.ticksExisted + partialTicks;
                GlStateManager.translate(f * 0.01F, f * 0.01F, 0.0F);
                GlStateManager.matrixMode(5888);
                GlStateManager.enableBlend();
                float f1 = 0.5F;
                GlStateManager.color(0.5F, 0.5F, 0.5F, 1.0F);
                GlStateManager.disableLighting();
                GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
                this.creeperModel.setModelAttributes(this.creeperRenderer.getMainModel());
                this.creeperModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                GlStateManager.matrixMode(5888);
                GlStateManager.enableLighting();
                GlStateManager.disableBlend();
                GlStateManager.depthMask(flag);
            }
        }

        public boolean shouldCombineTextures() {
            return false;
        }
    }
}
