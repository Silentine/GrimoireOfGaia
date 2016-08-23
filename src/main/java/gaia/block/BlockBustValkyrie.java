package gaia.block;

import gaia.Gaia;
import gaia.tileentity.TileEntityBustValkyrie;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBustValkyrie extends BlockContainer {

	public BlockBustValkyrie(Material par2Material) {
		super(par2Material);
		//this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
		this.setLightOpacity(0);
		this.setHardness(3.0F);
		this.setResistance(6.0F);
		this.setUnlocalizedName("GrimoireOfGaia.BustValkyrie");
		this.setCreativeTab(Gaia.tabGaia);
	}
	
	/** TODO BOUNDS**/
	protected static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BOUNDS;
    }
	
	public int getRenderType() {
		return -1;
	}

	public TileEntity createNewTileEntity(World par1World, int i) {
		return new TileEntityBustValkyrie();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isFullCube() {
        return false;
    }

	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
		if (entity != null) {
			TileEntityBustValkyrie tile = (TileEntityBustValkyrie)world.getTileEntity(pos);
			tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		}
	}

	public Block setBlockTextureName(String string) {
		return null;
	}
}
