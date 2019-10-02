package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaStrafeGoal;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public class GaiaDeathwordEntity extends AbstractMobHostileEntity implements ISwimmingMob {

    private static final int DETECTION_RANGE = 6;

    private MeleeAttackGoal aiMeleeAttack = new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true);
    private GaiaStrafeGoal aiStrafe = new GaiaStrafeGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);

    private boolean canSpawn;
    private int spawnTimer;
    private int spawnLimit;

    public GaiaDeathwordEntity(EntityType<? extends GaiaDeathwordEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        canSpawn = true;
        spawnTimer = 0;
        spawnLimit = 0;
    }

    public GaiaDeathwordEntity(World world) {
        this(GaiaEntities.DEATHWORD, world);
    }

    @Override
    public int getGaiaTier() {
        return 1;
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
            effects.put(Effects.LEVITATION, 0);

            ApplyDebuff(world, this, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        beaconMonster();

        if (playerDetection(this, DETECTION_RANGE)) {
            if (spawnLimit <= 3 && canSpawn) {
                if (spawnTimer != 60) {
                    spawnTimer += 1;
                }

                if (spawnTimer == 60) {
                    world.setEntityState(this, (byte) 9);

                    if (!world.isRemote) {
                        switch (rand.nextInt(4)) {
                            case 0:
                                boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
                                if (!flag) {
                                    spawnMinion(0);
                                } else {
                                    spawnMinion(1);
                                }

                                break;
                            case 1:
                                spawnMinion(1);
                                break;
                            case 2:
                                spawnMinion(2);
                                break;
                            case 3:
                                spawnMinion(3);
                                break;
                            default:
                        }
                    }

                    spawnTimer = 0;
                    spawnLimit += 1;
                }
            }

            if (spawnLimit >= 4 && canSpawn) {
                setCombatTask(1);

                canSpawn = false;
            }
        }
        
        Vec3d motion = getMotion();
        if (!onGround && getMotion().getY() < 0.0D) {
            double motionY = motion.getY();
            motionY *= 0.8D;
            setMotion(motion.x, motionY, motion.z);
        }

        motion = getMotion();
        if (motion.x > 0 || motion.y > 0 || motion.z > 0) {
            for (int var5 = 0; var5 < 2; ++var5) {
                world.addParticle(ParticleTypes.ENCHANT, posX + (rand.nextDouble() - 0.5D) * getWidth(), posY + rand.nextDouble() * getHeight(), posZ + (rand.nextDouble() - 0.5D) * getWidth(), 0.0D, 0.0D, 0.0D);
            }
        }

        if (isBurning()) {
            addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 0));
            addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 0));
        }

        super.livingTick();
    }

    private void spawnMinion(int id) {
        switch (id) {
            default:
                CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
                creeper.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
                creeper.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(creeper)), null, null, null);
                world.addEntity(creeper);
            case 1:
                SkeletonEntity skeleton = new SkeletonEntity(EntityType.SKELETON, world);
                skeleton.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
                skeleton.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(skeleton)), null, null, null);
                skeleton.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_MOB, 1));
                skeleton.setDropChance(EquipmentSlotType.MAINHAND, 0);
                skeleton.setDropChance(EquipmentSlotType.OFFHAND, 0);
                skeleton.setDropChance(EquipmentSlotType.FEET, 0);
                skeleton.setDropChance(EquipmentSlotType.LEGS, 0);
                skeleton.setDropChance(EquipmentSlotType.CHEST, 0);
                skeleton.setDropChance(EquipmentSlotType.HEAD, 0);
                world.addEntity(skeleton);
            case 2:
                SpiderEntity spider = new SpiderEntity(EntityType.SPIDER, world);
                spider.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
                spider.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(spider)), null, null, null);
                world.addEntity(spider);
            case 3:
                ZombieEntity zombie = new ZombieEntity(world);
                zombie.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
                zombie.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(zombie)), null, null, null);
                zombie.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_MOB, 1));
                zombie.setDropChance(EquipmentSlotType.MAINHAND, 0);
                zombie.setDropChance(EquipmentSlotType.OFFHAND, 0);
                zombie.setDropChance(EquipmentSlotType.FEET, 0);
                zombie.setDropChance(EquipmentSlotType.LEGS, 0);
                zombie.setDropChance(EquipmentSlotType.CHEST, 0);
                zombie.setDropChance(EquipmentSlotType.HEAD, 0);
                world.addEntity(zombie);
        }
    }

    private void setCombatTask() {
        goalSelector.removeGoal(aiMeleeAttack);
        goalSelector.removeGoal(aiStrafe);

        setCombatTask(1);
    }

    private void setCombatTask(int id) {
        switch (id) {
            default:
                goalSelector.removeGoal(aiMeleeAttack);
                goalSelector.addGoal(1, aiStrafe);
            case 1:
                goalSelector.removeGoal(aiStrafe);
                goalSelector.addGoal(1, aiMeleeAttack);
        }
    }

    private void beaconMonster() {
        if (!world.isRemote) {
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(6);
            List<LivingEntity> moblist = world.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);

            for (LivingEntity mob : moblist) {
                if (!(mob instanceof PlayerEntity)) {
                    mob.addPotionEffect(new EffectInstance(Effects.STRENGTH, 60 * 20, 1, true, true));
                }
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.BOOK_HIT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.BOOK_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.BOOK_HIT;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GaiaLootTables.ENTITIES_GAIA_DEATHWORD;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            int drop = rand.nextInt(3) + 1;

            for (int i = 0; i < drop; ++i) {
                entityDropItem(Items.PAPER, 1);
            }

            if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(Items.BOOK, 1);
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
                entityDropItem(GaiaItems.BAG_BOOK, 1);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.WEAPON_BOOK, 1);
            }
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        ItemStack weaponCustom = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED, 1);
        weaponCustom.addEnchantment(Enchantments.KNOCKBACK, 1);
        setItemStackToSlot(EquipmentSlotType.MAINHAND, weaponCustom);

        setCombatTask();

        return entityData;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
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
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return posY < 16.0D && super.canSpawn(worldIn, reason);
    }
}
