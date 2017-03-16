package kriptikz.archmage.capability.archmagelevel;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**
 * {@link IStorage} implementation for {@link IArchmageLevel} capability.
 * 
 * @author kriptikz
 *
 */
public class ArchmageLevelStorage implements IStorage<IArchmageLevel>
{

	@Override
	public NBTBase writeNBT(Capability<IArchmageLevel> capability, IArchmageLevel instance, EnumFacing side)
	{
		NBTTagCompound NBTData = new NBTTagCompound();
		
		NBTData.setInteger("archmage_level", instance.getArchmageLevel());
		NBTData.setFloat("level_xp", instance.getLevelXp());
		NBTData.setFloat("level_max_xp",  instance.getLevelMaxXp());
		NBTData.setBoolean("should_gain_xp", instance.getShouldGainXp());
		
		return NBTData;
	}

	@Override
	public void readNBT(Capability<IArchmageLevel> capability, IArchmageLevel instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound NBTData = (NBTTagCompound) nbt;
		
		instance.setArchmageLevel(NBTData.getInteger("archmage_level"));
		instance.setLevelXp(NBTData.getFloat("level_xp"));
		instance.setLevelMaxXp(NBTData.getFloat("level_max_xp"));
		instance.setShouldGainXp(NBTData.getBoolean("should_gain_xp"));
	}

}
