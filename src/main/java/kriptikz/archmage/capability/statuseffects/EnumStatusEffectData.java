package kriptikz.archmage.capability.statuseffects;

/**
 * Integer values used as array index's for easier reference into status effect array.
 * 
 * @author kriptikz
 *
 */
public enum EnumStatusEffectData
{
	IS_ACTIVE(0), TICKS(1), DURATION(2), AMP(3);
	
	private int indexValue;
	
	EnumStatusEffectData(int indexValue)
	{
		this.indexValue = indexValue;
	}
	
	public int getIndexValue()
	{
		return this.indexValue;
	}
}
