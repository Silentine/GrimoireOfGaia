package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IDayMob;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaCecaeliaEntity extends AbstractMobHostileEntity implements IDayMob, ISwimmingMob, IRangedAttackMob {
    private static final int DETECTION_RANGE = 3;

    private RangedAttackGoal aiArrowAttack = new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 60, 15.0F);
    private MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true);

    private int timer;
    private int switchDetect;
    private int switchEquip;

    private boolean animationPlay;
    private int animationTimer;

    private byte inWaterTimer;

    public GaiaCecaeliaEntity(EntityType<? extends GaiaCecaeliaEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;
        this.setPathPriority(PathNodeType.WATER, 8.0F);

        timer = 0;
        switchDetect = 0;
        switchEquip = 0;

        animationPlay = false;
        animationTimer = 0;

        inWaterTimer = 0;
    }

    public GaiaCecaeliaEntity(World world) {
        this(GaiaEntities.CECEALIA, world);
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    private void setCombatTask() {
        ItemStack itemstack = getHeldItemMainhand();
        if (itemstack.isEmpty()) {
            setCombatTask(0);
        } else {
            setCombatTask(1);
        }
    }

    private void setCombatTask(int id) {
        switch(id) {
            default:
                goalSelector.removeGoal(aiAttackOnCollide);
                goalSelector.addGoal(1, aiArrowAttack);

                setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                animationPlay = false;
                animationTimer = 0;
            case 1:
                goalSelector.removeGoal(aiArrowAttack);
                goalSelector.addGoal(1, aiAttackOnCollide);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        RangedHelper.bubble(target, this, distanceFactor);

        setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.ARROW));
        animationPlay = true;
        animationTimer = 0;
    }

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != GaiaEntities.CECEALIA;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.MINING_FATIGUE, 1);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        if (!world.isRemote) {
            if (isWet()) {
                if (inWaterTimer <= 100) {
                    ++inWaterTimer;
                } else {
                    world.setEntityState(this, (byte) 8);
                    heal(EntityAttributes.MAX_HEALTH_1 * 0.10F);
                    addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5 * 20, 0));
                    inWaterTimer = 0;
                }
            }
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
                setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
                setCombatTask(0);
                timer = 0;
                switchEquip = 0;
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
        return GaiaSounds.CECAELIA_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.CECAELIA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.CECAELIA_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_COALFISH, 1);
            }

            if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(Items.CLAY_BALL, 1);
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
                entityDropItem(new ItemStack(GaiaItems.BOX_ORE), 1);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                ItemStack enchantmentBook = new ItemStack(Items.ENCHANTED_BOOK);
                EnchantedBookItem.addEnchantment(enchantmentBook, new EnchantmentData(Enchantments.LUCK_OF_THE_SEA, 1));
                entityDropItem(enchantmentBook, 1);
            }
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
        setItemStackToSlot(EquipmentSlotType.FEET, bootsSwimming);
        bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 3);

        setCombatTask();

        return entityData;
    }

    @Override
    protected int getFireImmuneTicks() {
        return 10;
    }

    @Override
    public boolean isPushedByWater() {
        return false;
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        setCombatTask();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_UNDERGROUND;
    }

    @Override
    public boolean isInWater() {
        return this.getBoundingBox().minY < (double)(this.world.getSeaLevel() - 5);
    }

    @Override
	public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
		return GaiaConfig.COMMON.disableYRestriction.get() ? true : posY < 60.0D && super.canSpawn(worldIn, reason);
	}
}
