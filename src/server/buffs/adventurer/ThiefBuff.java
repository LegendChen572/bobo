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

public class ThiefBuff
extends AbstractBuffClass {
    public /* synthetic */ ThiefBuff() {
        ThiefBuff a2;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u5192\u96aa\u5bb6(a2) && MapleJob.is\u76dc\u8cca(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 0x421211: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARKSIGHT, Integer.valueOf(a2.level)));
                return arrayList2;
            }
            case 4001003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARKSIGHT, a2.x));
                return arrayList3;
            }
            case 4211003: {
                if (GameSetConstants.MAPLE_VERSION >= 147) {
                    a2.duration = Integer.MAX_VALUE;
                }
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PICKPOCKET, a2.x));
                return arrayList4;
            }
            case 4201011: 
            case 4211005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MESOGUARD, a2.x));
                return arrayList5;
            }
            case 4111001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MESOUP, a2.x));
                return arrayList6;
            }
            case 4111002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHADOWPARTNER, a2.x));
                return arrayList7;
            }
            case 4331002: {
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                    arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHADOWPARTNER, a2.x));
                    return arrayList8;
                }
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MIRROR_IMAGE, a2.x));
                return arrayList9;
            }
            case 0x404140: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHADOWPARTNER, Integer.valueOf(a2.level)));
                return arrayList10;
            }
            case 4101003: 
            case 4201002: 
            case 4301002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList11;
            }
            case 4321000: {
                a2.duration = 1000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DASH_SPEED, 100 + a2.x));
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DASH_JUMP, a2.y));
                return arrayList12;
            }
            case 4341007: {
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                    arrayList.add(new Pair<MapleBuffStat, Short>(MapleBuffStat.ENHANCED_WATK, a2.watk));
                    arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                    return arrayList13;
                }
                if (GameSetConstants.MAPLE_VERSION >= 118) {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList14 = arrayList;
                    arrayList14.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHARP_EYES, a2.x << 8 + a2.criticaldamageMin));
                    return arrayList14;
                }
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList15 = arrayList;
                arrayList15.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.THORNS, a2.x << 8 | a2.y));
                return arrayList15;
            }
            case 4341002: {
                a2.duration = 60000;
                a2.hpR = (double)(-a2.x) / 100.0;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList16 = arrayList;
                arrayList16.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FINAL_CUT, a2.y));
                return arrayList16;
            }
            case 4331003: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList17 = arrayList;
                arrayList17.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.OWL_SPIRIT, a2.y));
                return arrayList17;
            }
            case 4121000: 
            case 4221000: 
            case 4341000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList18 = arrayList;
                arrayList18.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList18;
            }
            case 4001002: {
                a2.monsterStatus.put(MonsterStatus.WATK, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.y);
                return arrayList;
            }
            case 4341003: {
                a2.monsterStatus.put(MonsterStatus.MONSTER_BOMB, Integer.valueOf(a2.damage));
                return arrayList;
            }
            case 4211002: {
                if (GameSetConstants.MAPLE_VERSION > 118) break;
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 4121008: 
            case 4201004: 
            case 4221007: 
            case 4331005: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 4321002: {
                a2.monsterStatus.put(MonsterStatus.DARKNESS, a2.x);
                return arrayList;
            }
            case 4121003: 
            case 4221003: {
                a2.monsterStatus.put(MonsterStatus.SHOWDOWN, a2.x);
                a2.monsterStatus.put(MonsterStatus.MDEF, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.x);
                return arrayList;
            }
            case 4121004: 
            case 4221004: {
                a2.monsterStatus.put(MonsterStatus.NINJA_AMBUSH, Integer.valueOf(a2.damage));
                return arrayList;
            }
            case 4341006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList19 = arrayList;
                arrayList19.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PUPPET, 1));
                return arrayList19;
            }
            case 4111007: 
            case 4211007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList20 = arrayList;
                arrayList20.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList20;
            }
            case 4111003: {
                a2.monsterStatus.put(MonsterStatus.SHADOW_WEB, 1);
                return arrayList;
            }
            case 4121006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList21 = arrayList;
                arrayList21.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPIRIT_CLAW, 0));
                return arrayList21;
            }
            case 4221013: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList22 = arrayList;
                arrayList22.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.KILLING_POINT, 0));
                return arrayList22;
            }
            case 4311009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList23 = arrayList;
                arrayList23.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList23;
            }
            case 4121015: {
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.x);
                return arrayList;
            }
            case 4111009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList24 = arrayList;
                arrayList24.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPIRIT_CLAW, 0));
                return arrayList24;
            }
            case 4330009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList25 = arrayList;
                arrayList25.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRIT_RATE, 100));
                return arrayList25;
            }
        }
        return arrayList;
    }
}

