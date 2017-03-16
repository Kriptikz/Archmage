package kriptikz.archmage.handler;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

/**
 * Mod's main event handler.
 * 
 * @author kriptikz
 *
 */
public class ModEventHandler
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		// sync all capability data.
	}
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{
		// ensure code is only run in TickEvent.Phase.START
		if (event.phase == TickEvent.Phase.START)
		{

		}
	}
}
