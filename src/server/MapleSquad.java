/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleCharacter;
import client.MapleClient;
import handling.channel.ChannelServer;
import handling.world.World;
import handling.world.sidekick.MapleSidekick;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import server.MapleCarnivalChallenge;
import server.Timer;
import server.life.MobSkill;
import server.maps.MapleMap;
import tools.ExternalCodeLongTableGetter;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.Pair;

public class MapleSquad {
    private /* synthetic */ ScheduledFuture<?> d;
    private /* synthetic */ MapleClient ALLATORIxDEMO;
    private final /* synthetic */ Map<String, String> C;
    private final /* synthetic */ int e;
    private final /* synthetic */ String F;
    private final /* synthetic */ String I;
    private final /* synthetic */ int B;
    private final /* synthetic */ int E;
    private final /* synthetic */ long g;
    private /* synthetic */ byte a;
    private final /* synthetic */ int k;
    private /* synthetic */ WeakReference<MapleCharacter> M;
    private final /* synthetic */ Map<String, String> H;
    private final /* synthetic */ MapleSquadType K;

    public /* synthetic */ MapleCharacter getChar(String a2) {
        MapleSquad a3;
        MapleSquad mapleSquad = a3;
        return ChannelServer.getInstance(mapleSquad.e, mapleSquad.E).getPlayerStorage().getCharacterByName(a2);
    }

    public /* synthetic */ void banMember(int a22) {
        MapleSquad a3;
        if (a22 <= 0 || a22 >= a3.C.size()) {
            return;
        }
        String a22 = a3.getMembers().get(a22);
        if (a22 != null && a3.getChar(a22) != null) {
            MapleSquad mapleSquad = a3;
            String string = a22;
            mapleSquad.H.put(string, mapleSquad.C.get(string));
            a3.C.remove(a22);
            a3.getChar(a22).dropMessage(5, a3.getLeaderName() + " \u5f9e\u9060\u5f81\u968a\u4e2d\u522a\u9664\u60a8.");
        }
    }

    public static /* synthetic */ void clearsquad(MapleClient a2, String a3) {
        MapleClient mapleClient = a2;
        a3 = ChannelServer.getInstance(a2.getWorld(), mapleClient.getChannel()).getMapleSquad((String)a3);
        MapleMap mapleMap = mapleClient.getChannelServer().getMapFactory().getMap(689013000);
        if (mapleMap.getCharactersSize() <= 1 && a3 != null) {
            ((MapleSquad)a3).clear();
            mapleMap.resetFully();
        }
    }

