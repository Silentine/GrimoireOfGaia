package gaia.items;

import java.util.List;
import java.util.Random;

import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSpawn extends ItemGaiaLootable {
	public ItemSpawn(Item.Properties builder) {
		super(builder); //"spawn");
		//setMaxStackSize(1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.RightClickUse"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		ItemStack stack = player.getHeldItem(handIn);

		player.playSound(GaiaSounds.BOX_OPEN_2, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random random = new Random();
		int i = random.nextInt(6);
		switch (i) {
			case 0:
				return loot(GaiaItems.SPAWN_CREEPER_GIRL);
			case 1:
				return loot(GaiaItems.SPAWN_ENDER_GIRL);
			case 2:
				return loot(GaiaItems.SPAWN_HOLSTAURUS);
			case 3:
				return loot(GaiaItems.SPAWN_SLIME_GIRL);
			case 4:
				return loot(GaiaItems.SPAWN_TRADER);
			case 5:
				return loot(GaiaItems.SPAWN_WERESHEEP);
			default:
				return new ActionResult<>(EnumActionResult.SUCCESS, stack);
		}
	}
}
