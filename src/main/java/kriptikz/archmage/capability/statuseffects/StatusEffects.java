package kriptikz.archmage.capability.statuseffects;

import kriptikz.archmage.Reference;

/**
 * Default implementation of {@link IStatusEffects} capability.
 * @author kriptikz
 *
 */
public class StatusEffects implements IStatusEffects
{	
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
	public void setIsActive(EnumStatusEffectId effectId, int newIsActive)
	{
		setTemp(effectId);
		
		if (newIsActive == Reference.TRUE)
		{
			this.temp[EnumStatusEffectData.IS_ACTIVE.getIndexValue()] = Reference.TRUE;
		}
		else
		{
			this.temp[EnumStatusEffectData.IS_ACTIVE.getIndexValue()] = Reference.FALSE;
		}
	}
	
	@Override
	public int getIsActive(EnumStatusEffectId effectId)
	{
		setTemp(effectId);
		
		return this.temp[EnumStatusEffectData.IS_ACTIVE.getIndexValue()];
	}
	
	@Override
	public void setTicks(EnumStatusEffectId effectId, int newTicks)
	{
		setTemp(effectId);
		
		this.temp[EnumStatusEffectData.TICKS.getIndexValue()] = newTicks;
	}

	@Override
	public int getTicks(EnumStatusEffectId effectId)
	{
		setTemp(effectId);
		
		return this.temp[EnumStatusEffectData.TICKS.getIndexValue()];
	}

	@Override
	public void setDuration(EnumStatusEffectId effectId, int newDuration)
	{
		setTemp(effectId);
		
		this.temp[EnumStatusEffectData.DURATION.getIndexValue()] = newDuration;
	}

	@Override
	public int getDuration(EnumStatusEffectId effectId)
	{
		setTemp(effectId);
		
		return this.temp[EnumStatusEffectData.DURATION.getIndexValue()];
	}

	@Override
	public void setAmp(EnumStatusEffectId effectId, int newAmp)
	{
		setTemp(effectId);
		
		this.temp[EnumStatusEffectData.AMP.getIndexValue()] = newAmp;
	}

	@Override
	public int getAmp(EnumStatusEffectId effectId)
	{
		setTemp(effectId);
		
		return this.temp[EnumStatusEffectData.AMP.getIndexValue()];
	}
	
	@Override
	public void setStatusEffectFromId(EnumStatusEffectId effectId, int[] statusEffect)
	{
		setTemp(effectId);
		
		this.temp = statusEffect;
	}

	@Override
	public int[] getStatusEffectFromId(EnumStatusEffectId effectId)
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
	public void setTemp(EnumStatusEffectId effectId)
	{
		this.temp = getStatusEffectFromId(effectId);
	}
}
