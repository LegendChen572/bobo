/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5154\u5154\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client;

import client.messages.commands.player.\u5154\u5154\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scripting.AbstractPlayerInteraction;
import tools.FilePrinter;

public class BuddyEntry {
    private /* synthetic */ int K;
    private /* synthetic */ String e;
    private /* synthetic */ long k;
    private final /* synthetic */ int E;
    private /* synthetic */ int d;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int a;
    private /* synthetic */ int B;
    private /* synthetic */ boolean g;
    private final /* synthetic */ String H;

    public /* synthetic */ int getChannel() {
        BuddyEntry a2;
        return a2.B;
    }

    public /* synthetic */ int getSub() {
        BuddyEntry a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ BuddyEntry(String a2, int a3, String a4, int a5, int a6, boolean a7, int a8, int a9, int a10) {
        BuddyEntry a11;
        BuddyEntry buddyEntry = a11;
        BuddyEntry buddyEntry2 = a11;
        BuddyEntry buddyEntry3 = a11;
        BuddyEntry buddyEntry4 = a11;
        a11.H = a2;
        buddyEntry4.E = a3;
        buddyEntry4.e = a4;
        buddyEntry3.d = a5;
        buddyEntry3.B = a6;
        buddyEntry2.g = a7;
        buddyEntry2.K = a8;
        buddyEntry.a = a9;
        buddyEntry.ALLATORIxDEMO = a10;
    }

    public /* synthetic */ int getCharacterId() {
        BuddyEntry a2;
        return a2.E;
    }

    public /* synthetic */ int getLevel() {
        BuddyEntry a2;
        return a2.K;
    }

    public /* synthetic */ void setOffline() {
        a.B = -1;
    }

    public final /* synthetic */ boolean equals(Object a2) {
        BuddyEntry a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        a2 = (BuddyEntry)a2;
        return a3.E == ((BuddyEntry)a2).E;
    }

    public /* synthetic */ void setGroup(String a2) {
        a.e = a2;
    }

    public /* synthetic */ boolean isVisible() {
        BuddyEntry a2;
        return a2.g;
    }

    public /* synthetic */ int getJob() {
        BuddyEntry a2;
        return a2.a;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ BuddyEntry getByIdfFromDB(int a2) {
        BuddyEntry buddyEntry;
        block12: {
            DruidPooledConnection druidPooledConnection;
            block10: {
                BuddyEntry buddyEntry2;
                block11: {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(AbstractPlayerInteraction.ALLATORIxDEMO("\u0005D\u001aD\u0015Uvh2-vo7l3-vm3w3mz!<n4-%t4b7u3f9s/!\u0010S\u0019Lvb>`$`5u3s%!\u0001I\u0013S\u0013!?ev<v>"));
                    preparedStatement.setInt(1, a2);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) break block10;
                    buddyEntry2 = new BuddyEntry(resultSet.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"b@aD")), resultSet.getInt(AbstractPlayerInteraction.ALLATORIxDEMO("?e")), "\u5c1a\u672a\u8a2d\u5b9a\u7fa4\u7d44", -1, -1, true, resultSet.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"MiWiM")), resultSet.getInt(AbstractPlayerInteraction.ALLATORIxDEMO("k9c")), resultSet.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"RyCo@xDkN~X")));
                    if (druidPooledConnection == null) break block11;
                    druidPooledConnection.close();
                }
                return buddyEntry2;
            }
            buddyEntry = null;
            if (druidPooledConnection == null) break block12;
            {
                catch (Throwable throwable) {
                    try {
                        Throwable throwable2;
                        block13: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    throwable2 = throwable;
                                    break block13;
                                }
                                catch (Throwable throwable3) {
                                    throwable.addSuppressed(throwable3);
                                }
                            }
                            throwable2 = throwable;
                        }
                        throw throwable2;
                    }
                    catch (SQLException sQLException) {
                        FilePrinter.printError(AbstractPlayerInteraction.ALLATORIxDEMO("\u0014t2e/D8u$xxu.u"), sQLException, \u5154\u5154\u8c37.ALLATORIxDEMO((String)"kDxcuomLig~NaeN\u0001d@\u007f\u0001_p@dtBiQxHcO"));
                        return null;
                    }
                }
            }
            druidPooledConnection.close();
        }
        return buddyEntry;
    }

    public /* synthetic */ int getWorld() {
        BuddyEntry a2;
        return a2.d;
    }

    public /* synthetic */ boolean isOnline() {
        BuddyEntry a2;
        return a2.B >= 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void updateGroupName() {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var2_3 = var1_1.prepareStatement(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"t\\eMuI\u0001lCyEhHiRl\u0001_dX\u0001lF~NyQb@aDl\u00011\u00013\u0001[iIsI\u0001eE,\u001c,\u001e"));
            v0.setString(1, a.getGroup());
            var2_3.setLong(2, a.k);
            v0.executeUpdate();
            var2_3.close();
            ** if (var1_1 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_1 == null) ** GOTO lbl24
            try {
                var1_1.close();
                v1 = var2_4;
                ** GOTO lbl25
            }
            catch (Throwable var3_5) {
                try {
                    var2_4.addSuppressed(var3_5);
lbl24:
                    // 2 sources

                    v1 = var2_4;
lbl25:
                    // 2 sources

                    throw v1;
                }
                catch (Exception var1_2) {
                    System.err.println("\u66f4\u65b0\u597d\u53cb\u7fa4\u7d44\u7570\u5e38 " + var1_2);
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
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ BuddyEntry getByNameFromDB(String a2) {
        BuddyEntry buddyEntry;
        block12: {
            DruidPooledConnection druidPooledConnection;
            block10: {
                BuddyEntry buddyEntry2;
                block11: {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(AbstractPlayerInteraction.ALLATORIxDEMO("\u0005D\u001aD\u0015Uvh2-vo7l3-vm3w3mz!<n4-%t4b7u3f9s/!\u0010S\u0019Lvb>`$`5u3s%!\u0001I\u0013S\u0013!8`;dv<v>"));
                    preparedStatement.setString(1, a2);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) break block10;
                    buddyEntry2 = new BuddyEntry(resultSet.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"b@aD")), resultSet.getInt(AbstractPlayerInteraction.ALLATORIxDEMO("?e")), "\u5c1a\u672a\u8a2d\u5b9a\u7fa4\u7d44", -1, -1, false, resultSet.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"MiWiM")), resultSet.getInt(AbstractPlayerInteraction.ALLATORIxDEMO("k9c")), resultSet.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"RyCo@xDkN~X")));
                    if (druidPooledConnection == null) break block11;
                    druidPooledConnection.close();
                }
                return buddyEntry2;
            }
            buddyEntry = null;
            if (druidPooledConnection == null) break block12;
            {
                catch (Throwable throwable) {
                    try {
                        Throwable throwable2;
                        block13: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    throwable2 = throwable;
                                    break block13;
                                }
                                catch (Throwable throwable3) {
                                    throwable.addSuppressed(throwable3);
                                }
                            }
                            throwable2 = throwable;
                        }
                        throw throwable2;
                    }
                    catch (SQLException sQLException) {
                        sQLException.printStackTrace();
                        FilePrinter.printError(AbstractPlayerInteraction.ALLATORIxDEMO("\u0014t2e/D8u$xxu.u"), sQLException, \u5154\u5154\u8c37.ALLATORIxDEMO((String)"kDxcuomLig~NaeN\u0001d@\u007f\u0001_p@dtBiQxHcO"));
                        return null;
                    }
                }
            }
            druidPooledConnection.close();
        }
        return buddyEntry;
    }

    public /* synthetic */ String getGroup() {
        BuddyEntry a2;
        return a2.e;
    }

    public final /* synthetic */ int hashCode() {
        BuddyEntry a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + a2.E;
        return n2;
    }

    public /* synthetic */ void setVisible(boolean a2) {
        a.g = a2;
    }

    public /* synthetic */ void setChannel(int a2) {
        a.B = a2;
    }

    public /* synthetic */ String getName() {
        BuddyEntry a2;
        return a2.H;
    }

    public /* synthetic */ BuddyEntry(long a2, String a3, int a4, String a5, int a6, int a7, boolean a8, int a9, int a10, int a11) {
        BuddyEntry a12;
        BuddyEntry buddyEntry = a12;
        BuddyEntry buddyEntry2 = a12;
        BuddyEntry buddyEntry3 = a12;
        BuddyEntry buddyEntry4 = a12;
        BuddyEntry buddyEntry5 = a12;
        buddyEntry5.k = a2;
        buddyEntry5.H = a3;
        buddyEntry4.E = a4;
        buddyEntry4.e = a5;
        buddyEntry3.d = a6;
        buddyEntry3.B = a7;
        buddyEntry2.g = a8;
        buddyEntry2.K = a9;
        buddyEntry.a = a10;
        buddyEntry.ALLATORIxDEMO = a11;
    }
}

