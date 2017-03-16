package kriptikz.archmage.capability.statuseffects;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Provider for {@link IStatusEffects} capability.
 * 
 * @author kriptikz
 *
 */
public class StatusEffectsProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject(IStatusEffects.class)
	public static final Capability<IStatusEffects> STATUS_EFFECT = null;
	
	/**
	 * Default instance of {@link IStatusEffects} capability.
	 */
	private IStatusEffects instance = STATUS_EFFECT.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == STATUS_EFFECT;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == STATUS_EFFECT ? STATUS_EFFECT.<T>cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound) STATUS_EFFECT.getStorage().writeNBT(STATUS_EFFECT, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		STATUS_EFFECT.getStorage().readNBT(STATUS_EFFECT, this.instance, null, nbt);
	}

}
