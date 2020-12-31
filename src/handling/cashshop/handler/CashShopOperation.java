/*
 * Decompiled with CFR 0.150.
 */
package handling.cashshop.handler;

import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryType;
import client.inventory.MapleRing;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ServerConfig;
import database.DBConPool;
import handling.auction.handler.MTSOperation;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.opcodes.BuyCashShopType;
import handling.world.CharacterTransfer;
import handling.world.World;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.CashItem;
import server.CashItemFactory;
import server.CashModItem;
import server.Coupon.CouponFactory;
import server.MTSStorage;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.RandomRewards;
import server.Randomizer;
import server.maps.Event_PyramidSubway;
import server.quest.MapleQuest;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.MTSCSPacket;

public class CashShopOperation {
    public /* synthetic */ CashShopOperation() {
        CashShopOperation a2;
    }

    public static /* synthetic */ void sendCashShopUpdate(MapleClient a2) {
        if (a2.getPlayer() != null) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MTSCSPacket.showGifts(mapleClient));
            CashShopOperation.ALLATORIxDEMO(mapleClient);
            mapleClient.sendPacket(MTSCSPacket.sendShowWishList(mapleClient.getPlayer()));
        }
    }

    public static /* synthetic */ boolean CanGetFromMoonBox(IItem a2) {
        boolean bl = true;
        if (a2.getItemId() >= 2000000) {
            return false;
        }
        Equip equip = (Equip)a2;
        if (!MapleItemInformationProvider.getInstance().isCash(a2.getItemId())) {
            bl = false;
            return false;
        }
        if (!equip.isclean()) {
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final /* synthetic */ MapleInventoryType ALLATORIxDEMO(int a2) {
        switch (a2) {
            case 50200075: {
                return MapleInventoryType.EQUIP;
            }
            case 50200074: {
                return MapleInventoryType.USE;
            }
            case 50200073: {
                return MapleInventoryType.ETC;
            }
        }
        return MapleInventoryType.UNDEFINED;
    }

    public static /* synthetic */ void CouponCode(String a2, MapleClient a3) {
        boolean bl = false;
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        int n5 = -1;
        if (GameSetConstants.CS_STATE_CHECK && a3.getLoginState() != 5) {
            FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("6K=Wul;G1\u000b\u551c\u57eau\u977a\u551c\u57ea\u729a\u616f\u6497\u4f78\u551c\u57eatP\"P"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6: " + a3.getPlayer().getName() + " \u52d5\u4f5c: sendgift");
            return;
        }
        if (a3.getPlayer().getPrizeLog(a2) >= 1) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u60bc\u5ddf\u4f6b\u7505\u905a\u6b49\u513e\u5fa8\u522c\f"));
            CashShopOperation.ALLATORIxDEMO(mapleClient);
            return;
        }
        if (GameSetConstants.PHONE_PRIZE_LIMIT && !a3.getPlayer().isPhoneVerified()) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(-1, Event_PyramidSubway.ALLATORIxDEMO("\u60f2\u53ce\u975a\u7db7\u9014\u626f\u6a05\u9a73\u8b13\b\u5c6b\u53cb\u4ebf\u5168\u6381\u510e\u60ba\u521c\u54bc\u0005"));
            CashShopOperation.ALLATORIxDEMO(mapleClient);
            return;
        }
        bl = CouponFactory.getNXCodeValid(a2.toUpperCase(), bl);
        if (bl) {
            MapleClient mapleClient;
            String string = a2;
            n2 = CouponFactory.getNXCodeType(string);
            n3 = CouponFactory.getNXCodeItem(string);
            n4 = CouponFactory.getNXCodeSize(string);
            n5 = CouponFactory.getNXCodeTime(string);
            if (n2 <= 4) {
                try {
                    CouponFactory.setNXCodeUsed(a3.getPlayer().getName(), a2);
                }
                catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                }
            }
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            String string2 = "";
            String string3 = "";
            switch (n2) {
                case 1: {
                    MapleClient mapleClient2 = a3;
                    while (false) {
                    }
                    mapleClient = mapleClient2;
                    int n9 = n3;
                    mapleClient2.getPlayer().modifyCSPoints(1, n9, false);
                    n6 = n9;
                    string2 = LittleEndianAccessor.ALLATORIxDEMO("SlGe");
                    break;
                }
                case 2: {
                    MapleClient mapleClient3 = a3;
                    mapleClient = mapleClient3;
                    int n10 = n3;
                    mapleClient3.getPlayer().modifyCSPoints(2, n10, false);
                    n6 = n10;
                    string2 = Event_PyramidSubway.ALLATORIxDEMO("\u6909\u846d\u9e84\u655c");
                    break;
                }
                case 3: {
                    MapleClient mapleClient4 = a3;
                    mapleClient = mapleClient4;
                    MapleInventoryManipulator.addById(mapleClient4, n3, (short)n4, LittleEndianAccessor.ALLATORIxDEMO("\u513e\u5fa8\u5363\u7983\u54d5\u0003"), null, n5);
                    n8 = 1;
                    break;
                }
                case 4: {
                    a3.getPlayer().gainMeso(n3, false);
                    n7 = n3;
                    string2 = Event_PyramidSubway.ALLATORIxDEMO("\u6909\u5e47");
                }
                default: {
                    mapleClient = a3;
                }
            }
            mapleClient.getPlayer().setPrizeLog(a2);
            if (n5 == -1 && n2 != 1 && n2 != 2) {
                string3 = LittleEndianAccessor.ALLATORIxDEMO("\u6c2c\u4e68");
                n8 = 2;
            }
            switch (n8) {
                case 1: {
                    while (false) {
                    }
                    a3.getPlayer().dropMessage(1, "\u5df2\u6210\u529f\u4f7f\u7528\u512a\u5f85\u5377\u7372\u5f97" + MapleItemInformationProvider.getInstance().getName(n3) + n5 + "\u5929 x" + n4 + "\u3002");
                    break;
                }
                case 2: {
                    a3.getPlayer().dropMessage(1, "\u5df2\u6210\u529f\u4f7f\u7528\u512a\u5f85\u5377\u7372\u5f97" + MapleItemInformationProvider.getInstance().getName(n3) + "\u6c38\u4e45 x" + n4 + "\u3002");
                    break;
                }
                default: {
                    a3.getPlayer().dropMessage(1, "\u5df2\u6210\u529f\u4f7f\u7528\u512a\u5f85\u5377\u7372\u5f97" + n3 + string2);
                    break;
                }
            }
        } else {
            a3.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u6b3e\u510e\u5fdf\u521c\u5da8\u7105\u6512\u6232\u4e57\u5b7c\u5772\u0005"));
        }
        CashShopOperation.ALLATORIxDEMO(a3);
    }

    public static /* synthetic */ void handleRandomRecommend(MapleClient a2) {
        ArrayList<CashItem> arrayList;
        if (a2 == null || a2.getPlayer() == null) {
            return;
        }
        Map<Integer, List<CashItem>> map = CashItemFactory.getInstance().getPackages();
        if (map.size() <= 0) {
            return;
        }
        ArrayList<CashItem> arrayList2 = new ArrayList<CashItem>();
        int n2 = -1;
        block0: do {
            Map<Integer, List<CashItem>> map2 = map;
            n2 = Randomizer.nextInt(map2.size());
            int n3 = 0;
            Iterator<List<CashItem>> iterator = map2.values().iterator();
            while (iterator.hasNext()) {
                Iterator<List<CashItem>> iterator2;
                List<CashItem> list = iterator2.next();
                if (n3 == n2) {
                    boolean bl;
                    block7: {
                        boolean bl2 = false;
                        for (CashItem cashItem : list) {
                            if (cashItem == null || cashItem.getId() >= 2000000) continue;
                            bl = bl2 = true;
                            break block7;
                        }
                        bl = bl2;
                    }
                    if (bl) {
                        ArrayList<CashItem> arrayList3 = arrayList2;
                        arrayList = arrayList3;
                        arrayList3.addAll(list);
                        continue block0;
                    }
                }
                ++n3;
                iterator = iterator2;
            }
            arrayList = arrayList2;
        } while (arrayList.isEmpty());
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MTSCSPacket.showRandomRecommend(arrayList2));
        CashShopOperation.ALLATORIxDEMO(mapleClient);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ void LeaveCashShop(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a3.getLoginState() != 5) {
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("xBs^;IuYu\u0002Pn:YlY"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a3.getSession().close();
            a3.disconnect();
            return;
        }
        if (a4.getEventInstance() != null) {
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("6K=Wu@;P;\u000b\u001egtP\"P"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a3.getSession().close();
            a3.disconnect();
            return;
        }
        try {
            ChannelServer channelServer;
            MapleClient mapleClient = a3;
            ChannelServer channelServer2 = channelServer = ChannelServer.getInstance(mapleClient.getWorld(), -10);
            channelServer2.getPlayerStorage().deregisterPlayer(a4);
            channelServer2.getPlayerStorage().registerPlayerTransfer(a4);
            MapleClient mapleClient2 = a3;
            mapleClient.updateLoginState(9, mapleClient2.getSessionIPAddress());
            MapleClient mapleClient3 = a3;
            World.channelChangeData(new CharacterTransfer(a4), mapleClient3, a4.getId(), a3.getWorld(), mapleClient3.getChannel());
            mapleClient.sendPacket(MaplePacketCreator.getChannelChange(ChannelServer.getInstance(mapleClient2.getWorld(), a3.getChannel()).getIP(), ChannelServer.getInstance(a3.getWorld(), a3.getChannel()).getPort()));
            if (mapleClient.isMonitored()) {
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a4.getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a4.getChrInfo(LittleEndianAccessor.ALLATORIxDEMO("\u96f6\u95a6\u5552\u57e3")));
            }
            MapleClient mapleClient4 = a3;
            mapleClient4.disconnect();
            mapleClient4.setPlayer(null);
            a3.setReceiving(false);
            return;
        }
        catch (Exception exception) {
            System.err.println("LeaveCashShop: " + exception);
            return;
        }
        finally {
            MapleClient mapleClient = a3;
            a3.disconnect();
            mapleClient.setPlayer(null);
            mapleClient.setReceiving(false);
        }
    }

    public static final /* synthetic */ void UseXmaxsSurprise(LittleEndianAccessor a2, MapleClient a3) {
        int n2 = (int)a2.readLong();
        IItem iItem = a3.getPlayer().getCashInventory().findByCashId(n2);
        if (iItem != null && iItem.getItemId() == 5222000 && iItem.getQuantity() > 0 && MapleInventoryManipulator.checkSpace(a3, iItem.getItemId(), iItem.getQuantity(), iItem.getOwner())) {
            int n3;
            int n4 = RandomRewards.getInstance().getXmasreward();
            Object object = CashItemFactory.getInstance().getAllItems();
            IItem iItem2 = null;
            CashItem cashItem = null;
            do {
                cashItem = object.get(Randomizer.rand(0, object.size() - 1));
            } while (!CashShopOperation.CanGetFromMoonBox(iItem2 = a3.getPlayer().getCashInventory().toItem(cashItem)));
            if (cashItem == null) {
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(MTSCSPacket.sendCSFail(0));
                CashShopOperation.ALLATORIxDEMO(mapleClient);
                return;
            }
            object = GameConstants.cashBlock;
            int n5 = GameConstants.cashBlock.length;
            int n6 = n3 = 0;
            while (n6 < n5) {
                Object object2 = object[n3];
                if (cashItem.getId() == object2) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, GameConstants.getCashBlockedMsg(cashItem.getId()));
                    CashShopOperation.ALLATORIxDEMO(mapleClient);
                    return;
                }
                n6 = ++n3;
            }
            if (iItem2 != null) {
                if (a3.getPlayer().getCashInventory().getItemsSize() >= 100) {
                    MapleClient mapleClient = a3;
                    mapleClient.sendPacket(MTSCSPacket.showXmasSurprise(true, n2, iItem2, a3.getAccID()));
                    CashShopOperation.ALLATORIxDEMO(mapleClient);
                    return;
                }
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().getCashInventory().addToInventory(iItem2);
                mapleClient.sendPacket(MTSCSPacket.showXmasSurprise(false, n2, iItem2, a3.getAccID()));
                a3.getPlayer().getCashInventory().removeFromInventory(iItem);
                return;
            }
            a3.sendPacket(MTSCSPacket.sendCSFail(0));
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 5 << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ 3 << 1;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public static /* synthetic */ void sendWebSite(MapleClient a2) {
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MTSCSPacket.sendWEB(mapleClient));
        CashShopOperation.ALLATORIxDEMO(mapleClient);
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2) {
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MTSCSPacket.showCashInventory(mapleClient));
        mapleClient.sendPacket(MTSCSPacket.showNXMapleTokens(mapleClient.getPlayer()));
        mapleClient.sendPacket(MTSCSPacket.enableCSUse());
        mapleClient.getPlayer().getCashInventory().checkExpire(a2);
    }

    public static final /* synthetic */ void ChangeName(LittleEndianAccessor a2, MapleClient a3) {
        if (GameSetConstants.CS_STATE_CHECK && a3.getLoginState() != 5) {
            FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("6K=Wul;G1\u000b\u551c\u57eau\u977a\u551c\u57ea\u729a\u616f\u6497\u4f78\u551c\u57eatP\"P"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6: " + a3.getPlayer().getName() + " \u52d5\u4f5c: ChangeName");
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        String string = littleEndianAccessor.readMapleAsciiString();
        int n3 = 500;
        if (a3.getSecondPassword() != null) {
            if (string == null) {
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u8adf\u8f15\u5171\u5beb\u78a8\u302f"));
                CashShopOperation.ALLATORIxDEMO(mapleClient);
                return;
            }
            if (!a3.check2ndPassword(string)) {
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u5be2\u78e6\u930b\u8afe\u3026"));
                CashShopOperation.ALLATORIxDEMO(mapleClient);
                return;
            }
            if (a3.getPlayer().getId() != n2) {
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u89ff\u8266dP\u5209\u5b8e\u9302\u8ab0\u302f"));
                CashShopOperation.ALLATORIxDEMO(mapleClient);
                return;
            }
            if (a3.getPlayer().getCSPoints(1) < 500) {
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("c\u001bw\u0012\u9efa\u6522\u4e29\u8de9\u0005"));
                CashShopOperation.ALLATORIxDEMO(mapleClient);
                return;
            }
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().modifyCSPoints(1, -n3, false);
            mapleClient.sendPacket(MTSCSPacket.sendChnageName(mapleClient));
        }
        CashShopOperation.ALLATORIxDEMO(a3);
    }

    public static /* synthetic */ void EnterCashShop(int a2, MapleClient a3, int a4) {
        Serializable serializable;
        a3.loadAccountidByPlayerid(a2);
        if (!GameSetConstants.FOWARD_PROTECT && GameSetConstants.ENTERCS_CHECK) {
            if (World.Find.findDisconnect(a3.getAccID()) > 0) {
                System.out.println("(EnterCashShop) \u5546\u57ce\u89d2\u8272\u8907\u88fd: " + a2 + " \u5e33\u865fid: " + a3.getAccID());
                FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("H5C)\u000b\u0012E9Ou\u8923\u88a7\u000b\u8988\u8256\u895d\u88d9tP\"P"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid: " + a3.getAccID() + " \u5546\u57ce\u89d2\u8272\u8907\u88fd (EnterCashShop)");
                MapleClient mapleClient = a3;
                World.Find.forceDeregisterDisconnect(mapleClient.getAccID());
                mapleClient.getSession().close();
                return;
            }
            if (!MapleCharacterUtil.isExistCharacterInDataBase(a2)) {
                System.out.println("<\u522a\u9664\u89d2\u8272> (EnterCashShop)  \u983b\u9053<" + a3.getChannel() + ">\u89d2\u8272\u8907\u88fd: " + a2 + " \u5e33\u865fid: " + a3.getAccID());
                FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("A{Jg\u0002\\LwF;\u892a\u88e9\u0002\u89c6\u825f\u8913\u88d0:YlY"), FileoutputUtil.CurrentReadable_Time() + " <\u522a\u9664\u89d2\u8272\u8907\u88fd> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID());
                a3.getSession().close();
                return;
            }
            if (a3.getLoginState() != 6) {
                System.out.println(" <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " getLoginState:" + a3.getLoginState());
                FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("H5C)\u000b\u0012E9Ou\u8923\u88a7\u000b\u551c\u57ea\u729a\u616f\u752a\u5e1ctP\"P"), FileoutputUtil.CurrentReadable_Time() + " <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " getLoginState:" + a3.getLoginState());
                a3.getSession().close();
                return;
            }
            MapleClient mapleClient = a3;
            if (ChannelServer.LoggedInPlayerCount(mapleClient, mapleClient.getAccID()) > 0) {
                MapleClient mapleClient2 = a3;
                ChannelServer.forceRemovePlayerByAccId(mapleClient2, mapleClient2.getAccID());
                System.out.println(" <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " \u9032\u5165\u5546\u57ce\u540c\u6642\u6709\u5176\u4ed6\u8655\u767b\u5165(Player \u9032\u904a\u6232\u5f8c)");
                FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("A{Jg\u0002\\LwF;\u892a\u88e9\u0002\u5552\u57e3\u72d4\u6166\u7564\u5e15:YlY"), FileoutputUtil.CurrentReadable_Time() + " <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " \u9032\u5165\u5546\u57ce\u540c\u6642\u6709\u5176\u4ed6\u8655\u767b\u5165(Player \u9032\u904a\u6232\u5f8c)");
                a3.getSession().close();
                return;
            }
            if (LoginServer.getClientCount(a3) > 0) {
                LoginServer.forceRemoveClient(a3);
                System.out.println(" <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " \u9032\u5165\u5546\u57ce\u540c\u6642\u6709\u5176\u4ed6\u8655\u767b\u5165(Client \u9032\u904a\u6232\u524d)");
                FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("H5C)\u000b\u0012E9Ou\u8923\u88a7\u000b\u551c\u57ea\u729a\u616f\u752a\u5e1ctP\"P"), FileoutputUtil.CurrentReadable_Time() + " <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " \u9032\u5165\u5546\u57ce\u540c\u6642\u6709\u5176\u4ed6\u8655\u767b\u5165 \u9032\u904a\u6232\u524d");
                a3.getSession().close();
                return;
            }
        }
        MapleClient mapleClient = a3;
        ChannelServer channelServer = ChannelServer.getInstance(mapleClient.getWorld(), -10);
        ChannelServer channelServer2 = ChannelServer.getInstance(mapleClient.getWorld(), -20);
        Serializable serializable2 = channelServer.getPlayerStorage().getPendingCharacter(a2);
        boolean bl = false;
        if (GameSetConstants.CHECKIP_ADRESS && !GameSetConstants.FOWARD_PROTECT) {
            if (serializable2 == null) {
                serializable2 = channelServer2.getPlayerStorage().getPendingCharacter(a2);
                bl = true;
                if (serializable2 == null) {
                    a3.disconnect();
                    return;
                }
            }
            if (!a3.CheckIPAddress()) {
                a3.disconnect();
                return;
            }
        }
        byte by = a3.getLoginState();
        boolean bl2 = false;
        serializable2 = MapleCharacter.ReconstructChr((CharacterTransfer)serializable2, a3, false);
        if (!(by != 1 && by != 6 || World.isConnected(((MapleCharacter)serializable2).getName()))) {
            bl2 = true;
        }
        if (!GameSetConstants.FOWARD_PROTECT) {
            if (!bl2) {
                a3.disconnect();
                return;
            }
            if (!World.inClientCsTransfer(a3.getAccountName())) {
                LoginServer.forceRemoveClient(a3);
                System.out.println(" <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " \u9032\u5165\u5546\u57ce\u540c\u6642\u6709\u5176\u4ed6\u8655\u767b\u5165(Client \u9032\u904a\u6232\u524d) not inClientCsTransfer");
                FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("A{Jg\u0002\\LwF;\u892a\u88e9\u0002\u5552\u57e3\u72d4\u6166\u7564\u5e15:YlY"), FileoutputUtil.CurrentReadable_Time() + " <\u5546\u57ce\u72c0\u614b\u7570\u5e38> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID() + " \u9032\u5165\u5546\u57ce\u540c\u6642\u6709\u5176\u4ed6\u8655\u767b\u5165 \u9032\u904a\u6232\u524d not inClientCsTransfer");
                a3.getSession().close();
                return;
            }
        }
        MapleClient mapleClient3 = a3;
        if (bl) {
            mapleClient3.updateLoginState(8, a3.getSessionIPAddress());
            Serializable serializable3 = serializable2;
            serializable = serializable3;
            channelServer2.getPlayerStorage().registerPlayer((MapleCharacter)serializable3);
        } else {
            mapleClient3.updateLoginState(5, a3.getSessionIPAddress());
            Serializable serializable4 = serializable2;
            serializable = serializable4;
            channelServer.getPlayerStorage().registerPlayer((MapleCharacter)serializable4);
        }
        ((MapleCharacter)serializable).setTransferTime(-1L);
        ChannelServer.deregisterAllPlayerTransfer(((MapleCharacter)serializable2).getId());
        MapleClient mapleClient4 = a3;
        Serializable serializable5 = serializable2;
        a3.setPlayer((MapleCharacter)serializable2);
        a3.setAccID(((MapleCharacter)serializable5).getAccountID());
        mapleClient4.setWorld(((MapleCharacter)serializable5).getWorld());
        mapleClient4.loadAccountData(((MapleCharacter)serializable2).getAccountID());
        World.removeClientCsTransfer(mapleClient4.getAccountName());
        if (bl) {
            MapleClient mapleClient5 = a3;
            mapleClient5.sendPacket(MTSCSPacket.startMTS((MapleCharacter)serializable2, mapleClient5));
            MTSOperation.MTSUpdate(MTSStorage.getInstance().getCart(a3.getPlayer().getId()), a3);
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleClient mapleClient6 = a3;
            mapleClient6.sendPacket(MTSCSPacket.warpCS(a3));
            mapleClient6.sendPacket(MTSCSPacket.intoCs(mapleClient6, a4));
        } else {
            MapleClient mapleClient7 = a3;
            mapleClient7.sendPacket(MTSCSPacket.warpCS(mapleClient7, a4));
        }
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            MapleClient mapleClient8 = a3;
            mapleClient8.sendPacket(MTSCSPacket.showCashShopAcc(mapleClient8));
        }
        CashShopOperation.sendCashShopUpdate(a3);
    }

    public static /* synthetic */ void sendGift(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        Object object = littleEndianAccessor.readMapleAsciiString();
        LittleEndianAccessor littleEndianAccessor2 = a2;
        CashModItem cashModItem = CashItemFactory.getInstance().getModItem(littleEndianAccessor2.readInt());
        String string = littleEndianAccessor.readMapleAsciiString();
        String string2 = littleEndianAccessor2.readMapleAsciiString();
        if (cashModItem == null || a3.getPlayer().getCSPoints(1) < cashModItem.getPrice() || string2.length() > 73 || string2.length() < 1) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MTSCSPacket.sendCSFail(0));
            CashShopOperation.ALLATORIxDEMO(mapleClient);
            return;
        }
        if (GameSetConstants.CS_STATE_CHECK && a3.getLoginState() != 5) {
            FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("xBs^;euN\u007f\u0002\u5552\u57e3;\u9773\u5552\u57e3\u72d4\u6166\u64d9\u4f71\u5552\u57e3:YlY"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6: " + a3.getPlayer().getName() + " \u52d5\u4f5c: sendgift");
            return;
        }
        Pair<Integer, Pair<Integer, Integer>> pair = MapleCharacterUtil.getInfoByName(string, a3.getPlayer().getWorld());
        if (pair == null || pair.getLeft() <= 0 || pair.getLeft().intValue() == a3.getPlayer().getId() || pair.getRight().getLeft().intValue() == a3.getAccID()) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MTSCSPacket.sendCSFail(162));
            CashShopOperation.ALLATORIxDEMO(mapleClient);
            return;
        }
        MapleClient mapleClient = a3;
        if (!cashModItem.genderEquals(pair.getRight().getRight())) {
            mapleClient.sendPacket(MTSCSPacket.sendCSFail(176));
            CashShopOperation.ALLATORIxDEMO(a3);
            return;
        }
        if (!mapleClient.check2ndPassword((String)object)) {
            MapleClient mapleClient2 = a3;
            mapleClient2.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u7b76\u4ea8\u7d1e\u5be2\u78e6\u930b\u8afe\u0005"));
            CashShopOperation.ALLATORIxDEMO(mapleClient2);
            return;
        }
        if (!cashModItem.isOnSale()) {
            MapleClient mapleClient3 = a3;
            mapleClient3.sendPacket(MTSCSPacket.sendCSFail(225));
            CashShopOperation.ALLATORIxDEMO(mapleClient3);
            return;
        }
        if (World.Find.findChr(pair.getLeft()) != null && World.Find.findChr(pair.getLeft()).getCashInventory().getItemsSize() >= 99) {
            MapleClient mapleClient4 = a3;
            mapleClient4.getPlayer().dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u5c19\u6594\u5552\u57e3\u9047\u515a\u905a\u5937"));
            CashShopOperation.ALLATORIxDEMO(mapleClient4);
            return;
        }
        if (MapleCharacterUtil.getGiftAmount(pair.getLeft()) >= 99) {
            MapleClient mapleClient5 = a3;
            mapleClient5.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u5c57\u659d\u551c\u57ea\u9009\u5153\u9014\u593e"));
            CashShopOperation.ALLATORIxDEMO(mapleClient5);
            return;
        }
        a3.getPlayer().getCashInventory().gift(pair.getLeft(), a3.getPlayer().getName(), string2, cashModItem.getSN(), MapleInventoryIdentifier.getInstance());
        MapleClient mapleClient6 = a3;
        mapleClient6.getPlayer().modifyCSPoints(1, -cashModItem.getPrice(), false);
        mapleClient6.sendPacket(MTSCSPacket.sendGift(string, cashModItem, cashModItem.getPrice() / 2, false));
        mapleClient6.getPlayer().sendNote(string, a3.getPlayer().getName() + " \u9001\u4e86\u4f60\u79ae\u7269! \u8d95\u5feb\u53bb\u5546\u57ce\u78ba\u8a8d\u770b\u770b.", 0);
        object = a3.getChannelServer().getPlayerStorage().getCharacterByName(string);
        if (object != null) {
            ((MapleCharacter)object).showNote();
        }
        if (ServerConfig.LOG_CSBUY) {
            FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("xBs^;iuYu\u0002\u5552\u57e3\u9015\u7983:YlY"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a3.getSession().remoteAddress().toString().split(Event_PyramidSubway.ALLATORIxDEMO("\u001e"))[0] + " \u5e33\u865f: " + a3.getAccountName() + " \u73a9\u5bb6: " + a3.getPlayer().getName() + " \u4f7f\u7528\u4e86\u9ede\u5238" + cashModItem.getPrice() + "\u9ede \u8d08\u9001\u4e86" + cashModItem.getId() + "x" + cashModItem.getCount() + " \u7d66" + string);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void BuyCashItem(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block162: {
            block161: {
                block163: {
                    block164: {
                        var3_3 = a.readByteAsInt();
                        var4_4 = null;
                        var4_4 = CashItemFactory.getInstance();
                        var5_5 = BuyCashShopType.getCashShopOperationType(var3_3);
                        if (GameSetConstants.CS_STATE_CHECK && a.getLoginState() != 5) {
                            FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("xBs^;euN\u007f\u0002\u5552\u57e3;\u9773\u5552\u57e3\u72d4\u6166\u64d9\u4f71\u5552\u57e3:YlY"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6: " + a.getPlayer().getName() + " LoginState:" + a.getLoginState());
                            return;
                        }
                        if (var5_5 == null) {
                            CashShopOperation.ALLATORIxDEMO(a);
                            return;
                        }
                        switch (1.ALLATORIxDEMO[var5_5.ordinal()]) {
                            case 1: 
                            case 2: {
                                v0 = a;
                                var5_6 = v0.readByte() + 1;
                                var6_13 = v0.readInt();
                                v1 = var4_4;
                                var7_29 = v1.getSimpleItem(var6_13);
                                var8_43 = v1.getModItem(var6_13);
                                var9_52 = null;
                                if (var3_3 == 30 && var7_29 != null) {
                                    var9_52 = CashItemFactory.getInstance().getPackageItems(var7_29.getId());
                                }
                                var10_61 = true;
                                var11_67 = 0;
                                if (var7_29 == null && var8_43 == null || var3_3 == 30 && (var9_52 == null || var9_52 != null && var9_52.isEmpty() != false) || var5_6 < 1 || var5_6 > 2) {
                                    v2 = var10_61 = false;
                                } else if (var8_43 == null || !var8_43.isOnSale()) {
                                    var10_61 = false;
                                    var11_67 = 225;
                                    v2 = var10_61;
                                } else if (a.getCSPoints(var5_6) < var8_43.getPrice()) {
                                    var11_67 = var5_6 == 1 ? 168 : 225;
                                    v2 = var10_61 = false;
                                } else if (!var8_43.genderEquals(a.getPlayer().getGender())) {
                                    var10_61 = false;
                                    var11_67 = 186;
                                    v2 = var10_61;
                                } else if (a.getPlayer().getCashInventory().getItemsSize() >= 100) {
                                    var10_61 = false;
                                    var11_67 = 175;
                                    v2 = var10_61;
                                } else {
                                    if (var8_43.getPrice() < 0) {
                                        var10_61 = false;
                                    }
                                    v2 = var10_61;
                                }
                                if (v2 && var8_43 != null) {
                                    var12_72 = GameConstants.cashBlock;
                                    var13_76 = GameConstants.cashBlock.length;
                                    v3 = var14_81 = 0;
                                    break;
                                }
                                a.sendPacket(MTSCSPacket.sendCSFail(var11_67));
lbl56:
                                // 3 sources

                                while (true) {
                                    v4 = a;
lbl58:
                                    // 2 sources

                                    while (true) {
                                        CashShopOperation.ALLATORIxDEMO(v4);
                                        return;
                                    }
                                    break;
                                }
                            }
                            case 3: {
                                v5 = a;
                                var5_5 = v5.readMapleAsciiString();
                                var6_14 = v5.readInt();
                                var7_30 = v5.readMapleAsciiString();
                                var8_44 = v5.readMapleAsciiString();
                                var9_53 = true;
                                var10_62 = 0;
                                var11_68 = var4_4.getModItem(var6_14);
                                var12_73 = MapleCharacterUtil.getInfoByName(var7_30, a.getPlayer().getWorld());
                                if (var11_68 == null) {
                                    v6 = var9_53 = false;
                                } else if (!var11_68.isOnSale()) {
                                    var9_53 = false;
                                    var10_62 = 225;
                                    v6 = var9_53;
                                } else if (a.getCSPoints(1) < var11_68.getPrice()) {
                                    var10_62 = 168;
                                    v6 = var9_53 = false;
                                } else if (!a.check2ndPassword((String)var5_5)) {
                                    var9_53 = false;
                                    var10_62 = 197;
                                    v6 = var9_53;
                                } else if (var8_44.getBytes().length < 1 || var8_44.getBytes().length > 74) {
                                    var9_53 = false;
                                    var10_62 = 225;
                                    v6 = var9_53;
                                } else if (var12_73 == null) {
                                    var9_53 = false;
                                    var10_62 = 172;
                                    v6 = var9_53;
                                } else if (var12_73.getRight().getLeft().intValue() == a.getAccID() || var12_73.getLeft().intValue() == a.getPlayer().getId()) {
                                    var9_53 = false;
                                    var10_62 = 171;
                                    v6 = var9_53;
                                } else {
                                    if (!var11_68.genderEquals(var12_73.getRight().getRight())) {
                                        var9_53 = false;
                                        var10_62 = 176;
                                    }
                                    v6 = var9_53;
                                }
                                if (!v6 || var12_73 == null || var11_68 == null) ** GOTO lbl112
                                var13_78 = GameConstants.cashBlock;
                                var14_83 = GameConstants.cashBlock.length;
                                v7 = var15_89 = 0;
                                break block161;
lbl112:
                                // 1 sources

                                a.sendPacket(MTSCSPacket.sendCSFail(var10_62));
lbl113:
                                // 3 sources

                                while (true) {
                                    CashShopOperation.ALLATORIxDEMO(a);
                                    return;
                                }
                            }
                            case 4: {
                                a.clearWishlist();
                                if (a.available() < 40L) {
                                    v8 = a;
                                    v8.sendPacket(MTSCSPacket.sendCSFail(0));
                                    CashShopOperation.ALLATORIxDEMO(v8);
                                    return;
                                }
                            }
                            var5_5 = new int[10];
                            v9 = var6_15 = 0;
                            while (v9 < 10) {
                                var5_5[var6_15++] = a.readInt();
                                v9 = var6_15;
                            }
                            if (a.getPlayer().isGM() && var5_5[0] != false) {
                                var6_16 = var4_4.getModItem((int)var5_5[0]);
                                CashShopOperation.deleteCashshopItem(LittleEndianAccessor.ALLATORIxDEMO("wLgEgE{]KD`Hy^"), (int)var5_5[0]);
                                a.dropMessage(1, "\u60a8\u5df2\u7d93\u79fb\u9664\u6b64\u5546\u57ce\u7269\u54c1 SN:" + (int)var5_5[0]);
                                a.setWishlist(new int[10]);
                                FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("6K=Wuc\u0017{\u0016k\u001d\u000b\u001di\u5270\u9640\u551c\u57ea\u7233\u54e5tP\"P"), FileoutputUtil.NowTime() + "\u89d2\u8272\u540d\u7a31:" + a.getPlayer().getName() + "\u3000\u7269\u54c1ID: " + var6_16.getId());
                                v10 = a;
                                v10.sendPacket(MTSCSPacket.setWishList(a));
                                CashShopOperation.ALLATORIxDEMO(v10);
                                return;
                            }
                            a.setWishlist((int[])var5_5);
                            v11 = a;
                            v11.sendPacket(MTSCSPacket.setWishList(a));
                            CashShopOperation.ALLATORIxDEMO(v11);
                            return;
                            case 5: {
                                v12 = a;
                                var5_7 = v12.readByte() + 1;
                                v13 = var6_17 = v12.readByte() > 0;
                                if (!var6_17) ** GOTO lbl175
                                var7_31 = CashShopOperation.ALLATORIxDEMO(a.readInt());
                                if (a.getCSPoints(var5_7) >= 100 && a.getInventory(var7_31).getSlotLimit() < 89) {
                                    if (!GameSetConstants.FreeSlot) {
                                        a.modifyCSPoints(var5_7, -100, false);
                                    }
                                    v14 = a;
                                    v14.getInventory(var7_31).addSlot((byte)8);
                                    v14.setchanged_slotlimit();
                                    a.dropMessage(1, "\u6b04\u4f4d\u5df2\u7d93\u64f4\u5145\u5230 " + a.getInventory(var7_31).getSlotLimit());
                                    if (ServerConfig.LOG_CSBUY) {
                                        v15 = LittleEndianAccessor.ALLATORIxDEMO("xBs^;iuYu\u0002\u5552\u57e3\u64e0\u5168:YlY");
                                        v16 = FileoutputUtil.NowTime();
                                        v17 = a.getSession().remoteAddress().toString().split(Event_PyramidSubway.ALLATORIxDEMO("\u001e"))[0];
                                        v18 = a.getAccountName();
                                        v19 = a.getPlayer().getName();
                                        if (var5_7 == 1) {
                                            v20 = LittleEndianAccessor.ALLATORIxDEMO("\u9eca\u5215");
                                            v21 = var7_31;
                                        } else {
                                            v20 = Event_PyramidSubway.ALLATORIxDEMO("\u6909\u846d\u9e84\u655c");
                                            v21 = var7_31;
                                        }
                                        FileoutputUtil.logToFile(v15, "\r\n " + v16 + " IP: " + v17 + " \u5e33\u865f: " + v18 + " \u73a9\u5bb6: " + v19 + " \u4f7f\u7528\u4e86" + v20 + "100\u9ede \u4f86\u8cfc\u8cb7\u64f4\u5145\u6b04\u4f4d" + v21.name() + "8\u683c \u76ee\u524d\u5171\u6709" + a.getInventory(var7_31).getSlotLimit() + "\u683c");
                                    }
                                } else {
                                    a.sendPacket(MTSCSPacket.sendCSFail(164));
                                }
                                ** GOTO lbl199
lbl175:
                                // 1 sources

                                var7_32 = MapleInventoryType.getByType(a.readByte());
                                if (a.getCSPoints(var5_7) < 100 || a.getInventory(var7_32).getSlotLimit() >= 93) ** GOTO lbl198
                                if (!GameSetConstants.FreeSlot) {
                                    a.modifyCSPoints(var5_7, -100, false);
                                }
                                v22 = a;
                                v22.getInventory(var7_32).addSlot((byte)4);
                                v22.setchanged_slotlimit();
                                a.dropMessage(1, "\u6b04\u4f4d\u5df2\u7d93\u64f4\u5145\u5230 " + a.getInventory(var7_32).getSlotLimit());
                                if (!ServerConfig.LOG_CSBUY) ** GOTO lbl199
                                v23 = LittleEndianAccessor.ALLATORIxDEMO("xBs^;iuYu\u0002\u5552\u57e3\u64e0\u5168:YlY");
                                v24 = FileoutputUtil.NowTime();
                                v25 = a.getSession().remoteAddress().toString().split(Event_PyramidSubway.ALLATORIxDEMO("\u001e"))[0];
                                v26 = a.getAccountName();
                                v27 = a.getPlayer().getName();
                                if (var5_7 == 1) {
                                    v28 = LittleEndianAccessor.ALLATORIxDEMO("\u9eca\u5215");
                                    v29 = var7_32;
                                } else {
                                    v28 = Event_PyramidSubway.ALLATORIxDEMO("\u6909\u846d\u9e84\u655c");
                                    v29 = var7_32;
                                }
                                FileoutputUtil.logToFile(v23, "\r\n " + v24 + " IP: " + v25 + " \u5e33\u865f: " + v26 + " \u73a9\u5bb6: " + v27 + " \u4f7f\u7528\u4e86" + v28 + "100\u9ede \u4f86\u8cfc\u8cb7\u64f4\u5145\u6b04\u4f4d" + v29.name() + "4\u683c \u76ee\u524d\u5171\u6709" + a.getInventory(var7_32).getSlotLimit() + "\u683c");
                                v30 = a;
                                ** GOTO lbl200
lbl198:
                                // 1 sources

                                a.sendPacket(MTSCSPacket.sendCSFail(164));
lbl199:
                                // 4 sources

                                v30 = a;
lbl200:
                                // 2 sources

                                CashShopOperation.ALLATORIxDEMO(v30);
                                return;
                            }
                            case 6: {
                                var5_8 = a.readByte() + 1;
                                if (a.getCSPoints(var5_8) < 100 || a.getStorage().getSlots() >= 45) ** GOTO lbl226
                                if (!GameSetConstants.FreeSlot) {
                                    a.modifyCSPoints(var5_8, -100, false);
                                }
                                v31 = a;
                                v31.getStorage().increaseSlots((byte)4);
                                v31.getStorage().saveToDB();
                                a.dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u501d\u5e86\u6b10\u4f60\u5de6\u7dbe\u64e0\u5168 \u6811"));
                                if (!ServerConfig.LOG_CSBUY) ** GOTO lbl227
                                v32 = Event_PyramidSubway.ALLATORIxDEMO("6K=Wu`;P;\u000b\u551c\u57ea\u64ae\u5161tP\"P");
                                v33 = FileoutputUtil.NowTime();
                                v34 = a.getSession().remoteAddress().toString().split(LittleEndianAccessor.ALLATORIxDEMO("\u0017"))[0];
                                v35 = a.getAccountName();
                                v36 = a.getPlayer().getName();
                                if (var5_8 == 1) {
                                    v37 = Event_PyramidSubway.ALLATORIxDEMO("\u9e84\u521c");
                                    v38 = a;
                                } else {
                                    v37 = LittleEndianAccessor.ALLATORIxDEMO("\u6947\u8464\u9eca\u6555");
                                    v38 = a;
                                }
                                FileoutputUtil.logToFile(v32, "\r\n " + v33 + " IP: " + v34 + " \u5e33\u865f: " + v35 + " \u73a9\u5bb6: " + v36 + " \u4f7f\u7528\u4e86" + v37 + "100\u9ede \u4f86\u8cfc\u8cb7\u64f4\u5145\u6b04\u4f4d\u5009\u5eab4\u683c \u76ee\u524d\u5171\u6709" + v38.getStorage().getSlots() + "\u683c");
                                v39 = a;
                                ** GOTO lbl228
lbl226:
                                // 1 sources

                                a.sendPacket(MTSCSPacket.sendCSFail(164));
lbl227:
                                // 2 sources

                                v39 = a;
lbl228:
                                // 2 sources

                                CashShopOperation.ALLATORIxDEMO(v39);
                                return;
                            }
                            case 7: {
                                var5_9 = a.readByte() + 1;
                                var6_18 = var4_4.getModItem(a.readInt());
                                var7_33 = a.getCharacterSlots();
                                if (var6_18 == null || a.getPlayer().getCSPoints(var5_9) < var6_18.getPrice() || var7_33 > 15) {
                                    v40 = a;
                                    v40.sendPacket(MTSCSPacket.sendCSFail(0));
                                    CashShopOperation.ALLATORIxDEMO(v40);
                                    return;
                                }
                                if (!GameSetConstants.FreeSlot) {
                                    a.modifyCSPoints(var5_9, -180, false);
                                }
                                if (!a.gainCharacterSlot()) ** GOTO lbl258
                                a.dropMessage(1, "\u6b04\u4f4d\u5df2\u7d93\u64f4\u5145\u5230 " + a.getCharacterSlots());
                                if (!ServerConfig.LOG_CSBUY) ** GOTO lbl259
                                v41 = Event_PyramidSubway.ALLATORIxDEMO("6K=Wu`;P;\u000b\u551c\u57ea\u64ae\u5161tP\"P");
                                v42 = FileoutputUtil.NowTime();
                                v43 = a.getSession().remoteAddress().toString().split(LittleEndianAccessor.ALLATORIxDEMO("\u0017"))[0];
                                v44 = a.getAccountName();
                                v45 = a.getPlayer().getName();
                                if (var5_9 == 1) {
                                    v46 = Event_PyramidSubway.ALLATORIxDEMO("\u9e84\u521c");
                                    v47 = var6_18;
                                } else {
                                    v46 = LittleEndianAccessor.ALLATORIxDEMO("\u6947\u8464\u9eca\u6555");
                                    v47 = var6_18;
                                }
                                FileoutputUtil.logToFile(v41, "\r\n " + v42 + " IP: " + v43 + " \u5e33\u865f: " + v44 + " \u73a9\u5bb6: " + v45 + " \u4f7f\u7528\u4e86" + v46 + v47.getPrice() + "\u9ede \u4f86\u8cfc\u8cb7\u64f4\u5145\u89d2\u8272\u6b04\u4f4d \u76ee\u524d\u5171\u6709" + a.getCharacterSlots() + "\u683c");
                                v48 = a;
                                ** GOTO lbl260
lbl258:
                                // 1 sources

                                a.sendPacket(MTSCSPacket.sendCSFail(0));
lbl259:
                                // 2 sources

                                v48 = a;
lbl260:
                                // 2 sources

                                CashShopOperation.ALLATORIxDEMO(v48);
                                return;
                            }
                            case 8: {
                                var5_5 = a.getPlayer().getCashInventory().findByCashId((int)a.readLong());
                                if (var5_5 != null && var5_5.getQuantity() > 0 && MapleInventoryManipulator.checkSpace(a, var5_5.getItemId(), var5_5.getQuantity(), var5_5.getOwner())) {
                                    var6_19 = var5_5.copy();
                                    var7_34 = MapleInventoryManipulator.addbyItem(a, var6_19, true);
                                    if (var7_34 >= 0) {
                                        if (var6_19.getPet() != null) {
                                            var6_19.getPet().setInventoryPosition(var7_34);
                                            a.getPlayer().addPet(var6_19.getPet());
                                        }
                                        a.getPlayer().getCashInventory().removeFromInventory((IItem)var5_5);
                                        a.sendPacket(MTSCSPacket.confirmFromCSInventory(var6_19, var7_34));
                                    } else {
                                        a.sendPacket(MTSCSPacket.sendCSFail(177));
                                    }
                                } else {
                                    a.sendPacket(MTSCSPacket.sendCSFail(177));
                                }
                                CashShopOperation.ALLATORIxDEMO(a);
                                return;
                            }
                            case 9: {
                                v49 = a;
                                var5_10 = (int)v49.readLong();
                                var6_20 = MapleInventoryType.getByType(v49.readByte());
                                var7_35 = a.getPlayer().getInventory(var6_20).findByUniqueId(var5_10);
                                if (var7_35 == null) {
                                    a.dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u7554\u5e62\u0005"));
                                    CashShopOperation.ALLATORIxDEMO(a);
                                    return;
                                }
                                if (GameSetConstants.isInvToCSBan(var7_35.getItemId())) {
                                    a.dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u8a66\u907e\u5163\u710c\u6cc1\u79d6\u52c1\f"));
                                    CashShopOperation.ALLATORIxDEMO(a);
                                    return;
                                }
                                if (var7_35 != null && var7_35.getQuantity() > 0 && var7_35.getUniqueId() > 0 && a.getPlayer().getCashInventory().getItemsSize() < 100) {
                                    var8_45 = var7_35.copy();
                                    a.getPlayer().getInventory(var6_20).removeItem(a.getPlayer(), var7_35.getPosition(), var7_35.getQuantity(), false);
                                    v50 = var8_45;
                                    var9_54 = CashItemFactory.getInstance().getItemSN(v50.getItemId());
                                    if (v50.getPet() != null) {
                                        a.getPlayer().removePet(var8_45.getPet());
                                    }
                                    v51 = var8_45;
                                    v51.setPosition((short)0);
                                    v51.setGMLog("\u8cfc\u7269\u5546\u57ce\u8cfc\u8cb7 \u6642\u9593: " + FileoutputUtil.CurrentReadable_Time());
                                    v52 = a;
                                    v53 = v52;
                                    a.getPlayer().getCashInventory().addToInventory(var8_45);
                                    v52.sendPacket(MTSCSPacket.confirmToCSInventory(var7_35, v52.getAccID(), var9_54));
                                } else {
                                    v54 = a;
                                    v53 = v54;
                                    v54.sendPacket(MTSCSPacket.sendCSFail(177));
                                }
                                CashShopOperation.ALLATORIxDEMO(v53);
                                return;
                            }
                            case 10: {
                                v55 = a;
                                var5_5 = v55.readMapleAsciiString();
                                var6_21 = (int)v55.readLong();
                                var7_36 = a.getPlayer().getCashInventory().findByCashId(var6_21);
                                if (var7_36 == null || !GameConstants.isEquip(var7_36.getItemId()) || var7_36.getExpiration() != -1L) {
                                    v56 = a;
                                    v56.sendPacket(MTSCSPacket.sendCSFail(0));
                                    CashShopOperation.ALLATORIxDEMO(v56);
                                    return;
                                }
                                if (!a.check2ndPassword((String)var5_5)) {
                                    if (GameSetConstants.MAPLE_VERSION == 113) {
                                        v57 = a;
                                        v58 = v57;
                                        v57.sendPacket(MTSCSPacket.sendCSFail(197));
                                    } else {
                                        a.dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u7b76\u4ea8\u7d1e\u5be2\u78e6\u930b\u8afe\u0005"));
                                        v58 = a;
                                    }
                                    CashShopOperation.ALLATORIxDEMO(v58);
                                    return;
                                }
                                v59 = var4_4;
                                var8_46 = v59.getItemSN(var7_36.getItemId());
                                var9_55 = v59.getSimpleItem(var8_46);
                                var10_63 = v59.getModItem(var8_46);
                                if (var9_55 == null) {
                                    v60 = a;
                                    v60.sendPacket(MTSCSPacket.sendCSFail(0));
                                    CashShopOperation.ALLATORIxDEMO(v60);
                                    return;
                                }
                                if (GameSetConstants.SellCashItem_BAN) {
                                    a.dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u6b70\u52b2\u80e9\u6707\u959f\u65138 \u001e\u82c8\u671d\u75bc\u617a\u8ae6\u807b\u7d4c\u7bb5\u742b\u54f5\u302f"));
                                    CashShopOperation.ALLATORIxDEMO(a);
                                    return;
                                }
                                a.getPlayer().modifyCSPoints(2, (int)Math.round((double)(var10_63 == null ? var9_55.getPrice() : var10_63.getPrice()) * 0.3), false);
                                v61 = a;
                                v61.getPlayer().getCashInventory().removeFromInventory(var7_36);
                                CashShopOperation.ALLATORIxDEMO(v61);
                                return;
                            }
                            case 11: {
                                v62 = a;
                                var5_5 = v62.readMapleAsciiString();
                                var6_22 = v62.readInt();
                                var7_37 = v62.readMapleAsciiString();
                                var8_47 = v62.readMapleAsciiString();
                                var9_56 = var4_4.getSimpleItem(var6_22);
                                var10_64 = a.getCashInventory().toItem(var9_56);
                                var11_69 = MapleCharacterUtil.getInfoByName(var7_37, a.getPlayer().getWorld());
                                if (a.getSecondPassword() != null) {
                                    if (var5_5 == null) {
                                        v63 = a;
                                        v63.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u8a91\u8f1c\u513f\u5be2\u78e6\u3026"));
                                        CashShopOperation.ALLATORIxDEMO(v63);
                                        return;
                                    }
                                    if (!a.check2ndPassword((String)var5_5)) {
                                        v64 = a;
                                        v64.getPlayer().dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u5beb\u78a8\u9302\u8ab0\u302f"));
                                        CashShopOperation.ALLATORIxDEMO(v64);
                                        return;
                                    }
                                    if (var11_69 == null || var11_69.getLeft() <= 0 || var11_69.getLeft().intValue() == a.getPlayer().getId() || var11_69.getRight().getLeft().intValue() == a.getAccID()) {
                                        v65 = a;
                                        v65.sendPacket(MTSCSPacket.sendCSFail(162));
                                        CashShopOperation.ALLATORIxDEMO(v65);
                                        return;
                                    }
                                    if (!var9_56.genderEquals(var11_69.getRight().getRight())) {
                                        v66 = a;
                                        v66.sendPacket(MTSCSPacket.sendCSFail(163));
                                        CashShopOperation.ALLATORIxDEMO(v66);
                                        return;
                                    }
                                    var12_74 = GameConstants.cashBlock;
                                    var13_79 = GameConstants.cashBlock.length;
                                    v67 = var14_84 = 0;
                                    while (v67 < var13_79) {
                                        var15_90 = var12_74[var14_84];
                                        if (var9_56.getId() == var15_90) {
                                            v68 = a;
                                            v68.getPlayer().dropMessage(1, GameConstants.getCashBlockedMsg(var9_56.getId()));
                                            CashShopOperation.ALLATORIxDEMO(v68);
                                            return;
                                        }
                                        v67 = ++var14_84;
                                    }
                                    a.getPlayer().getCashInventory().gift(var11_69.getLeft(), a.getPlayer().getName(), var8_47, var9_56.getSN(), MapleInventoryIdentifier.getInstance());
                                    v69 = var7_37;
                                    v70 = a;
                                    v70.getPlayer().modifyCSPoints(1, -var9_56.getPrice(), false);
                                    v70.sendPacket(MTSCSPacket.sendGift(v69, var9_56, var9_56.getPrice() / 2, false));
                                    v71 = a;
                                    v71.sendNote(v69, v71.getName() + " \u9001\u4e86\u4f60\u79ae\u7269! \u8d95\u5feb\u53bb\u5546\u57ce\u78ba\u8a8d\u770b\u770b.", 0);
                                    v72 = a.getChannelServer().getPlayerStorage().getCharacterByName(var7_37);
                                    var12_74 = v72;
                                    if (v72 != null) {
                                        var12_74.showNote();
                                    }
                                }
                                CashShopOperation.ALLATORIxDEMO(a);
                                return;
                            }
                            case 12: {
                                var5_5 = var4_4.getModItem(a.readInt());
                                if (var5_5 == null || !MapleItemInformationProvider.getInstance().isQuestItem(var5_5.getId())) {
                                    v73 = a;
                                    v73.sendPacket(MTSCSPacket.sendCSFail(0));
                                    CashShopOperation.ALLATORIxDEMO(v73);
                                    return;
                                }
                                if (a.getPlayer().getMeso() < var5_5.getPrice()) {
                                    v74 = a;
                                    v74.sendPacket(MTSCSPacket.sendCSFail(184));
                                    CashShopOperation.ALLATORIxDEMO(v74);
                                    return;
                                }
                                if (a.getPlayer().getInventory(GameConstants.getInventoryType(var5_5.getId())).getNextFreeSlot() < 0) {
                                    v75 = a;
                                    v75.sendPacket(MTSCSPacket.sendCSFail(177));
                                    CashShopOperation.ALLATORIxDEMO(v75);
                                    return;
                                }
                                var6_23 = GameConstants.cashBlock;
                                var7_38 = GameConstants.cashBlock.length;
                                v76 = var8_48 = 0;
                                while (v76 < var7_38) {
                                    var9_57 = var6_23[var8_48];
                                    if (var5_5.getId() == var9_57) {
                                        v77 = a;
                                        v77.getPlayer().dropMessage(1, GameConstants.getCashBlockedMsg(var5_5.getId()));
                                        CashShopOperation.ALLATORIxDEMO(v77);
                                        return;
                                    }
                                    v76 = ++var8_48;
                                }
                                var6_24 = MapleInventoryManipulator.addId(a, var5_5.getId(), (short)var5_5.getCount(), null);
                                if (var6_24 < 0) {
                                    v78 = a;
                                    v78.sendPacket(MTSCSPacket.sendCSFail(177));
                                    CashShopOperation.ALLATORIxDEMO(v78);
                                    return;
                                }
                                a.gainMeso(-var5_5.getPrice(), false);
                                v79 = a;
                                v79.sendPacket(MTSCSPacket.showBoughtCSQuestItem(var5_5.getPrice(), (short)var5_5.getCount(), var6_24, var5_5.getId()));
                                CashShopOperation.ALLATORIxDEMO(v79);
                                return;
                            }
                            case 13: 
                            case 14: {
                                v80 = a;
                                var5_5 = v80.readMapleAsciiString();
                                var6_25 = v80.readInt();
                                var7_39 = v80.readMapleAsciiString();
                                var8_49 = v80.readMapleAsciiString();
                                v81 = var4_4;
                                var9_58 = v81.getModItem(var6_25);
                                var10_65 = v81.getModItem(var6_25);
                                var11_70 = MapleCharacterUtil.getInfoByName(var7_39, a.getPlayer().getWorld());
                                var12_75 = true;
                                var13_80 = 0;
                                if (var9_58 == null) {
                                    v82 = var12_75 = false;
                                } else if (!var9_58.isOnSale()) {
                                    var12_75 = false;
                                    var13_80 = 225;
                                    v82 = var12_75;
                                } else if (a.getCSPoints(1) < var9_58.getPrice()) {
                                    var13_80 = 168;
                                    v82 = var12_75 = false;
                                } else if (!a.check2ndPassword((String)var5_5)) {
                                    var12_75 = false;
                                    var13_80 = 197;
                                    v82 = var12_75;
                                } else if (var8_49.getBytes().length < 1 || var8_49.getBytes().length > 74) {
                                    var12_75 = false;
                                    var13_80 = 225;
                                    v82 = var12_75;
                                } else if (var11_70 == null) {
                                    var12_75 = false;
                                    var13_80 = 172;
                                    v82 = var12_75;
                                } else if (var11_70.getRight().getLeft().intValue() == a.getAccID() || var11_70.getLeft().intValue() == a.getPlayer().getId()) {
                                    var12_75 = false;
                                    var13_80 = 171;
                                    v82 = var12_75;
                                } else if (!var9_58.genderEquals(var11_70.getRight().getRight())) {
                                    var12_75 = false;
                                    var13_80 = 176;
                                    v82 = var12_75;
                                } else if (!GameConstants.isEffectRing(var9_58.getId())) {
                                    var12_75 = false;
                                    var13_80 = 0;
                                    v82 = var12_75;
                                } else {
                                    if (!GameSetConstants.HOMOSEX && var11_70.getRight().getRight().intValue() == a.getPlayer().getGender() && var3_3 == 29) {
                                        var12_75 = false;
                                        var13_80 = 191;
                                    }
                                    v82 = var12_75;
                                }
                                if (!v82 || var11_70 == null || var9_58 == null) ** GOTO lbl508
                                var14_85 = GameConstants.cashBlock;
                                var15_91 = GameConstants.cashBlock.length;
                                v83 = var16_95 = 0;
                                break block162;
lbl508:
                                // 1 sources

                                a.sendPacket(MTSCSPacket.sendCSFail(var13_80));
lbl509:
                                // 3 sources

                                while (true) {
                                    CashShopOperation.ALLATORIxDEMO(a);
                                    return;
                                }
                            }
                            case 15: {
                                CashShopOperation.ALLATORIxDEMO(a);
                                return;
                            }
                            case 16: {
                                if (GameSetConstants.MAPLE_VERSION >= 149) {
                                    a.readByte();
                                }
                                if ((var5_5 = var4_4.getModItem(a.readInt())) != null && a.getPlayer().getCSPoints(1) >= var5_5.getPrice()) {
                                    a.dropMessage(1, "\u6210\u529f\u8cfc\u8cb7\u6953\u8449\u9ede\u6578:" + var5_5.getPrice());
                                    v84 = a;
                                    v84.getPlayer().modifyCSPoints(1, -var5_5.getPrice(), false);
                                    v84.getPlayer().modifyCSPoints(2, var5_5.getPrice(), false);
                                    CashShopOperation.ALLATORIxDEMO(v84);
                                    return;
                                }
                                v85 = a;
                                v85.sendPacket(MTSCSPacket.sendCSFail(0));
                                CashShopOperation.ALLATORIxDEMO(v85);
                                return;
                            }
                            case 17: {
                                var5_11 = a.readByte() + 1;
                                var6_26 = CashItemFactory.getInstance().getItem(a.readInt());
                                if (var5_11 > 2 || var5_11 < 1) {
                                    v86 = a;
                                    v86.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u7658\u7545\u670e\u77bf\u76a0\u9375\u8a80"));
                                    CashShopOperation.ALLATORIxDEMO(v86);
                                    return;
                                }
                                if (var6_26 != null && a.getCSPoints(var5_11) >= var6_26.getPrice()) {
                                    if (!var6_26.isOnSale()) {
                                        v87 = a;
                                        v87.getPlayer().dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u76c3\u5259\u5c37\u673e\u95a6\u652a\u62e0\u8cf7\u6b49\u9047\u515a"));
                                        CashShopOperation.ALLATORIxDEMO(v87);
                                        return;
                                    }
                                    if (a.getAnyWhereDoorCash() >= 100) {
                                        a.dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u8aef\u5112\u62ae\u5f6d\u5332\u4ea1\u612b\u95da\u6b05\u6522\u750c\u5bd6\u4e29\u5fcd\u8da1\u9014)P\u0015j\u0014\u6b7b\u3026"));
                                        CashShopOperation.ALLATORIxDEMO(a);
                                        return;
                                    }
                                    v88 = a;
                                    v88.modifyCSPoints(var5_11, -var6_26.getPrice(), false);
                                    var7_40 = v88.getCashInventory().toItem(var6_26, a);
                                    if (var7_40 != null && var7_40.getItemId() == var6_26.getId() && (var7_40.getQuantity() == var6_26.getCount() || var6_26.getCount() == 0)) {
                                        v89 = a;
                                        v89.setAnyWhereDoorCash(v89.getAnyWhereDoorCash() + var7_40.getQuantity());
                                        a.sendPacket(MaplePacketCreator.showAnyWhereDoor(v89.getAnyWhereDoor(), a.getAnyWhereDoorCash()));
                                        a.dropMessage(1, "\u5f37\u5316\u4efb\u610f\u9580\u8cfc\u8cb7\u5b8c\u6210\u76ee\u524d\u5171" + a.getAnyWhereDoorCash() + "\u6b21\u3002");
                                    } else {
                                        a.sendPacket(MTSCSPacket.sendCSFail(0));
                                    }
                                } else {
                                    a.sendPacket(MTSCSPacket.sendCSFail(0));
                                }
                                CashShopOperation.ALLATORIxDEMO(a);
                                return;
                            }
                            case 18: {
                                var5_5 = CashItemFactory.getInstance();
                                var6_27 = a.readInt();
                                var7_41 = a.getPlayer().getCashInventory().findByCashId(var6_27);
                                if (var7_41 != null && var7_41.getItemId() / 1000 == 5533) {
                                    if (a.getPlayer().getCashInventory().getItemsSize() >= 100) {
                                        v90 = a;
                                        v90.getPlayer().dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u9047\u515a\u6b10\u4f60\u5de6\u6ed2"));
                                        CashShopOperation.ALLATORIxDEMO(v90);
                                        return;
                                    }
                                    var8_50 = var4_4.getRandomItemInfo();
                                    if (var8_50.containsKey(var7_41.getItemId())) {
                                        v91 = var9_59 = var8_50.get(var7_41.getItemId());
                                        var10_66 = var4_4.getItem(v91.get(Randomizer.nextInt(v91.size())));
                                        var11_71 = a.getCashInventory().toItem(var10_66, a);
                                        if (var11_71 != null && var11_71.getUniqueId() > 0 && var11_71.getItemId() == var10_66.getId() && (var11_71.getQuantity() == var10_66.getCount() || var10_66.getCount() == 0)) {
                                            if (var11_71.getQuantity() <= 0) {
                                                var11_71.setQuantity((short)1);
                                            }
                                            var11_71.setGMLog("\u5f9e\u96a8\u6a5f\u7bb1\u5b50<" + var10_66.getId() + ">\u7372\u53d6" + var11_71.getItemId() + " \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                                            a.getPlayer().getCashInventory().removeFromInventory(var7_41);
                                            a.getCashInventory().addToInventory(var11_71);
                                        }
                                    }
                                }
                                CashShopOperation.ALLATORIxDEMO(a);
                                return;
                            }
                            case 19: {
                                v92 = a;
                                var5_12 = v92.readByte() + 1;
                                var6_28 = v92.readInt();
                                var7_42 = CashItemFactory.getInstance().getItem(var6_28);
                                if (var7_42 == null || a.getPlayer().getCSPoints(var5_12) < var7_42.getPrice() || var7_42.getId() / 10000 != 555) {
                                    v93 = a;
                                    v93.sendPacket(MTSCSPacket.sendCSFail(0));
                                    CashShopOperation.ALLATORIxDEMO(v93);
                                    return;
                                }
                                var8_51 = a.getPlayer().getQuestNoAdd(MapleQuest.getInstance(122700));
                                if (var8_51 != null && var8_51.getCustomData() != null && Long.parseLong(var8_51.getCustomData()) >= System.currentTimeMillis()) {
                                    a.dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u96fd\u58c6\u98da\u6b5e\u4f69\u6618\u95b7\u5c40\u670e\u526a\u673b\u64ae\u5161\u596b\u6573"));
                                    CashShopOperation.ALLATORIxDEMO(a);
                                    return;
                                }
                                var9_60 = 0L;
                                if (var7_42.getId() == 5550000) {
                                    var9_60 = 30L;
                                    v94 = a;
                                } else {
                                    if (var7_42.getId() == 5550001) {
                                        var9_60 = 7L;
                                    }
                                    v94 = a;
                                }
                                v94.getPlayer().getQuestNAdd(MapleQuest.getInstance(122700)).setCustomData(String.valueOf(System.currentTimeMillis() + var9_60 * 24L * 60L * 60L * 1000L));
                                a.getPlayer().modifyCSPoints(var5_12, -var7_42.getPrice(), false);
                                a.dropMessage(1, LittleEndianAccessor.ALLATORIxDEMO("\u96f4\u5888\u98d3\u6b10\u4f60\u5de6\u58b3\u52b4\u0003"));
                                return;
                            }
                            default: {
                                v95 = a;
                                v95.sendPacket(MTSCSPacket.sendCSFail(0));
                                CashShopOperation.ALLATORIxDEMO(v95);
                                return;
                            }
                        }
                        while (v3 < var13_76) {
                            var15_87 = var12_72[var14_81];
                            if (var8_43.getId() == var15_87) {
                                v96 = a;
                                v96.getPlayer().dropMessage(1, GameConstants.getCashBlockedMsg(var8_43.getId()));
                                CashShopOperation.ALLATORIxDEMO(v96);
                                return;
                            }
                            v3 = ++var14_81;
                        }
                        if (var8_43.isGashOnly() && var5_6 == 2) {
                            v97 = a;
                            v97.getPlayer().dropMessage(1, Event_PyramidSubway.ALLATORIxDEMO("\u6b3e\u724d\u549b\u7105\u6c8f\u4f5b\u7572\u6977\u8413\u9efa\u6522\u8cd8\u8ced\u0005"));
                            CashShopOperation.ALLATORIxDEMO(v97);
                            return;
                        }
                        if (var3_3 != 3) break block163;
                        v98 = a;
                        v98.modifyCSPoints(var5_6, -var8_43.getPrice(), false);
                        v99 = v98.getCashInventory().toItem((CashItem)var8_43, a);
                        var12_72 = v99;
                        if (v99 == null || var12_72.getUniqueId() <= 0 || var12_72.getItemId() != var8_43.getId() || var12_72.getQuantity() != var8_43.getCount()) break block164;
                        v100 = var12_72;
                        a.getCashInventory().addToInventory((IItem)v100);
                        v101 = a;
                        v101.sendPacket(MTSCSPacket.showBoughtCashItem((IItem)v100, var8_43.getSN(), v101.getAccID()));
                        if (ServerConfig.LOG_CSBUY) {
                            v102 = LittleEndianAccessor.ALLATORIxDEMO("xBs^;iuYu\u0002\u5552\u57e3\u8ce8\u8c9a:YlY");
                            v103 = FileoutputUtil.NowTime();
                            v104 = a.getSession().remoteAddress().toString().split(Event_PyramidSubway.ALLATORIxDEMO("\u001e"))[0];
                            v105 = a.getAccountName();
                            v106 = a.getPlayer().getName();
                            if (var5_6 == 1) {
                                v107 = LittleEndianAccessor.ALLATORIxDEMO("\u9eca\u5215");
                                v108 = var8_43;
                            } else {
                                v107 = Event_PyramidSubway.ALLATORIxDEMO("\u6909\u846d\u9e84\u655c");
                                v108 = var8_43;
                            }
                            FileoutputUtil.logToFile(v102, "\r\n " + v103 + " IP: " + v104 + " \u5e33\u865f: " + v105 + " \u73a9\u5bb6: " + v106 + " \u4f7f\u7528\u4e86" + v107 + v108.getPrice() + "\u9ede \u4f86\u8cfc\u8cb7" + var8_43.getId() + "x" + var8_43.getCount());
                        }
                        ** GOTO lbl56
                    }
                    a.sendPacket(MTSCSPacket.sendCSFail(var11_67));
                    ** while (true)
                }
                var12_72 = new HashMap<K, V>();
                var13_77 = var9_52.iterator();
                block27: while (true) {
                    v109 = var13_77;
                    while (v109.hasNext()) {
                        var14_82 = var13_77.next();
                        var15_88 = CashItemFactory.getInstance().getSimpleItem(var14_82.getSN());
                        var16_93 = GameConstants.cashBlock;
                        var17_96 = GameConstants.cashBlock.length;
                        v110 = var18_98 = 0;
                        while (v110 < var17_96) {
                            var19_99 = var16_93[var18_98];
                            if (var15_88.getId() == var19_99) {
                                // empty if block
                            }
                            v110 = ++var18_98;
                        }
                        v111 = var15_88;
                        v112 = a.getCashInventory().toItem(v111, a, MapleInventoryManipulator.getUniqueId(v111.getId(), null), "");
                        var16_93 = v112;
                        if (v112 == null || var16_93.getUniqueId() <= 0) continue block27;
                        if (var16_93.getItemId() != var15_88.getId()) {
                            v109 = var13_77;
                            continue;
                        }
                        var12_72.put(var15_88.getSN(), var16_93);
                        a.getPlayer().getCashInventory().addToInventory((IItem)var16_93);
                        v109 = var13_77;
                    }
                    break;
                }
                if (ServerConfig.LOG_CSBUY) {
                    v113 = LittleEndianAccessor.ALLATORIxDEMO("xBs^;iuYu\u0002\u5552\u57e3\u8ce8\u8c9a:YlY");
                    v114 = FileoutputUtil.NowTime();
                    v115 = a.getSession().remoteAddress().toString().split(Event_PyramidSubway.ALLATORIxDEMO("\u001e"))[0];
                    v116 = a.getAccountName();
                    v117 = a.getPlayer().getName();
                    if (var5_6 == 1) {
                        v118 = LittleEndianAccessor.ALLATORIxDEMO("\u9eca\u5215");
                        v119 = var8_43;
                    } else {
                        v118 = Event_PyramidSubway.ALLATORIxDEMO("\u6909\u846d\u9e84\u655c");
                        v119 = var8_43;
                    }
                    FileoutputUtil.logToFile(v113, "\r\n " + v114 + " IP: " + v115 + " \u5e33\u865f: " + v116 + " \u73a9\u5bb6: " + v117 + " \u4f7f\u7528\u4e86" + v118 + v119.getPrice() + "\u9ede \u4f86\u8cfc\u8cb7\u5957\u88dd" + var8_43.getId() + "x" + var8_43.getCount());
                }
                a.modifyCSPoints(var5_6, -var8_43.getPrice(), false);
                v120 = a;
                v4 = v120;
                v120.sendPacket(MTSCSPacket.showBoughtCashPackage((Map<Integer, IItem>)var12_72, v120.getAccID()));
                ** while (true)
            }
            while (v7 < var14_83) {
                var16_94 = var13_78[var15_89];
                if (var11_68.getId() == var16_94) {
                    a.getPlayer().dropMessage(1, GameConstants.getCashBlockedMsg(var11_68.getId()));
                    return;
                }
                v7 = ++var15_89;
            }
            a.getPlayer().getCashInventory().gift(var12_73.getLeft(), a.getPlayer().getName(), var8_44, var11_68.getSN(), MapleInventoryIdentifier.getInstance());
            a.getPlayer().modifyCSPoints(1, -var11_68.getPrice(), false);
            if (ServerConfig.LOG_CSBUY) {
                FileoutputUtil.logToFile(LittleEndianAccessor.ALLATORIxDEMO("xBs^;iuYu\u0002\u5552\u57e3\u9015\u7983:YlY"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a.getSession().remoteAddress().toString().split(Event_PyramidSubway.ALLATORIxDEMO("\u001e"))[0] + " \u5e33\u865f: " + a.getAccountName() + " \u73a9\u5bb6: " + a.getPlayer().getName() + " \u4f7f\u7528\u4e86\u9ede\u5238" + var11_68.getPrice() + "\u9ede \u8d08\u9001\u4e86" + var11_68.getId() + "x" + var11_68.getCount() + " \u7d66" + var7_30);
            }
            v121 = var11_68;
            a.sendPacket(MTSCSPacket.sendGift(var7_30, v121, v121.getPrice() / 2, false));
            v122 = a;
            v122.sendNote(var7_30, v122.getName() + " \u9001\u4e86\u4f60\u79ae\u7269! \u8d95\u5feb\u53bb\u5546\u57ce\u78ba\u8a8d\u770b\u770b.", 0);
            v123 = a.getChannelServer().getPlayerStorage().getCharacterByName(var7_30);
            var13_78 = v123;
            if (v123 == null) ** GOTO lbl113
            var13_78.showNote();
            ** while (true)
        }
        while (v83 < var15_91) {
            var17_97 = var14_85[var16_95];
            if (var9_58.getId() == var17_97) {
                v124 = a;
                v124.getPlayer().dropMessage(1, GameConstants.getCashBlockedMsg(var9_58.getId()));
                CashShopOperation.ALLATORIxDEMO(v124);
                return;
            }
            v83 = ++var16_95;
        }
        var14_86 = MapleRing.createRing(var9_58.getId(), a.getPlayer(), var7_39, var8_49, var11_70.getLeft(), var9_58.getSN());
        if (var14_86 != 1) {
            v125 = a;
            v125.sendPacket(MTSCSPacket.sendCSFail(0));
            CashShopOperation.ALLATORIxDEMO(v125);
            return;
        }
        a.getPlayer().modifyCSPoints(1, -var9_58.getPrice(), false);
        v126 = a;
        v126.sendNote(var7_39, v126.getName() + " \u9001\u4e86\u4f60\u79ae\u7269! \u8d95\u5feb\u53bb\u5546\u57ce\u78ba\u8a8d\u770b\u770b.", 0);
        var15_92 = a.getChannelServer().getPlayerStorage().getCharacterByName(var7_39);
        if (var15_92 != null) {
            var15_92.showNote();
        }
        if (!ServerConfig.LOG_CSBUY) ** GOTO lbl509
        FileoutputUtil.logToFile(Event_PyramidSubway.ALLATORIxDEMO("6K=Wu`;P;\u000b\u551c\u57ea\u905b\u798atP\"P"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a.getSession().remoteAddress().toString().split(LittleEndianAccessor.ALLATORIxDEMO("\u0017"))[0] + " \u5e33\u865f: " + a.getAccountName() + " \u73a9\u5bb6: " + a.getPlayer().getName() + " \u4f7f\u7528\u4e86\u9ede\u5238" + var9_58.getPrice() + "\u9ede \u8d08\u9001\u4e86" + var9_58.getId() + "x" + var9_58.getCount() + " \u7d66" + var7_39);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void deleteCashshopItem(String a, int a) {
        var2_3 = null;
        var3_4 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = var3_4.prepareStatement("DELETE FROM " + a + " WHERE SN = ?");
            var2_3.setInt(1, a);
            var2_3.execute();
            var2_3.close();
            ** if (var3_4 == null) goto lbl-1000
        }
        catch (Throwable var4_6) {
            if (var3_4 == null) ** GOTO lbl24
            try {
                var3_4.close();
                v0 = var4_6;
                ** GOTO lbl25
            }
            catch (Throwable a) {
                try {
                    var4_6.addSuppressed(a);
lbl24:
                    // 2 sources

                    v0 = var4_6;
lbl25:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var3_5) {
                    // empty catch block
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
}

