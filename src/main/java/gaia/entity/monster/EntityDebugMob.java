package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.renderer.particle.ParticleExample;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.Random;

//May as well keep this for future use. Model can be accessed and repurposed through mods.
//Remove egg from GaiaEntity before release!

/**
 * Used for testing new or updated features.
 */
public class EntityDebugMob extends EntityMobHostileDay {

    private static int manual_clock;

    public EntityDebugMob(World par1World) {
        super(par1World);

        this.experienceValue = EntityAttributes.experienceValue1;
        this.stepHeight = 1.0F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed1, true));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

        this.timer = 20; // timer
        this.manual_clock = 0;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
                .setBaseValue((double) EntityAttributes.maxHealth1);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE)
                .setBaseValue(EntityAttributes.followrange);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                .setBaseValue((double) EntityAttributes.moveSpeed1);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
                .setBaseValue((double) EntityAttributes.attackDamage1);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR)
                .setBaseValue((double) EntityAttributes.rateArmor1);
    }

    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (damage > EntityAttributes.baseDefense1) {
            damage = EntityAttributes.baseDefense1;
        }

        return super.attackEntityFrom(source, damage);
    }

    // ==================== Example Implementations ===================//
    public void onLivingUpdate() {
        super.onLivingUpdate();

        // 10 ticks = 1 second
        // 1 meter = 1 block

        // Examples of types of timers that can be used
        /*
        if ((this.manual_clock > 0) && (this.manual_clock <= 400)) {
            ++this.manual_clock;
        } else {
            if (!this.worldObj.isRemote) {
            
            }
            this.manual_clock = 1;
        }
        if (this.clock()) { 
            if (!this.worldObj.isRemote) {
                
            }
        }
        if (this.ticksExisted % 120 == 0) {
            if (!this.worldObj.isRemote) {
                
            }
        }
         */

        // Example of generating a custom particle
        if (!this.world.isRemote && rand.nextInt(200) == 0) {
            BlockPos pos = this.getPosition();
            ParticleExample newEffect = new ParticleExample(this.world, pos.getX() + 0.5, pos.getY() + 2.2, pos.getZ() + 0.5, 0, 0.001, 0);
            Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
        }
    }

    // ================= Example Methods =================//

    /** This method gets called first when a mob dies and wants to drop some loot
     * Normally it would check if there is a LootTable bound to the mob, and drop it
     * If not, it would send it to the hardcoded dropFewItems() method 
     * Instead of doing one or the other, I've overriden it an told it to do both
     * So it can drop things from a special LootTable and what else would normally drop
     */
    @Override
    protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
        /** Our method to drop a single random item from a loot table **/
        dropRandomLootFromLootTable(LootTableList.CHESTS_END_CITY_TREASURE, wasRecentlyHit, lootingModifier, source);

        /** We could setup multiples to work in conjunction via randoms and more control statements 
         * Or we could just use the control statements to adjust the chance the mob would attempt to drop something from that pool**/
        // TODO this does not seem to work with ENTITY LootTables
        //if(this.rand.nextInt(4) == 2)drop_A_Random_Loot_From_LootTable(LootTableList.ENTITIES_BLAZE, wasRecentlyHit, lootingModifier, source);

        /** Our legacy method to handle our other mob drops **/
        this.dropFewItems(wasRecentlyHit, lootingModifier);

    }

    /**
     * Our Method to drop a random item from an entire Loot Table
     **/
    public void dropRandomLootFromLootTable(ResourceLocation dungeonLoot, boolean wasRecentlyHit, int lootingModifier, DamageSource source) {

        long LootTableSeed = 0;
        int maxCount = 0;
        int currentCount = 0;
        Random Randomize = new Random();
        int roll = 0;

        // Things for Looting enchant calculations
        LootTable loottable = this.world.getLootTableManager()
                .getLootTableFromLocation(dungeonLoot);
        LootContext.Builder lootcontext$builder = (new LootContext.Builder((WorldServer) this.world)).withLootedEntity(this)
                .withDamageSource(source);

        if (wasRecentlyHit && this.attackingPlayer != null) {
            lootcontext$builder = lootcontext$builder.withPlayer(this.attackingPlayer)
                    .withLuck(this.attackingPlayer.getLuck());
        }

        // Here we count the amount of pools are in the Loot Table Array
        for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L
                ? this.rand
                : new Random(LootTableSeed), lootcontext$builder.build())) {
            maxCount++;
        }
        // Our Roll dependent on the amount of pools we counted
        roll = Randomize.nextInt(maxCount);

        for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L
                ? this.rand
                : new Random(LootTableSeed), lootcontext$builder.build())) {
            // Check if our current iteration matches our roll
            if (currentCount == roll) {
                this.entityDropItem(itemstack, 0.0F);
            }
            currentCount++; // Incrementing the current Iteration
        }
    }

    /** Our legacy method for dropping items
     * In the newest versions, this is a fallback **/
    protected void dropFewItems(boolean flag, int par) {
        BlockPos pos3 = this.getPosition();
        ParticleExample newEffect3 = new ParticleExample(this.world, pos3.getX() + 0.5, pos3.getY() + 2.2, pos3.getZ() + 0.5, 0, 0.0025, 0);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect3);

        /*
        //IDs found @Enchantment.registerEnchantments();
        ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
        //Special method that gives books a unique NBT they need
        Items.ENCHANTED_BOOK.addEnchantment(book, new EnchantmentData(Enchantment.getEnchantmentByID(35), 2));
        Items.ENCHANTED_BOOK.addEnchantment(book, new EnchantmentData(Enchantment.getEnchantmentByID(70), 1));        
        book.setStackDisplayName("Mysterious Tome");
        this.entityDropItem(book, 2);

        ItemStack shirt = new ItemStack(Items.LEATHER_CHESTPLATE);
        //Stack version is usable for other things
        shirt.addEnchantment(Enchantment.getEnchantmentByID(0), 2);
        ItemArmor itemarmor = (ItemArmor)shirt.getItem();
        itemarmor.setColor(shirt, 5681460);
        shirt.setStackDisplayName("Dusty Shirt");
        this.entityDropItem(shirt, 1);    

        ItemStack rod = new ItemStack(Items.FISHING_ROD);
        //Stack version is usable for other things
        rod.addEnchantment(Enchantment.getEnchantmentByID(62), 2);
        rod.setStackDisplayName("Arctic Fishing Rod");
        this.entityDropItem(rod, 1);    
         */
    }

    //================= Clock to prevent effect being spammed =================//
    public boolean clock() {
        this.timer++;
        if (this.timer > 600) {
            this.timer = 0;
            return true;
        }
        return false;
    };

    short timer;

    /**
     * Data for Clock
     */
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        if (tag.hasKey("Timer")) {
            short b0 = tag.getShort("Timer");
        }
    }

    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setShort("Timer", this.timer);
    }

    // ================= Bunch of mundane things below =================//
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SHOVEL));
        this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.BOW));
        this.setCustomNameTag("Debug Mob");
        return livingdata;
    }

    public boolean getCanSpawnHere() {
        return this.posY < 0.0D && super.getCanSpawnHere();
    }
}
