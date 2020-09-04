package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaBaphometEntity extends AbstractMobHostileEntity implements ISwimmingMob, IRangedAttackMob {

    private final RangedAttackGoal aiArrowAttack = new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, 20, 60, 15.0F);
    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, true);

    private int switchHealth;

    private boolean animationPlay;
    private int animationTimer;

    public GaiaBaphometEntity(EntityType<? extends GaiaBaphometEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;

        switchHealth = 0;

        animationPlay = false;
        animationTimer = 0;
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    public void setAttackTask() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_3, true));
    }

    private void setCombatTask(int id) {
        switch (id) {
            default:
                goalSelector.removeGoal(aiAttackOnCollide);
                goalSelector.addGoal(2, aiArrowAttack);

                this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                animationPlay = false;
                animationTimer = 0;
            case 1:
                goalSelector.removeGoal(aiArrowAttack);
                goalSelector.addGoal(1, aiAttackOnCollide);
        }
    }

    private void setCombatTask() {
        ItemStack itemstack = getHeldItemMainhand();
        if (itemstack.getItem() == GaiaItems.WEAPON_PROP_ENDER.get()) {
            setCombatTask(0);
        } else {
            setCombatTask(1);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        RangedHelper.fireball(target, this, distanceFactor);

        setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.ARROW));
        animationPlay = true;
        animationTimer = 0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);
        return !(source instanceof IndirectEntityDamageSource) && super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.SLOWNESS, 0);
            effects.put(Effects.WEAKNESS, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public void livingTick() {
        if ((getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 0)) {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL.get()));
            setCombatTask(1);
            switchHealth = 1;
        }

        if ((getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 1)) {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_ENDER.get(), 1));
            switchHealth = 0;
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
        return GaiaSounds.BAPHOMET_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.BAPHOMET_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.BAPHOMET_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3 + lootingModifier);

            if ((rand.nextInt(2) == 0 || rand.nextInt(2) > 0)) {
                for (int i = 0; i < drop; ++i) {
                    entityDropItem(GaiaItems.MISC_SOUL_FIERY.get(), 1);
                }
            } else {
                for (int i = 0; i < drop; ++i) {
                    entityDropItem(Items.BLAZE_POWDER, 1);
                }
            }

            if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_NETHER_WART.get(), 1);
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
                        entityDropItem(new ItemStack(GaiaItems.BOX_GOLD.get(), 1), 1);
                    case 1:
                        entityDropItem(GaiaItems.BAG_BOOK.get(), 1);
                    case 2:
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.ACCESSORY_TRINKET_WITHER.get(), 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setCombatTask(0);
        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_ENDER.get(), 1));

        return entityData;
    }

    @Override
    public boolean isPotionApplicable(EffectInstance instance) {
        return instance.getPotion() != Effects.WITHER && super.isPotionApplicable(instance);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        this.setCombatTask();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_2;
    }
}
