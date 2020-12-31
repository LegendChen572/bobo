/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.nova;

import client.MapleJob;
import client.status.MonsterStatus;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class KaiserBuff
extends AbstractBuffClass {
    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 61121054: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.IGNORE_ALL_COUNTER, 1));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.IGNORE_ALL_IMMUNE, 1));
                return arrayList2;
            }
            case 61111002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                return arrayList3;
            }
            case 61101002: 
            case 61110211: 
            case 61120007: 
            case 61121217: {
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TEMPEST_BLADES, 0));
                return arrayList4;
            }
            case 60001229: 
            case 61121100: 
            case 61121201: {
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                return arrayList;
            }
            case 61121009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.GRAND_ARMOR, a2.v));
                return arrayList5;
            }
            case 61111008: 
            case 61120008: 
            case 61121053: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.clear();
                a2.clear = true;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRITICAL_INC, a2.cr));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INDIE_BOOSTER, a2.indieBooster));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INDIE_DAMAGE_PERCENT, a2.indieDamR));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MORPH, a2.morph));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED, Integer.valueOf(a2.speed)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.IGNORE_ALL_COUNTER, 1));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.IGNORE_ALL_IMMUNE, 1));
                return arrayList;
            }
            case 61111100: {
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.z);
                return arrayList;
            }
            case 60001216: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.clear();
                a2.duration = 2100000000;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.KAISER_MODE_CHANGE, 1));
                return arrayList;
            }
            case 60001217: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.clear();
                a2.duration = 2100000000;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.KAISER_MODE_CHANGE, 0));
                return arrayList;
            }
            case 61111003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, Integer.valueOf(a2.asrR)));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, Integer.valueOf(a2.terR)));
                return arrayList9;
            }
            case 61121014: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList10 = arrayList;
                arrayList10.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList10;
            }
        }
        return arrayList;
    }

    public /* synthetic */ KaiserBuff() {
        KaiserBuff a2;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u51f1\u6492(a2);
    }
}

