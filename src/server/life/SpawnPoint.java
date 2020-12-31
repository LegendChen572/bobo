/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package server.life;

import client.SkillFactory;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameSetConstants;
import constants.MobConstants;
import java.awt.Point;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import server.MapleCarnivalFactory;
import server.MapleStatEffect;
import server.life.MapleMonster;
import server.life.MonsterListener;
import server.life.Spawns;
import server.maps.MapleMap;
import server.maps.MapleReactor;
import server.maps.MapleSummon;
import tools.MaplePacketCreator;
import tools.Pair;

public class SpawnPoint
extends Spawns {
    private final /* synthetic */ byte d;
    private /* synthetic */ long e;
    private final /* synthetic */ String a;
    private final /* synthetic */ boolean K;
    private final /* synthetic */ Point H;
    private /* synthetic */ int B;
    private /* synthetic */ MapleMonster C;
    private final /* synthetic */ int g;
    private /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int E;
    private final /* synthetic */ AtomicInteger k;

    @Override
    public final /* synthetic */ Point getPosition() {
        SpawnPoint a2;
        return a2.H;
    }

    @Override
    public final /* synthetic */ int getFh() {
        SpawnPoint a2;
        return a2.g;
    }

    @Override
    public final /* synthetic */ byte getCarnivalTeam() {
        SpawnPoint a2;
        return a2.d;
    }

    @Override
    public final /* synthetic */ MapleMonster spawnMonster(MapleMap a2) {
        Object object;
        SpawnPoint a3;
        SpawnPoint spawnPoint = a3;
        SpawnPoint spawnPoint2 = a3;
        a3.C = new MapleMonster(a3.C);
        SpawnPoint spawnPoint3 = a3;
        spawnPoint.C.setPosition(spawnPoint3.H);
        spawnPoint3.C.setOriginFh(a3.g);
        spawnPoint.C.setFh(a3.g);
        spawnPoint.C.setCarnivalTeam(a3.d);
        if (spawnPoint.ALLATORIxDEMO > -1) {
            SpawnPoint spawnPoint4 = a3;
            spawnPoint4.C.changeLevel(spawnPoint4.ALLATORIxDEMO);
        }
        SpawnPoint spawnPoint5 = a3;
        spawnPoint5.k.incrementAndGet();
        SpawnPoint spawnPoint6 = a3;
        spawnPoint6.C.setListener(new MonsterListener(){

            @Override
            public /* synthetic */ void monsterKilled() {
                1 a2;
                1 v0 = a2;
                v0.SpawnPoint.this.e = System.currentTimeMillis();
                if (v0.SpawnPoint.this.E > 0) {
                    1 v1 = a2;
                    v1.SpawnPoint.this.e += v1.SpawnPoint.this.E;
                }
                a2.SpawnPoint.this.k.decrementAndGet();
            }
            {
                1 a3;
            }
        });
        a2.spawnMonster(spawnPoint6.C, -2);
        if (spawnPoint5.d > -1) {
            for (MapleReactor abstractMapleMapObject : a2.getAllReactorsThreadsafe()) {
                if (!abstractMapleMapObject.getName().startsWith(String.valueOf(a3.d)) || abstractMapleMapObject.getReactorId() != 9980000 + a3.d || abstractMapleMapObject.getState() >= 5) continue;
                int n2 = Integer.parseInt(abstractMapleMapObject.getName().substring(1, 2));
                object = MapleCarnivalFactory.getInstance().getGuardian(n2);
                if (object == null || ((MapleCarnivalFactory.MCSkill)object).getMobSkill() == null || a3.C == null) continue;
                ((MapleCarnivalFactory.MCSkill)object).getMobSkill().applyEffect(null, a3.C, false);
            }
        }
        for (MapleSummon mapleSummon : a2.getAllSummonsThreadsafe()) {
            if (mapleSummon.getSkill() != 35111005) continue;
            MapleStatEffect mapleStatEffect = SkillFactory.getSkill(mapleSummon.getSkill()).getEffect(mapleSummon.getSkillLevel());
            Object object2 = object = mapleStatEffect.getMonsterStati().entrySet().iterator();
            while (object2.hasNext()) {
                Map.Entry<MonsterStatus, Integer> entry = object.next();
                a3.C.applyStatus(mapleSummon.getOwner(), new MonsterStatusEffect(entry.getKey(), entry.getValue(), mapleSummon.getSkill(), null, false), false, mapleStatEffect.getDuration(), true, mapleStatEffect);
                object2 = object;
            }
            break block1;
        }
        if (a3.a != null) {
            a2.broadcastMessage(MaplePacketCreator.getItemNotice(a3.a));
        }
        return a3.C;
    }

    public final /* synthetic */ void setCarnival(int a2) {
        a.B = a2;
    }

    @Override
    public final /* synthetic */ int getCarnivalId() {
        SpawnPoint a2;
        return a2.B;
    }

    @Override
    public final /* synthetic */ MapleMonster getMonster() {
        SpawnPoint a2;
        return a2.C;
    }

    public final /* synthetic */ void setLevel(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ SpawnPoint(MapleMonster a2, Pair<Integer, Point> a3, int a4, byte a5, String a6) {
        SpawnPoint a7;
        SpawnPoint spawnPoint = a7;
        SpawnPoint spawnPoint2 = a7;
        spawnPoint2.B = -1;
        SpawnPoint spawnPoint3 = a7;
        spawnPoint2.k = new AtomicInteger(0);
        spawnPoint2.ALLATORIxDEMO = -1;
        spawnPoint.C = a2;
        spawnPoint.g = a3.getLeft();
        a7.H = a3.getRight();
        a7.E = a4 < 0 ? -1 : a4 * 1000;
        SpawnPoint spawnPoint4 = a7;
        a7.d = a5;
        spawnPoint4.a = a6;
        spawnPoint4.K = !a2.getStats().getMobile();
        SpawnPoint spawnPoint5 = a7;
        spawnPoint5.e = System.currentTimeMillis();
        spawnPoint5.ALLATORIxDEMO = -1;
    }

    @Override
    public final /* synthetic */ int getMobTime() {
        SpawnPoint a2;
        return a2.E;
    }

    @Override
    public final /* synthetic */ boolean shouldSpawn(MapleMap a22) {
        SpawnPoint a3;
        if (a3.E < 0) {
            return false;
        }
        int a22 = MobConstants.isMonsterSpawn(a22);
        if (GameSetConstants.SERVER_NAME.equals(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u7dd0\u5950\u5254\u4ed4"))) {
            a22 = 1;
        }
        if ((a3.E != 0 || a3.K) && a3.k.get() > 0 || a3.k.get() > a22) {
            return false;
        }
        return a3.e <= System.currentTimeMillis();
    }
}

