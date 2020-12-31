/*
 * Decompiled with CFR 0.150.
 */
package scripting.event;

import FuckingHackerToby.L;
import client.MapleCharacter;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledFuture;
import javax.script.Invocable;
import javax.script.ScriptException;
import scripting.event.EventInstanceManager;
import server.Extend.SpecialItemData;
import server.MapleSquad;
import server.Randomizer;
import server.Timer;
import server.events.MapleEvent;
import server.events.MapleEventType;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MonsterDropEntry;
import server.life.OverrideMonsterStats;
import server.maps.MapleMap;
import server.maps.MapleMapFactory;
import server.maps.MapleMapObject;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.database.UniqueIdReset;
import tools.npcgenerator.Instruction;

public class EventManager {
    private /* synthetic */ Map<String, EventInstanceManager> a;
    private /* synthetic */ String ALLATORIxDEMO;
    private /* synthetic */ int K;
    private /* synthetic */ Properties d;
    private /* synthetic */ int k;
    private /* synthetic */ Invocable B;

    public /* synthetic */ EventInstanceManager newInstance(String a2) {
        EventInstanceManager eventInstanceManager;
        EventManager a3;
        EventManager eventManager = a3;
        EventInstanceManager eventInstanceManager2 = eventInstanceManager = new EventInstanceManager(eventManager, a2, a3.K, eventManager.k);
        a3.a.put(a2, eventInstanceManager2);
        return eventInstanceManager2;
    }

    public /* synthetic */ MapleMapFactory getMapFactory() {
        EventManager a2;
        return a2.getChannelServer().getMapFactory();
    }

    public /* synthetic */ void print(String a2) {
        System.out.println("[NPC_DEBUG]:" + a2);
    }

