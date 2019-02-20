package gaia.renderer.tileentity;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import gaia.GaiaReference;
import gaia.init.GaiaBlocks;
import gaia.model.tileentity.IModelBust;
import gaia.model.tileentity.TileModelBustSphinx;
import gaia.model.tileentity.TileModelBustValkyrie;
import gaia.model.tileentity.TileModelBustVampire;
import gaia.model.tileentity.TileModelDoll;
import gaia.model.tileentity.TileModelDollSlimeGirl;
import gaia.tileentity.TileEntityBust;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;

public class TileRenderBust extends TileEntityRenderer<TileEntityBust> {
	private final Map<Block, Tuple<IModelBust, ResourceLocation>> models = new ImmutableMap.Builder<Block, Tuple<IModelBust, ResourceLocation>>()
			.put(GaiaBlocks.BUST_SPHINX, new Tuple<>(new TileModelBustSphinx(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/blocks/bustsphinx.png")))
			.put(GaiaBlocks.BUST_VALKYRIE, new Tuple<>(new TileModelBustValkyrie(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/blocks/bustvalkyrie.png")))
			.put(GaiaBlocks.BUST_VAMPIRE, new Tuple<>(new TileModelBustVampire(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/blocks/bustvampire.png")))
			.put(GaiaBlocks.DOLL_CREEPER_GIRL, new Tuple<>(new TileModelDoll(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/blocks/dollcreepergirl.png")))
			.put(GaiaBlocks.DOLL_ENDER_GIRL, new Tuple<>(new TileModelDoll(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/blocks/dollendergirl.png")))
			.put(GaiaBlocks.DOLL_MAID, new Tuple<>(new TileModelDoll(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/blocks/dollmaid.png")))
			.put(GaiaBlocks.DOLL_SLIME_GIRL, new Tuple<>(new TileModelDollSlimeGirl(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/blocks/dollslimegirl.png")))
			.build();

	@Override
	public void render(TileEntityBust te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		Block block = te.getWorld().getBlockState(te.getPos()).getBlock();
		if (models.containsKey(block)) {
			GlStateManager.pushMatrix();
			GlStateManager.translatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GlStateManager.rotatef(getHorizontalAngle(te.getDirection()), 0.0F, 1.0F, 0.0F);

			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			bindTexture(models.get(block).getB());
			models.get(block).getA().renderModel(0.0625F);
			GlStateManager.popMatrix();
		}
	}
	
	private float getHorizontalAngle(EnumFacing facing) {
		//TODO fix models so that this extra logic and the -1 scale and extra translation above isn't needed
		return facing.getAxis() == EnumFacing.Axis.X ? facing.getOpposite().getHorizontalAngle() : facing.getHorizontalAngle();
	}
}
