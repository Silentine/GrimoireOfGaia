package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemShard extends Item {
	String texture;

	public ItemShard(String texture) {
		this.texture = texture;
        this.setHasSubtypes(true);
		this.setUnlocalizedName("GrimoireOfGaia.Shard");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public IIcon[] icons = new IIcon[7];

	@Override
	public void registerIcons(IIconRegister reg) {
		this.icons[0] = reg.registerIcon("gaia:" + "ShardIron");
		this.icons[1] = reg.registerIcon("gaia:" + "ShardGold");
		this.icons[2] = reg.registerIcon("gaia:" + "ShardDiamond");
		this.icons[3] = reg.registerIcon("gaia:" + "ShardEmerald");
		this.icons[4] = reg.registerIcon("gaia:" + "ShardNetherStar");
		this.icons[5] = reg.registerIcon("gaia:" + "ShardEnderPearl");
		this.icons[6] = reg.registerIcon("gaia:" + "ShardBlazeRod");
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > 6) meta = 0;
		return this.icons[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 7; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
}
