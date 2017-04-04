package kriptikz.archmage.entity;

import java.lang.ref.WeakReference;
import java.util.UUID;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import kriptikz.archmage.Archmage;
import kriptikz.archmage.capability.spelldata.ISpells;
import kriptikz.archmage.capability.spelldata.SpellsProvider;
import kriptikz.archmage.client.particle.EnumParticles;
import kriptikz.archmage.spell.ISpellBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Base for projectile({@link Entity}) spells.
 * 
 * @author kriptikz
 *
 */
public abstract class EntitySpellBase extends Entity implements ISpellBase, IEntityAdditionalSpawnData
{
    /** The spell casters UUID. */
    private UUID casterId;

    /** The {@link EntityLivingBase} that cast the spell. */
    private WeakReference<EntityLivingBase> casterRef;

    /**
     * The caster's {@link ISpellData} capability.
     */
    private ISpells spells;

    /**
     * Ticks the spell has been in the air for.
     */
    private int ticksInAir;

    public EntitySpellBase(World worldIn)
    {
        super(worldIn);
    }

    public EntitySpellBase(World world, EntityLivingBase caster)
    {
        this(world);

        this.casterRef = new WeakReference<EntityLivingBase>(caster);
        this.casterId = caster.getUniqueID();
        this.setSpells(caster);
        this.setPositionAndDirection(caster);
    }

    @Override
    public void entityInit()
    {
    }

    @Override
    public boolean isProjectile()
    {
        return true;
    }

    /**
     * Set the position and direction for the entity, called in constructor of
     * entity.
     * 
     * @param caster
     */
    public void setPositionAndDirection(EntityLivingBase caster)
    {
        this.setPosition(caster.posX, caster.posY + caster.getEyeHeight() - 0.10000000149011612D, caster.posZ);

        Vec3d look = caster.getLookVec();

        this.motionX = look.xCoord * this.getSpeed();
        this.motionY = look.yCoord * this.getSpeed();
        this.motionZ = look.zCoord * this.getSpeed();
    }

    /**
     * Checks if the entity is in range to render.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public boolean isInRangeToRenderDist(double distance)
    {

        double d0 = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0D;

        if (Double.isNaN(d0))
        {
            d0 = 4.0D;
        }

        d0 = d0 * 64.0D;
        return distance < d0 * d0;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        EntityLivingBase caster = getCaster();

        if (caster == null) // caster is null when they are offline
        {
            this.setDead();
            return;
        }

        this.spells = caster.getCapability(SpellsProvider.SPELLS, null);

        if (((caster == null || !caster.isDead) || this.world.isRemote && this.world.isBlockLoaded(new BlockPos(this))))
        {
            super.onUpdate();

            ++this.ticksInAir;

            if (this.ticksExisted >= this.getMaxTicksExisted())
            {
                this.setDead();
            }

            RayTraceResult raytraceresult = ProjectileHelper.forwardsRaycast(this, true, this.ticksInAir >= 25, caster);

            if (raytraceresult != null)
            {
                this.onImpact(raytraceresult);
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;

            if (this.getTravelParticle() != null)
            {
                for (int i = 0; i < 1; i++)
                {
                    for (int j = 0; j < 1; j++)
                    {
                        Archmage.proxy.spawnParticle(this.getTravelParticle(), this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
                    }
                }
            }

            this.setPosition(this.posX, this.posY, this.posZ);
        }
        else
        {
            this.setDead();
        }
    }

    /**
     * Called when the spell hits a block or entity.
     * 
     * @param result
     *            {@link RayTraceResult} of the spell
     */
    protected void onImpact(RayTraceResult result)
    {
        // Do/Apply the spell.
        doSpell(this.getCaster(), result);

        // Spawn the impact particles.
        double motionX = rand.nextGaussian() * 0.02D;
        double motionY = rand.nextGaussian() * 0.02D;
        double motionZ = rand.nextGaussian() * 0.02D;

        if (this.getImpactParticle() != null)
        {
            if (result.typeOfHit == RayTraceResult.Type.ENTITY)
            {
                Entity entity = result.entityHit;

                for (int i = 0; i < 1; i++)
                {
                    for (int j = 0; j < 20; j++)
                    {
                        Archmage.proxy.spawnParticle(this.getImpactParticle(), entity.posX + rand.nextFloat() * entity.width * 2.0F - entity.width,
                                entity.posY + 0.5D + rand.nextFloat() * entity.height,
                                entity.posZ + rand.nextFloat() * entity.width * 2.0F - entity.width, motionX, motionY, motionZ);
                        motionX = rand.nextGaussian() * 0.02D;
                        motionY = rand.nextGaussian() * 0.02D;
                        motionZ = rand.nextGaussian() * 0.02D;
                    }
                }
            }

            if (result.typeOfHit == RayTraceResult.Type.BLOCK)
            {
                BlockPos blockHit = result.getBlockPos();
                blockHit = blockHit.offset(result.sideHit);

                for (int i = 0; i < 1; i++)
                {
                    for (int j = 0; j < 15; j++)
                    {
                        Archmage.proxy.spawnParticle(this.getImpactParticle(), posX, posY, posZ, motionX, motionY, motionZ);
                        motionX = rand.nextGaussian() * 0.04D;
                        motionY = rand.nextGaussian() * 0.04D;
                        motionZ = rand.nextGaussian() * 0.04D;
                    }
                }
            }
        }

        this.setDead();
    }

