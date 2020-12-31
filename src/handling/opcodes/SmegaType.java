/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 */
package handling.opcodes;

import client.messages.commands.player.\u6bd4\u5947\u8c37;
import handling.WritableIntValueHolder;
import tools.Pair;

/*
 * Exception performing whole class analysis ignored.
 */
public final class SmegaType
extends Enum<SmegaType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ SmegaType BOX_MESSAGE;
    private static final /* synthetic */ SmegaType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ SmegaType CAKE_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType LOVE_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType BLUE_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType UNK_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType PIE_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType UNK_0_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType SCROLL_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType POP_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType NPC_POP_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType SKULL_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType TRIPLE_MEESAGE;
    public static final /* synthetic */ /* enum */ SmegaType ITEM_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType EFFICIENCY_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType GACH_MESSAGE;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ SmegaType REDMEGA_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType CAKES_MESSAGE;
    public static final /* synthetic */ /* enum */ SmegaType RED_MESSAGE;

    public static /* synthetic */ SmegaType[] values() {
        return (SmegaType[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ short getValue() {
        SmegaType a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ SmegaType valueOf(String a2) {
        return Enum.valueOf(SmegaType.class, a2);
    }

    public static /* synthetic */ SmegaType getSmegaType(int a2) {
        int n2;
        SmegaType[] arrsmegaType = SmegaType.values();
        int n3 = arrsmegaType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            SmegaType smegaType = arrsmegaType[n2];
            if (smegaType.getValue() == a2) {
                return smegaType;
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
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK], 1[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ SmegaType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        SmegaType a3;
        SmegaType smegaType = a3;
        a3.d = 0;
        smegaType.d = 0;
        smegaType.d = (short)a2;
    }

    public static /* synthetic */ {
        UNK_0_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"!\u0003?\u0012D\u00129\b'\u001e5\n1"), 0, 0);
        POP_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("L+L;Q!O7]#Y"), 1, 1);
        REDMEGA_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"&\b0\u00001\n5\u00129\b'\u001e5\n1"), 2, 2);
        EFFICIENCY_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("!Z\"U'U!R'E;Q!O7]#Y"), 3, 3);
        SCROLL_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u001e7\u001f;\u00018\u00129\b'\u001e5\n1"), 4, 4);
        RED_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("N!X;Q!O7]#Y"), 5, 5);
        BLUE_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u000f8\u00181\u00129\b'\u001e5\n1"), 6, 6);
        NPC_POP_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("R4_;L+L;Q!O7]#Y"), 7, 7);
        ITEM_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0004 \b9\u00129\b'\u001e5\n1"), 8, 8);
        CAKE_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("']/Y;Q!O7]#Y"), 9, 9);
        TRIPLE_MEESAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0019&\u0004$\u00011\u00129\b1\u001e5\n1"), 10, 10);
        LOVE_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("(S2Y;Q!O7]#Y"), 11, 11);
        SKULL_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"'\u0006!\u00018\u00129\b'\u001e5\n1"), 12, 12);
        GACH_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("#]'T;Q!O7]#Y"), 13, 13);
        UNK_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"!\u0003?\u00129\b'\u001e5\n1"), 14, 11);
        BOX_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("^+D;Q!O7]#Y"), 15, 17);
        CAKES_MESSAGE = new SmegaType(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"7\f?\b'\u00129\b'\u001e5\n1"), 16, 255);
        PIE_MESSAGE = new SmegaType(Pair.ALLATORIxDEMO("L-Y;Q!O7]#Y"), 17, 255);
        SmegaType[] arrsmegaType = new SmegaType[18];
        arrsmegaType[0] = UNK_0_MESSAGE;
        arrsmegaType[1] = POP_MESSAGE;
        arrsmegaType[2] = REDMEGA_MESSAGE;
        arrsmegaType[3] = EFFICIENCY_MESSAGE;
        arrsmegaType[4] = SCROLL_MESSAGE;
        arrsmegaType[5] = RED_MESSAGE;
        arrsmegaType[6] = BLUE_MESSAGE;
        arrsmegaType[7] = NPC_POP_MESSAGE;
        arrsmegaType[8] = ITEM_MESSAGE;
        arrsmegaType[9] = CAKE_MESSAGE;
        arrsmegaType[10] = TRIPLE_MEESAGE;
        arrsmegaType[11] = LOVE_MESSAGE;
        arrsmegaType[12] = SKULL_MESSAGE;
        arrsmegaType[13] = GACH_MESSAGE;
        arrsmegaType[14] = UNK_MESSAGE;
        arrsmegaType[15] = BOX_MESSAGE;
        arrsmegaType[16] = CAKES_MESSAGE;
        arrsmegaType[17] = PIE_MESSAGE;
        ALLATORIxDEMO = arrsmegaType;
        SmegaType.reloadValues();
    }
}

