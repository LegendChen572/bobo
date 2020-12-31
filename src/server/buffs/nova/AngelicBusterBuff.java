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

public class AngelicBusterBuff
extends AbstractBuffClass {
    public /* synthetic */ AngelicBusterBuff() {
        AngelicBusterBuff a2;
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 65121053: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRITICAL_INC, a2.x));
                arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.y));
                return arrayList2;
            }
            case 65121101: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TRINITY, a2.x));
                return arrayList3;
            }
            case 65121100: {
                break;
            }
            case 65121054: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOUL_EXALT, 1));
                return arrayList4;
            }
            case 65121003: {
                a2.duration = 8000;
                return arrayList;
            }
            case 65121002: {
                a2.monsterStatus.put(MonsterStatus.FATALITY, a2.x);
                return arrayList;
            }
            case 65121004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRIT_DAMAGE, a2.x));
                return arrayList5;
            }
            case 65120006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INDIE_DAMAGE_PERCENT, a2.y));
                a2.duration = 5000;
                return arrayList6;
            }
            case 65101100: {
                a2.monsterStatus.put(MonsterStatus.EXPLOSION, 1);
                return arrayList;
            }
            case 65101002: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                while (false) {
                }
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DAMAGE_ABSORBED, a2.x));
                return arrayList7;
            }
            case 65111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList8 = arrayList;
                arrayList8.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a2.prop));
                return arrayList8;
            }
            case 65121009: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList9 = arrayList;
                arrayList9.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAPLE_WARRIOR, a2.x));
                return arrayList9;
            }
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u5929\u4f7f\u7834\u58de\u8005(a2);
    }
}

