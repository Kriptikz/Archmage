package kriptikz.archmage.capability.spelldata;

/**
 * Spell data associated with each spell individually.
 * 
 * @author kriptikz
 *
 */
public class Spell
{
	//private final int id;
	private final SpellName name;
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
	public Spell(SpellName name)
	{
		this.name = name;
	}
	
	/**
	 * Get the name of the spell as a string
	 * 
	 * @return {@link SpellName#toString()}
	 */
	public String getName()
	{
		return this.name.toString();
	}

	public boolean getIsLearned()
	{
		return isLearned;
	}

	public void setIsLearned(boolean isLearned)
	{
		this.isLearned = isLearned;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getXp()
	{
		return xp;
	}

	public void setXp(int xp)
	{
		this.xp = xp;
	}

	public int getLevelMaxXp()
	{
		return levelMaxXp;
	}

	public void setLevelMaxXp(int levelMaxXp)
	{
		this.levelMaxXp = levelMaxXp;
	}

	public boolean getShouldGainXp()
	{
		return shouldGainXp;
	}

	public void setShouldGainXp(boolean shouldGainXp)
	{
		this.shouldGainXp = shouldGainXp;
	}
	
	
}
