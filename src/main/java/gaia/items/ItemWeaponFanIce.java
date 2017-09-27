package gaia.items;

import com.google.common.collect.Multimap;
import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.init.GaiaItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nullable;

/**
 * @see ItemSword
 */
public class ItemWeaponFanIce extends Item {

    private int attackDamage;

    public ItemWeaponFanIce(String name) {
        this.maxStackSize = 1;
        this.setMaxDamage(780);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
        this.attackDamage = 0;
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
        stack.damageItem(1, host);
        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 3));
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("effect.moveSlowdown") + " IV" + " (0:05)");
    }

    public boolean getIsRepairable(ItemStack stack, ItemStack par2ItemStack) {
        return GaiaItems.MiscSoulFire != par2ItemStack.getItem() && super.getIsRepairable(stack, par2ItemStack);
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
                    new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
                    new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }

        return multimap;
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        stack.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!this.isInCreativeTab(tab)) {
            return;
        }

        ItemStack stack = new ItemStack(this, 1, 0);
        stack.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 4);
        items.add(stack);
    }
}
