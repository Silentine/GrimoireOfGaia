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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class EntityGaiaNPCHolstaurus extends EntityMobMerchant {

    public EntityGaiaNPCHolstaurus(World worldIn) {
        super(worldIn);
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentTranslation("entity.grimoireofgaia:Holstaurus.name");
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Sounds.passive_say;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return Sounds.passive_hurt;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Sounds.passive_death;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit && (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
            entityDropItem(new ItemStack(GaiaItems.SpawnHolstaurus, 1, 0), 0.0F);
        }
    }

    @Override
    public void addRecipies(MerchantRecipeList recipes) {
        recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 2)));

        // Buy List
        recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 1, 2), new ItemStack(Items.WHEAT_SEEDS, 8, 0)));
        recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 1, 2), new ItemStack(Items.PUMPKIN_SEEDS, 16, 0)));
        recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 2, 2), new ItemStack(Items.MELON_SEEDS, 16, 0)));
        recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 16, 2), new ItemStack(Items.CAKE, 1, 0)));
        recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MiscCurrency, 8, 2), new ItemStack(Items.PUMPKIN_PIE, 1, 0)));

        // Sell List
        recipes.add(new GaiaTrade(new ItemStack(Items.WHEAT, 8, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 2)));
        recipes.add(new GaiaTrade(new ItemStack(Blocks.PUMPKIN, 2, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 2)));
        recipes.add(new GaiaTrade(new ItemStack(Blocks.MELON_BLOCK, 1, 0), new ItemStack(GaiaItems.MiscCurrency, 2, 2)));
        recipes.add(new GaiaTrade(new ItemStack(Items.EGG, 8, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 2)));
        recipes.add(new GaiaTrade(new ItemStack(Items.SUGAR, 16, 0), new ItemStack(GaiaItems.MiscCurrency, 1, 2)));
    }
}
