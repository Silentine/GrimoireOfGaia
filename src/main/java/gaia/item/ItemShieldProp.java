package gaia.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemShieldProp extends Item {
	public ItemShieldProp(Item.Properties builder) {
		super(builder.maxStackSize(1)); //"shield_prop");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.UNCOMMON;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.Prop.tag").applyTextStyle(TextFormatting.YELLOW));
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity host) {
		if (!(host instanceof PlayerEntity) || !((PlayerEntity) host).abilities.isCreativeMode) {
			stack.shrink(1);
		}

		return true;
	}
}
