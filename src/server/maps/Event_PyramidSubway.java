/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 */
package server.maps;

import client.MapleCharacter;
import client.MapleQuestStatus;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import handling.channel.ChannelServer;
import handling.world.CharacterIdChannelPair;
import handling.world.MaplePartyCharacter;
import java.awt.Point;
import java.util.concurrent.ScheduledFuture;
import server.Randomizer;
import server.Timer;
import server.life.MapleLifeFactory;
import server.maps.MapleMap;
import server.quest.MapleQuest;
import tools.MaplePacketCreator;

public class Event_PyramidSubway {
    private /* synthetic */ int B;
    private /* synthetic */ int k;
    private /* synthetic */ ScheduledFuture<?> d;
    private /* synthetic */ int H;
    private /* synthetic */ int E;
    private /* synthetic */ ScheduledFuture<?> a;
    private /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;
    private /* synthetic */ boolean K;
    private /* synthetic */ int e;
    private /* synthetic */ int g;

    public /* synthetic */ Event_PyramidSubway(final MapleCharacter a2) {
        MapleCharacter mapleCharacter;
        Event_PyramidSubway a3;
        Event_PyramidSubway event_PyramidSubway = a3;
        Event_PyramidSubway event_PyramidSubway2 = a3;
        Event_PyramidSubway event_PyramidSubway3 = a3;
        event_PyramidSubway3.H = 0;
        event_PyramidSubway3.e = 0;
        event_PyramidSubway2.E = 0;
        event_PyramidSubway2.g = 0;
        event_PyramidSubway.k = 100;
        event_PyramidSubway.K = false;
        int n2 = a2.getMapId();
        if (n2 / 10000 == 91032) {
            mapleCharacter = a2;
            a3.B = -1;
        } else {
            a3.B = n2 % 10000 / 1000;
            mapleCharacter = a2;
        }
        if (mapleCharacter.getParty() == null || a2.getParty().getLeader().equals(new MaplePartyCharacter(a2))) {
            a3.commenceTimerNextMap(a2, 1);
            a3.a = Timer.MapTimer.getInstance().register(new Runnable(){

                @Override
                public /* synthetic */ void run() {
                    1 v2;
                    1 a22;
                    1 v0 = a22;
                    v0.Event_PyramidSubway.this.k -= v0.a2.getParty() != null && a22.a2.getParty().getMembers().size() > 1 ? 10 : 5;
                    if (a22.Event_PyramidSubway.this.K) {
                        1 v1 = a22;
                        v2 = v1;
                        v1.a2.getMap().respawn(true);
                    } else {
                        1 v3 = a22;
                        v2 = v3;
                        v3.Event_PyramidSubway.this.K = true;
                    }
                    if (v2.Event_PyramidSubway.this.k <= 0) {
                        1 v4 = a22;
                        v4.Event_PyramidSubway.this.fail(v4.a2);
                    }
                }
                {
                    1 a3;
                }
            }, 1000L);
        }
    }

