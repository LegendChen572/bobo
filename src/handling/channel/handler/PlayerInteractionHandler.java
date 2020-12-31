/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import client.inventory.ItemCustomFlag;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.GameStringConstants;
import constants.ItemConstants;
import constants.ServerConfig;
import constants.ServerTempStorage;
import handling.channel.ChannelServer;
import handling.channel.handler.HiredFishingHandler;
import handling.channel.handler.HiredMerchantHandler;
import handling.opcodes.PlayerInteraction;
import handling.world.World;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import scripting.npc.NPCScriptManager;
import server.Framework.MapleExtendedSlots;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MaplePlayerShopBuyItem;
import server.MapleTrade;
import server.MerchItemPackage;
import server.maps.FieldLimitType;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.shops.HiredFishing;
import server.shops.HiredMerchant;
import server.shops.IMaplePlayerShop;
import server.shops.MapleMiniGame;
import server.shops.MaplePlayerShop;
import server.shops.MaplePlayerShopItem;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;
import tools.packet.PlayerShopPacket;

public class PlayerInteractionHandler {
    public static final /* synthetic */ byte VIEW_MERCHANT_BLACKLIST = 44;
    public static final /* synthetic */ byte VIEW_MERCHANT_VISITOR = 43;
    public static final /* synthetic */ byte ANSWER_TIE = 48;
    public static final /* synthetic */ byte CONFIRM_TRADE = 16;
    public static final /* synthetic */ byte EXIT_AFTER_GAME = 53;
    public static final /* synthetic */ byte REMOVE_ITEM_PS = 24;
    public static final /* synthetic */ byte ADD_ITEM = 30;
    public static final /* synthetic */ byte READY = 55;
    public static final /* synthetic */ byte SET_MESO = 15;
    public static final /* synthetic */ byte MOVE_OMOK = 61;
    public static final /* synthetic */ byte BUY_ITEM_STORE = 31;
    public static final /* synthetic */ byte CANCEL_EXIT = 54;
    public static final /* synthetic */ byte CREATE = 0;
    public static final /* synthetic */ byte MERCHANT_BLACKLIST_ADD = 45;
    public static final /* synthetic */ byte START = 58;
    public static final /* synthetic */ byte OPEN = 11;
    public static final /* synthetic */ byte DENY_TRADE = 3;
    public static final /* synthetic */ byte BUY_ITEM_PLAYER_SHOP = 20;
    public static final /* synthetic */ byte REQUEST_REDO = 51;
    public static final /* synthetic */ byte VISIT = 4;
    public static final /* synthetic */ byte SKIP = 60;
    public static final /* synthetic */ byte INVITE_TRADE = 2;
    public static final /* synthetic */ byte REQUEST_TIE = 47;
    public static final /* synthetic */ byte ADMIN_STORE_NAMECHANGE = 42;
    public static final /* synthetic */ byte SET_ITEMS = 14;
    public static final /* synthetic */ byte CLOSE_MERCHANT = 38;
    public static final /* synthetic */ byte SELECT_CARD = 65;
    public static final /* synthetic */ byte PLAYER_SHOP_ADD_ITEM = 19;
    public static final /* synthetic */ byte GIVE_UP = 49;
    public static final /* synthetic */ byte EXPEL = 57;
    public static final /* synthetic */ byte UN_READY = 56;
    public static final /* synthetic */ byte MAINTANCE_ORGANISE = 37;
    public static final /* synthetic */ byte MERCHANT_BLACKLIST_REMOVE = 46;
    public static final /* synthetic */ byte CHAT = 6;
    public static final /* synthetic */ byte BUY_ITEM_HIREDMERCHANT = 33;
    public static final /* synthetic */ byte MERCHANT_EXIT = 27;
    public static final /* synthetic */ byte ANSWER_REDO = 52;
    public static final /* synthetic */ byte TRADE_SOMETHING = 18;
    public static final /* synthetic */ byte KICK_Player = 25;
    public static final /* synthetic */ byte REMOVE_ITEM = 35;
    public static final /* synthetic */ byte MAINTANCE_OFF = 36;
    public static final /* synthetic */ byte EXIT = 10;

