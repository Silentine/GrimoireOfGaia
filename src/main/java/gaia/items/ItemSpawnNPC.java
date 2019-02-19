package gaia.items;

import java.util.List;
import java.util.function.Function;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSpawnNPC extends ItemBase {
	private final EnumRarity rarity;
	private final Function<World, Entity> createNPC;

	public ItemSpawnNPC(Item.Properties builder, EnumRarity rarity, Function<World, Entity> createNPC) {
		super(builder.maxStackSize(16));
		this.rarity = rarity;
		this.createNPC = createNPC;
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

	@Override
	public EnumActionResult onItemUse(ItemUseContext context) {
		EntityPlayer player = context.getPlayer();
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		
		ItemStack stack = context.getItem();

		BlockPos offsetPos = pos.offset(context.getFace());

		if (!player.canPlayerEdit(offsetPos, context.getFace(), stack)) {
			return EnumActionResult.FAIL;
		} else {
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}

			if (worldIn.isAirBlock(offsetPos) && !worldIn.isRemote) {
				Entity spawnEntity = createNPC.apply(worldIn);
				spawnEntity.setLocationAndAngles(offsetPos.getX() + 0.5, offsetPos.getY(), offsetPos.getZ() + 0.5, 0, 0);
				worldIn.spawnEntity(spawnEntity);
			}

			return EnumActionResult.SUCCESS;
		}
	}
}
