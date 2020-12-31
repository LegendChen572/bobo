/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 */
package server;

import client.messages.commands.player.\u592d\u58fd\u8c37;
import constants.GameConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import server.MapleShopItem;
import server.Randomizer;

public class RandomRewards {
    private /* synthetic */ List<RewardInfo> A;
    private /* synthetic */ List<Integer> D;
    private /* synthetic */ List<Integer> H;
    private /* synthetic */ List<Integer> m;
    private /* synthetic */ List<Integer> F;
    private /* synthetic */ List<Integer> B;
    private /* synthetic */ List<Integer> K;
    private /* synthetic */ List<Integer> M;
    private /* synthetic */ List<RewardInfo> g;
    private static final /* synthetic */ RandomRewards b;
    private /* synthetic */ int[] ALLATORIxDEMO;
    private /* synthetic */ List<RewardInfo> C;
    private /* synthetic */ int[] a;
    private /* synthetic */ List<RewardInfo> l;
    private /* synthetic */ List<RewardInfo> k;
    private /* synthetic */ List<RewardInfo> h;
    private /* synthetic */ List<RewardInfo> J;
    private /* synthetic */ List<Integer> f;
    private /* synthetic */ List<Integer> j;
    private /* synthetic */ List<Integer> i;
    private /* synthetic */ int[] d;
    private /* synthetic */ List<RewardInfo> e;
    private /* synthetic */ List<Integer> E;
    private /* synthetic */ List<RewardInfo> L;
    private /* synthetic */ List<Integer> c;
    private /* synthetic */ List<RewardInfo> I;

    public final /* synthetic */ int getOlaReward() {
        RandomRewards a2;
        if (a2.F.size() == 0) {
            return 2000006;
        }
        RandomRewards randomRewards = a2;
        return randomRewards.F.get(Randomizer.nextInt(randomRewards.F.size()));
    }

    public final /* synthetic */ int getStartSunReward() {
        RandomRewards a2;
        if (a2.m.size() == 0) {
            return 4001246;
        }
        RandomRewards randomRewards = a2;
        return randomRewards.m.get(Randomizer.nextInt(randomRewards.m.size()));
    }

    public /* synthetic */ List<Integer> getAramiaFireWorks() {
        RandomRewards a2;
        return a2.c;
    }

