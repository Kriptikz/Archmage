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
public class SpellsStorage implements IStorage<ISpells>
{

	@Override
	public NBTBase writeNBT(Capability<ISpells> capability, ISpells instance, EnumFacing side)
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
		
		// Write spell data to NBT.
		for (SpellData spellData : instance.getSpells())
		{
			NBTData.setBoolean(spellData.getSpell().getName() + "_is_learned", spellData.getIsLearned());
			NBTData.setInteger(spellData.getSpell().getName() + "_level", spellData.getLevel());
			NBTData.setInteger(spellData.getSpell().getName() + "_xp", spellData.getXp());
			NBTData.setInteger(spellData.getSpell().getName() + "_level_max_xp", spellData.getLevelMaxXp());
			NBTData.setBoolean(spellData.getSpell().getName() + "_should_gain_xp", spellData.getShouldGainXp());
		}
		
		return NBTData;
	}

	@Override
	public void readNBT(Capability<ISpells> capability, ISpells instance, EnumFacing side, NBTBase nbt)
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
		
		// Read spell data from NBT.		
		for (SpellData spellData : instance.getSpells())
		{
			spellData.setIsLearned(NBTData.getBoolean(spellData.getSpell().getName() + "_is_learned"));
			spellData.setLevel(NBTData.getInteger(spellData.getSpell().getName() + "_level"));
			spellData.setXp(NBTData.getInteger(spellData.getSpell().getName() + "_xp"));
			spellData.setLevelMaxXp(NBTData.getInteger(spellData.getSpell().getName() + "_level_max_xp"));
			spellData.setShouldGainXp(NBTData.getBoolean(spellData.getSpell().getName() + "_should_gain_xp"));
		}
	}

}
