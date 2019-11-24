package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
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

public class GaiaGelatinousSlimeEntity extends AbstractMobHostileEntity {

    private boolean animationPlay;
    private int animationTimer;

    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;

    public GaiaGelatinousSlimeEntity(EntityType<? extends GaiaGelatinousSlimeEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;

        setPathPriority(PathNodeType.WATER, -1.0F);

        animationPlay = false;
        animationTimer = 0;

        this.setCanPickUpLoot(true);
    }

    public GaiaGelatinousSlimeEntity(World world) {
        this(GaiaEntities.GELATINOUS_SLIME, world);
    }

    @Override
    public void setAttackTask() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_0, true));
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    public void setGaiaAttributes() {
        getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
        getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
        getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1 * 0.5);
        getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
        getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);

        getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);

        Entity entity = source.getImmediateSource();

        if (entity instanceof ArrowEntity) {
            world.setEntityState(this, (byte) 8);
            heal(EntityAttributes.MAX_HEALTH_2 * 0.10F);
        }

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
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public void tick() {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.tick();

        if (ticksExisted % 60 == 0) {
            animationPlay = true;
            animationTimer = 0;
        }

        if (animationPlay) {
            this.squishAmount = -0.10F;

            if (animationTimer != 10) {
                animationTimer += 1;
            } else {
                this.squishAmount = 1.0F;
                animationPlay = false;
            }
        }

        this.alterSquishAmount();
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.6F;
    }

    @Override
    public void livingTick() {
        rangeDebuff(4, Effects.SLOWNESS, 100, 1);

        if (getHealth() < EntityAttributes.MAX_HEALTH_2) {
            if (hasItem()) {
                setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);

                world.setEntityState(this, (byte) 8);
                heal(EntityAttributes.MAX_HEALTH_2 * 0.20F);
            }
        }

        super.livingTick();
    }

    private boolean hasItem() {
        if (!this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onDeath(DamageSource cause) {
        if (!this.world.isRemote) {
            spawnLingeringCloud(this, Effects.POISON, 10 * 20, 0);
        }
        super.onDeath(cause);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SLIME_HURT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SLIME_DEATH;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3 + lootingModifier);

            for (int i = 0; i < drop; ++i) {
                entityDropItem(Items.SLIME_BALL, 1);
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
                        entityDropItem(GaiaItems.BOX_GOLD, 1);
                    case 1:
                        entityDropItem(GaiaItems.BAG_BOOK, 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.SPAWN_SLIME_GIRL, 1);
            }

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaBlocks.DOLL_SLIME_GIRL, 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData data = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        ItemStack offhand = ItemStack.EMPTY;

        switch (rand.nextInt(3)) {
            case 0:
                offhand = new ItemStack(Items.BOW);
                break;
            case 1:
                offhand = new ItemStack(Items.ARROW);
                break;
            case 2:
                offhand = new ItemStack(Items.STONE_SWORD);
                break;
        }

        setItemStackToSlot(EquipmentSlotType.OFFHAND, offhand);

        return data;
    }

    @Override
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        return potioneffectIn.getPotion() == Effects.POISON ? false : super.isPotionApplicable(potioneffectIn);
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
