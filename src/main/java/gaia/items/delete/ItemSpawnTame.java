package gaia.items.delete;

import java.util.List;

import javax.annotation.Nullable;

import gaia.items.ItemBase;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnTame extends ItemBase {
	public ItemSpawnTame() {
		super("spawn_tame");
		setMaxStackSize(1);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.grimoireofgaia.desc")));
		tooltip.add(I18n.format("item.grimoireofgaia.spawn_tame.desc"));
		tooltip.add(TextFormatting.ITALIC + I18n.format("item.grimoireofgaia.spawn_tame2.desc"));
	}
}
