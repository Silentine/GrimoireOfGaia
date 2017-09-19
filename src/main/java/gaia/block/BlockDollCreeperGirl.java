package gaia.block;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.init.GaiaBlocks;
import gaia.tileentity.TileEntityDollCreeperGirl;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class BlockDollCreeperGirl extends BlockContainer {

    public BlockDollCreeperGirl() {
        super(Material.CLOTH);
        this.setLightOpacity(0);
        this.setHardness(3.0F);
        this.setResistance(6.0F);
        this.setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, GaiaBlocks.DOLL_CREEPER_GIRL_NAME));
        this.setUnlocalizedName(GaiaReference.MOD_PREFIX + GaiaBlocks.DOLL_CREEPER_GIRL_NAME);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    protected static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public TileEntity createNewTileEntity(World par1World, int i) {
        return new TileEntityDollCreeperGirl();
    }

    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        if (entity != null) {
            TileEntityDollCreeperGirl tile = (TileEntityDollCreeperGirl) world.getTileEntity(pos);
            tile.direction = MathHelper.floor((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        }
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
            @Nullable Entity entityIn, boolean p_185477_7_) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }
}
