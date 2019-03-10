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


public class EntityGaiaNPCEnderGirl extends EntityMobMerchant {

	public EntityGaiaNPCEnderGirl(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public EntityType<?> getType() {
		return GaiaEntities.ENDER_GIRL_NPC;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.ENDERGIRL_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.ENDERGIRL_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.ENDERGIRL_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0) {
				entityDropItem(new ItemStack(GaiaItems.SPAWN_ENDER_GIRL, 1), 0.0F);
			}
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY_SELL, 1), new ItemStack(Items.ENDER_PEARL, 1)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(Items.BONE, 8)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(Items.ROTTEN_FLESH, 16)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(Items.GUNPOWDER, 4)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(Items.SPIDER_EYE, 4)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(Items.STRING, 8)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Items.BONE, 16), new ItemStack(Items.ENDER_PEARL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 8), new ItemStack(Items.ENDER_PEARL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ROTTEN_FLESH, 24), new ItemStack(Items.ENDER_PEARL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.STRING, 16), new ItemStack(Items.ENDER_PEARL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SLIME_BALL, 8), new ItemStack(Items.ENDER_PEARL, 1)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SPIDER_EYE, 8), new ItemStack(Items.ENDER_PEARL, 1)));
	}
}
