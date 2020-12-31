/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package handling.opcodes;

import client.messages.commands.GM.\u65b0\u661f\u8c37;
import handling.WritableIntValueHolder;
import server.MapleShopItem;

/*
 * Exception performing whole class analysis ignored.
 */
public final class GmEffectType
extends Enum<GmEffectType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ GmEffectType UNMUTE_MSG_SEND;
    public static final /* synthetic */ /* enum */ GmEffectType BAN_ATTACK;
    private /* synthetic */ short d;
    private static final /* synthetic */ GmEffectType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ GmEffectType UNMUTE;
    public static final /* synthetic */ /* enum */ GmEffectType WARRING_SEND;
    public static final /* synthetic */ /* enum */ GmEffectType UNJAILBAN;
    public static final /* synthetic */ /* enum */ GmEffectType UNBAN_MSG;
    public static final /* synthetic */ /* enum */ GmEffectType ADMIN_WHITE_NOTICE;
    public static final /* synthetic */ /* enum */ GmEffectType WARRING_PLAYER_SEND;
    public static final /* synthetic */ /* enum */ GmEffectType UNBAN_ATTACK;
    public static final /* synthetic */ /* enum */ GmEffectType JAILBAN;
    public static final /* synthetic */ /* enum */ GmEffectType MUTE;
    public static final /* synthetic */ /* enum */ GmEffectType MUTE_MSG_SEND;

    public static /* synthetic */ GmEffectType valueOf(String a2) {
        return Enum.valueOf(GmEffectType.class, a2);
    }

    public static /* synthetic */ GmEffectType[] values() {
        return (GmEffectType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        MUTE_MSG_SEND = new GmEffectType(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0007(\u001e8\u00150\u0019:\u0015.\u000f3\u000e"), 0, 33);
        UNMUTE_MSG_SEND = new GmEffectType(MapleShopItem.ALLATORIxDEMO(")i1r(b#j/`#t9i8"), 1, 34);
        MUTE = new GmEffectType(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"0\u001f)\u000f"), 2, 35);
        UNMUTE = new GmEffectType(MapleShopItem.ALLATORIxDEMO("r2j)s9"), 3, 36);
        BAN_ATTACK = new GmEffectType(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"?\u000b3\u0015<\u001e)\u000b>\u0001"), 4, 37);
        UNBAN_ATTACK = new GmEffectType(MapleShopItem.ALLATORIxDEMO("r2e=i#f(s=d7"), 5, 38);
        JAILBAN = new GmEffectType(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0000<\u00031\b<\u0004"), 6, 39);
        UNJAILBAN = new GmEffectType(MapleShopItem.ALLATORIxDEMO(")i6f5k>f2"), 7, 40);
        UNBAN_MSG = new GmEffectType(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u001f3\b<\u0004\"\u0007.\r"), 8, 30);
        WARRING_SEND = new GmEffectType(MapleShopItem.ALLATORIxDEMO("p=u.n2`#t9i8"), 9, 42);
        WARRING_PLAYER_SEND = new GmEffectType(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u001d<\u0018/\u00033\r\"\u001a1\u000b$\u000f/\u0015.\u000f3\u000e"), 10, 46);
        ADMIN_WHITE_NOTICE = new GmEffectType(MapleShopItem.ALLATORIxDEMO("f8j5i#p4n(b#i3s5d9"), 11, 117);
        GmEffectType[] arrgmEffectType = new GmEffectType[12];
        arrgmEffectType[0] = MUTE_MSG_SEND;
        arrgmEffectType[1] = UNMUTE_MSG_SEND;
        arrgmEffectType[2] = MUTE;
        arrgmEffectType[3] = UNMUTE;
        arrgmEffectType[4] = BAN_ATTACK;
        arrgmEffectType[5] = UNBAN_ATTACK;
        arrgmEffectType[6] = JAILBAN;
        arrgmEffectType[7] = UNJAILBAN;
        arrgmEffectType[8] = UNBAN_MSG;
        arrgmEffectType[9] = WARRING_SEND;
        arrgmEffectType[10] = WARRING_PLAYER_SEND;
        arrgmEffectType[11] = ADMIN_WHITE_NOTICE;
        ALLATORIxDEMO = arrgmEffectType;
        GmEffectType.reloadValues();
    }

    public static /* synthetic */ GmEffectType getGmEffectType(int a2) {
        int n2;
        GmEffectType[] arrgmEffectType = GmEffectType.values();
        int n3 = arrgmEffectType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            GmEffectType gmEffectType = arrgmEffectType[n2];
            if (gmEffectType.getValue() == a2) {
                return gmEffectType;
            }
            n4 = ++n2;
        }
        return null;
    }

    @Override
    public /* synthetic */ short getValue() {
        GmEffectType a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ GmEffectType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        GmEffectType a3;
        GmEffectType gmEffectType = a3;
        a3.d = 0;
        gmEffectType.d = 0;
        gmEffectType.d = (short)a2;
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

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }
}

