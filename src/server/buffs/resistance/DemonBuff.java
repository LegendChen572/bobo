/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.resistance;

import client.MapleJob;
import client.status.MonsterStatus;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class DemonBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 31001001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                while (false) {
                }
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList2;
            }
            case 31121005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_PERCENT, Integer.valueOf(a2.damR)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_METAMORPHOSIS, 6));
                return arrayList3;
            }
            case 31121004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList4;
            }
            case 31121002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBO_DRAIN, a2.x));
                return arrayList5;
            }
            case 31101002: 
            case 31111001: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 31121003: {
                a2.monsterStatus.put(MonsterStatus.SHOWDOWN, a2.w);
                a2.monsterStatus.put(MonsterStatus.MDEF, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.x);
                a2.monsterStatus.put(MonsterStatus.MATK, a2.x);
                a2.monsterStatus.put(MonsterStatus.WATK, a2.x);
                a2.monsterStatus.put(MonsterStatus.ACC, a2.x);
                return arrayList;
            }
            case 31101003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PERFECT_ARMOR, a2.y));
                return arrayList6;
            }
            case 31121007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOUNDLESS_RAGE, 1));
                return arrayList7;
            }
            case 31111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, a2.y));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, a2.z));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DEFENCE_BOOST_R, a2.x));
                return arrayList8;
            }
        }
        return arrayList;
    }

    public /* synthetic */ DemonBuff() {
        DemonBuff a2;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u60e1\u9b54(a2);
    }
}

