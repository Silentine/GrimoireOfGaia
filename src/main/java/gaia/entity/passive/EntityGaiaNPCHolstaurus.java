package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;


public class EntityGaiaNPCHolstaurus extends EntityMobMerchant {

	public EntityGaiaNPCHolstaurus(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public EntityType<?> getType() {
		return GaiaEntities.HOLSTAURUS_NPC;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.HOLSTAURUS_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.HOLSTAURUS_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.HOLSTAURUS_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0) {
				entityDropItem(new ItemStack(GaiaItems.SPAWN_HOLSTAURUS, 1), 0.0F);
			}
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1), new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 1)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 1), new ItemStack(Items.WHEAT_SEEDS, 8)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 1), new ItemStack(Items.PUMPKIN_SEEDS, 16)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 2), new ItemStack(Items.MELON_SEEDS, 16)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 16), new ItemStack(Blocks.CAKE, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 8), new ItemStack(Items.PUMPKIN_PIE, 1)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Items.WHEAT, 8), new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.PUMPKIN, 2), new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.MELON, 1), new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Items.EGG, 8), new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SUGAR, 16), new ItemStack(GaiaItems.MISC_CURRENCY_HOLSTAURUS, 1)));
	}
}
