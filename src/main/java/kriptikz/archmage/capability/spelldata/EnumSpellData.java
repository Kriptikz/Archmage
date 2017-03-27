package kriptikz.archmage.capability.spelldata;

/**
 * Integer values used as array index's for easier reference into spell array.
 * 
 * @author kriptikz
 *
 */
public enum EnumSpellData
{
	IS_LEARNED(0), LEVEL(1), XP(2), LEVEL_MAX_XP(3), SHOULD_GAIN_XP(4);

	private int indexValue;
	
	EnumSpellData(int indexValue)
	{
		this.indexValue = indexValue;
	}
	
	public int getIndexValue()
	{
		return this.indexValue;
	}
}
