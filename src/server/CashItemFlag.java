/*
 * Decompiled with CFR 0.150.
 */
package server;

import constants.MobConstants;
import server.Extend.SpecialItemData;
import tools.WritableLongValueHolder;

/*
 * Exception performing whole class analysis ignored.
 */
public final class CashItemFlag
extends Enum<CashItemFlag>
implements WritableLongValueHolder {
    public static final /* synthetic */ /* enum */ CashItemFlag UNK26;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK12;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK8;
    private /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ CashItemFlag TIME_BEGIN;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK23;
    public static final /* synthetic */ /* enum */ CashItemFlag PRIORITY;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK33;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK22;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK29;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK15;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK31;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK28;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK21;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK17;
    public static final /* synthetic */ /* enum */ CashItemFlag FLAGE;
    private /* synthetic */ long a;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK13;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK6;
    public static final /* synthetic */ /* enum */ CashItemFlag COUNT;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK14;
    public static final /* synthetic */ /* enum */ CashItemFlag PACKAGEZ;
    public static final /* synthetic */ /* enum */ CashItemFlag GENDER;
    public static final /* synthetic */ /* enum */ CashItemFlag PERIOD;
    public static final /* synthetic */ /* enum */ CashItemFlag MESO;
    private static final /* synthetic */ CashItemFlag[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK27;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK30;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK18;
    public static final /* synthetic */ /* enum */ CashItemFlag ITEMID;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK3;
    public static final /* synthetic */ /* enum */ CashItemFlag TIME_END;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK32;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK24;
    public static final /* synthetic */ /* enum */ CashItemFlag PRICE;
    public static final /* synthetic */ /* enum */ CashItemFlag UNK25;
    public static final /* synthetic */ /* enum */ CashItemFlag ONSALE;

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void reloadValues() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    @Override
    public /* synthetic */ void setValue(long a2) {
        CashItemFlag a3;
        CashItemFlag cashItemFlag = a3;
        cashItemFlag.a = 1 << (int)(a2 % 32L);
        cashItemFlag.d = (int)Math.floor(a2 / 32L);
    }

    public /* synthetic */ int getPosition() {
        CashItemFlag a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ CashItemFlag(long l2) {
        void a2;
        void var2_-1;
        void var1_-1;
        CashItemFlag a3;
        CashItemFlag cashItemFlag = a3;
        cashItemFlag.a = 1 << (int)(a2 % 32L);
        cashItemFlag.d = (int)Math.floor((double)(a2 / 32L));
    }

    @Override
    public /* synthetic */ long getValue() {
        CashItemFlag a2;
        return a2.a;
    }

    public static /* synthetic */ CashItemFlag valueOf(String a2) {
        return Enum.valueOf(CashItemFlag.class, a2);
    }

    public static /* synthetic */ {
        ITEMID = new CashItemFlag(MobConstants.ALLATORIxDEMO("K`GyKp"), 0, 0L);
        COUNT = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("pgffg"), 1, 1L);
        PRICE = new CashItemFlag(MobConstants.ALLATORIxDEMO("dP}Aq"), 2, 2L);
        UNK3 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("}}c\u0000"), 3, 3L);
        PRIORITY = new CashItemFlag(MobConstants.ALLATORIxDEMO("RfK{P}Vm"), 4, 4L);
        PERIOD = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("xvzzgw"), 5, 5L);
        UNK6 = new CashItemFlag(MobConstants.ALLATORIxDEMO("WzI\u0002"), 6, 6L);
        MESO = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ev{|"), 7, 7L);
        UNK8 = new CashItemFlag(MobConstants.ALLATORIxDEMO("WzI\f"), 8, 8L);
        GENDER = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ovfwma"), 9, 9L);
        ONSALE = new CashItemFlag(MobConstants.ALLATORIxDEMO("MzQuNq"), 10, 10L);
        FLAGE = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("udrov"), 11, 11L);
        UNK12 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f3\u0006"), 12, 12L);
        UNK13 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u0019\u0000"), 13, 13L);
        UNK14 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f3\u0000"), 14, 14L);
        UNK15 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u0019\u0006"), 15, 15L);
        PACKAGEZ = new CashItemFlag(MobConstants.ALLATORIxDEMO("RuA\u007fCsGn"), 16, 16L);
        UNK17 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u0019\u0004"), 17, 17L);
        UNK18 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f3\f"), 18, 18L);
        TIME_BEGIN = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("|zevwqmta}"), 19, 19L);
        TIME_END = new CashItemFlag(MobConstants.ALLATORIxDEMO("V}Oq]qLp"), 20, 20L);
        UNK21 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u001a\u0002"), 21, 21L);
        UNK22 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f0\u0006"), 22, 22L);
        UNK23 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u001a\u0000"), 23, 23L);
        UNK24 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f0\u0000"), 24, 24L);
        UNK25 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u001a\u0006"), 25, 25L);
        UNK26 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f0\u0002"), 26, 26L);
        UNK27 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u001a\u0004"), 27, 27L);
        UNK28 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f0\f"), 28, 28L);
        UNK29 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u001a\n"), 29, 29L);
        UNK30 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f1\u0004"), 30, 30L);
        UNK31 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u001b\u0002"), 31, 31L);
        UNK32 = new CashItemFlag(MobConstants.ALLATORIxDEMO("aL\u007f1\u0006"), 32, 32L);
        UNK33 = new CashItemFlag(SpecialItemData.ALLATORIxDEMO("ffx\u001b\u0000"), 33, 33L);
        CashItemFlag[] arrcashItemFlag = new CashItemFlag[34];
        arrcashItemFlag[0] = ITEMID;
        arrcashItemFlag[1] = COUNT;
        arrcashItemFlag[2] = PRICE;
        arrcashItemFlag[3] = UNK3;
        arrcashItemFlag[4] = PRIORITY;
        arrcashItemFlag[5] = PERIOD;
        arrcashItemFlag[6] = UNK6;
        arrcashItemFlag[7] = MESO;
        arrcashItemFlag[8] = UNK8;
        arrcashItemFlag[9] = GENDER;
        arrcashItemFlag[10] = ONSALE;
        arrcashItemFlag[11] = FLAGE;
        arrcashItemFlag[12] = UNK12;
        arrcashItemFlag[13] = UNK13;
        arrcashItemFlag[14] = UNK14;
        arrcashItemFlag[15] = UNK15;
        arrcashItemFlag[16] = PACKAGEZ;
        arrcashItemFlag[17] = UNK17;
        arrcashItemFlag[18] = UNK18;
        arrcashItemFlag[19] = TIME_BEGIN;
        arrcashItemFlag[20] = TIME_END;
        arrcashItemFlag[21] = UNK21;
        arrcashItemFlag[22] = UNK22;
        arrcashItemFlag[23] = UNK23;
        arrcashItemFlag[24] = UNK24;
        arrcashItemFlag[25] = UNK25;
        arrcashItemFlag[26] = UNK26;
        arrcashItemFlag[27] = UNK27;
        arrcashItemFlag[28] = UNK28;
        arrcashItemFlag[29] = UNK29;
        arrcashItemFlag[30] = UNK30;
        arrcashItemFlag[31] = UNK31;
        arrcashItemFlag[32] = UNK32;
        arrcashItemFlag[33] = UNK33;
        ALLATORIxDEMO = arrcashItemFlag;
        CashItemFlag.reloadValues();
    }

    public static /* synthetic */ CashItemFlag[] values() {
        return (CashItemFlag[])ALLATORIxDEMO.clone();
    }
}

