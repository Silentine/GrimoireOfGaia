package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaBreakDoorGoal;
import gaia.entity.goals.GaiaRangedBowAttackGoal;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.item.ItemShieldProp;
import gaia.util.RangedHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;

import javax.annotation.Nullable;

public class GaiaDwarfEntity extends AbstractMobAssistEntity implements ISwimmingMob, IRangedAttackMob {
    private static final String MOB_TYPE_TAG = "MobType";
    private final GaiaRangedBowAttackGoal rangedBowAttackGoal = new GaiaRangedBowAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, 20, 15.0F);
    private final MeleeAttackGoal meleeAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_2, true);
    private final GaiaBreakDoorGoal breakDoor = new GaiaBreakDoorGoal(this);

    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaDwarfEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.createKey(GaiaDwarfEntity.class, DataSerializers.BOOLEAN);
    private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.SLOWNESS);
    private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), Potions.WEAKNESS);

    public int classID;
    public boolean randomClass;

    private boolean canSpawnLevel3;
    private boolean spawned;
    private int spawnLevel3;
    private int spawnLevel3Chance;

    public GaiaDwarfEntity(EntityType<? extends GaiaDwarfEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
        stepHeight = 1.0F;

        classID = 0;
        randomClass = true;
        spawnLevel3 = 0;
        spawnLevel3Chance = 0;

        if (!world.isRemote) {
            setCombatTask();
        }
    }

    @Override
    public int getGaiaTier() {
        return 2;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
//        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GaiaOrcEntity.class, true)); TODO: Reimplement Orc target call.
    }

    public void setBreakDoorsAItask(boolean enabled) {
        ((GroundPathNavigator) this.getNavigator()).setBreakDoors(enabled);

        if (enabled) {
            this.goalSelector.addGoal(1, this.breakDoor);
        } else {
            this.goalSelector.removeGoal(this.breakDoor);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        float attackDamage2 = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_2);
        if (damage > EntityAttributes.BASE_DEFENSE_2) {
            if (canSpawnLevel3) {
                spawnLevel3Chance += (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.05);
            }
        }

        if (hasShield()) {
            Entity entity = source.getImmediateSource();
            return !(entity instanceof ArrowEntity) && super.attackEntityFrom(source, attackDamage);
        } else {
            return super.attackEntityFrom(source, attackDamage2);
        }
    }

    private boolean hasShield() {
        ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);

        return itemstack.getItem() instanceof ShieldItem || itemstack.getItem() instanceof ItemShieldProp;
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (getMobType() == 1 && entityIn instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entityIn;
                int difficultyModifier = 0;

                if (world.getDifficulty() == Difficulty.NORMAL) {
                    difficultyModifier = 10;
                } else if (world.getDifficulty() == Difficulty.HARD) {
                    difficultyModifier = 20;
                }

                if (difficultyModifier > 0) {
                    livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, difficultyModifier * 20));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, difficultyModifier * 20));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
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

    private void setSpawn(int id) {
        switch(id) {
            default:
                explode();
//            EntityGaiaValkyrie valyrie = new EntityGaiaValkyrie(world);
//            valyrie.setLocationAndAngles(getPosX(), getPosY(), getPosZ(), rotationYaw, 0.0F);
//            valyrie.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(valyrie)), null, null);
//            world.spawnEntity(valyrie);
        }
    }

    @Override
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
        super.setItemStackToSlot(slotIn, stack);
        if (!world.isRemote && slotIn.getIndex() == 0) {
            setCombatTask();
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(meleeAttackGoal);
        goalSelector.removeGoal(rangedBowAttackGoal);

        ItemStack itemstack = getHeldItemMainhand();
        if (itemstack.getItem() instanceof BowItem) {
            goalSelector.addGoal(2, rangedBowAttackGoal);
        } else {
            goalSelector.addGoal(2, meleeAttackGoal);
        }
    }

    public int getMobType() {
        return dataManager.get(SKIN);
    }

    private void setMobType(int id) {
        dataManager.set(SKIN, id);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt(MOB_TYPE_TAG, getMobType());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            int type = compound.getInt(MOB_TYPE_TAG);
            setMobType(type);
        }
        setCombatTask();
    }

    //Start of archer data

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != GaiaEntities.DWARF.get();
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if (target.isAlive()) {
            RangedHelper.rangedAttack(target, this, distanceFactor);
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(SKIN, 0);
        this.getDataManager().register(SWINGING_ARMS, false);
    }
    //End of archer data

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
        return GaiaSounds.DWARF_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.DWARF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.DWARF_DEATH;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        switch (getMobType()) {
            case 0:
                return GaiaLootTables.ENTITIES_GAIA_DWARF_MELEE;
            case 1:
                return GaiaLootTables.ENTITIES_GAIA_DWARF_RANGED;
            case 2:
                return GaiaLootTables.ENTITIES_GAIA_DWARF_MINER;
            default:
                return LootTables.EMPTY;
        }
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3 + lootingModifier);

            switch (getMobType()) {
                case 0:
                    for (int i = 0; i < drop; ++i) {
                        entityDropItem(GaiaItems.FOOD_MEAT.get(), 1);
                    }
                    break;
                case 1:
                    for (int i = 0; i < drop; ++i) {
                        entityDropItem(Items.ARROW, 1);
                    }
                    break;
                case 2:
                    for (int i = 0; i < drop; ++i) {
                        entityDropItem(Items.IRON_NUGGET, 1);
                    }
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

            // Semi-Rare
            if ((rand.nextInt(EntityAttributes.RATE_SEMI_RARE_DROP) == 0) && (getMobType() == 2)) {
                entityDropItem(new ItemStack(GaiaItems.BOX_ORE.get(), 1), 0.0F);
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
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0) && (getMobType() == 1)) {
                entityDropItem(GaiaItems.BAG_ARROW.get(), 1);
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

        if (randomClass) {
            if (world.rand.nextInt(4) == 0) {
                mobClass(difficulty, 1);
            } else {
                if (world.rand.nextInt(4) == 0) {
                    mobClass(difficulty, 2);
                } else {
                    mobClass(difficulty, 0);
                }
            }
        } else {
            mobClass(difficulty, classID);
        }

        setCombatTask();
        setBreakDoorsAItask(true);

        if (GaiaConfig.COMMON.spawnLevel3.get() && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0)) {
            canSpawnLevel3 = true;
        }

        return entityData;
    }

    public void mobClass(DifficultyInstance difficulty, int id) {
        switch (id) {
            case 0:
                setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_AXE_STONE.get()));
                setEnchantmentBasedOnDifficulty(difficulty);

                if (world.rand.nextInt(2) == 0) {
                    ItemStack shield = new ItemStack(GaiaItems.SHIELD_PROP_IRON.get(), 1);
                    setItemStackToSlot(EquipmentSlotType.OFFHAND, shield);
                    getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
                }
                break;
            case 1:
                ItemStack bowCustom = new ItemStack(Items.BOW);
                setItemStackToSlot(EquipmentSlotType.MAINHAND, bowCustom);
                bowCustom.addEnchantment(Enchantments.PUNCH, 1);

                if (world.rand.nextInt(2) == 0) {
                    if (world.rand.nextInt(2) == 0) {
                        setItemStackToSlot(EquipmentSlotType.OFFHAND, TIPPED_ARROW_CUSTOM);
                    } else {
                        setItemStackToSlot(EquipmentSlotType.OFFHAND, TIPPED_ARROW_CUSTOM_2);
                    }
                }
                break;
            case 2:
                setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.STONE_PICKAXE));
                setEnchantmentBasedOnDifficulty(difficulty);
                break;
        }
        setMobType(id);
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
