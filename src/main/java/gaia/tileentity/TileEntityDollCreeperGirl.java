package gaia.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDollCreeperGirl extends TileEntity {

	public int direction;

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean canUpdate() {
		return true;
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	public Packet getDescriptionPacket() {
		S35PacketUpdateTileEntity datapacket = null;
		NBTTagCompound blockinfo = new NBTTagCompound();
		if (blockinfo.toString() != "") {
			this.writeToNBT(blockinfo);
		}

		datapacket = new S35PacketUpdateTileEntity(this.getPos(), 5, blockinfo);
		return datapacket;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.direction = nbt.getInteger("direction");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		new NBTTagList();
		nbt.setInteger("direction", this.direction);
	}
}
