package gaia.block;

import gaia.Gaia;
import gaia.tileentity.TileEntitySpawnGuard;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpawnGuard extends BlockContainer {

	public BlockSpawnGuard() {
		super(Material.CLOTH);
		this.setLightOpacity(0);
		this.setHardness(0.0F);
		this.setResistance(6.0F);
		this.setUnlocalizedName("GrimoireOfGaia.SpawnGuard");
		this.setCreativeTab(Gaia.tabGaia);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("block.GrimoireOfGaia.SpawnGuard.desc", new Object[]{Integer.valueOf(8)}));
	}
	
	protected static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F * 1.0F, 1.0F);

    public boolean isFullCube(IBlockState state) {
        return false;
    }
	
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }
    
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
	public TileEntity createNewTileEntity(World par1World, int i) {
		return new TileEntitySpawnGuard();
	}

	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {	
		if (entity != null) {
			TileEntitySpawnGuard tile = (TileEntitySpawnGuard)world.getTileEntity(pos);
			tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		}
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldln, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityln ) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}
}
