package gaia.block;

import gaia.Gaia;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpawnGuard extends Block {

	public BlockSpawnGuard() {
		super(Material.CLOTH);
		this.setLightOpacity(0);
		this.setHardness(0.0F);
		this.setResistance(6.0F);
		this.setUnlocalizedName("GrimoireOfGaia.SpawnGuard");
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.North));
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("block.GrimoireOfGaia.SpawnGuard.desc", new Object[]{Integer.valueOf(8)}));
	}
	
	protected static final AxisAlignedBB Down_BOX =  new AxisAlignedBB(0.0F, 0.0F, 0.0F,  1.0F, 0.06F, 1.0F);
	protected static final AxisAlignedBB Up_BOX =    new AxisAlignedBB(0.0F, 0.94F, 0.0F, 1.0F, 1.0F, 1.0F);
	protected static final AxisAlignedBB North_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.94F, 1.0F, 1.0F, 1.0F);
	protected static final AxisAlignedBB South_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F,  1.0F, 1.0F, 0.06F);
	protected static final AxisAlignedBB West_BOX =  new AxisAlignedBB(0.94F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	protected static final AxisAlignedBB East_BOX =  new AxisAlignedBB(0.0F, 0.0F, 0.0F,  0.06F, 1.0F, 1.0F);
	

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
        return EnumBlockRenderType.MODEL;
    }
    /* legacy tile entity code
	public TileEntity createNewTileEntity(World par1World, int i) {
		return new TileEntitySpawnGuard();
	}
	
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {	
		if (entity != null) {
			TileEntitySpawnGuard tile = (TileEntitySpawnGuard)world.getTileEntity(pos);
			tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		}
	}
	*/
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int meta = getMetaFromState(state);
		if(meta < 4) return Down_BOX;
		if(8 > meta && meta > 3) return Up_BOX;
		switch(meta){
			case 8: return North_BOX;
			case 9: return South_BOX;
			case 10: return West_BOX;
			case 11: return East_BOX;
				default: return Down_BOX;
		}
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {	
		EnumType constant = EnumType.getConstant(meta);
	    return getDefaultState().withProperty(TYPE, constant);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    EnumType type = (EnumType) state.getValue(TYPE);
	    return type.getID();
	}
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {	
		int ID = 0;
		int face = facing.getIndex();
		if(facing == EnumFacing.UP) ID = MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			else 
			if(facing == EnumFacing.DOWN) ID = (MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 4;
				else ID = face + 6;	
		
        return this.getStateFromMeta(ID);
    }
	
	
	@Override
	protected BlockStateContainer createBlockState() {
	    return new BlockStateContainer(this, new IProperty[] { TYPE });
	}
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockSpawnGuard.EnumType.class);
	
	public enum EnumType implements IStringSerializable {
	    North(0, "north"),
	    South(1, "south"),
	    West(2, "west"),
	    East(3, "east"),
	    
	    Up_North(4, "u_north"),
	    Up_South(5, "u_south"),
	    Up_West(6, "u_west"),
	    Up_East(7, "u_east"),
	    
	    Vertical_North(8, "v_north"),
	    Vertical_South(9, "v_south"),
	    Vertical_West(10, "v_west"),
	    Vertical_East(11, "v_east");	    

	    private int ID;
	    private String name;
	    
	    private EnumType(int ID, String name) {
	        this.ID = ID;
	        this.name = name;
	    }
	    
	    @Override
	    public String getName() {
	        return name;
	    }

	    public int getID() {
	        return ID;
	    }
	    
	    public static EnumType getConstant(int meta){
	    	if(0 > meta || meta > 11) meta = 0;
	    	return EnumType.values()[meta];	    	
	    }
	}
	
}
