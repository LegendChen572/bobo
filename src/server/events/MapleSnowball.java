/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import client.MapleCharacter;
import handling.opcodes.MapleBuffStat;
import handling.world.MapleMessengerCharacter;
import handling.world.family.MapleFamilyCharacter;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import server.RandomRewards;
import server.Timer;
import server.events.MapleEvent;
import server.events.MapleEventType;
import server.life.MobSkillFactory;
import server.maps.MapleMap;
import tools.MaplePacketCreator;

public class MapleSnowball
extends MapleEvent {
    private final /* synthetic */ MapleSnowballs[] ALLATORIxDEMO;

    public /* synthetic */ void makeSnowBall(int a2) {
        MapleSnowball a3;
        MapleSnowball mapleSnowball = a3;
        mapleSnowball.resetSnowBall(a2);
        int n2 = a2;
        int n3 = a2;
        mapleSnowball.ALLATORIxDEMO[n3] = new MapleSnowballs(n3);
    }

    public /* synthetic */ void resetSnowBall(int a2) {
        a.ALLATORIxDEMO[a2] = null;
    }

    @Override
    public /* synthetic */ void startEvent() {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 2) {
            MapleSnowball a2;
            MapleSnowballs mapleSnowballs = a2.getSnowBall(n2);
            MapleSnowball mapleSnowball = a2;
            MapleSnowballs mapleSnowballs2 = mapleSnowballs;
            mapleSnowballs2.broadcast(a2.getMap(0), 0);
            mapleSnowballs2.setInvis(0 != 0);
            mapleSnowballs.broadcast(mapleSnowball.getMap(0), 5);
            mapleSnowball.getMap(0).broadcastMessage(MaplePacketCreator.enterSnowBall());
            n3 = ++n2;
        }
    }

    @Override
    public /* synthetic */ void reset() {
        MapleSnowball a2;
        MapleSnowball mapleSnowball = a2;
        super.reset();
        mapleSnowball.makeSnowBall(0);
        mapleSnowball.makeSnowBall(1);
    }

    public /* synthetic */ MapleSnowball(int a2, int a3, int[] a4) {
        super(a2, a3, a4);
        MapleSnowball a5;
        a5.ALLATORIxDEMO = new MapleSnowballs[2];
    }

    @Override
    public /* synthetic */ void unreset() {
        int n2;
        MapleSnowball a2;
        super.unreset();
        int n3 = n2 = 0;
        while (n3 < 2) {
            MapleSnowball mapleSnowball = a2;
            mapleSnowball.getSnowBall(n2++).resetSchedule();
            mapleSnowball.resetSnowBall(n2);
            n3 = n2;
        }
    }

    public /* synthetic */ MapleSnowballs getSnowBall(int a2) {
        MapleSnowball a3;
        return a3.ALLATORIxDEMO[a2];
    }

    public static class MapleSnowballs {
        private /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;
        private /* synthetic */ boolean K;
        private /* synthetic */ boolean a;
        private /* synthetic */ int g;
        private /* synthetic */ int k;
        private final /* synthetic */ int B;
        private /* synthetic */ int d;

        public /* synthetic */ MapleSnowballs(int a2) {
            MapleSnowballs a3;
            MapleSnowballs mapleSnowballs = a3;
            MapleSnowballs mapleSnowballs2 = a3;
            MapleSnowballs mapleSnowballs3 = a3;
            a3.g = 0;
            mapleSnowballs3.k = 0;
            mapleSnowballs3.K = true;
            mapleSnowballs2.a = true;
            mapleSnowballs2.d = 7500;
            mapleSnowballs.ALLATORIxDEMO = null;
            mapleSnowballs.B = a2;
        }

        public /* synthetic */ void setInvis(boolean a2) {
            a.K = a2;
        }

        public /* synthetic */ int getRightX() {
            MapleSnowballs a2;
            return a2.getLeftX() + 275;
        }

        public /* synthetic */ boolean isInvis() {
            MapleSnowballs a2;
            return a2.K;
        }

        public /* synthetic */ void setHittable(boolean a2) {
            a.a = a2;
        }

        public /* synthetic */ void broadcast(MapleMap a2, int a3) {
            Iterator<MapleCharacter> iterator;
            Iterator<MapleCharacter> iterator2 = iterator = a2.getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                MapleSnowballs a4;
                iterator.next().getClient().sendPacket(MaplePacketCreator.snowballMessage(a4.B, a3));
                iterator2 = iterator;
            }
        }

        public /* synthetic */ int getSnowmanHP() {
            MapleSnowballs a2;
            return a2.d;
        }

        public /* synthetic */ void setStartPoint(MapleMap a2) {
            MapleSnowballs a3;
            MapleSnowballs mapleSnowballs = a3;
            ++mapleSnowballs.k;
            mapleSnowballs.broadcast(a2, mapleSnowballs.k);
        }

        public /* synthetic */ void setSnowmanHP(int a2) {
            a.d = a2;
        }

        public /* synthetic */ void setPositionX(int a2) {
            a.g = a2;
        }

        public /* synthetic */ boolean isHittable() {
            MapleSnowballs a2;
            return a2.a && !a2.K;
        }

        public static final /* synthetic */ void hitSnowball(MapleCharacter a2) {
            int n2 = a2.getPosition().y > -80 ? 0 : 1;
            MapleSnowball object2 = (MapleSnowball)a2.getClient().getChannelServer().getEvent(MapleEventType.\u6efe\u96ea\u7403);
            if (object2 == null) {
                return;
            }
            MapleSnowballs mapleSnowballs = object2.getSnowBall(n2);
            if (mapleSnowballs != null && !mapleSnowballs.isInvis()) {
                int n3;
                int n4 = n3 = a2.getPosition().x < -360 && a2.getPosition().x > -560 ? 1 : 0;
                if (n3 == 0) {
                    int n5 = n3 = (Math.random() < 0.01 || a2.getPosition().x > mapleSnowballs.getLeftX() && a2.getPosition().x < mapleSnowballs.getRightX()) && mapleSnowballs.isHittable() ? 10 : 0;
                    a2.getMap().broadcastMessage(MaplePacketCreator.hitSnowBall(n2, n5, 0, 1));
                    if (n5 == 0) {
                        if (Math.random() < 0.2) {
                            MapleCharacter mapleCharacter = a2;
                            mapleCharacter.getClient().sendPacket(MaplePacketCreator.leftKnockBack());
                            mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                    } else {
                        MapleSnowballs mapleSnowballs2 = mapleSnowballs;
                        mapleSnowballs2.setPositionX(mapleSnowballs2.getPosition() + 1);
                        if (mapleSnowballs2.getPosition() == 255 || mapleSnowballs.getPosition() == 511 || mapleSnowballs.getPosition() == 767) {
                            mapleSnowballs.setStartPoint(a2.getMap());
                            a2.getMap().broadcastMessage(MaplePacketCreator.rollSnowball(4, object2.getSnowBall(0), object2.getSnowBall(1)));
                            return;
                        }
                        if (mapleSnowballs.getPosition() == 899) {
                            Iterator<MapleCharacter> iterator;
                            int mapleMap;
                            MapleMap mapleMap2 = a2.getMap();
                            int n6 = mapleMap = 0;
                            while (n6 < 2) {
                                int n7 = mapleMap++;
                                object2.getSnowBall(n7).setInvis(true);
                                mapleMap2.broadcastMessage(MaplePacketCreator.rollSnowball(n7 + 2, object2.getSnowBall(0), object2.getSnowBall(1)));
                                n6 = mapleMap;
                            }
                            a2.getMap().broadcastMessage(MaplePacketCreator.getItemNotice("[\u606d\u559c] " + (n2 == 0 ? MapleMessengerCharacter.ALLATORIxDEMO("\u85c3\u968e") : MapleFamilyCharacter.ALLATORIxDEMO("\u7d21\u96c8")) + " \u8d0f\u5f97\u52dd\u5229!"));
                            Iterator<MapleCharacter> iterator2 = iterator = a2.getMap().getCharactersThreadsafe().iterator();
                            while (iterator2.hasNext()) {
                                MapleCharacter mapleCharacter = iterator.next();
                                if (n2 == 0 && mapleCharacter.getPosition().y > -80 || n2 == 1 && mapleCharacter.getPosition().y <= -80) {
                                    mapleCharacter.gainItem(RandomRewards.getInstance().getSnowBallReward());
                                }
                                object2.warpBack(mapleCharacter);
                                iterator2 = iterator;
                            }
                            object2.unreset();
                            return;
                        }
                        if (mapleSnowballs.getPosition() < 899) {
                            a2.getMap().broadcastMessage(MaplePacketCreator.rollSnowball(4, object2.getSnowBall(0), object2.getSnowBall(1)));
                            mapleSnowballs.setInvis(false);
                            return;
                        }
                    }
                } else if (mapleSnowballs.getPosition() < 899) {
                    n3 = 15;
                    if (Math.random() < 0.3) {
                        n3 = 0;
                    }
                    if (Math.random() < 0.05) {
                        n3 = 45;
                    }
                    a2.getMap().broadcastMessage(MaplePacketCreator.hitSnowBall(n2 + 2, n3, 0, 0));
                    MapleSnowballs mapleSnowballs3 = mapleSnowballs;
                    int n8 = n3;
                    mapleSnowballs3.setSnowmanHP(mapleSnowballs3.getSnowmanHP() - n8);
                    if (n8 > 0) {
                        a2.getMap().broadcastMessage(MaplePacketCreator.rollSnowball(0, object2.getSnowBall(0), object2.getSnowBall(1)));
                        if (mapleSnowballs.getSnowmanHP() <= 0) {
                            MapleSnowballs mapleSnowballs4;
                            mapleSnowballs.setSnowmanHP(7500);
                            MapleSnowballs mapleSnowballs5 = mapleSnowballs4 = object2.getSnowBall(n2 == 0 ? 1 : 0);
                            mapleSnowballs5.setHittable(false);
                            final MapleMap mapleMap = a2.getMap();
                            mapleSnowballs5.broadcast(mapleMap, 4);
                            mapleSnowballs5.ALLATORIxDEMO = Timer.EventTimer.getInstance().schedule(new Runnable(){
                                {
                                    1 a2;
                                }

                                @Override
                                public /* synthetic */ void run() {
                                    1 a2;
                                    1 v0 = a2;
                                    v0.mapleSnowballs4.setHittable(true);
                                    v0.mapleSnowballs4.broadcast(a2.mapleMap, 5);
                                }
                            }, 10000L);
                            for (MapleCharacter mapleCharacter : a2.getMap().getCharactersThreadsafe()) {
                                if ((mapleSnowballs.getTeam() != 0 || a2.getPosition().y >= -80) && (mapleSnowballs.getTeam() != 1 || a2.getPosition().y <= -80)) continue;
                                mapleCharacter.getDiseaseBuff(MapleBuffStat.SEDUCE, MobSkillFactory.getMobSkill(128, 1));
                            }
                        }
                    }
                }
            }
        }

        public /* synthetic */ int getLeftX() {
            MapleSnowballs a2;
            return a2.g * 3 + 175;
        }

        public /* synthetic */ void resetSchedule() {
            MapleSnowballs a2;
            if (a2.ALLATORIxDEMO != null) {
                a2.ALLATORIxDEMO.cancel(false);
                a2.ALLATORIxDEMO = null;
            }
        }

        public /* synthetic */ int getPosition() {
            MapleSnowballs a2;
            return a2.g;
        }

        public /* synthetic */ int getTeam() {
            MapleSnowballs a2;
            return a2.B;
        }
    }
}

