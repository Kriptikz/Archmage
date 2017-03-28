package kriptikz.archmage;

import kriptikz.archmage.capability.archmagelevel.ArchmageLevel;
import kriptikz.archmage.capability.archmagelevel.ArchmageLevelStorage;
import kriptikz.archmage.capability.archmagelevel.IArchmageLevel;
import kriptikz.archmage.capability.mana.IMana;
import kriptikz.archmage.capability.mana.Mana;
import kriptikz.archmage.capability.mana.ManaStorage;
import kriptikz.archmage.capability.spelldata.ISpells;
import kriptikz.archmage.capability.spelldata.Spells;
import kriptikz.archmage.capability.spelldata.SpellsStorage;
import kriptikz.archmage.capability.statuseffects.IStatusEffects;
import kriptikz.archmage.capability.statuseffects.StatusEffects;
import kriptikz.archmage.capability.statuseffects.StatusEffectsStorage;
import kriptikz.archmage.handler.AttachCapabilityHandler;
import kriptikz.archmage.handler.ModEventHandler;
import kriptikz.archmage.init.ModEntities;
import kriptikz.archmage.proxy.IProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Archmage
{
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static IProxy proxy;
	
	@Instance(Reference.MODID)
	public static Archmage instance;
	
	public static final CreativeTabs ARCHMAGE_TAB = new CreativeTabArchmage();
	
	public static SimpleNetworkWrapper network;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Register capabilities
		CapabilityManager.INSTANCE.register(IArchmageLevel.class, new ArchmageLevelStorage(), ArchmageLevel.class);
		CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana.class);
		CapabilityManager.INSTANCE.register(ISpells.class, new SpellsStorage(), Spells.class);
		CapabilityManager.INSTANCE.register(IStatusEffects.class, new StatusEffectsStorage(), StatusEffects.class);
		
		// Register network wrapper
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
		
		// Register messages
		
		// Register entities
		ModEntities.register();
		
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{	
		// Register event handlers
		MinecraftForge.EVENT_BUS.register(new AttachCapabilityHandler());
		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		
		// Register GUI Handler
		
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
		proxy.postInit();
	}
}
