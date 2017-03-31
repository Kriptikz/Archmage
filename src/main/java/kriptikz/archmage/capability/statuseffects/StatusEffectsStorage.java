package kriptikz.archmage.capability.statuseffects;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**
 * {@link IStorage} implementation for {@link IStatusEffects} capability.
 * @author kriptikz
 *
 */
public class StatusEffectsStorage implements IStorage<IStatusEffects>
{

	@Override
	public NBTBase writeNBT(Capability<IStatusEffects> capability, IStatusEffects instance, EnumFacing side)
	{
		NBTTagCompound NBTData = new NBTTagCompound();
		
		// Write status effect data to NBT.
		for (StatusEffectData effectData : instance.getStatusEffects())
		{
			NBTData.setBoolean(effectData.getName() + "_is_active", effectData.getIsActive());
			NBTData.setInteger(effectData.getName() + "_ticks", effectData.getTicks());
			NBTData.setInteger(effectData.getName() + "_duration", effectData.getDuration());
			NBTData.setInteger(effectData.getName() + "_amp", effectData.getAmp());
		}
		
		return NBTData;
	}

	@Override
	public void readNBT(Capability<IStatusEffects> capability, IStatusEffects instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound NBTData = (NBTTagCompound) nbt;
		
		// Read status effect data from NBT.
		for (StatusEffectData effectData : instance.getStatusEffects())
		{
			effectData.setIsActive(NBTData.getBoolean(effectData.getName() + "_is_active"));
			effectData.setTicks(NBTData.getInteger(effectData.getName() + "_ticks"));
			effectData.setDuration(NBTData.getInteger(effectData.getName() + "_duration"));
			effectData.setAmp(NBTData.getInteger(effectData.getName() + "_amp"));
		}
	}

}
