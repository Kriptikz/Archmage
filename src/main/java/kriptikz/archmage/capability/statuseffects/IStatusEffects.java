package kriptikz.archmage.capability.statuseffects;

/**
 * A capability to provide status effects to {@link EntityLivingBase}'s.
 * 
 * @author kriptikz
 *
 */
public interface IStatusEffects
{
	/**
	 * Set whether the status effect is active.
	 * 
	 * @param effectId The id of the status effect
	 * @param newisActive The new isActive value
	 */
	public void setIsActive(EnumStatusEffectId effectId, int newisActive);
	
	/**
	 * Get whether the status effect is active.
	 * 
	 * @param effectId The id of the status effect.
	 * @return Whether the status effect is active.
	 */
	public int getIsActive(EnumStatusEffectId effectId);
	
	/**
	 * Set the amount of ticks the status effect has been applied for.
	 * 
	 * @param effectId The id of the status effect
	 * @param newTicks The amount of ticks the status effect has been applied for
	 */
	public void setTicks(EnumStatusEffectId effectId, int newTicks);
	
	/**
	 * Get the amount of ticks the status effect has been applied for.
	 * 
	 * @param effectId The id of the status effect
	 * @return The amount of ticks the status effect has been applied for
	 */
	public int getTicks(EnumStatusEffectId effectId);
	
	/**
	 * Set the duration the status effect should be applied for.
	 * 
	 * @param effectId The id of the status effect
	 * @param newDuration The new duration of the status effect
	 */
	public void setDuration(EnumStatusEffectId effectId, int newDuration);
	
	/**
	 * Get the duration the staus effect should applied for.
	 * 
	 * @param effectId The id of the status effect
	 * @return The new duration the status effect should be applied for
	 */
	public int getDuration(EnumStatusEffectId effectId);
	
	/**
	 * Set the amp of the status effect.
	 * 
	 * @param effectId The id of the status effect
	 * @param newAmp The new amp of the status effect
	 */
	public void setAmp(EnumStatusEffectId effectId, int newAmp);
	
	/**
	 * Get the amp of the status effect.
	 * 
	 * @param effectId The id of the status effect
	 * @return The amp of the status effect
	 */
	public int getAmp(EnumStatusEffectId effectId);
	
	/**
	 * Set status effect data from status effect array, by id.
	 * 
	 * @param effectId The id of the status effect
	 * @param statusEffect The array of the new status effect data
	 */
	public void setStatusEffectFromId(EnumStatusEffectId effectId, int[] statusEffect);
	
	/**
	 * Get the status effect data from status effect array, by id.
	 * 
	 * @param effectId The id of the status effect
	 * @return The integer array of the status effect data
	 */
	public int[] getStatusEffectFromId(EnumStatusEffectId effectId);
}
