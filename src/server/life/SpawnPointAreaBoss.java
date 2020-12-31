/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import handling.world.World;
import java.awt.Point;
import java.util.concurrent.atomic.AtomicBoolean;
import server.Randomizer;
import server.life.MapleMonster;
import server.life.MonsterListener;
import server.life.Spawns;
import server.maps.MapleMap;
import tools.MaplePacketCreator;
import tools.Pair;

public class SpawnPointAreaBoss
extends Spawns {
    private final /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ Point H;
    private final /* synthetic */ int e;
    private final /* synthetic */ int E;
    private final /* synthetic */ int K;
    private final /* synthetic */ String d;
    private /* synthetic */ long k;
    private final /* synthetic */ AtomicBoolean a;
    private /* synthetic */ int B;
    private final /* synthetic */ int g;
    private final /* synthetic */ Point C;
    private /* synthetic */ MapleMonster I;
    private final /* synthetic */ Point F;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final /* synthetic */ MapleMonster spawnMonster(MapleMap a2) {
        SpawnPointAreaBoss spawnPointAreaBoss;
        SpawnPointAreaBoss a3;
        SpawnPointAreaBoss spawnPointAreaBoss2 = a3;
        Point point = spawnPointAreaBoss2.getPosition();
        spawnPointAreaBoss2.I = new MapleMonster(a3.I);
        a3.I.setPosition(point);
        spawnPointAreaBoss2.I.setOriginFh(a3.getFh());
        spawnPointAreaBoss2.I.setFh(a3.I.getOriginFh());
        spawnPointAreaBoss2.a.set(true);
        spawnPointAreaBoss2.I.setListener(new MonsterListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void monsterKilled() {
                1 a2;
                1 v0 = a2;
                v0.SpawnPointAreaBoss.this.k = System.currentTimeMillis();
                if (v0.SpawnPointAreaBoss.this.K > 0) {
                    1 v1 = a2;
                    v1.SpawnPointAreaBoss.this.k += v1.SpawnPointAreaBoss.this.K;
                }
                a2.SpawnPointAreaBoss.this.a.set(false);
            }
        });
        a2.spawnMonster(a3.I, -2);
        if (spawnPointAreaBoss2.d != null) {
            if (a3.ALLATORIxDEMO) {
                World.Broadcast.broadcastMessage(MaplePacketCreator.yellowChat("[\u7cfb\u7d71\u63d0\u793a] " + a3.d));
                spawnPointAreaBoss = a3;
                return spawnPointAreaBoss.I;
            }
            a2.broadcastMessage(MaplePacketCreator.getItemNotice(a3.d));
        }
        spawnPointAreaBoss = a3;
        return spawnPointAreaBoss.I;
    }

    @Override
    public final /* synthetic */ int getCarnivalId() {
        return -1;
    }

    @Override
    public final /* synthetic */ byte getCarnivalTeam() {
        return -1;
    }

    @Override
    public final /* synthetic */ Point getPosition() {
        SpawnPointAreaBoss a2;
        a2.B = Randomizer.nextInt(3);
        if (a2.B == 0) {
            return a2.F;
        }
        if (a2.B == 1) {
            return a2.C;
        }
        return a2.H;
    }

    @Override
    public final /* synthetic */ boolean shouldSpawn(MapleMap a2) {
        SpawnPointAreaBoss a3;
        if (a3.K < 0) {
            return false;
        }
        if (a3.a.get()) {
            return false;
        }
        return a3.k <= System.currentTimeMillis();
    }

    @Override
    public final /* synthetic */ int getMobTime() {
        SpawnPointAreaBoss a2;
        return a2.K;
    }

    public /* synthetic */ SpawnPointAreaBoss(MapleMonster a2, Pair<Integer, Point> a3, Pair<Integer, Point> a4, Pair<Integer, Point> a5, int a6, String a7, boolean a8) {
        SpawnPointAreaBoss a9;
        SpawnPointAreaBoss spawnPointAreaBoss = a9;
        a9.B = -1;
        SpawnPointAreaBoss spawnPointAreaBoss2 = a9;
        a9.a = new AtomicBoolean(false);
        spawnPointAreaBoss.I = a2;
        spawnPointAreaBoss.e = a3.getLeft();
        a9.E = a4.getLeft();
        a9.g = a5.getLeft();
        a9.F = a3.getRight();
        a9.C = a4.getRight();
        a9.H = a5.getRight();
        a9.K = a6 < 0 ? -1 : a6 * 1000;
        SpawnPointAreaBoss spawnPointAreaBoss3 = a9;
        spawnPointAreaBoss3.d = a7;
        spawnPointAreaBoss3.k = System.currentTimeMillis();
        spawnPointAreaBoss3.ALLATORIxDEMO = a8;
    }

    @Override
    public final /* synthetic */ int getFh() {
        SpawnPointAreaBoss a2;
        if (a2.B == -1) {
            a2.getPosition();
        }
        int n2 = a2.B == 0 ? a2.e : (a2.B == 1 ? a2.E : a2.g);
        a2.B = -1;
        return n2;
    }

    @Override
    public final /* synthetic */ MapleMonster getMonster() {
        SpawnPointAreaBoss a2;
        return a2.I;
    }
}

