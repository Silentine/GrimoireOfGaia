package gaia.proxy;

import java.util.Locale;

import gaia.GaiaReference;
import gaia.entity.monster.EntityDebugMob;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaMummy;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyress;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaSummonButler;
import gaia.entity.monster.EntityGaiaSummonSporeling;
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.renderer.RenderGaiaProjectileMagic;
import gaia.renderer.entity.RenderDebugMob;
import gaia.renderer.entity.RenderGaiaAnt;
import gaia.renderer.entity.RenderGaiaAnubis;
import gaia.renderer.entity.RenderGaiaArachne;
import gaia.renderer.entity.RenderGaiaBanshee;
import gaia.renderer.entity.RenderGaiaBaphomet;
import gaia.renderer.entity.RenderGaiaBoneKnight;
import gaia.renderer.entity.RenderGaiaCentaur;
import gaia.renderer.entity.RenderGaiaCobbleGolem;
import gaia.renderer.entity.RenderGaiaCobblestoneGolem;
import gaia.renderer.entity.RenderGaiaCreep;
import gaia.renderer.entity.RenderGaiaCyclops;
import gaia.renderer.entity.RenderGaiaDhampir;
import gaia.renderer.entity.RenderGaiaDryad;
import gaia.renderer.entity.RenderGaiaDullahan;
import gaia.renderer.entity.RenderGaiaDwarf;
import gaia.renderer.entity.RenderGaiaEnderDragonGirl;
import gaia.renderer.entity.RenderGaiaEnderEye;
import gaia.renderer.entity.RenderGaiaFleshLich;
import gaia.renderer.entity.RenderGaiaFutakuchiOnna;
import gaia.renderer.entity.RenderGaiaGryphon;
import gaia.renderer.entity.RenderGaiaHarpy;
import gaia.renderer.entity.RenderGaiaHunter;
import gaia.renderer.entity.RenderGaiaKobold;
import gaia.renderer.entity.RenderGaiaMandragora;
import gaia.renderer.entity.RenderGaiaMatango;
import gaia.renderer.entity.RenderGaiaMermaid;
import gaia.renderer.entity.RenderGaiaMimic;
import gaia.renderer.entity.RenderGaiaMinotaur;
import gaia.renderer.entity.RenderGaiaMinotaurus;
import gaia.renderer.entity.RenderGaiaMummy;
import gaia.renderer.entity.RenderGaiaNPCCreeperGirl;
import gaia.renderer.entity.RenderGaiaNPCEnderGirl;
import gaia.renderer.entity.RenderGaiaNPCHolstaurus;
import gaia.renderer.entity.RenderGaiaNPCSlimeGirl;
import gaia.renderer.entity.RenderGaiaNPCTrader;
import gaia.renderer.entity.RenderGaiaNPCWeresheep;
import gaia.renderer.entity.RenderGaiaNaga;
import gaia.renderer.entity.RenderGaiaNineTails;
import gaia.renderer.entity.RenderGaiaPropChestMimic;
import gaia.renderer.entity.RenderGaiaPropFlowerCyan;
import gaia.renderer.entity.RenderGaiaSahuagin;
import gaia.renderer.entity.RenderGaiaSatyress;
import gaia.renderer.entity.RenderGaiaSelkie;
import gaia.renderer.entity.RenderGaiaShaman;
import gaia.renderer.entity.RenderGaiaSharko;
import gaia.renderer.entity.RenderGaiaSiren;
import gaia.renderer.entity.RenderGaiaSludgeGirl;
import gaia.renderer.entity.RenderGaiaSphinx;
import gaia.renderer.entity.RenderGaiaSpriggan;
import gaia.renderer.entity.RenderGaiaSuccubus;
import gaia.renderer.entity.RenderGaiaSummonButler;
import gaia.renderer.entity.RenderGaiaSummonSporeling;
import gaia.renderer.entity.RenderGaiaToad;
import gaia.renderer.entity.RenderGaiaValkyrie;
import gaia.renderer.entity.RenderGaiaVampire;
import gaia.renderer.entity.RenderGaiaWerecat;
import gaia.renderer.entity.RenderGaiaWitch;
import gaia.renderer.entity.RenderGaiaWitherCow;
import gaia.renderer.entity.RenderGaiaYeti;
import gaia.renderer.entity.RenderGaiaYukiOnna;
import gaia.renderer.particle.ParticleHandler;
import gaia.renderer.tileentity.TileRenderBustSphinx;
import gaia.renderer.tileentity.TileRenderBustValkyrie;
import gaia.renderer.tileentity.TileRenderBustVampire;
import gaia.renderer.tileentity.TileRenderDollCreeperGirl;
import gaia.renderer.tileentity.TileRenderDollEnderGirl;
import gaia.renderer.tileentity.TileRenderDollMaid;
import gaia.renderer.tileentity.TileRenderDollSlimeGirl;
import gaia.tileentity.TileEntityBustSphinx;
import gaia.tileentity.TileEntityBustValkyrie;
import gaia.tileentity.TileEntityBustVampire;
import gaia.tileentity.TileEntityDollCreeperGirl;
import gaia.tileentity.TileEntityDollEnderGirl;
import gaia.tileentity.TileEntityDollMaid;
import gaia.tileentity.TileEntityDollSlimeGirl;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void registerHandlers() {
        MinecraftForge.EVENT_BUS.register(new ParticleHandler());
    }

    @SideOnly(Side.CLIENT)
    public void registerRenders() {
        // Debug
        RenderingRegistry.registerEntityRenderingHandler(EntityDebugMob.class, RenderDebugMob.FACTORY);
        // Mob
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaAnt.class, RenderGaiaAnt.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaAnubis.class, RenderGaiaAnubis.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaArachne.class, RenderGaiaArachne.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBanshee.class, RenderGaiaBanshee.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBaphomet.class, RenderGaiaBaphomet.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaBoneKnight.class, RenderGaiaBoneKnight.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCreep.class, RenderGaiaCreep.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCentaur.class, RenderGaiaCentaur.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobbleGolem.class, RenderGaiaCobbleGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCobblestoneGolem.class, RenderGaiaCobblestoneGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaCyclops.class, RenderGaiaCyclops.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDhampir.class, RenderGaiaDhampir.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDryad.class, RenderGaiaDryad.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDullahan.class, RenderGaiaDullahan.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaDwarf.class, RenderGaiaDwarf.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaEnderDragonGirl.class, RenderGaiaEnderDragonGirl.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaEnderEye.class, RenderGaiaEnderEye.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaFleshLich.class, RenderGaiaFleshLich.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaFutakuchiOnna.class, RenderGaiaFutakuchiOnna.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaGryphon.class, RenderGaiaGryphon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHarpy.class, RenderGaiaHarpy.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaHunter.class, RenderGaiaHunter.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaKobold.class, RenderGaiaKobold.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMandragora.class, RenderGaiaMandragora.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMatango.class, RenderGaiaMatango.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMermaid.class, RenderGaiaMermaid.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMimic.class, RenderGaiaMimic.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMinotaur.class, RenderGaiaMinotaur.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMinotaurus.class, RenderGaiaMinotaurus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaMummy.class, RenderGaiaMummy.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNaga.class, RenderGaiaNaga.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNineTails.class, RenderGaiaNineTails.FACTORY);
        // NPC
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCCreeperGirl.class, RenderGaiaNPCCreeperGirl.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCSlimeGirl.class, RenderGaiaNPCSlimeGirl.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCEnderGirl.class, RenderGaiaNPCEnderGirl.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCTrader.class, RenderGaiaNPCTrader.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCHolstaurus.class, RenderGaiaNPCHolstaurus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaNPCWeresheep.class, RenderGaiaNPCWeresheep.FACTORY);
        // Prop
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaPropChestMimic.class, RenderGaiaPropChestMimic.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaPropFlowerCyan.class, RenderGaiaPropFlowerCyan.FACTORY);
        // Mob
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSahuagin.class, RenderGaiaSahuagin.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSatyress.class, RenderGaiaSatyress.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSelkie.class, RenderGaiaSelkie.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaShaman.class, RenderGaiaShaman.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSharko.class, RenderGaiaSharko.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSiren.class, RenderGaiaSiren.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSludgeGirl.class, RenderGaiaSludgeGirl.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSphinx.class, RenderGaiaSphinx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSpriggan.class, RenderGaiaSpriggan.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSuccubus.class, RenderGaiaSuccubus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSummonButler.class, RenderGaiaSummonButler.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaSummonSporeling.class, RenderGaiaSummonSporeling.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaToad.class, RenderGaiaToad.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaValkyrie.class, RenderGaiaValkyrie.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaVampire.class, RenderGaiaVampire.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWerecat.class, RenderGaiaWerecat.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitch.class, RenderGaiaWitch.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaWitherCow.class, RenderGaiaWitherCow.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYeti.class, RenderGaiaYeti.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaYukiOnna.class, RenderGaiaYukiOnna.FACTORY);
        // Projectile
        RenderingRegistry.registerEntityRenderingHandler(EntityGaiaProjectileMagic.class, new RenderGaiaProjectileMagic(GaiaItems.PropWeaponProjectile));
        // Block
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustSphinx.class, new TileRenderBustSphinx());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustValkyrie.class, new TileRenderBustValkyrie());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBustVampire.class, new TileRenderBustVampire());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollCreeperGirl.class, new TileRenderDollCreeperGirl());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollEnderGirl.class, new TileRenderDollEnderGirl());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollSlimeGirl.class, new TileRenderDollSlimeGirl());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDollMaid.class, new TileRenderDollMaid());
    }

    @Override
    public void registerBlocksRender() {
        GaiaBlocks.registerRenders();
    }

    @Override
    public void registerItemsRender() {
        item_reg.registerRenders();
        item_reg.registerRenders_meta();
    }

    /**
     * Register default Item Models
     */
    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GaiaReference.MOD_PREFIX + item.getUnlocalizedName()
                .substring(5)
                .toLowerCase(Locale.US), "inventory"));
    }

    /**
     * Register Item Model for meta data reliant objects <p>Shortcut method
     *
     * @param pathname item filename that is nested in
     *        grimoireofgaia:textures/items/<pathname>
     */
    public static void reg_Meta(Item item, int metadata, String pathname) {
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(
                GaiaReference.MOD_PREFIX + pathname.toLowerCase(), "inventory"));
    }

    /**
     * Registry for item models
     */
    public static class item_reg extends GaiaItems {

        public static void registerRenders() {
            registerRender(Shard);
            registerRender(FoodMeat);
            registerRender(FoodRottenHeart);
            registerRender(FoodRoot);
            registerRender(FoodCoalfish);
            registerRender(FoodNetherWart);
            registerRender(FoodSmallAppleGold);
            registerRender(FoodMandrake);
            registerRender(FoodWither);
            registerRender(FoodPieMandrake);
            registerRender(FoodPieMeat);
            registerRender(FoodPieAppleGold);
            registerRender(MiscSoulFire);
            registerRender(MiscSoulFiery);
            registerRender(MiscGigaGear);
            registerRender(MiscFur);
            registerRender(MiscExperience);
            registerRender(MiscBook);
            registerRender(MiscQuill);
            registerRender(MiscRing);
            registerRender(MiscFurnaceFuel);
            registerRender(MiscCurrency);
            registerRender(Spawn);
            registerRender(SpawnCreeperGirl);
            registerRender(SpawnSlimeGirl);
            registerRender(SpawnEnderGirl);
            registerRender(SpawnTrader);
            registerRender(SpawnHolstaurus);
            registerRender(SpawnWeresheep);
            registerRender(SpawnTame);
            registerRender(BoxIron);
            registerRender(BoxGold);
            registerRender(BoxDiamond);
            registerRender(BagOre);
            registerRender(BagBook);
            registerRender(BagRecord);
            registerRender(BagArrow);
            registerRender(BoxOld);
            registerRender(Chest);
            registerRender(PropWeapon);
            registerRender(PropWeaponProjectile);
            registerRender(PropWeaponEnchanted);
            registerRender(PropShield);
            registerRender(FanIce);
            registerRender(FanFire);
            registerRender(BookBase);
            registerRender(BookFreezing);
            registerRender(BookNightmare);
            registerRender(BookMetal);
            registerRender(BookEnder);
            registerRender(BookHunger);
            registerRender(BookBattle);
            registerRender(BookNature);
            registerRender(BookWither);
            registerRender(BookBuff);
            registerRender(Debug);
            registerRender(AccessoryRingSpeed);
            registerRender(AccessoryRingHaste);
            registerRender(AccessoryRingJump);
            registerRender(AccessoryRingNight);
            registerRender(AccessoryTrinketPoison);
            registerRender(AccessoryTrinketWither);
            registerRender(AccessoryTrinketLevitation);
            registerRender(AccessoryCursed);
            registerRender(Card);
        }

        public static void registerRenders_meta() {
            // Shards
            reg_Meta(Shard, 0, "shardiron");
            reg_Meta(Shard, 1, "shardgold");
            reg_Meta(Shard, 2, "sharddiamond");
            reg_Meta(Shard, 3, "shardemerald");
            reg_Meta(Shard, 4, "shardcopper");
            reg_Meta(Shard, 5, "shardsilver");

            // MiscExperience
            reg_Meta(MiscExperience, 0, "miscexperienceiron");
            reg_Meta(MiscExperience, 1, "miscexperiencegold");
            reg_Meta(MiscExperience, 2, "miscexperiencediamond");

            // MiscRing
            reg_Meta(MiscRing, 0, "miscringspeed");
            reg_Meta(MiscRing, 1, "miscringhaste");
            reg_Meta(MiscRing, 2, "miscringjump");
            reg_Meta(MiscRing, 3, "miscringnight");

            // MiscCurrency
            reg_Meta(MiscCurrency, 0, "misccurrency_0");
            reg_Meta(MiscCurrency, 1, "misccurrency_1");
            reg_Meta(MiscCurrency, 2, "misccurrency_2");
            reg_Meta(MiscCurrency, 3, "misccurrency_3");

            // Box
            reg_Meta(Box, 0, "box");
            reg_Meta(Box, 1, "boxnether");
            reg_Meta(Box, 2, "boxend");

            // Chest
            reg_Meta(Chest, 0, "chest");
            reg_Meta(Chest, 1, "chestjungle");
            reg_Meta(Chest, 2, "chestdesert");

            // PropWeapon
            reg_Meta(PropWeapon, 0, "weaponpropender");
            reg_Meta(PropWeapon, 1, "weaponpropblaze");
            reg_Meta(PropWeapon, 2, "weaponpropspear");
            reg_Meta(PropWeapon, 3, "weaponpropdagger");
            reg_Meta(PropWeapon, 4, "weaponpropfan");
            reg_Meta(PropWeapon, 5, "weaponpropaxe");

            // PropWeaponProjectile
            reg_Meta(PropWeaponProjectile, 0, "weaponpropprojectile");

            // PropWeaponShield
            reg_Meta(PropShield, 0, "shieldpropiron");
            reg_Meta(PropShield, 1, "shieldpropgold");

            // AccessoryBauble
            // reg_Meta(AccessoryBauble, 0, "BaubleAccessory");

            // Card
            reg_Meta(Card, 0, "CardNull");
            reg_Meta(Card, 1, "CardChild");
            reg_Meta(Card, 2, "CardAttack");
        }
    }
}
