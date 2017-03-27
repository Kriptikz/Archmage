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
		
		// Write status effect arrays to NBT.
		for (EnumStatusEffectId effectId : EnumStatusEffectId.values())
		{
			NBTData.setIntArray("status_effect_" + effectId.toString().toLowerCase(), instance.getStatusEffectFromId(effectId));
		}
		
		return NBTData;
	}

	@Override
	public void readNBT(Capability<IStatusEffects> capability, IStatusEffects instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound NBTData = (NBTTagCompound) nbt;
		
		// Read status effect arrays from NBT.
		for (EnumStatusEffectId effectId : EnumStatusEffectId.values())
		{
			instance.setStatusEffectFromId(effectId, NBTData.getIntArray("status_effect_" + effectId.toString().toLowerCase()));
		}
	}

}
