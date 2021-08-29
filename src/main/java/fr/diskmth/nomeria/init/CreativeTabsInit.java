package fr.diskmth.nomeria.init;

import fr.diskmth.nomeria.objects.creativetabs.NomeriaTab1;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsInit
{
    public static CreativeTabs NOMERIA_TAB_1;

    public static void registerCreativetabs()
    {
        NOMERIA_TAB_1 = new NomeriaTab1("nomeria_tab_1");
    }
}