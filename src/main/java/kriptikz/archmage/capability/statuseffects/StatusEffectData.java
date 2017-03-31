package kriptikz.archmage.capability.statuseffects;

/**
 * Status effect data associated with each individual status effect.
 * 
 * @author kriptikz
 *
 */
public class StatusEffectData
{
	private final EnumStatusEffects statusEffect;
	private boolean isActive = false;
	private int ticks = 0;
	private int duration = 0;
	private int amp = 0;
	
	/**
	 * Constructor for {@link StatusEffectData}.
	 * 
	 * @param statusEffect an enum from {@link EnumStatusEffects}
	 */
	public StatusEffectData(EnumStatusEffects statusEffect)
	{
		this.statusEffect = statusEffect;
	}
	
	/**
	 * Get the integer id for this status effect from {@link EnumStatusEffects}.
	 * 
	 * @return
	 */
	public int getId()
	{
		return this.statusEffect.getId();
	}
	
	/**
	 * Get the name of this status effect from {@link EnumStatusEffects}.
	 * @return
	 */
	public String getName()
	{
		return this.statusEffect.getName();
	}
	
	/**
	 * Set whether this status effect is active, mainly used when retrieving NBT data.
	 * 
	 * @param newIsActive
	 */
	public void setIsActive(boolean newIsActive)
	{	
		if (newIsActive == true)
		{
			this.isActive = true;
		}
		else
		{
			this.isActive = false;
		}
	}
	
	/**
	 * Main method used to activate this status effect.
	 */
	public void activate()
	{
		this.isActive = true;
	}
	
	/**
	 * Main method used to deactivate this status effect.
	 */
	public void deactivate()
	{
		this.isActive = false;
	}
	
	/**
	 * Get whether this status effect is active.
	 * 
	 * @return
	 */
	public boolean getIsActive()
	{
		return this.isActive;
	}
	
	/**
	 * Main method for incrementing how many ticks this status effect has been active for.
	 */
	public void tick()
	{
		if (this.ticks < this.duration)
		{
			this.ticks += 1;
		}
		else
		{
			this.isActive = false;
			this.ticks = 0;
		}
		
	}
	
	/**
	 * Set how many ticks this status effect has been active for, mainly used when retrieving NBT data.
	 * @param newTicks
	 */
	public void setTicks(int newTicks)
	{
		this.ticks = newTicks;
	}

	/**
	 * Get the amount of ticks this status effect has been active for.
	 * 
	 * @return
	 */
	public int getTicks()
	{
		return this.ticks;
	}

	/**
	 * Set the duration this status effect will be active for, in ticks.
	 * 
	 * @param newDuration
	 */
	public void setDuration(int newDuration)
	{
		this.duration = newDuration;
	}

	/**
	 * Get the duration this status effect will be active for.
	 * 
	 * @return
	 */
	public int getDuration()
	{
		return this.duration;
	}

	/**
	 * Set the amp of this status effect.
	 * 
	 * @param newAmp
	 */
	public void setAmp(int newAmp)
	{
		this.amp = newAmp;
	}

	/**
	 * Get the amp of this status effect.
	 * 
	 * @return
	 */
	public int getAmp()
	{
		return this.amp;
	}
}
