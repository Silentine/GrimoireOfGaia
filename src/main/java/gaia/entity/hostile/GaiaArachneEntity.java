package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.SpiderEntity;
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
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public class GaiaArachneEntity extends AbstractMobHostileEntity implements ISwimmingMob, IRangedAttackMob {

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(GaiaArachneEntity.class, DataSerializers.BYTE);

    private final RangedAttackGoal aiArrowAttack = new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 60, 15.0F);
    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true);

    private int switchHealth;
    private int spawn;
    private int spawnTimer;

    private boolean animationPlay;
    private int animationTimer;

    public GaiaArachneEntity(EntityType<? extends GaiaArachneEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        switchHealth = 0;
        spawn = 0;
        spawnTimer = 0;

        animationPlay = false;
        animationTimer = 0;
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(CLIMBING, (byte) 0);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        this.setCombatTask();
    }

    @Override
    public boolean isOnLadder() {
        return isBesideClimbableBlock();
    }

    private boolean isBesideClimbableBlock() {
        return (getDataManager().get(CLIMBING) & 1) != 0;
    }

    private void setBesideClimbableBlock(boolean climbing) {
        byte b0 = getDataManager().get(CLIMBING);

        if (climbing) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        getDataManager().set(CLIMBING, b0);
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
        RangedHelper.web(target, this, distanceFactor, 0.0D);

        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.ARROW));
        animationPlay = true;
        animationTimer = 0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        return !(source instanceof IndirectEntityDamageSource) && super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != GaiaEntities.ARACHNE.get();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.SLOWNESS, 0);

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
    public void livingTick() {
        this.boostSpiderlikes();

        if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.5F) && (switchHealth == 0)) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL.get()));
            this.setCombatTask(1);
            switchHealth = 1;
        }

        if ((getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.5F) && (switchHealth == 1)) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_ENDER.get(), 1));
            this.setCombatTask(0);
            switchHealth = 0;
        }

        if (getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.75F && getHealth() > 0.0F && spawn == 0) {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.STICK));

            if (spawnTimer != 30) {
                spawnTimer += 1;
            }

            if (spawnTimer == 30) {
                world.setEntityState(this, (byte) 9);
                this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);

                if (!world.isRemote) {
                    spawnMinion(0);
                }

                spawnTimer = 0;
                spawn = 1;
            }
        }

        if (getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.25F && getHealth() > 0.0F && spawn == 1) {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.STICK));

            if (spawnTimer != 30) {
                spawnTimer += 1;
            }

            if (spawnTimer == 30) {
                world.setEntityState(this, (byte) 9);
                this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);

                if (!world.isRemote) {
                    spawnMinion(0);
                }

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

        if (!world.isRemote) {
            setBesideClimbableBlock(collidedHorizontally);
        }

        super.livingTick();
    }

    private void spawnMinion(int id) {
        switch(id) {
            default:
                CaveSpiderEntity caveSpider = new CaveSpiderEntity(EntityType.CAVE_SPIDER, world);
                caveSpider.setLocationAndAngles(getPosX(), getPosY(), getPosZ(), rotationYaw, 0.0F);
                caveSpider.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(caveSpider)), null, null, null);
                world.addEntity(caveSpider);
        }
    }

    private void boostSpiderlikes() {
        if (!world.isRemote) {
            AxisAlignedBB axisalignedbb = new AxisAlignedBB(getPosX(), getPosY(), getPosZ(), (getPosX() + 1), (getPosY() + 1), (getPosZ() + 1)).grow(6D);
            List<LivingEntity> moblist = world.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);

            for (LivingEntity mob : moblist) {
                if (mob instanceof SpiderEntity) {
                    mob.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300, 1, true, true));
                }
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.ARACHNE_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.ARACHNE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.ARACHNE_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GaiaLootTables.ENTITIES_GAIA_SPHINX;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.MISC_FURNACE_FUEL.get(), 1);
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
                entityDropItem(new ItemStack(GaiaItems.BOX_ORE.get()), 0.0F);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.MISC_BOOK.get());
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        ItemStack weaponCustom = new ItemStack(GaiaItems.WEAPON_PROP_ENDER.get(), 1);
        weaponCustom.addEnchantment(Enchantments.KNOCKBACK, 2);
        setItemStackToSlot(EquipmentSlotType.MAINHAND, weaponCustom);

        this.setCombatTask();

        return entityData;
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    public void setMotionMultiplier(BlockState blockState, Vec3d motion) {
        if (blockState.getBlock() != Blocks.COBWEB) {
            super.setMotionMultiplier(blockState, motion);
        }
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_UNDERGROUND;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return GaiaConfig.COMMON.disableYRestriction.get() || getPosY() < 32.0D && super.canSpawn(worldIn, reason);
    }
}
