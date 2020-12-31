/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6070\u6070\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.MapleRing;
import client.inventory.PetCommand;
import client.messages.commands.player.\u6070\u6070\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import server.CashItem;
import server.CashItemFactory;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import tools.Pair;
import tools.packet.MTSCSPacket;

public class CashShop
implements Serializable {
    private /* synthetic */ ItemLoader a;
    private /* synthetic */ List<Integer> ALLATORIxDEMO;
    private /* synthetic */ List<IItem> d;
    private static final /* synthetic */ long B = 231541893513373579L;
    private /* synthetic */ int K;
    private /* synthetic */ int k;

    public /* synthetic */ void addToInventory(IItem a2) {
        CashShop a3;
        a3.d.add(a2);
    }

    public /* synthetic */ CashShop(int a2, int a32, int a4, int a5) throws SQLException {
        CashShop cashShop;
        CashShop a6;
        CashShop cashShop2 = a6;
        CashShop cashShop3 = a6;
        a6.d = new ArrayList<IItem>();
        cashShop3.ALLATORIxDEMO = new ArrayList<Integer>();
        cashShop2.k = a2;
        cashShop2.K = a32;
        if (!GameSetConstants.CS_FACTORYOPEN) {
            if (a4 / 1000 == 1) {
                cashShop = a6;
                a6.a = ItemLoader.CASHSHOP_CYGNUS;
            } else if ((a4 / 100 == 21 || a4 / 100 == 20) && a4 != 2001) {
                cashShop = a6;
                a6.a = ItemLoader.CASHSHOP_ARAN;
            } else if (a4 == 2001 || a4 / 100 == 22) {
                cashShop = a6;
                a6.a = ItemLoader.CASHSHOP_EVAN;
            } else if (a4 >= 3000) {
                cashShop = a6;
                a6.a = ItemLoader.CASHSHOP_RESIST;
            } else if (a4 / 10 == 43) {
                cashShop = a6;
                a6.a = ItemLoader.CASHSHOP_DB;
            } else {
                cashShop = a6;
                a6.a = ItemLoader.CASHSHOP_EXPLORER;
            }
        } else {
            cashShop = a6;
            a6.a = ItemLoader.CASHSHOP_EXPLORER;
        }
        Integer[] arrinteger = new Integer[2];
        arrinteger[0] = a2;
        arrinteger[1] = a5;
        Iterator<Pair<IItem, MapleInventoryType>> iterator = a2 = cashShop.a.loadItems(false, arrinteger).values().iterator();
        while (iterator.hasNext()) {
            Pair<IItem, MapleInventoryType> a32 = a2.next();
            a6.d.add(a32.getLeft());
            iterator = a2;
        }
    }

    public /* synthetic */ IItem findByCashId(int a2) {
        CashShop a3;
        for (IItem iItem : a3.d) {
            if (iItem.getUniqueId() != a2) continue;
            return iItem;
        }
        return null;
    }

    public /* synthetic */ IItem toItem(CashItem a2, String a3) {
        CashShop a4;
        CashItem cashItem = a2;
        return a4.toItem(cashItem, MapleInventoryManipulator.getUniqueId(cashItem.getId(), null), a3);
    }

    public /* synthetic */ void sendedNote(int a2) {
        CashShop a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.ALLATORIxDEMO.size()) {
            if (a3.ALLATORIxDEMO.get(n2) == a2) {
                a3.ALLATORIxDEMO.remove(n2);
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ IItem toItem(CashItem a2, int a3, String a4) {
        CashShop a5;
        return a5.toItem(a2, null, a3, a4);
    }

    public /* synthetic */ void save(Connection a2, int a3) throws SQLException {
        CashShop a4;
        Iterator<IItem> iterator;
        ArrayList<Pair<IItem, MapleInventoryType>> arrayList = new ArrayList<Pair<IItem, MapleInventoryType>>();
        Iterator<IItem> iterator2 = iterator = a4.d.iterator();
        while (iterator2.hasNext()) {
            IItem iItem = iterator.next();
            iterator2 = iterator;
            IItem iItem2 = iItem;
            arrayList.add(new Pair<IItem, MapleInventoryType>(iItem2, GameConstants.getInventoryType(iItem2.getItemId())));
        }
        if (a2 != null) {
            if (GameSetConstants.NEW_ITEM_SAVE) {
                a4.a.saveItemsNew(arrayList, a2, 0, a4.k);
                return;
            }
            Integer[] arrinteger = new Integer[2];
            arrinteger[0] = a4.k;
            arrinteger[1] = a3;
            a4.a.saveItems(arrayList, a2, arrinteger);
            return;
        }
        CashShop cashShop = a4;
        if (GameSetConstants.NEW_ITEM_SAVE) {
            cashShop.a.saveItemsNew(arrayList, 0, a4.k);
            return;
        }
        Integer[] arrinteger = new Integer[2];
        arrinteger[0] = a4.k;
        arrinteger[1] = a3;
        cashShop.a.saveItems(arrayList, arrinteger);
    }

    public /* synthetic */ String getKey() {
        CashShop a2;
        Iterator<IItem> iterator;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<IItem> iterator2 = iterator = a2.d.iterator();
        while (iterator2.hasNext()) {
            IItem iItem = iterator.next();
            iterator2 = iterator;
            stringBuilder.append(iItem.getKey());
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ IItem toItem(CashItem a2, int a3, String a4, MapleCharacter a5) {
        CashShop a6;
        return a6.toItem(a2, a5, a3, a4);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void gift(int a, String a, String a, int a, int a, int a) {
        var7_8 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var8_10 = var7_8.prepareStatement(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\n \u0010+\u0011:c'\r:\fN#\t*\b7\u001d#N\u0015/\u000f;\u0006=cF\u0007+\u0005/\u0016\"\u0017BcQoN|BcQoN|BcQoN|G"));
            v1 = var8_10;
            v2 = var8_10;
            v2.setInt(1, a);
            v2.setString(2, a);
            v1.setString(3, a);
            v1.setInt(4, a);
            v0.setInt(5, a);
            var8_10.setInt(6, a);
            v0.executeUpdate();
            var8_10.close();
            ** if (var7_8 == null) goto lbl-1000
        }
        catch (Throwable var8_11) {
            if (var7_8 == null) ** GOTO lbl30
            try {
                var7_8.close();
                v3 = var8_11;
                ** GOTO lbl31
            }
            catch (Throwable a) {
                try {
                    var8_11.addSuppressed(a);
lbl30:
                    // 2 sources

                    v3 = var8_11;
lbl31:
                    // 2 sources

                    throw v3;
                }
                catch (SQLException var7_9) {
                    var7_9.printStackTrace();
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var7_8.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ List<Pair<IItem, String>> loadGifts(MapleClient a2) {
        a2 = new ArrayList();
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                CashShop a3;
                PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(PetCommand.ALLATORIxDEMO("fZyZvK\u00155\u0015YgPx?Ux\\yAlU?bWpMp?UmP|\\o\\z[kU?\b?\n"));
                preparedStatement.setInt(1, a3.K);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Object object = CashItemFactory.getInstance().getModItem(resultSet.getInt(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"0\u0000")));
                    if (object == null) continue;
                    IItem iItem = a3.toItem((CashItem)object, resultSet.getInt(PetCommand.ALLATORIxDEMO("j[vDjPvQ")), resultSet.getString(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"%\u001c,\u0003")));
                    a2.add(new Pair<IItem, String>(iItem, resultSet.getString(PetCommand.ALLATORIxDEMO("XzFlTxP"))));
                    a3.ALLATORIxDEMO.add(iItem.getUniqueId());
                    object = CashItemFactory.getInstance().getPackageItems(((CashItem)object).getId());
                    if (object != null && object.size() > 0) {
                        Iterator iterator = object = object.iterator();
                        while (iterator.hasNext()) {
                            CashItem cashItem = (CashItem)object.next();
                            iterator = object;
                            CashShop cashShop = a3;
                            cashShop.addToInventory(cashShop.toItem(cashItem, resultSet.getString(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"%\u001c,\u0003"))));
                        }
                        continue;
                    }
                    a3.addToInventory(iItem);
                }
                resultSet.close();
                preparedStatement.close();
                preparedStatement = druidPooledConnection.prepareStatement(PetCommand.ALLATORIxDEMO("qZyZaZ\u0015YgPx?Ux\\yAlU?bWpMp?UmP|\\o\\z[kU?\b?\n"));
                preparedStatement.setInt(1, a3.K);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                if (druidPooledConnection == null) return a2;
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
            return a2;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return a2;
    }

    public /* synthetic */ IItem toItem(CashItem a2) {
        CashShop a3;
        CashItem cashItem = a2;
        return a3.toItem(cashItem, MapleInventoryManipulator.getUniqueId(cashItem.getId(), null), "");
    }

    public /* synthetic */ int getItemsSize() {
        CashShop a2;
        return a2.d.size();
    }

    public /* synthetic */ void removeFromInventory(IItem a2) {
        CashShop a3;
        a3.d.remove(a2);
    }

    public /* synthetic */ IItem toItem(CashItem a2, int a3) {
        CashShop a4;
        return a4.toItem(a2, a3, "");
    }

    public /* synthetic */ boolean canSendNote(int a2) {
        CashShop a3;
        return a3.ALLATORIxDEMO.contains(a2);
    }

    public /* synthetic */ List<IItem> getInventory() {
        CashShop a2;
        return a2.d;
    }

    public /* synthetic */ IItem toItem(CashItem a2, MapleCharacter a3) {
        CashShop a4;
        CashItem cashItem = a2;
        return a4.toItem(cashItem, MapleInventoryManipulator.getUniqueId(cashItem.getId(), null), "", a3);
    }

    public /* synthetic */ void gift(int a2, String a3, String a4, int a5, int a6) {
        CashShop a7;
        a7.gift(a2, a3, a4, a5, a6, 0);
    }

    public /* synthetic */ IItem toItem(CashItem a2, MapleCharacter a3, int a4, String a5) {
        MaplePet maplePet;
        long l2;
        if (a4 <= 0) {
            a4 = MapleInventoryIdentifier.getInstance();
        }
        if ((l2 = (long)a2.getPeriod()) <= 0L) {
            l2 = -1L;
        }
        if (a2.getId() == 5320000) {
            l2 = 90L;
        }
        if (GameConstants.isPet(a2.getId()) && l2 == -1L) {
            l2 = 45L;
            if (GameSetConstants.SERVER_NAME.equals(PetCommand.ALLATORIxDEMO("\u7529\u5fdc\u8c02"))) {
                l2 = 999L;
            }
            if (GameSetConstants.MAPLE_VERSION == 75) {
                l2 = 90L;
            }
        }
        a3 = null;
        if (GameConstants.getInventoryType(a2.getId()) == MapleInventoryType.EQUIP) {
            MapleRing mapleRing;
            Equip equip = (Equip)MapleItemInformationProvider.getInstance().getEquipById(a2.getId());
            equip.setUniqueId(a4);
            if (l2 > 0L) {
                equip.setExpiration(System.currentTimeMillis() + l2 * 24L * 60L * 60L * 1000L);
            }
            Equip equip2 = equip;
            equip2.setGiftFrom(a5);
            equip2.setNoStat();
            if (GameConstants.isEffectRing(a2.getId()) && a4 > 0 && (mapleRing = MapleRing.loadFromDb(a4)) != null) {
                equip.setRing(mapleRing);
            }
            a3 = equip.copy();
            return a3;
        }
        Item item2 = new Item(a2.getId(), 0, (short)a2.getCount(), 0, a4);
        if (l2 > 0L) {
            item2.setExpiration(System.currentTimeMillis() + l2 * 24L * 60L * 60L * 1000L);
        }
        item2.setGiftFrom(a5);
        if (GameConstants.isPet(a2.getId()) && (maplePet = MaplePet.createPet(a2.getId(), a4)) != null) {
            item2.setPet(maplePet);
        }
        a3 = item2.copy();
        return a3;
    }

    public /* synthetic */ void saveRemoveList(Connection a2, int a3, List<Long> a4) throws SQLException {
        CashShop a5;
        ArrayList<Pair<IItem, MapleInventoryType>> arrayList = new ArrayList<Pair<IItem, MapleInventoryType>>();
        for (IItem iItem : a5.d) {
            if (a4.contains(iItem.getInventoryitemId())) continue;
            IItem iItem2 = iItem;
            arrayList.add(new Pair<IItem, MapleInventoryType>(iItem2, GameConstants.getInventoryType(iItem2.getItemId())));
        }
        if (a2 != null) {
            if (GameSetConstants.NEW_ITEM_SAVE) {
                a5.a.saveItemsNew(arrayList, a2, 0, a5.k);
                return;
            }
            Integer[] arrinteger = new Integer[2];
            arrinteger[0] = a5.k;
            arrinteger[1] = a3;
            a5.a.saveItems(arrayList, a2, arrinteger);
            return;
        }
        CashShop cashShop = a5;
        if (GameSetConstants.NEW_ITEM_SAVE) {
            cashShop.a.saveItemsNew(arrayList, 0, a5.k);
            return;
        }
        Integer[] arrinteger = new Integer[2];
        arrinteger[0] = a5.k;
        arrinteger[1] = a3;
        cashShop.a.saveItems(arrayList, arrinteger);
    }

    public /* synthetic */ void checkExpire(MapleClient a2) {
        CashShop a3;
        ArrayList<IItem> arrayList = new ArrayList<IItem>();
        for (IItem iItem : a3.d) {
            if (iItem == null || GameConstants.isPet(iItem.getItemId()) || iItem.getExpiration() <= 0L || iItem.getExpiration() >= System.currentTimeMillis()) continue;
            arrayList.add(iItem);
        }
        if (arrayList.size() > 0) {
            Iterator<IItem> iterator = arrayList.iterator();
            Iterator<Object> iterator2 = iterator;
            while (iterator2.hasNext()) {
                IItem iItem;
                iItem = iterator.next();
                iterator2 = iterator;
                IItem iItem2 = iItem;
                a3.removeFromInventory(iItem2);
                a2.sendPacket(MTSCSPacket.cashItemExpired(iItem2.getUniqueId()));
            }
            arrayList.clear();
        }
    }
}

