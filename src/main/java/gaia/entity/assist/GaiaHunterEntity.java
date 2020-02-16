package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaRangedBowAttackGoal;
import gaia.entity.types.IDayMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaHunterEntity extends AbstractMobAssistEntity implements IDayMob, IRangedAttackMob {
    private static final int DETECTION_RANGE = 3;

    private GaiaRangedBowAttackGoal rangedAttackGoal = new GaiaRangedBowAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);
    private MeleeAttackGoal meleeAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true);

    private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.POISON);

    private int timer;
    private int switchDetect;
    private int switchEquip;

    private boolean isFriendly;

    public GaiaHunterEntity(EntityType<? extends GaiaHunterEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        timer = 0;
        switchDetect = 0;
        switchEquip = 0;
    }

    public GaiaHunterEntity(World world) {
        this(GaiaEntities.HUNTER, world);
    }

    private void setCombatTask() {
        goalSelector.removeGoal(meleeAttackGoal);
        goalSelector.removeGoal(rangedAttackGoal);
        ItemStack itemstack = getHeldItemMainhand();

        if (itemstack.getItem() == Items.BOW) {
            int i = 20;

            if (this.world.getDifficulty() != Difficulty.HARD) {
                i = 40;
            }

            rangedAttackGoal.setAttackCooldown(i);
            setCombatTask(0);
        } else {
            setCombatTask(1);
        }
    }

    private void setCombatTask(int id) {
        switch(id) {
            default:
                if (!isNeutral()) {
                    goalSelector.removeGoal(meleeAttackGoal);
                    goalSelector.addGoal(1, rangedAttackGoal);
                }
            case 1:
                goalSelector.removeGoal(rangedAttackGoal);
                goalSelector.addGoal(1, meleeAttackGoal);
        }
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        setCombatTask();
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.POISON, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if(target.isAlive()) {
            RangedHelper.rangedAttack(target, this, distanceFactor);
        }
    }

    @Override
    public boolean isTameable() {
        return true;
    }

    @Override
    public void livingTick() {
        /* TODO Fix archers from attacking same spot despite target already being eliminated */
        if (isNeutral() && !isFriendly) {
            setCombatTask(1);
            timer = 0;
            switchEquip = 1;
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
            setItemStackToSlot(EquipmentSlotType.OFFHAND, ItemStack.EMPTY);
            isFriendly = true;
        }

        if (playerDetection(this, DETECTION_RANGE)) {
            if (switchDetect == 0) {
                switchDetect = 1;
            }
        } else {
            if (switchDetect == 1) {
                switchDetect = 0;
            }
        }

        if (switchDetect == 1 && switchEquip == 0) {
            if (timer <= 20) {
                ++timer;
            } else {
                if (!isPotionActive(Effects.SPEED)) {
                    addPotionEffect(new EffectInstance(Effects.SPEED, 10 * 20, 0));
                }
                setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL));
                setCombatTask(1);

                timer = 0;
                switchEquip = 1;
            }
        }

        if (switchDetect == 0 && switchEquip == 1) {
            if (timer <= 20) {
                ++timer;
            } else {
                if (isPotionActive(Effects.SPEED)) {
                    removePotionEffect(Effects.SPEED);
                }

                if (!isNeutral()) {
                    setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
                    setCombatTask(0);
                } else {
                    setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
                    setCombatTask(1);
                }

                timer = 0;
                switchEquip = 0;
            }
        }

        super.livingTick();
    }


    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.HUNTER_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.HUNTER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.HUNTER_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_ROTTEN_HEART, 1);
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
                entityDropItem(GaiaItems.BOX_IRON, 1);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BAG_ARROW, 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
        setEnchantmentBasedOnDifficulty(difficulty);

        if (world.rand.nextInt(2) == 0) {
            setItemStackToSlot(EquipmentSlotType.OFFHAND, TIPPED_ARROW_CUSTOM);
        }

        setCombatTask();

        return entityData;
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
