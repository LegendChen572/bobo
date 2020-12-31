/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import client.MapleTrait;
import client.anticheat.CheatingOffenseEntry;
import handling.WritableIntValueHolder;

/*
 * Exception performing whole class analysis ignored.
 */
public final class AdminNoticeType
extends Enum<AdminNoticeType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ AdminNoticeType GIFT_PACKAGE;
    private static final /* synthetic */ AdminNoticeType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ AdminNoticeType BUY_ITEM;
    public static final /* synthetic */ /* enum */ AdminNoticeType SLOT_INVENTORY_ADD;
    public static final /* synthetic */ /* enum */ AdminNoticeType CASH_TO_INV;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ AdminNoticeType SLOT_STORAGE_ADD;
    public static final /* synthetic */ /* enum */ AdminNoticeType SLOT_CHARACTER_ADD;
    public static final /* synthetic */ /* enum */ AdminNoticeType RING_FRIEND;
    public static final /* synthetic */ /* enum */ AdminNoticeType WISH_LIST;
    public static final /* synthetic */ /* enum */ AdminNoticeType BUY_MAPLE_POINT;
    public static final /* synthetic */ /* enum */ AdminNoticeType GIFT;
    public static final /* synthetic */ /* enum */ AdminNoticeType INV_TO_CASH;
    public static final /* synthetic */ /* enum */ AdminNoticeType UNKNOW_2;
    public static final /* synthetic */ /* enum */ AdminNoticeType RING_CRUSH;
    public static final /* synthetic */ /* enum */ AdminNoticeType UNKNOW_1;
    public static final /* synthetic */ /* enum */ AdminNoticeType RELOAD_CS;
    public static final /* synthetic */ /* enum */ AdminNoticeType UNKNOW_0;
    public static final /* synthetic */ /* enum */ AdminNoticeType BUY_ITEM_PACKAGE;
    public static final /* synthetic */ /* enum */ AdminNoticeType BUY_ARBITRARY_DOOR;
    public static final /* synthetic */ /* enum */ AdminNoticeType BUY_ITEM_QUEST;
    public static final /* synthetic */ /* enum */ AdminNoticeType SELL;

    public static /* synthetic */ AdminNoticeType valueOf(String a2) {
        return Enum.valueOf(AdminNoticeType.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ AdminNoticeType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        AdminNoticeType a3;
        AdminNoticeType adminNoticeType = a3;
        a3.d = 0;
        adminNoticeType.d = 0;
        adminNoticeType.d = (short)a2;
    }

    public static /* synthetic */ AdminNoticeType getCashShopOperationType(int a2) {
        int n2;
        AdminNoticeType[] arradminNoticeType = AdminNoticeType.values();
        int n3 = arradminNoticeType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            AdminNoticeType adminNoticeType = arradminNoticeType[n2];
            if (adminNoticeType.getValue() == a2) {
                return adminNoticeType;
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ AdminNoticeType[] values() {
        return (AdminNoticeType[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ short getValue() {
        AdminNoticeType a2;
        return a2.d;
    }

    public static /* synthetic */ {
        UNKNOW_0 = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("iswssjc\r"), 0, 0);
        BUY_ITEM = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\u001b\u0007\u0000\r\u0010\u0006\u001c\u001f"), 1, 3);
        BUY_ITEM_PACKAGE = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("~hebuiypcm}~w|{x"), 2, 30);
        BUY_ITEM_QUEST = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\u001b\u0007\u0000\r\u0010\u0006\u001c\u001f\u0006\u0003\f\u0017\n\u0006"), 3, 32);
        GIFT = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("{tzi"), 4, 4);
        GIFT_PACKAGE = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\u001e\u001b\u001f\u0006\u0006\u0002\u0018\u0011\u0012\u0013\u001e\u0017"), 5, 31);
        WISH_LIST = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("juntbptoi"), 6, 5);
        SLOT_INVENTORY_ADD = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\n\u001e\u0016\u0006\u0006\u001b\u0017\u0004\u001c\u001c\r\u001d\u000b\u000b\u0006\u0013\u001d\u0016"), 7, 6);
        SLOT_STORAGE_ADD = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("oqsicnhrn|{xc|xy"), 8, 7);
        SLOT_CHARACTER_ADD = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\n\u001e\u0016\u0006\u0006\u0011\u0011\u0013\u000b\u0013\u001a\u0006\u001c\u0000\u0006\u0013\u001d\u0016"), 9, 8);
        CASH_TO_INV = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("~}ntbhrctrk"), 10, 13);
        INV_TO_CASH = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\u001b\u0017\u0004\u0006\u0006\u0016\r\u001a\u0013\n\u001a"), 11, 14);
        UNKNOW_2 = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("iswssjc\u000f"), 12, 15);
        SELL = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\n\u0017\u0015\u001e"), 13, 26);
        RING_FRIEND = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("ous{bzouxry"), 14, 29);
        RING_CRUSH = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\u000b\u001b\u0017\u0015\u0006\u0011\u000b\u0007\n\u001a"), 15, 35);
        UNKNOW_1 = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("iswssjc\f"), 16, 41);
        RELOAD_CS = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\u0000\u001c\u001e\u0016\u0013\u001d\r\u001a\u0001"), 17, 49);
        BUY_MAPLE_POINT = new AdminNoticeType(CheatingOffenseEntry.ALLATORIxDEMO("\u007fidcp}mpxcmstri"), 18, 51);
        BUY_ARBITRARY_DOOR = new AdminNoticeType(MapleTrait.ALLATORIxDEMO("\u001b\u0007\u0000\r\u0018\u0000\u001b\u001b\r\u0000\u0018\u0000\u0000\r\u001d\u001d\u0016\u0000"), 19, 215);
        AdminNoticeType[] arradminNoticeType = new AdminNoticeType[20];
        arradminNoticeType[0] = UNKNOW_0;
        arradminNoticeType[1] = BUY_ITEM;
        arradminNoticeType[2] = BUY_ITEM_PACKAGE;
        arradminNoticeType[3] = BUY_ITEM_QUEST;
        arradminNoticeType[4] = GIFT;
        arradminNoticeType[5] = GIFT_PACKAGE;
        arradminNoticeType[6] = WISH_LIST;
        arradminNoticeType[7] = SLOT_INVENTORY_ADD;
        arradminNoticeType[8] = SLOT_STORAGE_ADD;
        arradminNoticeType[9] = SLOT_CHARACTER_ADD;
        arradminNoticeType[10] = CASH_TO_INV;
        arradminNoticeType[11] = INV_TO_CASH;
        arradminNoticeType[12] = UNKNOW_2;
        arradminNoticeType[13] = SELL;
        arradminNoticeType[14] = RING_FRIEND;
        arradminNoticeType[15] = RING_CRUSH;
        arradminNoticeType[16] = UNKNOW_1;
        arradminNoticeType[17] = RELOAD_CS;
        arradminNoticeType[18] = BUY_MAPLE_POINT;
        arradminNoticeType[19] = BUY_ARBITRARY_DOOR;
        ALLATORIxDEMO = arradminNoticeType;
        AdminNoticeType.reloadValues();
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
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
}

