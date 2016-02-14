package gaia.block;

import gaia.Gaia;
import gaia.tileentity.TileEntityDollMaid;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDollMaid extends BlockContainer {

	public BlockDollMaid(Material par2Material) {
		super(par2Material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
		this.setLightOpacity(0);
		this.setHardness(3.0F);
		this.setResistance(6.0F);
		this.setBlockName("GrimoireOfGaia.DollMaid");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public int getRenderType() {
		return -1;
	}

	public TileEntity createNewTileEntity(World par1World, int i) {
		return new TileEntityDollMaid();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if(entity != null) {
			TileEntityDollMaid tile = (TileEntityDollMaid)world.getTileEntity(x, y, z);
			tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		}
	}
}
