package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.Trade;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityGaiaNPCCreeperGirl extends EntityMobMerchant {

	public EntityGaiaNPCCreeperGirl(World var1) {
		super(var1);
	}
	
	public IChatComponent getDisplayName() {
		 String s = "Creeper Girl";
		 ChatComponentText chatcomponenttext = new ChatComponentText(s);
		 return chatcomponenttext;
    }
	
	@Override
	protected String getLivingSound() {
		return "grimoireofgaia:passive_say";
	}

	@Override
	protected String getHurtSound() {
		return "grimoireofgaia:passive_hurt";
	}

	@Override
	protected String getDeathSound() {
		return "grimoireofgaia:passive_death";
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(1) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.SpawnCreeperGirl, 1, 0), 0.0F);
		}
	}
	
	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));	
		
		//Buy List
		recipes.add(new Trade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.bone, 2, 0)));
		recipes.add(new Trade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.ROTTEN_FLESH, 4, 0)));
		recipes.add(new Trade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.SPIDER_EYE, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.string, 2, 0)));
		
		//Sell List
		recipes.add(new Trade(new ItemStack(Items.bone, 4, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.GUNPOWDER, 2, 0)));
		recipes.add(new Trade(new ItemStack(Items.ROTTEN_FLESH, 6, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.string, 4, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.slime_ball, 2, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.SPIDER_EYE, 2, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
	}
}
