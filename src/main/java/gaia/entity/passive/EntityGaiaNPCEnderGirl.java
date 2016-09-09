package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.Trade;
import gaia.init.GaiaItem;
import gaia.init.Sounds;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityGaiaNPCEnderGirl extends EntityMobMerchant {

	public EntityGaiaNPCEnderGirl(World var1) {
		super(var1);
	}
	public ITextComponent getDisplayName() {
		 String s = "Ender Girl";
		 TextComponentTranslation text = new TextComponentTranslation(s);
		 return text;
	}
	@Override
	protected SoundEvent getAmbientSound(){
		return Sounds.passive_say;
	}

	@Override
	protected SoundEvent getHurtSound(){
		return Sounds.passive_hurt;
	}

	@Override
	protected SoundEvent getDeathSound(){
		return Sounds.passive_death;
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(1) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.SpawnEnderGirl, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new Trade(new ItemStack(GaiaItem.MiscCurrency, 1, 0), new ItemStack(Items.ENDER_PEARL, 1, 0)));	
		
		//Buy List
		recipes.add(new Trade(new ItemStack(Items.ENDER_PEARL, 1, 0), new ItemStack(Items.BONE, 8, 0)));
		recipes.add(new Trade(new ItemStack(Items.ENDER_PEARL, 1, 0), new ItemStack(Items.ROTTEN_FLESH, 16, 0)));
		recipes.add(new Trade(new ItemStack(Items.ENDER_PEARL, 1, 0), new ItemStack(Items.GUNPOWDER, 4, 0)));
		recipes.add(new Trade(new ItemStack(Items.ENDER_PEARL, 1, 0), new ItemStack(Items.SPIDER_EYE, 4, 0)));
		recipes.add(new Trade(new ItemStack(Items.ENDER_PEARL, 1, 0), new ItemStack(Items.STRING, 8, 0)));
		
		//Sell List
		recipes.add(new Trade(new ItemStack(Items.BONE, 16, 0), new ItemStack(Items.ENDER_PEARL, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.GUNPOWDER, 8, 0), new ItemStack(Items.ENDER_PEARL, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.ROTTEN_FLESH, 24, 0), new ItemStack(Items.ENDER_PEARL, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.STRING, 16, 0), new ItemStack(Items.ENDER_PEARL, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.SLIME_BALL, 8, 0), new ItemStack(Items.ENDER_PEARL, 1, 0)));
		recipes.add(new Trade(new ItemStack(Items.SPIDER_EYE, 8, 0), new ItemStack(Items.ENDER_PEARL, 1, 0)));
	}
}
