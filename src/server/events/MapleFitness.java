/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import FuckingHackerToby.Rb;
import client.MapleCharacter;
import handling.channel.handler.PartyHandler;
import handling.channel.handler.StatsHandling;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import server.RandomRewards;
import server.Timer;
import server.events.MapleEvent;
import tools.MaplePacketCreator;
import tools.database.UniqueIdReset;

public class MapleFitness
extends MapleEvent {
    private /* synthetic */ ScheduledFuture<?> d;
    private final /* synthetic */ long K = 720000L;
    private static final /* synthetic */ long k = 845748950824L;
    private /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;
    private /* synthetic */ long a;

    public /* synthetic */ MapleFitness(int a2, int a3, int[] a4) {
        MapleFitness a5;
        MapleFitness mapleFitness = a5;
        super(a2, a3, a4);
        mapleFitness.K = 720000L;
        mapleFitness.a = 0L;
    }

    @Override
    public /* synthetic */ void reset() {
        MapleFitness a2;
        MapleFitness mapleFitness = a2;
        MapleFitness mapleFitness2 = a2;
        super.reset();
        mapleFitness2.resetSchedule();
        mapleFitness.getMap(0).getPortal(Rb.ALLATORIxDEMO("\u000eL\rMT\u0013")).setPortalState(false);
        mapleFitness.getMap(0).getPortal(PartyHandler.ALLATORIxDEMO("1\rhS")).setPortalState(false);
    }

    public /* synthetic */ boolean isTimerStarted() {
        MapleFitness a2;
        return a2.a > 0L;
    }

    public /* synthetic */ long getTimeLeft() {
        MapleFitness a2;
        return 720000L - (System.currentTimeMillis() - a2.a);
    }

    public /* synthetic */ long getTime() {
        return 720000L;
    }

    public /* synthetic */ void resetSchedule() {
        MapleFitness a2;
        a2.a = 0L;
        if (a2.d != null) {
            a2.d.cancel(false);
        }
        a2.d = null;
        if (a2.ALLATORIxDEMO != null) {
            a2.ALLATORIxDEMO.cancel(false);
        }
        a2.ALLATORIxDEMO = null;
    }

    @Override
    public /* synthetic */ void unreset() {
        MapleFitness a2;
        MapleFitness mapleFitness = a2;
        MapleFitness mapleFitness2 = a2;
        super.unreset();
        mapleFitness2.resetSchedule();
        mapleFitness.getMap(0).getPortal(Rb.ALLATORIxDEMO("\u000eL\rMT\u0013")).setPortalState(true);
        mapleFitness.getMap(0).getPortal(PartyHandler.ALLATORIxDEMO("1\rhS")).setPortalState(true);
    }

    public /* synthetic */ void checkAndMessage() {
        MapleFitness a2;
        a2.ALLATORIxDEMO = Timer.EventTimer.getInstance().register(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                2 a2;
                long l2 = a2.MapleFitness.this.getTimeLeft();
                if (l2 > 9000L && l2 < 11000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(UniqueIdReset.ALLATORIxDEMO("\u4f66\u90e3\u670fV6\u79b5\u5de0\u5394\u7682\u6625\u9595\uff6b\u90a5\u4efc\u4f66\u4e6a\u80fb\u64ad\u6551\u76e3\u73af\u5bd1\uff0a\u6276\u5e0a\u677c\u4f66\u4e6c\u6b27\u8d68\u5f91\u52ba\u522f\uff6b\u56d8\u984a\u898d\u3065")));
                    return;
                }
                if (l2 > 11000L && l2 < 101000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(StatsHandling.ALLATORIxDEMO("\u5906\u5409\uff77\u4f4e\u5212\u4e25\u6ce9\u6727\u5961\u5c3f\u6639\u95bd\u4efd\uff22\u8ab0\u62bd\u7db1\u666c\u95e8\u8873\u546a\u7d6c\u9ea5\u302c")));
                    return;
                }
                if (l2 > 101000L && l2 < 241000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(UniqueIdReset.ALLATORIxDEMO("\u907e\u5df4\u7df4\u6629\u6767\u5f8a\u4ee1\u4e0b\u89e6\u6538\u68a3\uff0a\u8c37\u5bca\u76e3\u5921\u7329\u7b4f\u8430\u4f66\uff66")));
                    return;
                }
                if (l2 > 241000L && l2 < 301000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(StatsHandling.ALLATORIxDEMO("\u9062\u8ddd\u5bf7\u5c1f\u5212\u4e25\u4e7b\u96a0\u4efd\u528e\u6cc2\uff2f")));
                    return;
                }
                if (l2 > 301000L && l2 < 361000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(UniqueIdReset.ALLATORIxDEMO("\u8acd\u5c68\u5fc5\u63ee\u843b\u3065")));
                    return;
                }
                if (l2 > 361000L && l2 < 501000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(StatsHandling.ALLATORIxDEMO("\u8ab0\u5c21\u5fb8f+\u6b56\u968d\u302c")));
                    return;
                }
                if (l2 > 501000L && l2 < 601000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(UniqueIdReset.ALLATORIxDEMO("\u8acd\u5c68\u5fc5\u7353\u5b56\u3065")));
                    return;
                }
                if (l2 > 601000L && l2 < 661000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(StatsHandling.ALLATORIxDEMO("\u7b57\u4ea2\u96f5\u76aa\u62fb\u5dc9\u8ab0\u5207\u7553\u731a\u5b2b\u302c")));
                    return;
                }
                if (l2 > 661000L && l2 < 701000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(UniqueIdReset.ALLATORIxDEMO("\u8acd\u5c68\u5fc5/V\u6b1f\u96f0\u3065")));
                    return;
                }
                if (l2 > 701000L && l2 < 781000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(StatsHandling.ALLATORIxDEMO("\u5909\u5bcd\u77cb\u9028\u000e \u7d6c\u690e\u5fe3\u806bs[\u5fa6\u5906\u7387\u76ff\uff2f")));
                    return;
                }
                if (l2 > 781000L && l2 < 841000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(UniqueIdReset.ALLATORIxDEMO("\u670f\u5388\u80fb\u6764\u5c09+G \u4e06\u4e6c\u4e0b\u9029\u4e0b\u9767\u8987\u64b3\u5fc5\u3065")));
                    return;
                }
                if (l2 > 841000L) {
                    a2.MapleFitness.this.broadcast(MaplePacketCreator.serverNotice(StatsHandling.ALLATORIxDEMO("u\u7d39\u695b\u5fb6\u803e&\u000e\u7e46\u515f\u6772\u56f5\u96f5\uff22\u59f9\u67b2\u4f1b\u789e\u5d9c\u5706\u9031\u621c\u9035\u7a25\u4e56\u6b55\u4eda\uff22\u4f1b\u672d\u5fe5\u9064\u6249\u4e03\u6df3\u591f\uff77\u626e\u4e9e\u8ae5\u6c93\u6121\u9062\u4e2e\u9ea5\u302c")));
                }
            }
            {
                2 a3;
            }
        }, 90000L);
    }

    @Override
    public /* synthetic */ void onMapLoad(MapleCharacter a2) {
        MapleFitness a3;
        if (a3.isTimerStarted()) {
            a2.getClient().sendPacket(MaplePacketCreator.getClock((int)(a3.getTimeLeft() / 1000L)));
        }
    }

    @Override
    public /* synthetic */ void startEvent() {
        MapleFitness a2;
        MapleFitness mapleFitness = a2;
        MapleFitness mapleFitness2 = a2;
        a2.unreset();
        super.reset();
        mapleFitness2.broadcast(MaplePacketCreator.getClock(720));
        mapleFitness2.a = System.currentTimeMillis();
        mapleFitness.checkAndMessage();
        Timer.EventTimer eventTimer = Timer.EventTimer.getInstance();
        Runnable runnable = new Runnable(){

            @Override
            public /* synthetic */ void run() {
                1 a2;
                int n2;
                int n3 = n2 = 0;
                while (n3 < a2.MapleFitness.this.mapid.length) {
                    Iterator<MapleCharacter> iterator = a2.MapleFitness.this.getMap(n2).getCharactersThreadsafe().iterator();
                    while (iterator.hasNext()) {
                        Iterator<MapleCharacter> iterator2;
                        MapleCharacter mapleCharacter = iterator2.next();
                        iterator = iterator2;
                        a2.MapleFitness.this.warpBack(mapleCharacter);
                    }
                    n3 = ++n2;
                }
                a2.MapleFitness.this.unreset();
            }
            {
                1 a3;
            }
        };
        Objects.requireNonNull(a2);
        mapleFitness.d = eventTimer.schedule(runnable, 720000L);
        mapleFitness.broadcast(MaplePacketCreator.serverNotice(PartyHandler.ALLATORIxDEMO("\u6d63\u52b6\u5daa\u7df0\u95d3\u59a8\uff54\u8aa8\u9042\u902d\u4e75\u95f0\u76dc\u5106\u53bb\u95e8\u5993\u9029\u626a\u3061")));
    }

    @Override
    public /* synthetic */ void finished(MapleCharacter a2) {
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.gainItem(RandomRewards.getInstance().getFitnessReward());
        mapleCharacter.finishAchievement(20);
    }
}