    /**
     * Get this spells caster. If null, the caster is offline so the spell will
     * die at {@link EntitySpellBase#onUpdate()}.
     * 
     * @return The caster
     */
    @Nullable
    public EntityLivingBase getCaster()
    {
        EntityLivingBase caster = this.casterRef == null ? null : this.casterRef.get();
        if (caster == null)
        {
            caster = this.world.getPlayerEntityByUUID(this.casterId);
            if (caster != null)
            {
                // cache for next time.
                this.casterRef = new WeakReference<EntityLivingBase>(caster);
            }
        }
        return caster;
    }

    /**
     * Get the spells travel speed.
     * 
     * @return
     */
    public abstract double getSpeed();

    /**
     * Get the spells travel particle.
     * 
     * @return
     */
    public abstract EnumParticles getTravelParticle();

    /**
     * Get the spells impact particle.
     * 
     * @return
     */
    public abstract EnumParticles getImpactParticle();

    /**
     * Get the max ticks the spell is allowed to exist.
     * 
     * @return
     */
    public abstract int getMaxTicksExisted();

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

    @Override
    public float getCollisionBorderSize()
    {
        return 1.0F;
    }

    @Override
    public float getBrightness(float partialTicks)
    {
        return 1.0F;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float partialTicks)
    {
        return 15728880;
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setString("caster_uuid", this.casterId.toString());
        compound.setTag("direction", this.newDoubleNBTList(new double[] { this.motionX, this.motionY, this.motionZ }));

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        this.casterId = UUID.fromString(compound.getString("caster_uuid"));

        if (compound.hasKey("direction", 9) && compound.getTagList("direction", 6).tagCount() == 3)
        {
            NBTTagList nbttaglist1 = compound.getTagList("direction", 6);
            this.motionX = nbttaglist1.getDoubleAt(0);
            this.motionY = nbttaglist1.getDoubleAt(1);
            this.motionZ = nbttaglist1.getDoubleAt(2);
        }
        else
        {
            this.setDead();
        }
    }

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        String uuid = this.casterId.toString();

        for (int i = 0; i < uuid.length(); i++)
        {
            buffer.writeChar(uuid.charAt(i));
        }
    }

    @Override
    public void readSpawnData(ByteBuf additionalData)
    {
        String uuid = new String();

        for (int i = 0; i < 36; i++)
        {
            uuid += Character.toString(additionalData.readChar());
        }

        this.casterId = UUID.fromString(uuid);
    }

    /**
     * Get the {@link ISpellData} capability stored in the spell.
     * 
     * @return {@link ISpellData} capability of the player
     */
    public ISpells getSpells()
    {
        return this.spells;
    }

    /**
     * Set the spell data from the casters {@link ISpellData} capability.
     * 
     * @param caster
     */
    public void setSpells(EntityLivingBase caster)
    {
        this.spells = caster.getCapability(SpellsProvider.SPELLS, null);
    }
}
