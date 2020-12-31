/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.MapleCharacter;
import client.MapleTrait;
import client.inventory.CheckCopyItem;
import client.inventory.IItem;
import client.inventory.InventoryException;
import client.inventory.Item;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryType;
import client.inventory.ModifyInventory;
import constants.GameConstants;
import constants.GameSetConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.MapleItemInformationProvider;
import server.MapleStorageType;
import server.Randomizer;
import server.gashapon.GashaponRewardSpecial;
import tools.MaplePacketCreator;

public class MapleInventory
implements Iterable<IItem>,
Serializable {
    private final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;
    private /* synthetic */ byte K;
    private /* synthetic */ int d;
    private /* synthetic */ MapleInventoryType a;
    private /* synthetic */ Map<Short, IItem> k;

    public /* synthetic */ void removeBagItem() {
        MapleInventory a2;
        --a2.d;
    }

    public /* synthetic */ List<IItem> newList() {
        MapleInventory a2;
        if (a2.k.size() <= 0) {
            return Collections.emptyList();
        }
        return new LinkedList<IItem>(a2.k.values());
    }

    public /* synthetic */ byte getSlotLimit() {
        MapleInventory a2;
        return a2.K;
    }

    public /* synthetic */ MapleInventoryType getType() {
        MapleInventory a2;
        return a2.a;
    }

    public /* synthetic */ void removeItem(MapleCharacter a2, short a3) {
        MapleInventory a4;
        a4.removeItem(a2, a3, (short)1, false);
    }

    public /* synthetic */ void removeSlot(MapleCharacter a2, short a3) {
        MapleInventory a4;
        a4.k.remove(a3);
        if (GameSetConstants.CHECK_COPYITEM) {
            MapleInventory mapleInventory = a4;
            CheckCopyItem.UpdateItem(a2, mapleInventory.k, mapleInventory.a);
        }
    }

    public /* synthetic */ Collection<IItem> list() {
        MapleInventory a2;
        return a2.k.values();
    }

    public /* synthetic */ void removeItem(short a2, short a3, boolean a4, MapleCharacter a5) {
        MapleInventory a6;
        IItem iItem = a6.k.get(a2);
        if (iItem == null) {
            return;
        }
        IItem iItem2 = iItem;
        iItem2.setQuantity((short)(iItem2.getQuantity() - a3));
        if (iItem2.getQuantity() < 0) {
            iItem.setQuantity((short)0);
        }
        if (iItem.getQuantity() == 0 && !a4) {
            a6.removeSlot(a5, a2);
        }
        if (GameSetConstants.CHECK_COPYITEM) {
            MapleInventory mapleInventory = a6;
            CheckCopyItem.UpdateItem(a5, mapleInventory.k, mapleInventory.a);
        }
    }

    public /* synthetic */ IItem findByUniqueId(int a2) {
        MapleInventory a3;
        for (IItem iItem : a3.k.values()) {
            if (iItem.getUniqueId() != a2) continue;
            return iItem;
        }
        return null;
    }

    public /* synthetic */ MapleInventory(MapleInventoryType a2) {
        MapleInventory a3;
        MapleInventory mapleInventory = a3;
        MapleInventory mapleInventory2 = a3;
        mapleInventory2.K = 0;
        mapleInventory2.d = 0;
        MapleInventory mapleInventory3 = a3;
        mapleInventory.ALLATORIxDEMO = new ReentrantReadWriteLock();
        mapleInventory.k = new LinkedHashMap<Short, IItem>();
        mapleInventory.a = a2;
    }

    public /* synthetic */ void initBagItem() {
        MapleInventory a2;
        a2.ALLATORIxDEMO.readLock().lock();
        try {
            a2.d = 0;
            for (Short s2 : a2.k.keySet()) {
                if (s2 <= 100 || s2 % 100 == 0) continue;
                ++a2.d;
            }
            return;
        }
        finally {
            a2.ALLATORIxDEMO.readLock().unlock();
        }
    }

    public /* synthetic */ void removeItem(MapleCharacter a2, short a3, short a4, boolean a5) {
        MapleInventory a6;
        a6.removeItem(a3, a4, a5, a2, false);
    }

    public /* synthetic */ List<IItem> listById(int a2) {
        MapleInventory a3;
        ArrayList<IItem> arrayList = new ArrayList<IItem>();
        for (IItem iItem : a3.k.values()) {
            if (iItem.getItemId() != a2) continue;
            arrayList.add(iItem);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public /* synthetic */ boolean isFull() {
        MapleInventory a2;
        return a2.k.size() - a2.d >= a2.K;
    }

    public /* synthetic */ IItem getItem(short a2) {
        MapleInventory a3;
        return a3.k.get(a2);
    }

    public /* synthetic */ void setSlotLimit(byte a2) {
        if (a2 > 96) {
            a2 = (byte)96;
        }
        a.K = a2;
    }

    public /* synthetic */ void removeItem(short a2, short a3, boolean a4, MapleCharacter a5, boolean a6) {
        MapleInventory a7;
        IItem iItem = a7.k.get(a2);
        if (iItem == null) {
            return;
        }
        IItem iItem2 = iItem;
        iItem2.setQuantity((short)(iItem2.getQuantity() - a3));
        if (iItem2.getQuantity() < 0) {
            iItem.setQuantity((short)0);
        }
        if (iItem.getQuantity() == 0 && !a4) {
            a7.removeSlot(a5, a2);
        }
        if (a6 && a5 != null) {
            MapleCharacter mapleCharacter = a5;
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(3, iItem)));
            mapleCharacter.dropMessage(5, "\u52a0\u503c\u9053\u5177[" + MapleItemInformationProvider.getInstance().getName(iItem.getItemId()) + "]\u56e0\u5230\u671f\u800c\u6d88\u5931\u4e86\u3002");
        }
        if (GameSetConstants.CHECK_COPYITEM) {
            MapleInventory mapleInventory = a7;
            CheckCopyItem.UpdateItem(a5, mapleInventory.k, mapleInventory.a);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ IItem findByInventoryIdAndItemId(long a2, int a3) {
        MapleInventory a4;
        a4.ALLATORIxDEMO.readLock().lock();
        try {
            for (IItem iItem : a4.k.values()) {
                if (iItem.getInventoryitemId() != a2 || iItem.getItemId() != a3) continue;
                return iItem;
            }
        }
        finally {
            a4.ALLATORIxDEMO.readLock().unlock();
        }
        return null;
    }

    public /* synthetic */ int getNumSlotLimit() {
        MapleInventory a2;
        return a2.k.size();
    }

    public /* synthetic */ short getNextFreeSlot() {
        short s2;
        MapleInventory a2;
        if (a2.isFull()) {
            return -1;
        }
        short s3 = s2 = 1;
        while (s3 <= a2.K) {
            if (!a2.k.keySet().contains(s2)) {
                return s2;
            }
            s3 = (short)(s2 + 1);
        }
        return -1;
    }

    public /* synthetic */ int countById(int a2) {
        MapleInventory a3;
        int n2 = 0;
        for (IItem iItem : a3.k.values()) {
            if (iItem.getItemId() != a2) continue;
            n2 += iItem.getQuantity();
        }
        return n2;
    }

    public /* synthetic */ IItem getItemRandom() {
        MapleInventory a2;
        int n2 = Randomizer.rand(1, a2.k.size());
        int n3 = 0;
        short s2 = 0;
        for (Map.Entry<Short, IItem> entry : a2.k.entrySet()) {
            if (n2 != ++n3) continue;
            s2 = entry.getKey();
        }
        return a2.k.get(s2);
    }

    @Override
    public /* synthetic */ Iterator<IItem> iterator() {
        MapleInventory a2;
        return Collections.unmodifiableCollection(a2.k.values()).iterator();
    }

    public /* synthetic */ short addItem(MapleCharacter a2, Item a3, int a4) {
        MapleInventory a5;
        a5.k.put((short)a4, a3);
        if (GameSetConstants.CHECK_COPYITEM) {
            MapleInventory mapleInventory = a5;
            CheckCopyItem.UpdateItem(a2, mapleInventory.k, mapleInventory.a);
        }
        a3.setPosition((short)a4);
        return (short)a4;
    }

    public /* synthetic */ void addSlot(byte a2) {
        MapleInventory a3;
        MapleInventory mapleInventory = a3;
        mapleInventory.K = (byte)(mapleInventory.K + a2);
        if (mapleInventory.K > 96) {
            a3.K = (byte)96;
        }
    }

    public /* synthetic */ short addItem(MapleCharacter a2, IItem a3) {
        MapleInventory a4;
        short s2 = a4.getNextFreeSlot();
        if (s2 < 0) {
            if (GameSetConstants.STORAGE_EXCEED && a2.getStorageExceed() != null && !GameConstants.isPet(a3.getItemId()) && a3.getQuantity() > 0) {
                if (a2.getStorageExceed().get((Object)MapleStorageType.STORAGE_EXCEED_ITEM).getItems().size() < 100) {
                    a2.getStorageExceed().get((Object)MapleStorageType.STORAGE_EXCEED_ITEM).store(a3);
                    a2.dropMessage(5, "\u60a8\u6709\u80cc\u5305\u6b04\u4f4d\u5df2\u6eff!\u5df2\u5c07\u60a8\u6b63\u8981\u7372\u5f97\u7684\u7684\u7269\u54c1: " + a3.getItemName() + " \u5b58\u5165\u6eff\u5305\u5009\u5eab!");
                } else {
                    a2.dropMessage(5, MapleTrait.ALLATORIxDEMO("\u60fa\u76dd\u6ead\u535c\u505b\u5ef2\u5978\u6ea6\u4ed4x\u8a99\u62d3\u6723\u8926\u7d34\u62a6\u51a8\u4fdfs"));
                }
            }
            return -1;
        }
        a4.k.put(s2, a3);
        if (GameSetConstants.CHECK_COPYITEM) {
            MapleInventory mapleInventory = a4;
            CheckCopyItem.UpdateItem(a2, mapleInventory.k, mapleInventory.a);
        }
        a3.setPosition(s2);
        return s2;
    }

    public /* synthetic */ IItem findById(int a2) {
        MapleInventory a3;
        for (IItem iItem : a3.k.values()) {
            if (iItem.getItemId() != a2) continue;
            return iItem;
        }
        return null;
    }

    public /* synthetic */ short getNumFreeSlot() {
        short s2;
        MapleInventory a2;
        if (a2.isFull()) {
            return 0;
        }
        int n2 = 0;
        short s3 = s2 = 1;
        while (s3 <= a2.K) {
            if (!a2.k.keySet().contains(s2)) {
                n2 = (byte)(n2 + 1);
            }
            s3 = (short)(s2 + 1);
        }
        return (short)n2;
    }

    public /* synthetic */ void addBagItem() {
        MapleInventory a2;
        ++a2.d;
    }

    public /* synthetic */ IItem getItemByInventoryItemId(Long a2) {
        MapleInventory a3;
        for (IItem iItem : a3.k.values()) {
            if (iItem.getInventoryitemId() != a2.longValue()) continue;
            return iItem;
        }
        return null;
    }

    private /* synthetic */ void ALLATORIxDEMO(IItem a2, IItem a3) {
        MapleInventory a4;
        a4.k.remove(a2.getPosition());
        a4.k.remove(a3.getPosition());
        IItem iItem = a3;
        short s2 = a2.getPosition();
        a2.setPosition(iItem.getPosition());
        iItem.setPosition(s2);
        a4.k.put(a2.getPosition(), a2);
        a4.k.put(a3.getPosition(), a3);
    }

    public /* synthetic */ boolean isFull(int a2) {
        MapleInventory a3;
        return a3.k.size() + a2 - a3.d >= a3.K;
    }

    public /* synthetic */ void move(short a2, short a3, short a4, MapleCharacter a5) {
        MapleInventory a6;
        Item item2 = (Item)a6.k.get(a2);
        Item item3 = (Item)a6.k.get(a3);
        if (item2 == null) {
            throw new InventoryException(GashaponRewardSpecial.ALLATORIxDEMO("sv^mIc\u0007pH$JkQa\u0007aJtS}\u0007wKkS"));
        }
        if (item3 == null) {
            item2.setPosition(a3);
            a6.k.put(a3, item2);
            a6.k.remove(a2);
        } else if (item3.getItemId() == item2.getItemId() && !GameConstants.isThrowingStar(item2.getItemId()) && !GameConstants.isBullet(item2.getItemId()) && item3.getOwner().equals(item2.getOwner()) && item3.getExpiration() == item2.getExpiration()) {
            if (a6.a.getType() == MapleInventoryType.EQUIP.getType() || a6.a.getType() == MapleInventoryType.CASH.getType()) {
                a6.ALLATORIxDEMO(item3, item2);
            } else if (item2.getQuantity() + item3.getQuantity() > a4) {
                Item item4 = item2;
                Item item5 = item3;
                short s2 = a4;
                item4.setQuantity((short)(item4.getQuantity() + item5.getQuantity() - s2));
                item5.setQuantity(s2);
            } else {
                item3.setQuantity((short)(item2.getQuantity() + item3.getQuantity()));
                a6.k.remove(a2);
            }
        } else {
            a6.ALLATORIxDEMO(item3, item2);
        }
        if (GameSetConstants.CHECK_COPYITEM) {
            MapleInventory mapleInventory = a6;
            CheckCopyItem.UpdateItem(a5, mapleInventory.k, mapleInventory.a);
        }
    }

    public /* synthetic */ void addFromDB(MapleCharacter a2, IItem a3) {
        MapleInventory a4;
        if (a3.getPosition() < 0 && !a4.a.equals((Object)MapleInventoryType.EQUIPPED)) {
            return;
        }
        if (a3.getItemId() == 3994192) {
            return;
        }
        if (MapleItemInformationProvider.getInstance().isCash(a3.getItemId()) && a3.getUniqueId() < 0 && GameConstants.getInventoryType(a3.getItemId()) == MapleInventoryType.EQUIP) {
            int n2 = MapleInventoryIdentifier.getInstance();
            a3.setUniqueId(n2);
        }
        if (a3.getExpiration() > 4000000000000L) {
            a3.setExpiration(-1L);
        }
        a4.k.put(a3.getPosition(), a3);
        if (GameSetConstants.CHECK_COPYITEM) {
            MapleInventory mapleInventory = a4;
            CheckCopyItem.UpdateItem(a2, mapleInventory.k, mapleInventory.a);
        }
    }
}

