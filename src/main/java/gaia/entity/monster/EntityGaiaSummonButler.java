package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.GaiaLootTableList;
import gaia.init.GaiaEntities;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;


public class EntityGaiaSummonButler extends EntityMobHostileBase {

	public EntityGaiaSummonButler(World worldIn) {
		super(GaiaEntities.BUTLER, worldIn);

		experienceValue = 0;
		stepHeight = 1.0F;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		tasks.addTask(2, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1 * 0.5);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
	}
	
	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaDhampir.class || cls != EntityGaiaVampire.class;
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.ENTITIES_GAIA_BUTLER;
	}

	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		return entityLivingData;
	}

	public float getEyeHeight() {
		return 0.45F;
	}

	@Override
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		return posY < 0.0D && super.canSpawn(world, p_205020_2_);
	}
}
