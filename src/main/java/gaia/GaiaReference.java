package gaia;

public class GaiaReference {
	public static final String MOD_ID = "grimoireofgaia";
	public static final String MOD_NAME = "Grimoire of Gaia 3";
	public static final String VERSION = "1.0.0";
	public static final String CLIENT_PROXY_CLASS = "gaia.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "gaia.proxy.CommonProxy";	
	public static final String guiFactory = "gaia.init.Config_GuiFactory";
	
	//Designates loading order "before" "after" or "required-after" for hard dependency + other MODID	
	public static final String DEPENDENCIES = "after:Baubles; after:Thaumcraft";
}
