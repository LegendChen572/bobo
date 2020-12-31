/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import constants.GameSetConstants;
import handling.SendPacketOpcode;
import handling.opcodes.PlayerInteraction;
import handling.world.CharacterIdChannelPair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import server.MaplePlayerShopBuyItem;
import server.MerchItemPackage;
import server.shops.AbstractPlayerStore;
import server.shops.HiredFishing;
import server.shops.HiredMerchant;
import server.shops.IMaplePlayerShop;
import server.shops.MapleMiniGame;
import server.shops.MaplePlayerShop;
import server.shops.MaplePlayerShopItem;
import tools.Pair;
import tools.Triple;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;

public class PlayerShopPacket {
    public static /* synthetic */ byte[] getMatchCardStart(MapleMiniGame a2, int a3) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u958b\u59cb.getValue());
        maplePacketLittleEndianWriter2.write(a3 == 1 ? 0 : 1);
        a3 = a2.getPieceType() == 1 ? 20 : (a2.getPieceType() == 2 ? 30 : 12);
        maplePacketLittleEndianWriter.write(a3);
        int n3 = n2 = 1;
        while (n3 <= a3) {
            maplePacketLittleEndianWriter.writeInt(a2.getCardId(n2++));
            n3 = n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameSkip1(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u8df3\u904e.getValue());
        maplePacketLittleEndianWriter2.write(a2 == 1 ? 0 : 1);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] updateHiredFishing(HiredFishing a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_HIRED_MERCHANT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getOwnerId());
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter2.writeLong(0L);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] spawnHiredFishing(HiredFishing a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        HiredFishing hiredFishing = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SPAWN_HIRED_MERCHANT.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getOwnerId());
        maplePacketLittleEndianWriter.writeInt(hiredFishing.getItemId());
        maplePacketLittleEndianWriter3.writePos(hiredFishing.getPosition());
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getOwnerName());
        maplePacketLittleEndianWriter2.writeLong(0L);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] closeHiredFishing(HiredFishing a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SEND_FISH_BOX.getValue());
        maplePacketLittleEndianWriter2.write(21);
        maplePacketLittleEndianWriter2.writeInt(a2.getObjectId());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] destroyHiredMerchant(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DESTROY_HIRED_MERCHANT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] ShowMerchItemStore(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MERCH_ITEM_STORE.getValue());
        maplePacketLittleEndianWriter3.write(37);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4 - 1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameRequestREDO() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter.write(PlayerInteraction.\u8981\u6c42\u91cd\u505a.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] MerchantBlackListView(List<String> a2) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u7cbe\u9748\u5546\u4eba\u9ed1\u540d\u55ae\u67e5\u770b.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2.size());
        int n3 = n2 = 0;
        while (n3 < a2.size()) {
            if (a2.get(n2) != null) {
                maplePacketLittleEndianWriter.writeMapleAsciiString(a2.get(n2));
            }
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public /* synthetic */ PlayerShopPacket() {
        PlayerShopPacket a2;
    }

    public static final /* synthetic */ byte[] merchItemStore_ItemData(MerchItemPackage a2) {
        Iterator<IItem> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MERCH_ITEM_STORE.getValue());
        int n2 = 35;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            n2 = 32;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 147) {
                n2 = 38;
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.write(n2);
        MerchItemPackage merchItemPackage = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter2.writeInt(9030000);
        maplePacketLittleEndianWriter4.writeInt(32272);
        maplePacketLittleEndianWriter4.writeZeroBytes(5);
        maplePacketLittleEndianWriter3.writeInt(a2.getMesos());
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.write(merchItemPackage.getItems().size());
        Iterator<IItem> iterator2 = iterator = merchItemPackage.getItems().iterator();
        while (iterator2.hasNext()) {
            IItem iItem = iterator.next();
            iterator2 = iterator;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter2, iItem);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.writeZeroBytes(3);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static final /* synthetic */ byte[] addCharBox(MapleCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3 = new MaplePacketLittleEndianWriter();
        a3.writeShort(SendPacketOpcode.UPDATE_CHAR_BOX.getValue());
        maplePacketLittleEndianWriter.writeInt(a2.getId());
        PacketHelper.addAnnounceBox(maplePacketLittleEndianWriter, a2);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] updateHiredMerchant(HiredMerchant a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_HIRED_MERCHANT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getOwnerId());
        PacketHelper.addInteraction(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] closeMerchantUI() {
        int n2 = 21;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            n2 = 17;
        }
        return PlayerShopPacket.shopErrorMessage(n2, 0);
    }

    public static /* synthetic */ byte[] getMiniGame(MapleClient a2, MapleMiniGame a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleMiniGame mapleMiniGame = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter4.write(PlayerInteraction.VISIT.getValue() + 1);
        maplePacketLittleEndianWriter3.write(a3.getGameType());
        maplePacketLittleEndianWriter3.write(a3.getMaxSize());
        maplePacketLittleEndianWriter.writeShort(mapleMiniGame.getVisitorSlot(a2.getPlayer()));
        PacketHelper.addCharLook(maplePacketLittleEndianWriter2, mapleMiniGame.getMCOwner(), false);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3.getOwnerName());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            maplePacketLittleEndianWriter.writeShort(a3.getMCOwner().getJob());
        }
        for (Pair<Byte, MapleCharacter> pair : a3.getVisitors()) {
            maplePacketLittleEndianWriter.write(pair.getLeft());
            PacketHelper.addCharLook(maplePacketLittleEndianWriter, pair.getRight(), false);
            maplePacketLittleEndianWriter.writeMapleAsciiString(pair.getRight().getName());
            if (GameSetConstants.MAPLE_VERSION <= 113) continue;
            maplePacketLittleEndianWriter.writeShort(pair.getRight().getJob());
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.write(-1);
        maplePacketLittleEndianWriter5.write(0);
        PlayerShopPacket.addGameInfo(maplePacketLittleEndianWriter, a3.getMCOwner(), a3);
        Iterator<Pair<Byte, MapleCharacter>> iterator = a3.getVisitors().iterator();
        Iterator<Pair<Byte, MapleCharacter>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            Pair<Byte, MapleCharacter> pair;
            pair = iterator.next();
            maplePacketLittleEndianWriter.write(pair.getLeft());
            PlayerShopPacket.addGameInfo(maplePacketLittleEndianWriter, pair.getRight(), a3);
            iterator2 = iterator;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(-1);
        maplePacketLittleEndianWriter6.writeMapleAsciiString(a3.getDescription());
        maplePacketLittleEndianWriter6.writeShort(a3.getPieceType());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMatchCardSelect(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u9078\u64c7\u5361\u7247.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        if (a2 == 0) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.write(a4);
            maplePacketLittleEndianWriter4.write(a5);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameRequestTie() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter.write(PlayerInteraction.\u8981\u6c42\u5e73\u624b.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameExitAfter(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? PlayerInteraction.\u904a\u6232\u96e2\u958b\u5f8c.getValue() : PlayerInteraction.\u53d6\u6d88\u96e2\u958b.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getHiredMerch(MapleCharacter a2, HiredMerchant a3, boolean a422) {
        Iterator<MaplePlayerShopItem> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.VISIT.getValue() + 1);
        maplePacketLittleEndianWriter2.write(5);
        maplePacketLittleEndianWriter2.write(GameSetConstants.MAPLE_VERSION >= 151 ? 7 : 4);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        HiredMerchant hiredMerchant = a3;
        maplePacketLittleEndianWriter.writeShort(hiredMerchant.getVisitorSlot(a2));
        maplePacketLittleEndianWriter3.writeInt(hiredMerchant.getItemId());
        maplePacketLittleEndianWriter3.writeMapleAsciiString(CharacterIdChannelPair.ALLATORIxDEMO("\u7ce4\u9739\u551c\u4ecb"));
        for (Pair<Byte, MapleCharacter> iterator2 : a3.getVisitors()) {
            maplePacketLittleEndianWriter.write((Byte)iterator2.left);
            PacketHelper.addCharLook(maplePacketLittleEndianWriter, (MapleCharacter)iterator2.right, false);
            maplePacketLittleEndianWriter.writeMapleAsciiString(((MapleCharacter)iterator2.right).getName());
            if (GameSetConstants.MAPLE_VERSION <= 113) continue;
            maplePacketLittleEndianWriter.writeShort(((MapleCharacter)iterator2.right).getJob());
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.write(-1);
        maplePacketLittleEndianWriter4.writeShort(0);
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3.getOwnerName());
        if (a3.isOwner(a2)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter5.writeInt(a3.getTimeLeft());
            maplePacketLittleEndianWriter5.write(a422 ? 1 : 0);
            HiredMerchant hiredMerchant2 = a3;
            maplePacketLittleEndianWriter.write(hiredMerchant2.getBoughtItems().size());
            Iterator<Object> iterator3 = hiredMerchant2.getBoughtItems().iterator();
            Iterator<Object> iterator2 = iterator3;
            while (iterator2.hasNext()) {
                AbstractPlayerStore.BoughtItem boughtItem = (AbstractPlayerStore.BoughtItem)iterator3.next();
                iterator2 = iterator3;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                AbstractPlayerStore.BoughtItem boughtItem2 = boughtItem;
                maplePacketLittleEndianWriter.writeInt(boughtItem.id);
                maplePacketLittleEndianWriter.writeShort(boughtItem2.quantity);
                maplePacketLittleEndianWriter6.writeInt(boughtItem2.totalPrice);
                maplePacketLittleEndianWriter6.writeMapleAsciiString(boughtItem.buyer);
            }
            maplePacketLittleEndianWriter.writeInt(a3.getMeso());
            if (GameSetConstants.MAPLE_VERSION > 113) {
                maplePacketLittleEndianWriter.writeInt(0);
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            maplePacketLittleEndianWriter.writeInt(a3.getObjectId());
        }
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3.getDescription());
        int n2 = 10;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            n2 = 16;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        HiredMerchant hiredMerchant3 = a3;
        maplePacketLittleEndianWriter.write(n2);
        maplePacketLittleEndianWriter7.writeInt(hiredMerchant3.getMeso());
        maplePacketLittleEndianWriter7.write(hiredMerchant3.getItems().size());
        Iterator<MaplePlayerShopItem> iterator3 = iterator = a3.getItems().iterator();
        while (iterator3.hasNext()) {
            MaplePlayerShopItem a422 = iterator.next();
            iterator3 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
            MaplePlayerShopItem maplePlayerShopItem = a422;
            maplePacketLittleEndianWriter.writeShort(a422.bundles);
            maplePacketLittleEndianWriter.writeShort(maplePlayerShopItem.item.getQuantity());
            maplePacketLittleEndianWriter8.writeInt(maplePlayerShopItem.price);
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter8, a422.item);
        }
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            Iterator<MaplePlayerShopBuyItem> iterator4;
            HiredMerchant hiredMerchant4 = a3;
            maplePacketLittleEndianWriter.write(hiredMerchant4.getAcquisitionItems().size());
            Iterator<MaplePlayerShopBuyItem> iterator5 = iterator4 = hiredMerchant4.getAcquisitionItems().iterator();
            while (iterator5.hasNext()) {
                MaplePlayerShopBuyItem a422 = iterator4.next();
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
                MaplePlayerShopBuyItem maplePlayerShopBuyItem = a422;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter.writeInt(a422.item.getItemId());
                maplePacketLittleEndianWriter10.write(0);
                maplePacketLittleEndianWriter10.writeShort(a422.qty);
                maplePacketLittleEndianWriter.writeShort(maplePlayerShopBuyItem.item.getQuantity());
                maplePacketLittleEndianWriter9.writeShort(maplePlayerShopBuyItem.bundles);
                maplePacketLittleEndianWriter9.writeInt((int)((long)a422.price >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (long)a422.price));
                iterator5 = iterator4;
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter11.writeShort(0);
        return maplePacketLittleEndianWriter11.getPacket();
    }

    public static final /* synthetic */ byte[] shopItemUpdate(IMaplePlayerShop a2) {
        Iterator<MaplePlayerShopItem> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u66f4\u65b0\u5167\u5bb9.getValue());
        if (a2.getShopType() == 1) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        maplePacketLittleEndianWriter.write(a2.getItems().size());
        Iterator<MaplePlayerShopItem> iterator2 = iterator = a2.getItems().iterator();
        while (iterator2.hasNext()) {
            MaplePlayerShopItem maplePlayerShopItem = iterator.next();
            iterator2 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MaplePlayerShopItem maplePlayerShopItem2 = maplePlayerShopItem;
            maplePacketLittleEndianWriter.writeShort(maplePlayerShopItem.bundles);
            maplePacketLittleEndianWriter.writeShort(maplePlayerShopItem2.item.getQuantity());
            maplePacketLittleEndianWriter3.writeInt(maplePlayerShopItem2.price);
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter3, maplePlayerShopItem.item);
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] Merchant_Buy_Error(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(23);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] MerchantVisitorView(HashMap<Integer, Triple<String, Long, Long>> a2) {
        Iterator<Triple<String, Long, Long>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        HashMap<Integer, Triple<String, Long, Long>> hashMap = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u7cbe\u9748\u5546\u4eba\u8a2a\u5ba2\u67e5\u770b.getValue());
        maplePacketLittleEndianWriter.writeShort(hashMap.size());
        Iterator<Triple<String, Long, Long>> iterator2 = iterator = hashMap.values().iterator();
        while (iterator2.hasNext()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3;
            Triple<String, Long, Long> triple = iterator.next();
            String string = triple.getLeft();
            long l2 = (triple.getRight() - triple.getMid()) / 1000L / 60L;
            if (l2 > 76L) {
                l2 += 7L;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            } else if (l2 > 65L) {
                l2 += 6L;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            } else if (l2 > 54L) {
                l2 += 5L;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            } else if (l2 > 43L) {
                l2 += 4L;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            } else if (l2 > 32L) {
                l2 += 3L;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            } else if (l2 > 20L) {
                l2 += 2L;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            } else {
                if (l2 > 10L) {
                    ++l2;
                }
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            }
            maplePacketLittleEndianWriter3.writeMapleAsciiString(string);
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeShort(0);
            maplePacketLittleEndianWriter4.writeShort((int)(l2 > 32767L ? 32767L : l2));
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameRequestREDB() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(53);
        maplePacketLittleEndianWriter2.writeShort(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] fishingItemStore(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        byte by = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MERCH_ITEM_STORE.getValue());
        maplePacketLittleEndianWriter2.write(by);
        switch (by) {
            case 36: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                while (false) {
                }
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.writeZeroBytes(8);
                break;
            }
            case 37: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.writeInt(9330108);
                maplePacketLittleEndianWriter4.writeInt(999999999);
                maplePacketLittleEndianWriter4.write(0);
                break;
            }
            case 38: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                maplePacketLittleEndianWriter5.writeZeroBytes(8);
                break;
            }
            default: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
                maplePacketLittleEndianWriter6.write(0);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] spawnHiredMerchant(HiredMerchant a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        HiredMerchant hiredMerchant = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SPAWN_HIRED_MERCHANT.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getOwnerId());
        maplePacketLittleEndianWriter.writeInt(hiredMerchant.getItemId());
        maplePacketLittleEndianWriter3.writePos(hiredMerchant.getPosition());
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getOwnerName());
        PacketHelper.addInteraction(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameFull() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.writeShort(5);
        maplePacketLittleEndianWriter2.write(2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] shopChat(String a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u5c0d\u8a71.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.write(PlayerInteraction.\u5c0d\u8a71.getValue() + 1);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(PlayerInteraction.VISIT.getValue());
        }
        maplePacketLittleEndianWriter.write(a3);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static final /* synthetic */ byte[] fishingItemStore_ItemData(MerchItemPackage a2) {
        Iterator<IItem> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MERCH_ITEM_STORE.getValue());
        int n2 = 35;
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            n2 += 3;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.write(n2);
        maplePacketLittleEndianWriter4.writeInt(9330108);
        maplePacketLittleEndianWriter3.writeInt(32272);
        maplePacketLittleEndianWriter3.writeZeroBytes(5);
        maplePacketLittleEndianWriter2.writeInt(a2.getMesos());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter.write(a2.getItems().size());
        Iterator<IItem> iterator2 = iterator = a2.getItems().iterator();
        while (iterator2.hasNext()) {
            IItem iItem = iterator.next();
            iterator2 = iterator;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeZeroBytes(3);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameDenyTie() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter.write(PlayerInteraction.\u56de\u61c9\u5e73\u624b.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getPlayerStore(MapleCharacter a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a3 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        IMaplePlayerShop iMaplePlayerShop = a2.getPlayerShop();
        maplePacketLittleEndianWriter2.write(5);
        switch (iMaplePlayerShop.getShopType()) {
            case 2: {
                maplePacketLittleEndianWriter = a3;
                while (false) {
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a3;
                maplePacketLittleEndianWriter3.write(4);
                maplePacketLittleEndianWriter3.write(4);
                break;
            }
            case 3: {
                maplePacketLittleEndianWriter = a3;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a3;
                maplePacketLittleEndianWriter4.write(2);
                maplePacketLittleEndianWriter4.write(2);
                break;
            }
            case 4: {
                a3.write(1);
                a3.write(2);
            }
            default: {
                maplePacketLittleEndianWriter = a3;
            }
        }
        maplePacketLittleEndianWriter.writeShort(iMaplePlayerShop.getVisitorSlot(a2));
        PacketHelper.addCharLook(a3, ((MaplePlayerShop)iMaplePlayerShop).getMCOwner(), false);
        a3.writeMapleAsciiString(iMaplePlayerShop.getOwnerName());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a3.writeShort(((MaplePlayerShop)iMaplePlayerShop).getMCOwner().getJob());
        }
        for (Pair<Byte, MapleCharacter> object : iMaplePlayerShop.getVisitors()) {
            a3.write((Byte)object.left);
            PacketHelper.addCharLook(a3, (MapleCharacter)object.right, false);
            a3.writeMapleAsciiString(((MapleCharacter)object.right).getName());
            if (GameSetConstants.MAPLE_VERSION < 134) continue;
            a3.writeShort(((MapleCharacter)object.right).getJob());
        }
        a3.write(255);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            a3.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a3;
        maplePacketLittleEndianWriter5.writeMapleAsciiString(iMaplePlayerShop.getDescription());
        maplePacketLittleEndianWriter5.write(10);
        a3.write(iMaplePlayerShop.getItems().size());
        Iterator<Object> iterator = iMaplePlayerShop.getItems().iterator();
        Iterator<Object> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MaplePlayerShopItem maplePlayerShopItem = (MaplePlayerShopItem)iterator.next();
            iterator2 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a3;
            MaplePlayerShopItem maplePlayerShopItem2 = maplePlayerShopItem;
            a3.writeShort(maplePlayerShopItem.bundles);
            a3.writeShort(maplePlayerShopItem2.item.getQuantity());
            maplePacketLittleEndianWriter6.writeInt(maplePlayerShopItem2.price);
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter6, maplePlayerShopItem.item);
        }
        return a3.getPacket();
    }

    public static final /* synthetic */ byte[] removeCharBox(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_CHAR_BOX.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameClose(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u96e2\u958b.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] shopVisitorLeave(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u96e2\u958b.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] shopMessage(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] shopErrorMessage(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u96e2\u958b.getValue());
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] merchItem_Message(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MERCH_ITEM_MSG.getValue());
        int n2 = a2;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            n2 -= 3;
        }
        maplePacketLittleEndianWriter2.write(n2);
        switch (a2) {
            case 34: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                while (false) {
                }
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.write(1);
                break;
            }
            case 36: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.writeInt(0);
                maplePacketLittleEndianWriter4.writeInt(999999999);
                maplePacketLittleEndianWriter4.write(1);
                break;
            }
            default: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                maplePacketLittleEndianWriter5.write(0);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ void addGameInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3, MapleMiniGame a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MapleMiniGame mapleMiniGame = a4;
        MapleCharacter mapleCharacter = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        maplePacketLittleEndianWriter2.writeInt(a4.getGameType());
        maplePacketLittleEndianWriter2.writeInt(a4.getWins(a3));
        a2.writeInt(a4.getTies(mapleCharacter));
        a2.writeInt(mapleMiniGame.getLosses(mapleCharacter));
        maplePacketLittleEndianWriter.writeInt(mapleMiniGame.getScore(a3));
        maplePacketLittleEndianWriter.writeInt(0);
    }

    public static final /* synthetic */ byte[] sendFishBox() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SEND_FISH_BOX.getValue());
        maplePacketLittleEndianWriter2.write(13);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] sendPlayerShopBox(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_CHAR_BOX.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        PacketHelper.addAnnounceBox(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameSkip(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u8df3\u904e.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] merchItemStore(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MERCH_ITEM_STORE.getValue());
        int n2 = a2;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter3;
            n2 -= 3;
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 147) {
                n2 += 3;
            }
            maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter3;
        }
        maplePacketLittleEndianWriter2.write(n2);
        switch (a2) {
            case 36: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter3;
                while (false) {
                }
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.writeZeroBytes(8);
                break;
            }
            case 37: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.writeInt(9030000);
                maplePacketLittleEndianWriter5.writeInt(999999999);
                maplePacketLittleEndianWriter5.write(0);
                break;
            }
            case 38: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
                maplePacketLittleEndianWriter6.writeZeroBytes(8);
                break;
            }
            default: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter7;
                maplePacketLittleEndianWriter7.write(0);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] sendHiredMerchantMessage(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MERCH_ITEM_MSG.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameDenyREDO() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter.write(PlayerInteraction.\u56de\u8986\u91cd\u505a.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] shopVisitorAdd(MapleCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.VISIT.getValue());
        maplePacketLittleEndianWriter3.write(a3);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter2, a2, false);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getName());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            maplePacketLittleEndianWriter.writeShort(a2.getJob());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ byte[] getMiniGameResult(MapleMiniGame a, int a, int a) {
        v0 = var3_5 = new MaplePacketLittleEndianWriter();
        v0.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        v0.write(PlayerInteraction.\u958b\u59cb.getValue() + 1);
        v0.write(a);
        v1 = a;
        a.setPoints(a, v1);
        if (v1 != 0) {
            if (a == 1) {
                v2 = 0;
                v3 = a;
            } else {
                v2 = 1;
                v3 = a;
            }
            a.setPoints(v2, v3 == 2 ? 0 : 1);
        }
        if (a == 1) ** GOTO lbl21
        if (a == 0) {
            var3_5.write(a == 1 ? 0 : 1);
            v4 = var3_5;
        } else {
            var3_5.write(a);
lbl21:
            // 2 sources

            v4 = var3_5;
        }
        PlayerShopPacket.addGameInfo(v4, a.getMCOwner(), a);
        v5 = a = a.getVisitors().iterator();
        while (v5.hasNext() != false) {
            a = a.next();
            PlayerShopPacket.addGameInfo(var3_5, (MapleCharacter)a.right, a);
            v5 = a;
        }
        return var3_5.getPacket();
    }

    public static final /* synthetic */ byte[] sendTitleBox() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SEND_TITLE_BOX.getValue());
        int n2 = 7;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            n2 = 6;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.write(n2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameMoveOmok(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u79fb\u52d5\u4e94\u5b50\u68cb.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameStart(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(PlayerInteraction.\u958b\u59cb.getValue());
        maplePacketLittleEndianWriter2.write(a2 == 1 ? 0 : 1);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameReady(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? PlayerInteraction.\u6e96\u5099.getValue() : PlayerInteraction.\u672a\u6e96\u5099\u5b8c\u6210.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMiniGameNewVisitor(MapleCharacter a2, int a3, MapleMiniGame a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.VISIT.getValue());
        maplePacketLittleEndianWriter3.write(a3);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter2, a2, false);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getName());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            maplePacketLittleEndianWriter.writeShort(a2.getJob());
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        PlayerShopPacket.addGameInfo(maplePacketLittleEndianWriter4, a2, a4);
        return maplePacketLittleEndianWriter4.getPacket();
    }
}

