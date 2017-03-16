package kriptikz.archmage;

import kriptikz.archmage.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabArchmage extends CreativeTabs
{
	public CreativeTabArchmage()
	{
		super(Reference.MODID);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.ITEMS[0]);
	}
}
