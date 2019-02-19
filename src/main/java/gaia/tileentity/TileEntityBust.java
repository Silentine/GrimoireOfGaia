package gaia.tileentity;

import javax.annotation.Nullable;

import gaia.init.GaiaTileType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntityBust extends TileEntity {
	public TileEntityBust() {
		super(GaiaTileType.GAIA_BUST);
	}

	private EnumFacing direction;

	public void setDirection(EnumFacing direction) {
		this.direction = direction;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		read(pkt.getNbtCompound());
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		super.handleUpdateTag(tag);
		read(tag);
	}
	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		
		direction = EnumFacing.byHorizontalIndex(compound.getInt("direction"));
	}
	
	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		super.write(compound);
		compound.setInt("direction", direction.getHorizontalIndex());
		return compound;
	}


	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, 5, getUpdateTag());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return write(new NBTTagCompound());
	}

	public EnumFacing getDirection() {
		return direction;
	}
}
