package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.ISwimmingMob;
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
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public class GaiaAnubisEntity extends AbstractMobHostileEntity implements ISwimmingMob, IRangedAttackMob {
    private static final DataParameter<Boolean> MALE = EntityDataManager.<Boolean>createKey(GaiaAnubisEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> CAN_SPAWN_LEVEL3 = EntityDataManager.<Boolean>createKey(GaiaAnubisEntity.class, DataSerializers.BOOLEAN);

    private final RangedAttackGoal aiArrowAttack = new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, 20, 60, 15.0F);
    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, true);

    private int switchHealth;
    private int spawn;
    private int spawnTimer;

    private boolean animationPlay;
    private int animationTimer;

    private boolean spawned;
    private int spawnLevel3;
    private int spawnLevel3Chance;

    public GaiaAnubisEntity(EntityType<? extends GaiaAnubisEntity> entityType, World world) {
        super(entityType, world);
        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;

        switchHealth = 0;
        spawn = 0;
        spawnTimer = 0;

        animationPlay = false;
        animationTimer = 0;

        spawned = false;
        spawnLevel3 = 0;
        spawnLevel3Chance = 0;
    }

    public GaiaAnubisEntity(World world) {
        this(GaiaEntities.ANUBIS.get(), world);
    }

    @Override
    public void setAttackTask() {
        setCombatTask();
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(MALE, Boolean.valueOf(false));
        this.getDataManager().register(CAN_SPAWN_LEVEL3, GaiaConfig.COMMON.spawnLevel3.get());
    }

    public boolean isMale() {
        return (this.dataManager.get(MALE));
    }

    public void setMale() {
        this.dataManager.set(MALE, true);
        this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.STICK));
    }

    public boolean getCanSpawnLevel3() {
        return (this.dataManager.get(CAN_SPAWN_LEVEL3));
    }

    public void setCanSpawnLevel3(boolean value) {
        this.dataManager.set(CAN_SPAWN_LEVEL3, value);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("canSpawnLevel3", getCanSpawnLevel3());
        compound.putBoolean("male", isMale());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("canSpawnLevel3")) {
            setCanSpawnLevel3(compound.getBoolean("canSpawnLevel3"));
        }
        if (compound.contains("male") && compound.getBoolean("male")) {
            setMale();
        }
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        RangedHelper.magic(target, this, distanceFactor);

        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.ARROW));
        animationPlay = true;
        animationTimer = 0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (damage > EntityAttributes.BASE_DEFENSE_2) {
            if (getCanSpawnLevel3()) {
                spawnLevel3Chance += (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.05);
            }
        }
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != GaiaEntities.ANUBIS.get();
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
        goalSelector.removeGoal(aiAttackOnCollide);
        goalSelector.removeGoal(aiArrowAttack);

        ItemStack itemstack = getHeldItemMainhand();
        if (itemstack.getItem() == GaiaItems.WEAPON_PROP_BLAZE.get()) {
            setCombatTask(0);
        } else {
            setCombatTask(1);
        }
    }

    @Override
    public void livingTick() {
        beaconMonster();

        if ((getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 0)) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL.get()));
            setCombatTask(1);
            switchHealth = 1;
        }

        if ((getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 1)) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_BLAZE.get(), 1));
            setCombatTask(0);
            switchHealth = 0;
        }

        if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F && getHealth() > 0.0F && spawn == 0) {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.STICK));

            if (spawnTimer != 30) {
                spawnTimer += 1;
            }

            if (spawnTimer == 30) {
                world.setEntityState(this, (byte) 9);
                this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);

                if (!world.isRemote) {
                    this.summonMinion(0);
                }

                spawnTimer = 0;
                spawn = 1;
            }
        }

        if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && spawn == 1) {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.STICK));

            if (spawnTimer != 30) {
                spawnTimer += 1;
            }

            if (spawnTimer == 30) {
                world.setEntityState(this, (byte) 9);
                this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);

                if (!world.isRemote) {
                    this.summonMinion(0);
                }

                /* LEVEL 3 SPAWN DATA */
                if (getCanSpawnLevel3()) {
                    if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && !spawned) {

                        if (spawnLevel3Chance > (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.5)) {
                            spawnLevel3Chance = (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.5);
                        }

                        if ((rand.nextInt(GaiaConfig.COMMON.spawnLevel3Chance.get() - spawnLevel3Chance) == 0 || rand.nextInt(1) > 0)) {
                            spawnLevel3 = 1;
                        }

                        spawned = true;
                    }
                }
                /* LEVEL 3 SPAWN DATA */

                spawnTimer = 0;
                spawn = 2;
            }
        }

        if (animationPlay) {
            if (animationTimer != 20) {
                animationTimer += 1;
            } else {
                this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                animationPlay = false;
            }
        }

        /* LEVEL 3 SPAWN DATA */
        if (ticksExisted % 60 == 0) {
            boolean configValue = GaiaConfig.COMMON.spawnLevel3.get();
            if ((getCanSpawnLevel3() != configValue && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0))) {
                setCanSpawnLevel3(configValue);
            }
        }

        if (spawnLevel3 == 1) {
            world.setEntityState(this, (byte) 10);

            attackEntityFrom(DamageSource.GENERIC, EntityAttributes.MAX_HEALTH_2 * 0.01F);
        }
        /* LEVEL 3 SPAWN DATA */

        super.livingTick();
    }

    private void summonMinion(int id) {
        switch (id) {
            default:
                SkeletonEntity skeleton = new SkeletonEntity(EntityType.SKELETON, world);
                skeleton.setLocationAndAngles(getPosX(), getPosY(), getPosZ(), rotationYaw, 0.0F);
                skeleton.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(skeleton)), null, null, null);
                skeleton.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_MOB.get(), 1));
                skeleton.setDropChance(EquipmentSlotType.MAINHAND, 0);
                skeleton.setDropChance(EquipmentSlotType.OFFHAND, 0);
                skeleton.setDropChance(EquipmentSlotType.FEET, 0);
                skeleton.setDropChance(EquipmentSlotType.LEGS, 0);
                skeleton.setDropChance(EquipmentSlotType.CHEST, 0);
                skeleton.setDropChance(EquipmentSlotType.HEAD, 0);
                world.addEntity(skeleton);
            case 1:
                this.explode();
                GaiaSphinxEntity sphinx = new GaiaSphinxEntity(world);
                sphinx.setLocationAndAngles(getPosX(), getPosY(), getPosZ(), rotationYaw, 0.0F);
                sphinx.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(sphinx)), null, null, null);
                world.addEntity(sphinx);
        }
    }

    private void beaconMonster() {
        if (!world.isRemote) {
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB(getPosX(), getPosY(), getPosZ(), getPosX() + 1, getPosY() + 1, getPosZ() + 1)).grow(6D);

            List<LivingEntity> moblist = world.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);

            for (LivingEntity mob : moblist) {
                if (mob instanceof ZombieEntity || mob instanceof AbstractSkeletonEntity) {
                    mob.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300, 1, true, true));
                }
            }
        }
    }

    private void explode() {
        if (!this.world.isRemote) {
            Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            int explosionRadius = 2;

            this.dead = true;
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), (float) explosionRadius, explosion$mode);
            this.remove();
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.ANUBIS_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.ANUBIS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.ANUBIS_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
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
                        entityDropItem(GaiaItems.BOX_GOLD.get(), 1);
                    case 1:
                        entityDropItem(GaiaItems.BAG_BOOK.get(), 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.MISC_BOOK.get(), 1);
            }

            // Unique Rare
//            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
//                entityDropItem(GaiaItems.SPAWN_WERESHEEP, 1);
//            }TODO: SPAWN_WERESHEEP Item
        }

        // Boss
        if (spawnLevel3 == 1) {
            summonMinion(1);
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        if (world.rand.nextInt(4) == 0) {
            setMale();
        }

        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_BLAZE.get(), 1));

        this.setCombatTask();

        return entityData;
    }

    @Override
    protected int getFireImmuneTicks() {
        return 10;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_2;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }
}
