package kriptikz.archmage.capability.archmagelevel;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Provider for {@link IArchmageLevel} capability.
 * 
 * @author kriptikz
 *
 */
public class ArchmageLevelProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject(IArchmageLevel.class)
	public static final Capability<IArchmageLevel> ARCHMAGE_LEVEL = null;

	/**
	 * Default instance of archmage level capability.
	 */
	private IArchmageLevel instance = ARCHMAGE_LEVEL.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == ARCHMAGE_LEVEL;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == ARCHMAGE_LEVEL ? ARCHMAGE_LEVEL.<T>cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound) ARCHMAGE_LEVEL.getStorage().writeNBT(ARCHMAGE_LEVEL, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		ARCHMAGE_LEVEL.getStorage().readNBT(ARCHMAGE_LEVEL, this.instance, null, nbt);
	}

}
