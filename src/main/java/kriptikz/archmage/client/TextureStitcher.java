package kriptikz.archmage.client;

import kriptikz.archmage.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Register sprite textures to the texture map.
 * 
 * @author kriptikz
 *
 */
public class TextureStitcher
{
	@SubscribeEvent
	public void textureStitchEventPre(TextureStitchEvent.Pre event)
	{
		ResourceLocation particle_default = new ResourceLocation(Reference.MODID, "particle/default");
		ResourceLocation fire = new ResourceLocation(Reference.MODID, "particle/fire");
		
		event.getMap().registerSprite(particle_default);
		event.getMap().registerSprite(fire);
	}
}
