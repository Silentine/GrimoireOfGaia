package gaia.items;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowingFluid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ItemSpawnNPC extends ItemBase {
	private static final Map<EntityType<?>, ItemSpawnNPC> EGGS = Maps.newIdentityHashMap();
	private final EnumRarity rarity;
	private final EntityType<?> typeIn;

	public ItemSpawnNPC(Item.Properties builder, EnumRarity rarity, EntityType<?> typeIn) {
		super(builder.maxStackSize(16));
		this.rarity = rarity;;
		this.typeIn = typeIn;
		EGGS.put(typeIn, this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return rarity;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		String name = getTranslationKey(stack);
		tooltip.add(new TextComponentTranslation(name + ".desc"));
	}

	public EnumActionResult onItemUse(ItemUseContext context) {
		World worldIn = context.getWorld();
		if (worldIn.isRemote) {
			return EnumActionResult.SUCCESS;
		} else {
			ItemStack stack = context.getItem();
			BlockPos pos = context.getPos();
			EnumFacing face = context.getFace();
			IBlockState state = worldIn.getBlockState(pos);
			Block block = state.getBlock();
			if (block == Blocks.SPAWNER) {
				TileEntity tile = worldIn.getTileEntity(pos);
				if (tile instanceof TileEntityMobSpawner) {
					MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)tile).getSpawnerBaseLogic();
					EntityType<?> typeIn = this.getType(stack.getTag());
					if (typeIn != null) {
						logic.setEntityType(typeIn);
						tile.markDirty();
						worldIn.notifyBlockUpdate(pos, state, state, 3);
					}

					stack.shrink(1);
					return EnumActionResult.SUCCESS;
				}
			}

			BlockPos pos2;
			if (state.getCollisionShape(worldIn, pos).isEmpty()) {
				pos2 = pos;
			} else {
				pos2 = pos.offset(face);
			}

			EntityType<?> typeIn2 = this.getType(stack.getTag());
			if (typeIn2 == null || typeIn2.spawnEntity(worldIn, stack, context.getPlayer(), pos2, true, !Objects.equals(pos, pos2) && face == EnumFacing.UP) != null) {
				stack.shrink(1);
			}

			return EnumActionResult.SUCCESS;
		}
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		if (worldIn.isRemote) {
			return new ActionResult(EnumActionResult.PASS, stack);
		} else {
			RayTraceResult result = this.rayTrace(worldIn, playerIn, true);
			if (result != null && result.type == RayTraceResult.Type.BLOCK) {
				BlockPos pos = result.getBlockPos();
				if (!(worldIn.getBlockState(pos).getBlock() instanceof BlockFlowingFluid)) {
					return new ActionResult(EnumActionResult.PASS, stack);
				} else if (worldIn.isBlockModifiable(playerIn, pos) && playerIn.canPlayerEdit(pos, result.sideHit, stack)) {
					EntityType<?> typeIn = this.getType(stack.getTag());
					if (typeIn != null && typeIn.spawnEntity(worldIn, stack, playerIn, pos, false, false) != null) {
						if (!playerIn.abilities.isCreativeMode) {
							stack.shrink(1);
						}

						playerIn.addStat(StatList.ITEM_USED.get(this));
						return new ActionResult(EnumActionResult.SUCCESS, stack);
					} else {
						return new ActionResult(EnumActionResult.PASS, stack);
					}
				} else {
					return new ActionResult(EnumActionResult.FAIL, stack);
				}
			} else {
				return new ActionResult(EnumActionResult.PASS, stack);
			}
		}
	}

	@Nullable
	public EntityType<?> getType(@Nullable NBTTagCompound tag) {
		if (tag != null && tag.contains("EntityTag", 10)) {
			NBTTagCompound entityTag = tag.getCompound("EntityTag");
			if (entityTag.contains("id", 8)) {
				return EntityType.getById(entityTag.getString("id"));
			}
		}

		return this.typeIn;
	}
}
