package kriptikz.archmage.capability.spelldata;

import kriptikz.archmage.spell.TeleportDestination;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**
 * {@link IStorage} implementation for {@link ISpellData} capability.
 * 
 * @author kriptikz
 *
 */
public class SpellDataStorage implements IStorage<ISpellData>
{

	@Override
	public NBTBase writeNBT(Capability<ISpellData> capability, ISpellData instance, EnumFacing side)
	{
		NBTTagCompound NBTData = new NBTTagCompound();
		
		TeleportDestination teleportDestination = instance.getTeleportDestination();
		
		// Check if the player has a teleport destination set.
		Boolean writeTeleportDestination = false;
		if (teleportDestination != null)
		{
			writeTeleportDestination = true;
		}
		
		// Set a boolean for whether readNBT should read the teleport destination.
		NBTData.setBoolean("readTeleportDestination", writeTeleportDestination);
		
		if (writeTeleportDestination)
		{
			// Write teleport destination.
			int[] teleportDestinationArray = {teleportDestination.getTeleportDimId(),
					teleportDestination.getTeleportPos().getX(),
					teleportDestination.getTeleportPos().getY(),
					teleportDestination.getTeleportPos().getZ()};
			NBTData.setIntArray("teleportDestination", teleportDestinationArray);
		}
		
		// Write players selected spell to NBT.
		NBTData.setInteger("selectedSpell", instance.getSelectedSpell().getId());
		
		// Write spell data arrays to NBT.
		for (EnumSpellId spellId : EnumSpellId.values())
		{
			NBTData.setIntArray("spell_" + spellId.toString().toLowerCase(), instance.getSpellFromId(spellId));
		}
		
		return NBTData;
	}

	@Override
	public void readNBT(Capability<ISpellData> capability, ISpellData instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound NBTData = (NBTTagCompound) nbt;

		Boolean readTeleportDestination = NBTData.getBoolean("readTeleportDestination");

		if (readTeleportDestination)
		{
			// Read the teleport destination.
			int[] teleportDestinationArray = NBTData.getIntArray("teleportDestination");
			int dimId = teleportDestinationArray[0];
			BlockPos teleportPos = new BlockPos(teleportDestinationArray[1], teleportDestinationArray[2], teleportDestinationArray[3]);

			TeleportDestination teleportDestination = new TeleportDestination(dimId, teleportPos);

			instance.setTeleportDestination(teleportDestination);
		}

		// Read players selected spell.
		instance.setSelectedSpell(NBTData.getInteger("selectedSpell"));
		
		// Read spell data arrays from NBT.
		for (EnumSpellId spellId : EnumSpellId.values())
		{
			instance.setSpellFromId(spellId, NBTData.getIntArray("spell_" + spellId.toString().toLowerCase()));
		}
	}

}
