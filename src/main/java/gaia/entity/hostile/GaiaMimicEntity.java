package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.item.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.HashMap;

public class GaiaMimicEntity extends AbstractMobHostileEntity {

    public GaiaMimicEntity(EntityType<? extends GaiaMimicEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 6.0F;

        this.setCanPickUpLoot(true);
    }

    public GaiaMimicEntity(World world) {
        this(GaiaEntities.MIMIC.get(), world);
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
        getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_0);
        getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
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
            effects.put(Effects.HUNGER, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        rangeDebuff(2, Effects.HUNGER, 100, 0);

        Vec3d motion = getMotion();
        if (!onGround && motion.y < 0.0D) {
            double motionY = motion.y;
            motionY *= 0.8D;
            setMotion(motion.x, motionY, motion.z);
        }

        if (getHealth() < EntityAttributes.MAX_HEALTH_1) {
            if (hasItem()) {
                setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);

                world.setEntityState(this, (byte) 8);
                heal(EntityAttributes.MAX_HEALTH_1 * 0.20F);
            }
        }

        if (isBurning()) {
            addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 0));
            addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 0));
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
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_CHEST_OPEN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BLOCK_WOOD_STEP;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_CHEST_OPEN;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            // Nuggets/Fragments
            int drop = rand.nextInt(3) + 1;

            for (int i = 0; i < drop; ++i) {
                entityDropItem(Items.IRON_NUGGET, 1);
            }

            if (GaiaConfig.COMMON.additionalOre.get()) {
                int dropNugget = rand.nextInt(3) + 1;

                for (int i = 0; i < dropNugget; ++i) {
                    ItemShard.dropNugget(this, 4);
                }
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                entityDropItem(new ItemStack(GaiaItems.BOX_ORE.get(), 1), 0.0F);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.FOOD_MONSTER_FEED_PREMIUM.get(), 1);
            }

//            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
//                entityDropItem(GaiaItems.SPAWN_TRADER, 1);
//            } TODO: SPAWN_TRADER Item

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BAG_RECORD.get(), 1);
            }

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.WEAPON_BOOK_HUNGER.get(), 1);
            }
        }
    }

    /* IMMUNITIES */
    @Override
    public void fall(float distance, float damageMultiplier) {
    }
    /* IMMUNITIES */

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return reason != SpawnReason.NATURAL && super.canSpawn(worldIn, reason);
    }
}
