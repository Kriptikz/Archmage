package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.spell.TeleportDestination;

public class Spells implements ISpells
{	
	/**
	 * The players currently selected spell.
	 */
	private EnumSpells selectedSpell = null;
	
	/**
	 * The players teleport destination for the teleport spell.
	 */
	private TeleportDestination teleportDestination;
	
	/**
	 * {@link Spell} object array of spells to hold individual spell data.
	 */
	private SpellData[] spells = new SpellData[] { 
			new SpellData(EnumSpells.FIREBALL),
			new SpellData(EnumSpells.STUN),
			new SpellData(EnumSpells.SELF_HEAL),
			new SpellData(EnumSpells.HEAL_PROJECTILE),
			new SpellData(EnumSpells.DIZZIFY),
			new SpellData(EnumSpells.SLOW),
			new SpellData(EnumSpells.DUMMY_CLONE),
			new SpellData(EnumSpells.LEVITATE),
			new SpellData(EnumSpells.WARP),
			new SpellData(EnumSpells.TELEPORT)};
	
	@Override
	public void setSelectedSpell(int newSelectedSpell)
	{
		for (EnumSpells spell : EnumSpells.values())
		{
			if (spell.getId() == newSelectedSpell)
			{
				this.selectedSpell = spell;
			}
		}
	}

	@Override
	public void setSelectedSpell(EnumSpells newSelectedSpell)
	{
		this.selectedSpell = newSelectedSpell;
	}

	@Override
	public EnumSpells getSelectedSpell()
	{
		return this.selectedSpell;
	}
	
	@Override
	public SpellData[] getSpells()
	{
		return this.spells;
	}
	
	@Override
	public SpellData getSpellData(EnumSpells spellName)
	{
		for (SpellData spellData : spells)
		{
			if (spellData.getSpell().getId() == spellName.getId())
			{
				return spellData;
			}
		}
		
		return null;
	}
	
	@Override
	public void setTeleportDestination(TeleportDestination newDestination)
	{
		this.teleportDestination = newDestination;
	}

	@Override
	public TeleportDestination getTeleportDestination()
	{
		return this.teleportDestination;
	}
}
