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

public class MihileBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u7c73\u54c8\u9038(a2);
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 51101004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENHANCED_WATK, 20));
                return arrayList2;
            }
            case 51111003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, a2.x));
                return arrayList3;
            }
            case 51101003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                while (false) {
                }
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList4;
            }
            case 51121005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList5;
            }
            case 51111005: {
                a2.monsterStatus.put(MonsterStatus.MAGIC_CRASH, 1);
                return arrayList;
            }
            case 51121004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList6;
            }
            case 51111007: 
            case 51121008: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 51111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, a2.y));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, a2.z));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DEFENCE_BOOST_R, a2.x));
                return arrayList7;
            }
            case 51121007: {
                a2.monsterStatus.put(MonsterStatus.DARKNESS, a2.x);
                return arrayList;
            }
            case 51121006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENRAGE, a2.x * 100 + a2.mobCount));
                return arrayList8;
            }
        }
        return arrayList;
    }

    public /* synthetic */ MihileBuff() {
        MihileBuff a2;
    }
}

