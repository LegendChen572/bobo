/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.WritableIntValueHolder;
import server.maps.MapNameData;
import tools.use.GetMACAddress;

/*
 * Exception performing whole class analysis ignored.
 */
public final class PlayerInteraction
extends Enum<PlayerInteraction>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ PlayerInteraction \u95dc\u9589\u7cbe\u9748\u5546\u4eba;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u53d6\u6d88\u96e2\u958b;
    public static final /* synthetic */ /* enum */ PlayerInteraction TRADE_SOMETHING;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u8981\u6c42\u5e73\u624b;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u6e96\u5099;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u958b\u59cb;
    public static final /* synthetic */ /* enum */ PlayerInteraction VISIT;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u9053\u5177;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u8a2d\u5b9a\u6953\u5e63;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u56de\u61c9\u5e73\u624b;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u958b\u555f\u7cbe\u9748\u5546\u4eba;
    public static final /* synthetic */ /* enum */ PlayerInteraction MERCHANT_EXIT;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u67e5\u770b;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u62d2\u7d55\u4ea4\u6613;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u500b\u4eba\u5546\u5e97\u6dfb\u52a0\u9053\u5177;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u6dfb\u52a0\u9053\u5177;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u56de\u8986\u91cd\u505a;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u8a2d\u5b9a\u9053\u5177;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7ba1\u7406\u54e1\u4fee\u6539\u5546\u5e97\u540d\u7a31;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u8e22\u73a9\u5bb6;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u96e2\u958b\u7cbe\u9748\u5546\u4eba;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u6536\u8cfc\u9053\u5177;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u672a\u6e96\u5099\u5b8c\u6210;
    private static final /* synthetic */ PlayerInteraction[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u79fb\u9664\u7269\u54c1;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7cbe\u9748\u5546\u4eba\u6dfb\u52a0\u6536\u8cfc\u9053\u5177;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u4f7f\u7528\u7cbe\u9748\u5546\u4eba;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u904a\u6232\u96e2\u958b\u5f8c;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u78ba\u8a8d\u4ea4\u6613;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u9078\u64c7\u5361\u7247;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u6dfb\u52a0;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u653e\u68c4;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u6574\u7406\u7cbe\u9748\u5546\u4eba;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u500b\u4eba\u5546\u5e97\u8cfc\u8cb7\u9053\u5177;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u79fb\u52d5\u4e94\u5b50\u68cb;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u9080\u8acb\u4ea4\u6613;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u958b\u555f;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u96e2\u958b;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u5275\u7acb;
    public static final /* synthetic */ /* enum */ PlayerInteraction unk;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u8981\u6c42\u91cd\u505a;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u66f4\u65b0\u5167\u5bb9;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7cbe\u9748\u5546\u4eba\u8a2a\u5ba2\u67e5\u770b;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u5c0d\u8a71;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u79fb\u9664;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u8df3\u904e;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u500b\u4eba\u5546\u5e97\u79fb\u9664\u9053\u5177;
    public static final /* synthetic */ /* enum */ PlayerInteraction \u5254\u9664;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ PlayerInteraction(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        PlayerInteraction a3;
        PlayerInteraction playerInteraction = a3;
        a3.d = 0;
        playerInteraction.d = 0;
        playerInteraction.d = (short)a2;
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

    public static /* synthetic */ PlayerInteraction getActionOperationType(int a2) {
        int n2;
        PlayerInteraction[] arrplayerInteraction = PlayerInteraction.values();
        int n3 = arrplayerInteraction.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            PlayerInteraction playerInteraction = arrplayerInteraction[n2];
            if (playerInteraction.getValue() == a2) {
                return playerInteraction;
            }
            n4 = ++n2;
        }
        return null;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ PlayerInteraction valueOf(String a2) {
        return Enum.valueOf(PlayerInteraction.class, a2);
    }

    public static /* synthetic */ PlayerInteraction[] values() {
        return (PlayerInteraction[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ short getValue() {
        PlayerInteraction a2;
        return a2.d;
    }

    public static /* synthetic */ {
        \u5275\u7acb = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u526c\u7aa8"), 0, 0);
        \u9080\u8acb\u4ea4\u6613 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u9090\u8a8e\u4eb4\u6656"), 1, 2);
        \u62d2\u7d55\u4ea4\u6613 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u62cb\u7d36\u4ebd\u6670"), 2, 3);
        VISIT = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u0013Y\u0016Y\u0011"), 3, 4);
        \u5c0d\u8a71 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u5c14\u8a12"), 4, 6);
        \u4f7f\u7528\u7cbe\u9748\u5546\u4eba = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u4f6f\u756d\u7cae\u970d\u5556\u4eff"), 5, 7);
        \u96e2\u958b = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u96fb\u95e8"), 6, 10);
        \u958b\u555f = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u959b\u551a"), 7, 11);
        \u8a2d\u5b9a\u9053\u5177 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u8a34\u5bf9\u904a\u5114"), 8, 14);
        \u8a2d\u5b9a\u6953\u5e63 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u8a3d\u5bdf\u6943\u5e26"), 9, 15);
        \u78ba\u8a8d\u4ea4\u6613 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u78a3\u8aee\u4ebd\u6670"), 10, 16);
        TRADE_SOMETHING = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u0011B\u0004T\u0000O\u0016_\bU\u0011X\f^\u0002"), 11, 18);
        \u500b\u4eba\u5546\u5e97\u6dfb\u52a0\u9053\u5177 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u5012\u4ed9\u555f\u5ef4\u6de2\u52c3\u904a\u5114"), 12, 19);
        \u500b\u4eba\u5546\u5e97\u8cfc\u8cb7\u9053\u5177 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u501b\u4eff\u5556\u5ed2\u8cec\u8cf2\u9043\u5132"), 13, 20);
        \u66f4\u65b0\u5167\u5bb9 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u66ed\u65d3\u517e\u5bda"), 14, 22);
        \u500b\u4eba\u5546\u5e97\u79fb\u9664\u9053\u5177 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u501b\u4eff\u5556\u5ed2\u79eb\u9621\u9043\u5132"), 15, 24);
        \u8e22\u73a9\u5bb6 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u8e41\u73b0\u5bd5"), 16, 25);
        MERCHANT_EXIT = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\bU\u0017S\rQ\u000bD\u001aU\u001dY\u0011"), 17, 27);
        \u6dfb\u52a0\u9053\u5177 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u6de2\u52c3\u904a\u5114"), 18, 30);
        \u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u9053\u5177 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u7cae\u970d\u5556\u4eff\u8cec\u8cf2\u9043\u5132"), 19, 31);
        \u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u6536\u8cfc\u9053\u5177 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u7ca7\u972b\u555f\u4ed9\u8ce5\u8cd4\u652f\u8c9f\u904a\u5114"), 20, 33);
        \u79fb\u9664\u7269\u54c1 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u79eb\u9621\u7279\u5484"), 21, 35);
        \u958b\u555f\u7cbe\u9748\u5546\u4eba = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u9592\u553c\u7ca7\u972b\u555f\u4ed9"), 22, 36);
        \u6574\u7406\u7cbe\u9748\u5546\u4eba = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u6564\u7443\u7cae\u970d\u5556\u4eff"), 23, 37);
        \u95dc\u9589\u7cbe\u9748\u5546\u4eba = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u95c5\u95ea\u7ca7\u972b\u555f\u4ed9"), 24, 38);
        unk = new PlayerInteraction(MapNameData.ALLATORIxDEMO("0~."), 25, 40);
        \u7ba1\u7406\u54e1\u4fee\u6539\u5546\u5e97\u540d\u7a31 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u7bc2\u741f\u5482\u4ff7\u655a\u555f\u5ef4\u5414\u7a52"), 26, 42);
        \u7cbe\u9748\u5546\u4eba\u8a2a\u5ba2\u67e5\u770b = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u7cae\u970d\u5556\u4eff\u8a3a\u5be7\u67f5\u774e"), 27, 43);
        \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u67e5\u770b = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u7cdd\u9751\u5525\u4ea3\u9eb2\u5414\u55cd\u67fc\u7768"), 28, 44);
        \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u6dfb\u52a0 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u7cfb\u9758\u5503\u4eaa\u9e94\u541d\u55eb\u6deb\u52e5"), 29, 45);
        \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u79fb\u9664 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u7cdd\u9751\u5525\u4ea3\u9eb2\u5414\u55cd\u79e2\u9607"), 30, 46);
        \u8981\u6c42\u5e73\u624b = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u8991\u6c07\u5e63\u620e"), 31, 47);
        \u56de\u61c9\u5e73\u624b = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u56c7\u61aa\u5e6a\u6228"), 32, 48);
        \u653e\u68c4 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u652e\u6881"), 33, 49);
        \u8981\u6c42\u91cd\u505a = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u8998\u6c21\u91d4\u5039"), 34, 51);
        \u56de\u8986\u91cd\u505a = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u56ce\u89c3\u91dd\u501f"), 35, 52);
        \u904a\u6232\u96e2\u958b\u5f8c = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u9029\u622b\u9681\u9592\u5fef"), 36, 53);
        \u53d6\u6d88\u96e2\u958b = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u53c6\u6dcd\u96f2\u95ce"), 37, 54);
        \u6e96\u5099 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u6e8f\u50fa"), 38, 55);
        \u672a\u6e96\u5099\u5b8c\u6210 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u676f\u6e86\u50dc\u5b9c\u6255"), 39, 56);
        \u5254\u9664 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u524d\u9607"), 40, 57);
        \u958b\u59cb = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u959b\u598e"), 41, 58);
        \u8df3\u904e = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u8dea\u902d"), 42, 60);
        \u79fb\u52d5\u4e94\u5b50\u68cb = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u79be\u52c5\u4ed1\u5b40\u688e"), 43, 61);
        \u9078\u64c7\u5361\u7247 = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u9061\u64a4\u5378\u7224"), 44, 65);
        \u7cbe\u9748\u5546\u4eba\u6dfb\u52a0\u6536\u8cfc\u9053\u5177 = new PlayerInteraction(MapNameData.ALLATORIxDEMO("\u7cae\u970d\u5556\u4eff\u6deb\u52e5\u6526\u8cb9\u9043\u5132"), 45, 153);
        \u96e2\u958b\u7cbe\u9748\u5546\u4eba = new PlayerInteraction(GetMACAddress.ALLATORIxDEMO("\u96fb\u95e8\u7ca7\u972b\u555f\u4ed9"), 46, 29);
        PlayerInteraction[] arrplayerInteraction = new PlayerInteraction[47];
        arrplayerInteraction[0] = \u5275\u7acb;
        arrplayerInteraction[1] = \u9080\u8acb\u4ea4\u6613;
        arrplayerInteraction[2] = \u62d2\u7d55\u4ea4\u6613;
        arrplayerInteraction[3] = VISIT;
        arrplayerInteraction[4] = \u5c0d\u8a71;
        arrplayerInteraction[5] = \u4f7f\u7528\u7cbe\u9748\u5546\u4eba;
        arrplayerInteraction[6] = \u96e2\u958b;
        arrplayerInteraction[7] = \u958b\u555f;
        arrplayerInteraction[8] = \u8a2d\u5b9a\u9053\u5177;
        arrplayerInteraction[9] = \u8a2d\u5b9a\u6953\u5e63;
        arrplayerInteraction[10] = \u78ba\u8a8d\u4ea4\u6613;
        arrplayerInteraction[11] = TRADE_SOMETHING;
        arrplayerInteraction[12] = \u500b\u4eba\u5546\u5e97\u6dfb\u52a0\u9053\u5177;
        arrplayerInteraction[13] = \u500b\u4eba\u5546\u5e97\u8cfc\u8cb7\u9053\u5177;
        arrplayerInteraction[14] = \u66f4\u65b0\u5167\u5bb9;
        arrplayerInteraction[15] = \u500b\u4eba\u5546\u5e97\u79fb\u9664\u9053\u5177;
        arrplayerInteraction[16] = \u8e22\u73a9\u5bb6;
        arrplayerInteraction[17] = MERCHANT_EXIT;
        arrplayerInteraction[18] = \u6dfb\u52a0\u9053\u5177;
        arrplayerInteraction[19] = \u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u9053\u5177;
        arrplayerInteraction[20] = \u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u6536\u8cfc\u9053\u5177;
        arrplayerInteraction[21] = \u79fb\u9664\u7269\u54c1;
        arrplayerInteraction[22] = \u958b\u555f\u7cbe\u9748\u5546\u4eba;
        arrplayerInteraction[23] = \u6574\u7406\u7cbe\u9748\u5546\u4eba;
        arrplayerInteraction[24] = \u95dc\u9589\u7cbe\u9748\u5546\u4eba;
        arrplayerInteraction[25] = unk;
        arrplayerInteraction[26] = \u7ba1\u7406\u54e1\u4fee\u6539\u5546\u5e97\u540d\u7a31;
        arrplayerInteraction[27] = \u7cbe\u9748\u5546\u4eba\u8a2a\u5ba2\u67e5\u770b;
        arrplayerInteraction[28] = \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u67e5\u770b;
        arrplayerInteraction[29] = \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u6dfb\u52a0;
        arrplayerInteraction[30] = \u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u79fb\u9664;
        arrplayerInteraction[31] = \u8981\u6c42\u5e73\u624b;
        arrplayerInteraction[32] = \u56de\u61c9\u5e73\u624b;
        arrplayerInteraction[33] = \u653e\u68c4;
        arrplayerInteraction[34] = \u8981\u6c42\u91cd\u505a;
        arrplayerInteraction[35] = \u56de\u8986\u91cd\u505a;
        arrplayerInteraction[36] = \u904a\u6232\u96e2\u958b\u5f8c;
        arrplayerInteraction[37] = \u53d6\u6d88\u96e2\u958b;
        arrplayerInteraction[38] = \u6e96\u5099;
        arrplayerInteraction[39] = \u672a\u6e96\u5099\u5b8c\u6210;
        arrplayerInteraction[40] = \u5254\u9664;
        arrplayerInteraction[41] = \u958b\u59cb;
        arrplayerInteraction[42] = \u8df3\u904e;
        arrplayerInteraction[43] = \u79fb\u52d5\u4e94\u5b50\u68cb;
        arrplayerInteraction[44] = \u9078\u64c7\u5361\u7247;
        arrplayerInteraction[45] = \u7cbe\u9748\u5546\u4eba\u6dfb\u52a0\u6536\u8cfc\u9053\u5177;
        arrplayerInteraction[46] = \u96e2\u958b\u7cbe\u9748\u5546\u4eba;
        ALLATORIxDEMO = arrplayerInteraction;
        PlayerInteraction.reloadValues();
    }
}

