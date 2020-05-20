package gaia.client.renderer.layers;

import gaia.client.model.ModelGaiaCreep;
import gaia.entity.hostile.GaiaCreepEntity;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.EnergyLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GaiaCreepChargeLayer extends EnergyLayer<GaiaCreepEntity, ModelGaiaCreep<GaiaCreepEntity>> {
    private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private final ModelGaiaCreep<GaiaCreepEntity> creepModel = new ModelGaiaCreep();

    public GaiaCreepChargeLayer(IEntityRenderer<GaiaCreepEntity, ModelGaiaCreep<GaiaCreepEntity>> renderer) {
        super(renderer);
    }

    protected float func_225634_a_(float p_225634_1_) {
        return p_225634_1_ * 0.01F;
    }

    protected ResourceLocation func_225633_a_() {
        return LIGHTNING_TEXTURE;
    }

    protected EntityModel<GaiaCreepEntity> func_225635_b_() {
        return this.creepModel;
    }
}