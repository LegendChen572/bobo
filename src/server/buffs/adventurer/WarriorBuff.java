/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.adventurer;

import client.MapleJob;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class WarriorBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u5192\u96aa\u5bb6(a2) && MapleJob.is\u528d\u58eb(a2);
    }

    public /* synthetic */ WarriorBuff() {
        WarriorBuff a2;
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 1311008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DRAGONBLOOD, a2.x));
                return arrayList2;
            }
            case 1121010: {
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENRAGE, a2.x * 100 + a2.mobCount));
                }
                if (GameSetConstants.MAPLE_VERSION < 143) break;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRIT_RATE, a2.z));
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRIT_MIN_DAMAGE, a2.y));
                return arrayList3;
            }
            case 1111005: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 1301007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAXHP, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAXMP, a2.x));
                return arrayList4;
            }
            case 1211010: {
                a2.hpR = (double)a2.x / 100.0;
                return arrayList;
            }
            case 1201006: {
                a2.monsterStatus.put(MonsterStatus.WATK, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.x);
                if (GameSetConstants.MAPLE_VERSION <= 113) break;
                a2.monsterStatus.put(MonsterStatus.DARKNESS, a2.z);
                return arrayList;
            }
            case 1211007: 
            case 1211008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.clear();
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, a2.x));
                if (GameSetConstants.MAPLE_VERSION <= 113) break;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.LIGHTNING_CHARGE, 1));
                return arrayList6;
            }
            case 1211005: 
            case 1211006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, a2.x));
                return arrayList7;
            }
            case 1211003: 
            case 1211004: 
            case 1221003: 
            case 1221004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, a2.x));
                return arrayList8;
            }
            case 0x10CCCC: 
            case 1101005: 
            case 1201004: 
            case 1201005: 
            case 1301004: 
            case 1301005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                while (false) {
                }
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList9;
            }
            case 1101007: 
            case 1201007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.POWERGUARD, a2.x));
                return arrayList10;
            }
            case 1111002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBO, 1));
                return arrayList11;
            }
            case 1311005: 
            case 1311006: {
                a2.hpR = (double)(-a2.x) / 100.0;
                return arrayList;
            }
            case 1121000: 
            case 1221000: 
            case 1321000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList12;
            }
            case 1111007: 
            case 1211009: 
            case 1311007: {
                break;
            }
            case 1220013: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DIVINE_SHIELD, a2.x + 1));
                return arrayList13;
            }
            case 1211011: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList14 = arrayList;
                arrayList14.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBAT_ORDERS, a2.x));
                return arrayList14;
            }
            case 1111008: 
            case 1121001: 
            case 1211002: 
            case 1221001: 
            case 1321001: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 1111003: {
                a2.monsterStatus.put(MonsterStatus.DARKNESS, a2.x);
                return arrayList;
            }
            case 1321007: {
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList15 = arrayList;
                    arrayList15.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BEHOLDER, Integer.valueOf(a2.level)));
                    return arrayList15;
                }
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList16 = arrayList;
                arrayList16.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList16;
            }
            case 0x111AEA: 
            case 1221002: 
            case 1321002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList17 = arrayList;
                arrayList17.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList17;
            }
        }
        return arrayList;
    }
}

