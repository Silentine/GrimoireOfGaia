package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaDullahanEntity extends AbstractMobHostileEntity implements ISwimmingMob {
    public GaiaDullahanEntity(EntityType<? extends GaiaDullahanEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;
    }

    public GaiaDullahanEntity(World world) {
        this(GaiaEntities.DULLAHAN.get(), world);
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void setAttackTask() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true));
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

    public boolean attackEntityFrom(DamageSource damageSource, int inputDamage) {
        Entity entity = damageSource.getTrueSource();
        int damage = inputDamage;
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack itemstack = player.getHeldItem(getActiveHand());

            Item item = itemstack.getItem();
            if (item == Items.GOLDEN_SWORD || item == Items.GOLDEN_AXE || item == Items.GOLDEN_SHOVEL || item == Items.GOLDEN_HOE || item == Items.GOLDEN_PICKAXE) {
                damage = 14;
                damage = (int) (damage + ItemTier.GOLD.getAttackDamage());
            }
        }

        return super.attackEntityFrom(damageSource, damage);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.DULLAHAN_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.DULLAHAN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.DULLAHAN_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.MISC_SOUL_FIRE.get(), 1);
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
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD.get()));
        setEnchantmentBasedOnDifficulty(difficulty);

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
