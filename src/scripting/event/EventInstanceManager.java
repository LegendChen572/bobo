/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6070\u6070\u8c37
 */
package scripting.event;

import FuckingHackerToby.F;
import FuckingHackerToby.fc;
import client.MapleCharacter;
import client.MapleQuestStatus;
import client.messages.commands.PracticerCommand;
import client.messages.commands.player.\u6070\u6070\u8c37;
import handling.channel.ChannelServer;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.script.ScriptException;
import scripting.event.EventManager;
import scripting.npc.NPCScriptManager;
import server.MapleCarnivalParty;
import server.MapleItemInformationProvider;
import server.MapleSquad;
import server.Timer;
import server.life.MapleMonster;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.MapleMap;
import server.maps.MapleMapFactory;
import server.quest.MapleQuest;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.packet.UIPacket;

public class EventInstanceManager {
    private /* synthetic */ long I;
    private /* synthetic */ List<MapleMonster> D;
    private /* synthetic */ List<Integer> h;
    private /* synthetic */ List<MapleCharacter> f;
    private final /* synthetic */ String J;
    private final /* synthetic */ Lock B;
    private /* synthetic */ Properties M;
    private /* synthetic */ boolean K;
    private final /* synthetic */ int i;
    private /* synthetic */ boolean k;
    private final /* synthetic */ Map<Integer, Map<String, Long>> A;
    private /* synthetic */ ScheduledFuture<?> e;
    private final /* synthetic */ EventManager j;
    private /* synthetic */ long F;
    private final /* synthetic */ Map<Integer, Integer> ALLATORIxDEMO;
    private /* synthetic */ List<Integer> C;
    private /* synthetic */ List<Boolean> H;
    private final /* synthetic */ Lock g;
    private final /* synthetic */ int a;
    private /* synthetic */ Map<Integer, Integer> L;
    private final /* synthetic */ List<Integer> d;
    private final /* synthetic */ ReentrantReadWriteLock E;

