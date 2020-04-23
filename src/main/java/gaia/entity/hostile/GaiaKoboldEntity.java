package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
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

public class GaiaKoboldEntity extends AbstractMobHostileEntity implements IRangedAttackMob {
    private static final String MOB_TYPE_TAG = "MobType";
    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaKoboldEntity.class, DataSerializers.VARINT);

    private MeleeAttackGoal meleeAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true);
    private final RangedBowAttackGoal arrowAttackGoal = new RangedBowAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);

    private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.SLOWNESS);
    private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.WEAKNESS);
    private int timer;
    private int switchDetect;
    private int switchEquip;

    public GaiaKoboldEntity(EntityType<? extends GaiaKoboldEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        timer = 0;
        switchDetect = 0;
        switchEquip = 0;
    }

    public GaiaKoboldEntity(World world) {
        this(GaiaEntities.KOBOLD.get(), world);
    }

    private void setCombatTask(int id) {
        switch (id) {
            default:
                goalSelector.removeGoal(meleeAttackGoal);
                goalSelector.addGoal(2, arrowAttackGoal);
            case 1:
                goalSelector.removeGoal(arrowAttackGoal);
                goalSelector.addGoal(1, meleeAttackGoal);
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(meleeAttackGoal);
        goalSelector.removeGoal(arrowAttackGoal);

        ItemStack itemstack = getHeldItemMainhand();
        if (itemstack.getItem() instanceof BowItem) {
            int i = 20;

            if (this.world.getDifficulty() != Difficulty.HARD) {
                i = 40;
            }

            arrowAttackGoal.setAttackCooldown(i);
            setCombatTask(0);
        } else {
            setCombatTask(1);
        }
    }

    @Override
    public void setAttackTask() {
        this.setCombatTask();
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(SKIN, 0);
    }

    public int getTextureType() {
        return getDataManager().get(SKIN);
    }

    private void setTextureType(int type) {
        getDataManager().set(SKIN, type);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt(MOB_TYPE_TAG, getTextureType());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            setTextureType(compound.getInt(MOB_TYPE_TAG));
        }
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if (target.isAlive()) {
            RangedHelper.rangedAttack(target, this, distanceFactor);
        }
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
            effects.put(Effects.MINING_FATIGUE, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != this.getType();
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public void livingTick() {
        if (playerDetection(this, 3)) {
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
                setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL.get()));
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
                setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
                setCombatTask(0);
                timer = 0;
                switchEquip = 0;
            }
        }

        super.livingTick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.KOBOLD_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.KOBOLD_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.KOBOLD_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.MISC_FUR.get(), 1);
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

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BAG_ARROW.get(), 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        if (world.rand.nextInt(4) == 0) {
            setTextureType(1);
        }

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
        setEnchantmentBasedOnDifficulty(difficulty);

        if (world.rand.nextInt(2) == 0) {
            if (world.rand.nextInt(2) == 0) {
                setItemStackToSlot(EquipmentSlotType.OFFHAND, TIPPED_ARROW_CUSTOM);
            } else {
                setItemStackToSlot(EquipmentSlotType.OFFHAND, TIPPED_ARROW_CUSTOM_2);
            }
        }

        return super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);
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
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }
}
