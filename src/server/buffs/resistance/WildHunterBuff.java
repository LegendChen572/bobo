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

public class WildHunterBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u72c2\u8c79\u7375\u4eba(a2);
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 33101003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOULARROW, a2.x));
                return arrayList2;
            }
            case 33001003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList3;
            }
            case 31121004: 
            case 33121007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                while (false) {
                }
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList4;
            }
            case 33121004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5;
                a3 = a2.x << 8 | a2.y;
                if (GameSetConstants.MAPLE_VERSION >= 143) {
                    arrayList5 = arrayList;
                    a3 = (a2.x << 8) + a2.y;
                } else {
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        a3 = (a2.x << 8) + a2.criticaldamageMax;
                    }
                    arrayList5 = arrayList;
                }
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHARP_EYES, a3));
                return arrayList;
            }
            case 33121006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED, a2.z));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ATTACK_BUFF, a2.y));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FELINE_BERSERK, a2.x));
                return arrayList6;
            }
            case 33101001: 
            case 33101002: 
            case 33111002: 
            case 33121002: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 33121005: {
                a2.monsterStatus.put(MonsterStatus.SHOWDOWN, a2.x);
                a2.monsterStatus.put(MonsterStatus.MDEF, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.x);
                return arrayList;
            }
            case 33111003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PUPPET, 1));
                return arrayList7;
            }
            case 33101011: 
            case 33111005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList8;
            }
            case 33101008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList9;
            }
            case 33111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLIND, a2.x));
                a2.monsterStatus.put(MonsterStatus.ACC, a2.x);
                return arrayList10;
            }
            case 33111007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED, a2.z));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ATTACK_BUFF, a2.y));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FELINE_BERSERK, a2.x));
                return arrayList11;
            }
            case 33101004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.RAINING_MINES, a2.x));
                return arrayList12;
            }
            case 33101005: {
                if (GameSetConstants.MAPLE_VERSION < 151) break;
                boolean bl = arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_BUFF, a2.z));
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRITICAL_RATE_BUFF, a2.y));
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MP_BUFF, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_TAKEN_BUFF, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DODGE_CHANGE_BUFF, a2.x));
                return arrayList13;
            }
        }
        return arrayList;
    }

    public /* synthetic */ WildHunterBuff() {
        WildHunterBuff a2;
    }
}

