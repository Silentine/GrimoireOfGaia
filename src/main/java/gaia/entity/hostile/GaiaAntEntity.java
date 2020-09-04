package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IDayMob;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
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

public class GaiaAntEntity extends AbstractMobHostileEntity implements IDayMob {
    private static final String MOB_TYPE_TAG = "MobType";
    private static final String IS_CHILD_TAG = "IsBaby";
    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaAntEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>createKey(GaiaAntEntity.class, DataSerializers.BOOLEAN);

    public GaiaAntEntity(EntityType<? extends GaiaAntEntity> entityType, World world) {
        super(entityType, world);
        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;
    }

    @Override
    public void setAttackTask() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true));
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(SKIN, 0);
        this.getDataManager().register(IS_CHILD, false);
    }

    public int getTextureType() {
        return getDataManager().get(SKIN);
    }

    private void setTextureType(int type) {
        getDataManager().set(SKIN, type);
    }

    public boolean isChild() {
        return getDataManager().get(IS_CHILD);
    }

    public void setChild(boolean isChild) {
        getDataManager().set(IS_CHILD, isChild);
    }

    private void setChild(boolean isRandom, int chance) {
        if (isRandom) {
            if (world.rand.nextInt(chance) == 0) {
                setChild(true);
            }
        } else {
            setChild(true);
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt(MOB_TYPE_TAG, getTextureType());
        compound.putBoolean(IS_CHILD_TAG, isChild());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            setTextureType(compound.getInt(MOB_TYPE_TAG));
        }
        if (compound.contains(IS_CHILD_TAG)) {
            setChild(compound.getBoolean(IS_CHILD_TAG));
        }
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.SLOWNESS, 0);
            effects.put(Effects.MINING_FATIGUE, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.ANT_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.ANT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.ANT_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {

            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(new ItemStack(Items.GREEN_DYE), 1);
            }

            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_HONEY.get(), 1);
            }

            // Nuggets/Fragments
            int dropNugget = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNugget; ++i) {
                entityDropItem(Items.IRON_NUGGET, 1);
            }

            if (GaiaConfig.COMMON.additionalOre.get()) {
                int dropNuggetAlt = rand.nextInt(3) + 1;

                for (int i = 0; i < dropNuggetAlt; ++i) {
                    ItemShard.dropNugget(this, 4);
                }
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BOX_IRON.get(), 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        if (world.rand.nextInt(2) == 0) {
            setTextureType(0);
        } else {
            setTextureType(1);
        }

        setChild(true, 10);

        if (world.rand.nextInt(2) == 0) {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD.get()));
        } else {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_AXE_WOOD.get()));
        }
        setEnchantmentBasedOnDifficulty(difficulty);

        return super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);
    }

    @Override
    public float getEyeHeight(Pose pose) {
        ItemStack itemstack = getItemStackFromSlot(EquipmentSlotType.CHEST);

        if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
            return 1.74F;
        } else {
            return 1.74F - 0.81F;
        }
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    protected int getFireImmuneTicks() {
        return 10;
    }

    @Override
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        return potioneffectIn.getPotion() != Effects.POISON && super.isPotionApplicable(potioneffectIn);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }
}
