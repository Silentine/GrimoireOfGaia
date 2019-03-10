package gaia.entity;

import gaia.GaiaConfig;
import gaia.init.GaiaEntities;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityMobProp extends EntityAgeable {
    public EntityMobProp(EntityType<?> type, World worldIn) {
        super(type, worldIn);
    }

    /* SPAWN CONDITIONS */
    public boolean daysPassed() {
        int daysPassedClientInt = (int) (world.getGameTime() / 24000);

        return GaiaConfig.COMMON.spawnDaysSet.get() <= daysPassedClientInt;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, boolean value) {
        if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
            return daysPassed() && super.canSpawn(worldIn, value);
        } else {
            return super.canSpawn(worldIn, value);
        }
    }
    /* SPAWN CONDITIONS */

    /**
     * Used to access dropFewItems despite having a LootTable
     */
    @Override
    protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
        super.dropLoot(wasRecentlyHit, lootingModifier, source);
        dropFewItems(wasRecentlyHit, lootingModifier);
    }

    public EntityAgeable createChild(EntityAgeable entityageable) {
        return null;
    }
}
