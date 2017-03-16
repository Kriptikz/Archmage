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
public class SpellDataProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject(ISpellData.class)
	public static final Capability<ISpellData> SPELL_DATA = null;
	
	/**
	 * Default instance of {@link ISpellData} capability.
	 */
	private ISpellData instance = SPELL_DATA.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == SPELL_DATA;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == SPELL_DATA ? SPELL_DATA.<T>cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound) SPELL_DATA.getStorage().writeNBT(SPELL_DATA, instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		SPELL_DATA.getStorage().readNBT(SPELL_DATA, instance, null, nbt);
	}

}
