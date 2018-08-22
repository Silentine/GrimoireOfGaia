package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaNPCHolstaurus extends EntityMobMerchant {

	public EntityGaiaNPCHolstaurus(World worldIn) {
		super(worldIn);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.PASSIVE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.PASSIVE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.PASSIVE_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit && (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
			entityDropItem(new ItemStack(GaiaItems.SPAWN_HOLSTAURUS, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2), new ItemStack(Items.WHEAT_SEEDS, 8, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2), new ItemStack(Items.PUMPKIN_SEEDS, 16, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 2, 2), new ItemStack(Items.MELON_SEEDS, 16, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 16, 2), new ItemStack(Items.CAKE, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 8, 2), new ItemStack(Items.PUMPKIN_PIE, 1, 0)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Items.WHEAT, 8, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.PUMPKIN, 2, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.MELON_BLOCK, 1, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 2, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Items.EGG, 8, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SUGAR, 16, 0), new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
	}
}
