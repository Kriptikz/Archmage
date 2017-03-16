package kriptikz.archmage.capability.mana;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**
 * {@link IStorage} implementation for {@link IMana} capability.
 * 
 * @author kriptikz
 *
 */
public class ManaStorage implements IStorage<IMana>
{
	@Override
	public NBTBase writeNBT(Capability<IMana> capability, IMana instance, EnumFacing side)
	{
		NBTTagCompound NBTData = new NBTTagCompound();
		
		NBTData.setFloat("mana", instance.getMana());
		NBTData.setFloat("max_mana", instance.getMaxMana());
		NBTData.setFloat("mana_regen", instance.getManaRegen());
		NBTData.setFloat("burnout", instance.getBurnout());
		NBTData.setFloat("max_burnout", instance.getMaxBurnout());
		
		return NBTData;
	}

	@Override
	public void readNBT(Capability<IMana> capability, IMana instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound NBTData = (NBTTagCompound) nbt;
		
		instance.setMana(NBTData.getFloat("mana"));
		instance.setMaxMana(NBTData.getFloat("max_mana"));
		instance.setManaRegen(NBTData.getFloat("mana_regen"));
		instance.setBurnout(NBTData.getFloat("burnout"));
		instance.setMaxBurnout(NBTData.getFloat("max_burnout"));
	}

}
