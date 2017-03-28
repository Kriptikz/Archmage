package kriptikz.archmage.handler;

import kriptikz.archmage.Reference;
import kriptikz.archmage.capability.archmagelevel.ArchmageLevelProvider;
import kriptikz.archmage.capability.mana.ManaProvider;
import kriptikz.archmage.capability.spelldata.SpellsProvider;
import kriptikz.archmage.capability.statuseffects.StatusEffectsProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Attach capabilities event handler.
 * 
 * @author kriptikz
 *
 */
public class AttachCapabilityHandler
{
	public static final ResourceLocation ARCHMAGE_LEVEL = new ResourceLocation(Reference.MODID, "archmage_level");
	public static final ResourceLocation MANA = new ResourceLocation(Reference.MODID, "mana");
	public static final ResourceLocation SPELLS = new ResourceLocation(Reference.MODID, "spells");
	public static final ResourceLocation STATUS_EFFECTS = new ResourceLocation(Reference.MODID, "status_effects");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		if (event.getObject() instanceof EntityPlayer)
		{
			event.addCapability(ARCHMAGE_LEVEL, new ArchmageLevelProvider());
			event.addCapability(MANA, new ManaProvider());
			event.addCapability(SPELLS, new SpellsProvider());
		}
		
		if (event.getObject() instanceof EntityLivingBase)
		{
			event.addCapability(STATUS_EFFECTS, new StatusEffectsProvider());
		}
	}
}
