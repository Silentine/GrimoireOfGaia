package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.registry.helper.MobReg;
import gaia.registry.helper.PropReg;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.criterion.EnterBlockTrigger;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.KilledTrigger;
import net.minecraft.core.ClientAsset;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class GaiaAdvancementProvider extends AdvancementProvider {
	public static final Map<EntityType<?>, AdvancementHolder> entityTypeAdvancementMap = new HashMap<>();

	public GaiaAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, List.of(new GaiaAdvancementGenerator()));
	}

	public static class GaiaAdvancementGenerator implements AdvancementSubProvider {

		@Override
		public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer) {
			HolderLookup<EntityType<?>> entityTypes = registries.lookupOrThrow(Registries.ENTITY_TYPE);

			//Root advancement
			AdvancementHolder root = Advancement.Builder.advancement()
					.display(rootDisplay(GaiaRegistry.DOLL_DRYAD.get(), advancementPrefix("root" + ".title"),
							advancementPrefix("root" + ".desc"), modLoc("textures/block/pearl_block_bottom.png")))
					.addCriterion("join", EnterBlockTrigger.TriggerInstance.entersBlock(Blocks.AIR))
					.save(consumer, rootID("root"));

			//Generate an advancement for every mob in GaiaRegistry
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.ANT_SALVAGER, GaiaRegistry.PROJECTILE_POISON.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.ANT_WORKER, Items.GREEN_DYE, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.ANUBIS, GaiaRegistry.SKELETON_STAFF.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.ARACHNE, GaiaRegistry.CAVE_SPIDER_STAFF.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.BANSHEE, GaiaRegistry.SOULFIRE.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.BEHENDER, GaiaRegistry.WEAPON_BOOK_ENDER.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.BONE_KNIGHT, GaiaRegistry.BONE_SHIELD.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.CECAELIA, GaiaRegistry.SHINY_PEARL.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.COBBLESTONE_GOLEM, GaiaRegistry.WEAPON_BOOK_METAL.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.CREEP, GaiaRegistry.DOLL_CREEPER_GIRL_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.CYAN_FLOWER, GaiaRegistry.MANDRAKE.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.DEATHWORD, Items.PAPER, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.DULLAHAN, GaiaRegistry.DOLL_DULLAHAN_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.ENDER_EYE, Items.ENDER_PEARL, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.FLESH_LICH, GaiaRegistry.ZOMBIE_STAFF.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.GELATINOUS_SLIME, GaiaRegistry.DOLL_SLIME_GIRL_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.GOBLIN_FERAL, Items.WOODEN_AXE, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.GRAVEMITE, Items.COBBLESTONE, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.HARPY, GaiaRegistry.DECO_NEST_HARPY_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.KOBOLD, Items.BOW, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.MANDRAGORA, GaiaRegistry.DECO_GARDEN_GNOME_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.MATANGO, Items.RED_MUSHROOM, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.MIMIC, Items.CHEST, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.MINOTAUR, GaiaRegistry.MINOTAUR_HAMMER.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.MINOTAURUS, GaiaRegistry.WEAPON_BOOK_BATTLE.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.MUMMY, Items.ROTTEN_FLESH, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.NAGA, GaiaRegistry.GOLD_SHIELD.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.NINE_TAILS, GaiaRegistry.DOLL_NINE_TAILS_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.ONI, GaiaRegistry.METAL_CLUB.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.ORC, Items.STONE_AXE, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SHAMAN, GaiaRegistry.ROTTEN_HEART.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SHARKO, GaiaRegistry.SHINY_PEARL.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SIREN, Items.COD, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SLUDGE_GIRL, Items.SLIME_BALL, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SPHINX, GaiaRegistry.BUST_SPHINX_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SPORELING, Items.BROWN_MUSHROOM, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SPRIGGAN, Items.OAK_LOG, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.SUCCUBUS, GaiaRegistry.FIRESHARD.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.TOAD, Items.SLIME_BALL, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.VALKYRIE, GaiaRegistry.BUST_VALKYRIE_ITEM.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.WERECAT, GaiaRegistry.MEAT.get(), root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.WITCH, Items.POTION, root);
			addKillAdvancement(consumer, entityTypes, GaiaRegistry.WITHER_COW, GaiaRegistry.WITHERED_BRAIN.get(), root);
		}

		/**
		 * Adds an advancement for killing a mob.
		 *
		 * @param consumer The consumer to add to.
		 * @param mobReg   The mob registry object.
		 * @param item     The item to display in the advancement.
		 * @param root     The root advancement.
		 */
		protected static void addKillAdvancement(Consumer<AdvancementHolder> consumer, HolderLookup<EntityType<?>> entityTypes,
		                                         MobReg<? extends LivingEntity> mobReg, @Nullable Item item, AdvancementHolder root) {
			Identifier registryLocation = modLoc(mobReg.getName());
			Item icon = item != null ? item : mobReg.getSpawnEgg().asOptional().orElse(Items.EGG);
			AdvancementHolder advancement = Advancement.Builder.advancement()
					.display(simpleDisplay(icon, registryLocation.getPath()))
					.parent(root)
					.addCriterion("kill", onKill(entityTypes, mobReg.getEntityType()))
					.save(consumer, rootID(registryLocation.getPath()));
			entityTypeAdvancementMap.put(mobReg.getEntityType(), advancement);
		}

		/**
		 * Adds an advancement for killing a prop mob.
		 *
		 * @param consumer The consumer to add to.
		 * @param propReg  The prop mob registry object.
		 * @param item     The item to display in the advancement.
		 * @param root     The root advancement.
		 */
		protected static void addKillAdvancement(Consumer<AdvancementHolder> consumer, HolderLookup<EntityType<?>> entityTypes,
		                                         PropReg<? extends LivingEntity> propReg, @Nullable Item item, AdvancementHolder root) {
			Identifier registryLocation = modLoc(propReg.getName());
			Item icon = item != null ? item : propReg.getSpawnEgg().asOptional().orElse(Items.EGG);
			AdvancementHolder advancement = Advancement.Builder.advancement()
					.display(simpleDisplay(icon, registryLocation.getPath()))
					.parent(root)
					.addCriterion("kill", onKill(entityTypes, propReg.getEntityType()))
					.save(consumer, rootID(registryLocation.getPath()));
			entityTypeAdvancementMap.put(propReg.getEntityType(), advancement);
		}

		/**
		 * Generate a root DisplayInfo object.
		 *
		 * @param icon       The icon to use.
		 * @param titleKey   The title key.
		 * @param descKey    The description key.
		 * @param background The background texture.
		 * @return The DisplayInfo object.
		 */
		protected static DisplayInfo rootDisplay(ItemLike icon, String titleKey, String descKey, Identifier background) {
			return new DisplayInfo(new ItemStackTemplate(icon.asItem()),
					Component.translatable(titleKey),
					Component.translatable(descKey),
					Optional.of(new ClientAsset.ResourceTexture(background)), AdvancementType.TASK, false, false, false);
		}

		/**
		 * Generate a simple DisplayInfo object.
		 *
		 * @param icon The icon to use.
		 * @param name The name of the advancement.
		 * @return The DisplayInfo object.
		 */
		protected static DisplayInfo simpleDisplay(ItemLike icon, String name) {
			return new DisplayInfo(new ItemStackTemplate(icon.asItem()),
					Component.translatable(advancementPrefix(name + ".title")),
					Component.translatable(advancementPrefix(name + ".desc")),
					Optional.empty(), AdvancementType.TASK, true, false, false);
		}

		/**
		 * Get a trigger instance for killing an entity.
		 *
		 * @param entityType The entity type.
		 * @return The trigger instance.
		 */
		protected static Criterion<KilledTrigger.TriggerInstance> onKill(HolderGetter<EntityType<?>> entityTypes, EntityType<?> entityType) {
			return KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entityTypes, entityType));
		}

		/**
		 * Generate a Identifier that has the mod ID as the namespace.
		 *
		 * @param path The path.
		 * @return The Identifier.
		 */
		private static Identifier modLoc(String path) {
			return Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, path);
		}

		/**
		 * Generate an advancement prefix.
		 *
		 * @param name The name of the advancement.
		 * @return The prefix.
		 */
		private static String advancementPrefix(String name) {
			return "advancement." + GrimoireOfGaia.MOD_ID + "." + name;
		}

		/**
		 * Generate a root advancement ID.
		 *
		 * @param name The name of the advancement.
		 * @return The advancement ID.
		 */
		private static String rootID(String name) {
			return modLoc("main/" + name).toString();
		}
	}
}
