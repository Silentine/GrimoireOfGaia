package gaia.entity.passive;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaNPCCreeperGirl extends EntityMobMerchant {

	public EntityGaiaNPCCreeperGirl(World worldIn) {
		super(worldIn);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.CREEPERGIRL_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.CREEPERGIRL_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.CREEPERGIRL_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit && (this.rand.nextInt(1) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
			entityDropItem(new ItemStack(GaiaItems.SPAWN_CREEPER_GIRL, 1, 0), 0.0F);
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.BONE, 2, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.ROTTEN_FLESH, 4, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.SPIDER_EYE, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.GUNPOWDER, 1, 0), new ItemStack(Items.STRING, 2, 0)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Items.BONE, 4, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ENDER_PEARL, 1, 0), new ItemStack(Items.GUNPOWDER, 2, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.ROTTEN_FLESH, 6, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.STRING, 4, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SLIME_BALL, 2, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(Items.SPIDER_EYE, 2, 0), new ItemStack(Items.GUNPOWDER, 1, 0)));
	}
}