package gaia.items;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import gaia.init.Sounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBookEnder extends ItemSword {

    private float attackDamage;
    private final Item.ToolMaterial material;

    public ItemWeaponBookEnder(String name) {
        super(Item.ToolMaterial.IRON);
        this.material = Item.ToolMaterial.IRON;
        this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses() * 3.48F));
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
        this.attackDamage = Item.ToolMaterial.IRON.getAttackDamage();
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public @Nonnull EnumRarity getRarity(ItemStack stack) {
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

        tooltip.add(I18n.format("effect.blindness") + " (0:04)");
    }

    @Override
    public @Nonnull
            ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn) {
        final ItemStack itemStackIn = playerIn.getHeldItem(handIn);

        itemStackIn.damageItem(5, playerIn);
        playerIn.addExhaustion(5.0F);

        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F,
                0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        playerIn.getCooldownTracker()
                .setCooldown(this, 60);

        if (!worldIn.isRemote) {
            EntityEnderPearl entityPearl = new EntityEnderPearl(worldIn, playerIn);
            entityPearl.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entityPearl);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, @Nonnull EntityLivingBase host) {
        EntityPlayer player = host instanceof EntityPlayer
                ? (EntityPlayer) host
                : null;

        stack.damageItem(1, host);
        player.playSound(Sounds.book_hit, 1.0F, 1.0F);
        target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack stack, @Nonnull ItemStack par2ItemStack) {
        return Items.ENDER_PEARL == par2ItemStack.getItem() && super.getIsRepairable(stack, par2ItemStack);
    }
}
