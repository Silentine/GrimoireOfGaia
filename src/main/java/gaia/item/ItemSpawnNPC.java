package gaia.item;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ItemSpawnNPC extends Item {
	private static final Map<EntityType<?>, ItemSpawnNPC> EGGS = Maps.newIdentityHashMap();
	private final Rarity rarity;
	private final EntityType<?> typeIn;

	public ItemSpawnNPC(Item.Properties builder, Rarity rarity, EntityType<?> typeIn) {
		super(builder.maxStackSize(16));
		this.rarity = rarity;;
		this.typeIn = typeIn;
		EGGS.put(typeIn, this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return rarity;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		String name = getTranslationKey(stack);
		tooltip.add(new TranslationTextComponent(name + ".desc"));
	}

	public ActionResultType onItemUse(ItemUseContext useContext) {
		World worldIn = useContext.getWorld();
		if (worldIn.isRemote) {
			return ActionResultType.SUCCESS;
		} else {
			ItemStack stack = useContext.getItem();
			BlockPos pos = useContext.getPos();
			Direction face = useContext.getFace();
			BlockState blockstate = worldIn.getBlockState(pos);
			Block block = blockstate.getBlock();
			if (block == Blocks.SPAWNER) {
				TileEntity tile = worldIn.getTileEntity(pos);
				if (tile instanceof MobSpawnerTileEntity) {
					AbstractSpawner spawner = ((MobSpawnerTileEntity)tile).getSpawnerBaseLogic();
					EntityType<?> type = this.getType(stack.getTag());
					spawner.setEntityType(type);
					tile.markDirty();
					worldIn.notifyBlockUpdate(pos, blockstate, blockstate, 3);
					stack.shrink(1);
					return ActionResultType.SUCCESS;
				}
			}

			BlockPos pos2;
			if (blockstate.getCollisionShape(worldIn, pos).isEmpty()) {
				pos2 = pos;
			} else {
				pos2 = pos.offset(face);
			}

			EntityType<?> type2 = this.getType(stack.getTag());
			if (type2.spawn(worldIn, stack, useContext.getPlayer(), pos2, SpawnReason.SPAWN_EGG, true, !Objects.equals(pos, pos2) && face == Direction.UP) != null) {
				stack.shrink(1);
			}

			return ActionResultType.SUCCESS;
		}
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		if (worldIn.isRemote) {
			return new ActionResult(ActionResultType.PASS, stack);
		} else {
			RayTraceResult trace = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
			if (trace.getType() != RayTraceResult.Type.BLOCK) {
				return new ActionResult(ActionResultType.PASS, stack);
			} else {
				BlockRayTraceResult blockTrace = (BlockRayTraceResult)trace;
				BlockPos blockPos = blockTrace.getPos();
				if (!(worldIn.getBlockState(blockPos).getBlock() instanceof FlowingFluidBlock)) {
					return new ActionResult(ActionResultType.PASS, stack);
				} else if (worldIn.isBlockModifiable(playerIn, blockPos) && playerIn.canPlayerEdit(blockPos, blockTrace.getFace(), stack)) {
					EntityType<?> type = this.getType(stack.getTag());
					if (type.spawn(worldIn, stack, playerIn, blockPos, SpawnReason.SPAWN_EGG, false, false) == null) {
						return new ActionResult(ActionResultType.PASS, stack);
					} else {
						if (!playerIn.abilities.isCreativeMode) {
							stack.shrink(1);
						}

						playerIn.addStat(Stats.ITEM_USED.get(this));
						return new ActionResult(ActionResultType.SUCCESS, stack);
					}
				} else {
					return new ActionResult(ActionResultType.FAIL, stack);
				}
			}
		}
	}

	@Nullable
	public EntityType<?> getType(@Nullable CompoundNBT tag) {
		if (tag != null && tag.contains("EntityTag", 10)) {
			CompoundNBT entityTag = tag.getCompound("EntityTag");
			if (entityTag.contains("id", 8)) {
				return EntityType.byKey(entityTag.getString("id")).orElse(this.typeIn);
			}
		}

		return this.typeIn;
	}
}
