/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package server.events;

import client.MapleCharacter;
import client.MapleStat;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import server.Timer;
import server.events.MapleEvent;
import server.events.MapleOxQuizFactory;
import server.maps.MapleMap;
import tools.MaplePacketCreator;

public class MapleOxQuiz
extends MapleEvent {
    private /* synthetic */ ScheduledFuture<?> d;
    private /* synthetic */ ScheduledFuture<?> a;
    private /* synthetic */ int ALLATORIxDEMO;

    @Override
    public /* synthetic */ void startEvent() {
        MapleOxQuiz a2;
        a2.sendQuestion();
    }

    @Override
    public /* synthetic */ void unreset() {
        MapleOxQuiz a2;
        MapleOxQuiz mapleOxQuiz = a2;
        super.unreset();
        mapleOxQuiz.getMap(0).getPortal(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0017%\u0014$Mz")).setPortalState(true);
        mapleOxQuiz.ALLATORIxDEMO();
    }

    @Override
    public /* synthetic */ void onMapLoad(MapleCharacter a2) {
        MapleOxQuiz a3;
        if (a2.getMapId() == a3.mapid[0] && !a2.isGM()) {
            a2.canTalk_event(false);
        }
    }

    public /* synthetic */ MapleOxQuiz(int a2, int a3, int[] a4) {
        super(a2, a3, a4);
        MapleOxQuiz a5;
        a5.ALLATORIxDEMO = 0;
    }

    public /* synthetic */ void sendQuestion() {
        MapleOxQuiz a2;
        MapleOxQuiz mapleOxQuiz = a2;
        mapleOxQuiz.sendQuestion(mapleOxQuiz.getMap(0));
    }

    @Override
    public /* synthetic */ void reset() {
        MapleOxQuiz a2;
        MapleOxQuiz mapleOxQuiz = a2;
        super.reset();
        mapleOxQuiz.getMap(0).getPortal(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0017%\u0014$Mz")).setPortalState(false);
        mapleOxQuiz.ALLATORIxDEMO();
        mapleOxQuiz.ALLATORIxDEMO = 0;
    }

    public /* synthetic */ void sendQuestion(final MapleMap a2) {
        MapleOxQuiz a3;
        if (a3.d != null) {
            a3.d.cancel(false);
        }
        a3.d = Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                Object object;
                var a22;
                boolean bl = false;
                int n2 = 9 - a22.MapleOxQuiz.this.ALLATORIxDEMO;
                Object object2 = object = a22.a2.getCharactersThreadsafe().iterator();
                while (object2.hasNext()) {
                    MapleCharacter mapleCharacter = object.next();
                    object2 = object;
                }
                object = MapleOxQuizFactory.getInstance().grabRandomQuestion();
                a22.a2.startMapEffect("OX\u554f\u7b54:" + ((MapleOxQuizFactory.MapleOxQuizEntry)object.getValue()).getQuestion(), 5120003);
                var v1 = a22;
                v1.a2.broadcastMessage(MaplePacketCreator.getClock(12));
                if (v1.MapleOxQuiz.this.a != null) {
                    a22.MapleOxQuiz.this.a.cancel(false);
                }
                a22.MapleOxQuiz.this.a = Timer.EventTimer.getInstance().schedule(new Runnable(){
                    public final /* synthetic */ Map.Entry a;
                    public final /* synthetic */ int d;
                    {
                        1 a3;
                        a3.a = entry;
                        a3.d = n2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        1 a2;
                        a2.a2.startMapEffect("OX\u554f\u7b54:" + ((MapleOxQuizFactory.MapleOxQuizEntry)a2.a.getValue()).getQuestion(), 5120003);
                        a2.MapleOxQuiz.this.ALLATORIxDEMO++;
                        Iterator<MapleCharacter> iterator = a2.a2.getCharactersThreadsafe().iterator();
                        while (iterator.hasNext()) {
                            MapleCharacter mapleCharacter = iterator.next();
                            if (mapleCharacter == null || mapleCharacter.isGM() || !mapleCharacter.isAlive()) continue;
                            if (!a2.MapleOxQuiz.this.ALLATORIxDEMO(mapleCharacter, ((MapleOxQuizFactory.MapleOxQuizEntry)a2.a.getValue()).getAnswer())) {
                                mapleCharacter.getStat().setHp(0);
                                mapleCharacter.updateSingleStat(MapleStat.HP, 0);
                                continue;
                            }
                            mapleCharacter.dropMessage(6, "\u76ee\u524d\u5df2\u7d93\u7b2c:" + a2.MapleOxQuiz.this.ALLATORIxDEMO + "\u984c/\u8ddd\u96e2\u6d3b\u52d5\u7d50\u675f\u9084\u6709:" + a2.d + "\u984c");
                            mapleCharacter.gainExp(3000, true, true, false);
                        }
                        a2.MapleOxQuiz.this.sendQuestion();
                    }
                }, 12000L);
            }
            {
                1 a3;
            }
        }, 10000L);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        MapleOxQuiz a2;
        if (a2.a != null) {
            a2.a.cancel(false);
            a2.a = null;
        }
        if (a2.d != null) {
            a2.d.cancel(false);
            a2.d = null;
        }
    }

    private /* synthetic */ boolean ALLATORIxDEMO(MapleCharacter a2, int a3) {
        MapleCharacter mapleCharacter = a2;
        double d2 = mapleCharacter.getPosition().getX();
        double d3 = mapleCharacter.getPosition().getY();
        if (d2 > -234.0 && d3 > -26.0 && a3 == 0 || d2 < -234.0 && d3 > -26.0 && a3 == 1) {
            a2.dropMessage(6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6027\u55e1\u5694\u7b29\u6b29\u78c7\uff4b"));
            return true;
        }
        a2.dropMessage(6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u5fc2\u62cc\u6b03\u7b29\u9365\u4efb\uff4b"));
        return false;
    }
}

