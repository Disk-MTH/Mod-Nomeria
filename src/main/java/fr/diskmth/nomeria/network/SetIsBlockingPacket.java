package fr.diskmth.nomeria.network;

import fr.diskmth.nomeria.utils.handlers.EventHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SetIsBlockingPacket implements IMessage
{
    private String isBlocking;

    public SetIsBlockingPacket()
    {
    }

    public SetIsBlockingPacket(String text)
    {
        this.isBlocking = text;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        isBlocking = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, isBlocking);
    }

    public static class Handler implements IMessageHandler<SetIsBlockingPacket, IMessage>
    {
        @Override
        public IMessage onMessage(SetIsBlockingPacket message, MessageContext ctx)
        {
            EventHandler.isBlocking = true;
            return null;
        }
    }
}