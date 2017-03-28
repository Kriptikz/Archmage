package kriptikz.archmage.capability.spelldata;

/**
 * Spell data associated with each individual spell.
 * 
 * @author kriptikz
 *
 */
public class SpellData
{
	private final EnumSpells spell;
	private boolean isLearned = false;
	private int level = 1;
	private int xp = 0;
	private int levelMaxXp = 100;
	private boolean shouldGainXp = true;
	
	/**
	 * Constructor for {@link Spell}.
	 * 
	 * @param name an enum from {@link SpellName}
	 */
	public SpellData(EnumSpells spell)
	{
		this.spell = spell;
	}
	
	/**
	 * Get the enum {@link EnumSpells} of the spell.
	 * 
	 * @return {@link SpellName}
	 */
	public EnumSpells getSpell()
	{
		return this.spell;
	}
	
	/**
	 * Set whether the spell is learned.
	 * 
	 * @param isLearned
	 */
	public void setIsLearned(boolean isLearned)
	{
		this.isLearned = isLearned;
	}

	/**
	 * Get whether the spell is learned.
	 * 
	 * @return
	 */
	public boolean getIsLearned()
	{
		return isLearned;
	}
	
	/**
	 * Set the spells level. Level cap implemented here.
	 * 
	 * @param level
	 */
	public void setLevel(int level)
	{
		if (level >= 10 )
		{
			this.level = 10;
			this.shouldGainXp = false;
		}
		else if (level < 10 && level >= 1)
		{
			this.level = level;
			this.shouldGainXp = true;
		}
		else
		{
			this.level = 1;
			this.shouldGainXp = true;
		}
	}

	/**
	 * Get the spells level.
	 * 
	 * @return
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * Set the current xp of the spell.
	 * 
	 * @param xp
	 */
	public void setXp(int xp)
	{
		this.xp = xp;
	}

	/**
	 * Get the current xp of the spell.
	 * 
	 * @return
	 */
	public int getXp()
	{
		return xp;
	}
	
	/**
	 * Set the current levels max xp.
	 * 
	 * @param levelMaxXp
	 */
	public void setLevelMaxXp(int levelMaxXp)
	{
		this.levelMaxXp = levelMaxXp;
	}

	/**
	 * Get the current levels max xp.
	 * @return
	 */
	public int getLevelMaxXp()
	{
		return levelMaxXp;
	}
	
	/**
	 * Set whether the spell should gain xp.
	 * 
	 * @param shouldGainXp
	 */
	public void setShouldGainXp(boolean shouldGainXp)
	{
		this.shouldGainXp = shouldGainXp;
	}

	/**
	 * Get whether the spell should gain xp.
	 * 
	 * @return
	 */
	public boolean getShouldGainXp()
	{
		return shouldGainXp;
	}
}
