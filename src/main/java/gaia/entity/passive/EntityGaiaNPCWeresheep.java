package gaia.entity.passive;

import javax.annotation.Nullable;

import gaia.entity.EntityMobMerchant;
import gaia.entity.GaiaTrade;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGaiaNPCWeresheep extends EntityMobMerchant {

	private static final DataParameter<Boolean> IS_SHEARED = EntityDataManager.<Boolean>createKey(EntityGaiaNPCWeresheep.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> DYE_COLOR = EntityDataManager.<Integer>createKey(EntityGaiaNPCWeresheep.class, DataSerializers.VARINT);

	public EntityGaiaNPCWeresheep(World worldIn) {
		super(worldIn);
	}

	protected void entityInit() {
		super.entityInit();
		dataManager.register(IS_SHEARED, false);
		dataManager.register(DYE_COLOR, Integer.valueOf(EnumDyeColor.WHITE.getDyeDamage()));
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.WERESHEEP_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.WERESHEEP_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.WERESHEEP_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if (rand.nextInt(1) == 0 || rand.nextInt(1 + lootingModifier) > 0) {
				entityDropItem(new ItemStack(GaiaItems.SPAWN_WERESHEEP, 1, 0), 0.0F);
			}
		}
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 1, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));

		// Buy List
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 0)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 1)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 2)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 4)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 5)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 6)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 7)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 8)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 9)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 10)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 11)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 12)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 13)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 14)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Blocks.WOOL, 1, 15)));
		recipes.add(new GaiaTrade(new ItemStack(GaiaItems.MISC_CURRENCY, 4, 3), ItemStack.EMPTY, new ItemStack(Items.STRING, 4, 0)));

		// Sell List
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 0), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 1), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 2), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 3), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 4), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 5), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 6), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 7), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 8), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 9), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 10), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 11), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 12), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 13), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 14), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
		recipes.add(new GaiaTrade(new ItemStack(Blocks.WOOL, 1, 15), ItemStack.EMPTY, new ItemStack(GaiaItems.MISC_CURRENCY, 1, 3)));
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);

		if (itemstack.getItem() == Items.DYE) {
			EnumDyeColor enumdyecolor = EnumDyeColor.byDyeDamage(itemstack.getMetadata());

			if (enumdyecolor != this.getDyeColor()) {
				this.setDyeColor(enumdyecolor);

				if (!player.capabilities.isCreativeMode) {
					itemstack.shrink(1);
				}

				return true;
			}
		}

		if (itemstack.getItem() == Items.SHEARS && !this.isSheared() && !this.isChild()) // Forge: Moved to onSheared
		{
			if (!this.world.isRemote) {
				setSheared(true);
			}

			itemstack.damageItem(1, player);
			this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
		}

		return super.processInteract(player, hand);
	}

	public EnumDyeColor getDyeColor() {
		return EnumDyeColor.byDyeDamage(((Integer) this.dataManager.get(DYE_COLOR)).intValue() & 15);
	}

	public void setDyeColor(EnumDyeColor Dyecolor) {
		this.dataManager.set(DYE_COLOR, Integer.valueOf(Dyecolor.getDyeDamage()));
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
        compound.setBoolean("Sheared", this.isSheared());
		compound.setByte("DyeColor", (byte) this.getDyeColor().getDyeDamage());
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		setSheared(compound.getBoolean("Sheared"));
        
		if (compound.hasKey("DyeColor", 99)) {
			this.setDyeColor(EnumDyeColor.byDyeDamage(compound.getByte("DyeColor")));
		}
	}

	public boolean isSheared() {
		return ((Boolean) getDataManager().get(IS_SHEARED)).booleanValue();
	}

	public void setSheared(boolean isChild) {
		getDataManager().set(IS_SHEARED, Boolean.valueOf(isChild));
	}
}
