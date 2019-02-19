package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;


public class EntityGaiaNPCWeresheep extends EntityMobMerchant {

	public EntityGaiaNPCWeresheep(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public EntityType<?> getType() {
		return GaiaEntities.WERESHEEP_NPC;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.WERESHEEP_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.WERESHEEP_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.WERESHEEP_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit && (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
			entityDropItem(new ItemStack(GaiaItems.SPAWN_WERESHEEP, 1), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 1)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.WHITE_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.ORANGE_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.MAGENTA_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.LIGHT_BLUE_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.YELLOW_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.LIME_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.PINK_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.GRAY_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.LIGHT_GRAY_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.CYAN_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.PURPLE_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.BLUE_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.BROWN_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.GREEN_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.RED_WOOL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_WERESHEEP, 4), new ItemStack(Blocks.BLACK_WOOL, 1)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WHITE_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.ORANGE_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.MAGENTA_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.LIGHT_BLUE_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.YELLOW_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.LIME_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.PINK_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.GRAY_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.LIGHT_GRAY_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.CYAN_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.PURPLE_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.BLUE_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.BROWN_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.GREEN_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.RED_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.BLACK_WOOL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1)));
	}
}
