/*
 * Decompiled with CFR 0.150.
 */
package tools.wztosql;

import handling.channel.handler.PlayerHandler;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.swing.Progressbar;
import tools.npcgenerator.Instruction;

public class DumpNpcNames {
    private static final /* synthetic */ Map<Integer, String> ALLATORIxDEMO;

    public static /* synthetic */ {
        ALLATORIxDEMO = new HashMap<Integer, String>();
    }

    public /* synthetic */ DumpNpcNames() {
        DumpNpcNames a2;
    }

    public static /* synthetic */ void start(String[] a2) {
        try {
            Progressbar.setValue(0);
            Progressbar.setText(Instruction.ALLATORIxDEMO("\u8f53\u5b39T1Y\u546c\u7a2bO4O"));
            System.out.println(PlayerHandler.ALLATORIxDEMO("Q'x\"|<rr{\"vr{3x756t&t|"));
            DumpNpcNames dumpNpcNames = new DumpNpcNames();
            dumpNpcNames.dumpNpcNameData();
            System.out.println(Instruction.ALLATORIxDEMO("^\u0014w\u0011:\u0002u\fj\r\u007f\u0015\u007fO"));
            Progressbar.setValue(100);
            return;
        }
        catch (SQLException sQLException) {
            Logger.getLogger(DumpNpcNames.class.getName()).log(Level.SEVERE, null, sQLException);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void dumpNpcNameData() throws SQLException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 13[CATCHBLOCK]
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

