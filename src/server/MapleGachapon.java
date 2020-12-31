/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server;

import client.messages.commands.player.eventSystem.BankSystem;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.auction.handler.MTSOperation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.MapleGachaponItem;
import server.Randomizer;

public class MapleGachapon {
    private static /* synthetic */ Map<Integer, String> d;
    private static final /* synthetic */ List<MapleGachaponItem> ALLATORIxDEMO;

    public static /* synthetic */ List<MapleGachaponItem> getItemsByType(int a2) {
        Object object = MapleGachapon.getItems();
        LinkedList<MapleGachaponItem> linkedList = new LinkedList<MapleGachaponItem>();
        object = object.iterator();
        while (object.hasNext()) {
            MapleGachaponItem mapleGachaponItem = (MapleGachaponItem)object.next();
            if (mapleGachaponItem.getGachaponType() != -1 && mapleGachaponItem.getGachaponType() != a2) continue;
            linkedList.add(mapleGachaponItem);
        }
        return linkedList;
    }

    public /* synthetic */ MapleGachapon() {
        MapleGachapon a2;
    }

    public static /* synthetic */ MapleGachaponItem randomItem(int a2) {
        List<MapleGachaponItem> list = MapleGachapon.getItemsByType(a2);
        if (list.isEmpty()) {
            return null;
        }
        LinkedList<MapleGachaponItem> linkedList = new LinkedList<MapleGachaponItem>();
        int n2 = Randomizer.nextInt(10000);
        for (MapleGachaponItem mapleGachaponItem : list) {
            if (mapleGachaponItem.getChance() < n2 || mapleGachaponItem.getRemainingQuantity() < mapleGachaponItem.getMinQuantity() && mapleGachaponItem.getQuantity() != 0) continue;
            linkedList.add(mapleGachaponItem);
        }
        if (linkedList.isEmpty()) {
            return MapleGachapon.randomItem(a2);
        }
        LinkedList<MapleGachaponItem> linkedList2 = linkedList;
        return (MapleGachaponItem)linkedList2.get(Randomizer.nextInt(linkedList2.size()));
    }

    public static /* synthetic */ List<MapleGachaponItem> getItems() {
        if (ALLATORIxDEMO.isEmpty()) {
            MapleGachapon.loadItems();
        }
        LinkedList<MapleGachaponItem> linkedList = new LinkedList<MapleGachaponItem>();
        linkedList.addAll(ALLATORIxDEMO);
        return linkedList;
    }

