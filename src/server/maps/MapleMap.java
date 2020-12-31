/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import FuckingHackerToby.F;
import client.MapleCharacter;
import client.MapleClient;
import client.MonsterFamiliar;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.messages.CommandProcessorUtil;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.MapConstants;
import constants.MobConstants;
import database.DBConPool;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.PartyOperation;
import handling.opcodes.SummonMovementType;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import scripting.event.EventManager;
import scripting.npc.NPCScriptManager;
import server.MapleCarnivalFactory;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MaplePortal;
import server.MapleSquad;
import server.MerchItemPackage;
import server.Randomizer;
import server.SpeedRunner;
import server.Timer;
import server.events.MapleEvent;
import server.life.AbstractLoadedMapleLife;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleMonsterInformationProvider;
import server.life.MapleNPC;
import server.life.MonsterDropEntry;
import server.life.MonsterGlobalDropEntry;
import server.life.SpawnPoint;
import server.life.SpawnPointAreaBoss;
import server.life.Spawns;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.AbstractMapleMapObject;
import server.maps.Extend.MapNoticeData;
import server.maps.Extend.MapNoticeFactory;
import server.maps.FieldLimitType;
import server.maps.MapScriptMethods;
import server.maps.MapleDoor;
import server.maps.MapleExtractor;
import server.maps.MapleFoothold;
import server.maps.MapleFootholdTree;
import server.maps.MapleKite;
import server.maps.MapleMapEffect;
import server.maps.MapleMapFactory;
import server.maps.MapleMapItem;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleMist;
import server.maps.MapleNodes;
import server.maps.MapleReactor;
import server.maps.MapleReactorFactory;
import server.maps.MapleReactorStats;
import server.maps.MapleSummon;
import server.maps.MechDoor;
import server.maps.SpeedRunType;
import server.quest.MapleQuest;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.StringUtil;
import tools.packet.MTSCSPacket;
import tools.packet.MobPacket;
import tools.packet.PetPacket;

