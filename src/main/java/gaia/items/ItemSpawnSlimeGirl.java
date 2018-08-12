package gaia.items;

import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSpawnSlimeGirl extends ItemBase {
	public ItemSpawnSlimeGirl() {
		super("spawn_slime_girl");
		maxStackSize = 16;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("item.grimoireofgaia.spawn_slime_girl.desc"));
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);

		BlockPos offsetPos = pos.offset(facing);

		if (!player.canPlayerEdit(offsetPos, facing, stack)) {
			return EnumActionResult.FAIL;
		} else {
			if (!player.capabilities.isCreativeMode) {
				stack.shrink(1);
			}

			if (worldIn.isAirBlock(offsetPos) && !worldIn.isRemote) {
				EntityGaiaNPCSlimeGirl spawnEntity = new EntityGaiaNPCSlimeGirl(worldIn);
				spawnEntity.setLocationAndAngles(player.posX + 0.5, player.posY, player.posZ + 0.5, 0, 0);
				worldIn.spawnEntity(spawnEntity);
			}

			return EnumActionResult.SUCCESS;
		}
	}
}
