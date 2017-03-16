package kriptikz.archmage.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.base.Optional;

import io.netty.buffer.ByteBuf;
import kriptikz.archmage.capability.spelldata.ISpellData;
import kriptikz.archmage.capability.spelldata.SpellDataProvider;
import kriptikz.archmage.spell.ISpellBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
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
	/**
	 * The spell caster's UUID.
	 */
	private static final DataParameter<Optional<UUID>> CASTER_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(EntitySpellBase.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	
	/**
	 * The {@link EntityLivingBase} that cast the spell.
	 */
	private EntityLivingBase caster;
	
	/**
	 * The caster's {@link ISpellData} capability.
	 */
	private ISpellData spellData;
	
	/**
	 * The speed the spell will travel.
	 */
	private double speed;
	
	/**
	 * The spells travel particles.
	 */
	private EnumParticleTypes[] travelParticles;

	/**
	 * The spells impact particles.
	 */
	private EnumParticleTypes[] impactParticles;
	
	/**
	 * The max ticks the spell can be alive for.
	 */
	private int maxTicksExisted;
	
	/**
	 * Ticks the spell has been in the air for.
	 */
	private int ticksInAir;

	public EntitySpellBase(World worldIn)
	{
		super(worldIn);	
		this.setSize(1.0f, 1.0f);
	}
	
	public EntitySpellBase(World world, EntityLivingBase caster)
	{
		this(world);
		
		this.caster = caster;
		this.setCasterId(caster.getUniqueID());
		this.setSpellData(caster);
		this.speed = getSpeed();
		this.maxTicksExisted = getMaxTicksExisted();
		this.travelParticles = getTravelParticles();
		this.impactParticles = getImpactParticles();
		this.setPositionAndDirection(caster);
	}
	
	@Override
	public void entityInit()
	{
		this.dataManager.register(CASTER_UNIQUE_ID, Optional.<UUID>absent());
	}

	@Override
	public boolean isProjectile()
	{
		return true;
	}
	
	/**
	 * Set the position and direction for the entity, called in constructor of entity.
	 * 
	 * @param caster
	 */
	public void setPositionAndDirection(EntityLivingBase caster)
	{	
		this.setPosition(caster.posX, caster.posY + caster.getEyeHeight() - 0.10000000149011612D, caster.posZ);
		
		Vec3d look = this.caster.getLookVec();
		
		this.motionX = look.xCoord * this.speed;
		this.motionY = look.yCoord * this.speed;
		this.motionZ = look.zCoord * this.speed;
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
    	this.caster = this.getCaster();
    	setSpellData(caster);
    	
    	if ((this.caster == null || !this.caster.isDead) || this.world.isRemote && this.world.isBlockLoaded(new BlockPos(this)))
        {
            super.onUpdate();

            ++this.ticksInAir;
            
            if (this.ticksExisted >= this.maxTicksExisted)
            {
            	this.setDead();
            }

            RayTraceResult raytraceresult = ProjectileHelper.forwardsRaycast(this, true, this.ticksInAir >= 25, this.caster);

            if (raytraceresult != null && !(raytraceresult.entityHit instanceof EntityPlayer))
            {
            	//if (world.isRemote)
            		System.out.println("***********HIT***************");
            	System.out.println("Caster: " + this.caster);
                this.onImpact(raytraceresult);
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            
            
            if (this.travelParticles != null)
            {
            	for (int i = 0; i < travelParticles.length; i++)
            	{
            		for (int j = 0; j < 1; j++)
            		{
            			if (world.isRemote)
            			this.world.spawnParticle(travelParticles[i], this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
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
     * @param result {@link RayTraceResult} of the spell
     */
    protected void onImpact(RayTraceResult result)
    {
    	// Do/Apply the spell.
    	doSpell(this.caster, result);
    	
    	// Spawn the impact particles.
        double motionX = rand.nextGaussian() * 0.02D;
        double motionY = rand.nextGaussian() * 0.02D;
        double motionZ = rand.nextGaussian() * 0.02D;
  
        
        if (impactParticles != null)
        {
			if (result.typeOfHit == RayTraceResult.Type.ENTITY)
			{
				Entity entity = result.entityHit;
				
	        	for (int i = 0; i < impactParticles.length; i++)
	        	{
	        		for (int j = 0; j < 20; j++)
	        		{
						this.world.spawnParticle(impactParticles[i],
								entity.posX + rand.nextFloat() * entity.width * 2.0F - entity.width,
								entity.posY + 0.5D + rand.nextFloat() * entity.height,
								entity.posZ + rand.nextFloat() * entity.width * 2.0F - entity.width, motionX, motionY,
								motionZ, new int[0]);
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
				
	        	for (int i = 0; i < impactParticles.length; i++)
	        	{
	        		for (int j = 0; j < 20; j++)
	        		{
						this.world.spawnParticle(impactParticles[i], posX, posY, posZ, motionX, motionY, motionZ,
								new int[0]);
						motionX = rand.nextGaussian() * 0.02D;
						motionY = rand.nextGaussian() * 0.02D;
						motionZ = rand.nextGaussian() * 0.02D;
	        		}
	        	}
			}
        }
        
        this.setDead();
    }
    
    /**
     * Get the spells travel speed.
     * 
     * @return
     */
	public abstract double getSpeed();
	
	/**
	 * Get the spells travel particles.
	 * 
	 * @return
	 */
	public abstract EnumParticleTypes[] getTravelParticles();

	/**
	 * Get the spells impact particles.
	 * 
	 * @return
	 */
	public abstract EnumParticleTypes[] getImpactParticles();
	
	/**
	 * Get the max ticks the spell is allowed to exist.
	 * 
	 * @return
	 */
	public abstract int getMaxTicksExisted();
    
    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
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

    /**
     * Gets how bright this entity is.
     */
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
		compound.setTag("direction", this.newDoubleNBTList(new double[] {this.motionX, this.motionY, this.motionZ}));
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound)
	{
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
		String uuid = this.getCasterId().toString();
		
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
		
		this.setCasterId(UUID.fromString(uuid));
	}

	/**
	 * Get this spells caster.
	 * 
	 * @return The caster
	 */
    public EntityLivingBase getCaster()
    {
            return this.world.getPlayerEntityByUUID(this.getCasterId());
    }
	
    /**
     * Store the casters UUID in the spell.
     * 
     * @param uuid The casters {@link UUID}
     */
    public void setCasterId(@Nullable UUID uuid)
    {
        this.dataManager.set(CASTER_UNIQUE_ID, Optional.fromNullable(uuid));
    }
    
    /**
     * Get the spell casters UUID.
     * 
     * @return {@link UUID} of the caster
     */
    public UUID getCasterId()
    {
        return (UUID)((Optional<UUID>)this.dataManager.get(CASTER_UNIQUE_ID)).orNull();
    }

    /**
     * Get the {@link ISpellData} capability stored in the spell.
     * 
     * @return {@link ISpellData} capability of the player
     */
	public ISpellData getSpellData()
	{
		return spellData;
	}

	/**
	 * Set the spell data from the casters {@link ISpellData} capability.
	 * @param caster
	 */
	public void setSpellData(EntityLivingBase caster)
	{
		this.spellData = caster.getCapability(SpellDataProvider.SPELL_DATA, null);
	}
}
