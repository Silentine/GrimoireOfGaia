package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
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

public class ItemWeaponBookBook extends ItemSword {

    private float attackDamage;
    private final Item.ToolMaterial material;

    public ItemWeaponBookBook(String name) {
        super(Item.ToolMaterial.IRON);
        this.material = Item.ToolMaterial.IRON;
        this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses() * 3.48F));
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
        this.attackDamage = Item.ToolMaterial.IRON.getAttackDamage();
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        final EntityPlayer player = Minecraft.getMinecraft().player;
        if (player == null) {
            return;
        }
        if (player.getHeldItemOffhand() == stack) {
            tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.BlessOffhand")));
        } else {
            tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.BlessMainhand")));
        }

        tooltip.add(I18n.format("effect.weakness") + " (0:04)");
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
        stack.damageItem(1, host);
        EntityPlayer player = host instanceof EntityPlayer
                ? (EntityPlayer) host
                : null;
        player.playSound(Sounds.book_hit, 1.0F, 1.0F);
        target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 80, 0));
        return true;
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == GaiaItems.MiscQuill;
    }
}
