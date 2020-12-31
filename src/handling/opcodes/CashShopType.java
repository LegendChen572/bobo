/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6070\u6070\u8c37
 */
package handling.opcodes;

import client.messages.ConsoleCommandExecute;
import client.messages.commands.player.\u6070\u6070\u8c37;
import handling.WritableIntValueHolder;

/*
 * Exception performing whole class analysis ignored.
 */
public final class CashShopType
extends Enum<CashShopType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ CashShopType INC_SLOT_STORAGE;
    public static final /* synthetic */ /* enum */ CashShopType INVENTORY;
    public static final /* synthetic */ /* enum */ CashShopType USE_WHEEL;
    public static final /* synthetic */ /* enum */ CashShopType BUY_CS_QUSET_ITEM;
    public static final /* synthetic */ /* enum */ CashShopType GIFT_SEND_FAIL;
    public static final /* synthetic */ /* enum */ CashShopType BUY_PACKAGE;
    public static final /* synthetic */ /* enum */ CashShopType INV_TO_CS;
    public static final /* synthetic */ /* enum */ CashShopType BUY;
    public static final /* synthetic */ /* enum */ CashShopType SHOW_WISHLIST_FAIL;
    public static final /* synthetic */ /* enum */ CashShopType INC_SLOT;
    public static final /* synthetic */ /* enum */ CashShopType CS_TO_INV;
    public static final /* synthetic */ /* enum */ CashShopType FAILED;
    public static final /* synthetic */ /* enum */ CashShopType GIFT_SEND;
    public static final /* synthetic */ /* enum */ CashShopType GIFT_SEND_PACKAGE_FAIL;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ CashShopType BUY_CASHPACKAGE_FAIL;
    public static final /* synthetic */ /* enum */ CashShopType BUY_CSITEM_FAIL;
    public static final /* synthetic */ /* enum */ CashShopType SET_WISHLIST_FAIL;
    public static final /* synthetic */ /* enum */ CashShopType CHANGE_NAME;
    public static final /* synthetic */ /* enum */ CashShopType GIFT_GET;
    public static final /* synthetic */ /* enum */ CashShopType COUPON_REDEEM;
    public static final /* synthetic */ /* enum */ CashShopType GIFT_SEND_PACKAGE;
    public static final /* synthetic */ /* enum */ CashShopType CASHITEM_EXPIRED;
    private static final /* synthetic */ CashShopType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ CashShopType WISH_LIST;
    public static final /* synthetic */ /* enum */ CashShopType WISH_LIST_UPDATE;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ CashShopType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        CashShopType a3;
        CashShopType cashShopType = a3;
        a3.d = 0;
        cashShopType.d = 0;
        cashShopType.d = (short)a2;
    }

    @Override
    public /* synthetic */ short getValue() {
        CashShopType a2;
        return a2.d;
    }

    public static /* synthetic */ CashShopType[] values() {
        return (CashShopType[])ALLATORIxDEMO.clone();
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

    public static /* synthetic */ CashShopType valueOf(String a2) {
        return Enum.valueOf(CashShopType.class, a2);
    }

    public static /* synthetic */ {
        INVENTORY = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("N\u0003Q\bI\u0019H\u001f^"), 0, 70);
        GIFT_GET = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0004'\u0005:\u001c)\u0006:"), 1, 72);
        GIFT_SEND = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("@\u0004A\u0019X\u001eB\u0003C"), 2, 85);
        INC_SLOT = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\n \u00001\u0010\"\f:"), 3, 87);
        INC_SLOT_STORAGE = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("\u0004I\u000eX\u001eK\u0002S\u0012T\u0019H\u001fF\nB"), 4, 91);
        CS_TO_INV = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"-\u00101\u0017!\u001c'\r8"), 5, 95);
        INV_TO_CS = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("N\u0003Q\u0012S\u0002X\u000eT"), 6, 97);
        GIFT_SEND_PACKAGE = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)")\n(\u00171\u0010+\r*\u001c>\u0002-\b/\u0004+"), 7, 130);
        CASHITEM_EXPIRED = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("\u000eF\u001eO\u0004S\bJ\u0012B\u0015W\u0004U\bC"), 8, 113);
        BUY = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)",\u00167"), 9, 78);
        FAILED = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("\u000bF\u0004K\bC"), 10, 86);
        BUY_PACKAGE = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)",\u00167\u001c>\u0002-\b/\u0004+"), 11, 128);
        WISH_LIST = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("P\u0004T\u0005X\u0001N\u001eS"), 12, 74);
        WISH_LIST_UPDATE = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0014'\u0010&\u001c\"\n=\u00171\u0016>\u0007/\u0017+"), 13, 76);
        COUPON_REDEEM = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("D\u0002R\u001dH\u0003X\u001fB\tB\bJ"), 14, 98);
        GIFT_SEND_FAIL = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0004'\u0005:\u001c=\u0006 \u00071\u0005/\n\""), 15, 86);
        GIFT_SEND_PACKAGE_FAIL = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("\nN\u000bS\u0012T\bI\tX\u001dF\u000eL\f@\bX\u000bF\u0004K"), 16, 131);
        BUY_CASHPACKAGE_FAIL = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0001;\u001a1\u0000/\u0010&\u0013/\u0000%\u0002)\u00061\u0005/\n\""), 17, 129);
        BUY_CSITEM_FAIL = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("E\u0018^\u0012D\u001eN\u0019B\u0000X\u000bF\u0004K"), 18, 79);
        SET_WISHLIST_FAIL = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"=\u0006:\u001c9\n=\u000b\"\n=\u00171\u0005/\n\""), 19, 77);
        SHOW_WISHLIST_FAIL = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("\u001eO\u0002P\u0012P\u0004T\u0005K\u0004T\u0019X\u000bF\u0004K"), 20, 75);
        BUY_CS_QUSET_ITEM = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)",\u00167\u001c-\u00101\u0012;\u0010+\u00171\n:\u0006#"), 21, 146);
        CHANGE_NAME = new CashShopType(ConsoleCommandExecute.ALLATORIxDEMO("D\u0005F\u0003@\bX\u0003F\u0000B"), 22, 134);
        USE_WHEEL = new CashShopType(\u6070\u6070\u8c37.ALLATORIxDEMO((String)";\u0010+\u001c9\u000b+\u0006\""), 23, 19);
        CashShopType[] arrcashShopType = new CashShopType[24];
        arrcashShopType[0] = INVENTORY;
        arrcashShopType[1] = GIFT_GET;
        arrcashShopType[2] = GIFT_SEND;
        arrcashShopType[3] = INC_SLOT;
        arrcashShopType[4] = INC_SLOT_STORAGE;
        arrcashShopType[5] = CS_TO_INV;
        arrcashShopType[6] = INV_TO_CS;
        arrcashShopType[7] = GIFT_SEND_PACKAGE;
        arrcashShopType[8] = CASHITEM_EXPIRED;
        arrcashShopType[9] = BUY;
        arrcashShopType[10] = FAILED;
        arrcashShopType[11] = BUY_PACKAGE;
        arrcashShopType[12] = WISH_LIST;
        arrcashShopType[13] = WISH_LIST_UPDATE;
        arrcashShopType[14] = COUPON_REDEEM;
        arrcashShopType[15] = GIFT_SEND_FAIL;
        arrcashShopType[16] = GIFT_SEND_PACKAGE_FAIL;
        arrcashShopType[17] = BUY_CASHPACKAGE_FAIL;
        arrcashShopType[18] = BUY_CSITEM_FAIL;
        arrcashShopType[19] = SET_WISHLIST_FAIL;
        arrcashShopType[20] = SHOW_WISHLIST_FAIL;
        arrcashShopType[21] = BUY_CS_QUSET_ITEM;
        arrcashShopType[22] = CHANGE_NAME;
        arrcashShopType[23] = USE_WHEEL;
        ALLATORIxDEMO = arrcashShopType;
        CashShopType.reloadValues();
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }
}

