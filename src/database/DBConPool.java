/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidDataSource
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameSetConstants;
import handling.world.family.MapleFamilyCharacter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import server.ServerProperties;
import server.shark.SharkReader;

public class DBConPool {
    public static /* synthetic */ String dbIp;
    private static /* synthetic */ DruidDataSource ALLATORIxDEMO;
    public static /* synthetic */ int dbport;
    public static /* synthetic */ String dbPass;
    public static /* synthetic */ String dbName;
    public static final /* synthetic */ int RETURN_GENERATED_KEYS = 1;
    public static /* synthetic */ String dbUser;

    public static /* synthetic */ {
        ALLATORIxDEMO = null;
        dbUser = "";
        dbPass = "root";
        dbIp = "localhost";
        dbName = "twms";
        dbport = 3306;
        DBConPool.InitDB();
        try {
            Class.forName(SharkReader.ALLATORIxDEMO(" =.|.+0#/|)6!1m\u00161;571"));
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("[\u8cc7\u6599\u5eab\u4fe1\u606f] \u627e\u4e0d\u5230JDBC\u9a45\u52d5\u3002" + classNotFoundException);
            System.exit(0);
        }
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        if (!GameSetConstants.ONLYTOOL) {
            ALLATORIxDEMO = new DruidDataSource();
            ALLATORIxDEMO.setName(MapleFamilyCharacter.ALLATORIxDEMO("I;W3H\u001dT-K."));
            ALLATORIxDEMO.setDriverClassName(SharkReader.ALLATORIxDEMO(" =.|.+0#/|)6!1m\u00161;571"));
            ALLATORIxDEMO.setUrl("jdbc:mysql://" + dbIp + ":" + dbport + "/" + dbName + "?useUnicode=true&characterEncoding=UTF8");
            ALLATORIxDEMO.setUsername(dbUser);
            ALLATORIxDEMO.setPassword(dbPass);
            ALLATORIxDEMO.setInitialSize(750);
            ALLATORIxDEMO.setMinIdle(1250);
            ALLATORIxDEMO.setMaxActive(5000);
            ALLATORIxDEMO.setTimeBetweenEvictionRunsMillis(60000L);
            ALLATORIxDEMO.setMinEvictableIdleTimeMillis(300000L);
            ALLATORIxDEMO.setValidationQuery(MapleFamilyCharacter.ALLATORIxDEMO("w\u0007h\u0007g\u0016\u0004e\\e"));
            ALLATORIxDEMO.setTestOnBorrow(false);
            ALLATORIxDEMO.setTestOnReturn(false);
            ALLATORIxDEMO.setTestWhileIdle(true);
            ALLATORIxDEMO.setMaxWait(60000L);
            ALLATORIxDEMO.setUseUnfairLock(true);
        }
    }

