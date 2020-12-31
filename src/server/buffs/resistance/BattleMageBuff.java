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

public class BattleMageBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 32101005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList2;
            }
            case 32111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CONVERSION, a2.x));
                return arrayList3;
            }
            case 32111010: {
                a2.mpCon = (short)a2.y;
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TELEPORT_MASTERY, a2.x));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList4;
            }
            case 32000012: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                while (false) {
                }
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_WEAKEN, a2.x));
                return arrayList5;
            }
            case 32121007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList6;
            }
            case 32101004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBO_DRAIN, a2.x));
                return arrayList7;
            }
            case 32121003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TORNADO, a2.x));
                return arrayList8;
            }
            case 32111005: {
                a2.duration = 60000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BODY_BOOST, Integer.valueOf(a2.level)));
                return arrayList9;
            }
            case 32101001: 
            case 32111011: 
            case 32121004: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 32111006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.REAPER, 1));
                return arrayList10;
            }
            case 32120000: {
                a2.dot = a2.damage;
                a2.dotTime = (short)3;
                a2.monsterStatus.put(MonsterStatus.POISON, 1);
            }
            case 32001003: 
            case 32110007: {
                a2.duration = a2.sourceid == 32110007 ? 60000 : 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a2.level)));
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_AURA, a2.x));
                return arrayList11;
            }
            case 32101002: 
            case 32110000: 
            case 32110008: 
            case 32111012: {
                a2.duration = a2.sourceid == 32110008 ? 60000 : 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a2.level)));
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, Integer.valueOf(a2.level)));
                return arrayList12;
            }
            case 32120001: {
                a2.monsterStatus.put(MonsterStatus.SPEED, Integer.valueOf(a2.speed));
                return arrayList;
            }
            case 32101003: 
            case 32110009: {
                a2.duration = a2.sourceid == 32110009 ? 60000 : 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a2.level)));
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, Integer.valueOf(a2.level)));
                return arrayList13;
            }
            case 32111014: 
            case 32121005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList14 = arrayList;
                arrayList14.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList14;
            }
            case 32121010: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList15 = arrayList;
                arrayList15.clear();
                arrayList15.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRITICAL_INC, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHARP_EYES, a2.z));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HP_BOOST_PERCENT, Integer.valueOf(a2.mhpR)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MP_BOOST_PERCENT, Integer.valueOf(a2.mmpR)));
                return arrayList15;
            }
        }
        return arrayList;
    }

    public /* synthetic */ BattleMageBuff() {
        BattleMageBuff a2;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u7149\u7344\u5deb\u5e2b(a2);
    }
}

