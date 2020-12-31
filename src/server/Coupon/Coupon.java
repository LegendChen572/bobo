/*
 * Decompiled with CFR 0.150.
 */
package server.Coupon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import server.Coupon.CouponFactory;
import server.Coupon.CouponReward;
import server.Randomizer;
import server.StructSetItem;
import tools.Pair;

public class Coupon {
    private static /* synthetic */ Coupon ALLATORIxDEMO;
    private final /* synthetic */ List<Pair<Long, CouponReward>> d;

    private /* synthetic */ String ALLATORIxDEMO() {
        int n2;
        int n3 = 20;
        Object object = "";
        int n4 = n2 = 0;
        while (n4 < n3) {
            Coupon a2;
            object = (String)object + (char)a2.ALLATORIxDEMO();
            n4 = ++n2;
        }
        return object;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = null;
    }

    private /* synthetic */ byte ALLATORIxDEMO() {
        if (!false) {
            byte by = (byte)(Math.random() * 26.0);
            byte by2 = (byte)(65 + by);
            return by2;
        }
        byte by = (byte)(Math.random() * 26.0);
        byte by3 = (byte)(97 + by);
        return by3;
    }

    public static /* synthetic */ Coupon getInstance() {
        if (ALLATORIxDEMO == null) {
            System.out.println(StructSetItem.ALLATORIxDEMO("\u3074\u8ba6\u53b2\u4e0b\u3075\u0006'I\u0011V\u000bHD\u001c^\u001c"));
            ALLATORIxDEMO = new Coupon();
            ALLATORIxDEMO.reloadItems();
        }
        return ALLATORIxDEMO;
    }

    public /* synthetic */ CouponReward generateReward() {
        Coupon a2;
        if (a2.d.isEmpty()) {
            a2.reloadItems();
        }
        Coupon coupon2 = a2;
        Iterator<Pair<Long, CouponReward>> iterator = coupon2.d.iterator();
        long l2 = (Long)coupon2.d.get((int)(a2.d.size() - 1)).left;
        Long l3 = Math.abs(Randomizer.nextLong() * System.currentTimeMillis() + 47L * System.currentTimeMillis()) % l2;
        while (iterator.hasNext()) {
            Pair<Long, CouponReward> pair = iterator.next();
            if (l3 > (Long)pair.left) continue;
            return (CouponReward)pair.right;
        }
        return null;
    }

    public /* synthetic */ Coupon() {
        Coupon a2;
        Coupon coupon2 = a2;
        coupon2.d = new LinkedList<Pair<Long, CouponReward>>();
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void reloadItems() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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

    public /* synthetic */ String checkedCouponCode() {
        Coupon a2;
        String string = a2.ALLATORIxDEMO();
        do {
            a2.ALLATORIxDEMO();
        } while (CouponFactory.getNXCodeExist(string));
        return string;
    }
}

