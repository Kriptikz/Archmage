package kriptikz.archmage.client.render;

import kriptikz.archmage.Reference;
import kriptikz.archmage.spell.SpellFireball;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Render for Fireball entity.
 * 
 * @author kriptikz
 *
 */
public class RenderFireball extends Render<SpellFireball>
{
	private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/projectiles/fireball.png");
	public static final RenderFactory FACTORY = new RenderFactory();
	private final float scale = 0.5f;

	protected RenderFireball(RenderManager renderManager)
	{
		super(renderManager);
	}

	@Override
	public void doRender(SpellFireball entity, double x, double y, double z, float entityYaw, float partialTicks)
	{	
        GlStateManager.pushMatrix();
        this.bindEntityTexture(entity);
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(this.scale, this.scale, this.scale);
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * -this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        vertexbuffer.pos(-0.5D, -0.5D, 0.0D).tex((double)0, (double)1).normal(0.0F, 1.0F, 0.0F).endVertex();
        vertexbuffer.pos(0.5D, -0.5D, 0.0D).tex((double)1, (double)1).normal(0.0F, 1.0F, 0.0F).endVertex();
        vertexbuffer.pos(0.5D, 0.5D, 0.0D).tex((double)1, (double)0).normal(0.0F, 1.0F, 0.0F).endVertex();
        vertexbuffer.pos(-0.5D, 0.5D, 0.0D).tex((double)0, (double)0).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.draw();

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
	}



	@Override
	protected ResourceLocation getEntityTexture(SpellFireball entity)
	{
		return texture;
	}

	public static class RenderFactory implements IRenderFactory<SpellFireball>
	{
		@Override
		public Render<? super SpellFireball> createRenderFor(RenderManager manager)
		{
			return new RenderFireball(manager);
		}
		
	}
}
