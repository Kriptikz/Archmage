package kriptikz.archmage.proxy;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public interface IProxy
{
	void preInit();

	void init();

	void postInit();
	
	/**
	 * Spawn a particle, can be called from common code. Server implementation should be empty.
	 * 
	 * @param particleType
	 * @param xCoord
	 * @param yCoord
	 * @param zCoord
	 * @param xSpeed
	 * @param ySpeed
	 * @param zSpeed
	 */
	public void spawnParticle(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed);
	

	/**
	 * Spawn a custom particle by name and version.
	 * 
	 * @param particleName The name of the custom particle, must be lowercase
	 * @param version The version of the particle, if null will spawn version 1
	 * @param xCoord
	 * @param yCoord
	 * @param zCoord
	 * @param xSpeed
	 * @param ySpeed
	 * @param zSpeed
	 */
	public void spawnParticle(String particleName, @Nullable int version, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed,
			double zSpeed);

	/**
	 * Get the {@link IThreadListender} for the {@link MessageContext}'s {@link Side}.
	 * 
	 * @param context The message context
	 * @return The thread listener
	 */
	public IThreadListener getThreadListener(MessageContext context);

	/**
	 * Get the {@link EntityPlayer} from the {@link MessageContext}.
	 * 
	 * @param context The message context
	 * @return The player
	 */
	public EntityPlayer getEntityPlayer(MessageContext context);
	
	/**
	 * Get the {@link World} from the {@link MessageContext}.
	 * 
	 * @param context The message context
	 * @return The world
	 */
	public World getWorld(MessageContext context);
}
