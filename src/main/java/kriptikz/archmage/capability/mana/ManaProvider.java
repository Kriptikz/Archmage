package kriptikz.archmage.capability.mana;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Provider for {@link IMana} capability.
 * 
 * @author kriptikz
 *
 */
public class ManaProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject(IMana.class)
	public static final Capability<IMana> MANA = null;
	
	/**
	 * Default instance of {@link IMana} capability.
	 */
	private IMana instance = MANA.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == MANA;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == MANA ? MANA.<T>cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound) MANA.getStorage().writeNBT(MANA, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		MANA.getStorage().readNBT(MANA, this.instance, null, nbt);
	}
}
