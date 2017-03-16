package kriptikz.archmage.spell;

import java.util.List;

import kriptikz.archmage.entity.EntitySpellBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SpellFireball extends EntitySpellBase
{
	public SpellFireball(World world)
	{
		super(world);
		this.setSize(1.0f, 1.0f);
	}

	public SpellFireball(World world, EntityLivingBase caster)
	{
		super(world, caster);
	}

	@Override
	public void doSpell(EntityLivingBase caster, RayTraceResult result)
	{
		if (!caster.world.isRemote)
		{
				AxisAlignedBB aabb = this.getEntityBoundingBox().expandXyz(3.0D);
				List<EntityLivingBase> surroundingEntities = this.world.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
				
				if (surroundingEntities != null)
				{
					for (EntityLivingBase entity : surroundingEntities)
					{
						if (entity instanceof EntityPlayer)
						{
							if (entity != caster)
							{
								entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, caster), 10);
								entity.setFire(3);
							}
						}
						else
						{
							entity.setFire(3);
							entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, caster), 10);
						}
					} 
				}

		}
	}
	
	@Override
	public int getMaxTicksExisted()
	{
		return 100;
	}

	@Override
	public double getSpeed()
	{
		return 2.0;
	}

	@Override
	public EnumParticleTypes[] getTravelParticles()
	{
		return new EnumParticleTypes[] {EnumParticleTypes.LAVA};
	}

	@Override
	public EnumParticleTypes[] getImpactParticles()
	{
		return new EnumParticleTypes[] {EnumParticleTypes.FLAME};
	}

}
