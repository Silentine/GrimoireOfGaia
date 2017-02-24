package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItems;
import gaia.init.Sounds;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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

public class ItemWeaponBookFreezing extends ItemSword {
	
	private float attackDamage;
	private final Item.ToolMaterial material;

	public ItemWeaponBookFreezing(String name) {
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
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		EntityPlayer player = host instanceof EntityPlayer ? (EntityPlayer)host : null;
        player.playSound(Sounds.book_hit, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80, 1));
		return true;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		if (player.getHeldItemOffhand() == stack) {
			par3List.add(TextFormatting.GREEN + (I18n.translateToLocal("text.GrimoireOfGaia.BlessOffhand")));
		} else  {
			par3List.add(TextFormatting.RED + (I18n.translateToLocal("text.GrimoireOfGaia.BlessMainhand")));
		}
		
		par3List.add(I18n.translateToLocal("effect.moveSlowdown") + " II" + " (0:04)");
	}

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == GaiaItems.MiscQuill;
    }
}
