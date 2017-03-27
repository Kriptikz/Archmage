package kriptikz.archmage.capability.statuseffects;

/**
 * Associates each status effect with an integer value used for referencing each status effect by an Id.
 * 
 * @author kriptikz
 *
 */
public enum EnumStatusEffectId
{
	STUNNED(0), LEVITATING(1);
	
	private int id;
	
	EnumStatusEffectId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
}
