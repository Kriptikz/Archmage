package kriptikz.archmage.capability;

import kriptikz.archmage.capability.archmagelevel.IArchmageLevel;
import kriptikz.archmage.capability.mana.IMana;
import kriptikz.archmage.capability.spelldata.ISpellData;
import kriptikz.archmage.capability.spelldata.Spell;

/**
 * A class of static methods used to increase/decrease mana, burnout, archmage xp or level, spell xp or level.
 * 
 * @author kriptikz
 *
 */
public class DataManager
{
	/**
	 * Regen players mana by player regen mana amount.
	 * 
	 * @param player The player to regen mana for
	 */
	public static void regenMana(IMana mana)
	{
		increaseMana(mana, mana.getManaRegen());
	}
	
	/**
	 * Increase the players mana by specified amount. Ensures mana cannot go above max mana.
	 * 
	 * @param mana The players {@link IMana} capability
	 * @param amount The amount of mana to increase by
	 */
	public static void increaseMana(IMana mana, float amount)
	{		
		if (mana.getMana() + amount <= mana.getMaxMana())
		{
			mana.setMana(mana.getMana() + amount);
		}
		else
		{
			mana.setMana(mana.getMaxMana());
		}
	}
	
	/**
	 * Decrease the players mana by specified amount. Ensures mana cannot go below 0.
	 * 
	 * @param mana The players {@link IMana} capability
	 * @param amount The amount of mana to decrease by
	 * @return Whether the mana was able to be decreased by specified amount
	 */
	public static boolean decreaseMana(IMana mana, float amount)
	{
		if (mana.getMana() - amount >= 0)
		{
			mana.setMana(mana.getMana() - amount);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Increase the players burnout by specified amount. Ensures burnout cannot go about max burnout.
	 * 
	 * @param mana The players {@link IMana} capability
	 * @param amount The amount to increase burnout by
	 */
	public static void increaseBurnout(IMana mana, float amount)
	{
		if (mana.getBurnout() + amount <= mana.getMaxBurnout())
		{
			mana.setBurnout(mana.getBurnout() + amount);
		}
	}
	
	/**
	 * Decrease the players burnout by specified amount. Ensures burnout cannot go below 0.
	 * 
	 * @param mana The players {@link IMana} capability
	 * @param amount The amount to decrease burnout by
	 */
	public static void decreaseBurnout(IMana mana, float amount)
	{
		if (mana.getBurnout() - amount >= 0)
		{
			mana.setBurnout(mana.getBurnout() - amount);
		}
		else
		{
			mana.setBurnout(0);
		}
	}
	
	/**
	 * Increase the players Archmage xp. Archmage level will also increase if appropriate.
	 * 
	 * @param archmageLevel The players {@link IArchmage} capability
	 * @param amount The amount to increase the players Archmage xp by
	 */
	public static void increaseArchmageXp(IArchmageLevel archmageLevel, float amount)
	{
		if (archmageLevel.getShouldGainXp())
		{
			if (archmageLevel.getLevelXp() + amount < archmageLevel.getLevelMaxXp())
			{
				archmageLevel.setLevelXp(archmageLevel.getLevelXp() + amount);
			}
			else if (archmageLevel.getLevelXp() + amount >= archmageLevel.getLevelMaxXp())
			{
				increaseArchmageLevel(archmageLevel, 1);
				archmageLevel.setLevelXp((archmageLevel.getLevelXp() + amount) - archmageLevel.getLevelMaxXp());
				archmageLevel.setLevelMaxXp(archmageLevel.getLevelMaxXp() * 1.3f);
			}
		}
	}
	
	/**
	 * Increase the players Archmage level. Level cap is hardcoded and handled in the capability.
	 * 
	 * @param archmageLevel The players {@link IArchmage} capabilty
	 * @param amount The amount to increase the players Archmage level by
	 */
	public static void increaseArchmageLevel(IArchmageLevel archmageLevel, int amount)
	{
		archmageLevel.setArchmageLevel(archmageLevel.getArchmageLevel() + amount);
	}
	
	/**
	 * Increase the players spell xp. Spell level will also increase if appropriate.
	 * 
	 * @param spellData The players {@link ISpellData} capabilty
	 * @param spellName The name of the spell to increase xp for
	 * @param amount The amount to increase the players spell xp by
	 */
	public static void increaseSpellXp(Spell spell, int amount)
	{
		//Spell spell = spellData.getSpell(spellName);
		
		if (spell.getShouldGainXp())
		{
			if (spell.getXp() < spell.getLevelMaxXp())
			{
				spell.setXp(spell.getXp() + amount);
			}
			else if (spell.getXp() >= spell.getLevelMaxXp())
			{
				increaseSpellLevel(spell, 1);
				spell.setXp((spell.getXp() + amount) - spell.getLevelMaxXp());
				spell.setLevelMaxXp((int) (spell.getLevelMaxXp() * 1.3));
			}
		}
	}
	
	/**
	 * Increase the players spell level. Level cap is hardcoded and handled in the capability.
	 * 
	 * @param spellData The players {@link ISpellData} capability
	 * @param spellId The id of the spell to increase level for
	 * @param amount The amount to increase the players spell level by
	 */
	public static void increaseSpellLevel(Spell spell, int amount)
	{
		spell.setLevel(spell.getLevel() + amount);
	}
}
