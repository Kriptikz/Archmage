package kriptikz.archmage.capability.spelldata;

/**
 * Associates each spell with an enum name and integer value used for referencing each spell.
 * 
 * @author kriptikz
 *
 */
public enum EnumSpells
{
	NONE(0), FIREBALL(1), STUN(2), SELF_HEAL(3), HEAL_PROJECTILE(4), DIZZIFY(5), SLOW(6),
	DUMMY_CLONE(7), LEVITATE(8), WARP(9), TELEPORT(10);
	
	private int id;
	
	EnumSpells(int id)
	{
		this.id = id;
	}
	
	/**
	 * Get the integer Id of the spell.
	 * 
	 * @return id
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Get the {@link EnumSpells} enum name of the spell as a string in LOWERCASE.
	 * 
	 * @return a lowercase string of the enums name in {@link SpellName}
	 */
	public String getName()
	{
		return this.toString().toLowerCase();
	}
}
