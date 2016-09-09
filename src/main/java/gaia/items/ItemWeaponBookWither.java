package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
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

import com.google.common.collect.Multimap;

public class ItemWeaponBookWither extends ItemSword {
	private float weaponDamage;
	private final Item.ToolMaterial toolMaterial;
	String texture;

	public ItemWeaponBookWither(String texture) {
		super(Item.ToolMaterial.IRON);
		this.toolMaterial = Item.ToolMaterial.IRON;
		this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses()*3.48F));
		this.weaponDamage = Item.ToolMaterial.IRON.getDamageVsEntity();
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.WeaponBookWither");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", -0.15000000000000002D, 2));
		return multimap;
	}

	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer entityplayer, int par4) {
		stack.damageItem(27, entityplayer);
		entityplayer.addExhaustion(5.0F);
		world.playSoundAtEntity(entityplayer, SoundEvents.ENTITY_ARROW_SHOOT, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!world.isRemote) {
			Vec3 look = entityplayer.getLookVec();
			EntityWitherSkull fireball2 = new EntityWitherSkull(world, entityplayer, 1.0D, 1.0D, 1.0D);
			fireball2.setPosition(entityplayer.posX + look.xCoord * 1.0D, entityplayer.posY + look.yCoord + (double)entityplayer.getEyeHeight() - 0.10000000149011612D, entityplayer.posZ + look.zCoord * 1.0D);
			fireball2.accelerationX = look.xCoord * 0.1D;
			fireball2.accelerationY = look.yCoord * 0.1D;
			fireball2.accelerationZ = look.zCoord * 0.1D;
			world.spawnEntityInWorld(fireball2);
		}
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("effect.wither") + " (0:04)");
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		stack.damageItem(1, par3EntityLiving);
		par2EntityLiving.addPotionEffect(new PotionEffect(MobEffects.WITHER, 80, 0));
		return true;
	}
	
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack par2ItemStack) {
		return Items.BOOK == par2ItemStack.getItem()?true:super.getIsRepairable(stack, par2ItemStack);
	}
}
