package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.entity.types.IDayMob;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class AbstractMobPropEntity extends AgeableEntity implements IDayMob, ISharedMethods {
    protected AbstractMobPropEntity(EntityType<? extends AbstractMobPropEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    /* SPAWN CONDITIONS */
    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason value) {
        boolean blacklisted = this.isDimensionBlacklisted(world);

        if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
            return blacklisted && this.daysPassed(world) && super.canSpawn(world, value);
        } else {
            return blacklisted && super.canSpawn(worldIn, value);
        }
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageableEntity) {
        return null;
    }
}
