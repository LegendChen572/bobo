/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.hero;

import client.MapleJob;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class PhantomBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 20031203: {
                while (false) {
                }
                a2.moveTo = a2.x;
                return arrayList;
            }
            case 24111003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.clear();
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, a2.y));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HP_BOOST_PERCENT, a2.indieMhpR));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MP_BOOST_PERCENT, a2.indieMmpR));
                return arrayList2;
            }
            case 24111002: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FINAL_FEINT, 1));
                return arrayList3;
            }
            case 24121004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENHANCED_WATK, 30));
                return arrayList4;
            }
            case 24101005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList5;
            }
            case 24121008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList6;
            }
            case 20031205: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHROUD_WALK, 1));
                return arrayList7;
            }
            case 24121054: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FINAL_JUDGMENT_DRAW, a2.x));
                return arrayList8;
            }
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u5e7b\u5f71\u4fe0\u76dc(a2);
    }

    public /* synthetic */ PhantomBuff() {
        PhantomBuff a2;
    }
}

