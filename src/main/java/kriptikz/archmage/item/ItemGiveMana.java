package kriptikz.archmage.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Gives the player some mana.
 * 
 * @author kriptikz
 *
 */
public class ItemGiveMana extends ItemBase
{

	public ItemGiveMana(String name)
	{
		super(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		final ItemStack heldItem = playerIn.getHeldItem(hand);
		
		if (!(playerIn.world.isRemote))
		{

		}
		
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, heldItem);
	}

}
