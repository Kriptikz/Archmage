package kriptikz.archmage.item;

import kriptikz.archmage.capability.spelldata.ISpellData;
import kriptikz.archmage.capability.spelldata.SpellDataProvider;
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
import net.minecraft.util.EnumParticleTypes;
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
				ISpellBase spell = null;
				ISpellData spellData = entityLiving.getCapability(SpellDataProvider.SPELL_DATA, null);
				
				switch(spellData.getSelectedSpell())
				{
					case 0:
						spell = new SpellFireball(worldIn, entityLiving);
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
			if ( count % 3 == 0)
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

					ISpellData spellData = player.getCapability(SpellDataProvider.SPELL_DATA, null);
					if (spellData.getSelectedSpell() == 0)
					{
						player.world.spawnParticle(EnumParticleTypes.FLAME, particlePos.xCoord, particlePos.yCoord,
								particlePos.zCoord, 0.0D, 0.0D, 0.0D, new int[0]);
					}
					else
					{
						player.world.spawnParticle(EnumParticleTypes.SPELL_WITCH, particlePos.xCoord,
								particlePos.yCoord, particlePos.zCoord, 0.0D, 0.0D, 0.0D, new int[0]);
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