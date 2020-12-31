/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 */
package server.events;

import client.MapleCharacter;
import client.PlayerRandomStream;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import client.messages.commands.player.\u738b\u4e4b\u8c37;
import handling.channel.handler.NPCHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import server.RandomRewards;
import server.Timer;
import server.events.MapleEvent;
import tools.MaplePacketCreator;
import tools.wztosql.DumpItemsAdditions;

public class MapleCoconut
extends MapleEvent {
    private final /* synthetic */ List<MapleCoconuts> k;
    private /* synthetic */ int d;
    private /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int[] K;
    private /* synthetic */ int a;

    @Override
    public /* synthetic */ void onMapLoad(MapleCharacter a2) {
        MapleCoconut a3;
        a2.getClient().sendPacket(MaplePacketCreator.coconutScore(a3.getCoconutScore()));
    }

    public /* synthetic */ void stopCoconut() {
        MapleCoconut a2;
        --a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void addMapleScore() {
        MapleCoconut a2;
        a2.K[0] = a2.K[0] + 1;
    }

    @Override
    public /* synthetic */ void reset() {
        MapleCoconut a2;
        MapleCoconut mapleCoconut = a2;
        super.reset();
        mapleCoconut.resetCoconutScore();
    }

    public /* synthetic */ void resetCoconutScore() {
        int n2;
        MapleCoconut a2;
        MapleCoconut mapleCoconut = a2;
        mapleCoconut.K[0] = 0;
        mapleCoconut.K[1] = 0;
        mapleCoconut.a = 80;
        a2.d = 1001;
        a2.ALLATORIxDEMO = 20;
        a2.k.clear();
        int n3 = n2 = 0;
        while (n3 < 506) {
            a2.k.add(new MapleCoconuts());
            n3 = ++n2;
        }
    }

    public /* synthetic */ int getFalling() {
        MapleCoconut a2;
        return a2.d;
    }

    public /* synthetic */ void setHittable(boolean a2) {
        MapleCoconut a3;
        Iterator<MapleCoconuts> iterator;
        Iterator<MapleCoconuts> iterator2 = iterator = a3.k.iterator();
        while (iterator2.hasNext()) {
            iterator.next().setHittable(a2);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ MapleCoconuts getCoconut(int a2) {
        MapleCoconut a3;
        return a3.k.get(a2);
    }

    public /* synthetic */ int getMapleScore() {
        MapleCoconut a2;
        return a2.K[0];
    }

    public /* synthetic */ void addStoryScore() {
        MapleCoconut a2;
        a2.K[1] = a2.K[1] + 1;
    }

    public /* synthetic */ int[] getCoconutScore() {
        MapleCoconut a2;
        return a2.K;
    }

    public /* synthetic */ int getStoryScore() {
        MapleCoconut a2;
        return a2.K[1];
    }

    public /* synthetic */ List<MapleCoconuts> getAllCoconuts() {
        MapleCoconut a2;
        return a2.k;
    }

    public /* synthetic */ void bombCoconut() {
        MapleCoconut a2;
        --a2.a;
    }

    @Override
    public /* synthetic */ void unreset() {
        MapleCoconut a2;
        MapleCoconut mapleCoconut = a2;
        super.unreset();
        mapleCoconut.resetCoconutScore();
        mapleCoconut.setHittable(false);
    }

    public /* synthetic */ int getBombings() {
        MapleCoconut a2;
        return a2.a;
    }

    public /* synthetic */ int getStopped() {
        MapleCoconut a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MapleCoconut(int a2, int a3, int[] a4) {
        MapleCoconut a5;
        MapleCoconut mapleCoconut = a5;
        MapleCoconut mapleCoconut2 = a5;
        super(a2, a3, a4);
        MapleCoconut mapleCoconut3 = a5;
        mapleCoconut3.k = new LinkedList<MapleCoconuts>();
        mapleCoconut2.K = new int[2];
        mapleCoconut2.a = 0;
        mapleCoconut.d = 0;
        mapleCoconut.ALLATORIxDEMO = 0;
    }

    public /* synthetic */ void bonusTime() {
        MapleCoconut a2;
        a2.getMap(0).broadcastMessage(MaplePacketCreator.getClock(120));
        Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                2 a2;
                if (a2.MapleCoconut.this.getMapleScore() == a2.MapleCoconut.this.getStoryScore()) {
                    Iterator<MapleCharacter> iterator;
                    Iterator<MapleCharacter> iterator2 = iterator = a2.MapleCoconut.this.getMap(0).getCharactersThreadsafe().iterator();
                    while (iterator2.hasNext()) {
                        MapleCharacter mapleCharacter = iterator.next();
                        iterator2 = iterator;
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        mapleCharacter2.getClient().sendPacket(MaplePacketCreator.showEffect(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0018<\u0018$\te\u001e%\u001e%\u0013?\te\u0011%\u000e/")));
                        mapleCharacter2.getClient().sendPacket(MaplePacketCreator.playSound(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"dqDqIkS1a\u007fNrBz")));
                    }
                    a2.MapleCoconut.this.warpOut();
                    return;
                }
                if (a2.MapleCoconut.this.getMapleScore() > a2.MapleCoconut.this.getStoryScore()) {
                    Iterator<MapleCharacter> iterator = a2.MapleCoconut.this.getMap(0).getCharactersThreadsafe().iterator();
                    while (iterator.hasNext()) {
                        MapleCharacter mapleCharacter;
                        MapleCharacter mapleCharacter3 = mapleCharacter = iterator.next();
                        if (mapleCharacter.getCoconutTeam() == 0) {
                            mapleCharacter3.getClient().sendPacket(MaplePacketCreator.showEffect(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"/\u000b/\u0013>R)\u0012)\u0012$\b>R<\u0014)\t%\u000f3")));
                            mapleCharacter.getClient().sendPacket(MaplePacketCreator.playSound(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"]H}HpRj\bHN}SqUg")));
                            continue;
                        }
                        mapleCharacter3.getClient().sendPacket(MaplePacketCreator.showEffect(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0018<\u0018$\te\u001e%\u001e%\u0013?\te\u0011%\u000e/")));
                        mapleCharacter.getClient().sendPacket(MaplePacketCreator.playSound(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"dqDqIkS1a\u007fNrBz")));
                    }
                    a2.MapleCoconut.this.warpOut();
                    return;
                }
                for (MapleCharacter mapleCharacter : a2.MapleCoconut.this.getMap(0).getCharactersThreadsafe()) {
                    if (mapleCharacter.getCoconutTeam() == 1) {
                        MapleCharacter mapleCharacter4 = mapleCharacter;
                        mapleCharacter4.getClient().sendPacket(MaplePacketCreator.showEffect(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"/\u000b/\u0013>R)\u0012)\u0012$\b>R<\u0014)\t%\u000f3")));
                        mapleCharacter4.getClient().sendPacket(MaplePacketCreator.playSound(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"]H}HpRj\bHN}SqUg")));
                        continue;
                    }
                    MapleCharacter mapleCharacter5 = mapleCharacter;
                    mapleCharacter5.getClient().sendPacket(MaplePacketCreator.showEffect(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0018<\u0018$\te\u001e%\u001e%\u0013?\te\u0011%\u000e/")));
                    mapleCharacter5.getClient().sendPacket(MaplePacketCreator.playSound(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"dqDqIkS1a\u007fNrBz")));
                }
                a2.MapleCoconut.this.warpOut();
            }
            {
                2 a3;
            }
        }, 120000L);
    }

    public /* synthetic */ void warpOut() {
        MapleCoconut a2;
        a2.setHittable(false);
        Timer.EventTimer.getInstance().schedule(new Runnable(){
            {
                3 a3;
            }

            @Override
            public /* synthetic */ void run() {
                3 a2;
                Iterator<MapleCharacter> iterator;
                Iterator<MapleCharacter> iterator2 = iterator = a2.MapleCoconut.this.getMap(0).getCharactersThreadsafe().iterator();
                while (iterator2.hasNext()) {
                    MapleCharacter mapleCharacter = iterator.next();
                    if (a2.MapleCoconut.this.getMapleScore() > a2.MapleCoconut.this.getStoryScore() && mapleCharacter.getCoconutTeam() == 0 || a2.MapleCoconut.this.getStoryScore() > a2.MapleCoconut.this.getMapleScore() && mapleCharacter.getCoconutTeam() == 1) {
                        mapleCharacter.gainItem(RandomRewards.getInstance().getCoconutReward());
                    }
                    a2.MapleCoconut.this.warpBack(mapleCharacter);
                    iterator2 = iterator;
                }
                a2.MapleCoconut.this.unreset();
            }
        }, 12000L);
    }

    public /* synthetic */ void fallCoconut() {
        MapleCoconut a2;
        --a2.d;
    }

    @Override
    public /* synthetic */ void startEvent() {
        MapleCoconut a2;
        MapleCoconut mapleCoconut = a2;
        MapleCoconut mapleCoconut2 = a2;
        a2.reset();
        mapleCoconut2.setHittable(true);
        mapleCoconut2.getMap(0).broadcastMessage(MaplePacketCreator.getErrorNotice(PlayerRandomStream.ALLATORIxDEMO("\u6d68\u529a\u95d8\u5984rn")));
        mapleCoconut.getMap(0).broadcastMessage(MaplePacketCreator.hitCoconut(true, 0, 0));
        mapleCoconut.getMap(0).broadcastMessage(MaplePacketCreator.getClock(360));
        Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                1 a2;
                if (a2.MapleCoconut.this.getMapleScore() == a2.MapleCoconut.this.getStoryScore()) {
                    a2.MapleCoconut.this.bonusTime();
                    return;
                }
                if (a2.MapleCoconut.this.getMapleScore() > a2.MapleCoconut.this.getStoryScore()) {
                    for (MapleCharacter mapleCharacter : a2.MapleCoconut.this.getMap(0).getCharactersThreadsafe()) {
                        if (mapleCharacter.getCoconutTeam() == 0) {
                            MapleCharacter mapleCharacter2 = mapleCharacter;
                            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.showEffect(DumpItemsAdditions.ALLATORIxDEMO(",P,H=\t*I*I'S=\t?O*R&T0")));
                            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.playSound(NPCHandler.ALLATORIxDEMO("@\b`\bm\u0012wHU\u000e`\u0013l\u0015z")));
                            continue;
                        }
                        MapleCharacter mapleCharacter3 = mapleCharacter;
                        mapleCharacter3.getClient().sendPacket(MaplePacketCreator.showEffect(DumpItemsAdditions.ALLATORIxDEMO("C?C'RfE&E&H<RfJ&U,")));
                        mapleCharacter3.getClient().sendPacket(MaplePacketCreator.playSound(NPCHandler.ALLATORIxDEMO("$l\u0004l\tv\u0013,!b\u000eo\u0002g")));
                    }
                    a2.MapleCoconut.this.warpOut();
                    return;
                }
                for (MapleCharacter mapleCharacter : a2.MapleCoconut.this.getMap(0).getCharactersThreadsafe()) {
                    if (mapleCharacter.getCoconutTeam() == 1) {
                        MapleCharacter mapleCharacter4 = mapleCharacter;
                        mapleCharacter4.getClient().sendPacket(MaplePacketCreator.showEffect(DumpItemsAdditions.ALLATORIxDEMO(",P,H=\t*I*I'S=\t?O*R&T0")));
                        mapleCharacter4.getClient().sendPacket(MaplePacketCreator.playSound(NPCHandler.ALLATORIxDEMO("@\b`\bm\u0012wHU\u000e`\u0013l\u0015z")));
                        continue;
                    }
                    MapleCharacter mapleCharacter5 = mapleCharacter;
                    mapleCharacter5.getClient().sendPacket(MaplePacketCreator.showEffect(DumpItemsAdditions.ALLATORIxDEMO("C?C'RfE&E&H<RfJ&U,")));
                    mapleCharacter5.getClient().sendPacket(MaplePacketCreator.playSound(NPCHandler.ALLATORIxDEMO("$l\u0004l\tv\u0013,!b\u000eo\u0002g")));
                }
                a2.MapleCoconut.this.warpOut();
            }
            {
                1 a3;
            }
        }, 360000L);
    }

    public static class MapleCoconuts {
        private /* synthetic */ long ALLATORIxDEMO;
        private /* synthetic */ boolean a;
        private /* synthetic */ int K;
        private /* synthetic */ boolean d;

        public /* synthetic */ void resetHits() {
            a.K = 0;
        }

        public /* synthetic */ long getHitTime() {
            MapleCoconuts a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ void setHittable(boolean a2) {
            a.a = a2;
        }

        public /* synthetic */ MapleCoconuts() {
            MapleCoconuts a2;
            MapleCoconuts mapleCoconuts = a2;
            a2.K = 0;
            mapleCoconuts.a = 0;
            mapleCoconuts.d = false;
            mapleCoconuts.ALLATORIxDEMO = System.currentTimeMillis();
        }

        public /* synthetic */ void hit() {
            MapleCoconuts a2;
            a2.ALLATORIxDEMO = System.currentTimeMillis() + 1000L;
            ++a2.K;
        }

        public /* synthetic */ int getHits() {
            MapleCoconuts a2;
            return a2.K;
        }

        public /* synthetic */ void setStopped(boolean a2) {
            a.d = a2;
        }

        public /* synthetic */ boolean isHittable() {
            MapleCoconuts a2;
            return a2.a;
        }

        public /* synthetic */ boolean isStopped() {
            MapleCoconuts a2;
            return a2.d;
        }
    }
}

