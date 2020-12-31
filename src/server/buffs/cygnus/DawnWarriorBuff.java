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

public class DawnWarriorBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u8056\u9b42\u528d\u58eb(a2);
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 11101002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FINAL_MELEE_ATTACK, a2.x));
                return arrayList2;
            }
            case 11111007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, a2.x));
                return arrayList3;
            }
            case 11101001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList4;
            }
            case 11111001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBO, 1));
                return arrayList5;
            }
            case 11111002: {
                a2.monsterStatus.put(MonsterStatus.DARKNESS, a2.x);
                return arrayList;
            }
            case 11001004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                while (false) {
                }
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList6;
            }
            case 11101006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.POWERGUARD, a2.x));
                return arrayList7;
            }
        }
        return arrayList;
    }

    public /* synthetic */ DawnWarriorBuff() {
        DawnWarriorBuff a2;
    }
}

