/*
 * Decompiled with CFR 0.150.
 */
package handling.channel;

import client.MapleCharacter;
import client.MapleClient;
import constants.GameSetConstants;
import constants.ServerConfig;
import constants.WorldConstants;
import handling.channel.PlayerStorage;
import handling.login.LoginServer;
import handling.mina.ServerConnection;
import handling.world.CheaterData;
import handling.world.World;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lottery.AutoEventManager;
import scripting.event.EventScriptManager;
import server.Framework.MapleExtendedSlots;
import server.MapleShopItem;
import server.MapleSquad;
import server.ServerProperties;
import server.Timer;
import server.events.MapleCoconut;
import server.events.MapleEvent;
import server.events.MapleEventType;
import server.events.MapleFitness;
import server.events.MapleJewel;
import server.events.MapleOla;
import server.events.MapleOxQuiz;
import server.events.MapleSnowball;
import server.life.PlayerNPC;
import server.maps.MapleMap;
import server.maps.MapleMapFactory;
import server.maps.MapleMapObject;
import server.shops.HiredFishing;
import server.shops.HiredMerchant;
import server.shops.MaplePlayerShop;
import tools.CollectionUtil;
import tools.ConcurrentEnumMap;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;

public class ChannelServer
implements Serializable {
    private /* synthetic */ PlayerStorage m;
    private final /* synthetic */ Map<Integer, MaplePlayerShop> J;
    private /* synthetic */ boolean c;
    private final /* synthetic */ ReentrantReadWriteLock I;
    private /* synthetic */ int d;
    private final /* synthetic */ Map<Integer, HiredMerchant> j;
    private /* synthetic */ int B;
    private final /* synthetic */ MapleMapFactory f;
    private /* synthetic */ int P;
    private /* synthetic */ int w;
    private final /* synthetic */ ReentrantReadWriteLock F;
    private final /* synthetic */ Map<Integer, HiredFishing> i;
    private final /* synthetic */ ReentrantReadWriteLock C;
    private static /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ Map<Integer, PlayerNPC> M;
    private /* synthetic */ boolean l;
    private /* synthetic */ String G;
    private final /* synthetic */ Map<MapleSquad.MapleSquadType, MapleSquad> L;
    private /* synthetic */ int E;
    private final /* synthetic */ Map<MapleEventType, MapleEvent> g;
    private /* synthetic */ int Q;
    private /* synthetic */ int K;
    private final /* synthetic */ ReentrantReadWriteLock H;
    private /* synthetic */ boolean b;
    private /* synthetic */ EventScriptManager h;
    private /* synthetic */ int a;
    private /* synthetic */ int t;
    private /* synthetic */ ServerConnection A;
    private static final /* synthetic */ ReentrantReadWriteLock e;
    private static final /* synthetic */ Map<Integer, ChannelServer> D;
    public static /* synthetic */ long serverStartTime;
    private final /* synthetic */ int o;
    private final /* synthetic */ int Z;
    private /* synthetic */ int k;

    public static final /* synthetic */ Collection<ChannelServer> getAllChannelInstances() {
        HashMap<Integer, ChannelServer> hashMap = new HashMap<Integer, ChannelServer>();
        for (Map.Entry<Integer, ChannelServer> entry : D.entrySet()) {
            if (entry.getValue().getChannel() == -10 || entry.getValue().getChannel() == -20) continue;
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return Collections.unmodifiableCollection(hashMap.values());
    }

    public static /* synthetic */ boolean isOnlineAccount(int a2, int a3) {
        boolean bl = false;
        if (a3 == 3 || a3 == 11) {
            FileoutputUtil.logToFile(MapleShopItem.ALLATORIxDEMO("\u0010H\u001bTSo\u001dD\u0017\b\u897b\u88daS\u96fe\u7607x\u5e4f\u8678\u4f03\u750f\u4e51\t\b_\b"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f<" + a2 + ">  loginstate: " + a3 + " \r\n");
            return true;
        }
        block0: for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
            List<MapleCharacter> list;
            block4: {
                Iterator iterator = channelServer.getPlayerStorage().getAllCharactersTransferThreadSafe();
                List<MapleCharacter> list2 = channelServer.getPlayerStorage().getAllCharactersThreadSafe();
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    MapleCharacter mapleCharacter = (MapleCharacter)iterator.next();
                    if (mapleCharacter.getAccountID() != a2) continue;
                    FileoutputUtil.logToFile(MapleExtendedSlots.ALLATORIxDEMO("4H?Two9D3\b\u895f\u88daw\u96fe\u7623x\u5e6b\u8678\u4f27\u750f\u4e75\t,_,"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f<" + a2 + ">  \u72c0\u614b: \u89d2\u8272\u4f4d\u65bcgetAllCharactersTransferThreadSafe\u5167 \u5361\u767b\u983b\u9053: " + channelServer.Z + " loginstate: " + a3 + "\r\n");
                    bl = true;
                    list = list2;
                    break block4;
                }
                list = list2;
            }
            for (MapleCharacter mapleCharacter : list) {
                if (mapleCharacter.getAccountID() != a2) continue;
                FileoutputUtil.logToFile(MapleShopItem.ALLATORIxDEMO("\u0010H\u001bTSo\u001dD\u0017\b\u897b\u88daS\u96fe\u7607x\u5e4f\u8678\u4f03\u750f\u4e51\t\b_\b"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f<" + a2 + ">  \u72c0\u614b: \u89d2\u8272\u4f4d\u65bcgetAllCharactersThreadSafe\u5167 \u5361\u767b\u983b\u9053: " + channelServer.Z + " loginstate: " + a3 + "\r\n");
                bl = true;
                continue block0;
            }
        }
        return bl;
    }

    public final /* synthetic */ void setExpRate(int a2) {
        ChannelServer a3;
        LoginServer.getWorldStatic(a3.o).setExpRate(a2);
    }

    public final /* synthetic */ boolean removeMapleSquad(MapleSquad.MapleSquadType a2) {
        ChannelServer a3;
        if (a2 != null && a3.L.containsKey((Object)a2)) {
            a3.L.remove((Object)a2);
            return true;
        }
        return false;
    }

    public final /* synthetic */ void setServerMessage(String a2) {
        WorldConstants.SCROLL_MESSAGE = a2;
    }

    public final /* synthetic */ String getServerMessage() {
        return WorldConstants.SCROLL_MESSAGE;
    }

    public final /* synthetic */ void setServerName(String a2) {
        ServerConfig.SERVER_NAME = a2;
    }

    public /* synthetic */ int getConnectedClients() {
        ChannelServer a2;
        return a2.getPlayerStorage().getConnectedClients();
    }

    public /* synthetic */ void broadcastGMMessage(byte[] a2, boolean a3) {
        ChannelServer a4;
        if (a4.Z != -10 && a4.Z != -20) {
            a4.broadcastGMPacket(a2, a3);
        }
    }

    public final /* synthetic */ void addPlayerNPC(PlayerNPC a2) {
        ChannelServer a3;
        if (a3.M.containsKey(a2.getId())) {
            a3.removePlayerNPC(a2);
        }
        ChannelServer channelServer = a3;
        channelServer.M.put(a2.getId(), a2);
        if (channelServer.getMapFactory().getMap(a2.getMapId()) != null) {
            a3.getMapFactory().getMap(a2.getMapId()).addMapObject(a2);
        }
    }

    public final /* synthetic */ void setEvent(int a2) {
        a.E = a2;
    }

    public final /* synthetic */ int getExMesoRate() {
        ChannelServer a2;
        return a2.K;
    }

    public final /* synthetic */ void removePlayer(MapleCharacter a2) {
        ChannelServer a3;
        a3.getPlayerStorage().deregisterPlayer(a2);
    }

    public /* synthetic */ int getEvent() {
        ChannelServer a2;
        return a2.E;
    }

    public /* synthetic */ void broadcastGMMessage(byte[] a2) {
        ChannelServer a3;
        if (a3.Z != -10 && a3.Z != -20) {
            a3.broadcastGMPacket(a2);
        }
    }

    public final /* synthetic */ void broadcastGMPacket(byte[] a2) {
        ChannelServer a3;
        a3.getPlayerStorage().broadcastGMPacket(a2);
    }

    public final /* synthetic */ void loadEvents() {
        ChannelServer a2;
        if (!a2.g.isEmpty()) {
            return;
        }
        ChannelServer channelServer = a2;
        a2.g.put(MapleEventType.\u6253\u74f6\u84cb, new MapleCoconut(channelServer.o, channelServer.Z, MapleEventType.\u6253\u74f6\u84cb.mapids));
        ChannelServer channelServer2 = a2;
        a2.g.put(MapleEventType.\u6253\u679c\u5b50, new MapleCoconut(channelServer2.o, channelServer2.Z, MapleEventType.\u6253\u679c\u5b50.mapids));
        ChannelServer channelServer3 = a2;
        a2.g.put(MapleEventType.\u7d42\u6975\u5fcd\u8010, new MapleFitness(channelServer3.o, channelServer3.Z, MapleEventType.\u7d42\u6975\u5fcd\u8010.mapids));
        ChannelServer channelServer4 = a2;
        a2.g.put(MapleEventType.\u722c\u7e69\u5b50, new MapleOla(channelServer4.o, channelServer4.Z, MapleEventType.\u722c\u7e69\u5b50.mapids));
        ChannelServer channelServer5 = a2;
        a2.g.put(MapleEventType.\u662f\u975e\u984c\u5927\u8003\u9a57, new MapleOxQuiz(channelServer5.o, channelServer5.Z, MapleEventType.\u662f\u975e\u984c\u5927\u8003\u9a57.mapids));
        ChannelServer channelServer6 = a2;
        a2.g.put(MapleEventType.\u6efe\u96ea\u7403, new MapleSnowball(channelServer6.o, channelServer6.Z, MapleEventType.\u6efe\u96ea\u7403.mapids));
        ChannelServer channelServer7 = a2;
        a2.g.put(MapleEventType.\u5c0b\u5bf6, new MapleJewel(channelServer7.o, channelServer7.Z, MapleEventType.\u5c0b\u5bf6.mapids));
    }

    public final /* synthetic */ void broadcastEtcSmegaPacket(byte[] a2) {
        ChannelServer a3;
        a3.getPlayerStorage().broadcastEtcSmegaPacket(a2);
    }

    public final /* synthetic */ void setFinishShutdown() {
        ChannelServer a2;
        a2.c = true;
        System.out.println("\u3010\u983b\u9053" + a2.getChannel() + "\u3011 \u5df2\u7d93\u95dc\u9589\u5b8c\u6210.");
    }

    public final /* synthetic */ PlayerNPC getPlayerNPC(int a2) {
        ChannelServer a3;
        return a3.M.get(a2);
    }

    public final /* synthetic */ void setChannel(int a2) {
        ChannelServer a3;
        D.put(a2, a3);
        LoginServer.addChannel(a3.o, a2);
    }

    public final /* synthetic */ boolean addMapleSquad(MapleSquad a2, String a3) {
        ChannelServer a4;
        if ((a3 = MapleSquad.MapleSquadType.valueOf(a3.toLowerCase())) != null && !a4.L.containsKey(a3)) {
            a4.L.put((MapleSquad.MapleSquadType)((Object)a3), a2);
            a2.scheduleRemoval();
            return true;
        }
        return false;
    }

    public /* synthetic */ void removeFishing(HiredFishing a2) {
        ChannelServer a3;
        a3.H.writeLock().lock();
        try {
            a3.i.remove(a2.getStoreId());
            return;
        }
        finally {
            a3.H.writeLock().unlock();
        }
    }

    public static final /* synthetic */ Set<Integer> getChannels() {
        return new HashSet<Integer>(D.keySet());
    }

    public static /* synthetic */ void forceRemovePlayerByCharNameFromDataBase(MapleClient a2, List<String> a3) {
        for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
            for (String string : a3) {
                if (channelServer.getPlayerStorage().getCharacterByName(string) == null) continue;
                MapleCharacter mapleCharacter = channelServer.getPlayerStorage().getCharacterByName(string);
                try {
                    if (mapleCharacter.getClient() != null && mapleCharacter.getClient() != a2) {
                        mapleCharacter.getClient().unLockDisconnect();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (channelServer.getPlayerStorage().getAllCharactersThreadSafe().contains(mapleCharacter)) {
                    channelServer.removePlayer(mapleCharacter);
                }
                mapleCharacter.getMap().removePlayer(mapleCharacter);
            }
        }
    }

    public static /* synthetic */ boolean containsPlayerTransfer(int a2) {
        Iterator<ChannelServer> iterator = ChannelServer.getAllInstances().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getPlayerStorage().containsPlayerTransfer(a2)) continue;
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int closeAllMerchant() {
        ChannelServer a2;
        int n2 = 0;
        a2.I.writeLock().lock();
        try {
            Iterator<Map.Entry<Integer, HiredMerchant>> iterator = a2.j.entrySet().iterator();
            while (iterator.hasNext()) {
                HiredMerchant hiredMerchant;
                HiredMerchant hiredMerchant2 = hiredMerchant = iterator.next().getValue();
                hiredMerchant2.closeShop(true, false);
                ++n2;
                hiredMerchant2.getMap().removeMapObject(hiredMerchant);
                iterator.remove();
            }
            return n2;
        }
        finally {
            a2.I.writeLock().unlock();
        }
    }

    public final /* synthetic */ void addPlayer(MapleCharacter a2) {
        ChannelServer a3;
        MapleCharacter mapleCharacter = a2;
        a3.getPlayerStorage().registerPlayer(mapleCharacter);
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.serverMessage(a3.getServerMessage()));
    }

    public /* synthetic */ void shutdown() {
        ChannelServer a2;
        if (a2.c) {
            return;
        }
        String string = a2.Z == -10 ? MapleExtendedSlots.ALLATORIxDEMO("\u5561\u5796") : (a2.Z == -20 ? MapleShopItem.ALLATORIxDEMO("\u62ea\u8c9f") : MapleExtendedSlots.ALLATORIxDEMO("\u906d\u626a"));
        ChannelServer channelServer = a2;
        channelServer.broadcastPacket(MaplePacketCreator.serverNotice("\u3010" + string + "\u983b\u9053" + channelServer.getChannel() + "\u3011 \u9019\u500b\u983b\u9053\u6b63\u5728\u95dc\u9589\u4e2d."));
        a2.b = true;
        a2.getPlayerStorage().SessionCloseAll();
        System.out.println("\u3010" + string + "\u983b\u9053" + a2.getChannel() + "\u3011 \u89e3\u9664\u7aef\u53e3\u7d81\u5b9a\u4e2d...");
        try {
            if (a2.A != null) {
                a2.A.close();
                System.out.println("\u3010" + string + "\u983b\u9053" + a2.getChannel() + "\u3011 \u89e3\u9664\u7aef\u53e3\u6210\u529f");
            }
        }
        catch (Exception exception) {
            System.out.println("\u3010" + string + "\u983b\u9053" + a2.getChannel() + "\u3011 \u89e3\u9664\u7aef\u53e3\u5931\u6557");
        }
        D.remove(a2.Z);
        a2.setFinishShutdown();
    }

    public static /* synthetic */ void forceRemovePlayerByAccId(MapleClient a2, int a3) {
        for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
            List<MapleCharacter> list = channelServer.getPlayerStorage().getAllCharactersThreadSafe();
            List<MapleCharacter> list2 = channelServer.getPlayerStorage().getAllCharactersTransferThreadSafe();
            for (MapleCharacter mapleCharacter : list) {
                if (mapleCharacter.getAccountID() != a3) continue;
                try {
                    if (mapleCharacter.getClient() != null && mapleCharacter.getClient() != a2) {
                        mapleCharacter.getClient().unLockDisconnect();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (!(list = channelServer.getPlayerStorage().getAllCharactersThreadSafe()).contains(mapleCharacter)) continue;
                channelServer.removePlayer(mapleCharacter);
            }
            for (MapleCharacter mapleCharacter : list2) {
                if (mapleCharacter.getAccountID() != a3) continue;
                try {
                    if (mapleCharacter.getClient() != null && mapleCharacter.getClient() != a2) {
                        mapleCharacter.getClient().unLockDisconnect();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (!(list = channelServer.getPlayerStorage().getAllCharactersTransferThreadSafe()).contains(mapleCharacter)) continue;
                channelServer.getPlayerStorage().deregisterPlayerTransfer(mapleCharacter.getId());
                mapleCharacter.setTransferTime(-1L);
            }
        }
    }

    public /* synthetic */ void broadcastMessage(byte[] a2) {
        ChannelServer a3;
        if (a3.Z != -10 && a3.Z != -20) {
            a3.broadcastPacket(a2);
        }
    }

    public static /* synthetic */ int LoggedInPlayerCount(MapleClient a2, int a3) {
        int n2 = 0;
        Iterator<ChannelServer> iterator = ChannelServer.getAllInstances().iterator();
        while (iterator.hasNext()) {
            for (MapleCharacter mapleCharacter : iterator.next().getPlayerStorage().getAllCharactersThreadSafe()) {
                if (mapleCharacter.getAccountID() != a3 || mapleCharacter.getClient() == null || mapleCharacter.getClient() == a2) continue;
                ++n2;
            }
        }
        return n2;
    }

    public static /* synthetic */ void RemoveChrTransfer(int a2) {
        try {
            for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
                for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharactersTransferThreadSafe()) {
                    if (mapleCharacter.getAccountID() != a2 || System.currentTimeMillis() - mapleCharacter.getTransferTime() <= 8000L) continue;
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    int n2 = World.Find.findChannel(mapleCharacter2.getId());
                    World.removeChangeChannel(mapleCharacter2.getClient().getAccID());
                    System.out.println("RemoveChrTransfer: accid = " + a2 + " channel =" + n2 + " LoginState:" + mapleCharacter.getClient().getLoginState());
                    n2 = 0;
                    MapleCharacter mapleCharacter3 = mapleCharacter;
                    mapleCharacter.getClient().updateLoginState(n2, mapleCharacter.getClient().getSessionIPAddress());
                    channelServer.getPlayerStorage().deregisterPlayerTransfer(mapleCharacter.getId());
                    mapleCharacter3.setTransferTime(-1L);
                    mapleCharacter3.getClient().getSession().close();
                    return;
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public /* synthetic */ boolean CanGMItem() {
        return WorldConstants.GMITEMS;
    }

    public final /* synthetic */ boolean isShutdown() {
        ChannelServer a2;
        return a2.b;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int SaveAllMerchant() {
        ChannelServer a2;
        int n2 = 0;
        a2.F.writeLock().lock();
        try {
            Iterator<Map.Entry<Integer, HiredMerchant>> iterator = a2.j.entrySet().iterator();
            while (iterator.hasNext()) {
                ++n2;
                iterator.next().getValue().saveItems(true);
            }
            return n2;
        }
        finally {
            a2.F.writeLock().unlock();
        }
    }

    public final /* synthetic */ Collection<PlayerNPC> getAllPlayerNPC() {
        ChannelServer a2;
        return a2.M.values();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int SaveUseMerchant() {
        ChannelServer a2;
        int n2 = 0;
        a2.F.writeLock().lock();
        try {
            Iterator<Map.Entry<Integer, HiredMerchant>> iterator = a2.j.entrySet().iterator();
            while (iterator.hasNext()) {
                HiredMerchant hiredMerchant = iterator.next().getValue();
                if (GameSetConstants.MERCHANT_TIMER) {
                    hiredMerchant.addOpenMinute((int)(GameSetConstants.AUTO_SAVE_MERCHANT / 60000L));
                }
                if (!hiredMerchant.getNeedSave()) continue;
                ++n2;
                hiredMerchant.saveItems(true);
            }
            return n2;
        }
        finally {
            a2.F.writeLock().unlock();
        }
    }

    public final /* synthetic */ void setup() {
        ChannelServer channelServer;
        ChannelServer a2;
        boolean bl = a2.Z == -10;
        boolean bl2 = a2.Z == -20;
        serverStartTime = System.currentTimeMillis();
        ChannelServer channelServer2 = a2;
        channelServer2.setChannel(channelServer2.Z);
        ChannelServer channelServer3 = a2;
        a2.m = new PlayerStorage(a2.Z);
        if (bl) {
            int n2 = GameSetConstants.CASH_PORT;
            a2.Q = n2 + a2.o;
            System.out.println("\u3010\u5546\u57ce\u983b\u9053" + a2.getChannel() + "\u3011  - \u76e3\u807d\u7aef\u53e3: " + a2.Q);
            channelServer = a2;
        } else if (bl2) {
            short s2 = Short.valueOf(ServerProperties.getProperty(MapleExtendedSlots.ALLATORIxDEMO("T=U.B*\t+B,S1I?TvF-D,N7IvW7U,"), MapleShopItem.ALLATORIxDEMO("\u0011J\u0011J")));
            a2.Q = s2 + a2.o;
            System.out.println("\u3010\u62cd\u8ce3\u983b\u9053" + a2.getChannel() + "\u3011  - \u76e3\u807d\u7aef\u53e3: " + a2.Q);
            channelServer = a2;
        } else {
            try {
                a2.h = new EventScriptManager(a2, GameSetConstants.EVENT_LIST);
                a2.Q = LoginServer.getChannelAmount();
            }
            catch (Exception exception) {
                throw new RuntimeException(exception);
            }
            a2.loadEvents();
            if (GameSetConstants.GAMBLING_SYSTEM) {
                Timer.TimerManager timerManager = Timer.TimerManager.getInstance();
                if (a2.Z == ServerConfig.getGamblingChannel() && ServerConfig.GAMBLING_SYSTEM) {
                    ChannelServer channelServer4 = a2;
                    timerManager.register(AutoEventManager.getInstance(channelServer4, channelServer4.getMapFactory()), 120000L);
                }
            }
            System.out.println("\u3010\u904a\u6232\u983b\u9053" + a2.getChannel() + "\u3011  - \u76e3\u807d\u7aef\u53e3: " + a2.Q);
            channelServer = a2;
        }
        channelServer.G = ServerConfig.IP + ":" + a2.Q;
        ChannelServer channelServer5 = a2;
        ChannelServer channelServer6 = a2;
        channelServer5.A = new ServerConnection(channelServer5.Q, channelServer6.o, channelServer6.Z, bl);
        channelServer5.A.run();
        if (!bl && !bl2) {
            a2.h.init();
        }
        LoginServer.addChannelAmount();
    }

    public final /* synthetic */ boolean isRegularExpBonus() {
        return ServerConfig.isRegularExpBonus();
    }

    public static /* synthetic */ ChannelServer newInstance(int a2, int a3) {
        return new ChannelServer(a2, a3);
    }

    public static /* synthetic */ void deregisterAllPlayerTransfer(int a2) {
        Iterator<ChannelServer> iterator;
        Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllInstances().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getPlayerStorage().deregisterPlayerTransfer(a2);
            iterator2 = iterator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ HiredMerchant getMerchant(MapleCharacter a22) {
        ChannelServer a3;
        boolean bl = false;
        HiredMerchant hiredMerchant = null;
        a3.F.writeLock().lock();
        try {
            ChannelServer channelServer;
            block3: {
                Iterator<Map.Entry<Integer, HiredMerchant>> iterator = a3.j.entrySet().iterator();
                while (iterator.hasNext()) {
                    HiredMerchant hiredMerchant2 = iterator.next().getValue();
                    if (!hiredMerchant2.isOwner(a22)) continue;
                    hiredMerchant = hiredMerchant2;
                    channelServer = a3;
                    break block3;
                }
                channelServer = a3;
            }
            channelServer.F.writeLock().unlock();
            return hiredMerchant;
        }
        catch (Throwable a22) {
            a3.F.writeLock().unlock();
            throw a22;
        }
    }

    public /* synthetic */ int getTraitRate() {
        ChannelServer a2;
        return a2.d;
    }

    public final /* synthetic */ int getExDropRate() {
        ChannelServer a2;
        return a2.k;
    }

    public /* synthetic */ int addFishing(HiredFishing a2) {
        ChannelServer a3;
        a3.H.writeLock().lock();
        int n2 = 0;
        try {
            ChannelServer channelServer = a3;
            n2 = channelServer.w++;
            channelServer.i.put(a3.w, a2);
            return n2;
        }
        finally {
            a3.H.writeLock().unlock();
        }
    }

    public final /* synthetic */ void setExExpRate(int a2) {
        a.B = a2;
    }

    public static /* synthetic */ ChannelServer getInstance(int a2, int a32) {
        ChannelServer channelServer = null;
        try {
            channelServer = LoginServer.getInstance().getChannel(a2, a32);
            return channelServer;
        }
        catch (Exception a32) {
            a32.printStackTrace();
            return channelServer;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final /* synthetic */ double getExpRate(int a, MapleCharacter a) {
        block27: {
            block32: {
                block31: {
                    block30: {
                        block29: {
                            block28: {
                                block26: {
                                    var3_3 = LoginServer.getWorldStatic(a).getExpRate();
                                    if (a == null) ** GOTO lbl88
                                    a = a.getLevel();
                                    if (!GameSetConstants.SERVER_NAME.equals(MapleShopItem.ALLATORIxDEMO("\u6756\u77c2\u8c4b"))) break block26;
                                    if (a > 120) {
                                        var3_3 = 1.0;
                                        v0 = a;
                                    } else if (a > 30) {
                                        var3_3 = 2.0;
                                        v0 = a;
                                    } else {
                                        var3_3 = 3.0;
                                        v0 = a;
                                    }
                                    break block27;
                                }
                                if (!GameSetConstants.SERVER_NAME.equals(MapleExtendedSlots.ALLATORIxDEMO("\u7544\u5fe4\u8c6f"))) break block28;
                                if (a < 250) ** GOTO lbl88
                                var3_3 = 0.5;
                                v0 = a;
                                break block27;
                            }
                            if (!GameSetConstants.SERVER_NAME.equals(MapleShopItem.ALLATORIxDEMO("\u8c3a\u8c61\u8c4b"))) break block29;
                            if (a > 180) {
                                var3_3 = 1.0;
                                v0 = a;
                            } else if (a > 150) {
                                var3_3 = 2.0;
                                v0 = a;
                            } else {
                                var3_3 = 3.0;
                                v0 = a;
                            }
                            break block27;
                        }
                        if (!GameSetConstants.SERVER_NAME.equals(MapleExtendedSlots.ALLATORIxDEMO("\u7d8a\u5942\u520e\u4ec6"))) break block30;
                        if (a > 200) {
                            var3_3 = 1.0;
                            v0 = a;
                        } else if (a > 150) {
                            var3_3 = 1.5;
                            v0 = a;
                        } else {
                            var3_3 = 2.0;
                            v0 = a;
                        }
                        break block27;
                    }
                    if (!GameSetConstants.SERVER_NAME.equals(MapleShopItem.ALLATORIxDEMO("\u6974\u820e\u5e5c\u608f"))) break block31;
                    if (a <= 200) ** GOTO lbl88
                    var3_3 = 0.0033333333333333335;
                    v0 = a;
                    break block27;
                }
                if (!GameSetConstants.SERVER_NAME.equals(MapleExtendedSlots.ALLATORIxDEMO("\u73d3\u4e6c\u8c6f"))) break block32;
                var3_3 = 5.0 - (double)(a.getReborn() - 3) * 0.1;
                if (v1 < 1.0) {
                    var3_3 = 1.0;
                }
                switch (a.getReborn()) {
                    case 0: {
                        var3_3 = 5.0;
                        break;
                    }
                    case 1: {
                        var3_3 = 4.0;
                        break;
                    }
                    case 2: {
                        var3_3 = 3.0;
                        break;
                    }
                    case 3: {
                        var3_3 = 2.0;
                    }
                }
                ** GOTO lbl88
            }
            if (GameSetConstants.SERVER_NAME.equals(MapleShopItem.ALLATORIxDEMO("\u609d\u728b\u8c4b"))) {
                if (a > 120) {
                    var3_3 = 2.0;
                    v0 = a;
                } else if (a > 70) {
                    var3_3 = 3.0;
                    v0 = a;
                } else {
                    var3_3 = 4.0;
                    v0 = a;
                }
            } else {
                if (GameSetConstants.SERVER_NAME.equals(MapleExtendedSlots.ALLATORIxDEMO("\u51e8\u8288\u8c6f")) && a >= 160) {
                    var3_3 = 1.0;
                }
lbl88:
                // 7 sources

                v0 = a;
            }
        }
        if (v0.isRegularExpBonus() == false) return var3_3 * (double)a.B;
        return var3_3 * (double)a.B * GameSetConstants.EXP_BONUS_RATE;
    }

    public final /* synthetic */ void setExDropRate(int a2) {
        a.k = a2;
    }

    public final /* synthetic */ int getPort() {
        ChannelServer a2;
        return a2.Q;
    }

    public final /* synthetic */ MapleMapFactory getMapFactory() {
        ChannelServer a2;
        return a2.f;
    }

    public /* synthetic */ void broadcastSmega(byte[] a2) {
        ChannelServer a3;
        if (a3.Z != -10 && a3.Z != -20) {
            a3.broadcastSmegaPacket(a2);
        }
    }

    public final /* synthetic */ String getSocket() {
        ChannelServer a2;
        return a2.G;
    }

    public final /* synthetic */ double getExpRate(int a2) {
        ChannelServer a3;
        return a3.getExpRate(a2, null);
    }

    public final /* synthetic */ int addPlayerShop(MaplePlayerShop a2) {
        ChannelServer a3;
        a3.I.writeLock().lock();
        int n2 = 0;
        try {
            ChannelServer channelServer = a3;
            n2 = channelServer.P++;
            channelServer.J.put(a3.P, a2);
            return n2;
        }
        finally {
            a3.I.writeLock().unlock();
        }
    }

    public final /* synthetic */ void updateEvents(String a2) {
        if (a2 != null) {
            ChannelServer a3;
            a3.h.addEventManager(a3, a2);
        }
    }

    public /* synthetic */ void registerGameLoop() {
        try {
            ChannelServer a2;
            e.writeLock().lock();
            Timer.ChannelTimer.getInstance().register(a2.new handleFishs(), 1000L);
            return;
        }
        catch (Exception exception) {
            FileoutputUtil.printError(MapleShopItem.ALLATORIxDEMO("?O\u001dI\u0012B\u0010t\u0019U\nB\u000e\t\b_\b"), exception, MapleExtendedSlots.ALLATORIxDEMO("0F6C4B\u0015F(n,B5"));
            return;
        }
        finally {
            e.writeLock().unlock();
        }
    }

    public final /* synthetic */ double getDropRate(int a2) {
        ChannelServer a3;
        if (a3.isRegularDropBonus()) {
            return (double)(LoginServer.getWorldStatic(a2).getDropRate() * a3.k) * GameSetConstants.DROP_BONUS_RATE;
        }
        return LoginServer.getWorldStatic(a2).getDropRate() * a3.k;
    }

    public static /* synthetic */ void forceRemovePlayerByCharName(MapleClient a2, String a3) {
        for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
            List<MapleCharacter> list = channelServer.getPlayerStorage().getAllCharactersThreadSafe();
            for (MapleCharacter mapleCharacter : list) {
                if (!mapleCharacter.getName().equalsIgnoreCase(a3)) continue;
                try {
                    if (mapleCharacter.getClient() != null && mapleCharacter.getClient() != a2) {
                        mapleCharacter.getClient().unLockDisconnect();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if ((list = channelServer.getPlayerStorage().getAllCharactersThreadSafe()).contains(mapleCharacter)) {
                    channelServer.removePlayer(mapleCharacter);
                }
                mapleCharacter.getMap().removePlayer(mapleCharacter);
            }
        }
    }

    public final /* synthetic */ void removeMerchant(HiredMerchant a2) {
        ChannelServer a3;
        a3.I.writeLock().lock();
        try {
            a3.j.remove(a2.getStoreId());
            return;
        }
        finally {
            a3.I.writeLock().unlock();
        }
    }

    public final /* synthetic */ void reloadEvents() {
        ChannelServer a2;
        a2.h.cancel();
        a2.h = new EventScriptManager(a2, GameSetConstants.EVENT_LIST);
        a2.h.init();
    }

    public final /* synthetic */ boolean isRegularDropBonus() {
        return ServerConfig.isRegularDropBonus();
    }

    public static final /* synthetic */ Collection<ChannelServer> getAllInstances() {
        return Collections.unmodifiableCollection(D.values());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ HiredMerchant getMerchant(int a22) {
        ChannelServer a3;
        HiredMerchant hiredMerchant = null;
        a3.I.readLock().lock();
        try {
            ChannelServer channelServer;
            block3: {
                for (HiredMerchant hiredMerchant2 : a3.j.values()) {
                    if (hiredMerchant2.getOwnerAccId() != a22) continue;
                    hiredMerchant = hiredMerchant2;
                    channelServer = a3;
                    break block3;
                }
                channelServer = a3;
            }
            channelServer.I.readLock().unlock();
            return hiredMerchant;
        }
        catch (Throwable a22) {
            a3.I.readLock().unlock();
            throw a22;
        }
    }

    public final /* synthetic */ int getFishingMap(MapleCharacter a2) {
        int n2;
        int n3 = -1;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Object object = GameSetConstants.FISH_MAP;
        int n4 = GameSetConstants.FISH_MAP.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            int n6 = object[n2];
            int n7 = n6;
            linkedList.add(n6);
            n5 = ++n2;
        }
        linkedList.add(749050500);
        linkedList.add(749050501);
        linkedList.add(749050502);
        object = linkedList.iterator();
        while (object.hasNext()) {
            ChannelServer a3;
            n4 = (Integer)object.next();
            for (MapleMapObject mapleMapObject : a3.f.getMap(n4).getAllHiredFishingThreadsafe()) {
                if (((HiredFishing)mapleMapObject).getOwnerId() != a2.getId()) continue;
                return a3.f.getMap(n4).getId();
            }
        }
        return n3;
    }

    public /* synthetic */ String getIP() {
        return ServerConfig.IP;
    }

    public final /* synthetic */ String getServerName() {
        return ServerConfig.SERVER_NAME;
    }

    public final /* synthetic */ void reloadEvent(String a2) {
        ChannelServer a3;
        a3.h.reloadEvent(a3, a2);
    }

    public static final /* synthetic */ ChannelServer getGamblingChannel() {
        return D.get(ServerConfig.getGamblingChannel());
    }

    public final /* synthetic */ int getChannel() {
        ChannelServer a2;
        return a2.Z;
    }

    public final /* synthetic */ void removePlayerNPC(PlayerNPC a2) {
        ChannelServer a3;
        if (a3.M.containsKey(a2.getId())) {
            ChannelServer channelServer = a3;
            channelServer.M.remove(a2.getId());
            if (channelServer.getMapFactory().getMap(a2.getMapId()) != null) {
                a3.getMapFactory().getMap(a2.getMapId()).removeMapObject(a2);
            }
        }
    }

    public final /* synthetic */ EventScriptManager getEventSM() {
        ChannelServer a2;
        return a2.h;
    }

    public final /* synthetic */ void setMesoRate(int a2) {
        ChannelServer a3;
        LoginServer.getWorldStatic(a3.o).setMesoRate(a2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<HiredMerchant> searchMerchant(int a2) {
        ChannelServer a3;
        LinkedList<HiredMerchant> linkedList = new LinkedList<HiredMerchant>();
        a3.I.readLock().lock();
        try {
            for (HiredMerchant hiredMerchant : a3.j.values()) {
                if (hiredMerchant.searchItem(a2).size() <= 0) continue;
                linkedList.add(hiredMerchant);
            }
            return linkedList;
        }
        finally {
            a3.I.readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean containsMerchant(int a2) {
        ChannelServer a3;
        boolean bl = false;
        a3.I.readLock().lock();
        try {
            Iterator<HiredMerchant> iterator = a3.j.values().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getOwnerAccId() != a2) continue;
                bl = true;
                break;
            }
            return bl;
        }
        finally {
            a3.I.readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void removeMerchantByAccId(int a2) {
        ChannelServer a3;
        int n2 = -1;
        a3.I.readLock().lock();
        try {
            int n3;
            block6: {
                for (HiredMerchant hiredMerchant : a3.j.values()) {
                    if (hiredMerchant.getOwnerAccId() != a2) continue;
                    n3 = n2 = hiredMerchant.getStoreId();
                    break block6;
                }
                n3 = n2;
            }
            if (n3 != -1) {
                a3.j.remove(n2);
            }
            return;
        }
        finally {
            a3.I.readLock().unlock();
        }
    }

    public static /* synthetic */ boolean forceRemovePlayerByCharIDFromDataBase(MapleClient a2, List<Integer> a3, int a4) {
        boolean bl = false;
        for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
            for (int n2 : a3) {
                if (channelServer.getPlayerStorage().getPendingCharacter(n2) == null) continue;
                MapleClient mapleClient = channelServer.getPlayerStorage().getPendingClient(n2);
                try {
                    if (mapleClient == null || mapleClient == a2) continue;
                    bl = true;
                }
                catch (Exception exception) {}
            }
        }
        if (bl) {
            World.Find.registerDisconnect(a4);
        }
        return World.Find.findDisconnect(a4) > 0;
    }

    public /* synthetic */ Map<MapleEventType, MapleEvent> getAllEvent() {
        ChannelServer a2;
        return a2.g;
    }

    public /* synthetic */ Map<MapleSquad.MapleSquadType, MapleSquad> getAllSquads() {
        ChannelServer a2;
        return Collections.unmodifiableMap(a2.L);
    }

    public /* synthetic */ void handleFishAction(MapleMap a2, long a3) {
        for (MapleCharacter mapleCharacter : ((MapleMap)a2).getCharactersThreadsafe()) {
            if (!mapleCharacter.isAlive() || !mapleCharacter.canFish(a3)) continue;
            mapleCharacter.doFish();
        }
    }

    public /* synthetic */ void broadcastEtcSmega(byte[] a2) {
        ChannelServer a3;
        if (a3.Z != -10 && a3.Z != -20) {
            a3.broadcastEtcSmegaPacket(a2);
        }
    }

    public /* synthetic */ MapleEvent getEvent(MapleEventType a2) {
        ChannelServer a3;
        if (!a3.g.containsKey((Object)a2)) {
            return null;
        }
        return a3.g.get((Object)a2);
    }

    public final /* synthetic */ boolean hasFinishedShutdown() {
        ChannelServer a2;
        return a2.c;
    }

    public final /* synthetic */ boolean getMegaphoneMuteState() {
        ChannelServer a2;
        return a2.l;
    }

    public static /* synthetic */ void forceRemovePlayerByIPandMac(MapleClient a2, String a3, String a4) {
        if (GameSetConstants.MORE_OPEN > 0) {
            int n2 = 0;
            Iterator<ChannelServer> iterator = ChannelServer.getAllInstances().iterator();
            while (iterator.hasNext()) {
                for (MapleCharacter mapleCharacter : iterator.next().getPlayerStorage().getAllCharactersThreadSafe()) {
                    try {
                        if (mapleCharacter.getClient() == null || !mapleCharacter.getClient().getSessionIPAddress().equalsIgnoreCase(a3) || !mapleCharacter.getClient().getClientMac().equalsIgnoreCase(a4) && !mapleCharacter.getClient().getClientMac().isEmpty()) continue;
                        ++n2;
                    }
                    catch (Exception exception) {}
                }
                if (GameSetConstants.MORE_OPEN > n2) continue;
                a2.getSession().close();
            }
        }
    }

    public static /* synthetic */ Set<Integer> getAllChannels() {
        return new HashSet<Integer>(D.keySet());
    }

    public /* synthetic */ ChannelServer(int a2, int a3) {
        ChannelServer a4;
        ChannelServer channelServer = a4;
        ChannelServer channelServer2 = a4;
        ChannelServer channelServer3 = a4;
        ChannelServer channelServer4 = a4;
        ChannelServer channelServer5 = a4;
        ChannelServer channelServer6 = a4;
        ChannelServer channelServer7 = a4;
        ChannelServer channelServer8 = a4;
        a4.Q = 14000;
        channelServer8.t = 0;
        channelServer8.P = 0;
        channelServer7.w = 0;
        channelServer7.b = false;
        channelServer6.c = false;
        channelServer6.l = false;
        ChannelServer channelServer9 = a4;
        channelServer5.L = new ConcurrentEnumMap<MapleSquad.MapleSquadType, MapleSquad>(MapleSquad.MapleSquadType.class);
        channelServer9.j = new HashMap<Integer, HiredMerchant>();
        channelServer5.i = new HashMap<Integer, HiredFishing>();
        channelServer5.J = new HashMap<Integer, MaplePlayerShop>();
        channelServer5.M = new HashMap<Integer, PlayerNPC>();
        channelServer5.I = new ReentrantReadWriteLock();
        channelServer5.F = new ReentrantReadWriteLock();
        channelServer5.C = new ReentrantReadWriteLock();
        channelServer4.H = new ReentrantReadWriteLock();
        channelServer4.E = -1;
        channelServer4.g = new EnumMap<MapleEventType, MapleEvent>(MapleEventType.class);
        channelServer3.B = 1;
        channelServer3.k = 1;
        channelServer2.K = 1;
        channelServer2.a = 1;
        channelServer.d = 1;
        channelServer.o = a2;
        a4.Z = a3;
        a4.setChannel(a3);
        a4.f = new MapleMapFactory(a2, a3);
    }

    public final /* synthetic */ int addMerchant(HiredMerchant a2) {
        ChannelServer a3;
        a3.I.writeLock().lock();
        int n2 = 0;
        try {
            ChannelServer channelServer = a3;
            n2 = channelServer.t++;
            channelServer.j.put(a3.t, a2);
            return n2;
        }
        finally {
            a3.I.writeLock().unlock();
        }
    }

    public final /* synthetic */ boolean isAdminOnly() {
        return GameSetConstants.ADMIN_ONLY;
    }

    public final /* synthetic */ void toggleMegaphoneMuteState() {
        ChannelServer a2;
        a2.l = !a2.l;
    }

    public /* synthetic */ List<CheaterData> getCheaters() {
        ChannelServer a2;
        List<CheaterData> list;
        List<CheaterData> list2 = list = a2.getPlayerStorage().getCheaters();
        Collections.sort(list2);
        return CollectionUtil.copyFirst(list2, 20);
    }

    public final /* synthetic */ void broadcastSmegaPacket(byte[] a2) {
        ChannelServer a3;
        a3.getPlayerStorage().broadcastSmegaPacket(a2);
    }

    public final /* synthetic */ int getMesoRate(int a2) {
        ChannelServer a3;
        return LoginServer.getWorldStatic(a2).getMesoRate() * a3.K;
    }

    public final /* synthetic */ int getWorld() {
        ChannelServer a2;
        return a2.o;
    }

    public static /* synthetic */ Map<Integer, Map<Integer, Integer>> getChannelLoad() {
        Iterator<World> iterator;
        HashMap<Integer, Map<Integer, Integer>> hashMap = new HashMap<Integer, Map<Integer, Integer>>();
        Iterator<World> iterator2 = iterator = LoginServer.getWorlds().iterator();
        while (iterator2.hasNext()) {
            World world = iterator.next();
            HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
            Iterator<ChannelServer> iterator3 = world.getChannels().iterator();
            while (iterator3.hasNext()) {
                Iterator<ChannelServer> iterator4;
                ChannelServer channelServer = iterator4.next();
                iterator3 = iterator4;
                hashMap2.put(channelServer.getChannel(), channelServer.getConnectedClients());
            }
            hashMap.put(world.getWorldId(), hashMap2);
            iterator2 = iterator;
        }
        return hashMap;
    }

    public static final /* synthetic */ int getChannelCount() {
        return D.size();
    }

    public final /* synthetic */ MapleSquad getMapleSquad(MapleSquad.MapleSquadType a2) {
        ChannelServer a3;
        return a3.L.get((Object)a2);
    }

    public final /* synthetic */ int getExExpRate() {
        ChannelServer a2;
        return a2.B;
    }

    public static /* synthetic */ boolean isBlockedLoggedIn(MapleClient a2, int a3) {
        for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
            List<MapleCharacter> list = channelServer.getPlayerStorage().getAllCharactersThreadSafe();
            for (MapleCharacter mapleCharacter : list) {
                if (mapleCharacter.getAccountID() != a3) continue;
                try {
                    if (mapleCharacter.getClient() == null || mapleCharacter.getClient() == a2 || !mapleCharacter.BlockedLoggedIn()) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (mapleCharacter.getTrade() != null) {
                        stringBuilder.append(MapleExtendedSlots.ALLATORIxDEMO("x|\u6b3b\u570f\u4efc\u6634\u0005"));
                    }
                    if (mapleCharacter.getConversation() > 0) {
                        stringBuilder.append(MapleShopItem.ALLATORIxDEMO("\\|\u6756\u7d77\u6723i,d\u5c71\u8a56!"));
                    }
                    if (mapleCharacter.getPlayerShop() != null) {
                        stringBuilder.append(MapleExtendedSlots.ALLATORIxDEMO("\u0007\u0003\u7c99\u9710\u5561\u4ee2\u64ea\u4f04\u4e0a\u0005"));
                    }
                    if (mapleCharacter.isOperateStorage()) {
                        stringBuilder.append(MapleShopItem.ALLATORIxDEMO("\u0007'\u502e\u5ed7\u64ea\u4f20\u4e0a!"));
                    }
                    FileoutputUtil.logToFile(MapleExtendedSlots.ALLATORIxDEMO("4H?Two9D3\b\u6495\u4f7b\u4e75\u5f10\u7623\t,_,"), "\r\n" + FileoutputUtil.NowTime() + "IP: " + a2.getSessionIPAddress() + " \u5e33\u865f: " + a3 + " \u89d2\u8272: " + mapleCharacter.getName() + " \u72c0\u614b:" + stringBuilder.toString(), false, false);
                    mapleCharacter.getClient().unLockDisconnect();
                    list = channelServer.getPlayerStorage().getAllCharactersThreadSafe();
                    if (list.contains(mapleCharacter)) {
                        channelServer.removePlayer(mapleCharacter);
                    }
                    return true;
                }
                catch (Exception exception) {
                }
            }
        }
        return false;
    }

    public final /* synthetic */ void broadcastPacket(byte[] a2) {
        ChannelServer a3;
        a3.getPlayerStorage().broadcastPacket(a2);
    }

    public final /* synthetic */ void broadcastGMPacket(byte[] a2, boolean a3) {
        ChannelServer a4;
        a4.getPlayerStorage().broadcastGMPacket(a2, a3);
    }

    public final /* synthetic */ void setPrepareShutdown() {
        ChannelServer a2;
        a2.b = true;
        System.out.println("\u3010\u983b\u9053" + a2.getChannel() + "\u3011 \u6e96\u5099\u95dc\u9589.");
    }

    public static /* synthetic */ {
        D = new HashMap<Integer, ChannelServer>();
        e = new ReentrantReadWriteLock();
        ALLATORIxDEMO = 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int closeAllPlayerShop() {
        ChannelServer a2;
        int n2 = 0;
        a2.I.writeLock().lock();
        try {
            Iterator<Map.Entry<Integer, MaplePlayerShop>> iterator = a2.J.entrySet().iterator();
            while (iterator.hasNext()) {
                MaplePlayerShop maplePlayerShop;
                MaplePlayerShop maplePlayerShop2 = maplePlayerShop = iterator.next().getValue();
                maplePlayerShop2.closeShop(true, false);
                ++n2;
                maplePlayerShop2.getMap().removeMapObject(maplePlayerShop);
                iterator.remove();
            }
            return n2;
        }
        finally {
            a2.I.writeLock().unlock();
        }
    }

    public final /* synthetic */ MapleSquad getMapleSquad(String a2) {
        ChannelServer a3;
        return a3.getMapleSquad(MapleSquad.MapleSquadType.valueOf(a2.toLowerCase()));
    }

    public final /* synthetic */ void removePlayer(int a2, String a3) {
        ChannelServer a4;
        a4.getPlayerStorage().deregisterPlayer(a2, a3);
    }

    public final /* synthetic */ void setDropRate(int a2) {
        ChannelServer a3;
        LoginServer.getWorldStatic(a3.o).setDropRate(a2);
    }

    public final /* synthetic */ int getMerchantMap(MapleCharacter a2) {
        int n2;
        int n3 = -1;
        int n4 = n2 = 910000001;
        while (n4 <= 910000022) {
            ChannelServer a3;
            Iterator<MapleMapObject> iterator = a3.f.getMap(n2).getAllHiredMerchantsThreadsafe().iterator();
            while (iterator.hasNext()) {
                if (((HiredMerchant)iterator.next()).getOwnerId() != a2.getId()) continue;
                return a3.f.getMap(n2).getId();
            }
            n4 = ++n2;
        }
        return n3;
    }

    public final /* synthetic */ void setExMesoRate(int a2) {
        a.K = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ HiredFishing containsFishing(int a22) {
        ChannelServer a3;
        HiredFishing hiredFishing = null;
        a3.H.readLock().lock();
        try {
            ChannelServer channelServer;
            block3: {
                for (HiredFishing hiredFishing2 : a3.i.values()) {
                    if (hiredFishing2.getOwnerAccId() != a22) continue;
                    hiredFishing = hiredFishing2;
                    channelServer = a3;
                    break block3;
                }
                channelServer = a3;
            }
            channelServer.H.readLock().unlock();
            return hiredFishing;
        }
        catch (Throwable a22) {
            a3.H.readLock().unlock();
            throw a22;
        }
    }

    public final /* synthetic */ PlayerStorage getPlayerStorage() {
        ChannelServer a2;
        if (a2.m == null) {
            ChannelServer channelServer = a2;
            a2.m = new PlayerStorage(a2.Z);
        }
        return a2.m;
    }

    public final /* synthetic */ int getLoadedMaps() {
        ChannelServer a2;
        return a2.f.getLoadedMaps();
    }

    public class handleFishs
    implements Runnable {
        public /* synthetic */ handleFishs() {
            handleFishs a3;
        }

        @Override
        public /* synthetic */ void run() {
            int n2;
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            linkedList.add(749050500);
            linkedList.add(749050501);
            linkedList.add(749050502);
            Object object = GameSetConstants.FISH_MAP;
            int n3 = ((int[])object).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                linkedList.add(object[n2++]);
                n4 = n2;
            }
            object = linkedList.iterator();
            while (object.hasNext()) {
                handleFishs a2;
                n3 = (Integer)object.next();
                if (!a2.ChannelServer.this.getMapFactory().isMapLoaded(n3)) continue;
                handleFishs handleFishs2 = a2;
                MapleMap mapleMap = handleFishs2.ChannelServer.this.getMapFactory().getMap(n3);
                handleFishs2.ChannelServer.this.handleFishAction(mapleMap, System.currentTimeMillis());
            }
        }
    }
}

