/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.nova;

import client.MapleJob;
import client.status.MonsterStatus;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class LuminousBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u591c\u5149(a2);
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 27101004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                while (false) {
                }
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList2;
            }
            case 27101101: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 27101202: {
                a2.duration = 10000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PRESSURE_VOID, a2.x));
                return arrayList3;
            }
            case 27111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.clear();
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_BUFF_RESISTANCES, 3));
                a2.duration = 2100000000;
                return arrayList4;
            }
            case 27111005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList5;
            }
            case 27121052: {
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                return arrayList;
            }
            case 27121006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.IGNORE_DEF, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_RESET, a2.x));
                return arrayList6;
            }
            case 27121005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_CRESCENDO, 1));
                return arrayList7;
            }
            case 27121009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList8;
            }
        }
        return arrayList;
    }

    public /* synthetic */ LuminousBuff() {
        LuminousBuff a2;
    }
}

