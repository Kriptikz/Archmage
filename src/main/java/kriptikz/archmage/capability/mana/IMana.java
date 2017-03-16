package kriptikz.archmage.capability.mana;

/**
 * A capability to provide mana to an entity.
 * 
 * @author kriptikz
 *
 */
public interface IMana
{
	/**
	 * Set the players mana
	 * 
	 * @param newMana The new mana value
	 */
	public void setMana(float newMana);
	
	/**
	 * Get the players mana
	 * 
	 * @return The players mana
	 */
	public float getMana();
	
	/**
	 * Set the players max mana
	 * 
	 * @param newMaxMana The new max mana value
	 */
	public void setMaxMana(float newMaxMana);
	
	
	/**
	 * Get the players max mana
	 * 
	 * @return The players max mana
	 */
	public float getMaxMana();
	
	/**
	 * Set the players mana regen per second.
	 * 
	 * @param manaRegenPerSecond The new mana regen per second
	 */
	public void setManaRegen(float newManaRegen);
	
	/**
	 * Get the players mana regen per second.
	 * 
	 * @return The players mana regen per second
	 */
	public float getManaRegen();
	
	/**
	 * Set the players burnout.
	 * 
	 * @param newBurnout The new burnout value
	 */
	public void setBurnout(float newBurnout);
	
	/**
	 * Get the players burnout.
	 * 
	 * @return The players burnout
	 */
	public float getBurnout();
	
	/**
	 * Set the players max burnout.
	 * 
	 * @param newMaxBurnout The new max burnout value
	 */
	public void setMaxBurnout(float newMaxBurnout);
	
	/**
	 * Get the player max burnout.
	 * 
	 * @return The players max burnout
	 */
	public float getMaxBurnout();
}
