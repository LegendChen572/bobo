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

public class BowmanBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u5192\u96aa\u5bb6(a2) && MapleJob.is\u5f13\u7bad\u624b(a2);
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 3120010: {
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    a2.monsterStatus.put(MonsterStatus.POISON, 1);
                    return arrayList;
                }
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 3101004: 
            case 3201004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOULARROW, a2.x));
                return arrayList2;
            }
            case 3111000: 
            case 3121008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CONCENTRATE, a2.x));
                return arrayList3;
            }
            case 3101002: 
            case 3201002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                while (false) {
                }
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList4;
            }
            case 3121000: 
            case 3221000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList5;
            }
            case 3121002: 
            case 3221002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6;
                a3 = a2.x << 8 | a2.y;
                if (GameSetConstants.MAPLE_VERSION >= 143) {
                    arrayList6 = arrayList;
                    a3 = (a2.x << 8) + a2.y;
                } else {
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        a3 = (a2.x << 8) + a2.criticaldamageMax;
                    }
                    arrayList6 = arrayList;
                }
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHARP_EYES, a3));
                return arrayList;
            }
            case 3101005: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 3211003: {
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                return arrayList;
            }
            case 3111002: 
            case 3120012: 
            case 3211002: 
            case 3220012: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PUPPET, 1));
                return arrayList7;
            }
            case 3120006: 
            case 3220005: {
                if (GameSetConstants.MAPLE_VERSION < 139) break;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.clear();
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, Integer.valueOf(a2.terR)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPIRIT_LINK, Integer.valueOf(a2.getLevel())));
                return arrayList;
            }
            case 3101007: 
            case 3111005: 
            case 3121006: 
            case 3201007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList9;
            }
            case 3211005: {
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                }
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 3221005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                return arrayList10;
            }
            case 3221006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLIND, a2.x));
                a2.monsterStatus.put(MonsterStatus.ACC, a2.x);
                return arrayList11;
            }
            case 3121007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HAMSTRING, a2.x));
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                return arrayList12;
            }
            case 3111004: {
                if (GameSetConstants.MAPLE_VERSION < 143) break;
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 3110007: 
            case 3210007: {
                if (GameSetConstants.MAPLE_VERSION < 123) break;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                a2.setOverTime(true);
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRITICAL_RATE_BUFF, 100));
                return arrayList13;
            }
            case 3211004: {
                if (GameSetConstants.MAPLE_VERSION < 143) break;
                a2.monsterStatus.put(MonsterStatus.SEAL, 1);
                return arrayList;
            }
        }
        return arrayList;
    }

    public /* synthetic */ BowmanBuff() {
        BowmanBuff a2;
    }
}

