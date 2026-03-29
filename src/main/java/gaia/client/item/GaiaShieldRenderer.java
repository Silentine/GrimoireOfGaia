package gaia.client.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Transformation;
import com.mojang.serialization.MapCodec;
import gaia.Reference;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class GaiaShieldRenderer implements SpecialModelRenderer<DataComponentMap> {
	public static final Transformation DEFAULT_TRANSFORMATION = new Transformation(null, null, new Vector3f(1.0F, -1.0F, -1.0F), null);
	public static final Map<String, SpriteId> SPRITE_MAP = Map.of(
			"bone_shield", Sheets.SHIELD_MAPPER.apply(Reference.modLoc("bone_shield")),
			"stone_shield", Sheets.SHIELD_MAPPER.apply(Reference.modLoc("stone_shield")),
			"iron_shield", Sheets.SHIELD_MAPPER.apply(Reference.modLoc("iron_shield")),
			"gold_shield", Sheets.SHIELD_MAPPER.apply(Reference.modLoc("gold_shield"))
	);
	private final SpriteGetter sprites;
	private final ShieldModel model;
	private SpriteId texture;

	public GaiaShieldRenderer(SpriteGetter sprites, ShieldModel model) {
		this.sprites = sprites;
		this.model = model;
	}

	public @Nullable DataComponentMap extractArgument(ItemStack stack) {
		if (!stack.isEmpty() && stack.getItem() instanceof ShieldItem) {
			this.texture = SPRITE_MAP.getOrDefault(stack.typeHolder().unwrapKey().orElseThrow().identifier().getPath(), null);
		}
		return stack.immutableComponents();
	}

	public void submit(
			@Nullable DataComponentMap components,
			PoseStack poseStack,
			SubmitNodeCollector submitNodeCollector,
			int lightCoords,
			int overlayCoords,
			boolean hasFoil,
			int outlineColor
	) {
		SpriteId usedTexture = this.texture != null ? texture : Sheets.SHIELD_BASE_NO_PATTERN;
		BannerPatternLayers patterns = components != null
				? components.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
				: BannerPatternLayers.EMPTY;
		DyeColor baseColor = components != null ? components.get(DataComponents.BASE_COLOR) : null;
		boolean hasPatterns = !patterns.layers().isEmpty() || baseColor != null;
		SpriteId base = hasPatterns ? Sheets.SHIELD_BASE : usedTexture;
		submitNodeCollector.submitModel(this.model, Unit.INSTANCE, poseStack, lightCoords, overlayCoords, -1,
				base, this.sprites, outlineColor, null);
		if (hasPatterns) {
			BannerRenderer.submitPatterns(
					this.sprites,
					poseStack,
					submitNodeCollector,
					lightCoords,
					overlayCoords,
					this.model,
					Unit.INSTANCE,
					false,
					Objects.requireNonNullElse(baseColor, DyeColor.WHITE),
					patterns,
					null
			);
		}

		if (hasFoil) {
			submitNodeCollector.submitModel(
					this.model, Unit.INSTANCE, poseStack, RenderTypes.entityGlint(), lightCoords, overlayCoords, -1, this.sprites.get(base), 0, null
			);
		}
	}

	@Override
	public void getExtents(Consumer<Vector3fc> output) {
		PoseStack poseStack = new PoseStack();
		this.model.root().getExtentsForGui(poseStack, output);
	}

	public record Unbaked() implements SpecialModelRenderer.Unbaked<DataComponentMap> {
		public static final GaiaShieldRenderer.Unbaked INSTANCE = new GaiaShieldRenderer.Unbaked();
		public static final MapCodec<GaiaShieldRenderer.Unbaked> MAP_CODEC = MapCodec.unit(INSTANCE);

		@Override
		public MapCodec<GaiaShieldRenderer.Unbaked> type() {
			return MAP_CODEC;
		}

		public GaiaShieldRenderer bake(SpecialModelRenderer.BakingContext context) {
			return new GaiaShieldRenderer(context.sprites(), new ShieldModel(context.entityModelSet().bakeLayer(ModelLayers.SHIELD)));
		}
	}
}
