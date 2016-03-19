package gaia.init;

import java.util.ArrayList;
import java.util.List;

import gaia.GaiaReference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

//Tutorial Source ->  https://github.com/Minalien/BlogArchive/blob/master/ForgeTutorials/Spotlight__Config_GUIs.md
// + http://forum.feed-the-beast.com/threads/code-snippets-classes.51404/page-4#post-876553
// + http://jabelarminecraft.blogspot.com/p/minecraft-modding-configuration-guis.html

public class Config_Gui extends GuiConfig {
	
	//Simple version
  /**
  public Config_Gui(GuiScreen parent) {
    super(parent,
    
    	new ConfigElement(GaiaConfigGeneration.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
    	GaiaReference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(GaiaConfigGeneration.config.toString()));
  
  }  
  **/
  
	//Complex version
  public Config_Gui(GuiScreen parent) {
      super(parent, getConfigElements(), GaiaReference.MOD_ID, false, false, "Grimoire of Gaia Configuration");
  }

  /** Compiles a list of config elements */
  private static List<IConfigElement> getConfigElements() {
      List<IConfigElement> list = new ArrayList<IConfigElement>();
    
      //Add categories to config GUI
      list.add(categoryElement(GaiaConfigGeneration.config.CATEGORY_GENERAL, "General", "Spawn Rate. Set to 0 to disable mob from spawning. Recommended: 10> Day, <100 Night"));
      list.add(categoryElement(GaiaConfigGeneration.DAMAGE, "Base damage", "If BaseDamage is set to true, all mobs will deal 1.0 piercing damage (ignores armor)."));
      list.add(categoryElement(GaiaConfigGeneration.MODIFIER, "Modifier", "Percentage amount. Default value: 100"));
      
      //I believe we're supposed to setup something with the lang file to properly setup up the tooltip strings here like below
      /**
      list.add(categoryElement(GaiaConfigGeneration.config.CATEGORY_GENERAL, "General", "mymod.configgui.ctgy.general"));
    	**/
      return list;
  }

  /** Creates a button linking to another screen where all options of the category are available */
  private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
      return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
              new ConfigElement(GaiaConfigGeneration.config.getCategory(category)).getChildElements());
  }
}