    private static final /* synthetic */ void ALLATORIxDEMO(MapleMap a2, boolean a3) {
        if (a3 && a2.getCharactersSize() > 0) {
            return;
        }
        a2.resetFully(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean warpStartPyramid(MapleCharacter a2, int a32) {
        int n2;
        MapleCharacter mapleCharacter;
        int n3 = 926010100 + a32 * 1000;
        int n4 = 40;
        int n5 = 60;
        switch (a32) {
            case 1: {
                n4 = 45;
                mapleCharacter = a2;
                break;
            }
            case 2: {
                n4 = 50;
                mapleCharacter = a2;
                break;
            }
            case 3: {
                n4 = 61;
                n5 = 200;
            }
            default: {
                mapleCharacter = a2;
            }
        }
        ChannelServer a32 = mapleCharacter.getClient().getChannelServer();
        int n6 = n2 = 0;
        while (n6 < 5) {
            MapleMap mapleMap = a32.getMapFactory().getMap(n3 + n2);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap2 = mapleMap;
                Event_PyramidSubway.ALLATORIxDEMO(mapleMap2, false);
                Event_PyramidSubway.ALLATORIxDEMO(a2, mapleMap2, n4, n5, 0);
                return true;
            }
            n6 = ++n2;
        }
        return false;
    }

    public final /* synthetic */ void commenceTimerNextMap(final MapleCharacter a2, int a3) {
        Event_PyramidSubway a4;
        if (a4.d != null) {
            a4.d.cancel(false);
            a4.d = null;
        }
        if (a4.ALLATORIxDEMO != null) {
            a4.ALLATORIxDEMO.cancel(false);
            a4.ALLATORIxDEMO = null;
        }
        MapleMap mapleMap = a2.getMap();
        int n2 = (a4.B == -1 ? 180 : (a3 == 1 ? 240 : 300)) - 1;
        if (a2.getParty() != null && a2.getParty().getMembers().size() > 1) {
            for (MaplePartyCharacter object : a2.getParty().getMembers()) {
                MapleCharacter mapleCharacter = mapleMap.getCharacterById(object.getId());
                if (mapleCharacter == null) continue;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.getClient().sendPacket(MaplePacketCreator.getClock(n2));
                mapleCharacter2.getClient().sendPacket(MaplePacketCreator.showEffect("killing/first/number/" + a3));
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.getClient().sendPacket(MaplePacketCreator.showEffect(CharacterIdChannelPair.ALLATORIxDEMO("\u001a3\u001d6\u00184\u0016u\u00173\u0003)\u0005u\u0002.\u0010=\u0014")));
                mapleCharacter3.getClient().sendPacket(MaplePacketCreator.showEffect(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u001f$\u0018!\u001d#\u0013b\u0012$\u0006>\u0000b\u00079\u0015?\u0000")));
                a4.fullUpdate(mapleCharacter3, a3);
            }
        } else {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.getClock(n2));
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.showEffect("killing/first/number/" + a3));
            MapleCharacter mapleCharacter4 = a2;
            mapleCharacter4.getClient().sendPacket(MaplePacketCreator.showEffect(CharacterIdChannelPair.ALLATORIxDEMO("\u001a3\u001d6\u00184\u0016u\u00173\u0003)\u0005u\u0002.\u0010=\u0014")));
            mapleCharacter4.getClient().sendPacket(MaplePacketCreator.showEffect(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u001f$\u0018!\u001d#\u0013b\u0012$\u0006>\u0000b\u00079\u0015?\u0000")));
            a4.fullUpdate(mapleCharacter4, a3);
        }
        if (a4.B != -1 && (a3 == 4 || a3 == 5)) {
            MapleCharacter mapleCharacter = a2;
            Point point = mapleCharacter.getPosition();
            MapleMap mapleMap2 = mapleCharacter.getMap();
            a4.ALLATORIxDEMO = Timer.MapTimer.getInstance().register(new Runnable(){
                public final /* synthetic */ MapleMap K;
                public final /* synthetic */ int a;
                public final /* synthetic */ Event_PyramidSubway ALLATORIxDEMO;
                public final /* synthetic */ Point d;
                {
                    2 a3;
                    2 v0 = a3;
                    v0.ALLATORIxDEMO = a2;
                    v0.K = mapleMap;
                    a3.a = n2;
                    a3.d = point;
                }

                @Override
                public /* synthetic */ void run() {
                    2 a2;
                    if (a2.K.countMonsterById(9300021) <= (a2.a == 4 ? 1 : 2)) {
                        a2.K.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9300021), new Point(a2.d));
                    }
                }
            }, 10000L);
        }
        a4.d = Timer.MapTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                boolean bl;
                3 a22;
                boolean bl2 = false;
                if (a22.Event_PyramidSubway.this.B == -1) {
                    bl = bl2 = Event_PyramidSubway.warpNextMap_Subway(a22.a2);
                } else {
                    3 v1 = a22;
                    bl = bl2 = Event_PyramidSubway.warpNextMap_Pyramid(v1.a2, v1.Event_PyramidSubway.this.B);
                }
                if (!bl) {
                    3 v2 = a22;
                    v2.Event_PyramidSubway.this.fail(v2.a2);
                }
            }
            {
                3 a3;
            }
        }, (long)n2 * 1000L);
    }

    public final /* synthetic */ void broadcastUpdate(MapleCharacter a2) {
        Event_PyramidSubway a3;
        MapleCharacter mapleCharacter = a2;
        MapleMap mapleMap = mapleCharacter.getMap();
        if (mapleCharacter.getParty() != null && a2.getParty().getMembers().size() > 1) {
            for (MaplePartyCharacter maplePartyCharacter : a2.getParty().getMembers()) {
                MapleCharacter serializable = mapleMap.getCharacterById(maplePartyCharacter.getId());
                if (serializable == null) continue;
                serializable.getClient().sendPacket(MaplePacketCreator.sendPyramidUpdate(a3.k));
            }
        } else {
            a2.getClient().sendPacket(MaplePacketCreator.sendPyramidUpdate(a3.k));
        }
    }

    public final /* synthetic */ void dispose(MapleCharacter a2) {
        Event_PyramidSubway a3;
        boolean bl;
        boolean bl2 = bl = a3.a != null && a3.d != null;
        if (a3.a != null) {
            a3.a.cancel(false);
            a3.a = null;
        }
        if (a3.d != null) {
            a3.d.cancel(false);
            a3.d = null;
        }
        if (a3.ALLATORIxDEMO != null) {
            a3.ALLATORIxDEMO.cancel(false);
            a3.ALLATORIxDEMO = null;
        }
        if (a2.getParty() != null && bl && a2.getParty().getMembers().size() > 1) {
            a3.fail(a2);
            return;
        }
        a2.setPyramidSubway(null);
    }

    public static /* synthetic */ boolean warpStartSubway(MapleCharacter a2) {
        int n2;
        int n3 = 910320100;
        ChannelServer channelServer = a2.getClient().getChannelServer();
        int n4 = n2 = 0;
        while (n4 < 5) {
            MapleMap mapleMap = channelServer.getMapFactory().getMap(910320100 + n2);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap2 = mapleMap;
                Event_PyramidSubway.ALLATORIxDEMO(mapleMap2, false);
                Event_PyramidSubway.ALLATORIxDEMO(a2, mapleMap2, 25, 30, 0);
                return true;
            }
            n4 = ++n2;
        }
        return false;
    }

    public final /* synthetic */ void broadcastEffect(MapleCharacter a2, String a3) {
        a2.getClient().sendPacket(MaplePacketCreator.showEffect(a3));
    }

    private static final /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, MapleMap a3, int a4, int a5, int a6) {
        MapleCharacter mapleCharacter;
        MapleCharacter mapleCharacter2 = a2;
        MapleMap mapleMap = mapleCharacter2.getMap();
        if (mapleCharacter2.getParty() != null && a2.getParty().getMembers().size() > 1) {
            for (MaplePartyCharacter maplePartyCharacter : a2.getParty().getMembers()) {
                MapleCharacter mapleCharacter3;
                MapleCharacter serializable = mapleMap.getCharacterById(maplePartyCharacter.getId());
                if (serializable == null || serializable.getId() == a2.getId() || serializable.getLevel() < a4 || serializable.getLevel() > a5) continue;
                if (a6 == 1) {
                    MapleCharacter mapleCharacter4 = serializable;
                    mapleCharacter3 = mapleCharacter4;
                    mapleCharacter4.getClient().sendPacket(MaplePacketCreator.showEffect(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u001f$\u0018!\u001d#\u0013b\u0017!\u0011,\u0006")));
                } else {
                    if (a6 == 2) {
                        serializable.getClient().sendPacket(MaplePacketCreator.showEffect(CharacterIdChannelPair.ALLATORIxDEMO("1\u00186\u001d3\u001f=^<\u00103\u001d")));
                    }
                    mapleCharacter3 = serializable;
                }
                MapleMap mapleMap2 = a3;
                mapleCharacter3.changeMap(mapleMap2, mapleMap2.getPortal(0));
            }
        }
        if (a6 == 1) {
            MapleCharacter mapleCharacter5 = a2;
            mapleCharacter = mapleCharacter5;
            mapleCharacter5.getClient().sendPacket(MaplePacketCreator.showEffect(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u001f$\u0018!\u001d#\u0013b\u0017!\u0011,\u0006")));
        } else {
            if (a6 == 2) {
                a2.getClient().sendPacket(MaplePacketCreator.showEffect(CharacterIdChannelPair.ALLATORIxDEMO("1\u00186\u001d3\u001f=^<\u00103\u001d")));
            }
            mapleCharacter = a2;
        }
        MapleMap mapleMap3 = a3;
        mapleCharacter.changeMap(mapleMap3, mapleMap3.getPortal(0));
    }

    public static /* synthetic */ boolean warpBonusSubway(MapleCharacter a2) {
        int n2;
        int n3 = 910320010;
        ChannelServer channelServer = a2.getClient().getChannelServer();
        int n4 = n2 = 0;
        while (n4 < 20) {
            MapleMap mapleMap = channelServer.getMapFactory().getMap(910320010 + n2);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap2 = mapleMap;
                Event_PyramidSubway.ALLATORIxDEMO(mapleMap2, false);
                a2.changeMap(mapleMap2, mapleMap.getPortal(0));
                return true;
            }
            n4 = ++n2;
        }
        return false;
    }

    public final /* synthetic */ boolean onSkillUse(MapleCharacter a2) {
        Event_PyramidSubway a3;
        if (a3.g > 0 && a3.B != -1) {
            Event_PyramidSubway event_PyramidSubway = a3;
            --event_PyramidSubway.g;
            event_PyramidSubway.broadcastEnergy(a2, CharacterIdChannelPair.ALLATORIxDEMO("7\u0010)\u0002;\u0012(\u0014\u0005\u00021\u00186\u001d"), a3.g);
            return true;
        }
        return false;
    }

    public final /* synthetic */ void onChangeMap(MapleCharacter a2, int a3) {
        Event_PyramidSubway a4;
        if (a3 == 910330001 && a4.B == -1 || a3 == 926020001 + a4.B && a4.B != -1) {
            a4.succeed(a2);
            return;
        }
        if (a4.B == -1 && (a3 < 910320100 || a3 > 910320304)) {
            a4.dispose(a2);
            return;
        }
        if (a4.B != -1 && (a3 < 926010100 || a3 > 926013504)) {
            a4.dispose(a2);
            return;
        }
        if (a2.getParty() == null || a2.getParty().getLeader().equals(new MaplePartyCharacter(a2))) {
            a4.k = 100;
            a4.commenceTimerNextMap(a2, a3 % 1000 / 100);
        }
    }

    public final /* synthetic */ void fail(MapleCharacter a2) {
        MapleMap mapleMap;
        MapleCharacter mapleCharacter;
        Event_PyramidSubway a3;
        if (a3.B == -1) {
            MapleCharacter mapleCharacter2 = a2;
            mapleCharacter = mapleCharacter2;
            mapleMap = mapleCharacter2.getClient().getChannelServer().getMapFactory().getMap(910320001);
        } else {
            MapleCharacter mapleCharacter3 = a2;
            mapleCharacter = mapleCharacter3;
            mapleMap = mapleCharacter3.getClient().getChannelServer().getMapFactory().getMap(926010001 + a3.B);
        }
        Event_PyramidSubway.ALLATORIxDEMO(mapleCharacter, mapleMap, 1, 200, 2);
        a3.dispose(a2);
    }

    public static /* synthetic */ boolean warpBonusPyramid(MapleCharacter a2, int a3) {
        int n2;
        a3 = 926010010 + a3 * 20;
        ChannelServer channelServer = a2.getClient().getChannelServer();
        int n3 = n2 = 0;
        while (n3 < 20) {
            MapleMap mapleMap = channelServer.getMapFactory().getMap(a3 + n2);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap2 = mapleMap;
                Event_PyramidSubway.ALLATORIxDEMO(mapleMap2, false);
                a2.changeMap(mapleMap2, mapleMap.getPortal(0));
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public final /* synthetic */ void broadcastEnergy(MapleCharacter a2, String a3, int a4) {
        a2.getClient().sendPacket(MaplePacketCreator.sendPyramidEnergy(a3, String.valueOf(a4)));
    }

    public final /* synthetic */ void fullUpdate(MapleCharacter a2, int a3) {
        Event_PyramidSubway a4;
        MapleCharacter mapleCharacter = a2;
        a4.broadcastEnergy(mapleCharacter, CharacterIdChannelPair.ALLATORIxDEMO("7\u0010)\u0002;\u0012(\u0014\u0005\u0001;\u0003.\b"), mapleCharacter.getParty() == null ? 0 : a2.getParty().getMembers().size());
        Event_PyramidSubway event_PyramidSubway = a4;
        MapleCharacter mapleCharacter2 = a2;
        Event_PyramidSubway event_PyramidSubway2 = a4;
        MapleCharacter mapleCharacter3 = a2;
        a4.broadcastEnergy(mapleCharacter3, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0019,\u0007>\u0015.\u0006(+ \u001d>\u0007"), a4.E);
        event_PyramidSubway2.broadcastEnergy(mapleCharacter3, CharacterIdChannelPair.ALLATORIxDEMO("\u001c;\u0002)\u00109\u0003?.9\u001e5\u001d"), a4.e);
        event_PyramidSubway2.broadcastEnergy(a2, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)" \u0015>\u0007,\u0017?\u0011\u0012\u0007&\u001d!\u0018"), a4.g);
        a4.broadcastEnergy(mapleCharacter2, CharacterIdChannelPair.ALLATORIxDEMO("7\u0010)\u0002;\u0012(\u0014\u0005\u001d;\u0002.\u0002.\u0010=\u0014"), a3 - 1);
        event_PyramidSubway.broadcastEnergy(mapleCharacter2, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)" \u0015>\u0007,\u0017?\u0011\u0012\u001c$\u0000"), a4.H);
        event_PyramidSubway.broadcastUpdate(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void succeed(MapleCharacter a2) {
        Event_PyramidSubway a3;
        MapleQuestStatus mapleQuestStatus = a2.getQuestNAdd(MapleQuest.getInstance(a3.B == -1 ? 7662 : 7760));
        String string = mapleQuestStatus.getCustomData();
        if (string == null) {
            MapleQuestStatus mapleQuestStatus2 = mapleQuestStatus;
            mapleQuestStatus2.setCustomData(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"D"));
            string = mapleQuestStatus2.getCustomData();
        }
        byte by = Integer.parseInt(string);
        Event_PyramidSubway event_PyramidSubway = a3;
        int n2 = a3.H + event_PyramidSubway.e;
        mapleQuestStatus.setCustomData(String.valueOf(by + n2));
        by = 4;
        if (event_PyramidSubway.B == -1) {
            if (n2 >= 2000) {
                by = 0;
            } else if (n2 >= 1500 && n2 <= 1999) {
                by = 1;
            } else if (n2 >= 1000 && n2 <= 1499) {
                by = 2;
            } else if (n2 >= 500 && n2 <= 999) {
                by = 3;
            }
        } else if (n2 >= 3000) {
            by = 0;
        } else if (n2 >= 2000 && n2 <= 2999) {
            by = 1;
        } else if (n2 >= 1500 && n2 <= 1999) {
            by = 2;
        } else if (n2 >= 500 && n2 <= 1499) {
            by = 3;
        }
        n2 = 0;
        block0 : switch (a3.B) {
            case 0: {
                switch (by) {
                    case 0: {
                        n2 = 60500;
                        break block0;
                    }
                    case 1: {
                        n2 = 55000;
                        break block0;
                    }
                    case 2: {
                        n2 = 46750;
                        break block0;
                    }
                    case 3: {
                        n2 = 22000;
                        break block0;
                    }
                }
                break;
            }
            case 1: {
                switch (by) {
                    case 0: {
                        n2 = 66000;
                        break block0;
                    }
                    case 1: {
                        n2 = 60000;
                        break block0;
                    }
                    case 2: {
                        n2 = 51750;
                        break block0;
                    }
                    case 3: {
                        n2 = 24000;
                        break block0;
                    }
                }
                break;
            }
            case 2: {
                switch (by) {
                    case 0: {
                        n2 = 71500;
                        break block0;
                    }
                    case 1: {
                        n2 = 65000;
                        break block0;
                    }
                    case 2: {
                        n2 = 55250;
                        break block0;
                    }
                    case 3: {
                        n2 = 26000;
                        break block0;
                    }
                }
                break;
            }
            case 3: {
                switch (by) {
                    case 0: {
                        n2 = 77000;
                        break block0;
                    }
                    case 1: {
                        n2 = 70000;
                        break block0;
                    }
                    case 2: {
                        n2 = 59500;
                        break block0;
                    }
                    case 3: {
                        n2 = 28000;
                        break block0;
                    }
                }
                break;
            }
            default: {
                switch (by) {
                    case 0: {
                        n2 = 22000;
                        break block0;
                    }
                    case 1: {
                        n2 = 17000;
                        break block0;
                    }
                    case 2: {
                        n2 = 10750;
                        break block0;
                    }
                    case 3: {
                        n2 = 7000;
                        break block0;
                    }
                }
            }
        }
        int n3 = 0;
        if (by < 4) {
            MapleCharacter mapleCharacter = a2;
            n3 = (int)((double)(a3.H * 2 + a3.e * 10 + n2) * mapleCharacter.getClient().getChannelServer().getExpRate(a2.getWorld()));
            mapleCharacter.gainExp(n3, true, false, false);
        }
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.showEffect(CharacterIdChannelPair.ALLATORIxDEMO("\u001a3\u001d6\u00184\u0016u\u00126\u0014;\u0003")));
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.sendPyramidResult(by, n3));
        a3.dispose(a2);
    }

    public final /* synthetic */ void onMiss(MapleCharacter a2) {
        Event_PyramidSubway a3;
        Event_PyramidSubway event_PyramidSubway = a3;
        Event_PyramidSubway event_PyramidSubway2 = a3;
        ++event_PyramidSubway2.E;
        event_PyramidSubway2.k -= 5;
        event_PyramidSubway.broadcastUpdate(a2);
        event_PyramidSubway.broadcastEnergy(a2, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0019,\u0007>\u0015.\u0006(+ \u001d>\u0007"), a3.E);
    }

    public static /* synthetic */ boolean warpNextMap_Pyramid(MapleCharacter a2, int a3) {
        MapleCharacter mapleCharacter = a2;
        int n2 = (mapleCharacter.getMapId() - (926010100 + a3 * 1000)) / 100;
        MapleMap mapleMap = mapleCharacter.getMap();
        Event_PyramidSubway.ALLATORIxDEMO(mapleMap, true);
        ChannelServer channelServer = mapleCharacter.getClient().getChannelServer();
        if (n2 >= 4) {
            mapleMap = channelServer.getMapFactory().getMap(926020001 + a3);
            Event_PyramidSubway.ALLATORIxDEMO(a2, mapleMap, 1, 200, 1);
            return true;
        }
        a3 = 926010100 + (n2 + 1) * 100 + a3 * 1000;
        int n3 = n2 = 0;
        while (n3 < 5) {
            mapleMap = channelServer.getMapFactory().getMap(a3 + n2);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap2 = mapleMap;
                Event_PyramidSubway.ALLATORIxDEMO(mapleMap2, false);
                Event_PyramidSubway.ALLATORIxDEMO(a2, mapleMap2, 1, 200, 1);
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 5 << 1;
        int cfr_ignored_0 = 4 << 4 ^ (2 ^ 5) << 1;
        int n5 = n3;
        int n6 = 4 << 3 ^ 4;
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

    public static /* synthetic */ boolean warpNextMap_Subway(MapleCharacter a2) {
        int n2;
        MapleCharacter mapleCharacter = a2;
        int n3 = (mapleCharacter.getMapId() - 910320100) / 100;
        MapleMap mapleMap = mapleCharacter.getMap();
        Event_PyramidSubway.ALLATORIxDEMO(mapleMap, true);
        ChannelServer channelServer = mapleCharacter.getClient().getChannelServer();
        if (n3 >= 2) {
            mapleMap = channelServer.getMapFactory().getMap(910330001);
            Event_PyramidSubway.ALLATORIxDEMO(a2, mapleMap, 1, 200, 1);
            return true;
        }
        n3 = 910320100 + (n3 + 1) * 100;
        int n4 = n2 = 0;
        while (n4 < 5) {
            mapleMap = channelServer.getMapFactory().getMap(n3 + n2);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap2 = mapleMap;
                Event_PyramidSubway.ALLATORIxDEMO(mapleMap2, false);
                Event_PyramidSubway.ALLATORIxDEMO(a2, mapleMap2, 1, 200, 1);
                return true;
            }
            n4 = ++n2;
        }
        return false;
    }

    public final /* synthetic */ void onKill(MapleCharacter a2) {
        Event_PyramidSubway a3;
        ++a3.H;
        if (Randomizer.nextInt(100) < 5) {
            Event_PyramidSubway event_PyramidSubway = a3;
            ++event_PyramidSubway.e;
            event_PyramidSubway.broadcastEnergy(a2, CharacterIdChannelPair.ALLATORIxDEMO("\u001c;\u0002)\u00109\u0003?.9\u001e5\u001d"), a3.e);
        }
        Event_PyramidSubway event_PyramidSubway = a3;
        event_PyramidSubway.k += 5;
        if (event_PyramidSubway.k > 100) {
            a3.k = 100;
        }
        if (a3.B != -1) {
            Event_PyramidSubway event_PyramidSubway2;
            block6: {
                int n2;
                int n3 = n2 = 5;
                while (n3 >= 1) {
                    Event_PyramidSubway event_PyramidSubway3 = a3;
                    if ((event_PyramidSubway3.H + event_PyramidSubway3.e) % (n2 * 100) == 0 && Randomizer.nextInt(100) < 50) {
                        a3.broadcastEffect(a2, "killing/yeti" + (n2 - 1));
                        event_PyramidSubway2 = a3;
                        break block6;
                    }
                    n3 = --n2;
                }
                event_PyramidSubway2 = a3;
            }
            if ((event_PyramidSubway2.H + a3.e) % 500 == 0) {
                Event_PyramidSubway event_PyramidSubway4 = a3;
                ++event_PyramidSubway4.g;
                event_PyramidSubway4.broadcastEnergy(a2, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)" \u0015>\u0007,\u0017?\u0011\u0012\u0007&\u001d!\u0018"), a3.g);
            }
        }
        MapleCharacter mapleCharacter = a2;
        a3.broadcastUpdate(mapleCharacter);
        a3.broadcastEnergy(mapleCharacter, CharacterIdChannelPair.ALLATORIxDEMO("7\u0010)\u0002;\u0012(\u0014\u0005\u00193\u0005"), a3.H);
    }
}

