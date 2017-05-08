package kriptikz.archmage.init;

import kriptikz.archmage.Archmage;
import kriptikz.archmage.Reference;
import kriptikz.archmage.client.render.RenderFireball;
import kriptikz.archmage.entity.EntitySpellBase;
import kriptikz.archmage.spell.SpellFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities
{
	public static void register()
	{
		int id = 1;
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "spell_base"), EntitySpellBase.class, "archmageSpellBase", id++, Archmage.instance, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "spell_fireball"), SpellFireball.class, "archmageSpellFireball", id++, Archmage.instance, 64, 10, true);
	}
	
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(SpellFireball.class, RenderFireball.FACTORY);
	}
}
