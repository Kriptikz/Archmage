package kriptikz.archmage.proxy;

import kriptikz.archmage.client.particle.EnumParticles;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy implements IProxy
{
	@Override
	public void preInit()
	{		
	}

	@Override
	public void init()
	{	
	}

	@Override
	public void postInit()
	{	
	}
	
	@Override
	public void spawnParticle(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed,
			double zSpeed)
	{		
	}
	
	@Override
	public void spawnParticle(EnumParticles particle, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed,
			double zSpeed)
	{
	}

	@Override
	public IThreadListener getThreadListener(MessageContext context)
	{
		return context.getServerHandler().playerEntity.mcServer;
	}

	@Override
	public EntityPlayer getEntityPlayer(MessageContext context)
	{
		return context.getServerHandler().playerEntity;
	}
	
	@Override
	public World getWorld(MessageContext context)
	{
		return context.getServerHandler().playerEntity.world;
	}
}
