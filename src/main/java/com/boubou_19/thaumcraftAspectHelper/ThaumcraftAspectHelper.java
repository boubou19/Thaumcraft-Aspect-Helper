package com.boubou_19.thaumcraftAspectHelper;

import com.boubou_19.thaumcraftAspectHelper.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLServerStartedEvent;




@Mod(modid = ThaumcraftAspectHelper.MODID, version = ThaumcraftAspectHelper.VERSION,name = ThaumcraftAspectHelper.NAME, acceptableRemoteVersions = "*")
public class ThaumcraftAspectHelper
{
    public static final String MODID = "thaumcraftaspecthelper";
    public static final String VERSION = "1.0";
    public static final String NAME = "Thaumcraft Aspect Helper";

    @Mod.Instance
    public static ThaumcraftAspectHelper instance;

    @SidedProxy(clientSide = "com.boubou_19.thaumcraftAspectHelper.proxies.ClientProxy", serverSide = "com.boubou_19.thaumcraftAspectHelper.proxies.CommonProxy")
    public static CommonProxy proxy;
    @Mod.EventHandler
    public void onServerStarted(FMLServerStartedEvent event) {
       Helper.runItem("items.csv");
    }
}
