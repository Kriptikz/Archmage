package kriptikz.archmage.capability.spelldata;

/**
 * Associates each spell with an integer value used for referencing each spell by an Id.
 * 
 * @author kriptikz
 *
 */
public enum EnumSpellId
{
	FIREBALL(0), STUN(1), SELF_HEAL(2), HEAL_PROJECTILE(3), DIZZIFY(4), SLOW(5),
	DUMMY_CLONE(6), LEVITATE(7), WARP(8), TELEPORT(9);
	
	private int id;
	
	EnumSpellId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
}
