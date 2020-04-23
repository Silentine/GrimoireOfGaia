package gaia.item;

import com.google.common.collect.Iterables;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;

public class ItemShard extends Item {

	public ItemShard(Item.Properties builder) {
		super(builder); //"shard");
	}

	/**
	 * Drops a nugget in the world. Will drop Gaia nuggets if no other nuggets are present.
	 * 
	 * @param entity
	 * @param i      0 = Iron, 1 = Gold, 2 = Diamond, 3 = Emerald, 4 = Copper, 5 = Silver
	 */
	public static void dropNugget(Entity entity, int i) {	
		ItemStack stack;
		
		switch (i) {
			case 0:
				stack = oreCheck(new ItemStack(GaiaItems.SHARD_IRON.get()), "iron");
				break;
			case 1:
				stack = oreCheck(new ItemStack(GaiaItems.SHARD_GOLD.get()), "gold");
				break;
			case 2:
				stack = oreCheck(new ItemStack(GaiaItems.SHARD_DIAMOND.get()), "diamond");
				break;
			case 3:
				stack = oreCheck(new ItemStack(GaiaItems.SHARD_EMERALD.get()), "emerald");
				break;
			case 4:
				stack = oreCheck(new ItemStack(GaiaItems.SHARD_COPPER.get()), "copper");
				break;
			case 5:
				stack = oreCheck(new ItemStack(GaiaItems.SHARD_SILVER.get()), "silver");
				break;
			default:
				stack = new ItemStack(GaiaItems.SHARD_IRON.get());
				break;
		}
		
		entity.entityDropItem(stack, 1);
	}

	/**
	 * Checks ore dictionary if there is already a registered nugget. Then attempts to use that instead
	 */
	private static ItemStack oreCheck(ItemStack stack, String s) {
		
		for(ResourceLocation resource : ItemTags.getCollection().getRegisteredTags())
		{
			if(resource.getNamespace().contains("nugget") && resource.getNamespace().contains(s))
			{
				Tag<Item> nugget = ItemTags.getCollection().get(resource);
				Collection<Item> itemList = nugget.getAllElements();
				if(!itemList.isEmpty())
				{
					return new ItemStack(Iterables.get(itemList, 0));
				} else {
					return stack;
				}
			}
		}
		return stack;
	}
}
