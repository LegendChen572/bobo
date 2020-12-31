/*
 * Decompiled with CFR 0.150.
 */
package handling.login.handler;

import client.MapleLieDetector;
import constants.GameSetConstants;
import database.DBConPool;
import handling.login.LoginServer;
import java.sql.SQLException;

public class AutoRegister {
    private static final /* synthetic */ int ALLATORIxDEMO;
    public static /* synthetic */ int registeredId;
    public static /* synthetic */ boolean autoRegister;
    private static final /* synthetic */ int d;

    public static /* synthetic */ {
        d = GameSetConstants.ACCOUNTS_PER_MAC;
        ALLATORIxDEMO = GameSetConstants.ACCOUNTS_PER_IP;
        autoRegister = LoginServer.getAutoReg();
        registeredId = -1;
    }

    public /* synthetic */ AutoRegister() {
        AutoRegister a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean getAccountExists(String a) {
        var1_1 = false;
        var2_2 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var3_4 = var2_2.prepareStatement(MapleLieDetector.ALLATORIxDEMO("lxsx|i\u001fS^PZ\u001dyopp\u001f\\\\^PHQIL\u001dhuzoz\u001dQ\\RX\u001f\u0000\u001f\u0002"));
            var3_4.setString(1, a);
            var4_6 = var3_4.executeQuery();
            if (var4_6.first()) {
                var1_1 = true;
            }
            ** if (var2_2 == null) goto lbl-1000
        }
        catch (Throwable var3_5) {
            if (var2_2 == null) ** GOTO lbl23
            try {
                var2_2.close();
                v0 = var3_5;
                ** GOTO lbl24
            }
            catch (Throwable var4_7) {
                try {
                    var3_5.addSuppressed(var4_7);
lbl23:
                    // 2 sources

                    v0 = var3_5;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var2_3) {
                    System.err.println("[getAccountExists]" + var2_3);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_2.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return var1_1;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean createAccount(String a, String a, String a, String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 17[CATCHBLOCK]
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
     * Exception decompiling
     */
    public static /* synthetic */ int getIpExists(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 4[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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

