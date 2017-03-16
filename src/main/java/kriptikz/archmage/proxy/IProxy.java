package kriptikz.archmage.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public interface IProxy
{
	void preInit();

	void init();

	void postInit();

	/**
	 * Get the {@link IThreadListender} for the {@link MessageContext}'s {@link Side}.
	 * 
	 * @param context The message context
	 * @return The thread listener
	 */
	IThreadListener getThreadListener(MessageContext context);

	/**
	 * Get the {@link EntityPlayer} from the {@link MessageContext}.
	 * 
	 * @param context The message context
	 * @return The player
	 */
	EntityPlayer getEntityPlayer(MessageContext context);
	
	/**
	 * Get the {@link World} from the {@link MessageContext}.
	 * 
	 * @param context The message context
	 * @return The world
	 */
	World getWorld(MessageContext context);
}
