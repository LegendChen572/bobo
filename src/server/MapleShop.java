/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleFriendship;
import client.SkillFactory;
import client.inventory.IItem;
import client.inventory.ItemCustomFlag;
import client.inventory.MapleInventoryIdentifierPet;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.MapleRing;
import client.inventory.ModifyInventory;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import server.AutobanManager;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MapleShopItem;
import server.shops.MapleShopResponse;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;

public class MapleShop {
    private final /* synthetic */ List<MapleShopItem> d;
    private final /* synthetic */ int a;
    public static final /* synthetic */ Set<Integer> rechargeableItems;
    private final /* synthetic */ int K;
    private final /* synthetic */ List<Pair<Integer, String>> ALLATORIxDEMO;

    public /* synthetic */ void sendShop(MapleClient a2) {
        if (a2 != null && a2.getPlayer() != null) {
            MapleShop a3;
            MapleClient mapleClient = a2;
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().setShop(a3);
            mapleClient2.sendPacket(MaplePacketCreator.getNPCShop(mapleClient, a3.getNpcId(), a3.d, a3));
            if (mapleClient.getPlayer().isGM()) {
                a2.getPlayer().dropMessage("\u5546\u5e97NPC ID: " + a3.getNpcId() + " \u5546\u5e97ID:" + a3.K);
            }
        }
    }

    public /* synthetic */ List<MapleShopItem> getItems() {
        MapleShop a2;
        return a2.d;
    }

