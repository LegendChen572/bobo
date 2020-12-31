/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.database;

import client.inventory.IItem;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryType;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.ServerSet;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import server.Framework.MapleExtendedSlots;
import tools.FilePrinter;
import tools.JsonMapConverter;
import tools.Pair;

public class UniqueIdReset {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void resetItemUniqueId() {
        int n2 = 1;
        int n3 = 0;
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("&A9A6PU.UB'K8$\u0015m\u001br\u0010j\u0001k\u0007}\u001cp\u0010i\u0006[\u001fw\u001aj\u0015"));
                ResultSet resultSet = null;
                resultSet = preparedStatement.executeQuery();
                long l2 = System.currentTimeMillis();
                ResultSet resultSet2 = resultSet;
                while (true) {
                    block17: {
                        Object object;
                        int n4;
                        Map<Long, Pair<IItem, MapleInventoryType>> map;
                        block18: {
                            block16: {
                                if (!resultSet2.next()) break block16;
                                ResultSet resultSet3 = resultSet;
                                map = ItemLoader.loadItemsByJson(resultSet3.getString(MapleExtendedSlots.ALLATORIxDEMO("M+H6")));
                                n4 = resultSet3.getInt(JsonMapConverter.ALLATORIxDEMO("m\u001br\u0010j\u0001k\u0007}\u001cp\u0010i\u0006[\u001fw\u001aj*m\u0011"));
                                if (map == null || map.size() == 0) break block17;
                                object = map.entrySet().iterator();
                                break block18;
                            }
                            preparedStatement = druidPooledConnection.prepareStatement("DELETE FROM `pets` WHERE petid > " + n2);
                            preparedStatement.execute();
                            preparedStatement = druidPooledConnection.prepareStatement("DELETE FROM `rings` WHERE ringid > " + n2);
                            preparedStatement.execute();
                            preparedStatement = druidPooledConnection.prepareStatement("DELETE FROM `rings` WHERE partnerRingId > " + n2);
                            preparedStatement.execute();
                            preparedStatement.close();
                            resultSet.close();
                            System.out.println("\u66ff\u63db\u6578\u91cf:" + n2);
                            ServerSet.setServerSet(JsonMapConverter.ALLATORIxDEMO("q\u001bm\u0004q\u0010m\u0011"), n2);
                            ServerSet.saveServerSet();
                            if (druidPooledConnection == null) return;
                            druidPooledConnection.close();
                            return;
                        }
                        while (object.hasNext()) {
                            Map.Entry<Long, Pair<IItem, MapleInventoryType>> entry;
                            AutoCloseable autoCloseable;
                            Map.Entry<Long, Pair<IItem, MapleInventoryType>> entry2 = object.next();
                            if (entry2.getValue().getLeft().getUniqueId() <= 0) continue;
                            if (GameConstants.isPet(entry2.getValue().getLeft().getItemId())) {
                                autoCloseable = druidPooledConnection.prepareStatement(MapleExtendedSlots.ALLATORIxDEMO("\rw\u001cf\fbxW=S+\u0007\u000bb\f\u0007(B,N<\u0007e\u0007g\u0007\u000fo\u001du\u001d\u0007(B,N<\u0007e\u0007g"));
                                PreparedStatement preparedStatement2 = autoCloseable;
                                preparedStatement2.setLong(1, n2);
                                preparedStatement2.setLong(2, entry2.getValue().getLeft().getUniqueId());
                                entry = entry2;
                                autoCloseable.execute();
                                autoCloseable.close();
                            } else {
                                if (GameConstants.isRing(entry2.getValue().getLeft().getItemId())) {
                                    autoCloseable = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("W0H0G!$_$3V:IUv\u001cj\u0012wUS=A'AUv\u001cj\u0012m\u0011$H$J"));
                                    autoCloseable.setLong(1, entry2.getValue().getLeft().getUniqueId());
                                    autoCloseable = autoCloseable.executeQuery();
                                    if (autoCloseable.next()) {
                                        PreparedStatement preparedStatement3;
                                        PreparedStatement preparedStatement4 = preparedStatement3 = druidPooledConnection.prepareStatement(MapleExtendedSlots.ALLATORIxDEMO("r\bc\u0019s\u001d\u0007*N6@+\u0007\u000bb\f\u0007*N6@1Cx\u001ax\u0018xp\u0010b\nbxU1I?N<\u0007e\u0007g"));
                                        preparedStatement4.setLong(1, n2);
                                        preparedStatement4.setLong(2, entry2.getValue().getLeft().getUniqueId());
                                        preparedStatement3.execute();
                                        preparedStatement3 = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("Q%@4P0$\u0007m\u001bc\u0006$&A!$\u0005e\u0007p\u001ba\u0007V\u001cj\u0012M\u0011$H$J$\"L0V0$\u0005e\u0007p\u001ba\u0007V\u001cj\u0012M\u0011$H$J"));
                                        preparedStatement3.setLong(1, n2);
                                        preparedStatement3.setLong(2, entry2.getValue().getLeft().getUniqueId());
                                        preparedStatement3.execute();
                                        preparedStatement3.close();
                                    }
                                    autoCloseable.close();
                                }
                                entry = entry2;
                            }
                            entry.getValue().getLeft().setUniqueId(n2++);
                        }
                        Object object2 = object = druidPooledConnection.prepareStatement(MapleExtendedSlots.ALLATORIxDEMO("r\bc\u0019s\u001d\u00071I.B6S7U!N,B5T\u0007M+H6\u0007\u000bb\f\u00072T7Ix\u001ax\u0018xp\u0010b\nbxN6Q=I,H*^1S=J+x2T7I\u0007N<\u0007e\u0007g"));
                        object2.setString(1, ItemLoader.getJsonByItems(map));
                        object2.setInt(2, n4);
                        object2.executeUpdate();
                        object.close();
                    }
                    System.out.println("\u66ff\u63db\u6578\u91cf:" + ++n3);
                    resultSet2 = resultSet;
                }
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                if (druidPooledConnection != null) {
                    try {
                        druidPooledConnection.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (Throwable throwable3) {
                        throwable.addSuppressed(throwable3);
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            FilePrinter.printError(MapleExtendedSlots.ALLATORIxDEMO("*B+B,n,B5r6N)R=n<\t,_,"), sQLException, "");
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 ^ 5;
        int cfr_ignored_0 = 4 << 4 ^ (2 << 2 ^ 3);
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ (2 ^ 5);
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ UniqueIdReset() {
        UniqueIdReset a2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void resetRingId() {
        int n2 = 1;
        try {
            PreparedStatement preparedStatement;
            long l2;
            ResultSet resultSet;
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement2 = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("&A9A6PU.UB'K8$\u0007m\u001bc\u0006"));
            ResultSet resultSet2 = resultSet = preparedStatement2.executeQuery();
            while (resultSet2.next()) {
                l2 = resultSet.getLong(MapleExtendedSlots.ALLATORIxDEMO("U1I?N<"));
                PreparedStatement preparedStatement3 = preparedStatement = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("Q%@4P0$\u0007m\u001bc\u0006$&A!$\u0007m\u001bc\u001c`U9U;U(Ut\u0014v\u0001j\u0010v'm\u001bc<`U9U;US=A'AUv\u001cj\u0012m\u0011$H$J"));
                preparedStatement3.setLong(1, n2);
                preparedStatement3.setLong(2, n2 % 2 == 0 ? (long)(n2 - 1) : (long)(n2 + 1));
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
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                    }
                    throwable2 = throwable;
                    throw throwable2;
                }
            }
            {
                resultSet2 = resultSet;
                PreparedStatement preparedStatement4 = preparedStatement;
                preparedStatement4.setLong(3, l2);
                ++n2;
                preparedStatement4.execute();
                preparedStatement.close();
                continue;
            }
            resultSet.close();
            preparedStatement2.close();
            if (druidPooledConnection == null) return;
            druidPooledConnection.close();
            return;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            FilePrinter.printError(MapleExtendedSlots.ALLATORIxDEMO("*B+B,u1I?n<\t,_,"), sQLException, "");
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void resetPetId() {
        int n2 = 1;
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("W0H0G!$_$3V:IUt\u0010p\u0006"));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            PreparedStatement preparedStatement2;
            long l2 = resultSet.getLong(MapleExtendedSlots.ALLATORIxDEMO("(B,N<"));
            PreparedStatement preparedStatement3 = preparedStatement2 = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO(" T1E!AUt\u0010p\u0006$&A!$\u0005a\u0001m\u0011$H$J$\"L0V0$\u0005a\u0001m\u0011$H$J"));
            preparedStatement3.setLong(1, n2);
            preparedStatement3.setLong(2, l2);
            ++n2;
            preparedStatement3.execute();
            preparedStatement2.close();
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
            return;
        }
        {
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block11: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block11;
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
                    FilePrinter.printError(MapleExtendedSlots.ALLATORIxDEMO("U=T=S\bB,n<\t,_,"), sQLException, "");
                }
            }
        }
    }
}

