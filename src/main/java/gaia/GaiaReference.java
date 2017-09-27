package gaia;

public class GaiaReference {

    public static final String MOD_ID = "grimoireofgaia";
    public static final String MOD_NAME = "Grimoire of Gaia 3";
    public static final String MOD_PREFIX = MOD_ID + ":";
    public static final String VERSION = "@VERSION@";

    public static final String CLIENT_PROXY_CLASS = "gaia.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "gaia.proxy.CommonProxy";

    public static final String GUI_FACTORY = "gaia.init.Config_GuiFactory";
    public static final String DEPENDENCIES = "required-after:forge@[14.22.1.2480,];required-after:baubles@[1.4.2,]";
}
