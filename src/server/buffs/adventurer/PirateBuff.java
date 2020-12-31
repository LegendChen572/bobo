/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.adventurer;

import client.MapleJob;
import client.status.MonsterStatus;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class PirateBuff
extends AbstractBuffClass {
    public /* synthetic */ PirateBuff() {
        PirateBuff a2;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u5192\u96aa\u5bb6(a2) && MapleJob.is\u6d77\u76dc(a2);
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 5101006: 
            case 5201003: 
            case 5301002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList2;
            }
            case 5111007: 
            case 5211007: 
            case 5311005: 
            case 5320007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DICE_ROLL, 0));
                return arrayList3;
            }
            case 5301003: {
                break;
            }
            case 5120011: 
            case 5220012: 
            case 5720012: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_PERCENT, Integer.valueOf(a2.damR)));
                return arrayList4;
            }
            case 5121009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED_INFUSION, a2.x));
                return arrayList5;
            }
            case 5001005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                while (false) {
                }
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DASH_SPEED, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DASH_JUMP, a2.y));
                return arrayList6;
            }
            case 5211006: 
            case 5220011: 
            case 5721003: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HOMING_BEACON, a2.x));
                return arrayList7;
            }
            case 5121000: 
            case 5221000: 
            case 5321005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList8;
            }
            case 5101002: 
            case 5101003: 
            case 5111002: 
            case 5121004: 
            case 5121005: 
            case 5121007: 
            case 5201004: 
            case 5301001: 
            case 5310008: 
            case 5311001: 
            case 5311002: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 5211005: {
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                a2.duration *= 2;
                return arrayList;
            }
            case 5011002: {
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.z);
                return arrayList;
            }
            case 5211001: 
            case 5220002: 
            case 5321003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PUPPET, 1));
                return arrayList9;
            }
            case 5211002: 
            case 5321004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList10;
            }
            case 5321010: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList11;
            }
            case 5121015: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENHANCED_WATK, 15));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, 30));
                return arrayList12;
            }
            case 5211009: {
                a2.duration = Integer.MAX_VALUE;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENHANCED_WATK, 20));
                return arrayList13;
            }
            case 5211011: 
            case 5211015: 
            case 5211016: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList14 = arrayList;
                arrayList14.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList14;
            }
            case 5211014: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList15 = arrayList;
                arrayList15.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PUPPET, 1));
                return arrayList15;
            }
            case 5711001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList16 = arrayList;
                arrayList16.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList16;
            }
            case 5201008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList17 = arrayList;
                arrayList17.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPIRIT_CLAW, 0));
                return arrayList17;
            }
            case 5721000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList18 = arrayList;
                arrayList18.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList18;
            }
            case 5311004: 
            case 5711011: {
                a2.mpCon = (short)a2.y;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList19 = arrayList;
                arrayList19.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TELEPORT_MASTERY, a2.x));
                return arrayList19;
            }
            case 5221009: {
                a2.monsterStatus.put(MonsterStatus.HYPNOTIZE, 1);
                return arrayList;
            }
            case 5110001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList20 = arrayList;
                arrayList20.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENERGY_CHARGE, 0));
                return arrayList20;
            }
            case 5701005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList21 = arrayList;
                arrayList21.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList21;
            }
            case 5111010: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList22 = arrayList;
                arrayList22.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WATER_SHIELD, a2.x));
                return arrayList22;
            }
            case 5221018: 
            case 5721009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList23 = arrayList;
                arrayList23.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.z));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_PERCENT, Integer.valueOf(a2.damR)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, a2.x));
                return arrayList23;
            }
        }
        return arrayList;
    }
}

