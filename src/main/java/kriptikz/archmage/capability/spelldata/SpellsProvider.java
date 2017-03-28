package kriptikz.archmage.capability.spelldata;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Provider for {@link ISpellData} capability.
 * 
 * @author kriptikz
 *
 */
public class SpellsProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject(ISpells.class)
	public static final Capability<ISpells> SPELLS = null;
	
	/**
	 * Default instance of {@link ISpellData} capability.
	 */
	private ISpells instance = SPELLS.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == SPELLS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == SPELLS ? SPELLS.<T>cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound) SPELLS.getStorage().writeNBT(SPELLS, instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		SPELLS.getStorage().readNBT(SPELLS, instance, null, nbt);
	}

}
