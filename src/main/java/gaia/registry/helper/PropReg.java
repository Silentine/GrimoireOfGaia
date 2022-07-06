package gaia.registry.helper;

import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTabs;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

/**
 * Helper class for registering mob's with spawn eggs.
 */
public class PropReg<T extends Mob> {
	protected final String name;
	protected final RegistryObject<EntityType<? extends T>> entityType;
	protected final RegistryObject<Item> spawnEgg;

	/**
	 * @return The registry name of the mob
	 */
	@Nonnull
	public String getName() {
		return name;
	}

	/**
	 * @return The entity type registry object of the mob.
	 */
	public EntityType<? extends T> getEntityType() {
		return entityType.get();
	}

	/**
	 * @return The spawn egg item registry object of the mob.
	 */
	public RegistryObject<Item> getSpawnEgg() {
		return spawnEgg;
	}

	public PropReg(String name, EntityType.Builder<T> builder, int backgroundColor, int highlightColor) {
		this.name = name;
		this.entityType = GaiaRegistry.ENTITIES.register(name, () -> builder.build(name));
		this.spawnEgg = GaiaRegistry.ITEMS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(this.entityType, backgroundColor, highlightColor,
				new Item.Properties().tab(GaiaTabs.GAIA_TAB)));
	}
}
