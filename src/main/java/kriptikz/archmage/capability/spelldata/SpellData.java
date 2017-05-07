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
	private int selectedLevel = 1;
	private int level = 1;
	private int xp = 0;
	private int levelMaxXp = 100;
	private boolean shouldGainXp = true;
	
	/**
	 * Constructor for {@link SpellData}.
	 * 
	 * @param spell an enum from {@link EnumSpells}
	 */
	public SpellData(EnumSpells spell)
	{
		this.spell = spell;
	}
	
	/**
	 * Get the id for this spell from {@link EnumSpells}.
	 * 
	 * @return
	 */
	public int getId()
	{
		return this.spell.getId();
	}
	
	/**
	 * Get the name of this spell from {@link EnumSpells}.
	 * 
	 * @return
	 */
	public String getName()
	{
		return this.spell.getName();
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
		return this.isLearned;
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
		return this.level;
	}
	
	/**
	 * Set the currently selected level of the spell.
	 * 
	 * @param selectedLevel
	 */
	public void setSelectedLevel(int selectedLevel)
	{
	    if (selectedLevel <= 0)
	    {
	        this.selectedLevel = 1;
	    }
	    else if (selectedLevel > this.level)
	    {
	        this.selectedLevel = level;
	    }
	    else
	    {
	        this.selectedLevel = selectedLevel;
	    }
	}
	
	/**
	 * Get the currently selected level of the spell.
	 * 
	 * @return
	 */
	public int getSelectedLevel()
	{
	    return this.selectedLevel;
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
		return this.xp;
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
		return this.levelMaxXp;
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
		return this.shouldGainXp;
	}
}
