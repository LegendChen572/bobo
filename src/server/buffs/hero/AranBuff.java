/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.hero;

import client.MapleJob;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class AranBuff
extends AbstractBuffClass {
    public /* synthetic */ AranBuff() {
        AranBuff a2;
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 21001003: {
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                    arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, -a2.y));
                    return arrayList2;
                }
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList3;
            }
            case 21100005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBO_DRAIN, a2.x));
                return arrayList4;
            }
            case 21000000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                while (false) {
                }
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ARAN_COMBO, 100));
                return arrayList5;
            }
            case 21101006: 
            case 21111005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, a2.x));
                return arrayList6;
            }
            case 21111009: {
                a2.hpR = (double)(-a2.x) / 100.0;
                return arrayList;
            }
            case 21121000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList7;
            }
            case 21101003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BODY_PRESSURE, a2.x));
                return arrayList8;
            }
            case 21111001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SMART_KNOCKBACK, a2.x));
                return arrayList9;
            }
            case 21120006: {
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                a2.duration *= 2;
                return arrayList;
            }
            case 21120007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBO_BARRIER, a2.x));
                return arrayList10;
            }
            case 21110006: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 21121003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList11;
            }
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u72c2\u72fc\u52c7\u58eb(a2);
    }
}

