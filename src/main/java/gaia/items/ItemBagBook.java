package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.init.Sounds;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemBagBook extends Item {

    public ItemBagBook(String name) {
        this.maxStackSize = 1;
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("text.grimoireofgaia.RightClickUse"));
    }

    @Override
    public @Nonnull
            ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand handIn) {
        // TODO remove testing line * world.addWeatherEffect(new
        // EntityLightningBolt(world, player.posX, player.posY, player.posZ,
        // false));
        player.playSound(Sounds.bag_open, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

        /**
         * TODO Check Enchantment enchantment =
         * Enchantment.enchantmentsBookList[itemRand.nextInt(Enchantment.enchantmentsBookList.length)];
         * int k = MathHelper.getRandomIntegerInRange(itemRand,
         * enchantment.getMinLevel(), enchantment.getMaxLevel()); ItemStack book
         * = Items.ENCHANTED_BOOK.getEnchantedItemStack(new
         * EnchantmentData(enchantment, k));
         **/

        Random rand = new Random();
        ItemStack book = new ItemStack(Items.BOOK);
        book = EnchantmentHelper.addRandomEnchantment(rand, book, 5 + rand.nextInt(15), true);

        return new ActionResult<>(EnumActionResult.SUCCESS, book);
    }
}
