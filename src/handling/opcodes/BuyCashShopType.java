/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.WritableIntValueHolder;
import server.MapleShopItem;
import tools.npcgenerator.Instruction;

/*
 * Exception performing whole class analysis ignored.
 */
public final class BuyCashShopType
extends Enum<BuyCashShopType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ BuyCashShopType RELOAD_CS;
    public static final /* synthetic */ /* enum */ BuyCashShopType WISH_LIST;
    private static final /* synthetic */ BuyCashShopType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ BuyCashShopType SLOT_CHARACTER_ADD;
    public static final /* synthetic */ /* enum */ BuyCashShopType UNKNOW_1;
    public static final /* synthetic */ /* enum */ BuyCashShopType INV_TO_CASH;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ BuyCashShopType SLOT_STORAGE_ADD;
    public static final /* synthetic */ /* enum */ BuyCashShopType BUY_MAPLE_POINT;
    public static final /* synthetic */ /* enum */ BuyCashShopType UNKNOW_0;
    public static final /* synthetic */ /* enum */ BuyCashShopType SLOT_INVENTORY_ADD;
    public static final /* synthetic */ /* enum */ BuyCashShopType UNKNOW_2;
    public static final /* synthetic */ /* enum */ BuyCashShopType BUY_ARBITRARY_DOOR;
    public static final /* synthetic */ /* enum */ BuyCashShopType BUY_ITEM_PACKAGE;
    public static final /* synthetic */ /* enum */ BuyCashShopType RING_CRUSH;
    public static final /* synthetic */ /* enum */ BuyCashShopType RANDOM_BOX;
    public static final /* synthetic */ /* enum */ BuyCashShopType GIFT;
    public static final /* synthetic */ /* enum */ BuyCashShopType BUY_ITEM_QUEST;
    public static final /* synthetic */ /* enum */ BuyCashShopType GIFT_PACKAGE;
    public static final /* synthetic */ /* enum */ BuyCashShopType SELL;
    public static final /* synthetic */ /* enum */ BuyCashShopType BUY_ITEM;
    public static final /* synthetic */ /* enum */ BuyCashShopType PENDANT;
    public static final /* synthetic */ /* enum */ BuyCashShopType CASH_TO_INV;
    public static final /* synthetic */ /* enum */ BuyCashShopType RING_FRIEND;

    public static /* synthetic */ BuyCashShopType[] values() {
        return (BuyCashShopType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ BuyCashShopType getCashShopOperationType(int a2) {
        int n2;
        BuyCashShopType[] arrbuyCashShopType = BuyCashShopType.values();
        int n3 = arrbuyCashShopType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            BuyCashShopType buyCashShopType = arrbuyCashShopType[n2];
            if (buyCashShopType.getValue() == a2) {
                return buyCashShopType;
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
    private /* synthetic */ BuyCashShopType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        BuyCashShopType a3;
        BuyCashShopType buyCashShopType = a3;
        a3.d = 0;
        buyCashShopType.d = 0;
        buyCashShopType.d = (short)a2;
    }

    public static /* synthetic */ BuyCashShopType valueOf(String a2) {
        return Enum.valueOf(BuyCashShopType.class, a2);
    }

    @Override
    public /* synthetic */ short getValue() {
        BuyCashShopType a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ {
        UNKNOW_0 = new BuyCashShopType(Instruction.ALLATORIxDEMO("O/Q/U6EQ"), 0, 0);
        BUY_ITEM = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("e)~#n(b1"), 1, 3);
        BUY_ITEM_PACKAGE = new BuyCashShopType(Instruction.ALLATORIxDEMO("X4C>S5_,E1[\"Q ]$"), 2, 30);
        BUY_ITEM_QUEST = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("e)~#n(b1x-r9t("), 3, 32);
        GIFT = new BuyCashShopType(Instruction.ALLATORIxDEMO("](\\5"), 4, 4);
        GIFT_PACKAGE = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("`5a(x,f?l=`9"), 5, 31);
        WISH_LIST = new BuyCashShopType(Instruction.ALLATORIxDEMO("6S2R>V(I5"), 6, 5);
        SLOT_INVENTORY_ADD = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("t0h(x5i*b2s3u%x=c8"), 7, 6);
        SLOT_STORAGE_ADD = new BuyCashShopType(Instruction.ALLATORIxDEMO("I-U5E2N.H ]$E ^%"), 8, 7);
        SLOT_CHARACTER_ADD = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("t0h(x?o=u=d(b.x=c8"), 9, 8);
        CASH_TO_INV = new BuyCashShopType(Instruction.ALLATORIxDEMO("\"[2R>N.E(T7"), 10, 13);
        INV_TO_CASH = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("5i*x(h#d=t4"), 11, 14);
        UNKNOW_2 = new BuyCashShopType(Instruction.ALLATORIxDEMO("O/Q/U6ES"), 12, 15);
        SELL = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("t9k0"), 13, 26);
        RING_FRIEND = new BuyCashShopType(Instruction.ALLATORIxDEMO("3S/]>\\3S$T%"), 14, 29);
        RING_CRUSH = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("u5i;x?u)t4"), 15, 35);
        UNKNOW_1 = new BuyCashShopType(Instruction.ALLATORIxDEMO("O/Q/U6EP"), 16, 41);
        RELOAD_CS = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO(".b0h=c#d/"), 17, 49);
        BUY_MAPLE_POINT = new BuyCashShopType(Instruction.ALLATORIxDEMO("#O8E,[1V$E1U(T5"), 18, 51);
        BUY_ARBITRARY_DOOR = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO("e)~#f.e5s.f.~#c3h."), 19, 215);
        RANDOM_BOX = new BuyCashShopType(Instruction.ALLATORIxDEMO("H T%U,E#U9"), 20, 56);
        PENDANT = new BuyCashShopType(MapleShopItem.ALLATORIxDEMO(",b2c=i("), 21, 10);
        BuyCashShopType[] arrbuyCashShopType = new BuyCashShopType[22];
        arrbuyCashShopType[0] = UNKNOW_0;
        arrbuyCashShopType[1] = BUY_ITEM;
        arrbuyCashShopType[2] = BUY_ITEM_PACKAGE;
        arrbuyCashShopType[3] = BUY_ITEM_QUEST;
        arrbuyCashShopType[4] = GIFT;
        arrbuyCashShopType[5] = GIFT_PACKAGE;
        arrbuyCashShopType[6] = WISH_LIST;
        arrbuyCashShopType[7] = SLOT_INVENTORY_ADD;
        arrbuyCashShopType[8] = SLOT_STORAGE_ADD;
        arrbuyCashShopType[9] = SLOT_CHARACTER_ADD;
        arrbuyCashShopType[10] = CASH_TO_INV;
        arrbuyCashShopType[11] = INV_TO_CASH;
        arrbuyCashShopType[12] = UNKNOW_2;
        arrbuyCashShopType[13] = SELL;
        arrbuyCashShopType[14] = RING_FRIEND;
        arrbuyCashShopType[15] = RING_CRUSH;
        arrbuyCashShopType[16] = UNKNOW_1;
        arrbuyCashShopType[17] = RELOAD_CS;
        arrbuyCashShopType[18] = BUY_MAPLE_POINT;
        arrbuyCashShopType[19] = BUY_ARBITRARY_DOOR;
        arrbuyCashShopType[20] = RANDOM_BOX;
        arrbuyCashShopType[21] = PENDANT;
        ALLATORIxDEMO = arrbuyCashShopType;
        BuyCashShopType.reloadValues();
    }
}