public final class MapleMap {
    private final /* synthetic */ Map<Integer, MaplePortal> Da;
    private /* synthetic */ int s;
    private /* synthetic */ MapleSquad.MapleSquadType F;
    private /* synthetic */ long M;
    private /* synthetic */ MapleMonster ha;
    private /* synthetic */ MapleNodes I;
    private /* synthetic */ int ga;
    private /* synthetic */ boolean S;
    private /* synthetic */ boolean H;
    private /* synthetic */ long J;
    private /* synthetic */ boolean b;
    private /* synthetic */ MapleMapEffect da;
    private /* synthetic */ boolean R;
    private /* synthetic */ boolean E;
    private final /* synthetic */ byte ma;
    private /* synthetic */ int n;
    private /* synthetic */ boolean w;
    private /* synthetic */ boolean r;
    private /* synthetic */ String D;
    private /* synthetic */ boolean T;
    private /* synthetic */ short K;
    private /* synthetic */ boolean P;
    private /* synthetic */ boolean l;
    private /* synthetic */ boolean N;
    private /* synthetic */ int V;
    private final /* synthetic */ ReentrantReadWriteLock ia;
    private /* synthetic */ String f;
    private /* synthetic */ float Aa;
    private /* synthetic */ boolean o;
    private /* synthetic */ boolean C;
    private /* synthetic */ String h;
    private /* synthetic */ long i;
    private /* synthetic */ int x;
    private final /* synthetic */ Map<MapleMapObjectType, ReentrantReadWriteLock> ka;
    private /* synthetic */ boolean c;
    private /* synthetic */ int X;
    private /* synthetic */ short k;
    private /* synthetic */ short Ha;
    private final /* synthetic */ List<Point> Ia;
    private /* synthetic */ short a;
    private final /* synthetic */ AtomicInteger Ma;
    private /* synthetic */ boolean Q;
    private /* synthetic */ ScheduledFuture<?> L;
    private /* synthetic */ boolean e;
    private /* synthetic */ int Y;
    private /* synthetic */ boolean G;
    private final /* synthetic */ int Ja;
    private /* synthetic */ short y;
    private final /* synthetic */ Lock ca;
    private /* synthetic */ long ALLATORIxDEMO;
    private final /* synthetic */ Map<Integer, List<MonsterDropEntry>> ba;
    private /* synthetic */ short B;
    private /* synthetic */ MapleFootholdTree la;
    private /* synthetic */ String m;
    private /* synthetic */ int W;
    private /* synthetic */ boolean g;
    private final /* synthetic */ List<Spawns> ea;
    private /* synthetic */ String A;
    private /* synthetic */ boolean t;
    private final /* synthetic */ List<MonsterDropEntry> ja;
    private final /* synthetic */ List<MapleCharacter> La;
    private /* synthetic */ int U;
    private /* synthetic */ int p;
    private final /* synthetic */ int Ba;
    private /* synthetic */ int d;
    private /* synthetic */ int v;
    private final /* synthetic */ float Ea;
    private final /* synthetic */ Map<String, Integer> Ca;
    private /* synthetic */ int u;
    private /* synthetic */ int O;
    private final /* synthetic */ Lock Fa;
    private /* synthetic */ int z;
    private /* synthetic */ int q;
    private /* synthetic */ ScheduledFuture<?> j;
    private final /* synthetic */ List<Integer> Ka;
    private /* synthetic */ int fa;
    private /* synthetic */ boolean Z;
    private final /* synthetic */ Map<MapleMapObjectType, LinkedHashMap<Integer, MapleMapObject>> aa;

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ MapleSquad getSquadByMap() {
        MapleMap a2;
        MapleSquad.MapleSquadType mapleSquadType = null;
        switch (a2.Ba) {
            case 105100300: {
                mapleSquadType = MapleSquad.MapleSquadType.bossbalrog;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 280030000: {
                mapleSquadType = MapleSquad.MapleSquadType.zak;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 280030001: {
                mapleSquadType = MapleSquad.MapleSquadType.chaoszak;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 240060000: 
            case 240060100: 
            case 240060200: {
                mapleSquadType = MapleSquad.MapleSquadType.horntail;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 270050100: {
                mapleSquadType = MapleSquad.MapleSquadType.pinkbean;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 802000111: {
                mapleSquadType = MapleSquad.MapleSquadType.nmm_squad;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 802000211: {
                mapleSquadType = MapleSquad.MapleSquadType.vergamot;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 802000411: {
                mapleSquadType = MapleSquad.MapleSquadType.dunas;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 802000611: {
                mapleSquadType = MapleSquad.MapleSquadType.nibergen_squad;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 802000711: {
                mapleSquadType = MapleSquad.MapleSquadType.dunas2;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 802000801: 
            case 802000802: 
            case 802000803: {
                mapleSquadType = MapleSquad.MapleSquadType.core_blaze;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 802000821: 
            case 802000823: {
                mapleSquadType = MapleSquad.MapleSquadType.aufheben;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 211070100: 
            case 211070101: 
            case 211070110: {
                mapleSquadType = MapleSquad.MapleSquadType.vonleon;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 223030210: 
            case 551030200: {
                mapleSquadType = MapleSquad.MapleSquadType.scartar;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 271040100: {
                mapleSquadType = MapleSquad.MapleSquadType.cygnus;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 105100400: {
                mapleSquadType = MapleSquad.MapleSquadType.bossbalrog;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
            case 240060001: 
            case 240060101: 
            case 240060201: {
                mapleSquadType = MapleSquad.MapleSquadType.chaosht;
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getMapleSquad(mapleSquadType);
            }
        }
        return null;
    }

    public /* synthetic */ boolean getBelongsToSomeone() {
        MapleMap a2;
        return a2.getBelongsTo() != -1;
    }

    public /* synthetic */ void boatPacket(boolean a2) {
        MapleMap a3;
        a3.broadcastMessage(MaplePacketCreator.boatPacket(a2));
    }

    public final /* synthetic */ void blockAllPortal() {
        MapleMap a2;
        Iterator<MaplePortal> iterator;
        Iterator<MaplePortal> iterator2 = iterator = a2.Da.values().iterator();
        while (iterator2.hasNext()) {
            iterator.next().setPortalState(false);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void addMapDrop(int a2, int a3, int a4, int a5, Short a6) {
        MapleMap a7;
        a7.ja.add(new MonsterDropEntry(a2, a3, a4, a5, a6.shortValue()));
        a7.c = true;
    }

    public final /* synthetic */ void broadcastMessage(byte[] a2) {
        MapleMap a3;
        a3.ALLATORIxDEMO(null, a2, Double.POSITIVE_INFINITY, null);
    }

    public final /* synthetic */ void toggleGDrops() {
        MapleMap a2;
        a2.r = !a2.r;
    }

    public /* synthetic */ boolean isDisconnected(int a2) {
        MapleMap a3;
        return a3.Ka.contains(a2);
    }

    public final /* synthetic */ boolean canHurt() {
        MapleMap a2;
        if (a2.M > 0L && a2.M + (long)a2.V < System.currentTimeMillis()) {
            a2.M = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final /* synthetic */ boolean isClosePortal() {
        MapleMap a2;
        return a2.P;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void addPlayer(MapleCharacter a) {
        block74: {
            block73: {
                block72: {
                    block71: {
                        for (MapleCharacter var3_7 : a.getAllPlayersThreadsafe()) {
                            if (var3_7.getId() != a.getId()) continue;
                            a.removePlayer(var3_7);
                        }
                        a.setPosition(new Point(a.getPosition().x, a.getPosition().y - 70));
                        a.ka.get((Object)MapleMapObjectType.PLAYER).writeLock().lock();
                        try {
                            a.aa.get((Object)MapleMapObjectType.PLAYER).put(a.getObjectId(), a);
                        }
                        finally {
                            a.ka.get((Object)MapleMapObjectType.PLAYER).writeLock().unlock();
                        }
                        a.ia.writeLock().lock();
                        try {
                            a.La.add(a);
                            v0 = a;
                            v0.ia.writeLock().unlock();
                        }
                        catch (Throwable var5_15) {
                            a.ia.writeLock().unlock();
                            throw var5_15;
                        }
                        if (v0.Ba == 109080000 || a.Ba == 109080001 || a.Ba == 109080002 || a.Ba == 109080003 || a.Ba == 109080010 || a.Ba == 109080011 || a.Ba == 109080012) {
                            a.setCoconutTeam(a.getAndSwitchTeam() != false ? 0 : 1);
                        }
                        v1 = a;
                        var2_2 = MaplePacketCreator.spawnPlayerMapobject(v1);
                        if (v1.isHidden()) break block71;
                        v2 = a;
                        a.broadcastMessage(v2, (byte[])var2_2, false);
                        if (!v2.isGM() || a.i <= 0L) break block72;
                        v3 = a;
                        v4 = a;
                        v4.endSpeedRun();
                        v4.broadcastMessage(MaplePacketCreator.getErrorNotice(MTSCSPacket.ALLATORIxDEMO("\u751b\u6599\u904a\u5fa4\u96a0\u96af\u955d\u96c7\u95a1\u4ea3\uff26\u6265\u4ecf\u9045\u5fab\u96af\u4ed1\u52fc\u591b\u6572\u3028")));
                        break block73;
                    }
                    a.broadcastGMMessage(a, (byte[])var2_2, false);
                }
                v3 = a;
            }
            if (!v3.isClone()) {
                if (!a.h.equals("") && a.getCharactersSize() == 1) {
                    MapScriptMethods.startScript_FirstUser(a.getClient(), a.h);
                }
                v5 = a;
                v6 = a;
                v5.ALLATORIxDEMO(v6);
                v6.getClient().sendPacket((byte[])var2_2);
                if (!v5.f.equals("")) {
                    MapScriptMethods.startScript_User(a.getClient(), a.f);
                }
                switch (a.Ba) {
                    case 109030001: 
                    case 109040000: 
                    case 109060001: 
                    case 109080000: {
                        a.getClient().sendPacket(MaplePacketCreator.showEventInstructions());
                        v7 = a;
                        break;
                    }
                    case 809000101: 
                    case 809000201: {
                        a.getClient().sendPacket(MaplePacketCreator.showEquipEffect());
                    }
                    default: {
                        v7 = a;
                    }
                }
                switch (v7.Ba) {
                    case 109080000: 
                    case 109080001: 
                    case 109080002: 
                    case 109080003: 
                    case 109080010: {
                        a.getClient().sendPacket(MaplePacketCreator.showEquipEffect(a.getCoconutTeam()));
                        break;
                    }
                }
            }
            v8 = var3_8 = new LinkedList<MaplePet>(a.getSummonedPets());
            Collections.sort(v8, new Comparator<MaplePet>(){
                {
                    28 a3;
                }

                @Override
                public /* synthetic */ int compare(MaplePet a2, MaplePet a3) {
                    if (a2.getSummonedValue() < a3.getSummonedValue()) {
                        return -1;
                    }
                    if (a2.getSummonedValue() == a3.getSummonedValue()) {
                        return 0;
                    }
                    return 1;
                }
            });
            for (Object var5_16 : v8) {
                if (!var5_16.getSummoned()) continue;
                v9 = a;
                var5_16.setPos(v9.getPosition());
                var2_3 = false;
                a.getClient().sendPacket(PetPacket.showPet(a, (MaplePet)var5_16, false, false, var2_3));
                v9.getClient().sendPacket(PetPacket.loadExceptionList(a, (MaplePet)var5_16));
            }
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                if (a.getSummonedFamiliar() != null) {
                    v10 = a;
                    v10.spawnFamiliar(v10.getSummonedFamiliar());
                }
                if (a.getAndroid() != null && a.checkHearts()) {
                    v11 = a;
                    a.getAndroid().setPos(v11.getPosition());
                    a.broadcastMessage(MaplePacketCreator.spawnAndroid(v11, a.getAndroid()));
                }
            }
            if (a.getParty() != null && !a.isClone()) {
                v12 = a;
                v12.silentPartyUpdate();
                v13 = a;
                v12.getClient().sendPacket(MaplePacketCreator.updateParty(a.getClient().getChannel(), v13.getParty(), PartyOperation.SILENT_UPDATE, null));
                v13.updatePartyMemberHP();
                v12.receivePartyMemberHP();
            }
            v14 = a;
            World.PartySearch.checkPartySearch(v14);
            var4_14 = v14.getStatForBuff(MapleBuffStat.SUMMON);
            if (var4_14 != null && !a.isClone()) {
                var5_16 = a.getSummonsReadLock();
                try {
                    var2_4 = var5_16.iterator();
                    while (var2_4.hasNext()) {
                        v15 = var3_10 = (MapleSummon)var2_4.next();
                        v15.setPosition(a.getTruePosition());
                        a.addVisibleMapObject(v15);
                        a.spawnSummon(v15);
                    }
                    v16 = a;
                }
                finally {
                    a.unlockSummonsReadLock();
                }
            } else {
                v16 = a;
            }
            if (v16.da != null) {
                a.da.sendStartData(a.getClient());
            }
            if (!MapConstants.isPVPMap(a.Ba) && a.z != 999999999 && a.U > 0 && a.getForcedReturnMap() != null && !a.isClone()) {
                a.startMapTimeLimitTask(a.U, a.getForcedReturnMap());
            }
            if (a.getBuffedValue(MapleBuffStat.MONSTER_RIDING) != null && FieldLimitType.Mount.check(a.x)) {
                v17 = new MapleBuffStat[1];
                v17[0] = MapleBuffStat.MONSTER_RIDING;
                a.cancelBuffStats(v17);
            }
            if (a.ALLATORIxDEMO() == 2) {
                v18 = a;
                v19 = v18;
                v18.getClient().sendPacket(MaplePacketCreator.boatPacket(true));
            } else {
                if (a.ALLATORIxDEMO() == 1 && (a.getMapId() != 200090000 || a.getMapId() != 200090010)) {
                    a.getClient().sendPacket(MaplePacketCreator.boatPacket(false));
                }
                v19 = a;
            }
            if (v19.isClone()) break block74;
            if (a.getEventInstance() != null && a.getEventInstance().isTimerStarted() && !a.isClone()) {
                a.getClient().sendPacket(MaplePacketCreator.getClock((int)(a.getEventInstance().getTimeLeft() / 1000L)));
            }
            if (a.hasClock()) {
                var5_16 = Calendar.getInstance();
                a.getClient().sendPacket(MaplePacketCreator.getClockTime(var5_16.get(11), var5_16.get(12), var5_16.get(13)));
            }
            if (a.getCarnivalParty() != null && a.getEventInstance() != null) {
                a.getEventInstance().onMapLoad(a);
            }
            v20 = a;
            MapleEvent.mapLoad(a, v20.ma, v20.Ja);
            if (a.getSquadBegin() != null && a.getSquadBegin().getTimeLeft() > 0L && a.getSquadBegin().getStatus() == 1) {
                a.getClient().sendPacket(MaplePacketCreator.getClock((int)(a.getSquadBegin().getTimeLeft() / 1000L)));
            }
            if (a.Ba / 1000 == 105100 || a.Ba / 100 == 8020003 || a.Ba / 100 == 8020008 || a.Ba == 271040100) ** GOTO lbl156
            v21 = a;
            var5_16 = v21.getSquadByMap();
            var2_5 = v21.getEMByMap();
            if (v21.G || var5_16 == null || !a.getName().equals(var5_16.getLeaderName()) || var2_5 == null || var2_5.getProperty(MerchItemPackage.ALLATORIxDEMO("@QMPIF")) == null || !var2_5.getProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X")).equals(MerchItemPackage.ALLATORIxDEMO("XFYQ")) || !a.l) ** GOTO lbl156
            if (var2_5.getProperty(MTSCSPacket.ALLATORIxDEMO("AEvBWCKO")) == null) {
                v22 = a;
                a.doShrine(false);
                a.G = true;
            } else {
                if (var2_5.getProperty(MerchItemPackage.ALLATORIxDEMO("H[\u007f\\^]BQ")) != null && var2_5.getProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X")).equals(MerchItemPackage.ALLATORIxDEMO("RMX_Q"))) {
                    a.doShrine(false);
                    a.G = true;
                }
lbl156:
                // 5 sources

                v22 = a;
            }
            if (v22.getEventInstance() != null) {
                if (a.getEventInstance().getDeathCount(a.getId()) != -1 && a.getEventInstance().isShowDeathCountMap(a.Ba)) {
                    a.getClient().announce(MaplePacketCreator.getDeathCountInfo(false, a.getEventInstance().getDeathCount(a.getId())));
                }
                if ((var5_16 = a.getEventInstance().getAggroRank(a.getId())) != null && !var5_16.isEmpty()) {
                    a.getClient().announce(MaplePacketCreator.getAggroRankInfo((List<String>)var5_16));
                }
            }
            var5_16 = a.getClones();
            var2_6 = ((WeakReference<MapleCharacter>[])var5_16).length;
            v23 = var3_11 = 0;
            while (v23 < var2_6) {
                var6_18 = var5_16[var3_12];
                if (var6_18.get() != null) {
                    ((MapleCharacter)var6_18.get()).setPosition(new Point(a.getPosition()));
                    ((MapleCharacter)var6_18.get()).setMap(a);
                    a.addPlayer((MapleCharacter)var6_18.get());
                }
                v23 = ++var3_12;
            }
            if (a.Ba == 914000000) {
                v24 = a;
                v25 = v24;
                v24.getClient().sendPacket(MaplePacketCreator.temporaryStats_Aran());
            } else if (a.Ba == 105100300 && a.getLevel() >= 91) {
                v26 = a;
                v25 = v26;
                a.getClient().sendPacket(MaplePacketCreator.temporaryStats_Balrog(v26));
            } else {
                if (a.Ba == 140090000 || a.Ba == 105100301 || a.Ba == 105100100) {
                    a.getClient().sendPacket(MaplePacketCreator.temporaryStats_Reset());
                }
                v25 = a;
            }
            if (GameConstants.isEvan(v25.getJob()) && a.getJob() >= 2200) {
                v27 = a;
                if (a.getDragon() == null) {
                    v27.makeDragon();
                    v28 = a;
                } else {
                    v27.getDragon().setPosition(a.getPosition());
                    v28 = a;
                }
                if (v28.getDragon() != null) {
                    a.broadcastMessage(MaplePacketCreator.spawnDragon(a.getDragon()));
                }
            }
            if (MapConstants.isCakeMap(a.Ba)) {
                a.cancelMorphs();
            }
        }
        if ((a.Ba == 900000001 || a.Ba == 10000 && a.getJob() == 0 || a.Ba == 130030000 && a.getJob() == 1000 || a.Ba == 914000000 && a.getJob() == 2000 || a.Ba == 900010000 && a.getJob() == 2001) && a.getOneTimeLog(MTSCSPacket.ALLATORIxDEMO("moifjgvm")) < 1) {
            a.setOneTimeLog(MerchItemPackage.ALLATORIxDEMO("dq`xcy\u007fs"));
            if (GameSetConstants.NEWPLAYER_JUMP) {
                a.getClient().removeClickedNPC();
                v29 = a;
                v30 = v29;
                NPCScriptManager.getInstance().start(v29.getClient(), 9010000, MTSCSPacket.ALLATORIxDEMO("\u6595\u6261\u8dd6\u5fe7"));
            } else {
                v31 = a;
                if (GameSetConstants.CHOOSE_JOB) {
                    v31.getClient().removeClickedNPC();
                    NPCScriptManager.getInstance().start(a.getClient(), 9010000, MerchItemPackage.ALLATORIxDEMO("\u9054\u64f3\u805b\u6959"));
                    v30 = a;
                } else {
                    v31.dropMessage(1, GameSetConstants.WELCOMEMSG);
                    v30 = a;
                }
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(GameSetConstants.getCreateNotice(v30)));
        }
        a.spawnExtraMonster(a, a.Ba);
        if (GameSetConstants.MAP_WEATHER != 0) {
            v32 = a;
            a.getClient().sendPacket(MaplePacketCreator.startMapEffect("", GameSetConstants.MAP_WEATHER, false));
        } else {
            if (a.s > 0) {
                a.getClient().sendPacket(MaplePacketCreator.startMapEffect("", a.s, false));
            }
            v32 = a;
        }
        if (v32.getPlatforms().size() > 0) {
            a.getClient().sendPacket(MaplePacketCreator.getMovingPlatforms(a));
        }
        if (a.Ca.size() > 0) {
            a.getClient().sendPacket(MaplePacketCreator.getUpdateEnvironment(a));
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (a.isTown()) {
                a.cancelEffectFromBuffStat(MapleBuffStat.RAINING_MINES);
            }
            if (!a.canSoar()) {
                a.cancelEffectFromBuffStat(MapleBuffStat.SOARING);
            }
            if (a.getJob() < 3200 || a.getJob() > 3212) {
                a.cancelEffectFromBuffStat(MapleBuffStat.AURA);
            }
        }
        a.updateWarpingMap(true);
    }

    public /* synthetic */ int getSpawnSpeed() {
        MapleMap a2;
        return a2.v;
    }

    public final /* synthetic */ void resetPQ(int a2) {
        Iterator<MapleMonster> iterator;
        MapleMap a3;
        MapleMap mapleMap = a3;
        mapleMap.resetFully();
        Iterator<MapleMonster> iterator2 = iterator = mapleMap.getAllMonstersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            iterator.next().changeLevel(a2, true);
            iterator2 = iterator;
        }
        a3.resetSpawnLevel(a2);
    }

    public final /* synthetic */ void setCreateMobInterval(short a2) {
        a.y = a2;
    }

    public final /* synthetic */ void resetlastSpawnTime() {
        a.J = System.currentTimeMillis();
    }

    public final /* synthetic */ void spawnSummon(final MapleSummon a2) {
        MapleMap a3;
        MapleSummon mapleSummon = a2;
        MapleMap mapleMap = a3;
        mapleSummon.updateMap(mapleMap);
        MapleSummon mapleSummon2 = a2;
        mapleMap.ALLATORIxDEMO(mapleSummon, new DelayedPacketCreation(){
            {
                13 a3;
            }

            @Override
            public /* synthetic */ void sendPackets(MapleClient a22) {
                13 a3;
                if (a22 != null && a22.getPlayer() != null && a3.a2 != null) {
                    a22.sendPacket(MaplePacketCreator.spawnSummon(a3.a2, true));
                }
            }
        }, null);
    }

    public final /* synthetic */ void startMapEffect(String a2, int a3, boolean a4, int a5) {
        MapleMap a6;
        if (a6.da != null) {
            return;
        }
        MapleMap mapleMap = a6;
        mapleMap.da = new MapleMapEffect(a2, a3);
        mapleMap.da.setJukebox(a4);
        mapleMap.broadcastMessage(mapleMap.da.makeStartData());
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            {
                26 a3;
            }

            @Override
            public /* synthetic */ void run() {
                26 a2;
                26 v0 = a2;
                a2.MapleMap.this.broadcastMessage(v0.MapleMap.this.da.makeDestroyData());
                v0.MapleMap.this.da = null;
            }
        }, a4 ? 300000L : (long)a5);
    }

    public final /* synthetic */ List<Pair<Integer, Integer>> getMobsToSpawn() {
        MapleMap a2;
        return a2.I.getMobsToSpawn();
    }

    public /* synthetic */ int getNumMonsters() {
        MapleMap a2;
        a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().lock();
        try {
            int n2 = a2.aa.get((Object)MapleMapObjectType.MONSTER).size();
            return n2;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().unlock();
        }
    }

    public final /* synthetic */ void resetSpawns() {
        MapleMap a2;
        boolean bl = false;
        Iterator<Spawns> iterator = a2.ea.iterator();
        block0: while (true) {
            Iterator<Spawns> iterator2 = iterator;
            while (iterator2.hasNext()) {
                if (iterator.next().getCarnivalId() <= -1) continue block0;
                Iterator<Spawns> iterator3 = iterator;
                iterator2 = iterator3;
                iterator3.remove();
                bl = true;
            }
            break;
        }
        a2.setSpawns(true);
        if (bl) {
            a2.loadMonsterRate(true);
        }
    }

    public final /* synthetic */ void setFootholds(MapleFootholdTree a2) {
        a.la = a2;
    }

    public /* synthetic */ void setLeft(int a2) {
        a.K = (short)a2;
    }

    public final /* synthetic */ void setSpawns(boolean a2) {
        a.b = a2;
    }

    public final /* synthetic */ int getId() {
        MapleMap a2;
        return a2.Ba;
    }

    public /* synthetic */ void setBoat(boolean a2) {
        a.H = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void removeNpc(int a2) {
        MapleMapObject mapleMapObject;
        Iterator<MapleMapObject> iterator;
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.NPC).writeLock().lock();
        Iterator<MapleMapObject> iterator2 = iterator = a3.aa.get((Object)MapleMapObjectType.NPC).values().iterator();
        while (iterator2.hasNext()) {
            mapleMapObject = iterator.next();
            MapleNPC mapleNPC = (MapleNPC)mapleMapObject;
            iterator2 = iterator;
        }
        try {
            iterator = a3.aa.get((Object)MapleMapObjectType.NPC).values().iterator();
            while (iterator.hasNext()) {
                mapleMapObject = (MapleNPC)iterator.next();
                if (!((AbstractLoadedMapleLife)mapleMapObject).isCustom() || a2 != -1 && ((AbstractLoadedMapleLife)mapleMapObject).getId() != a2) continue;
                MapleMap mapleMap = a3;
                MapleMapObject mapleMapObject2 = mapleMapObject;
                mapleMap.broadcastMessage(MaplePacketCreator.removeNPCController(((AbstractMapleMapObject)mapleMapObject2).getObjectId()));
                mapleMap.broadcastMessage(MaplePacketCreator.removeNPC(((AbstractMapleMapObject)mapleMapObject2).getObjectId()));
                iterator.remove();
            }
            return;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.NPC).writeLock().unlock();
        }
    }

    public final /* synthetic */ void addSpawnPoint(Point a2) {
        MapleMap a3;
        a3.Ia.add(a2);
    }

    public final /* synthetic */ void killMonster(int a2) {
        MapleMap a3;
        for (MapleMapObject mapleMapObject : a3.getAllMonstersThreadsafe()) {
            if (((MapleMonster)mapleMapObject).getId() != a2) continue;
            MapleMap mapleMap = a3;
            mapleMap.removeMapObject(mapleMapObject);
            mapleMap.broadcastMessage(MobPacket.killMonster(mapleMapObject.getObjectId(), 1));
            return;
        }
    }

    public final /* synthetic */ void startJukebox(String a2, int a3) {
        MapleMap a4;
        a4.startMapEffect(a2, a3, true);
    }

    public /* synthetic */ void endSpeedRun() {
        MapleMap a2;
        MapleMap mapleMap = a2;
        mapleMap.i = 0L;
        mapleMap.D = "";
    }

    public /* synthetic */ int getNumItems() {
        MapleMap a2;
        a2.ka.get((Object)MapleMapObjectType.ITEM).readLock().lock();
        try {
            int n2 = a2.aa.get((Object)MapleMapObjectType.ITEM).size();
            return n2;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.ITEM).readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleReactor getReactorByName(String a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            for (MapleReactor mapleReactor : a3.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                if (!mapleReactor.getName().equalsIgnoreCase(a2)) continue;
                MapleReactor mapleReactor2 = mapleReactor;
                return mapleReactor2;
            }
            Iterator<MapleMapObject> iterator = null;
            return iterator;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
    }

    public final /* synthetic */ void setClosePortal(boolean a2) {
        a.P = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<MapleCharacter> getPlayersInRectThreadsafe(Rectangle a2, List<MapleCharacter> a3) {
        MapleMap a4;
        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
        a4.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a4.La) {
                if (!a3.contains(mapleCharacter) || !a2.contains(mapleCharacter.getPosition())) continue;
                linkedList.add(mapleCharacter);
            }
            return linkedList;
        }
        finally {
            a4.ia.readLock().unlock();
        }
    }

    public final /* synthetic */ void loadMonsterRate(boolean a2) {
        MapleMap mapleMap;
        MapleMap a3;
        int n2 = a3.ea.size();
        MapleMap mapleMap2 = a3;
        a3.q = Math.round((float)n2 * mapleMap2.Ea);
        if (mapleMap2.q < 2) {
            mapleMap = a3;
            a3.q = 2;
        } else {
            if (a3.q > n2) {
                int n3 = n2;
                a3.q = n3 - n3 / 15;
            }
            mapleMap = a3;
        }
        if (mapleMap.X > 0) {
            a3.q = a3.X;
        }
        LinkedList<Spawns> linkedList = new LinkedList<Spawns>();
        LinkedList<Spawns> linkedList2 = new LinkedList<Spawns>();
        Iterator<Spawns> iterator = a3.ea.iterator();
        block0: while (true) {
            Iterator<Spawns> iterator2 = iterator;
            while (iterator2.hasNext()) {
                Spawns spawns = iterator.next();
                if (spawns.getCarnivalTeam() >= 2) {
                    iterator2 = iterator;
                    continue;
                }
                if (spawns.getMonster().getStats().isBoss()) {
                    linkedList2.add(spawns);
                    continue block0;
                }
                linkedList.add(spawns);
                continue block0;
            }
            break;
        }
        MapleMap mapleMap3 = a3;
        mapleMap3.ea.clear();
        mapleMap3.ea.addAll(linkedList2);
        a3.ea.addAll(linkedList);
        if (a2 && n2 > 0) {
            a3.J = System.currentTimeMillis();
            if (MobConstants.isForceRespawn(a3.Ba)) {
                a3.y = (short)15000;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void spawnExtraMonster(MapleCharacter a2, int a3) {
        switch (a3) {
            case 677000007: {
                MapleMap a4;
                if (a4.getMonsterById(9400611) != null || !a2.haveItem(4032494)) return;
                a4.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9400611), new Point(230, 0));
                return;
            }
            case 677000001: {
                MapleMap a4;
                if (a4.getMonsterById(9400612) != null || !a2.haveItem(4032495)) return;
                a4.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9400612), new Point(80, 0));
                return;
            }
            case 677000003: {
                MapleMap a4;
                if (a4.getMonsterById(9400610) != null || !a2.haveItem(4032492)) return;
                a4.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9400610), new Point(150, 0));
                return;
            }
            case 677000005: {
                MapleMap a4;
                if (a4.getMonsterById(9400609) != null || !a2.haveItem(4032491)) return;
                a4.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9400609), new Point(65, 0));
                return;
            }
            case 677000009: {
                MapleMap a4;
                if (a4.getMonsterById(9400613) != null || !a2.haveItem(4032493)) return;
                a4.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9400613), new Point(20, 0));
                return;
            }
        }
    }

    public /* synthetic */ Collection<MapleCharacter> getNearestPvpChar(MapleCharacter a2, double a3, double a4, Collection<MapleCharacter> a5) {
        MapleMap a6;
        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
        Point point = a2.getPosition();
        for (MapleCharacter mapleCharacter : a6.La) {
            if (!a5.contains(mapleCharacter.getClient().getPlayer())) continue;
            MapleCharacter mapleCharacter2 = mapleCharacter;
            Point point2 = mapleCharacter2.getPosition();
            Point point3 = mapleCharacter2.getMap().findClosestSpawnpoint(mapleCharacter.getPosition()).getPosition();
            double d2 = point2.distance(point3);
            double d3 = point.distance(point2.getX(), point2.getY());
            a2.dropDebugMessage("\u653b\u64ca\u65b9\u5411:" + (a2.isLeft() ? MerchItemPackage.ALLATORIxDEMO("\u5dd2") : MTSCSPacket.ALLATORIxDEMO("\u53d9")));
            if (a2.isLeft() && point.x < point2.x && d3 < a3 && d3 > 2.0 && (double)point2.y >= (double)point.y - a4 && (double)point2.y <= (double)point.y + a4 && d2 > 2.0) {
                linkedList.add(mapleCharacter);
            }
            if (!a2.isRight() || point.x <= point2.x || !(d3 < a3) || !(d3 > 2.0) || !((double)point2.y >= (double)point.y - a4) || !((double)point2.y <= (double)point.y + a4) || !(d2 > 2.0)) continue;
            linkedList.add(mapleCharacter);
        }
        return linkedList;
    }

    public final /* synthetic */ int mobCount() {
        MapleMap a2;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        return a2.getMapObjectsInRange(new Point(0, 0), Double.POSITIVE_INFINITY, Arrays.asList(arrmapleMapObjectType)).size();
    }

    public final /* synthetic */ void spawnReactor(final MapleReactor a2) {
        MapleMap a3;
        MapleReactor mapleReactor = a2;
        MapleMap mapleMap = a3;
        mapleReactor.setMap(mapleMap);
        MapleReactor mapleReactor2 = a2;
        mapleMap.ALLATORIxDEMO(mapleReactor, new DelayedPacketCreation(){
            {
                9 a3;
            }

            @Override
            public final /* synthetic */ void sendPackets(MapleClient a22) {
                9 a3;
                a22.sendPacket(MaplePacketCreator.spawnReactor(a3.a2));
            }
        }, null);
    }

    public /* synthetic */ MapleNodes.MapleNodeInfo getNode(int a2) {
        MapleMap a3;
        return a3.I.getNode(a2);
    }

    public /* synthetic */ void removeMonster(MapleMonster a2) {
        MapleMap a3;
        if (a2 == null) {
            return;
        }
        MapleMap mapleMap = a3;
        MapleMonster mapleMonster = a2;
        mapleMap.broadcastMessage(MobPacket.killMonster(mapleMonster.getObjectId(), 0));
        mapleMap.removeMapObject(mapleMonster);
        a2.killed();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void resetSpawnLevel(int a2) {
        MapleMap a3;
        a3.ca.lock();
        try {
            for (Spawns spawns : a3.ea) {
                if (!(spawns instanceof SpawnPoint)) continue;
                ((SpawnPoint)spawns).setLevel(a2);
            }
            return;
        }
        catch (Exception exception) {
            FileoutputUtil.printError(MerchItemPackage.ALLATORIxDEMO("aU\\XIyMD\u0002@T@"), exception, "\u5730\u5716\u4ee3\u78bc: " + a3.Ba);
            return;
        }
        finally {
            a3.ca.unlock();
        }
    }

    public final /* synthetic */ void resetNPCs() {
        MapleMap a2;
        a2.removeNpc(-1);
    }

    public final /* synthetic */ List<MonsterDropEntry> retrieveMapDrop() {
        MapleMap a2;
        return a2.ja;
    }

    public /* synthetic */ List<Pair<Point, Integer>> getGuardians() {
        MapleMap a2;
        return a2.I.getGuardians();
    }

    public final /* synthetic */ void toggleDrops() {
        MapleMap a2;
        a2.S = !a2.S;
    }

    public /* synthetic */ int getItemsSize() {
        MapleMap a2;
        return a2.aa.get((Object)MapleMapObjectType.ITEM).size();
    }

    public final /* synthetic */ MapleMap getForcedReturnMap() {
        MapleMap a2;
        MapleMap mapleMap = a2;
        return ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma).getMapFactory().getMap(a2.z);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleSummon> getAllSummonsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleSummon> arrayList = new ArrayList<MapleSummon>();
        a2.ka.get((Object)MapleMapObjectType.SUMMON).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.SUMMON).values()) {
                if (!(mapleMapObject instanceof MapleSummon)) continue;
                arrayList.add((MapleSummon)mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.SUMMON).readLock().unlock();
        }
    }

    public /* synthetic */ String getSpeakOutPut() {
        MapleMap a2;
        String string = MerchItemPackage.ALLATORIxDEMO("\u7115");
        for (MapleCharacter mapleCharacter : a2.getCharactersThreadsafe()) {
            if (mapleCharacter.getSpeakOutPut().isEmpty()) continue;
            string = mapleCharacter.getSpeakOutPut();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<MapleMapObject> getMapObjectsInRange(Point a2, double a3) {
        int n2;
        ArrayList<MapleMapObject> arrayList = new ArrayList<MapleMapObject>();
        MapleMapObjectType[] arrmapleMapObjectType = MapleMapObjectType.values();
        int n3 = arrmapleMapObjectType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleMap a4;
            MapleMapObjectType mapleMapObjectType = arrmapleMapObjectType[n2];
            a4.ka.get((Object)mapleMapObjectType).readLock().lock();
            try {
                for (MapleMapObject mapleMapObject : a4.aa.get((Object)mapleMapObjectType).values()) {
                    if (!(a2.distanceSq(mapleMapObject.getPosition()) <= a3)) continue;
                    arrayList.add(mapleMapObject);
                }
            }
            finally {
                a4.ka.get((Object)mapleMapObjectType).readLock().unlock();
            }
            n4 = ++n2;
        }
        return arrayList;
    }

    public /* synthetic */ int getExtractorSize() {
        MapleMap a2;
        return a2.aa.get((Object)MapleMapObjectType.EXTRACTOR).size();
    }

    public /* synthetic */ boolean getPapfight() {
        MapleMap a2;
        return a2.E;
    }

    public /* synthetic */ void boatEffect(int a2) {
        MapleMap a3;
        a3.broadcastMessage(MaplePacketCreator.boatEffect(a2));
    }

    public final /* synthetic */ void MonsterDead_SetEventCount(MapleMonster a222, MapleCharacter a3) {
        MapleMap a4;
        MapNoticeData mapNoticeData = MapNoticeFactory.getInstance().getMapNotice(((AbstractLoadedMapleLife)a222).getId());
        if (mapNoticeData != null && a4.Ba == mapNoticeData.getMapId()) {
            if (mapNoticeData.getEventCount() != null && !mapNoticeData.getEventCount().isEmpty()) {
                for (MapleCharacter mapleCharacter : a3.getMap().getCharactersThreadsafe()) {
                    MapNoticeData mapNoticeData2 = mapNoticeData;
                    mapleCharacter.setEventCount(mapNoticeData2.getEventCount());
                    if (mapNoticeData2.getChangeMap() == 0) continue;
                    mapleCharacter.changeMap(mapNoticeData.getChangeMap());
                }
            }
            if (GameSetConstants.SHOWEVENTMSG && mapNoticeData.getCongratulation() != null && !mapNoticeData.getCongratulation().isEmpty()) {
                World.Broadcast.broadcastMessage(a3.getWorld(), MaplePacketCreator.getItemNotice("[" + a3.getName() + "\u6240\u5e36\u9818\u7684\u968a\u4f0d] " + mapNoticeData.getCongratulation()));
            }
        }
        switch (((AbstractLoadedMapleLife)a222).getId()) {
            case 6400005: 
            case 8830001: 
            case 8830002: 
            case 8830007: {
                while (false) {
                }
                if (a4.Ba != 105100300) break;
                boolean bl = false;
                for (MapleCharacter a222 : a3.getMap().getCharactersThreadsafe()) {
                    if (a222.getMap().getMonsterById(8830002) == null && a222.getMap().getMonsterById(8830001) == null && a222.getMap().getMonsterById(8830007) == null) {
                        bl = true;
                        MapleCharacter mapleCharacter = a222;
                        mapleCharacter.setEventCount(MTSCSPacket.ALLATORIxDEMO("\u9b7e\u5dd1\u904a\u5fa4\u96a0"));
                        mapleCharacter.changeMap(105100301);
                        continue;
                    }
                    MapleCharacter mapleCharacter = a222;
                    mapleCharacter.dropMessage("\u60a8\u5c1a\u672a\u6e05\u9664\u5730\u5716\u4e0a\u6240\u6709\u7684\u602a\u7269\u54e6!\u9084\u6709" + mapleCharacter.getMap().getAllMonstersThreadsafe().size() + "\u500b\u602a\u7269\uff0c\u52a0\u6cb9!");
                }
                if (!bl || !GameSetConstants.SHOWEVENTMSG || GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u671e\u77c9\u8c03"))) break;
                World.Broadcast.broadcastMessage(a3.getWorld(), MaplePacketCreator.getItemNotice("\u7d93\u904e\u7121\u6578\u6b21\u7684\u6311\u6230\uff0c" + a3.getName() + "\u6240\u5e36\u9818\u7684\u968a\u4f0d\u7d42\u65bc\u64ca\u6557\u4e86\u9b54\u738b\u5df4\u6d1b\u53e4\uff01\u4f60\u5011\u624d\u662f\u771f\u6b63\u82f1\u96c4~"));
                return;
            }
            case 9400265: {
                if (a4.Ba != 802000211) break;
                for (MapleCharacter mapleCharacter : a3.getMap().getCharactersThreadsafe()) {
                    mapleCharacter.setEventCount(MTSCSPacket.ALLATORIxDEMO("\r\u6700\u4fa3\u675b\u4e89\u0003\u8cb8\u9b45\u5285\u5882\u725c\u904a\u5fa4\u96a0"));
                    if (!GameSetConstants.TOKYOBOSS_AUTOREWARD) continue;
                    if (mapleCharacter.getQuestStatus(4686) != 2) {
                        MapleQuest.getInstance(4686).forceComplete(mapleCharacter, 0);
                    }
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    MapleCharacter mapleCharacter3 = mapleCharacter;
                    mapleCharacter3.gainItem(4032181, 100);
                    mapleCharacter2.changeMap(802000210);
                    mapleCharacter3.getClient().sendPacket(MaplePacketCreator.showEffect(MerchItemPackage.ALLATORIxDEMO("EYQ_@\u0003DMFXM\u0003W@QMF")));
                    mapleCharacter2.getClient().sendPacket(MaplePacketCreator.playSound(MTSCSPacket.ALLATORIxDEMO("uKW^\\\u001b\niIODX")));
                }
                if (!GameSetConstants.SHOWEVENTMSG) break;
                World.Broadcast.broadcastMessage(a3.getWorld(), MaplePacketCreator.getItemNotice("\u7d93\u904e\u7121\u6578\u6b21\u7684\u6311\u6230\uff0c" + a3.getName() + "\u6240\u5e36\u9818\u7684\u968a\u4f0d\u7d42\u65bc\u64ca\u6557\u4e86\u8c9d\u9b6f\u52a0\u58a8\u7279\uff01\u4f60\u5011\u624d\u662f\u672a\u4f86\u6771\u4eac\u771f\u6b63\u82f1\u96c4~"));
                return;
            }
        }
    }

    public /* synthetic */ int getPlayerSize() {
        MapleMap a2;
        return a2.aa.get((Object)MapleMapObjectType.PLAYER).size();
    }

    public final /* synthetic */ SpawnPoint addMonsterSpawn(MapleMonster a2, int a3, byte a4, String a5, boolean a6) {
        boolean bl;
        MapleMap a7;
        Pair<Integer, Point> pair = a7.calcFhAndPointBelow(((AbstractMapleMapObject)a2).getPosition());
        --((Point)pair.right).y;
        a2 = new SpawnPoint((MapleMonster)a2, pair, a3, a4, a5);
        if (a4 > -1) {
            bl = a6;
            a7.ea.add(0, (Spawns)a2);
        } else {
            a7.ea.add((Spawns)a2);
            bl = a6;
        }
        if (bl) {
            ((SpawnPoint)a2).spawnMonster(a7);
        }
        return a2;
    }

    public final /* synthetic */ void removeMapObject(MapleMapObject a2) {
        MapleMap a3;
        a3.ka.get((Object)a2.getType()).writeLock().lock();
        try {
            a3.aa.get((Object)a2.getType()).remove(a2.getObjectId());
            return;
        }
        finally {
            a3.ka.get((Object)a2.getType()).writeLock().unlock();
        }
    }

    public /* synthetic */ void spawnMesoRain(MapleCharacter a2, int a3) throws InterruptedException {
        MapleMap a4;
        MapleMap mapleMap = a4;
        short s2 = mapleMap.getRight();
        short s3 = mapleMap.getLeft();
        int n2 = a2.getPosition().y - 300;
        int n3 = a2.getPosition().y;
        new Point(s2, s3);
        if (s2 < s3) {
            short s4;
            short s5 = s4 = s2;
            while (s5 < s3) {
                Point point = new Point(s4, n2);
                Point point2 = new Point(s4, n3);
                MapleCharacter mapleCharacter = a2;
                a4.spawnMesoDrops(a3, point, point2, mapleCharacter, mapleCharacter, true, (byte)0);
                s5 = (short)(s4 + 1);
            }
        } else {
            short s6;
            short s7 = s6 = s3;
            while (s7 < s2) {
                Point point = new Point(s6, n2);
                Point point3 = new Point(s6, n3);
                MapleCharacter mapleCharacter = a2;
                a4.spawnMesoDrops(a3, point, point3, mapleCharacter, mapleCharacter, true, (byte)0);
                Thread.sleep(25L);
                s7 = (short)(s6 + 15);
            }
        }
    }

    public final /* synthetic */ void spawnMesoDrops(int a22, Point a3, Point a4, MapleMapObject a5, MapleCharacter a6, boolean a7, byte a8) {
        MapleMap a9;
        MapleMap mapleMap = a9;
        Point point = a4;
        a4 = mapleMap.calcDropPos(point, point);
        MapleMapItem a22 = new MapleMapItem(a22, a4, a5, a6, a8, a7);
        mapleMap.ALLATORIxDEMO(a22, new DelayedPacketCreation(){
            public final /* synthetic */ Point d;
            public final /* synthetic */ Point a;
            public final /* synthetic */ MapleMapItem K;
            public final /* synthetic */ MapleMap ALLATORIxDEMO;

            @Override
            public /* synthetic */ void sendPackets(MapleClient a2) {
                20 a3;
                20 v0 = a3;
                a2.sendPacket(MaplePacketCreator.dropItemFromMapObject(v0.K, v0.a, a3.d, (byte)1));
            }
            {
                20 a3;
                20 v0 = a3;
                v0.ALLATORIxDEMO = a2;
                v0.K = mapleMapItem;
                a3.a = point;
                a3.d = point2;
            }
        }, null);
        if (!mapleMap.N) {
            a22.registerExpire(120000L);
            if (a8 == 0 || a8 == 1) {
                a22.registerFFA(30000L);
            }
        }
    }

    public /* synthetic */ MapleMap(int a22, int a32, int a42, int a5, float a6) {
        MapleMap a7;
        MapleMap mapleMap = a7;
        MapleMap mapleMap2 = a7;
        MapleMap mapleMap3 = a7;
        MapleMap mapleMap4 = a7;
        MapleMap mapleMap5 = a7;
        MapleMap mapleMap6 = a7;
        MapleMap mapleMap7 = a7;
        MapleMap mapleMap8 = a7;
        MapleMap mapleMap9 = a7;
        MapleMap mapleMap10 = a7;
        MapleMap mapleMap11 = a7;
        MapleMap mapleMap12 = a7;
        MapleMap mapleMap13 = a7;
        MapleMap mapleMap14 = a7;
        MapleMap mapleMap15 = a7;
        MapleMap mapleMap16 = a7;
        MapleMap mapleMap17 = a7;
        MapleMap mapleMap18 = a7;
        MapleMap mapleMap19 = a7;
        MapleMap mapleMap20 = a7;
        MapleMap mapleMap21 = a7;
        MapleMap mapleMap22 = a7;
        MapleMap mapleMap23 = a7;
        MapleMap mapleMap24 = a7;
        mapleMap24.La = new LinkedList<MapleCharacter>();
        mapleMap23.ia = new ReentrantReadWriteLock();
        mapleMap22.ga = 100000;
        mapleMap23.Fa = new ReentrantLock();
        mapleMap22.Ca = new LinkedHashMap<String, Integer>();
        mapleMap22.ea = new ArrayList<Spawns>();
        mapleMap22.Ia = new ArrayList<Point>();
        mapleMap22.Ma = new AtomicInteger(0);
        mapleMap22.Da = new HashMap<Integer, MaplePortal>();
        mapleMap22.Ka = new ArrayList<Integer>();
        mapleMap22.ba = new HashMap<Integer, List<MonsterDropEntry>>();
        mapleMap22.ja = new ArrayList<MonsterDropEntry>();
        mapleMap21.la = null;
        mapleMap21.ha = null;
        mapleMap21.ca = new ReentrantLock();
        mapleMap20.Ha = 0;
        mapleMap20.y = (short)9000;
        mapleMap19.W = 0;
        mapleMap19.p = 0;
        mapleMap18.V = 10000;
        mapleMap18.q = 0;
        mapleMap17.z = 999999999;
        mapleMap17.Y = 0;
        mapleMap16.O = 0;
        mapleMap16.s = 0;
        mapleMap15.n = 0;
        mapleMap15.v = 1;
        mapleMap14.N = false;
        mapleMap14.S = false;
        mapleMap13.r = false;
        mapleMap13.Q = false;
        mapleMap12.o = false;
        mapleMap12.Z = false;
        mapleMap11.t = false;
        mapleMap11.P = false;
        mapleMap10.w = false;
        mapleMap10.G = false;
        mapleMap9.b = true;
        mapleMap9.c = false;
        mapleMap8.l = true;
        mapleMap8.D = "";
        mapleMap7.L = null;
        mapleMap7.j = null;
        mapleMap6.i = 0L;
        mapleMap6.J = 0L;
        mapleMap5.M = 0L;
        mapleMap5.E = false;
        mapleMap4.g = false;
        mapleMap4.B = 0;
        mapleMap3.k = 0;
        mapleMap3.K = 0;
        mapleMap2.a = 0;
        mapleMap2.d = -1;
        mapleMap.Ba = a22;
        mapleMap.ma = (byte)a42;
        a7.Ja = a32;
        a7.u = a5;
        if (a7.u == 999999999) {
            a7.u = a22;
        }
        a7.Ea = a6;
        EnumMap a22 = new EnumMap(MapleMapObjectType.class);
        EnumMap<MapleMapObjectType, ReentrantReadWriteLock> a32 = new EnumMap<MapleMapObjectType, ReentrantReadWriteLock>(MapleMapObjectType.class);
        MapleMapObjectType[] a42 = MapleMapObjectType.values();
        a5 = a42.length;
        int n2 = a6 = 0;
        while (n2 < a5) {
            MapleMapObjectType mapleMapObjectType = a42[a6];
            a22.put(mapleMapObjectType, new LinkedHashMap());
            a32.put(mapleMapObjectType, new ReentrantReadWriteLock());
            n2 = ++a6;
        }
        a7.aa = Collections.unmodifiableMap(a22);
        a7.ka = Collections.unmodifiableMap(a32);
    }

    private /* synthetic */ void H(MapleMonster a2) {
        MapleMap a3;
        MapleMonster mapleMonster = a2;
        a2.setHp(0L);
        mapleMonster.spawnRevives(a3);
        a3.broadcastMessage(MobPacket.killMonster(a2.getObjectId(), 1));
        a3.removeMapObject(mapleMonster);
        if (mapleMonster.listener != null) {
            a2.listener.monsterKilled();
        }
    }

    public final /* synthetic */ void broadcastMessage(MapleCharacter a2, byte[] a3, boolean a4) {
        MapleMap a5;
        byte[] arrby;
        MapleCharacter mapleCharacter;
        if (a4) {
            mapleCharacter = null;
            arrby = a3;
        } else {
            mapleCharacter = a2;
            arrby = a3;
        }
        a5.ALLATORIxDEMO(mapleCharacter, arrby, Double.POSITIVE_INFINITY, a2.getPosition());
    }

    public final /* synthetic */ String getStreetName() {
        MapleMap a2;
        return a2.A;
    }

    public final /* synthetic */ void setReactorState() {
        MapleMap a2;
        a2.setReactorState((byte)1);
    }

    public final /* synthetic */ void spawnFakeMonster(final MapleMonster a2) {
        MapleMap a3;
        MapleMonster mapleMonster = a2;
        MapleMap mapleMap = a3;
        mapleMonster.setMap(mapleMap);
        a3.ALLATORIxDEMO(a2, new DelayedPacketCreation(){

            @Override
            public final /* synthetic */ void sendPackets(MapleClient a22) {
                8 a3;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    a22.sendPacket(MobPacket.spawnMonster(a3.a2, -4, 0));
                    return;
                }
                a22.sendPacket(MobPacket.spawnFakeMonster(a3.a2));
            }
            {
                8 a3;
            }
        }, null);
        mapleMap.updateMonsterController(mapleMonster);
    }

    public final /* synthetic */ List<MapleMapObject> getAllMonsters() {
        MapleMap a2;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        return a2.getMapObjectsInRange(new Point(0, 0), Double.POSITIVE_INFINITY, Arrays.asList(arrmapleMapObjectType));
    }

    public final /* synthetic */ void killAllMonsters(boolean a2) {
        MapleMap a3;
        Iterator<MapleMonster> iterator;
        Iterator<MapleMonster> iterator2 = iterator = a3.getAllMonstersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            MapleMonster mapleMonster;
            MapleMonster mapleMonster2 = mapleMonster = (MapleMonster)((MapleMapObject)iterator.next());
            mapleMonster2.setHp(0L);
            a3.broadcastMessage(MobPacket.killMonster(mapleMonster2.getObjectId(), a2 ? 1 : 0));
            iterator2 = iterator;
            MapleMonster mapleMonster3 = mapleMonster;
            a3.removeMapObject(mapleMonster3);
            mapleMonster3.killed();
        }
    }

    public final /* synthetic */ void setPvP() {
        MapleMap a2;
        a2.g = !a2.g;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ MapleNPC getNPCById(int a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.NPC).readLock().lock();
        try {
            for (MapleNPC mapleNPC2 : a3.aa.get((Object)MapleMapObjectType.NPC).values()) {
                if (mapleNPC2.getId() != a2) continue;
                MapleNPC mapleNPC = mapleNPC2;
                return mapleNPC;
            }
            MapleNPC mapleNPC = null;
            return mapleNPC;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.NPC).readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int getNumPlayersInArea(int a2) {
        MapleMap a3;
        int n2 = 0;
        a3.ia.readLock().lock();
        try {
            Iterator<MapleCharacter> iterator = a3.La.iterator();
            while (iterator.hasNext()) {
                if (!a3.getArea(a2).contains(iterator.next().getPosition())) continue;
                ++n2;
            }
            return n2;
        }
        finally {
            a3.ia.readLock().unlock();
        }
    }

    public /* synthetic */ int DC_SameIPCharacter() {
        MapleMap a2;
        int n2 = 0;
        List<MapleCharacter> list = a2.getAllPlayersThreadsafe();
        for (MapleCharacter mapleCharacter : list) {
            String string = mapleCharacter.getClient().getSessionIPAddress();
            for (MapleCharacter mapleCharacter2 : list) {
                if (mapleCharacter == mapleCharacter2 || !string.equalsIgnoreCase(mapleCharacter2.getClient().getSessionIPAddress()) || mapleCharacter.isGM()) continue;
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.getClient().disconnect();
                mapleCharacter3.getClient().getSession().close();
                ++n2;
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] \u7576\u524d\u5730\u5716\u73a9\u5bb6: " + mapleCharacter3.getName() + " \u5df2\u88ab\u8e22\u4e0b\u7dda! \u8207\u6b64\u89d2\u8272\u76f8\u540cIP\u73a9\u5bb6:" + mapleCharacter2.getName()));
            }
        }
        return n2;
    }

    public final /* synthetic */ void spawnExtractor(final MapleExtractor a2) {
        MapleMap a3;
        a3.ALLATORIxDEMO(a2, new DelayedPacketCreation(){

            @Override
            public /* synthetic */ void sendPackets(MapleClient a22) {
                31 a3;
                a3.a2.sendSpawnData(a22);
            }
            {
                31 a3;
            }
        }, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void killMonster(final MapleMonster a, final MapleCharacter a, boolean a, boolean a, byte a, int a) {
        block126: {
            block124: {
                block155: {
                    block154: {
                        block153: {
                            block152: {
                                block151: {
                                    block150: {
                                        block149: {
                                            block148: {
                                                block147: {
                                                    block146: {
                                                        block145: {
                                                            block144: {
                                                                block125: {
                                                                    block143: {
                                                                        block123: {
                                                                            block142: {
                                                                                block141: {
                                                                                    block140: {
                                                                                        block139: {
                                                                                            block138: {
                                                                                                block137: {
                                                                                                    block136: {
                                                                                                        block135: {
                                                                                                            block134: {
                                                                                                                block133: {
                                                                                                                    block132: {
                                                                                                                        block131: {
                                                                                                                            block130: {
                                                                                                                                block129: {
                                                                                                                                    block128: {
                                                                                                                                        block127: {
                                                                                                                                            if ((a.getId() == 8810122 || a.getId() == 8810018) && a == 0) {
                                                                                                                                                Timer.MapTimer.getInstance().schedule(new Runnable(){
                                                                                                                                                    {
                                                                                                                                                        1 a3;
                                                                                                                                                    }

                                                                                                                                                    @Override
                                                                                                                                                    public /* synthetic */ void run() {
                                                                                                                                                        1 a2;
                                                                                                                                                        1 v0 = a2;
                                                                                                                                                        1 v1 = a2;
                                                                                                                                                        v0.MapleMap.this.killMonster(v0.a, v1.a, 1 != 0, 1 != 0, (byte)1);
                                                                                                                                                        v1.MapleMap.this.killAllMonsters(true);
                                                                                                                                                    }
                                                                                                                                                }, 3000L);
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            if (a.getId() == 8820014) {
                                                                                                                                                v0 = a;
                                                                                                                                                a.killMonster(8820000);
                                                                                                                                            } else {
                                                                                                                                                if (a.getId() == 9300166) {
                                                                                                                                                    a = (byte)2;
                                                                                                                                                }
                                                                                                                                                v0 = a;
                                                                                                                                            }
                                                                                                                                            if (v0 != null && !a.isMonsterPet() && !a.isFake() && a.checkSoulWeapon() && GameSetConstants.MAPLE_VERSION >= 151) {
                                                                                                                                                a = 1 + Randomizer.nextInt(4);
                                                                                                                                                v1 = var7_20 = 0;
                                                                                                                                                while (v1 < a) {
                                                                                                                                                    var8_21 /* !! */  = new Item(4001536, 0, 1);
                                                                                                                                                    v2 = var9_22 = new MapleMapItem((IItem)var8_21 /* !! */ , a.getPosition(), (MapleMapObject)a, a, (byte)(false ? 1 : 0), false);
                                                                                                                                                    v2.registerExpire(500000L);
                                                                                                                                                    a.addMapObject((MapleMapObject)v2);
                                                                                                                                                    a.getClient().getSession().writeAndFlush((Object)MaplePacketCreator.dropItemFromMapObject((MapleMapItem)var9_22, a.getPosition(), a.getPosition(), (byte)1));
                                                                                                                                                    var9_22.setPickedUp(true);
                                                                                                                                                    a.getClient().getSession().writeAndFlush((Object)MaplePacketCreator.removeItemFromMap(var9_22.getObjectId(), 2, a.getId()));
                                                                                                                                                    a.removeMapObject((MapleMapObject)var9_22);
                                                                                                                                                    v1 = ++var7_20;
                                                                                                                                                }
                                                                                                                                                a.writeSoulPacket();
                                                                                                                                                a.checkSoulState(false);
                                                                                                                                            }
                                                                                                                                            v3 = a;
                                                                                                                                            a.removeMapObject(v3);
                                                                                                                                            a = v3.killBy(a, a);
                                                                                                                                            a.broadcastMessage(MobPacket.killMonster(v3.getObjectId(), a));
                                                                                                                                            if (a.getBuffToGive() > -1) {
                                                                                                                                                var7_20 = a.getBuffToGive();
                                                                                                                                                var8_21 /* !! */  = MapleItemInformationProvider.getInstance().getItemEffect(var7_20);
                                                                                                                                                a.ia.readLock().lock();
                                                                                                                                                try {
                                                                                                                                                    block27: for (MapleCharacter var10_23 : a.La) {
                                                                                                                                                        if (!var10_23.isAlive()) continue;
                                                                                                                                                        var8_21 /* !! */ .applyTo(var10_23);
                                                                                                                                                        switch (a.getId()) {
                                                                                                                                                            case 8810018: 
                                                                                                                                                            case 8810122: 
                                                                                                                                                            case 8820001: {
                                                                                                                                                                v4 = var10_23;
                                                                                                                                                                v4.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(var7_20, 11, var10_23.getLevel(), 1));
                                                                                                                                                                if (v4.getBuffedValue(MapleBuffStat.MORPH) != null) continue block27;
                                                                                                                                                                v5 = var10_23;
                                                                                                                                                                a.broadcastMessage(v5, MaplePacketCreator.showBuffEffect(v5.getId(), var7_20, 11, var10_23.getLevel(), 1), false);
                                                                                                                                                                continue block27;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    v6 = a;
                                                                                                                                                }
                                                                                                                                                finally {
                                                                                                                                                    a.ia.readLock().unlock();
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                v6 = a;
                                                                                                                                            }
                                                                                                                                            var7_20 = v6.getId();
                                                                                                                                            var8_21 /* !! */  = SpeedRunType.NULL;
                                                                                                                                            var9_22 = a.getSquadByMap();
                                                                                                                                            if ((GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u5e4c\u4e67\u8c03")) || GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u6e06\u8a43\u8c1dS\u001b\u0011\u0013\u000b\u0018"))) && var7_20 >= 8820000 && var7_20 <= 8820027) {
                                                                                                                                                if (a.getMonsterById(8820011) != null && a.getMonsterById(8820003) == null && a.getMonsterById(8820004) == null) {
                                                                                                                                                    v7 = a;
                                                                                                                                                    v7.killMonster(v7.getMonsterById(8820011), a, false, false, a);
                                                                                                                                                }
                                                                                                                                                if (a.getMonsterById(8820012) != null && a.getMonsterById(8820003) == null && a.getMonsterById(8820004) == null && a.getMonsterById(8820005) == null) {
                                                                                                                                                    v8 = a;
                                                                                                                                                    v8.killMonster(v8.getMonsterById(8820012), a, false, false, a);
                                                                                                                                                }
                                                                                                                                                if (a.getMonsterById(8820013) != null && a.getMonsterById(8820003) == null && a.getMonsterById(8820004) == null && a.getMonsterById(8820005) == null && a.getMonsterById(8820006) == null) {
                                                                                                                                                    v9 = a;
                                                                                                                                                    v9.killMonster(v9.getMonsterById(8820013), a, false, false, a);
                                                                                                                                                }
                                                                                                                                                if (a.getMonsterById(8820014) != null && a.getMonsterById(8820015) == null && a.getMonsterById(8820016) == null && a.getMonsterById(8820017) == null && a.getMonsterById(8820018) == null) {
                                                                                                                                                    v10 = a;
                                                                                                                                                    v10.killMonster(v10.getMonsterById(8820013), a, false, false, a);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            if (var7_20 != 8810018 || a.Ba != 240060200 || a.isGM()) break block127;
                                                                                                                                            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u7d93\u904e\u7121\u6578\u6b21\u7684\u6311\u6230\uff0c" + a.getName() + "\u6240\u5e36\u9818\u7684\u968a\u4f0d\u7d42\u65bc\u64ca\u7834\u4e86\u95c7\u9ed1\u9f8d\u738b\u7684\u9060\u5f81\u968a\uff01\u4f60\u5011\u624d\u662f\u9f8d\u4e4b\u6797\u7684\u771f\u6b63\u82f1\u96c4"));
                                                                                                                                            v11 = var10_24 = a.getCharactersThreadsafe().iterator();
                                                                                                                                            while (v11.hasNext()) {
                                                                                                                                                var11_59 = var10_24.next();
                                                                                                                                                v11 = var10_24;
                                                                                                                                                var11_59.finishAchievement(16);
                                                                                                                                            }
                                                                                                                                            FilePrinter.print("HorntailLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                                            if (a.i > 0L) {
                                                                                                                                                var8_21 /* !! */  = SpeedRunType.Horntail;
                                                                                                                                            }
                                                                                                                                            if (var9_22 != null) {
                                                                                                                                                a.doShrine(true);
                                                                                                                                            }
                                                                                                                                            a.warpMapWithClock(0xE4EE0E0, 90);
                                                                                                                                            break block124;
                                                                                                                                        }
                                                                                                                                        if (var7_20 != 8810122 || a.Ba != 240060201 || a.isGM()) break block128;
                                                                                                                                        World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u7d93\u904e\u7121\u6578\u6b21\u7684\u6311\u6230\uff0c" + a.getName() + "\u6240\u5e36\u9818\u7684\u968a\u4f0d\u7d42\u65bc\u64ca\u7834\u4e86\u6df7\u6c8c\u95c7\u9ed1\u9f8d\u738b\u7684\u9060\u5f81\u968a\uff01\u4f60\u5011\u624d\u662f\u9f8d\u4e4b\u6797\u7684\u771f\u6b63\u82f1\u96c4"));
                                                                                                                                        v12 = var10_25 = a.getCharactersThreadsafe().iterator();
                                                                                                                                        while (v12.hasNext()) {
                                                                                                                                            var11_60 = var10_25.next();
                                                                                                                                            v12 = var10_25;
                                                                                                                                            var11_60.finishAchievement(24);
                                                                                                                                        }
                                                                                                                                        FilePrinter.print("ChaosHT.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                                        if (a.i > 0L) {
                                                                                                                                            var8_21 /* !! */  = SpeedRunType.ChaosHT;
                                                                                                                                        }
                                                                                                                                        if (var9_22 != null) {
                                                                                                                                            a.doShrine(true);
                                                                                                                                        }
                                                                                                                                        a.warpMapWithClock(240060201, 90);
                                                                                                                                        break block124;
                                                                                                                                    }
                                                                                                                                    if (var7_20 != 9410066 || a.Ba != 74904000) break block129;
                                                                                                                                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u7d93\u904e\u7121\u6578\u6b21\u7684\u6311\u6230\uff0c" + a.getName() + "\u6240\u5e36\u9818\u7684\u968a\u4f0d\u7684\u9060\u5f81\u968a\u4ee5\u6c38\u4e0d\u7184\u6ec5\u7684\u71b1\u60c5\u64ca\u6557\u4e86\u821e\u9f8d\u821e\u7345\uff01\u8c61\u5fb5\u4e86\u65b0\u5e74\u597d\u7684\u958b\u59cb\uff01"));
                                                                                                                                    v13 = var10_26 = a.getCharactersThreadsafe().iterator();
                                                                                                                                    while (v13.hasNext()) {
                                                                                                                                        var11_61 = var10_26.next();
                                                                                                                                        v13 = var10_26;
                                                                                                                                        var11_61.finishAchievement(42);
                                                                                                                                    }
                                                                                                                                    FilePrinter.print("Chinese_Lion.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                                    if (a.i > 0L) {
                                                                                                                                        var8_21 /* !! */  = SpeedRunType.Chinese_Lion;
                                                                                                                                    }
                                                                                                                                    if (var9_22 != null) {
                                                                                                                                        a.doShrine(true);
                                                                                                                                    }
                                                                                                                                    break block124;
                                                                                                                                }
                                                                                                                                if (var7_20 != 8500002 || a.Ba != 220080001) break block130;
                                                                                                                                FilePrinter.print("PapLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                                if (a.i > 0L) {
                                                                                                                                    var8_21 /* !! */  = SpeedRunType.Papulatus;
                                                                                                                                }
                                                                                                                                break block124;
                                                                                                                            }
                                                                                                                            if (var7_20 != 9400266 || a.Ba != 802000111) break block131;
                                                                                                                            FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                            if (a.i > 0L) {
                                                                                                                                var8_21 /* !! */  = SpeedRunType.Nameless_Magic_Monster;
                                                                                                                            }
                                                                                                                            if (var9_22 != null) {
                                                                                                                                a.doShrine(true);
                                                                                                                            }
                                                                                                                            break block124;
                                                                                                                        }
                                                                                                                        if (var7_20 != 9400265 || a.Ba != 802000211) break block132;
                                                                                                                        FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                        if (a.i > 0L) {
                                                                                                                            var8_21 /* !! */  = SpeedRunType.Vergamot;
                                                                                                                        }
                                                                                                                        if (var9_22 != null) {
                                                                                                                            a.doShrine(true);
                                                                                                                        }
                                                                                                                        break block124;
                                                                                                                    }
                                                                                                                    if (var7_20 != 9400270 || a.Ba != 802000411) break block133;
                                                                                                                    FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                    if (a.i > 0L) {
                                                                                                                        var8_21 /* !! */  = SpeedRunType.Dunas;
                                                                                                                    }
                                                                                                                    if (var9_22 != null) {
                                                                                                                        a.doShrine(true);
                                                                                                                    }
                                                                                                                    break block124;
                                                                                                                }
                                                                                                                if (var7_20 != 9400273 || a.Ba != 802000611) break block134;
                                                                                                                FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                                if (a.i > 0L) {
                                                                                                                    var8_21 /* !! */  = SpeedRunType.Nibergen;
                                                                                                                }
                                                                                                                if (var9_22 != null) {
                                                                                                                    a.doShrine(true);
                                                                                                                }
                                                                                                                break block124;
                                                                                                            }
                                                                                                            if (var7_20 != 9400294 || a.Ba != 802000711) break block135;
                                                                                                            FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                            if (a.i > 0L) {
                                                                                                                var8_21 /* !! */  = SpeedRunType.Dunas_2;
                                                                                                            }
                                                                                                            if (var9_22 != null) {
                                                                                                                a.doShrine(true);
                                                                                                            }
                                                                                                            break block124;
                                                                                                        }
                                                                                                        if (var7_20 != 9400296 || a.Ba != 802000803) break block136;
                                                                                                        FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                        if (a.i > 0L) {
                                                                                                            var8_21 /* !! */  = SpeedRunType.Core_Blaze;
                                                                                                        }
                                                                                                        if (var9_22 != null) {
                                                                                                            a.doShrine(true);
                                                                                                        }
                                                                                                        break block124;
                                                                                                    }
                                                                                                    if (var7_20 != 9400289 || a.Ba != 802000821) break block137;
                                                                                                    FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                    if (a.i > 0L) {
                                                                                                        var8_21 /* !! */  = SpeedRunType.Aufhaven;
                                                                                                    }
                                                                                                    if (var9_22 != null) {
                                                                                                        a.doShrine(true);
                                                                                                    }
                                                                                                    break block124;
                                                                                                }
                                                                                                if (var7_20 != 9420549 && var7_20 != 9420544 || a.Ba != 551030200 && a.Ba != 223030210) break block138;
                                                                                                FilePrinter.print("MalaysiaBOSSLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                                if (a.i > 0L) {
                                                                                                    var8_21 /* !! */  = var7_20 == 9420549 ? SpeedRunType.Scarlion : SpeedRunType.Targa;
                                                                                                }
                                                                                                break block124;
                                                                                            }
                                                                                            if (var7_20 != 8820001 || a.Ba != 270050100 || a.isGM()) break block139;
                                                                                            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u4ee5\u6c38\u4e0d\u7184\u6ec5\u7684\u71b1\u60c5\u6240\u5e36\u9818\u7684\u9060\u5f81\u968a\u6253\u5012\u76ae\u5361\u557e\u554a\uff01" + a.getName() + "\u4f60\u5011\u662f\u771f\u6b63\u7684\u52c7\u8005\uff01\u771f\u6b63\u7684\u52dd\u5229\u8005\uff01"));
                                                                                            if (a.i > 0L) {
                                                                                                var8_21 /* !! */  = SpeedRunType.Pink_Bean;
                                                                                            }
                                                                                            if (var9_22 != null) {
                                                                                                a.doShrine(true);
                                                                                            }
                                                                                            FilePrinter.print("PinkbeanLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                            break block124;
                                                                                        }
                                                                                        if (var7_20 != 8800002 || a.Ba != 280030000) break block140;
                                                                                        v14 = var10_27 = a.getCharactersThreadsafe().iterator();
                                                                                        while (v14.hasNext()) {
                                                                                            var11_62 = var10_27.next();
                                                                                            v14 = var10_27;
                                                                                            var11_62.finishAchievement(15);
                                                                                        }
                                                                                        FilePrinter.print("ZakumLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                        if (a.i > 0L) {
                                                                                            var8_21 /* !! */  = SpeedRunType.Zakum;
                                                                                        }
                                                                                        if (var9_22 != null) {
                                                                                            a.doShrine(true);
                                                                                        }
                                                                                        break block124;
                                                                                    }
                                                                                    if (var7_20 != 8840000 || a.Ba != 211070100) break block141;
                                                                                    v15 = var10_28 = a.getCharactersThreadsafe().iterator();
                                                                                    while (v15.hasNext()) {
                                                                                        var11_63 = var10_28.next();
                                                                                        v15 = var10_28;
                                                                                        var11_63.finishAchievement(38);
                                                                                    }
                                                                                    if (a.i > 0L) {
                                                                                        var8_21 /* !! */  = SpeedRunType.VonLeon;
                                                                                    }
                                                                                    if (var9_22 != null) {
                                                                                        a.doShrine(true);
                                                                                    }
                                                                                    break block124;
                                                                                }
                                                                                if (var7_20 != 8800102 || a.Ba != 280030001) break block142;
                                                                                v16 = var10_29 = a.getCharactersThreadsafe().iterator();
                                                                                while (v16.hasNext()) {
                                                                                    var11_64 = var10_29.next();
                                                                                    v16 = var10_29;
                                                                                    var11_64.finishAchievement(23);
                                                                                }
                                                                                FilePrinter.print("ZakumLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                                                if (a.i > 0L) {
                                                                                    var8_21 /* !! */  = SpeedRunType.Chaos_Zakum;
                                                                                }
                                                                                if (var9_22 != null) {
                                                                                    a.doShrine(true);
                                                                                }
                                                                                break block124;
                                                                            }
                                                                            if (var7_20 < 8800003 || var7_20 > 8800010) break block143;
                                                                            var10_30 = true;
                                                                            var11_65 = a.getAllMonstersThreadsafe();
                                                                            for (MapleMonster var12_79 : var11_65) {
                                                                                if (var12_79 /* !! */ .getId() < 8800003 || var12_79 /* !! */ .getId() > 8800010) continue;
                                                                                v17 = var10_31 = false;
                                                                                break block123;
                                                                            }
                                                                            v17 = var10_30;
                                                                        }
                                                                        if (v17) {
                                                                            for (MapleMonster var12_79 : var11_65) {
                                                                                var13_85 = var12_79 /* !! */ ;
                                                                                if (var13_85.getId() != 8800000) continue;
                                                                                var14_89 = var13_85.getPosition();
                                                                                v18 = a;
                                                                                v18.killAllMonsters(true);
                                                                                v18.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(8800000), var14_89);
                                                                                break block124;
                                                                            }
                                                                        }
                                                                        break block124;
                                                                    }
                                                                    if (var7_20 < 8800103 || var7_20 > 8800110) break block144;
                                                                    var10_32 = true;
                                                                    var11_66 = a.getAllMonstersThreadsafe();
                                                                    for (MapleMonster var12_80 : var11_66) {
                                                                        if (var12_80.getId() < 8800103 || var12_80.getId() > 8800110) continue;
                                                                        v19 = var10_33 = false;
                                                                        break block125;
                                                                    }
                                                                    v19 = var10_32;
                                                                }
                                                                if (v19) {
                                                                    for (MapleMonster var12_80 : var11_66) {
                                                                        if (var12_80.getId() != 8800100) continue;
                                                                        var13_86 = var12_80.getPosition();
                                                                        v20 = a;
                                                                        v20.killAllMonsters(true);
                                                                        v20.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(8800100), var13_86);
                                                                        break block124;
                                                                    }
                                                                }
                                                                break block124;
                                                            }
                                                            if (var7_20 != 9400405 || a.Ba != 800040208) break block145;
                                                            FilePrinter.print("JapanBOSSLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                            break block124;
                                                        }
                                                        if (var7_20 != 9400408 && var7_20 != 9400409 || a.Ba != 800040410) break block146;
                                                        FilePrinter.print("JapanBOSSLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                        break block124;
                                                    }
                                                    if (a.Ba != 802000211) break block147;
                                                    switch (var7_20) {
                                                        case 9400263: {
                                                            break;
                                                        }
                                                    }
                                                    FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                    break block124;
                                                }
                                                if (a.Ba != 802000611) break block148;
                                                switch (var7_20) {
                                                    case 9400271: {
                                                        break;
                                                    }
                                                }
                                                FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                                break block124;
                                            }
                                            if (a.Ba != 802000711) break block149;
                                            switch (var7_20) {
                                                case 9400293: {
                                                    break;
                                                }
                                            }
                                            FilePrinter.print("TokyoLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                            break block124;
                                        }
                                        if (a.Ba != 551030200) break block150;
                                        switch (var7_20) {
                                            case 9420542: {
                                                break;
                                            }
                                            case 9420543: {
                                                break;
                                            }
                                            case 9420547: {
                                                break;
                                            }
                                        }
                                        FilePrinter.print("MalaysiaBOSSLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                        break block124;
                                    }
                                    if (a.Ba != 220080001) break block151;
                                    switch (var7_20) {
                                        case 8220001: {
                                            FilePrinter.print("EBPQLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                            break;
                                        }
                                        case 8500002: 
                                        case 9300028: 
                                        case 9400549: {
                                            FilePrinter.print("NBPQLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                            break;
                                        }
                                        case 8220004: 
                                        case 8220005: 
                                        case 0x7D6D66: 
                                        case 8800002: 
                                        case 9400121: 
                                        case 9400405: 
                                        case 9420544: 
                                        case 9420549: {
                                            FilePrinter.print("HBPQLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                            break;
                                        }
                                        case 8820001: 
                                        case 9400300: {
                                            FilePrinter.print("HEPQLog.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                        }
                                    }
                                    break block124;
                                }
                                if (var7_20 != 9300215 || a.Ba != 925023800) break block152;
                                v21 = a;
                                if (a.getParty() == null) {
                                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u6b66\u9675\u9053\u9928\u516c\u544a]: " + v21.getName() + "\u6210\u529f\u6311\u6230\u6b66\u9675\u9053\u5834\u6700\u5f37\u7684\u6b66\u516c\u3002"));
                                } else if (v21.getParty().getMembers().size() >= 1) {
                                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u6b66\u9675\u9053\u9928\u516c\u544a]: " + a.getName() + "\u548c\u4ed6\u7684\u5c0f\u5925\u4f34\u5011\u6210\u529f\u6311\u6230\u6b66\u9675\u9053\u5834\u6700\u5f37\u7684\u6b66\u516c\u3002"));
                                }
                                FilePrinter.print("Dojodare.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                                break block124;
                            }
                            if (var7_20 != 9300214 || a.Ba != 925023700) break block153;
                            FilePrinter.print("Dojodare.txt", a.ALLATORIxDEMO(MapleLifeFactory.getMonster(var7_20)));
                            break block124;
                        }
                        if (var7_20 != 8820008) break block154;
                        for (MapleMapObject var11_67 : a.getAllMonstersThreadsafe()) {
                            a = (MapleMonster)var11_67;
                            if (a.getLinkOid() == a.getObjectId()) continue;
                            a.killMonster(a, a, false, false, a);
                        }
                        break block124;
                    }
                    if (var7_20 < 8820010 || var7_20 > 8820014) break block155;
                    for (MapleMapObject var11_68 : a.getAllMonstersThreadsafe()) {
                        a = (MapleMonster)var11_68;
                        if (a.getId() == 8820000 || a.getId() == 8820001 || a.getObjectId() == a.getObjectId() || !a.isAlive() || a.getLinkOid() != a.getObjectId()) continue;
                        a.killMonster(a, a, false, false, a);
                    }
                    break block124;
                }
                if (!a.isEventMob()) break block124;
                if (!GameSetConstants.EVENTMOB_REWARD) ** GOTO lbl392
                var10_36 = "";
                var11_69 = Randomizer.rand(1, 3);
                a = Randomizer.rand(50000, 200000);
                var12_81 = var11_69 == 1;
                var13_87 = Randomizer.rand(100, 1000);
                var14_90 = var11_69 == 2;
                a = (byte)Randomizer.rand(1, 10);
                v22 = var7_20 = var11_69 == 3 ? 1 : 0;
                if (var12_81) {
                    var10_37 = "\u7372\u5f97\u4e86" + a + "\u6953\u5e63\u734e\u52f5";
                    v23 = a;
                } else if (var14_90) {
                    var10_38 = "\u7372\u5f97\u4e86" + var13_87 + " * \u7b49\u7d1a \u7d93\u9a57\u734e\u52f5";
                    v23 = a;
                } else {
                    if (var7_20 != 0) {
                        var10_39 = "\u7372\u5f97\u4e86" + a + "\u6953\u9ede\u734e\u52f5";
                    }
                    v23 = a;
                }
                var15_91 = LoginServer.getWorldStatic(v23.getWorld()).getChannels().iterator();
                while (true) {
                    if (var15_91.hasNext()) break block126;
                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(a.getName() + " \u6210\u529f\u64ca\u6557\u4e86\u96a8\u6a5f\u6d3b\u52d5\u602a\u7269\uff0c\u5168\u4f3a\u670d\u5668" + (String)var10_41));
lbl392:
                    // 2 sources

                    var10_43 = Randomizer.rand(GameSetConstants.EVENTMOB_POINTS[1], GameSetConstants.EVENTMOB_POINTS[2]);
                    if (GameSetConstants.EVENTMOB_POINTS[1] <= 0) break;
                    for (ChannelServer a : LoginServer.getWorldStatic(a.getWorld()).getChannels()) {
                        for (MapleCharacter var13_88 : a.getPlayerStorage().getAllCharactersThreadSafe()) {
                            if (var13_88 == null || World.Find.findChannel(var13_88.getName()) == -1) continue;
                            var13_88.modifyCSPoints(GameSetConstants.EVENTMOB_POINTS[0], var10_43);
                        }
                    }
                    var11_71 = GameSetConstants.EVENTMOB_POINTS[1] == 1 ? MTSCSPacket.ALLATORIxDEMO("\u9efb\u6552") : MerchItemPackage.ALLATORIxDEMO("\u697f\u9eea");
                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(a.getName() + " \u6210\u529f\u64ca\u6557\u4e86\u96a8\u6a5f\u6d3b\u52d5\u602a\u7269\uff0c\u5168\u4f3a\u670d\u5668\u7372\u5f97" + var11_71 + " " + var10_43 + " \u9ede!"));
                    break;
                }
            }
            if (GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u6700\u77c0\u8c1d")) && (a.getId() == 8810018 && a.Ba == 240060200 || a.getId() == 8800002 && a.Ba == 280030000 || a.getId() == 8860000 && a.Ba == 993053100 || a.getId() == 8870200 && a.Ba == 993053100 || a.getId() == 9450020 && a.Ba == 993053100)) {
                for (ChannelServer var11_72 : LoginServer.getWorldStatic(a.getWorld()).getChannels()) {
                    for (MapleCharacter var12_83 : var11_72.getPlayerStorage().getAllCharactersThreadSafe()) {
                        if (var12_83 == null || World.Find.findChannel(var12_83.getName()) == -1) continue;
                        var12_83.modifyCSPoints(true ? 1 : 0, 5, true);
                    }
                }
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(a.getName() + " \u6210\u529f\u64ca\u6557" + a.getName() + "\uff0c\u5168\u4f3a\u670d\u5668\u7372\u5f975\u9edeGASH!"));
            }
            if (GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u5e4c\u4e67\u8c03")) && (a.getId() == 8810122 && a.Ba == 240060201 || a.getId() == 8800102 && a.Ba == 280030001 || a.getId() == 8860000 && a.Ba == 272020200 || a.getId() == 8820001 && a.Ba == 270050100 || a.getId() == 9450038 && a.Ba == 105200511 || a.getId() == 9440025 && a.Ba == 105200210)) {
                for (ChannelServer var11_73 : LoginServer.getWorldStatic(a.getWorld()).getChannels()) {
                    for (MapleCharacter var12_84 : var11_73.getPlayerStorage().getAllCharactersThreadSafe()) {
                        if (var12_84 == null || World.Find.findChannel(var12_84.getName()) == -1) continue;
                        var12_84.modifyCSPoints(2, 10, true);
                    }
                }
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(a.getName() + " \u6210\u529f\u64ca\u6557" + a.getName() + "\uff0c\u5168\u4f3a\u670d\u5668\u7372\u5f9710\u9ede\u6953\u9ede!"));
            }
            if (GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u6595\u829b\u5366\u8c1d"))) {
                if (a.getId() == 9410070) {
                    var10_46 = 10;
                    v24 = var11_74 = a.getAllPlayersThreadsafe().iterator();
                    while (v24.hasNext()) {
                        a = var11_74.next();
                        v24 = var11_74;
                        a.gainPoints(var10_46);
                    }
                    a.broadcastMessage(MaplePacketCreator.getErrorNotice("\u606d\u559c\u64ca\u6557: " + a.getName() + " \u5168\u5730\u5716\u7372\u5f97\u7d05\u5229\u9ede\u6578" + var10_46 + "\u9ede!"));
                }
                if (a.getId() == 9410071) {
                    var10_47 = 20;
                    v25 = var11_75 = a.getAllPlayersThreadsafe().iterator();
                    while (v25.hasNext()) {
                        a = var11_75.next();
                        v25 = var11_75;
                        a.gainPoints(var10_47);
                    }
                    a.broadcastMessage(MaplePacketCreator.getErrorNotice("\u606d\u559c\u64ca\u6557: " + a.getName() + " \u5168\u5730\u5716\u7372\u5f97\u7d05\u5229\u9ede\u6578" + var10_47 + "\u9ede!"));
                }
                if (a.getId() == 9410072) {
                    var10_48 = 30;
                    v26 = var11_76 = a.getAllPlayersThreadsafe().iterator();
                    while (v26.hasNext()) {
                        a = var11_76.next();
                        v26 = var11_76;
                        a.gainPoints(var10_48);
                    }
                    a.broadcastMessage(MaplePacketCreator.getErrorNotice("\u606d\u559c\u64ca\u6557: " + a.getName() + " \u5168\u5730\u5716\u7372\u5f97\u7d05\u5229\u9ede\u6578" + var10_48 + "\u9ede!"));
                }
                if (a.getId() == 9410073) {
                    var10_49 = 40;
                    v27 = var11_77 = a.getAllPlayersThreadsafe().iterator();
                    while (v27.hasNext()) {
                        a = var11_77.next();
                        v27 = var11_77;
                        a.gainPoints(var10_49);
                    }
                    a.broadcastMessage(MaplePacketCreator.getErrorNotice("\u606d\u559c\u64ca\u6557: " + a.getName() + " \u5168\u5730\u5716\u7372\u5f97\u7d05\u5229\u9ede\u6578" + var10_49 + "\u9ede!"));
                }
                if (a.getId() == 9410074) {
                    var10_50 = 50;
                    v28 = var11_78 = a.getAllPlayersThreadsafe().iterator();
                    while (v28.hasNext()) {
                        a = var11_78.next();
                        v28 = var11_78;
                        a.gainPoints(var10_50);
                    }
                    a.broadcastMessage(MaplePacketCreator.getErrorNotice("\u606d\u559c\u64ca\u6557: " + a.getName() + " \u5168\u5730\u5716\u7372\u5f97\u7d05\u5229\u9ede\u6578" + var10_50 + "\u9ede!"));
                }
            }
            if (var8_21 /* !! */  != SpeedRunType.NULL && a.i > 0L && a.D.length() > 0) {
                var10_51 = System.currentTimeMillis();
                v29 = a;
                a = StringUtil.getReadableMillis(v29.i, var10_51);
                v29.broadcastMessage(MaplePacketCreator.getErrorNotice(v29.D + "'\u9060\u5f81\u968a\u82b1\u4e86 " + a + " \u6642\u9593\u6253\u6557\u4e86 " + var8_21 /* !! */  + "!"));
                v30 = a;
                v30.getRankAndAdd(v30.D, a, var8_21 /* !! */ , var10_51 - a.i, var9_22 == null ? null : var9_22.getMembers());
                a.endSpeedRun();
            }
            if (a) {
                var10_52 = null;
                if (a <= 0) {
                    var10_53 = a;
                    v31 = a;
                } else {
                    var10_54 = a.getCharacterById(a);
                    if (var10_54 == null) {
                        var10_55 = a;
                    }
                    v31 = a;
                }
                v31.ALLATORIxDEMO((MapleCharacter)var10_57, a);
                a.l((MapleCharacter)var10_57, a);
                if (GameSetConstants.isHell(a.getClient().getChannel())) {
                    a.H((MapleCharacter)var10_57, a);
                }
            }
            if (a != null && !a.isMonsterPet()) {
                v32 = a;
                v33 = a;
                v33.MonsterDead_SetEventCount(a, a);
                v33.AddMonsterPetKill(v32, a);
                v34 = a;
                v34.handleHpMpRecover();
                v34.addMobKill(v32.getId());
            }
            a.statClear();
            return;
        }
        var16_92 = var15_91.next().getPlayerStorage().getAllCharactersThreadSafe().iterator();
        while (true) lbl-1000:
        // 7 sources

        {
            if (!var16_92.hasNext()) ** continue;
            var17_93 = var16_92.next();
            if (var17_93 == null || World.Find.findChannel(var17_93.getName()) == -1) ** continue;
            if (var12_81) {
                if (var17_93.getMeso() + a < 0x7FFFFFFF) {
                    var17_93.gainMeso(a, true);
                    ** continue;
                }
                var17_93.dropMessage(MerchItemPackage.ALLATORIxDEMO("\u6084\u76b0\u80e0\u5331\u697f\u5e57\u5dde\u7da7\u6ed3\u56fd\r\u7115\u6cf9\u51b9\u735e\u5fa3\u6d17\u52e1\u6006\u725d\u5144\u6739\u697f\u5e57\u7362\u52c1"));
                ** continue;
            }
            if (var14_90) {
                v35 = var17_93;
                v35.gainExp(v35.getLevel() * var13_87, true, true, false);
                ** continue;
            }
            if (var7_20 == 0) ** continue;
            var17_93.modifyCSPoints(2, a);
        }
    }

    public final /* synthetic */ Rectangle getArea(int a2) {
        MapleMap a3;
        return a3.I.getArea(a2);
    }

    public /* synthetic */ int getPartyBonusRate() {
        MapleMap a2;
        return a2.n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void removePlayer(MapleCharacter a2) {
        Iterator<MapleSummon> iterator;
        MapleMap mapleMap;
        Object object;
        MapleMap a3;
        block24: {
            if (a3.N) {
                a3.returnEverLastItem(a2);
            }
            a3.ia.writeLock().lock();
            try {
                a3.La.remove(a2);
            }
            finally {
                a3.ia.writeLock().unlock();
            }
            World.PartySearch.stopSearch(a2);
            MapleCharacter mapleCharacter = a2;
            a3.removeMapObject(mapleCharacter);
            a2.checkFollow();
            mapleCharacter.removeExtractor();
            if (mapleCharacter.getMapId() == 220080001 && a2.getMap().playerCount() <= 0) {
                MapleMap mapleMap2 = a3;
                if (ChannelServer.getInstance(mapleMap2.Ja, mapleMap2.ma) != null) {
                    try {
                        MapleMap mapleMap3 = a3;
                        object = ChannelServer.getInstance(mapleMap3.Ja, mapleMap3.ma).getMapFactory().getMap(220080000);
                        ((MapleMap)object).EndPapfight();
                        ((MapleMap)object).resetReactors();
                        mapleMap = a3;
                        break block24;
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
            mapleMap = a3;
        }
        mapleMap.broadcastMessage(MaplePacketCreator.removePlayerFromMap(a2.getId()));
        object = new ArrayList();
        Object object2 = a2.getSummonsReadLock();
        try {
            object2 = object2.iterator();
            while (object2.hasNext()) {
                iterator = (MapleSummon)object2.next();
                MapleSummon mapleSummon = iterator;
                a3.broadcastMessage(MaplePacketCreator.removeSummon((MapleSummon)((Object)iterator), true));
                a3.removeMapObject(mapleSummon);
                if (mapleSummon.getMovementType() == SummonMovementType.STATIONARY || ((MapleSummon)((Object)iterator)).getMovementType() == SummonMovementType.CIRCLE_STATIONARY || ((MapleSummon)((Object)iterator)).getMovementType() == SummonMovementType.WALK_STATIONARY) {
                    object.add(iterator);
                    continue;
                }
                ((MapleSummon)((Object)iterator)).setChangedMap(true);
            }
        }
        finally {
            a2.unlockSummonsReadLock();
        }
        Object object3 = object2 = object.iterator();
        while (object3.hasNext()) {
            iterator = (MapleSummon)object2.next();
            object3 = object2;
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.removeSummon((MapleSummon)((Object)iterator));
            mapleCharacter.dispelSkill(((MapleSummon)((Object)iterator)).getSkill());
        }
        if (!a2.isClone()) {
            int n2;
            Iterator iterator2;
            object2 = new ArrayList();
            iterator = a2.getControlled().iterator();
            while (iterator.hasNext()) {
                MapleMonster object4 = (MapleMonster)((Object)iterator.next());
                if (object4 == null) continue;
                MapleMonster mapleMonster = object4;
                MapleMonster mapleMonster2 = object4;
                mapleMonster2.setController(null);
                mapleMonster2.setControllerHasAggro(false);
                mapleMonster.setControllerKnowsAboutAggro(false);
                iterator.remove();
                object2.add(mapleMonster);
            }
            Iterator iterator3 = iterator2 = object2.iterator();
            while (iterator3.hasNext()) {
                object = (MapleMonster)iterator2.next();
                iterator3 = iterator2;
                a3.updateMonsterController((MapleMonster)object);
            }
            a2.leaveMap();
            MapleMap mapleMap4 = a3;
            mapleMap4.checkStates(a2.getName());
            if (mapleMap4.Ba == 109020001) {
                a2.canTalk_event(true);
            }
            WeakReference<MapleCharacter>[] arrweakReference = a2.getClones();
            int n3 = arrweakReference.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                WeakReference<MapleCharacter> weakReference = arrweakReference[n2];
                if (weakReference.get() != null) {
                    a3.removePlayer((MapleCharacter)weakReference.get());
                }
                n4 = ++n2;
            }
        }
        a2.cancelEffectFromBuffStat(MapleBuffStat.REAPER);
        boolean bl = false;
        for (MapleSummon mapleSummon : a2.getSummons()) {
            if (mapleSummon.getMovementType() == SummonMovementType.STATIONARY || mapleSummon.getMovementType() == SummonMovementType.CIRCLE_STATIONARY || mapleSummon.getMovementType() == SummonMovementType.WALK_STATIONARY) {
                bl = true;
                continue;
            }
            mapleSummon.setChangedMap(true);
            a3.removeMapObject(mapleSummon);
        }
        if (bl) {
            a2.cancelEffectFromBuffStat(MapleBuffStat.SUMMON);
        }
    }

    public final /* synthetic */ void setForceMove(int a2) {
        a.Y = a2;
    }

    public final /* synthetic */ MapleCharacter getCharacterById_InMap(int a2) {
        MapleMap a3;
        return a3.getCharacterById(a2);
    }

    public /* synthetic */ int getBelongsTo() {
        MapleMap a2;
        MapleMap mapleMap = a2;
        if (mapleMap.getCharacterById(mapleMap.d) == null || a2.ALLATORIxDEMO < System.currentTimeMillis()) {
            a2.d = -1;
        }
        return a2.d;
    }

    private /* synthetic */ void H(MapleCharacter a2, MapleMonster a3) {
        double d2;
        Iterator iterator;
        MapleMap a4;
        block17: {
            block16: {
                if (a3 == null || a2 == null) break block16;
                MapleMap mapleMap = a4;
                if (ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma) != null && !a3.dropsDisabled() && a2.getPyramidSubway() == null) break block17;
            }
            return;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        Object object = MapleMonsterInformationProvider.getInstance();
        byte by = (byte)(a3.getStats().isExplosiveReward() ? 3 : (a3.getStats().isFfaLoot() ? 2 : (a2.getParty() != null ? 1 : 0)));
        MapleMonster mapleMonster = a3;
        int n2 = mapleMonster.getPosition().x;
        double d3 = a2.getAllMesoRate();
        int n3 = 1;
        Point point = new Point(0, a3.getPosition().y);
        d3 = 0.0;
        if (!mapleMonster.getStats().isBoss() && (iterator = a3.getBuff(MonsterStatus.SHOWDOWN)) != null) {
            d3 += (double)((MonsterStatusEffect)((Object)iterator)).getX().intValue();
        }
        iterator = new ArrayList<MonsterGlobalDropEntry>(((MapleMonsterInformationProvider)object).getGlobalDrop_Hell());
        Collections.shuffle(iterator);
        d3 = (double)a3.getLevel() / (double)a2.getLevel();
        if (d2 > 2.0) {
            d3 = 2.0;
        }
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            MapleMap mapleMap;
            MonsterGlobalDropEntry monsterGlobalDropEntry = (MonsterGlobalDropEntry)iterator.next();
            double d4 = (double)monsterGlobalDropEntry.chance * d3;
            double d5 = d4 / 999999.0;
            a2.dropDebugMessage("\u6389\u843d:" + MapleItemInformationProvider.getInstance().getName(monsterGlobalDropEntry.itemId) + "\u6a5f\u7387: " + d5);
            if (!((double)Randomizer.nextInt(999999) < d4) || !(monsterGlobalDropEntry.continent < 0 || monsterGlobalDropEntry.continent < 10 && a4.Ba / 100000000 == monsterGlobalDropEntry.continent || monsterGlobalDropEntry.continent < 100 && a4.Ba / 10000000 == monsterGlobalDropEntry.continent) && (monsterGlobalDropEntry.continent >= 1000 || a4.Ba / 1000000 != monsterGlobalDropEntry.continent)) continue;
            if (by == 3) {
                point.x = n2 + (n3 % 2 == 0 ? 40 * (n3 + 1) / 2 : -(40 * (n3 / 2)));
                mapleMap = a4;
            } else {
                point.x = n2 + (n3 % 2 == 0 ? 25 * (n3 + 1) / 2 : -(25 * (n3 / 2)));
                mapleMap = a4;
            }
            if (mapleMap.Q) continue;
            if (GameConstants.getInventoryType(monsterGlobalDropEntry.itemId) == MapleInventoryType.EQUIP) {
                MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
                object = mapleItemInformationProvider2.randomizeStats((Equip)mapleItemInformationProvider2.getEquipById(monsterGlobalDropEntry.itemId));
            } else {
                int n4;
                if (monsterGlobalDropEntry.Maximum != 1) {
                    MonsterGlobalDropEntry monsterGlobalDropEntry2 = monsterGlobalDropEntry;
                    n4 = Randomizer.rand(monsterGlobalDropEntry2.Minimum, monsterGlobalDropEntry2.Maximum);
                } else {
                    n4 = 1;
                }
                object = new Item(monsterGlobalDropEntry.itemId, 0, (short)n4, 0);
            }
            if (MapleItemInformationProvider.getInstance().itemExists(object.getItemId())) {
                MonsterGlobalDropEntry monsterGlobalDropEntry3;
                byte by2;
                MapleMap mapleMap2 = a4;
                Point point2 = mapleMap2.calcDropPos(point, a3.getPosition());
                if (monsterGlobalDropEntry.onlySelf) {
                    by2 = 0;
                    monsterGlobalDropEntry3 = monsterGlobalDropEntry;
                } else {
                    by2 = by;
                    monsterGlobalDropEntry3 = monsterGlobalDropEntry;
                }
                mapleMap2.spawnMobDrop((IItem)object, point2, a3, a2, by2, monsterGlobalDropEntry3.questid);
            }
            if (GameSetConstants.HELLDROP_BROCAST && monsterGlobalDropEntry.chance < 500) {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5730\u7344\u983b\u9053] \u606d\u559c" + a2.getName() + "\u525b\u624d\u5728 \u5730\u7344\u983b\u9053 \u6253\u5230\u4e86 " + MapleItemInformationProvider.getInstance().getName(monsterGlobalDropEntry.itemId) + "\uff01"));
            }
            n3 = (byte)(n3 + 1);
        }
    }

    public final /* synthetic */ void disconnectAll(MapleCharacter a2) {
        MapleMap a3;
        for (MapleCharacter mapleCharacter : a3.getCharactersThreadsafe()) {
            if (mapleCharacter.getGMLevel() >= a2.getGMLevel()) continue;
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.getClient().disconnect();
            mapleCharacter2.getClient().getSession().close();
        }
    }

    public /* synthetic */ boolean getAndSwitchTeam() {
        MapleMap a2;
        return a2.getCharactersSize() % 2 != 0;
    }

    public final /* synthetic */ void removeDrops() {
        MapleMap a2;
        Iterator<MapleMapItem> iterator;
        Iterator<MapleMapItem> iterator2 = iterator = a2.getAllItemsThreadsafe().iterator();
        while (iterator2.hasNext()) {
            iterator.next().expire(a2);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void setSoaring(boolean a2) {
        a.w = a2;
    }

    public final /* synthetic */ void spawnRandDrop() {
        MapleMap a2;
        if (a2.Ba != 910000000 || a2.ma != 1) {
            return;
        }
        a2.ka.get((Object)MapleMapObjectType.ITEM).readLock().lock();
        try {
            Iterator<MapleMapObject> iterator = a2.aa.get((Object)MapleMapObjectType.ITEM).values().iterator();
            while (iterator.hasNext()) {
                if (!((MapleMapItem)iterator.next()).isRandDrop()) continue;
                return;
            }
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.ITEM).readLock().unlock();
        }
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            {
                23 a3;
            }

            @Override
            public /* synthetic */ void run() {
                23 v0;
                23 a2;
                Point point = new Point(Randomizer.nextInt(800) + 531, -806);
                int n2 = Randomizer.nextInt(1000);
                int n3 = 0;
                if (n2 < 950) {
                    n3 = GameConstants.normalDrops[Randomizer.nextInt(GameConstants.normalDrops.length)];
                    v0 = a2;
                } else if (n2 < 990) {
                    n3 = GameConstants.rareDrops[Randomizer.nextInt(GameConstants.rareDrops.length)];
                    v0 = a2;
                } else {
                    n3 = GameConstants.superDrops[Randomizer.nextInt(GameConstants.superDrops.length)];
                    v0 = a2;
                }
                v0.MapleMap.this.spawnAutoDrop(n3, point);
            }
        }, 20000L);
    }

    public /* synthetic */ List<Point> getSpawnPoints() {
        MapleMap a2;
        return a2.Ia;
    }

    public /* synthetic */ MaplePortal findClosestSpawnpoint(Point a2) {
        MapleMap a3;
        MaplePortal maplePortal = null;
        double d2 = Double.POSITIVE_INFINITY;
        for (MaplePortal maplePortal2 : a3.Da.values()) {
            double d3 = maplePortal2.getPosition().distanceSq(a2);
            if (maplePortal2.getType() < 0 || maplePortal2.getType() > 2 || !(d3 < d2) || maplePortal2.getTargetMapId() != 999999999) continue;
            maplePortal = maplePortal2;
            d2 = d3;
        }
        return maplePortal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void addMapObject(MapleMapObject a2) {
        int n2;
        MapleMap a3;
        a3.Fa.lock();
        try {
            n2 = ++a3.ga;
        }
        finally {
            a3.Fa.unlock();
        }
        a2.setObjectId(n2);
        a3.ka.get((Object)a2.getType()).writeLock().lock();
        try {
            a3.aa.get((Object)a2.getType()).put(n2, a2);
            return;
        }
        finally {
            a3.ka.get((Object)a2.getType()).writeLock().unlock();
        }
    }

    public final /* synthetic */ void shuffleReactors() {
        MapleMap a2;
        a2.shuffleReactors(0, 9999999);
    }

    public final /* synthetic */ void spawnMonster(MapleMonster a2, int a3) {
        MapleMap a4;
        a4.spawnMonster(a2, a3, false);
    }

    public final /* synthetic */ void addDrop(int a2, int a3, int a4, int a5, int a6) {
        MapleMap a7;
        a7.addDrop(a2, a3, a4, a5, a6, (short)0);
    }

    public final /* synthetic */ void setTimeLimit(int a2) {
        a.U = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void shuffleReactors(int a2, int a3) {
        MapleReactor mapleReactor;
        MapleMap a4;
        ArrayList<Point> arrayList = new ArrayList<Point>();
        a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a4.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                mapleReactor = (MapleReactor)mapleMapObject;
                if (mapleReactor.getReactorId() < a2 || mapleReactor.getReactorId() > a3) continue;
                arrayList.add(mapleReactor.getPosition());
            }
        }
        finally {
            a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
        Collections.shuffle(arrayList);
        a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a4.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                mapleReactor = (MapleReactor)mapleMapObject;
                if (mapleReactor.getReactorId() < a2 || mapleReactor.getReactorId() > a3) continue;
                ArrayList<Point> arrayList2 = arrayList;
                mapleReactor.setPosition((Point)arrayList2.remove(arrayList2.size() - 1));
            }
            return;
        }
        finally {
            a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
    }

    public final /* synthetic */ void spawnFakeMonsterOnGroundBelow(MapleMonster a2, Point a3) {
        MapleMap a4;
        MapleMap mapleMap = a4;
        Point point = a3;
        a3 = mapleMap.calcPointBelow(new Point(point.x, point.y - 1));
        MapleMonster mapleMonster = a2;
        --a3.y;
        mapleMonster.setPosition(a3);
        mapleMap.spawnFakeMonster(mapleMonster);
    }

    public /* synthetic */ short getLeft() {
        MapleMap a2;
        return a2.K;
    }

    public /* synthetic */ void warpMapWithClock(final int a2, int a3) {
        Iterator<MapleCharacter> iterator;
        MapleMap a4;
        final MapleMap mapleMap = a4;
        Iterator<MapleCharacter> iterator2 = iterator = mapleMap.getAllPlayersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getClient().sendPacket(MaplePacketCreator.getClock(a3));
            iterator2 = iterator;
        }
        Timer.MapTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                Iterator<MapleCharacter> iterator;
                32 a22;
                32 v0 = a22;
                MapleMap mapleMap3 = ChannelServer.getInstance(a22.MapleMap.this.Ja, a22.MapleMap.this.ma).getMapFactory().getMap(v0.a2);
                Iterator<MapleCharacter> iterator2 = iterator = v0.mapleMap.getAllPlayersThreadsafe().iterator();
                while (iterator2.hasNext()) {
                    MapleCharacter mapleCharacter = iterator.next();
                    iterator2 = iterator;
                    MapleMap mapleMap2 = mapleMap3;
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    mapleCharacter2.getClient().sendPacket(MaplePacketCreator.stopClock());
                    mapleCharacter2.changeMap(mapleMap2, mapleMap2.getPortal(0));
                }
            }
            {
                32 a3;
            }
        }, 1000 * a3);
    }

    public final /* synthetic */ int getReturnMapId() {
        MapleMap a2;
        return a2.u;
    }

    public final /* synthetic */ void setClickGameMap(boolean a2) {
        a.t = a2;
    }

    public final /* synthetic */ void setFirstUserEnter(String a2) {
        a.h = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void movePlayer(MapleCharacter a2, Point a3) {
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.setPosition((Point)((Object)a3));
        if (!mapleCharacter.isClone()) {
            try {
                MapleMap a4;
                a3 = a2.getAndWriteLockVisibleMapObjects();
                for (Object object : new ArrayList<MapleMapObject>(a3)) {
                    if (object != null && a4.getMapObject(object.getObjectId(), object.getType()) == object) {
                        a4.updateMapObjectVisibility(a2, (MapleMapObject)object);
                        continue;
                    }
                    if (object == null) continue;
                    a3.remove(object);
                }
                for (MapleMapObject mapleMapObject : a4.getMapObjectsInRange(a2.getPosition(), GameConstants.maxViewRangeSq())) {
                    if (mapleMapObject == null || a2.isMapObjectVisible(mapleMapObject)) continue;
                    MapleMapObject mapleMapObject2 = mapleMapObject;
                    mapleMapObject2.sendSpawnData(a2.getClient());
                    a3.add(mapleMapObject2);
                }
                return;
            }
            finally {
                a2.unlockWriteVisibleMapObjects();
            }
        }
    }

    public final /* synthetic */ Pair<Integer, Point> calcFhAndPointBelow(Point a2) {
        int n2;
        MapleMap a3;
        MapleFoothold mapleFoothold = a3.la.findBelow(a2);
        if (mapleFoothold == null) {
            return new Pair<Integer, Object>(0, null);
        }
        int n3 = mapleFoothold.getY1();
        int n4 = a2.x < a3.K + 30 ? a3.K + 30 : (n2 = a2.x > a3.a - 30 ? a3.a - 30 : a2.x);
        if (!mapleFoothold.isWall() && mapleFoothold.getY1() != mapleFoothold.getY2()) {
            MapleFoothold mapleFoothold2 = mapleFoothold;
            MapleFoothold mapleFoothold3 = mapleFoothold;
            double d2 = Math.abs(mapleFoothold2.getY2() - mapleFoothold3.getY1());
            double d3 = Math.abs(mapleFoothold2.getX2() - mapleFoothold.getX1());
            n3 = mapleFoothold3.getY2() < mapleFoothold.getY1() ? mapleFoothold.getY1() - (int)(Math.cos(Math.atan(d3 / d2)) * ((double)Math.abs(a2.x - mapleFoothold.getX1()) / Math.cos(Math.atan(d2 / d3)))) : mapleFoothold.getY1() + (int)(Math.cos(Math.atan(d3 / d2)) * ((double)Math.abs(a2.x - mapleFoothold.getX1()) / Math.cos(Math.atan(d2 / d3))));
        }
        return new Pair<Integer, Point>(mapleFoothold.getId(), new Point(n2, n3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void moveMonster(MapleMonster a2, Point a3) {
        MapleMap a4;
        a2.setPosition((Point)a3);
        a4.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a4.La) {
                a4.updateMapObjectVisibility(mapleCharacter, a2);
            }
            return;
        }
        finally {
            a4.ia.readLock().unlock();
        }
    }

    public final /* synthetic */ List<MapleMapObject> getMapObjects(List<MapleMapObjectType> a2) {
        MapleMap a3;
        return a3.getMapObjectsInRange(new Point(0, 0), Double.MAX_VALUE, a2);
    }

    public /* synthetic */ int getMobsSize() {
        MapleMap a2;
        return a2.aa.get((Object)MapleMapObjectType.MONSTER).size();
    }

    public final /* synthetic */ void spawnMonster(MapleMonster a2) {
        Point point;
        MapleMap a3;
        if (a3.Ia.size() > 0) {
            MapleMap mapleMap = a3;
            mapleMap.spawnMonsterOnGroundBelow(a2, mapleMap.Ia.get(Randomizer.rand(0, a3.Ia.size() - 1)));
            return;
        }
        if (a3.getFootholds() != null && (point = a3.getFootholds().getRandomPos()) != null) {
            a3.spawnMonsterOnGroundBelow(a2, point);
        }
    }

    public final /* synthetic */ void setRecoveryRate(float a2) {
        a.Aa = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void getRankAndAdd(String a, String a, SpeedRunType a, long a, Collection<String> a) {
        try {
            block13: {
                block12: {
                    var7_6 = DBConPool.getInstance().getDataSource().getConnection();
                    var8_8 = new StringBuilder();
                    if (a != null) {
                        v0 = var9_10 = a.iterator();
                        while (v0.hasNext()) {
                            var10_12 = (String)var9_10.next();
                            v0 = var9_10;
                            var8_8.append((String)var10_12);
                            var8_8.append(MTSCSPacket.ALLATORIxDEMO("\u0006"));
                        }
                    }
                    var9_10 = var8_8.toString();
                    if (a == null) break block12;
                    v1 = var9_10;
                    var9_10 = v1.substring(0, v1.length() - 1);
                    {
                        catch (Throwable var8_9) {
                            if (var7_6 != null) {
                                try {
                                    var7_6.close();
                                    v2 = var8_9;
                                    throw v2;
                                }
                                catch (Throwable var9_11) {
                                    var8_9.addSuppressed(var9_11);
                                }
                            }
                            v2 = var8_9;
                            throw v2;
                        }
                    }
                }
                v3 = var10_12 = var7_6.prepareStatement(MerchItemPackage.ALLATORIxDEMO("}bgifx\u0014ezx{\fG\\QIP^ABG\u0004TXM\\QL\u0018\fT@QMPIFL\u0018\fTX]AQ_@^]BSL\u0018\fTX]AQL\u0018\fTAQAVIF_T\u0005\u0014zu`aig\f\u001c\u0013\u0018\u0013\u0018\u0013\u0018\u0013\u0018\u0013\u001d"));
                v4 = var10_12;
                var10_12.setString(1, a.name());
                v4.setString(2, a);
                v4.setString(3, a);
                v3.setLong(4, a);
                v3.setString(5, (String)var9_10);
                v3.executeUpdate();
                var10_12.close();
                if (SpeedRunner.getInstance().getSpeedRunData(a) != null) break block13;
                SpeedRunner.getInstance().addSpeedRunData(a, SpeedRunner.getInstance().addSpeedRunData(new StringBuilder("#rThese are the speedrun times for " + a + ".#k\r\n\r\n"), new HashMap<Integer, String>(), (String)var9_10, a, 1, a));
                v5 = var7_6;
                ** GOTO lbl50
            }
            SpeedRunner.getInstance().removeSpeedRunData(a);
            SpeedRunner.getInstance().loadSpeedRunData(a);
            v5 = var7_6;
lbl50:
            // 2 sources

            if (v5 == null) return;
            var7_6.close();
            return;
        }
        catch (Exception var7_7) {
            var7_7.printStackTrace();
        }
    }

    public final /* synthetic */ boolean ChairDisabled() {
        MapleMap a2;
        if (GameConstants.SkillDisableMap(a2.getId()) || a2.Z) {
            return true;
        }
        return a2.Z;
    }

    public /* synthetic */ void EndPapfight() {
        a.E = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, byte[] a3, double a4, Point a5, int a6) {
        MapleMap a7;
        a7.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a7.La) {
                if (mapleCharacter == a2 || mapleCharacter.getGMLevel() < a6) continue;
                mapleCharacter.getClient().sendPacket(a3);
            }
            return;
        }
        finally {
            a7.ia.readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void limitReactor(int a22, int a3) {
        MapleMap a4;
        ArrayList<MapleReactor> a22 = new ArrayList<MapleReactor>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a4.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                MapleReactor mapleReactor = (MapleReactor)mapleMapObject;
                if (linkedHashMap.containsKey(mapleReactor.getReactorId())) {
                    if ((Integer)linkedHashMap.get(mapleReactor.getReactorId()) >= a3) {
                        a22.add(mapleReactor);
                        continue;
                    }
                    linkedHashMap.put(mapleReactor.getReactorId(), (Integer)linkedHashMap.get(mapleReactor.getReactorId()) + 1);
                    continue;
                }
                linkedHashMap.put(mapleReactor.getReactorId(), 1);
            }
        }
        finally {
            a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
        Iterator<MapleMapObject> iterator = a22.iterator();
        Iterator<Object> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MapleMapObject mapleMapObject;
            mapleMapObject = (MapleReactor)iterator.next();
            iterator2 = iterator;
            a4.destroyReactor(((AbstractMapleMapObject)mapleMapObject).getObjectId());
        }
    }

    public final /* synthetic */ void addMesoDrop(int a2, int a3, int a4, int a5) {
        MapleMap a6;
        a6.addDrop(a2, 0, a3, a4, a5, (short)0);
    }

    public final /* synthetic */ void toggleEnvironment(String a2) {
        MapleMap a3;
        if (a3.Ca.containsKey(a2)) {
            MapleMap mapleMap = a3;
            mapleMap.moveEnvironment(a2, mapleMap.Ca.get(a2) == 1 ? 2 : 1);
            return;
        }
        a3.moveEnvironment(a2, 1);
    }

    public final /* synthetic */ void setForcedReturnMap(int a2) {
        a.z = a2;
    }

    public /* synthetic */ void spawnDragon(int a2) {
        MapleMap a3;
        MapleMonster mapleMonster = MapleLifeFactory.getMonster(8810026);
        mapleMonster.setspawnRevivesHpRate(a2);
        a3.spawnMonsterOnGroundBelow(mapleMonster, new Point(71, 260));
    }

    public /* synthetic */ void startSpeedRun(String a2) {
        MapleMap a3;
        MapleMap mapleMap = a3;
        mapleMap.i = System.currentTimeMillis();
        mapleMap.D = a2;
    }

    public /* synthetic */ void HandleMonsterPetLevelup(MapleMonster a2, MapleCharacter a3) {
        int n2;
        MapleCharacter mapleCharacter = a3;
        int n3 = mapleCharacter.getMonsterPetLevel(a2.getId());
        int n4 = mapleCharacter.getMonsterPetKill(a2.getId());
        double d2 = 0.0;
        int n5 = n2 = 0;
        while (n5 <= n3) {
            double d3 = n2;
            d2 += Math.pow(1.1, d3);
            n5 = ++n2;
        }
        a3.dropDebugMessage("\u9700\u64ca\u6bba:" + (int)(d2 *= 100.0) + "\u96bb\u602a \u602a\u7269\u5bf5\u7269\u624d\u53ef\u5347\u7d1a,\u76ee\u524d\u5df2\u64ca\u6bba:" + n4 + "\u96bb");
        if ((double)n4 >= d2) {
            MapleCharacter mapleCharacter2 = a3;
            mapleCharacter2.addMonsterPetLevel(a2.getId());
            mapleCharacter2.dropMessage("\u60a8\u7684\u602a\u7269\u5bf5\u7269: " + a2.getStats().getName() + "\u5df2\u5347\u7d1a\u70ba" + ++n3 + "\u7d1a! \u76ee\u524d\u5df2\u64ca\u6bba:" + n4 + "\u96bb" + a2.getStats().getName() + "\u4e0b\u6b21\u8ddd\u96e2\u4e0b\u6b21\u5347\u7d1a\u9700\u64ca\u6bba" + (int)(d2 += Math.pow(1.1, n3 + 1) * 100.0));
        }
    }

    public final /* synthetic */ void addDrops(int a2, int a3, int a4, int a5, int a6) {
        a5 = Randomizer.rand(a5, a6);
        int n2 = a6 = 0;
        while (n2 < a5) {
            MapleMap a7;
            a7.addDrop(a2, a3, a4, 1, 1, (short)0);
            n2 = ++a6;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<MapleMapObject> getMapObjectsInRect(Rectangle a2, List<MapleMapObjectType> a3) {
        ArrayList<MapleMapObject> arrayList = new ArrayList<MapleMapObject>();
        a3 = a3.iterator();
        while (a3.hasNext()) {
            MapleMap a4;
            MapleMapObjectType mapleMapObjectType = (MapleMapObjectType)((Object)a3.next());
            a4.ka.get((Object)mapleMapObjectType).readLock().lock();
            try {
                for (MapleMapObject mapleMapObject : a4.aa.get((Object)mapleMapObjectType).values()) {
                    if (!a2.contains(mapleMapObject.getPosition())) continue;
                    arrayList.add(mapleMapObject);
                }
            }
            finally {
                a4.ka.get((Object)mapleMapObjectType).readLock().unlock();
            }
        }
        return arrayList;
    }

    public /* synthetic */ Collection<MaplePortal> getPortals() {
        MapleMap a2;
        return Collections.unmodifiableCollection(a2.Da.values());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ String ALLATORIxDEMO(MapleMonster a2) {
        MapleMap a3;
        StringBuilder stringBuilder = new StringBuilder(MTSCSPacket.ALLATORIxDEMO("\u64e0\u6572\u6668\u95b6\n\u001f\n"));
        stringBuilder.append(FilePrinter.getLocalDateString());
        stringBuilder.append(MerchItemPackage.ALLATORIxDEMO("\fH\f\u5704\u573a\u4ed7\u7890\u0014\u0016\u0014")).append(a3.Ba);
        stringBuilder.append(MTSCSPacket.ALLATORIxDEMO("\u0005V\u0005\u6000\u724c\n\u001f\n")).append(((AbstractLoadedMapleLife)a2).getId());
        a3.ia.readLock().lock();
        try {
            stringBuilder.append(MerchItemPackage.ALLATORIxDEMO("\u0014\u7385\u5b82\fo")).append(a3.La.size()).append(MTSCSPacket.ALLATORIxDEMO("x\nY\n"));
            a2 = a3.La.iterator();
            while (a2.hasNext()) {
                MapleCharacter mapleCharacter = (MapleCharacter)a2.next();
                stringBuilder.append(MerchItemPackage.ALLATORIxDEMO("\u0014\u5421\u5b63\u0016\u0014"));
                stringBuilder.append(mapleCharacter.getName());
                stringBuilder.append(MTSCSPacket.ALLATORIxDEMO("\n\u7b6c\u7d30\u001f\n"));
                stringBuilder.append(mapleCharacter.getLevel());
                stringBuilder.append(MerchItemPackage.ALLATORIxDEMO("\u0014\u805b\u6959\u0016\u0014"));
                stringBuilder.append(mapleCharacter.getJob()).append(" ");
            }
        }
        finally {
            a3.ia.readLock().unlock();
        }
        return stringBuilder.toString();
    }

    public final /* synthetic */ void setFixedMob(int a2) {
        a.X = a2;
    }

    public /* synthetic */ int getWorld() {
        MapleMap a2;
        return a2.Ja;
    }

    public /* synthetic */ void addMaxMobInMap() {
        MapleMap a2;
        ++a2.q;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ Point getPointOfItem(int a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.ITEM).readLock().lock();
        try {
            for (MapleMapItem object : a3.aa.get((Object)MapleMapObjectType.ITEM).values()) {
                if (object.getItem() == null || object.getItem().getItemId() != a2) continue;
                Point point = object.getPosition();
                return point;
            }
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.ITEM).readLock().unlock();
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<MapleCharacter> getCharactersThreadsafe() {
        MapleMap a2;
        ArrayList<MapleCharacter> arrayList = new ArrayList<MapleCharacter>();
        a2.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a2.La) {
                arrayList.add(mapleCharacter);
            }
            return arrayList;
        }
        finally {
            a2.ia.readLock().unlock();
        }
    }

    public final /* synthetic */ boolean skillDisabled() {
        MapleMap a2;
        if (GameConstants.SkillDisableMap(a2.getId()) || a2.t) {
            return true;
        }
        return a2.o;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleNPC> getAllNPCsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleNPC> arrayList = new ArrayList<MapleNPC>();
        a2.ka.get((Object)MapleMapObjectType.NPC).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.NPC).values()) {
                arrayList.add((MapleNPC)mapleMapObject);
                mapleMapObject = (MapleNPC)mapleMapObject;
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.NPC).readLock().unlock();
        }
    }

    public final /* synthetic */ void addMapDrop(int a2, int a3, int a4, int a5) {
        MapleMap a6;
        a6.addMapDrop(a2, a3, a4, a5, (short)0);
    }

    public /* synthetic */ short getBottom() {
        MapleMap a2;
        return a2.k;
    }

    public final /* synthetic */ void killMonsterDpm(MapleMonster a2) {
        MapleMap a3;
        if (a2 == null) {
            return;
        }
        a2.setHp(0L);
        a3.broadcastMessage(MobPacket.killMonster(a2.getObjectId(), a2.getStats().getSelfD() < 0 ? 1 : (int)a2.getStats().getSelfD()));
        MapleMonster mapleMonster = a2;
        a3.removeMapObject(mapleMonster);
        mapleMonster.killed();
    }

    public final /* synthetic */ void spawnMobDrop(IItem a2, Point a3, MapleMonster a4, MapleCharacter a5, byte a6, int a7) {
        MapleMap a8;
        a8.ALLATORIxDEMO((MapleMapObject)(a2 = new MapleMapItem((IItem)a2, a3, a4, a5, a6, false, a7)), new DelayedPacketCreation(){
            public final /* synthetic */ MapleMap ALLATORIxDEMO;
            public final /* synthetic */ MapleMonster a;
            public final /* synthetic */ Point d;
            public final /* synthetic */ int k;
            public final /* synthetic */ MapleMapItem K;

            @Override
            public /* synthetic */ void sendPackets(MapleClient a2) {
                22 a3;
                if (a3.k <= 0 || a2.getPlayer().getQuestStatus(a3.k) == 1) {
                    22 v0 = a3;
                    a2.sendPacket(MaplePacketCreator.dropItemFromMapObject(v0.K, v0.a.getPosition(), a3.d, (byte)1));
                }
            }
            {
                22 a3;
                22 v0 = a3;
                a3.ALLATORIxDEMO = a2;
                v0.k = n2;
                v0.K = mapleMapItem;
                a3.a = mapleMonster;
                a3.d = point;
            }
        }, null);
        ((MapleMapItem)a2).registerExpire(120000L);
        if (a6 == 0 || a6 == 1) {
            ((MapleMapItem)a2).registerFFA(30000L);
        }
        a8.ALLATORIxDEMO((MapleMapItem)a2, a5.getClient());
    }

    public /* synthetic */ String spawnDebug() {
        MapleMap a2;
        StringBuilder stringBuilder = new StringBuilder(MTSCSPacket.ALLATORIxDEMO("hKUEG@@IQY\u0005CK\nHKU\n\u001f\n"));
        StringBuilder stringBuilder2 = stringBuilder.append(a2.getMapObjectSize());
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder.append(MerchItemPackage.ALLATORIxDEMO("\u0014_DMCBQHyCZ_@IF_{ByMD\u0016\u0014"));
        stringBuilder3.append(a2.Ma);
        stringBuilder.append(MTSCSPacket.ALLATORIxDEMO("\u0005YUKRDUELDQY\u001f\n"));
        stringBuilder.append(a2.ea.size());
        stringBuilder.append(MerchItemPackage.ALLATORIxDEMO("\fYML~QKA@U^g\\U[Z\u0016\u0014"));
        stringBuilder.append(a2.q);
        stringBuilder.append(MTSCSPacket.ALLATORIxDEMO("\u0005KF^PKI\nHEKYQOWY\u001f\n"));
        stringBuilder.append(a2.getNumMonsters());
        return stringBuilder3.toString();
    }

    public final /* synthetic */ MapleReactor getReactorByOid(int a22) {
        MapleMap a3;
        MapleMapObject a22 = a3.getMapObject(a22, MapleMapObjectType.REACTOR);
        if (a22 == null) {
            return null;
        }
        return (MapleReactor)a22;
    }

    public final /* synthetic */ String getUserEnter() {
        MapleMap a2;
        return a2.f;
    }

    public final /* synthetic */ void setEverlast(boolean a2) {
        a.N = a2;
    }

    public final /* synthetic */ void addDrop(int a2, int a3, int a4, int a5, int a6, Short a7) {
        MapleMap mapleMap;
        MapleMap a8;
        if (a8.ba.containsKey(a2)) {
            List<MonsterDropEntry> list = a8.ba.get(a2);
            List<MonsterDropEntry> list2 = a8.ba.remove(a2);
            MapleMap mapleMap2 = a8;
            list.add(new MonsterDropEntry(a3, a4, a5, a6, a7.shortValue()));
            mapleMap = mapleMap2;
            mapleMap2.ba.put(a2, list);
        } else {
            LinkedList<MonsterDropEntry> linkedList = new LinkedList<MonsterDropEntry>();
            MapleMap mapleMap3 = a8;
            linkedList.add(new MonsterDropEntry(a3, a4, a5, a6, a7.shortValue()));
            mapleMap = mapleMap3;
            mapleMap3.ba.put(a2, linkedList);
        }
        mapleMap.c = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean containsNPC(int a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.NPC).readLock().lock();
        try {
            for (MapleNPC mapleNPC : a3.aa.get((Object)MapleMapObjectType.NPC).values()) {
                if (mapleNPC.getId() != a2) continue;
                boolean bl = true;
                return bl;
            }
            boolean bl = false;
            return bl;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.NPC).readLock().unlock();
        }
    }

    public final /* synthetic */ boolean allowPersonalShop() {
        MapleMap a2;
        return a2.R;
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2) {
        MapleMapObject mapleMapObject;
        MapleMap a3;
        if (a2 == null || a2.isClone()) {
            return;
        }
        Iterator<MapleMapObject> iterator = a3.getAllMonstersThreadsafe().iterator();
        Iterator<MapleMapObject> iterator2 = iterator;
        while (iterator2.hasNext()) {
            mapleMapObject = iterator.next();
            a3.updateMonsterController((MapleMonster)mapleMapObject);
            iterator2 = iterator;
        }
        iterator = a3.getMapObjectsInRange(a2.getPosition(), GameConstants.maxViewRangeSq(), GameConstants.rangedMapobjectTypes).iterator();
        Iterator<MapleMapObject> iterator3 = iterator;
        while (iterator3.hasNext()) {
            mapleMapObject = iterator.next();
            if (mapleMapObject.getType() == MapleMapObjectType.REACTOR && !((MapleReactor)mapleMapObject).isAlive()) {
                iterator3 = iterator;
                continue;
            }
            mapleMapObject.sendSpawnData(a2.getClient());
            iterator3 = iterator;
            a2.addVisibleMapObject(mapleMapObject);
        }
    }

    public final /* synthetic */ void changeEnvironment(String a2, int a3) {
        MapleMap a4;
        a4.broadcastMessage(MaplePacketCreator.environmentChange(a2, a3));
    }

    public final /* synthetic */ void spawnMesoDrop(int a22, Point a3, MapleMapObject a4, MapleCharacter a5, boolean a6, byte a7) {
        MapleMap a8;
        MapleMap mapleMap = a8;
        Point point = a3;
        a3 = mapleMap.calcDropPos(point, point);
        MapleMapItem a22 = new MapleMapItem(a22, a3, a4, a5, a7, a6);
        mapleMap.ALLATORIxDEMO(a22, new DelayedPacketCreation(){
            public final /* synthetic */ MapleMap ALLATORIxDEMO;
            public final /* synthetic */ Point d;
            public final /* synthetic */ MapleMapItem K;
            public final /* synthetic */ MapleMapObject a;
            {
                19 a3;
                19 v0 = a3;
                v0.ALLATORIxDEMO = a2;
                v0.K = mapleMapItem;
                a3.a = mapleMapObject;
                a3.d = point;
            }

            @Override
            public /* synthetic */ void sendPackets(MapleClient a2) {
                19 a3;
                19 v0 = a3;
                a2.sendPacket(MaplePacketCreator.dropItemFromMapObject(v0.K, v0.a.getPosition(), a3.d, (byte)1));
            }
        }, null);
        if (!mapleMap.N) {
            a22.registerExpire(120000L);
            if (a7 == 0 || a7 == 1) {
                a22.registerFFA(30000L);
            }
        }
    }

    public final /* synthetic */ float getRecoveryRate() {
        MapleMap a2;
        return a2.Aa;
    }

    public /* synthetic */ int getChannel() {
        MapleMap a2;
        return a2.ma;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void destroyReactors(int a2, int a3) {
        MapleMap a4;
        ArrayList<MapleReactor> arrayList = new ArrayList<MapleReactor>();
        a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a4.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                MapleReactor mapleReactor = (MapleReactor)mapleMapObject;
                if (mapleReactor.getReactorId() < a2 || mapleReactor.getReactorId() > a3) continue;
                arrayList.add(mapleReactor);
            }
        }
        finally {
            a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
        Iterator<MapleMapObject> iterator = arrayList.iterator();
        Iterator<Object> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MapleMapObject mapleMapObject;
            mapleMapObject = (MapleReactor)iterator.next();
            iterator2 = iterator;
            a4.destroyReactor(((AbstractMapleMapObject)mapleMapObject).getObjectId());
        }
    }

    public final /* synthetic */ void ChangeMonsterStat(MapleMonster a2) {
        double d2;
        double d3 = d2 = a2.getStats().isBoss() ? GameSetConstants.BOSS_HPRATE : GameSetConstants.MOB_HPRATE;
        if (a2.getId() >= 8820000 && a2.getId() <= 8830000) {
            d2 = 1.0;
        }
        if (!a2.getChanged()) {
            MapleMap a3;
            if (GameSetConstants.isHell(a3.ma)) {
                a2.changeHellsettings();
                return;
            }
            if (d2 != 1.0) {
                a2.modifyHp(d2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleMapObject a2, DelayedPacketCreation a3, SpawnCondition a4) {
        MapleMap a5;
        MapleMap mapleMap = a5;
        mapleMap.addMapObject(a2);
        mapleMap.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a5.La) {
                if (a4 != null && !a4.canSpawn(mapleCharacter) || mapleCharacter.isClone() || !(mapleCharacter.getPosition().distanceSq(a2.getPosition()) <= (double)GameConstants.maxViewRangeSq())) continue;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                a3.sendPackets(mapleCharacter2.getClient());
                mapleCharacter2.addVisibleMapObject(a2);
            }
            return;
        }
        finally {
            a5.ia.readLock().unlock();
        }
    }

    public /* synthetic */ void addDisconnected(int a2) {
        MapleMap a3;
        a3.Ka.add(a2);
    }

    public final /* synthetic */ int getHPDecInterval() {
        MapleMap a2;
        return a2.V;
    }

    public final /* synthetic */ boolean getPvP() {
        MapleMap a2;
        return a2.g;
    }

    public final /* synthetic */ int getHPDecProtect() {
        MapleMap a2;
        return a2.p;
    }

    public /* synthetic */ int getPermanentWeather() {
        MapleMap a2;
        return a2.s;
    }

    public /* synthetic */ int getConsumeItemCoolTime() {
        MapleMap a2;
        return a2.W;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, byte[] a3) {
        MapleMap a4;
        a4.ia.readLock().lock();
        try {
            if (a2 == null) {
                for (MapleCharacter mapleCharacter : a4.La) {
                    if (mapleCharacter.isStaff()) continue;
                    mapleCharacter.getClient().getSession().writeAndFlush((Object)a3);
                }
            } else {
                for (MapleCharacter mapleCharacter : a4.La) {
                    if (mapleCharacter == a2 || mapleCharacter.getGMLevel() >= 3) continue;
                    mapleCharacter.getClient().getSession().writeAndFlush((Object)a3);
                }
            }
            return;
        }
        finally {
            a4.ia.readLock().unlock();
        }
    }

    public final /* synthetic */ MaplePortal getPortal(int a2) {
        MapleMap a3;
        if (a3.Da.get(a2) == null) {
            return a3.Da.get(1);
        }
        return a3.Da.get(a2);
    }

    public /* synthetic */ void broadcastGMMessage(MapleCharacter a2, byte[] a3, boolean a4) {
        MapleMap a5;
        MapleCharacter mapleCharacter;
        Point point;
        byte[] arrby;
        MapleCharacter mapleCharacter2;
        if (a4) {
            mapleCharacter2 = null;
            arrby = a3;
        } else {
            mapleCharacter2 = a2;
            arrby = a3;
        }
        if (a2 == null) {
            point = new Point(0, 0);
            mapleCharacter = a2;
        } else {
            point = a2.getPosition();
            mapleCharacter = a2;
        }
        a5.ALLATORIxDEMO(mapleCharacter2, arrby, Double.POSITIVE_INFINITY, point, mapleCharacter == null ? 1 : a2.getGMLevel());
    }

    public final /* synthetic */ MapleFootholdTree getFootholds() {
        MapleMap a2;
        return a2.la;
    }

    public /* synthetic */ MapleMonster getForceMob() {
        MapleMap a2;
        return a2.ha;
    }

    public /* synthetic */ String getSnowballPortal() {
        MapleMap a2;
        int[] arrn = new int[2];
        Iterator<MapleCharacter> iterator = a2.getCharactersThreadsafe().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPosition().y > -80) {
                arrn[0] = arrn[0] + 1;
                continue;
            }
            arrn[1] = arrn[1] + 1;
        }
        if (arrn[0] > arrn[1]) {
            return MTSCSPacket.ALLATORIxDEMO("V^\u0015\u001b");
        }
        return MerchItemPackage.ALLATORIxDEMO("_@\u001c\u0004");
    }

    public final /* synthetic */ void setMapName(String a2) {
        a.m = a2;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void spawnMist(MapleMist a, int a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[CASE], 1[SWITCH]], but top level block is 0[TRYBLOCK]
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

    public final /* synthetic */ int spawnMonsterWithEffect(final MapleMonster a22, final int a3, Point a4) {
        try {
            MapleMap a5;
            MapleMonster mapleMonster = a22;
            MapleMonster mapleMonster2 = a22;
            mapleMonster2.setMap(a5);
            mapleMonster2.setPosition(a4);
            MapleMap mapleMap = a5;
            mapleMap.ALLATORIxDEMO(a22, new DelayedPacketCreation(){

                @Override
                public final /* synthetic */ void sendPackets(MapleClient a2) {
                    7 a32;
                    7 v0 = a32;
                    a2.sendPacket(MobPacket.spawnMonster(v0.a22, v0.a3, 0));
                }
                {
                    7 a32;
                }
            }, null);
            mapleMap.updateMonsterController(mapleMonster);
            return mapleMonster.getObjectId();
        }
        catch (Exception a22) {
            return -1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void reloadReactors() {
        MapleMap a2;
        ArrayList<MapleReactor> arrayList = new ArrayList<MapleReactor>();
        a2.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                MapleReactor mapleReactor;
                MapleReactor mapleReactor2 = mapleReactor = (MapleReactor)mapleMapObject;
                MapleReactor mapleReactor3 = mapleReactor;
                a2.broadcastMessage(MaplePacketCreator.destroyReactor(mapleReactor3));
                mapleReactor2.setAlive(false);
                mapleReactor3.setTimerActive(false);
                arrayList.add(mapleReactor2);
            }
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
        Iterator<MapleMapObject> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            MapleMapObject mapleMapObject;
            MapleMapObject mapleMapObject2 = mapleMapObject = (MapleReactor)iterator.next();
            a2.removeMapObject(mapleMapObject2);
            if (((MapleReactor)mapleMapObject2).getReactorId() == 9980000 || ((MapleReactor)mapleMapObject).getReactorId() == 9980001) continue;
            a2.ALLATORIxDEMO((MapleReactor)mapleMapObject);
        }
    }

    public /* synthetic */ long getEndBelong() {
        MapleMap a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void spawnDoor(final MapleDoor a2) {
        MapleMap a3;
        a3.ALLATORIxDEMO(a2, new DelayedPacketCreation(){
            {
                10 a3;
            }

            @Override
            public final /* synthetic */ void sendPackets(MapleClient a22) {
                10 a3;
                10 v0 = a3;
                a22.sendPacket(MaplePacketCreator.spawnDoor(a3.a2.getOwner().getId(), v0.a2.getTargetPosition(), false));
                if (v0.a2.getOwner().getParty() != null && (a3.a2.getOwner() == a22.getPlayer() || a3.a2.getOwner().getParty().containsMembers(new MaplePartyCharacter(a22.getPlayer())))) {
                    a22.sendPacket(MaplePacketCreator.partyPortal(a3.a2.getTown().getId(), a3.a2.getTarget().getId(), a3.a2.getSkill(), a3.a2.getTargetPosition()));
                    return;
                }
                a22.sendPacket(MaplePacketCreator.spawnPortal(a3.a2.getTown().getId(), a3.a2.getTarget().getId(), a3.a2.getSkill(), a3.a2.getTargetPosition()));
            }
        }, new SpawnCondition(){

            @Override
            public final /* synthetic */ boolean canSpawn(MapleCharacter a22) {
                11 a3;
                return a3.a2.getTarget().getId() == a22.getMapId() || a3.a2.getOwnerId() == a22.getId() || a3.a2.getOwner() != null && a3.a2.getOwner().getParty() != null && a3.a2.getOwner().getParty().getMemberById(a22.getId()) != null;
            }
            {
                11 a3;
            }
        });
    }

    public /* synthetic */ List<MapleMapItem> getAllItems() {
        MapleMap a2;
        return a2.getAllItemsThreadsafe();
    }

    public final /* synthetic */ void resetReactors() {
        MapleMap a2;
        a2.setReactorState((byte)0);
    }

    public final /* synthetic */ MapleNPC getNPCByOid(int a22) {
        MapleMap a3;
        MapleMapObject a22 = a3.getMapObject(a22, MapleMapObjectType.NPC);
        if (a22 == null) {
            return null;
        }
        return (MapleNPC)a22;
    }

    public final /* synthetic */ void spawnMonsterOnGroundBelow(MapleMonster a2, Point a3, int a4) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a4) {
            MapleMap a5;
            a5.spawnMonster_sSack(a2, a3, -2);
            n3 = ++n2;
        }
    }

    public final /* synthetic */ void spawnMonsterOnGroundBelow(MapleMonster a2, Point a3) {
        MapleMap a4;
        a4.spawnMonster_sSack(a2, a3, -2);
    }

    public final /* synthetic */ List<Integer> getSkillIds() {
        MapleMap a2;
        return a2.I.getSkillIds();
    }

    public final /* synthetic */ void addAreaMonsterSpawn(MapleMonster a2, Point a3, Point a4, Point a5, int a6, String a7, boolean a8) {
        Pair<Integer, Point> pair;
        Pair<Integer, Point> pair2;
        Pair<Integer, Point> pair3;
        MapleMap a9;
        block11: {
            Pair<Integer, Point> pair4;
            block10: {
                block12: {
                    block9: {
                        MapleMap mapleMap = a9;
                        pair3 = mapleMap.calcFhAndPointBelow(a3);
                        pair2 = mapleMap.calcFhAndPointBelow(a4);
                        pair = mapleMap.calcFhAndPointBelow(a5);
                        a3 = pair3.getRight();
                        a4 = pair2.getRight();
                        a5 = pair.getRight();
                        if (a3 != null) {
                            --a3.y;
                        }
                        if (a4 != null) {
                            --a4.y;
                        }
                        if (a5 != null) {
                            --a5.y;
                        }
                        if (a3 == null && a4 == null && a5 == null) {
                            System.err.println("\u8b66\u544a: \u5730\u5716 " + a9.Ba + ", \u602a\u7269\u4ee3\u78bc " + a2.getId() + " \u53ec\u559a\u5931\u6557. (pos1 == null && pos2 == null && pos3 == null)");
                            return;
                        }
                        if (a3 == null) break block9;
                        if (a4 == null) {
                            a4 = new Point(a3);
                        }
                        if (a5 != null) break block10;
                        a5 = new Point(a3);
                        pair4 = pair3;
                        break block11;
                    }
                    if (a4 == null) break block12;
                    if (a3 == null) {
                        a3 = new Point(a4);
                    }
                    if (a5 != null) break block10;
                    a5 = new Point(a4);
                    pair4 = pair3;
                    break block11;
                }
                if (a5 != null) {
                    if (a3 == null) {
                        a3 = new Point(a5);
                    }
                    if (a4 == null) {
                        a4 = new Point(a5);
                    }
                }
            }
            pair4 = pair3;
        }
        pair4.right = a3;
        pair2.right = a4;
        pair.right = a5;
        a9.ea.add(new SpawnPointAreaBoss(a2, pair3, pair2, pair, a6, a7, a8));
    }

    public final /* synthetic */ void closeDrops() {
        a.S = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ MapleReactor getReactorById(int a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            MapleReactor mapleReactor;
            block5: {
                MapleReactor mapleReactor3 = null;
                for (MapleReactor mapleReactor22 : a3.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                    if (mapleReactor22.getReactorId() != a2) continue;
                    mapleReactor = mapleReactor3 = mapleReactor22;
                    break block5;
                }
                mapleReactor = mapleReactor3;
            }
            MapleReactor mapleReactor2 = mapleReactor;
            return mapleReactor2;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
    }

    public final /* synthetic */ boolean getEverlast() {
        MapleMap a2;
        return a2.N;
    }

    public /* synthetic */ void checkStates(String a2) {
        EventManager eventManager;
        int n2;
        EventManager eventManager2;
        MapleMap a3;
        block21: {
            block19: {
                MapleSquad mapleSquad;
                block24: {
                    int n3;
                    block22: {
                        block23: {
                            int n4;
                            block20: {
                                if (!a3.l) {
                                    return;
                                }
                                MapleMap mapleMap = a3;
                                mapleSquad = mapleMap.getSquadByMap();
                                eventManager2 = mapleMap.getEMByMap();
                                n2 = mapleMap.getCharactersSize();
                                boolean bl = false;
                                if (mapleSquad == null) break block19;
                                if (mapleSquad.getType() == MapleSquad.MapleSquadType.horntail || mapleSquad.getType() == MapleSquad.MapleSquadType.chaosht) {
                                    bl = true;
                                }
                                if (bl) break block20;
                                mapleSquad.removeMember(a2);
                                if (eventManager2 == null) break block19;
                                if (mapleSquad.getLeaderName().equals(a2)) {
                                    eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X"), MerchItemPackage.ALLATORIxDEMO("RMX_Q"));
                                }
                                if (!a2.equals("") && n2 != 0) break block19;
                                mapleSquad.clear();
                                EventManager eventManager3 = eventManager2;
                                eventManager = eventManager3;
                                eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("YQKQO"), MerchItemPackage.ALLATORIxDEMO("\u0004"));
                                eventManager3.setProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X"), MerchItemPackage.ALLATORIxDEMO("XFYQ"));
                                a3.cancelSquadSchedule();
                                break block21;
                            }
                            if (mapleSquad.getType() != MapleSquad.MapleSquadType.horntail) break block22;
                            MapleMap mapleMap = a3;
                            MapleMapFactory mapleMapFactory = ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma).getMapFactory();
                            int[] arrn = new int[3];
                            arrn[0] = 240060000;
                            arrn[1] = 240060100;
                            arrn[2] = 240060200;
                            int[] arrn2 = arrn;
                            int n5 = 0;
                            int n6 = n4 = 0;
                            while (n6 < arrn2.length) {
                                MapleMap mapleMap2 = mapleMapFactory.getMap(arrn2[n4]);
                                n5 += mapleMap2.getCharactersSize();
                                n6 = ++n4;
                            }
                            if (n5 == 0) {
                                mapleSquad.removeallMember();
                            }
                            if (eventManager2 == null) break block19;
                            if (mapleSquad.getLeaderName().equals(a2)) {
                                eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X"), MerchItemPackage.ALLATORIxDEMO("RMX_Q"));
                            }
                            if (a2.equals("")) break block23;
                            MapleMap mapleMap3 = a3;
                            if (!ChannelServer.getInstance(mapleMap3.Ja, mapleMap3.ma).getMapleSquad(mapleSquad.getType()).getMembers().isEmpty()) break block19;
                        }
                        eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("YQKQO"), MerchItemPackage.ALLATORIxDEMO("\u0004"));
                        eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X"), MerchItemPackage.ALLATORIxDEMO("XFYQ"));
                        a3.cancelSquadSchedule();
                        mapleSquad.clear();
                        break block19;
                    }
                    if (mapleSquad.getType() != MapleSquad.MapleSquadType.chaosht) break block19;
                    MapleMap mapleMap = a3;
                    MapleMapFactory mapleMapFactory = ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma).getMapFactory();
                    int[] arrn = new int[3];
                    arrn[0] = 240060001;
                    arrn[1] = 240060101;
                    arrn[2] = 240060201;
                    int[] arrn3 = arrn;
                    int n7 = 0;
                    int n8 = n3 = 0;
                    while (n8 < arrn3.length) {
                        MapleMap mapleMap4 = mapleMapFactory.getMap(arrn3[n3]);
                        n7 += mapleMap4.getCharactersSize();
                        n8 = ++n3;
                    }
                    if (n7 == 0) {
                        mapleSquad.removeallMember();
                    }
                    if (eventManager2 == null) break block19;
                    if (mapleSquad.getLeaderName().equals(a2)) {
                        eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X"), MerchItemPackage.ALLATORIxDEMO("RMX_Q"));
                    }
                    if (a2.equals("")) break block24;
                    MapleMap mapleMap5 = a3;
                    if (!ChannelServer.getInstance(mapleMap5.Ja, mapleMap5.ma).getMapleSquad(mapleSquad.getType()).getMembers().isEmpty()) break block19;
                }
                eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("YQKQO"), MerchItemPackage.ALLATORIxDEMO("\u0004"));
                eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X"), MerchItemPackage.ALLATORIxDEMO("XFYQ"));
                a3.cancelSquadSchedule();
                mapleSquad.clear();
            }
            eventManager = eventManager2;
        }
        if (eventManager != null && eventManager2.getProperty(MTSCSPacket.ALLATORIxDEMO("YQKQO")) != null && n2 == 0) {
            EventManager eventManager4 = eventManager2;
            eventManager4.setProperty(MerchItemPackage.ALLATORIxDEMO("GXUXQ"), MTSCSPacket.ALLATORIxDEMO("\u001a"));
            if (eventManager4.getProperty(MerchItemPackage.ALLATORIxDEMO("@QMPIF")) != null) {
                eventManager2.setProperty(MTSCSPacket.ALLATORIxDEMO("IODN@X"), MerchItemPackage.ALLATORIxDEMO("XFYQ"));
            }
        }
        if (a3.i > 0L && a3.D.equalsIgnoreCase(a2)) {
            if (n2 > 0) {
                a3.broadcastMessage(MaplePacketCreator.getErrorNotice(MTSCSPacket.ALLATORIxDEMO("\u751b\u6599\u904a\u5fa4\u96a0\u96af\u955d\u96c7\u95a1\u4ea3\uff26\u6265\u4ecf\u9045\u5fab\u96af\u4ed1\u52fc\u591b\u6572\u3028")));
            }
            a3.endSpeedRun();
        }
    }

    public final /* synthetic */ void addMapMesoDrop(int a2, int a3, int a4) {
        MapleMap a5;
        a5.addMapDrop(0, a2, a3, a4, (short)0);
    }

    public final /* synthetic */ void setHPDecProtect(int a2) {
        a.p = a2;
    }

    public /* synthetic */ List<MapleMapObject> getAllDoor() {
        MapleMap a2;
        return a2.getAllDoorsThreadsafe();
    }

    public final /* synthetic */ void spawnRevives(final MapleMonster a2, final int a3) {
        MapleMap a4;
        double d2 = a2.getStats().isBoss() ? GameSetConstants.BOSS_HPRATE : GameSetConstants.MOB_HPRATE;
        MapleMonster mapleMonster = a2;
        a2.setMap(a4);
        a4.ALLATORIxDEMO(a2);
        a4.ChangeMonsterStat(mapleMonster);
        mapleMonster.setLinkOid(a3);
        MapleMap mapleMap = a4;
        mapleMap.ALLATORIxDEMO(a2, new DelayedPacketCreation(){

            @Override
            public final /* synthetic */ void sendPackets(MapleClient a22) {
                4 v2;
                int n2;
                4 a32;
                4 v0 = a32;
                if (v0.a2.getStats().getSummonType() <= 1) {
                    n2 = -3;
                    v2 = a32;
                } else {
                    n2 = a32.a2.getStats().getSummonType();
                    v2 = a32;
                }
                a22.sendPacket(MobPacket.spawnMonster(v0.a2, n2, v2.a3));
            }
            {
                4 a32;
            }
        }, null);
        mapleMap.updateMonsterController(mapleMonster);
    }

    public final /* synthetic */ void startMapEffect(String a2, int a3) {
        MapleMap a4;
        a4.startMapEffect(a2, a3, false);
    }

    public /* synthetic */ List<MapleNPC> getAllNPCs() {
        MapleMap a2;
        return a2.getAllNPCsThreadsafe();
    }

    private /* synthetic */ void ALLATORIxDEMO(final MapleMonster a2) {
        int n2 = a2.getStats().getRemoveAfter();
        if (n2 > 0 && a2.getLinkCID() <= 0) {
            MapleMap a3;
            Timer.MapTimer.getInstance().schedule(new Runnable(){

                @Override
                public final /* synthetic */ void run() {
                    3 a22;
                    if (a22.a2 != null) {
                        3 v0 = a22;
                        if (v0.a2 == v0.MapleMap.this.getMapObject(a22.a2.getObjectId(), a22.a2.getType())) {
                            3 v1 = a22;
                            v1.MapleMap.this.H(v1.a2);
                        }
                    }
                }
                {
                    3 a3;
                }
            }, n2 * 1000);
        }
    }

    public final /* synthetic */ void spawnZakum(int a22, int a32) {
        int n2;
        MapleMap a4;
        Point a22 = new Point(a22, a32);
        Object a32 = MapleLifeFactory.getMonster(8800000);
        MapleMap mapleMap = a4;
        Point point = a22;
        a22 = mapleMap.calcPointBelow(new Point(point.x, point.y - 1));
        MapleMonster mapleMonster = a32;
        mapleMonster.setPosition(a22);
        mapleMonster.setFake(true);
        mapleMap.spawnFakeMonster(mapleMonster);
        int[] arrn = new int[8];
        arrn[0] = 8800003;
        arrn[1] = 8800004;
        arrn[2] = 8800005;
        arrn[3] = 8800006;
        arrn[4] = 8800007;
        arrn[5] = 8800008;
        arrn[6] = 8800009;
        arrn[7] = 8800010;
        a32 = arrn;
        if (GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u6700\u77c0\u8c1d")) || GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u6be0\u596b\u8c03"))) {
            int[] arrn2 = new int[7];
            arrn2[0] = 8800004;
            arrn2[1] = 8800005;
            arrn2[2] = 8800006;
            arrn2[3] = 8800007;
            arrn2[4] = 8800008;
            arrn2[5] = 8800009;
            arrn2[6] = 8800010;
            a32 = arrn2;
        }
        int n3 = ((Object)a32).length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleMonster mapleMonster2;
            MapleMonster mapleMonster3 = mapleMonster2 = MapleLifeFactory.getMonster((int)a32[n2]);
            mapleMonster3.setPosition(a22);
            a4.spawnMonster(mapleMonster3, -2);
            n4 = ++n2;
        }
        if (a4.L != null) {
            MapleMap mapleMap2 = a4;
            mapleMap2.cancelSquadSchedule();
            mapleMap2.broadcastMessage(MaplePacketCreator.stopClock());
            mapleMap2.broadcastMessage(MaplePacketCreator.getClock(28800));
        }
    }

    public final /* synthetic */ boolean canSpawn() {
        MapleMap mapleMap;
        MapleMap a2;
        if (MobConstants.isSpawnSpeed(a2)) {
            mapleMap = a2;
            a2.y = 0;
        } else if (GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u6c00\u6ed8\u8c03"))) {
            mapleMap = a2;
            a2.y = (short)6000;
        } else {
            MapleMap mapleMap2 = a2;
            if (GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u9718\u9717\u8c1d"))) {
                mapleMap2.y = (short)3000;
                mapleMap = a2;
            } else {
                mapleMap2.y = (short)9000;
                mapleMap = a2;
            }
        }
        return mapleMap.J > 0L && a2.b && a2.J + (long)a2.y < System.currentTimeMillis();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleMapObject> getAllHiredMerchantsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleMapObject> arrayList = new ArrayList<MapleMapObject>();
        a2.ka.get((Object)MapleMapObjectType.HIRED_MERCHANT).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.HIRED_MERCHANT).values()) {
                arrayList.add(mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.HIRED_MERCHANT).readLock().unlock();
        }
    }

    public final /* synthetic */ void startMapEffect(String a2, int a3, boolean a4) {
        MapleMap a5;
        a5.startMapEffect(a2, a3, false, 10000);
    }

    public /* synthetic */ void broadcastNONGMMessage(MapleCharacter a2, byte[] a3, boolean a4) {
        MapleMap a5;
        byte[] arrby;
        MapleCharacter mapleCharacter;
        if (a4) {
            mapleCharacter = null;
            arrby = a3;
        } else {
            mapleCharacter = a2;
            arrby = a3;
        }
        a5.ALLATORIxDEMO(mapleCharacter, arrby);
    }

    public final /* synthetic */ void startExtendedMapEffect(final String a2, final int a3) {
        MapleMap a4;
        a4.broadcastMessage(MaplePacketCreator.startMapEffect(a2, a3, true));
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            {
                27 a32;
            }

            @Override
            public /* synthetic */ void run() {
                27 a22;
                27 v0 = a22;
                v0.MapleMap.this.broadcastMessage(MaplePacketCreator.removeMapEffect());
                27 v1 = a22;
                v0.MapleMap.this.broadcastMessage(MaplePacketCreator.startMapEffect(v1.a2, v1.a3, false));
            }
        }, 60000L);
    }

    public /* synthetic */ List<MapleMonster> getAllMonster() {
        MapleMap a2;
        return a2.getAllMonstersThreadsafe();
    }

    public /* synthetic */ boolean getCanBelong() {
        MapleMap a2;
        return a2.d == -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleMist> getAllMistsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleMist> arrayList = new ArrayList<MapleMist>();
        a2.ka.get((Object)MapleMapObjectType.MIST).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.MIST).values()) {
                arrayList.add((MapleMist)mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.MIST).readLock().unlock();
        }
    }

    public final /* synthetic */ void toggleSkill() {
        MapleMap a2;
        a2.o = !a2.o;
    }

    public final /* synthetic */ SpawnPoint addMonsterSpawn(MapleMonster a2, int a3, byte a4, String a5) {
        MapleMap a6;
        return a6.addMonsterSpawn(a2, a3, a4, a5, false);
    }

    public final /* synthetic */ String getFirstUserEnter() {
        MapleMap a2;
        return a2.h;
    }

    private /* synthetic */ int ALLATORIxDEMO() {
        MapleMap a2;
        if (a2.e) {
            return 2;
        }
        if (a2.H) {
            return 1;
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleMapItem> getAllItemsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleMapItem> arrayList = new ArrayList<MapleMapItem>();
        a2.ka.get((Object)MapleMapObjectType.ITEM).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.ITEM).values()) {
                arrayList.add((MapleMapItem)mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.ITEM).readLock().unlock();
        }
    }

    public final /* synthetic */ MapleMonster getMonsterByOid(int a22) {
        MapleMap a3;
        MapleMapObject a22 = a3.getMapObject(a22, MapleMapObjectType.MONSTER);
        if (a22 == null) {
            return null;
        }
        return (MapleMonster)a22;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void respawn(boolean a222) {
        void v3;
        Object object;
        int n2;
        int n3;
        int n4;
        ArrayList<Spawns> a222;
        MapleMap a3;
        a3.J = System.currentTimeMillis();
        if (a222 != 0) {
            a222 = (int)((double)(a3.ea.size() * MobConstants.isMonsterSpawn(a3)) * a3.getMobSpawnRate() * GameSetConstants.getMapExtraSpawn(a3.Ba)) - a3.getNumMonsters() + MobConstants.addSpawnMobCount(a3.Ba);
            if (a222 <= 0) return;
            int n5 = 0;
            Iterator<Spawns> iterator = a3.ea.iterator();
            do {
                if (!iterator.hasNext()) return;
                Spawns spawns = iterator.next();
                spawns.spawnMonster(a3);
            } while (++n5 < a222);
            return;
        }
        if (GameConstants.isCarnivalMaps(a3.Ba)) {
            a222 = new ArrayList<Spawns>(a3.ea);
            n4 = 0;
            n3 = 0;
            n2 = 0;
            object = a222.iterator();
        } else {
            int a222 = (int)((double)(a3.ea.size() * MobConstants.isMonsterSpawn(a3)) * a3.getMobSpawnRate() * GameSetConstants.getMapExtraSpawn(a3.Ba)) - a3.getNumMonsters() + MobConstants.addSpawnMobCount(a3.Ba);
            if (a222 <= 0) {
                if (!MobConstants.isForceRespawn(a3.Ba)) return;
            }
            int n6 = 0;
            ArrayList<Spawns> arrayList = new ArrayList<Spawns>(a3.ea);
            Collections.shuffle(arrayList);
            Iterator iterator = arrayList.iterator();
            do {
                if (!iterator.hasNext()) return;
                Spawns spawns = (Spawns)iterator.next();
                if (!spawns.shouldSpawn(a3) && !MobConstants.isForceRespawn(a3.Ba)) continue;
                ++n6;
                spawns.spawnMonster(a3);
            } while (n6 < a222);
            return;
        }
        block11: while (object.hasNext()) {
            Spawns spawns = (Spawns)object.next();
            switch (spawns.getCarnivalTeam()) {
                case 0: {
                    ++n4;
                    continue block11;
                }
                case 1: {
                    ++n3;
                    continue block11;
                }
                case -1: {
                    ++n2;
                    continue block11;
                }
            }
        }
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        object = a3.getMapObjects(Arrays.asList(arrmapleMapObjectType));
        Iterator<MapleMapObject> iterator = object.iterator();
        block12: while (true) {
            Iterator<MapleMapObject> iterator2 = iterator;
            while (iterator2.hasNext()) {
                MapleMapObject mapleMapObject = iterator.next();
                if (!(mapleMapObject instanceof MapleMonster)) {
                    iterator2 = iterator;
                    continue;
                }
                MapleMonster mapleMonster = (MapleMonster)mapleMapObject;
                switch (mapleMonster.getCarnivalTeam()) {
                    case 0: {
                        --n4;
                        continue block12;
                    }
                    case 1: {
                        --n3;
                        continue block12;
                    }
                }
                --n2;
                continue block12;
            }
            break;
        }
        if (n2 <= 0 && n4 <= 0 && n3 <= 0) {
            if (!MobConstants.isForceRespawn(a3.Ba)) return;
        }
        boolean bl = false;
        int n7 = 0;
        int n8 = 0;
        ArrayList<Spawns> arrayList = a222;
        Collections.shuffle(arrayList);
        Iterator iterator3 = arrayList.iterator();
        do {
            void var6_17;
            if (!iterator3.hasNext()) return;
            Spawns spawns = (Spawns)iterator3.next();
            if (spawns.shouldSpawn(a3) || MobConstants.isForceRespawn(a3.Ba)) {
                if (spawns.getCarnivalTeam() == 0 && n4 > 0) {
                    spawns.spawnMonster(a3);
                    v3 = ++var6_17;
                    continue;
                }
                if (spawns.getCarnivalTeam() == 1 && n3 > 0) {
                    ++n7;
                    spawns.spawnMonster(a3);
                    v3 = var6_17;
                    continue;
                }
                if (spawns.getCarnivalTeam() == -1 && n2 > 0) {
                    ++n8;
                    spawns.spawnMonster(a3);
                }
            }
            v3 = var6_17;
        } while (v3 < n4 || n7 < n3 || n8 < n2);
    }

    public final /* synthetic */ void resetPortals() {
        MapleMap a2;
        Iterator<MaplePortal> iterator;
        Iterator<MaplePortal> iterator2 = iterator = a2.Da.values().iterator();
        while (iterator2.hasNext()) {
            iterator.next().setPortalState(true);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void returnEverLastItem(MapleCharacter a2) {
        MapleMap a3;
        Iterator<MapleMapItem> iterator = a3.getAllItemsThreadsafe().iterator();
        while (iterator.hasNext()) {
            MapleMap mapleMap;
            MapleMapItem mapleMapItem = (MapleMapItem)((MapleMapObject)iterator.next());
            if (mapleMapItem.getOwner() != a2.getId()) continue;
            MapleMapItem mapleMapItem2 = mapleMapItem;
            mapleMapItem2.setPickedUp(true);
            a3.broadcastMessage(MaplePacketCreator.removeItemFromMap(mapleMapItem2.getObjectId(), 2, a2.getId()), mapleMapItem.getPosition());
            if (mapleMapItem2.getMeso() > 0) {
                mapleMap = a3;
                a2.gainMeso(mapleMapItem.getMeso(), false);
            } else {
                MapleInventoryManipulator.addFromDrop(a2.getClient(), mapleMapItem.getItem(), false);
                mapleMap = a3;
            }
            mapleMap.removeMapObject(mapleMapItem);
        }
        a3.spawnRandDrop();
    }

    public final /* synthetic */ void disconnectAll() {
        MapleMap a2;
        for (MapleCharacter mapleCharacter : a2.getCharactersThreadsafe()) {
            if (mapleCharacter.isGM()) continue;
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.getClient().disconnect();
            mapleCharacter2.getClient().getSession().close();
        }
    }

    public final /* synthetic */ void moveEnvironment(String a2, int a3) {
        MapleMap a4;
        MapleMap mapleMap = a4;
        mapleMap.broadcastMessage(MaplePacketCreator.environmentMove(a2, a3));
        mapleMap.Ca.put(a2, a3);
    }

    public final /* synthetic */ int playerCount() {
        MapleMap a2;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.PLAYER;
        return a2.getMapObjectsInRange(new Point(0, 0), Double.POSITIVE_INFINITY, Arrays.asList(arrmapleMapObjectType)).size();
    }

    public /* synthetic */ List<MapleMapObject> getAllMerchant() {
        MapleMap a2;
        return a2.getAllHiredMerchantsThreadsafe();
    }

    public final /* synthetic */ boolean canChair() {
        MapleMap a2;
        return !a2.Z;
    }

    public final /* synthetic */ void closeGDrops() {
        a.r = true;
    }

    public /* synthetic */ short getTop() {
        MapleMap a2;
        return a2.B;
    }

    public final /* synthetic */ boolean makeCarnivalSpawn(int a2, MapleMonster a3, int a4) {
        MapleNodes.MonsterPoint monsterPoint;
        MapleMap a5;
        MapleNodes.MonsterPoint monsterPoint2;
        block4: {
            monsterPoint2 = null;
            for (MapleNodes.MonsterPoint monsterPoint3 : a5.I.getMonsterPoints()) {
                boolean bl;
                block3: {
                    if (monsterPoint3.team != a2 && monsterPoint3.team != -1) continue;
                    MapleMap mapleMap = a5;
                    MapleNodes.MonsterPoint monsterPoint4 = monsterPoint3;
                    Point point = mapleMap.calcPointBelow(new Point(monsterPoint4.x, monsterPoint4.y));
                    --point.y;
                    boolean bl2 = false;
                    for (Spawns spawns : mapleMap.ea) {
                        if (spawns.getCarnivalId() <= -1 || monsterPoint3.team != -1 && spawns.getCarnivalTeam() != monsterPoint3.team || spawns.getPosition().x != point.x || spawns.getPosition().y != point.y) continue;
                        bl = bl2 = true;
                        break block3;
                    }
                    bl = bl2;
                }
                if (bl) continue;
                monsterPoint = monsterPoint2 = monsterPoint3;
                break block4;
            }
            monsterPoint = monsterPoint2;
        }
        if (monsterPoint != null) {
            MapleMonster mapleMonster = a3;
            MapleMonster mapleMonster2 = a3;
            MapleNodes.MonsterPoint monsterPoint5 = monsterPoint2;
            MapleMonster mapleMonster3 = a3;
            mapleMonster3.setCy(monsterPoint2.cy);
            mapleMonster3.setF(0);
            a3.setFh(monsterPoint5.fh);
            mapleMonster2.setRx0(monsterPoint5.x + 50);
            mapleMonster2.setRx1(monsterPoint2.x - 50);
            MapleMonster mapleMonster4 = a3;
            MapleNodes.MonsterPoint monsterPoint6 = monsterPoint2;
            mapleMonster.setPosition(new Point(monsterPoint6.x, monsterPoint6.y));
            mapleMonster.setHide(false);
            SpawnPoint spawnPoint = a5.addMonsterSpawn(mapleMonster, 1, (byte)a2, null);
            spawnPoint.setCarnival(a4);
        }
        return monsterPoint2 != null;
    }

    public final /* synthetic */ MapleCharacter getRandChr() {
        MapleMap a2;
        Iterator<MapleCharacter> iterator = a2.getCharactersThreadsafe().iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ int countMonsterById(int a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.MONSTER).readLock().lock();
        try {
            int n2 = 0;
            for (MapleMonster mapleMonster : a3.aa.get((Object)MapleMapObjectType.MONSTER).values()) {
                if (mapleMonster.getId() != a2) continue;
                ++n2;
            }
            int n3 = n2;
            return n3;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.MONSTER).readLock().unlock();
        }
    }

    public final /* synthetic */ void resetAllSpawnPoint(int a2, int a3) {
        Iterator iterator;
        MapleMap a4;
        LinkedList<Spawns> linkedList = new LinkedList<Spawns>(a4.ea);
        MapleMap mapleMap = a4;
        mapleMap.resetFully();
        mapleMap.ea.clear();
        Iterator iterator2 = iterator = linkedList.iterator();
        while (iterator2.hasNext()) {
            Object object = (Spawns)iterator.next();
            MapleMonster mapleMonster = MapleLifeFactory.getMonster(a2);
            object = ((Spawns)object).getMonster();
            iterator2 = iterator;
            MapleMonster mapleMonster2 = mapleMonster;
            MapleMonster mapleMonster3 = mapleMonster;
            Object object2 = object;
            MapleMonster mapleMonster4 = mapleMonster;
            mapleMonster4.setCy(((AbstractLoadedMapleLife)object).getCy());
            mapleMonster4.setF(((AbstractLoadedMapleLife)object).getF());
            mapleMonster.setFh(((AbstractAnimatedMapleMapObject)object2).getFh());
            mapleMonster3.setRx0(((AbstractLoadedMapleLife)object2).getRx0());
            mapleMonster3.setRx1(((AbstractLoadedMapleLife)object).getRx1());
            MapleMonster mapleMonster5 = mapleMonster;
            mapleMonster2.setPosition(new Point(((AbstractMapleMapObject)object).getPosition()));
            mapleMonster2.setHide(((AbstractLoadedMapleLife)object).isHidden());
            a4.addMonsterSpawn(mapleMonster2, a3, (byte)-1, null);
        }
        a4.loadMonsterRate(true);
    }

    public final /* synthetic */ int incApplyedStatusMonsterCount() {
        MapleMap a2;
        return a2.fa++;
    }

    public /* synthetic */ void Killdpm(boolean a2) {
        MapleMap a3;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        for (MapleMonster mapleMonster : a3.getMapObjectsInRange(new Point(0, 0), Double.POSITIVE_INFINITY, Arrays.asList(arrmapleMapObjectType))) {
            if (mapleMonster.getId() != 9001007) continue;
            MapleMonster mapleMonster2 = mapleMonster;
            mapleMonster2.setHp(0L);
            a3.broadcastMessage(MobPacket.killMonster(mapleMonster2.getObjectId(), a2 ? 1 : 0));
            MapleMonster mapleMonster3 = mapleMonster;
            a3.removeMapObject(mapleMonster3);
            mapleMonster3.killed();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<Integer> getAllUniqueMonsters() {
        MapleMap a2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().lock();
        try {
            Iterator<MapleMapObject> iterator = a2.aa.get((Object)MapleMapObjectType.MONSTER).values().iterator();
            while (iterator.hasNext()) {
                int n2 = ((MapleMonster)iterator.next()).getId();
                StringBuilder stringBuilder = new StringBuilder();
                if (arrayList.contains(n2)) continue;
                arrayList.add(n2);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleCharacter> getAllPlayersThreadsafe() {
        MapleMap a2;
        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
        a2.ka.get((Object)MapleMapObjectType.PLAYER).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.PLAYER).values()) {
                linkedList.add((MapleCharacter)mapleMapObject);
            }
            return linkedList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.PLAYER).readLock().unlock();
        }
    }

    public /* synthetic */ void AddMonsterPetKill(MapleMonster a2, MapleCharacter a3) {
        if (GameSetConstants.MONSTERPET && a3.hasMonsterPet(a2.getId())) {
            MapleMap a4;
            a3.addMonsterPetKill(a2.getId());
            a4.HandleMonsterPetLevelup(a2, a3);
        }
    }

    public /* synthetic */ void setPermanentWeather(int a2) {
        a.s = a2;
    }

    public final /* synthetic */ int getFieldLimit() {
        MapleMap a2;
        return a2.x;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleMapObject> getAllMechDoorsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleMapObject> arrayList = new ArrayList<MapleMapObject>();
        a2.ka.get((Object)MapleMapObjectType.DOOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.DOOR).values()) {
                if (!(mapleMapObject instanceof MechDoor)) continue;
                arrayList.add(mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.DOOR).readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, byte[] a3, double a4, Point a5) {
        MapleMap a6;
        a6.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a6.La) {
                if (mapleCharacter == a2) continue;
                if (a4 < Double.POSITIVE_INFINITY) {
                    if (!(a5.distanceSq(mapleCharacter.getPosition()) <= a4)) continue;
                    mapleCharacter.getClient().sendPacket(a3);
                    continue;
                }
                mapleCharacter.getClient().sendPacket(a3);
            }
            return;
        }
        finally {
            a6.ia.readLock().unlock();
        }
    }

    public /* synthetic */ MaplePortal findClosestPortal(Point a2) {
        MapleMap a3;
        MapleMap mapleMap = a3;
        MaplePortal maplePortal = mapleMap.getPortal(0);
        double d2 = Double.POSITIVE_INFINITY;
        for (MaplePortal maplePortal2 : mapleMap.Da.values()) {
            double d3;
            double d4 = maplePortal2.getPosition().distanceSq(a2);
            if (!(d3 < d2)) continue;
            maplePortal = maplePortal2;
            d2 = d4;
        }
        return maplePortal;
    }

    public /* synthetic */ void setBelongsTo(MapleCharacter a2) {
        MapleMap a3;
        if (a2 == null) {
            a3.d = -1;
            return;
        }
        if (a3.getBelongsTo() != -1) {
            return;
        }
        MapleMap mapleMap = a3;
        mapleMap.d = a2.getId();
        mapleMap.ALLATORIxDEMO = System.currentTimeMillis() + 180000L;
    }

    public final /* synthetic */ List<MonsterDropEntry> retrieveDrop(int a2) {
        MapleMap a3;
        return a3.ba.get(a2);
    }

    public final /* synthetic */ void broadcastMessage(MapleCharacter a2, byte[] a3, Point a4) {
        MapleMap a5;
        a5.ALLATORIxDEMO(a2, a3, GameConstants.maxViewRangeSq(), a4);
    }

    public /* synthetic */ List<MapleReactor> getAllReactor() {
        MapleMap a2;
        return a2.getAllReactorsThreadsafe();
    }

    public final /* synthetic */ MapleSquad getSquadBegin() {
        MapleMap a2;
        if (a2.F != null) {
            MapleMap mapleMap = a2;
            return ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma).getMapleSquad(a2.F);
        }
        return null;
    }

    public final /* synthetic */ void spawnMonster(final MapleMonster a2, final int a3, boolean a4) {
        MapleMap a5;
        MapleMonster mapleMonster = a2;
        mapleMonster.setMap(a5);
        a5.ALLATORIxDEMO(a2);
        a5.ChangeMonsterStat(mapleMonster);
        if (mapleMonster.getId() == 9300166) {
            Timer.MapTimer.getInstance().schedule(new Runnable(){

                @Override
                public /* synthetic */ void run() {
                    5 a22;
                    5 v0 = a22;
                    v0.MapleMap.this.broadcastMessage(MobPacket.killMonster(v0.a2.getObjectId(), 2));
                }
                {
                    5 a3;
                }
            }, new Random().nextInt(5000));
        }
        MapleMap mapleMap = a5;
        MapleMonster mapleMonster2 = a2;
        MapleMonster mapleMonster3 = a2;
        mapleMap.ALLATORIxDEMO(mapleMonster2, new DelayedPacketCreation(){
            {
                6 a32;
            }

            @Override
            public final /* synthetic */ void sendPackets(MapleClient a22) {
                6 a32;
                6 v0 = a32;
                a22.sendPacket(MobPacket.spawnMonster(v0.a2, v0.a3, 0));
            }
        }, null);
        mapleMap.updateMonsterController(mapleMonster2);
    }

    public final /* synthetic */ String getMapName() {
        MapleMap a2;
        return a2.m;
    }

    public /* synthetic */ void setDocked(boolean a2) {
        a.e = a2;
    }

    public final /* synthetic */ boolean makeCarnivalReactor(int a2, int a3) {
        Object object;
        Object object2;
        MapleMap a4;
        block7: {
            object2 = a4.getReactorByName("" + a2 + a3);
            if (object2 != null && ((MapleReactor)object2).getState() < 5) {
                return false;
            }
            object2 = null;
            MapleMap mapleMap = a4;
            List<MapleReactor> list = mapleMap.getAllReactorsThreadsafe();
            for (Pair<Point, Integer> object3 : mapleMap.I.getGuardians()) {
                boolean bl;
                block6: {
                    if ((Integer)object3.right != a2 && (Integer)object3.right != -1) continue;
                    boolean mCSkill = false;
                    for (MapleReactor mapleReactor : list) {
                        if (mapleReactor.getPosition().x != ((Point)object3.left).x || mapleReactor.getPosition().y != ((Point)object3.left).y || mapleReactor.getState() >= 5) continue;
                        bl = mCSkill = true;
                        break block6;
                    }
                    bl = mCSkill;
                }
                if (bl) continue;
                object = object2 = (Point)object3.left;
                break block7;
            }
            object = object2;
        }
        if (object != null) {
            MapleReactorStats mapleReactorStats = MapleReactorFactory.getReactor(9980000 + a2);
            MapleReactor mapleReactor = new MapleReactor(mapleReactorStats, 9980000 + a2, a4.getWorld());
            mapleReactorStats.setFacingDirection((byte)0);
            MapleReactor mapleReactor2 = mapleReactor;
            mapleReactor.setPosition((Point)object2);
            mapleReactor2.setState((byte)1);
            mapleReactor2.setDelay(0);
            mapleReactor2.setName("" + a2 + a3);
            a4.spawnReactor(mapleReactor);
            MapleCarnivalFactory.MCSkill mCSkill = MapleCarnivalFactory.getInstance().getGuardian(a3);
            if (mCSkill != null && mCSkill.getMobSkill() != null) {
                for (MapleMonster mapleMonster : a4.getAllMonstersThreadsafe()) {
                    if (mapleMonster.getCarnivalTeam() != a2) continue;
                    mCSkill.getMobSkill().applyEffect(null, mapleMonster, false);
                }
            }
        }
        return object2 != null;
    }

    public final /* synthetic */ Map<String, Integer> getEnvironment() {
        MapleMap a2;
        return a2.Ca;
    }

    public final /* synthetic */ void spawnChaosZakum(int a22, int a32) {
        int n2;
        MapleMap a4;
        Point a22 = new Point(a22, a32);
        Object a32 = MapleLifeFactory.getMonster(8800100);
        MapleMap mapleMap = a4;
        Point point = a22;
        a22 = mapleMap.calcPointBelow(new Point(point.x, point.y - 1));
        MapleMonster mapleMonster = a32;
        mapleMonster.setPosition(a22);
        mapleMonster.setFake(true);
        mapleMap.spawnFakeMonster(mapleMonster);
        int[] arrn = new int[8];
        arrn[0] = 8800103;
        arrn[1] = 8800104;
        arrn[2] = 8800105;
        arrn[3] = 8800106;
        arrn[4] = 8800107;
        arrn[5] = 8800108;
        arrn[6] = 8800109;
        arrn[7] = 8800110;
        a32 = arrn;
        int n3 = arrn.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleMonster mapleMonster2;
            MapleMonster mapleMonster3 = mapleMonster2 = MapleLifeFactory.getMonster((int)a32[n2]);
            mapleMonster3.setPosition(a22);
            a4.spawnMonster(mapleMonster3, -2);
            n4 = ++n2;
        }
        if (a4.L != null) {
            MapleMap mapleMap2 = a4;
            mapleMap2.cancelSquadSchedule();
            mapleMap2.broadcastMessage(MaplePacketCreator.stopClock());
            mapleMap2.broadcastMessage(MaplePacketCreator.getClock(28800));
        }
    }

    public final /* synthetic */ void toggleChair() {
        MapleMap a2;
        a2.Z = !a2.Z;
    }

    public final /* synthetic */ boolean isTown() {
        MapleMap a2;
        return a2.T;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int getCurrentPartyId() {
        MapleMap a2;
        a2.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a2.La) {
                if (mapleCharacter.getPartyId() == -1) continue;
                int n2 = mapleCharacter.getPartyId();
                return n2;
            }
        }
        finally {
            a2.ia.readLock().unlock();
        }
        return -1;
    }

    public final /* synthetic */ List<MapleCharacter> getCharacters() {
        MapleMap a2;
        return a2.getCharactersThreadsafe();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ MapleMonster getMonsterById(int a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.MONSTER).readLock().lock();
        try {
            MapleMonster mapleMonster;
            block5: {
                MapleMonster mapleMonster3 = null;
                for (MapleMonster mapleMonster22 : a3.aa.get((Object)MapleMapObjectType.MONSTER).values()) {
                    if (mapleMonster22.getId() != a2) continue;
                    mapleMonster = mapleMonster3 = mapleMonster22;
                    break block5;
                }
                mapleMonster = mapleMonster3;
            }
            MapleMonster mapleMonster2 = mapleMonster;
            return mapleMonster2;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.MONSTER).readLock().unlock();
        }
    }

    public final /* synthetic */ boolean hasClock() {
        MapleMap a2;
        return a2.C;
    }

    public /* synthetic */ void setPartyBonusRate(int a2) {
        a.n = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void removeNpc_(int a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.NPC).writeLock().lock();
        try {
            Iterator<MapleMapObject> iterator = a3.aa.get((Object)MapleMapObjectType.NPC).values().iterator();
            while (iterator.hasNext()) {
                MapleNPC mapleNPC = (MapleNPC)iterator.next();
                if (a2 != -1 && mapleNPC.getId() != a2) continue;
                MapleMap mapleMap = a3;
                MapleNPC mapleNPC2 = mapleNPC;
                mapleMap.broadcastMessage(MaplePacketCreator.removeNPCController(mapleNPC2.getObjectId()));
                mapleMap.broadcastMessage(MaplePacketCreator.removeNPC(mapleNPC2.getObjectId()));
                iterator.remove();
            }
            return;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.NPC).writeLock().unlock();
        }
    }

    public /* synthetic */ void setSpawnSpeed(int a2) {
        a.v = a2;
    }

    public /* synthetic */ void Papfight() {
        a.E = true;
    }

    public final /* synthetic */ int getForcedReturnId() {
        MapleMap a2;
        return a2.z;
    }

    public final /* synthetic */ int getTimeLimit() {
        MapleMap a2;
        return a2.U;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleCharacter getCharacterById(int a2) {
        MapleMap a3;
        a3.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a3.La) {
                if (mapleCharacter.getId() != a2) continue;
                return mapleCharacter;
            }
        }
        finally {
            a3.ia.readLock().unlock();
        }
        return null;
    }

    public final /* synthetic */ int getMapObjectSize() {
        MapleMap a2;
        return a2.aa.size() + a2.getCharactersSize() - a2.La.size();
    }

    public final /* synthetic */ void killMonster(MapleMonster a2, MapleCharacter a3, boolean a4) {
        MapleMap a5;
        a5.killMonster(a2, a3, a4, false, (byte)1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int getCharactersSize() {
        MapleMap a2;
        int n2 = 0;
        a2.ia.readLock().lock();
        try {
            Iterator<MapleCharacter> iterator = a2.La.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().isClone()) continue;
                ++n2;
            }
            return n2;
        }
        finally {
            a2.ia.readLock().unlock();
        }
    }

    public final /* synthetic */ boolean getSpawns() {
        MapleMap a2;
        return a2.b;
    }

    public final /* synthetic */ void spawnAutoDrop(int a2, final Point a3) {
        MapleMap a4;
        Item item2 = null;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (GameConstants.getInventoryType(a2) == MapleInventoryType.EQUIP) {
            MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
            item2 = mapleItemInformationProvider2.randomizeStats((Equip)mapleItemInformationProvider2.getEquipById(a2));
        } else {
            item2 = new Item(a2, 0, 1, 0);
        }
        MapleMapItem mapleMapItem = a2 = new MapleMapItem(a3, item2);
        MapleMap mapleMap = a4;
        mapleMap.ALLATORIxDEMO(a2, new DelayedPacketCreation(){
            {
                24 a32;
            }

            @Override
            public /* synthetic */ void sendPackets(MapleClient a22) {
                24 a32;
                24 v0 = a32;
                a22.sendPacket(MaplePacketCreator.dropItemFromMapObject(v0.a2, v0.a3, a32.a3, (byte)1));
            }
        }, null);
        mapleMap.broadcastMessage(MaplePacketCreator.dropItemFromMapObject(mapleMapItem, a3, a3, (byte)0));
        mapleMapItem.registerExpire(120000L);
    }

    public final /* synthetic */ int getForceMove() {
        MapleMap a2;
        return a2.Y;
    }

    public final /* synthetic */ void talkMonster(String a2, int a3, int a4) {
        MapleMap a5;
        if (a3 > 0) {
            a5.startMapEffect(a2, a3, false);
        }
        MapleMap mapleMap = a5;
        int n2 = a4;
        mapleMap.broadcastMessage(MobPacket.talkMonster(n2, a3, a2));
        mapleMap.broadcastMessage(MobPacket.removeTalkMonster(n2));
    }

    public final /* synthetic */ int spawnMonsterWithEffectBelow(MapleMonster a2, Point a3, int a4) {
        MapleMap a5;
        MapleMap mapleMap = a5;
        Point point = a3;
        a3 = mapleMap.calcPointBelow(new Point(point.x, point.y - 1));
        return mapleMap.spawnMonsterWithEffect(a2, a4, a3);
    }

    public /* synthetic */ void setSquad(MapleSquad.MapleSquadType a2) {
        a.F = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ EventManager getEMByMap() {
        MapleMap a2;
        String string = null;
        switch (a2.Ba) {
            case 105100300: {
                string = MerchItemPackage.ALLATORIxDEMO("n[_GnU@FCS");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 280030000: {
                string = MTSCSPacket.ALLATORIxDEMO("pDAPGgKQ^IO");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 240060000: 
            case 240060100: 
            case 240060200: {
                string = MerchItemPackage.ALLATORIxDEMO("d[^ZXUEXnUX@@Q");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 280030001: {
                string = MTSCSPacket.ALLATORIxDEMO("fBDEVpDAPG");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 270050100: {
                string = MerchItemPackage.ALLATORIxDEMO("|]B_nQMZnUX@@Q");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000111: {
                string = MTSCSPacket.ALLATORIxDEMO("kKHOIOVYhKBCFgJDV^@X");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000211: {
                string = MerchItemPackage.ALLATORIxDEMO("zQ^SMYC@");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000311: {
                string = MTSCSPacket.ALLATORIxDEMO("QENSJu\u0017\u001a\u001c\u001f");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000411: {
                string = MerchItemPackage.ALLATORIxDEMO("pYZMG");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000611: {
                string = MTSCSPacket.ALLATORIxDEMO("kCGOWM@D");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000711: {
                string = MerchItemPackage.ALLATORIxDEMO("hABU_\u0006");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000801: 
            case 802000802: 
            case 802000803: {
                string = MTSCSPacket.ALLATORIxDEMO("iJX@hIK_O");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 802000821: 
            case 802000823: {
                string = MerchItemPackage.ALLATORIxDEMO("mAJ\\MBIZ");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 211070100: 
            case 211070101: 
            case 211070110: {
                string = MTSCSPacket.ALLATORIxDEMO("|JDiOJDgKQ^IO");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 223030210: 
            case 551030200: {
                string = MerchItemPackage.ALLATORIxDEMO("gOU^`MFnUX@@Q");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 271040100: {
                string = MTSCSPacket.ALLATORIxDEMO("fSBDPYgKQ^IO");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 262030300: {
                string = MerchItemPackage.ALLATORIxDEMO("|EX@UnUX@@Q");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 262031300: {
                string = MTSCSPacket.ALLATORIxDEMO("nDXNbLFIKgKQ^IO");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 272020110: 
            case 272030400: {
                string = MerchItemPackage.ALLATORIxDEMO("mFGU^]YYnUX@@Q");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 955000100: 
            case 955000200: 
            case 955000300: {
                string = MTSCSPacket.ALLATORIxDEMO("dYRKKeCLvODYJD");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 280030100: {
                string = MerchItemPackage.ALLATORIxDEMO("nM_YYnUX@@Q");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 272020200: {
                string = MTSCSPacket.ALLATORIxDEMO("kNK\\CIO");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 689013000: {
                string = MerchItemPackage.ALLATORIxDEMO("dEZGnM_YY");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 703200400: {
                string = MTSCSPacket.ALLATORIxDEMO("\u0015kIFgEVY");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 105100400: {
                string = MerchItemPackage.ALLATORIxDEMO("vCG_vMX^[Kkiu\u007fm");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
            case 240060001: 
            case 240060101: 
            case 240060201: {
                string = MTSCSPacket.ALLATORIxDEMO("iMKJYmEWDQKLF");
                MapleMap mapleMap = a2;
                return ChannelServer.getInstance(mapleMap.Ja, a2.ma).getEventSM().getEventManager(string);
            }
        }
        return null;
    }

    public final /* synthetic */ MapleMap getReturnMap() {
        MapleMap a2;
        MapleMap mapleMap = a2;
        return ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma).getMapFactory().getMap(a2.u);
    }

    public final /* synthetic */ void setHPDecInterval(int a2) {
        a.V = a2;
    }

    public final /* synthetic */ void addPortal(MaplePortal a2) {
        MapleMap a3;
        a3.Da.put(a2.getId(), a2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleReactor> getAllReactorsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleReactor> arrayList = new ArrayList<MapleReactor>();
        a2.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                arrayList.add((MapleReactor)mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
    }

    public /* synthetic */ void setCheckStates(boolean a2) {
        a.l = a2;
    }

    public final /* synthetic */ void setLevelLimit(int a2) {
        a.O = a2;
    }

    public final /* synthetic */ boolean canSoar() {
        MapleMap a2;
        return a2.w;
    }

    public /* synthetic */ void setBottom(int a2) {
        a.k = (short)a2;
    }

    public final /* synthetic */ MaplePortal getPortalByScriptName(String a2) {
        MapleMap a3;
        for (MaplePortal maplePortal : a3.Da.values()) {
            String string = maplePortal.getScriptName();
            if (string == null || !string.equals(a2)) continue;
            return maplePortal;
        }
        return null;
    }

    private /* synthetic */ void l(MapleCharacter a2, MapleMonster a3) {
        Item item2;
        int n2;
        int n3;
        List<MonsterDropEntry> list;
        MapleMap a4;
        block32: {
            block31: {
                if (!a4.c || a3 == null || a2 == null) break block31;
                MapleMap mapleMap = a4;
                if (ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma) != null && !a3.dropsDisabled() && a2.getPyramidSubway() == null) break block32;
            }
            return;
        }
        if (a3.isSummonMonster()) {
            return;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        byte by = (byte)(a3.getStats().isExplosiveReward() ? 3 : (a3.getStats().isFfaLoot() ? 2 : (a2.getParty() != null ? 1 : 0)));
        MapleMonster mapleMonster = a3;
        int n4 = mapleMonster.getPosition().x;
        double d2 = a2.getAllMesoRate();
        int n5 = 1;
        Point point = new Point(0, a3.getPosition().y);
        double d3 = 0.0;
        if (!mapleMonster.getStats().isBoss() && (list = a3.getBuff(MonsterStatus.SHOWDOWN)) != null) {
            d3 += (double)((MonsterStatusEffect)((Object)list)).getX().intValue();
        }
        list = MapleMonsterInformationProvider.getInstance();
        list = a4.retrieveMapDrop();
        for (MonsterDropEntry arrayList2 : list) {
            MonsterDropEntry monsterDropEntry;
            by = 3;
            d3 = a2.getStat().getTotalDropBuff(arrayList2.itemId) <= 0.0 ? 100.0 : a2.getStat().getTotalDropBuff(arrayList2.itemId);
            n3 = (int)((double)arrayList2.chance * d3 / 100.0 * a2.getAllDropRate(a4, a3));
            n3 += (int)((double)(n3 * a2.getEquipDropRate()) * 0.01);
            if (Randomizer.nextInt(999999) >= n3) continue;
            n2 = list.size();
            if (by == 3) {
                point.x = n4 + (int)(n5 % 2 == 0 ? (double)(40 * (n5 + 1)) * 0.5 : (double)(40 * n5) * 0.5);
                monsterDropEntry = arrayList2;
            } else {
                point.x = n4 + (n5 % 2 == 0 ? 25 * (n5 + 1) / 2 : -(25 * (n5 / 2)));
                monsterDropEntry = arrayList2;
            }
            if (monsterDropEntry.itemId == 0) {
                MonsterDropEntry monsterDropEntry2 = arrayList2;
                int n6 = Randomizer.nextInt(1 + Math.abs(monsterDropEntry2.Maximum - monsterDropEntry2.Minimum)) + arrayList2.Minimum;
                if (n6 <= 0) continue;
                MapleMap mapleMap = a4;
                mapleMap.spawnMobMesoDrop(n6, mapleMap.calcDropPos(point, a3.getTruePosition()), a3, a2, false, by);
                n5 = (byte)(n5 + 1);
                continue;
            }
            if (GameConstants.getInventoryType(arrayList2.itemId) == MapleInventoryType.EQUIP) {
                MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
                item2 = mapleItemInformationProvider2.randomizeStats((Equip)mapleItemInformationProvider2.getEquipById(arrayList2.itemId));
            } else {
                int n7;
                if (arrayList2.Maximum != 1) {
                    MonsterDropEntry monsterDropEntry3 = arrayList2;
                    n7 = Randomizer.nextInt(monsterDropEntry3.Maximum - monsterDropEntry3.Minimum) + arrayList2.Minimum;
                } else {
                    n7 = 1;
                }
                item2 = new Item(arrayList2.itemId, 0, (short)n7, 0);
            }
            if (MapleItemInformationProvider.getInstance().itemExists(item2.getItemId())) {
                MapleMap mapleMap = a4;
                mapleMap.spawnMobDrop(item2, mapleMap.calcDropPos(point, a3.getPosition()), a3, a2, by, arrayList2.questid);
            }
            n5 = (byte)(n5 + 1);
        }
        List<MonsterDropEntry> list2 = a4.retrieveDrop(a3.getId());
        if (list2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(list2);
        if (arrayList == null) {
            return;
        }
        ArrayList arrayList2 = arrayList;
        Collections.shuffle(arrayList2);
        Iterator iterator = arrayList2.iterator();
        block1: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                MonsterDropEntry monsterDropEntry;
                MonsterDropEntry monsterDropEntry4 = (MonsterDropEntry)iterator.next();
                if (monsterDropEntry4.itemId == a3.getStolen()) {
                    iterator2 = iterator;
                    continue;
                }
                if (Randomizer.nextInt(999999) >= monsterDropEntry4.chance) continue block1;
                if (by != 3 && monsterDropEntry4.itemId == 0) {
                    iterator2 = iterator;
                    continue;
                }
                if (monsterDropEntry4.questid > 0 && a2.getQuestStatus(monsterDropEntry4.questid) != 1) {
                    iterator2 = iterator;
                    continue;
                }
                if (monsterDropEntry4.itemId / 10000 == 238 && !a3.getStats().isBoss() && a2.getMonsterBook().getLevelByCard(mapleItemInformationProvider.getCardMobId(monsterDropEntry4.itemId)) >= 2) {
                    iterator2 = iterator;
                    continue;
                }
                if (by == 3) {
                    point.x = n4 + (n5 % 2 == 0 ? 40 * (n5 + 1) / 2 : -(40 * (n5 / 2)));
                    monsterDropEntry = monsterDropEntry4;
                } else {
                    point.x = n4 + (n5 % 2 == 0 ? 25 * (n5 + 1) / 2 : -(25 * (n5 / 2)));
                    monsterDropEntry = monsterDropEntry4;
                }
                if (monsterDropEntry.itemId == 0) {
                    MonsterDropEntry monsterDropEntry5 = monsterDropEntry4;
                    n3 = Randomizer.nextInt(1 + Math.abs(monsterDropEntry5.Maximum - monsterDropEntry5.Minimum)) + monsterDropEntry4.Minimum;
                    if (n3 > 0) {
                        n2 = (int)((double)n3 * (a2.getStat().mesoBuff / 100.0) * (double)a2.getDropMod() * d2);
                        n2 += (int)((double)(n2 * a2.getEquipMesoRate()) * 0.01);
                        MapleMap mapleMap = a4;
                        mapleMap.spawnMobMesoDrop(n2, mapleMap.calcDropPos(point, a3.getTruePosition()), a3, a2, false, by);
                    }
                } else {
                    if (GameConstants.getInventoryType(monsterDropEntry4.itemId) == MapleInventoryType.EQUIP) {
                        MapleItemInformationProvider mapleItemInformationProvider3 = mapleItemInformationProvider;
                        item2 = mapleItemInformationProvider3.randomizeStats((Equip)mapleItemInformationProvider3.getEquipById(monsterDropEntry4.itemId));
                    } else {
                        MonsterDropEntry monsterDropEntry6 = monsterDropEntry4;
                        n3 = Math.abs(monsterDropEntry6.Maximum - monsterDropEntry6.Minimum);
                        item2 = new Item(monsterDropEntry4.itemId, 0, (short)(monsterDropEntry4.Maximum != 1 ? Randomizer.nextInt(n3 <= 0 ? 1 : n3) + monsterDropEntry4.Minimum : 1), 0);
                    }
                    if (MapleItemInformationProvider.getInstance().itemExists(item2.getItemId())) {
                        MapleMap mapleMap = a4;
                        mapleMap.spawnMobDrop(item2, mapleMap.calcDropPos(point, a3.getPosition()), a3, a2, by, monsterDropEntry4.questid);
                    }
                }
                n5 = (byte)(n5 + 1);
                continue block1;
            }
            break;
        }
    }

    public final /* synthetic */ void addMapDrop(int a2, int a3) {
        MapleMap a4;
        a4.addMapDrop(a2, a3, 1, 1, (short)0);
    }

    public final /* synthetic */ void setPersonalShop(boolean a2) {
        a.R = a2;
    }

    public final /* synthetic */ int getLevelLimit() {
        MapleMap a2;
        return a2.O;
    }

    public final /* synthetic */ void setHPDec(int a2) {
        MapleMap a3;
        if (a2 > 0 || a3.Ba == 749040100) {
            a3.M = System.currentTimeMillis();
        }
        a3.Ha = (short)a2;
    }

    public final /* synthetic */ MaplePortal getPortal(String a2) {
        MapleMap a3;
        for (MaplePortal maplePortal : a3.Da.values()) {
            if (!maplePortal.getName().equals(a2)) continue;
            return maplePortal;
        }
        return null;
    }

    public final /* synthetic */ boolean isClickGameMap() {
        MapleMap a2;
        return a2.t;
    }

    public /* synthetic */ long getSpeedRunStart() {
        MapleMap a2;
        return a2.i;
    }

    public /* synthetic */ void UpdateEndBelong() {
        a.ALLATORIxDEMO = System.currentTimeMillis() + 30000L;
    }

    public final /* synthetic */ void spawnKite(MapleKite a2) {
        MapleMap a3;
        MapleMap mapleMap = a3;
        mapleMap.addMapObject(a2);
        mapleMap.broadcastMessage(a2.makeSpawnData());
        Timer.MapTimer.getInstance().schedule(() -> {
            MapleMap a3;
            MapleMap mapleMap = a3;
            mapleMap.broadcastMessage(a2.makeDestroyData());
            mapleMap.removeMapObject(a2);
        }, 3600000L);
    }

    public final /* synthetic */ void startMapEffect(String a2, int a3, int a4) {
        MapleMap a5;
        a5.startMapEffect(a2, a3, false, a4);
    }

    public /* synthetic */ void setMulungDojoLeaveTask(ScheduledFuture<?> a2) {
        a.j = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<MapleMapObject> getMapObjectsInRange(Point a2, double a3, List<MapleMapObjectType> a4) {
        ArrayList<MapleMapObject> arrayList = new ArrayList<MapleMapObject>();
        a4 = a4.iterator();
        while (a4.hasNext()) {
            MapleMap a5;
            MapleMapObjectType mapleMapObjectType = (MapleMapObjectType)((Object)a4.next());
            a5.ka.get((Object)mapleMapObjectType).readLock().lock();
            try {
                for (MapleMapObject mapleMapObject : a5.aa.get((Object)mapleMapObjectType).values()) {
                    if (!(a2.distanceSq(mapleMapObject.getPosition()) <= a3)) continue;
                    arrayList.add(mapleMapObject);
                }
            }
            finally {
                a5.ka.get((Object)mapleMapObjectType).readLock().unlock();
            }
        }
        return arrayList;
    }

    public /* synthetic */ void setConsumeItemCoolTime(int a2) {
        a.W = a2;
    }

    public final /* synthetic */ void spawnNpc(int a2, Point a3) {
        MapleMap a4;
        MapleNPC mapleNPC = a2 = MapleLifeFactory.getNPC(a2);
        MapleNPC mapleNPC2 = a2;
        Point point = a3;
        a2.setPosition(a3);
        a2.setCy(point.y);
        mapleNPC2.setRx0(point.x + 50);
        mapleNPC2.setRx1(a3.x - 50);
        mapleNPC.setFh(a4.getFootholds().findBelow(a3).getId());
        mapleNPC.setCustom(true);
        MapleMap mapleMap = a4;
        mapleMap.addMapObject(a2);
        mapleMap.broadcastMessage(MaplePacketCreator.spawnNPC(mapleNPC, true));
    }

    public /* synthetic */ void setTop(int a2) {
        a.B = (short)a2;
    }

    public final /* synthetic */ void decApplyedStatusMonster() {
        MapleMap a2;
        --a2.fa;
    }

    public /* synthetic */ void setRight(int a2) {
        a.a = (short)a2;
    }

    public final /* synthetic */ void setTown(boolean a2) {
        a.T = a2;
    }

    public final /* synthetic */ void broadcastMessage(byte[] a2, Point a3) {
        MapleMap a4;
        a4.ALLATORIxDEMO(null, a2, GameConstants.maxViewRangeSq(), a3);
    }

    public final /* synthetic */ void spawnMechDoor(final MechDoor a2) {
        MapleMap a3;
        a3.ALLATORIxDEMO(a2, new DelayedPacketCreation(){
            {
                12 a3;
            }

            @Override
            public final /* synthetic */ void sendPackets(MapleClient a22) {
                12 a3;
                MapleClient mapleClient = a22;
                mapleClient.sendPacket(MaplePacketCreator.spawnMechDoor(a3.a2, true));
                mapleClient.sendPacket(MaplePacketCreator.enableActions());
            }
        }, null);
    }

    public final /* synthetic */ void setUserEnter(String a2) {
        a.f = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleMapObject getMapObject(int a22, MapleMapObjectType a3) {
        MapleMap a4;
        a4.ka.get((Object)a3).readLock().lock();
        try {
            MapleMapObject a22 = a4.aa.get((Object)a3).get(a22);
            return a22;
        }
        finally {
            a4.ka.get((Object)a3).readLock().unlock();
        }
    }

    public /* synthetic */ void doShrine(boolean a2) {
        MapleMap a3;
        if (a3.L != null) {
            a3.cancelSquadSchedule();
        }
        int n2 = 300;
        int n3 = a3.Ba == 280030000 ? 1 : (a3.Ba == 280030001 ? 2 : (a3.Ba == 240060200 || a3.Ba == 240060201 ? 3 : 0));
        MapleMap mapleMap = a3;
        Object object = mapleMap.getSquadByMap();
        Object object2 = mapleMap.getEMByMap();
        if (object != null && object2 != null && a3.getCharactersSize() > 0) {
            MapleMap mapleMap2;
            MapleMap mapleMap3;
            int n4;
            object = ((MapleSquad)object).getLeaderName();
            String string = ((EventManager)object2).getProperty(MTSCSPacket.ALLATORIxDEMO("YQKQO"));
            MapleMap mapleMap4 = a3.getForcedReturnMap();
            if (mapleMap4 == null || mapleMap4.getId() == a3.Ba) {
                mapleMap4 = a3.getReturnMap();
            }
            EventManager eventManager = object2;
            if (!a2) {
                eventManager.setProperty(MerchItemPackage.ALLATORIxDEMO("H[\u007f\\^]BQ"), MTSCSPacket.ALLATORIxDEMO("QXPO"));
                n4 = n3;
            } else {
                eventManager.setProperty(MerchItemPackage.ALLATORIxDEMO("H[\u007f\\^]BQ"), MTSCSPacket.ALLATORIxDEMO("LDFVO"));
                n4 = n3;
            }
            switch (n4) {
                case 1: {
                    MapleMap mapleMap5 = a3;
                    while (false) {
                    }
                    mapleMap3 = mapleMap5;
                    mapleMap5.broadcastMessage(MaplePacketCreator.showZakumShrine(a2, 5));
                    break;
                }
                case 2: {
                    MapleMap mapleMap6 = a3;
                    mapleMap3 = mapleMap6;
                    mapleMap6.broadcastMessage(MaplePacketCreator.showChaosZakumShrine(a2, 5));
                    break;
                }
                case 3: {
                    MapleMap mapleMap7 = a3;
                    mapleMap3 = mapleMap7;
                    mapleMap7.broadcastMessage(MaplePacketCreator.showChaosHorntailShrine(a2, 5));
                    break;
                }
                default: {
                    MapleMap mapleMap8 = a3;
                    mapleMap3 = mapleMap8;
                    mapleMap8.broadcastMessage(MaplePacketCreator.showHorntailShrine(a2, 5));
                }
            }
            mapleMap3.broadcastMessage(MaplePacketCreator.getClock(n2));
            if (!a2) {
                Iterator<MapleMonster> iterator;
                List<MapleMonster> list = a3.getAllMonstersThreadsafe();
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                Iterator<MapleMonster> iterator2 = iterator = list.iterator();
                while (iterator2.hasNext()) {
                    MapleMapObject mapleMapObject = iterator.next();
                    iterator2 = iterator;
                    arrayList.add(mapleMapObject.getObjectId());
                }
                object2 = new Runnable(){
                    public final /* synthetic */ boolean a;
                    public final /* synthetic */ int K;
                    public final /* synthetic */ List k;
                    public final /* synthetic */ List E;
                    public final /* synthetic */ String g;
                    public final /* synthetic */ MapleMap ALLATORIxDEMO;
                    public final /* synthetic */ MapleMap d;
                    public final /* synthetic */ String B;
                    {
                        29 a3;
                        29 v0 = a3;
                        29 v1 = a3;
                        29 v2 = a3;
                        v2.ALLATORIxDEMO = a2;
                        v2.E = list;
                        v1.g = string;
                        v1.B = string2;
                        v0.k = list2;
                        v0.K = n2;
                        a3.a = bl;
                        a3.d = mapleMap;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        29 a2;
                        29 v0 = a2;
                        MapleSquad mapleSquad = v0.ALLATORIxDEMO.getSquadByMap();
                        if (v0.ALLATORIxDEMO.getCharactersSize() > 0 && a2.ALLATORIxDEMO.getNumMonsters() == a2.E.size() && mapleSquad != null && mapleSquad.getStatus() == 2 && mapleSquad.getLeaderName().equals(a2.g) && a2.ALLATORIxDEMO.getEMByMap().getProperty(CommandProcessorUtil.ALLATORIxDEMO("K\u0012Y\u0012]")).equals(a2.B)) {
                            boolean bl;
                            Object object;
                            block11: {
                                29 v1 = a2;
                                boolean bl2 = v1.E.isEmpty();
                                for (MapleMapObject object2 : v1.ALLATORIxDEMO.getAllMonstersThreadsafe()) {
                                    boolean bl3;
                                    block10: {
                                        object = a2.k.iterator();
                                        while (object.hasNext()) {
                                            int n2 = (Integer)object.next();
                                            if (object2.getObjectId() != n2) continue;
                                            bl3 = bl2 = true;
                                            break block10;
                                        }
                                        bl3 = bl2;
                                    }
                                    if (!bl3) continue;
                                    bl = bl2;
                                    break block11;
                                }
                                bl = bl2;
                            }
                            if (bl) {
                                Iterator<MapleCharacter> iterator;
                                Object object3;
                                29 v5;
                                switch (a2.K) {
                                    case 1: {
                                        29 v4 = a2;
                                        while (false) {
                                        }
                                        v5 = v4;
                                        object3 = MaplePacketCreator.showZakumShrine(v4.a, 0);
                                        break;
                                    }
                                    case 2: {
                                        29 v6 = a2;
                                        v5 = v6;
                                        object3 = MaplePacketCreator.showChaosZakumShrine(v6.a, 0);
                                        break;
                                    }
                                    default: {
                                        29 v7 = a2;
                                        v5 = v7;
                                        object3 = MaplePacketCreator.showHorntailShrine(v7.a, 0);
                                    }
                                }
                                Iterator<MapleCharacter> iterator2 = iterator = v5.ALLATORIxDEMO.getCharactersThreadsafe().iterator();
                                while (iterator2.hasNext()) {
                                    object = iterator.next();
                                    iterator2 = iterator;
                                    Object object2 = object;
                                    ((MapleCharacter)object2).getClient().sendPacket((byte[])object3);
                                    ((MapleCharacter)object2).changeMap(a2.d, a2.d.getPortal(0));
                                }
                                29 v10 = a2;
                                v10.ALLATORIxDEMO.checkStates("");
                                v10.ALLATORIxDEMO.resetFully();
                            }
                        }
                    }
                };
                mapleMap2 = a3;
            } else {
                object2 = new Runnable(){
                    public final /* synthetic */ MapleMap ALLATORIxDEMO;
                    public final /* synthetic */ String k;
                    public final /* synthetic */ int K;
                    public final /* synthetic */ String B;
                    public final /* synthetic */ boolean a;
                    public final /* synthetic */ MapleMap d;

                    @Override
                    public /* synthetic */ void run() {
                        30 a2;
                        30 v0 = a2;
                        MapleSquad mapleSquad = v0.ALLATORIxDEMO.getSquadByMap();
                        if (v0.ALLATORIxDEMO.getCharactersSize() > 0 && mapleSquad != null && mapleSquad.getStatus() == 2 && mapleSquad.getLeaderName().equals(a2.B) && a2.ALLATORIxDEMO.getEMByMap().getProperty(FuckingHackerToby.F.ALLATORIxDEMO("?\\-\\)")).equals(a2.k)) {
                            Iterator<MapleCharacter> iterator;
                            byte[] arrby;
                            30 v2;
                            switch (a2.K) {
                                case 1: {
                                    30 v1 = a2;
                                    while (false) {
                                    }
                                    v2 = v1;
                                    arrby = MaplePacketCreator.showZakumShrine(v1.a, 0);
                                    break;
                                }
                                case 2: {
                                    30 v3 = a2;
                                    v2 = v3;
                                    arrby = MaplePacketCreator.showChaosZakumShrine(v3.a, 0);
                                    break;
                                }
                                default: {
                                    30 v4 = a2;
                                    v2 = v4;
                                    arrby = MaplePacketCreator.showHorntailShrine(v4.a, 0);
                                }
                            }
                            Iterator<MapleCharacter> iterator2 = iterator = v2.ALLATORIxDEMO.getCharactersThreadsafe().iterator();
                            while (iterator2.hasNext()) {
                                MapleCharacter mapleCharacter = iterator.next();
                                iterator2 = iterator;
                                MapleCharacter mapleCharacter2 = mapleCharacter;
                                mapleCharacter2.getClient().sendPacket(arrby);
                                mapleCharacter2.changeMap(a2.d, a2.d.getPortal(0));
                            }
                            30 v7 = a2;
                            v7.ALLATORIxDEMO.checkStates("");
                            v7.ALLATORIxDEMO.resetFully();
                        }
                    }
                    {
                        30 a3;
                        30 v0 = a3;
                        30 v1 = a3;
                        v1.ALLATORIxDEMO = a2;
                        v1.B = string;
                        v0.k = string2;
                        v0.K = n2;
                        a3.a = bl;
                        a3.d = mapleMap;
                    }
                };
                mapleMap2 = a3;
            }
            mapleMap2.L = Timer.MapTimer.getInstance().schedule((Runnable)object2, n2 * 1000);
        }
    }

    public final /* synthetic */ List<Rectangle> getAreas() {
        MapleMap a2;
        return a2.I.getAreas();
    }

    public final /* synthetic */ void killMonster(MapleMonster a2, MapleCharacter a3, boolean a4, boolean a5, byte a6) {
        MapleMap a7;
        a7.killMonster(a2, a3, a4, a5, a6, 0);
    }

    public /* synthetic */ void setNodes(MapleNodes a2) {
        a.I = a2;
    }

    public final /* synthetic */ void spawnMobMesoDrop(int a22, Point a3, MapleMapObject a4, MapleCharacter a5, boolean a6, byte a7) {
        MapleMap a8;
        MapleMapItem a22 = new MapleMapItem(a22, a3, a4, a5, a7, a6);
        a8.ALLATORIxDEMO(a22, new DelayedPacketCreation(){
            public final /* synthetic */ Point d;
            public final /* synthetic */ MapleMapObject a;
            public final /* synthetic */ MapleMapItem K;
            public final /* synthetic */ MapleMap ALLATORIxDEMO;
            {
                21 a3;
                21 v0 = a3;
                v0.ALLATORIxDEMO = a2;
                v0.K = mapleMapItem;
                a3.a = mapleMapObject;
                a3.d = point;
            }

            @Override
            public /* synthetic */ void sendPackets(MapleClient a2) {
                21 a3;
                21 v0 = a3;
                a2.sendPacket(MaplePacketCreator.dropItemFromMapObject(v0.K, v0.a.getPosition(), a3.d, (byte)1));
            }
        }, null);
        a22.registerExpire(120000L);
        if (a7 == 0 || a7 == 1) {
            a22.registerFFA(30000L);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void updateMonsterController(MapleMonster a2) {
        MapleMap a3;
        if (!a2.isAlive()) {
            return;
        }
        if (a2.getController() != null) {
            if (a2.getController().getMap() != a3) {
                a2.getController().stopControllingMonster(a2);
            } else {
                return;
            }
        }
        int n2 = -1;
        MapleCharacter mapleCharacter = null;
        a3.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter2 : a3.La) {
                if (mapleCharacter2.isHidden() || mapleCharacter2.isClone() || mapleCharacter2.getControlledSize() >= n2 && n2 != -1) continue;
                n2 = mapleCharacter2.getControlledSize();
            }
        }
        finally {
            a3.ia.readLock().unlock();
        }
        if (mapleCharacter != null) {
            MapleCharacter mapleCharacter3 = mapleCharacter;
            if (a2.isFirstAttack()) {
                mapleCharacter3.controlMonster(a2, true);
                MapleMonster mapleMonster = a2;
                mapleMonster.setControllerHasAggro(true);
                mapleMonster.setControllerKnowsAboutAggro(true);
                return;
            }
            mapleCharacter3.controlMonster(a2, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void setReactorState(byte a2) {
        MapleMap a3;
        a3.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            Iterator<MapleMapObject> iterator = a3.aa.get((Object)MapleMapObjectType.REACTOR).values().iterator();
            while (iterator.hasNext()) {
                ((MapleReactor)iterator.next()).forceHitReactor(a2);
            }
            return;
        }
        finally {
            a3.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
        }
    }

    public /* synthetic */ Collection<MapleNodes.MapleNodeInfo> getNodes() {
        MapleMap a2;
        return a2.I.getNodes();
    }

    public final /* synthetic */ void setClock(boolean a2) {
        a.C = a2;
    }

    public final /* synthetic */ void destroyReactor(int a222) {
        MapleMap a3;
        MapleMap mapleMap = a3;
        final MapleReactor a222 = mapleMap.getReactorByOid(a222);
        mapleMap.broadcastMessage(MaplePacketCreator.destroyReactor(a222));
        MapleReactor mapleReactor = a222;
        mapleReactor.setAlive(false);
        mapleMap.removeMapObject(mapleReactor);
        MapleReactor mapleReactor2 = a222;
        mapleReactor2.setTimerActive(false);
        if (mapleReactor2.getDelay() > 0) {
            try {
                Timer.MapTimer.getInstance().schedule(new Runnable(){
                    {
                        2 a3;
                    }

                    @Override
                    public final /* synthetic */ void run() {
                        2 a2;
                        2 v0 = a2;
                        v0.MapleMap.this.ALLATORIxDEMO(v0.a222);
                    }
                }, a222.getDelay());
                return;
            }
            catch (RejectedExecutionException a222) {
                System.err.println("\u53cd\u61c9\u7269\u7cfb\u7d71: Timer[MapTimer] \u51fa\u73fe\u7570\u5e38: " + a222.getLocalizedMessage());
            }
        }
    }

    public final /* synthetic */ void updateMapObjectVisibility(MapleCharacter a2, MapleMapObject a3) {
        if (a2 == null || a2.isClone()) {
            return;
        }
        if (!a2.isMapObjectVisible(a3)) {
            if (a3.getType() == MapleMapObjectType.MIST || a3.getType() == MapleMapObjectType.EXTRACTOR || a3.getType() == MapleMapObjectType.SUMMON || a3.getType() == MapleMapObjectType.FAMILIAR || a3 instanceof MechDoor || a3.getTruePosition().distance(a2.getTruePosition()) <= (double)GameConstants.maxViewRangeSq()) {
                a2.addVisibleMapObject(a3);
                a3.sendSpawnData(a2.getClient());
                return;
            }
        } else {
            if (!(a3 instanceof MechDoor) && a3.getType() != MapleMapObjectType.MIST && a3.getType() != MapleMapObjectType.EXTRACTOR && a3.getType() != MapleMapObjectType.SUMMON && a3.getType() != MapleMapObjectType.FAMILIAR && a3.getTruePosition().distance(a2.getTruePosition()) > (double)GameConstants.maxViewRangeSq()) {
                MapleCharacter mapleCharacter = a2;
                MapleMapObject mapleMapObject = a3;
                mapleCharacter.removeVisibleMapObject(mapleMapObject);
                mapleMapObject.sendDestroyData(mapleCharacter.getClient());
                return;
            }
            if (a3.getType() == MapleMapObjectType.MONSTER && a2.getTruePosition().distance(a3.getTruePosition()) <= (double)GameConstants.maxViewRangeSq()) {
                MapleMap a4;
                a4.updateMonsterController((MapleMonster)a3);
            }
        }
    }

    public final /* synthetic */ List<MapleNodes.MaplePlatform> getPlatforms() {
        MapleMap a2;
        return a2.I.getPlatforms();
    }

    public /* synthetic */ boolean isSpeakOutPut() {
        MapleMap a2;
        boolean bl = false;
        Iterator<MapleCharacter> iterator = a2.getCharactersThreadsafe().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isSpeakOutPut()) continue;
            bl = true;
        }
        return bl;
    }

    public final /* synthetic */ void disappearingItemDrop(MapleMapObject a2, MapleCharacter a3, IItem a4, Point a5) {
        MapleMap a6;
        MapleMap mapleMap = a6;
        Point point = a5;
        a5 = mapleMap.calcDropPos(point, point);
        a3 = new MapleMapItem(a4, a5, a2, (MapleCharacter)a3, 1, false);
        mapleMap.broadcastMessage(MaplePacketCreator.dropItemFromMapObject((MapleMapItem)a3, a2.getPosition(), a5, (byte)3), a3.getPosition());
    }

    public final /* synthetic */ int getApplyedStatusMonsterCount() {
        MapleMap a2;
        return a2.fa;
    }

    public /* synthetic */ void spawnPinkZakum(int a22, int a32) {
        int n2;
        MapleMap a4;
        Point a22 = new Point(a22, a32);
        Object a32 = MapleLifeFactory.getMonster(9400900);
        MapleMap mapleMap = a4;
        Point point = a22;
        a22 = mapleMap.calcPointBelow(new Point(point.x, point.y - 1));
        MapleMonster mapleMonster = a32;
        mapleMonster.setPosition(a22);
        mapleMap.spawnMonster(mapleMonster, -2);
        int[] arrn = new int[8];
        arrn[0] = 9400903;
        arrn[1] = 9400904;
        arrn[2] = 9400905;
        arrn[3] = 9400906;
        arrn[4] = 9400907;
        arrn[5] = 9400908;
        arrn[6] = 9400909;
        arrn[7] = 9400910;
        a32 = arrn;
        int n3 = arrn.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleMonster mapleMonster2;
            MapleMonster mapleMonster3 = mapleMonster2 = MapleLifeFactory.getMonster((int)a32[n2]);
            mapleMonster3.setPosition(a22);
            a4.spawnMonster(mapleMonster3, -2);
            n4 = ++n2;
        }
        if (a4.L != null) {
            MapleMap mapleMap2 = a4;
            mapleMap2.cancelSquadSchedule();
            mapleMap2.broadcastMessage(MaplePacketCreator.stopClock());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleCharacter getCharacterByName(String a2) {
        MapleMap a3;
        a3.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a3.La) {
                if (!mapleCharacter.getName().equals(a2)) continue;
                return mapleCharacter;
            }
        }
        finally {
            a3.ia.readLock().unlock();
        }
        return null;
    }

    public final /* synthetic */ void spawnMonster(int a2) {
        Point point;
        MapleMap a3;
        if (a3.Ia.size() > 0) {
            MapleMap mapleMap = a3;
            mapleMap.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), mapleMap.Ia.get(Randomizer.rand(0, a3.Ia.size() - 1)));
            return;
        }
        if (a3.getFootholds() != null && (point = a3.getFootholds().getRandomPos()) != null) {
            a3.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), point);
        }
    }

    public /* synthetic */ void resetDisconnected() {
        MapleMap a2;
        a2.Ka.clear();
    }

    public final /* synthetic */ void resetFully() {
        MapleMap a2;
        a2.resetFully(true);
    }

    public final /* synthetic */ void spawnItemDrop(MapleMapObject a2, MapleCharacter a3, IItem a4, Point a5, boolean a6, boolean a7) {
        MapleMap a8;
        MapleMap mapleMap = a8;
        Point point = a5;
        a5 = mapleMap.calcDropPos(point, point);
        mapleMap.ALLATORIxDEMO((MapleMapObject)(a4 = new MapleMapItem((IItem)a4, a5, a2, a3, 2, a7)), new DelayedPacketCreation(){
            public final /* synthetic */ MapleMapItem K;
            public final /* synthetic */ MapleMapObject a;
            public final /* synthetic */ Point d;
            public final /* synthetic */ MapleMap ALLATORIxDEMO;
            {
                25 a3;
                25 v0 = a3;
                v0.ALLATORIxDEMO = a2;
                v0.K = mapleMapItem;
                a3.a = mapleMapObject;
                a3.d = point;
            }

            @Override
            public /* synthetic */ void sendPackets(MapleClient a2) {
                25 a3;
                25 v0 = a3;
                a2.sendPacket(MaplePacketCreator.dropItemFromMapObject(v0.K, v0.a.getPosition(), a3.d, (byte)1));
            }
        }, null);
        mapleMap.broadcastMessage(MaplePacketCreator.dropItemFromMapObject((MapleMapItem)a4, a2.getPosition(), a5, (byte)0));
        if (!mapleMap.N) {
            Object object = a4;
            ((MapleMapItem)object).registerExpire(120000L);
            a8.ALLATORIxDEMO((MapleMapItem)object, a3.getClient());
        }
    }

    public final /* synthetic */ void spawnMonster_sSack(MapleMonster a2, Point a3, int a4) {
        MapleMap a5;
        Point point = a3;
        Point point2 = a5.calcPointBelow(new Point(point.x, point.y - 1));
        if (point2 == null) {
            Point point3 = a3;
            point2 = a5.calcPointBelow(new Point(point3.x, point3.y));
            Point point4 = a3;
            Point point5 = a3;
            System.out.println("\u602a\u7269:" + a2.getStats().getId() + " \u5730\u5716:" + a5.getId() + "  \u5ea7\u6a19:" + point4.x + "," + (point4.y - 1) + "\u53ec\u559a\u5931\u6557, \u627e\u4e0d\u5230\u5e73\u53f0, \u81ea\u52d5\u8f49\u70ba" + point5.x + "," + point5.y + " \u8f49\u63db\u5f8c:" + (point2 == null ? MTSCSPacket.ALLATORIxDEMO("\u5914\u657d") : MerchItemPackage.ALLATORIxDEMO("\u623c\u52ab")));
        }
        a2.setPosition(point2);
        a5.spawnMonster(a2, a4);
    }

    public final /* synthetic */ void cancelSquadSchedule() {
        MapleMap a2;
        a2.G = false;
        a2.l = true;
        if (a2.L != null) {
            a2.L.cancel(false);
            a2.L = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ double getMobSpawnRate() {
        if (GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u8438\u8283\u8c03"))) {
            MapleMap a2;
            switch (a2.Ba) {
                case 103000101: 
                case 103000102: 
                case 103000103: 
                case 103000104: 
                case 103000105: 
                case 105050000: 
                case 105050100: 
                case 105050200: 
                case 105050300: 
                case 105070001: 
                case 200010120: 
                case 200010121: 
                case 211010000: 
                case 211020000: 
                case 211030000: 
                case 211040000: 
                case 211050000: 
                case 220010500: 
                case 230040000: 
                case 230040100: 
                case 240020400: 
                case 270010100: 
                case 270010200: 
                case 270010300: 
                case 270010400: 
                case 270010500: 
                case 270020100: 
                case 270020200: 
                case 270020300: 
                case 270020400: 
                case 270020500: 
                case 270030100: 
                case 270030200: 
                case 270030300: 
                case 270030400: 
                case 270030500: 
                case 270130100: 
                case 270130200: 
                case 270130300: 
                case 270130400: 
                case 271030101: 
                case 271030500: 
                case 271030510: 
                case 271030520: 
                case 271030530: 
                case 271030540: 
                case 271030600: 
                case 272020000: 
                case 272020100: 
                case 541000100: 
                case 541000200: 
                case 541000300: 
                case 541010010: 
                case 541020100: 
                case 541020200: 
                case 541020300: 
                case 541020400: 
                case 541020500: 
                case 742010100: 
                case 802000200: 
                case 921100100: 
                case 921100300: {
                    return 1.0;
                }
            }
        }
        return GameSetConstants.MOB_COUNT_RATE;
    }

    public /* synthetic */ List<MapleMapObject> getItemsInRange(Point a2, double a3) {
        MapleMap a4;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.ITEM;
        return a4.getMapObjectsInRange(a2, a3, Arrays.asList(arrmapleMapObjectType));
    }

    public final /* synthetic */ void spawnReactor(int a2, Point a3) {
        MapleMap a4;
        MapleReactorStats mapleReactorStats = MapleReactorFactory.getReactor(a2);
        MapleReactor mapleReactor = a2 = new MapleReactor(mapleReactorStats, a2, 0);
        mapleReactor.setDelay(-1);
        mapleReactor.setPosition(a3);
        a4.spawnReactor(mapleReactor);
    }

    public final /* synthetic */ void addDrop(int a2, int a3, int a4) {
        MapleMap a5;
        a5.addDrop(a2, a3, a4, 1, 1, (short)0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleMapItem a2, MapleClient a3) {
        MapleMap a4;
        IItem iItem = a2.getItem();
        a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().lock();
        try {
            MapleMap mapleMap;
            block3: {
                for (MapleReactor mapleReactor : a4.aa.get((Object)MapleMapObjectType.REACTOR).values()) {
                    if (mapleReactor.getReactorType() != 100 || !GameConstants.isCustomReactItem(mapleReactor.getReactorId(), iItem.getItemId(), mapleReactor.getReactItem().getLeft()) || mapleReactor.getReactItem().getRight().intValue() != iItem.getQuantity() || !mapleReactor.getArea().contains(a2.getPosition()) || mapleReactor.isTimerActive()) continue;
                    Timer.MapTimer.getInstance().schedule(new ActivateItemReactor(a4, a2, mapleReactor, a3), 5000L);
                    mapleReactor.setTimerActive(true);
                    mapleMap = a4;
                    break block3;
                }
                mapleMap = a4;
            }
            mapleMap.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
            return;
        }
        catch (Throwable throwable) {
            a4.ka.get((Object)MapleMapObjectType.REACTOR).readLock().unlock();
            throw throwable;
        }
    }

    public final /* synthetic */ void resetApplyedStatusMonster() {
        a.fa = 0;
    }

    public /* synthetic */ short getRight() {
        MapleMap a2;
        return a2.a;
    }

    public final /* synthetic */ Point calcDropPos(Point a2, Point a3) {
        MapleMap a4;
        Point point = a2;
        a2 = a4.calcPointBelow(new Point(point.x, point.y - 50));
        if (a2 == null) {
            return a3;
        }
        return a2;
    }

    public final /* synthetic */ Point calcPointBelow(Point a2) {
        MapleMap a3;
        return a3.calcFhAndPointBelow(a2).getRight();
    }

    public final /* synthetic */ void KillFk(boolean a2) {
        MapleMap a3;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        for (MapleMonster mapleMonster : a3.getMapObjectsInRange(new Point(0, 0), Double.POSITIVE_INFINITY, Arrays.asList(arrmapleMapObjectType))) {
            if (mapleMonster.getId() != 3230300 && mapleMonster.getId() != 3230301) continue;
            mapleMonster.setHp(0L);
            a3.broadcastMessage(MobPacket.killMonster(mapleMonster.getObjectId(), a2 ? 1 : 0));
            MapleMonster mapleMonster2 = mapleMonster;
            a3.removeMapObject(mapleMonster2);
            mapleMonster2.killed();
        }
        a3.broadcastMessage(MaplePacketCreator.getItemNotice(MerchItemPackage.ALLATORIxDEMO("\u7505\u6590\u53e3\u8a77\u54a6\u76a8\u5c9d\u77df\u889f\u644b\u6bac\uff20\u7102\u8020\u889f\u8a77\u54a6\u76a8\u8740\u875a\u7c8a\u6da4\u5905\u4eaa\u3036")));
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, MapleMonster a32) {
        int n2;
        Item item2;
        int n3;
        Object object;
        MapleMap a4;
        block62: {
            block61: {
                if (a32 == null || a2 == null) break block61;
                MapleMap mapleMap = a4;
                if (ChannelServer.getInstance(mapleMap.Ja, mapleMap.ma) != null && !a4.S && !a32.dropsDisabled() && a2.getPyramidSubway() == null) break block62;
            }
            return;
        }
        if (GameSetConstants.AUTO_CLEAN_DROPS > 0) {
            if (a4.aa.get((Object)MapleMapObjectType.ITEM).size() >= GameSetConstants.AUTO_CLEAN_DROPS) {
                a4.removeDrops();
            } else if (a4.aa.get((Object)MapleMapObjectType.ITEM).size() >= GameSetConstants.AUTO_CLEAN_DROPS - 50) {
                MapleMap mapleMap = a4;
                mapleMap.broadcastMessage(MaplePacketCreator.getItemNotice("\u76ee\u524d\u5730\u5716\u6389\u843d\u7269\u6578\u91cf:" + mapleMap.aa.get((Object)MapleMapObjectType.ITEM).size() + " \u9054\u5230:" + GameSetConstants.AUTO_CLEAN_DROPS + " \u53ca\u6703\u5168\u90e8\u6e05\u9664!"));
            }
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        byte by = (byte)(a32.getStats().isExplosiveReward() ? 3 : (a32.getStats().isFfaLoot() ? 2 : (a2.getParty() != null ? 1 : 0)));
        int n4 = a32.getPosition().x;
        double d2 = a2.getAllMesoRate();
        int n5 = 1;
        Point point = new Point(0, a32.getPosition().y);
        MapleMonsterInformationProvider mapleMonsterInformationProvider = MapleMonsterInformationProvider.getInstance();
        Object object2 = mapleMonsterInformationProvider.retrieveDrop(a32.getId());
        if ((object2 = new ArrayList<MonsterDropEntry>((Collection<MonsterDropEntry>)object2)) == null) {
            return;
        }
        if (a2.getDebugMessage()) {
            Iterator<MonsterDropEntry> iterator;
            a2.dropMessage("\u602a\u7269: " + a32.getId());
            a2.dropMessage(MerchItemPackage.ALLATORIxDEMO("\u63a5\u5bc2\u59ae\u4e3f\u0016\u0014"));
            Iterator<MonsterDropEntry> iterator2 = iterator = object2.iterator();
            while (iterator2.hasNext()) {
                Object object3 = object = iterator.next();
                Object object4 = object;
                a2.dropMessage(" \u9053\u5177: " + ((MonsterDropEntry)object3).itemId + " \u6a5f\u7387: " + (double)((MonsterDropEntry)object3).chance * a2.getAllDropRate(a4, a32) + " \u6700\u5927/\u5c0f\u6389\u843d\u91cf: " + ((MonsterDropEntry)object4).Maximum + "/" + ((MonsterDropEntry)object4).Minimum);
                iterator2 = iterator;
            }
        }
        Collections.shuffle(object2);
        boolean bl = false;
        object = object2.iterator();
        block8: while (true) {
            Object object5 = object;
            while (object5.hasNext()) {
                int n6;
                MonsterDropEntry monsterDropEntry;
                MonsterDropEntry monsterDropEntry2 = object.next();
                if (monsterDropEntry2.itemId == a32.getStolen()) {
                    object5 = object;
                    continue;
                }
                double d3 = a2.getStat().getTotalDropBuff(monsterDropEntry2.itemId) <= 0.0 ? 100.0 : a2.getStat().getTotalDropBuff(monsterDropEntry2.itemId);
                int n7 = (int)((double)monsterDropEntry2.chance * d3 / 100.0 * a2.getAllDropRate(a4, a32));
                n7 += (int)((double)(n7 * a2.getEquipDropRate()) * 0.01);
                if (Randomizer.nextInt(999999) >= n7) continue block8;
                if (bl && by != 3 && monsterDropEntry2.itemId == 0) {
                    object5 = object;
                    continue;
                }
                if (monsterDropEntry2.questid > 0 && a2.getQuestStatus(monsterDropEntry2.questid) != 1) {
                    object5 = object;
                    continue;
                }
                if (monsterDropEntry2.itemId / 10000 == 238 && !a32.getStats().isBoss() && a2.getMonsterBook().getLevelByCard(mapleItemInformationProvider.getCardMobId(monsterDropEntry2.itemId)) >= 2) {
                    object5 = object;
                    continue;
                }
                if (by == 3) {
                    point.x = n4 + (n5 % 2 == 0 ? 40 * (n5 + 1) / 2 : -(40 * (n5 / 2)));
                    monsterDropEntry = monsterDropEntry2;
                } else {
                    point.x = n4 + (n5 % 2 == 0 ? 25 * (n5 + 1) / 2 : -(25 * (n5 / 2)));
                    monsterDropEntry = monsterDropEntry2;
                }
                if (monsterDropEntry.itemId == 0) {
                    MonsterDropEntry monsterDropEntry3 = monsterDropEntry2;
                    n6 = Randomizer.nextInt(1 + Math.abs(monsterDropEntry3.Maximum - monsterDropEntry3.Minimum)) + monsterDropEntry2.Minimum;
                    if (n6 > 0) {
                        n3 = (int)((double)n6 * (a2.getStat().mesoBuff / 100.0) * (double)a2.getDropMod() * d2);
                        n3 += (int)((double)(n3 * a2.getEquipMesoRate()) * 0.01);
                        MapleMap mapleMap = a4;
                        mapleMap.spawnMobMesoDrop(n3, mapleMap.calcDropPos(point, a32.getTruePosition()), a32, a2, false, by);
                        bl = true;
                    }
                } else {
                    if (GameConstants.getInventoryType(monsterDropEntry2.itemId) == MapleInventoryType.EQUIP) {
                        MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
                        item2 = mapleItemInformationProvider2.randomizeStats((Equip)mapleItemInformationProvider2.getEquipById(monsterDropEntry2.itemId));
                    } else {
                        MonsterDropEntry monsterDropEntry4 = monsterDropEntry2;
                        n6 = Math.abs(monsterDropEntry4.Maximum - monsterDropEntry4.Minimum);
                        item2 = new Item(monsterDropEntry2.itemId, 0, (short)(monsterDropEntry2.Maximum != 1 ? Randomizer.nextInt(n6 <= 0 ? 1 : n6) + monsterDropEntry2.Minimum : 1), 0);
                    }
                    if (MapleItemInformationProvider.getInstance().itemExists(item2.getItemId()) && !a2.isExcludeItem(monsterDropEntry2.itemId)) {
                        MapleMap mapleMap = a4;
                        mapleMap.spawnMobDrop(item2, mapleMap.calcDropPos(point, a32.getPosition()), a32, a2, by, monsterDropEntry2.questid);
                    }
                }
                n5 = (byte)(n5 + 1);
                continue block8;
            }
            break;
        }
        point.x = Math.min(Math.max(n4 - 25 * (n5 / 2), a4.la.getMinDropX() + 25), a4.la.getMaxDropX() - n5 * 25);
        int n8 = Randomizer.nextInt(a32.getLevel()) + a32.getLevel();
        if (n8 > 0) {
            double d4 = a2.getStat().realMesoBuff - 100.0 <= 0.0 ? 100.0 : a2.getStat().realMesoBuff - 100.0;
            n2 = (int)((double)n8 * (d4 / 100.0) * (double)a2.getDropMod() * d2 * a32.getExtraMesoRate());
            n2 += (int)((double)(n2 * a2.getEquipMesoRate()) * 0.01);
            MapleMap mapleMap = a4;
            mapleMap.spawnMobMesoDrop(n2, mapleMap.calcDropPos(point, a32.getTruePosition()), a32, a2, false, by);
        }
        ArrayList<MonsterGlobalDropEntry> arrayList = new ArrayList<MonsterGlobalDropEntry>(mapleMonsterInformationProvider.getGlobalDrop());
        Collections.shuffle(arrayList);
        int n9 = a32.getStats().isBoss() && a32.getStats().getHPDisplayType() == 0 ? 20 : 1;
        n2 = (int)(a32.getStats().isBoss() ? 0L : (long)(a32.getMobExp() / 1000) + a32.getMobMaxHp() / 10000L);
        if (!MapConstants.isBanGlobalDrop(a4.getId())) {
            for (MonsterGlobalDropEntry monsterGlobalDropEntry : arrayList) {
                MonsterGlobalDropEntry monsterGlobalDropEntry2;
                if (Randomizer.nextInt(999999) >= monsterGlobalDropEntry.chance || !(monsterGlobalDropEntry.continent < 0 || monsterGlobalDropEntry.continent < 10 && a4.Ba / 100000000 == monsterGlobalDropEntry.continent || monsterGlobalDropEntry.continent < 100 && a4.Ba / 10000000 == monsterGlobalDropEntry.continent) && (monsterGlobalDropEntry.continent >= 1000 || a4.Ba / 1000000 != monsterGlobalDropEntry.continent)) continue;
                if (by == 3) {
                    point.x = n4 + (n5 % 2 == 0 ? 40 * (n5 + 1) / 2 : -(40 * (n5 / 2)));
                    monsterGlobalDropEntry2 = monsterGlobalDropEntry;
                } else {
                    point.x = n4 + (n5 % 2 == 0 ? 25 * (n5 + 1) / 2 : -(25 * (n5 / 2)));
                    monsterGlobalDropEntry2 = monsterGlobalDropEntry;
                }
                if (monsterGlobalDropEntry2.itemId == 0 || a4.r) continue;
                if (GameConstants.getInventoryType(monsterGlobalDropEntry.itemId) == MapleInventoryType.EQUIP) {
                    MapleItemInformationProvider mapleItemInformationProvider3 = mapleItemInformationProvider;
                    item2 = mapleItemInformationProvider3.randomizeStats((Equip)mapleItemInformationProvider3.getEquipById(monsterGlobalDropEntry.itemId));
                } else {
                    n3 = 0;
                    if (monsterGlobalDropEntry.Maximum > 1 && monsterGlobalDropEntry.Minimum > 1) {
                        MonsterGlobalDropEntry monsterGlobalDropEntry3 = monsterGlobalDropEntry;
                        n3 = Randomizer.rand(monsterGlobalDropEntry3.Minimum, monsterGlobalDropEntry3.Maximum);
                    }
                    if (n3 < 1) {
                        n3 = 1;
                    }
                    item2 = new Item(monsterGlobalDropEntry.itemId, 0, (short)(monsterGlobalDropEntry.Maximum != 1 ? n3 : 1), 0);
                }
                if (MapleItemInformationProvider.getInstance().itemExists(item2.getItemId()) && !a2.isExcludeItem(monsterGlobalDropEntry.itemId)) {
                    MonsterGlobalDropEntry monsterGlobalDropEntry4;
                    byte by2;
                    MapleMap mapleMap = a4;
                    Point point2 = mapleMap.calcDropPos(point, a32.getPosition());
                    if (monsterGlobalDropEntry.onlySelf) {
                        by2 = 0;
                        monsterGlobalDropEntry4 = monsterGlobalDropEntry;
                    } else {
                        by2 = by;
                        monsterGlobalDropEntry4 = monsterGlobalDropEntry;
                    }
                    mapleMap.spawnMobDrop(item2, point2, a32, a2, by2, monsterGlobalDropEntry4.questid);
                }
                n5 = (byte)(n5 + 1);
            }
        }
        if (GameSetConstants.PEE_SYSTEM && Randomizer.nextInt(GameSetConstants.PEE_RATE) < 1) {
            if (GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u6700\u77c0\u8c1d")) && MapConstants.isVonleonMap(a4.Ba)) {
                MapleCharacter mapleCharacter = a2;
                mapleCharacter.setPee(mapleCharacter.getPee() + 7);
            } else if (GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u671e\u77c9\u8c03")) && MapConstants.isRabbitMap(a4.Ba)) {
                MapleCharacter mapleCharacter = a2;
                mapleCharacter.setPee(mapleCharacter.getPee() + 3);
            } else {
                MapleCharacter mapleCharacter = a2;
                mapleCharacter.setPee(mapleCharacter.getPee() + 1);
            }
        }
        if (GameSetConstants.MobDropPOINT[0] > 0.0) {
            object2 = GameSetConstants.MobDropPOINT[2] == 1.0 ? MTSCSPacket.ALLATORIxDEMO("bkvb") : MerchItemPackage.ALLATORIxDEMO("\u697f\u9eea");
            int n10 = (int)GameSetConstants.MobDropPOINT[4];
            double d5 = GameSetConstants.MobDropPOINT[3];
            if (GameSetConstants.VIPMONSTERPOINT) {
                n10 = (int)((long)n10 + a2.getClient().getTotalDonate());
                d5 *= 1.0 + (double)a2.getVipDropRate() * 0.01;
            }
            if (GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u6595\u829b\u5366\u8c1d"))) {
                switch (a2.getVip()) {
                    case 1: {
                        n10 += 1000;
                        while (false) {
                        }
                        break;
                    }
                    case 2: {
                        n10 += 2000;
                        break;
                    }
                    case 3: {
                        n10 += 3000;
                        break;
                    }
                    case 4: {
                        n10 += 4000;
                        break;
                    }
                    case 5: {
                        n10 += 5000;
                    }
                }
            }
            if (Math.random() < d5) {
                if (n10 > 0 && a2.getMonsterPoint() >= (long)n10) {
                    if (a2.getBossLogReload(MerchItemPackage.ALLATORIxDEMO("\u627f\u6ecb\u6be3\u65d1\u9ef2\u654c")) < 1) {
                        a2.setBossLog(MTSCSPacket.ALLATORIxDEMO("\u6276\u6ed5\u6bea\u65cf\u9efb\u6552"));
                        MapleCharacter mapleCharacter = a2;
                        mapleCharacter.dropMessage(-1, "\u4eca\u65e5\u7d2f\u8a08\u5df2\u7372\u5f97:" + mapleCharacter.getMonsterPoint() + "\u9ede" + (String)(n10 > 0 ? (String)object2 + "(MAX:" + n10 + "\u9ede/\u5929),\u7121\u6cd5\u518d\u7372\u5f97\u66f4\u591a\u9ede\u6578\u3002" : ""));
                        return;
                    }
                } else {
                    MapleCharacter mapleCharacter;
                    if (GameSetConstants.MobDropPOINT_LEVEL && (GameSetConstants.SERVER_NAME.equals(MerchItemPackage.ALLATORIxDEMO("\u7cbd\u7d29\u8c03")) ? a2.getLevel() - 20 > a32.getLevel() : (GameSetConstants.SERVER_NAME.equals(MTSCSPacket.ALLATORIxDEMO("\u5903\u4f5a\u8c1d")) ? a32.getLevel() < 70 : a2.getLevel() + 10 < a32.getLevel() || a2.getLevel() - 10 > a32.getLevel()))) {
                        return;
                    }
                    if (GameSetConstants.PHONE_PRIZE_LIMIT && !a2.isPhoneVerified()) {
                        a2.dropMessage(-1, MerchItemPackage.ALLATORIxDEMO("\u609c\u53c6\u9734\u7dbf\u907a\u6267\u6a6b\u9a7b\u8b7d\u0000\u5c05\u53c3\u4ed1\u735e\u5fa3\u627f\u601e\u9ef2\u654c\u54ca\u0015"));
                        return;
                    }
                    int a32 = Randomizer.rand((int)GameSetConstants.MobDropPOINT[0], (int)(GameSetConstants.MobDropPOINT[1] + (double)(GameSetConstants.VIPMONSTERPOINT_ADD * a2.getVip())));
                    if (GameSetConstants.MobDropPOINT[2] == 3.0) {
                        int n11 = a32 + a2.getPoints();
                        MapleCharacter mapleCharacter2 = a2;
                        mapleCharacter = mapleCharacter2;
                        mapleCharacter2.setPoints(n11);
                    } else {
                        MapleCharacter mapleCharacter3 = a2;
                        mapleCharacter = mapleCharacter3;
                        mapleCharacter3.modifyCSPoints((int)GameSetConstants.MobDropPOINT[2], a32);
                    }
                    mapleCharacter.addMonsterPoint(a32);
                    a2.dropMessage(-1, "\u4f60\u5f9e\u602a\u7269\u8eab\u4e0a\u7372\u5f97 [" + a32 + "]\u9ede" + (String)object2 + ",\u4eca\u65e5\u7d2f\u8a08\u7372\u5f97:" + a2.getMonsterPoint() + "\u9ede" + (String)(n10 > 0 ? (String)object2 + "(MAX:" + n10 + "\u9ede/\u5929)" : ""));
                }
            }
        }
    }

    public final /* synthetic */ void startSimpleMapEffect(String a2, int a3) {
        MapleMap a4;
        a4.broadcastMessage(MaplePacketCreator.startMapEffect(a2, a3, true));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<MapleCharacter> getCharactersIntersect(Rectangle a2) {
        MapleMap a3;
        ArrayList<MapleCharacter> arrayList = new ArrayList<MapleCharacter>();
        a3.ia.readLock().lock();
        try {
            for (MapleCharacter mapleCharacter : a3.La) {
                if (!mapleCharacter.getBounds().intersects(a2)) continue;
                arrayList.add(mapleCharacter);
            }
            return arrayList;
        }
        finally {
            a3.ia.readLock().unlock();
        }
    }

    public final /* synthetic */ void setStreetName(String a2) {
        a.A = a2;
    }

    public /* synthetic */ MaplePortal getRandomPortal() {
        MapleMap a2;
        return a2.Da.values().iterator().next();
    }

    public /* synthetic */ void setForceMob(MapleMonster a2) {
        a.ha = a2;
    }

    public final /* synthetic */ int getHPDec() {
        MapleMap a2;
        return a2.Ha;
    }

    public final /* synthetic */ void setReturnMapId(int a2) {
        a.u = a2;
    }

    public final /* synthetic */ void setDrops(boolean a2) {
        a.S = a2;
    }

    public /* synthetic */ void startSpeedRun() {
        MapleMap a2;
        MapleSquad mapleSquad = a2.getSquadByMap();
        if (mapleSquad != null) {
            for (MapleCharacter mapleCharacter : a2.getCharactersThreadsafe()) {
                if (!mapleCharacter.getName().equals(mapleSquad.getLeaderName())) continue;
                a2.startSpeedRun(mapleCharacter.getName());
                return;
            }
        }
    }

    public final /* synthetic */ boolean canSkill() {
        MapleMap a2;
        return !a2.o;
    }

    public final /* synthetic */ void setFieldLimit(int a2) {
        a.x = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleMonster> getAllMonstersThreadsafe() {
        MapleMap a2;
        ArrayList<MapleMonster> arrayList = new ArrayList<MapleMonster>();
        a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.MONSTER).values()) {
                arrayList.add((MapleMonster)mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleMapObject> getAllDoorsThreadsafe() {
        MapleMap a2;
        ArrayList<MapleMapObject> arrayList = new ArrayList<MapleMapObject>();
        a2.ka.get((Object)MapleMapObjectType.DOOR).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.DOOR).values()) {
                arrayList.add(mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.DOOR).readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ List<MapleMapObject> getAllHiredFishingThreadsafe() {
        MapleMap a2;
        ArrayList<MapleMapObject> arrayList = new ArrayList<MapleMapObject>();
        a2.ka.get((Object)MapleMapObjectType.HIRED_FISHING).readLock().lock();
        try {
            for (MapleMapObject mapleMapObject : a2.aa.get((Object)MapleMapObjectType.HIRED_FISHING).values()) {
                arrayList.add(mapleMapObject);
            }
            return arrayList;
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.HIRED_FISHING).readLock().unlock();
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleReactor a2) {
        MapleMap a3;
        MapleReactor mapleReactor = a2;
        mapleReactor.setState((byte)0);
        mapleReactor.setAlive(true);
        a3.spawnReactor(mapleReactor);
    }

    public final /* synthetic */ void spawnFamiliar(final MonsterFamiliar a2) {
        MapleMap a3;
        a3.ALLATORIxDEMO(a2, new DelayedPacketCreation(){
            {
                14 a3;
            }

            @Override
            public /* synthetic */ void sendPackets(MapleClient a22) {
                14 a3;
                if (a3.a2 != null && a22.getPlayer() != null) {
                    a22.sendPacket(MaplePacketCreator.spawnFamiliar(a3.a2, true));
                }
            }
        }, null);
    }

    public /* synthetic */ int characterSize() {
        MapleMap a2;
        return a2.La.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ boolean hasBoss() {
        MapleMap a2;
        ArrayList<MapleMonster> arrayList = new ArrayList<MapleMonster>();
        a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().lock();
        try {
            for (MapleMapObject object : a2.aa.get((Object)MapleMapObjectType.MONSTER).values()) {
                arrayList.add((MapleMonster)object);
            }
        }
        finally {
            a2.ka.get((Object)MapleMapObjectType.MONSTER).readLock().unlock();
        }
        boolean bl = false;
        for (MapleMonster mapleMonster : arrayList) {
            if (!mapleMonster.getStats().isBoss()) continue;
            bl = true;
            return true;
        }
        return bl;
    }

    public final /* synthetic */ void resetFully(boolean a2) {
        MapleMap a3;
        MapleMap mapleMap = a3;
        mapleMap.killAllMonsters(false);
        mapleMap.reloadReactors();
        mapleMap.removeDrops();
        mapleMap.resetNPCs();
        mapleMap.resetSpawns();
        mapleMap.resetDisconnected();
        mapleMap.endSpeedRun();
        mapleMap.cancelSquadSchedule();
        mapleMap.resetPortals();
        mapleMap.Ca.clear();
        if (mapleMap.j != null && !a3.j.isCancelled()) {
            a3.j.cancel(true);
            a3.j = null;
        }
        if (a2 && a3.getId() != 802000821) {
            a3.respawn(true);
        }
    }

    private static interface SpawnCondition {
        public /* synthetic */ boolean canSpawn(MapleCharacter var1);
    }

    private static interface DelayedPacketCreation {
        public /* synthetic */ void sendPackets(MapleClient var1);
    }

    private class ActivateItemReactor
    implements Runnable {
        private /* synthetic */ MapleClient d;
        public final /* synthetic */ MapleMap ALLATORIxDEMO;
        private /* synthetic */ MapleMapItem K;
        private /* synthetic */ MapleReactor a;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public /* synthetic */ void run() {
            ActivateItemReactor a2;
            if (a2.K != null) {
                ActivateItemReactor activateItemReactor = a2;
                if (activateItemReactor.K == activateItemReactor.ALLATORIxDEMO.getMapObject(a2.K.getObjectId(), a2.K.getType())) {
                    if (a2.K.isPickedUp()) {
                        a2.a.setTimerActive(false);
                        return;
                    }
                    ActivateItemReactor activateItemReactor2 = a2;
                    ActivateItemReactor activateItemReactor3 = a2;
                    activateItemReactor2.K.expire(activateItemReactor3.ALLATORIxDEMO);
                    activateItemReactor2.a.hitReactor(a2.d);
                    activateItemReactor3.a.setTimerActive(false);
                    if (activateItemReactor2.a.getDelay() <= 0) return;
                    Timer.MapTimer.getInstance().schedule(new Runnable(){

                        @Override
                        public /* synthetic */ void run() {
                            1 a2;
                            a2.ActivateItemReactor.this.a.forceHitReactor((byte)0);
                        }
                        {
                            1 a3;
                        }
                    }, a2.a.getDelay());
                    return;
                }
            }
            a2.a.setTimerActive(false);
        }

        public /* synthetic */ ActivateItemReactor(MapleMap mapleMap, MapleMapItem a2, MapleReactor a3, MapleClient a4) {
            ActivateItemReactor a5;
            ActivateItemReactor activateItemReactor = a5;
            a5.ALLATORIxDEMO = mapleMap;
            a5.K = a2;
            activateItemReactor.a = a3;
            activateItemReactor.d = a4;
        }
    }
}

