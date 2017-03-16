package kriptikz.archmage.proxy;

import kriptikz.archmage.init.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy implements IProxy
{
	Minecraft MINECRAFT = Minecraft.getMinecraft();
	
	@Override
	public void preInit()
	{
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
