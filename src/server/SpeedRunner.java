/*
 * Decompiled with CFR 0.150.
 */
package server;

import handling.channel.handler.UserInterfaceHandler;
import java.sql.SQLException;
import java.util.EnumMap;
import java.util.Map;
import server.maps.SpeedRunType;
import tools.Eval;
import tools.FilePrinter;
import tools.Pair;

public class SpeedRunner {
    private static final /* synthetic */ SpeedRunner d;
    private final /* synthetic */ Map<SpeedRunType, Pair<String, Map<Integer, String>>> ALLATORIxDEMO;

    public static /* synthetic */ {
        d = new SpeedRunner();
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void loadSpeedRunData(SpeedRunType a) throws SQLException {
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

    public final /* synthetic */ Pair<String, Map<Integer, String>> getSpeedRunData(SpeedRunType a2) {
        SpeedRunner a3;
        return a3.ALLATORIxDEMO.get((Object)a2);
    }

    public final /* synthetic */ void addSpeedRunData(SpeedRunType a2, Pair<StringBuilder, Map<Integer, String>> a3) {
        SpeedRunner a4;
        a4.ALLATORIxDEMO.put(a2, new Pair<String, Map<Integer, String>>(a3.getLeft().toString(), a3.getRight()));
    }

    public final /* synthetic */ void loadSpeedRuns() {
        int n2;
        SpeedRunner a2;
        if (a2.ALLATORIxDEMO.size() > 0) {
            return;
        }
        SpeedRunType[] arrspeedRunType = SpeedRunType.values();
        int n3 = arrspeedRunType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            SpeedRunType speedRunType = arrspeedRunType[n2];
            try {
                a2.loadSpeedRunData(speedRunType);
            }
            catch (SQLException sQLException) {
                FilePrinter.printError(UserInterfaceHandler.ALLATORIxDEMO("XTU_gKQ^PiAUG\u0015@C@"), sQLException);
            }
            n4 = ++n2;
        }
    }

    private /* synthetic */ SpeedRunner() {
        SpeedRunner a2;
        SpeedRunner speedRunner = a2;
        speedRunner.ALLATORIxDEMO = new EnumMap<SpeedRunType, Pair<String, Map<Integer, String>>>(SpeedRunType.class);
    }

    public final /* synthetic */ void removeSpeedRunData(SpeedRunType a2) {
        SpeedRunner a3;
        a3.ALLATORIxDEMO.remove((Object)a2);
    }

    public static final /* synthetic */ SpeedRunner getInstance() {
        return d;
    }

    public final /* synthetic */ Pair<StringBuilder, Map<Integer, String>> addSpeedRunData(StringBuilder a2, Map<Integer, String> a3, String a4, String a5, int a6, String a7) {
        StringBuilder stringBuilder = new StringBuilder();
        a4 = a4.split(Eval.ALLATORIxDEMO("h"));
        stringBuilder.append(UserInterfaceHandler.ALLATORIxDEMO("\u0017Y\u8a46\u905b\u5fb5\u96b1\u0014")).append(a5).append(Eval.ALLATORIxDEMO("c\u624f\u52db\u634e\u6274\u63cd\u5449\u70e5d")).append(a6).append(UserInterfaceHandler.ALLATORIxDEMO("\u001a\u0018_6>6>"));
        int n2 = 0;
        int n3 = n2;
        while (n3 < a4.length) {
            stringBuilder.append(Eval.ALLATORIxDEMO("|6|!"));
            stringBuilder.append(n2 + 1);
            stringBuilder.append(UserInterfaceHandler.ALLATORIxDEMO("\u0015\u0017U\u0014"));
            stringBuilder.append(a4[n2]);
            stringBuilder.append(Eval.ALLATORIxDEMO("|/RN"));
            n3 = ++n2;
        }
        a3.put(a6, stringBuilder.toString());
        a2.append(UserInterfaceHandler.ALLATORIxDEMO("\u0018V"));
        if (a4.length > 1) {
            a2.append(Eval.ALLATORIxDEMO("|\b"));
            a2.append(a6);
            a2.append(UserInterfaceHandler.ALLATORIxDEMO("\u0017"));
        }
        a2.append(Eval.ALLATORIxDEMO("\u0016>*4d|!"));
        a2.append(a6);
        a2.append(UserInterfaceHandler.ALLATORIxDEMO("\u0017U\u0017P\u0014\u0001\u0014"));
        a2.append(a5);
        a2.append(Eval.ALLATORIxDEMO("h\u007f-1d"));
        a2.append(a7);
        if (a4.length > 1) {
            a2.append(UserInterfaceHandler.ALLATORIxDEMO("\u0018X"));
        }
        a2.append(Eval.ALLATORIxDEMO("RN"));
        return new Pair<StringBuilder, Map<Integer, String>>(a2, a3);
    }
}

