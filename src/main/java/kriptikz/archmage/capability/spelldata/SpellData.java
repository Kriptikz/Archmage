package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.Reference;
import kriptikz.archmage.spell.TeleportDestination;

public class SpellData implements ISpellData
{	
	/**
	 * The players currently selected spell.
	 */
	private EnumSpellId selectedSpell = EnumSpellId.FIREBALL;
	
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
	public void setSelectedSpell(EnumSpellId newSelectedSpell)
	{
		this.selectedSpell = newSelectedSpell;
	}

	@Override
	public EnumSpellId getSelectedSpell()
	{
		return this.selectedSpell;
	}

	@Override
	public void setSpellIsLearned(EnumSpellId spellId, int newIS_LEARNED)
	{
		setTemp(spellId);
		
		this.temp[EnumSpellData.IS_LEARNED.getIndexValue()] = newIS_LEARNED;
	}

	@Override
	public int getSpellIsLearned(EnumSpellId spellId)
	{
		setTemp(spellId);
		
		return this.temp[EnumSpellData.IS_LEARNED.getIndexValue()];
	}

	@Override
	public void setSpellLevel(EnumSpellId spellId, int newSpellLevel)
	{
		setTemp(spellId);
		
		if (this.temp[EnumSpellData.LEVEL.getIndexValue()] >= 10)
		{
			this.temp[EnumSpellData.LEVEL.getIndexValue()] = 10;
			this.temp[EnumSpellData.SHOULD_GAIN_XP.getIndexValue()] = Reference.FALSE;
		}
		else if (this.temp[EnumSpellData.LEVEL.getIndexValue()] < 1)
		{
			this.temp[EnumSpellData.LEVEL.getIndexValue()] = 1;
			this.temp[EnumSpellData.SHOULD_GAIN_XP.getIndexValue()] = Reference.TRUE;
		}
		else
		{
			this.temp[EnumSpellData.LEVEL.getIndexValue()] = newSpellLevel;
			this.temp[EnumSpellData.SHOULD_GAIN_XP.getIndexValue()] = Reference.TRUE;
		}
		
	}

	@Override
	public int getSpellLevel(EnumSpellId spellId)
	{
		setTemp(spellId);
		
		return this.temp[EnumSpellData.LEVEL.getIndexValue()];
	}

	@Override
	public void setSpellXp(EnumSpellId spellId, int newSpellXp)
	{
		setTemp(spellId);
		
		this.temp[EnumSpellData.XP.getIndexValue()] = newSpellXp;
	}

	@Override
	public int getSpellXp(EnumSpellId spellId)
	{
		setTemp(spellId);
		
		return this.temp[EnumSpellData.XP.getIndexValue()];
	}

	@Override
	public void setSpellLevelMaxXp(EnumSpellId spellId, int newLevelMaxXp)
	{
		setTemp(spellId);
		
		this.temp[EnumSpellData.LEVEL_MAX_XP.getIndexValue()] = newLevelMaxXp;
	}

	@Override
	public int getSpellLevelMaxXp(EnumSpellId spellId)
	{
		setTemp(spellId);
		
		return this.temp[EnumSpellData.LEVEL_MAX_XP.getIndexValue()];
	}

	@Override
	public void setShouldGainXp(EnumSpellId spellId, int newShouldGainXp)
	{
		setTemp(spellId);
		
		if (newShouldGainXp == Reference.TRUE)
		{
			this.temp[EnumSpellData.SHOULD_GAIN_XP.getIndexValue()] = Reference.TRUE;
		}
		else
		{
			this.temp[EnumSpellData.SHOULD_GAIN_XP.getIndexValue()] = Reference.FALSE;
		}
	}

	@Override
	public int getShouldGainXp(EnumSpellId spellId)
	{
		setTemp(spellId);
		
		return this.temp[EnumSpellData.SHOULD_GAIN_XP.getIndexValue()];
	}

	@Override
	public void setSpellFromId(EnumSpellId spellId, int[] spell)
	{
		setTemp(spellId);
		
		this.temp = spell;
	}

	@Override
	public int[] getSpellFromId(EnumSpellId spellId)
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
	private void setTemp(EnumSpellId spellId)
	{
		this.temp = getSpellFromId(spellId);
	}
}
