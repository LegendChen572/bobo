/*
 * Decompiled with CFR 0.150.
 */
package handling.login;

import client.MapleClient;
import constants.GameSetConstants;
import constants.ServerConfig;
import constants.WorldConstants;
import handling.channel.ChannelServer;
import handling.login.AccountStorage;
import handling.mina.ServerConnection;
import handling.world.World;
import handling.world.sidekick.MapleSidekick;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import tools.Pair;
import tools.StringUtil;
import tools.packet.LoginPacket;
import tools.wztosql.DumpMobName;

public class LoginServer {
    private static final /* synthetic */ Map<Integer, Long> I;
    private static /* synthetic */ AccountStorage g;
    private static final /* synthetic */ Map<Integer, Byte> k;
    public static /* synthetic */ int port;
    private static final /* synthetic */ Map<Integer, Integer> C;
    private static final /* synthetic */ List<Map<Integer, String>> d;
    private static final /* synthetic */ Map<Integer, Long> J;
    private static /* synthetic */ LoginServer ALLATORIxDEMO;
    private static final /* synthetic */ Map<Integer, Long> F;
    private static final /* synthetic */ List<Integer> K;
    private static final /* synthetic */ List<World> a;
    private static /* synthetic */ ServerConnection B;
    private static /* synthetic */ int e;
    public static /* synthetic */ int totalChannelAmount;
    private static /* synthetic */ Map<Integer, Map<Integer, Integer>> H;
    private static /* synthetic */ boolean E;
    private static final /* synthetic */ Map<Integer, String> M;

    public static /* synthetic */ void addDoubleLoginTime(int a2) {
        if (!C.containsKey(a2)) {
            C.put(a2, 1);
            return;
        }
        C.put(a2, LoginServer.getDoubleLoginTime(a2) + 1);
    }

    public static final /* synthetic */ String getServerName() {
        return ServerConfig.SERVER_NAME;
    }

    public static /* synthetic */ void addLoginAgainTime(int a2) {
        I.put(a2, System.currentTimeMillis());
    }

    public static final /* synthetic */ void setOn() {
        E = false;
    }

