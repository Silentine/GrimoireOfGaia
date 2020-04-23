package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.goals.GaiaCreepSwellGoal;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.item.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class GaiaCreepEntity extends AbstractMobHostileEntity implements ISwimmingMob {

    private static final int DETECTION_RANGE = 8;

    private static final DataParameter<Integer> STATE = EntityDataManager.createKey(GaiaCreepEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> POWERED = EntityDataManager.createKey(GaiaCreepEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(GaiaCreepEntity.class, DataSerializers.BOOLEAN);
    private static final String EXPLOSION_RADIUS_TAG = "ExplosionRadius";
    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 30;
    private int explosionRadius = 3;

    public GaiaCreepEntity(EntityType<? extends GaiaCreepEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;
    }

    public GaiaCreepEntity(World world) {
        this(GaiaEntities.CREEP.get(), world);
    }

    @Override
    public void setAttackTask() {
        this.goalSelector.addGoal(2, new GaiaCreepSwellGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, true));
    }

    @Override
    public void giveSpecificTasks() {
        super.giveSpecificTasks();
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, OcelotEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, CatEntity.class, 6.0F, 1.0D, 1.2D));
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
    public boolean attackEntityAsMob(Entity entity) {
        return true;
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
        super.fall(distance, damageMultiplier);
        this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + distance * 1.5F);
        if (this.timeSinceIgnited > this.fuseTime - 5) {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(STATE, -1);
        this.dataManager.register(POWERED, false);
        this.dataManager.register(IGNITED, false);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.dataManager.get(POWERED)) {
            compound.putBoolean("powered", true);
        }

        compound.putShort("Fuse", (short)this.fuseTime);
        compound.putByte("ExplosionRadius", (byte)this.explosionRadius);
        compound.putBoolean("ignited", this.hasIgnited());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.dataManager.set(POWERED, compound.getBoolean("powered"));
        if (compound.contains("Fuse", 99)) {
            this.fuseTime = compound.getShort("Fuse");
        }

        if (compound.contains("ExplosionRadius", 99)) {
            this.explosionRadius = compound.getByte("ExplosionRadius");
        }

        if (compound.getBoolean("ignited")) {
            this.ignite();
        }
    }

    @Override
    public void tick() {
        if (playerDetection(this, DETECTION_RANGE)) {
            if (isPotionActive(Effects.INVISIBILITY)) {
                removePotionEffect(Effects.INVISIBILITY);
            }
        } else {
            if (!isPotionActive(Effects.INVISIBILITY)) {
                addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 480 * 20, 0));
            }
        }

        if (this.isAlive()) {
            this.lastActiveTime = this.timeSinceIgnited;
            if (this.hasIgnited()) {
                this.setCreeperState(1);
            }

            int i = this.getCreeperState();
            if (i > 0 && this.timeSinceIgnited == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
            }

            this.timeSinceIgnited += i;
            if (this.timeSinceIgnited < 0) {
                this.timeSinceIgnited = 0;
            }

            if (this.timeSinceIgnited >= this.fuseTime) {
                this.timeSinceIgnited = this.fuseTime;
                this.explode();
            }
        }

        super.tick();
    }

    private boolean hasIgnited() {
        return dataManager.get(IGNITED);
    }

    private void ignite() {
        dataManager.set(IGNITED, true);
    }

    public boolean getPowered() {
        return this.dataManager.get(POWERED);
    }

    @OnlyIn(Dist.CLIENT)
    public float getCreeperFlashIntensity(float partialTicks) {
        return MathHelper.lerp(partialTicks, (float)this.lastActiveTime, (float)this.timeSinceIgnited) / (float)(this.fuseTime - 2);
    }

    @Override
    public void onStruckByLightning(LightningBoltEntity lightningBolt) {
        super.onStruckByLightning(lightningBolt);
        this.dataManager.set(POWERED, true);
    }

    private void explode() {
        if (!world.isRemote) {
            Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            float f = getPowered() ? 2.0F : 1.0F;
            dead = true;
            world.createExplosion(this, this.posX, this.posY, this.posZ, (float) explosionRadius * f, explosion$mode);
            remove();
        }
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GaiaLootTables.ENTITIES_GAIA_CREEP;
    }

    public int getCreeperState() {
        return dataManager.get(STATE);
    }

    public void setCreeperState(int state) {
        dataManager.set(STATE, state);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(Items.GUNPOWDER, 1);
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
                entityDropItem(new ItemStack(GaiaItems.BOX_ORE.get()), 1);
            }

            // Unique Rare
//            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
//                entityDropItem(GaiaItems.SPAWN_CREEPER_GIRL, 1);
//            } TODO: SPAWN_CREEPER_GIRL item

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaBlocks.DOLL_CREEPER_GIRL.get(), 1);
            }
        }
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_UNDERGROUND;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return GaiaConfig.COMMON.disableYRestriction.get() ? true : posY < 60.0D && GaiaConfig.COMMON.disableYRestriction.get() ? true : posY > 32.0D && super.canSpawn(worldIn, reason);
    }
}
