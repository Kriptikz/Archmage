package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.spell.TeleportDestination;

/**
 * A capability to provide spellIds with individual leveling to the player.
 * 
 * @author kriptikz
 *
 */
public interface ISpellData
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
	public void setSelectedSpell(SpellName newSelectedSpell);
	
	/**
	 * Get the players currently selected spell.
	 * 
	 * @return The players currently selected spell.
	 */
	public SpellName getSelectedSpell();
	
	/**
	 * Get the array of {@link Spell} objects.
	 * @return
	 */
	public Spell[] getSpells();
	
	/**
	 * Get a spell.
	 * 
	 * @return
	 */
	public Spell getSpell(SpellName spellName );
	
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
