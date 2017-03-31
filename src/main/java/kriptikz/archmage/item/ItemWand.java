package kriptikz.archmage.item;

import kriptikz.archmage.Archmage;
import kriptikz.archmage.capability.spelldata.ISpells;
import kriptikz.archmage.capability.spelldata.SpellsProvider;
import kriptikz.archmage.entity.EntitySpellBase;
import kriptikz.archmage.spell.ISpellBase;
import kriptikz.archmage.spell.SpellFireball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Handles spell casting.
 * 
 * @author kriptikz
 *
 */
public class ItemWand extends ItemBase
{

	public ItemWand(String name)
	{
		super(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeleft)
	{
		if (timeleft <= 975)
		{	
			if (!worldIn.isRemote)
			{
				ISpellBase spell;
				ISpells spells = entityLiving.getCapability(SpellsProvider.SPELLS, null);
				
				switch(spells.getSelectedSpell())
				{
					case NONE:
						spell = null;
						break;
					case FIREBALL:
						spell = new SpellFireball(worldIn, entityLiving);
						break;
					default:
						spell = null;
						break;
					
				}
				if (spell != null)
				{
					if (spell.isProjectile())
					{
						worldIn.spawnEntity((EntitySpellBase) spell);
					}
					else
					{
						spell.doSpell(entityLiving, null);
					}
				}

			}
		}
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count)
	{	
		if (count <= 975)
		{
			if ( count % 6 == 0)
			{
				if (player.world.isRemote)
				{
					double particleDistance = 0.6;
					double vectorRotation = -50.80;
					Vec3d look = player.getLookVec();

					 
					Vec3d particleVector = new Vec3d(
							(look.xCoord * Math.cos(vectorRotation) + (look.zCoord) * Math.sin(vectorRotation)),
							look.yCoord,
							(-look.xCoord * Math.sin(vectorRotation) + (look.zCoord * Math.cos(vectorRotation))));
					
					Vec3d particlePos = new Vec3d(player.posX + (particleVector.xCoord * particleDistance),
							(player.posY + player.getEyeHeight() + 0.2) + (particleVector.yCoord * particleDistance),
							player.posZ + (particleVector.zCoord * particleDistance));

					ISpells spells = player.getCapability(SpellsProvider.SPELLS, null);
					
					switch(spells.getSelectedSpell())
					{
						case NONE:
							break;
						case FIREBALL:
							Archmage.proxy.spawnParticle("fire", 1, particlePos.xCoord, particlePos.yCoord, particlePos.zCoord, 0.0D, 0.0D, 0.0D);
							break;
						default:
							Archmage.proxy.spawnParticle("default", 1, particlePos.xCoord, particlePos.yCoord, particlePos.zCoord, 0.0D, 0.0D, 0.0D);
					}
				}			
			}
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		final ItemStack heldItem = playerIn.getHeldItem(hand);
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, heldItem);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 1000;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.BOW;
	}
}