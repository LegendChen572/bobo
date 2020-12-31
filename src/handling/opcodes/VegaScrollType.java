/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.WritableIntValueHolder;
import tools.Quadra;
import tools.wztosql.DumpMobName;

/*
 * Exception performing whole class analysis ignored.
 */
public final class VegaScrollType
extends Enum<VegaScrollType>
implements WritableIntValueHolder {
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ VegaScrollType END;
    public static final /* synthetic */ /* enum */ VegaScrollType ERROR;
    private static final /* synthetic */ VegaScrollType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ VegaScrollType FAILED;
    public static final /* synthetic */ /* enum */ VegaScrollType SUCCESS;

    public static /* synthetic */ VegaScrollType[] values() {
        return (VegaScrollType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ VegaScrollType valueOf(String a2) {
        return Enum.valueOf(VegaScrollType.class, a2);
    }

    @Override
    public /* synthetic */ short getValue() {
        VegaScrollType a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ VegaScrollType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        VegaScrollType a3;
        VegaScrollType vegaScrollType = a3;
        a3.d = 0;
        vegaScrollType.d = 0;
        vegaScrollType.d = (short)a2;
    }

    public static /* synthetic */ {
        SUCCESS = new VegaScrollType(DumpMobName.ALLATORIxDEMO("F\u0005V\u0013P\u0003F"), 0, 60);
        FAILED = new VegaScrollType(Quadra.ALLATORIxDEMO("p\b\u007f\u0005s\r"), 1, 65);
        END = new VegaScrollType(DumpMobName.ALLATORIxDEMO("P\u001eQ"), 2, 61);
        ERROR = new VegaScrollType(Quadra.ALLATORIxDEMO("\fd\u001by\u001b"), 3, 63);
        VegaScrollType[] arrvegaScrollType = new VegaScrollType[4];
        arrvegaScrollType[0] = SUCCESS;
        arrvegaScrollType[1] = FAILED;
        arrvegaScrollType[2] = END;
        arrvegaScrollType[3] = ERROR;
        ALLATORIxDEMO = arrvegaScrollType;
        VegaScrollType.reloadValues();
    }

    public static /* synthetic */ VegaScrollType getCashShopOperationType(int a2) {
        int n2;
        VegaScrollType[] arrvegaScrollType = VegaScrollType.values();
        int n3 = arrvegaScrollType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            VegaScrollType vegaScrollType = arrvegaScrollType[n2];
            if (vegaScrollType.getValue() == a2) {
                return vegaScrollType;
            }
            n4 = ++n2;
        }
        return null;
    }

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
}

