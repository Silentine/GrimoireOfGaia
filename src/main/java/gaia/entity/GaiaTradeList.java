package gaia.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.village.MerchantRecipeList;

public class GaiaTradeList extends MerchantRecipeList {

	/**
	 * generated serial UID
	 */
	private static final long serialVersionUID = -5377825160709018713L;

	GaiaTradeList(NBTTagCompound tag) {
		super(tag);
	}
	
	@Override
	public void read(NBTTagCompound compound) {
		NBTTagList list = compound.getList("Recipes", 10);
		for (int i = 0; i < list.size(); ++i) {
			NBTTagCompound nbttagcompound1 = list.getCompound(i);
			this.add(new GaiaTrade(nbttagcompound1));
		}
	}
}
