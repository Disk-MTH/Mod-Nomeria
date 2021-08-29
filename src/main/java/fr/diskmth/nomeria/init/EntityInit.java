package fr.diskmth.nomeria.init;

import fr.diskmth.nomeria.objects.entity.EntityPillerTNTPrimed;
import fr.diskmth.nomeria.utils.References;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
    public static void registerEntity()
    {
        EntityRegistry.registerModEntity(new ResourceLocation(References.MODID, "piller_tnt"), EntityPillerTNTPrimed.class, "entity_piller_tnt_primed", 0, References.MODID, 128, 1, true);
    }
}