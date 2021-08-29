package fr.diskmth.nomeria.init;

import fr.diskmth.nomeria.client.render.RenderPillerTNTPrimed;
import fr.diskmth.nomeria.objects.entity.EntityPillerTNTPrimed;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RendersInit
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void registerRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityPillerTNTPrimed.class, new IRenderFactory()
        {
            public Render<? super EntityPillerTNTPrimed> createRenderFor(RenderManager manager)
            {
                return new RenderPillerTNTPrimed(manager);
            }
        });
    }
}