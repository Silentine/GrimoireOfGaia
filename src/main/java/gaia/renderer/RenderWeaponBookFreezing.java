/*package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.model.ModelWeaponBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderWeaponBookFreezing implements IItemRenderer {

	protected ModelWeaponBook bookModel = new ModelWeaponBook();

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(RenderWeaponBookFreezing.NamelessClass1923601102.$SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[type.ordinal()]) {
		case 1:
			return true;
		case 2:
			return true;
		default:
			return false;
		}
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object ... data) {
		switch(RenderWeaponBookNature.NamelessClass1923601102.$SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[type.ordinal()]) {
		case 1:
		case 2:
			GL11.glPushMatrix();
			float scale = 1.2F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(55.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.01F, 0.20F, 0.5F);
			boolean isFirstPerson = false;
			if(data[1] != null & data[1] instanceof EntityPlayer && (EntityPlayer)data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && (!(Minecraft.getMinecraft().currentScreen instanceof GuiInventory) && !(Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) || RenderManager.instance.playerViewY != 180.0F)) {
				isFirstPerson = true;
				float scale2 = 1.8F;
				GL11.glScalef(scale2, scale2, scale2);
				GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.25F, 0.1F, 0.0F);
			}

			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(GaiaReference.MOD_ID, "textures/models/weapons/WeaponBookFreezing.png"));
			this.bookModel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, isFirstPerson);
			GL11.glPopMatrix();
		default:
		}
	}

	// $FF: synthetic class
	static class NamelessClass1923601102 {

		// $FF: synthetic field
		static final int[] $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType = new int[ItemRenderType.values().length];

		static {
			try {
				$SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[ItemRenderType.EQUIPPED.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				$SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[ItemRenderType.EQUIPPED_FIRST_PERSON.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}
		}
	}
}
*/