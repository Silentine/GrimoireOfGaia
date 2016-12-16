package gaia.items;

import gaia.Gaia;
import gaia.entity.EntityGaiaEggInfo;
import gaia.util.BlockStateHelper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class ItemGaiaSpawnEgg extends Item {
	private static Map<Integer, String> idToName = new HashMap();
	public static Map<Integer, EntityGaiaEggInfo> idToEgg = new HashMap();
	private static Map<Integer, Class<? extends EntityLiving>> idToClass = new HashMap();
	private static Map<Class<? extends EntityLiving>, Integer> classToID = new HashMap();

	public static void registerEntityEgg(
			Class<? extends EntityLiving> entityClass, int entityID,int primaryColor, int secondaryColor) {

		Integer id = Integer.valueOf(entityID);
		idToClass.put(id, entityClass);
		classToID.put(entityClass, id);
		idToEgg.put(id, new EntityGaiaEggInfo(entityID, primaryColor,
				secondaryColor));
		//idToName.put(id, (String) EntityList.classToStringMapping.get(entityClass));
		idToName.put(id, (String) EntityList.getEntityStringFromClass(entityClass));
	}

	public static Entity spawnCreature(World world, int entityID, double posX,
			double posY, double posZ) {
		Integer id = Integer.valueOf(entityID);
		if (!idToEgg.containsKey(id)) {
			return null;
		} else {
			EntityLiving entity = null;

			try {
				Class exception = (Class) idToClass.get(id);
				if (exception != null) {
					entity = (EntityLiving) exception.getConstructor(
							new Class[] { World.class }).newInstance(
									new Object[] { world });
				}
			} catch (Exception var11) {
				var11.printStackTrace();
			}

			if (entity == null) {
			} else {
				entity.setLocationAndAngles(posX, posY, posZ, MathHelper
						.wrapDegrees(world.rand.nextFloat() * 360.0F),0.0F);
				entity.rotationYawHead = entity.rotationYaw;
				entity.renderYawOffset = entity.rotationYaw;
				entity.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(entity)), (IEntityLivingData)null);
				world.spawnEntityInWorld(entity);
				entity.playLivingSound();
			}

			return entity;
		}
	}

	public static int entityID(Class<? extends EntityLiving> entityClass) {
		Integer result = (Integer) classToID.get(entityClass);
		return null == result ? -1 : result.intValue();
	}

	public ItemGaiaSpawnEgg(String name) {
		this.setHasSubtypes(true);
		this.setCreativeTab(Gaia.tabGaia);
		this.setUnlocalizedName(name);
	}
		
	public String getItemStackDisplayName(ItemStack istack) {
		String ownName = ("" + I18n.translateToLocal(this
				.getUnlocalizedName() + ".name")).trim();
		String mobName = (String) idToName.get(Integer.valueOf(istack
				.getItemDamage()));
		if (mobName != null) {
			ownName = ownName
					+ " "
					+ I18n.translateToLocal("entity." + mobName
							+ ".name");
		}

		return ownName;
	}
	
	public String MobName(ItemStack istack){
		return (String) idToName.get(Integer.valueOf(istack
				.getItemDamage()));
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack istack, int renderPass) {
		EntityGaiaEggInfo EntityGaiaEggInfo = (EntityGaiaEggInfo) idToEgg
				.get(Integer.valueOf(istack.getItemDamage()));
		return EntityGaiaEggInfo != null ? (renderPass == 0 ? EntityGaiaEggInfo.primaryColor
				: EntityGaiaEggInfo.secondaryColor)
				: 16777215;
	}
	
	 @SideOnly(Side.CLIENT)
	    public static IItemColor getItemColor()
	    {
	        return new IItemColor()
	        {
	            @Override
	            public int getColorFromItemstack(ItemStack stack, int pass) 
	            {
	            	EntityGaiaEggInfo EntityGaiaEggInfo = (EntityGaiaEggInfo) idToEgg
	        				.get(Integer.valueOf(stack.getItemDamage()));
	        		return EntityGaiaEggInfo != null ? (pass == 0 ? EntityGaiaEggInfo.primaryColor
	        				: EntityGaiaEggInfo.secondaryColor)
	        				: 16777215;
	            }
	        };
	    }
	 
	 
	 

	//public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if (worldIn.isRemote) {
			return EnumActionResult.SUCCESS;
		}
		else if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack)) {
			return EnumActionResult.FAIL;
		} else {
			IBlockState iblockstate = worldIn.getBlockState(pos);

			if (iblockstate.getBlock() == Blocks.MOB_SPAWNER) {
				TileEntity tileentity = worldIn.getTileEntity(pos);

				if (tileentity instanceof TileEntityMobSpawner) {
					MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
					//mobspawnerbaselogic.setEntityName(ItemMonsterPlacer.getEntityName(stack));
					//mobspawnerbaselogic.setEntityName(getEntityIdFromItem(stack));
					mobspawnerbaselogic.setEntityName(MobName(stack));
					tileentity.markDirty();
					worldIn.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);

					if (!playerIn.capabilities.isCreativeMode) {
						--stack.stackSize;
					}

					return EnumActionResult.SUCCESS;
				}
			}

			pos = pos.offset(facing);
			double d0 = 0.0D;

			if (facing == EnumFacing.UP && iblockstate.getBlock() instanceof BlockFence) {
				d0 = 0.5D;
			}

			Entity entity = spawnCreature(worldIn, stack.getItemDamage(),
					(double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D);
			if (entity != null) {
				if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
					entity.setCustomNameTag(stack.getDisplayName());
				}

				if (!playerIn.capabilities.isCreativeMode) {
					--stack.stackSize;
				}
			}

			return EnumActionResult.SUCCESS;
		}
	}

	//public ItemStack onItemRightClick(ItemStack istack, World world,EntityPlayer player) {
	public ActionResult<ItemStack> onItemRightClick(ItemStack istack, World world, EntityPlayer player, EnumHand hand)
	{
		if (world.isRemote) {
			//return istack;
			return new ActionResult(EnumActionResult.PASS, istack);
		} else {
			//RayTraceResult mop = this.getMovingObjectPositionFromPlayer(world, player, true);
			RayTraceResult mop = this.rayTrace(world, player, true);
			if (mop == null) {
				//return istack;
				return new ActionResult(EnumActionResult.PASS, istack);
			} else {
				if (mop.typeOfHit == RayTraceResult.Type.BLOCK) {
					int posX = mop.getBlockPos().getX();
					int posY = mop.getBlockPos().getX();
					int posZ = mop.getBlockPos().getX();
					BlockPos pos = mop.getBlockPos();
					if (!world.canMineBlockBody(player, pos)
							|| !player.canPlayerEdit(pos,
									mop.sideHit, istack)) {
						//return istack;
						return new ActionResult(EnumActionResult.PASS, istack);
					}

					//Block b = BlockStateHelper.getBlockfromState(world, pos);
					 IBlockState b = world.getBlockState(pos);
					 
					if (b.getMaterial() == Material.WATER) {
						Entity entity = spawnCreature(world,
								istack.getItemDamage(), (double) posX,
								(double) posY, (double) posZ);
						if (entity != null) {
							if (entity instanceof EntityLiving
									&& istack.hasDisplayName()) {
								((EntityLiving) entity).setCustomNameTag(istack
										.getDisplayName());
							}

							if (!player.capabilities.isCreativeMode) {
								--istack.stackSize;
							}
						}
					}
				}

				//return istack;
				return new ActionResult(EnumActionResult.PASS, istack);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_,
			List p_150895_3_) {
		Iterator it = idToEgg.values().iterator();

		while (it.hasNext()) {
			EntityGaiaEggInfo info = (EntityGaiaEggInfo) it.next();
			p_150895_3_.add(new ItemStack(p_150895_1_, 1, info.spawnedID));
		}
	}
}
