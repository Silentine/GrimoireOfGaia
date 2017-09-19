package gaia.entity.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;

import javax.annotation.Nonnull;

public class EntityGaiaAgeableChest extends EntityGaiaAgeable {

    public EntityGaiaAgeableChest(World worldIn) {
        super(worldIn);
    }

    public EntityGaiaAgeableChest(World worldIn, ResourceLocation lootTableIn) {
        super(worldIn, lootTableIn);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, @Nonnull DamageSource source) {
        for (int var = 0; var < 2; ++var) {
            this.dropRandomLootFromLootTable(super.getLootTable(), wasRecentlyHit, lootingModifier, source);
        }
    }

    private void dropRandomLootFromLootTable(ResourceLocation dungeonLoot, boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
        int maxCount, roll;
        int currentCount = 0;

        LootTable loottable = world.getLootTableManager()
                .getLootTableFromLocation(dungeonLoot);
        LootContext.Builder context = new LootContext.Builder((WorldServer) world);

        context = context.withLootedEntity(this);
        context = context.withDamageSource(source);

        if (wasRecentlyHit && attackingPlayer != null) {
            context = context.withPlayer(attackingPlayer);
            context = context.withLuck(attackingPlayer.getLuck());
        }

        maxCount = loottable.generateLootForPools(rand, context.build()).size();
        roll = rand.nextInt(maxCount);

        for (ItemStack itemstack : loottable.generateLootForPools(rand, context.build())) {
            if (currentCount == roll) {
                entityDropItem(itemstack, 0.0F);
            }

            currentCount++;
        }
    }
}
