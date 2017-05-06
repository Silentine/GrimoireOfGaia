package gaia.items;

import gaia.Gaia;
import gaia.init.Sounds;

import java.util.List;

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
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBookEnder extends ItemSword {
	
	private float attackDamage;
	private final Item.ToolMaterial material;

	public ItemWeaponBookEnder(String name) {
		super(Item.ToolMaterial.IRON);
		this.material = Item.ToolMaterial.IRON;
		this.setMaxDamage((int) (Item.ToolMaterial.IRON.getMaxUses()*3.48F));
		this.setCreativeTab(Gaia.tabGaia);
		this.attackDamage = Item.ToolMaterial.IRON.getDamageVsEntity();
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (playerIn.getHeldItemOffhand() == stack)
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.BlessOffhand")));
		else
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.BlessMainhand")));
		
		tooltip.add(I18n.translateToLocal("effect.blindness") + " (0:04)");
	}
	
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		itemStackIn.damageItem(5, playerIn);
		playerIn.addExhaustion(5.0F);
		
        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        playerIn.getCooldownTracker().setCooldown(this, 60);

        if (!worldIn.isRemote) {
        	EntityEnderPearl entitysnowball = new EntityEnderPearl(worldIn, playerIn);
            entitysnowball.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntityInWorld(entitysnowball);
        }
        
        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		stack.damageItem(1, host);
		EntityPlayer player = host instanceof EntityPlayer ? (EntityPlayer)host : null;
        player.playSound(Sounds.book_hit, 1.0F, 1.0F);
		target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
		return true;
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack par2ItemStack) {
		return Items.ENDER_PEARL == par2ItemStack.getItem()?true:super.getIsRepairable(stack, par2ItemStack);
	}
}
