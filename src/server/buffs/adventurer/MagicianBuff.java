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

public class MagicianBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u5192\u96aa\u5bb6(a2) && MapleJob.is\u6cd5\u5e2b(a2);
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 2001002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAGIC_GUARD, a2.x));
                return arrayList2;
            }
            case 2301003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INVINCIBLE, a2.x));
                return arrayList3;
            }
            case 2311002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOULARROW, a2.x));
                return arrayList4;
            }
            case 2121009: 
            case 2221009: 
            case 2321010: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BUFF_MASTERY, a2.x));
                return arrayList5;
            }
            case 2120010: 
            case 2220010: 
            case 2320011: {
                a2.duration = 5000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ARCANE_AIM, a2.x));
                return arrayList6;
            }
            case 2111008: 
            case 2211008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_RESET, a2.x));
                return arrayList7;
            }
            case 2311006: {
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                    arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                    return arrayList8;
                }
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, a2.x));
                return arrayList9;
            }
            case 2121000: 
            case 2221000: 
            case 2321000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList10;
            }
            case 2000007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                while (false) {
                }
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_WEAKEN, a2.x));
                return arrayList11;
            }
            case 2311009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HOLY_MAGIC_SHELL, a2.x));
                a2.hpR = (double)a2.z / 100.0;
                return arrayList12;
            }
            case 2221006: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 2111007: 
            case 2211007: 
            case 2311007: {
                a2.mpCon = (short)a2.y;
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TELEPORT_MASTERY, a2.x));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList13;
            }
            case 2121006: 
            case 2201004: 
            case 2211002: 
            case 2211006: 
            case 2221001: 
            case 2221003: 
            case 2221007: {
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                return arrayList;
            }
            case 2101003: 
            case 2201003: {
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                return arrayList;
            }
            case 2311005: {
                a2.monsterStatus.put(MonsterStatus.DOOM, 1);
                return arrayList;
            }
            case 2121005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList14 = arrayList;
                arrayList14.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList14;
            }
            case 2221005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList15 = arrayList;
                arrayList15.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                return arrayList15;
            }
            case 2111005: 
            case 2211005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList16 = arrayList;
                arrayList16.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList16;
            }
            case 2121004: 
            case 2221004: 
            case 2321004: {
                MapleStatEffect mapleStatEffect = a2;
                mapleStatEffect.hpR = (double)mapleStatEffect.y / 100.0;
                mapleStatEffect.mpR = (double)mapleStatEffect.y / 100.0;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList17 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INFINITY, a2.x));
                arrayList17.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList17;
            }
            case 2121002: 
            case 2221002: 
            case 2321002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList18 = arrayList;
                arrayList18.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MANA_REFLECTION, 1));
                return arrayList18;
            }
            case 2321005: {
                if (GameSetConstants.MAPLE_VERSION < 138) {
                    arrayList.clear();
                }
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList19 = arrayList;
                arrayList19.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HOLY_SHIELD, a2.x));
                return arrayList19;
            }
            case 2301004: {
                if (GameSetConstants.MAPLE_VERSION < 134) break;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList20 = arrayList;
                arrayList20.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLESS, Integer.valueOf(a2.level)));
                return arrayList20;
            }
            case 2111004: 
            case 2211004: {
                a2.monsterStatus.put(MonsterStatus.SEAL, 1);
                return arrayList;
            }
            case 2321003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList21 = arrayList;
                arrayList21.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList21;
            }
            case 2311003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList22 = arrayList;
                arrayList22.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HOLY_SYMBOL, a2.x));
                return arrayList22;
            }
            case 2211003: 
            case 2311004: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
        }
        return arrayList;
    }

    public /* synthetic */ MagicianBuff() {
        MagicianBuff a2;
    }
}

