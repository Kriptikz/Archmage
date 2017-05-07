package kriptikz.archmage.proxy;

import kriptikz.archmage.client.TextureStitcher;
import kriptikz.archmage.client.keybinds.Keybinds;
import kriptikz.archmage.client.particle.EnumParticles;
import kriptikz.archmage.client.particle.ParticleDefault;
import kriptikz.archmage.client.particle.ParticleFire;
import kriptikz.archmage.handler.KeyboardMouseHandler;
import kriptikz.archmage.init.ModEntities;
import net.minecraft.client.Minecraft;
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
		
		// register entity renders
		ModEntities.registerRenders();
	}

	@Override
	public void init()
	{
		// register keybinds
	    Keybinds.register();
	    
		// TODO register client event handlers		
	    MinecraftForge.EVENT_BUS.register(new KeyboardMouseHandler(MINECRAFT));
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
	public void spawnParticle(EnumParticles particle, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed,
			double zSpeed)
	{
		
		switch(particle)
		{	
			case FIRE:
				MINECRAFT.effectRenderer.addEffect(new ParticleFire(MINECRAFT.world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed));
				break;
			default:
				MINECRAFT.effectRenderer.addEffect(new ParticleDefault(MINECRAFT.world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed));
		}
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
