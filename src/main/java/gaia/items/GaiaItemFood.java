package gaia.items;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class GaiaItemFood extends ItemFood {

    /**
     * Base class for food Items that rely on multiple potion effects <p>I
     * didn't check but I'm pretty sure the previous codebase didn't work
     */
    public GaiaItemFood(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if (!worldIn.isRemote && this.second_Potion != null && worldIn.rand.nextFloat() < this.second_Chance) {
            player.addPotionEffect(new PotionEffect(this.second_Potion));
        }
    }

    /**
     * Spawns EntityXPOrb
     */
    public static void rewardEXP(EntityPlayer player, int value) {
        World world = player.world;
        EntityXPOrb entity = new EntityXPOrb(world, player.posX, player.posY + 1, player.posZ, value);

        if (!world.isRemote) {
            world.spawnEntity(entity);
        }
    }

    private PotionEffect second_Potion;
    private float second_Chance;

    public ItemFood setSecondPotionEffect(PotionEffect effect, float chance) {
        this.second_Potion = effect;
        this.second_Chance = chance;
        return this;
    }
}