    public final /* synthetic */ void disbandParty() {
        EventInstanceManager a2;
        if (a2.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a2;
            a2.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"'\u00070\f\"\u0000'>\"\u001c7\u0017"), arrobject);
            return;
        }
        catch (Exception exception) {
            System.out.println("Event name" + a2.j.getName() + ", Instance name : " + a2.J + ", method Name : disbandParty:\n" + exception);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a2.j.getName() + ", Instance name : " + a2.J + ", method Name : disbandParty:\n" + exception);
            return;
        }
    }

    public final /* synthetic */ String getName() {
        EventInstanceManager a2;
        return a2.J;
    }

    public /* synthetic */ void addShowDeathCountMap(int a2) {
        EventInstanceManager a3;
        a3.d.add(a2);
        Iterator<MapleCharacter> iterator = a3.f.iterator();
        while (iterator.hasNext()) {
            MapleCharacter mapleCharacter = iterator.next();
            if (mapleCharacter.getMapId() != a2 || a3.getDeathCount(mapleCharacter.getId()) == -1) continue;
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.getDeathCountInfo(false, a3.getDeathCount(mapleCharacter.getId())));
        }
    }

    public final /* synthetic */ void broadcastPacket(byte[] a2) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getClient().sendPacket(a2);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void registerCarnivalParty(MapleCharacter a2, MapleMap a3, byte a4, MapleMap a5) {
        Iterator noSuchMethodException;
        Object object2;
        EventInstanceManager a6;
        if (a6.k) {
            return;
        }
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.clearCarnivalRequests();
        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
        MapleParty mapleParty = mapleCharacter.getParty();
        int n2 = 0;
        if (mapleParty == null) {
            return;
        }
        Object object = object2 = mapleParty.getMembers().iterator();
        while (object.hasNext()) {
            ++n2;
            MaplePartyCharacter object4 = object2.next();
            object = object2;
        }
        if (a5 != null && n2 != ((MapleMap)a5).characterSize() && ((MapleMap)a5).characterSize() != 0) {
            MapleCharacter mapleCharacter2 = a2;
            mapleCharacter2.changeMap(mapleCharacter2.getMap(), a2.getMap().getPortal(0));
            mapleCharacter2.dropMessage(6, \u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u512a\u96e4\u4ef9\u6516\u4e65\u4e63\u76bb\u7b27"));
            return;
        }
        if ((n2 <= 1 || a5 != null && ((MapleMap)a5).characterSize() <= 1) && a2.isPlayer()) {
            MapleCharacter mapleCharacter3 = a2;
            mapleCharacter3.changeMap(mapleCharacter3.getMap(), a2.getMap().getPortal(0));
            mapleCharacter3.dropMessage(6, Timer.ALLATORIxDEMO("\u4eda\u656c\u7510\u5e2c"));
            return;
        }
        for (MaplePartyCharacter scriptException : mapleParty.getMembers()) {
            a5 = a3.getCharacterById(scriptException.getId());
            if (a5 == null) continue;
            linkedList.add((MapleCharacter)a5);
            Object object3 = a5;
            a6.registerPlayer((MapleCharacter)object3);
            ((MapleCharacter)object3).resetCP();
        }
        object2 = new MapleCarnivalParty(a2, linkedList, a4);
        Iterator iterator = noSuchMethodException = linkedList.iterator();
        while (iterator.hasNext()) {
            a5 = (MapleCharacter)noSuchMethodException.next();
            iterator = noSuchMethodException;
            ((MapleCharacter)a5).setCarnivalParty((MapleCarnivalParty)object2);
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a6;
            arrobject[1] = object2;
            a6.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001c&\t*\u001d7\u000b1-\"\u001c-\u00075\u000f/>\"\u001c7\u0017"), arrobject);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return;
        }
        catch (ScriptException scriptException) {
            System.err.println("Event name" + a6.j.getName() + ", Instance name : " + a6.J + ", method Name : registerCarnivalParty:\n" + scriptException);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a6.j.getName() + ", Instance name : " + a6.J + ", method Name : registerCarnivalParty:\n" + scriptException);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException2) {
            return;
        }
    }

    public /* synthetic */ void startEventTimer(long a2) {
        EventInstanceManager a3;
        a3.restartEventTimer(a2);
    }

    public /* synthetic */ void registerMonster(MapleMonster a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        a3.D.add(a2);
        a2.setEventInstance(a3);
    }

    public final /* synthetic */ void registerCarnivalParty(MapleCharacter a2, MapleMap a3, byte a4) {
        Iterator rejectedExecutionException;
        MapleCharacter mapleCharacter;
        EventInstanceManager a5;
        if (a5.k) {
            return;
        }
        MapleCharacter mapleCharacter2 = a2;
        mapleCharacter2.clearCarnivalRequests();
        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
        Object object2 = mapleCharacter2.getParty();
        if (object2 == null) {
            return;
        }
        for (MaplePartyCharacter object3 : ((MapleParty)object2).getMembers()) {
            mapleCharacter = a3.getCharacterById(object3.getId());
            if (mapleCharacter == null) continue;
            linkedList.add(mapleCharacter);
            MapleCharacter mapleCharacter3 = mapleCharacter;
            a5.registerPlayer(mapleCharacter3);
            mapleCharacter3.resetCP();
        }
        object2 = new MapleCarnivalParty(a2, linkedList, a4);
        Iterator iterator = rejectedExecutionException = linkedList.iterator();
        while (iterator.hasNext()) {
            mapleCharacter = (MapleCharacter)rejectedExecutionException.next();
            iterator = rejectedExecutionException;
            mapleCharacter.setCarnivalParty((MapleCarnivalParty)object2);
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a5;
            arrobject[1] = object2;
            a5.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001c&\t*\u001d7\u000b1-\"\u001c-\u00075\u000f/>\"\u001c7\u0017"), arrobject);
            return;
        }
        catch (RejectedExecutionException scriptException) {
            return;
        }
        catch (ScriptException noSuchMethodException) {
            System.err.println("Event name" + a5.j.getName() + ", Instance name : " + a5.J + ", method Name : registerCarnivalParty:\n" + noSuchMethodException);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a5.j.getName() + ", Instance name : " + a5.J + ", method Name : registerCarnivalParty:\n" + noSuchMethodException);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return;
        }
    }

    public /* synthetic */ void dispose() {
        EventInstanceManager a2;
        a2.B.lock();
        try {
            a2.dispose_NoLock();
            return;
        }
        finally {
            a2.B.unlock();
        }
    }

    public final /* synthetic */ MapleMapFactory getMapFactory() {
        EventInstanceManager a2;
        return a2.getChannelServer().getMapFactory();
    }

    public final /* synthetic */ void gainItem(int a2, int a3, int a4) {
        EventInstanceManager a5;
        if (a5.k) {
            return;
        }
        for (MapleCharacter mapleCharacter : a5.getPlayers()) {
            if (mapleCharacter.getBossLog("\u526f\u672c\u7372\u5f97:" + a2) < a4) {
                mapleCharacter.setBossLog("\u526f\u672c\u7372\u5f97:" + a2);
                mapleCharacter.gainItem(a2, a3);
                continue;
            }
            mapleCharacter.dropMessage("\u60a8\u4eca\u65e5\u5df2\u7d93\u7372\u5f97\u904e\u734e\u52f5: " + MapleItemInformationProvider.getInstance().getName(a2) + " ,\u7121\u6cd5\u518d\u6b21\u7372\u5f97!");
        }
    }

    public /* synthetic */ boolean check1() {
        EventInstanceManager a2;
        for (MapleCharacter mapleCharacter : a2.getPlayers()) {
            if (mapleCharacter.getLevel() >= 51 && mapleCharacter.getLevel() <= 120) continue;
            return false;
        }
        return true;
    }

    public /* synthetic */ void clearsquad(String a2) {
        EventInstanceManager a3;
        EventInstanceManager eventInstanceManager = a3;
        a2 = ChannelServer.getInstance(eventInstanceManager.a, eventInstanceManager.i).getMapleSquad((String)a2);
        if (a2 != null) {
            ((MapleSquad)a2).clear();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ MapleMap getMapInstance(int a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return null;
        }
        try {
            MapleMap mapleMap;
            boolean bl;
            int n2;
            boolean bl2 = false;
            if (a2 >= a3.C.size()) {
                n2 = a2;
                bl = bl2;
            } else {
                n2 = a3.C.get(a2);
                bl = bl2 = a3.H.get(a2).booleanValue();
            }
            if (!bl) {
                mapleMap = a3.getMapFactory().getMap(n2);
                if (mapleMap == null) {
                    return null;
                }
                if (mapleMap.getCharactersSize() != 0 || a3.j.getProperty(Timer.ALLATORIxDEMO("g\ba\u0006r\fq2q\u0001w\u0014{\u0012g")) == null || !a3.j.getProperty(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001d+\u001b%\b/\u000b\u0011\u000b\"\r7\u00011\u001d")).equals(Timer.ALLATORIxDEMO("\u0014f\u0015q"))) return mapleMap;
                MapleMap mapleMap2 = mapleMap;
                mapleMap2.shuffleReactors();
                return mapleMap2;
            } else {
                mapleMap = a3.getMapFactory().getInstanceMap(n2);
                if (mapleMap == null) {
                    return null;
                }
                if (mapleMap.getCharactersSize() != 0 || a3.j.getProperty(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001d+\u001b%\b/\u000b\u0011\u000b\"\r7\u00011\u001d")) == null || !a3.j.getProperty(Timer.ALLATORIxDEMO("g\ba\u0006r\fq2q\u0001w\u0014{\u0012g")).equals(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"7\u001c6\u000b"))) return mapleMap;
                mapleMap.shuffleReactors();
            }
            return mapleMap;
        }
        catch (NullPointerException nullPointerException) {
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), nullPointerException);
            return null;
        }
    }

    public /* synthetic */ void print(String a2) {
        System.out.println("[NPC_DEBUG]:" + a2);
    }

    public /* synthetic */ void applyBuff(MapleCharacter a2, int a3) {
        MapleItemInformationProvider.getInstance().getItemEffect(a3).applyTo(a2);
        a2.getClient().sendPacket(UIPacket.getStatusMsg(a3));
    }

    public final /* synthetic */ void CreateSpeedTime(String a2) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().CreateSpeedTime(a2);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ EventManager getEventManager() {
        EventInstanceManager a2;
        return a2.j;
    }

    public /* synthetic */ void changedMap(MapleCharacter a22, int a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[3];
            arrobject[0] = a4;
            arrobject[1] = a22;
            arrobject[2] = a3;
            a4.j.getIv().invokeFunction(Timer.ALLATORIxDEMO("\u0003|\u0001z\u0007q\u0004Y\u0001d"), arrobject);
            return;
        }
        catch (NullPointerException a22) {
            return;
        }
        catch (Exception a22) {
            FilePrinter.printError(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0006\u0018&\u00007'-\u001d7\u000f-\r&#\"\u0000\"\t&\u001cm\u001a;\u001a"), "Event name" + a4.j.getName() + ", Instance name : " + a4.J + ", method Name : changedMap:\n" + a22);
            System.err.println("Event name" + a4.j.getName() + ", Instance name : " + a4.J + ", method Name : changedMap:\n" + a22);
            return;
        }
    }

    public final /* synthetic */ void schedule(final String a2, long a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                2 a22;
                if (a22.EventInstanceManager.this.k || a22.EventInstanceManager.this == null || a22.EventInstanceManager.this.j == null) {
                    return;
                }
                try {
                    Object[] arrobject = new Object[1];
                    arrobject[0] = a22.EventInstanceManager.this;
                    a22.EventInstanceManager.this.j.getIv().invokeFunction(a22.a2, arrobject);
                    return;
                }
                catch (NullPointerException nullPointerException) {
                    return;
                }
                catch (RejectedExecutionException rejectedExecutionException) {
                    return;
                }
                catch (NoSuchMethodException | ScriptException exception) {
                    System.err.println("Event name" + a22.EventInstanceManager.this.j.getName() + ", Instance name : " + a22.EventInstanceManager.this.J + ", method Name : " + a22.a2 + ":\n" + exception);
                    FilePrinter.printError(fc.ALLATORIxDEMO("R$r<c\u001by!c3y1r\u001fv<v5r 9&o&"), "Event name" + a22.EventInstanceManager.this.j.getName() + ", Instance name : " + a22.EventInstanceManager.this.J + ", method Name : " + a22.a2 + ":\n" + exception);
                    return;
                }
            }
            {
                2 a3;
            }
        }, a3);
    }

    public final /* synthetic */ List<Pair<Integer, MapleCharacter>> newPair_chr() {
        return new ArrayList<Pair<Integer, MapleCharacter>>();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void playerDisconnected(MapleCharacter a2, int a3) {
        EventInstanceManager eventInstanceManager;
        byte by;
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a4;
            arrobject[1] = a2;
            by = ((Double)a4.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"3\u0002\"\u0017&\u001c\u0007\u00070\r,\u0000-\u000b \u001a&\n"), arrobject)).byteValue();
            eventInstanceManager = a4;
        }
        catch (Exception exception) {
            by = 0;
            eventInstanceManager = a4;
        }
        eventInstanceManager.B.lock();
        try {
            EventInstanceManager eventInstanceManager2;
            block15: {
                block14: {
                    block13: {
                        if (a4.k) {
                            return;
                        }
                        a4.h.add(a3);
                        if (a2 != null) {
                            a4.ALLATORIxDEMO((MapleCharacter)a2);
                        }
                        if (by != 0) break block13;
                        if (a4.getPlayerCount() > 0) break block14;
                        EventInstanceManager eventInstanceManager3 = a4;
                        eventInstanceManager2 = eventInstanceManager3;
                        eventInstanceManager3.dispose_NoLock();
                        break block15;
                    }
                    if (by > 0 && a4.getPlayerCount() < by || by < 0 && (a4.isLeader((MapleCharacter)a2) || a4.getPlayerCount() < by * -1)) {
                        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>(a4.f);
                        for (MapleCharacter mapleCharacter : linkedList) {
                            if (mapleCharacter.getId() == a3) continue;
                            a4.removePlayer(mapleCharacter);
                        }
                        a4.dispose_NoLock();
                    }
                }
                eventInstanceManager2 = a4;
            }
            eventInstanceManager2.B.unlock();
            return;
        }
        catch (Exception exception) {
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), exception);
            return;
        }
        finally {
            a4.B.unlock();
        }
    }

    public /* synthetic */ List<String> getAggroRank(int a42) {
        EventInstanceManager a5;
        Object object = null;
        if (a5.A.containsKey(a42)) {
            object = a5.A.get(a42);
        }
        if (object == null) {
            object = new TreeMap();
        }
        Object a42 = new ArrayList(object.entrySet());
        Collections.sort(a42, (a2, a3) -> ((Long)a2.getValue()).compareTo((Long)a3.getValue()));
        object = new ArrayList();
        Object object2 = a42 = a42.iterator();
        while (object2.hasNext()) {
            Map.Entry entry = (Map.Entry)a42.next();
            object.add((String)entry.getKey());
            object2 = a42;
        }
        return object;
    }

    public /* synthetic */ int getKillCount(MapleCharacter a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return 0;
        }
        if ((a2 = a3.L.get(((MapleCharacter)a2).getId())) == null) {
            return 0;
        }
        return (Integer)a2;
    }

    public final /* synthetic */ void broadcastPlayerMsg(int a2, String a3) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a4.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getClient().sendPacket(MaplePacketCreator.broadcastMessage(a2, a3));
            iterator2 = iterator;
        }
    }

    public /* synthetic */ boolean isTimerStarted() {
        EventInstanceManager a2;
        return a2.F > 0L && a2.I > 0L;
    }

    public /* synthetic */ EventInstanceManager(EventManager a2, String a3, int a4, int a5) {
        EventInstanceManager a6;
        EventInstanceManager eventInstanceManager = a6;
        EventInstanceManager eventInstanceManager2 = a6;
        EventInstanceManager eventInstanceManager3 = a6;
        EventInstanceManager eventInstanceManager4 = a6;
        EventInstanceManager eventInstanceManager5 = a6;
        EventInstanceManager eventInstanceManager6 = a6;
        EventInstanceManager eventInstanceManager7 = a6;
        a6.A = new TreeMap<Integer, Map<String, Long>>();
        eventInstanceManager7.f = new LinkedList<MapleCharacter>();
        a6.h = new LinkedList<Integer>();
        a6.D = new LinkedList<MapleMonster>();
        a6.L = new HashMap<Integer, Integer>();
        a6.M = new Properties();
        eventInstanceManager6.I = 0L;
        eventInstanceManager6.F = 0L;
        eventInstanceManager5.C = new LinkedList<Integer>();
        eventInstanceManager5.H = new LinkedList<Boolean>();
        eventInstanceManager5.E = new ReentrantReadWriteLock();
        eventInstanceManager5.g = eventInstanceManager5.E.readLock();
        eventInstanceManager5.B = eventInstanceManager5.E.writeLock();
        eventInstanceManager4.k = false;
        eventInstanceManager3.K = false;
        eventInstanceManager4.d = new LinkedList<Integer>();
        eventInstanceManager3.ALLATORIxDEMO = new TreeMap<Integer, Integer>();
        eventInstanceManager2.j = a2;
        eventInstanceManager2.J = a3;
        eventInstanceManager.i = a5;
        eventInstanceManager.a = a4;
    }

    public /* synthetic */ boolean revivePlayer(MapleCharacter a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return false;
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a3;
            arrobject[1] = a22;
            a22 = a3.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"3\u0002\"\u0017&\u001c\u0011\u000b5\u00075\u000b"), arrobject);
            if (a22 instanceof Boolean) {
                return (Boolean)a22;
            }
        }
        catch (RejectedExecutionException a22) {
        }
        catch (NoSuchMethodException | ScriptException a22) {
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : playerRevive:\n" + a22);
            System.err.println("Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : playerRevive:\n" + a22);
        }
        return true;
    }

    public final /* synthetic */ void setBossLog(String a2) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().setBossLog(a2);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ MapleMap setInstanceMap(int a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return a3.getMapFactory().getMap(a2);
        }
        EventInstanceManager eventInstanceManager = a3;
        eventInstanceManager.C.add(a2);
        a3.H.add(false);
        return eventInstanceManager.getMapFactory().getMap(a2);
    }

    public final /* synthetic */ void broadcastShowMapEffect(String a2) {
        EventInstanceManager a3;
        a3.broadcastShowMapEffect(true, a2);
    }

    public final /* synthetic */ MapleMap createInstanceMapS(int a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return null;
        }
        EventInstanceManager eventInstanceManager = a3;
        int n2 = eventInstanceManager.getChannelServer().getEventSM().getNewInstanceMapId();
        eventInstanceManager.C.add(n2);
        a3.H.add(true);
        return eventInstanceManager.getMapFactory().CreateInstanceMap(a2, false, false, false, n2);
    }

    public /* synthetic */ void registerSquad(MapleSquad a2, MapleMap a322, int a4, String a5) {
        EventInstanceManager a6;
        if (a6.k) {
            return;
        }
        int a322 = a322.getId();
        for (String string : a2.getMembers()) {
            MapleCharacter object = a2.getChar(string);
            if (object == null || object.getMapId() != a322) continue;
            if (a4 > 0) {
                object.getQuestNAdd(MapleQuest.getInstance(a4)).setCustomData(String.valueOf(System.currentTimeMillis()));
            }
            if (a5 != null) {
                object.setBossLog(a5);
            }
            a6.registerPlayer(object);
        }
        MapleSquad mapleSquad = a2;
        mapleSquad.setStatus((byte)2);
        mapleSquad.getBeginMap().broadcastMessage(MaplePacketCreator.stopClock());
    }

    public /* synthetic */ void registerParty(MapleParty a2, MapleMap a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        Object object = a2 = ((MapleParty)a2).getMembers().iterator();
        while (object.hasNext()) {
            Serializable serializable = (MaplePartyCharacter)a2.next();
            serializable = a3.getCharacterById(serializable.getId());
            object = a2;
            a4.registerPlayer((MapleCharacter)serializable);
        }
    }

    public final /* synthetic */ void killAllPlayers() {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a2;
        if (a2.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().kill();
            iterator2 = iterator;
        }
    }

    public /* synthetic */ List<MapleMonster> getMobs() {
        EventInstanceManager a2;
        return a2.D;
    }

    public /* synthetic */ void timeOut(long a2, final EventInstanceManager a3) {
        EventInstanceManager a4;
        if (a4.k || a3 == null) {
            return;
        }
        a4.e = Timer.EventTimer.getInstance().schedule(new Runnable(){
            {
                1 a32;
            }

            @Override
            public /* synthetic */ void run() {
                1 a2;
                if (a2.EventInstanceManager.this.k || a2.a3 == null || a2.EventInstanceManager.this.j == null) {
                    return;
                }
                try {
                    Object[] arrobject = new Object[1];
                    arrobject[0] = a2.a3;
                    a2.EventInstanceManager.this.j.getIv().invokeFunction(PracticerCommand.ALLATORIxDEMO("t\u0018o\u001ec\u000ek\u001ec/n\u0016b\u0014r\u000f"), arrobject);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(FuckingHackerToby.F.ALLATORIxDEMO("m:M\"\\\u0005F?\\-F/M\u0001I\"I+M>\u00068P8"), "Event name " + a2.EventInstanceManager.this.j.getName() + ", Instance name : " + a2.EventInstanceManager.this.J + ", method Name : scheduledTimeout:\n" + exception);
                    System.err.println("Event name" + a2.EventInstanceManager.this.j.getName() + ", Instance name : " + a2.EventInstanceManager.this.J + ", method Name : scheduledTimeout:\n" + exception);
                    return;
                }
            }
        }, a2);
    }

    public /* synthetic */ void monsterKilled(MapleCharacter a2, MapleMonster a3) {
        int n2;
        Integer n3;
        EventInstanceManager a4;
        block12: {
            if (a4.k) {
                return;
            }
            n3 = a4.L.get(a2.getId());
            Object[] arrobject = new Object[2];
            arrobject[0] = a4;
            arrobject[1] = a3.getId();
            n2 = (Integer)a4.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)".\u0001-\u001d7\u000b18\"\u00026\u000b"), arrobject);
            if (!a4.k) break block12;
            return;
        }
        try {
            EventInstanceManager eventInstanceManager;
            if (n3 == null) {
                n3 = n2;
                eventInstanceManager = a4;
            } else {
                n3 = n3 + n2;
                eventInstanceManager = a4;
            }
            eventInstanceManager.L.put(a2.getId(), n3);
            if (a2.getCarnivalParty() != null && (a3.getStats().getPoint() > 0 || a3.getStats().getCP() > 0)) {
                Object[] arrobject = new Object[3];
                arrobject[0] = a4;
                arrobject[1] = a2;
                MapleMonster mapleMonster = a3;
                arrobject[2] = a3.getStats().getCP() > 0 ? mapleMonster.getStats().getCP() : mapleMonster.getStats().getPoint();
                a4.j.getIv().invokeFunction(Timer.ALLATORIxDEMO("y\u000fz\u0013`\u0005f+}\fx\u0005p"), arrobject);
                return;
            }
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            EventInstanceManager eventInstanceManager;
            String string;
            EventInstanceManager eventInstanceManager2;
            String string2;
            if (a4.j == null) {
                string2 = \u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u001b/\u0002");
                eventInstanceManager2 = a4;
            } else {
                string2 = a4.j.getName();
                eventInstanceManager2 = a4;
            }
            System.err.println("Event name" + string2 + ", Instance name : " + eventInstanceManager2.J + ", method Name : monsterValue:\n" + exception);
            String string3 = Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`");
            if (a4.j == null) {
                string = \u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u001b/\u0002");
                eventInstanceManager = a4;
            } else {
                string = a4.j.getName();
                eventInstanceManager = a4;
            }
            FilePrinter.printError(string3, "Event name" + string + ", Instance name : " + eventInstanceManager.J + ", method Name : monsterValue:\n" + exception);
        }
    }

    public /* synthetic */ void onMapLoad(MapleCharacter a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a3;
            arrobject[1] = a22;
            a3.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0001-#\"\u001e\u000f\u0001\"\n"), arrobject);
            return;
        }
        catch (RejectedExecutionException a22) {
            return;
        }
        catch (ScriptException a22) {
            System.err.println("Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : onMapLoad:\n" + a22);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : onMapLoad:\n" + a22);
            return;
        }
        catch (NoSuchMethodException a22) {
            return;
        }
    }

    public /* synthetic */ void disposeNow() {
        AbstractAnimatedMapleMapObject abstractAnimatedMapleMapObject;
        EventInstanceManager a2;
        if (a2.k || a2.j == null) {
            return;
        }
        String string = a2.j.getName();
        a2.k = true;
        Iterator<AbstractAnimatedMapleMapObject> iterator = a2.f.iterator();
        Iterator<AbstractAnimatedMapleMapObject> iterator2 = iterator;
        while (iterator2.hasNext()) {
            abstractAnimatedMapleMapObject = iterator.next();
            iterator2 = iterator;
            ((MapleCharacter)abstractAnimatedMapleMapObject).setEventInstance(null);
        }
        try {
            int n2;
            a2.f.clear();
            a2.f = null;
            iterator = a2.D.iterator();
            Iterator<AbstractAnimatedMapleMapObject> iterator3 = iterator;
            while (iterator3.hasNext()) {
                abstractAnimatedMapleMapObject = (MapleMonster)iterator.next();
                iterator3 = iterator;
                ((MapleMonster)abstractAnimatedMapleMapObject).setEventInstance(null);
            }
            EventInstanceManager eventInstanceManager = a2;
            eventInstanceManager.D.clear();
            a2.D = null;
            eventInstanceManager.L.clear();
            a2.A.clear();
            a2.L = null;
            a2.h.clear();
            a2.h = null;
            a2.I = 0L;
            a2.F = 0L;
            a2.M.clear();
            a2.M = null;
            int n3 = n2 = 0;
            while (n3 < a2.C.size()) {
                if (a2.H.get(n2).booleanValue()) {
                    a2.getMapFactory().removeInstanceMap(a2.C.get(n2));
                }
                n3 = ++n2;
            }
            a2.C.clear();
            a2.C = null;
            a2.H.clear();
            a2.H = null;
            a2.j.disposeInstance(a2.J);
            return;
        }
        catch (Exception exception) {
            System.err.println("Caused by : " + string + " instance name: " + a2.J + " method: dispose: " + exception);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Caused by : " + string + " instance name: " + a2.J + " method: dispose: " + exception);
            return;
        }
    }

    public final /* synthetic */ MapleMap createInstanceMapNoMob(int a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return null;
        }
        EventInstanceManager eventInstanceManager = a3;
        int n2 = eventInstanceManager.getChannelServer().getEventSM().getNewInstanceMapId();
        eventInstanceManager.C.add(n2);
        a3.H.add(true);
        return eventInstanceManager.getMapFactory().CreateInstanceMap(a2, true, true, true, n2, 1110101);
    }

    public final /* synthetic */ void saveMP(int a2) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().modifyCSPoints(2, a2, true);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ void stopEventTimer() {
        EventInstanceManager a2;
        a2.F = 0L;
        a2.I = 0L;
        if (a2.e != null) {
            a2.e.cancel(false);
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void registerPlayer(MapleCharacter a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[CATCHBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public final /* synthetic */ MapleMap createInstanceMap(int a2, int a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return null;
        }
        EventInstanceManager eventInstanceManager = a4;
        int n2 = eventInstanceManager.getChannelServer().getEventSM().getNewInstanceMapId();
        eventInstanceManager.C.add(n2);
        a4.H.add(true);
        return eventInstanceManager.getMapFactory().CreateInstanceMap(a2, true, true, true, n2, a3);
    }

    public final /* synthetic */ void broadcastTeamPacket(byte[] a2, int a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        for (MapleCharacter mapleCharacter : a4.getPlayers()) {
            if (mapleCharacter.getTeam() != a3) continue;
            mapleCharacter.getClient().sendPacket(a2);
        }
    }

    public /* synthetic */ List<MapleCharacter> getPlayers() {
        EventInstanceManager a2;
        if (a2.k) {
            return Collections.emptyList();
        }
        a2.g.lock();
        try {
            LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>(a2.f);
            return linkedList;
        }
        finally {
            a2.g.unlock();
        }
    }

    public /* synthetic */ void unregisterPlayer(MapleCharacter a2) {
        EventInstanceManager a3;
        if (a3.k) {
            a2.setEventInstance(null);
            return;
        }
        a3.B.lock();
        try {
            a3.ALLATORIxDEMO(a2);
            return;
        }
        finally {
            a3.B.unlock();
        }
    }

    public /* synthetic */ boolean check() {
        EventInstanceManager a2;
        for (MapleCharacter mapleCharacter : a2.getPlayers()) {
            if (mapleCharacter.getLevel() >= 30 && mapleCharacter.getLevel() <= 50) continue;
            return false;
        }
        return true;
    }

    public final /* synthetic */ void broadcastPyramidLife(int a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        byte[] a22 = UIPacket.sendNewPyramidLife(a22);
        for (MapleCharacter mapleCharacter : a3.getPlayers()) {
            if (mapleCharacter == null) continue;
            mapleCharacter.getClient().sendPacket(a22);
        }
    }

    public final /* synthetic */ void finishPQ() {
        EventInstanceManager a2;
        if (a2.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[1];
            arrobject[0] = a2;
            a2.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\r/\u000b\"\u001c\u0013?"), arrobject);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Event name" + a2.j.getName() + ", Instance name : " + a2.J + ", method Name : clearPQ:\n" + exception);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a2.j.getName() + ", Instance name : " + a2.J + ", method Name : clearPQ:\n" + exception);
            return;
        }
    }

    public final /* synthetic */ void showWZEffect(String a2) {
        EventInstanceManager a3;
        Iterator<MapleCharacter> iterator;
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getClient().sendPacket(UIPacket.ShowWZEffect(a2));
            iterator2 = iterator;
        }
    }

    public /* synthetic */ void addToPair(List<Pair<Integer, String>> a2, int a3, String a4) {
        a2.add(new Pair<Integer, String>(a3, a4));
    }

    public /* synthetic */ boolean isShowDeathCountMap(int a2) {
        EventInstanceManager a3;
        Iterator<Integer> iterator = a3.d.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != a2) continue;
            return true;
        }
        return false;
    }

    public final /* synthetic */ void removePlayer(MapleCharacter a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a3;
            arrobject[1] = a22;
            a3.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"3\u0002\"\u0017&\u001c\u0006\u0016*\u001a"), arrobject);
            return;
        }
        catch (RejectedExecutionException a22) {
            return;
        }
        catch (NoSuchMethodException | ScriptException a22) {
            System.err.println("Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : playerExit:\n" + a22);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : playerExit:\n" + a22);
            return;
        }
    }

    public final /* synthetic */ void leftParty(MapleCharacter a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a3;
            arrobject[1] = a22;
            a3.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0002&\b7>\"\u001c7\u0017"), arrobject);
            return;
        }
        catch (Exception a22) {
            System.err.println("Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : leftParty:\n" + a22);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : leftParty:\n" + a22);
            return;
        }
    }

    public /* synthetic */ void registerMapMonster() {
        EventInstanceManager a2;
        if (a2.k) {
            return;
        }
        Iterator<MapleMap> iterator = a2.getAllMapInstances().iterator();
        while (iterator.hasNext()) {
            Iterator<MapleMonster> iterator2 = iterator.next().getAllMonstersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                Iterator<MapleMonster> iterator3;
                MapleMonster mapleMonster = iterator3.next();
                Iterator<MapleMonster> iterator4 = a2.D.iterator();
                block2: while (true) {
                    Iterator<MapleMonster> iterator5 = iterator4;
                    while (iterator5.hasNext()) {
                        if (iterator4.next().getObjectId() != mapleMonster.getObjectId()) continue block2;
                        iterator5 = iterator4;
                    }
                    break;
                }
                a2.D.add(mapleMonster);
                mapleMonster.setEventInstance(a2);
                iterator2 = iterator3;
            }
        }
    }

    public /* synthetic */ ChannelServer getChannelServer() {
        EventInstanceManager a2;
        EventInstanceManager eventInstanceManager = a2;
        return ChannelServer.getInstance(eventInstanceManager.a, eventInstanceManager.i);
    }

    public /* synthetic */ void addAggroRankMobDamage(int a2, int a32, String a4, int a5) {
        int n2;
        long l2;
        EventInstanceManager a6;
        Object a32 = null;
        if (a6.A.containsKey(a2)) {
            a32 = a6.A.get(a2);
        }
        if (a32 == null) {
            a32 = new TreeMap<String, Long>();
        }
        TreeMap<String, Long> treeMap = a32;
        String string = a4;
        if (treeMap.containsKey(string)) {
            l2 = (Long)a32.get(a4);
            n2 = a5;
        } else {
            l2 = 0L;
            n2 = a5;
        }
        treeMap.put(string, l2 + (long)n2);
        a6.A.put(a2, (Map<String, Long>)a32);
        a32 = a6.f.iterator();
        Object object = a32;
        while (object.hasNext()) {
            a4 = (MapleCharacter)a32.next();
            if (((MapleCharacter)a4).getMapId() != a2) {
                object = a32;
                continue;
            }
            ((MapleCharacter)a4).getClient().sendPacket(MaplePacketCreator.getAggroRankInfo(a6.getAggroRank(a2)));
            object = a32;
        }
    }

    public /* synthetic */ boolean isDisconnected(MapleCharacter a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return false;
        }
        return a3.h.contains(a2.getId());
    }

    public final /* synthetic */ void setProperty(String a2, String a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        a4.M.setProperty(a2, a3);
    }

    public final /* synthetic */ void showWZEffect2(String a2) {
        EventInstanceManager a3;
        Iterator<MapleCharacter> iterator;
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getClient().sendPacket(UIPacket.ShowWZEffect2(a2));
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void broadcastShowMapEffect(boolean a2, String a3) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a4.getPlayers().iterator();
        while (iterator2.hasNext()) {
            MapleCharacter mapleCharacter = iterator.next();
            byte[] arrby = UIPacket.ShowWZEffect2(a3);
            if (a2) {
                arrby = UIPacket.MapEff(a3);
            }
            mapleCharacter.getClient().sendPacket(arrby);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ void removeDisconnected(int a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        a3.h.remove(a2);
    }

    public final /* synthetic */ void setEventCount(String a2) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().setEventCount(a2);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ void worldMessage(String a2) {
        World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(a2));
    }

    public final /* synthetic */ List<Pair<Integer, String>> newPair() {
        return new ArrayList<Pair<Integer, String>>();
    }

    public /* synthetic */ List<Integer> getDisconnected() {
        EventInstanceManager a2;
        return a2.h;
    }

    public /* synthetic */ void setDeathCount(int a2, int a3) {
        EventInstanceManager a4;
        int n2 = a3;
        a4.ALLATORIxDEMO.put(a2, n2);
        if (n2 == -1) {
            return;
        }
        Iterator<MapleCharacter> iterator = a4.f.iterator();
        block0: while (true) {
            Iterator<MapleCharacter> iterator2 = iterator;
            while (iterator2.hasNext()) {
                int n3;
                MapleCharacter mapleCharacter = iterator.next();
                if (mapleCharacter == null) {
                    iterator2 = iterator;
                    continue;
                }
                if (a2 != mapleCharacter.getId()) {
                    iterator2 = iterator;
                    continue;
                }
                Iterator<Integer> iterator3 = a4.d.iterator();
                do {
                    if (!iterator3.hasNext()) continue block0;
                    n3 = iterator3.next();
                } while (mapleCharacter.getMapId() != n3);
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.getDeathCountInfo(false, a3));
                continue block0;
            }
            break;
        }
    }

    public /* synthetic */ void playerKilled(MapleCharacter a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[2];
            arrobject[0] = a3;
            arrobject[1] = a22;
            a3.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"3\u0002\"\u0017&\u001c\u0007\u000b\"\n"), arrobject);
            return;
        }
        catch (RejectedExecutionException a22) {
            return;
        }
        catch (NoSuchMethodException | ScriptException a22) {
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : playerDead:\n" + a22);
            System.err.println("Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : playerDead:\n" + a22);
            return;
        }
    }

    public final /* synthetic */ void saveNX(int a2) {
        Iterator<MapleCharacter> iterator;
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().modifyCSPoints(true ? 1 : 0, a2, true);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ void addToPair_chr(List<Pair<Integer, MapleCharacter>> a2, int a3, MapleCharacter a4) {
        a2.add(new Pair<Integer, MapleCharacter>(a3, a4));
    }

    public final /* synthetic */ Properties getProperties() {
        EventInstanceManager a2;
        return a2.M;
    }

    public /* synthetic */ void restartEventTimer(long a2) {
        EventInstanceManager a3;
        block6: {
            if (!a3.k) break block6;
            return;
        }
        try {
            Iterator<MapleCharacter> iterator;
            EventInstanceManager eventInstanceManager = a3;
            eventInstanceManager.I = System.currentTimeMillis();
            eventInstanceManager.F = a2;
            if (a3.e != null) {
                a3.e.cancel(false);
            }
            a3.e = null;
            int n2 = (int)a2 / 1000;
            Iterator<MapleCharacter> iterator2 = iterator = a3.getPlayers().iterator();
            while (iterator2.hasNext()) {
                iterator.next().getClient().sendPacket(MaplePacketCreator.getClock(n2));
                iterator2 = iterator;
            }
        }
        catch (Exception exception) {
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : restartEventTimer:\n" + exception);
            System.err.println("Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : restartEventTimer:\n");
            exception.printStackTrace();
            return;
        }
        a3.timeOut(a2, a3);
    }

    public /* synthetic */ void setAllDeathCount(int a2) {
        EventInstanceManager a3;
        Iterator<MapleCharacter> iterator;
        Iterator<MapleCharacter> iterator2 = iterator = a3.f.iterator();
        while (iterator2.hasNext()) {
            MapleCharacter mapleCharacter = iterator.next();
            if (mapleCharacter == null) {
                iterator2 = iterator;
                continue;
            }
            a3.setDeathCount(mapleCharacter.getId(), a2);
            iterator2 = iterator;
        }
    }

    private /* synthetic */ boolean ALLATORIxDEMO(MapleCharacter a2) {
        EventInstanceManager a3;
        if (a3.J.equals(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u0014%\u0013?"))) {
            EventInstanceManager eventInstanceManager = a3;
            MapleSquad mapleSquad = ChannelServer.getInstance(eventInstanceManager.a, eventInstanceManager.i).getMapleSquad(Timer.ALLATORIxDEMO("W7_0E"));
            if (mapleSquad != null) {
                MapleSquad mapleSquad2 = mapleSquad;
                mapleSquad2.removeMember(a2.getName());
                if (mapleSquad2.getLeaderName().equals(a2.getName())) {
                    a3.j.setProperty(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"/\u000b\"\n&\u001c"), Timer.ALLATORIxDEMO("r\u0001x\u0013q"));
                }
            }
        }
        a2.setEventInstance(null);
        if (a3.k) {
            return false;
        }
        if (a3.f.contains(a2)) {
            a3.f.remove(a2);
            return true;
        }
        return false;
    }

    public final /* synthetic */ int getPlayerCount() {
        EventInstanceManager a2;
        if (a2.k) {
            return 0;
        }
        return a2.f.size();
    }

    public final /* synthetic */ void broadcastPyramidResult(boolean a22, int a3, int a42, int a5, int a6) {
        EventInstanceManager a7;
        if (a7.k) {
            return;
        }
        byte[] a22 = UIPacket.sendNewPyramidResult(a22, a3, a42, a5, a6);
        for (MapleCharacter a42 : a7.getPlayers()) {
            if (a42 == null) continue;
            a42.getClient().sendPacket(a22);
        }
    }

    public /* synthetic */ void openAllPlayerNpc(int a2, int a3, String a4) {
        EventInstanceManager a5;
        Iterator<MapleCharacter> iterator;
        Iterator<MapleCharacter> iterator2 = iterator = a5.f.iterator();
        while (iterator2.hasNext()) {
            MapleCharacter mapleCharacter = iterator.next();
            iterator2 = iterator;
            mapleCharacter.getClient().removeClickedNPC();
            NPCScriptManager.getInstance().start(mapleCharacter.getClient(), a2, a3, a4, true);
        }
    }

    public /* synthetic */ void addPVPScore(MapleCharacter a22, int a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return;
        }
        try {
            Object[] arrobject = new Object[3];
            arrobject[0] = a4;
            arrobject[1] = a22;
            arrobject[2] = a3;
            a4.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u000f'\n\u00138\u0013= \u00011\u000b"), arrobject);
            return;
        }
        catch (ScriptException a22) {
            EventInstanceManager eventInstanceManager;
            String string;
            EventInstanceManager eventInstanceManager2;
            String string2;
            if (a4.j == null) {
                string2 = Timer.ALLATORIxDEMO("\u000ea\fx");
                eventInstanceManager2 = a4;
            } else {
                string2 = a4.j.getName();
                eventInstanceManager2 = a4;
            }
            System.out.println("Event name" + string2 + ", Instance name : " + eventInstanceManager2.J + ", method Name : monsterValue:\n" + a22);
            if (a4.j == null) {
                string = \u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u001b/\u0002");
                eventInstanceManager = a4;
            } else {
                string = a4.j.getName();
                eventInstanceManager = a4;
            }
            FileoutputUtil.log("logs/Except/\u8173\u672c\u932f\u8aa4.txt", "Event name" + string + ", Instance name : " + eventInstanceManager.J + ", method Name : monsterValue:\n" + a22);
            return;
        }
        catch (NoSuchMethodException a22) {
            EventInstanceManager eventInstanceManager;
            String string;
            EventInstanceManager eventInstanceManager3;
            String string3;
            if (a4.j == null) {
                string3 = Timer.ALLATORIxDEMO("\u000ea\fx");
                eventInstanceManager3 = a4;
            } else {
                string3 = a4.j.getName();
                eventInstanceManager3 = a4;
            }
            System.out.println("Event name" + string3 + ", Instance name : " + eventInstanceManager3.J + ", method Name : monsterValue:\n" + a22);
            if (a4.j == null) {
                string = \u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u001b/\u0002");
                eventInstanceManager = a4;
            } else {
                string = a4.j.getName();
                eventInstanceManager = a4;
            }
            FileoutputUtil.log("logs/Except/\u8173\u672c\u932f\u8aa4.txt", "Event name" + string + ", Instance name : " + eventInstanceManager.J + ", method Name : monsterValue:\n" + a22);
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            FileoutputUtil.outputFileError("logs/Except/\u8173\u672c\u932f\u8aa4.txt", a22);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ List<MapleMap> getAllMapInstances() {
        EventInstanceManager a2;
        LinkedList<MapleMap> linkedList = new LinkedList<MapleMap>();
        if (a2.k) {
            return null;
        }
        try {
            boolean bl = false;
            int n2 = -1;
            MapleMap mapleMap = null;
            for (int i2 = 0; i2 < a2.C.size(); ++i2) {
                LinkedList<MapleMap> linkedList2;
                block10: {
                    block9: {
                        block8: {
                            n2 = a2.C.get(i2);
                            bl = a2.H.get(i2);
                            if (bl) break block8;
                            mapleMap = a2.getMapFactory().getMap(n2);
                            if (mapleMap == null) {
                                return null;
                            }
                            if (mapleMap.getCharactersSize() != 0 || a2.j.getProperty(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001d+\u001b%\b/\u000b\u0011\u000b\"\r7\u00011\u001d")) == null || !a2.j.getProperty(Timer.ALLATORIxDEMO("g\ba\u0006r\fq2q\u0001w\u0014{\u0012g")).equals(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"7\u001c6\u000b"))) break block9;
                            linkedList2 = linkedList;
                            mapleMap.shuffleReactors();
                            break block10;
                        }
                        mapleMap = a2.getMapFactory().getInstanceMap(n2);
                        if (mapleMap == null) {
                            return null;
                        }
                        if (mapleMap.getCharactersSize() == 0 && a2.j.getProperty(Timer.ALLATORIxDEMO("g\ba\u0006r\fq2q\u0001w\u0014{\u0012g")) != null && a2.j.getProperty(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001d+\u001b%\b/\u000b\u0011\u000b\"\r7\u00011\u001d")).equals(Timer.ALLATORIxDEMO("\u0014f\u0015q"))) {
                            mapleMap.shuffleReactors();
                        }
                    }
                    linkedList2 = linkedList;
                }
                linkedList2.add(mapleMap);
            }
            return linkedList;
        }
        catch (NullPointerException nullPointerException) {
            FileoutputUtil.outputFileError(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u000f\u0001$\u001dl+;\r&\u001e7\u0007,\u0000l\",\t\u001c\u811d\u676f1\u4fc8\u5978m\u001a;\u001a"), nullPointerException);
            System.err.println(nullPointerException);
            return null;
        }
    }

    public final /* synthetic */ Object setProperty(String a2, String a3, boolean a4) {
        EventInstanceManager a5;
        if (a5.k) {
            return null;
        }
        return a5.M.setProperty(a2, a3);
    }

    public final /* synthetic */ void broadcastPyramidScore(int a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        byte[] a22 = UIPacket.sendNewPyramidScore(a22);
        for (MapleCharacter mapleCharacter : a3.getPlayers()) {
            if (mapleCharacter == null) continue;
            mapleCharacter.getClient().sendPacket(a22);
        }
    }

    public /* synthetic */ MapleCharacter getLeader() {
        EventInstanceManager a2;
        for (MapleCharacter mapleCharacter : a2.getPlayers()) {
            if (!a2.isLeader(mapleCharacter)) continue;
            return mapleCharacter;
        }
        return null;
    }

    public final /* synthetic */ void saveBossQuest(int a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        Iterator<MapleCharacter> iterator = a3.getPlayers().iterator();
        while (iterator.hasNext()) {
            MapleQuestStatus mapleQuestStatus = iterator.next().getQuestNAdd(MapleQuest.getInstance(150001));
            if (mapleQuestStatus.getCustomData() != null) {
                MapleQuestStatus mapleQuestStatus2 = mapleQuestStatus;
                mapleQuestStatus2.setCustomData(String.valueOf((long)a2 + Long.parseLong(mapleQuestStatus2.getCustomData())));
                continue;
            }
            mapleQuestStatus.setCustomData(String.valueOf(a2));
        }
    }

    public /* synthetic */ void dispose_NoLock() {
        EventInstanceManager a2;
        if (a2.k || a2.j == null) {
            return;
        }
        a2.K = true;
    }

    public /* synthetic */ void unregisterMonster(MapleMonster a22) {
        EventInstanceManager a3;
        a22.setEventInstance(null);
        if (a3.k) {
            return;
        }
        EventInstanceManager eventInstanceManager = a3;
        eventInstanceManager.D.remove(a22);
        if (eventInstanceManager.D.isEmpty()) {
            try {
                Object[] arrobject = new Object[1];
                arrobject[0] = a3;
                a3.j.getIv().invokeFunction(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u000f/\u0002\u000e\u0001-\u001d7\u000b1\u001d\u0007\u000b\"\n"), arrobject);
                return;
            }
            catch (RejectedExecutionException a22) {
                return;
            }
            catch (NoSuchMethodException | ScriptException a22) {
                FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : allMonstersDead:\n" + a22);
                System.err.println("Event name" + a3.j.getName() + ", Instance name : " + a3.J + ", method Name : allMonstersDead:\n" + a22);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean disposeIfPlayerBelowCheck(byte a22, int a3) {
        EventInstanceManager a4;
        if (a4.k) {
            return true;
        }
        MapleMap mapleMap = null;
        if (a3 > 0) {
            mapleMap = a4.getMapFactory().getMap(a3);
        }
        a4.B.lock();
        try {
            if (a4.f.size() <= a22) {
                for (MapleCharacter mapleCharacter : new LinkedList<MapleCharacter>(a4.f)) {
                    a4.ALLATORIxDEMO(mapleCharacter);
                    if (a3 <= 0) continue;
                    MapleMap mapleMap2 = mapleMap;
                    mapleCharacter.changeMap(mapleMap2, mapleMap2.getPortal(0));
                }
                a4.disposeNow();
                boolean a22 = true;
                return a22;
            }
        }
        finally {
            a4.B.unlock();
        }
        return false;
    }

    public /* synthetic */ void monsterDamaged(MapleCharacter a22, MapleMonster a3, int a4) {
        EventInstanceManager a5;
        if (a5.k || a3.getId() != 9700037) {
            return;
        }
        try {
            Object[] arrobject = new Object[4];
            arrobject[0] = a5;
            arrobject[1] = a22;
            arrobject[2] = a3.getId();
            arrobject[3] = a4;
            a5.j.getIv().invokeFunction(Timer.ALLATORIxDEMO("\r{\u000eg\u0014q\u0012P\u0001y\u0001s\u0005p"), arrobject);
            return;
        }
        catch (RejectedExecutionException a22) {
            return;
        }
        catch (ScriptException a22) {
            EventInstanceManager eventInstanceManager;
            String string;
            if (a5.j == null) {
                string = \u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u001b/\u0002");
                eventInstanceManager = a5;
            } else {
                string = a5.j.getName();
                eventInstanceManager = a5;
            }
            System.err.println("Event name" + string + ", Instance name : " + eventInstanceManager.J + ", method Name : monsterValue:\n" + a22);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a5.j.getName() + ", Instance name : " + a5.J + ", method Name : restartEventTimer:\n" + a22);
            return;
        }
        catch (NoSuchMethodException a22) {
            EventInstanceManager eventInstanceManager;
            String string;
            if (a5.j == null) {
                string = \u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u001b/\u0002");
                eventInstanceManager = a5;
            } else {
                string = a5.j.getName();
                eventInstanceManager = a5;
            }
            System.err.println("Event name" + string + ", Instance name : " + eventInstanceManager.J + ", method Name : monsterValue:\n" + a22);
            FilePrinter.printError(Timer.ALLATORIxDEMO("%b\u0005z\u0014]\u000eg\u0014u\u000ew\u0005Y\u0001z\u0001s\u0005fN`\u0018`"), "Event name" + a5.j.getName() + ", Instance name : " + a5.J + ", method Name : restartEventTimer:\n" + a22);
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            FilePrinter.printError(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0006\u0018&\u00007'-\u001d7\u000f-\r&#\"\u0000\"\t&\u001cm\u001a;\u001a"), "Event name" + a5.j.getName() + ", Instance name : " + a5.J + ", method Name : restartEventTimer:\n" + a22);
            return;
        }
    }

    public /* synthetic */ boolean isLeader(MapleCharacter a2) {
        return a2 != null && a2.getParty() != null && a2.getParty().getLeader().getId() == a2.getId();
    }

    public final /* synthetic */ void broadcastCloseUI(int a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        byte[] a22 = UIPacket.closeUI(a22);
        for (MapleCharacter mapleCharacter : a3.getPlayers()) {
            if (mapleCharacter == null) continue;
            mapleCharacter.getClient().sendPacket(a22);
        }
    }

    public final /* synthetic */ String getProperty(String a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return "";
        }
        return a3.M.getProperty(a2);
    }

    public /* synthetic */ long getTimeLeft() {
        EventInstanceManager a2;
        return a2.F - (System.currentTimeMillis() - a2.I);
    }

    public /* synthetic */ int getDeathCount(int a2) {
        EventInstanceManager a3;
        if (a3.ALLATORIxDEMO != null && a3.ALLATORIxDEMO.containsKey(a2)) {
            return a3.ALLATORIxDEMO.get(a2);
        }
        return -1;
    }

    public /* synthetic */ boolean CheckDispose() {
        EventInstanceManager a2;
        return a2.K;
    }

    public final /* synthetic */ void broadcastPyramidLevel(int a22) {
        EventInstanceManager a3;
        if (a3.k) {
            return;
        }
        byte[] a22 = UIPacket.sendNewPyramidLevel(a22);
        for (MapleCharacter mapleCharacter : a3.getPlayers()) {
            if (mapleCharacter == null) continue;
            mapleCharacter.getClient().sendPacket(a22);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean disposeIfPlayerBelow(byte a2, int a3) {
        EventInstanceManager a4;
        if (a2 == 100 || a3 != 0) {
            return a4.disposeIfPlayerBelowCheck(a2, a3);
        }
        if (a4.k) {
            return true;
        }
        MapleMap mapleMap = null;
        if (a3 > 0) {
            mapleMap = a4.getMapFactory().getMap(a3);
        }
        a4.B.lock();
        try {
            if (a4.f.size() <= a2) {
                a4.K = true;
                a2 = 0;
                return a2 != 0;
            }
        }
        finally {
            a4.B.unlock();
        }
        return false;
    }

    public /* synthetic */ void registerSquad(MapleSquad a2, MapleMap a3, int a4) {
        EventInstanceManager a5;
        a5.registerSquad(a2, a3, a4, null);
    }

    public final /* synthetic */ MapleMap createInstanceMap(int a2) {
        EventInstanceManager a3;
        if (a3.k) {
            return null;
        }
        EventInstanceManager eventInstanceManager = a3;
        int n2 = eventInstanceManager.getChannelServer().getEventSM().getNewInstanceMapId();
        eventInstanceManager.C.add(n2);
        a3.H.add(true);
        return eventInstanceManager.getMapFactory().CreateInstanceMap(a2, true, true, true, n2);
    }
}

