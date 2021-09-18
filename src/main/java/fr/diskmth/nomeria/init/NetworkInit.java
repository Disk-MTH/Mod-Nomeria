package fr.diskmth.nomeria.init;

import fr.diskmth.nomeria.network.CancelIsBlockingPacket;
import fr.diskmth.nomeria.network.SetIsBlockingPacket;
import fr.diskmth.nomeria.utils.References;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkInit
{
    public static SimpleNetworkWrapper NETWORK;

    public static void registerNetwork()
    {
        NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(References.MODID);

        NETWORK.registerMessage(SetIsBlockingPacket.Handler.class, SetIsBlockingPacket.class, 0, Side.SERVER);
        NETWORK.registerMessage(CancelIsBlockingPacket.Handler.class, CancelIsBlockingPacket.class, 1, Side.SERVER);
    }
}