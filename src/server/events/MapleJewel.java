/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import client.MapleCharacter;
import client.messages.ConsoleCommandObject;
import constants.MobConstants;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import server.RandomRewards;
import server.Timer;
import server.events.MapleEvent;
import tools.MaplePacketCreator;

public class MapleJewel
extends MapleEvent {
    private static final /* synthetic */ long k = 845748950824L;
    private /* synthetic */ ScheduledFuture<?> d;
    private final /* synthetic */ long K = 600000L;
    private /* synthetic */ long a;
    private /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;

    @Override
    public /* synthetic */ void reset() {
        MapleJewel a2;
        MapleJewel mapleJewel = a2;
        super.reset();
        mapleJewel.resetSchedule();
        mapleJewel.getMap(0).getPortal(ConsoleCommandObject.ALLATORIxDEMO("vUuT,\n")).setPortalState(false);
    }

    public /* synthetic */ long getTime() {
        return 600000L;
    }

    public /* synthetic */ MapleJewel(int a2, int a3, int[] a4) {
        MapleJewel a5;
        MapleJewel mapleJewel = a5;
        super(a2, a3, a4);
        mapleJewel.K = 600000L;
        mapleJewel.a = 0L;
    }

    @Override
    public /* synthetic */ void startEvent() {
        MapleJewel a2;
        MapleJewel mapleJewel = a2;
        mapleJewel.unreset();
        super.reset();
        mapleJewel.broadcast(MaplePacketCreator.getClock(600));
        a2.a = System.currentTimeMillis();
        Timer.EventTimer eventTimer = Timer.EventTimer.getInstance();
        Runnable runnable = new Runnable(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void run() {
                1 a2;
                int n2;
                int n3 = n2 = 0;
                while (n3 < a2.MapleJewel.this.mapid.length) {
                    Iterator<MapleCharacter> iterator = a2.MapleJewel.this.getMap(n2).getCharactersThreadsafe().iterator();
                    while (iterator.hasNext()) {
                        MapleCharacter mapleCharacter;
                        MapleCharacter mapleCharacter2 = mapleCharacter = iterator.next();
                        a2.MapleJewel.this.warpBack(mapleCharacter2);
                        if (!mapleCharacter2.haveItem(4031017)) continue;
                        mapleCharacter.removeAll(4031017);
                    }
                    n3 = ++n2;
                }
                a2.MapleJewel.this.unreset();
            }
        };
        Objects.requireNonNull(a2);
        a2.d = eventTimer.schedule(runnable, 600000L);
        a2.broadcast(MaplePacketCreator.serverNotice(MobConstants.ALLATORIxDEMO("\u6d39\u52e1\u5df0\u7da7\u9589\u59ff\uff0e\u8aff\u9018\u907a\u4e2f\u95a7\u7686\u5151\u53e1\u95bf\u59c9\u907e\u6230\u3036")));
    }

    @Override
    public /* synthetic */ void onMapLoad(MapleCharacter a2) {
        MapleJewel a3;
        if (a3.isTimerStarted()) {
            a2.getClient().sendPacket(MaplePacketCreator.getClock((int)(a3.getTimeLeft() / 1000L)));
        }
    }

    public /* synthetic */ long getTimeLeft() {
        MapleJewel a2;
        return 600000L - (System.currentTimeMillis() - a2.a);
    }

    @Override
    public /* synthetic */ void unreset() {
        MapleJewel a2;
        MapleJewel mapleJewel = a2;
        super.unreset();
        mapleJewel.resetSchedule();
        mapleJewel.getMap(0).getPortal(MobConstants.ALLATORIxDEMO("h[kZ2\u0004")).setPortalState(true);
    }

    public /* synthetic */ boolean isTimerStarted() {
        MapleJewel a2;
        return a2.a > 0L;
    }

    @Override
    public /* synthetic */ void finished(MapleCharacter a2) {
        a2.gainItem(RandomRewards.getInstance().getJewelReward());
    }

    public /* synthetic */ void resetSchedule() {
        MapleJewel a2;
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
}

