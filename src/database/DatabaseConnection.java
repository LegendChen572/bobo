/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package database;

import client.PlayerRandomStream;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import constants.GameSetConstants;
import database.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseConnection {
    public static /* synthetic */ String dbName;
    public static /* synthetic */ String dbUser;
    public static final /* synthetic */ Runnable CloseSQLConnections;
    private static final /* synthetic */ ReentrantLock ALLATORIxDEMO;
    public static /* synthetic */ String dbIp;
    public static /* synthetic */ int dbport;
    private static final /* synthetic */ long d = 1800000L;
    private static final /* synthetic */ HashMap<Integer, ConWrapper> a;
    public static /* synthetic */ String dbPass;

    public /* synthetic */ DatabaseConnection() {
        DatabaseConnection a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ void closeTimeout() {
        int n2 = 0;
        ALLATORIxDEMO.lock();
        Object object = new ArrayList<Integer>(a.keySet());
        try {
            object = object.iterator();
            while (object.hasNext()) {
                Integer n3 = (Integer)object.next();
                if (!a.get(n3).close()) continue;
                ++n2;
            }
            return;
        }
        finally {
            ALLATORIxDEMO.unlock();
        }
    }

    public static /* synthetic */ HashMap ALLATORIxDEMO() {
        return a;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ Connection getConnection() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 3[TRYBLOCK]
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
        a = new HashMap();
        dbUser = "";
        dbPass = "root";
        dbIp = "localhost";
        dbName = "twms";
        dbport = 3306;
        ALLATORIxDEMO = new ReentrantLock();
        CloseSQLConnections = new Runnable(){
            {
                1 a2;
            }

            @Override
            public /* synthetic */ void run() {
                DatabaseConnection.closeTimeout();
            }
        };
        DatabaseConnection.InitDB();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ void close() {
        block6: {
            Thread thread = Thread.currentThread();
            Integer n2 = (int)thread.getId();
            Object object = a.get(n2);
            if (object == null) break block6;
            if (!(object = ((ConWrapper)object).getConnection()).isClosed()) {
                object.close();
            }
            ALLATORIxDEMO.lock();
            try {
                a.remove(n2);
                ALLATORIxDEMO.unlock();
                return;
            }
            catch (Throwable throwable) {
                try {
                    ALLATORIxDEMO.unlock();
                    throw throwable;
                }
                catch (SQLException sQLException) {
                    // empty catch block
                }
            }
        }
    }

    public static /* synthetic */ int getConnectionsCount() {
        return a.size();
    }

    private static /* synthetic */ Connection H() {
        try {
            Properties properties = new Properties();
            properties.put(PlayerRandomStream.ALLATORIxDEMO("&<6="), dbUser);
            properties.put(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"D0G\"C>F5"), dbPass);
            properties.put(PlayerRandomStream.ALLATORIxDEMO(".&;<\u001d6,<!=*0;"), \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"@#A4"));
            properties.put(PlayerRandomStream.ALLATORIxDEMO(",;.!.0;6=\u0016!0 7&=("), \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"a\u0005ri"));
            properties.put(PlayerRandomStream.ALLATORIxDEMO("0 =!6,'\u001b:\"6 &;"), \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"c\u0004a\u0004a\u0004a"));
            properties.put(PlayerRandomStream.ALLATORIxDEMO(" *!96=\u0007&>*) =*"), \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0010G8U~`0]!Q8"));
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbIp + ":" + dbport + "/" + dbName + "?&maxReconnects=10000&character-set-server=utf8mb4", properties);
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerRandomStream.ALLATORIxDEMO("\u0000\n\u0007o'&>*\f5<!6onotdcwi\u007fch"));
            preparedStatement.execute();
            preparedStatement.close();
            return connection;
        }
        catch (SQLException sQLException) {
            throw new DatabaseException(sQLException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void closeAll() {
        HashMap<Integer, ConWrapper> hashMap = a;
        synchronized (hashMap) {
            Iterator<ConWrapper> iterator = a.values().iterator();
            while (iterator.hasNext()) {
                ConWrapper conWrapper = iterator.next();
                try {
                    conWrapper.ALLATORIxDEMO.close();
                }
                catch (SQLException sQLException) {
                }
            }
            return;
        }
    }

    public static /* synthetic */ ReentrantLock ALLATORIxDEMO() {
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ boolean isInitialized() {
        return !dbUser.equals("");
    }

    public static /* synthetic */ void InitDB() {
        dbName = GameSetConstants.dbName;
        dbIp = GameSetConstants.dbIp;
        dbport = GameSetConstants.dbport;
        dbUser = GameSetConstants.dbUser;
        dbPass = GameSetConstants.dbPass;
    }

    public static class ConWrapper {
        private final /* synthetic */ int a;
        private /* synthetic */ Connection ALLATORIxDEMO;
        private /* synthetic */ long d;

        public /* synthetic */ Connection getConnection() {
            ConWrapper a2;
            if (a2.expiredConnection()) {
                ConWrapper conWrapper;
                try {
                    a2.ALLATORIxDEMO.close();
                    conWrapper = a2;
                }
                catch (SQLException sQLException) {
                    conWrapper = a2;
                }
                conWrapper.ALLATORIxDEMO = DatabaseConnection.H();
            }
            a2.d = System.currentTimeMillis();
            return a2.ALLATORIxDEMO;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        public /* synthetic */ boolean close() {
            var1_1 = false;
            if (a.ALLATORIxDEMO == null) {
                var1_1 = false;
                return false;
            }
            DatabaseConnection.ALLATORIxDEMO().lock();
            if (!a.expiredConnection() && !a.ALLATORIxDEMO.isValid(10)) ** GOTO lbl17
            try {
                a.ALLATORIxDEMO.close();
                var1_1 = true;
                ** GOTO lbl17
            }
            catch (SQLException var2_2) {
                try {
                    try {
                        var1_1 = false;
lbl17:
                        // 3 sources

                        DatabaseConnection.ALLATORIxDEMO().remove(a.a);
                    }
                    catch (Throwable var3_4) {
                        throw var3_4;
                    }
                    finally {
                        DatabaseConnection.ALLATORIxDEMO().unlock();
                    }
                }
                catch (SQLException var2_3) {
                    var1_1 = false;
                }
            }
            return var1_1;
        }

        public /* synthetic */ boolean expiredConnection() {
            ConWrapper a2;
            return System.currentTimeMillis() - a2.d >= 1800000L;
        }

        public /* synthetic */ ConWrapper(int a2, Connection a3) {
            ConWrapper a4;
            ConWrapper conWrapper = a4;
            conWrapper.a = a2;
            conWrapper.d = System.currentTimeMillis();
            conWrapper.ALLATORIxDEMO = a3;
        }
    }
}

