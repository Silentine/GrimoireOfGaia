package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IDayMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.item.EnchantedBookItem;
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
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.HashMap;

public class GaiaAntRangerEntity extends AbstractMobHostileEntity implements IDayMob, IRangedAttackMob {

    private static final DataParameter<Boolean> HIDING = EntityDataManager.<Boolean>createKey(GaiaAntRangerEntity.class, DataSerializers.BOOLEAN);

    private static final int DETECTION_RANGE = 4;

    private final RangedAttackGoal aiArrowAttack = new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 60, 15.0F);

    private boolean canHide;

    public GaiaAntRangerEntity(EntityType<? extends GaiaAntRangerEntity> entityType, World world) {
        super(entityType, world);
        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        canHide = false;
    }

    public GaiaAntRangerEntity(World world) {
        this(GaiaEntities.ANT_RANGER, world);
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        RangedHelper.poison(target, this, distanceFactor);
    }

    @Override
    public void setAttackTask() {
        if (!isHiding()) {
            this.goalSelector.addGoal(4, this.aiArrowAttack);
        }
    }

    @Override
    public void setGaiaAttributes() {
        getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
        getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE * 0.5);
        getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
        getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);

        getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(HIDING, false);
    }

    public boolean isHiding() {
        return (getDataManager().get(HIDING));
    }

    public void setHiding(boolean hiding) {
        getDataManager().set(HIDING, hiding);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("hiding", isHiding());
        compound.putBoolean("canHide", this.canHide);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("hiding")) {
            setHiding(compound.getBoolean("hiding"));
        }
        if (compound.contains("canHide")) {
            this.canHide = compound.getBoolean("canHide");
        }
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        if (isHiding()) {
            return source == source.OUT_OF_WORLD ? super.attackEntityFrom(source, attackDamage) : false;
        } else {
            return super.attackEntityFrom(source, attackDamage);
        }
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
    public void livingTick() {
        if (ticksExisted % 60 == 0 && !canHide) {
            canHide = true;
        }

        if (playerDetection(this, DETECTION_RANGE)) {
            if (canHide) {
                if (!isPotionActive(Effects.INVISIBILITY)) {
                    world.setEntityState(this, (byte) 12);
                    removeRangedTask(true);
                    addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 480 * 20, 0));
                    setHiding(true);
                }

                if (!(this.onGround)) {
                    world.setEntityState(this, (byte) 11);
                    remove();
                }
            }
        } else {
            if (isPotionActive(Effects.INVISIBILITY)) {
                world.setEntityState(this, (byte) 12);
                removeRangedTask(false);
                removePotionEffect(Effects.INVISIBILITY);
                setHiding(false);
            }
        }

        super.livingTick();
    }

    public void removeRangedTask(boolean remove) {
        if(remove) {
            goalSelector.removeGoal(aiArrowAttack);
        }
        else {
            goalSelector.addGoal(1, aiArrowAttack);
        }
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.ANT_RANGER_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.ANT_RANGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.ANT_RANGER_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_MEAT, 1);
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
                ItemStack enchantmentBook = new ItemStack(Items.ENCHANTED_BOOK);
                EnchantedBookItem.addEnchantment(enchantmentBook, new EnchantmentData(Enchantments.LOOTING, 1));
                entityDropItem(enchantmentBook, 1);
            }
        }
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entity) { }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    @Override
    public void applyEntityCollision(Entity p_70108_1_) { }

    @Override
    protected int getFireImmuneTicks() {
        return 10;
    }

    @Override
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        return potioneffectIn.getPotion() == Effects.POISON ? false : super.isPotionApplicable(potioneffectIn);
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
