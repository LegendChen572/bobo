/*
 * Decompiled with CFR 0.150.
 */
package server.shops;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import client.inventory.ItemFlag;
import constants.GameConstants;
import java.util.ArrayList;
import java.util.List;
import server.Extend.SpecialItemData;
import server.MapleInventoryManipulator;
import server.shops.AbstractPlayerStore;
import server.shops.MaplePlayerShopItem;
import tools.MaplePacketCreator;
import tools.otp.HmacOneTimePasswordGenerator;
import tools.packet.PlayerShopPacket;

public class MaplePlayerShop
extends AbstractPlayerStore {
    private final /* synthetic */ List<String> ALLATORIxDEMO;
    private /* synthetic */ int d;
    public /* synthetic */ boolean canShop;

    @Override
    public /* synthetic */ void buy(MapleClient a2, int a32, short a4) {
        block6: {
            MaplePlayerShop maplePlayerShop;
            MaplePlayerShop a5;
            block10: {
                block9: {
                    block7: {
                        block8: {
                            MaplePlayerShopItem maplePlayerShopItem;
                            IItem iItem;
                            MaplePlayerShopItem a32 = (MaplePlayerShopItem)a5.items.get(a32);
                            if (a32.bundles <= 0) break block6;
                            IItem iItem2 = iItem = a32.item.copy();
                            iItem2.setQuantity((short)(a4 * iItem2.getQuantity()));
                            int n2 = iItem2.getFlag();
                            if (ItemFlag.KARMA_EQ.check(n2)) {
                                maplePlayerShopItem = a32;
                                iItem.setFlag(n2 - ItemFlag.KARMA_EQ.getValue());
                            } else {
                                if (ItemFlag.KARMA_USE.check(n2)) {
                                    iItem.setFlag(n2 - ItemFlag.KARMA_USE.getValue());
                                }
                                maplePlayerShopItem = a32;
                            }
                            n2 = maplePlayerShopItem.price * a4;
                            if (a2.getPlayer().getMeso() < n2) break block7;
                            if (!a2.getPlayer().canHold(iItem.getItemId())) {
                                MapleClient mapleClient = a2;
                                mapleClient.getPlayer().dropMessage(1, SpecialItemData.ALLATORIxDEMO("\u609b\u76ac\u80ff\u532d\u6ecc\u4eae\u001d"));
                                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                                return;
                            }
                            if (a5.getMCOwner().getMeso() + n2 <= 0 || !MapleInventoryManipulator.checkSpace(a2, iItem.getItemId(), iItem.getQuantity(), iItem.getOwner()) || !MapleInventoryManipulator.addFromDrop(a2, iItem, false)) break block8;
                            MaplePlayerShopItem maplePlayerShopItem2 = a32;
                            maplePlayerShopItem2.bundles = (short)(maplePlayerShopItem2.bundles - a4);
                            a5.bought.add(new AbstractPlayerStore.BoughtItem(iItem.getItemId(), a4, n2, a2.getPlayer().getName()));
                            a2.getPlayer().gainMeso(-n2, false);
                            int n3 = n2;
                            a5.getMCOwner().gainMeso(n3 - GameConstants.EntrustedStoreTax(n3), false);
                            if (maplePlayerShopItem2.bundles <= 0) {
                                MaplePlayerShop maplePlayerShop2 = a5;
                                ++maplePlayerShop2.d;
                                if (maplePlayerShop2.d == a5.items.size()) {
                                    a5.closeShop(false, true);
                                    return;
                                }
                            }
                            break block9;
                        }
                        a2.getPlayer().dropMessage(1, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u4f37\u769e\u888a\u5083\u6b53\u5de8\u7dc4\u6ee5\u4ed1\u3018"));
                        maplePlayerShop = a5;
                        break block10;
                    }
                    a2.getPlayer().dropMessage(1, SpecialItemData.ALLATORIxDEMO("\u4f53\u6cba\u673a\u8d9b\u5913\u76ac\u6960\u5e4b\u3031"));
                }
                maplePlayerShop = a5;
            }
            maplePlayerShop.getMCOwner().getClient().sendPacket(PlayerShopPacket.shopItemUpdate(a5));
        }
    }

    @Override
    public final /* synthetic */ void setCanShop(boolean a2) {
        a.canShop = a2;
    }

    public /* synthetic */ void banPlayer(String a2) {
        int n2;
        MaplePlayerShop a3;
        if (!a3.ALLATORIxDEMO.contains(a2)) {
            a3.ALLATORIxDEMO.add(a2);
        }
        int n3 = n2 = 0;
        while (n3 < 3) {
            MapleCharacter mapleCharacter = a3.getVisitor(n2);
            if (mapleCharacter.getName().equals(a2)) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.getClient().sendPacket(PlayerShopPacket.shopErrorMessage(5, 1));
                mapleCharacter2.setPlayerShop(null);
                a3.removeVisitor(mapleCharacter2);
            }
            n3 = ++n2;
        }
    }

    @Override
    public /* synthetic */ void closeShop(boolean a2, boolean a3, boolean a4) {
        MaplePlayerShop a5;
        a5.closeShop(a2, a3);
    }

    @Override
    public /* synthetic */ void closeShop(boolean a22, boolean a3) {
        MaplePlayerShop a4;
        MapleCharacter a22 = a4.getMCOwner();
        if (a22 != null && a22.getClient() != null) {
            MapleCharacter mapleCharacter;
            block3: {
                MaplePlayerShop maplePlayerShop = a4;
                maplePlayerShop.removeAllVisitors(3, 1);
                MaplePlayerShop maplePlayerShop2 = a4;
                maplePlayerShop.getMap().removeMapObject(maplePlayerShop2);
                for (MaplePlayerShopItem maplePlayerShopItem : maplePlayerShop2.getItems()) {
                    IItem iItem;
                    if (maplePlayerShopItem.bundles <= 0) continue;
                    IItem iItem2 = iItem = maplePlayerShopItem.item.copy();
                    iItem2.setQuantity((short)(maplePlayerShopItem.bundles * iItem2.getQuantity()));
                    if (MapleInventoryManipulator.addFromDrop(a22.getClient(), iItem, false)) {
                        maplePlayerShopItem.bundles = 0;
                        continue;
                    }
                    a4.saveItems(true);
                    mapleCharacter = a22;
                    break block3;
                }
                mapleCharacter = a22;
            }
            mapleCharacter.setPlayerShop(null);
            a4.update();
        }
    }

    @Override
    public final /* synthetic */ boolean getCanShop() {
        MaplePlayerShop a2;
        return a2.canShop;
    }

    @Override
    public /* synthetic */ byte getShopType() {
        return 2;
    }

    public /* synthetic */ MaplePlayerShop(MapleCharacter a2, int a3, String a4) {
        MaplePlayerShop a5;
        MaplePlayerShop maplePlayerShop = a5;
        super(a2, a3, a4, "", 3);
        maplePlayerShop.d = 0;
        MaplePlayerShop maplePlayerShop2 = a5;
        maplePlayerShop.ALLATORIxDEMO = new ArrayList<String>();
        maplePlayerShop.canShop = true;
    }

    public /* synthetic */ boolean isBanned(String a2) {
        MaplePlayerShop a3;
        return a3.ALLATORIxDEMO.contains(a2);
    }
}

