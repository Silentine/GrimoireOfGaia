package gaia.entity.item;

import gaia.entity.GaiaLootTableList;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGaiaBox extends EntityAgeable {
	
	public EntityGaiaBox(World worldIn) {
		super(worldIn);
		this.prevRenderYawOffset = 180.0F;
		this.renderYawOffset = 180.0F;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
	}
	
	public void onLivingUpdate() {
		this.attackEntityFrom(DamageSource.generic, 2.0F);
		super.onLivingUpdate();
	}
	
    protected float getSoundVolume() {
        return 0.0F;
    }

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.BOXES_OVERWORLD;
	}
	
	protected void onDeathUpdate() {
		this.setDead();
	}
	
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
