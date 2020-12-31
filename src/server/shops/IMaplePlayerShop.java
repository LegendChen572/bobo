/*
 * Decompiled with CFR 0.150.
 */
package server.shops;

import client.MapleCharacter;
import client.MapleClient;
import java.util.List;
import server.MaplePlayerShopBuyItem;
import server.shops.AbstractPlayerStore;
import server.shops.MaplePlayerShopItem;
import tools.Pair;

public interface IMaplePlayerShop {
    public static final /* synthetic */ byte MATCH_CARD = 4;
    public static final /* synthetic */ byte OMOK = 3;
    public static final /* synthetic */ byte PLAYER_SHOP = 2;
    public static final /* synthetic */ byte HIRED_MERCHANT = 1;
    public static final /* synthetic */ byte HIRED_FISHING = 0;

    public /* synthetic */ void removeAllVisitors(int var1, int var2);

    public /* synthetic */ boolean saveItems(boolean var1);

    public /* synthetic */ int getOpenMinute();

    public /* synthetic */ void addVisitor(MapleCharacter var1);

    public /* synthetic */ int getItemId();

    public /* synthetic */ int getMaxSize();

    public /* synthetic */ List<AbstractPlayerStore.BoughtItem> getBoughtItems();

    public /* synthetic */ void setMeso(int var1);

    public /* synthetic */ void setNeedSave(boolean var1);

    public /* synthetic */ void closeShop(boolean var1, boolean var2);

    public /* synthetic */ void setOpen(boolean var1);

    public /* synthetic */ String getDescription();

    public /* synthetic */ boolean isAvailable();

    public /* synthetic */ void addOpenMinute(int var1);

    public /* synthetic */ int getMeso();

    public /* synthetic */ boolean removeItem(int var1);

    public /* synthetic */ void removeFromAcquisitionItem(int var1);

    public /* synthetic */ String getOwnerName();

    public /* synthetic */ void removeVisitor(MapleCharacter var1);

    public /* synthetic */ void setOpenMinute(int var1);

    public /* synthetic */ boolean isOwner(MapleCharacter var1);

    public /* synthetic */ void broadcastToVisitors(byte[] var1);

    public /* synthetic */ List<MaplePlayerShopBuyItem> getAcquisitionItems();

    public /* synthetic */ void removeFromSlot(int var1);

    public /* synthetic */ byte getShopType();

    public /* synthetic */ int getSize();

    public /* synthetic */ void update();

    public /* synthetic */ boolean getNeedSave();

    public /* synthetic */ List<MaplePlayerShopItem> getItems();

    public /* synthetic */ boolean isOpen();

    public /* synthetic */ byte getVisitorSlot(MapleCharacter var1);

    public /* synthetic */ int getGameType();

    public /* synthetic */ String getPassword();

    public /* synthetic */ void addItem(MaplePlayerShopItem var1);

    public /* synthetic */ int getOwnerId();

    public /* synthetic */ void buy(MapleClient var1, int var2, short var3);

    public /* synthetic */ byte getFreeSlot();

    public /* synthetic */ int getOwnerAccId();

    public /* synthetic */ void setCanShop(boolean var1);

    public /* synthetic */ boolean getCanShop();

    public /* synthetic */ List<Pair<Byte, MapleCharacter>> getVisitors();

    public /* synthetic */ void closeShop(boolean var1, boolean var2, boolean var3);

    public /* synthetic */ void setAvailable(boolean var1);

    public /* synthetic */ MapleCharacter getOwner();

    public /* synthetic */ void addAcquisitionItem(MaplePlayerShopBuyItem var1);
}

