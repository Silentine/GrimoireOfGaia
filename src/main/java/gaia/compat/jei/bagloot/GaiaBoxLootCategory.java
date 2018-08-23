package gaia.compat.jei.bagloot;

import gaia.GaiaReference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.util.Translator;
import net.minecraft.util.ResourceLocation;

public class GaiaBoxLootCategory extends GaiaSatchelLootCategory {

	public static final String UID = "gaia.box.loot";
    private final String title;
    private final IDrawableStatic icon;
	
    public GaiaBoxLootCategory(IGuiHelper guiHelper) {
		super(guiHelper);
		title = Translator.translateToLocal("gui.gaia.box.loot");
		ResourceLocation iconLocation = new ResourceLocation(GaiaReference.MOD_ID, "textures/gui/gaia_icon.png");
		icon = guiHelper.createDrawable(iconLocation, 16, 0, 16, 16);
	}

	@Override
	public String getUid() {
		return UID;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}
}