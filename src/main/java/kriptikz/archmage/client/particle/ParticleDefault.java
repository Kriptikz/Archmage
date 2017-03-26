package kriptikz.archmage.client.particle;

import kriptikz.archmage.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * A default particle for testing and missing particles.
 * 
 * @author kriptikz
 *
 */
public class ParticleDefault extends Particle
{
	private final ResourceLocation test = new ResourceLocation(Reference.MODID, "particle/default");
	//private final float iceScale;
	
	/**
	 * A test particle that all particles default to if missing.
	 * @param version
	 * @param worldIn
	 * @param xCoordIn
	 * @param yCoordIn
	 * @param zCoordIn
	 * @param xSpeedIn
	 * @param ySpeedIn
	 * @param zSpeedIn
	 */
	public ParticleDefault(int version, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn)
	{
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);

        this.motionX = this.motionX * 0.009999999776482582D + xSpeedIn;
        this.motionY = this.motionY * 0.009999999776482582D + ySpeedIn;
        this.motionZ = this.motionZ * 0.009999999776482582D + zSpeedIn;
        this.posX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.particleScale = this.particleScale * 0.5f;
        this.particleRed = 1.0F;
        this.particleGreen = 1.0F;
        this.particleBlue = 1.0F;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        
        TextureAtlasSprite texture = null;
        
        switch(version)
        {
			case 1:
				texture = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(test.toString());
				break;
			default:		
        }
        
        this.setParticleTexture(texture);
	}
	
	@Override
	public int getFXLayer()
	{
		return 1;
	}
}
