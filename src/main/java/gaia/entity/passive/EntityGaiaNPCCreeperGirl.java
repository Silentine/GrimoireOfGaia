package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;


public class EntityGaiaNPCCreeperGirl extends EntityMobMerchant {

	public EntityGaiaNPCCreeperGirl(World worldIn) {
		super(worldIn);
	}

	@Override
	public EntityType<?> getType() {
		return GaiaEntities.CREEPER_GIRL_NPC;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.CREEPERGIRL_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.CREEPERGIRL_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.CREEPERGIRL_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0) {
				entityDropItem(new ItemStack(GaiaItems.SPAWN_CREEPER_GIRL, 1), 0.0F);
			}
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1), new ItemStack(Items.GUNPOWDER, 1)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1), new ItemStack(Items.BONE, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1), new ItemStack(Items.ROTTEN_FLESH, 4)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1), new ItemStack(Items.SPIDER_EYE, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1), new ItemStack(Items.STRING, 2)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Items.BONE, 4), new ItemStack(Items.GUNPOWDER, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(Items.GUNPOWDER, 2)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ROTTEN_FLESH, 6), new ItemStack(Items.GUNPOWDER, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.STRING, 4), new ItemStack(Items.GUNPOWDER, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SLIME_BALL, 2), new ItemStack(Items.GUNPOWDER, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SPIDER_EYE, 2), new ItemStack(Items.GUNPOWDER, 1)));
	}
}
