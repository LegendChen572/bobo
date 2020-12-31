/*
 * Decompiled with CFR 0.150.
 */
package server.buffs.gamemaster;

import client.MapleJob;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import tools.Pair;

public class GameMasterBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u7ba1\u7406\u54e1(a2);
    }

    public /* synthetic */ GameMasterBuff() {
        GameMasterBuff a2;
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 9001008: 
            case 9101008: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAXHP, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAXMP, a2.x));
                return arrayList2;
            }
            case 9001020: 
            case 9101020: {
                a2.monsterStatus.put(MonsterStatus.STUN, 1);
                return arrayList;
            }
            case 90001004: {
                a2.monsterStatus.put(MonsterStatus.DARKNESS, a2.x);
                return arrayList;
            }
            case 9001002: 
            case 9101002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                while (false) {
                }
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HOLY_SYMBOL, a2.x));
                return arrayList3;
            }
            case 9001003: 
            case 9101003: {
                if (GameSetConstants.MAPLE_VERSION < 134) break;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLESS, Integer.valueOf(a2.level)));
                return arrayList4;
            }
            case 9001004: 
            case 9101004: {
                a2.duration = 0x6DDD00;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARKSIGHT, 1));
                return arrayList5;
            }
        }
        return arrayList;
    }
}

