/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 */
package server;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.CheckItemFactory;
import client.inventory.IItem;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryType;
import client.messages.commands.player.\u53ef\u53ef\u8c37;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ServerConfig;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.world.World;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.life.MobSkill;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.packet.PlayerShopPacket;

public class MapleTrade {
    private final /* synthetic */ List<IItem> C;
    private /* synthetic */ boolean a;
    private final /* synthetic */ byte k;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ boolean K;
    private /* synthetic */ int E;
    private final /* synthetic */ WeakReference<MapleCharacter> B;
    private /* synthetic */ MapleTrade F;
    private /* synthetic */ boolean d;
    private /* synthetic */ List<IItem> H;
    private /* synthetic */ boolean g;
    private /* synthetic */ int e;

    public final /* synthetic */ void setPartner(MapleTrade a2) {
        MapleTrade a3;
        if (a3.g) {
            return;
        }
        if (a3.C != null) {
            a3.C.clear();
        }
        if (a3.H != null) {
            a3.H.clear();
        }
        MapleTrade mapleTrade = a3;
        mapleTrade.e = 0;
        mapleTrade.E = 0;
        a3.F = a2;
    }

    public final /* synthetic */ MapleCharacter getChr() {
        MapleTrade a2;
        return (MapleCharacter)a2.B.get();
    }

    public /* synthetic */ MapleTrade(byte a2, MapleCharacter a3) {
        MapleTrade a4;
        MapleTrade mapleTrade = a4;
        MapleTrade mapleTrade2 = a4;
        MapleTrade mapleTrade3 = a4;
        MapleTrade mapleTrade4 = a4;
        a4.F = null;
        MapleTrade mapleTrade5 = a4;
        a4.C = new LinkedList<IItem>();
        mapleTrade4.e = 0;
        mapleTrade4.E = 0;
        mapleTrade3.g = 0;
        mapleTrade3.K = false;
        mapleTrade2.a = false;
        mapleTrade2.d = false;
        mapleTrade.ALLATORIxDEMO = false;
        mapleTrade.k = a2;
        mapleTrade.B = new WeakReference<MapleCharacter>(a3);
    }

