/*
 * Decompiled with CFR 0.150.
 */
package handling.auction.handler;

import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.SpecialSkillConstants;
import handling.channel.ChannelServer;
import handling.channel.handler.BBSHandler;
import handling.world.CharacterTransfer;
import handling.world.World;
import java.io.Serializable;
import server.MTSCart;
import server.MTSStorage;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import tools.FileoutputUtil;
import tools.data.LittleEndianAccessor;
import tools.packet.MTSCSPacket;

public class MTSOperation {
    public static /* synthetic */ void MTSOperation(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 != null && a3.getPlayer() != null && MTSStorage.getInstance() != null) {
            MTSCart mTSCart;
            MTSCart mTSCart2 = MTSStorage.getInstance().getCart(a3.getPlayer().getId());
            if (a2.available() <= 0L) {
                MTSOperation.ALLATORIxDEMO(mTSCart2, a3, false);
                return;
            }
            byte by = a2.readByte();
            switch (by) {
                case 1: {
                    Equip equip;
                    byte by2;
                    LittleEndianAccessor littleEndianAccessor;
                    while (false) {
                    }
                    byte by3 = a2.readByte();
                    if (by3 != 1 && by3 != 2) {
                        MapleClient mapleClient = a3;
                        mapleClient.sendPacket(MTSCSPacket.getMTSFailSell());
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, false);
                        return;
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    int n2 = littleEndianAccessor2.readInt();
                    if (littleEndianAccessor2.readByte() != 0) {
                        MapleClient mapleClient = a3;
                        mapleClient.sendPacket(MTSCSPacket.getMTSFailSell());
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, false);
                        return;
                    }
                    a2.skip(8);
                    short s2 = 1;
                    short s3 = 1;
                    if (by3 == 1) {
                        a2.skip(32);
                    } else {
                        s2 = a2.readShort();
                    }
                    System.out.println(a2.toString());
                    String string = a2.readMapleAsciiString();
                    System.out.println(a2.toString());
                    if (by3 == 1) {
                        LittleEndianAccessor littleEndianAccessor3 = a2;
                        littleEndianAccessor = littleEndianAccessor3;
                        littleEndianAccessor3.skip(28);
                        by2 = (byte)littleEndianAccessor3.readInt();
                        littleEndianAccessor3.skip(4);
                    } else {
                        a2.skip(2);
                        if (GameConstants.isThrowingStar(n2) || GameConstants.isBullet(n2)) {
                            a2.skip(8);
                        }
                        by2 = (byte)a2.readInt();
                        if (GameConstants.isThrowingStar(n2) || GameConstants.isBullet(n2)) {
                            s3 = s2;
                            LittleEndianAccessor littleEndianAccessor4 = a2;
                            littleEndianAccessor = littleEndianAccessor4;
                            littleEndianAccessor4.skip(4);
                        } else {
                            LittleEndianAccessor littleEndianAccessor5 = a2;
                            littleEndianAccessor = littleEndianAccessor5;
                            s3 = (short)littleEndianAccessor5.readInt();
                        }
                    }
                    int n3 = littleEndianAccessor.readInt();
                    MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                    MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(n2);
                    IItem iItem = a3.getPlayer().getInventory(mapleInventoryType).getItem(by2).copy();
                    if (mapleItemInformationProvider.isCash(n2) || s3 <= 0 || iItem == null || iItem.getQuantity() <= 0 || iItem.getItemId() != n2 || iItem.getUniqueId() > 0 || iItem.getQuantity() < s3 || n3 < 110 || a3.getPlayer().getMeso() < 5000 || mTSCart2.getNotYetSold().size() >= 10 || mapleItemInformationProvider.isDropRestricted(n2) || mapleItemInformationProvider.isAccountShared(n2) || iItem.getExpiration() > -1L || iItem.getFlag() > 0) {
                        a3.sendPacket(MTSCSPacket.getMTSFailSell());
                        MTSOperation.ALLATORIxDEMO(mTSCart2, a3, false);
                        return;
                    }
                    if (mapleInventoryType == MapleInventoryType.EQUIP && ((equip = (Equip)iItem).getState() > 0 || equip.getEnhance() > 0 || equip.getDurability() > -1)) {
                        a3.sendPacket(MTSCSPacket.getMTSFailSell());
                        MTSOperation.ALLATORIxDEMO(mTSCart2, a3, false);
                        return;
                    }
                    if (a3.getPlayer().getMeso() < 5000) {
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().dropMessage(1, SpecialSkillConstants.ALLATORIxDEMO("\u6964\u5e11\u4e3a\u8dc1\u0016"));
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, false);
                        return;
                    }
                    long l2 = System.currentTimeMillis() + 604800000L;
                    iItem.setQuantity(s3);
                    if (!string.isEmpty()) {
                        iItem.setOwner(string);
                    }
                    MTSStorage.getInstance().addToBuyNow(mTSCart2, iItem, n3, a3.getPlayer().getId(), a3.getPlayer().getName(), l2);
                    mTSCart = mTSCart2;
                    MapleInventoryManipulator.removeFromSlot(a3, mapleInventoryType, by2, s3, false);
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().gainMeso(-5000, false);
                    mapleClient.sendPacket(MTSCSPacket.getMTSConfirmSell());
                    break;
                }
                case 3: 
                case 17: {
                    a3.getPlayer().dropMessage(1, BBSHandler.ALLATORIxDEMO("\u6b47\u52bc\u80de\u6688\u4e2e\u95a8\u651d"));
                    mTSCart = mTSCart2;
                    break;
                }
                case 4: {
                    MTSCart mTSCart3 = mTSCart2;
                    mTSCart = mTSCart3;
                    mTSCart3.changeInfo(a2.readInt(), a2.readInt(), a2.readInt());
                    break;
                }
                case 6: {
                    MapleClient mapleClient = a3;
                    if (!MTSStorage.getInstance().removeFromBuyNow(a2.readInt(), a3.getPlayer().getId(), true)) {
                        mapleClient.sendPacket(MTSCSPacket.getMTSFailCancel());
                        mTSCart = mTSCart2;
                        break;
                    }
                    mapleClient.sendPacket(MTSCSPacket.getMTSConfirmCancel());
                    MTSOperation.ALLATORIxDEMO(mTSCart2, a3, true);
                    return;
                }
                case 7: {
                    int n4 = Integer.MAX_VALUE - a2.readInt();
                    if (n4 >= mTSCart2.getInventory().size()) {
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().dropMessage(1, SpecialSkillConstants.ALLATORIxDEMO("\u8ab9\u7a3a\u5ffe\u571f\u8a14\u0019"));
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, true);
                        return;
                    }
                    IItem iItem = mTSCart2.getInventory().get(n4);
                    if (iItem == null || iItem.getQuantity() <= 0) {
                        a3.sendPacket(MTSCSPacket.getMTSFailBuy());
                        mTSCart = mTSCart2;
                        break;
                    }
                    if (!MapleInventoryManipulator.checkSpace(a3, iItem.getItemId(), iItem.getQuantity(), iItem.getOwner())) {
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().dropMessage(1, BBSHandler.ALLATORIxDEMO("\u80ef\u5326\u7a59\u95b0\u4e2e\u8d90\r"));
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, true);
                        return;
                    }
                    IItem iItem2 = iItem.copy();
                    short s4 = MapleInventoryManipulator.addbyItem(a3, iItem2, true);
                    if (s4 < 0) {
                        MapleClient mapleClient = a3;
                        mapleClient.sendPacket(MTSCSPacket.getMTSFailBuy());
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, true);
                        return;
                    }
                    if (iItem2.getPet() != null) {
                        iItem2.getPet().setInventoryPosition(s4);
                        a3.getPlayer().addPet(iItem2.getPet());
                    }
                    mTSCart = mTSCart2;
                    mTSCart2.removeFromInventory(iItem);
                    a3.sendPacket(MTSCSPacket.getMTSConfirmTransfer(iItem2.getQuantity(), s4));
                    break;
                }
                case 8: {
                    int n5 = a2.readInt();
                    if (MTSStorage.getInstance().checkCart(n5, a3.getPlayer().getId()) && mTSCart2.addToCart(n5)) {
                        mTSCart = mTSCart2;
                        a3.sendPacket(MTSCSPacket.addToCartMessage(false, false));
                        break;
                    }
                    a3.sendPacket(MTSCSPacket.addToCartMessage(true, false));
                    mTSCart = mTSCart2;
                    break;
                }
                case 9: {
                    int n6 = a2.readInt();
                    if (mTSCart2.getCart().contains(n6)) {
                        MTSCart mTSCart4 = mTSCart2;
                        mTSCart = mTSCart4;
                        mTSCart4.removeFromCart(n6);
                        a3.sendPacket(MTSCSPacket.addToCartMessage(false, true));
                        break;
                    }
                    a3.sendPacket(MTSCSPacket.addToCartMessage(true, true));
                    mTSCart = mTSCart2;
                    break;
                }
                case 15: 
                case 16: {
                    MTSStorage.MTSItemInfo mTSItemInfo = MTSStorage.getInstance().getSingleItem(a2.readInt());
                    if (mTSItemInfo == null) {
                        MapleClient mapleClient = a3;
                        mapleClient.sendPacket(MTSCSPacket.getMTSFailBuy());
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, false);
                        return;
                    }
                    if (a3.getPlayer().getCSPoints(2) < mTSItemInfo.getRealPrice()) {
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().dropMessage(1, SpecialSkillConstants.ALLATORIxDEMO("\u6964\u843b\u9ee9\u650a\u992f\u983f\u4e3a\u8dc1\u0019"));
                        MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient, false);
                        return;
                    }
                    MapleClient mapleClient = a3;
                    if (!MTSStorage.getInstance().removeFromBuyNow(mTSItemInfo.getId(), a3.getPlayer().getId(), false)) {
                        mapleClient.sendPacket(MTSCSPacket.getMTSFailBuy());
                        mTSCart = mTSCart2;
                        break;
                    }
                    mapleClient.getPlayer().modifyCSPoints(2, -mTSItemInfo.getRealPrice(), false);
                    MTSStorage.getInstance().getCart(mTSItemInfo.getCharacterId()).increaseOwedNX(mTSItemInfo.getPrice());
                    MapleClient mapleClient2 = a3;
                    mapleClient2.sendPacket(MTSCSPacket.getMTSConfirmBuy());
                    MTSOperation.ALLATORIxDEMO(mTSCart2, mapleClient2, true);
                    return;
                }
                default: {
                    System.out.println("\u672a\u8655\u7406\u7684\u62cd\u8ce3\u5305 \u64cd\u4f5c\u78bc: " + by + ", \n" + a2.toString());
                    mTSCart = mTSCart2;
                }
            }
            MTSOperation.ALLATORIxDEMO(mTSCart, a3, false);
        }
    }

    public static /* synthetic */ void MTSUpdate(MTSCart a2, MapleClient a3) {
        int n2 = MTSStorage.getInstance().getCart(a3.getPlayer().getId()).getSetOwedNX();
        if (n2 != 0) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().modifyCSPoints(2, n2, false);
            mapleClient.getPlayer().dropMessage(1, "\u60a8\u900f\u904e\u62cd\u8ce3\u7269\u54c1\u7372\u5f97 " + n2 + " \u6953\u9ede!");
        }
        a3.sendPacket(MTSCSPacket.getMTSWantedListingOver(0, 0));
        MTSOperation.ALLATORIxDEMO(a2, a3, false);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 4 ^ (3 ^ 5) << 1;
        int cfr_ignored_0 = (3 ^ 5) << 3 ^ 2;
        int n5 = n3;
        int n6 = 4 << 3 ^ 3;
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

    private static /* synthetic */ void ALLATORIxDEMO(MTSCart a2, MapleClient a3, boolean a4) {
        MapleClient mapleClient = a3;
        mapleClient.sendPacket(MTSStorage.getInstance().getCurrentMTS(a2));
        mapleClient.sendPacket(MTSStorage.getInstance().getCurrentNotYetSold(a2));
        mapleClient.sendPacket(MTSStorage.getInstance().getCurrentTransfer(a2, a4));
        mapleClient.sendPacket(MTSCSPacket.showMTSCash(mapleClient.getPlayer()));
        mapleClient.sendPacket(MTSCSPacket.enableCSUse());
        MTSStorage.getInstance().checkExpirations();
    }

    public static /* synthetic */ void EnterMTS(int a2, MapleClient a3) {
        MapleClient mapleClient = a3;
        mapleClient.loadAccountidByPlayerid(a2);
        if (World.Find.findDisconnect(mapleClient.getAccID()) > 0) {
            System.out.println("(EnterCashShop) \u5546\u57ce\u89d2\u8272\u8907\u88fd: " + a2 + " \u5e33\u865fid: " + a3.getAccID());
            FileoutputUtil.logToFile(SpecialSkillConstants.ALLATORIxDEMO("[\u001dP\u0001\u0018:V\u0011\\]\u8930\u888f\u0018\u89a0\u8245\u8975\u88ca\\C\nC"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid: " + a3.getAccID() + " \u5546\u57ce\u89d2\u8272\u8907\u88fd (EnterCashShop)");
            MapleClient mapleClient2 = a3;
            World.Find.forceDeregisterDisconnect(mapleClient2.getAccID());
            mapleClient2.getSession().close();
            return;
        }
        if (!MapleCharacterUtil.isExistCharacterInDataBase(a2)) {
            System.out.println("<\u522a\u9664\u89d2\u8272> (EnterCashShop)  \u983b\u9053<" + a3.getChannel() + ">\u89d2\u8272\u8907\u88fd: " + a2 + " \u5e33\u865fid: " + a3.getAccID());
            FileoutputUtil.logToFile(BBSHandler.ALLATORIxDEMO("OLDP\fkB@H\f\u8924\u88de\f\u89f1\u8251\u8924\u88de\rW[W"), FileoutputUtil.CurrentReadable_Time() + " <\u522a\u9664\u89d2\u8272\u8907\u88fd> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID());
            a3.getSession().close();
            return;
        }
        ChannelServer channelServer = ChannelServer.getInstance(a3.getWorld(), -20);
        Serializable serializable = channelServer.getPlayerStorage().getPendingCharacter(a2);
        if (serializable == null) {
            a3.disconnect();
            return;
        }
        serializable = MapleCharacter.ReconstructChr((CharacterTransfer)serializable, a3, true);
        MapleClient mapleClient3 = a3;
        Serializable serializable2 = serializable;
        a3.setPlayer((MapleCharacter)serializable);
        a3.setAccID(((MapleCharacter)serializable2).getAccountID());
        mapleClient3.setWorld(((MapleCharacter)serializable2).getWorld());
        mapleClient3.loadAccountData(((MapleCharacter)serializable).getAccountID());
        if (GameSetConstants.CHECKIP_ADRESS && !a3.CheckIPAddress()) {
            a3.disconnect();
            return;
        }
        byte by = a3.getLoginState();
        boolean bl = false;
        if (!(by != 1 && by != 6 || World.isConnected(((MapleCharacter)serializable).getName()))) {
            bl = true;
        }
        if (!bl) {
            a3.disconnect();
            return;
        }
        MapleClient mapleClient4 = a3;
        MapleClient mapleClient5 = a3;
        mapleClient5.updateLoginState(5, mapleClient5.getSessionIPAddress());
        Serializable serializable3 = serializable;
        channelServer.getPlayerStorage().registerPlayer((MapleCharacter)serializable3);
        mapleClient4.sendPacket(MTSCSPacket.startMTS((MapleCharacter)serializable3, mapleClient4));
        MTSOperation.MTSUpdate(MTSStorage.getInstance().getCart(a3.getPlayer().getId()), a3);
    }

    public /* synthetic */ MTSOperation() {
        MTSOperation a2;
    }
}

