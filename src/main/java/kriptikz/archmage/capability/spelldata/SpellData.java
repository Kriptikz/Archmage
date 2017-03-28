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
	 * An array to temporarily set to a spell array in order to set/get the spell arrays data.
	 * Index: [0] = IS_LEARNED, [1] = level, [2] = xp, [3] = levelMaxXp, [4] = shouldGainXp
	 */
	//private int[] temp = new int[5];
	//private Spell temp = null;
	
	/**
	 * {@link Spell} object to hold spell data.
	 */
	/*
	private int[] spellFireball = {0, 1, 0, 100, 1},
				  spellStunEntity = {0, 1, 0, 100, 1},
				  spellSelfHeal = {0, 1, 0, 100, 1},
				  spellHealProjectile = {0, 1, 0, 100, 1},
				  spellDizzify = {0, 1, 0, 100, 1},
				  spellSlowEntity = {0, 1, 0, 100, 1},
				  spellDummyClone = {0, 1, 0, 100, 1},
				  spellLevitate = {0, 1, 0, 100, 1},
				  spellWarp = {0, 1, 0, 100, 1},
				  spellTeleport = {0, 1, 0, 100, 1};
	*/
	
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
