package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.passive.EntityOcelot;
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

	protected void initEntityAI() {
		tasks.addTask(1, new EntityAIAvoidEntity(this, EntityOcelot.class, 8.0F, 0.6D, 0.6D));
		tasks.addTask(1, new EntityAIAvoidEntity(this, EntityGaiaWerecat.class, 8.0F, 0.6D, 0.6D));
		super.initEntityAI();
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
				entityDropItem(new ItemStack(GaiaItems.SPAWN_CREEPER_GIRL, 1, 0), 0.0F);
			}
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 0), ItemStack.EMPTY, new ItemStack(Items.GUNPOWDER, 1, 0)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), ItemStack.EMPTY, new ItemStack(Items.BONE, 2, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), ItemStack.EMPTY, new ItemStack(Items.ROTTEN_FLESH, 4, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), ItemStack.EMPTY, new ItemStack(Items.SPIDER_EYE, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), ItemStack.EMPTY, new ItemStack(Items.STRING, 2, 0)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Items.BONE, 4, 0), ItemStack.EMPTY, new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1, 0), ItemStack.EMPTY, new ItemStack(Items.GUNPOWDER, 2, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ROTTEN_FLESH, 6, 0), ItemStack.EMPTY, new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.STRING, 4, 0), ItemStack.EMPTY, new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SLIME_BALL, 2, 0), ItemStack.EMPTY, new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SPIDER_EYE, 2, 0), ItemStack.EMPTY, new ItemStack(Items.GUNPOWDER, 1, 0)));
	}
}
