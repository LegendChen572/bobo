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

public class EvanBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 22000002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                while (false) {
                }
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_WEAKEN, a2.x));
                return arrayList2;
            }
            case 22141002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList3;
            }
            case 22111001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAGIC_GUARD, a2.x));
                return arrayList4;
            }
            case 22161004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ONYX_SHROUD, a2.x));
                return arrayList5;
            }
            case 22121001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_RESET, a2.x));
                return arrayList6;
            }
            case 22151002: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HOMING_BEACON, a2.x));
                return arrayList7;
            }
            case 22171000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList8;
            }
            case 22151003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAGIC_RESISTANCE, a2.x));
                return arrayList9;
            }
            case 22181003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOUL_STONE, 1));
                return arrayList10;
            }
            case 22131002: {
                if (GameSetConstants.MAPLE_VERSION >= 145) {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList11 = arrayList;
                    arrayList11.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_RESET, a2.x));
                    return arrayList11;
                }
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                return arrayList;
            }
            case 22141003: {
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                return arrayList;
            }
            case 22131001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList12 = arrayList;
                arrayList12.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAGIC_SHIELD, a2.x));
                return arrayList12;
            }
            case 22131000: 
            case 22141001: 
            case 22151001: 
            case 22181001: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 22121000: {
                a2.monsterStatus.put(MonsterStatus.FREEZE, 1);
                a2.duration *= 2;
                return arrayList;
            }
            case 22161002: {
                a2.monsterStatus.put(MonsterStatus.IMPRINT, a2.x);
                return arrayList;
            }
            case 22181004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList13 = arrayList;
                arrayList13.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ONYX_WILL, Integer.valueOf(a2.damage)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList13;
            }
            case 22161005: {
                a2.mpCon = (short)a2.y;
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList14 = arrayList;
                arrayList14.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TELEPORT_MASTERY, a2.x));
                return arrayList14;
            }
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u9f8d\u9b54\u5c0e\u58eb(a2);
    }

    public /* synthetic */ EvanBuff() {
        EvanBuff a2;
    }
}

