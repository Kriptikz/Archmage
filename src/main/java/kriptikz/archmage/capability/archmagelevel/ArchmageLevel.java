package kriptikz.archmage.capability.archmagelevel;

/**
 * Default implementation of {@link IArchmageLevel}.
 * 
 * @author kriptikz
 *
 */
public class ArchmageLevel implements IArchmageLevel
{
	/**
	 * The players current Archmage level.
	 */
	private int archmageLevel = 1;
	
	/**
	 * The players current Archmage level xp.
	 */
	private float levelXp = 0;
	
	/**
	 * The players current Archmage level max xp.
	 */
	private float levelMaxXp = 50;
	
	/**
	 * Whether the player should gain xp.
	 */
	private boolean shouldGainXp = true;
	
	@Override
	public void setArchmageLevel(int newLevel)
	{
		// Ensure the new level is within bounds.
		if (newLevel <= 0)
		{
			this.archmageLevel = 1;
			this.shouldGainXp = true;
		}
		else if (newLevel >= 50)
		{
			this.archmageLevel = 50;
			this.shouldGainXp = false;
		}
		else
		{
			this.archmageLevel = newLevel;
			this.shouldGainXp = true;
		}
	}

	@Override
	public int getArchmageLevel()
	{
		return this.archmageLevel;
	}

	@Override
	public void setLevelXp(float newLevelXp)
	{
		this.levelXp = newLevelXp;
	}

	@Override
	public float getLevelXp()
	{
		return this.levelXp;
	}

	@Override
	public void setLevelMaxXp(float newLevelMaxXp)
	{
		this.levelMaxXp = newLevelMaxXp;
	}

	@Override
	public float getLevelMaxXp()
	{
		return this.levelMaxXp;
	}

	@Override
	public void setShouldGainXp(boolean newShouldGainXp)
	{
		this.shouldGainXp = newShouldGainXp;
	}

	@Override
	public boolean getShouldGainXp()
	{
		return this.shouldGainXp;
	}

}
