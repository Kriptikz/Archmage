package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.spell.TeleportDestination;

public class SpellData implements ISpellData
{
	/**
	 * Constant used as array index's for easier reference into spell array.
	 */
	public static final int IS_LEARNED = 0,
							LEVEL = 1,
							XP = 2,
							LEVEL_MAX_XP = 3,
							SHOULD_GAIN_XP = 4;
	/**
	 * Constant for int value of true and false, where TRUE = 1, FALSE = 0.
	 */
	public static final int TRUE = 1,
							FALSE = 0;
	
	/**
	 * Constant used for easier reference of spells by Id.
	 */
	public static final int FIREBALL = 0,
							STUN = 1,
							SELF_HEAL = 2,
							HEAL_PROJECTILE = 3,
							DIZZIFY = 4,
							SLOW = 5,
							DUMMY_CLONE = 6,
							LEVITATE = 7,
							WARP = 8,
							TELEPORT = 9;
	
	/**
	 * Constant used for number of spells implemented.
	 */
	public static final int NUMBER_OF_SPELLS = 10;
	
	/**
	 * The players currently selected spell.
	 */
	private int selectedSpell = 0;
	
	/**
	 * The players teleport destination for the teleport spell.
	 */
	private TeleportDestination teleportDestination;
	
	/**
	 * An array to temporarily set to a spell array in order to set/get the spell arrays data.
	 * Index: [0] = IS_LEARNED, [1] = level, [2] = xp, [3] = levelMaxXp, [4] = shouldGainXp
	 */
	private int[] temp = new int[5];
	
	/**
	 * Spell array to hold spell data.
	 * Index: [0] = isLearned, [1] = level, [2] = xp, [3] = levelMaxXp, [4] = shouldGainXp
	 */
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
	
	/**
	 * The players TeleportDestination for spellTeleport
	 */

	@Override
	public void setSelectedSpell(int newSelectedSpell)
	{
		this.selectedSpell = newSelectedSpell;
	}

	@Override
	public int getSelectedSpell()
	{
		return this.selectedSpell;
	}

	@Override
	public void setSpellIsLearned(int spellId, int newIS_LEARNED)
	{
		setTemp(spellId);
		
		this.temp[IS_LEARNED] = newIS_LEARNED;
	}

	@Override
	public int getSpellIsLearned(int spellId)
	{
		setTemp(spellId);
		
		return this.temp[IS_LEARNED];
	}

	@Override
	public void setSpellLevel(int spellId, int newSpellLevel)
	{
		setTemp(spellId);
		
		if (this.temp[LEVEL] >= 10)
		{
			this.temp[LEVEL] = 10;
			this.temp[SHOULD_GAIN_XP] = FALSE;
		}
		else if (this.temp[LEVEL] < 1)
		{
			this.temp[LEVEL] = 1;
			this.temp[SHOULD_GAIN_XP] = TRUE;
		}
		else
		{
			this.temp[LEVEL] = newSpellLevel;
			this.temp[SHOULD_GAIN_XP] = TRUE;
		}
		
	}

	@Override
	public int getSpellLevel(int spellId)
	{
		setTemp(spellId);
		
		return this.temp[LEVEL];
	}

	@Override
	public void setSpellXp(int spellId, int newSpellXp)
	{
		setTemp(spellId);
		
		this.temp[XP] = newSpellXp;
	}

	@Override
	public int getSpellXp(int spellId)
	{
		setTemp(spellId);
		
		return this.temp[XP];
	}

	@Override
	public void setSpellLevelMaxXp(int spellId, int newLevelMaxXp)
	{
		setTemp(spellId);
		
		this.temp[LEVEL_MAX_XP] = newLevelMaxXp;
	}

	@Override
	public int getSpellLevelMaxXp(int spellId)
	{
		setTemp(spellId);
		
		return this.temp[LEVEL_MAX_XP];
	}

	@Override
	public void setShouldGainXp(int spellId, int newShouldGainXp)
	{
		setTemp(spellId);
		
		if (newShouldGainXp == TRUE)
		{
			this.temp[SHOULD_GAIN_XP] = TRUE;
		}
		else
		{
			this.temp[SHOULD_GAIN_XP] = FALSE;
		}
	}

	@Override
	public int getShouldGainXp(int spellId)
	{
		setTemp(spellId);
		
		return this.temp[SHOULD_GAIN_XP];
	}

	@Override
	public void setSpellFromId(int spellId, int[] spell)
	{
		setTemp(spellId);
		
		this.temp = spell;
	}

	@Override
	public int[] getSpellFromId(int spellId)
	{
		switch(spellId)
		{
			case FIREBALL: return spellFireball;
			case STUN: return this.spellStunEntity;
			case SELF_HEAL: return this.spellSelfHeal;
			case HEAL_PROJECTILE: return this.spellHealProjectile;
			case DIZZIFY: return this.spellDizzify;
			case SLOW: return this.spellSlowEntity;
			case DUMMY_CLONE: return this.spellDummyClone;
			case LEVITATE: return this.spellLevitate;
			case WARP: return this.spellWarp;
			case TELEPORT: return this.spellTeleport;
			
			default: return null;
		}
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
	
	/**
	 * Set the temp array to a spell array for getting/setting spell array data.
	 * 
	 * @param spellId The id of the spell
	 */
	private void setTemp(int spellId)
	{
		this.temp = getSpellFromId(spellId);
	}
}
