package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItems;
import gaia.init.Sounds;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBookBattle extends ItemSword {
	
	private float attackDamage;
	private final Item.ToolMaterial material;

	public ItemWeaponBookBattle(String name) {
		super(Item.ToolMaterial.IRON);
		this.material = Item.ToolMaterial.IRON;
		this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses()*3.48F));
		this.setCreativeTab(Gaia.tabGaia);
		this.attackDamage = Item.ToolMaterial.IRON.getDamageVsEntity();
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (playerIn.getHeldItemOffhand() == stack)
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.BlessOffhand")));
		else
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.BlessMainhand")));
		
		tooltip.add(I18n.translateToLocal("effect.weakness") + " (0:04)");
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		EntityPlayer player = host instanceof EntityPlayer ? (EntityPlayer)host : null;
        player.playSound(Sounds.book_hit, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 80, 0));
		return true;
	}

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == GaiaItems.MiscQuill;
    }
}
