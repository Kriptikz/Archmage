package kriptikz.archmage.proxy;

import javax.annotation.Nullable;

import kriptikz.archmage.client.TextureStitcher;
import kriptikz.archmage.client.particle.ParticleIce;
import kriptikz.archmage.init.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy implements IProxy
{
	Minecraft MINECRAFT = Minecraft.getMinecraft();
	
	@Override
	public void preInit()
	{
		// register texture stitcher
		MinecraftForge.EVENT_BUS.register(new TextureStitcher());
		
		// register entity models
		ModEntities.registerModels();
	}

	@Override
	public void init()
	{
		// TODO register keybinds
		// TODO register client event handlers		
	}

	@Override
	public void postInit()
	{
	}
	
	@Override
	public void spawnParticle(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed,
			double zSpeed)
	{
		MINECRAFT.world.spawnParticle(particleType, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
	}
	
	@Override
	public void spawnParticle(String particleName, @Nullable int version, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed,
			double zSpeed)
	{
		Particle particle;
		
		switch(particleName)
		{
			case "ice" : particle = new ParticleIce(version, MINECRAFT.world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
				break;
			default: particle = null;
		}
		
		MINECRAFT.effectRenderer.addEffect(particle);
	}

	@Override
	public IThreadListener getThreadListener(MessageContext context)
	{
		if (context.side.isClient())
		{
			return MINECRAFT;
		}
		else
		{
			return context.getServerHandler().playerEntity.mcServer;
		}
	}

	@Override
	public EntityPlayer getEntityPlayer(MessageContext context)
	{
		if (context.side.isClient())
		{
			return MINECRAFT.player;
		}
		else
		{
			return context.getServerHandler().playerEntity;
		}
	}

	@Override
	public World getWorld(MessageContext context)
	{
		if (context.side.isClient())
		{
			return MINECRAFT.world;
		}
		else
		{
			return context.getServerHandler().playerEntity.world;
		}
	}
}
