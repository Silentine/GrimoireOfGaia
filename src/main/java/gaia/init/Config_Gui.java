package gaia.init;

import gaia.GaiaReference;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

/** Tutorial Source
 * <li>https://github.com/Minalien/BlogArchive/blob/master/ForgeTutorials/Spotlight__Config_GUIs.md
 * <li>http://forum.feed-the-beast.com/threads/code-snippets-classes.51404/page-4#post-876553
 * <li>http://jabelarminecraft.blogspot.com/p/minecraft-modding-configuration-guis.html
 **/
public class Config_Gui extends GuiConfig {

	//Simple version
	/*
	public Config_Gui(GuiScreen parent) {
		super(parent,
				new ConfigElement(GaiaConfigGeneration.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				GaiaReference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(GaiaConfigGeneration.config.toString()));
	}  
	 */

	//Complex version
	public Config_Gui(GuiScreen parent) {
		super(parent, getConfigElements(), GaiaReference.MOD_ID, false, false, "Grimoire of Gaia Configuration");
	}

	/** 
	 * Compiles a list of config elements 
	 */
	private static List<IConfigElement> getConfigElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		//Add categories to config GUI
		list.add(categoryElement(GaiaConfigGeneration.config.CATEGORY_GENERAL, "configgui.GrimoireOfGaia.category.general.tooltip", "configgui.GrimoireOfGaia.category.general"));
		list.add(categoryElement(GaiaConfigGeneration.DAMAGE, "configgui.GrimoireOfGaia.category.damage.tooltip", "configgui.GrimoireOfGaia.category.damage"));
		list.add(categoryElement(GaiaConfigGeneration.DEFENSE, "configgui.GrimoireOfGaia.category.defense.tooltip", "configgui.GrimoireOfGaia.category.defense"));
		list.add(categoryElement(GaiaConfigGeneration.ATTRIBUTES, "configgui.GrimoireOfGaia.category.attributes.tooltip", "configgui.GrimoireOfGaia.category.attributes"));
		list.add(categoryElement(GaiaConfigGeneration.OPTIONS, "configgui.GrimoireOfGaia.category.options.tooltip", "configgui.GrimoireOfGaia.category.options"));
		list.add(categoryElement(GaiaConfigGeneration.DEBUG, "configgui.GrimoireOfGaia.category.debug.tooltip", "configgui.GrimoireOfGaia.category.debug"));
		return list;
	}

	/** 
	 * Creates a button linking to another screen where all options of the category are available 
	 */
	private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
		return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
				new ConfigElement(GaiaConfigGeneration.config.getCategory(category)).getChildElements());
	}
}