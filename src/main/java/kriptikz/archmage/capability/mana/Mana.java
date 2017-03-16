package kriptikz.archmage.capability.mana;

/**
 * Default implementation of {@link IMana}.
 * 
 * @author kriptikz
 *
 */
public class Mana implements IMana
{
	/**
	 * The players mana.
	 */
	private float mana = 0;
	
	/**
	 * The players max mana.
	 */
	private float maxMana = 50;
	
	/**
	 * The players mana regen per second;
	 */
	private float manaRegen = 0.25f;
	
	/**
	 * The players burnout.
	 */
	private float burnout = 0;
	
	/**
	 * The player max burnout.
	 */
	private float maxBurnout = 10;
	
	
	@Override
	public void setMana(float newMana)
	{
		this.mana = newMana;
	}

	@Override
	public float getMana()
	{
		return this.mana;
	}

	@Override
	public void setMaxMana(float newMaxMana)
	{
		this.maxMana = newMaxMana;
	}

	@Override
	public float getMaxMana()
	{
		return this.maxMana;
	}
	
	@Override
	public void setManaRegen(float newManaRegen)
	{
		this.manaRegen = newManaRegen;
	}
	
	@Override
	public float getManaRegen()
	{
		return this.manaRegen;
	}

	@Override
	public void setBurnout(float newBurnout)
	{
		this.burnout = newBurnout;
	}

	@Override
	public float getBurnout()
	{
		return this.burnout;
	}

	@Override
	public void setMaxBurnout(float newMaxBurnout)
	{
		this.maxBurnout = newMaxBurnout;
	}

	@Override
	public float getMaxBurnout()
	{
		return this.maxBurnout;
	}

}
