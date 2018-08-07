package gaia.init;

import gaia.GaiaReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused") //used in config Gui reflection
public class GuiConfigGaia extends GuiConfig {

    @SuppressWarnings("WeakerAccess") //reflection needs this public
    public GuiConfigGaia(GuiScreen parent) {
        super(parent, getConfigElements(), GaiaReference.MOD_ID, false, false, "Grimoire of Gaia Configuration");
    }

    /**
     * Compiles a list of config elements
     */
    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();

        // Add categories to config GUI
        list.add(categoryElement(Configuration.CATEGORY_GENERAL, "configgui.grimoireofgaia.category.general.tooltip",
                "configgui.grimoireofgaia.category.general"));
        list.add(categoryElement(GaiaConfigGeneration.DAMAGE, "configgui.grimoireofgaia.category.damage.tooltip",
                "configgui.grimoireofgaia.category.damage"));
        list.add(categoryElement(GaiaConfigGeneration.DEFENSE, "configgui.grimoireofgaia.category.defense.tooltip",
                "configgui.grimoireofgaia.category.defense"));
        list.add(categoryElement(GaiaConfigGeneration.ATTRIBUTES, "configgui.grimoireofgaia.category.attributes.tooltip",
                "configgui.grimoireofgaia.category.attributes"));
        list.add(categoryElement(GaiaConfigGeneration.OPTIONS, "configgui.grimoireofgaia.category.options.tooltip",
                "configgui.grimoireofgaia.category.options"));
        list.add(categoryElement(GaiaConfigGeneration.DEBUG, "configgui.grimoireofgaia.category.debug.tooltip",
                "configgui.grimoireofgaia.category.debug"));
        return list;
    }

    /**
     * Creates a button linking to another screen where all options of the
     * category are available
     */
    private static IConfigElement categoryElement(String category, String name, String tooltipKey) {
        return new DummyConfigElement.DummyCategoryElement(name, tooltipKey,
                new ConfigElement(GaiaConfigGeneration.config.getCategory(category)).getChildElements());
    }

    public static class Factory implements IModGuiFactory {

		@Override
		public void initialize(Minecraft minecraftInstance) {
            //noop
		}

		@Override
		public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
            return Collections.emptySet();
		}

		@Override
		public boolean hasConfigGui() {
			return true;
		}

		@Override
		public GuiScreen createConfigGui(GuiScreen parentScreen) {
			return new GuiConfigGaia(parentScreen);
		}
	}
}
