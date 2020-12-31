/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.cygnus;

import client.MapleJob;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class WindArcherBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 13111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PUPPET, 1));
                return arrayList2;
            }
            case 13101003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOULARROW, a2.x));
                return arrayList3;
            }
            case 0xC7E7CE: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WIND_WALK, a2.x));
                return arrayList4;
            }
            case 13101002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FINAL_MELEE_ATTACK, a2.x));
                return arrayList5;
            }
            case 13111001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CONCENTRATE, a2.x));
                return arrayList6;
            }
            case 13101001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList7;
            }
            case 13001004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                while (false) {
                }
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList8;
            }
            case 13111000: {
                if (GameSetConstants.MAPLE_VERSION < 143) break;
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 13110008: {
                if (GameSetConstants.MAPLE_VERSION < 123) break;
                a2.setOverTime(true);
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRITICAL_RATE_BUFF, 100));
                return arrayList9;
            }
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u7834\u98a8\u4f7f\u8005(a2);
    }

    public /* synthetic */ WindArcherBuff() {
        WindArcherBuff a2;
    }
}

