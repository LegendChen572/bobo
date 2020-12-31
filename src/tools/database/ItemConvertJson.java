/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.database;

import client.MapleCharacter;
import client.inventory.IItem;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryType;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameSetConstants;
import database.DBConPool;
import handling.channel.handler.HiredMerchantHandler;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import server.CashShop;
import server.MapleStorage;
import server.MapleStorageType;
import server.Timer;
import server.maps.MapleMapEffect;
import tools.Pair;

public class ItemConvertJson {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void ConvertAll() {
        long l2;
        int n2;
        Serializable serializable;
        Object object;
        PreparedStatement preparedStatement;
        DruidPooledConnection druidPooledConnection;
        try {
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                preparedStatement = null;
                object = null;
                preparedStatement = druidPooledConnection.prepareStatement(Timer.ALLATORIxDEMO("3Q,Q#@@>@R2[-4\u0003|\u0001f\u0001w\u0014q\u0012g"));
                object = preparedStatement.executeQuery();
                serializable = new LinkedList<Integer>();
                n2 = 0;
                ResultSet resultSet = object;
                while (resultSet.next()) {
                    ResultSet resultSet2 = object;
                    resultSet = resultSet2;
                    serializable.add(resultSet2.getInt(MapleMapEffect.ALLATORIxDEMO("^*")));
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
            return;
        }
        {
            object.close();
            preparedStatement.close();
            l2 = 0L;
            Object object2 = object = serializable.iterator();
            while (object2.hasNext()) {
                int n3 = (Integer)object.next();
                long l3 = System.currentTimeMillis();
                Serializable serializable2 = serializable = MapleCharacter.getCharacterById(n3);
                ((MapleCharacter)serializable).loadCharacterSet();
                ((MapleCharacter)serializable2).setChangeCharacterSet(true);
                ((MapleCharacter)serializable2).saveToDB(true, false);
                ItemLoader.HIRED_MERCHANT.saveItemsNew(HiredMerchantHandler.loadItemFromDatabase_(((MapleCharacter)serializable).getId(), ((MapleCharacter)serializable).getAccountID()), (Connection)druidPooledConnection, 0, ((MapleCharacter)serializable).getAccountID());
                ((MapleCharacter)serializable).getClient().disconnect();
                System.out.println("\u76ee\u524d\u8f49\u63db\u6578\u91cf:" + ++n2 + " \u6d88\u8017\u6642\u9593:" + (System.currentTimeMillis() - l3));
                l2 += System.currentTimeMillis() - l3;
                object2 = object;
            }
        }
        {
            System.out.println("\u7e3d\u8f49\u63db\u6578\u91cf:" + n2 + " \u6d88\u8017\u6642\u9593: " + l2 + " \u6beb\u79d2");
            if (druidPooledConnection == null) return;
        }
        druidPooledConnection.close();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void ConvertAll_A() {
        try {
            var0 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                var1_2 = null;
                var3_4 = null;
                var1_2 = var0.prepareStatement(Timer.ALLATORIxDEMO("3Q,Q#@@>@R2[-4\u0003|\u0001f\u0001w\u0014q\u0012g"));
                var3_4 = var1_2.executeQuery();
                var4_5 = 0;
                var5_6 = 0L;
                v0 = var3_4;
lbl11:
                // 2 sources

                while (v0.next()) {
                    var7_7 = System.currentTimeMillis();
                    var9_9 = System.currentTimeMillis();
                    v1 = var3_4;
                    var9_8 = v1.getInt(MapleMapEffect.ALLATORIxDEMO("^*"));
                    var10_10 = v1.getInt(Timer.ALLATORIxDEMO("u\u0003w\u000fa\u000e`\tp"));
                    var11_12 = new CashShop(var10_10, var9_8, var11_11 = v1.getInt(MapleMapEffect.ALLATORIxDEMO("$X,")), 0);
                    if (var11_12 != null) {
                        var11_12.save((Connection)var0, 0);
                    }
                    v2 = new Integer[1];
                    v2[0] = var9_8;
                    var11_12 = ItemLoader.INVENTORY.loadItems(false, v2);
                    var12_14 = new ArrayList<Pair<IItem, MapleInventoryType>>();
                    if (var11_12 != null) {
                        var13_16 /* !! */  = var11_12.values().iterator();
                        v3 /* !! */  = var13_16 /* !! */ ;
                        while (v3 /* !! */ .hasNext()) {
                            var14_17 = (MapleStorageType[])var13_16 /* !! */ .next();
                            v3 /* !! */  = var13_16 /* !! */ ;
                            var12_14.add((Pair<IItem, MapleInventoryType>)var14_17);
                        }
                    }
                    ** GOTO lbl-1000
                }
                ** GOTO lbl70
            }
            catch (Throwable var1_3) {
                if (var0 != null) {
                    try {
                        var0.close();
                        v4 = var1_3;
                        throw v4;
                    }
                    catch (Throwable var2_18) {
                        var1_3.addSuppressed(var2_18);
                    }
                }
                v4 = var1_3;
                throw v4;
            }
        }
        catch (SQLException var0_1) {
            var0_1.printStackTrace();
            return;
        }
lbl-1000:
        // 1 sources

        {
            ItemLoader.INVENTORY.saveItemsNew(var12_14, (Connection)var0, var9_8, 0);
            var13_16 /* !! */  = MapleStorage.loadStorage(0, var10_10, var9_8);
            if (var13_16 /* !! */  != null) {
                var13_16 /* !! */ .saveToDB((Connection)var0);
            }
            if (!GameSetConstants.STORAGE_EXCEED) ** GOTO lbl-1000
            var14_17 = MapleStorageType.values();
            var11_13 = var14_17.length;
            v5 = var12_15 = 0;
            while (v5 < var11_13) {
                var13_16 /* !! */  = var14_17[var12_15];
                if (var13_16 /* !! */ .isExceed() && (var13_16 /* !! */  = MapleStorage.loadStorage(0, var10_10, var9_8, (MapleStorageType)var13_16 /* !! */ )) != null) {
                    var13_16 /* !! */ .saveToDB((Connection)var0);
                }
                v5 = ++var12_15;
            }
        }
lbl-1000:
        // 2 sources

        {
            ItemLoader.HIRED_MERCHANT.saveItemsNew(HiredMerchantHandler.loadItemFromDatabase_(var9_8, var10_10), (Connection)var0, 0, var10_10);
            System.out.println("\u76ee\u524d\u8f49\u63db\u6578\u91cf:" + ++var4_5 + " \u6d88\u8017\u6642\u9593:" + (System.currentTimeMillis() - var7_7));
            var5_6 += System.currentTimeMillis() - var7_7;
            v0 = var3_4;
            ** GOTO lbl11
lbl70:
            // 1 sources

            var3_4.close();
            var1_2.close();
            System.out.println("\u7e3d\u8f49\u63db\u6578\u91cf:" + var4_5 + " \u6d88\u8017\u6642\u9593: " + var5_6 + " \u6beb\u79d2");
            if (var0 == null) return;
        }
        var0.close();
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void ConvertRange(int a2) {
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int n2 = a2;
        preparedStatement = druidPooledConnection.prepareStatement("SELECT * FROM characters WHERE id >=" + n2 + " AND id <= " + (n2 + 100));
        resultSet = preparedStatement.executeQuery();
        int n3 = 0;
        while (resultSet.next()) {
            int n4 = resultSet.getInt(MapleMapEffect.ALLATORIxDEMO("^*"));
            long l2 = System.currentTimeMillis();
            long l3 = System.currentTimeMillis();
            System.out.println("1:" + (System.currentTimeMillis() - l3));
            l3 = System.currentTimeMillis();
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterById(n4);
            System.out.println("2:" + (System.currentTimeMillis() - l3));
            l3 = System.currentTimeMillis();
            mapleCharacter.loadCharacterSet();
            System.out.println("3:" + (System.currentTimeMillis() - l3));
            l3 = System.currentTimeMillis();
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.setChangeCharacterSet(true);
            mapleCharacter2.saveToDB(true, false);
            System.out.println("4:" + (System.currentTimeMillis() - l3));
            l3 = System.currentTimeMillis();
            ItemLoader.HIRED_MERCHANT.saveItemsNew(HiredMerchantHandler.loadItemFromDatabase_(mapleCharacter.getId(), mapleCharacter.getAccountID()), (Connection)druidPooledConnection, 0, mapleCharacter.getAccountID());
            System.out.println("5:" + (System.currentTimeMillis() - l3));
            l3 = System.currentTimeMillis();
            mapleCharacter.getClient().disconnect();
            System.out.println("\u76ee\u524d\u8f49\u63db\u6578\u91cf:" + ++n3 + " \u6d88\u8017\u6642\u9593:" + (System.currentTimeMillis() - l2));
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
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void ConvertAll_CS() {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = null;
        resultSet = null;
        preparedStatement = druidPooledConnection.prepareStatement(Timer.ALLATORIxDEMO("3Q,Q#@@>@R2[-4\u0003|\u0001f\u0001w\u0014q\u0012g"));
        resultSet = preparedStatement.executeQuery();
        n2 = 0;
        l2 = 0L;
        v0 = resultSet;
        while (v0.next()) {
            l3 = System.currentTimeMillis();
            l4 = System.currentTimeMillis();
            v1 = resultSet;
            n4 = v1.getInt(MapleMapEffect.ALLATORIxDEMO("^*"));
            n5 = v1.getInt(Timer.ALLATORIxDEMO("u\u0003w\u000fa\u000e`\tp"));
            cashShop = new CashShop(n5, n4, n3 = v1.getInt(MapleMapEffect.ALLATORIxDEMO("$X,")), 0);
            if (cashShop != null) {
                cashShop.save((Connection)druidPooledConnection, 0);
            }
            System.out.println("\u76ee\u524d\u8f49\u63db\u6578\u91cf:" + ++n2 + " \u6d88\u8017\u6642\u9593:" + (System.currentTimeMillis() - l3));
            l2 += System.currentTimeMillis() - l3;
            v0 = resultSet;
        }
        resultSet.close();
        preparedStatement.close();
        System.out.println("\u7e3d\u8f49\u63db\u6578\u91cf:" + n2 + " \u6d88\u8017\u6642\u9593: " + l2 + " \u6beb\u79d2");
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block13: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v2 = throwable;
                                break block13;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v2 = throwable;
                    }
                    throw v2;
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void Convert(int a2) {
        DruidPooledConnection druidPooledConnection;
        DruidPooledConnection druidPooledConnection2;
        block9: {
            try {
                druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    PreparedStatement preparedStatement = null;
                    ResultSet resultSet = null;
                    preparedStatement = druidPooledConnection2.prepareStatement(MapleMapEffect.ALLATORIxDEMO("d\u000b{\u000bt\u001a\u0017d\u0017\be\u0001znT&V<V-C+E="));
                    resultSet = preparedStatement.executeQuery();
                    int n2 = 0;
                    while (resultSet.next()) {
                        n2 = resultSet.getInt(Timer.ALLATORIxDEMO("\tp"));
                        if (n2 != a2) continue;
                        MapleCharacter mapleCharacter = MapleCharacter.getCharacterById(n2);
                        druidPooledConnection = druidPooledConnection2;
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        mapleCharacter.loadCharacterSet();
                        mapleCharacter2.setChangeCharacterSet(true);
                        mapleCharacter2.saveToDB(true, false);
                        ItemLoader.HIRED_MERCHANT.saveItemsNew(HiredMerchantHandler.loadItemFromDatabase_(mapleCharacter.getId(), mapleCharacter.getAccountID()), (Connection)druidPooledConnection2, 0, mapleCharacter.getAccountID());
                        break block9;
                    }
                }
                catch (Throwable throwable) {
                    Throwable throwable2;
                    if (druidPooledConnection2 != null) {
                        try {
                            druidPooledConnection2.close();
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
                return;
            }
            druidPooledConnection = druidPooledConnection2;
        }
        if (druidPooledConnection == null) return;
        druidPooledConnection2.close();
    }

    public /* synthetic */ ItemConvertJson() {
        ItemConvertJson a2;
    }
}

