/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.group.ChannelGroup
 *  io.netty.channel.group.DefaultChannelGroup
 *  io.netty.util.concurrent.EventExecutor
 *  io.netty.util.concurrent.GlobalEventExecutor
 */
package handling;

import client.MapleClient;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.channel.handler.NPCHandler;
import handling.login.LoginServer;
import handling.world.World;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.Iterator;
import tools.FileoutputUtil;
import tools.MaplePacketOperation;

public class ClientChannelGroup {
    private static final /* synthetic */ ChannelGroup ALLATORIxDEMO;

    public static /* synthetic */ void DcChannelByIp(String a2) {
        for (Channel channel : ALLATORIxDEMO) {
            if (!channel.remoteAddress().toString().split(MaplePacketOperation.ALLATORIxDEMO("\u007f"))[0].equals(a2)) continue;
            Channel channel2 = channel;
            ClientChannelGroup.clearMapleClient(channel2);
            channel2.close();
            FileoutputUtil.logToFile(NPCHandler.ALLATORIxDEMO("o\bd\u0014,.S\u9044\u7dd9\u6b46\u657b\u9029\u5919Iw\u001fw"), "\r\n" + a2, false);
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new DefaultChannelGroup((EventExecutor)GlobalEventExecutor.INSTANCE);
    }

    public static /* synthetic */ ChannelGroup getChannels() {
        return ALLATORIxDEMO;
    }

    public /* synthetic */ ClientChannelGroup() {
        ClientChannelGroup a2;
    }

    public static /* synthetic */ void CheckChannel(Channel a2) {
        String string;
        if (!GameSetConstants.PROXY_IP && !GameSetConstants.FOWARD_PROTECT && a2 != null && ClientChannelGroup.getChannelCountByIp(string = a2.remoteAddress().toString().split(NPCHandler.ALLATORIxDEMO("9"))[0]) > GameSetConstants.IP_CHANNEL_LIMIT) {
            ClientChannelGroup.DcChannelByIp(string);
        }
    }

    public static /* synthetic */ void clearMapleClient(Channel a2) {
        MapleClient mapleClient;
        block5: {
            MapleClient mapleClient2;
            block8: {
                block7: {
                    block6: {
                        mapleClient = (MapleClient)a2.attr(MapleClient.CLIENT_KEY).get();
                        if (mapleClient == null) break block5;
                        if (mapleClient.getPlayer() == null) break block6;
                        mapleClient.getPlayer().saveToDB(true, mapleClient.getChannel() == -10);
                        if (mapleClient.getLoginState() == 4 || mapleClient.getLoginState() == 9 || mapleClient.getLoginState() == 7 || mapleClient.getLoginState() == 10 || mapleClient.getLoginState() == 6 || mapleClient.getLoginState() == 1 || mapleClient.getPlayer() == null) break block7;
                        MapleClient mapleClient3 = mapleClient;
                        int n2 = World.Find.findChannel(mapleClient3.getPlayer().getId());
                        int n3 = World.Find.findWorld(mapleClient3.getPlayer().getId());
                        try {
                            if (ChannelServer.getInstance(n3, n2) != null) {
                                ChannelServer.getInstance(n3, n2).removePlayer(mapleClient.getPlayer());
                            }
                        }
                        catch (Exception exception) {
                            System.out.println(exception);
                        }
                        MapleClient mapleClient4 = mapleClient;
                        mapleClient2 = mapleClient4;
                        mapleClient4.disconnect();
                        break block8;
                    }
                    mapleClient.getSession().close();
                }
                mapleClient2 = mapleClient;
            }
            if (mapleClient2.getChannel() == 0) {
                MapleClient mapleClient5 = mapleClient;
                mapleClient5.setCanloginpw(false);
                LoginServer.removeClient(mapleClient5);
            }
        }
        if (mapleClient != null) {
            a2.attr(MapleClient.CLIENT_KEY).remove();
        }
    }

    public static /* synthetic */ int getChannelCountByIp(String a2) {
        Iterator iterator = ALLATORIxDEMO.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            if (!((Channel)iterator.next()).remoteAddress().toString().split(MaplePacketOperation.ALLATORIxDEMO("\u007f"))[0].equals(a2)) continue;
            ++n2;
        }
        return n2;
    }

    public static /* synthetic */ void DcChannelByIp_CF(String a2) {
        for (Channel channel : ALLATORIxDEMO) {
            Object object = channel.remoteAddress().toString().split(MaplePacketOperation.ALLATORIxDEMO("\u007f"))[0];
            object = (MapleClient)channel.attr(MapleClient.CLIENT_KEY).get();
            if (object == null || ((MapleClient)object).getPlayer() != null || !((MapleClient)object).getDecodeProxyIP().contains(a2)) continue;
            ((MapleClient)object).getSession().close();
            FileoutputUtil.logToFile(NPCHandler.ALLATORIxDEMO("o\bd\u0014,.S\u9044\u7dd9\u655c\u64c9\u818d\u52d6\u5260\u9667\u9044\u7dd9Iw\u001fw"), "\r\n" + a2, false);
        }
    }
}

