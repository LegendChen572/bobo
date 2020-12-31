/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.cygnus;

import client.MapleJob;
import client.status.MonsterStatus;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class ThunderBreakerBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 15111006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPARK, a2.x));
                return arrayList2;
            }
            case 15100004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENERGY_CHARGE, 0));
                return arrayList3;
            }
            case 15101006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, a2.x));
                return arrayList4;
            }
            case 15101002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList5;
            }
            case 15111005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED_INFUSION, a2.x));
                return arrayList6;
            }
            case 15001003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                while (false) {
                }
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DASH_SPEED, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DASH_JUMP, a2.y));
                return arrayList7;
            }
            case 15101005: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 15001004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList8;
            }
            case 15111011: {
                a2.mpCon = (short)a2.y;
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TELEPORT_MASTERY, a2.x));
                return arrayList9;
            }
        }
        return arrayList;
    }

    public /* synthetic */ ThunderBreakerBuff() {
        ThunderBreakerBuff a2;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u9583\u96f7\u608d\u5c07(a2);
    }
}

