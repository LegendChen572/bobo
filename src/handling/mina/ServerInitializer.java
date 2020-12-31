/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelInitializer
 *  io.netty.channel.socket.SocketChannel
 *  io.netty.handler.timeout.IdleStateHandler
 */
package handling.mina;

import constants.GameSetConstants;
import handling.MapleServerHandler;
import handling.mina.MaplePacketDecoder;
import handling.mina.MaplePacketEncoder;
import handling.world.MaplePartyCharacter;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;
import server.maps.MapNameData;

public class ServerInitializer
extends ChannelInitializer<SocketChannel> {
    private /* synthetic */ int d;
    private /* synthetic */ int a;
    private /* synthetic */ boolean ALLATORIxDEMO;

    public /* synthetic */ void initChannel(SocketChannel a2) throws Exception {
        ServerInitializer a3;
        a2 = a2.pipeline();
        if (GameSetConstants.PING_HANDLER) {
            ChannelHandler[] arrchannelHandler = new ChannelHandler[1];
            arrchannelHandler[0] = new IdleStateHandler(5L, 0L, 0L, TimeUnit.SECONDS);
            a2.addLast(arrchannelHandler);
        }
        a2.addLast(MapNameData.ALLATORIxDEMO("!u&\u007f!u7"), (ChannelHandler)new MaplePacketDecoder());
        a2.addLast(MaplePartyCharacter.ALLATORIxDEMO("cPeQb[t"), (ChannelHandler)new MaplePacketEncoder());
        ServerInitializer serverInitializer = a3;
        a2.addLast(MapNameData.ALLATORIxDEMO("-q+t)u7"), (ChannelHandler)new MapleServerHandler(serverInitializer.a, serverInitializer.d, a3.ALLATORIxDEMO));
    }

    public /* synthetic */ ServerInitializer(int a2, int a3, boolean a4) {
        ServerInitializer a5;
        ServerInitializer serverInitializer = a5;
        a5.a = a2;
        serverInitializer.d = a3;
        serverInitializer.ALLATORIxDEMO = a4;
    }
}

