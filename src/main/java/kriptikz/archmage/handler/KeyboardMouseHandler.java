package kriptikz.archmage.handler;

import kriptikz.archmage.client.gui.GuiMain;
import kriptikz.archmage.client.keybinds.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyboardMouseHandler
{
    Minecraft mc;
    
    public KeyboardMouseHandler(Minecraft mc)
    {
        this.mc = mc;
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event)
    {
        if (Keybinds.main.isPressed())
        {
            mc.displayGuiScreen(new GuiMain());
        }
    }
}
