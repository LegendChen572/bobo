/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import client.MapleCharacter;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import server.MerchItemPackage;
import server.RandomRewards;
import server.Randomizer;
import server.Timer;
import server.events.MapleEvent;
import server.swing.autoupdate.GetSelfDocName;
import tools.MaplePacketCreator;

public class MapleOla
extends MapleEvent {
    private /* synthetic */ long a;
    private /* synthetic */ int[] ALLATORIxDEMO;
    private transient /* synthetic */ ScheduledFuture<?> d;
    private static final /* synthetic */ long k = 845748150824L;
    private final /* synthetic */ long K = 600000L;

    @Override
    public /* synthetic */ void startEvent() {
        MapleOla a2;
        MapleOla mapleOla = a2;
        mapleOla.unreset();
        super.reset();
        mapleOla.broadcast(MaplePacketCreator.getClock(600));
        a2.a = System.currentTimeMillis();
        Timer.EventTimer eventTimer = Timer.EventTimer.getInstance();
        Runnable runnable = new Runnable(){

            @Override
            public /* synthetic */ void run() {
                1 a2;
                int n2;
                int n3 = n2 = 0;
                while (n3 < a2.MapleOla.this.mapid.length) {
                    Iterator<MapleCharacter> iterator = a2.MapleOla.this.getMap(n2).getCharactersThreadsafe().iterator();
                    while (iterator.hasNext()) {
                        Iterator<MapleCharacter> iterator2;
                        MapleCharacter mapleCharacter = iterator2.next();
                        iterator = iterator2;
                        a2.MapleOla.this.warpBack(mapleCharacter);
                    }
                    a2.MapleOla.this.unreset();
                    n3 = ++n2;
                }
            }
            {
                1 a3;
            }
        };
        Objects.requireNonNull(a2);
        a2.d = eventTimer.schedule(runnable, 600000L);
        a2.broadcast(MaplePacketCreator.serverNotice(MerchItemPackage.ALLATORIxDEMO("\u6d17\u52e1\u5dde\u7da7\u95a7\u59ff\uff20\u8aff\u9036\u907a\u4e01\u95a7\u76a8\u5151\u53cf\u95bf\u59e7\u907e\u621e\u3036")));
    }

    public /* synthetic */ long getTime() {
        return 600000L;
    }

    public /* synthetic */ boolean isTimerStarted() {
        MapleOla a2;
        return a2.a > 0L;
    }

    public /* synthetic */ long getTimeLeft() {
        MapleOla a2;
        return 600000L - (System.currentTimeMillis() - a2.a);
    }

    public /* synthetic */ boolean isCharCorrect(String a22, int a3) {
        int n2;
        String string;
        MapleOla a4;
        int a22 = a4.ALLATORIxDEMO[a3 % 10 - 1];
        if (a22 < 10) {
            string = GetSelfDocName.ALLATORIxDEMO("9");
            n2 = a22;
        } else {
            string = "";
            n2 = a22;
        }
        return a22.equals("ch" + string + n2);
    }

    public /* synthetic */ MapleOla(int a2, int a3, int[] a4) {
        MapleOla a5;
        MapleOla mapleOla = a5;
        super(a2, a3, a4);
        a5.K = 600000L;
        mapleOla.a = 0L;
        mapleOla.ALLATORIxDEMO = new int[3];
    }

    @Override
    public /* synthetic */ void finished(MapleCharacter a2) {
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.gainItem(RandomRewards.getInstance().getOlaReward());
        mapleCharacter.finishAchievement(21);
    }

    public /* synthetic */ void resetSchedule() {
        MapleOla a2;
        a2.a = 0L;
        if (a2.d != null) {
            a2.d.cancel(false);
        }
        a2.d = null;
    }

    @Override
    public /* synthetic */ void reset() {
        MapleOla a2;
        MapleOla mapleOla = a2;
        super.reset();
        mapleOla.resetSchedule();
        a2.getMap(0).getPortal(GetSelfDocName.ALLATORIxDEMO("\u000ef\rgT9")).setPortalState(false);
        int[] arrn = new int[3];
        arrn[0] = 0;
        arrn[1] = 0;
        arrn[2] = 0;
        a2.ALLATORIxDEMO = arrn;
    }

    @Override
    public /* synthetic */ void unreset() {
        MapleOla a2;
        MapleOla mapleOla = a2;
        super.unreset();
        mapleOla.resetSchedule();
        a2.getMap(0).getPortal(MerchItemPackage.ALLATORIxDEMO("F[EZ\u001c\u0004")).setPortalState(true);
        int[] arrn = new int[3];
        arrn[0] = Randomizer.nextInt(5);
        arrn[1] = Randomizer.nextInt(8);
        arrn[2] = Randomizer.nextInt(15);
        a2.ALLATORIxDEMO = arrn;
    }

    @Override
    public /* synthetic */ void onMapLoad(MapleCharacter a2) {
        MapleOla a3;
        if (a3.isTimerStarted()) {
            a2.getClient().sendPacket(MaplePacketCreator.getClock((int)(a3.getTimeLeft() / 1000L)));
        }
    }
}