    public /* synthetic */ PlayerInteractionHandler() {
        PlayerInteractionHandler a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void PlayerInteraction(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a4 == null) {
            return;
        }
        if (World.isShutDown) {
            a4.dropMessage(1, GameStringConstants.\u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f);
            return;
        }
        Object object = PlayerInteraction.getActionOperationType(a2.readByte());
        if (object == null) {
            FileoutputUtil.logToFile(ByteArrayByteStream.ALLATORIxDEMO("[BP^\u0018}VN\\HC\u0002gAVTR_~CCHELTY^BY\u0003CUC"), "\r\n " + FileoutputUtil.NowTime() + "\u52d5\u4f5c:" + (PlayerInteraction)object + " \u672a\u8655\u7406\u3002");
            return;
        }
        switch (1.ALLATORIxDEMO[((Enum)object).ordinal()]) {
            case 1: {
                object = a4.getPlayerShop();
                if (object == null) return;
                object.removeAllVisitors(5, 1);
                return;
            }
            case 2: {
                MapleCharacter mapleCharacter = a4;
                object = mapleCharacter.getPlayerShop();
                if (mapleCharacter.isOperateStorage()) {
                    a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u8a93\u95fb\u95d1\u502e\u5ef3\u5fab\u51d5\u9015\u8814\u64ea\u4f04"));
                    return;
                }
                if (object == null) return;
                if (!(object instanceof HiredMerchant)) return;
                if (!object.isOwner(a4)) return;
                if (!object.getCanShop()) return;
                object.setOpen(true);
                a4.setPlayerShop(null);
                return;
            }
            case 3: {
                HiredFishing hiredFishing;
                byte by = a2.readByte();
                if (a4.isOperateStorage()) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    return;
                }
                if (by == 3) {
                    MapleTrade.startTrade(a4);
                    return;
                }
                if (by == 1 || by == 2 || by == 4 || by == 5) {
                    int n2;
                    if (a4.getTrade() != null) {
                        a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u76c9\u5215\u72e7\u6113\u7106\u6c8d\u64ea\u4f04"));
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[2];
                    arrmapleMapObjectType[0] = MapleMapObjectType.SHOP;
                    arrmapleMapObjectType[1] = MapleMapObjectType.HIRED_MERCHANT;
                    if (!a4.getMap().getMapObjectsInRange(a4.getPosition(), 20000.0, Arrays.asList(arrmapleMapObjectType)).isEmpty()) {
                        a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u6b49\u8662\u710c\u6ce2\u5ed7\u7afc\u556b\u5ea0"));
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    if ((by == 1 || by == 2) && FieldLimitType.Minigames.check(a4.getMap().getFieldLimit())) {
                        a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u6b3c\u8672\u7179\u6cf2\u95d3\u8a0a\u5c57\u906d\u626a"));
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    LittleEndianAccessor littleEndianAccessor = a2;
                    String string = littleEndianAccessor.readMapleAsciiString();
                    String string2 = "";
                    if (littleEndianAccessor.readByte() > 0 && (by == 1 || by == 2)) {
                        string2 = a2.readMapleAsciiString();
                    }
                    if (by == 1 || by == 2) {
                        MapleMiniGame mapleMiniGame;
                        if (World.isShutDown) {
                            a4.dropMessage(1, GameStringConstants.\u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f);
                            a3.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        if (GameSetConstants.MAPLE_VERSION > 139) {
                            a2.skip(2);
                        }
                        byte by2 = a2.readByte();
                        int n3 = by == 1 ? 4080000 + by2 : 4080100;
                        if (!a4.haveItem(n3)) return;
                        if (a3.getPlayer().getMapId() >= 910000001 && a3.getPlayer().getMapId() <= 910000022) {
                            return;
                        }
                        MapleMiniGame mapleMiniGame2 = mapleMiniGame = new MapleMiniGame(a4, n3, string, string2, by);
                        MapleMiniGame mapleMiniGame3 = mapleMiniGame;
                        mapleMiniGame.setPieceType(by2);
                        a4.setPlayerShop(mapleMiniGame3);
                        mapleMiniGame3.setAvailable(true);
                        mapleMiniGame2.setOpen(true);
                        mapleMiniGame2.send(a3);
                        MapleMiniGame mapleMiniGame4 = mapleMiniGame;
                        a4.getMap().addMapObject(mapleMiniGame4);
                        mapleMiniGame4.update();
                        return;
                    }
                    boolean bl = World.hasMerchant(a3.getPlayer().getAccountID());
                    if (bl) {
                        MapleClient mapleClient = a3;
                        mapleClient.sendPacket(PlayerShopPacket.ShowMerchItemStore(9030000, World.getMerchantMap(mapleClient.getPlayer()), World.getMerchantChannel(a3.getPlayer())));
                        mapleClient.getPlayer().setConversation(0);
                        return;
                    }
                    IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.CASH).getItem((byte)a2.readShort());
                    if (iItem == null) return;
                    if (iItem.getQuantity() <= 0) return;
                    if (iItem.getItemId() != a2.readInt()) return;
                    if (a3.getPlayer().getMapId() < 910000001) return;
                    if (a3.getPlayer().getMapId() > 910000022) {
                        return;
                    }
                    if (ServerConfig.HiredMerchantBan) {
                        a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u76d9\u5260\u517f\u6686\u6675\u95f1\u95be\u7c93\u977f\u556b\u4e8d\u4ec8\u9605\u900d\u6227\u7384\u5b81\u76a9\u643a\u591c\uff3b\u8ae6\u5910\u5b9b\u517f\u4f52\u751f\u4e89\u6624\u623b\u5ed4\u6480\u7ac1\u6a34\u725e\u54ec\u3035"));
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    if (World.isShutDown) {
                        a4.dropMessage(1, GameStringConstants.\u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f);
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    if (!a4.getCanTalk()) {
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    byte by3 = HiredMerchantHandler.checkExistance(a3.getPlayer().getAccountID(), a3.getPlayer().getId());
                    if (by3 == 1) {
                        MapleClient mapleClient = a3;
                        HiredMerchantHandler.ClearWorldMerchant(a3.getPlayer());
                        mapleClient.getPlayer().RemoveHired();
                        a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u7528\u5e1f\u6495\u4f7bt\u7557\u5e60\u5561\u5ecf\u5dd5\u81b2\u52f2\u6e5d\u9643\u305a"));
                        mapleClient.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    int n4 = n2 = 5;
                    while (n4 >= 1) {
                        a4.dropMessage(1, "\u4f7f\u7528\u5408\u7d04\u66f8\u8acb\u8a73\u7d30\u95b1\u8b80\r\n\u7531\u65bc\u7cbe\u9748\u5546\u4eba\u3001\u500b\u4eba\u5546\u5e97BUG\u592a\u591a \u8acb\u73a9\u5bb6\u4f7f\u7528\u6642\u8acb\u62b1\u8457\u6b64\u7a2e\u5fc3\u614b\r\n1.\u6771\u897f\u4e0d\u60f3\u8981\u4e86 2.\u6c92\u9322\u62ff\u4e5f\u6c92\u5dee\r\n\u56e0\u70ba\u5f88\u91cd\u8981\u6240\u4ee5\u8acb\u95b1\u8b80" + n2-- + "/5\u6b21");
                        n4 = n2;
                    }
                    if (by == 4) {
                        MaplePlayerShop maplePlayerShop = new MaplePlayerShop(a4, iItem.getItemId(), string);
                        MapleCharacter mapleCharacter = a4;
                        mapleCharacter.setPlayerShop(maplePlayerShop);
                        mapleCharacter.getMap().addMapObject(maplePlayerShop);
                        if (ServerTempStorage.getMerchant(a3.getPlayer())) {
                            ServerTempStorage.setMerchant(a3.getPlayer(), false);
                        }
                        a3.sendPacket(PlayerShopPacket.getPlayerStore(a4, true));
                        return;
                    }
                    HiredMerchant hiredMerchant = new HiredMerchant(a4, iItem.getItemId(), string);
                    MapleCharacter mapleCharacter = a4;
                    mapleCharacter.setPlayerShop(hiredMerchant);
                    mapleCharacter.getMap().addMapObject(hiredMerchant);
                    if (ServerTempStorage.getMerchant(a3.getPlayer())) {
                        ServerTempStorage.setMerchant(a3.getPlayer(), false);
                    }
                    a3.sendPacket(PlayerShopPacket.getHiredMerch(a4, hiredMerchant, true));
                    return;
                }
                if (by != 75) return;
                if (a4.getTrade() != null) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u76c3\u527a\u72ed\u617c\u710c\u6ce2\u64e0\u4f6b"));
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                HiredFishing hiredFishing2 = World.hasFishing(a3.getPlayer().getAccountID());
                if (hiredFishing2 != null) {
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                littleEndianAccessor.skip(5);
                int n5 = littleEndianAccessor.readInt();
                IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.CASH).findById(n5);
                if (iItem == null) {
                    return;
                }
                if (iItem.getQuantity() <= 0) {
                    return;
                }
                if (a3.getPlayer().getMapId() < 749050500) return;
                if (a3.getPlayer().getMapId() > 749050502) {
                    return;
                }
                if (n5 != 5600001 && n5 != 5600000) {
                    return;
                }
                MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[2];
                arrmapleMapObjectType[0] = MapleMapObjectType.SHOP;
                arrmapleMapObjectType[1] = MapleMapObjectType.HIRED_FISHING;
                if (!a4.getMap().getMapObjectsInRange(a4.getPosition(), 20000.0, Arrays.asList(arrmapleMapObjectType)).isEmpty()) {
                    a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u4e55\u80da\u5770\u5151\u4e8e\u5c28\u91bb\u626c\u6599"));
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (!GameSetConstants.MERCHANT_FISH) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u76c3\u527a\u6707\u95bc\u6513\u4f48\u7505\u7c89\u9765\u5c38\u91ce\u627c"));
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                HiredFishing hiredFishing3 = hiredFishing = new HiredFishing(a4, iItem.getItemId());
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.setPlayerFishing(hiredFishing);
                hiredFishing.setAvailable(true);
                mapleCharacter.getMap().addMapObject(hiredFishing);
                hiredFishing3.setStoreid(a3.getChannelServer().addFishing(hiredFishing));
                a4.startHiredFishingTask();
                hiredFishing3.update();
                return;
            }
            case 4: {
                MapleCharacter mapleCharacter = a4;
                MapleTrade.inviteTrade(mapleCharacter, mapleCharacter.getMap().getCharacterById(a2.readInt()));
                return;
            }
            case 5: {
                MapleTrade.declineTrade(a4);
                return;
            }
            case 6: {
                if (World.isShutDown) {
                    a4.dropMessage(1, GameStringConstants.\u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f);
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                boolean bl = false;
                if (a4.getTrade() != null && a4.getTrade().getPartner() != null && a4.getTrade().getPartner().getChr() != null) {
                    bl = a4.isInvited();
                }
                MapleCharacter mapleCharacter = a4;
                if (a4.isOperateStorage()) {
                    mapleCharacter.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u8a93\u95fb\u95d1\u502e\u5ef3\u5fab\u51d5\u9015\u8814\u64ea\u4f04"));
                    return;
                }
                if (mapleCharacter.getTrade() != null && a4.getTrade().getPartner() != null && a4.getTrade().getPartner().getChr().isOperateStorage()) {
                    MapleCharacter mapleCharacter2 = a4;
                    mapleCharacter2.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u5c20\u658e\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    mapleCharacter2.getTrade().getPartner().getChr().dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u8a93\u95fb\u95d1\u502e\u5ef3\u5fab\u51d5\u9015\u8814\u64ea\u4f04"));
                    return;
                }
                if (a4.getTrade() != null && a4.getTrade().getPartner() != null && bl) {
                    MapleCharacter mapleCharacter3 = a4;
                    MapleTrade.visitTrade(mapleCharacter3, mapleCharacter3.getTrade().getPartner().getChr());
                    mapleCharacter3.setInvited(false);
                    return;
                }
                if (a4.getMap() == null) return;
                int n6 = a2.readInt();
                if (n6 == 0) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u5c20\u658e\u5ddf\u95eb\u95a4\u4e93\u663e\u3035"));
                    return;
                }
                MapleMapObject mapleMapObject = a4.getMap().getMapObject(n6, MapleMapObjectType.HIRED_MERCHANT);
                if (mapleMapObject == null) {
                    mapleMapObject = a4.getMap().getMapObject(n6, MapleMapObjectType.SHOP);
                }
                if (mapleMapObject == null) {
                    mapleMapObject = a4.getMap().getMapObject(n6, MapleMapObjectType.HIRED_FISHING);
                    if (mapleMapObject instanceof IMaplePlayerShop) {
                        HiredFishing hiredFishing;
                        IMaplePlayerShop iMaplePlayerShop = (IMaplePlayerShop)((Object)mapleMapObject);
                        if (mapleMapObject instanceof HiredFishing && (hiredFishing = (HiredFishing)iMaplePlayerShop).isOwner(a4)) {
                            a4.cancelHiredFishingTask();
                            hiredFishing.closeShop(true, true);
                            a4.setPlayerFishing(null);
                            MerchItemPackage merchItemPackage = HiredFishingHandler.loadItemFrom_Database(a3.getPlayer().getId(), a3.getPlayer().getAccountID(), a3.getWorld());
                            if (merchItemPackage != null) {
                                MapleClient mapleClient = a3;
                                mapleClient.getPlayer().setConversation(6);
                                mapleClient.sendPacket(PlayerShopPacket.fishingItemStore_ItemData(merchItemPackage));
                            }
                        }
                    }
                    MapleCharacter mapleCharacter4 = a4;
                    int n7 = World.getMerchantMap(mapleCharacter4);
                    int n8 = World.getMerchantChannel(mapleCharacter4);
                    int n9 = World.getFishingMap(mapleCharacter4);
                    int n10 = World.getFishingChannel(mapleCharacter4);
                    if (mapleMapObject != null) return;
                    boolean bl2 = false;
                    if (n7 != 1 && n8 != 1) {
                        a4.dropMessage(1, "\u60a8\u7684\u7cbe\u9748\u5546\u4eba\u4f4d\u65bc \u983b\u9053: " + n8 + " \u5730\u5716: " + MapleItemInformationProvider.getInstance().getMapName(n7));
                        bl2 = true;
                    }
                    if (n9 != 1 && n10 != 1) {
                        a4.dropMessage(1, "\u60a8\u7684\u7cbe\u9748\u91e3\u624b\u4f4d\u65bc \u983b\u9053: " + n10 + " \u5730\u5716: " + MapleItemInformationProvider.getInstance().getMapName(n9));
                        return;
                    }
                    if (bl2) return;
                    a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u6259\u4e55\u5217\u551e\u4e9dy"));
                    return;
                }
                if (!(mapleMapObject instanceof IMaplePlayerShop)) return;
                if (a4.getPlayerShop() != null) return;
                IMaplePlayerShop iMaplePlayerShop = (IMaplePlayerShop)((Object)mapleMapObject);
                if (mapleMapObject instanceof HiredMerchant) {
                    HiredMerchant hiredMerchant = (HiredMerchant)iMaplePlayerShop;
                    boolean bl3 = World.hasMerchant(hiredMerchant.getOwnerAccId());
                    HiredMerchant hiredMerchant2 = hiredMerchant;
                    if (!bl3) {
                        hiredMerchant2.closeShop(false, true);
                        a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u6b49\u7c89\u9765\u5571\u4e97\u673e\u755d\u5e0f\u0001\u8afc\u9037\u77d2jz"));
                        FileoutputUtil.logToFile(MapleExtendedSlots.ALLATORIxDEMO("4H?Two9D3\b\u7ce6\u976f\u551e\u4e9d\u7528\u5e1fj\t,_,"), a3.getPlayer().getChrInfo("World.hasMerchant \u627e\u4e0d\u5230\u7cbe\u9748\u5546\u4eba,\u537b\u80fd\u64cd\u4f5c\u3002" + World.getMerchantMap(a3.getPlayer()) + " " + World.getMerchantChannel(a3.getPlayer()) + " MerchantAccountId:" + hiredMerchant.getOwnerAccId()));
                        return;
                    }
                    HiredMerchant hiredMerchant3 = hiredMerchant;
                    if (hiredMerchant2.isOwner(a4)) {
                        hiredMerchant3.setOpen(false);
                        MapleClient mapleClient = a3;
                        hiredMerchant.removeAllVisitors((byte)MaplePacketOperation.MerchantStatus.\u5546\u5e97\u6574\u7406\u7269\u54c1, 1);
                        a4.setPlayerShop(iMaplePlayerShop);
                        mapleClient.sendPacket(PlayerShopPacket.getHiredMerch(a4, hiredMerchant, false));
                        hiredMerchant.sendMsg(mapleClient);
                        return;
                    }
                    if (!hiredMerchant3.isOpen() || !hiredMerchant.isAvailable()) {
                        a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u902e\u5026\u5571\u5eba\u571f\u6559\u7431\u623b\u8032\u6602\u6ca5\u5705\u8c9e\u8cce\u6746\u8952\u3035"));
                        return;
                    }
                    if (iMaplePlayerShop.getFreeSlot() == -1) {
                        a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u5561\u5ecf\u4e9d\u6520\u5dd5\u7dcb\u6ed8\u4ede\uff2b\u8a93\u7a2a\u5fd4\u51aa\u906a\u5142\u305a"));
                        return;
                    }
                    MapleCharacter mapleCharacter5 = a4;
                    if (hiredMerchant.isInBlackList(a4.getName())) {
                        mapleCharacter5.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u889c\u528d\u5152\u9efc\u543a\u5583\u4eb1\uff21\u6277\u4ec8\u4e3a\u80d0\u9005\u5148\u3035"));
                        return;
                    }
                    mapleCharacter5.setPlayerShop(iMaplePlayerShop);
                    MapleClient mapleClient = a3;
                    HiredMerchant hiredMerchant4 = hiredMerchant;
                    hiredMerchant4.addVisitor(a4);
                    mapleClient.sendPacket(PlayerShopPacket.getHiredMerch(a4, hiredMerchant, false));
                    hiredMerchant4.sendMsg(mapleClient);
                    return;
                }
                if (iMaplePlayerShop instanceof MaplePlayerShop && ((MaplePlayerShop)iMaplePlayerShop).isBanned(a4.getName())) {
                    a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u88f3\u5287\u513d\u9ef6\u5455\u5589\u4ede\uff2b\u6218\u4ec2\u4e55\u80da\u906a\u5142\u305a"));
                    return;
                }
                if (iMaplePlayerShop.getFreeSlot() < 0 || iMaplePlayerShop.getVisitorSlot(a4) > -1 || !iMaplePlayerShop.isOpen() || !iMaplePlayerShop.isAvailable()) {
                    a3.sendPacket(PlayerShopPacket.getMiniGameFull());
                    return;
                }
                if (a2.available() > 0L && a2.readByte() > 0) {
                    String string = a2.readMapleAsciiString();
                    if (!string.equals(iMaplePlayerShop.getPassword())) {
                        a3.getPlayer().dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u4f57\u8f15\u5152\u76a9\u5bf1\u7891\u9318\u8a89\u001b\u8ae6\u91fa\u659d\u51ba\u8a4b\u4e37\u6b0c\u0019"));
                        return;
                    }
                } else if (iMaplePlayerShop.getPassword().length() > 0) {
                    a3.getPlayer().dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u4f38\u8f1f\u513d\u76a3\u5b9e\u789b\u9377\u8a83t\u8aec\u9195\u6597\u51d5\u8a41\u4e58\u6b06v"));
                    return;
                }
                a4.setPlayerShop(iMaplePlayerShop);
                IMaplePlayerShop iMaplePlayerShop2 = iMaplePlayerShop;
                iMaplePlayerShop2.addVisitor(a4);
                if (iMaplePlayerShop2 instanceof MapleMiniGame) {
                    ((MapleMiniGame)iMaplePlayerShop).send(a3);
                    return;
                }
                a3.sendPacket(PlayerShopPacket.getPlayerStore(a4, false));
                return;
            }
            case 7: {
                if (GameSetConstants.MAPLE_VERSION > 113) {
                    a2.readInt();
                }
                MapleCharacter mapleCharacter = a4;
                if (a4.getTrade() != null) {
                    mapleCharacter.getTrade().chat(a2.readMapleAsciiString());
                    return;
                }
                if (mapleCharacter.getPlayerShop() == null) return;
                object = a4.getPlayerShop();
                String string = a2.readMapleAsciiString();
                object.broadcastToVisitors(PlayerShopPacket.shopChat(a4.getName() + " : " + string, object.getVisitorSlot(a4)));
                if (object.getShopType() != 1) return;
                ((HiredMerchant)object).addMsg(a4.getName() + " : " + string, object.getVisitorSlot(a4));
                return;
            }
            case 8: {
                MapleCharacter mapleCharacter;
                MapleCharacter mapleCharacter6 = a4;
                if (a4.getTrade() != null) {
                    object = mapleCharacter6.getTrade();
                    MapleCharacter mapleCharacter7 = a4;
                    mapleCharacter7.addTradeMsg(mapleCharacter7.getName(), ByteArrayByteStream.ALLATORIxDEMO("\u0017\u53fb\u6dbf\u4e89\u6624 ="));
                    MapleTrade.cancelTrade(mapleCharacter7.getTrade(), a4.getClient());
                    return;
                }
                object = mapleCharacter6.getPlayerShop();
                if (object == null) {
                    return;
                }
                if (!object.isAvailable() || object.isOwner(a4) && object.getShopType() != 1) {
                    object.closeShop(false, object.isAvailable());
                    mapleCharacter = a4;
                } else {
                    object.removeVisitor(a4);
                    mapleCharacter = a4;
                }
                mapleCharacter.setPlayerShop(null);
                NPCScriptManager.getInstance().dispose(a3);
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                if (!mapleClient.isMonitored()) return;
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleExtendedSlots.ALLATORIxDEMO("\u9584\u95ae\u7ce6\u976f\u551e\u4e9dp\u670d\u5ea2\u7aec\u7ce6\u976f\u551e\u4e9dt\u670d\u6566\u7f49\u7231\u54e6q")));
                return;
            }
            case 9: {
                boolean bl = World.hasMerchant(a3.getPlayer().getAccountID());
                if (bl) {
                    MapleClient mapleClient = a3;
                    mapleClient.sendPacket(PlayerShopPacket.ShowMerchItemStore(9030000, World.getMerchantMap(mapleClient.getPlayer()), World.getMerchantChannel(a3.getPlayer())));
                    mapleClient.getPlayer().setConversation(0);
                    return;
                }
                IMaplePlayerShop iMaplePlayerShop = a4.getPlayerShop();
                if (iMaplePlayerShop == null) return;
                if (!iMaplePlayerShop.isOwner(a4)) return;
                if (iMaplePlayerShop.getShopType() >= 3) return;
                if (a4.getMap().allowPersonalShop()) {
                    if (World.isShutDown) {
                        IMaplePlayerShop iMaplePlayerShop3 = iMaplePlayerShop;
                        a4.dropMessage(1, GameStringConstants.\u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f);
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        iMaplePlayerShop3.closeShop(iMaplePlayerShop3.getShopType() == 1, false);
                        return;
                    }
                    if (a4.isOperateStorage()) {
                        a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                        return;
                    }
                    if (iMaplePlayerShop.getShopType() == 1) {
                        HiredMerchant hiredMerchant = (HiredMerchant)iMaplePlayerShop;
                        MapleCharacter mapleCharacter = a4;
                        HiredMerchant hiredMerchant5 = hiredMerchant;
                        HiredMerchant hiredMerchant6 = hiredMerchant;
                        hiredMerchant6.setStoreId(a3.getChannelServer().addMerchant(hiredMerchant));
                        hiredMerchant6.setOpen(true);
                        hiredMerchant5.setAvailable(true);
                        hiredMerchant5.setNeedSave(true);
                        mapleCharacter.getMap().broadcastMessage(PlayerShopPacket.spawnHiredMerchant(hiredMerchant));
                        mapleCharacter.setPlayerShop(null);
                        hiredMerchant.saveItems(true);
                        if (a3.isMonitored()) {
                            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleExtendedSlots.ALLATORIxDEMO("\u5edd\u7a93\u7c99\u9710\u5561\u4ee2")));
                        }
                        List<MaplePlayerShopItem> list = hiredMerchant.getItems();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("\r\n\u6642\u9593 " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a3.getPlayer().getName() + "\u7b49\u7d1a:" + a3.getPlayer().getLevel() + " (\u7de8\u865f: " + a3.getPlayer().getId() + ")\u5efa\u7acb\u7cbe\u9748\u5546\u4eba");
                        stringBuilder.append(ByteArrayByteStream.ALLATORIxDEMO(" =\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a"));
                        Iterator<MaplePlayerShopItem> iterator = list.iterator();
                        Iterator<MaplePlayerShopItem> iterator2 = iterator;
                        while (true) {
                            if (!iterator2.hasNext()) {
                                stringBuilder.append("\u6953\u5e63:" + hiredMerchant.getMeso());
                                stringBuilder.append(MapleExtendedSlots.ALLATORIxDEMO("*R\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu"));
                                FileoutputUtil.logToFile(ByteArrayByteStream.ALLATORIxDEMO("AXJD\u0002sLCL\u0018\u7c93\u977f\u556b\u4e8d\u95a6\u5ea0\u0003CUC"), stringBuilder.toString());
                                return;
                            }
                            MaplePlayerShopItem maplePlayerShopItem = iterator.next();
                            stringBuilder.append("\r\n\u7269\u54c1ID:" + maplePlayerShopItem.item.getItemId() + "\u7269\u54c1\u540d\u7a31:" + maplePlayerShopItem.item.getItemName() + " \u6578\u91cf:" + maplePlayerShopItem.bundles);
                            iterator2 = iterator;
                        }
                    }
                    if (iMaplePlayerShop.getShopType() != 2) return;
                    IMaplePlayerShop iMaplePlayerShop4 = iMaplePlayerShop;
                    IMaplePlayerShop iMaplePlayerShop5 = iMaplePlayerShop;
                    iMaplePlayerShop5.setOpen(true);
                    iMaplePlayerShop4.setAvailable(true);
                    iMaplePlayerShop5.update();
                    MaplePlayerShop maplePlayerShop = (MaplePlayerShop)iMaplePlayerShop4;
                    MapleClient mapleClient = a3;
                    mapleClient.getChannelServer().addPlayerShop(maplePlayerShop);
                    maplePlayerShop.saveItems(true);
                    if (mapleClient.isMonitored()) {
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleExtendedSlots.ALLATORIxDEMO("\u5edd\u7a93\u7c99\u9710\u5561\u4ee2")));
                    }
                    List<MaplePlayerShopItem> list = maplePlayerShop.getItems();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\r\n\u6642\u9593 " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a3.getPlayer().getName() + "\u7b49\u7d1a:" + a3.getPlayer().getLevel() + " (\u7de8\u865f: " + a3.getPlayer().getId() + ")\u5efa\u7acb\u7cbe\u9748\u5546\u4eba");
                    stringBuilder.append(ByteArrayByteStream.ALLATORIxDEMO(" =\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a"));
                    Iterator<MaplePlayerShopItem> iterator = list.iterator();
                    Iterator<MaplePlayerShopItem> iterator3 = iterator;
                    while (true) {
                        if (!iterator3.hasNext()) {
                            stringBuilder.append("\u6953\u5e63:" + maplePlayerShop.getMeso());
                            stringBuilder.append(MapleExtendedSlots.ALLATORIxDEMO("*R\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu\nu"));
                            FileoutputUtil.logToFile(ByteArrayByteStream.ALLATORIxDEMO("AXJD\u0002sLCL\u0018\u7c93\u977f\u556b\u4e8d\u95a6\u5ea0\u0003CUC"), stringBuilder.toString());
                            return;
                        }
                        MaplePlayerShopItem maplePlayerShopItem = iterator.next();
                        stringBuilder.append("\r\n\u7269\u54c1ID:" + maplePlayerShopItem.item.getItemId() + "\u7269\u54c1\u540d\u7a31:" + maplePlayerShopItem.item.getItemName() + " \u6578\u91cf:" + maplePlayerShopItem.bundles);
                        iterator3 = iterator;
                    }
                }
                a3.getSession().close();
                if (!ServerConfig.LOG_DC) return;
                FileoutputUtil.logToFile(MapleExtendedSlots.ALLATORIxDEMO("K7@+\b<F,Fwc\u001b\t,_,"), "\r\n \u6642\u9593:" + FileoutputUtil.NowTime() + "\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                return;
            }
            case 10: {
                object = MapleItemInformationProvider.getInstance();
                LittleEndianAccessor littleEndianAccessor = a2;
                byte by = littleEndianAccessor.readByte();
                short s2 = littleEndianAccessor.readShort();
                short s3 = littleEndianAccessor.readShort();
                byte by4 = littleEndianAccessor.readByte();
                MapleInventoryType mapleInventoryType = MapleInventoryType.getByType(by);
                IItem iItem = a4.getInventory(mapleInventoryType).getItem(s2);
                if (ItemCustomFlag.\u7121\u6cd5\u4ea4\u6613.check(iItem.getCustomFlag())) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u6b49\u9064\u515a\u7116\u6cf8\u4e93\u663e\u3035"));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                MapleCharacter mapleCharacter = a4;
                if (a4.isOperateStorage()) {
                    mapleCharacter.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u8a93\u95fb\u95d1\u502e\u5ef3\u5fab\u51d5\u9015\u8814\u64ea\u4f04"));
                    return;
                }
                if (mapleCharacter.getTrade() == null) return;
                if (iItem == null) return;
                if (a4.isInvited()) return;
                if (!(s3 <= iItem.getQuantity() && s3 >= 0 || GameConstants.isThrowingStar(iItem.getItemId()))) {
                    if (!GameConstants.isBullet(iItem.getItemId())) return;
                }
                if (a3.getPlayer().isPlayer() && ItemConstants.isOverPoweredEquip(a3, s2)) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u671b\u88f0\u50ae\u80d0\u52ac\u9063\u658b\u5f1a\u5910\u0001\u0017\u8ae6\u8058\u7e46\u7b96\u742b\u54d6"));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                a4.getTrade().setItems(a3, iItem, by4, s3);
                return;
            }
            case 11: {
                MapleCharacter mapleCharacter = a4;
                object = mapleCharacter.getTrade();
                if (mapleCharacter.isOperateStorage()) {
                    a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u8a93\u95fb\u95d1\u502e\u5ef3\u5fab\u51d5\u9015\u8814\u64ea\u4f04"));
                    return;
                }
                if (object == null) return;
                ((MapleTrade)object).setMeso(a2.readInt());
                return;
            }
            case 12: {
                MapleCharacter mapleCharacter = a4;
                if (a4.isOperateStorage()) {
                    mapleCharacter.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    return;
                }
                if (mapleCharacter.getTrade() == null) return;
                if (a4.isInvited()) return;
                if (a4.getTrade().getPartner().getChr().isInvited()) return;
                MapleCharacter mapleCharacter8 = a4;
                mapleCharacter8.addTradeMsg(mapleCharacter8.getName(), MapleExtendedSlots.ALLATORIxDEMO("x\u789d\u8ad5\u4e83\u664b*R"));
                MapleTrade.completeTrade(mapleCharacter8);
                return;
            }
            case 13: {
                return;
            }
            case 14: 
            case 15: {
                MapleClient mapleClient;
                LittleEndianAccessor littleEndianAccessor = a2;
                object = MapleInventoryType.getByType(littleEndianAccessor.readByte());
                byte by = (byte)littleEndianAccessor.readShort();
                short s4 = littleEndianAccessor.readShort();
                short s5 = littleEndianAccessor.readShort();
                int n11 = littleEndianAccessor.readInt();
                if (n11 <= 0) return;
                if (s4 <= 0) return;
                if (s5 <= 0) {
                    return;
                }
                IMaplePlayerShop iMaplePlayerShop = a4.getPlayerShop();
                if (iMaplePlayerShop == null) return;
                if (!iMaplePlayerShop.isOwner(a4)) return;
                if (iMaplePlayerShop instanceof MapleMiniGame) return;
                if (!iMaplePlayerShop.getCanShop()) {
                    return;
                }
                IItem iItem = a4.getInventory((MapleInventoryType)((Object)object)).getItem(by);
                MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                if (iItem == null) return;
                long l2 = s4 * s5;
                if (l2 > 32767L) return;
                if (l2 <= 0L) {
                    return;
                }
                short s6 = (short)(s4 * s5);
                if (a4.isOperateStorage()) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    return;
                }
                if (iItem.getQuantity() < s6) return;
                int n12 = iItem.getFlag();
                boolean bl = ItemFlag.UNTRADEABLE.check(n12);
                if (ItemFlag.KARMA_EQ.check(n12) || ItemFlag.KARMA_USE.check(n12)) {
                    bl = false;
                }
                if (bl || ItemFlag.LOCK.check(n12)) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if ((mapleItemInformationProvider.isDropRestricted(iItem.getItemId()) || mapleItemInformationProvider.isAccountShared(iItem.getItemId())) && !ItemFlag.KARMA_EQ.check(n12) && !ItemFlag.KARMA_USE.check(n12)) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (GameConstants.isThrowingStar(iItem.getItemId()) || GameConstants.isBullet(iItem.getItemId())) {
                    IItem iItem2 = iItem;
                    IItem iItem3 = iItem2.copyWithQuantity(iItem2.getQuantity());
                    MapleClient mapleClient2 = a3;
                    mapleClient = mapleClient2;
                    iMaplePlayerShop.addItem(new MaplePlayerShopItem(iItem3, 1, n11));
                    MapleInventoryManipulator.removeFromSlot(mapleClient2, (MapleInventoryType)((Object)object), by, iItem.getQuantity(), true);
                } else {
                    if (a3.getPlayer().isPlayer() && ItemConstants.isOverPoweredEquip(a3, by)) {
                        MapleClient mapleClient3 = a3;
                        mapleClient3.getPlayer().dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u6774\u88fa\u50c1\u80da\u52c3\u9069\u65e4\u5f10\u597f\u000bx\u8aec\u8037\u7e4c\u7bf9\u7421\u54b9"));
                        mapleClient3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    MapleClient mapleClient4 = a3;
                    MapleInventoryManipulator.removeFromSlot(mapleClient4, (MapleInventoryType)((Object)object), by, s6, true);
                    IItem iItem4 = iItem.copy();
                    iItem4.setQuantity(s5);
                    iMaplePlayerShop.addItem(new MaplePlayerShopItem(iItem4, s4, n11));
                    if (mapleClient4.isMonitored()) {
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo("\u653e\u7f6e\u7cbe\u9748\u5546\u4eba\u7269\u54c1(ID: " + iItem.getItemId() + "\u6578\u91cf: " + s4 + ")"));
                    }
                    mapleClient = a3;
                }
                mapleClient.sendPacket(PlayerShopPacket.shopItemUpdate(iMaplePlayerShop));
                return;
            }
            case 16: {
                if (GameSetConstants.MAPLE_VERSION < 143) {
                    return;
                }
                if (a4.isOperateStorage()) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    return;
                }
                if (World.isShutDown) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u4f1d\u6755\u564f\u532b\u5c20\u9584\u95ae\uff54\u7106\u6c8d\u57d0\u8814\u670b\u6495\u4f7b\u305a"));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                byte by = littleEndianAccessor.readByte();
                short s7 = littleEndianAccessor.readShort();
                short s8 = littleEndianAccessor.readShort();
                HiredMerchant hiredMerchant = (HiredMerchant)a4.getPlayerShop();
                if (hiredMerchant == null) return;
                if (!hiredMerchant.getCanShop()) return;
                if (hiredMerchant.isOwner(a4)) return;
                if (by >= hiredMerchant.getAcquisitionItems().size()) {
                    return;
                }
                MaplePlayerShopBuyItem maplePlayerShopBuyItem = hiredMerchant.getAcquisitionItems().get(by);
                if (maplePlayerShopBuyItem == null) {
                    return;
                }
                MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(maplePlayerShopBuyItem.item.getItemId());
                if (a4.getInventory(mapleInventoryType).getItem(s8) == null) return;
                if (a4.getInventory(mapleInventoryType).getItem(s8).getItemId() != maplePlayerShopBuyItem.item.getItemId()) return;
                if (a4.getInventory(mapleInventoryType).getItem(s8).getQuantity() < s7) {
                    return;
                }
                MaplePlayerShopBuyItem maplePlayerShopBuyItem2 = maplePlayerShopBuyItem;
                long l3 = maplePlayerShopBuyItem2.bundles * maplePlayerShopBuyItem2.item.getQuantity();
                long l4 = maplePlayerShopBuyItem2.price * maplePlayerShopBuyItem.bundles;
                if (l3 > 0L && l4 <= Integer.MAX_VALUE && l4 > 0L && l3 <= 32767L) {
                    HiredMerchant hiredMerchant7 = hiredMerchant;
                    hiredMerchant7.buyAcquisitionItem(a3, by, s8, s7);
                    hiredMerchant7.broadcastToVisitors(PlayerShopPacket.shopItemUpdate(hiredMerchant7));
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 17: 
            case 18: {
                if (a4.isOperateStorage()) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    return;
                }
                if (a4.getTrade() != null) {
                    a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u8a93\u95fb\u95d1\u4e83\u664b\u5fab\u51d5\u9015\u8814\u64ea\u4f04"));
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                byte by = littleEndianAccessor.readByte();
                short s9 = littleEndianAccessor.readShort();
                IMaplePlayerShop iMaplePlayerShop = a4.getPlayerShop();
                if (iMaplePlayerShop == null) return;
                if (iMaplePlayerShop.isOwner(a4)) return;
                if (iMaplePlayerShop instanceof MapleMiniGame) return;
                if (by >= iMaplePlayerShop.getItems().size()) return;
                if (!iMaplePlayerShop.getCanShop()) {
                    return;
                }
                MaplePlayerShopItem maplePlayerShopItem = iMaplePlayerShop.getItems().get(by);
                if (maplePlayerShopItem == null) {
                    return;
                }
                MaplePlayerShopItem maplePlayerShopItem2 = maplePlayerShopItem;
                long l5 = maplePlayerShopItem2.bundles * s9;
                long l6 = maplePlayerShopItem2.price * s9;
                long l7 = maplePlayerShopItem2.item.getQuantity() * s9;
                if (l5 <= 0L) return;
                if (l6 > Integer.MAX_VALUE) return;
                if (l6 <= 0L) return;
                if (l7 > 32767L) return;
                if (l7 < 0L) {
                    return;
                }
                if (maplePlayerShopItem.bundles < s9) return;
                if (maplePlayerShopItem.bundles % s9 != 0) {
                    if (GameConstants.isEquip(maplePlayerShopItem.item.getItemId())) return;
                }
                if ((long)a4.getMeso() - l6 > Integer.MAX_VALUE) return;
                if ((long)iMaplePlayerShop.getMeso() + l6 < 0L) {
                    return;
                }
                if ((long)a4.getMeso() - l6 < 0L) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u609f\u76a9\u6964\u5e4e\u4e3a\u8d9e\u0019"));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if ((long)iMaplePlayerShop.getMeso() + l6 > Integer.MAX_VALUE) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u60f0\u8cdb\u8cef\u76a3\u551e\u5eb0\u7187\u694a\u9815\u5dd5\u7dcb\u8da2\u6a41\uff2b\u8a93\u903d\u77bd\u5eb0\u4e63\u4fa1\u656e\u9305\u305a"));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                IMaplePlayerShop iMaplePlayerShop6 = iMaplePlayerShop;
                iMaplePlayerShop6.buy(a3, by, s9);
                iMaplePlayerShop6.broadcastToVisitors(PlayerShopPacket.shopItemUpdate(iMaplePlayerShop6));
                return;
            }
            case 19: 
            case 20: {
                byte by = 0;
                if (GameSetConstants.MAPLE_VERSION >= 147) {
                    by = a2.readByte();
                }
                short s10 = a2.readShort();
                IMaplePlayerShop iMaplePlayerShop = a4.getPlayerShop();
                if (iMaplePlayerShop == null) return;
                if (!iMaplePlayerShop.isOwner(a4)) return;
                if (iMaplePlayerShop instanceof MapleMiniGame) return;
                if (iMaplePlayerShop.getItems().size() <= 0) return;
                if (iMaplePlayerShop.getItems().size() <= s10) return;
                if (s10 < 0) return;
                if (!iMaplePlayerShop.getCanShop()) {
                    return;
                }
                if (a4.isOperateStorage()) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    return;
                }
                if (by == 0) {
                    MaplePlayerShopItem maplePlayerShopItem = iMaplePlayerShop.getItems().get(s10);
                    if (maplePlayerShopItem != null && maplePlayerShopItem.bundles > 0) {
                        MaplePlayerShopItem maplePlayerShopItem3 = maplePlayerShopItem;
                        IItem iItem = maplePlayerShopItem3.item.copy();
                        short s11 = maplePlayerShopItem3.item.getQuantity();
                        long l8 = maplePlayerShopItem3.bundles * s11;
                        if (l8 <= 0L) return;
                        if (l8 > 32767L) {
                            return;
                        }
                        iItem.setQuantity((short)l8);
                        if (MapleInventoryManipulator.checkSpace(a3, iItem.getItemId(), iItem.getQuantity(), iItem.getOwner())) {
                            MapleInventoryManipulator.addFromDrop(a3, iItem, false);
                            maplePlayerShopItem.bundles = 0;
                            iMaplePlayerShop.removeFromSlot(s10);
                        }
                    }
                } else if (by == 1) {
                    if (iMaplePlayerShop.getAcquisitionItems().size() <= 0 || iMaplePlayerShop.getAcquisitionItems().size() <= s10) {
                        a3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    MaplePlayerShopBuyItem maplePlayerShopBuyItem = iMaplePlayerShop.getAcquisitionItems().get(s10);
                    if (maplePlayerShopBuyItem != null) {
                        HiredMerchant hiredMerchant = (HiredMerchant)iMaplePlayerShop;
                        if (hiredMerchant.getAcquisition_get().size() > 0 && hiredMerchant.getAcquisition_get().get(s10) != null) {
                            IItem iItem = hiredMerchant.getAcquisition_get().get((Object)Integer.valueOf((int)s10)).item;
                            if (MapleInventoryManipulator.checkSpace(a3, iItem.getItemId(), iItem.getQuantity(), iItem.getOwner())) {
                                MapleInventoryManipulator.addById(a3, iItem.getItemId(), iItem.getQuantity());
                                if ((long)maplePlayerShopBuyItem.price > 0L) {
                                    MaplePlayerShopBuyItem maplePlayerShopBuyItem3 = maplePlayerShopBuyItem;
                                    if ((long)(a3.getPlayer().getMeso() + maplePlayerShopBuyItem3.bundles / maplePlayerShopBuyItem3.item.getQuantity() * maplePlayerShopBuyItem.price) > Integer.MAX_VALUE) {
                                        MapleClient mapleClient = a3;
                                        mapleClient.getPlayer().dropMessage(MapleExtendedSlots.ALLATORIxDEMO("\u60f0\u76a3\u690b\u5e44\u5daa\u7db4\u5daa\u7db4\u6ea7\u4ea1\u305a"));
                                        mapleClient.sendPacket(MaplePacketCreator.enableActions());
                                        return;
                                    }
                                    long l9 = maplePlayerShopBuyItem.bundles / maplePlayerShopBuyItem.item.getQuantity() * maplePlayerShopBuyItem.price;
                                    iMaplePlayerShop.setMeso((int)((long)iMaplePlayerShop.getMeso() - l9));
                                    a3.getPlayer().gainMeso((int)l9, true);
                                    maplePlayerShopBuyItem.price = 0;
                                    maplePlayerShopBuyItem.qty = 0;
                                }
                                maplePlayerShopBuyItem.bundles = 0;
                                hiredMerchant.getAcquisition_get().remove(s10);
                                iMaplePlayerShop.removeFromAcquisitionItem(s10);
                            }
                        } else if ((long)maplePlayerShopBuyItem.price > 0L) {
                            MaplePlayerShopBuyItem maplePlayerShopBuyItem4 = maplePlayerShopBuyItem;
                            if ((long)(a3.getPlayer().getMeso() + maplePlayerShopBuyItem4.bundles / maplePlayerShopBuyItem4.item.getQuantity() * maplePlayerShopBuyItem.price) > Integer.MAX_VALUE) {
                                MapleClient mapleClient = a3;
                                mapleClient.getPlayer().dropMessage(ByteArrayByteStream.ALLATORIxDEMO("\u609f\u76a9\u6964\u5e4e\u5dc5\u7dbe\u5dc5\u7dbe\u6ec8\u4eab\u3035"));
                                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                                return;
                            }
                            MaplePlayerShopBuyItem maplePlayerShopBuyItem5 = maplePlayerShopBuyItem;
                            long l10 = maplePlayerShopBuyItem.bundles / maplePlayerShopBuyItem.item.getQuantity() * maplePlayerShopBuyItem.price;
                            iMaplePlayerShop.setMeso((int)((long)iMaplePlayerShop.getMeso() - l10));
                            a3.getPlayer().gainMeso((int)l10, true);
                            maplePlayerShopBuyItem.price = 0;
                            maplePlayerShopBuyItem5.qty = 0;
                            maplePlayerShopBuyItem5.bundles = 0;
                            iMaplePlayerShop.removeFromAcquisitionItem(s10);
                        }
                    }
                }
                a3.sendPacket(PlayerShopPacket.shopItemUpdate(iMaplePlayerShop));
                return;
            }
            case 21: {
                MapleCharacter mapleCharacter = a4;
                object = mapleCharacter.getPlayerShop();
                if (mapleCharacter.isOperateStorage()) {
                    a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u8a93\u95fb\u95d1\u502e\u5ef3\u5fab\u51d5\u9015\u8814\u64ea\u4f04"));
                    return;
                }
                if (object == null) return;
                if (!(object instanceof HiredMerchant)) return;
                if (!object.isOwner(a4)) return;
                if (!object.getCanShop()) return;
                object.setOpen(true);
                a4.setPlayerShop(null);
                return;
            }
            case 22: {
                MapleCharacter mapleCharacter = a4;
                object = mapleCharacter.getPlayerShop();
                if (mapleCharacter.isOperateStorage()) {
                    a4.dropMessage(1, ByteArrayByteStream.ALLATORIxDEMO("\u8afc\u95f1\u95be\u5024\u5e9c\u5fa1\u51ba\u901f\u887b\u64e0\u4f6b"));
                    return;
                }
                if (object != null && object.isOwner(a4) && !(object instanceof MapleMiniGame) && object.getCanShop()) {
                    int n13;
                    int n14 = n13 = 0;
                    while (n14 < object.getItems().size()) {
                        if (object.getItems().get((int)n13).bundles == 0) {
                            object.getItems().remove(n13);
                        }
                        n14 = ++n13;
                    }
                    if (a4.getMeso() + object.getMeso() < 0) {
                        a3.sendPacket(PlayerShopPacket.shopItemUpdate((IMaplePlayerShop)object));
                        return;
                    }
                    a4.gainMeso(object.getMeso(), false);
                    Object object2 = object;
                    object2.setMeso(0);
                    a3.sendPacket(PlayerShopPacket.shopItemUpdate((IMaplePlayerShop)object2));
                    return;
                }
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 23: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (object.getShopType() == 1 && object.isOwner(a4) && object.isAvailable()) {
                    if (ServerConfig.LOG_MERCHANT) {
                        Object object3 = "";
                        for (MaplePlayerShopItem maplePlayerShopItem : object.getItems()) {
                            IItem iItem = maplePlayerShopItem.item;
                            if (iItem == null) continue;
                            object3 = (String)object3 + iItem.getItemName() + "(" + iItem.getItemId() + ")";
                            if (iItem.getEquipOnlyId() > 0L) {
                                object3 = (String)object3 + "\u552f\u4e00ID:" + iItem.getEquipOnlyId();
                            }
                            object3 = (String)object3 + ", ";
                        }
                        FileoutputUtil.logToFile(MapleExtendedSlots.ALLATORIxDEMO("4H?Twc9S9\b\u7ce6\u976f\u551e\u4e9d\u0007\u95fb\u95d1\t,_,"), "\r\n" + FileoutputUtil.CurrentReadable_Time() + " " + a3.getSessionIPAddress() + " \u73a9\u5bb6 " + a3.getPlayer().getName() + " \u7cbe\u9748\u5546\u4eba\u95dc\u9589, \u6953\u5e63[" + object.getMeso() + "]\u7269\u54c1[" + (String)object3 + "]\r\n");
                    }
                    MapleClient mapleClient = a3;
                    mapleClient.sendPacket(PlayerShopPacket.closeMerchantUI());
                    mapleClient.sendPacket(MaplePacketCreator.getPopupMsg(ByteArrayByteStream.ALLATORIxDEMO("\u8ae6\u538c\u6253\u5bfb\u8600\u5f80\u91e1\u982f\u53fb\u4f57\u76a9\u88ea\u50b4\u54bb\u697e\u5e54")));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    Object object4 = object;
                    object4.removeAllVisitors(-1, -1);
                    a4.setPlayerShop(null);
                    object4.closeShop(true, true);
                    if (ServerTempStorage.getMerchant(a3.getPlayer())) {
                        ServerTempStorage.setMerchant(a3.getPlayer(), false);
                    }
                    if (!a3.isMonitored()) return;
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleExtendedSlots.ALLATORIxDEMO("\u9584\u95ae\u7ce6\u976f\u551e\u4e9dp\u5dd5\u5ea2\u7aec\u7ce6\u976f\u551e\u4e9dq")));
                    return;
                }
                MapleClient mapleClient = a3;
                a3.sendPacket(PlayerShopPacket.closeMerchantUI());
                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                object.removeAllVisitors(-1, -1);
                a4.setPlayerShop(null);
                object.closeShop(true, false, true);
                NPCScriptManager.getInstance().dispose(a3);
                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                if (ServerTempStorage.getMerchant(a3.getPlayer())) {
                    ServerTempStorage.setMerchant(a3.getPlayer(), false);
                }
                if (!a3.isMonitored()) return;
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(ByteArrayByteStream.ALLATORIxDEMO("\u95eb\u95a4\u7c89\u9765\u5571\u4e97\u001f\u6707\u5ecd\u7ae6\u7c89\u9765\u5571\u4e97\u001b\u6724\u6509\u7f43\u725e\u54ec\u001e")));
                return;
            }
            case 24: 
            case 25: {
                return;
            }
            case 26: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (object.getShopType() != 1) return;
                if (!object.isOwner(a4)) return;
                ((HiredMerchant)object).sendVisitor(a3);
                return;
            }
            case 27: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (object.getShopType() != 1) return;
                if (!object.isOwner(a4)) return;
                ((HiredMerchant)object).sendBlackList(a3);
                return;
            }
            case 28: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (object.getShopType() != 1) return;
                if (!object.isOwner(a4)) return;
                ((HiredMerchant)object).addBlackList(a2.readMapleAsciiString());
                return;
            }
            case 29: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (object.getShopType() != 1) return;
                if (!object.isOwner(a4)) return;
                ((HiredMerchant)object).removeBlackList(a2.readMapleAsciiString());
                return;
            }
            case 30: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame = (MapleMiniGame)object;
                if (mapleMiniGame.isOpen()) {
                    return;
                }
                MapleMiniGame mapleMiniGame5 = mapleMiniGame;
                MapleMiniGame mapleMiniGame6 = mapleMiniGame;
                MapleMiniGame mapleMiniGame7 = mapleMiniGame;
                mapleMiniGame7.broadcastToVisitors(PlayerShopPacket.getMiniGameResult(mapleMiniGame7, 0, mapleMiniGame7.getVisitorSlot(a4)));
                mapleMiniGame6.nextLoser();
                mapleMiniGame5.setOpen(true);
                mapleMiniGame6.update();
                mapleMiniGame5.checkExitAfterGame();
                return;
            }
            case 31: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                if (!((MapleMiniGame)object).isOpen()) {
                    return;
                }
                object.removeAllVisitors(5, 1);
                return;
            }
            case 32: 
            case 33: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame = (MapleMiniGame)object;
                if (mapleMiniGame.isOwner(a4)) return;
                if (!mapleMiniGame.isOpen()) return;
                MapleMiniGame mapleMiniGame8 = mapleMiniGame;
                MapleMiniGame mapleMiniGame9 = mapleMiniGame;
                mapleMiniGame9.setReady(mapleMiniGame.getVisitorSlot(a4));
                mapleMiniGame8.broadcastToVisitors(PlayerShopPacket.getMiniGameReady(mapleMiniGame9.isReady(mapleMiniGame8.getVisitorSlot(a4))));
                return;
            }
            case 34: {
                MapleMiniGame mapleMiniGame;
                int n15;
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame10 = (MapleMiniGame)object;
                if (!mapleMiniGame10.isOwner(a4)) return;
                if (!mapleMiniGame10.isOpen()) return;
                int n16 = n15 = 1;
                while (n16 < object.getSize()) {
                    if (!mapleMiniGame10.isReady(n15)) {
                        return;
                    }
                    n16 = ++n15;
                }
                MapleMiniGame mapleMiniGame11 = mapleMiniGame10;
                mapleMiniGame11.setGameType();
                mapleMiniGame11.shuffleList();
                if (mapleMiniGame11.getGameType() == 1) {
                    MapleMiniGame mapleMiniGame12 = mapleMiniGame10;
                    mapleMiniGame = mapleMiniGame12;
                    mapleMiniGame12.broadcastToVisitors(PlayerShopPacket.getMiniGameStart(mapleMiniGame12.getLoser()));
                } else {
                    MapleMiniGame mapleMiniGame13 = mapleMiniGame10;
                    mapleMiniGame = mapleMiniGame13;
                    mapleMiniGame13.broadcastToVisitors(PlayerShopPacket.getMatchCardStart(mapleMiniGame13, mapleMiniGame13.getLoser()));
                }
                mapleMiniGame.setOpen(false);
                mapleMiniGame10.update();
                return;
            }
            case 35: {
                MapleMiniGame mapleMiniGame;
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame14 = (MapleMiniGame)object;
                if (mapleMiniGame14.isOpen()) {
                    return;
                }
                MapleMiniGame mapleMiniGame15 = mapleMiniGame14;
                if (mapleMiniGame14.isOwner(a4)) {
                    mapleMiniGame15.broadcastToVisitors(PlayerShopPacket.getMiniGameRequestTie(), false);
                    mapleMiniGame = mapleMiniGame14;
                } else {
                    mapleMiniGame15.getMCOwner().getClient().sendPacket(PlayerShopPacket.getMiniGameRequestTie());
                    mapleMiniGame = mapleMiniGame14;
                }
                mapleMiniGame.setRequestedTie(mapleMiniGame14.getVisitorSlot(a4));
                return;
            }
            case 36: {
                MapleMiniGame mapleMiniGame;
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame16 = (MapleMiniGame)object;
                if (mapleMiniGame16.isOpen()) {
                    return;
                }
                if (mapleMiniGame16.getRequestedTie() <= -1) return;
                if (mapleMiniGame16.getRequestedTie() == mapleMiniGame16.getVisitorSlot(a4)) return;
                MapleMiniGame mapleMiniGame17 = mapleMiniGame16;
                if (a2.readByte() > 0) {
                    MapleMiniGame mapleMiniGame18 = mapleMiniGame16;
                    mapleMiniGame17.broadcastToVisitors(PlayerShopPacket.getMiniGameResult(mapleMiniGame18, 1, mapleMiniGame18.getRequestedTie()));
                    MapleMiniGame mapleMiniGame19 = mapleMiniGame16;
                    mapleMiniGame = mapleMiniGame19;
                    MapleMiniGame mapleMiniGame20 = mapleMiniGame16;
                    mapleMiniGame20.nextLoser();
                    mapleMiniGame19.setOpen(true);
                    mapleMiniGame20.update();
                    mapleMiniGame19.checkExitAfterGame();
                } else {
                    mapleMiniGame17.broadcastToVisitors(PlayerShopPacket.getMiniGameDenyTie());
                    mapleMiniGame = mapleMiniGame16;
                }
                mapleMiniGame.setRequestedTie(-1);
                return;
            }
            case 37: {
                MapleMiniGame mapleMiniGame;
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame21 = (MapleMiniGame)object;
                if (mapleMiniGame21.isOpen()) {
                    return;
                }
                MapleMiniGame mapleMiniGame22 = mapleMiniGame21;
                if (mapleMiniGame21.isOwner(a4)) {
                    mapleMiniGame22.broadcastToVisitors(PlayerShopPacket.getMiniGameRequestREDO(), false);
                    mapleMiniGame = mapleMiniGame21;
                } else {
                    mapleMiniGame22.getMCOwner().getClient().sendPacket(PlayerShopPacket.getMiniGameRequestREDO());
                    mapleMiniGame = mapleMiniGame21;
                }
                mapleMiniGame.setRequestedTie(mapleMiniGame21.getVisitorSlot(a4));
                return;
            }
            case 38: {
                MapleMiniGame mapleMiniGame;
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame23 = (MapleMiniGame)object;
                if (mapleMiniGame23.isOpen()) {
                    return;
                }
                if (a2.readByte() > 0) {
                    MapleMiniGame mapleMiniGame24 = mapleMiniGame23;
                    mapleMiniGame = mapleMiniGame24;
                    Object object5 = object;
                    object5.broadcastToVisitors(PlayerShopPacket.getMiniGameSkip1(object5.getVisitorSlot(a4)));
                    mapleMiniGame24.nextLoser();
                } else {
                    MapleMiniGame mapleMiniGame25 = mapleMiniGame23;
                    mapleMiniGame = mapleMiniGame25;
                    mapleMiniGame25.broadcastToVisitors(PlayerShopPacket.getMiniGameRequestREDB());
                }
                mapleMiniGame.setRequestedTie(-1);
                return;
            }
            case 39: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame = (MapleMiniGame)object;
                if (mapleMiniGame.isOpen()) {
                    return;
                }
                Object object6 = object;
                object6.broadcastToVisitors(PlayerShopPacket.getMiniGameSkip(object6.getVisitorSlot(a4)));
                mapleMiniGame.nextLoser();
                return;
            }
            case 40: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame = (MapleMiniGame)object;
                if (mapleMiniGame.isOpen()) {
                    return;
                }
                mapleMiniGame.setPiece(a2.readInt(), a2.readInt(), a2.readByte(), a4);
                return;
            }
            case 41: {
                MapleMiniGame mapleMiniGame;
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame26 = (MapleMiniGame)object;
                if (mapleMiniGame26.isOpen()) {
                    return;
                }
                if (a2.readByte() != mapleMiniGame26.getTurn()) {
                    MapleMiniGame mapleMiniGame27 = mapleMiniGame26;
                    mapleMiniGame27.broadcastToVisitors(PlayerShopPacket.shopChat("\u4e0d\u80fd\u653e\u5728\u901a\u904e " + a4.getName() + ". \u5931\u6557\u8005: " + mapleMiniGame26.getLoser() + " \u904a\u5ba2: " + mapleMiniGame27.getVisitorSlot(a4) + " \u662f\u5426\u70ba\u771f: " + mapleMiniGame26.getTurn(), mapleMiniGame26.getVisitorSlot(a4)));
                    return;
                }
                byte by = a2.readByte();
                MapleMiniGame mapleMiniGame28 = mapleMiniGame26;
                int n17 = mapleMiniGame28.getTurn();
                int n18 = mapleMiniGame28.getFirstSlot();
                if (n17 == 1) {
                    MapleMiniGame mapleMiniGame29;
                    MapleMiniGame mapleMiniGame30 = mapleMiniGame26;
                    mapleMiniGame30.setFirstSlot(by);
                    MapleMiniGame mapleMiniGame31 = mapleMiniGame26;
                    if (mapleMiniGame30.isOwner(a4)) {
                        int n19 = n17;
                        mapleMiniGame31.broadcastToVisitors(PlayerShopPacket.getMatchCardSelect(n19, by, n18, n19), false);
                        mapleMiniGame29 = mapleMiniGame26;
                    } else {
                        int n20 = n17;
                        mapleMiniGame31.getMCOwner().getClient().sendPacket(PlayerShopPacket.getMatchCardSelect(n20, by, n18, n20));
                        mapleMiniGame29 = mapleMiniGame26;
                    }
                    mapleMiniGame29.setTurn(0);
                    return;
                }
                if (mapleMiniGame26.getCardId(n18 + 1) == mapleMiniGame26.getCardId(by + 1)) {
                    mapleMiniGame26.broadcastToVisitors(PlayerShopPacket.getMatchCardSelect(n17, by, n18, mapleMiniGame26.isOwner(a4) ? 2 : 3));
                    MapleMiniGame mapleMiniGame32 = mapleMiniGame26;
                    mapleMiniGame = mapleMiniGame32;
                    mapleMiniGame32.setPoints(mapleMiniGame32.getVisitorSlot(a4));
                } else {
                    mapleMiniGame26.broadcastToVisitors(PlayerShopPacket.getMatchCardSelect(n17, by, n18, mapleMiniGame26.isOwner(a4) ? 0 : 1));
                    MapleMiniGame mapleMiniGame33 = mapleMiniGame26;
                    mapleMiniGame = mapleMiniGame33;
                    mapleMiniGame33.nextLoser();
                }
                mapleMiniGame.setTurn(1);
                mapleMiniGame26.setFirstSlot(0);
                return;
            }
            case 42: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame = (MapleMiniGame)object;
                if (mapleMiniGame.isOpen()) {
                    return;
                }
                MapleMiniGame mapleMiniGame34 = mapleMiniGame;
                MapleMiniGame mapleMiniGame35 = mapleMiniGame;
                MapleMiniGame mapleMiniGame36 = mapleMiniGame;
                mapleMiniGame36.broadcastToVisitors(PlayerShopPacket.getMiniGameResult(mapleMiniGame36, 0, mapleMiniGame36.getVisitorSlot(a4)));
                mapleMiniGame35.nextLoser();
                mapleMiniGame34.setOpen(true);
                mapleMiniGame35.update();
                mapleMiniGame34.checkExitAfterGame();
                return;
            }
            case 43: {
                object = a4.getPlayerShop();
                if (object == null) return;
                if (!(object instanceof MapleMiniGame)) return;
                MapleMiniGame mapleMiniGame = (MapleMiniGame)object;
                if (mapleMiniGame.isOpen()) {
                    return;
                }
                MapleMiniGame mapleMiniGame37 = mapleMiniGame;
                mapleMiniGame37.setExitAfter(a4);
                mapleMiniGame.broadcastToVisitors(PlayerShopPacket.getMiniGameExitAfter(mapleMiniGame37.isExitAfter(a4)));
                return;
            }
        }
    }

    public static final /* synthetic */ void HiredMerchantRemoteControl(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        int n2;
        if (a4.getMapId() != 910000000 || a4.getParty() != null) {
            return;
        }
        if (World.isShutDown) {
            a4.dropMessage(1, GameStringConstants.\u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f);
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        ChannelServer channelServer = ChannelServer.getInstance(a4.getWorld(), a4.getMap().getChannel());
        if (channelServer == null) {
            return;
        }
        int n3 = n2 = 1;
        while (n3 < 23) {
            MapleMap mapleMap = channelServer.getMapFactory().getMap(910000000 + n2);
            if (mapleMap != null) {
                MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
                arrmapleMapObjectType[0] = MapleMapObjectType.HIRED_MERCHANT;
                for (MapleMapObject mapleMapObject : mapleMap.getMapObjects(Arrays.asList(arrmapleMapObjectType))) {
                    HiredMerchant hiredMerchant;
                    if (!(mapleMapObject instanceof HiredMerchant) || !(hiredMerchant = (HiredMerchant)mapleMapObject).isOwner(a4)) continue;
                    HiredMerchant hiredMerchant2 = hiredMerchant;
                    hiredMerchant2.setOpen(false);
                    hiredMerchant2.removeAllVisitors((byte)MaplePacketOperation.MerchantStatus.\u5546\u5e97\u6574\u7406\u7269\u54c1, 1);
                    a4.setPlayerShop((IMaplePlayerShop)((Object)mapleMapObject));
                    a3.sendPacket(PlayerShopPacket.getHiredMerch(a4, hiredMerchant, false));
                    return;
                }
            }
            n3 = ++n2;
        }
        a4.dropMessage(1, MapleExtendedSlots.ALLATORIxDEMO("\u670d\u6226\u5217\u7ce6\u976f\u551e\u4e9d\uff54\u8aec\u78e2\u8aaa\u5fd4\u51aa\u4f27\u750f\u305a"));
    }
}

