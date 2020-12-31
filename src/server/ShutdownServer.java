/*
 * Decompiled with CFR 0.150.
 */
package server;

import constants.GameSetConstants;
import server.ShutdownServerMBean;
import tools.database.MysqlBackup;
import tools.googledrive.SyncServerData;

public class ShutdownServer
implements Runnable,
ShutdownServerMBean {
    public static /* synthetic */ boolean running;
    private static final /* synthetic */ ShutdownServer ALLATORIxDEMO;

    @Override
    public /* synthetic */ void shutdown() {
        ShutdownServer a2;
        a2.run();
    }

    public static /* synthetic */ ShutdownServer getInstance() {
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new ShutdownServer();
        running = false;
    }

    public /* synthetic */ void backupdata() {
        MysqlBackup.run();
        if (GameSetConstants.BACKUP_GOOGLEDRIVE) {
            SyncServerData.ZipScriptsFiles();
            MysqlBackup.uploadGoogleDrive();
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public /* synthetic */ void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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

    public /* synthetic */ ShutdownServer() {
        ShutdownServer a2;
    }
}

