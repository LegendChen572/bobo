/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleFriendship;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import tools.Pair;

public class FishingRewardFactory {
    private /* synthetic */ Long B;
    private final /* synthetic */ int[] a;
    private static final /* synthetic */ FishingRewardFactory ALLATORIxDEMO;
    private final /* synthetic */ int d = 100;
    private final /* synthetic */ List<Pair<Long, FishingReward>> g;
    private final /* synthetic */ int[] K;
    private final /* synthetic */ Random k;

    /*
     * Exception decompiling
     */
    private /* synthetic */ void ALLATORIxDEMO() {
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

    public /* synthetic */ void reloadItems() {
        FishingRewardFactory a2;
        a2.ALLATORIxDEMO();
    }

    public /* synthetic */ int getNextRewardType() {
        int n2;
        FishingRewardFactory a2;
        Objects.requireNonNull(a2);
        Integer n3 = a2.k.nextInt(100);
        int n4 = n2 = 0;
        while (n4 < 3) {
            if (n3 <= a2.a[n2]) {
                return n2;
            }
            n4 = ++n2;
        }
        return 0;
    }

    public /* synthetic */ FishingRewardFactory() {
        FishingRewardFactory a2;
        FishingRewardFactory fishingRewardFactory = a2;
        FishingRewardFactory fishingRewardFactory2 = a2;
        fishingRewardFactory2.B = 0L;
        int[] arrn = new int[3];
        arrn[0] = 40;
        arrn[1] = 40;
        arrn[2] = 20;
        fishingRewardFactory2.K = arrn;
        int[] arrn2 = new int[3];
        arrn2[0] = 40;
        arrn2[1] = 80;
        arrn2[2] = 100;
        fishingRewardFactory.a = arrn2;
        fishingRewardFactory.d = 100;
        System.out.println(MapleFriendship.ALLATORIxDEMO("\u303b\u8b98\u53fd\u4e35\u303a8mqXpBvLJNoJjO^J{_wYa\u000b\"\u0011\""));
        FishingRewardFactory fishingRewardFactory3 = a2;
        a2.g = new LinkedList<Pair<Long, FishingReward>>();
        fishingRewardFactory3.k = new Random(System.currentTimeMillis());
        a2.ALLATORIxDEMO();
    }

    public static /* synthetic */ FishingRewardFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public /* synthetic */ FishingReward getNextRewardItemId() {
        FishingRewardFactory a2;
        if (a2.g.isEmpty()) {
            a2.ALLATORIxDEMO();
        }
        FishingRewardFactory fishingRewardFactory = a2;
        Iterator<Pair<Long, FishingReward>> iterator = fishingRewardFactory.g.iterator();
        if (fishingRewardFactory.B != 0L) {
            Long l2 = Math.abs(a2.k.nextLong() * System.currentTimeMillis() + 47L * System.currentTimeMillis()) % a2.B;
            while (iterator.hasNext()) {
                Pair<Long, FishingReward> pair = iterator.next();
                if (l2 > (Long)pair.left) continue;
                return (FishingReward)pair.right;
            }
        }
        return null;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new FishingRewardFactory();
    }

    public class FishingReward {
        private final /* synthetic */ int a;
        public final /* synthetic */ FishingRewardFactory ALLATORIxDEMO;
        private final /* synthetic */ int d;

        public /* synthetic */ int getExpiration() {
            FishingReward a2;
            return a2.d;
        }

        public /* synthetic */ int getItemId() {
            FishingReward a2;
            return a2.a;
        }

        public /* synthetic */ FishingReward(FishingRewardFactory a2, int a3, int a4) {
            FishingReward a5;
            FishingReward fishingReward = a5;
            a5.ALLATORIxDEMO = a2;
            fishingReward.d = a4;
            fishingReward.a = a3;
        }
    }
}

