package gaia.block;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpawnGuard extends Block {

    private static final PropertyEnum<BlockSpawnGuard.EnumType> TYPE = PropertyEnum.create("type", BlockSpawnGuard.EnumType.class);

    public BlockSpawnGuard() {
        super(Material.CLOTH);
        this.setLightOpacity(0);
        this.setHardness(0.0F);
        this.setResistance(6.0F);
        this.setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, "SpawnGuard"));
        this.setUnlocalizedName("SpawnGuard");
        this.setCreativeTab(CreativeTabGaia.INSTANCE);

        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(TYPE, EnumType.North));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.grimoireofgaia.desc")));
        tooltip.add(I18n.format("block.grimoireofgaia.SpawnGuard.desc", 8));
    }

    protected static final AxisAlignedBB Down_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.06F, 1.0F);
    protected static final AxisAlignedBB Up_BOX = new AxisAlignedBB(0.0F, 0.94F, 0.0F, 1.0F, 1.0F, 1.0F);
    protected static final AxisAlignedBB North_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.94F, 1.0F, 1.0F, 1.0F);
    protected static final AxisAlignedBB South_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.06F);
    protected static final AxisAlignedBB West_BOX = new AxisAlignedBB(0.94F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    protected static final AxisAlignedBB East_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 0.06F, 1.0F, 1.0F);

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public @Nonnull EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    /* Legacy tile entity code
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
        if (meta < 4) {
            return Down_BOX;
        }
        if (8 > meta && meta > 3) {
            return Up_BOX;
        }
        switch (meta) {
            case 8:
                return North_BOX;
            case 9:
                return South_BOX;
            case 10:
                return West_BOX;
            case 11:
                return East_BOX;
            default:
                return Down_BOX;
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

    @Override
    @MethodsReturnNonnullByDefault
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
            EntityLivingBase placer) {
        int ID;
        int face = facing.getIndex();
        if (facing == EnumFacing.UP) {
            ID = MathHelper.floor((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        } else if (facing == EnumFacing.DOWN) {
            ID = (MathHelper.floor((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 4;
        } else {
            ID = face + 6;
        }

        return getStateFromMeta(ID);
    }

    @Override
    protected @Nonnull BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

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

        public static EnumType getConstant(int meta) {
            if (0 > meta || meta > 11) {
                meta = 0;
            }
            return EnumType.values()[meta];
        }
    }
}
