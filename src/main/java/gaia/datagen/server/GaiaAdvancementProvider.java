package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.registry.helper.MobReg;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GaiaAdvancementProvider extends AdvancementProvider {
	public static final Map<EntityType<?>, Advancement> entityTypeAdvancementMap = new HashMap<>();

	public GaiaAdvancementProvider(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
		super(generatorIn, fileHelperIn);
	}

	@Override
	protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
		//Root advancement
		Advancement root = Advancement.Builder.advancement()
				.display(rootDisplay(GaiaRegistry.DOLL_DRYAD.get(), advancementPrefix("root" + ".title"),
						advancementPrefix("root" + ".desc"), modLoc("textures/block/pearl_block_bottom.png")))
				.addCriterion("join", EnterBlockTrigger.TriggerInstance.entersBlock(Blocks.AIR))
				.save(consumer, rootID("root"));

		//Generate an advancement for every mob in GaiaRegistry
		addKillAdvancement(consumer, GaiaRegistry.ANT_SALVAGER, GaiaRegistry.PROJECTILE_POISON.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.ANT_WORKER, Items.GREEN_DYE, root);
		addKillAdvancement(consumer, GaiaRegistry.ANUBIS, GaiaRegistry.SKELETON_STAFF.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.ARACHNE, GaiaRegistry.CAVE_SPIDER_STAFF.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.BANSHEE, GaiaRegistry.SOULFIRE.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.BEHENDER, GaiaRegistry.WEAPON_BOOK_ENDER.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.BONE_KNIGHT, GaiaRegistry.BONE_SHIELD.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.CECAELIA, GaiaRegistry.SHINY_PEARL.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.COBBLESTONE_GOLEM, GaiaRegistry.WEAPON_BOOK_METAL.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.CREEP, GaiaRegistry.DOLL_CREEPER_GIRL_ITEM.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.DEATHWORD, Items.PAPER, root);
		addKillAdvancement(consumer, GaiaRegistry.DULLAHAN, GaiaRegistry.DOLL_DULLAHAN_ITEM.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.ENDER_EYE, Items.ENDER_PEARL, root);
		addKillAdvancement(consumer, GaiaRegistry.FLESH_LICH, GaiaRegistry.ZOMBIE_STAFF.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.GELATINOUS_SLIME, GaiaRegistry.DOLL_SLIME_GIRL_ITEM.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.GOBLIN_FERAL, Items.WOODEN_AXE, root);
		addKillAdvancement(consumer, GaiaRegistry.HARPY, GaiaRegistry.DECO_NEST_HARPY_ITEM.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.KOBOLD, Items.BOW, root);
		addKillAdvancement(consumer, GaiaRegistry.MATANGO, Items.RED_MUSHROOM, root);
		addKillAdvancement(consumer, GaiaRegistry.MIMIC, Items.CHEST, root);
		addKillAdvancement(consumer, GaiaRegistry.MINOTAUR, GaiaRegistry.MINOTAUR_HAMMER.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.MINOTAURUS, GaiaRegistry.WEAPON_BOOK_BATTLE.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.NAGA, GaiaRegistry.GOLD_SHIELD.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.NINE_TAILS, GaiaRegistry.DOLL_NINE_TAILS_ITEM.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.ONI, GaiaRegistry.METAL_CLUB.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.ORC, Items.STONE_AXE, root);
		addKillAdvancement(consumer, GaiaRegistry.SHAMAN, GaiaRegistry.ROTTEN_HEART.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.SHARKO, GaiaRegistry.SHINY_PEARL.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.SIREN, Items.COD, root);
		addKillAdvancement(consumer, GaiaRegistry.SLUDGE_GIRL, Items.SLIME_BALL, root);
		addKillAdvancement(consumer, GaiaRegistry.SPHINX, GaiaRegistry.BUST_SPHINX_ITEM.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.SPORELING, Items.BROWN_MUSHROOM, root);
		addKillAdvancement(consumer, GaiaRegistry.SPRIGGAN, Items.OAK_LOG, root);
		addKillAdvancement(consumer, GaiaRegistry.SUCCUBUS, GaiaRegistry.FIRESHARD.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.TOAD, Items.SLIME_BALL, root);
		addKillAdvancement(consumer, GaiaRegistry.VALKYRIE, GaiaRegistry.BUST_VALKYRIE_ITEM.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.WERECAT, GaiaRegistry.MEAT.get(), root);
		addKillAdvancement(consumer, GaiaRegistry.WITCH, Items.POTION, root);
		addKillAdvancement(consumer, GaiaRegistry.WITHER_COW, GaiaRegistry.WITHERED_BRAIN.get(), root);
	}

	protected static void addKillAdvancement(Consumer<Advancement> consumer, MobReg<? extends LivingEntity> mobReg, @Nullable Item item, Advancement root) {
		ResourceLocation registryLocation = modLoc(mobReg.getName());
		Item icon = item != null ? item : mobReg.getSpawnEgg().orElse(Items.EGG);
		Advancement advancement = Advancement.Builder.advancement()
				.display(simpleDisplay(icon, registryLocation.getPath()))
				.parent(root)
				.addCriterion("kill", onKill(mobReg.getEntityType()))
				.save(consumer, rootID(registryLocation.getPath()));
		entityTypeAdvancementMap.put(mobReg.getEntityType(), advancement);
	}

	protected static DisplayInfo rootDisplay(ItemLike icon, String titleKey, String descKey, ResourceLocation background) {
		return new DisplayInfo(new ItemStack(icon.asItem()),
				new TranslatableComponent(titleKey),
				new TranslatableComponent(descKey),
				background, FrameType.TASK, false, false, false);
	}

	protected static DisplayInfo simpleDisplay(ItemLike icon, String name) {
		return new DisplayInfo(new ItemStack(icon.asItem()),
				new TranslatableComponent(advancementPrefix(name + ".title")),
				new TranslatableComponent(advancementPrefix(name + ".desc")),
				null, FrameType.TASK, true, false, false);
	}

	protected static KilledTrigger.TriggerInstance onKill(EntityType<?> entityType) {
		return KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entityType));
	}

	private static ResourceLocation modLoc(String path) {
		return new ResourceLocation(GrimoireOfGaia.MOD_ID, path);
	}

	private static String advancementPrefix(String name) {
		return "advancement." + GrimoireOfGaia.MOD_ID + "." + name;
	}

	private static String rootID(String name) {
		return modLoc("main/" + name).toString();
	}
}
