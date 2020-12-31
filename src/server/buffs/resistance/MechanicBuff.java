/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.resistance;

import client.MapleJob;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class MechanicBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 35001002: 
            case 35120000: {
                a2.duration = 2100000000;
                return arrayList;
            }
            case 35101005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOULARROW, a2.x));
                return arrayList2;
            }
            case 35101006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList3;
            }
            case 35111013: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DICE_ROLL, 0));
                return arrayList4;
            }
            case 35121007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList5;
            }
            case 35101003: 
            case 35111015: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 35121003: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList6;
            }
            case 35111001: 
            case 35111009: 
            case 35111010: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PUPPET, 1));
                return arrayList7;
            }
            case 35111002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList8;
            }
            case 35111005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.y);
                return arrayList9;
            }
            case 35111011: 
            case 35121009: 
            case 35121011: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList10;
            }
            case 35121010: {
                a2.duration = 60000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_BUFF, a2.x));
                return arrayList11;
            }
            case 35101007: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PERFECT_ARMOR, a2.x));
                return arrayList12;
            }
            case 35121006: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SATELLITESAFE_PROC, a2.x));
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SATELLITESAFE_ABSORB, a2.y));
                return arrayList13;
            }
            case 35001001: 
            case 35101009: {
                while (false) {
                }
                a2.duration = 1000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList14 = arrayList;
                arrayList14.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MECH_CHANGE, Integer.valueOf(a2.level)));
                return arrayList14;
            }
            case 35111004: 
            case 35121013: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList15;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    arrayList15 = arrayList;
                    a2.duration = Integer.MAX_VALUE;
                } else {
                    a2.duration = 10000;
                    arrayList15 = arrayList;
                }
                arrayList15.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MECH_CHANGE, Integer.valueOf(a2.level)));
                return arrayList;
            }
            case 35121005: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList16 = arrayList;
                arrayList16.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MECH_CHANGE, Integer.valueOf(a2.level)));
                return arrayList16;
            }
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u6a5f\u7532\u6230\u795e(a2);
    }

    public /* synthetic */ MechanicBuff() {
        MechanicBuff a2;
    }
}

