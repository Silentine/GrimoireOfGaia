package gaia.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityBustSphinx extends TileEntity {

    public int direction;

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean canUpdate() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
    }

    public Packet<?> getDescriptionPacket() {
        NBTTagCompound blockinfo = new NBTTagCompound();
        if (!blockinfo.toString()
                .isEmpty()) {
            writeToNBT(blockinfo);
        }

        return new SPacketUpdateTileEntity(getPos(), 5, blockinfo);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        direction = nbt.getInteger("direction");
    }

    @Override
    public @Nonnull
            NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("direction", direction);
        return nbt;
    }

    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(pos, 5, getUpdateTag());
    }

    @Override
    public @Nonnull
            NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }
}
