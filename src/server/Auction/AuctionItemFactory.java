/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.Auction;

import client.MapleCharacter;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.world.World;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.Auction.AuctionItemData;
import server.MapleItemInformationProvider;
import tools.ArrayMap;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.googledrive.SyncServerData;

public class AuctionItemFactory {
    public static /* synthetic */ boolean change;
    public final /* synthetic */ Map<Integer, AuctionItemData> AuctionItemCache;
    private static final /* synthetic */ AuctionItemFactory ALLATORIxDEMO;

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void InsertAuctionItem(int a, int a, int a, int a) {
        var5_6 = new HashMap();
        var5_6 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var6_8 = var5_6.prepareStatement("INSERT INTO `auction_item` (`auctionid`, `characterid`, `itemid`, `count`) VALUES ('" + a + "', '" + a + "', '" + a + "', '" + a + "');");
            var6_8.execute();
            var6_8.close();
            ** if (var5_6 == null) goto lbl-1000
        }
        catch (Throwable var6_9) {
            if (var5_6 == null) ** GOTO lbl23
            try {
                var5_6.close();
                v0 = var6_9;
                ** GOTO lbl24
            }
            catch (Throwable a) {
                try {
                    var6_9.addSuppressed(a);
lbl23:
                    // 2 sources

                    v0 = var6_9;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var5_7) {
                    System.out.println(var5_7);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var5_6.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public static final /* synthetic */ AuctionItemFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public final /* synthetic */ void reload() {
        AuctionItemFactory a2;
        a2.AuctionItemCache.clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void saveAuctionItem() {
        AuctionItemFactory a2;
        if (!change) return;
        if (a2.AuctionItemCache.isEmpty()) {
            return;
        }
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                StringBuilder stringBuilder = new StringBuilder();
                PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(SyncServerData.ALLATORIxDEMO("1O9O!OUL'E8*\u0014\u007f\u0016~\u001ce\u001b1"));
                preparedStatement.execute();
                preparedStatement.close();
                preparedStatement = druidPooledConnection.prepareStatement(ArrayMap.ALLATORIxDEMO("\u0017#\u0002*\u0004O\u0002.\u0014#\u0013O7\u001a5\u001b?\u00008O\u0017:\u0002 \t&\u0018,\u0004*\u001b*\u0018;k^m"));
                preparedStatement.execute();
                preparedStatement.close();
                boolean bl = true;
                Iterator<AuctionItemData> iterator = a2.AuctionItemCache.values().iterator();
                Iterator<AuctionItemData> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    StringBuilder stringBuilder2;
                    AuctionItemData auctionItemData = iterator.next();
                    if (bl) {
                        bl = false;
                        StringBuilder stringBuilder3 = stringBuilder;
                        stringBuilder2 = stringBuilder3;
                        stringBuilder3.append(SyncServerData.ALLATORIxDEMO("<D&O'^UC;^:*\u0014\u007f\u0016~\u001ce\u001b*#K9_0YU\""));
                    } else {
                        StringBuilder stringBuilder4 = stringBuilder;
                        stringBuilder2 = stringBuilder4;
                        stringBuilder4.append(ArrayMap.ALLATORIxDEMO("C~"));
                    }
                    stringBuilder2.append(SyncServerData.ALLATORIxDEMO("1O3K F!&"));
                    stringBuilder.append(auctionItemData.getItemId()).append(ArrayMap.ALLATORIxDEMO("z"));
                    stringBuilder.append(auctionItemData.getCount()).append(SyncServerData.ALLATORIxDEMO("&"));
                    stringBuilder.append(auctionItemData.getBiddingItem()).append(ArrayMap.ALLATORIxDEMO("z"));
                    stringBuilder.append(auctionItemData.getBiddingStartCount()).append(SyncServerData.ALLATORIxDEMO("&"));
                    stringBuilder.append(auctionItemData.getBiddingKnife()).append(ArrayMap.ALLATORIxDEMO("z"));
                    stringBuilder.append(auctionItemData.getBiddingNowCount()).append(SyncServerData.ALLATORIxDEMO("&"));
                    stringBuilder.append("'" + a2.getTime(auctionItemData.getStartTime()) + "'").append(ArrayMap.ALLATORIxDEMO("z"));
                    stringBuilder.append("'" + a2.getTime(auctionItemData.getEndTime()) + "'").append(SyncServerData.ALLATORIxDEMO("&"));
                    stringBuilder.append("'" + auctionItemData.getWinner() + "'").append(ArrayMap.ALLATORIxDEMO("\u007f"));
                    iterator2 = iterator;
                }
                preparedStatement = druidPooledConnection.prepareStatement(stringBuilder.toString());
                preparedStatement.execute();
                preparedStatement.close();
                change = false;
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
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ List<Pair<Integer, Integer>> getAuctionItems(MapleCharacter a22) throws ParseException {
        linkedList = new LinkedList<Pair<Integer, Integer>>();
        if (a3.AuctionItemCache.isEmpty()) {
            a3.loadAuctionItem();
        }
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement("SELECT * FROM auction_item WHERE characterid = " + a22.getId());
        a22 = preparedStatement.executeQuery();
        while (a22.next()) {
            n2 = a22.getInt(SyncServerData.ALLATORIxDEMO("k\u0000i\u0001c\u001ad\u001cn"));
            auctionItemData = a3.AuctionItemCache.get(n2);
            if (auctionItemData == null || auctionItemData.getCount() != 0 || System.currentTimeMillis() <= auctionItemData.getEndTime()) continue;
            linkedList.add(new Pair<Integer, Integer>(a22.getInt(ArrayMap.ALLATORIxDEMO("\u0006\"\n;\u00062")), a22.getInt(SyncServerData.ALLATORIxDEMO("i\u001a\u007f\u001b~"))));
        }
        a22.close();
        preparedStatement.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block13: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v0 = throwable;
                                break block13;
                            }
                            catch (Throwable a22) {
                                throwable.addSuppressed(a22);
                            }
                        }
                        v0 = throwable;
                    }
                    throw v0;
                }
                catch (SQLException sQLException) {
                    System.out.println(sQLException);
                }
            }
        }
        return linkedList;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new AuctionItemFactory();
        change = false;
    }

    public /* synthetic */ Map<Integer, AuctionItemData> getAuctionItems() throws ParseException {
        AuctionItemFactory a2;
        if (a2.AuctionItemCache.isEmpty()) {
            a2.loadAuctionItem();
        }
        return a2.AuctionItemCache;
    }

    public /* synthetic */ AuctionItemFactory() {
        AuctionItemFactory a2;
        AuctionItemFactory auctionItemFactory = a2;
        auctionItemFactory.AuctionItemCache = new HashMap<Integer, AuctionItemData>();
        System.out.println(ArrayMap.ALLATORIxDEMO("\u307f\u8bd6\u53b9\u4e7b\u307ev.#\f\"\u00069\u0001\u001f\u001b3\u0002\u0010\u000e5\u001b9\u001d/OlUl"));
    }

    public /* synthetic */ String getTime(long a2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(a2);
        return new SimpleDateFormat(SyncServerData.ALLATORIxDEMO("s\fs\f'8GXn\u0011*=BOg\u00180\u0006y")).format(calendar.getTime());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void loadAuctionItem() throws ParseException {
        a2.AuctionItemCache.clear();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(SyncServerData.ALLATORIxDEMO("Y0F0I!*_*3X:GUk\u0000i\u0001c\u001ad"));
        v0 = resultSet = preparedStatement.executeQuery();
        while (v0.next()) {
            n2 = resultSet.getInt(ArrayMap.ALLATORIxDEMO("\u0006\"\n;\u00062"));
            v1 = calendar = Calendar.getInstance();
            calendar.setTime(new SimpleDateFormat(SyncServerData.ALLATORIxDEMO("s\fs\f'8GXn\u0011*=BOg\u00180\u0006y")).parse(resultSet.getString(ArrayMap.ALLATORIxDEMO("%\u001b7\u001d\"\u001b?\u00023"))));
            l2 = v1.getTimeInMillis();
            calendar.setTime(new SimpleDateFormat(SyncServerData.ALLATORIxDEMO("s\fs\f'8GXn\u0011*=BOg\u00180\u0006y")).parse(resultSet.getString(ArrayMap.ALLATORIxDEMO("3\u00012\u001b?\u00023"))));
            l3 = calendar.getTimeInMillis();
            v2 = resultSet;
            v0 = v2;
            auctionItemData = new AuctionItemData(v2.getInt(SyncServerData.ALLATORIxDEMO("\u001cn")), n2, resultSet.getInt(ArrayMap.ALLATORIxDEMO("5\u0000#\u0001\"")), resultSet.getInt(SyncServerData.ALLATORIxDEMO("h\u001cn\u0011c\u001bm\u001c~\u0010g")), resultSet.getInt(ArrayMap.ALLATORIxDEMO("4\u00062\u000b?\u00011\u001c\"\u000e$\u001b5\u0000#\u0001\"")), resultSet.getInt(SyncServerData.ALLATORIxDEMO("\u0017c\u0011n\u001cd\u0012a\u001bc\u0013o")), resultSet.getInt(ArrayMap.ALLATORIxDEMO("4\u00062\u000b?\u00011\u00019\u00185\u0000#\u0001\"")), l2, l3, resultSet.getString(SyncServerData.ALLATORIxDEMO("\u0002c\u001bd\u0010x")));
            a2.AuctionItemCache.put(resultSet.getInt(ArrayMap.ALLATORIxDEMO("\u00062")), auctionItemData);
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
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v3 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v3 = throwable;
                    }
                    throw v3;
                }
                catch (SQLException sQLException) {
                    System.out.println(sQLException);
                }
            }
        }
    }

    public /* synthetic */ void checkActionItems() {
        AuctionItemFactory a2;
        for (Map.Entry<Integer, AuctionItemData> entry : a2.AuctionItemCache.entrySet()) {
            AuctionItemData auctionItemData = entry.getValue();
            int n2 = entry.getKey();
            if (auctionItemData.getCount() <= 0 || System.currentTimeMillis() <= auctionItemData.getEndTime()) continue;
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(auctionItemData.getWinner());
            if (mapleCharacter != null) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                a2.InsertAuctionItem(n2, mapleCharacter2.getId(), auctionItemData.getItemId(), auctionItemData.getCount());
                World.Broadcast.broadcastMessage(MaplePacketCreator.yellowChat("\u300e\u7af6\u62cd\u7cfb\u7d71\u300f" + mapleCharacter2.getName() + "\u5f9e\u7af6\u62cd\u7cfb\u7d71\u7b2c[" + n2 + "]\u4e2d\u62cd\u5f97 " + MapleItemInformationProvider.getInstance().getName(auctionItemData.getItemId()) + " x " + auctionItemData.getCount() + "\uff01"));
                auctionItemData.setCount(0);
                change = true;
                continue;
            }
            auctionItemData.setCount(0);
            change = true;
            World.Broadcast.broadcastMessage(MaplePacketCreator.yellowChat("\u300e\u7af6\u62cd\u7cfb\u7d71\u300f\u7af6\u62cd\u7cfb\u7d71\u7b2c[" + n2 + "]\u5df2\u7d50\u675f,\u6700\u7d42\u6d41\u6a19\uff01"));
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void DeleteAuctionItem(int a, int a) {
        var3_4 = new HashMap();
        var3_4 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var4_6 = var3_4.prepareStatement("DELETE FROM `auction_item` WHERE auctionid = " + a + " AND characterid = " + a);
            var4_6.execute();
            var4_6.close();
            ** if (var3_4 == null) goto lbl-1000
        }
        catch (Throwable var4_7) {
            if (var3_4 == null) ** GOTO lbl23
            try {
                var3_4.close();
                v0 = var4_7;
                ** GOTO lbl24
            }
            catch (Throwable a) {
                try {
                    var4_7.addSuppressed(a);
lbl23:
                    // 2 sources

                    v0 = var4_7;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var3_5) {
                    System.out.println(var3_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var3_4.close();
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
    private /* synthetic */ boolean ALLATORIxDEMO(int a, int a) {
        var3_5 = false;
        var4_6 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var5_8 = var4_6.prepareStatement("SELECT * FROM auction_item WHERE characterid = " + a + " AND auctionid = " + a);
            a = var5_8.executeQuery();
            if (a.next()) {
                var3_5 = true;
            }
            a.close();
            var5_8.close();
            ** if (var4_6 == null) goto lbl-1000
        }
        catch (Throwable var5_9) {
            if (var4_6 == null) ** GOTO lbl24
            try {
                var4_6.close();
                v0 = var5_9;
                ** GOTO lbl25
            }
            catch (Throwable a) {
                try {
                    var5_9.addSuppressed(a);
lbl24:
                    // 2 sources

                    v0 = var5_9;
lbl25:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var4_7) {
                    System.out.println(var4_7);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var4_6.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return var3_5;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Map<Integer, Pair<Integer, Integer>> ALLATORIxDEMO(int a22) {
        hashMap = new HashMap<Integer, Pair<Integer, Integer>>();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement("SELECT * FROM auction_item WHERE auctionid = " + a22);
        v0 = a22 = preparedStatement.executeQuery();
        while (v0.next()) {
            v1 = a22;
            v0 = v1;
            hashMap.put(v1.getInt(ArrayMap.ALLATORIxDEMO("5\u00077\u001d7\f\"\n$\u00062")), new Pair<Integer, Integer>(a22.getInt(SyncServerData.ALLATORIxDEMO("\u001c~\u0010g\u001cn")), a22.getInt(ArrayMap.ALLATORIxDEMO("5\u0000#\u0001\""))));
        }
        a22.close();
        preparedStatement.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v2 = throwable;
                                break block12;
                            }
                            catch (Throwable a22) {
                                throwable.addSuppressed(a22);
                            }
                        }
                        v2 = throwable;
                    }
                    throw v2;
                }
                catch (SQLException sQLException) {
                    System.out.println(sQLException);
                }
            }
        }
        return hashMap;
    }
}