    public static /* synthetic */ {
        d = new HashMap<Integer, String>();
        ALLATORIxDEMO = new LinkedList<MapleGachaponItem>();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void loadItems() {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        DruidPooledConnection druidPooledConnection;
        try {
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                preparedStatement = druidPooledConnection.prepareStatement(BankSystem.ALLATORIxDEMO("$6;64'WYW5%<:S\u0010\u0012\u0014\u001b\u0016\u0003\u0018\u001d\u001e\u0007\u0012\u001e\u0004"));
                ResultSet resultSet2 = resultSet = preparedStatement.executeQuery();
                while (resultSet2.next()) {
                    ALLATORIxDEMO.add(new MapleGachaponItem(resultSet.getInt(MTSOperation.ALLATORIxDEMO("%W)N\u0005G")), resultSet.getInt(BankSystem.ALLATORIxDEMO("\u0002\u0002\u0012\u0019\u0007\u001e\u0007\u000e")), resultSet.getInt(MTSOperation.ALLATORIxDEMO("Q)N-J\"J\"D\u001dV-M8J8Z")), resultSet.getInt(BankSystem.ALLATORIxDEMO("\u001e\u001e\u001d\u001e\u001e\u0002\u001e(\u0002\u0002\u0012\u0019\u0007\u001e\u0007\u000e")), resultSet.getInt(MTSOperation.ALLATORIxDEMO("!B4J!V!|=V-M8J8Z")), resultSet.getInt(BankSystem.ALLATORIxDEMO("\u0010\u001f\u0012\u0019\u0010\u0012")), resultSet.getInt(MTSOperation.ALLATORIxDEMO("P!F+B\u0018Z<F")), resultSet.getInt(BankSystem.ALLATORIxDEMO("\u0014\u0016\u0010\u001f\u0012\u0007\u001c\u0019'\u000e\u0003\u0012"))));
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
            // empty catch block
            return;
        }
        {
            preparedStatement.close();
            preparedStatement = druidPooledConnection.prepareStatement(MTSOperation.ALLATORIxDEMO("\u001ff\u0000f\u000fwlJ(\u000flM-N)\u0003\nq\u0003nlD-P$B<L\"P"));
            ResultSet resultSet3 = resultSet = preparedStatement.executeQuery();
            while (resultSet3.next()) {
                d.put(resultSet.getInt(BankSystem.ALLATORIxDEMO("\u001a\u0013")), resultSet.getString(MTSOperation.ALLATORIxDEMO("\"B!F")));
                resultSet3 = resultSet;
            }
        }
        {
            preparedStatement.close();
            if (druidPooledConnection == null) return;
        }
        druidPooledConnection.close();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ int gainItem(MapleGachaponItem a) {
        block11: {
            var1_1 = a.getMinQuantity();
            if (var1_1 > 1 && a.getMaxQuantity() > a.getMinQuantity()) {
                var1_1 += Randomizer.nextInt(a.getMaxQuantity() - a.getMinQuantity());
            }
            if (a.getQuantity() == 0) break block11;
            if (var1_1 > a.getRemainingQuantity()) {
                var1_1 = a.getRemainingQuantity();
            }
            var2_2 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                v0 = var3_4 = var2_2.prepareStatement(BankSystem.ALLATORIxDEMO("&'76'2S\u0010\u0012\u0014\u001b\u0016\u0003\u0018\u001d\u001e\u0007\u0012\u001e\u0004S$6#S\u0017\u0001\u0012\u001e\u0016\u001a\u0019\u001a\u0019\u0014&\u0006\u0016\u001d\u0003\u001a\u0003\n\u0017SJSHS ;2!2S\u001e\u0007\u0012\u001e>\u0017WNWLW297W\u0002\u0002\u0012\u0019\u0007\u001e\u0007\u000eSJSHS6=3S\u0005\u0016\u001a\u0012\u001e\u001d\u001e\u001d\u0010\"\u0002\u0012\u0019\u0007\u001e\u0007\u000eSJSHS6=3S\u001a\u001a\u0019\u001a\u001a\u0006\u001a,\u0006\u0006\u0016\u001d\u0003\u001a\u0003\nWNWLW297W\u001e\u0016\u000b\u001e\u001e\u0002\u001e(\u0002\u0002\u0012\u0019\u0007\u001e\u0007\u000eSJSHS6=3S\u0014\u001b\u0016\u001d\u0014\u0016WNWLW297W\u0000\u001a\u0016\u0010\u0012#\n\u0007\u0016WNWLW297W\u0014\u0016\u0010\u001f\u0012\u0007\u001c\u0019'\u000e\u0003\u0012SJSH"));
                v1 = var3_4;
                v2 = var3_4;
                v3 = var3_4;
                var3_4.setInt(1, a.getRemainingQuantity() - var1_1);
                v3.setInt(2, a.getItemId());
                v3.setInt(3, a.getQuantity());
                v2.setInt(4, a.getRemainingQuantity());
                v2.setInt(5, a.getMinQuantity());
                v1.setInt(6, a.getMaxQuantity());
                v1.setInt(7, a.getChance());
                v0.setInt(8, a.getSmegaType());
                var3_4.setInt(9, a.getGachaponType());
                v0.execute();
                var3_4.close();
                ** if (var2_2 == null) goto lbl-1000
            }
            catch (Throwable var3_5) {
                if (var2_2 == null) ** GOTO lbl39
                try {
                    var2_2.close();
                    v4 = var3_5;
                    ** GOTO lbl40
                }
                catch (Throwable var4_6) {
                    try {
                        var3_5.addSuppressed(var4_6);
lbl39:
                        // 2 sources

                        v4 = var3_5;
lbl40:
                        // 2 sources

                        throw v4;
                    }
                    catch (SQLException var2_3) {
                        // empty catch block
                    }
                }
            }
lbl-1000:
            // 1 sources

            {
                var2_2.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            v5 = a;
            v5.setRemainingQuantity(v5.getRemainingQuantity() - var1_1);
        }
        return var1_1;
    }

    public static /* synthetic */ String getGachaponName(int a2) {
        return d.get(a2);
    }
}

