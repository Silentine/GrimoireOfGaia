package gaia.entity;

import com.google.common.collect.Sets;
import gaia.config.GaiaConfig;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface ISharedMethods {
    public static Set<Block> spawnBlocks = Sets.newHashSet(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.GRAVEL, Blocks.SAND, Blocks.SNOW, Blocks.SNOW);
    public static Set<Block> blackList = Sets.newHashSet(Blocks.REDSTONE_TORCH); //GaiaBlocks.SPAWN_GUARD

    /* SPAWN CONDITIONS */
    default boolean daysPassed(World world) {
        int daysPassedClientInt = (int) (world.getGameTime() / 24000);

        return GaiaConfig.COMMON.spawnDaysSet.get() <= daysPassedClientInt;
    }

    default boolean isDimensionBlacklisted(World world) {
        if(!GaiaConfig.COMMON.dimensionBlacklist.get().isEmpty()) {
            if(GaiaConfig.COMMON.dimensionBlacklist.get().contains(String.valueOf(world.getDimension().getType().getId()))) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    default boolean isValidLightLevel(LivingEntity entity) {
        BlockPos blockpos = new BlockPos(entity.posX, entity.getBoundingBox().minY, entity.posZ);
        if (entity.getBrightness() > 0.5F && entity.world.canBlockSeeSky(blockpos) && !torchCheck(entity.world, blockpos)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The actual check. It inputs the radius and feeds it to the sphere shape method.
     * After it gets the block position map it scans every block in that map. Then returns depending if the match triggers.
     */
    default boolean torchCheck(World world, BlockPos pos) {
        for (BlockPos position : BlockPos.getAllInBox(pos.add(-8, -8, -8), pos.add(8, 8, 8)).collect(Collectors.toList())) {
            if (blackList.contains(world.getBlockState(position).getBlock())) {
                return true;
            }
        }
        return false;
    }

    default boolean spawnConditions(LivingEntity entity) {
        if (isValidLightLevel(entity)) {
            World world = entity.world;
            BlockPos pos = entity.getPosition();
            boolean flag = entity.world.getDifficulty() != Difficulty.PEACEFUL && world.isDaytime();
            boolean flag2 = this.isValidLightLevel(entity) && !torchCheck(world, pos);

            Block spawnBlock = world.getBlockState(pos.down()).getBlock();
            Set<String> additionalBlocks = new HashSet<String>(GaiaConfig.COMMON.additionalSpawnBlocks.get());
            boolean defaultFlag = spawnBlocks.contains(spawnBlock);
            boolean additionalFlag = !additionalBlocks.isEmpty() && additionalBlocks.contains(spawnBlock.getRegistryName().toString());

            return (defaultFlag || additionalFlag) && flag && flag2 && !world.containsAnyLiquid(entity.getBoundingBox());
        }

        return false;
    }

    /**
     *
     * @param entity
     * @param range
     * Detects if there's a player nearby
     */
    default boolean playerDetection(LivingEntity entity, int range) {
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(entity.posX, entity.posY, entity.posZ, entity.posX + 1, entity.posY + 1, entity.posZ + 1)).grow(range);
        List<PlayerEntity> list = entity.world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);

        if(!list.isEmpty()) {
            Iterator<PlayerEntity> i = list.iterator();
            while (i.hasNext()) {
                PlayerEntity player = i.next(); // must be called before you can call i.remove()
                if(player.isSpectator()) {
                    i.remove();
                }
            }
        }

        return !list.isEmpty();
    }


    default void ApplyDebuff(World world, Entity entityIn, HashMap<Effect, Integer> effects) {
        if (entityIn instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entityIn;
            int difficultyModifier = 0;

            if (world.getDifficulty() == Difficulty.NORMAL) {
                difficultyModifier = 5;
            } else if (world.getDifficulty() == Difficulty.HARD) {
                difficultyModifier = 10;
            }

            if (difficultyModifier > 0) {
                if(!effects.isEmpty()) {
                    for(HashMap.Entry<Effect, Integer> entry : effects.entrySet()) {
                        livingEntity.addPotionEffect(new EffectInstance(entry.getKey(), difficultyModifier * 20, entry.getValue()));
                    }
                }
            }
        }
    }

    default boolean canEntitySeeSky(IWorld worldIn, Entity entity) {
        if(GaiaConfig.COMMON.disableYRestriction.get())
            return true;

        return worldIn.canBlockSeeSky(entity.getPosition());
    }
}
