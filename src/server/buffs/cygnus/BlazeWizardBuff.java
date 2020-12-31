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

public class BlazeWizardBuff
extends AbstractBuffClass {
    @Override
    public /* synthetic */ boolean containsJob(int a2) {
        return MapleJob.is\u70c8\u7130\u5deb\u5e2b(a2);
    }

    public /* synthetic */ BlazeWizardBuff() {
        BlazeWizardBuff a2;
    }

    @Override
    public /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect a2, int a3) {
        ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
        switch (a3) {
            case 12101001: {
                a2.monsterStatus.put(MonsterStatus.SPEED, a2.x);
                return arrayList;
            }
            case 12111007: {
                a2.mpCon = (short)a2.y;
                a2.duration = 2100000000;
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TELEPORT_MASTERY, a2.x));
                return arrayList2;
            }
            case 12101004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BOOSTER, a2.x));
                return arrayList3;
            }
            case 12001001: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAGIC_GUARD, a2.x));
                return arrayList4;
            }
            case 12101005: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = arrayList;
                arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_RESET, a2.x));
                return arrayList5;
            }
            case 12000006: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                while (false) {
                }
                arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENT_WEAKEN, a2.x));
                return arrayList6;
            }
            case 12001004: 
            case 12111004: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList7 = arrayList;
                arrayList7.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SUMMON, 1));
                return arrayList7;
            }
            case 12111002: {
                a2.monsterStatus.put(MonsterStatus.SEAL, 1);
                return arrayList;
            }
        }
        return arrayList;
    }
}