    public static final /* synthetic */ void visitTrade(MapleCharacter a2, MapleCharacter a3) {
        if (a2 != null) {
            if (a3 != null && a2.getTrade() != null && a2.getTrade().getPartner() == a3.getTrade() && a3.getTrade() != null && a3.getTrade().getPartner() == a2.getTrade()) {
                MapleCharacter mapleCharacter = a2;
                a3.getClient().sendPacket(MaplePacketCreator.getTradePartnerAdd(mapleCharacter));
                a2.getClient().sendPacket(MaplePacketCreator.getTradeStart(a2.getClient(), a2.getTrade(), (byte)1));
                mapleCharacter.addTradeMsg(mapleCharacter.getName(), " \u89d2\u8272\u540d\u5b57:" + a2.getName() + " \u63a5\u53d7\u4ea4\u6613\u9080\u8acb,\u9032\u5165 " + a3.getName() + " \u7684\u4ea4\u6613\u8996\u7a97\r\n");
                MapleCharacter mapleCharacter2 = a3;
                mapleCharacter2.addTradeMsg(a3.getName(), "\u89d2\u8272\u540d\u5b57:" + mapleCharacter2.getName() + " \u63d0\u51fa\u7684\u4ea4\u6613\u9080\u8acb,\u5df2\u88ab " + a2.getName() + " \u63a5\u53d7 \u9032\u5165\u4ea4\u6613\u8996\u7a97\r\n");
                return;
            }
            a2.getClient().sendPacket(MaplePacketCreator.getErrorNotice(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u4ef3\u661f\u5da5\u7d9f\u88fc\u95d0\u95de\"")));
        }
    }

    public static final /* synthetic */ void declineTrade(MapleCharacter a2) {
        MapleTrade mapleTrade = a2.getTrade();
        MapleCharacter mapleCharacter = null;
        if (mapleTrade != null) {
            if (mapleTrade.getPartner() != null && (mapleCharacter = mapleTrade.getPartner().getChr()) != null) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.setInvited(false);
                if (mapleCharacter2.getTrade() != null) {
                    MapleCharacter mapleCharacter3 = mapleCharacter;
                    mapleCharacter.getTrade().cancel(mapleCharacter3.getClient());
                    mapleCharacter3.setTrade(null);
                }
                a2.setInvited(false);
                mapleCharacter.dropMessage(5, a2.getName() + " \u62d2\u7d55\u4e86\u4f60\u7684\u9080\u8acb.");
            }
            if (mapleCharacter != null) {
                mapleTrade.cancel(a2.getClient());
            }
            a2.setTrade(null);
        }
    }

    public final /* synthetic */ void addItem(IItem a2) {
        MapleTrade a3;
        if (a3.g || a3.F == null) {
            return;
        }
        ((MapleCharacter)a3.B.get()).addTradeMsg(((MapleCharacter)a3.B.get()).getName(), " \u8a2d\u5b9a\u9053\u5177[" + a2.getItemId() + "]\u6578\u91cf[" + a2.getQuantity() + "]\r\n");
        MapleTrade mapleTrade = a3;
        mapleTrade.C.add(a2);
        ((MapleCharacter)mapleTrade.B.get()).getClient().sendPacket(MaplePacketCreator.getTradeItemAdd((byte)0, a2));
        if (a3.F != null) {
            a3.F.getChr().getClient().sendPacket(MaplePacketCreator.getTradeItemAdd((byte)1, a2));
        }
    }

    public final /* synthetic */ int getNextTargetSlot() {
        MapleTrade a2;
        if (a2.C.size() >= 9) {
            return -1;
        }
        int n2 = 1;
        Iterator<IItem> iterator = a2.C.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPosition() != n2) continue;
            ++n2;
        }
        return n2;
    }

    public static final /* synthetic */ void completeTrade(MapleCharacter a2) {
        MapleTrade mapleTrade = a2.getTrade();
        MapleTrade mapleTrade2 = mapleTrade.getPartner();
        if (mapleTrade2 == null || mapleTrade.g) {
            return;
        }
        if (a2.canTrade() && mapleTrade2.getChr().canTrade()) {
            mapleTrade.g = true;
            mapleTrade2.getChr().getClient().sendPacket(MaplePacketCreator.getTradeConfirmation());
            mapleTrade2.H = mapleTrade.C;
            mapleTrade2.E = mapleTrade.e;
            if (mapleTrade2.isLocked() && !MapleTrade.isAbonormalTradeStatus(mapleTrade, mapleTrade2)) {
                MapleCharacter mapleCharacter;
                int n2 = mapleTrade.ALLATORIxDEMO();
                int n3 = mapleTrade2.ALLATORIxDEMO();
                if (!mapleTrade2.getChr().istrading() || !mapleTrade.getChr().istrading()) {
                    mapleTrade2.H.clear();
                    mapleTrade.C.clear();
                    mapleTrade2.E = 0;
                    mapleTrade.e = 0;
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]" + mapleTrade2.getChr().getName() + "\u548c" + mapleTrade.getChr().getName() + " \u7591\u4f3c\u4ea4\u6613\u8907\u88fd!!\u5df2\u6e05\u9664\u6240\u6709\u4ea4\u6613\u7269\u54c1!"));
                    FileoutputUtil.logToFile(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"`8k$#\u001fm4gx\u890b\u88aa#\u4ef3\u661f\u8950\u88f1yx/x"), "\u6642\u9593: " + FileoutputUtil.NowTime() + " \u540d\u7a31[" + mapleTrade.getChr().getName() + "](\u7de8\u865f" + mapleTrade.getChr().getId() + ")<\u5e33\u865f" + mapleTrade.getChr().getAccountID() + "> \u548c [" + mapleTrade2.getChr().getName() + "](\u7de8\u865f" + mapleTrade2.getChr().getId() + ")<\u5e33\u865f" + mapleTrade2.getChr().getAccountID() + "> \u4ea4\u6613\u7591\u4f3c\u8907\u88fd\uff0c \u5730\u5716:" + mapleTrade.getChr().getMapId() + "\r\n ");
                    MapleTrade mapleTrade3 = mapleTrade2;
                    mapleTrade2.setCanceling(true);
                    mapleTrade.setCanceling(true);
                    mapleTrade3.getChr().settrading(false);
                    mapleTrade.getChr().settrading(false);
                    mapleTrade3.cancel(mapleTrade3.getChr().getClient(), n2 == 0 ? n3 : n2, false);
                    mapleTrade.cancel(a2.getClient(), n2 == 0 ? n3 : n2, false);
                    mapleCharacter = a2;
                } else if (n2 == 0 && n3 == 0) {
                    mapleCharacter = a2;
                    MapleTrade mapleTrade4 = mapleTrade;
                    MapleTrade mapleTrade5 = mapleTrade2;
                    mapleTrade.CompleteTrade();
                    mapleTrade5.CompleteTrade();
                    mapleTrade5.setCompleting(true);
                    mapleTrade4.setCompleting(true);
                    mapleTrade2.getChr().settrading(false);
                    mapleTrade4.getChr().settrading(false);
                } else {
                    MapleTrade mapleTrade6 = mapleTrade2;
                    mapleTrade2.setCanceling(true);
                    mapleTrade.setCanceling(true);
                    mapleTrade6.getChr().settrading(false);
                    mapleTrade.getChr().settrading(false);
                    mapleTrade2.cancel(mapleTrade6.getChr().getClient(), n2 == 0 ? n3 : n2, true);
                    mapleTrade.cancel(a2.getClient(), n2 == 0 ? n3 : n2, true);
                    mapleCharacter = a2;
                }
                if (mapleCharacter.getClient().isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", "\r\n---------------------------------" + mapleTrade.getChr().getName() + "\u548c" + mapleTrade2.getChr().getName() + "\u4ea4\u6613\u7d50\u675f---------------------------------");
                }
                mapleTrade.getChr().addTradeMsg(mapleTrade.getChr().getName(), " \u78ba\u8a8d\u64cd\u4f5c \u8207" + mapleTrade2.getChr().getName() + "(" + mapleTrade2.getChr().getClient().getSessionIPAddress() + ")\u7684\u4ea4\u6613 \u7d50\u679c: " + (n2 + n3 == 0 ? MobSkill.ALLATORIxDEMO("\u623a\u52b5") : \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u5966\u655b")) + "\r\n");
                mapleTrade.getChr().addEmptyTradeMsg(MobSkill.ALLATORIxDEMO("\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017' "));
                mapleTrade2.getChr().addTradeMsg(mapleTrade2.getChr().getName(), " \u78ba\u8a8d\u64cd\u4f5c \u8207" + mapleTrade.getChr().getName() + "(" + mapleTrade.getChr().getClient().getSessionIPAddress() + ")\u7684\u4ea4\u6613 \u7d50\u679c: " + (n2 + n3 == 0 ? \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u6247\u5293") : MobSkill.ALLATORIxDEMO("\u591b\u657d")) + "\r\n");
                MapleTrade mapleTrade7 = mapleTrade2;
                MapleTrade mapleTrade8 = mapleTrade2;
                mapleTrade8.getChr().addEmptyTradeMsg(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1Z\u0006"));
                mapleTrade.getChr().endTradeMsg(mapleTrade.getChr().getName());
                mapleTrade8.getChr().endTradeMsg(mapleTrade2.getChr().getName());
                mapleTrade8.getChr().setTrade(null);
                a2.setTrade(null);
                mapleTrade.setCanceling(false);
                mapleTrade2.setCanceling(false);
                mapleTrade.setCompleting(false);
                mapleTrade7.setCompleting(false);
                if (mapleTrade7.getChr().istrading()) {
                    mapleTrade2.getChr().settrading(false);
                }
                if (mapleTrade.getChr().istrading()) {
                    mapleTrade.getChr().settrading(false);
                }
                if (mapleTrade.getChr().getClient().getAccID() == mapleTrade2.getChr().getClient().getAccID()) {
                    MapleTrade mapleTrade9 = mapleTrade;
                    mapleTrade9.getChr().ban(MobSkill.ALLATORIxDEMO("\u4fc4\u6513\u6552\u64f0\u532f\n\u0007\n\u5426\u5e19\u8675\u89f8\u8258\u4e8e\u6639"), true, true, false);
                    mapleTrade2.getChr().ban(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u4fe2\u656e\u6574\u648d\u5309w!w\u5400\u5e64\u8653\u8985\u827e\u4ef3\u661f"), true, true, false);
                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u865f\u7cfb\u7d71]" + mapleTrade9.getChr().getName() + " \u56e0\u70ba\u4f7f\u7528\u975e\u6cd5\u8edf\u4ef6\u800c\u88ab\u6c38\u4e45\u5c01\u865f\u3002"));
                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u865f\u7cfb\u7d71]" + mapleTrade2.getChr().getName() + " \u56e0\u70ba\u4f7f\u7528\u975e\u6cd5\u8edf\u4ef6\u800c\u88ab\u6c38\u4e45\u5c01\u865f\u3002"));
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]" + mapleTrade2.getChr().getName() + "\u548c" + mapleTrade.getChr().getName() + " \u70ba\u540c\u5e33\u865f\u7684\u89d2\u8272\u4e14\u9032\u884c\u4ea4\u6613\u3002"));
                    FileoutputUtil.logToFile(MobSkill.ALLATORIxDEMO("FEMY\u0005bKIA\u0005HKD\u0005\u4e8e\u6639\u755a\u5e12\u0004^R^"), "\u6642\u9593: " + FileoutputUtil.NowTime() + " IP: " + mapleTrade.getChr().getClient().getSessionIPAddress() + " MAC: " + mapleTrade.getChr().getNowMacs() + " " + mapleTrade.getChr().getName() + " \u548c " + mapleTrade2.getChr().getName() + " \u70ba\u540c\u500b\u5e33\u865f\u7684\u89d2\u8272\u4e14\u9032\u884c\u4ea4\u6613\r\n");
                    mapleTrade.getChr().getClient().getSession().close();
                    mapleTrade2.getChr().getClient().getSession().close();
                    return;
                }
            }
        } else {
            FileoutputUtil.logToFile(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"`8k$#\u001fm4gx\u890b\u88aa#\u4ef3\u661f\u8950\u88f1yx/x"), "\u6642\u9593: " + FileoutputUtil.NowTime() + " \u540d\u7a31[" + mapleTrade.getChr().getName() + "](\u7de8\u865f" + mapleTrade.getChr().getId() + ")<\u5e33\u865f" + mapleTrade.getChr().getAccountID() + "> \u548c [" + mapleTrade2.getChr().getName() + "](\u7de8\u865f" + mapleTrade2.getChr().getId() + ")<\u5e33\u865f" + mapleTrade2.getChr().getAccountID() + "> \u4ea4\u6613\u7591\u4f3c\u8907\u88fd\uff0c \u5730\u5716:" + mapleTrade.getChr().getMapId() + "\r\n ");
        }
    }

    public final /* synthetic */ void CompleteTrade() {
        MapleTrade a2;
        MapleTrade mapleTrade = a2;
        int n2 = mapleTrade.E;
        int n3 = ((MapleCharacter)mapleTrade.B.get()).getMeso();
        Object object = "";
        if (!((MapleCharacter)a2.B.get()).istrading()) {
            a2.H.clear();
            a2.E = 0;
            a2.e = 0;
            ((MapleCharacter)a2.B.get()).getClient().sendPacket(MaplePacketCreator.getTradeCancel(a2.k, 1));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]" + a2.F.getChr().getName() + "\u548c" + ((MapleCharacter)a2.B.get()).getName() + " \u7591\u4f3c\u4ea4\u6613\u8907\u88fd!!\u5df2\u6e05\u9664\u6240\u6709\u4ea4\u6613\u7269\u54c1!"));
            FileoutputUtil.logToFile(MobSkill.ALLATORIxDEMO("FEMY\u0005bKIA\u0005\u892d\u88d7\u0005\u4e8e\u6639\u892d\u88d7\u0004^R^"), "\u6642\u9593: " + FileoutputUtil.NowTime() + " \u540d\u7a31[" + ((MapleCharacter)a2.B.get()).getName() + "](\u7de8\u865f" + ((MapleCharacter)a2.B.get()).getId() + ")<\u5e33\u865f" + ((MapleCharacter)a2.B.get()).getAccountID() + "> \u548c [" + a2.F.getChr().getName() + "](\u7de8\u865f" + a2.F.getChr().getId() + ")<\u5e33\u865f" + a2.F.getChr().getAccountID() + "> \u4ea4\u6613\u7591\u4f3c\u8907\u88fd\uff0c \u5730\u5716:" + ((MapleCharacter)a2.B.get()).getMapId() + "\r\n ");
            return;
        }
        if (a2.H != null) {
            Iterator<IItem> iterator;
            Iterator<IItem> iterator2 = iterator = a2.H.iterator();
            while (iterator2.hasNext()) {
                MapleTrade mapleTrade2;
                IItem iItem;
                IItem iItem2 = iterator.next();
                String string = MapleItemInformationProvider.getInstance().getName(iItem2.getItemId());
                if (!\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"9y;`").equals(string)) {
                    object = (String)object + string + "(" + iItem2.getQuantity() + "), ";
                    iItem = iItem2;
                } else {
                    object = (String)object + iItem2.getItemId() + "(" + iItem2.getQuantity() + "), ";
                    iItem = iItem2;
                }
                int n4 = iItem.getFlag();
                if (ItemFlag.KARMA_EQ.check(n4)) {
                    mapleTrade2 = a2;
                    iItem2.setFlag(n4 - ItemFlag.KARMA_EQ.getValue());
                } else {
                    if (ItemFlag.KARMA_USE.check(n4)) {
                        iItem2.setFlag(n4 - ItemFlag.KARMA_USE.getValue());
                    }
                    mapleTrade2 = a2;
                }
                MapleInventoryManipulator.addFromDrop(((MapleCharacter)mapleTrade2.B.get()).getClient(), iItem2, false);
                iterator2 = iterator;
            }
            a2.H.clear();
        }
        if (a2.E > 0) {
            MapleTrade mapleTrade3 = a2;
            ((MapleCharacter)a2.B.get()).gainMeso(mapleTrade3.E - GameConstants.getTaxAmount(mapleTrade3.E), false, true, false);
        }
        a2.E = 0;
        int n5 = ((MapleCharacter)a2.B.get()).getMeso();
        ((MapleCharacter)a2.B.get()).getClient().sendPacket(MaplePacketCreator.TradeMessage(a2.k, GameSetConstants.MAPLE_VERSION == 75 ? (byte)7 : 8));
        ((MapleCharacter)a2.B.get()).addTradeMsg(((MapleCharacter)a2.B.get()).getName(), " \u4ea4\u6613\u9053\u5177,\u6536\u5230: " + (String)object + "\r\n");
        ((MapleCharacter)a2.B.get()).addTradeMsg(((MapleCharacter)a2.B.get()).getName(), " \u4ea4\u6613\u6953\u5e63,\u6536\u5230 " + n2 + " \u539f\u59cb\u6953\u5e63:" + n3 + " \u66f4\u8b8a\u5f8c\u6953\u5e63:" + n5 + "\r\n");
        ((MapleCharacter)a2.B.get()).addTradeMsg(((MapleCharacter)a2.B.get()).getName(), MobSkill.ALLATORIxDEMO("\n\u4e8e\u6639\u7d7a\u6775\u0006\u7d7a\u67b6\u0010\n\u4e8e\u6639\u623a\u52b5' "));
        if (((MapleCharacter)a2.B.get()).getClient().isMonitored()) {
            int n6;
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + ((MapleCharacter)a2.B.get()).getName() + "/\u4ea4\u6613\u6953\u5e63.txt", "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6: " + ((MapleCharacter)a2.B.get()).getName() + " \u7372\u5f97\u4e86\u9053\u5177: " + (String)object + "\r\n");
            String string = "logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + ((MapleCharacter)a2.B.get()).getName() + "/\u4ea4\u6613\u6953\u5e63.txt";
            String string2 = FileoutputUtil.NowTime();
            String string3 = ((MapleCharacter)a2.B.get()).getName();
            if (n2 > 0) {
                int n7 = n2;
                n6 = n7 - GameConstants.getTaxAmount(n7);
            } else {
                n6 = 0;
            }
            FileoutputUtil.logToFile(string, "\r\n " + string2 + " \u73a9\u5bb6: " + string3 + " \u7372\u5f97\u4e86\u6953\u5e63: " + n6 + "\r\n");
        }
    }

    public /* synthetic */ void setCompleting(boolean a2) {
        a.a = a2;
    }

    public final /* synthetic */ void chat(String a2) {
        MapleTrade a3;
        if (a3.F == null) {
            return;
        }
        if (((MapleCharacter)a3.B.get()).getCanTalk()) {
            ((MapleCharacter)a3.B.get()).dropMessage(-2, ((MapleCharacter)a3.B.get()).getName() + " : " + a2);
            ((MapleCharacter)a3.B.get()).addTradeMsg(((MapleCharacter)a3.B.get()).getName(), " \u804a\u5929<" + a3.F.getChr().getName() + ">  [" + a2 + "]\r\n");
        }
        if (ServerConfig.LOG_CHAT) {
            try {
                FileoutputUtil.logToFile(MobSkill.ALLATORIxDEMO("FEMY\u0005\u8060\u5903\u0005\u4e8e\u6639\u8060\u5903\u0004^R^"), " " + FileoutputUtil.NowTime() + " IP: " + ((MapleCharacter)a3.B.get()).getClient().getSession().remoteAddress().toString().split(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"6"))[0] + " \u300e" + ((MapleCharacter)a3.B.get()).getName() + "\u300f\u5c0d\u300e" + a3.F.getChr().getName() + "\u300f\u7684\u4ea4\u6613\u804a\u5929\uff1a  " + a2 + "\r\n");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        StringBuilder stringBuilder = new StringBuilder("[GM \u5bc6\u8a9e] \u300e" + ((MapleCharacter)a3.B.get()).getName() + "\u300f\u5c0d\u300e" + a3.F.getChr().getName() + "\u300f\u7684\u4ea4\u6613\u804a\u5929\uff1a  " + a2);
        Iterator<ChannelServer> iterator = LoginServer.getWorldStatic(((MapleCharacter)a3.B.get()).getWorld()).getChannels().iterator();
        while (iterator.hasNext()) {
            for (MapleCharacter mapleCharacter : iterator.next().getPlayerStorage().getAllCharactersThreadSafe()) {
                if (!mapleCharacter.getmsg_Chat()) continue;
                mapleCharacter.dropMessage(stringBuilder.toString());
            }
        }
        if (a3.F != null && ((MapleCharacter)a3.B.get()).getCanTalk()) {
            a3.F.getChr().getClient().sendPacket(PlayerShopPacket.shopChat(((MapleCharacter)a3.B.get()).getName() + " : " + a2, 1));
        }
    }

    public /* synthetic */ void setCanceling(boolean a2) {
        a.a = a2;
    }

    public final /* synthetic */ boolean isLocked() {
        MapleTrade a2;
        return a2.g;
    }

    public /* synthetic */ boolean isCompleting() {
        MapleTrade a2;
        return a2.d;
    }

    public static final /* synthetic */ void inviteTrade(MapleCharacter a2, MapleCharacter a3) {
        if (a2 == null || a2.getTrade() == null || a3 == null) {
            return;
        }
        if (a2.getClient().isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", "\r\n" + FileoutputUtil.NowTime() + "\u89d2\u8272" + a2.getName() + "\u7b49\u7d1a:" + a2.getLevel() + " (\u7de8\u865f: " + a2.getId() + ")\u5411 " + a3.getName() + " \u63d0\u51fa\u4ea4\u6613\u7533\u8acb ");
        }
        if (a3.getClient().isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", "\r\n" + FileoutputUtil.NowTime() + "\u89d2\u8272" + a3.getName() + "\u7b49\u7d1a:" + a3.getLevel() + " (\u7de8\u865f: " + a3.getId() + ")\u63a5\u6536\u5230 " + a2.getName() + " \u7684\u4ea4\u6613\u9080\u8acb");
        }
        if (World.isShutDown) {
            MapleCharacter mapleCharacter = a2;
            MapleTrade.cancelTrade(mapleCharacter.getTrade(), a2.getClient());
            mapleCharacter.dropMessage(1, \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u4f6d\u6701\u563f\u537f\u5c50\u95d0\u95de\uff00\u7176\u6cd9\u57a0\u8840\u677b\u64c1\u4f0b\u300e"));
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.getWorld() != a3.getWorld()) {
            MapleCharacter mapleCharacter = a2;
            MapleTrade.cancelTrade(mapleCharacter.getTrade(), a2.getClient());
            mapleCharacter.dropMessage(1, MobSkill.ALLATORIxDEMO("\u4e27\u5426\u4e3c\u7566\u710b\u6cff\u4e8e\u6639"));
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a3.isOperateStorage() || !a3.isAlive()) {
            MapleCharacter mapleCharacter = a2;
            MapleCharacter mapleCharacter2 = a2;
            MapleTrade.cancelTrade(mapleCharacter.getTrade(), mapleCharacter2.getClient());
            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.getErrorNotice(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u5c5a\u65b5\u6b34\u5724\u5f8e\u7880\u4e7a\u300e")));
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.isOperateStorage() || !a2.isAlive()) {
            MapleCharacter mapleCharacter = a2;
            MapleTrade.cancelTrade(a2.getTrade(), mapleCharacter.getClient());
            mapleCharacter.dropMessage(1, MobSkill.ALLATORIxDEMO("\u76c4\u5267\u72ea\u6161\u710b\u6cff\u4e8e\u6639"));
            a2.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.getPlayerShop() != null || a3.getPlayerShop() != null) {
            MapleCharacter mapleCharacter = a2;
            MapleTrade.cancelTrade(a2.getTrade(), mapleCharacter.getClient());
            mapleCharacter.dropMessage(1, \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u7cb2\u971f\u554a\u4eed\u64c1\u4f0b\u4e21{\u76e2\u521a\u72cc\u611c\u712d\u6c82\u4ea8\u6644\u300e"));
            a2.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.getTrade().getPartner() != null) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.dropMessage(1, MobSkill.ALLATORIxDEMO("\u76c4\u5267\u72ea\u6161\u710b\u6cff\u4e8e\u6639"));
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.getClient().getAccID() == a3.getClient().getAccID()) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.ban(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u4fe2\u656e\u6574\u648d\u5309w!w\u5400\u5e64\u8653\u8985\u827e\u4ef3\u661f"), true, true, false);
            a3.ban(MobSkill.ALLATORIxDEMO("\u4fc4\u6513\u6552\u64f0\u532f\n\u0007\n\u5426\u5e19\u8675\u89f8\u8258\u4e8e\u6639"), true, true, false);
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + mapleCharacter.getName() + " \u56e0\u70ba\u4f7f\u7528\u9055\u6cd5\u7a0b\u5f0f\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a3.getName() + " \u56e0\u70ba\u4f7f\u7528\u9055\u6cd5\u7a0b\u5f0f\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a2.getName() + " \u548c " + a3.getName() + " \u540c\u5e33\u865f\u89d2\u8272\u4ea4\u6613"));
            FileoutputUtil.logToFile(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"`8k$#\u001fm4gx\u5400\u5e64\u8653\u4ef3\u661fyx/x"), FileoutputUtil.CurrentReadable_Time() + " " + a2.getName() + " \u548c " + a3.getName() + " \u540c\u5e33\u865f\u89d2\u8272\u4ea4\u6613");
            a2.getClient().getSession().close();
            a3.getClient().getSession().close();
            return;
        }
        if (a3.getTrade() == null && a2.getTrade().getPartner() == null) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.addTradeMsg(mapleCharacter.getName(), " \u8207" + a3.getName() + "\u4ea4\u6613\u958b\u59cb\r\n");
            MapleCharacter mapleCharacter3 = a3;
            mapleCharacter3.addTradeMsg(mapleCharacter3.getName(), " \u8207" + a2.getName() + "\u4ea4\u6613\u958b\u59cb\r\n");
            MapleCharacter mapleCharacter4 = a3;
            a2.settrading(true);
            a3.settrading(true);
            a3.setTrade(new MapleTrade(1, a3));
            mapleCharacter4.getTrade().setPartner(a2.getTrade());
            a2.getTrade().setPartner(a3.getTrade());
            mapleCharacter4.setInvited(true);
            mapleCharacter4.getClient().sendPacket(MaplePacketCreator.getTradeInvite(a2));
            return;
        }
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.getErrorNotice(MobSkill.ALLATORIxDEMO("\u53cc\u4e2a\u4f67\u7383\u5b9c\u6b49\u5702\u4e8e\u6639\u4e07")));
        MapleTrade.cancelTrade(mapleCharacter.getTrade(), a2.getClient());
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ int ALLATORIxDEMO() {
        MapleTrade a2;
        if (a2.B.get() == null) {
            return 2;
        }
        if (((MapleCharacter)a2.B.get()).getMeso() + a2.E < 0) {
            return 1;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        short s2 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        for (IItem iItem : a2.H) {
            MapleItemInformationProvider mapleItemInformationProvider2;
            switch (1.ALLATORIxDEMO[GameConstants.getInventoryType(iItem.getItemId()).ordinal()]) {
                case 1: {
                    s2 = (byte)(s2 + 1);
                    mapleItemInformationProvider2 = mapleItemInformationProvider;
                    break;
                }
                case 2: {
                    s3 = (byte)(s3 + 1);
                    mapleItemInformationProvider2 = mapleItemInformationProvider;
                    break;
                }
                case 3: {
                    s4 = (byte)(s4 + 1);
                    mapleItemInformationProvider2 = mapleItemInformationProvider;
                    break;
                }
                case 4: {
                    s5 = (byte)(s5 + 1);
                    mapleItemInformationProvider2 = mapleItemInformationProvider;
                    break;
                }
                case 5: {
                    s6 = (byte)(s6 + 1);
                }
                default: {
                    mapleItemInformationProvider2 = mapleItemInformationProvider;
                }
            }
            if (mapleItemInformationProvider2.isPickupRestricted(iItem.getItemId()) && ((MapleCharacter)a2.B.get()).getInventory(GameConstants.getInventoryType(iItem.getItemId())).findById(iItem.getItemId()) != null) {
                return 2;
            }
            if (!mapleItemInformationProvider.isPickupRestricted(iItem.getItemId()) || !((MapleCharacter)a2.B.get()).haveItem(iItem.getItemId(), true ? 1 : 0, true, true)) continue;
            return 2;
        }
        if (((MapleCharacter)a2.B.get()).getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() >= s2 && ((MapleCharacter)a2.B.get()).getInventory(MapleInventoryType.USE).getNumFreeSlot() >= s3 && ((MapleCharacter)a2.B.get()).getInventory(MapleInventoryType.SETUP).getNumFreeSlot() >= s4 && ((MapleCharacter)a2.B.get()).getInventory(MapleInventoryType.ETC).getNumFreeSlot() >= s5 && ((MapleCharacter)a2.B.get()).getInventory(MapleInventoryType.CASH).getNumFreeSlot() >= s6) {
            return 0;
        }
        return 1;
    }

    public final /* synthetic */ void setMeso(int a2) {
        int n2;
        MapleTrade a3;
        if (a3.g || a3.F == null || a2 <= 0 || a3.e + a2 <= 0) {
            return;
        }
        if (a3.F.getChr() == null || a3.F.getChr().isInvited()) {
            return;
        }
        if (((MapleCharacter)a3.B.get()).getMeso() >= a2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\u8a2d\u5b9a\u6953\u5e63[" + a2 + "] \u8a2d\u5b9a\u524d\u6953\u5e63[" + ((MapleCharacter)a3.B.get()).getMeso() + "]");
            ((MapleCharacter)a3.B.get()).gainMeso(-a2, false, true, false);
            stringBuilder.append("\u8a2d\u5b9a\u5f8c\u6953\u5e63[" + ((MapleCharacter)a3.B.get()).getMeso() + "]");
            ((MapleCharacter)a3.B.get()).addTradeMsg(((MapleCharacter)a3.B.get()).getName(), stringBuilder.toString() + "\r\n");
            MapleTrade mapleTrade = a3;
            mapleTrade.e += a2;
            ((MapleCharacter)mapleTrade.B.get()).getClient().sendPacket(MaplePacketCreator.getTradeMesoSet((byte)0, a3.e));
            if (a3.F != null) {
                a3.F.getChr().getClient().sendPacket(MaplePacketCreator.getTradeMesoSet((byte)1, a3.e));
            }
        }
        if (a2 >= (n2 = GameSetConstants.checkMeso)) {
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + ((MapleCharacter)a3.B.get()).getName() + "\u7b49\u7d1a:" + ((MapleCharacter)a3.B.get()).getLevel() + "(\u7de8\u865f: " + ((MapleCharacter)a3.B.get()).getId() + ")\u6b63\u5728\u4ea4\u6613!\u6253\u7b97\u7d66\u4e88" + a3.F.getChr().getName() + "(\u7b49\u7d1a:" + a3.F.getChr().getLevel() + ")" + a2 + "\u6953\u5e63\uff0c\u5341\u5206\u53ef\u7591\u3002"));
            FileoutputUtil.logToFile(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"`8k$#\u001fm4gx\u757c\u5e6f\u695f\u5e34\u905f\u5120\u5079\u6e7b#\u5970\u91c3\u4ef3\u661f\u6904\u5e6fyx/x"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + ((MapleCharacter)a3.B.get()).getName() + "\u7b49\u7d1a:" + ((MapleCharacter)a3.B.get()).getLevel() + " (\u7de8\u865f: " + ((MapleCharacter)a3.B.get()).getId() + ")\u6b63\u5728\u4ea4\u6613!\u6253\u7b97\u7d66\u4e88" + a3.F.getChr().getName() + "(\u7b49\u7d1a:" + a3.F.getChr().getLevel() + ")" + a2 + "\u6953\u5e63");
        }
        if (((MapleCharacter)a3.B.get()).getClient().isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + ((MapleCharacter)a3.B.get()).getName() + "/\u4ea4\u6613\u6953\u5e63.txt", "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + ((MapleCharacter)a3.B.get()).getName() + "\u7b49\u7d1a:" + ((MapleCharacter)a3.B.get()).getLevel() + " (\u7de8\u865f: " + ((MapleCharacter)a3.B.get()).getId() + ")\u6b63\u5728\u4ea4\u6613!\u6253\u7b97\u7d66\u4e88" + a3.F.getChr().getName() + "(\u7b49\u7d1a:" + a3.F.getChr().getLevel() + ")" + a2 + "\u6953\u5e63");
        }
    }

    public static /* synthetic */ boolean isAbonormalTradeStatus(MapleTrade a2, MapleTrade a3) {
        if (a2 != null && a3 != null) {
            return a2.isCanceling() || a3.isCanceling() || a2.isCompleting() || a3.isCompleting();
        }
        if (a2 != null && a3 == null) {
            return a2.isCanceling() || a2.isCompleting();
        }
        if (a2 == null && a3 != null) {
            return a3.isCanceling() || a3.isCompleting();
        }
        if (a2 == null && a3 == null) {
            return true;
        }
        return true;
    }

    public final /* synthetic */ MapleTrade getPartner() {
        MapleTrade a2;
        return a2.F;
    }

    public final /* synthetic */ void cancel(MapleClient a2) {
        MapleTrade a3;
        a3.cancel(a2, false ? 1 : 0, false);
    }

    public /* synthetic */ boolean isCanceling() {
        MapleTrade a2;
        return a2.a;
    }

    public final /* synthetic */ void cancel(MapleClient a2, int a3, boolean a4) {
        MapleTrade a5;
        MapleClient mapleClient = a2;
        Object object = mapleClient.getPlayer().getTrade();
        Object object2 = ((MapleTrade)object).getPartner();
        int n2 = mapleClient.getPlayer().getMeso();
        if (((MapleTrade)object).isLocked() && ((MapleTrade)object2).isLocked() && a4 == 0) {
            a5.e = 0;
            a5.C.clear();
        }
        MapleTrade mapleTrade = a5;
        a4 = mapleTrade.e;
        object = "";
        if (mapleTrade.C != null) {
            Object object3 = object2 = a5.C.iterator();
            while (object3.hasNext()) {
                MapleClient mapleClient2;
                IItem iItem = (IItem)object2.next();
                String string = MapleItemInformationProvider.getInstance().getName(iItem.getItemId());
                if (!\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"9y;`").equals(string)) {
                    object = (String)object + string + "(" + iItem.getQuantity() + "), ";
                    mapleClient2 = a2;
                } else {
                    object = (String)object + iItem.getItemId() + "(" + iItem.getQuantity() + "), ";
                    mapleClient2 = a2;
                }
                MapleInventoryManipulator.addFromDrop(mapleClient2, iItem, false);
                object3 = object2;
            }
            a5.C.clear();
        }
        if (a2 != null && a2.getPlayer() != null && a5.e > 0) {
            a2.getPlayer().gainMeso(a5.e, false, true, false);
        }
        a5.e = 0;
        MapleClient mapleClient3 = a2;
        int n3 = mapleClient3.getPlayer().getMeso();
        mapleClient3.sendPacket(MaplePacketCreator.getTradeCancel(a5.k, a3));
        if (mapleClient3 != null && a2.getPlayer() != null) {
            ((MapleCharacter)a5.B.get()).addTradeMsg(((MapleCharacter)a5.B.get()).getName(), " \u4ea4\u6613\u9053\u5177,\u6536\u5230: " + (String)object + "\r\n");
            ((MapleCharacter)a5.B.get()).addTradeMsg(((MapleCharacter)a5.B.get()).getName(), " \u4ea4\u6613\u6953\u5e63,\u6536\u5230 " + a4 + " \u539f\u59cb\u6953\u5e63:" + n2 + " \u66f4\u8b8a\u5f8c\u6953\u5e63:" + n3 + "\r\n");
            ((MapleCharacter)a5.B.get()).addTradeMsg(((MapleCharacter)a5.B.get()).getName(), MobSkill.ALLATORIxDEMO("\n\u4e8e\u6639\u7d7a\u6775\u0006\u7d7a\u67b6\u0010\n\u4e8e\u6639\u591b\u657d' "));
        }
        if (((MapleCharacter)a5.B.get()).getClient().isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + ((MapleCharacter)a5.B.get()).getName() + "/\u4ea4\u6613\u6953\u5e63.txt", "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6: " + ((MapleCharacter)a5.B.get()).getName() + " \u62ff\u56de\u4e86\u9053\u5177: " + (String)object + "\r\n");
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + ((MapleCharacter)a5.B.get()).getName() + "/\u4ea4\u6613\u6953\u5e63.txt", "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6: " + ((MapleCharacter)a5.B.get()).getName() + " \u62ff\u56de\u4e86\u6953\u5e63: " + (a4 > 0 ? a4 : 0) + "\r\n");
        }
    }

    public final /* synthetic */ boolean setItems(MapleClient a2, IItem a3, byte a4, int a5) {
        Object object;
        Object object2;
        MapleTrade a6;
        block11: {
            byte by;
            int n2 = a6.getNextTargetSlot();
            object2 = MapleItemInformationProvider.getInstance();
            if (n2 == -1 || GameConstants.isPet(a3.getItemId()) || a6.isLocked() || GameConstants.getInventoryType(a3.getItemId()) == MapleInventoryType.CASH && a5 != 1 || GameConstants.getInventoryType(a3.getItemId()) == MapleInventoryType.EQUIP && a5 != 1) {
                return false;
            }
            int n3 = a3.getFlag();
            boolean bl = ItemFlag.UNTRADEABLE.check(n3);
            if (ItemFlag.KARMA_EQ.check(n3) || ItemFlag.KARMA_USE.check(n3)) {
                bl = false;
            }
            if (bl || ItemFlag.LOCK.check(n3)) {
                a2.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if ((((MapleItemInformationProvider)object2).isDropRestricted(a3.getItemId()) || ((MapleItemInformationProvider)object2).isAccountShared(a3.getItemId())) && !ItemFlag.KARMA_EQ.check(n3) && !ItemFlag.KARMA_USE.check(n3)) {
                a2.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            IItem iItem = a3;
            object2 = iItem.copy();
            if (GameConstants.isThrowingStar(iItem.getItemId()) || GameConstants.isBullet(a3.getItemId())) {
                object2.setQuantity(a3.getQuantity());
                by = a4;
                MapleInventoryManipulator.removeFromSlot(a2, GameConstants.getInventoryType(a3.getItemId()), a3.getPosition(), a3.getQuantity(), true);
            } else {
                object2.setQuantity((short)a5);
                by = a4;
                MapleInventoryManipulator.removeFromSlot(a2, GameConstants.getInventoryType(a3.getItemId()), a3.getPosition(), (short)a5, true);
            }
            if (by < 0) {
                a4 = (byte)n2;
                object = object2;
            } else {
                Iterator<IItem> iterator = a6.C.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getPosition() != a4) continue;
                    a4 = (byte)n2;
                    object = object2;
                    break block11;
                }
                object = object2;
            }
        }
        object.setPosition(a4);
        a6.addItem((IItem)object2);
        Map<Integer, Integer> map = CheckItemFactory.getItems();
        if (map.containsKey(a3.getItemId()) && a5 > map.get(a3.getItemId())) {
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + ((MapleCharacter)a6.B.get()).getName() + "\u7b49\u7d1a:" + ((MapleCharacter)a6.B.get()).getLevel() + "(\u7de8\u865f: " + ((MapleCharacter)a6.B.get()).getId() + ")\u6b63\u5728\u4ea4\u6613!\u6253\u7b97\u7d66\u4e88" + a6.F.getChr().getName() + "(\u7b49\u7d1a:" + a6.F.getChr().getLevel() + ")" + a5 + "\u5f35" + MapleItemInformationProvider.getInstance().getName(a3.getItemId()) + "\uff0c\u5341\u5206\u53ef\u7591\u3002"));
            FileoutputUtil.logToFile(MobSkill.ALLATORIxDEMO("FEMY\u0005bKIA\u0005\u755a\u5e12\u6979\u5e49\u9079\u515d\u505f\u6e06\u0005\u4e8e\u6639\u7243\u54eb\u6a88\u6e06\u0004^R^"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + ((MapleCharacter)a6.B.get()).getName() + "\u7b49\u7d1a:" + ((MapleCharacter)a6.B.get()).getLevel() + " (\u7de8\u865f: " + ((MapleCharacter)a6.B.get()).getId() + ")\u6b63\u5728\u4ea4\u6613!\u6253\u7b97\u7d66\u4e88" + a6.F.getChr().getName() + "(\u7b49\u7d1a:" + a6.F.getChr().getLevel() + ")" + a5 + "\u5f35" + MapleItemInformationProvider.getInstance().getName(a3.getItemId()));
            if (GameSetConstants.AUTOMONITOR && !a2.isMonitored() && !a2.isGm()) {
                a2.setMonitored(true);
            }
        }
        return true;
    }

    public static final /* synthetic */ void startTrade(MapleCharacter a2) {
        if (a2.getTrade() == null) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.setTrade(new MapleTrade(0, a2));
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.getTradeStart(a2.getClient(), a2.getTrade(), (byte)0));
            return;
        }
        a2.getClient().sendPacket(MaplePacketCreator.getErrorNotice(MobSkill.ALLATORIxDEMO("\u6082\u76c4\u5267\u5dd8\u7db9\u5702\u4e8e\u6639\u4eac")));
    }

    public static final /* synthetic */ void cancelTrade(MapleTrade a2, MapleClient a3) {
        MapleTrade mapleTrade = a2;
        MapleTrade mapleTrade2 = mapleTrade.getPartner();
        if (!MapleTrade.isAbonormalTradeStatus(mapleTrade, mapleTrade2)) {
            a2.setCanceling(true);
            if (mapleTrade2 != null) {
                mapleTrade2.setCanceling(true);
            }
            a2.cancel(a3);
            if (mapleTrade2 != null && mapleTrade2.getChr() != null) {
                if (mapleTrade2.getChr().getClient() != null && mapleTrade2.getChr().canTrade()) {
                    MapleTrade mapleTrade3 = mapleTrade2;
                    mapleTrade3.setCanceling(false);
                    mapleTrade3.cancel(mapleTrade3.getChr().getClient());
                    mapleTrade3.getChr().setTrade(null);
                    a2.getChr().addTradeMsg(a2.getChr().getName(), " \u78ba\u8a8d\u64cd\u4f5c \u8207" + mapleTrade2.getChr().getName() + "(" + mapleTrade2.getChr().getClient().getSessionIPAddress() + ")\u7684\u4ea4\u6613 \u7d50\u679c: \u53d6\u6d88\r\n");
                    a2.getChr().addEmptyTradeMsg(MobSkill.ALLATORIxDEMO("\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017\u0017' "));
                    mapleTrade2.getChr().addTradeMsg(mapleTrade2.getChr().getName(), " \u78ba\u8a8d\u64cd\u4f5c \u8207" + a2.getChr().getName() + "(" + a2.getChr().getClient().getSessionIPAddress() + ")\u7684\u4ea4\u6613 \u7d50\u679c: \u53d6\u6d88\r\n");
                    MapleTrade mapleTrade4 = mapleTrade2;
                    MapleTrade mapleTrade5 = a2;
                    mapleTrade2.getChr().addEmptyTradeMsg(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1j1Z\u0006"));
                    mapleTrade5.getChr().endTradeMsg(a2.getChr().getName());
                    mapleTrade4.getChr().endTradeMsg(mapleTrade2.getChr().getName());
                    mapleTrade4.getChr().settrading(false);
                    mapleTrade5.getChr().settrading(false);
                }
                mapleTrade2.setCanceling(false);
            }
            if (a2.B.get() != null) {
                ((MapleCharacter)a2.B.get()).setTrade(null);
            }
        }
    }
}

