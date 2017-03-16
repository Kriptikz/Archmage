package kriptikz.archmage.capability.statuseffects;

/**
 * Default implementation of {@link IStatusEffects} capability.
 * @author kriptikz
 *
 */
public class StatusEffects implements IStatusEffects
{
	/**
	 * Constants used as array index's for easier reference into status effects array.
	 */
	public final int IS_ACTIVE = 0;
	public final int TICKS = 1;
	public final int DURATION = 2;
	public final int AMP = 3;
	
	public final int TRUE = 1;
	public final int FALSE = 0;
	
	/**
	 * Constants used for easier reference of spells by Id.
	 */
	public static final int STUNNED = 0, LEVITATING = 1;
	
	/**
	 * Constant used for number of status effects implemented.
	 */
	public static final int NUMBER_OF_STATUS_EFFECTS = 2;
	
	/**
	 * An array to temporarily set to a status effects array in order to get/set status effect data.
	 * Index: [0] = isActive, [1] = ticks, [2] = duration, [3] = amp
	 */
	private int[] temp = new int[4];
	
	/**
	 * The following variables are arrays to  hold status effect data.
	 * Index: [0] = isActive, [1] = ticks, [2] = duration, [3] = amp
	 */
	private int[] stunned = {0, 0, 0, 0};
	private int[] levitating = {0, 0, 0, 0};

	@Override
	public void setIsActive(int effectId, int newIsActive)
	{
		setTemp(effectId);
		
		if (newIsActive == TRUE)
		{
			this.temp[IS_ACTIVE] = TRUE;
		}
		else
		{
			this.temp[IS_ACTIVE] = FALSE;
		}
	}
	
	@Override
	public int getIsActive(int effectId)
	{
		setTemp(effectId);
		
		return this.temp[IS_ACTIVE];
	}
	
	@Override
	public void setTicks(int effectId, int newTicks)
	{
		setTemp(effectId);
		
		this.temp[TICKS] = newTicks;
	}

	@Override
	public int getTicks(int effectId)
	{
		setTemp(effectId);
		
		return this.temp[TICKS];
	}

	@Override
	public void setDuration(int effectId, int newDuration)
	{
		setTemp(effectId);
		
		this.temp[DURATION] = newDuration;
	}

	@Override
	public int getDuration(int effectId)
	{
		setTemp(effectId);
		
		return this.temp[DURATION];
	}

	@Override
	public void setAmp(int effectId, int newAmp)
	{
		setTemp(effectId);
		
		this.temp[AMP] = newAmp;
	}

	@Override
	public int getAmp(int effectId)
	{
		setTemp(effectId);
		
		return this.temp[AMP];
	}
	
	@Override
	public void setStatusEffectFromId(int effectId, int[] statusEffect)
	{
		setTemp(effectId);
		
		this.temp = statusEffect;
	}

	@Override
	public int[] getStatusEffectFromId(int effectId)
	{
		switch(effectId)
		{
			case STUNNED: return this.stunned;
			case LEVITATING: return this.levitating;
			
			default: return null;
		}
	}
	
	/**
	 * Set the temp array to a status effect array, for get/set status effect data.
	 * 
	 * @param statusEffectId The id of the status effect
	 */
	public void setTemp(int effectId)
	{
		this.temp = getStatusEffectFromId(effectId);
	}
}
