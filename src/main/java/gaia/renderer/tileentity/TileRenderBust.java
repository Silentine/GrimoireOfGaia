package gaia.renderer.tileentity;

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
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;

import java.util.Map;

public class TileRenderBust extends TileEntitySpecialRenderer<TileEntityBust> {
	private final Map<Block, Tuple<IModelBust, ResourceLocation>> models = new ImmutableMap.Builder<Block, Tuple<IModelBust, ResourceLocation>>()
			.put(GaiaBlocks.BUST_SPHINX, new Tuple<>(new TileModelBustSphinx(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/bustsphinx.png")))
			.put(GaiaBlocks.BUST_VALKYRIE, new Tuple<>(new TileModelBustValkyrie(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/bustvalkyrie.png")))
			.put(GaiaBlocks.BUST_VAMPIRE, new Tuple<>(new TileModelBustVampire(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/bustvampire.png")))
			.put(GaiaBlocks.DOLL_CREEPER_GIRL, new Tuple<>(new TileModelDoll(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/dollcreepergirl.png")))
			.put(GaiaBlocks.DOLL_ENDER_GIRL, new Tuple<>(new TileModelDoll(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/dollendergirl.png")))
			.put(GaiaBlocks.DOLL_MAID, new Tuple<>(new TileModelDoll(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/dollmaid.png")))
			.put(GaiaBlocks.DOLL_SLIME_GIRL, new Tuple<>(new TileModelDollSlimeGirl(),
					new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/dollslimegirl.png")))
			.build();

	@Override
	public void render(TileEntityBust te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		Block block = te.getWorld().getBlockState(te.getPos()).getBlock();
		if (models.containsKey(block)) {
			GlStateManager.pushMatrix();
			GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GlStateManager.rotate(getHorizontalAngle(te.getDirection()), 0.0F, 1.0F, 0.0F);

			GlStateManager.scale(1.0F, -1.0F, -1.0F);
			bindTexture(models.get(block).getSecond());
			models.get(block).getFirst().renderModel(0.0625F);
			GlStateManager.popMatrix();
		}
	}

	private float getHorizontalAngle(EnumFacing facing) {
		//TODO fix models so that this extra logic and the -1 scale and extra translation above isn't needed
		return facing.getAxis() == EnumFacing.Axis.X ? facing.getOpposite().getHorizontalAngle() : facing.getHorizontalAngle();
	}
}