    public static /* synthetic */ void InitDB() {
        dbName = ServerProperties.getProperty(SharkReader.ALLATORIxDEMO("071$& m!&&7;-50|'0m<\"?&"), dbName);
        dbIp = ServerProperties.getProperty(MapleFamilyCharacter.ALLATORIxDEMO("1A0R'VlW'P6M,C1\n&FlM2"), dbIp);
        dbport = ServerProperties.getProperty(SharkReader.ALLATORIxDEMO("071$& m!&&7;-50|'0m\", 7"), dbport);
        dbUser = ServerProperties.getProperty(MapleFamilyCharacter.ALLATORIxDEMO("1A0R'VlW'P6M,C1\n&FlQ1A0"), dbUser);
        dbPass = ServerProperties.getProperty(SharkReader.ALLATORIxDEMO("071$& m!&&7;-50|'0m\"\"!0%, '"), dbPass);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void createDatabase() {
        var0 = null;
        v0 = var0 = new DruidDataSource();
        v0.setName(SharkReader.ALLATORIxDEMO("?:!2>\u001c\",=/"));
        v0.setDriverClassName(MapleFamilyCharacter.ALLATORIxDEMO("!K/\n/]1U.\n(@ Gl`0M4A0"));
        v0.setUrl("jdbc:mysql://" + DBConPool.dbIp + ":" + DBConPool.dbport + "/?useUnicode=true&characterEncoding=UTF8");
        v1 = var0;
        v1.setUsername(DBConPool.dbUser);
        v1.setPassword(DBConPool.dbPass);
        var1_1 = var0.getConnection();
        try {
            var2_3 = var1_1.prepareStatement("CREATE DATABASE " + DBConPool.dbName);
            var2_3.execute();
            var2_3.close();
            ** if (var1_1 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_1 == null) ** GOTO lbl30
            try {
                var1_1.close();
                v2 = var2_4;
                ** GOTO lbl31
            }
            catch (Throwable var3_5) {
                try {
                    var2_4.addSuppressed(var3_5);
lbl30:
                    // 2 sources

                    v2 = var2_4;
lbl31:
                    // 2 sources

                    throw v2;
                }
                catch (SQLException var1_2) {
                    var1_2.printStackTrace();
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_1.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean ColumnExist(String a, String a) {
        block11: {
            var3_4 = 0;
            var4_5 = DBConPool.getInstance().getDataSource().getConnection();
            var5_7 = null;
            var5_7 = var4_5.prepareStatement("SELECT count(*) FROM information_schema.columns WHERE table_schema='" + DBConPool.dbName + "' AND table_name = '" + (String)a + "' AND column_name = '" + a + "'");
            a = var5_7.executeQuery();
            if (!a.next()) break block11;
            v0 = var4_5;
            var3_4 = a.getInt(1);
            ** GOTO lbl31
        }
        var3_4 = -1;
        v0 = var4_5;
        {
            catch (Throwable var5_8) {
                try {
                    block12: {
                        if (var4_5 != null) {
                            try {
                                var4_5.close();
                                v1 = var5_8;
                                break block12;
                            }
                            catch (Throwable a) {
                                var5_8.addSuppressed(a);
                            }
                        }
                        v1 = var5_8;
                    }
                    throw v1;
                }
                catch (Exception var4_6) {
                    return false;
                }
            }
        }
lbl31:
        // 2 sources

        if (v0 != null) {
            var4_5.close();
        }
        return var3_4 > 0;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ boolean TableExist(String a222222) {
        DruidPooledConnection druidPooledConnection;
        block9: {
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = druidPooledConnection.prepareStatement("SELECT * FROM " + (String)a222222);
            a222222 = preparedStatement.executeQuery();
            if (!a222222.next()) break block9;
            boolean bl = true;
            if (druidPooledConnection == null) return bl;
            druidPooledConnection.close();
            return bl;
        }
        if (druidPooledConnection == null) return true;
        druidPooledConnection.close();
        return true;
        {
            catch (Exception exception) {
                return false;
            }
        }
        {
            catch (Throwable throwable) {
                Throwable throwable2;
                if (druidPooledConnection != null) {
                    try {
                        druidPooledConnection.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (Throwable a222222) {
                        throwable.addSuppressed(a222222);
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
        }
    }

    public /* synthetic */ DruidDataSource getDataSource() {
        if (ALLATORIxDEMO == null) {
            DBConPool a2;
            a2.ALLATORIxDEMO();
        }
        return ALLATORIxDEMO;
    }

    public /* synthetic */ DBConPool(1 a2) {
        a3();
        DBConPool a3;
    }

    public /* synthetic */ boolean CheckConnect() throws SQLException {
        try {
            DBConPool a2;
            DruidPooledConnection druidPooledConnection = a2.getDataSource().getConnection();
            if (druidPooledConnection != null) {
                boolean bl = true;
                return bl;
            }
        }
        catch (SQLException sQLException) {
            boolean bl = false;
            return bl;
        }
        finally {
            return false;
        }
    }

    public static /* synthetic */ DBConPool getInstance() {
        return InstanceHolder.instance;
    }

    private /* synthetic */ DBConPool() {
        DBConPool a2;
    }

    private static class InstanceHolder {
        public static final /* synthetic */ DBConPool instance;

        public static /* synthetic */ {
            instance = new DBConPool(null);
        }

        private /* synthetic */ InstanceHolder() {
            InstanceHolder a2;
        }
    }
}

