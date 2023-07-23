package gaia.item.weapon;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FanItem extends Item {
	protected float attackDamage;

	public FanItem(Properties properties) {
		super(properties.durability(780).rarity(Rarity.RARE));
		this.attackDamage = 0;
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairStack.is(Items.PAPER);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!attacker.level().isClientSide) {
			stack.hurtAndBreak(1, attacker, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		}
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity livingEntity) {
		if (!level.isClientSide) {
			stack.hurtAndBreak(2, livingEntity, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		}

		return true;
	}
}
