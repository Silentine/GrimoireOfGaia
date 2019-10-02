package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaValidateTargetPlayerGoal;
import gaia.entity.types.IDayMob;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
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

public class GaiaCyclopsEntity extends AbstractMobAssistEntity implements IDayMob, ISwimmingMob {

    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true);
    private final GaiaValidateTargetPlayerGoal targetPlayerGoal = new GaiaValidateTargetPlayerGoal(this);

    private int buffEffect;
    private boolean animationPlay;
    private int animationTimer;

    public GaiaCyclopsEntity(EntityType<? extends GaiaCyclopsEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        buffEffect = 0;
        animationPlay = false;
        animationTimer = 0;
    }

    public GaiaCyclopsEntity(World world) {
        this(GaiaEntities.CYCLOPS, world);
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void setValidateTargetPlayerTask() {
        if (this.world != null && !this.world.isRemote) {
            if (GaiaConfig.COMMON.passiveHostileAllMobs.get()) {
                this.targetSelector.addGoal(2, targetPlayerGoal);
            }

            if(this.isNeutral()) {
                this.targetSelector.removeGoal(this.targetPlayerGoal);
            }
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
    public boolean isTameable() {
        return true;
    }

    @Override
    public void livingTick() {
        /* BUFF */
        if (getHealth() <= EntityAttributes.MAX_HEALTH_1 * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
            setCombatTask(1);
            setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.STICK));
            buffEffect = 1;
            animationPlay = true;
        }

        if (getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.25F && buffEffect == 1) {
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
        super.livingTick();
    }

    private void setCombatTask(int id) {
        switch(id) {
            default:
                goalSelector.addGoal(1, aiAttackOnCollide);
            case 1:
                goalSelector.removeGoal(aiAttackOnCollide);
        }
    }

    private void setBuff() {
        world.setEntityState(this, (byte) 7);
        addPotionEffect(new EffectInstance(Effects.SPEED, 20 * 60, 0));
    }

    private void setCombatTask() {
        goalSelector.removeGoal(aiAttackOnCollide);

        setCombatTask(0);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.CYCLOPS_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.CYCLOPS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.CYCLOPS_DEATH;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GaiaLootTables.ENTITIES_GAIA_MONOEYE;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.MISC_FUR, 1);
            }

            // Nuggets/Fragments
            int dropNugget = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNugget; ++i) {
                entityDropItem(Items.IRON_NUGGET);
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
                EnchantedBookItem.addEnchantment(enchantmentBook, new EnchantmentData(Enchantments.SHARPNESS, 1));
                entityDropItem(enchantmentBook, 1);
            }
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
        setEnchantmentBasedOnDifficulty(difficulty);
        setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
        setEnchantmentBasedOnDifficulty(difficulty);

        setCombatTask();

        return entityData;
    }

    @Override
    protected int getFireImmuneTicks() {
        return 10;
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        setCombatTask();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return posY > 60.0D && super.canSpawn(worldIn, reason);
    }
}
