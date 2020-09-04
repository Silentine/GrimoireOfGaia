package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.init.GaiaItems;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GaiaFleshLichEntity extends AbstractMobHostileEntity implements IRangedAttackMob {


    private boolean animationPlay;
    private int animationTimer;

    public GaiaFleshLichEntity(EntityType<? extends GaiaFleshLichEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;

        animationPlay = false;
        animationTimer = 0;
    }

    @Override
    public void setAttackTask() {
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, 20, 60, 15.0F));
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        RangedHelper.fireball(target, this, distanceFactor);

        setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.ARROW));
        animationPlay = true;
        animationTimer = 0;
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public void livingTick() {
        if (world.isDaytime() && !world.isRemote) {
            float f = getBrightness();

            if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canBlockSeeSky(getPosition())) {
                world.setEntityState(this, (byte) 11);

                attackEntityFrom(DamageSource.OUT_OF_WORLD, EntityAttributes.MAX_HEALTH_2 * 0.25F);
            }
        }

        if (animationPlay) {
            if (animationTimer != 20) {
                animationTimer += 1;
            } else {
                setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                animationPlay = false;
            }
        }

        super.livingTick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_ZOMBIE_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3) + 1;

            for (int i = 0; i < drop; ++i) {
                entityDropItem(new ItemStack(Items.LAPIS_LAZULI, 1), 0.0F);
            }

            // Nuggets/Fragments
            int dropNugget = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNugget; ++i) {
                entityDropItem(Items.GOLD_NUGGET, 1);
            }

            if (GaiaConfig.COMMON.additionalOre.get()) {
                int dropNuggetAlt = rand.nextInt(3) + 1;

                for (int i = 0; i < dropNuggetAlt; ++i) {
                    ItemShard.dropNugget(this, 5);
                }
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                switch (rand.nextInt(2)) {
                    case 0:
                        entityDropItem(new ItemStack(GaiaItems.BOX_ORE.get()), 0.0F);
                    case 1:
                        entityDropItem(Blocks.LAPIS_BLOCK, 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(new ItemStack(Items.ZOMBIE_HEAD, 1), 0.0F);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData data = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_ENDER.get(), 1));

        return data;
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_UNDERGROUND;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return GaiaConfig.COMMON.disableYRestriction.get() || getPosY() < 16.0D && super.canSpawn(worldIn, reason);
    }
}
