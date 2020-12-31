/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.cygnus;

import client.MapleJob;
import client.status.MonsterStatus;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class NightWalkerBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u6697\u591c\u884c\u8005(a2);
    }

    public /* synthetic */ NightWalkerBuff() {
        NightWalkerBuff a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 14001005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList2;
            }
            case 14111001: {
                a2.monsterStatus.put(MonsterStatus.SHADOW_WEB, 1);
                return arrayList;
            }
            case 14001002: {
                a2.monsterStatus.put(MonsterStatus.WATK, a2.x);
                a2.monsterStatus.put(MonsterStatus.WDEF, a2.y);
                return arrayList;
            }
            case 14101002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList3;
            }
            case 14001003: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARKSIGHT, a2.x));
                return arrayList4;
            }
            case 14111000: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHADOWPARTNER, a2.x));
                return arrayList5;
            }
            case 14111007: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPIRIT_CLAW, 0));
                return arrayList6;
            }
        }
        return arrayList;
    }
}

