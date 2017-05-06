package gaia.entity.item;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityGaiaChestJungle extends EntityAgeable {
	
	public EntityGaiaChestJungle(World worldIn) {
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

	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		for (int var = 0; var < 2; ++var) {
			this.dropRandomLootFromLootTable(LootTableList.CHESTS_JUNGLE_TEMPLE, wasRecentlyHit, lootingModifier, source);
		}
	}

	public void dropRandomLootFromLootTable(ResourceLocation dungeonLoot, boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		long LootTableSeed = 0;
		int maxCount = 0;
		int currentCount = 0;
		Random Randomize = new Random();
		int roll = 0;

		LootTable loottable = this.worldObj.getLootTableManager().getLootTableFromLocation(dungeonLoot);
		LootContext.Builder lootcontext$builder = (new LootContext.Builder((WorldServer)this.worldObj)).withLootedEntity(this).withDamageSource(source);

		if (wasRecentlyHit && this.attackingPlayer != null) {
			lootcontext$builder = lootcontext$builder.withPlayer(this.attackingPlayer).withLuck(this.attackingPlayer.getLuck());
		}

		for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L ? this.rand : new Random(LootTableSeed), lootcontext$builder.build())) {
			maxCount++;
		}

		roll = Randomize.nextInt(maxCount);        

		for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L ? this.rand : new Random(LootTableSeed), lootcontext$builder.build())) {
			if (currentCount == roll)this.entityDropItem(itemstack, 0.0F);
			currentCount++;      
		}
	}
	
	protected void onDeathUpdate() {
		this.setDead();
	}
	
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
