/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.shops;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryType;
import client.messages.commands.player.\u61b6\u6200\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import handling.channel.ChannelServer;
import handling.world.World;
import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import server.MaplePlayerShopBuyItem;
import server.maps.AbstractMapleMapObject;
import server.maps.Event_PyramidSubway;
import server.maps.MapleMap;
import server.maps.MapleMapObjectType;
import server.shops.HiredMerchant;
import server.shops.IMaplePlayerShop;
import server.shops.MapleMiniGame;
import server.shops.MaplePlayerShopItem;
import tools.FilePrinter;
import tools.Pair;
import tools.Triple;
import tools.packet.PlayerShopPacket;

public abstract class AbstractPlayerStore
extends AbstractMapleMapObject
implements IMaplePlayerShop {
    public /* synthetic */ int world;
    public /* synthetic */ WeakReference<MapleCharacter>[] chrs;
    public /* synthetic */ List<MaplePlayerShopBuyItem> acquisition_items;
    public /* synthetic */ int ownerAccount;
    public /* synthetic */ boolean available;
    public /* synthetic */ List<Pair<String, Byte>> messages;
    public /* synthetic */ int openMinute;
    public /* synthetic */ int itemId;
    public /* synthetic */ HashMap<Integer, Triple<String, Long, Long>> visitors;
    public /* synthetic */ String des;
    public /* synthetic */ List<MaplePlayerShopItem> items;
    public /* synthetic */ List<BoughtItem> bought;
    public /* synthetic */ String pass;
    public /* synthetic */ int ownerId;
    public /* synthetic */ boolean isOpened;
    public /* synthetic */ String ownerName;
    public /* synthetic */ int channel;
    public /* synthetic */ MapleCharacter owner;
    public /* synthetic */ int map;
    public /* synthetic */ AtomicInteger meso;
    public /* synthetic */ boolean needSave;

    @Override
    public /* synthetic */ boolean saveItems(boolean a2) {
        boolean bl;
        block20: {
            AbstractPlayerStore a3;
            if (a3.getShopType() != 1 && a3.getShopType() != 0) {
                return false;
            }
            Object object = a2 ? Event_PyramidSubway.ALLATORIxDEMO("2M(A>I?V9L") : \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"qcko}lpyqcwm");
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                AbstractPlayerStore abstractPlayerStore;
                PreparedStatement preparedStatement;
                PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement("DELETE FROM " + (String)object + " WHERE accountid = ? OR characterid = ?");
                preparedStatement2.setInt(1, a3.ownerAccount);
                preparedStatement2.setInt(2, a3.ownerId);
                preparedStatement2.execute();
                preparedStatement.close();
                PreparedStatement preparedStatement3 = preparedStatement = druidPooledConnection.prepareStatement("INSERT INTO " + (String)object + " (characterid, accountid, Mesos, time) VALUES (?, ?, ?, ?)", 1);
                PreparedStatement preparedStatement4 = preparedStatement;
                preparedStatement4.setInt(1, a3.ownerId);
                preparedStatement4.setInt(2, a3.ownerAccount);
                preparedStatement3.setInt(3, a3.meso.get());
                preparedStatement3.setLong(4, System.currentTimeMillis());
                preparedStatement3.executeUpdate();
                object = preparedStatement.getGeneratedKeys();
                if (!object.next()) {
                    object.close();
                    preparedStatement.close();
                    throw new RuntimeException(Event_PyramidSubway.ALLATORIxDEMO("\u001fV(K(\bzE>@3J=\u00047A(G2E4PzP5\u0004\u001ef"));
                }
                Object object2 = object;
                int n2 = object2.getInt(1);
                object2.close();
                preparedStatement.close();
                ArrayList<Pair<IItem, MapleInventoryType>> arrayList = new ArrayList<Pair<IItem, MapleInventoryType>>();
                Iterator<MaplePlayerShopItem> iterator = a3.items.iterator();
                block7: while (true) {
                    Iterator<MaplePlayerShopItem> iterator2 = iterator;
                    while (iterator2.hasNext()) {
                        MaplePlayerShopItem maplePlayerShopItem = iterator.next();
                        if (maplePlayerShopItem.item == null) continue block7;
                        if (maplePlayerShopItem.bundles <= 0) {
                            iterator2 = iterator;
                            continue;
                        }
                        if (maplePlayerShopItem.item.getQuantity() <= 0 && !GameConstants.isRechargable(maplePlayerShopItem.item.getItemId())) {
                            iterator2 = iterator;
                            continue;
                        }
                        IItem iItem = maplePlayerShopItem.item.copy();
                        iterator2 = iterator;
                        IItem iItem2 = iItem;
                        iItem2.setQuantity((short)(iItem2.getQuantity() * maplePlayerShopItem.bundles));
                        IItem iItem3 = iItem;
                        arrayList.add(new Pair<IItem, MapleInventoryType>(iItem3, GameConstants.getInventoryType(iItem3.getItemId())));
                    }
                    break;
                }
                if (a2) {
                    if (GameSetConstants.NEW_ITEM_SAVE) {
                        ItemLoader.HIRED_MERCHANT.saveItemsNew(arrayList, (Connection)druidPooledConnection, 0, a3.ownerAccount);
                        abstractPlayerStore = a3;
                    } else {
                        Integer[] arrinteger = new Integer[2];
                        arrinteger[0] = n2;
                        arrinteger[1] = a3.ownerAccount;
                        ItemLoader.HIRED_MERCHANT.saveItems(arrayList, (Connection)druidPooledConnection, arrinteger);
                        abstractPlayerStore = a3;
                    }
                } else if (GameSetConstants.NEW_ITEM_SAVE) {
                    ItemLoader.HIRED_FISHING.saveItemsNew(arrayList, (Connection)druidPooledConnection, 0, a3.ownerAccount);
                    abstractPlayerStore = a3;
                } else {
                    Integer[] arrinteger = new Integer[2];
                    arrinteger[0] = n2;
                    arrinteger[1] = a3.ownerAccount;
                    ItemLoader.HIRED_FISHING.saveItems(arrayList, (Connection)druidPooledConnection, arrinteger);
                    abstractPlayerStore = a3;
                }
                abstractPlayerStore.needSave = false;
                bl = true;
                if (druidPooledConnection == null) break block20;
            }
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block21: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block21;
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
                    FilePrinter.printError(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"K{ymxximZuk`okYmeko7~a~"), sQLException, Event_PyramidSubway.ALLATORIxDEMO("W;R?m.A7W"));
                    return false;
                }
            }
            druidPooledConnection.close();
        }
        return bl;
    }

    @Override
    public /* synthetic */ String getDescription() {
        AbstractPlayerStore a2;
        if (a2.des == null) {
            return "";
        }
        return a2.des;
    }

    @Override
    public /* synthetic */ void addVisitor(MapleCharacter a2) {
        AbstractPlayerStore a3;
        byte by = a3.getFreeSlot();
        if (by > 0) {
            AbstractPlayerStore abstractPlayerStore;
            if (a3.getShopType() >= 3) {
                AbstractPlayerStore abstractPlayerStore2 = a3;
                abstractPlayerStore2.broadcastToVisitors(PlayerShopPacket.getMiniGameNewVisitor(a2, by, (MapleMiniGame)abstractPlayerStore2));
                abstractPlayerStore = a3;
            } else {
                AbstractPlayerStore abstractPlayerStore3 = a3;
                abstractPlayerStore = abstractPlayerStore3;
                abstractPlayerStore3.broadcastToVisitors(PlayerShopPacket.shopVisitorAdd(a2, by));
            }
            abstractPlayerStore.chrs[by - 1] = new WeakReference<MapleCharacter>(a2);
            if (!a3.isOwner(a2)) {
                a3.visitors.put(a2.getId(), new Triple<String, Long, Integer>(a2.getName(), System.currentTimeMillis(), -1));
            }
            if (by == 3) {
                a3.update();
            }
        }
    }

    @Override
    public /* synthetic */ boolean getNeedSave() {
        AbstractPlayerStore a2;
        return a2.needSave;
    }

    public /* synthetic */ MapleCharacter getVisitor(int a2) {
        AbstractPlayerStore a3;
        return (MapleCharacter)a3.chrs[a2].get();
    }

    @Override
    public /* synthetic */ void removeVisitor(MapleCharacter a2) {
        boolean bl;
        AbstractPlayerStore a3;
        AbstractPlayerStore abstractPlayerStore = a3;
        byte by = abstractPlayerStore.getVisitorSlot(a2);
        boolean bl2 = bl = abstractPlayerStore.getFreeSlot() == -1;
        if (by > 0) {
            AbstractPlayerStore abstractPlayerStore2 = a3;
            abstractPlayerStore2.broadcastToVisitors(PlayerShopPacket.shopVisitorLeave(by), by);
            abstractPlayerStore2.chrs[by - 1] = new WeakReference<Object>(null);
            if (bl) {
                a3.update();
            }
            if (!a3.isOwner(a2)) {
                a3.visitors.put(a2.getId(), new Triple<String, Long, Long>(a2.getName(), a3.visitors.get(a2.getId()).getMid(), System.currentTimeMillis()));
            }
        }
    }

    public /* synthetic */ void broadcastToVisitors(byte[] a2, boolean a3) {
        int n2;
        AbstractPlayerStore a4;
        WeakReference<MapleCharacter>[] arrweakReference = a4.chrs;
        int n3 = a4.chrs.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            WeakReference<MapleCharacter> weakReference = arrweakReference[n2];
            if (weakReference != null && weakReference.get() != null) {
                ((MapleCharacter)weakReference.get()).getClient().sendPacket(a2);
            }
            n4 = ++n2;
        }
        if (a4.getShopType() != 1 && a3 && a4.getMCOwner() != null) {
            a4.getMCOwner().getClient().sendPacket(a2);
        }
    }

    @Override
    public /* synthetic */ int getMeso() {
        AbstractPlayerStore a2;
        return a2.meso.get();
    }

    @Override
    public /* synthetic */ String getPassword() {
        AbstractPlayerStore a2;
        if (a2.pass == null) {
            return "";
        }
        return a2.pass;
    }

    @Override
    public /* synthetic */ void addAcquisitionItem(MaplePlayerShopBuyItem a2) {
        AbstractPlayerStore a3;
        a3.acquisition_items.add(a2);
    }

    @Override
    public /* synthetic */ List<Pair<Byte, MapleCharacter>> getVisitors() {
        AbstractPlayerStore a2;
        int n2;
        LinkedList<Pair<Byte, MapleCharacter>> linkedList = new LinkedList<Pair<Byte, MapleCharacter>>();
        int n3 = n2 = 0;
        while (n3 < a2.chrs.length) {
            if (a2.chrs[n2] != null && a2.chrs[n2].get() != null) {
                linkedList.add(new Pair<Byte, MapleCharacter>((byte)(n2 + 1), (MapleCharacter)a2.chrs[n2].get()));
            }
            n3 = n2 = (int)((byte)(n2 + 1));
        }
        return linkedList;
    }

    @Override
    public /* synthetic */ List<MaplePlayerShopBuyItem> getAcquisitionItems() {
        AbstractPlayerStore a2;
        return a2.acquisition_items;
    }

    @Override
    public /* synthetic */ void update() {
        AbstractPlayerStore a2;
        if (a2.isAvailable()) {
            if (a2.getShopType() == 1) {
                a2.getMap().broadcastMessage(PlayerShopPacket.updateHiredMerchant((HiredMerchant)a2));
                return;
            }
            if (a2.getMCOwner() != null) {
                a2.getMap().broadcastMessage(PlayerShopPacket.sendPlayerShopBox(a2.getMCOwner()));
            }
        }
    }

    @Override
    public /* synthetic */ boolean removeItem(int a2) {
        return false;
    }

    @Override
    public /* synthetic */ int getSize() {
        AbstractPlayerStore a2;
        if (a2.getFreeSlot() == -1) {
            return a2.getMaxSize();
        }
        return a2.getFreeSlot();
    }

    @Override
    public /* synthetic */ void addOpenMinute(int a2) {
        a.openMinute += a2;
    }

    @Override
    public /* synthetic */ List<BoughtItem> getBoughtItems() {
        AbstractPlayerStore a2;
        return a2.bought;
    }

    @Override
    public /* synthetic */ void setOpen(boolean a2) {
        a.isOpened = a2;
    }

    @Override
    public /* synthetic */ String getOwnerName() {
        AbstractPlayerStore a2;
        return a2.ownerName;
    }

    public /* synthetic */ MapleMap getMap() {
        AbstractPlayerStore a2;
        AbstractPlayerStore abstractPlayerStore = a2;
        return ChannelServer.getInstance(abstractPlayerStore.world, abstractPlayerStore.channel).getMapFactory().getMap(a2.map);
    }

    @Override
    public /* synthetic */ void addItem(MaplePlayerShopItem a2) {
        AbstractPlayerStore a3;
        a3.needSave = true;
        a3.items.add(a2);
    }

    @Override
    public /* synthetic */ void setAvailable(boolean a2) {
        a.available = a2;
    }

    @Override
    public /* synthetic */ boolean isOwner(MapleCharacter a2) {
        AbstractPlayerStore a3;
        return a2.getId() == a3.ownerId && a2.getName().equals(a3.ownerName);
    }

    @Override
    public /* synthetic */ byte getVisitorSlot(MapleCharacter a2) {
        AbstractPlayerStore a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.chrs.length) {
            if (a3.chrs[n2] != null && a3.chrs[n2].get() != null && ((MapleCharacter)a3.chrs[n2].get()).getId() == a2.getId()) {
                return (byte)(n2 + 1);
            }
            n3 = n2 = (int)((byte)(n2 + 1));
        }
        if (a2.getId() == a3.ownerId) {
            return 0;
        }
        return -1;
    }

    @Override
    public /* synthetic */ boolean isOpen() {
        AbstractPlayerStore a2;
        return a2.isOpened;
    }

    @Override
    public /* synthetic */ void setMeso(int a2) {
        AbstractPlayerStore a3;
        a3.needSave = true;
        a3.meso.set(a2);
    }

    public /* synthetic */ AbstractPlayerStore(MapleCharacter a2, int a3, String a4, String a5, int a6) {
        AbstractPlayerStore a7;
        AbstractPlayerStore abstractPlayerStore = a7;
        AbstractPlayerStore abstractPlayerStore2 = a7;
        MapleCharacter mapleCharacter = a2;
        AbstractPlayerStore abstractPlayerStore3 = a7;
        AbstractPlayerStore abstractPlayerStore4 = a7;
        AbstractPlayerStore abstractPlayerStore5 = a7;
        MapleCharacter mapleCharacter2 = a2;
        AbstractPlayerStore abstractPlayerStore6 = a7;
        AbstractPlayerStore abstractPlayerStore7 = a7;
        AbstractPlayerStore abstractPlayerStore8 = a7;
        a7.isOpened = false;
        abstractPlayerStore8.available = false;
        abstractPlayerStore8.needSave = true;
        AbstractPlayerStore abstractPlayerStore9 = a7;
        abstractPlayerStore7.meso = new AtomicInteger(0);
        abstractPlayerStore9.visitors = new HashMap();
        abstractPlayerStore7.bought = new LinkedList<BoughtItem>();
        abstractPlayerStore6.items = new LinkedList<MaplePlayerShopItem>();
        abstractPlayerStore6.messages = new LinkedList<Pair<String, Byte>>();
        abstractPlayerStore6.openMinute = 0;
        a7.setPosition(a2.getPosition());
        a7.owner = a2;
        a7.ownerName = mapleCharacter2.getName();
        abstractPlayerStore5.ownerId = mapleCharacter2.getId();
        abstractPlayerStore5.ownerAccount = a2.getAccountID();
        abstractPlayerStore4.itemId = a3;
        abstractPlayerStore4.des = a4;
        abstractPlayerStore3.pass = a5;
        abstractPlayerStore3.map = a2.getMapId();
        a7.channel = mapleCharacter.getClient().getChannel();
        abstractPlayerStore2.world = mapleCharacter.getClient().getWorld();
        abstractPlayerStore2.needSave = true;
        abstractPlayerStore.openMinute = 0;
        abstractPlayerStore.acquisition_items = new LinkedList<MaplePlayerShopBuyItem>();
        abstractPlayerStore.chrs = new WeakReference[a6];
        int n2 = a2 = 0;
        while (n2 < a7.chrs.length) {
            a7.chrs[a2++] = new WeakReference<Object>(null);
            n2 = a2;
        }
    }

    public /* synthetic */ MapleCharacter getMCOwnerWorld() {
        AbstractPlayerStore a2;
        AbstractPlayerStore abstractPlayerStore = a2;
        int n2 = World.Find.findWorld(abstractPlayerStore.ownerId);
        int n3 = World.Find.findChannel(abstractPlayerStore.ownerId);
        if (n3 <= 0) {
            return null;
        }
        return ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterById(a2.ownerId);
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
    }

    public final /* synthetic */ List<Pair<String, Byte>> getMessages() {
        AbstractPlayerStore a2;
        return a2.messages;
    }

    @Override
    public /* synthetic */ int getOwnerId() {
        AbstractPlayerStore a2;
        return a2.ownerId;
    }

    @Override
    public /* synthetic */ int getOwnerAccId() {
        AbstractPlayerStore a2;
        return a2.ownerAccount;
    }

    @Override
    public /* synthetic */ byte getFreeSlot() {
        AbstractPlayerStore a2;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2.chrs.length) {
            if (a2.chrs[n2] == null || a2.chrs[n2].get() == null) {
                return (byte)(n2 + 1);
            }
            n3 = n2 = (int)((byte)(n2 + 1));
        }
        return -1;
    }

    @Override
    public /* synthetic */ void removeAllVisitors(int a2, int a3) {
        AbstractPlayerStore a4;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a4.chrs.length) {
            MapleCharacter mapleCharacter = a4.getVisitor(n2);
            if (mapleCharacter != null) {
                if (a3 != -1) {
                    mapleCharacter.getClient().sendPacket(PlayerShopPacket.shopErrorMessage(a2, a3));
                }
                MapleCharacter mapleCharacter2 = mapleCharacter;
                AbstractPlayerStore abstractPlayerStore = a4;
                abstractPlayerStore.broadcastToVisitors(PlayerShopPacket.shopVisitorLeave(a4.getVisitorSlot(mapleCharacter2)), abstractPlayerStore.getVisitorSlot(mapleCharacter));
                mapleCharacter2.setPlayerShop(null);
                ++a3;
                a4.chrs[n2] = new WeakReference<Object>(null);
            }
            n3 = ++n2;
        }
        a4.update();
    }

    @Override
    public /* synthetic */ int getGameType() {
        AbstractPlayerStore a2;
        if (a2.getShopType() == 1) {
            return 5;
        }
        if (a2.getShopType() == 2) {
            return 4;
        }
        if (a2.getShopType() == 3) {
            return 1;
        }
        if (a2.getShopType() == 4) {
            return 2;
        }
        return 0;
    }

    @Override
    public /* synthetic */ int getOpenMinute() {
        AbstractPlayerStore a2;
        return a2.openMinute;
    }

    @Override
    public /* synthetic */ List<MaplePlayerShopItem> getItems() {
        AbstractPlayerStore a2;
        return a2.items;
    }

    @Override
    public /* synthetic */ void setNeedSave(boolean a2) {
        a.needSave = a2;
    }

    @Override
    public /* synthetic */ void broadcastToVisitors(byte[] a2) {
        AbstractPlayerStore a3;
        a3.broadcastToVisitors(a2, true);
    }

    @Override
    public /* synthetic */ void setOpenMinute(int a2) {
        a.openMinute = a2;
    }

    @Override
    public /* synthetic */ int getItemId() {
        AbstractPlayerStore a2;
        return a2.itemId;
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.SHOP;
    }

    @Override
    public /* synthetic */ MapleCharacter getOwner() {
        AbstractPlayerStore a2;
        return a2.owner;
    }

    @Override
    public /* synthetic */ void removeFromAcquisitionItem(int a2) {
        AbstractPlayerStore a3;
        a3.acquisition_items.remove(a2);
    }

    @Override
    public /* synthetic */ int getMaxSize() {
        AbstractPlayerStore a2;
        return a2.chrs.length + 1;
    }

    @Override
    public /* synthetic */ boolean isAvailable() {
        AbstractPlayerStore a2;
        return a2.available;
    }

    public /* synthetic */ MapleCharacter getMCOwner() {
        AbstractPlayerStore a2;
        return a2.getMap().getCharacterById(a2.ownerId);
    }

    public /* synthetic */ void broadcastToVisitors(byte[] a2, int a3) {
        int n2;
        AbstractPlayerStore a4;
        WeakReference<MapleCharacter>[] arrweakReference = a4.chrs;
        int n3 = a4.chrs.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            WeakReference<MapleCharacter> weakReference = arrweakReference[n2];
            if (weakReference != null && weakReference.get() != null && a4.getVisitorSlot((MapleCharacter)weakReference.get()) != a3) {
                ((MapleCharacter)weakReference.get()).getClient().sendPacket(a2);
            }
            n4 = ++n2;
        }
        if (a4.getShopType() != 1 && a4.getShopType() != 2 && a4.getMCOwner() != null) {
            a4.getMCOwner().getClient().sendPacket(a2);
            return;
        }
        if (a4.getShopType() == 2 && a4.getMCOwner() != null) {
            a4.getMCOwner().getClient().sendPacket(a2);
        }
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
    }

    @Override
    public /* synthetic */ void removeFromSlot(int a2) {
        AbstractPlayerStore a3;
        a3.needSave = true;
        a3.items.remove(a2);
    }

    public static final class BoughtItem {
        public /* synthetic */ String buyer;
        public /* synthetic */ int quantity;
        public /* synthetic */ int id;
        public /* synthetic */ int totalPrice;

        public /* synthetic */ BoughtItem(int a2, int a3, int a4, String a5) {
            BoughtItem a6;
            BoughtItem boughtItem = a6;
            BoughtItem boughtItem2 = a6;
            boughtItem2.id = a2;
            boughtItem2.quantity = a3;
            boughtItem.totalPrice = a4;
            boughtItem.buyer = a5;
        }
    }
}

