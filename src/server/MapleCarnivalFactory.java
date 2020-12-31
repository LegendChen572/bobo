/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleLieDetector;
import handling.opcodes.MapleBuffStat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.MapleShopItem;
import server.Randomizer;
import server.life.MobSkill;
import server.life.MobSkillFactory;

public class MapleCarnivalFactory {
    private final /* synthetic */ MapleDataProvider d;
    private static final /* synthetic */ MapleCarnivalFactory k;
    private final /* synthetic */ Collection<MapleBuffStat> ALLATORIxDEMO;
    private final /* synthetic */ Map<Integer, MCSkill> K;
    private final /* synthetic */ Map<Integer, MCSkill> a;

    public /* synthetic */ MapleCarnivalFactory() {
        MapleCarnivalFactory a2;
        MapleCarnivalFactory mapleCarnivalFactory = a2;
        MapleCarnivalFactory mapleCarnivalFactory2 = a2;
        mapleCarnivalFactory2.K = new HashMap<Integer, MCSkill>();
        mapleCarnivalFactory.a = new HashMap<Integer, MCSkill>();
        a2.d = MapleDataProviderFactory.getDataProvider(MapleShopItem.ALLATORIxDEMO("t\u0017N\u0010KRP\u0006"));
        mapleCarnivalFactory.ALLATORIxDEMO = new LinkedList<MapleBuffStat>();
        a2.ALLATORIxDEMO();
    }

    public static /* synthetic */ {
        k = new MapleCarnivalFactory();
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        MapleData mapleData;
        Iterator iterator;
        MapleCarnivalFactory a2;
        if (!a2.K.isEmpty()) {
            return;
        }
        System.out.println(MapleLieDetector.ALLATORIxDEMO("\u302d\u8bbf\u53eb\u4e12\u302c\u001fp^MSX|\\MSVK^Qy\\\\IPOF\u0007\u0005\u0007"));
        Iterator iterator2 = iterator = a2.d.getData(MapleShopItem.ALLATORIxDEMO("1d/L\u0015K\u0010\t\u0015J\u001b")).iterator();
        while (iterator2.hasNext()) {
            mapleData = (MapleData)iterator.next();
            int n2 = Integer.parseInt(mapleData.getName());
            int n3 = MapleDataTool.getInt(MapleLieDetector.ALLATORIxDEMO("NOXQY|m"), mapleData, 0);
            int n4 = MapleDataTool.getInt(MapleShopItem.ALLATORIxDEMO("J\u0013E/L\u0015K\u0010n8"), mapleData, 0);
            int n5 = MapleDataTool.getInt(MapleLieDetector.ALLATORIxDEMO("QZKZQ"), mapleData, 0);
            boolean bl = MapleDataTool.getInt(MapleShopItem.ALLATORIxDEMO("S\u001dU\u001bB\b"), mapleData, 1) > 1;
            iterator2 = iterator;
            a2.K.put(n2, new MCSkill(n3, n4, n5, bl));
        }
        iterator = a2.d.getData(MapleLieDetector.ALLATORIxDEMO("r~xH^O[T^S\u0011TRZ")).iterator();
        Iterator iterator3 = iterator;
        while (iterator3.hasNext()) {
            mapleData = (MapleData)iterator.next();
            iterator3 = iterator;
            a2.a.put(Integer.parseInt(mapleData.getName()), new MCSkill(MapleDataTool.getInt(MapleShopItem.ALLATORIxDEMO("\u000fW\u0019I\u0018d,"), mapleData, 0), MapleDataTool.getInt(MapleLieDetector.ALLATORIxDEMO("RR]nTTSQvy"), mapleData, 0), MapleDataTool.getInt(MapleShopItem.ALLATORIxDEMO("\u0010B\nB\u0010"), mapleData, 0), true));
        }
        a2.ALLATORIxDEMO.add(MapleBuffStat.CURSE);
        a2.ALLATORIxDEMO.add(MapleBuffStat.FREEZE);
        a2.ALLATORIxDEMO.add(MapleBuffStat.BLIND);
        a2.ALLATORIxDEMO.add(MapleBuffStat.SHADOW);
        a2.ALLATORIxDEMO.add(MapleBuffStat.POTION);
        a2.ALLATORIxDEMO.add(MapleBuffStat.WEAKEN);
        a2.ALLATORIxDEMO.add(MapleBuffStat.DARKNESS);
        a2.ALLATORIxDEMO.add(MapleBuffStat.SEAL);
        a2.ALLATORIxDEMO.add(MapleBuffStat.POISON);
        a2.ALLATORIxDEMO.add(MapleBuffStat.STUN);
        a2.ALLATORIxDEMO.add(MapleBuffStat.WEIRD_FLAME);
        a2.ALLATORIxDEMO.add(MapleBuffStat.REVERSE_DIRECTION);
        a2.ALLATORIxDEMO.add(MapleBuffStat.ZOMBIFY);
        a2.ALLATORIxDEMO.add(MapleBuffStat.SEDUCE);
        a2.ALLATORIxDEMO.add(MapleBuffStat.MORPH);
        a2.ALLATORIxDEMO.add(MapleBuffStat.SLOW);
    }

    public /* synthetic */ MCSkill getGuardian(int a2) {
        MapleCarnivalFactory a3;
        return a3.a.get(a2);
    }

    public /* synthetic */ MCSkill getSkill(int a2) {
        MapleCarnivalFactory a3;
        return a3.K.get(a2);
    }

    public /* synthetic */ MapleBuffStat getRandomDiasease() {
        MapleBuffStat mapleBuffStat;
        block0: while (true) {
            MapleCarnivalFactory a2;
            Iterator<MapleBuffStat> iterator = a2.ALLATORIxDEMO.iterator();
            do {
                if (!iterator.hasNext()) continue block0;
                mapleBuffStat = iterator.next();
            } while (Randomizer.nextInt(a2.ALLATORIxDEMO.size()) != 0);
            break;
        }
        return mapleBuffStat;
    }

    public static class MCSkill {
        public /* synthetic */ int cpLoss;
        public /* synthetic */ int level;
        public /* synthetic */ boolean targetsAll;
        public /* synthetic */ int mobSkillId;

        public /* synthetic */ MapleBuffStat getDisease() {
            MCSkill a2;
            if (a2.mobSkillId <= 0) {
                return k.getRandomDiasease();
            }
            return MobSkill.getByMobSkill(a2.mobSkillId);
        }

        public /* synthetic */ MobSkill getMobSkill() {
            MCSkill a2;
            MCSkill mCSkill = a2;
            return MobSkillFactory.getMobSkill(mCSkill.mobSkillId, mCSkill.level);
        }

        public /* synthetic */ MCSkill(int a2, int a3, int a4, boolean a5) {
            MCSkill a6;
            MCSkill mCSkill = a6;
            MCSkill mCSkill2 = a6;
            mCSkill2.cpLoss = a2;
            mCSkill2.mobSkillId = a3;
            mCSkill.level = a4;
            mCSkill.targetsAll = a5;
        }
    }
}

