package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItem;
import gaia.init.Sounds;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawn extends Gaia_Lootable {
	String texture;

	public ItemSpawn(String texture) {
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.Spawn");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{
		player.playSound(Sounds.box_open2, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		Random random = new Random();
		int i = random.nextInt(5);
		switch(i) {
		case 0:
			return loot(GaiaItem.SpawnCreeperGirl);
		case 1:
			return loot(GaiaItem.SpawnEnderGirl);
		case 2:
			return loot(GaiaItem.SpawnHolstaurus);
		case 3:
			return loot(GaiaItem.SpawnSlimeGirl);
		case 4:
			return loot(GaiaItem.SpawnTrader);
		default:
			return new ActionResult(EnumActionResult.SUCCESS, stack);
		}
	}
}
