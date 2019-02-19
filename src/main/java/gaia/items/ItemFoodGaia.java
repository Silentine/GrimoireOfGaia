package gaia.items;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFoodGaia extends ItemFoodBase {

	/**
	 * Base class for food Items that rely on multiple potion effects <p>I
	 * didn't check but I'm pretty sure the previous codebase didn't work
	 */
	ItemFoodGaia(Item.Properties builder, int amount, float saturation, boolean isWolfFood) {
		super(builder, amount, saturation, isWolfFood);
	}

	@Override
	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		if (!worldIn.isRemote && secondPotion != null && worldIn.rand.nextFloat() < secondChance) {
			player.addPotionEffect(new PotionEffect(secondPotion));
		}
	}

	/**
	 * Spawns EntityXPOrb
	 */
	static void rewardEXP(EntityPlayer player, int value) {
		World world = player.world;
		EntityXPOrb entity = new EntityXPOrb(world, player.posX, player.posY + 1, player.posZ, value);

		if (!world.isRemote) {
			world.spawnEntity(entity);
		}
	}

	private PotionEffect secondPotion;
	private float secondChance;

	void setSecondPotionEffect(PotionEffect effect, float chance) {
		secondPotion = effect;
		secondChance = chance;
	}
}
