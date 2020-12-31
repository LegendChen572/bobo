/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.bootstrap.ServerBootstrap
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelOption
 *  io.netty.channel.EventLoopGroup
 *  io.netty.channel.nio.NioEventLoopGroup
 *  io.netty.channel.socket.nio.NioServerSocketChannel
 */
package handling.mina;

import client.MapleDiseaseValueHolder;
import constants.WorldConstants;
import handling.mina.ServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerConnection {
    private final /* synthetic */ EventLoopGroup d;
    private /* synthetic */ boolean k;
    private /* synthetic */ int B;
    private final /* synthetic */ EventLoopGroup a;
    private /* synthetic */ int g;
    private /* synthetic */ ServerBootstrap K;
    private /* synthetic */ Channel ALLATORIxDEMO;
    private final /* synthetic */ int E;

    public /* synthetic */ void run() {
        ServerConnection a2;
        ServerConnection serverConnection = a2;
        ServerConnection serverConnection2 = a2;
        a2.K = ((ServerBootstrap)((ServerBootstrap)new ServerBootstrap().group(serverConnection.a, serverConnection.d).channel(NioServerSocketChannel.class)).option(ChannelOption.SO_BACKLOG, (Object)WorldConstants.USER_LIMIT)).childOption(ChannelOption.TCP_NODELAY, (Object)true).childOption(ChannelOption.SO_KEEPALIVE, (Object)true).childHandler((ChannelHandler)new ServerInitializer(serverConnection2.g, serverConnection2.B, a2.k));
        try {
            ServerConnection serverConnection3 = a2;
            serverConnection3.ALLATORIxDEMO = serverConnection3.K.bind(serverConnection3.E).sync().channel().closeFuture().channel();
            return;
        }
        catch (InterruptedException interruptedException) {
            try {
                interruptedException.printStackTrace();
                return;
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Exception exception) {
                    Object[] arrobject = new Object[1];
                    arrobject[0] = a2.ALLATORIxDEMO == null ? exception.toString() : a2.ALLATORIxDEMO.remoteAddress();
                    System.out.printf(MapleDiseaseValueHolder.ALLATORIxDEMO("`\u0018M\u0019F\u0014W\u001eL\u0019\u0003\u0003LW\u0006\u0004\u0003\u0011B\u001eO\u0012GY"), arrobject);
                    a2.close();
                    return;
                }
            }
        }
    }

    public /* synthetic */ void close() {
        ServerConnection a2;
        if (a2.ALLATORIxDEMO != null) {
            a2.ALLATORIxDEMO.close();
        }
        a2.a.shutdownGracefully();
        a2.d.shutdownGracefully();
    }

    public /* synthetic */ ServerConnection(int a2, int a3, int a4, boolean a5) {
        ServerConnection a6;
        ServerConnection serverConnection = a6;
        ServerConnection serverConnection2 = a6;
        ServerConnection serverConnection3 = a6;
        serverConnection3.g = -1;
        serverConnection3.B = -1;
        ServerConnection serverConnection4 = a6;
        serverConnection3.a = new NioEventLoopGroup(1);
        serverConnection4.d = new NioEventLoopGroup();
        serverConnection2.E = a2;
        serverConnection2.g = a3;
        serverConnection.B = a4;
        serverConnection.k = a5;
    }

    public /* synthetic */ ServerConnection(String a2, int a3) {
        ServerConnection a4;
        ServerConnection serverConnection = a4;
        ServerConnection serverConnection2 = a4;
        serverConnection2.g = -1;
        serverConnection2.B = -1;
        ServerConnection serverConnection3 = a4;
        serverConnection.a = new NioEventLoopGroup(1);
        serverConnection.d = new NioEventLoopGroup();
        serverConnection.E = a3;
    }
}

