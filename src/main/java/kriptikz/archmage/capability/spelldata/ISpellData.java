package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.spell.TeleportDestination;

/**
 * A capability to provide spells with individual leveling to the player.
 * Spell data is stored in an int array, so booleans are 0 = false, 1 = true.
 * 
 * @author kriptikz
 *
 */
public interface ISpellData
{	
	/**
	 * Set the players currently selected spell.
	 * 
	 * @param newSelectedSpell The new players selected spell value
	 */
	public void setSelectedSpell(int newSelectedSpell);
	
	/**
	 * Get the players currently selected spell.
	 * 
	 * @return The players currently selected spell.
	 */
	public int getSelectedSpell();
	
	/**
	 * Set whether the player has learned the spell.
	 * 
	 * @param spellId The id of the spell
	 * @param newIsLearned The new isLearned value of the spell
	 */
	public void setSpellIsLearned(int spellId, int newIsLearned);
	
	/**
	 * Get whether the player has learned the spell.
	 * 
	 * @param spellId The id of the spell
	 * @return Whether the player has learned the spell
	 */
	public int getSpellIsLearned(int spellId);
	
	/**
	 * Set the spells level.
	 * 
	 * @param spellId The id of the spell
	 * @param newSpellLevel The new spell level value of the spell
	 */
	public void setSpellLevel(int spellId, int newSpellLevel);
	
	/**
	 * Get the spells level.
	 * 
	 * @param spellId The id of the spell
	 * @return The spells level
	 */
	public int getSpellLevel(int spellId);
	
	/**
	 * Set the spells xp.
	 * 
	 * @param spellId The id of the spell
	 * @param newSpellXp The new xp value of the spell
	 */
	public void setSpellXp(int spellId, int newSpellXp);
	
	/**
	 * Get the spells xp.
	 * @param spellId The id of the spell
	 * @return The xp of the spell
	 */
	public int getSpellXp(int spellId);
	
	/**
	 * Set spell level max xp.
	 * 
	 * @param spellId The is of the spell
	 * @param newSpellLevelMaxXp The new spell level max xp value
	 */
	public void setSpellLevelMaxXp(int spellId, int newSpellLevelMaxXp);
	
	/**
	 * Get the spell level max xp.
	 * 
	 * @param spellId The id of the spell
	 * @return The spell level max xp
	 */
	public int getSpellLevelMaxXp(int spellId);
	
	/**
	 * Set whether the spell should gain xp.
	 * 
	 * @param spellId The id of the spell
	 * @param newShouldGainXp The new shouldGainXp value
	 */
	public void setShouldGainXp(int spellId, int newShouldGainXp);
	
	/**
	 * Get whether the spell should gain xp.'
	 * 
	 * @param spellId The id of the spell
	 * @return Whether the spell should gain xp
	 */
	public int getShouldGainXp(int spellId);

	/**
	 * Set spell data from a spell array, by spell id.
	 * 
	 * @param spellId The id of the spell
	 * @param spell The array of the new spell data
	 */
	public void setSpellFromId(int spellId, int[] spell);
	
	/**
	 * Get the spell data from spell, by spell id.
	 * 
	 * @param spellid The id of the spell
	 * @return The integer array of the spell data.
	 */
	public int[] getSpellFromId(int spellId);
	
	/**
	 * Set the players teleport destination for the teleport spell.
	 * 
	 * @param newDestination The new teleport destination
	 */
	public void setTeleportDestination(TeleportDestination newDestination);
	
	/**
	 * Get the players teleport destination for the teleport spell.
	 * 
	 * @return The players teleport destination
	 */
	public TeleportDestination getTeleportDestination();
}
