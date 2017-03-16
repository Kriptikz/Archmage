package kriptikz.archmage.client.render;

import kriptikz.archmage.Reference;
import kriptikz.archmage.spell.SpellFireball;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFireball extends Render<SpellFireball>
{
	private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/projectiles/fireball.png");
	public static final RenderFactory FACTORY = new RenderFactory();

	protected RenderFireball(RenderManager renderManager)
	{
		super(renderManager);
	}

	@Override
	public void doRender(SpellFireball entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		//this.bindTexture(texture);
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
