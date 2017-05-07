package kriptikz.archmage.client.keybinds;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds
{
    public static KeyBinding main;
    
    public static void register()
    {
        main = new KeyBinding("key.archmage:main", Keyboard.KEY_X, "key.categories.archmage");
        
        ClientRegistry.registerKeyBinding(main);
    }
}
