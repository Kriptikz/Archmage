package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.spell.TeleportDestination;

public class SpellData implements ISpellData
{	
	/**
	 * The players currently selected spell.
	 */
	private SpellName selectedSpell = SpellName.FIREBALL;
	
	/**
	 * The players teleport destination for the teleport spell.
	 */
	private TeleportDestination teleportDestination;
	
	/**
	 * {@link Spell} object array of spells to hold individual spell data.
	 */
	private Spell[] spells = new Spell[] { 
			new Spell(SpellName.FIREBALL),
			new Spell(SpellName.STUN),
			new Spell(SpellName.SELF_HEAL),
			new Spell(SpellName.HEAL_PROJECTILE),
			new Spell(SpellName.DIZZIFY),
			new Spell(SpellName.SLOW),
			new Spell(SpellName.DUMMY_CLONE),
			new Spell(SpellName.LEVITATE),
			new Spell(SpellName.WARP),
			new Spell(SpellName.TELEPORT)};
	
	@Override
	public void setSelectedSpell(int newSelectedSpell)
	{
		for (SpellName spell : SpellName.values())
		{
			if (spell.getId() == newSelectedSpell)
			{
				this.selectedSpell = spell;
			}
		}
	}

	@Override
	public void setSelectedSpell(SpellName newSelectedSpell)
	{
		this.selectedSpell = newSelectedSpell;
	}

	@Override
	public SpellName getSelectedSpell()
	{
		return this.selectedSpell;
	}
	
	@Override
	public Spell[] getSpells()
	{
		return this.spells;
	}
	
	@Override
	public Spell getSpell(SpellName spellName)
	{
		for (Spell spell : spells)
		{
			if (spell.getName() == spellName.toString())
			{
				return spell;
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
