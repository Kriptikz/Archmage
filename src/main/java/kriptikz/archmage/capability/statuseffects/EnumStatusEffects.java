package kriptikz.archmage.capability.statuseffects;

/**
 * Associates each status effect with an enum name and integer value used for referencing each status effect by an Id.
 * 
 * @author kriptikz
 *
 */
public enum EnumStatusEffects
{
	STUNNED(0), LEVITATING(1);
	
	private int id;
	
	EnumStatusEffects(int id)
	{
		this.id = id;
	}
	
	/**
	 * Get the integer id of this status effect.
	 * @return
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Get the {@link EnumStatusEffects} enum name of the status effect as a string in LOWERCASE.
	 * 
	 * @return a lowercase string of the enums name in {@link EnumStatusEffects}
	 */
	public String getName()
	{
		return this.toString().toLowerCase();
	}
}
