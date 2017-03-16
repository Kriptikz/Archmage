package kriptikz.archmage.capability.archmagelevel;

/**
 * A capability to provide an Archmage level to the player. 
 * 
 * @author kriptikz
 *
 */
public interface IArchmageLevel
{
	/**
	 * Set the players Archmage level.
	 * 
	 * @param newLevel The players new Archmage level
	 */
	public void setArchmageLevel(int newLevel);
	
	/**
	 * Get the players Archmage level.
	 * 
	 * @return The players Archmage level
	 */
	public int getArchmageLevel();
	
	/**
	 * Set the players Archmage level xp. Level cap is hard coded and handled appropriately.
	 * 
	 * @param newLevelXp The players new Archmage level xp value;
	 */
	public void setLevelXp(float newLevelXp);
	
	/**
	 * Get the players Archmage level xp.
	 * 
	 * @return The players Archmage level xp
	 */
	public float getLevelXp();
	
	/**
	 * Set the players max Archmage level xp for the current level.
	 * 
	 * @param newLevelMaxXp The players new Archmage level max xp
	 */
	public void setLevelMaxXp(float newLevelMaxXp);
	
	/**
	 * Get the players max Archmage level xp.
	 * 
	 * @return The players Archmage level max xp
	 */
	public float getLevelMaxXp();
	
	/**
	 * Set whether the player should gain Archmage xp.
	 * 
	 * @param newShouldGainXp The new shouldGainXp value
	 */
	public void setShouldGainXp(boolean newShouldGainXp);
	
	/**
	 * Get whether the player should gain Archmage xp.
	 * 
	 * @return Whether the player should gain xp.
	 */
	public boolean getShouldGainXp();
}
