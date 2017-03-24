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
		ResourceLocation travel = new ResourceLocation(Reference.MODID, "particle/travel");
		ResourceLocation impact = new ResourceLocation(Reference.MODID, "particle/impact");
		ResourceLocation charge = new ResourceLocation(Reference.MODID, "particle/charge");
		
		event.getMap().registerSprite(travel);
		event.getMap().registerSprite(impact);
		event.getMap().registerSprite(charge);
	}
}
