package gaia.item.loot;

import gaia.init.GaiaSounds;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Random;

public class ItemSpawn extends ItemGaiaLootable {
	public ItemSpawn(Item.Properties builder) {
		super(builder); //"spawn");
		//setMaxStackSize(1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.RightClickUse"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand handIn) {
		ItemStack stack = player.getHeldItem(handIn);

		player.playSound(GaiaSounds.BOX_OPEN_2, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random random = new Random();
		int i = random.nextInt(6);
		switch (i) {
//			case 0: TODO: Spawn items of traders
//				return loot(GaiaItems.SPAWN_CREEPER_GIRL.get());
//			case 1:
//				return loot(GaiaItems.SPAWN_ENDER_GIRL.get());
//			case 2:
//				return loot(GaiaItems.SPAWN_HOLSTAURUS.get());
//			case 3:
//				return loot(GaiaItems.SPAWN_SLIME_GIRL.get());
//			case 4:
//				return loot(GaiaItems.SPAWN_TRADER.get());
//			case 5:
//				return loot(GaiaItems.SPAWN_WERESHEEP.get());
			default:
				return new ActionResult<>(ActionResultType.SUCCESS, stack);
		}
	}
}
