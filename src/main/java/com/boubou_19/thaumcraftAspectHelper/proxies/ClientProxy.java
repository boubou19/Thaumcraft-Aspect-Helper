package com.boubou_19.thaumcraftAspectHelper.proxies;

import com.boubou_19.thaumcraftAspectHelper.GUIConfig;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import static com.boubou_19.thaumcraftAspectHelper.ThaumcraftAspectHelper.MODID;

public class ClientProxy extends CommonProxy {
    public static KeyBinding keyBindHelperGui;
    public ClientProxy(){
        {
            FMLCommonHandler.instance().bus().register(this);
            keyBindHelperGui = new KeyBinding(MODID+".key.guikey", Keyboard.KEY_P, MODID+".category");
            ClientRegistry.registerKeyBinding(keyBindHelperGui);
        }
    }
    @SubscribeEvent
    public void onEvent(InputEvent.KeyInputEvent event)
    {
        if(keyBindHelperGui.isPressed())
        {
            guiKeyPressed();
        }
    }
    public void guiKeyPressed(){
        Minecraft.getMinecraft().displayGuiScreen(new GUIConfig());
    }
}
