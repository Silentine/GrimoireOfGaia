package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaItems;
import gaia.item.ItemShard;
import gaia.item.ItemShieldProp;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaBoneKnightEntity extends AbstractMobHostileEntity implements ISwimmingMob {

    public GaiaBoneKnightEntity(EntityType<? extends GaiaBoneKnightEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
    }

    @Override
    public void setAttackTask() {
        goalSelector.addGoal(3, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, true));
    }

    @Override
    public void giveSpecificTasks() {
        super.giveSpecificTasks();
        goalSelector.addGoal(1, new RestrictSunGoal(this));
        goalSelector.addGoal(2, new FleeSunGoal(this, EntityAttributes.ATTACK_SPEED_2));
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        if (hasShield()) {
            Entity entity = source.getImmediateSource();
            return !(entity instanceof ArrowEntity) && super.attackEntityFrom(source, attackDamage);
        } else {
            return super.attackEntityFrom(source, attackDamage);
        }
    }

    private boolean hasShield() {
        ItemStack stack = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);

        return stack.getItem() instanceof ShieldItem || stack.getItem() instanceof ItemShieldProp;
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.SLOWNESS, 0);
            effects.put(Effects.MINING_FATIGUE, 2);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        if (world.isDaytime() && !world.isRemote) {
            float f = getBrightness();
            if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canBlockSeeSky(getPosition())) {
                setFire(8);
                attackEntityFrom(DamageSource.OUT_OF_WORLD, EntityAttributes.MAX_HEALTH_2 * 0.25F);
            }
        }

        super.livingTick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_SKELETON_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3) + 1;

            for (int i = 0; i < drop; ++i) {
                entityDropItem(Items.REDSTONE, 1);
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
                        entityDropItem(new ItemStack(GaiaItems.BOX_ORE.get()), 1);
                    case 1:
                        entityDropItem(new ItemStack(Blocks.REDSTONE_BLOCK), 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(new ItemStack(Items.SKELETON_SKULL), 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_STONE.get()));
        setEnchantmentBasedOnDifficulty(difficulty);

        ItemStack shield = new ItemStack(GaiaItems.SHIELD_PROP_STONE.get(), 1);
        setItemStackToSlot(EquipmentSlotType.OFFHAND, shield);

        return entityData;
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
    }

    /* SPAWN CONDITIONS */
    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_UNDERGROUND;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return GaiaConfig.COMMON.disableYRestriction.get() || getPosY() < 32.0D && super.canSpawn(worldIn, reason);
    }
}
