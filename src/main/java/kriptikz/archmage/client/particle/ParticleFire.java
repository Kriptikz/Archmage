package kriptikz.archmage.client.particle;

import kriptikz.archmage.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Custom fire particle for Archmage mod.
 * 
 * @author kriptikz
 *
 */
public class ParticleFire extends Particle
{
	private final ResourceLocation fire = new ResourceLocation(Reference.MODID, "particle/fire");
	private final float fireScale;
	
	public ParticleFire(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn)
	{
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);

        this.motionX = this.motionX * 0.009999999776482582D + xSpeedIn;
        this.motionY = this.motionY * 0.009999999776482582D + ySpeedIn;
        this.motionZ = this.motionZ * 0.009999999776482582D + zSpeedIn;
        this.posX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.particleScale = this.particleScale * 0.5f;
        this.fireScale = this.particleScale;
        this.particleRed = 1.0F;
        this.particleGreen = 1.0F;
        this.particleBlue = 1.0F;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        
        this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fire.toString()));
	}
	
	@Override
    public void renderParticle(VertexBuffer buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge;
        this.particleScale = this.fireScale * (1.0F - f * f * 0.5F);
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
	
	@Override
	public int getFXLayer()
	{
		return 1;
	}
}
