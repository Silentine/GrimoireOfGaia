package gaia.datagen.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetEnchantmentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class GaiaLoot extends LootTableProvider {
	public GaiaLoot(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
		return ImmutableList.of(
				Pair.of(GaiaBlockTables::new, LootContextParamSets.BLOCK),
				Pair.of(GaiaEntityLoot::new, LootContextParamSets.ENTITY));
	}

	public static class GaiaBlockTables extends BlockLoot {
		@Override
		protected void addTables() {
			this.dropSelf(GaiaRegistry.BUST_GORGON.get());
			this.dropSelf(GaiaRegistry.BUST_SPHINX.get());
			this.dropSelf(GaiaRegistry.BUST_VALKYRIE.get());
			this.dropSelf(GaiaRegistry.BUST_VAMPIRE.get());
			this.dropSelf(GaiaRegistry.BUST_MINOTAUR.get());
			this.dropSelf(GaiaRegistry.DOLL_CREEPER_GIRL.get());
			this.dropSelf(GaiaRegistry.DOLL_ENDER_GIRL.get());
			this.dropSelf(GaiaRegistry.DOLL_SLIME_GIRL.get());
			this.dropSelf(GaiaRegistry.DOLL_MAID.get());
			this.dropSelf(GaiaRegistry.DOLL_DULLAHAN.get());
			this.dropSelf(GaiaRegistry.DOLL_MERMAID.get());
			this.dropSelf(GaiaRegistry.DOLL_NINE_TAILS.get());
			this.dropSelf(GaiaRegistry.DOLL_DRYAD.get());
			this.dropSelf(GaiaRegistry.DECO_GARDEN_GNOME.get());
			this.dropSelf(GaiaRegistry.DECO_MANDRAGORA_POT.get());
			this.dropSelf(GaiaRegistry.DECO_NEST_HARPY.get());
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) GaiaRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
		}
	}

	private static class GaiaEntityLoot extends EntityLoot {

		@Override
		protected void addTables() {
			this.add(GaiaRegistry.ANT_HILL.getEntityType(), LootTable.lootTable());
			this.add(GaiaRegistry.ANT_WORKER.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.GREEN_DYE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.HONEYDEW.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
			);
			this.add(GaiaRegistry.ANUBIS.getEntityType(), LootTable.lootTable()
							.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
									.add(TagEntry.expandTag(Tags.Items.NUGGETS_GOLD)
											.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
							.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.025F))
									.add(LootItem.lootTableItem(GaiaRegistry.BOX_GOLD.get()))
									.add(LootItem.lootTableItem(GaiaRegistry.BAG_BOOK.get())))
							.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
									.add(LootItem.lootTableItem(GaiaRegistry.BOOK_OF_MEMORY.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
//					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//							.add(LootItem.lootTableItem(GaiaRegistry.SPAWN_WERESHEEP.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.CENTAUR.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.LEATHER)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_ARROWS.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.CREEP.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.GUNPOWDER)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_OVERWORLD.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.DOLL_CREEPER_GIRL.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.CYCLOPS.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.FUR.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.BOOK)
									.apply(new SetEnchantmentsFunction.Builder().withEnchantment(Enchantments.SHARPNESS, ConstantValue.exactly(1.0F)))
									.when(LootItemRandomChanceCondition.randomChance(0.01F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.KNUCKLES.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.DRYAD.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.TAPROOT.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(ItemTags.LOGS_THAT_BURN)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
							.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER,
									EntityPredicate.Builder.entity().equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(GaiaTags.TOOLS_AXES).build()).build()))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.DOLL_DRYAD.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.DULLAHAN.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.SOULFIRE.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.DOLL_DULLAHAN.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.HARPY.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.FEATHER)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.DECO_NEST_HARPY.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.HUNTER.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.ROTTEN_HEART.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_ARROWS.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.KOBOLD.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.FUR.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_ARROWS.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.MATANGO.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.MUSHROOMS)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
			);
			this.add(GaiaRegistry.NINE_TAILS.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.SOULFIRE.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_GOLD)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.025F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_GOLD.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_BOOK.get())))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.FAN_FIRE.get())
									.apply(new SetEnchantmentsFunction.Builder()
											.withEnchantment(Enchantments.FIRE_ASPECT, ConstantValue.exactly(2.0F))
											.withEnchantment(Enchantments.KNOCKBACK, ConstantValue.exactly(1.0F)))
									.when(LootItemRandomChanceCondition.randomChance(0.01F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.DOLL_NINE_TAILS.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.ONI.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.SOULFIRE.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.BOOK)
									.apply(new SetEnchantmentsFunction.Builder().withEnchantment(Enchantments.SHARPNESS, ConstantValue.exactly(1.0F)))
									.when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.SHAMAN.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.ROTTEN_HEART.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.025F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_GOLD.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_BOOK.get())))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOOK_OF_MEMORY.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
			);
			this.add(GaiaRegistry.SIREN.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(BuiltInLootTables.FISHING_FISH)
									.apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_ARROWS.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);
			this.add(GaiaRegistry.SLUDGE_GIRL.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.SLIME_BALL)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
			);
			this.add(GaiaRegistry.SPORELING.getEntityType(), LootTable.lootTable());
			this.add(GaiaRegistry.SUCCUBUS.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.FIRESHARD.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.QUARTZ))
							.add(LootItem.lootTableItem(Items.GLOWSTONE_DUST)))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_NETHER.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
			);
			this.add(GaiaRegistry.WERECAT.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.MEAT.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_IRON)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_IRON.get()).when(LootItemRandomChanceCondition.randomChance(0.025F))))
			);
			this.add(GaiaRegistry.YUKI_ONNA.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.FUR.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(TagEntry.expandTag(Tags.Items.NUGGETS_GOLD)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.025F))
							.add(LootItem.lootTableItem(GaiaRegistry.BOX_GOLD.get()))
							.add(LootItem.lootTableItem(GaiaRegistry.BAG_BOOK.get()))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(GaiaRegistry.FAN_ICE.get()).when(LootItemRandomChanceCondition.randomChance(0.01F))))
			);

			this.add(GaiaRegistry.HORSE.getEntityType(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(EntityType.ZOMBIE_HORSE.getDefaultLootTable())))
			);
		}

		@Override
		protected Iterable<EntityType<?>> getKnownEntities() {
			Stream<EntityType<?>> entities = GaiaRegistry.ENTITIES.getEntries().stream().map(RegistryObject::get);
			return (Iterable<EntityType<?>>) entities::iterator;
		}
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
		List<ResourceLocation> ignored = List.of(GaiaRegistry.HORSE.getEntityType().getDefaultLootTable(), GaiaRegistry.SIREN.getEntityType().getDefaultLootTable());
		map.forEach((name, table) -> {
			if (!ignored.contains(name)) {
				LootTables.validate(validationContext, name, table);
			}
		});
	}
}