    public final /* synthetic */ Map<String, Integer> getJobs() {
        MapleSquad a2;
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, String> entry : a2.C.entrySet()) {
            if (linkedHashMap.containsKey(entry.getValue())) {
                linkedHashMap.put(entry.getValue(), (Integer)linkedHashMap.get(entry.getValue()) + 1);
                continue;
            }
            linkedHashMap.put(entry.getValue(), 1);
        }
        return linkedHashMap;
    }

    public /* synthetic */ void removeallMember() {
        MapleSquad a2;
        a2.C.clear();
    }

    public /* synthetic */ List<String> getBannedMembers() {
        MapleSquad a2;
        return new LinkedList<String>(a2.H.keySet());
    }

    public /* synthetic */ void reAddMember(MapleCharacter a2) {
        MapleSquad a3;
        MapleSquad mapleSquad = a3;
        mapleSquad.removeMember(a2);
        mapleSquad.C.put(a2.getName(), MapleCarnivalChallenge.getJobNameById(a2.getJob()));
    }

    public /* synthetic */ String getNextPlayer() {
        Iterator<Pair<String, Long>> iterator;
        MapleSquad a2;
        StringBuilder stringBuilder = new StringBuilder(ExternalCodeLongTableGetter.ALLATORIxDEMO("X\u63f9\u96d8\u627b\u54b3KhK"));
        stringBuilder.append(MaplePacketOperation.ALLATORIxDEMO("\u0003'")).append(a2.K.queue.get(a2.E).size()).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("rH9K")).append(MaplePacketOperation.ALLATORIxDEMO("\u8227\u9025\u5fa1\u96cf\u542d\u55eb\u0000\u007f\u0000O-e"));
        int n2 = 0;
        Iterator<Pair<String, Long>> iterator2 = iterator = a2.K.queue.get(a2.E).iterator();
        while (iterator2.hasNext()) {
            Pair<String, Long> pair = iterator.next();
            stringBuilder.append(++n2).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("KhK")).append((String)pair.left);
            stringBuilder.append(MaplePacketOperation.ALLATORIxDEMO("\u0000O-e"));
            iterator2 = iterator;
        }
        StringBuilder stringBuilder2 = stringBuilder;
        stringBuilder2.append(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u4f32\u6644\u5474\u6098\u89d3Kq\u000e\u7524\u4e60\u4e52\u5060q\u0005r\u5743\u9032\u5fea\u96d8\u63f9\u96d8\u4e46\u3052\u627d\u8057Kq\u000e\u79a9\u960fq\u0005r\u5743\u9032\u5fea\u96d8Tr\u59e9\u67ce\u4f0b\u60a1\u76ef\u8a23E|E"));
        return stringBuilder2.toString();
    }

    public /* synthetic */ boolean containsMember(MapleCharacter a2) {
        MapleSquad a3;
        Iterator<String> iterator = a3.C.keySet().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().equalsIgnoreCase(a2.getName())) continue;
            return true;
        }
        return false;
    }

    public /* synthetic */ void scheduleRemoval() {
        MapleSquad a2;
        a2.d = Timer.EtcTimer.getInstance().schedule(new Runnable(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void run() {
                1 a2;
                if (a2.MapleSquad.this.a != 0 && a2.MapleSquad.this.M != null && (a2.MapleSquad.this.getLeader() == null || a2.MapleSquad.this.a == 1)) {
                    1 v0 = a2;
                    v0.MapleSquad.this.clear();
                    v0.MapleSquad.this.copy();
                }
            }
        }, a2.B);
    }

    public final /* synthetic */ MapleSquadType getType() {
        MapleSquad a2;
        return a2.K;
    }

    public /* synthetic */ int addMember(MapleCharacter a2, boolean a3) {
        MapleSquad a4;
        if (a4.getLeader() == null) {
            return -1;
        }
        String string = MapleCarnivalChallenge.getJobNameById(a2.getJob());
        if (a3) {
            if (!a4.containsMember(a2) && !a4.getAllNextPlayer().contains(a2.getName())) {
                if (a4.C.size() <= 30) {
                    MapleSquad mapleSquad = a4;
                    mapleSquad.C.put(a2.getName(), string);
                    mapleSquad.getLeader().dropMessage(6, a2.getName() + " (" + string + ") \u52a0\u5165\u4e86\u9060\u5f81\u968a!");
                    return 1;
                }
                return 2;
            }
            return -1;
        }
        if (a4.containsMember(a2)) {
            MapleSquad mapleSquad = a4;
            mapleSquad.C.remove(a2.getName());
            mapleSquad.getLeader().dropMessage(6, a2.getName() + " (" + string + ") \u96e2\u958b\u4e86\u9060\u5f81\u968a.");
            return 1;
        }
        return -1;
    }

    public /* synthetic */ void setBossLog(String a2) {
        MapleSquad a3;
        LinkedList<String> linkedList = new LinkedList<String>();
        for (String string : a3.getMembers()) {
            if (linkedList.contains(string)) continue;
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string);
            if (mapleCharacter != null) {
                mapleCharacter.setBossLog(a2);
            }
            linkedList.add(string);
        }
    }

    public /* synthetic */ void acceptMember(int a22) {
        MapleSquad a3;
        if (a22 < 0 || a22 >= a3.H.size()) {
            return;
        }
        String a22 = a3.getBannedMembers().get(a22);
        if (a22 != null && a3.getChar(a22) != null) {
            MapleSquad mapleSquad = a3;
            String string = a22;
            mapleSquad.C.put(string, mapleSquad.H.get(string));
            a3.H.remove(a22);
            a3.getChar(a22).dropMessage(5, a3.getLeaderName() + " \u5141\u8a31\u4f60\u91cd\u65b0\u56de\u4f86\u9060\u5f81\u968a");
        }
    }

    public /* synthetic */ MapleSquad(int a2, int a3, String a4, MapleCharacter a5, int a6, String a7) {
        MapleSquad a8;
        MapleSquad mapleSquad = a8;
        MapleSquad mapleSquad2 = a8;
        MapleSquad mapleSquad3 = a8;
        mapleSquad3.C = new LinkedHashMap<String, String>();
        mapleSquad2.H = new LinkedHashMap<String, String>();
        mapleSquad.a = 0;
        mapleSquad2.M = new WeakReference<MapleCharacter>(a5);
        mapleSquad.C.put(a5.getName(), MapleCarnivalChallenge.getJobNameById(a5.getJob()));
        MapleCharacter mapleCharacter = a5;
        MapleSquad mapleSquad4 = a8;
        MapleSquad mapleSquad5 = a8;
        MapleSquad mapleSquad6 = a8;
        mapleSquad6.I = a5.getName();
        mapleSquad6.e = a2;
        mapleSquad5.E = a3;
        mapleSquad5.F = a7;
        mapleSquad4.K = MapleSquadType.valueOf(a4.toLowerCase());
        mapleSquad4.a = 1;
        a8.k = mapleCharacter.getMapId();
        mapleCharacter.getMap().setSquad(a8.K);
        if (mapleSquad.K.queue.get(a3) == null) {
            a8.K.queue.put(a3, new ArrayList());
            a8.K.queuedPlayers.put(a3, new ArrayList());
        }
        a8.g = System.currentTimeMillis();
        a8.B = a6;
    }

    public /* synthetic */ int getBossLog(String a2) {
        MapleSquad a3;
        int n2 = 0;
        Iterator<String> iterator = a3.getMembers().iterator();
        while (iterator.hasNext()) {
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(iterator.next());
            if (mapleCharacter == null || mapleCharacter.getBossLog(a2) <= n2) continue;
            n2 = mapleCharacter.getBossLog(a2);
        }
        return n2;
    }

    public /* synthetic */ int getBannedMemberSize() {
        MapleSquad a2;
        return a2.H.size();
    }

    public /* synthetic */ String getSquadMemberString(byte a22) {
        switch (a22) {
            case 0: {
                MapleSquad a3;
                StringBuilder a22 = new StringBuilder(MaplePacketOperation.ALLATORIxDEMO("\u76ab\u526d\u9025\u5fa1\u96cf\u7e1d\u4eff\u6558e\u001ae"));
                a22.append(ExternalCodeLongTableGetter.ALLATORIxDEMO("q\t")).append(a3.C.size()).append(MaplePacketOperation.ALLATORIxDEMO("\u0000fKe")).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("fX\u900b\u5fd3\u96e1\u545f\u55c5rQra_K"));
                int n2 = 0;
                Iterator<Map.Entry<String, String>> iterator = a3.C.entrySet().iterator();
                Iterator<Map.Entry<String, String>> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    Map.Entry<String, String> entry = iterator.next();
                    a22.append(++n2).append(MaplePacketOperation.ALLATORIxDEMO("e\u001ae")).append(entry.getKey()).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("rC")).append(entry.getValue()).append(MaplePacketOperation.ALLATORIxDEMO("\te"));
                    if (n2 == 1) {
                        a22.append(ExternalCodeLongTableGetter.ALLATORIxDEMO("C\u9032\u5fea\u96d8\u9873\u88c4B"));
                    }
                    a22.append(MaplePacketOperation.ALLATORIxDEMO("\u0000O-e"));
                    iterator2 = iterator;
                }
                int n3 = n2;
                while (n3 < 30) {
                    int n4 = ++n2;
                    n3 = n4;
                    a22.append(n4).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("KhK")).append(MaplePacketOperation.ALLATORIxDEMO("\u0000O-e"));
                }
                return a22.toString();
            }
            case 1: {
                MapleSquad a3;
                StringBuilder a22 = new StringBuilder(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u7685\u521f\u900b\u5fd3\u96e1\u7e6f\u4ed1\u652aKhK"));
                a22.append(MaplePacketOperation.ALLATORIxDEMO("\u0003'")).append(a3.C.size()).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("rH9K")).append(MaplePacketOperation.ALLATORIxDEMO("H*\u9025\u5fa1\u96cf\u542d\u55eb\u0000\u007f\u0000O-e"));
                int n5 = 0;
                int n6 = 0;
                Iterator<Map.Entry<String, String>> iterator = a3.C.entrySet().iterator();
                Iterator<Map.Entry<String, String>> iterator3 = iterator;
                while (iterator3.hasNext()) {
                    Map.Entry<String, String> entry = iterator.next();
                    StringBuilder stringBuilder = a22;
                    StringBuilder stringBuilder2 = stringBuilder.append(ExternalCodeLongTableGetter.ALLATORIxDEMO("q\tq'")).append(n6);
                    ++n6;
                    stringBuilder2.append(MaplePacketOperation.ALLATORIxDEMO("f"));
                    stringBuilder.append(++n5).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("KhK")).append(entry.getKey()).append(MaplePacketOperation.ALLATORIxDEMO("\u0000m")).append(entry.getValue()).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("{K"));
                    if (n5 == 1) {
                        a22.append(MaplePacketOperation.ALLATORIxDEMO("m\u9040\u5fc4\u96aa\u985d\u88b6l"));
                    }
                    a22.append(ExternalCodeLongTableGetter.ALLATORIxDEMO("q\u0007")).append(MaplePacketOperation.ALLATORIxDEMO("\u0000O-e"));
                    iterator3 = iterator;
                }
                int n7 = n5;
                while (n7 < 30) {
                    int n8 = ++n5;
                    n7 = n8;
                    a22.append(n8).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("KhK")).append(MaplePacketOperation.ALLATORIxDEMO("\u0000O-e"));
                }
                return a22.toString();
            }
            case 2: {
                MapleSquad a3;
                StringBuilder a22 = new StringBuilder(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u7685\u521f\u900b\u5fd3\u96e1\u7e6f\u4ed1\u652aKhK"));
                a22.append(MaplePacketOperation.ALLATORIxDEMO("\u0003'")).append(a3.C.size()).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("rH9K")).append(MaplePacketOperation.ALLATORIxDEMO("H*\u9025\u5fa1\u96cf\u542d\u55eb\u0000\u007f\u0000O-e"));
                int n9 = 0;
                int n10 = 0;
                Iterator<Map.Entry<String, String>> iterator = a3.H.entrySet().iterator();
                Iterator<Map.Entry<String, String>> iterator4 = iterator;
                while (iterator4.hasNext()) {
                    Map.Entry<String, String> entry = iterator.next();
                    StringBuilder stringBuilder = a22;
                    StringBuilder stringBuilder3 = stringBuilder.append(ExternalCodeLongTableGetter.ALLATORIxDEMO("q\tq'")).append(n10);
                    ++n10;
                    stringBuilder3.append(MaplePacketOperation.ALLATORIxDEMO("f"));
                    stringBuilder.append(++n9).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("KhK")).append(entry.getKey()).append(MaplePacketOperation.ALLATORIxDEMO("\u0000m")).append(entry.getValue()).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("{K"));
                    a22.append(MaplePacketOperation.ALLATORIxDEMO("\u0003)")).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("ra_K"));
                    iterator4 = iterator;
                }
                int n11 = n9;
                while (n11 < 30) {
                    int n12 = ++n9;
                    n11 = n12;
                    a22.append(n12).append(MaplePacketOperation.ALLATORIxDEMO("e\u001ae")).append(ExternalCodeLongTableGetter.ALLATORIxDEMO("ra_K"));
                }
                return a22.toString();
            }
            case 3: {
                Iterator<Map.Entry<String, Integer>> iterator;
                MapleSquad a3;
                StringBuilder a22 = new StringBuilder(MaplePacketOperation.ALLATORIxDEMO("\u8032\u694de\u001ae"));
                Map<String, Integer> map = a3.getJobs();
                Iterator<Map.Entry<String, Integer>> iterator5 = iterator = map.entrySet().iterator();
                while (iterator5.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    a22.append(ExternalCodeLongTableGetter.ALLATORIxDEMO("_a")).append(entry.getKey()).append(MaplePacketOperation.ALLATORIxDEMO("e\u001ae")).append(entry.getValue());
                    iterator5 = iterator;
                }
                return a22.toString();
            }
        }
        return null;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ 5;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 5 << 1;
        int n5 = n3;
        int n6 = 1 << 3 ^ 4;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ List<String> getMembers() {
        MapleSquad a2;
        return new LinkedList<String>(a2.C.keySet());
    }

    public /* synthetic */ void setStatus(byte a2) {
        MapleSquad a3;
        a3.a = a2;
        if (a3.a == 2 && a3.d != null) {
            a3.d.cancel(false);
            a3.d = null;
        }
    }

    public /* synthetic */ void setNextPlayer(String a2) {
        Object object;
        MapleSquad a3;
        Object object2;
        block4: {
            object2 = null;
            for (Pair<String, Long> serializable : a3.K.queue.get(a3.E)) {
                if (!((String)serializable.left).equals(a2)) continue;
                object = object2 = serializable;
                break block4;
            }
            object = object2;
        }
        if (object != null) {
            a3.K.queue.get(a3.E).remove(object2);
            return;
        }
        for (ArrayList arrayList : a3.K.queue.values()) {
            object2 = arrayList.iterator();
            while (object2.hasNext()) {
                if (!((String)((Pair)object2.next()).left).equals(a2)) continue;
                return;
            }
        }
        a3.K.queue.get(a3.E).add(new Pair<String, Long>(a2, System.currentTimeMillis()));
    }

    public /* synthetic */ void clear() {
        MapleSquad a2;
        if (a2.d != null) {
            MapleSquad mapleSquad = a2;
            mapleSquad.getBeginMap().broadcastMessage(MaplePacketCreator.stopClock());
            mapleSquad.d.cancel(false);
            a2.d = null;
        }
        MapleSquad mapleSquad = a2;
        mapleSquad.C.clear();
        mapleSquad.H.clear();
        mapleSquad.M = null;
        ChannelServer.getInstance(a2.e, a2.E).removeMapleSquad(a2.K);
        a2.a = 0;
    }

    public /* synthetic */ boolean isBanned(MapleCharacter a2) {
        MapleSquad a3;
        return a3.H.containsKey(a2.getName());
    }

    public /* synthetic */ void copy() {
        MapleSquad a2;
        while (a2.K.queue.get(a2.E).size() > 0) {
            int n2;
            MapleSquad mapleSquad = a2;
            if (ChannelServer.getInstance(mapleSquad.e, mapleSquad.E).getMapleSquad(a2.K) != null) break;
            int n3 = 0;
            long l2 = 0L;
            int n4 = n2 = 0;
            while (n4 < a2.K.queue.get(a2.E).size()) {
                if (l2 == 0L || (Long)a2.K.queue.get((Object)Integer.valueOf((int)a2.E)).get((int)n2).right < l2) {
                    n3 = n2;
                    l2 = (Long)a2.K.queue.get((Object)Integer.valueOf((int)a2.E)).get((int)n2).right;
                }
                n4 = ++n2;
            }
            String string = (String)a2.K.queue.get((Object)Integer.valueOf((int)a2.E)).remove((int)n3).left;
            n3 = World.Find.findChannel(string);
            int n5 = World.Find.findWorld(string);
            if (n3 > 0) {
                MapleCharacter mapleCharacter = ChannelServer.getInstance(n5, n3).getPlayerStorage().getCharacterByName(string);
                if (mapleCharacter != null && mapleCharacter.getMapId() == a2.k && mapleCharacter.getClient().getChannel() == a2.E) {
                    MapleSquad mapleSquad2 = a2;
                    MapleSquad mapleSquad3 = a2;
                    MapleSquad mapleSquad4 = new MapleSquad(mapleSquad2.e, mapleSquad2.E, a2.K.name(), mapleCharacter, mapleSquad3.B, mapleSquad3.F);
                    MapleSquad mapleSquad5 = a2;
                    if (ChannelServer.getInstance(mapleSquad5.e, mapleSquad5.E).addMapleSquad(mapleSquad4, a2.K.name())) {
                        MapleSquad mapleSquad6 = a2;
                        a2.getBeginMap().broadcastMessage(MaplePacketCreator.getClock(mapleSquad6.B / 1000));
                        mapleSquad6.getBeginMap().broadcastMessage(MaplePacketCreator.getItemNotice(string + a2.F));
                        a2.K.queuedPlayers.get(a2.E).add(new Pair<String, String>(string, MaplePacketOperation.ALLATORIxDEMO("\u6230\u52da")));
                        return;
                    }
                    mapleSquad4.clear();
                    a2.K.queuedPlayers.get(a2.E).add(new Pair<String, String>(string, ExternalCodeLongTableGetter.ALLATORIxDEMO("\u8da1\u9025")));
                    return;
                }
                if (mapleCharacter != null) {
                    mapleCharacter.dropMessage(6, MaplePacketOperation.ALLATORIxDEMO("\u9025\u5fa1\u96cf\u5dd2\u7dd6\u7d70\u671a\u4ea6\uff49\u7511\u65f9\u6cb2\u674c\u5708\u6b26\u789a\u76c1\u981b\u9016\u88c1\u3047"));
                }
                a2.getBeginMap().broadcastMessage(MaplePacketCreator.getItemNotice(string + "\u9060\u5f81\u968a\u5df2\u7d93\u7d50\u675f\u4e86\uff0c\u7531\u65bc\u6709\u6210\u54e1\u6c92\u6709\u5728\u5730\u5716\u5167"));
                a2.K.queuedPlayers.get(a2.E).add(new Pair<String, String>(string, ExternalCodeLongTableGetter.ALLATORIxDEMO("\u4e66\u577a\u575b\u5744\u510c")));
                continue;
            }
            a2.getBeginMap().broadcastMessage(MaplePacketCreator.getItemNotice(string + "'\u9060\u5f81\u968a\u5df2\u7d93\u7d50\u675f\u4e86\uff0c\u7531\u65bc\u6709\u6210\u54e1\u6c92\u6709\u5728\u7dda\u4e0a"));
            a2.K.queuedPlayers.get(a2.E).add(new Pair<String, String>(string, MaplePacketOperation.ALLATORIxDEMO("\u6cb2\u674c\u4e2a\u7d9f")));
        }
    }

    public /* synthetic */ List<Pair<String, Long>> getAllNextPlayer() {
        MapleSquad a2;
        return a2.K.queue.get(a2.E);
    }

    public /* synthetic */ int getStatus() {
        MapleSquad a2;
        return a2.a;
    }

    public /* synthetic */ void removeMember(MapleCharacter a2) {
        MapleSquad a3;
        if (a3.C.containsKey(a2.getName())) {
            a3.C.remove(a2.getName());
        }
    }

    public /* synthetic */ String getLeaderName() {
        MapleSquad a2;
        return a2.I;
    }

    public /* synthetic */ MapleMap getBeginMap() {
        MapleSquad a2;
        MapleSquad mapleSquad = a2;
        return ChannelServer.getInstance(mapleSquad.e, mapleSquad.E).getMapFactory().getMap(a2.k);
    }

    public /* synthetic */ int getSquadSize() {
        MapleSquad a2;
        int n2 = 0;
        Iterator<Map.Entry<String, String>> iterator = a2.C.entrySet().iterator();
        while (iterator.hasNext()) {
            MapleCharacter mapleCharacter = MapleCharacter.getOnlineCharacterByName(iterator.next().getKey());
            if (mapleCharacter == null || mapleCharacter.getClient().getChannel() < 1 || mapleCharacter.getClient().getChannel() > 20) continue;
            ++n2;
        }
        return n2;
    }

    public /* synthetic */ long getTimeLeft() {
        MapleSquad a2;
        return (long)a2.B - (System.currentTimeMillis() - a2.g);
    }

    public /* synthetic */ void removeMember(String a2) {
        MapleSquad a3;
        if (a3.C.containsKey(a2)) {
            a3.C.remove(a2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ MapleCharacter getLeader() {
        MapleSquad mapleSquad;
        MapleSquad a2;
        if (a2.M != null && a2.M.get() != null) {
            mapleSquad = a2;
            return (MapleCharacter)mapleSquad.M.get();
        }
        if (a2.C.size() > 0) {
            MapleSquad mapleSquad2 = a2;
            if (mapleSquad2.getChar(mapleSquad2.I) != null) {
                mapleSquad = a2;
                MapleSquad mapleSquad3 = a2;
                a2.M = new WeakReference<MapleCharacter>(mapleSquad3.getChar(mapleSquad3.I));
                return (MapleCharacter)mapleSquad.M.get();
            }
        }
        if (a2.a == 0) return null;
        a2.clear();
        return null;
    }

    public static final class MapleSquadType
    extends Enum<MapleSquadType> {
        public static final /* synthetic */ /* enum */ MapleSquadType aufheben;
        public static final /* synthetic */ /* enum */ MapleSquadType cwkpq;
        public static final /* synthetic */ /* enum */ MapleSquadType scartar;
        public static final /* synthetic */ /* enum */ MapleSquadType boss4;
        public static final /* synthetic */ /* enum */ MapleSquadType bgbossmm;
        public static final /* synthetic */ /* enum */ MapleSquadType boss2;
        public static final /* synthetic */ /* enum */ MapleSquadType boss6;
        public static final /* synthetic */ /* enum */ MapleSquadType pinkzak;
        public static final /* synthetic */ /* enum */ MapleSquadType boss3;
        public static final /* synthetic */ /* enum */ MapleSquadType cygnus;
        public static final /* synthetic */ /* enum */ MapleSquadType horntail;
        public /* synthetic */ int i;
        public static final /* synthetic */ /* enum */ MapleSquadType vonleon;
        public static final /* synthetic */ /* enum */ MapleSquadType nmm_squad;
        public /* synthetic */ HashMap<Integer, ArrayList<Pair<String, String>>> queuedPlayers;
        public static final /* synthetic */ /* enum */ MapleSquadType dunas;
        public static final /* synthetic */ /* enum */ MapleSquadType nibergen_squad;
        public static final /* synthetic */ /* enum */ MapleSquadType bossbalrog;
        public static final /* synthetic */ /* enum */ MapleSquadType vergamot;
        public static final /* synthetic */ /* enum */ MapleSquadType boss1;
        public static final /* synthetic */ /* enum */ MapleSquadType core_blaze;
        public static final /* synthetic */ /* enum */ MapleSquadType aufhaven;
        public /* synthetic */ HashMap<Integer, ArrayList<Pair<String, Long>>> queue;
        private static final /* synthetic */ MapleSquadType[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ MapleSquadType akaylemm;
        public static final /* synthetic */ /* enum */ MapleSquadType chaosht;
        public static final /* synthetic */ /* enum */ MapleSquadType zak;
        public static final /* synthetic */ /* enum */ MapleSquadType pinkbean;
        public static final /* synthetic */ /* enum */ MapleSquadType dunas2;
        public static final /* synthetic */ /* enum */ MapleSquadType sila;
        public static final /* synthetic */ /* enum */ MapleSquadType boss5;
        public static final /* synthetic */ /* enum */ MapleSquadType chaoszak;
        public static final /* synthetic */ /* enum */ MapleSquadType lionsquad;

        public static /* synthetic */ {
            bossbalrog = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0001\u001f\u0010\u0003\u0001\u0011\u000f\u0002\f\u0017"), 0, 2);
            zak = new MapleSquadType(MobSkill.ALLATORIxDEMO("PKA"), 1, 2);
            chaoszak = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0000\u0018\u0002\u001f\u0010\n\u0002\u001b"), 2, 3);
            horntail = new MapleSquadType(MobSkill.ALLATORIxDEMO("BEXD^KCF"), 3, 3);
            chaosht = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0013\u000b\u0011\f\u0003\u000b\u0004"), 4, 3);
            pinkbean = new MapleSquadType(MobSkill.ALLATORIxDEMO("ZCDAHOKD"), 5, 3);
            nmm_squad = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u001e\u000e\u001d<\u0003\u0012\u0005\u0002\u0014"), 6, 2);
            vergamot = new MapleSquadType(MobSkill.ALLATORIxDEMO("\\OXMKGE^"), 7, 2);
            dunas = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0014\u0016\u001e\u0002\u0003"), 8, 2);
            nibergen_squad = new MapleSquadType(MobSkill.ALLATORIxDEMO("DCHOXMODuY[_KN"), 9, 2);
            dunas2 = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0007\u0005\r\u0011\u0010B"), 10, 2);
            core_blaze = new MapleSquadType(MobSkill.ALLATORIxDEMO("IEXOuHFKPO"), 11, 2);
            aufheben = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0002\u0005\u0005\u0018\u0006\u0012\u0006\u001e"), 12, 2);
            aufhaven = new MapleSquadType(MobSkill.ALLATORIxDEMO("K_LBK\\OD"), 13, 2);
            cwkpq = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0013\u0014\u001b\u0013\u0001"), 14, 10);
            vonleon = new MapleSquadType(MobSkill.ALLATORIxDEMO("\\EDFOED"), 15, 3);
            scartar = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0003\u0000\u0011\u0011\u0004\u0002\u0002"), 16, 2);
            cygnus = new MapleSquadType(MobSkill.ALLATORIxDEMO("ISMD_Y"), 17, 3);
            lionsquad = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u001c\n\u001f\r\u0003\u0012\u0005\u0002\u0014"), 18, 2);
            pinkzak = new MapleSquadType(MobSkill.ALLATORIxDEMO("ZCDAPKA"), 19, 2);
            sila = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0010\u0019\u000f\u0011"), 20, 3);
            akaylemm = new MapleSquadType(MobSkill.ALLATORIxDEMO("KAKSFOGG"), 21, 3);
            bgbossmm = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0001\u0017\u0001\u001f\u0010\u0003\u000e\u001d"), 22, 3);
            boss1 = new MapleSquadType(MobSkill.ALLATORIxDEMO("HEYY\u001b"), 23, 3);
            boss2 = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0012\f\u0003\u0010B"), 24, 3);
            boss3 = new MapleSquadType(MobSkill.ALLATORIxDEMO("HEYY\u0019"), 25, 3);
            boss4 = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0012\f\u0003\u0010D"), 26, 3);
            boss5 = new MapleSquadType(MobSkill.ALLATORIxDEMO("HEYY\u001f"), 27, 3);
            boss6 = new MapleSquadType(MapleSidekick.ALLATORIxDEMO("\u0012\f\u0003\u0010F"), 28, 3);
            MapleSquadType[] arrmapleSquadType = new MapleSquadType[29];
            arrmapleSquadType[0] = bossbalrog;
            arrmapleSquadType[1] = zak;
            arrmapleSquadType[2] = chaoszak;
            arrmapleSquadType[3] = horntail;
            arrmapleSquadType[4] = chaosht;
            arrmapleSquadType[5] = pinkbean;
            arrmapleSquadType[6] = nmm_squad;
            arrmapleSquadType[7] = vergamot;
            arrmapleSquadType[8] = dunas;
            arrmapleSquadType[9] = nibergen_squad;
            arrmapleSquadType[10] = dunas2;
            arrmapleSquadType[11] = core_blaze;
            arrmapleSquadType[12] = aufheben;
            arrmapleSquadType[13] = aufhaven;
            arrmapleSquadType[14] = cwkpq;
            arrmapleSquadType[15] = vonleon;
            arrmapleSquadType[16] = scartar;
            arrmapleSquadType[17] = cygnus;
            arrmapleSquadType[18] = lionsquad;
            arrmapleSquadType[19] = pinkzak;
            arrmapleSquadType[20] = sila;
            arrmapleSquadType[21] = akaylemm;
            arrmapleSquadType[22] = bgbossmm;
            arrmapleSquadType[23] = boss1;
            arrmapleSquadType[24] = boss2;
            arrmapleSquadType[25] = boss3;
            arrmapleSquadType[26] = boss4;
            arrmapleSquadType[27] = boss5;
            arrmapleSquadType[28] = boss6;
            ALLATORIxDEMO = arrmapleSquadType;
        }

        public static /* synthetic */ MapleSquadType valueOf(String a2) {
            return Enum.valueOf(MapleSquadType.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ MapleSquadType(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            MapleSquadType a3;
            MapleSquadType mapleSquadType = a3;
            MapleSquadType mapleSquadType2 = a3;
            mapleSquadType.queuedPlayers = new HashMap();
            mapleSquadType.queue = new HashMap();
            mapleSquadType.i = a2;
        }

        public static /* synthetic */ MapleSquadType[] values() {
            return (MapleSquadType[])ALLATORIxDEMO.clone();
        }
    }
}

