/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 */
package tools.wztosql;

import client.messages.commands.player.\u53ef\u53ef\u8c37;
import constants.GameSetConstants;
import java.sql.PreparedStatement;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import server.MapleCarnivalChallenge;
import server.swing.Progressbar;

public class DumpQuests {
    public /* synthetic */ boolean hadError;
    public /* synthetic */ int id;
    public /* synthetic */ boolean update;
    private final /* synthetic */ MapleDataProvider ALLATORIxDEMO;

    public /* synthetic */ boolean isHadError() {
        DumpQuests a2;
        return a2.hadError;
    }

    public /* synthetic */ DumpQuests(boolean a2) throws Exception {
        DumpQuests a3;
        DumpQuests dumpQuests = a3;
        a3.hadError = false;
        dumpQuests.update = false;
        dumpQuests.id = 0;
        a3.update = a2;
        a3.ALLATORIxDEMO = MapleDataProviderFactory.getDataProvider(MapleCarnivalChallenge.ALLATORIxDEMO("M\u0004y\u0002h_k\u000b"));
        if (a3.ALLATORIxDEMO == null) {
            a3.hadError = true;
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void delete(String a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 7[CATCHBLOCK]
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
    public /* synthetic */ void dumpQuests(PreparedStatement a, PreparedStatement a, PreparedStatement a, PreparedStatement a, PreparedStatement a, PreparedStatement a, PreparedStatement a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [38[UNCONDITIONALDOLOOP]], but top level block is 51[WHILELOOP]
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
    public /* synthetic */ void dumpQuests() throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 7[CATCHBLOCK]
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

    public /* synthetic */ int currentId() {
        DumpQuests a2;
        return a2.id;
    }

    public static /* synthetic */ void start(String[] a2) {
        int n2;
        GameSetConstants.loadsetting();
        GameSetConstants.reloadset();
        Progressbar.setValue(0);
        Progressbar.setText(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u8f45\u5b0f\u4ef7\u528e\"y\""));
        boolean bl = false;
        int n3 = 0;
        long l2 = System.currentTimeMillis();
        String[] arrstring = a2;
        int n4 = a2.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            String string = arrstring[n2];
            if (string.equalsIgnoreCase(MapleCarnivalChallenge.ALLATORIxDEMO("\\i\u0001x\u0010h\u0014"))) {
                n3 = 1;
            }
            n5 = ++n2;
        }
        int n6 = 0;
        try {
            DumpQuests dumpQuests = new DumpQuests(n3 != 0);
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0013y:|>b0,&y2\u007f#\u007f"));
            dumpQuests.dumpQuests();
            DumpQuests dumpQuests2 = dumpQuests;
            bl |= dumpQuests2.isHadError();
            n6 = dumpQuests2.currentId();
        }
        catch (Exception exception) {
            bl = true;
            System.out.println(n6 + " quest.");
        }
        long l3 = System.currentTimeMillis();
        double d2 = (double)(l3 - l2) / 1000.0;
        n3 = (int)d2 % 60;
        n6 = (int)(d2 / 60.0);
        String string = "";
        if (bl) {
            string = MapleCarnivalChallenge.ALLATORIxDEMO("<\u0006u\u0005tQy\u0003n\u001en\u0002");
        }
        Progressbar.setValue(100);
        System.out.println("Finished" + string + " in " + n6 + " minutes " + n3 + " seconds");
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean doesExist(String a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

