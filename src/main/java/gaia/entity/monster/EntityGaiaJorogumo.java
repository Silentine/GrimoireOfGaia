package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.entity.ai.EntityAIGaiaLeapAtTarget;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaJorogumo extends EntityMobBase {
	private static final Item[] jorogumoDrops = new Item[] { 
		Items.fermented_spider_eye, Items.fermented_spider_eye, Items.fermented_spider_eye, 
		Items.spider_eye, Items.spider_eye, Items.spider_eye, 
		Items.string, Items.string, Items.string, 
		Items.speckled_melon,
		Items.golden_carrot,
		Item.getItemFromBlock(Blocks.brown_mushroom) };
	private int spawn;

	public EntityGaiaJorogumo(World par1World) {
		super(par1World);
		this.setSize(1.4F, 1.6F);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaLeapAtTarget(this, 0.4F));
		this.tasks.addTask(2, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.spawn = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth1);
//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage1);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if(super.attackEntityAsMob(par1Entity)) {
			if(par1Entity instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL){
                	byte0 = 7;
                } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                	byte0 = 15;
                }

				if(byte0 > 0) {
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, byte0 * 60, 0));
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.weakness.id, byte0 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		EntityCaveSpider spawnMob;
		if(this.getHealth() < EntityAttributes.maxHealth1 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0 && !this.worldObj.isRemote) {
			spawnMob = new EntityCaveSpider(this.worldObj);
			spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			spawnMob.onSpawnWithEgg((IEntityLivingData)null);
			this.worldObj.spawnEntityInWorld(spawnMob);
			this.spawn = 1;
		}

		if(this.getHealth() < EntityAttributes.maxHealth1 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1 && !this.worldObj.isRemote) {
			spawnMob = new EntityCaveSpider(this.worldObj);
			spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			spawnMob.onSpawnWithEgg((IEntityLivingData)null);
			this.worldObj.spawnEntityInWorld(spawnMob);
			this.spawn = 2;
		}

		super.onLivingUpdate();
	}

	public boolean attackEntityFrom(DamageSource ds, float amount) {
		return super.attackEntityFrom(ds, amount * (float)(ds.isProjectile()?2:1));
	}

	protected String getLivingSound() {
		return "gaia:aggressive_say";
	}

	protected String getHurtSound() {
		return "gaia:aggressive_hurt";
	}

	protected String getDeathSound() {
		return "gaia:aggressive_death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.spider.step", 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3) + 1;

		for(int var4 = 0; var4 < var3; ++var4) {
			int var5 = this.rand.nextInt(3);
			Item var6 = jorogumoDrops[this.rand.nextInt(jorogumoDrops.length)];
			if(par2 > 0) {
				var5 += this.rand.nextInt(par2 + 1);
			}

			for(int var7 = 0; var7 < var5; ++var7) {
				this.dropItem(var6, 1);
			}
		}

		if(par1 && (this.rand.nextInt(10) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.MiscFurnaceFuel,1);
		}
		
		if(par1 && (this.rand.nextInt(8) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 5), 0.0F);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(4)) {
		case 0:
			this.dropItem(GaiaItem.BagOre,1);
			break;
		case 1:
			this.dropItem(GaiaItem.BagRecord,1);
			break;
		case 2:
			this.dropItem(GaiaItem.MiscBook,1);
			break;
		case 3:
			this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id?false:super.isPotionApplicable(par1PotionEffect);
	}

	public void setInWeb() {}

	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
    }

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1IEntityLivingData) {
		par1IEntityLivingData = super.onSpawnWithEgg(par1IEntityLivingData);
		this.setCurrentItemOrArmor(0, new ItemStack(GaiaItem.PropWeapon, 1, 0));
		this.enchantEquipment();
		return par1IEntityLivingData;
	}

	public void knockBack(Entity par1Entity, int par2, double par3, double par5) {
		this.isAirBorne = true;
		float var7 = MathHelper.sqrt_double(par3 * par3 + par5 * par5);
		float var8 = 0.4F;
		this.motionX /= 2.0D;
		this.motionY /= 2.0D;
		this.motionZ /= 2.0D;
		this.motionX -= par3 / (double)var7 * (double)var8;
		this.motionY += (double)var8;
		this.motionZ -= par5 / (double)var7 * (double)var8;
		if(this.motionY > EntityAttributes.knockback1) {
			this.motionY = EntityAttributes.knockback1;
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY < 32.0D && super.getCanSpawnHere();
	}
}
