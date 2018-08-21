package gaia.items;

import javax.annotation.Nonnull;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.init.GaiaItems;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBook extends ItemSword {

    private float attackDamage;
    private final Item.ToolMaterial material;

    public ItemWeaponBook(String name) {
        super(Item.ToolMaterial.IRON);
        this.material = Item.ToolMaterial.IRON;
        this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses() * 3.48F));
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
        this.attackDamage = Item.ToolMaterial.IRON.getAttackDamage();
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public @Nonnull EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, @Nonnull ItemStack repair) {
        return repair.getItem() == GaiaItems.MiscQuill;
    }
}