    private static /* synthetic */ void ALLATORIxDEMO(List<Integer> a2, int[] a3) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.length) {
            a2.add(a3[n2++]);
            n3 = n2;
        }
        Collections.shuffle(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(List<Integer> a2, List<RewardInfo> a3) {
        if (a3 != null) {
            a3 = a3.iterator();
            while (a3.hasNext()) {
                int n2;
                RewardInfo rewardInfo = (RewardInfo)a3.next();
                int n3 = n2 = 0;
                while (n3 < rewardInfo.getChance()) {
                    a2.add(rewardInfo.getItemId());
                    n3 = ++n2;
                }
            }
            Collections.shuffle(a2);
        }
    }

    public final /* synthetic */ int getEventReward() {
        RandomRewards a2;
        RandomRewards randomRewards = a2;
        return randomRewards.i.get(Randomizer.nextInt(randomRewards.i.size()));
    }

    public final /* synthetic */ int getFitnessReward() {
        RandomRewards a2;
        if (a2.H.size() == 0) {
            return 2000006;
        }
        RandomRewards randomRewards = a2;
        return randomRewards.H.get(Randomizer.nextInt(randomRewards.H.size()));
    }

    public final /* synthetic */ int getAramiaFireWorkReward() {
        RandomRewards a2;
        RandomRewards randomRewards = a2;
        return randomRewards.c.get(Randomizer.nextInt(randomRewards.c.size()));
    }

    public final /* synthetic */ int getCoconutReward() {
        RandomRewards a2;
        if (a2.E.size() == 0) {
            return 2000006;
        }
        RandomRewards randomRewards = a2;
        return randomRewards.E.get(Randomizer.nextInt(randomRewards.E.size()));
    }

    public /* synthetic */ void reloadGoldItems() {
        RandomRewards a2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        a2.ALLATORIxDEMO(arrayList, a2.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u91ad\u5bd1\u7bcd")));
        a2.f = arrayList;
    }

    public /* synthetic */ RandomRewards() {
        RandomRewards a2;
        RandomRewards randomRewards = a2;
        RandomRewards randomRewards2 = a2;
        RandomRewards randomRewards3 = a2;
        RandomRewards randomRewards4 = a2;
        a2.c = null;
        randomRewards4.l = null;
        randomRewards4.m = null;
        randomRewards3.A = null;
        randomRewards3.f = null;
        randomRewards2.h = null;
        randomRewards2.D = null;
        randomRewards.L = null;
        Integer[] arrinteger = new Integer[2];
        arrinteger[0] = 2450000;
        arrinteger[1] = 2340000;
        randomRewards.j = Arrays.asList(arrinteger);
        RandomRewards randomRewards5 = a2;
        RandomRewards randomRewards6 = a2;
        RandomRewards randomRewards7 = a2;
        RandomRewards randomRewards8 = a2;
        RandomRewards randomRewards9 = a2;
        a2.i = null;
        randomRewards9.J = null;
        randomRewards9.M = null;
        randomRewards8.I = null;
        randomRewards8.F = null;
        randomRewards7.C = null;
        randomRewards7.H = null;
        randomRewards6.e = null;
        randomRewards6.E = null;
        randomRewards5.g = null;
        randomRewards5.B = null;
        a2.k = null;
        a2.K = null;
        a2.ReloadItems();
    }

    public /* synthetic */ void reloadAramiaFireWorkItems() {
        RandomRewards a2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        a2.ALLATORIxDEMO(arrayList, a2.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u6974\u6a45\u5c56\u4e64")));
        a2.c = arrayList;
    }

    public final /* synthetic */ int getXmasreward() {
        RandomRewards a2;
        RandomRewards randomRewards = a2;
        return randomRewards.j.get(Randomizer.nextInt(randomRewards.j.size()));
    }

    public final /* synthetic */ RewardInfo getGoldBoxReward() {
        RandomRewards a2;
        RandomRewards randomRewards = a2;
        int n2 = randomRewards.f.get(Randomizer.nextInt(randomRewards.f.size()));
        for (RewardInfo rewardInfo : a2.h) {
            if (rewardInfo.getItemId() != n2) continue;
            return rewardInfo;
        }
        return new RewardInfo(4280000, 1, 1, 1, 0);
    }

    public final /* synthetic */ RewardInfo getSilverBoxReward() {
        RandomRewards a2;
        RandomRewards randomRewards = a2;
        int n2 = randomRewards.D.get(Randomizer.nextInt(randomRewards.D.size()));
        for (RewardInfo rewardInfo : a2.L) {
            if (rewardInfo.getItemId() != n2) continue;
            return rewardInfo;
        }
        return new RewardInfo(4280001, 1, 1, 1, 0);
    }

    public final /* synthetic */ List<Integer> getTenPercent() {
        RandomRewards a2;
        return a2.K;
    }

    public /* synthetic */ void ReloadItems() {
        RandomRewards a2;
        System.out.println(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u3076\u8bf4\u53b0\u4e59\u3077T4\u0015\b\u0010\t\u00194\u0011\u0011\u0015\u0014\u0010\u0015T\\N\\"));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<RewardInfo> arrayList2 = new ArrayList();
        RandomRewards randomRewards = a2;
        arrayList2 = randomRewards.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u6974\u6a45\u5c56\u4e64"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.m = arrayList;
        randomRewards.A = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u91b7\u5b82\u7bd7"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.f = arrayList;
        randomRewards.h = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u92fc\u5bd1\u7bcd"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.D = arrayList;
        randomRewards.L = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6d4f\u52b3\u733a\u5293"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.i = arrayList;
        randomRewards.J = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u6974\u6a45\u5c56\u4e64"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.c = arrayList;
        randomRewards.l = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6e98\u969e\u7465"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.M = arrayList;
        randomRewards.I = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u7250\u7e4e\u5b2c"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.F = arrayList;
        randomRewards.C = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6235\u67e8\u5b36"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.E = arrayList;
        randomRewards.g = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u7d65\u6909\u5fea\u806c"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.H = arrayList;
        randomRewards.e = arrayList2;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList2 = randomRewards.ALLATORIxDEMO(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5c7f\u5b90"));
        randomRewards.ALLATORIxDEMO(arrayList, arrayList2);
        randomRewards.B = arrayList;
        randomRewards.k = arrayList2;
        arrayList = new ArrayList<Integer>();
        RandomRewards.ALLATORIxDEMO(arrayList, GameConstants.tenPercent);
        randomRewards.K = arrayList;
    }

    public final /* synthetic */ int getJewelReward() {
        RandomRewards a2;
        if (a2.B.size() == 0) {
            return 2000006;
        }
        RandomRewards randomRewards = a2;
        return randomRewards.B.get(Randomizer.nextInt(randomRewards.B.size()));
    }

    public static /* synthetic */ {
        b = new RandomRewards();
    }

    public final /* synthetic */ int getSnowBallReward() {
        RandomRewards a2;
        if (a2.M.size() == 0) {
            return 2000006;
        }
        RandomRewards randomRewards = a2;
        return randomRewards.M.get(Randomizer.nextInt(randomRewards.M.size()));
    }

    public static /* synthetic */ RandomRewards getInstance() {
        return b;
    }

    public /* synthetic */ void reloadEventItems() {
        RandomRewards a2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        a2.ALLATORIxDEMO(arrayList, a2.ALLATORIxDEMO(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6d4f\u52b3\u733a\u5293")));
        a2.D = arrayList;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ List<RewardInfo> ALLATORIxDEMO(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public /* synthetic */ void reloadSilverItems() {
        RandomRewards a2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        a2.ALLATORIxDEMO(arrayList, a2.ALLATORIxDEMO(MapleShopItem.ALLATORIxDEMO("\u92fc\u5bd1\u7bcd")));
        a2.D = arrayList;
    }

    public static class RewardInfo {
        private final /* synthetic */ int d;
        private final /* synthetic */ int K;
        private final /* synthetic */ int a;
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ int k;

        public /* synthetic */ int getChance() {
            RewardInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getItemId() {
            RewardInfo a2;
            return a2.k;
        }

        public /* synthetic */ int getShowMessage() {
            RewardInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ RewardInfo(int a2, int a3, int a4, int a5, int a6) {
            RewardInfo a7;
            RewardInfo rewardInfo = a7;
            RewardInfo rewardInfo2 = a7;
            a7.k = a2;
            rewardInfo2.K = a3;
            rewardInfo2.a = a4;
            rewardInfo.d = a5;
            rewardInfo.ALLATORIxDEMO = a6;
        }

        public /* synthetic */ int getMaxNumber() {
            RewardInfo a2;
            return a2.d;
        }

        public /* synthetic */ int getMinNumber() {
            RewardInfo a2;
            return a2.a;
        }
    }
}

