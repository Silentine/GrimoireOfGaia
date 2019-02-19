package gaia.items;

import java.util.Collection;

import com.google.common.collect.Iterables;

import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ItemShard extends ItemBase {

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
			stack = oreCheck(new ItemStack(GaiaItems.SHARD_IRON, 1), "iron");
			break;
		case 1:
			stack = oreCheck(new ItemStack(GaiaItems.SHARD_IRON, 1), "iron");
			break;
		case 2:
			stack = oreCheck(new ItemStack(GaiaItems.SHARD_IRON, 1), "iron");
			break;
		case 3:
			stack = oreCheck(new ItemStack(GaiaItems.SHARD_IRON, 1), "iron");
			break;
		case 4:
			stack = oreCheck(new ItemStack(GaiaItems.SHARD_IRON, 1), "iron");
			break;
		case 5:
			stack = oreCheck(new ItemStack(GaiaItems.SHARD_IRON, 1), "iron");
			break;

		default:
			stack = new ItemStack(GaiaItems.SHARD_IRON, 1);
			break;
		}
		
		entity.entityDropItem(stack, 0.0F);
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
				}
				return new ItemStack(getGaiaShard(s));
			}
		}

		return new ItemStack(getGaiaShard(s));
	}
	
	public static Item getGaiaShard(String oreName)
	{
		switch (oreName) {
		case "iron":
			return GaiaItems.SHARD_IRON;
		case "gold":
			return GaiaItems.SHARD_GOLD;
		case "diamond":
			return GaiaItems.SHARD_DIAMOND;
		case "emerald":
			return GaiaItems.SHARD_EMERALD;
		case "copper":
			return GaiaItems.SHARD_COPPER;
		case "silver":
			return GaiaItems.SHARD_SILVER;

		default:
			return GaiaItems.SHARD_IRON;
		}
	}
}