    public static final /* synthetic */ void setup() {
        int n2;
        Object object;
        int[] arrn = new int[18];
        int[] arrn2 = new int[18];
        int[] arrn3 = new int[18];
        int[] arrn4 = new int[18];
        int[] arrn5 = new int[18];
        boolean[] arrbl = new boolean[18];
        int n3 = WorldConstants.UserLimit;
        String[] arrstring = new String[18];
        Iterator<Pair<Integer, Object>> iterator = WorldConstants.flags.iterator();
        Iterator<Pair<Integer, Object>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            object = iterator.next();
            arrn[((Integer)object.left).intValue()] = (Integer)((Pair)object).right;
            iterator2 = iterator;
        }
        iterator = WorldConstants.expRates.iterator();
        Iterator<Pair<Integer, Object>> iterator3 = iterator;
        while (iterator3.hasNext()) {
            object = iterator.next();
            arrn2[((Integer)object.left).intValue()] = (Integer)((Pair)object).right;
            iterator3 = iterator;
        }
        iterator = WorldConstants.mesoRates.iterator();
        Iterator<Pair<Integer, Object>> iterator4 = iterator;
        while (iterator4.hasNext()) {
            object = iterator.next();
            arrn3[((Integer)object.left).intValue()] = (Integer)((Pair)object).right;
            iterator4 = iterator;
        }
        iterator = WorldConstants.dropRates.iterator();
        Iterator<Pair<Integer, Object>> iterator5 = iterator;
        while (iterator5.hasNext()) {
            object = iterator.next();
            arrn4[((Integer)object.left).intValue()] = (Integer)((Pair)object).right;
            iterator5 = iterator;
        }
        iterator = WorldConstants.eventMessages.iterator();
        Iterator<Pair<Integer, Object>> iterator6 = iterator;
        while (iterator6.hasNext()) {
            object = iterator.next();
            arrstring[((Integer)object.left).intValue()] = (String)((Pair)object).right;
            iterator6 = iterator;
        }
        iterator = WorldConstants.chAmounts.iterator();
        Iterator<Pair<Integer, Object>> iterator7 = iterator;
        while (iterator7.hasNext()) {
            object = iterator.next();
            arrn5[((Integer)object.left).intValue()] = (Integer)((Pair)object).right;
            iterator7 = iterator;
        }
        iterator = WorldConstants.canCreates.iterator();
        Iterator<Pair<Integer, Object>> iterator8 = iterator;
        while (iterator8.hasNext()) {
            object = iterator.next();
            arrbl[((Integer)object.left).intValue()] = (Boolean)((Pair)object).right;
            iterator8 = iterator;
        }
        int n4 = n2 = 0;
        while (n4 < WorldConstants.Worlds) {
            int n5;
            int n6 = LoginServer.totalChannelAmount;
            int n7 = n2;
            object = new World(n7, arrn[n2], arrstring[n7], arrn2[n2], arrn3[n2], arrn4[n2], arrn5[n2], arrbl[n2]);
            a.add((World)object);
            d.add(new LinkedHashMap());
            int n8 = 0;
            int n9 = n8;
            while (n9 < ((World)object).getChAmount()) {
                ChannelServer channelServer;
                n5 = n8 + 1;
                ChannelServer channelServer2 = channelServer = ChannelServer.newInstance(n2, n5);
                ((World)object).addChannel(channelServer2);
                channelServer2.setup();
                d.get(n2).put(n5, channelServer.getIP());
                n9 = ++n8;
            }
            if (GameSetConstants.CASH_SHOP_SERVER) {
                ChannelServer channelServer;
                n8 = -10;
                ChannelServer channelServer3 = channelServer = ChannelServer.newInstance(n2, n8);
                ((World)object).addChannel(channelServer3);
                channelServer3.setup();
                d.get(n2).put(n8, channelServer.getIP());
            }
            if (GameSetConstants.AUCTION_SERVER) {
                ChannelServer channelServer;
                n8 = -20;
                ChannelServer channelServer4 = channelServer = ChannelServer.newInstance(n2, n8);
                ((World)object).addChannel(channelServer4);
                channelServer4.setup();
                d.get(n2).put(n8, channelServer.getIP());
            }
            int n10 = LoginServer.totalChannelAmount;
            String string = LoginPacket.Server.getById(((World)object).getWorldId()).toString();
            n5 = LoginServer.getInstance().getWorld(((World)object).getWorldId()).getChannels().size();
            int n11 = LoginServer.getInstance().getWorld(((World)object).getWorldId()).getExpRate();
            int n12 = LoginServer.getInstance().getWorld(((World)object).getWorldId()).getMesoRate();
            int n13 = LoginServer.getInstance().getWorld(((World)object).getWorldId()).getDropRate();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DumpMobName.ALLATORIxDEMO("\u4e03\u751c5j5"));
            stringBuilder.append(StringUtil.getRightPaddedStr(string, ' ', 8));
            stringBuilder.append(MapleSidekick.ALLATORIxDEMO("C\u984b\u9030\u6508CJ"));
            stringBuilder.append(n5);
            stringBuilder.append(DumpMobName.ALLATORIxDEMO("5\u7dc3\u9a42p/"));
            stringBuilder.append(n11);
            stringBuilder.append(MapleSidekick.ALLATORIxDEMO("P\u91b2\u9352CJ"));
            stringBuilder.append(n12);
            stringBuilder.append(DumpMobName.ALLATORIxDEMO("5\u63d9\u8428p/"));
            stringBuilder.append(n13);
            stringBuilder.append(MapleSidekick.ALLATORIxDEMO("P\u7a8c\u5393CJ"));
            stringBuilder.append(n6);
            stringBuilder.append(DumpMobName.ALLATORIxDEMO("5.5"));
            stringBuilder.append(n10 - 1);
            System.out.println(stringBuilder.toString());
            n4 = ++n2;
        }
        port = (short)GameSetConstants.LOGIN_PORT;
        B = new ServerConnection(port, false ? 1 : 0, false ? 1 : 0, false);
        B.run();
        System.out.println("\n\u3010\u767b\u5165\u4f3a\u670d\u5668\u3011  - \u76e3\u807d\u7aef\u53e3: " + port + " \n");
    }

    public static /* synthetic */ boolean addFairy(byte a2, int a32) {
        try {
            k.put(a32, a2);
        }
        catch (Exception a32) {
            // empty catch block
        }
        return true;
    }

    public static /* synthetic */ boolean CanLoginKey(MapleClient a2, String a3) {
        return M.get(a2.getAccID()) == null || M.containsValue(a3) && M.get(a2.getAccID()).equals(a3);
    }

    public static /* synthetic */ long getLoginAgainTime(int a2) {
        return I.get(a2);
    }

    public static /* synthetic */ boolean removeLoginKey(MapleClient a2) {
        M.remove(a2.getAccID());
        return true;
    }

    public /* synthetic */ World getWorld(int a2) {
        return a.get(a2);
    }

    public static /* synthetic */ {
        J = new WeakHashMap<Integer, Long>();
        M = new HashMap<Integer, String>();
        I = new HashMap<Integer, Long>();
        F = new HashMap<Integer, Long>();
        C = new HashMap<Integer, Integer>();
        H = new HashMap<Integer, Map<Integer, Integer>>();
        e = 0;
        port = 8484;
        totalChannelAmount = GameSetConstants.DEFAULT_PORT;
        E = true;
        k = new HashMap<Integer, Byte>();
        K = new ArrayList<Integer>();
        a = new ArrayList<World>();
        d = new LinkedList<Map<Integer, String>>();
        ALLATORIxDEMO = null;
    }

    public static /* synthetic */ boolean canEnterGameAgain(int a2) {
        long l2 = System.currentTimeMillis();
        return !F.containsKey(a2) || F.get(a2) + 60000L <= l2;
    }

    public static /* synthetic */ boolean canLoginAgain(int a2) {
        long l2 = System.currentTimeMillis();
        return !I.containsKey(a2) || I.get(a2) + 40000L <= l2;
    }

    public static final /* synthetic */ boolean isShutdown() {
        return E;
    }

    public static /* synthetic */ void RemoveClientByAccName(String a2) {
        for (MapleClient mapleClient : LoginServer.getClientStorage().getAllClientsThreadSafe()) {
            if (mapleClient == null || !mapleClient.getAccountName().equals(a2)) continue;
            MapleClient mapleClient2 = mapleClient;
            mapleClient2.unLockDisconnect();
            LoginServer.removeClient(mapleClient2);
        }
    }

    public static /* synthetic */ void forceRemoveClient(MapleClient a2) {
        LoginServer.forceRemoveClient(a2, true);
    }

    public static /* synthetic */ boolean CanFairy(int a2) {
        return k.get(a2) == null;
    }

    public static final /* synthetic */ void addClient(MapleClient a2) {
        LoginServer.getClientStorage().registerAccount(a2);
    }

    public static final /* synthetic */ void shutdown() {
        if (E) {
            System.out.println(MapleSidekick.ALLATORIxDEMO("\u3060\u7618\u5115\u4f59\u677d\u560b\u3061C\u5d82\u7df0\u95ac\u95ea\u4ef6M^M\u7151\u6cb6\u5787\u882f\u6b14\u52b6\u4f2c"));
            return;
        }
        System.out.println(DumpMobName.ALLATORIxDEMO("\u3040\u766e\u5135\u4f2f\u675d\u567d\u30415\u958c\u959c\u4e7d;~;"));
        B.close();
        System.out.println(MapleSidekick.ALLATORIxDEMO("\u3060\u7618\u5115\u4f59\u677d\u560b\u3061C\u95ac\u95ea\u5bfc\u7501^M^"));
        E = true;
    }

    public static final /* synthetic */ int getUsersOn() {
        return e;
    }

    public /* synthetic */ ChannelServer getChannel(int a2, int a3) {
        if (a2 < 0) {
            return null;
        }
        return a.get(a2).getChannel(a3);
    }

    public static /* synthetic */ int getDoubleLoginTime(int a2) {
        if (!C.containsKey(a2)) {
            return 0;
        }
        return C.get(a2);
    }

    public static /* synthetic */ boolean doubleLogin(MapleClient a2) {
        for (MapleClient mapleClient : LoginServer.getClientStorage().getAllClientsThreadSafe()) {
            if (mapleClient == null || a2.getAccID() != mapleClient.getAccID()) continue;
            return true;
        }
        return false;
    }

    public static final /* synthetic */ void removeChannels(int a2) {
        if (H.containsKey(a2)) {
            H.get(a2).clear();
        }
        d.clear();
    }

    public static /* synthetic */ long getEnterGameAgainTime(int a2) {
        return F.get(a2);
    }

    public static /* synthetic */ void forceRemoveClient(MapleClient a2, boolean a3) {
        Iterator iterator = LoginServer.getClientStorage().getAllClientsThreadSafe().iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                MapleClient mapleClient = (MapleClient)iterator.next();
                if (mapleClient == null) {
                    iterator2 = iterator;
                    continue;
                }
                if (mapleClient.getAccID() != a2.getAccID() && mapleClient != a2) continue block0;
                if (mapleClient != a2) {
                    mapleClient.unLockDisconnect();
                }
                if (!a3) continue block0;
                LoginServer.removeClient(mapleClient);
                continue block0;
            }
            break;
        }
    }

    public static /* synthetic */ void setLoad(Map<Integer, Map<Integer, Integer>> a2, int a3) {
        H = a2;
        e = a3;
    }

    public static /* synthetic */ AccountStorage getClientStorage() {
        if (g == null) {
            g = new AccountStorage();
        }
        return g;
    }

    public static /* synthetic */ boolean addLoginKey(MapleClient a2, String a3) {
        M.put(a2.getAccID(), a3);
        return true;
    }

    public static final /* synthetic */ void addChannel(int a2, int a3) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(a3, 1);
        H.put(a2, hashMap);
    }

    public static /* synthetic */ List<World> getWorlds() {
        return a;
    }

    public static /* synthetic */ boolean CheckSelectChar(int a2) {
        long l2 = System.currentTimeMillis();
        if (J.containsKey(a2)) {
            if (J.get(a2) + 3000L > l2) {
                return false;
            }
            J.remove(a2);
        } else {
            J.put(a2, l2);
        }
        return true;
    }

    public /* synthetic */ LoginServer() {
        LoginServer a2;
    }

    public static /* synthetic */ void addEnterGameAgainTime(int a2) {
        F.put(a2, System.currentTimeMillis());
    }

    public static /* synthetic */ String getLoginKey(MapleClient a2) {
        return M.get(a2.getAccID());
    }

    public static /* synthetic */ int getClientCount(MapleClient a2) {
        int n2 = 0;
        Iterator iterator = LoginServer.getClientStorage().getAllClientsThreadSafe().iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                MapleClient mapleClient = (MapleClient)iterator.next();
                if (mapleClient == null) {
                    iterator2 = iterator;
                    continue;
                }
                if (mapleClient.getAccID() != a2.getAccID() && mapleClient != a2 || mapleClient == a2) continue block0;
                ++n2;
                mapleClient.unLockDisconnect();
                continue block0;
            }
            break;
        }
        return n2;
    }

    public static /* synthetic */ void forceRemoveClientByIPandMAC(MapleClient a2, String a3, String a4) {
        for (MapleClient mapleClient : LoginServer.getClientStorage().getAllClientsThreadSafe()) {
            boolean bl;
            if (mapleClient == null) continue;
            boolean bl2 = bl = mapleClient.getSessionIPAddress().equalsIgnoreCase(a3) && mapleClient.getClientMac().equalsIgnoreCase(a4);
            if (mapleClient.getAccID() != a2.getAccID() && mapleClient != a2 && !bl) continue;
            if (mapleClient != a2 || bl) {
                mapleClient.unLockDisconnect();
            }
            LoginServer.removeClient(mapleClient);
        }
    }

    public static /* synthetic */ void setAutoReg(boolean a2) {
        ServerConfig.AUTO_REGISTER = a2;
    }

    public static final /* synthetic */ void removeClient(MapleClient a2) {
        LoginServer.getClientStorage().deregisterAccount(a2);
    }

    public static /* synthetic */ LoginServer getInstance() {
        if (ALLATORIxDEMO == null) {
            ALLATORIxDEMO = new LoginServer();
        }
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ void addChannelAmount() {
        ++totalChannelAmount;
    }

    public static final /* synthetic */ Map<Integer, Map<Integer, Integer>> getLoad() {
        return H;
    }

    public static /* synthetic */ World getWorldStatic(int a2) {
        return a.get(a2);
    }

    public static /* synthetic */ byte getFairy(int a2) {
        if (k.containsKey(a2)) {
            return k.get(a2);
        }
        return 0;
    }

    public static /* synthetic */ boolean containClient(MapleClient a2) {
        for (MapleClient mapleClient : LoginServer.getClientStorage().getAllClientsThreadSafe()) {
            if (mapleClient == null || a2 != mapleClient) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean getAutoReg() {
        return ServerConfig.AUTO_REGISTER;
    }
}

