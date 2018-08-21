package gaia;

public class GaiaReference {

    public static final String MOD_ID = "grimoireofgaia";
    public static final String MOD_NAME = "Grimoire of Gaia 3";
    public static final String MOD_PREFIX = MOD_ID + ":";
    public static final String VERSION = "@VERSION@";

    public static final String CLIENT_PROXY_CLASS = "gaia.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "gaia.proxy.CommonProxy";

    public static final String GUI_FACTORY = "gaia.init.Config_GuiFactory";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.4.2705,];after:baubles@[1.5.2,]";
    
    public static final float TINY_SHADOW = 0.25F;
    public static final float SMALL_SHADOW = 0.4F;
    public static final float MEDIUM_SHADOW = 0.5F;
    public static final float LARGE_SHADOW = 0.7F;
}
