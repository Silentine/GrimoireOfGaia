package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** Tutorial Source
 * <li>http://jabelarminecraft.blogspot.com/p/complex-entity-models-including.html
 */
@SideOnly(Side.CLIENT)
public class ModelGaia extends ModelBase {

    protected void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild) {
        parChild.rotationPointX -= parParent.rotationPointX;
        parChild.rotationPointY -= parParent.rotationPointY;
        parChild.rotationPointZ -= parParent.rotationPointZ;
        parChild.rotateAngleX -= parParent.rotateAngleX;
        parChild.rotateAngleY -= parParent.rotateAngleY;
        parChild.rotateAngleZ -= parParent.rotateAngleZ;
        parParent.addChild(parChild);
    }

    protected double distanceMovedTotal = 0.0D;
    protected static final double CYCLES_PER_BLOCK = 3.0D; //CYCLES_PER_BLOCK = SPEED; 
    protected int cycleIndex = 0;

    // ***************************************
    // Helper functions
    // ***************************************

    protected void updateDistanceMovedTotal(Entity parEntity) {
        distanceMovedTotal += parEntity.getDistance(parEntity.prevPosX, parEntity.prevPosY, parEntity.prevPosZ);
    }

    protected double getDistanceMovedTotal(Entity parEntity) {
        return (distanceMovedTotal);
    }

    protected float degToRad(float degrees) {
        return degrees * (float) Math.PI / 180;
    }
}
