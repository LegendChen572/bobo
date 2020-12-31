/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server;

import client.inventory.IItem;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryType;
import client.inventory.PetCommand;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import server.MTSStorage;
import tools.FileoutputUtil;
import tools.Pair;
import tools.database.CashShopConvert;

public class MTSCart
implements Serializable {
    private static final /* synthetic */ long e = 231541893513373578L;
    private /* synthetic */ int g;
    private /* synthetic */ List<Integer> d;
    private /* synthetic */ int E;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ List<Integer> a;
    private /* synthetic */ List<IItem> K;
    private /* synthetic */ int B;
    private /* synthetic */ int k;

    public final /* synthetic */ int getSetOwedNX() {
        MTSCart a2;
        int n2 = a2.ALLATORIxDEMO;
        a2.ALLATORIxDEMO = 0;
        return n2;
    }

    public /* synthetic */ void removeFromCart(int a2) {
        MTSCart a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.a.size()) {
            if (a3.a.get(n2) == a2) {
                a3.a.remove(n2);
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ List<IItem> getInventory() {
        MTSCart a2;
        return a2.K;
    }

    public /* synthetic */ void addToNotYetSold(int a2) {
        MTSCart a3;
        a3.d.add(a2);
    }

    public /* synthetic */ void changeInfo(int a2, int a3, int a4) {
        MTSCart a5;
        MTSCart mTSCart = a5;
        a5.g = a2;
        mTSCart.B = a3;
        mTSCart.k = a4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void loadNotYetSold() throws SQLException {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(CashShopConvert.ALLATORIxDEMO("\u0016(\t(\u00069eGe+\u0017\"\bM(\u001962,\u0019 \u00006M\u0012%\u0000?\u0000M&\u0005$\u001f$\u000e1\b7\u0004!MxMz"));
        preparedStatement.setInt(1, a2.E);
        resultSet = preparedStatement.executeQuery();
        block9: while (true) {
            v0 = resultSet;
            while (v0.next()) {
                n2 = resultSet.getInt(PetCommand.ALLATORIxDEMO("vQ"));
                if (!MTSStorage.getInstance().check(n2)) continue block9;
                v0 = resultSet;
                a2.d.add(n2);
            }
            break;
        }
        resultSet.close();
        preparedStatement.close();
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
                                v1 = throwable;
                                break block13;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v1 = throwable;
                    }
                    throw v1;
                }
                catch (SQLException sQLException) {
                    FileoutputUtil.outError(CashShopConvert.ALLATORIxDEMO("\u0001*\n6B\u8c82\u65f4\u5eee\u751d\u5e7dC1\u00151"), sQLException);
                }
            }
        }
    }

    public /* synthetic */ int getPage() {
        MTSCart a2;
        return a2.k;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void loadCart() throws SQLException {
        try {
            var1_1 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                var2_3 = var1_1.prepareStatement(PetCommand.ALLATORIxDEMO("LpSp\\a?\u001f?sMzR\u0015rAlj|TmA?bWpMp?VwTmT|AzGvQ?\b?\n"));
                var2_3.setInt(1, a.E);
                var3_5 = var2_3.executeQuery();
                block9: while (true) {
                    v0 = var3_5;
lbl9:
                    // 3 sources

                    while (v0.next()) {
                        var4_7 = var3_5.getInt(CashShopConvert.ALLATORIxDEMO("\u00041\b(\u0004!"));
                        if (var4_7 >= 0) continue block9;
                        v0 = var3_5;
                        a.ALLATORIxDEMO -= var4_7;
                    }
                    ** GOTO lbl-1000
                    break;
                }
            }
            catch (Throwable var2_4) {
                if (var1_1 != null) {
                    try {
                        var1_1.close();
                        v1 = var2_4;
                        throw v1;
                    }
                    catch (Throwable var3_6) {
                        var2_4.addSuppressed(var3_6);
                    }
                }
                v1 = var2_4;
                throw v1;
            }
        }
        catch (SQLException var1_2) {
            FileoutputUtil.outError(PetCommand.ALLATORIxDEMO("sZxF0\u8cf2\u6586\u5e9e\u756f\u5e0d1AgA"), var1_2);
            return;
        }
        {
            if (!MTSStorage.getInstance().check(var4_7)) ** continue;
            v0 = var3_5;
            a.a.add(var4_7);
            ** GOTO lbl9
        }
lbl-1000:
        // 1 sources

        {
            var3_5.close();
            var2_3.close();
            if (var1_1 == null) return;
        }
        var1_1.close();
    }

    public /* synthetic */ int getType() {
        MTSCart a2;
        return a2.B;
    }

    public /* synthetic */ List<Integer> getNotYetSold() {
        MTSCart a2;
        return a2.d;
    }

    public /* synthetic */ int getTab() {
        MTSCart a2;
        return a2.g;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void save() throws SQLException {
        Object object;
        MTSCart a2;
        DruidPooledConnection druidPooledConnection;
        Object object2 = new ArrayList<Pair<IItem, MapleInventoryType>>();
        DruidPooledConnection druidPooledConnection2 = druidPooledConnection = a2.getInventory().iterator();
        while (druidPooledConnection2.hasNext()) {
            object = druidPooledConnection.next();
            druidPooledConnection2 = druidPooledConnection;
            IItem iItem = object;
            object2.add(new Pair<IItem, MapleInventoryType>(iItem, GameConstants.getInventoryType(iItem.getItemId())));
        }
        Integer[] arrinteger = new Integer[1];
        arrinteger[0] = a2.E;
        ItemLoader.MTS_TRANSFER.saveItems((List<Pair<IItem, MapleInventoryType>>)object2, arrinteger);
        if (GameSetConstants.NEW_ITEM_SAVE) {
            ItemLoader.MTS_TRANSFER.saveItemsNew((List<Pair<IItem, MapleInventoryType>>)object2, a2.E, 0);
        } else {
            Integer[] arrinteger2 = new Integer[1];
            arrinteger2[0] = a2.E;
            ItemLoader.MTS_TRANSFER.saveItems((List<Pair<IItem, MapleInventoryType>>)object2, arrinteger2);
        }
        try {
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                object = druidPooledConnection.prepareStatement(CashShopConvert.ALLATORIxDEMO(")\u0000!\u00009\u0000M\u0003?\n e\u00001\u001e\u001a\u000e$\u001f1M\u0012%\u0000?\u0000M&\u0005$\u001f$\u000e1\b7\u0004!MxMz"));
                object.setInt(1, a2.E);
                object.execute();
                object.close();
                object = druidPooledConnection.prepareStatement(PetCommand.ALLATORIxDEMO("V{LpMa?|QaP\u0015rAlj|TmA?c^yJpL\u001d[pYtJyK\u0019?\n3\u0015 \u001c"));
                MTSCart mTSCart = a2;
                object.setInt(1, mTSCart.E);
                object2 = mTSCart.a.iterator();
                Object object3 = object2;
                while (object3.hasNext()) {
                    int n2 = (Integer)object2.next();
                    object3 = object2;
                    Object object4 = object;
                    object4.setInt(2, n2);
                    object4.executeUpdate();
                }
                if (a2.ALLATORIxDEMO > 0) {
                    Object object5 = object;
                    object5.setInt(2, -a2.ALLATORIxDEMO);
                    object5.executeUpdate();
                }
                object.close();
                if (druidPooledConnection == null) return;
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
            druidPooledConnection.close();
            return;
        }
        catch (SQLException sQLException) {
            FileoutputUtil.outError(CashShopConvert.ALLATORIxDEMO("\u0001*\n6B\u8c82\u65f4\u5eee\u751d\u5e7dC1\u00151"), sQLException);
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 4 ^ 1;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ (3 << 2 ^ 1);
        int n5 = n3;
        int n6 = 5 << 4 ^ 3;
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

    public /* synthetic */ void increaseOwedNX(int a2) {
        a.ALLATORIxDEMO += a2;
    }

    public /* synthetic */ boolean addToCart(int a2) {
        MTSCart a3;
        if (!a3.a.contains(a2)) {
            a3.a.add(a2);
            return true;
        }
        return false;
    }

    public /* synthetic */ void addToInventory(IItem a2) {
        MTSCart a3;
        a3.K.add(a2);
    }

    public /* synthetic */ MTSCart(int a2) throws SQLException {
        MTSCart a3;
        MTSCart mTSCart = a3;
        MTSCart mTSCart2 = a3;
        MTSCart mTSCart3 = a3;
        a3.g = 1;
        mTSCart3.B = 0;
        mTSCart3.k = 0;
        MTSCart mTSCart4 = a3;
        mTSCart2.K = new ArrayList<IItem>();
        mTSCart4.a = new ArrayList<Integer>();
        mTSCart2.d = new ArrayList<Integer>(10);
        mTSCart.ALLATORIxDEMO = 0;
        mTSCart.E = a2;
        Integer[] arrinteger = new Integer[1];
        arrinteger[0] = a2;
        Iterator<Pair<IItem, MapleInventoryType>> iterator = a2 = ItemLoader.MTS_TRANSFER.loadItems(false, arrinteger).values().iterator();
        while (iterator.hasNext()) {
            Pair<IItem, MapleInventoryType> pair = a2.next();
            a3.K.add(pair.getLeft());
            iterator = a2;
        }
        MTSCart mTSCart5 = a3;
        mTSCart5.loadCart();
        mTSCart5.loadNotYetSold();
    }

    public /* synthetic */ void removeFromInventory(IItem a2) {
        MTSCart a3;
        a3.K.remove(a2);
    }

    public /* synthetic */ List<Integer> getCart() {
        MTSCart a2;
        return a2.a;
    }

    public /* synthetic */ void removeFromNotYetSold(int a2) {
        MTSCart a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.d.size()) {
            if (a3.d.get(n2) == a2) {
                a3.d.remove(n2);
            }
            n3 = ++n2;
        }
    }
}

