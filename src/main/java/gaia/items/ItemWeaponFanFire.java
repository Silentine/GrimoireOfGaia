package gaia.items;

import javax.annotation.Nonnull;

import com.google.common.collect.Multimap;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.init.GaiaItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see ItemSword
 */
public class ItemWeaponFanFire extends Item {

    private int attackDamage;

    public ItemWeaponFanFire(String name) {
        this.maxStackSize = 1;
        this.setMaxDamage(780);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
        this.attackDamage = 7;
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
        stack.damageItem(1, host);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (state.getBlockHardness(worldIn, pos) != 0.0f) {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack stack, ItemStack par2ItemStack) {
        return GaiaItems.MiscSoulFiery == par2ItemStack.getItem() && super.getIsRepairable(stack, par2ItemStack);
    }

    @Override
    public @Nonnull
            Multimap<String, AttributeModifier> getAttributeModifiers(@Nonnull EntityEquipmentSlot equipmentSlot, ItemStack itemStack) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot, itemStack);

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
        stack.addEnchantment(Enchantment.getEnchantmentByLocation("fire_aspect"), 2);
        stack.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!this.isInCreativeTab(tab)) {
            return;
        }

        ItemStack stack = new ItemStack(this, 1, 0);
        stack.addEnchantment(Enchantment.getEnchantmentByLocation("fire_aspect"), 2);
        stack.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 1);
        items.add(stack);
    }
}
