package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBookFreezing extends ItemSword {
	private float weaponDamage;
	private final Item.ToolMaterial toolMaterial;
	String texture;

	public ItemWeaponBookFreezing(String texture) {
		super(Item.ToolMaterial.IRON);
		this.toolMaterial = Item.ToolMaterial.IRON;
		this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses()*3.48F));
		this.weaponDamage = Item.ToolMaterial.IRON.getDamageVsEntity();
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.WeaponBookFreezing");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int par4) {
		stack.damageItem(1, player);
		player.addExhaustion(5.0F);
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntitySnowball(world, player));
		}
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("effect.moveSlowdown") + " II" + " (0:04)");
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		stack.damageItem(1, par3EntityLiving);
		par2EntityLiving.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80, 1));
		return true;
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack par2ItemStack) {
		return Items.BOOK == par2ItemStack.getItem()?true:super.getIsRepairable(stack, par2ItemStack);
	}
}
