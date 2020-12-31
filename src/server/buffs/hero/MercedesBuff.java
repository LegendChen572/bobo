/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.hero;

import client.MapleJob;
import client.status.MonsterStatus;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class MercedesBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u7cbe\u9748\u904a\u4fe0(a2);
    }

    public /* synthetic */ MercedesBuff() {
        MercedesBuff a2;
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 23101002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList2;
            }
            case 23101003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPIRIT_LINK, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRITICAL_INC, a2.x));
                return arrayList3;
            }
            case 23121004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_PERCENT, Integer.valueOf(a2.damR)));
                return arrayList4;
            }
            case 23111005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, Integer.valueOf(a2.terR)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, Integer.valueOf(a2.terR)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WATER_SHIELD, a2.x));
                return arrayList5;
            }
            case 23121002: {
                a2.monsterStatus.put(MonsterStatus.WDEF, -a2.x);
                return arrayList;
            }
            case 23111008: 
            case 23111009: 
            case 23111010: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList6;
            }
            case 23111002: {
                a2.monsterStatus.put(MonsterStatus.IMPRINT, a2.x);
                return arrayList;
            }
            case 23121005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList7;
            }
            case 20021110: {
                while (false) {
                }
                a2.moveTo = a2.x;
                return arrayList;
            }
            case 23111000: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
        }
        return arrayList;
    }
}

