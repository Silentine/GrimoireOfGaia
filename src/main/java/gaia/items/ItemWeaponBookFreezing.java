package gaia.items;

import java.util.List;

import javax.annotation.Nonnull;
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
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBookFreezing extends ItemSword {

    public ItemWeaponBookFreezing(String name) {
        super(Item.ToolMaterial.IRON);

        setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses() * 3.48F));
        setCreativeTab(CreativeTabGaia.INSTANCE);
        setRegistryName(GaiaReference.MOD_ID, name);
        setUnlocalizedName(name);
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

        tooltip.add(I18n.format("effect.moveSlowdown") + " II" + " (0:04)");
    }

    @Override
    public @Nonnull
            ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn) {
        final ItemStack itemStackIn = playerIn.getHeldItem(handIn);

        itemStackIn.damageItem(5, playerIn);
        playerIn.addExhaustion(5.0F);

        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F,
                0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        playerIn.getCooldownTracker()
                .setCooldown(this, 60);

        if (!worldIn.isRemote) {
            EntitySnowball snowball = new EntitySnowball(worldIn, playerIn);
            snowball.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(snowball);
        }

        StatBase statBase = StatList.getObjectUseStats(this);
        if (statBase != null) {
            playerIn.addStat(statBase);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, @Nonnull EntityLivingBase attacker) {
        super.hitEntity(stack, target, attacker);

        final EntityPlayer player = attacker instanceof EntityPlayer
                ? (EntityPlayer) attacker
                : null;

        if (player != null) {
            player.playSound(Sounds.book_hit, 1.0F, 1.0F);
        }

        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80, 1));

        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, @Nonnull ItemStack repair) {
        return repair.getItem() == GaiaItems.MiscQuill;
    }
}
