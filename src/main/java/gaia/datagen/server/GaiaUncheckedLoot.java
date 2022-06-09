package gaia.datagen.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import gaia.registry.GaiaLootTables;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GaiaUncheckedLoot extends LootTableProvider {
	public GaiaUncheckedLoot(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
		return ImmutableList.of(Pair.of(GaiaBoxLoot::new, LootContextParamSets.GIFT));
	}

	private static class GaiaBoxLoot implements Consumer<BiConsumer<ResourceLocation, Builder>> {
		@Override
		public void accept(BiConsumer<ResourceLocation, Builder> consumer) {
			consumer.accept(GaiaLootTables.BAG_ARROW, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.TIPPED_ARROW)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 16.0F)))
									.apply(SetPotionFunction.setPotion(Potions.SLOWNESS)).setWeight(10))
							.add(LootItem.lootTableItem(Items.TIPPED_ARROW)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 16.0F)))
									.apply(SetPotionFunction.setPotion(Potions.HARMING)).setWeight(10))
							.add(LootItem.lootTableItem(Items.TIPPED_ARROW)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 16.0F)))
									.apply(SetPotionFunction.setPotion(Potions.POISON)).setWeight(10))
							.add(LootItem.lootTableItem(Items.TIPPED_ARROW)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 16.0F)))
									.apply(SetPotionFunction.setPotion(Potions.WEAKNESS)).setWeight(10))
					)
			);
			consumer.accept(GaiaLootTables.BAG_BOOK, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(5, 20)).allowTreasure()))
					)
			);
			consumer.accept(GaiaLootTables.BAG_RECORD, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(TagEntry.expandTag(GaiaTags.RECORDS))
					)
			);
			consumer.accept(GaiaLootTables.BOXES_HAT, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(GaiaRegistry.HEADGEAR_BOOK.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.HEADGEAR_MOB.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.HEADGEAR_BOLT.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.HEADGEAR_ARROW.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.HEADGEAR_DOLL.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.HEADGEAR_EARS_ELF.get()))
					)
			);
			//TODO: Spawn item
			consumer.accept(GaiaLootTables.BOXES_OLD, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_BOOK.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.GIGA_GEAR.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.WEAPON_BOOK_WITHER.get()))
					)
			);
			consumer.accept(GaiaLootTables.BOXES_IRON, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.IRON_INGOT)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 9.0F))))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.IRON_AXE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_PICKAXE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_SHOVEL)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_SHOVEL)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_HELMET)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_CHESTPLATE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_LEGGINGS)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_BOOTS)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_HORSE_ARMOR).setWeight(10))
					)
			);
			consumer.accept(GaiaLootTables.BOXES_GOLD, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.GOLD_INGOT)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 9.0F))))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.GOLDEN_AXE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_PICKAXE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_SHOVEL)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_SHOVEL)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_HELMET)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_CHESTPLATE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_LEGGINGS)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_BOOTS)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.GOLDEN_HORSE_ARMOR).setWeight(10))
					)
			);
			consumer.accept(GaiaLootTables.BOXES_DIAMOND, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.DIAMOND)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 9.0F))))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.DIAMOND_AXE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_SHOVEL)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_SHOVEL)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_HELMET)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_BOOTS)
									.apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR).setWeight(10))
					)
			);
			consumer.accept(GaiaLootTables.BOXES_OVERWORLD, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.GOLD_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))).setWeight(10))
							.add(LootItem.lootTableItem(Items.IRON_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))).setWeight(15))
							.add(LootItem.lootTableItem(Items.COPPER_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))).setWeight(15))
							.add(LootItem.lootTableItem(Items.COAL_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))).setWeight(15))
							.add(LootItem.lootTableItem(Items.LAPIS_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))).setWeight(10))
							.add(LootItem.lootTableItem(Items.DIAMOND_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).setWeight(5))
							.add(LootItem.lootTableItem(Items.REDSTONE_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))).setWeight(10))
							.add(LootItem.lootTableItem(Items.EMERALD_ORE).setWeight(5))
					)
			);
			consumer.accept(GaiaLootTables.BOXES_END, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.OBSIDIAN)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))).setWeight(15))
							.add(LootItem.lootTableItem(Items.END_STONE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))).setWeight(15))
					)
			);
			consumer.accept(GaiaLootTables.BOXES_NETHER, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.name("main")
							.add(LootItem.lootTableItem(Items.GLOWSTONE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))).setWeight(10))
							.add(LootItem.lootTableItem(Items.NETHER_QUARTZ_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))).setWeight(15))
							.add(LootItem.lootTableItem(Items.NETHER_GOLD_ORE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))).setWeight(15))
					)
			);
		}
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {

	}
}