    public static /* synthetic */ {
        List<Integer> list;
        rechargeableItems = new LinkedHashSet<Integer>();
        if (GameSetConstants.MAPLE_VERSION == 75) {
            rechargeableItems.add(2070000);
            rechargeableItems.add(2070001);
            rechargeableItems.add(2070002);
            rechargeableItems.add(2070003);
            rechargeableItems.add(2070004);
            rechargeableItems.add(2070005);
            rechargeableItems.add(2070006);
            rechargeableItems.add(2070007);
            rechargeableItems.add(2070008);
            rechargeableItems.add(2070009);
            rechargeableItems.add(2070010);
            rechargeableItems.add(2070011);
            rechargeableItems.add(2070012);
            rechargeableItems.add(2070015);
            rechargeableItems.add(2330000);
            rechargeableItems.add(2330001);
            rechargeableItems.add(2330002);
            rechargeableItems.add(2330003);
            rechargeableItems.add(2330004);
            rechargeableItems.add(2330005);
            rechargeableItems.add(2331000);
            rechargeableItems.add(2332000);
        } else {
            rechargeableItems.add(2070000);
            rechargeableItems.add(2070001);
            rechargeableItems.add(2070002);
            rechargeableItems.add(2070003);
            rechargeableItems.add(2070004);
            rechargeableItems.add(2070005);
            rechargeableItems.add(2070006);
            rechargeableItems.add(2070007);
            rechargeableItems.add(2070008);
            rechargeableItems.add(2070009);
            rechargeableItems.add(2070010);
            rechargeableItems.add(2070011);
            rechargeableItems.add(2070012);
            rechargeableItems.add(2070013);
            rechargeableItems.add(2070019);
            rechargeableItems.add(2330000);
            rechargeableItems.add(2330001);
            rechargeableItems.add(2330002);
            rechargeableItems.add(2330003);
            rechargeableItems.add(2330004);
            rechargeableItems.add(2330005);
            rechargeableItems.add(2330007);
            rechargeableItems.add(2331000);
            rechargeableItems.add(2332000);
        }
        if (GameSetConstants.SERVER_NAME.equals(MapleFriendship.ALLATORIxDEMO("\u6607\u802b\u8c2f"))) {
            rechargeableItems.add(2070023);
            rechargeableItems.add(2070024);
            rechargeableItems.add(2070026);
        }
        if (GameSetConstants.NEW_RECHARGE_ITEM) {
            rechargeableItems.add(2070018);
            rechargeableItems.add(2070022);
            rechargeableItems.add(2070023);
            rechargeableItems.add(2070024);
            rechargeableItems.add(2070025);
            rechargeableItems.add(2070026);
            rechargeableItems.add(2330008);
            rechargeableItems.add(2330009);
            rechargeableItems.add(2330010);
            rechargeableItems.add(2330011);
            rechargeableItems.add(2330012);
            rechargeableItems.add(2330013);
            rechargeableItems.add(2330016);
            rechargeableItems.add(2333000);
            rechargeableItems.add(2333001);
        }
        if ((list = MapleItemInformationProvider.getInstance().getRechargeItems()).size() > 0) {
            rechargeableItems.addAll(list);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void buySellBack(MapleClient a2, int a3, int a4) {
        MapleShop a5;
        IItem iItem;
        boolean bl = false;
        Iterator<IItem> iterator = a2.getPlayer().getSell().iterator();
        block0: do {
            Iterator<IItem> iterator2 = iterator;
            while (true) {
                if (!iterator2.hasNext()) {
                    if (bl) return;
                    a2.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u4f4b\u5dea\u7db8\u8ce4\u8c9c\u56c6\u6b4f\u7271\u54ea\u4e9e\u54cd9"));
                    MapleClient mapleClient = a2;
                    mapleClient.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u767c\u751f\u672a\u77e5\u932f\u8aa4, a5, mapleClient, -1));
                    return;
                }
                iItem = iterator.next();
                if (iItem != null) continue block0;
                iterator2 = iterator;
            }
        } while (iItem.getItemId() != a3);
        if (iItem.getQuantity() != a4) {
            a2.getPlayer().dropMessage(1, "\u8cb7\u56de\u5931\u6557,\u4f60\u4e4b\u524d\u6240\u8ca9\u8ce3\u7684\u6578\u91cf\u70ba" + iItem.getQuantity() + "\u500b!");
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u767c\u751f\u672a\u77e5\u932f\u8aa4, a5, mapleClient, -1));
            return;
        }
        bl = true;
        int n2 = (int)MapleItemInformationProvider.getInstance().getPrice(iItem.getItemId()) * a4;
        if (a2.getPlayer().getMeso() < n2) {
            a2.getPlayer().dropMessage(1, MapleRing.ALLATORIxDEMO("\u4f3c\u769e\u690f\u5e79\u4e51\u8da9}"));
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u80cc\u5305\u91d1\u5e63\u4e0d\u5920, a5, mapleClient, -1));
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            int n3;
            int n4;
            block9: {
                Iterator<MapleShopItem> iterator3;
                int n5 = 0;
                n4 = -1;
                Iterator<MapleShopItem> iterator4 = iterator3 = a2.getPlayer().getRebuy().iterator();
                while (iterator4.hasNext()) {
                    if (iterator3.next().getItemId() == a3) {
                        n3 = n4 = n5;
                        break block9;
                    }
                    ++n5;
                    iterator4 = iterator3;
                }
                n3 = n4;
            }
            if (n3 != -1 && a2.getPlayer().getRebuy().get(n4) != null) {
                a2.getPlayer().getRebuy().remove(n4);
            }
        }
        MapleClient mapleClient = a2;
        mapleClient.getPlayer().gainMeso(-n2, true);
        IItem iItem2 = iItem;
        mapleClient.getPlayer().removeSell(iItem2);
        MapleInventoryManipulator.addFromDrop(a2, iItem2, false);
        a2.getPlayer().equipChanged();
        MapleClient mapleClient2 = a2;
        mapleClient2.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u8cfc\u8cb7\u9053\u5177\u5b8c\u6210, a5, mapleClient2, -1));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ MapleShop createFromSell(MapleCharacter a2) {
        MapleShop mapleShop = null;
        mapleShop = new MapleShop(999, 9270027);
        Iterator<IItem> iterator = a2.getSell().iterator();
        while (true) {
            IItem iItem;
            Iterator<IItem> iterator2 = iterator;
            while (true) {
                if (!iterator2.hasNext()) {
                    return mapleShop;
                }
                iItem = iterator.next();
                if (iItem != null) break;
                iterator2 = iterator;
            }
            boolean bl = false;
            switch (iItem.getItemId()) {
                case 4001106: {
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            mapleShop.addItem(new MapleShopItem(1000, iItem.getItemId(), (int)MapleItemInformationProvider.getInstance().getPrice(iItem.getItemId()), 0, 0, 0, 0, 0, 0, 0, 0));
        }
    }

    public /* synthetic */ void recharge(MapleClient a2, byte a32) {
        IItem a32 = a2.getPlayer().getInventory(MapleInventoryType.USE).getItem(a32);
        if (a32 == null || !GameConstants.isThrowingStar(a32.getItemId()) && !GameConstants.isBullet(a32.getItemId())) {
            return;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        MapleClient mapleClient = a2;
        short s2 = mapleItemInformationProvider.getSlotMax(mapleClient, a32.getItemId());
        int n2 = GameConstants.getMasterySkill(mapleClient.getPlayer().getJob());
        if (n2 != 0) {
            s2 = (short)(s2 + a2.getPlayer().getSkillLevel(SkillFactory.getSkill(n2)) * 10);
        }
        if (a32.getQuantity() < s2) {
            MapleShop a4;
            int n3 = (int)Math.round(mapleItemInformationProvider.getPrice(a32.getItemId()) * (double)(s2 - a32.getQuantity()));
            if (a2.getPlayer().getMeso() >= n3) {
                a32.setQuantity(s2);
                a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, a32)));
                a2.getPlayer().gainMeso(-n3, false, true, false);
                MapleClient mapleClient2 = a2;
                mapleClient2.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u5145\u503c\u98db\u93e2\u5b8c\u6210, a4, mapleClient2, -1));
                return;
            }
            MapleClient mapleClient3 = a2;
            mapleClient3.getPlayer().dropMessage(1, MapleRing.ALLATORIxDEMO("\u4f3c\u769e\u690f\u5e79\u4e51\u8da9\uff50\u713b\u6c89\u88c6\u5119\u98c1\u93be\u301b\u5f14\u4e22\u305e"));
            mapleClient3.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u5145\u503c\u91d1\u5e63\u4e0d\u5920, a4, a2, -1));
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void sell(MapleClient a, MapleInventoryType a, byte a, short a) {
        block24: {
            block25: {
                if (a == 65535 || a == 0) {
                    a = 1;
                }
                if ((var5_5 = a.getPlayer().getInventory(a).getItem(a)) == null) {
                    return;
                }
                if (ItemCustomFlag.\u7121\u6cd5\u8ca9\u8ce3\u5546\u5e97.check(var5_5.getCustomFlag())) {
                    v0 = a;
                    v0.getPlayer().dropMessage(1, MapleRing.ALLATORIxDEMO("\u6b7e\u900f\u516d\u717d\u6ccf\u8cf5\u8cf9\u305e"));
                    v0.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                v1 = var5_5;
                var6_6 = v1.copy();
                if (GameConstants.isThrowingStar(v1.getItemId()) || GameConstants.isBullet(var5_5.getItemId())) {
                    a = var5_5.getQuantity();
                }
                if (a < 0) {
                    a.getPlayer().ban(a.getPlayer().getName() + "\u4fee\u6539\u5c01\u5305", true, true, false);
                    FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("GwLk\u0004PJ{@7\u556d\u5e8f\u0005lSl"), "\r\n" + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + a.getPlayer().getName() + " \u906d\u5230\u5c01\u9396\uff0c\u539f\u56e0\uff1a \u8ce3\u51fa" + var5_5.getItemId() + "\u7684\u6578\u91cf\u5c0f\u65bc0(\u70ba" + a + ")");
                    return;
                }
                var7_7 = var5_5.getQuantity();
                if (var7_7 == 65535) {
                    var7_7 = 1;
                }
                if ((var8_10 = MapleItemInformationProvider.getInstance()).cantSell(var5_5.getItemId())) {
                    return;
                }
                if (a > var7_7 || var7_7 <= 0 && !GameConstants.isRechargable(var5_5.getItemId())) break block24;
                if (GameConstants.isThrowingStar(var5_5.getItemId()) || GameConstants.isBullet(var5_5.getItemId())) {
                    var9_11 = (double)var8_10.getWholePrice(var5_5.getItemId()) + (double)a * var8_10.getPrice(var5_5.getItemId());
                    v2 = var5_5;
                } else {
                    var9_11 = var8_10.getPrice(var5_5.getItemId());
                    v2 = var5_5;
                }
                if (!GameConstants.isThrowingStar(v2.getItemId()) && !GameConstants.isBullet(var5_5.getItemId()) && (var7_8 = a.findById(var5_5.getItemId())) != null && var9_11 > (double)var7_8.getPrice()) {
                    FileoutputUtil.logToFile(MapleRing.ALLATORIxDEMO("v3}/5\u0014{?qs\u555c\u5ecb\u50e3\u68604(b("), "\r\n" + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + a.getPlayer().getName() + "\u5546\u5e97\u7269\u54c1:" + MapleItemInformationProvider.getInstance().getName(var5_5.getItemId()) + " \u7269\u54c1\u4ee3\u78bc:" + var5_5.getItemId() + " \u5546\u5e97\u8ca9\u8ce3\u50f9\u683c:" + var7_8.getPrice() + " \u5546\u5e97\u8ce3\u56de\u50f9\u683c:" + var9_11);
                    var9_11 = var7_8.getPrice();
                }
                var7_9 = 0;
                if (GameConstants.isThrowingStar(var5_5.getItemId()) || GameConstants.isBullet(var5_5.getItemId())) {
                    var7_9 = (int)var9_11;
                    v3 = var9_11;
                } else {
                    var11_14 = (long)(var9_11 * (double)a);
                    if (var11_14 > 0x7FFFFFFFL) {
                        a.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u4f78\u4e2b\u6b39\u8cc8\u5932\u5931\u933a\u4ead9"));
                        v4 = a;
                        v4.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u767c\u751f\u672a\u77e5\u932f\u8aa4, a, v4, -1));
                        return;
                    }
                    var7_9 = (int)Math.max(Math.ceil(var9_11 * (double)a), 0.0);
                    v3 = var9_11;
                }
                if (v3 == -1.0 || var7_9 <= 0) break block25;
                if (var7_9 > GameSetConstants.SELL_MESO_LIMIT) {
                    var7_9 = 1;
                }
                var11_15 = (int)((double)var7_9 * GameSetConstants.SELL_PRICE);
                if (GameSetConstants.MAPLE_VERSION < 139 || GameSetConstants.BUYBACK_SYSTEM) ** GOTO lbl88
                var12_16 = 5;
                if (GameSetConstants.MAPLE_VERSION >= 142) {
                    var12_16 = 10;
                }
                var8_10 = new ArrayList<E>();
                if (var5_5.getQuantity() == a) {
                    if (a.getPlayer().getRebuy().size() < var12_16) {
                        v5 = a;
                        v6 = v5;
                        v5.getPlayer().getRebuy().add(new MapleShopItem(var5_5.copy(), var7_9, var5_5.getQuantity()));
                    } else if (a.getPlayer().getRebuy().size() == var12_16) {
                        v7 = var9_12 = 1;
                        while (v7 < var12_16) {
                            var8_10.add(a.getPlayer().getRebuy().get(var9_12++));
                            v7 = var9_12;
                        }
                        var8_10.add(new MapleShopItem(var5_5.copy(), var7_9, var5_5.getQuantity()));
                        a.getPlayer().setRebuy((List<MapleShopItem>)var8_10);
                        v6 = a;
                    } else {
                        var9_13 = a.getPlayer().getRebuy().size();
                        v8 = var10_17 = var9_13 - var12_16;
                        while (v8 < var9_13) {
                            var8_10.add(a.getPlayer().getRebuy().get(var10_17++));
                            v8 = var10_17;
                        }
                        v9 = a;
                        v6 = v9;
                        v9.getPlayer().setRebuy((List<MapleShopItem>)var8_10);
                    }
                } else {
                    a.getPlayer().getRebuy().add(new MapleShopItem(var5_5.copyWithQuantity(a), var7_9, a));
lbl88:
                    // 2 sources

                    v6 = a;
                }
                MapleInventoryManipulator.removeFromSlot(v6, a, a, a, false);
                a.getPlayer().gainMeso(var11_15, false);
                if (GameSetConstants.BUYBACK_SYSTEM) {
                    var6_6.setQuantity(a);
                    a.getPlayer().addSell(var6_6);
                }
                FileoutputUtil.logToFile("logs/\u73a9\u5bb6\u64cd\u4f5c/" + a.getPlayer().getName() + "/\u8ca9\u8ce3\u9053\u5177.txt", a.getPlayer().getChrInfo("NPC: " + a.K + " \u9053\u5177" + var6_6.getItemName() + "(" + var6_6.getItemId() + ")\u6578\u91cf:" + a + " \u8ca9\u8ce3\u7e3d\u50f9\u683c:" + var11_15));
            }
            a.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u8ce3\u51fa\u9053\u5177\u5b8c\u6210, a, a, -1));
            return;
        }
        a.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u767c\u751f\u672a\u77e5\u932f\u8aa4, a, a, -1));
    }

    public /* synthetic */ MapleShopItem findById(int a2) {
        MapleShop a3;
        for (MapleShopItem mapleShopItem : a3.d) {
            if (mapleShopItem.getItemId() != a2) continue;
            return mapleShopItem;
        }
        return null;
    }

    public /* synthetic */ void buy(MapleClient a2, int a3, short a4) {
        int n2;
        Object object;
        Object object2;
        int n3;
        int n4;
        MapleShopItem mapleShopItem;
        MapleShop a5;
        block24: {
            if (a4 <= 0) {
                AutobanManager.getInstance().addPoints(a2, 1000, 0L, "Buying " + a4 + " " + a3);
                return;
            }
            if (a3 / 10000 == 190 && !GameConstants.isMountItemAvailable(a3, a2.getPlayer().getJob())) {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u4f78\u4e26\u53f7\u4ece\u8caf\u9032\u904b\u515c\u301a"));
                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            long l2 = -1L;
            mapleShopItem = a5.findById(a3);
            if (GameSetConstants.MAPLE_VERSION >= 139 && mapleShopItem != null && mapleShopItem.getExpiration() > 0) {
                l2 = TimeUnit.MINUTES.toMillis(mapleShopItem.getExpiration());
            }
            n4 = 0;
            n3 = -1;
            Object object3 = object2 = a2.getPlayer().getRebuy().iterator();
            while (object3.hasNext()) {
                object = object2.next();
                if (((MapleShopItem)object).getItemId() == a3) {
                    n2 = n3 = n4;
                    break block24;
                }
                ++n4;
                object3 = object2;
            }
            n2 = n3;
        }
        if (n2 >= 0) {
            object2 = MapleItemInformationProvider.getInstance();
            object = a2.getPlayer().getRebuy().get(n3).getReBuyItem();
            int n5 = (int)Math.max(Math.ceil(((MapleItemInformationProvider)object2).getPrice(a3) * (double)(GameConstants.isRechargable(a3) ? (short)1 : object.getQuantity())), 0.0);
            if (GameConstants.isRechargable(object.getItemId())) {
                n5 = (int)((double)((MapleItemInformationProvider)object2).getWholePrice(object.getItemId()) + Math.ceil((double)object.getQuantity() * ((MapleItemInformationProvider)object2).getPrice(object.getItemId())));
            }
            if (n5 >= 0 && a2.getPlayer().getMeso() >= n5) {
                if (MapleInventoryManipulator.checkSpace(a2, a3, object.getQuantity(), object.getOwner())) {
                    MapleClient mapleClient = a2;
                    mapleClient.getPlayer().gainMeso(-n5, false);
                    MapleInventoryManipulator.addbyItem(mapleClient, (IItem)object);
                    if (mapleClient.getPlayer().getRebuy().get(n3) != null) {
                        a2.getPlayer().getRebuy().remove(n3);
                    }
                    MapleClient mapleClient2 = a2;
                    mapleClient2.getPlayer().removeSell((IItem)object);
                    mapleClient2.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u8cfc\u8cb7\u9053\u5177\u5b8c\u6210, a5, a2, n4));
                    return;
                }
                a2.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u80cc\u5305\u7a7a\u9593\u4e0d\u5920, a5, a2, -1));
                return;
            }
            a2.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u767c\u751f\u672a\u77e5\u932f\u8aa4, a5, a2, -1));
            return;
        }
        if (mapleShopItem != null && mapleShopItem.getPrice() > 0 && mapleShopItem.getReqItem() == 0) {
            int n6;
            long l3 = (long)mapleShopItem.getPrice() * (long)a4;
            if (l3 > Integer.MAX_VALUE) {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(1, MapleRing.ALLATORIxDEMO("\u8ce6\u8ceb\u9049\u512b\u769e\u918d\u5e79\u8dd9\u51e0\u675c\u593d\u5060"));
                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            MapleShopItem mapleShopItem2 = mapleShopItem;
            int n7 = n6 = GameConstants.isRechargable(a3) ? mapleShopItem2.getPrice() : mapleShopItem2.getPrice() * a4;
            if (n6 >= 0 && a2.getPlayer().getMeso() >= n6) {
                if (MapleInventoryManipulator.checkSpace(a2, a3, a4, "")) {
                    MapleClient mapleClient;
                    a2.getPlayer().gainMeso(-n6, false);
                    if (GameConstants.isPet(a3)) {
                        MapleClient mapleClient3 = a2;
                        mapleClient = mapleClient3;
                        int n8 = a3;
                        MapleInventoryManipulator.addById(mapleClient3, n8, a4, "", MaplePet.createPet(n8, MapleInventoryIdentifierPet.getInstance()), -1L);
                    } else {
                        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                        if (GameConstants.isRechargable(a3)) {
                            a4 = mapleItemInformationProvider.getSlotMax(a2, mapleShopItem.getItemId());
                        }
                        MapleClient mapleClient4 = a2;
                        mapleClient = mapleClient4;
                        MapleInventoryManipulator.addById(mapleClient4, a3, a4);
                    }
                    mapleClient.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u8cfc\u8cb7\u9053\u5177\u5b8c\u6210, a5, a2, -1));
                    return;
                }
                int n9 = a3;
                short s2 = a4;
                a2.getPlayer().dropGMMessage("\u4f60\u7684\u9053\u5177\u6b04\u6eff\u4e86itemid:" + n9 + "\u9322:" + a2.getPlayer().getMeso() + "\u7269\u54c1\u6578\u91cf:" + s2 + "\u6b04\u4f4d\u5224\u65b7" + MapleInventoryManipulator.checkSpace(a2, n9, s2, ""));
                MapleClient mapleClient = a2;
                mapleClient.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u80cc\u5305\u7a7a\u9593\u4e0d\u5920, a5, mapleClient, -1));
                return;
            }
        } else if (mapleShopItem != null && mapleShopItem.getReqItem() > 0 && a4 == 1 && a2.getPlayer().haveItem(mapleShopItem.getReqItem(), mapleShopItem.getReqItemQ(), false, true)) {
            MapleClient mapleClient;
            if (MapleInventoryManipulator.checkSpace(a2, a3, a4, "")) {
                MapleInventoryManipulator.removeById(a2, GameConstants.getInventoryType(mapleShopItem.getReqItem()), mapleShopItem.getReqItem(), mapleShopItem.getReqItemQ(), false, false);
                if (GameConstants.isPet(a3)) {
                    MapleClient mapleClient5 = a2;
                    mapleClient = mapleClient5;
                    int n10 = a3;
                    MapleInventoryManipulator.addById(mapleClient5, n10, a4, "", MaplePet.createPet(n10, MapleInventoryIdentifierPet.getInstance()), -1L);
                } else {
                    object2 = MapleItemInformationProvider.getInstance();
                    if (GameConstants.isRechargable(a3)) {
                        a4 = ((MapleItemInformationProvider)object2).getSlotMax(a2, mapleShopItem.getItemId());
                    }
                    MapleClient mapleClient6 = a2;
                    mapleClient = mapleClient6;
                    MapleInventoryManipulator.addById(mapleClient6, a3, a4);
                }
            } else {
                MapleClient mapleClient7 = a2;
                mapleClient = mapleClient7;
                mapleClient7.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u4f4b\u769c\u9078\u516f\u6b2f\u6ee7\u4ead\u301a"));
                MapleClient mapleClient8 = a2;
                mapleClient8.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u80cc\u5305\u7a7a\u9593\u4e0d\u5920, a5, mapleClient8, -1));
            }
            mapleClient.sendPacket(MaplePacketCreator.confirmShopTransaction(MapleShopResponse.\u8cfc\u8cb7\u9053\u5177\u5b8c\u6210, a5, a2, -1));
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ MapleShop createFromDB(int a, boolean a) {
        var2_2 = MapleItemInformationProvider.getInstance();
        var3_3 = null;
        try {
            block20: {
                var4_4 = DBConPool.getInstance().getDataSource().getConnection();
                var5_6 = var4_4.prepareStatement(a != false ? MapleFriendship.ALLATORIxDEMO("x]g]hL\u000b2\u000b^yWf8XpDhX8|PnJn8XpDhB|\u000b%\u000b'") : MapleRing.ALLATORIxDEMO("\u000f_\u0010_\u001fN|0|\\\u000eU\u0011:/r3j/:\u000bR\u0019H\u0019:2j?s8:a:c"));
                var5_6.setInt(1, a);
                var6_8 = var5_6.executeQuery();
                if (!var6_8.next()) break block20;
                v0 = var6_8;
                a = v0.getInt(MapleFriendship.ALLATORIxDEMO("XpDhB|"));
                var3_3 = new MapleShop((int)a, var6_8.getInt(MapleRing.ALLATORIxDEMO("2j?s8")));
                v0.close();
                var5_6.close();
                ** GOTO lbl26
            }
            var6_8.close();
            var5_6.close();
            var7_10 = null;
            if (var4_4 == null) return var7_10;
            var4_4.close();
            return var7_10;
lbl26:
            // 2 sources

            try {
                var5_6 = var4_4.prepareStatement(MapleFriendship.ALLATORIxDEMO("x]g]hL\u000b2\u000b^yWf8XpDhBlNuX8|PnJn8XpDhB|\u000b%\u000b'\u000bWy\\nJ\u000bZr8[wXq_qDv\u000bYx["));
                var5_6.setInt(1, (int)a);
                var6_8 = var5_6.executeQuery();
                var7_11 = new ArrayList<Integer>(MapleShop.rechargeableItems);
                block11: while (true) {
                    v1 = var6_8;
                    while (v1.next()) {
                        if (GameConstants.isThrowingStar(var6_8.getInt(MapleRing.ALLATORIxDEMO("s(\u007f1s8"))) || GameConstants.isBullet(var6_8.getInt(MapleFriendship.ALLATORIxDEMO("BlNuB|")))) {
                            var8_12 = new MapleShopItem(1, var6_8.getInt(MapleRing.ALLATORIxDEMO("s(\u007f1s8")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("hYqH}")), var6_8.getInt(MapleRing.ALLATORIxDEMO(".\u007f-s(\u007f1")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("Y}Zq_}Fi")), var6_8.getInt(MapleRing.ALLATORIxDEMO("h9k5n9wn")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("jNiBlNuZ*")), var6_8.getInt(MapleRing.ALLATORIxDEMO("y=n9}3h%")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("N`[qYy_qDv")), var6_8.getInt(MapleRing.ALLATORIxDEMO(":h5\u007f2~/")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("MjB}E|[wBv_k")));
                            var3_3.addItem((MapleShopItem)var8_12);
                            if (!MapleShop.rechargeableItems.contains(var8_12.getItemId())) continue block11;
                            var7_11.remove(var8_12.getItemId());
                            continue block11;
                        }
                        if (var2_2.itemExists(var6_8.getInt(MapleRing.ALLATORIxDEMO("s(\u007f1s8")))) ** break;
                        continue block11;
                        v1 = var6_8;
                        var3_3.addItem(new MapleShopItem(1000, var6_8.getInt(MapleFriendship.ALLATORIxDEMO("BlNuB|")), var6_8.getInt(MapleRing.ALLATORIxDEMO(",h5y9")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("jNiBlNu")), var6_8.getInt(MapleRing.ALLATORIxDEMO("h9k5n9w-")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("Y}Zq_}F*")), var6_8.getInt(MapleRing.ALLATORIxDEMO(".\u007f-s(\u007f1kn")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("Hy_}LwYa")), var6_8.getInt(MapleRing.ALLATORIxDEMO("\u007f$j5h=n5u2")), var6_8.getInt(MapleFriendship.ALLATORIxDEMO("~YqNvOk")), var6_8.getInt(MapleRing.ALLATORIxDEMO("|.s9t8j3s2n/"))));
                    }
                    break;
                }
                var8_12 = var7_11.iterator();
                while (var8_12.hasNext()) {
                    var7_11 = (Integer)var8_12.next();
                    if (var2_2.itemExists(var7_11.intValue())) {
                        var3_3.addItem(new MapleShopItem(1000, var7_11.intValue(), 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        continue;
                    }
                    MapleShop.rechargeableItems.remove(var7_11);
                }
                var6_8.close();
                var5_6.close();
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    var5_6 = var4_4.prepareStatement(MapleFriendship.ALLATORIxDEMO("x]g]hL\u000b2\u000b^yWf8XpDhYyEsX8|PnJn8XpDhB|\u000b%\u000b'\u000bWy\\nJ\u000bZr8YyEs\u000bYx["));
                    var5_6.setInt(1, (int)a);
                    var6_8 = var5_6.executeQuery();
                    block14: while (true) {
                        v2 = var6_8;
                        while (v2.next()) {
                            if (!var2_2.itemExists(var6_8.getInt(MapleRing.ALLATORIxDEMO("s(\u007f1s8")))) continue block14;
                            v2 = var6_8;
                            var3_3.ALLATORIxDEMO.add(new Pair<Integer, String>(var6_8.getInt(MapleFriendship.ALLATORIxDEMO("BlNuB|")), var6_8.getString(MapleRing.ALLATORIxDEMO("t=w9"))));
                        }
                        break;
                    }
                    var6_8.close();
                    var5_6.close();
                }
                if (var4_4 == null) return var3_3;
            }
            catch (Throwable var5_7) {
                if (var4_4 != null) {
                    try {
                        var4_4.close();
                        v3 = var5_7;
                        throw v3;
                    }
                    catch (Throwable var6_9) {
                        var5_7.addSuppressed(var6_9);
                    }
                }
                v3 = var5_7;
                throw v3;
            }
            var4_4.close();
            return var3_3;
        }
        catch (SQLException var4_5) {
            System.err.println("Could not load shop" + var4_5);
        }
        return var3_3;
    }

    public /* synthetic */ List<Pair<Integer, String>> getRanks() {
        MapleShop a2;
        return a2.ALLATORIxDEMO;
    }

    private /* synthetic */ MapleShop(int a2, int a3) {
        MapleShop a4;
        MapleShop mapleShop = a4;
        MapleShop mapleShop2 = a4;
        mapleShop2.ALLATORIxDEMO = new ArrayList<Pair<Integer, String>>();
        mapleShop.K = a2;
        mapleShop.a = a3;
        mapleShop.d = new LinkedList<MapleShopItem>();
    }

    public /* synthetic */ int getId() {
        MapleShop a2;
        return a2.K;
    }

    public /* synthetic */ void sendShop(MapleClient a2, int a3) {
        MapleShop a4;
        MapleClient mapleClient = a2;
        mapleClient.getPlayer().setShop(a4);
        mapleClient.sendPacket(MaplePacketCreator.getNPCShop(mapleClient, a3, a4.d, a4));
    }

    public /* synthetic */ void addItem(MapleShopItem a2) {
        MapleShop a3;
        a3.d.add(a2);
    }

    public /* synthetic */ int getNpcId() {
        MapleShop a2;
        return a2.a;
    }
}

