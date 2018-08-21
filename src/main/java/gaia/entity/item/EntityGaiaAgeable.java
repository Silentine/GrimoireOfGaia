package gaia.entity.item;

import javax.annotation.Nonnull;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityGaiaAgeable extends EntityAgeable {

    private ResourceLocation lootTable;

    public EntityGaiaAgeable(World worldIn) {
        this(worldIn, null);
    }

    public EntityGaiaAgeable(World worldIn, ResourceLocation lootTableIn) {
        super(worldIn);

        lootTable = lootTableIn;
        prevRenderYawOffset = 180.0F;
        renderYawOffset = 180.0F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
    }

    @Override
    public void onLivingUpdate() {
        attackEntityFrom(DamageSource.GENERIC, 2.0F);

        super.onLivingUpdate();
    }

    @Override
    protected float getSoundVolume() {
        return 0.0F;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return lootTable;
    }

    @Override
    protected void onDeathUpdate() {
        this.setDead();
    }

    @Override
    public EntityAgeable createChild(@Nonnull EntityAgeable entityageable) {
        return null;
    }
}
