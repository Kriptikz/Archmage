package kriptikz.archmage.item;

import kriptikz.archmage.Archmage;
import kriptikz.archmage.Reference;
import net.minecraft.item.Item;

/**
 * Base class for easier item creation.
 * 
 * @author kriptikz
 *
 */
public class ItemBase extends Item
{
	/**
	 * ItemBase constructor, used to set the registry name, unlocalized name and creative tab.
	 * 
	 * @param name The name of the item
	 */
	ItemBase(String name)
	{
		this.setRegistryName(Reference.MODID, name);
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(Archmage.ARCHMAGE_TAB);
	}
}
