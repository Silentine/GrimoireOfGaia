package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IDayMob;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GaiaDhampirEntity extends AbstractMobHostileEntity implements IDayMob {

    private final MeleeAttackGoal meleeAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, true);

    private int buffEffect;
    private boolean animationPlay;
    private int animationTimer;

    private boolean canSpawnLevel3;
    private boolean spawned;
    private int spawnLevel3;
    private int spawnLevel3Chance;

    public GaiaDhampirEntity(EntityType<? extends GaiaDhampirEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;

        buffEffect = 0;
        animationPlay = false;
        animationTimer = 0;

        spawnLevel3 = 0;
        spawnLevel3Chance = 0;
    }

    public GaiaDhampirEntity(World world) {
        this(GaiaEntities.DHAMPIR.get(), world);
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    private void setCombatTask(int id) {
        switch (id) {
            default:
                goalSelector.addGoal(1, meleeAttackGoal);
            case 1:
                goalSelector.removeGoal(meleeAttackGoal);
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(meleeAttackGoal);
        setCombatTask(0);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);
        if (damage > EntityAttributes.BASE_DEFENSE_2) {
            if (canSpawnLevel3) {
                spawnLevel3Chance += (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.05);
            }
        }
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entityIn;
                int difficultyModifier = 0;

                if (world.getDifficulty() == Difficulty.NORMAL) {
                    difficultyModifier = 10;
                } else if (world.getDifficulty() == Difficulty.HARD) {
                    difficultyModifier = 20;
                }

                if (difficultyModifier > 0) {
                    livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, difficultyModifier * 20, 0));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        /* BUFF */
        if (getHealth() <= EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
            setCombatTask(1);
            setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.STICK));
            buffEffect = 1;
            animationPlay = true;
        }

        if (getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.25F && buffEffect == 1) {
            buffEffect = 0;
            animationPlay = false;
            animationTimer = 0;
        }

        if (animationPlay) {
            if (animationTimer != 15) {
                animationTimer += 1;
            } else {
                setBuff();
                setCombatTask(0);
                setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                animationPlay = false;
            }
        }
        /* BUFF */

        /* LEVEL 3 SPAWN DATA */
        if ((GaiaConfig.COMMON.spawnLevel3.get() && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0)) && !canSpawnLevel3) {
            canSpawnLevel3 = true;
        }

        if (canSpawnLevel3) {
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

        if (spawnLevel3 == 1) {
            world.setEntityState(this, (byte) 10);

            attackEntityFrom(DamageSource.GENERIC, EntityAttributes.MAX_HEALTH_2 * 0.01F);
        }
        /* LEVEL 3 SPAWN DATA */

        super.livingTick();
    }

    private void setBuff() {
        world.setEntityState(this, (byte) 7);
        addPotionEffect(new EffectInstance(Effects.SPEED, 20 * 60, 0));
        addPotionEffect(new EffectInstance(Effects.HASTE, 20 * 60, 0));
    }

    private void setSpawn(int id) {
        switch(id) {
            default:
                explode();

//                EntityGaiaVampire vampire = new EntityGaiaVampire(world); TODO: Reimplement Vampire spawn
//                vampire.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
//                vampire.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(vampire)), null, null, null);
//                world.addEntity(vampire);
        }
    }

    private void explode() {
        if (!this.world.isRemote) {
            Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            int explosionRadius = 2;

            this.dead = true;
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, (float) explosionRadius, explosion$mode);
            this.remove();
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.DHAMPIR_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.DHAMPIR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.DHAMPIR_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3 + lootingModifier);

            for (int i = 0; i < drop; ++i) {
                entityDropItem(GaiaItems.MISC_SOUL_FIRE.get(), 1);
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
                        entityDropItem(GaiaItems.BOX_GOLD.get(), 1);
                    case 1:
                        entityDropItem(GaiaItems.BAG_BOOK.get(), 1);
                }
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaBlocks.DOLL_MAID.get(), 1);
            }
        }

        // Boss
        if (spawnLevel3 == 1) {
            setSpawn((byte) 1);
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_STONE.get()));
        setEnchantmentBasedOnDifficulty(difficulty);

        if (GaiaConfig.COMMON.spawnLevel3.get() && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0)) {
            canSpawnLevel3 = true;
        }

        setCombatTask();

        return entityData;
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        setCombatTask();
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
