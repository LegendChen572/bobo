/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleClient;
import java.awt.Rectangle;
import scripting.reactor.ReactorScriptManager;
import server.Timer;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMap;
import server.maps.MapleMapObjectType;
import server.maps.MapleReactorStats;
import tools.MaplePacketCreator;
import tools.Pair;

public class MapleReactor
extends AbstractMapleMapObject {
    private /* synthetic */ MapleReactorStats E;
    private /* synthetic */ byte g;
    private /* synthetic */ int e;
    private /* synthetic */ boolean d;
    private /* synthetic */ boolean a;
    private /* synthetic */ int B;
    private /* synthetic */ MapleMap k;
    private /* synthetic */ String K;
    private /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ boolean isTimerActive() {
        MapleReactor a2;
        return a2.a;
    }

    public /* synthetic */ int getDelay() {
        MapleReactor a2;
        return a2.B;
    }

    public /* synthetic */ void setDelay(int a2) {
        a.B = a2;
    }

    public /* synthetic */ void scheduleSetState(final byte a2, final byte a3, long a4) {
        MapleReactor a5;
        Timer.MapTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                3 a22;
                if (a22.MapleReactor.this.g == a22.a2) {
                    3 v0 = a22;
                    v0.MapleReactor.this.forceHitReactor(v0.a3);
                }
            }
            {
                3 a32;
            }
        }, a4);
    }

    public /* synthetic */ void forceHitReactor(byte a2) {
        MapleReactor a3;
        MapleReactor mapleReactor = a3;
        mapleReactor.setState(a2);
        mapleReactor.setTimerActive(false);
        mapleReactor.k.broadcastMessage(MaplePacketCreator.triggerReactor(a3, 0));
    }

    public /* synthetic */ int getReactorType() {
        MapleReactor a2;
        MapleReactor mapleReactor = a2;
        return mapleReactor.E.getType(mapleReactor.g);
    }

    public /* synthetic */ MapleMap getMap() {
        MapleReactor a2;
        return a2.k;
    }

    public /* synthetic */ int getReactorId() {
        MapleReactor a2;
        return a2.e;
    }

    public /* synthetic */ MapleReactor(MapleReactorStats a2, int a3, int a4) {
        MapleReactor a5;
        MapleReactor mapleReactor = a5;
        MapleReactor mapleReactor2 = a5;
        a5.K = "";
        mapleReactor2.E = a2;
        mapleReactor2.e = a3;
        mapleReactor.d = true;
        mapleReactor.ALLATORIxDEMO = a4;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleReactor a3;
        a2.sendPacket(MaplePacketCreator.spawnReactor(a3));
    }

    public /* synthetic */ void setMap(MapleMap a2) {
        a.k = a2;
    }

    public /* synthetic */ byte getTouch() {
        MapleReactor a2;
        MapleReactor mapleReactor = a2;
        return mapleReactor.E.canTouch(mapleReactor.g);
    }

    public /* synthetic */ boolean isAlive() {
        MapleReactor a2;
        return a2.d;
    }

    public /* synthetic */ int getWorld() {
        MapleReactor a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MapleReactorStats getStats() {
        MapleReactor a2;
        return a2.E;
    }

    public /* synthetic */ String toString() {
        MapleReactor a2;
        MapleReactor mapleReactor = a2;
        return "Reactor " + a2.getObjectId() + " of id " + a2.e + " at position " + a2.getPosition().toString() + " state" + mapleReactor.g + " type " + mapleReactor.E.getType(a2.g);
    }

    public /* synthetic */ void setTimerActive(boolean a2) {
        a.a = a2;
    }

    public /* synthetic */ void delayedDestroyReactor(long a2) {
        MapleReactor a3;
        Timer.MapTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                1 a2;
                a2.MapleReactor.this.k.destroyReactor(a2.MapleReactor.this.getObjectId());
            }
            {
                1 a3;
            }
        }, a2);
    }

    public final /* synthetic */ byte getFacingDirection() {
        MapleReactor a2;
        return a2.E.getFacingDirection();
    }

    public /* synthetic */ void setState(byte a2) {
        a.g = a2;
    }

    public /* synthetic */ byte getState() {
        MapleReactor a2;
        return a2.g;
    }

    public /* synthetic */ void forceStartReactor(MapleClient a2) {
        MapleReactor a3;
        ReactorScriptManager.getInstance().act(a2, a3);
    }

    public /* synthetic */ void hitReactor(MapleClient a2) {
        MapleReactor a3;
        a3.hitReactor(0, (short)0, a2);
    }

    public /* synthetic */ void delayedHitReactor(final MapleClient a2, long a3) {
        MapleReactor a4;
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void run() {
                2 a22;
                2 v0 = a22;
                v0.MapleReactor.this.hitReactor(v0.a2);
            }
        }, a3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void hitReactor(int a, short a, MapleClient a) {
        block6: {
            block7: {
                block5: {
                    v0 = a;
                    if (v0.E.getType(v0.g) >= 999) return;
                    v1 = a;
                    if (v1.E.getType(v1.g) == -1) return;
                    v2 = a;
                    var4_4 = v2.g;
                    if (v2.E.getType(a.g) == 2) {
                        if (a == 0) return;
                        if (a == 2) return;
                    }
                    v3 = a;
                    a.g = v3.E.getNextState(a.g);
                    if (v3.E.getNextState(a.g) == -1) break block5;
                    v4 = a;
                    if (v4.E.getType(v4.g) != 999) break block6;
                }
                v5 = a;
                if (v5.E.getType(v5.g) < 100) break block7;
                v6 = a;
                if (v6.E.getType(v6.g) != 999) ** GOTO lbl-1000
            }
            if (a.B > 0) {
                a.k.destroyReactor(a.getObjectId());
            } else lbl-1000:
            // 2 sources

            {
                a.k.broadcastMessage(MaplePacketCreator.triggerReactor(a, a));
            }
            ReactorScriptManager.getInstance().act(a, a);
            return;
        }
        a = 0;
        v7 = a;
        a.k.broadcastMessage(MaplePacketCreator.triggerReactor(v7, a));
        v8 = a;
        if (v7.g == v8.E.getNextState(v8.g) || a.e == 2618000 || a.e == 2309000) {
            ReactorScriptManager.getInstance().act(a, a);
            a = 1;
        }
        v9 = a;
        if (v9.E.getTimeOut(v9.g) <= 0) return;
        if (a == 0) {
            ReactorScriptManager.getInstance().act(a, a);
        }
        v10 = a;
        v11 = a;
        v10.scheduleSetState(v10.g, var4_4, v11.E.getTimeOut(v11.g));
    }

    public /* synthetic */ void setName(String a2) {
        a.K = a2;
    }

    public /* synthetic */ void setAlive(boolean a2) {
        a.d = a2;
    }

    public /* synthetic */ String getName() {
        MapleReactor a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.REACTOR;
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleReactor a3;
        a2.sendPacket(MaplePacketCreator.destroyReactor(a3));
    }

    public /* synthetic */ Rectangle getClickArea() {
        MapleReactor a2;
        MapleReactor mapleReactor = a2;
        MapleReactor mapleReactor2 = a2;
        int n2 = mapleReactor.E.getBR().y - mapleReactor2.E.getTL().y;
        int n3 = mapleReactor.E.getBR().x - a2.E.getTL().x;
        int n4 = mapleReactor2.getPosition().x + a2.E.getTL().x;
        int n5 = mapleReactor.getPosition().y + a2.E.getTL().y + 10;
        return new Rectangle(n4, n5, n3, n2);
    }

    public /* synthetic */ void forceTrigger() {
        MapleReactor a2;
        a2.k.broadcastMessage(MaplePacketCreator.triggerReactor(a2, 0));
    }

    public /* synthetic */ Pair<Integer, Integer> getReactItem() {
        MapleReactor a2;
        MapleReactor mapleReactor = a2;
        return mapleReactor.E.getReactItem(mapleReactor.g);
    }

    public /* synthetic */ Rectangle getArea() {
        MapleReactor a2;
        MapleReactor mapleReactor = a2;
        MapleReactor mapleReactor2 = a2;
        int n2 = mapleReactor.E.getBR().y - mapleReactor2.E.getTL().y;
        int n3 = mapleReactor.E.getBR().x - a2.E.getTL().x;
        int n4 = mapleReactor2.getPosition().x + a2.E.getTL().x;
        int n5 = mapleReactor.getPosition().y + a2.E.getTL().y;
        return new Rectangle(n4, n5, n3, n2);
    }
}

