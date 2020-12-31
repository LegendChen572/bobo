/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 */
package server.swing.Recovery;

import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import handling.channel.handler.HiredMerchantHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import server.swing.Recovery.Main;

public class DatabaseConnection {
    public static /* synthetic */ String dbPass;
    public static final /* synthetic */ int CLOSE_ALL_RESULTS = 3;
    public static final /* synthetic */ int SUCCESS_NO_INFO = -2;
    public static final /* synthetic */ int RETURN_GENERATED_KEYS = 1;
    public static /* synthetic */ String dbUser;
    public static final /* synthetic */ int CLOSE_CURRENT_RESULT = 1;
    public static /* synthetic */ String dbName2;
    public static /* synthetic */ String dbName;
    public static final /* synthetic */ int NO_GENERATED_KEYS = 2;
    public static /* synthetic */ String dbIp;
    public static /* synthetic */ int dbport;
    public static final /* synthetic */ int EXECUTE_FAILED = -3;
    public static final /* synthetic */ int KEEP_CURRENT_RESULT = 2;

    /*
     * Exception decompiling
     */
    private static /* synthetic */ int ALLATORIxDEMO() {
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

    public static /* synthetic */ {
        dbUser = "root";
        dbPass = "";
        dbIp = "localhost";
        dbName = "dream";
        dbName2 = "dream2";
        dbport = 3306;
    }

    public /* synthetic */ DatabaseConnection() {
        DatabaseConnection a2;
    }

    public static /* synthetic */ Connection getConnection2() throws SQLException {
        int n2 = 0;
        while (true) {
            try {
                Properties properties = new Properties();
                properties.put(HiredMerchantHandler.ALLATORIxDEMO("\u0001}\u0011|"), Main.dbname);
                properties.put(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\r`\u000er\nn\u000fe"), dbPass);
                properties.put(HiredMerchantHandler.ALLATORIxDEMO("o\u0001z\u001b\\\u0011m\u001b`\u001ak\u0017z"), \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\ts\bd"));
                properties.put(HiredMerchantHandler.ALLATORIxDEMO("m\u001co\u0006o\u0017z\u0011|1`\u0017a\u0010g\u001ai"), \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"(U;9"));
                properties.put(HiredMerchantHandler.ALLATORIxDEMO("\u0017a\u001a`\u0011m\u0000Z\u001dc\u0011a\u0001z"), \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"3M1M1M1"));
                properties.put(HiredMerchantHandler.ALLATORIxDEMO("\u0007k\u0006x\u0011| g\u0019k\u000ea\u001ak"), \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"@\u000eh\u001c.)`\u0014q\u0018h"));
                properties.put(HiredMerchantHandler.ALLATORIxDEMO("\u0000k\u0007z;`6a\u0006|\u001by"), \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\ts\bd"));
                properties.put(HiredMerchantHandler.ALLATORIxDEMO("x\u0015b\u001dj\u0015z\u001da\u001a_\u0001k\u0006w"), \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u000ed\u0011d\u001eu]0"));
                return DriverManager.getConnection("jdbc:mysql://" + dbIp + ":" + dbport + "/" + dbName2, properties);
            }
            catch (SQLException sQLException) {
                System.out.println(sQLException);
                if (++n2 != 3) continue;
                throw sQLException;
            }
            break;
        }
    }
}

