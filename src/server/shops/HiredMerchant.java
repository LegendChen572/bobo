/*
 * Decompiled with CFR 0.150.
 */
package server.shops;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.ServerConfig;
import handling.channel.ChannelServer;
import handling.channel.handler.HiredMerchantHandler;
import handling.login.LoginServer;
import handling.world.World;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import scripting.AbstractPlayerInteraction;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MaplePlayerShopBuyItem;
import server.MerchItemPackage;
import server.Timer;
import server.life.MobSkill;
import server.maps.MapleMapObjectType;
import server.shops.AbstractPlayerStore;
import server.shops.MaplePlayerShopItem;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.packet.PlayerShopPacket;

public class HiredMerchant
extends AbstractPlayerStore {
    private /* synthetic */ int k;
    private final /* synthetic */ List<String> d;
    private final /* synthetic */ Map<String, Integer> a;
    private final /* synthetic */ long B;
    private /* synthetic */ ReentrantReadWriteLock K;
    public /* synthetic */ boolean canShop;
    public final /* synthetic */ HashMap<Integer, MaplePlayerShopItem> acquisition_get;
    private /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;

    @Override
    public /* synthetic */ byte getShopType() {
        return 1;
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        HiredMerchant a3;
        if (a3.isAvailable()) {
            a2.sendPacket(PlayerShopPacket.destroyHiredMerchant(a3.getOwnerId()));
        }
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        HiredMerchant a3;
        if (a3.isAvailable()) {
            a2.sendPacket(PlayerShopPacket.spawnHiredMerchant(a3));
        }
    }

    @Override
    public /* synthetic */ void removeFromAcquisitionItem(int a2) {
        HiredMerchant a3;
        a3.acquisition_items.remove(a2);
    }

    public final /* synthetic */ void removeBlackList(String a2) {
        HiredMerchant a3;
        a3.d.remove(a2);
    }

    public final /* synthetic */ void sendVisitor(MapleClient a22) {
        try {
            HiredMerchant a3;
            a22.sendPacket(PlayerShopPacket.MerchantVisitorView(a3.visitors));
            return;
        }
        catch (Exception a22) {
            return;
        }
    }

    public final /* synthetic */ void sendMsg(MapleClient a2) {
        HiredMerchant a4;
        a4.a.entrySet().stream().forEach(a3 -> a2.sendPacket(PlayerShopPacket.shopChat((String)a3.getKey(), (Integer)a3.getValue())));
    }

    public /* synthetic */ int getTimeLeft() {
        HiredMerchant a2;
        return (int)((System.currentTimeMillis() - a2.B) / 1000L);
    }

    public final /* synthetic */ void setStoreId(int a2) {
        a.k = a2;
    }

    public /* synthetic */ HiredMerchant(MapleCharacter a2, int a3, String a4) {
        HiredMerchant a5;
        HiredMerchant hiredMerchant = a5;
        super(a2, a3, a4, "", 3);
        a5.canShop = true;
        HiredMerchant hiredMerchant2 = a5;
        hiredMerchant.K = new ReentrantReadWriteLock();
        hiredMerchant2.B = System.currentTimeMillis();
        hiredMerchant.d = new LinkedList<String>();
        hiredMerchant.a = new HashMap<String, Integer>();
        hiredMerchant.acquisition_get = new HashMap();
        hiredMerchant.ALLATORIxDEMO = Timer.EtcTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                1 a2;
                1 v0 = a2;
                v0.HiredMerchant.this.removeAllVisitors(MaplePacketOperation.MerchantStatus.\u8d85\u904e\u71df\u696d\u6642\u9593, 0);
                v0.HiredMerchant.this.closeShop(true, true);
            }
            {
                1 a3;
            }
        }, 86400000L);
    }

    @Override
    public final /* synthetic */ boolean getCanShop() {
        HiredMerchant a2;
        return a2.canShop;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public /* synthetic */ void closeShop(boolean a2, boolean a3, boolean a4) {
        HiredMerchant a5;
        a5.K.writeLock().lock();
        try {
            if (a5.ALLATORIxDEMO != null) {
                a5.ALLATORIxDEMO.cancel(false);
            }
            HiredMerchant hiredMerchant = a5;
            MerchItemPackage merchItemPackage = HiredMerchantHandler.loadItemFromDatabase(hiredMerchant.ownerId, hiredMerchant.ownerAccount);
            if ((a4 || merchItemPackage != null) && a2 && a5.getCanShop()) {
                a5.saveItems(true);
                a5.items.clear();
            }
            if (a3) {
                HiredMerchant hiredMerchant2 = a5;
                HiredMerchant hiredMerchant3 = a5;
                ChannelServer.getInstance(hiredMerchant2.world, hiredMerchant2.channel).removeMerchant(hiredMerchant3);
                hiredMerchant3.getMap().broadcastMessage(PlayerShopPacket.destroyHiredMerchant(a5.getOwnerId()));
            }
            HiredMerchant hiredMerchant4 = a5;
            hiredMerchant4.setCanShop(false);
            hiredMerchant4.getMap().removeMapObject(a5);
            a5.ALLATORIxDEMO = null;
            return;
        }
        finally {
            a5.K.writeLock().unlock();
        }
    }

    public final /* synthetic */ void sendBlackList(MapleClient a2) {
        HiredMerchant a3;
        a2.sendPacket(PlayerShopPacket.MerchantBlackListView(a3.d));
    }

    public final /* synthetic */ boolean isInBlackList(String a2) {
        HiredMerchant a3;
        return a3.d.contains(a2);
    }

    public /* synthetic */ List<MaplePlayerShopItem> searchItem(int a2) {
        HiredMerchant a3;
        LinkedList<MaplePlayerShopItem> linkedList = new LinkedList<MaplePlayerShopItem>();
        for (MaplePlayerShopItem maplePlayerShopItem : a3.items) {
            if (maplePlayerShopItem.item.getItemId() != a2 || maplePlayerShopItem.bundles <= 0) continue;
            linkedList.add(maplePlayerShopItem);
        }
        return linkedList;
    }

    public final /* synthetic */ void addBlackList(String a2) {
        HiredMerchant a3;
        a3.d.add(a2);
    }

    public final /* synthetic */ int getStoreId() {
        HiredMerchant a2;
        return a2.k;
    }

    @Override
    public final /* synthetic */ void setCanShop(boolean a2) {
        a.canShop = a2;
    }

    @Override
    public /* synthetic */ void closeShop(boolean a2, boolean a3) {
        HiredMerchant a4;
        a4.closeShop(a2, a3, false);
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.HIRED_MERCHANT;
    }

    @Override
    public /* synthetic */ void buy(MapleClient a2, int a32, short a42) {
        MapleClient mapleClient;
        HiredMerchant a5;
        Object a32 = (MaplePlayerShopItem)a5.items.get(a32);
        Object object = ((MaplePlayerShopItem)a32).item.copy();
        short s2 = object.getQuantity();
        int n2 = ((MaplePlayerShopItem)a32).price * a42;
        object.setQuantity((short)(a42 * s2));
        if ((long)((MaplePlayerShopItem)a32).price * (long)a42 > Integer.MAX_VALUE) {
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().dropMessage(1, MobSkill.ALLATORIxDEMO("\u8cd6\u8c9d\u9079\u515d\u76ae\u91fb\u5e49\u8daf\u51d0\u672a\u590d\u5016"));
            mapleClient2.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        n2 = object.getFlag();
        if (ItemFlag.KARMA_EQ.check(n2)) {
            mapleClient = a2;
            object.setFlag(n2 - ItemFlag.KARMA_EQ.getValue());
        } else {
            if (ItemFlag.KARMA_USE.check(n2)) {
                object.setFlag(n2 - ItemFlag.KARMA_USE.getValue());
            }
            mapleClient = a2;
        }
        if (!mapleClient.getPlayer().canHold(object.getItemId())) {
            MapleClient mapleClient3 = a2;
            mapleClient3.getPlayer().dropMessage(1, AbstractPlayerInteraction.ALLATORIxDEMO("\u60fe\u7685\u809a\u5304\u6ea9\u4e87"));
            mapleClient3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        object.setGMLog(a2.getPlayer().getName() + " Buy from  " + a5.getOwnerName() + "'s Merchant " + object.getItemId() + "x" + a42 + " Prize : " + ((MaplePlayerShopItem)a32).price);
        if (MapleInventoryManipulator.addFromDrop(a2, (IItem)object, false)) {
            ((MaplePlayerShopItem)a32).bundles = (short)(((MaplePlayerShopItem)a32).bundles - a42);
            HiredMerchant hiredMerchant = a5;
            n2 = hiredMerchant.getMeso() + ((MaplePlayerShopItem)a32).price * a42 - GameConstants.EntrustedStoreTax(((MaplePlayerShopItem)a32).price * a42);
            hiredMerchant.setMeso(n2);
            a2.getPlayer().gainMeso(-((MaplePlayerShopItem)a32).price * a42, false);
            MapleCharacter mapleCharacter = hiredMerchant.getMCOwnerWorld();
            if (mapleCharacter != null) {
                mapleCharacter.dropMessage(5, "\u9053\u5177 " + MapleItemInformationProvider.getInstance().getName(object.getItemId()) + " (" + s2 + ") \u00d7 " + a42 + " \u5df2\u88ab\u73a9\u5bb6: " + a2.getPlayer().getName() + " \u8cfc\u8cb7\uff0c\u9084\u5269\u4e0b\uff1a" + ((MaplePlayerShopItem)a32).bundles + " \u500b");
            }
            if (ServerConfig.LOG_MERCHANT) {
                FileoutputUtil.logToFile(MobSkill.ALLATORIxDEMO("FEMY\u0005nK^K\u0005\u7c94\u9762\u556c\u4e90\u0004^R^"), "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "] IP: " + a2.getSession().remoteAddress().toString().split(AbstractPlayerInteraction.ALLATORIxDEMO(";"))[0] + " \u73a9\u5bb6 " + a2.getPlayer().getName() + " \u5f9e  " + a5.getOwnerName() + " \u7684\u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u4e86" + MapleItemInformationProvider.getInstance().getName(object.getItemId()) + " (" + object.getItemId() + ") x" + a42 + " \u55ae\u500b\u50f9\u9322\u70ba : " + ((MaplePlayerShopItem)a32).price + " \u73a9\u5bb6\u5269\u9918\u6953\u5e63:" + a2.getPlayer().getMeso() + " \u5546\u5e97\u6953\u5e63\u589e\u52a0\u81f3: " + n2);
            }
            a32 = new StringBuilder("[GM \u5bc6\u8a9e] \u73a9\u5bb6 " + a2.getPlayer().getName() + " \u5f9e  " + a5.getOwnerName() + " \u7684\u7cbe\u9748\u5546\u4eba\u8cfc\u8cb7\u4e86 " + MapleItemInformationProvider.getInstance().getName(object.getItemId()) + "(" + object.getItemId() + ") x" + a42 + " \u55ae\u500b\u50f9\u9322\u70ba : " + ((MaplePlayerShopItem)a32).price);
            Iterator<World> a42 = LoginServer.getWorlds().iterator();
            while (a42.hasNext()) {
                object = a42.next().getChannels().iterator();
                while (object.hasNext()) {
                    for (MapleCharacter mapleCharacter2 : ((ChannelServer)object.next()).getPlayerStorage().getAllCharactersThreadSafe()) {
                        if (!mapleCharacter2.getmsg_HiredMerchant()) continue;
                        mapleCharacter2.dropMessage(((StringBuilder)a32).toString());
                    }
                }
            }
        } else {
            MapleClient mapleClient4 = a2;
            mapleClient4.getPlayer().dropMessage(1, MobSkill.ALLATORIxDEMO("\u6082\u76ae\u80e6\u532f\u6ed5\u4eac\uff26\u8ae1\u6a88\u67cf\u6082\u76ae\u80e6\u532f\uff2b"));
            mapleClient4.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public final /* synthetic */ void addMsg(String a2, byte a3) {
        HiredMerchant a4;
        a4.a.put(a2, Integer.valueOf(a3));
    }

    @Override
    public /* synthetic */ void addAcquisitionItem(MaplePlayerShopBuyItem a2) {
        HiredMerchant a3;
        a3.acquisition_items.add(a2);
    }

    public /* synthetic */ void buyAcquisitionItem(MapleClient a2, int a32, short a4, short a5) {
        HiredMerchant a6;
        MaplePlayerShopBuyItem maplePlayerShopBuyItem = (MaplePlayerShopBuyItem)a6.acquisition_items.get(a32);
        IItem iItem = maplePlayerShopBuyItem.item.copy();
        short s2 = iItem.getQuantity();
        long l2 = maplePlayerShopBuyItem.price * a5;
        iItem.setQuantity((short)(a5 * s2));
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(maplePlayerShopBuyItem.item.getItemId());
        int n2 = iItem.getFlag();
        if (a2.getPlayer().getInventory(mapleInventoryType).getItem(a4).getExpiration() <= System.currentTimeMillis() && a2.getPlayer().getInventory(mapleInventoryType).getItem(a4).getExpiration() != -1L) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().expirationTask(true, false);
            mapleClient.getPlayer().dropMessage(1, AbstractPlayerInteraction.ALLATORIxDEMO("\u8a73\u5510\u54c0\u5da4\u904f\u6749/"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (l2 > Integer.MAX_VALUE) {
            a2.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a4 = (short)l2;
        long l3 = l2 - (long)GameConstants.EntrustedStoreTax(a4);
        if ((long)a6.getMeso() - l2 >= 0L) {
            HiredMerchant hiredMerchant;
            if (ItemFlag.KARMA_EQ.check(n2)) {
                hiredMerchant = a6;
                iItem.removeFlag(ItemFlag.KARMA_EQ.getValue());
            } else {
                if (ItemFlag.KARMA_USE.check(n2)) {
                    iItem.removeFlag(ItemFlag.KARMA_USE.getValue());
                }
                hiredMerchant = a6;
            }
            hiredMerchant.setMeso(a6.getMeso() - a4);
            MaplePlayerShopBuyItem maplePlayerShopBuyItem2 = maplePlayerShopBuyItem;
            maplePlayerShopBuyItem2.bundles = (short)(maplePlayerShopBuyItem2.bundles - a5 * s2);
            maplePlayerShopBuyItem2.qty = (short)(maplePlayerShopBuyItem2.qty + (short)(a5 * s2));
            iItem.setQuantity(maplePlayerShopBuyItem2.qty);
            MapleInventoryManipulator.removeById(a2, mapleInventoryType, iItem.getItemId(), a5 * s2, false, false);
            a2.getPlayer().gainMeso(a4, true);
            a6.acquisition_get.put(a32, new MaplePlayerShopItem(iItem, maplePlayerShopBuyItem.qty, -1));
            MapleCharacter a32 = a6.getMCOwnerWorld();
            if (a32 != null) {
                short s3 = s2;
                a32.dropMessage(5, "\u9053\u5177 " + iItem.getItemName() + " (" + s3 + ") x " + a5 * s3 + " \u5728\u7cbe\u9748\u5546\u4eba\u6536\u8cfc\u4e2d\u88ab\u8cb7\u5165. \u5269\u4e0b\u9700\u6c42\u6578\u91cf: " + maplePlayerShopBuyItem.bundles);
                return;
            }
        } else {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dropMessage(1, MobSkill.ALLATORIxDEMO("\u8c9d\u5b9c\u632b\u6723\u76ae\u6979\u5e49\u4e27\u8d99\uff26\u710b\u6cff\u8cd6\u8c9d"));
            mapleClient.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
        }
    }

    public /* synthetic */ HashMap<Integer, MaplePlayerShopItem> getAcquisition_get() {
        HiredMerchant a2;
        return a2.acquisition_get;
    }
}

