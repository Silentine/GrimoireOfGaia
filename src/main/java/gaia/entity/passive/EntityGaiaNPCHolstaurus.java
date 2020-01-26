package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
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
				entityDropItem(new ItemStack(GaiaItems.SPAWN_HOLSTAURUS, 1, 0), 0.0F);
			}
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
		
		// Unique
		ItemStack iron_hoe = new ItemStack(Items.IRON_HOE);
		ItemStack iron_hoe_enchanted = new ItemStack(Items.IRON_HOE);
		iron_hoe_enchanted.addEnchantment(Enchantments.UNBREAKING, 2);

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2), ItemStack.EMPTY, new ItemStack(Items.WHEAT_SEEDS, 8, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2), ItemStack.EMPTY, new ItemStack(Items.PUMPKIN_SEEDS, 16, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 2, 2), ItemStack.EMPTY, new ItemStack(Items.MELON_SEEDS, 16, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 16, 2), ItemStack.EMPTY, new ItemStack(Items.CAKE, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 8, 2), ItemStack.EMPTY, new ItemStack(Items.PUMPKIN_PIE, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 32, 2), iron_hoe, iron_hoe_enchanted));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Items.WHEAT, 8, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.PUMPKIN, 2, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.MELON_BLOCK, 1, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 2, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Items.EGG, 8, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SUGAR, 16, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 2)));
	}
}
