package kriptikz.archmage.capability.statuseffects;


/**
 * Default implementation of {@link IStatusEffects} capability.
 * @author kriptikz
 *
 */
public class StatusEffects implements IStatusEffects
{	
	/**
	 * {@link StatusEffectData} object array of status effects to hold individual status effect data.
	 */
	private StatusEffectData[] statusEffects = new StatusEffectData[] {
			new StatusEffectData(EnumStatusEffects.LEVITATING),
			new StatusEffectData(EnumStatusEffects.STUNNED)
	};

	@Override
	public StatusEffectData getStatusEffectData(EnumStatusEffects effect)
	{
		for (StatusEffectData statusEffectData : statusEffects)
		{
			if (statusEffectData.getId() == effect.getId())
			{
				return statusEffectData;
			}
		}
		
		return null;
	}
	
	@Override
	public StatusEffectData[] getStatusEffects()
	{
		return this.statusEffects;
	}
}
