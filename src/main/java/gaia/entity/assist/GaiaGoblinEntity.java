package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IDayMob;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.item.ItemShieldProp;
import gaia.util.RangedHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;

import javax.annotation.Nullable;

public class GaiaGoblinEntity extends AbstractMobAssistEntity implements IDayMob, ISwimmingMob, IRangedAttackMob {
    private static final String MOB_TYPE_TAG = "MobType";
    private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(GaiaGoblinEntity.class, DataSerializers.VARINT);

    private final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 60, 15.0F);
    private final MeleeAttackGoal collideAttackGoal = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true) {
        public void resetTask() {
            super.resetTask();
            GaiaGoblinEntity.this.setAggroed(false);
        }

        public void startExecuting() {
            super.startExecuting();
            GaiaGoblinEntity.this.setAggroed(true);
        }
    };

    public GaiaGoblinEntity(EntityType<? extends GaiaGoblinEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;
        setCanPickUpLoot(true);
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if (target.isAlive()) {
            RangedHelper.bomb(target, this, distanceFactor);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        if (hasShield()) {
            Entity entity = source.getImmediateSource();
            return !(entity instanceof ArrowEntity) && super.attackEntityFrom(source, attackDamage);
        } else {
            return super.attackEntityFrom(source, attackDamage);
        }
    }

    private boolean hasShield() {
        ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);

        return itemstack.getItem() instanceof ShieldItem || itemstack.getItem() instanceof ItemShieldProp;
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
        super.setItemStackToSlot(slotIn, stack);
        if (!world.isRemote && slotIn.getIndex() == 0) {
            setCombatTask();
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(collideAttackGoal);
        goalSelector.removeGoal(rangedAttackGoal);
        ItemStack itemstack = getHeldItemMainhand();

        if (itemstack.getItem() == GaiaItems.WEAPON_PROJECTILE_BOMB.get()) {
            goalSelector.addGoal(1, rangedAttackGoal);
        } else {
            goalSelector.addGoal(1, collideAttackGoal);
        }
    }

    @Override
    public boolean canAttack(EntityType<?> type) {
        return super.canAttack(type) && type != GaiaEntities.GOBLIN.get();
    }

    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(SKIN, 0);
    }

    public int getTextureType() {
        return dataManager.get(SKIN);
    }

    private void setTextureType(int par1) {
        dataManager.set(SKIN, par1);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte(MOB_TYPE_TAG, (byte) getTextureType());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(MOB_TYPE_TAG)) {
            byte b0 = compound.getByte(MOB_TYPE_TAG);
            setTextureType(b0);
        }

        setCombatTask();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.GOBLIN_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.GOBLIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.GOBLIN_DEATH;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        switch (getTextureType()) {
            case 0:
                return GaiaLootTables.ENTITIES_GAIA_GOBLIN_MELEE;
            case 1:
                return GaiaLootTables.ENTITIES_GAIA_GOBLIN_RANGED;
            default:
                return LootTables.EMPTY;
        }
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_MEAT.get(), 1);
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
                if (getTextureType() == 1) {
                    entityDropItem(GaiaItems.BAG_ARROW.get(), 1);
                }
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        if (world.rand.nextInt(4) == 0) {
            mobClass(difficulty, 1);
        } else {
            mobClass(difficulty, 0);
        }

        setCombatTask();

        return entityData;
    }

    public void mobClass(DifficultyInstance difficulty, int id) {
        switch (id) {
            case 0:
                setEquipmentBasedOnDifficulty(difficulty);
                break;
            case 1:
                setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROJECTILE_BOMB.get()));
                setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.FLINT_AND_STEEL));
                break;
        }

        setTextureType(id);
        setTextureType(id);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        if (rand.nextInt(4) == 0) {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD.get()));
        } else {
            setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_AXE_WOOD.get()));
        }
        setEnchantmentBasedOnDifficulty(difficulty);
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
