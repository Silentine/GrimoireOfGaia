package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaMatangoEntity extends AbstractMobHostileEntity {
    private static final ItemStack[] matangoDrops = new ItemStack[] { new ItemStack(Blocks.RED_MUSHROOM, 1), new ItemStack(Blocks.BROWN_MUSHROOM, 1) };

    private int spawnLimit;
    private int spawnTime;
    private boolean canSpawn;

    public GaiaMatangoEntity(EntityType<? extends GaiaMatangoEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        spawnLimit = 0;
        spawnTime = 0;
        canSpawn = true;
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void setAttackTask() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_0, true));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float input = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        Entity entity = source.getTrueSource();

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack itemstack = player.getHeldItem(getActiveHand());

            if (itemstack.getItem() instanceof AxeItem) {
                input = input * 1.5F;
            }
        }

        return super.attackEntityFrom(source, input);
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.NAUSEA, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        rangeDebuff(2, Effects.SPEED, 300, 0);

        Vec3d motion = getMotion();
        if (motion.x * motion.x + motion.z * motion.z > 2.500000277905201E-7D && rand.nextInt(5) == 0) {
            int i = MathHelper.floor(getPosX());
            int j = MathHelper.floor(getPosY() - 0.20000000298023224D);
            int k = MathHelper.floor(getPosZ());
            BlockState blockstate = world.getBlockState(new BlockPos(i, j, k));

            if (blockstate.getMaterial() != Material.AIR) {
                world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate), getPosX() + (rand.nextDouble() - 0.5D) * getWidth(), getBoundingBox().minY + 0.1D, getPosZ() + (rand.nextDouble() - 0.5D) * getWidth(), 4.0D * (rand.nextDouble() - 0.5D), 0.5D, (rand.nextDouble() - 0.5D) * 4.0D);
            }
        }

        if (getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.90F && getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.10F) {
            if (canSpawn) {
                if (spawnLimit < 5) {
                    if ((spawnTime >= 0) && (spawnTime <= 140)) {
                        ++spawnTime;
                    } else {
                        world.setEntityState(this, (byte) 9);

                        if (!world.isRemote) {
                            setSpawn(0);
                        }

                        world.setEntityState(this, (byte) 8);
                        heal(EntityAttributes.MAX_HEALTH_1 * 0.20F);

                        spawnLimit += 1;
                        spawnTime = 0;

                    }
                } else {
                    canSpawn = false;
                }
            }
        }

        if (isBurning()) {
            addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 0));
            addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 0));
        }

        super.livingTick();
    }

    private void setSpawn(int id) {
        if (!isNeutral()) {
            if (id == 0) {
//                GaiaSporelingEntity sporeling = new GaiaSporelingEntity(world); TODO: Spawn Sporeling here
//                sporeling.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
//                sporeling.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(sporeling)), null, null);
//                world.spawnEntity(sporeling);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.MATANGO_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.MATANGO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.MATANGO_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            for (int i = 0; i < 1; ++i) {
                ItemStack dropList = matangoDrops[rand.nextInt(matangoDrops.length)];

                for (int j = 0; j < 1; ++j) {
                    entityDropItem(dropList, 1);
                }
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

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData ret = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        ItemStack weaponCustom = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED.get(), 1);
        weaponCustom.addEnchantment(Enchantments.KNOCKBACK, 1);
        setItemStackToSlot(EquipmentSlotType.MAINHAND, weaponCustom);

        return ret;
    }

    /* IMMUNITIES */

    @Override
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        return potioneffectIn.getPotion() != Effects.POISON && super.isPotionApplicable(potioneffectIn);
    }
    /* IMMUNITIES */

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return getPosY() > 60.0D && super.canSpawn(world, reason);
    }
}
