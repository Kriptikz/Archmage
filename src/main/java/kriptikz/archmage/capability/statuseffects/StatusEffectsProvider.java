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
	public static final Capability<IStatusEffects> STATUS_EFFECTS = null;
	
	/**
	 * Default instance of {@link IStatusEffects} capability.
	 */
	private IStatusEffects instance = STATUS_EFFECTS.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == STATUS_EFFECTS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == STATUS_EFFECTS ? STATUS_EFFECTS.<T>cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound) STATUS_EFFECTS.getStorage().writeNBT(STATUS_EFFECTS, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		STATUS_EFFECTS.getStorage().readNBT(STATUS_EFFECTS, this.instance, null, nbt);
	}

}