    public /* synthetic */ void startInstance_Party(String a22, MapleCharacter a3) {
        EventManager a4;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a22;
            a22 = (EventInstanceManager)a4.B.invokeFunction(SpecialItemData.ALLATORIxDEMO("@MG]C"), arrobject);
            ((EventInstanceManager)a22).registerParty(a3.getParty(), a3.getMap());
            return;
        }
        catch (NoSuchMethodException | ScriptException a22) {
            System.err.println("Event name : " + a4.ALLATORIxDEMO + ", method Name : setup:\n" + a22);
            FilePrinter.printError(L.ALLATORIxDEMO("jYJA[bNANHJ]\u0001[W["), "Event name : " + a4.ALLATORIxDEMO + ", method Name : setup:\n" + a22);
            return;
        }
    }

    public /* synthetic */ String getProperty(String a2) {
        EventManager a3;
        return a3.d.getProperty(a2);
    }

    public /* synthetic */ Collection<EventInstanceManager> getInstances() {
        EventManager a2;
        return Collections.unmodifiableCollection(a2.a.values());
    }

    public /* synthetic */ String getName() {
        EventManager a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void startInstance(MapleParty a2, MapleMap a3) {
        EventManager a4;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a2.getId();
            EventInstanceManager eventInstanceManager = (EventInstanceManager)a4.B.invokeFunction(L.ALLATORIxDEMO("\\J[Z_"), arrobject);
            MapleParty mapleParty = a2;
            eventInstanceManager.registerParty(mapleParty, a3);
            Iterator<MaplePartyCharacter> iterator = mapleParty.getMembers().iterator();
            while (iterator.hasNext()) {
                MapleCharacter.getCharacterByName(iterator.next().getName()).setSpeedStartTime();
            }
        }
        catch (ScriptException scriptException) {
            System.err.println("Event name : " + a4.ALLATORIxDEMO + ", method Name : setup-partyid:\n" + scriptException);
            FilePrinter.printError(SpecialItemData.ALLATORIxDEMO("mEM]\\~I]ITMA\u0006GPG"), "Event name : " + a4.ALLATORIxDEMO + ", method Name : setup-partyid:\n" + scriptException);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            a4.startInstance_NoID(a2, a3, noSuchMethodException);
        }
    }

    public /* synthetic */ void startInstance() {
        EventManager a2;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = null;
            a2.B.invokeFunction(SpecialItemData.ALLATORIxDEMO("@MG]C"), arrobject);
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name : " + a2.ALLATORIxDEMO + ", method Name : setup:\n" + exception);
            FilePrinter.printError(L.ALLATORIxDEMO("jYJA[bNANHJ]\u0001[W["), "Event name : " + a2.ALLATORIxDEMO + ", method Name : setup:\n" + exception);
            return;
        }
    }

    public /* synthetic */ void startInstance(MapleCharacter a2, String a3) {
        EventManager a4;
        try {
            EventInstanceManager eventInstanceManager;
            Object[] arrobject = new Object[1];
            arrobject[0] = null;
            EventInstanceManager eventInstanceManager2 = eventInstanceManager = (EventInstanceManager)a4.B.invokeFunction(SpecialItemData.ALLATORIxDEMO("@MG]C"), arrobject);
            eventInstanceManager.registerPlayer(a2);
            eventInstanceManager2.setProperty(L.ALLATORIxDEMO("CJNKJ]"), a3);
            eventInstanceManager2.setProperty(SpecialItemData.ALLATORIxDEMO("T]ZDWAW"), String.valueOf(a2.getGuildId()));
            a4.setProperty(L.ALLATORIxDEMO("HZFCKFK"), String.valueOf(a2.getGuildId()));
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name : " + a4.ALLATORIxDEMO + ", method Name : setup-Guild:\n" + exception);
            FilePrinter.printError(SpecialItemData.ALLATORIxDEMO("mEM]\\~I]ITMA\u0006GPG"), "Event name : " + a4.ALLATORIxDEMO + ", method Name : setup-Guild:\n" + exception);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean scheduleSystemEvent(String a2) {
        EventManager eventManager;
        EventManager a3;
        MapleEventType mapleEventType = MapleEventType.getByString(a2);
        int n2 = 0;
        int n3 = 0;
        if (mapleEventType != null) {
            MapleEventType mapleEventType2 = mapleEventType;
            ChannelServer channelServer = ChannelServer.getInstance(mapleEventType2.world, mapleEventType2.channel);
            if (channelServer != null && channelServer.getEvent() == -1 && !channelServer.getEvent(mapleEventType).isRunning()) {
                eventManager = a3;
                MapleEventType mapleEventType3 = mapleEventType;
                n2 = mapleEventType3.channel;
                n3 = mapleEventType3.world;
                return eventManager.scheduleSystemEventInChannel(a2, n3, n2);
            }
            mapleEventType = null;
        }
        eventManager = a3;
        return eventManager.scheduleSystemEventInChannel(a2, n3, n2);
    }

    public /* synthetic */ ScheduledFuture<?> scheduleAtTimestamp(final String a2, long a3) {
        EventManager a4;
        return Timer.EventTimer.getInstance().scheduleAtTimestamp(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                3 a22;
                try {
                    Object[] arrobject = new Object[1];
                    arrobject[0] = null;
                    a22.EventManager.this.B.invokeFunction(a22.a2, arrobject);
                    return;
                }
                catch (NoSuchMethodException | ScriptException exception) {
                    System.err.println("Event name : " + a22.EventManager.this.ALLATORIxDEMO + ", method Name : " + a22.a2 + ":\n" + exception);
                    FilePrinter.printError(Instruction.ALLATORIxDEMO("_\u0017\u007f\u000fn,{\u000f{\u0006\u007f\u00134\u0015b\u0015"), "Event name : " + a22.EventManager.this.ALLATORIxDEMO + ", method Name : " + a22.a2 + ":\n" + exception);
                    return;
                }
            }
            {
                3 a3;
            }
        }, a3);
    }

    public /* synthetic */ MapleMonster getMonster(int a2) {
        return MapleLifeFactory.getMonster(a2);
    }

    public /* synthetic */ OverrideMonsterStats newMonsterStats() {
        return new OverrideMonsterStats();
    }

    public /* synthetic */ EventInstanceManager getInstance(String a2) {
        EventManager a3;
        return a3.a.get(a2);
    }

    public /* synthetic */ List<MapleCharacter> newCharList() {
        return new ArrayList<MapleCharacter>();
    }

    public /* synthetic */ boolean isGamblingTime() {
        return GameSetConstants.isGamblingTime();
    }

    public /* synthetic */ String getServerName() {
        return GameSetConstants.SERVER_NAME;
    }

    public /* synthetic */ void startInstance(MapleCharacter a2) {
        EventManager a3;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a2;
            EventInstanceManager eventInstanceManager = (EventInstanceManager)a3.B.invokeFunction(L.ALLATORIxDEMO("\\J[Z_"), arrobject);
            eventInstanceManager.registerPlayer(a2);
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name : " + a3.ALLATORIxDEMO + ", method Name : setup-character:\n" + exception);
            FilePrinter.printError(SpecialItemData.ALLATORIxDEMO("mEM]\\~I]ITMA\u0006GPG"), "Event name : " + a3.ALLATORIxDEMO + ", method Name : setup-character:\n" + exception);
            return;
        }
    }

    public final /* synthetic */ Properties getProperties() {
        EventManager a2;
        return a2.d;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ boolean scheduleRandomEventInChannel(int a, int a) {
        var3_3 = null;
        var4_4 = MapleEventType.values();
        var5_5 = var4_4.length;
        v0 = var6_6 = 0;
        while (v0 < var5_5) {
            block4: {
                var7_7 = var4_4[var6_6];
                if (var7_7.channel != a) break block4;
                v1 = var3_3 = var7_7.name();
                ** GOTO lbl15
            }
            v0 = ++var6_6;
        }
        block1: while (true) {
            v1 = var3_3;
lbl15:
            // 2 sources

            if (v1 != null) return a.scheduleSystemEventInChannel(var3_3, a, a);
            var4_4 = MapleEventType.values();
            var5_5 = var4_4.length;
            v2 = var6_6 = 0;
            while (true) {
                if (v2 >= var5_5) continue block1;
                var7_7 = var4_4[var6_6];
                if (Randomizer.nextInt(MapleEventType.values().length) == 0) {
                    var3_3 = var7_7.name();
                    continue block1;
                }
                v2 = ++var6_6;
            }
            break;
        }
    }

    public /* synthetic */ void cancel() {
        EventManager a2;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = null;
            a2.B.invokeFunction(SpecialItemData.ALLATORIxDEMO("KRFPM_{P@VLFDV"), arrobject);
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name : " + a2.ALLATORIxDEMO + ", method Name : cancelSchedule:\n" + exception);
            FilePrinter.printError(L.ALLATORIxDEMO("jYJA[bNANHJ]\u0001[W["), "Event name : " + a2.ALLATORIxDEMO + ", method Name : cancelSchedule:\n" + exception);
            return;
        }
    }

    public /* synthetic */ ScheduledFuture<?> schedule(final String a2, long a3, final EventInstanceManager a4) {
        EventManager a5;
        return Timer.EventTimer.getInstance().schedule(new Runnable(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void run() {
                2 a22;
                try {
                    Object[] arrobject = new Object[1];
                    arrobject[0] = a22.a4;
                    a22.EventManager.this.B.invokeFunction(a22.a2, arrobject);
                    return;
                }
                catch (NoSuchMethodException | ScriptException exception) {
                    System.err.println("Event name : " + a22.EventManager.this.ALLATORIxDEMO + ", method Name : " + a22.a2 + ":\n" + exception);
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("zAZYKz^Y^PZE\u0011CGC"), "Event name : " + a22.EventManager.this.ALLATORIxDEMO + ", method Name : " + a22.a2 + ":\n" + exception);
                    return;
                }
            }
        }, a3);
    }

    public /* synthetic */ boolean scheduleSystemEvent() {
        EventManager a2;
        int n2;
        boolean bl = false;
        String string = "";
        LinkedList<String> linkedList = new LinkedList<String>();
        MapleEventType[] arrmapleEventType = MapleEventType.values();
        int n3 = arrmapleEventType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleEventType mapleEventType = arrmapleEventType[n2];
            switch (5.ALLATORIxDEMO[mapleEventType.ordinal()]) {
                case 1: 
                case 2: {
                    break;
                }
                default: {
                    linkedList.add(mapleEventType.name());
                }
            }
            n4 = ++n2;
        }
        string = (String)linkedList.get(Randomizer.rand(0, linkedList.size() - 1));
        a2.scheduleSystemEvent(string);
        return bl;
    }

    public /* synthetic */ ChannelServer getChannelServer() {
        EventManager a2;
        EventManager eventManager = a2;
        return ChannelServer.getInstance(eventManager.K, eventManager.k);
    }

    public /* synthetic */ void startInstance_NoID(MapleParty a2, MapleMap a3, Exception a4) {
        EventManager a5;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = null;
            EventInstanceManager eventInstanceManager = (EventInstanceManager)a5.B.invokeFunction(L.ALLATORIxDEMO("\\J[Z_"), arrobject);
            eventInstanceManager.registerParty(a2, a3);
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name : " + a5.ALLATORIxDEMO + ", method Name : setup-party:\n" + exception);
            FilePrinter.printError(SpecialItemData.ALLATORIxDEMO("mEM]\\~I]ITMA\u0006GPG"), "Event name : " + a5.ALLATORIxDEMO + ", method Name : setup-party:\n" + exception + "\n" + (Serializable)(a4 == null ? L.ALLATORIxDEMO("A@\u000f@CK\u000fJWLJ_[F@A") : a4));
            return;
        }
    }

    public /* synthetic */ void startInstance_NoID(MapleParty a2, MapleMap a3) {
        EventManager a4;
        a4.startInstance_NoID(a2, a3, null);
    }

    public /* synthetic */ void startInstance_Solo(String a22, MapleCharacter a3) {
        EventManager a4;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a22;
            a22 = (EventInstanceManager)a4.B.invokeFunction(SpecialItemData.ALLATORIxDEMO("@MG]C"), arrobject);
            ((EventInstanceManager)a22).registerPlayer(a3);
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            FileoutputUtil.log("logs/Except/\u8173\u672c\u932f\u8aa4.txt", "Event name : " + a4.ALLATORIxDEMO + ", method Name : setup:\n" + a22);
            return;
        }
    }

    public /* synthetic */ void startInstance(String a22, MapleCharacter a3) {
        EventManager a4;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a22;
            a22 = (EventInstanceManager)a4.B.invokeFunction(SpecialItemData.ALLATORIxDEMO("@MG]C"), arrobject);
            MapleCharacter mapleCharacter = a3;
            ((EventInstanceManager)a22).registerCarnivalParty(mapleCharacter, mapleCharacter.getMap(), (byte)0);
            return;
        }
        catch (NoSuchMethodException | ScriptException a22) {
            System.err.println("Event name : " + a4.ALLATORIxDEMO + ", method Name : setup:\n" + a22);
            FilePrinter.printError(L.ALLATORIxDEMO("jYJA[bNANHJ]\u0001[W["), "Event name : " + a4.ALLATORIxDEMO + ", method Name : setup:\n" + a22);
            return;
        }
    }

    public /* synthetic */ void startInstance(MapleSquad a2, MapleMap a3, int a4) {
        EventManager a5;
        a5.startInstance(a2, a3, a4, null);
    }

    public /* synthetic */ int getChannel() {
        EventManager a2;
        return a2.k;
    }

    public /* synthetic */ EventManager(ChannelServer a2, Invocable a3, String a4) {
        EventManager a5;
        EventManager eventManager = a5;
        ChannelServer channelServer = a2;
        EventManager eventManager2 = a5;
        EventManager eventManager3 = a5;
        eventManager2.a = new WeakHashMap<String, EventInstanceManager>();
        eventManager2.d = new Properties();
        eventManager2.B = a3;
        a5.k = channelServer.getChannel();
        eventManager.K = channelServer.getWorld();
        eventManager.ALLATORIxDEMO = a4;
    }

    public /* synthetic */ Invocable getIv() {
        EventManager a2;
        return a2.B;
    }

    public /* synthetic */ void startInstance(MapleSquad a2, MapleMap a3, int a4, String a5) {
        EventManager a6;
        if (a2.getStatus() == 0) {
            return;
        }
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a2.getLeaderName();
            EventInstanceManager eventInstanceManager = (EventInstanceManager)a6.B.invokeFunction(L.ALLATORIxDEMO("\\J[Z_"), arrobject);
            eventInstanceManager.registerSquad(a2, a3, a4, a5);
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name : " + a6.ALLATORIxDEMO + ", method Name : setup-squad:\n" + exception);
            FilePrinter.printError(SpecialItemData.ALLATORIxDEMO("mEM]\\~I]ITMA\u0006GPG"), "Event name : " + a6.ALLATORIxDEMO + ", method Name : setup-squad:\n" + exception);
            return;
        }
    }

    public /* synthetic */ void broadcastYellowMsg(String a2) {
        EventManager a3;
        int n2 = 0;
        if (a2.contains(L.ALLATORIxDEMO("\u8c18")) && !GameSetConstants.SERVER_NAME.equals(SpecialItemData.ALLATORIxDEMO("\u6598\u8731\u4e63\u8c04"))) {
            int n3;
            char[] arrc = a2.toCharArray();
            int n4 = n3 = 0;
            while (n4 < arrc.length) {
                if (arrc[n3] == '\u8c37') {
                    n2 = n3;
                }
                n4 = ++n3;
            }
            if (n2 >= 2) {
                StringBuilder stringBuilder = new StringBuilder(a2);
                stringBuilder.replace(n2 - 2, n2 + 1, GameSetConstants.SERVER_NAME);
                a2 = stringBuilder.toString();
            }
        }
        a3.getChannelServer().broadcastPacket(MaplePacketCreator.yellowChat(a2));
    }

    public /* synthetic */ void warpAllPlayer(int a22, int a32) {
        EventManager a4;
        EventManager eventManager = a4;
        MapleMap a32 = eventManager.getMapFactory().getMap(a32);
        Object a22 = eventManager.getMapFactory().getMap(a22);
        List<MapleCharacter> list = ((MapleMap)a22).getCharactersThreadsafe();
        if (a32 != null && list != null && ((MapleMap)a22).getCharactersSize() > 0) {
            Object object = a22 = list.iterator();
            while (object.hasNext()) {
                MapleMap mapleMap = a32;
                ((MapleCharacter)((MapleMapObject)a22.next())).changeMap(mapleMap, mapleMap.getPortal(0));
                object = a22;
            }
        }
    }

    public /* synthetic */ void startInstance_level(MapleParty a2, MapleMap a3, int a4) {
        EventManager a5;
        int n2;
        block6: {
            int n3 = 0;
            n2 = 0;
            for (MaplePartyCharacter maplePartyCharacter : a2.getMembers()) {
                if (!maplePartyCharacter.isOnline() || maplePartyCharacter.getMapid() != a3.getId() || maplePartyCharacter.getChannel() != a3.getChannel()) continue;
                ++n2;
                n3 += maplePartyCharacter.getLevel();
            }
            if (n2 > 0) break block6;
            return;
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = Math.min(a4, n3 /= n2);
            arrobject[1] = a2.getId();
            EventInstanceManager eventInstanceManager = (EventInstanceManager)a5.B.invokeFunction(L.ALLATORIxDEMO("\\J[Z_"), arrobject);
            eventInstanceManager.registerParty(a2, a3);
            return;
        }
        catch (ScriptException scriptException) {
            System.out.println("Event name : " + a5.ALLATORIxDEMO + ", method Name : setup-partyid:\n" + scriptException);
            FileoutputUtil.log(SpecialItemData.ALLATORIxDEMO("_GT[\u001cmKKVXG\u0007\u007fGTw\u8140\u6704l\u4fa3\u5925\u0006GPG"), "Event name : " + a5.ALLATORIxDEMO + ", method Name : setup-partyid:\n" + scriptException);
            return;
        }
        catch (Exception exception) {
            a5.startInstance_NoID(a2, a3, exception);
            return;
        }
    }

    public /* synthetic */ void broadcastShip(int a2, int a3) {
        EventManager a4;
        a4.getMapFactory().getMap(a2).broadcastMessage(MaplePacketCreator.boatEffect(a3));
    }

    public /* synthetic */ void broadcastServerMsg(int a2, String a3, boolean a4) {
        EventManager a5;
        if (!a4) {
            a5.getChannelServer().broadcastPacket(MaplePacketCreator.broadcastMessage(a2, a3));
            return;
        }
        for (MapleMap mapleMap : a5.getMapFactory().getAllMaps()) {
            if (mapleMap.getCharactersSize() <= 0) continue;
            mapleMap.startMapEffect(a3, a2);
        }
    }

    public /* synthetic */ ScheduledFuture<?> schedule(final String a2, long a3) {
        EventManager a4;
        return Timer.EventTimer.getInstance().schedule(new Runnable(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void run() {
                1 a22;
                try {
                    Object[] arrobject = new Object[1];
                    arrobject[0] = null;
                    a22.EventManager.this.B.invokeFunction(a22.a2, arrobject);
                    return;
                }
                catch (NoSuchMethodException | ScriptException exception) {
                    System.err.println("Event name : " + a22.EventManager.this.ALLATORIxDEMO + ", method Name : " + a22.a2 + ":\n" + exception);
                    FilePrinter.printError(UniqueIdReset.ALLATORIxDEMO("C\u0011c\tr*g\tg\u0000c\u0015(\u0013~\u0013"), "Event name : " + a22.EventManager.this.ALLATORIxDEMO + ", method Name : " + a22.a2 + ":\n" + exception);
                    return;
                }
            }
        }, a3);
    }

    public /* synthetic */ void disposeInstance(String a2) {
        EventManager a3;
        EventManager eventManager = a3;
        eventManager.a.remove(a2);
        if (eventManager.getProperty(SpecialItemData.ALLATORIxDEMO("@\\R\\V")) != null && a3.a.isEmpty()) {
            a3.setProperty(L.ALLATORIxDEMO("\\[N[J"), SpecialItemData.ALLATORIxDEMO("\u0003"));
        }
        if (a3.getProperty(L.ALLATORIxDEMO("CJNKJ]")) != null && a3.a.isEmpty() && a3.getProperty(SpecialItemData.ALLATORIxDEMO("DVIWMA")).equals(L.ALLATORIxDEMO("INC\\J"))) {
            a3.setProperty(SpecialItemData.ALLATORIxDEMO("DVIWMA"), L.ALLATORIxDEMO("[]ZJ"));
        }
        if (a3.ALLATORIxDEMO.equals(SpecialItemData.ALLATORIxDEMO("p\u007fxxb"))) {
            EventManager eventManager2 = a3;
            a2 = ChannelServer.getInstance(eventManager2.K, eventManager2.k).getMapleSquad(L.ALLATORIxDEMO("lxd\u007f~"));
            if (a2 != null) {
                ((MapleSquad)a2).clear();
            }
        }
    }

    public /* synthetic */ void startInstance(EventInstanceManager a22, String a3) {
        EventManager a4;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a22;
            a4.B.invokeFunction(SpecialItemData.ALLATORIxDEMO("@MG]C"), arrobject);
            a22.setProperty(L.ALLATORIxDEMO("CJNKJ]"), a3);
            return;
        }
        catch (NoSuchMethodException | ScriptException a22) {
            System.err.println("Event name : " + a4.ALLATORIxDEMO + ", method Name : setup-leader:\n" + a22);
            FilePrinter.printError(SpecialItemData.ALLATORIxDEMO("mEM]\\~I]ITMA\u0006GPG"), "Event name : " + a4.ALLATORIxDEMO + ", method Name : setup-leader:\n" + a22);
            return;
        }
    }

    public /* synthetic */ void startInstance_CharID(MapleCharacter a2) {
        EventManager a3;
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a2.getId();
            EventInstanceManager eventInstanceManager = (EventInstanceManager)a3.B.invokeFunction(L.ALLATORIxDEMO("\\J[Z_"), arrobject);
            eventInstanceManager.registerPlayer(a2);
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name : " + a3.ALLATORIxDEMO + ", method Name : setup-CharID:\n" + exception);
            FilePrinter.printError(SpecialItemData.ALLATORIxDEMO("mEM]\\~I]ITMA\u0006GPG"), "Event name : " + a3.ALLATORIxDEMO + ", method Name : setup-CharID:\n" + exception);
            return;
        }
    }

    public /* synthetic */ void setProperty(String a2, String a3) {
        EventManager a4;
        a4.d.setProperty(a2, a3);
    }

    public /* synthetic */ boolean scheduleSystemEventInChannel(String a2, int a32, int a4) {
        EventManager a5;
        a2 = MapleEventType.getByString(a2);
        final ChannelServer a32 = ChannelServer.getInstance(a32, a4);
        if (a2 == null || a4 < 1 || a32 == null || a32.getEvent() > -1 || a32.getEvent((MapleEventType)((Object)a2)).isRunning()) {
            return false;
        }
        if ((a2 = MapleEvent.scheduleEvent((MapleEventType)((Object)a2), a32)).length() > 0) {
            a5.broadcastYellowMsg((String)a2);
            return false;
        }
        Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                4 a2;
                if (a2.a32.getEvent() >= 0) {
                    MapleEvent.setEvent(a2.a32, true);
                }
            }
            {
                4 a3;
            }
        }, GameSetConstants.SERVER_NAME.equals(L.ALLATORIxDEMO("\u697c\u4e64\u75fa")) ? 600000L : 180000L);
        return true;
    }

    public /* synthetic */ int getChannelOnline() {
        EventManager a2;
        return a2.getChannelServer().getConnectedClients();
    }

    public /* synthetic */ void startInstance(MapleSquad a2, MapleMap a3) {
        EventManager a4;
        a4.startInstance(a2, a3, -1, null);
    }
}

