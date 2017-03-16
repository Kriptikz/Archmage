package kriptikz.archmage.spell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

/**
 * TeleportDestination is used to create a teleport destination, based on a block position and dimension id, for the spell Teleport.
 * 
 * @author kriptikz
 * 
 */
public class TeleportDestination
{
	/**
	 * The position in the dimension to teleport to.
	 */
	private BlockPos teleportPos;
	
	/**
	 * The id of the dimension to teleport to.
	 */
	private int teleportDimId;
	
	/**
	 * TeleportDestination constructor.
	 * 
	 * @param newDimId The new id of the dimension to teleport to
	 * @param newTeleportPos The new position to teleport to in the specified dimension
	 */
	public TeleportDestination(int newDimId, BlockPos newTeleportPos)
	{
		this.teleportDimId = newDimId;
		this.teleportPos = newTeleportPos;
	}
	
	/**
	 * Set the position to teleport.
	 * 
	 * @param newTeleportPos The new position to teleport to
	 */
	public void setTeleportPos(BlockPos newTeleportPos)
	{
		this.teleportPos = newTeleportPos;
	}
	
	/**
	 * Get the position to teleport to.
	 * 
	 * @return The position to teleport to
	 */
	public BlockPos getTeleportPos()
	{
		return this.teleportPos;
	}
	
	/**
	 * Set the id of the dimension to teleport to.
	 * 
	 * @param newDimId The new id of the dimension to teleport to
	 */
	public void setTeleportDimId(int newDimId)
	{
		this.teleportDimId = newDimId;
	}
	
	/**
	 * Get the id of the dimension to teleport to.
	 * 
	 * @return The id of the dimension to teleport to
	 */
	public int getTeleportDimId()
	{
		return this.teleportDimId;
	}
	
	/**
	 * Teleport the player specified position in specified dimension.
	 * 
	 * @param player The player to teleport
	 * @param dimension The dimension to teleport the player to
	 * @param x The x-pos in the specified dimension to teleport the player to
	 * @param y The y-pos in the specified dimension to teleport the player to
	 * @param z The z-pos in the specified dimension to teleport the player to
	 */
    public static void teleportPlayer(EntityPlayer player, int dimension, double x, double y, double z) 
    {
        // The player to teleport.
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        
        // The MinecraftServer of the player.
        MinecraftServer server = player.getEntityWorld().getMinecraftServer();
        
        // The WorldServer for the dimension to teleport the player to.
        WorldServer worldServer = server.worldServerForDimension(dimension);
        
        //player.addExperienceLevel(0);


        // Teleport the player.
        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new Teleporter(worldServer));
        player.setPositionAndUpdate(x, y, z);
    }
}
