package kriptikz.archmage.spell;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.RayTraceResult;

/**
 * Base for all spells.
 * 
 * @author kriptikz
 *
 */
public interface ISpellBase
{
	/**
	 * Check if the spell is a projectile.
	 * If it is a projectile it will need to be spawned.
	 * 
	 * @return Whether the spell is a projectile
	 */
	public boolean isProjectile();
	
	/**
	 * Do/apply the spell.
	 */
	public void doSpell(EntityLivingBase caster, @Nullable RayTraceResult result);
}
