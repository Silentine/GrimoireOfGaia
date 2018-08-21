package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import gaia.GaiaReference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Used for debugging health related coding
 *
 * @see ItemSword
 */
public class ItemWeaponDebug extends Item {

    private float attackDamage;

    public ItemWeaponDebug(String name) {
        this.attackDamage = 500;
        this.maxStackSize = 1;
        this.setMaxDamage(780);
        // this.setCreativeTab(CreativeTabGaia.INSTANCE);
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
    }

    /**
     * https://github.com/Flaxbeard/Cyberware/blob/4bae328ee0a714900094d3f203b3281af3e048c4/src/main/java/flaxbeard/cyberware/common/handler/CyberwareMenuHandler.java
     **/
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
        tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Debug.tag")));
        if (shiftPressed) {
            tooltip.add(I18n.format("item.grimoireofgaia.WeaponDebug.desc"));
        } else {
            tooltip.add(TextFormatting.ITALIC + (I18n.format("text.grimoireofgaia.HoldShift")));
        }
    }

    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
        EntityPlayer player = (EntityPlayer) entityIn;

        for (int i = 0; i < 9; ++i) {
            if (player.inventory.getStackInSlot(i) == stack) {
                this.doEffect(player, stack);
                break;
            }
        }
    }

    public void doEffect(EntityPlayer player, ItemStack item) {
        if (!player.isPotionActive(MobEffects.REGENERATION)) {
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 4, true, false));
        }
    }
}
