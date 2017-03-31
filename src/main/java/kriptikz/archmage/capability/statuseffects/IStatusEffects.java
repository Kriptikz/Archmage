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
	 * Get the status effect data from a status effect enum {@link EnumStatusEffects}.
	 * 
	 * @param effect The enum of the status effect
	 * @return The {@link StatusEffectData} of the status effect
	 */
	public StatusEffectData getStatusEffectData(EnumStatusEffects effect);
	
	/**
	 * Get the {@link StatusEffectData} object array from {@link StatusEffects}.
	 * 
	 * @return
	 */
	public StatusEffectData[] getStatusEffects();
}
