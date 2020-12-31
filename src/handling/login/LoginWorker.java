/*
 * Decompiled with CFR 0.150.
 */
package handling.login;

import client.MapleClient;
import client.messages.commands.player.eventSystem.BankSystem;
import constants.GameSetConstants;
import constants.ServerConfig;
import constants.WorldConstants;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.world.World;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import server.MobSkillData;
import server.Timer;
import server.maps.MapleFoothold;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.packet.LoginPacket;

public class LoginWorker {
    private static /* synthetic */ long ALLATORIxDEMO;

    public static /* synthetic */ void registerClient(final MapleClient a2) {
        Object object;
        Iterator<Object> iterator;
        if (GameSetConstants.ADMIN_ONLY && !a2.isGm()) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.getPopupMsg(MapleFoothold.ALLATORIxDEMO("\u4f66\u675d\u5634\u76be\u5211\u6b33\u5774\u7dfd\u4fb2\u4e7dr]V\u76be\u5211\u7bf1\u745a\u54b1\u6b3f\u5778\u6e70\u8a36\u7235\u5491r]V\u8a9b\u7a51\u5fdc\u7b15\u5fd5\u7df1\u4fbe\u305e")));
            mapleClient.sendPacket(LoginPacket.getLoginFailed(7));
            return;
        }
        if (GameSetConstants.BLOCK_LOGGEDIN_CHECK) {
            MapleClient mapleClient = a2;
            if (ChannelServer.isBlockedLoggedIn(mapleClient, mapleClient.getAccID())) {
                MapleClient mapleClient2 = a2;
                mapleClient2.sendPacket(MaplePacketCreator.getPopupMsg(BankSystem.ALLATORIxDEMO("\u60db\u7501\u523e\u89a5\u8201\u72b7\u6138\u7699\u523e\u7156\u6ca6\u760c\u5116V")));
                mapleClient2.sendPacket(LoginPacket.getLoginFailed(7));
            }
        }
        if (!a2.isGm() && (a2.hasBannedMac() || a2.hasBannedIP()) || a2.isBanned()) {
            a2.sendPacket(LoginPacket.getLoginFailed(3));
            return;
        }
        ALLATORIxDEMO = System.currentTimeMillis();
        Map<Integer, Map<Integer, Integer>> map = ChannelServer.getChannelLoad();
        int n2 = 0;
        if (map == null || map.size() <= 0) {
            ALLATORIxDEMO = 0L;
            a2.sendPacket(LoginPacket.getLoginFailed(7));
            return;
        }
        int n3 = 0;
        Iterator<Map.Entry<Integer, Map<Integer, Integer>>> iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Iterator<Map.Entry<Integer, Integer>> iterator3 = iterator2.next().getValue().entrySet().iterator();
            while (iterator3.hasNext()) {
                ++n3;
                object = iterator.next();
                iterator3 = iterator;
            }
        }
        double d2 = 600.0 / ((double)WorldConstants.UserLimit / (double)n3);
        iterator = map.entrySet().iterator();
        Iterator<Object> iterator4 = iterator;
        while (iterator4.hasNext()) {
            object = iterator.next();
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            Iterator iterator5 = ((Map)object.getValue()).entrySet().iterator();
            while (iterator5.hasNext()) {
                Iterator iterator6;
                Map.Entry entry = iterator6.next();
                n2 += ((Integer)entry.getValue()).intValue();
                hashMap.put((Integer)entry.getKey(), Math.min(1200, (int)((double)((Integer)entry.getValue()).intValue() * d2)));
                iterator5 = iterator6;
            }
            map.put(object.getKey(), hashMap);
            iterator4 = iterator;
        }
        LoginServer.setLoad(map, n2);
        ALLATORIxDEMO = System.currentTimeMillis();
        if (a2.finishLogin() == 0) {
            MapleClient mapleClient;
            MapleClient mapleClient3 = a2;
            if (a2.getSecondPassword() == null) {
                mapleClient3.sendPacket(LoginPacket.getGenderNeeded(a2));
                mapleClient = a2;
            } else {
                World.clearChannelChangeDataByAccountId(mapleClient3.getAccID());
                MapleClient mapleClient4 = a2;
                LoginServer.forceRemoveClient(mapleClient4);
                ChannelServer.forceRemovePlayerByAccId(mapleClient4, mapleClient4.getAccID());
                ChannelServer.forceRemovePlayerByIPandMac(mapleClient4, mapleClient4.getSessionIPAddress(), a2.getClientMac());
                LoginServer.getClientStorage().registerAccount(a2);
                mapleClient4.sendPacket(LoginPacket.getAuthSuccessRequest(mapleClient4));
                iterator = LoginServer.getWorlds().iterator();
                Iterator<Object> iterator7 = iterator;
                while (iterator7.hasNext()) {
                    object = (World)iterator.next();
                    iterator7 = iterator;
                    a2.sendPacket(LoginPacket.getServerList(((World)object).getWorldId(), LoginPacket.Server.getById(((World)object).getWorldId()).toString(), ((World)object).getFlag(), ((World)object).getEventMessage(), ((World)object).getChannels()));
                }
                MapleClient mapleClient5 = a2;
                mapleClient = mapleClient5;
                mapleClient5.sendPacket(LoginPacket.getEndOfServerList());
                mapleClient5.sendPacket(LoginPacket.getWorldSelected(mapleClient5.getLastWorld()));
            }
            mapleClient.setIdleTask(Timer.PingTimer.getInstance().schedule(new Runnable(){
                {
                    1 a22;
                }

                @Override
                public /* synthetic */ void run() {
                    1 a22;
                    a22.a2.getSession().close();
                    if (ServerConfig.LOG_DC) {
                        FileoutputUtil.logToFile(MobSkillData.ALLATORIxDEMO("\fb\u0007~OI\u0001y\u0001\"$NNy\u0018y"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                    }
                }
            }, 6000000L));
            return;
        }
        a2.sendPacket(LoginPacket.getLoginFailed(7));
    }

    public /* synthetic */ LoginWorker() {
        LoginWorker a2;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = 0L;
    }
}

