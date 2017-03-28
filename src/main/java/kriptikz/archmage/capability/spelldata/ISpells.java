package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.spell.TeleportDestination;

/**
 * A capability to provide spellIds with individual leveling to the player.
 * 
 * @author kriptikz
 *
 */
public interface ISpells
{	
	/**
	 * Set the players currently selected spell using an integer rather than {@link EnumspellIds}.
	 * 
	 * @param newSelectedSpell
	 */
	public void setSelectedSpell(int newSelectedSpell);
	
	/**
	 * Set the players currently selected spell using {@link EnumspellIds}.
	 * 
	 * @param newSelectedSpell The new players selected spell
	 */
	public void setSelectedSpell(EnumSpells newSelectedSpell);
	
	/**
	 * Get the players currently selected spell.
	 * 
	 * @return The players currently selected spell as an {@link EnumSpells}
	 */
	public EnumSpells getSelectedSpell();
	
	/**
	 * Get the array of {@link Spell} objects.
	 * @return
	 */
	public SpellData[] getSpells();
	
	/**
	 * Get a spell by its enum {@link SpellName}.
	 * 
	 * @return
	 */
	public SpellData getSpellData(EnumSpells spellName );
	
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
