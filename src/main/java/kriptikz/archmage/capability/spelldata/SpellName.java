package kriptikz.archmage.capability.spelldata;

/**
 * Associates each spell with a name and integer value used for referencing each spell.
 * 
 * @author kriptikz
 *
 */
public enum SpellName
{
	FIREBALL(0), STUN(1), SELF_HEAL(2), HEAL_PROJECTILE(3), DIZZIFY(4), SLOW(5),
	DUMMY_CLONE(6), LEVITATE(7), WARP(8), TELEPORT(9);
	
	private int id;
	
	SpellName(int id)
	{
		this.id = id;
	}
	
	/**
	 * Get the Integer Id of the spell.
	 * 
	 * @return id
	 */
	public int getId()
	{
		return this.id;
	}
}
