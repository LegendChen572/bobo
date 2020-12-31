/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.WritableIntValueHolder;
import server.MapleShopItem;
import tools.MaplePacketOperation;

/*
 * Exception performing whole class analysis ignored.
 */
public final class StatusInfoType
extends Enum<StatusInfoType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ StatusInfoType STATUS_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType INC_FATIGUE_BY_REST;
    public static final /* synthetic */ /* enum */ StatusInfoType TRAIT_MAX;
    public static final /* synthetic */ /* enum */ StatusInfoType FAME_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType SHOW_INVENTORY_GAIN;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ StatusInfoType TRAIT_GAIN;
    public static final /* synthetic */ /* enum */ StatusInfoType FISHING_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType EXP_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType ITEM_EXPIRED;
    public static final /* synthetic */ /* enum */ StatusInfoType SP_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType UPDATE_INFO_QUEST;
    private static final /* synthetic */ StatusInfoType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ StatusInfoType QUEST_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType BP_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType GP_MSG;
    public static final /* synthetic */ /* enum */ StatusInfoType UPDATE_QUEST;
    public static final /* synthetic */ /* enum */ StatusInfoType SHOW_INVENTORY_GAIN_INCHAT;
    public static final /* synthetic */ /* enum */ StatusInfoType SHOW_INFO;

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

    public static /* synthetic */ {
        SHOW_INVENTORY_GAIN = new StatusInfoType(MapleShopItem.ALLATORIxDEMO("/o3p#n2q9i(h.~#`=n2"), 0, 0);
        UPDATE_QUEST = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("u\u0015d\u0004t\u0000\u007f\u0014u\u0000s\u0011"), 1, 1);
        ITEM_EXPIRED = new StatusInfoType(MapleShopItem.ALLATORIxDEMO("n(b1x9\u007f,n.b8"), 2, 2);
        EXP_MSG = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("\u0000x\u0015\u007f\bs\u0002"), 3, 3);
        SP_MSG = new StatusInfoType(MapleShopItem.ALLATORIxDEMO("t,x1t;"), 4, 3);
        FAME_MSG = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("f\u0004m\u0000\u007f\bs\u0002"), 5, 4);
        SHOW_INVENTORY_GAIN_INCHAT = new StatusInfoType(MapleShopItem.ALLATORIxDEMO("t4h+x5i*b2s3u%x;f5i#n2d4f("), 6, 5);
        GP_MSG = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("g\u0015\u007f\bs\u0002"), 7, 6);
        STATUS_MSG = new StatusInfoType(MapleShopItem.ALLATORIxDEMO("t(f(r/x1t;"), 8, 7);
        QUEST_MSG = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("\u0014u\u0000s\u0011\u007f\bs\u0002"), 9, 9);
        UPDATE_INFO_QUEST = new StatusInfoType(MapleShopItem.ALLATORIxDEMO(")w8f(b#n2a3x-r9t("), 10, 10);
        SHOW_INFO = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("\u0016h\nw\u001ai\u000bf\n"), 11, 14);
        FISHING_MSG = new StatusInfoType(MapleShopItem.ALLATORIxDEMO(":n/o5i;x1t;"), 12, 16);
        TRAIT_GAIN = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("t\u0017a\ft\u001ag\u0004i\u000b"), 13, 16);
        TRAIT_MAX = new StatusInfoType(MapleShopItem.ALLATORIxDEMO("(u=n(x1f$"), 14, 17);
        INC_FATIGUE_BY_REST = new StatusInfoType(MaplePacketOperation.ALLATORIxDEMO("\fn\u0006\u007f\u0003a\u0011i\u0002u\u0000\u007f\u0007y\u001ar\u0000s\u0011"), 15, 20);
        BP_MSG = new StatusInfoType(MapleShopItem.ALLATORIxDEMO("e,x1t;"), 16, 23);
        StatusInfoType[] arrstatusInfoType = new StatusInfoType[17];
        arrstatusInfoType[0] = SHOW_INVENTORY_GAIN;
        arrstatusInfoType[1] = UPDATE_QUEST;
        arrstatusInfoType[2] = ITEM_EXPIRED;
        arrstatusInfoType[3] = EXP_MSG;
        arrstatusInfoType[4] = SP_MSG;
        arrstatusInfoType[5] = FAME_MSG;
        arrstatusInfoType[6] = SHOW_INVENTORY_GAIN_INCHAT;
        arrstatusInfoType[7] = GP_MSG;
        arrstatusInfoType[8] = STATUS_MSG;
        arrstatusInfoType[9] = QUEST_MSG;
        arrstatusInfoType[10] = UPDATE_INFO_QUEST;
        arrstatusInfoType[11] = SHOW_INFO;
        arrstatusInfoType[12] = FISHING_MSG;
        arrstatusInfoType[13] = TRAIT_GAIN;
        arrstatusInfoType[14] = TRAIT_MAX;
        arrstatusInfoType[15] = INC_FATIGUE_BY_REST;
        arrstatusInfoType[16] = BP_MSG;
        ALLATORIxDEMO = arrstatusInfoType;
        StatusInfoType.reloadValues();
    }

    public static /* synthetic */ StatusInfoType valueOf(String a2) {
        return Enum.valueOf(StatusInfoType.class, a2);
    }

    public static /* synthetic */ StatusInfoType[] values() {
        return (StatusInfoType[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ short getValue() {
        StatusInfoType a2;
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
    private /* synthetic */ StatusInfoType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        StatusInfoType a3;
        StatusInfoType statusInfoType = a3;
        a3.d = 0;
        statusInfoType.d = 0;
        statusInfoType.d = (short)a2;
    }
}

