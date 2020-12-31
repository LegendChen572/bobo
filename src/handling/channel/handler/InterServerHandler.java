/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u672a\u77e5\u8c37
 */
package handling.channel.handler;

import client.BuddyEntry;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleQuestStatus;
import client.MapleStat;
import client.SkillFactory;
import client.anticheat.CheatingOffense;
import client.inventory.MapleInventoryType;
import client.messages.commands.player.\u672a\u77e5\u8c37;
import constants.GameSetConstants;
import constants.ServerConfig;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.PartyOperation;
import handling.world.CharacterIdChannelPair;
import handling.world.CharacterTransfer;
import handling.world.MapleMessenger;
import handling.world.MapleMessengerCharacter;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.PlayerBuffStorage;
import handling.world.World;
import handling.world.exped.MapleExpedition;
import handling.world.guild.MapleGuild;
import handling.world.sidekick.MapleSidekick;
import handling.world.weather.WeatherHandler;
import java.io.Serializable;
import java.util.List;
import server.Extend.SpecialEquipFactory;
import server.Extend.SpecialItemFactory;
import server.MTSCart;
import server.Randomizer;
import server.maps.FieldLimitType;
import server.quest.MapleQuest;
import server.shops.HiredFishing;
import tools.FileoutputUtil;
import tools.IpGeoLocation;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;
import tools.packet.FamilyPacket;
import tools.packet.MTSCSPacket;

public class InterServerHandler {
    public static /* synthetic */ boolean checkArgState(MapleClient a2, int a3, CharacterTransfer a4) {
        if (a4 == null) {
            if (System.getProperty(String.valueOf(a3)) == null || !System.getProperty(String.valueOf(a3)).equals("1")) {
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getErrorNotice("[GM\u63d0\u9192] <\u9ed1\u983b\u8907\u88fd> \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID()));
                FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("-<& n\u001b 0*|\u8946\u88aen\u5332\u9e90\u9868\u763a\u5136o'9'"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
                System.out.println("[\u7591\u4f3c\u8907\u88fd]\u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
                a2.getSession().close();
                return true;
            }
            if (System.getProperty(a2.getAccountName().toLowerCase()) == null || !System.getProperty(a2.getAccountName().toLowerCase()).equals("1")) {
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getErrorNotice("[GM\u63d0\u9192] <\u9ed1\u983b\u8907\u88fd2> \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID()));
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"mZfF.}`Vj\u001a\u8906\u88c8.\u5354\u9ed0\u980e\u767a\u51503\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
                System.out.println("[\u7591\u4f3c\u8907\u88fd2]\u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
                a2.getSession().close();
                return true;
            }
            System.setProperty(String.valueOf(a3), String.valueOf(0));
            System.setProperty(String.valueOf(a2.getAccountName().toLowerCase()), String.valueOf(0));
        }
        return false;
    }

    public /* synthetic */ InterServerHandler() {
        InterServerHandler a2;
    }

    public static final /* synthetic */ void ChangeChannel(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4, boolean a5) {
        MapleClient mapleClient;
        if (!InterServerHandler.HandleInGame(a4, false, false)) {
            return;
        }
        MapleClient mapleClient2 = a3;
        ChannelServer channelServer = ChannelServer.getInstance(mapleClient2.getWorld(), -10);
        ChannelServer channelServer2 = ChannelServer.getInstance(mapleClient2.getWorld(), -20);
        boolean bl = false;
        boolean bl2 = false;
        if (channelServer != null) {
            boolean bl3 = bl = channelServer.getPlayerStorage().getCharacterById(a4.getId()) != null;
        }
        if (GameSetConstants.AUCTION_SERVER && channelServer2 != null) {
            bl2 = channelServer2.getPlayerStorage().getCharacterById(a4.getId()) != null;
        }
        int n2 = a2.readByte() + 1;
        int n3 = 0;
        if (a5) {
            n3 = a2.readInt();
        }
        if (a3.getCloseSession()) {
            return;
        }
        if (a5 && (n3 < 910000001 || n3 > 910000022)) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (GameSetConstants.isHell(n2) && GameSetConstants.HELLLIMIT_REBORN && !a4.isReborn()) {
            String string = MTSCart.ALLATORIxDEMO("\u60e9\u5c49\u676b\u5bdf\u6251\u8f1a\u755e\u007f\u4faf\u7da7\u4e4c\u8de0m\u7172\u6c94\u9061\u5124\u5763\u7305\u9868\u9012r");
            MapleClient mapleClient3 = a3;
            mapleClient3.getPlayer().dropMessage(-1, string);
            mapleClient3.getPlayer().dropMessage(5, string);
            mapleClient3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a4.hasBlockedInventory(true) || a4.getEventInstance() != null || a4.getMap() == null || FieldLimitType.ChannelSwitch.check(a4.getMap().getFieldLimit()) || bl || bl2) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter = a4;
        if (a5) {
            mapleCharacter.changeRoom(n2, n3, a5);
            mapleClient = a3;
        } else {
            mapleCharacter.changeChannel(n2);
            mapleClient = a3;
        }
        mapleClient.loadVip(a4.getAccountID());
    }

    public static /* synthetic */ boolean HandleInGame(MapleCharacter a2, boolean a3, boolean a42) {
        String string;
        Object a42 = "";
        String string2 = "";
        boolean bl = false;
        if (LoginServer.getDoubleLoginTime(a2.getClient().getAccID()) > 2) {
            a2.getCheatTracker().registerOffense(CheatingOffense.\u9ed1\u983b\u8907\u88fd, "\u5e33\u865f: " + a2.getClient().getAccountName());
            return false;
        }
        if (ServerConfig.isPvP(a2.getClient().getChannel(), a2.getMapId()) && ServerConfig.PVP_SYSTEM) {
            String string3 = string = GameSetConstants.PVP_MAP == 0 ? \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u980e\u9052") : MTSCart.ALLATORIxDEMO("\u5771\u5745");
            a42 = "\u89aa\u611b\u7684\u73a9\u5bb6\uff1a" + a2.getName() + " \u60a8\u597d \r\n\u672c" + string3 + "\u70ba" + LoginServer.getServerName() + "\u6bba\u4eba\u5340\r\n\u5728\u6b64" + string3 + "\u8005\u89d2\u8272\u53ef\u4e92\u76f8\u6bba\u5bb3\r\n\u5f85\u5728\u6b64\u983b\u9053\u8acb\u5c0f\u5fc3!";
        } else if (ServerConfig.isGamblingChannel(a2.getClient().getChannel()) && ServerConfig.GAMBLING_SYSTEM) {
            a42 = "\u89aa\u611b\u7684\u73a9\u5bb6\uff1a" + a2.getName() + " \u60a8\u597d \r\n\u672c\u983b\u9053\u70ba" + LoginServer.getServerName() + "\u8ced\u535a\u983b\u9053\r\n\u5728\u6b64\u983b\u9053\u8005\u53ef\u9032\u884c\u8ced\u535a\r\n\u8ced\u535a\u53ef\u80fd\u81f4\u5bcc\u4e5f\u53ef\u80fd\u8b93\u4eba\u60f3\u9000\u8c37!\r\n\u8acb\u52ff\u6c89\u8ff7!";
        } else if (GameSetConstants.LOGIN_MSG && !GameSetConstants.LOGIN_MSG_CONTENT.isEmpty() && a3) {
            a42 = GameSetConstants.LOGIN_MSG_CONTENT;
        } else if (GameSetConstants.isHell(a2.getClient().getChannel())) {
            if (GameSetConstants.HELLLIMIT_REBORN && !a2.isReborn()) {
                bl = true;
                string2 = \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u60a9\u5c2f\u672b\u5bb9\u6211\u8f7c\u751e\u0019\u4fef\u7dc1\u4e0c\u8d86-\u7114\u6cd4\u9007\u5164\u5705\u7345\u980e\u9052\u0014\u5df3\u81df\u52d4\u8fe1\u56df\u980e\u9052\u0004\u3003");
            }
            if (!bl) {
                a42 = "\u89aa\u611b\u7684\u73a9\u5bb6\uff1a" + a2.getName() + " \u60a8\u597d \r\n\u672c\u983b\u9053\u70ba" + LoginServer.getServerName() + "\u5730\u7344\u983b\u9053\r\n\u5728\u6b64\u983b\u9053\u7684\u602a\u7269\u6975\u70ba\u5f37\u608d\r\n\u8acb\u65b0\u624b\u5011\u8981\u7279\u5225\u5c0f\u5fc3!\r\n\u602a\u7269\u8840\u91cf\u500d\u7387:" + GameSetConstants.HELL_RATE[3] + "\u6389\u5bf6\u500d\u7387:" + GameSetConstants.HELL_RATE[1];
            }
        }
        if (GameSetConstants.WEATHER_SYSTEM && WeatherHandler.getWeather() != null) {
            a2.dropMessage(-1, "\u76ee\u524d\u5929\u6c23[" + WeatherHandler.getWeather().name() + "] \u6548\u679c: " + WeatherHandler.getWeather().getInfo());
        }
        if (!((String)a42).isEmpty()) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.dropMessage(-1, (String)a42);
            mapleCharacter.dropMessage(1, (String)a42);
        }
        if (bl && a3) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.dropMessage(5, string2);
            mapleCharacter.ForcechangeChannel(1);
        }
        if (GameSetConstants.LOGIN_SIGNLOG && a3) {
            MapleCharacter mapleCharacter = a2;
            string = mapleCharacter.addSignLog();
            mapleCharacter.dropMessage(-1, string);
        }
        if (GameSetConstants.YUTO_SHIELD_PROTECT != 0L) {
            a2.UpdateYutoShieldTime();
        }
        if (GameSetConstants.AUTO_SAVE > 0L) {
            a2.UpdateSaveTime();
        }
        return !bl;
    }

    public static /* synthetic */ boolean checkDoubleLogin(MapleClient a2, int a3, int a4, CharacterTransfer a5) {
        if (a4 != 1 && a5 == null) {
            LoginServer.addDoubleLoginTime(a2.getAccID());
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getErrorNotice("[GM\u63d0\u9192] <\u9ed1\u983b\u8907\u88fd_\u65b0> \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID()));
            FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aITb^.\u8932\u88fc\u001a\u5360\u9ee4\u983a\u764e\u5164j\u65b1\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
            System.out.println("[\u9ed1\u983b\u8907\u88fd_\u65b0]\u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
            a2.getSession().close();
            return true;
        }
        if (a4 == 1 && a5 != null) {
            LoginServer.addDoubleLoginTime(a2.getAccID());
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getErrorNotice("[GM\u63d0\u9192] <\u9ed1\u983b\u8907\u88fd_\u65b03> \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID()));
            FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\t2\"8n\u8954\u88bc|\u5320\u9e82\u987a\u7628\u5124\f\u65f1`o'9'"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
            System.out.println("[\u9ed1\u983b\u8907\u88fd_\u65b03]\u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
            a2.getSession().close();
            return true;
        }
        if (a4 != 1 && a4 != 6 && a4 != 9 && a4 != 10) {
            LoginServer.addDoubleLoginTime(a2.getAccID());
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getErrorNotice("[GM\u63d0\u9192] <\u9ed1\u983b\u8907\u88fd_\u65b02> \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID()));
            FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"mZfF.}`Vj\u001a\u8906\u88c8.\u5354\u9ed0\u980e\u767a\u5150^\u65853\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID() + "state:" + a4);
            System.out.println("[\u9ed1\u983b\u8907\u88fd_\u65b02]\u73a9\u5bb6id: " + a3 + " \u5e33\u865fid:" + a2.getAccID());
            a2.getSession().close();
            return true;
        }
        return false;
    }

    public static final /* synthetic */ void EnterCashShop(MapleClient a2, MapleCharacter a3) {
        if (a2.getCloseSession()) {
            return;
        }
        if (GameSetConstants.DCLOAD_SAVING && World.isPlayerSaving(a2.getAccID())) {
            FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\u0004+\"61'n\u5161\u5b19\u4e7e\u8f48\u5136o'9'"), FileoutputUtil.CurrentReadable_Time() + " \u89d2\u8272: " + a3.getId() + "\u5e33\u865f: " + a2.getAccountName() + " \u5546\u57ce\r\n ");
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aeTuT.qB\u001buMu"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a2.getSession().close();
            return;
        }
        int n2 = Randomizer.rand(1, 5);
        if (World.isShutDown && !a3.isGM()) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.serverBlocked(2));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!GameSetConstants.CASH_SHOP_SERVER && !a3.isGM()) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.serverBlocked(2));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.getPlayer().inMapleLand() && !a2.getPlayer().isGM() || a2.getPlayer().getMapId() == 220080001 && !a2.getPlayer().isGM()) {
            a2.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
            a2.getPlayer().dropMessage(5, MTSCart.ALLATORIxDEMO("\u76bd\u520c\u7172\u6c94\u4f2c\u7569\u8caf\u7228\u5515\u578f\u3051"));
            return;
        }
        if (GameSetConstants.FLY_CHAIR && a2.getPlayer().getFlyChairId() != 0) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().setFlyChairId(0);
            MapleBuffStat[] arrmapleBuffStat = new MapleBuffStat[1];
            arrmapleBuffStat[0] = MapleBuffStat.MONSTER_RIDING;
            mapleClient.getPlayer().cancelBuffStats(arrmapleBuffStat);
        }
        MapleClient mapleClient = a2;
        byte[] arrby = MTSCSPacket.warpCS(mapleClient, mapleClient.getcs());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleClient mapleClient2 = a2;
            arrby = MTSCSPacket.intoCs(mapleClient2, mapleClient2.getcs());
        }
        if (arrby.length >= 65535) {
            FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aDMbPqA.\u5573\u57cf\u7114\u6cd4\u9007\u5164\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6:" + a2.getPlayer().getName() + " \u591a\u9918\u5c01\u5305\u6578\u91cf: " + (arrby.length - 65535) + " \r\n");
            a2.getPlayer().dropMessage(5, "\u8acb\u5c07\u80cc\u5305\u7684\u6771\u897f\u6e1b\u5c11\u5f8c\u518d\u9032\u5165\u5546\u57ce(" + (arrby.length - 65535) + ")");
            a2.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a2.getPlayer().getChrInfo(MTSCart.ALLATORIxDEMO("\u9061\u5124\u5515\u578fs\b=563\u0000$!763\u001b =%?$!")));
        }
        try {
            int n3 = a3.saveToDB(false, false);
            if (n3 == 1) {
                a3.dropMessage(5, \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u89d3\u8247\u4fdc\u5b6d\u6211\u52aa\uff00"));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        ChannelServer channelServer = ChannelServer.getInstance(a2.getWorld(), a2.getChannel());
        if (a3 != null && channelServer != null) {
            MapleClient mapleClient3;
            MapleClient mapleClient4;
            Serializable serializable;
            MapleCharacter mapleCharacter = a3;
            MapleClient mapleClient5 = a2;
            MapleClient mapleClient6 = a2;
            World.addChangeChannel(mapleClient5.getAccID(), mapleClient6.getChannel());
            World.AddClientCsTransfer(mapleClient5.getAccountName());
            World.AddClientChannelTransfer(mapleClient6.getAccountName());
            mapleCharacter.changeRemoval();
            if (mapleCharacter.getMessenger() != null) {
                serializable = new MapleMessengerCharacter(a3);
                World.Messenger.leaveMessenger(a3.getMessenger().getId(), (MapleMessengerCharacter)serializable);
            }
            try {
                MapleCharacter mapleCharacter2 = a3;
                PlayerBuffStorage.addBuffsToStorage(mapleCharacter2.getId(), a3.getAllBuffs());
                PlayerBuffStorage.addStackBuffsToStorage(mapleCharacter2.getId(), a3.getSpecialBuffInfo());
                mapleClient4 = a2;
            }
            catch (Exception exception) {
                System.out.println(exception);
                mapleClient4 = a2;
            }
            serializable = ChannelServer.getInstance(mapleClient4.getWorld(), -10);
            MapleCharacter mapleCharacter3 = a3;
            PlayerBuffStorage.addCooldownsToStorage(a3.getId(), mapleCharacter3.getCooldowns());
            PlayerBuffStorage.addDiseaseToStorage(mapleCharacter3.getId(), a3.getAllDiseases());
            a2.getPlayer().setLoggedIn(false);
            try {
                World.channelChangeData(new CharacterTransfer(a3), a2, a3.getId(), a3.getWorld(), -10);
                mapleClient3 = a2;
            }
            catch (Exception exception) {
                mapleClient3 = a2;
                exception.printStackTrace();
            }
            mapleClient3.getPlayer().expirationTask(true, false);
            MapleClient mapleClient7 = a2;
            ChannelServer channelServer2 = channelServer;
            a2.setPlayer(null);
            channelServer2.removePlayer(a3);
            MapleCharacter mapleCharacter4 = a3;
            channelServer2.getPlayerStorage().registerPlayerTransfer(mapleCharacter4);
            MapleClient mapleClient8 = a2;
            mapleClient8.updateLoginState(6, mapleClient8.getSessionIPAddress());
            mapleCharacter4.getMap().removePlayer(a3);
            mapleClient7.sendPacket(MaplePacketCreator.getChannelChange(((ChannelServer)serializable).getSocket().split(MTSCart.ALLATORIxDEMO("i"))[0], Integer.parseInt(((ChannelServer)serializable).getSocket().split(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)";"))[1])));
            mapleClient7.setReceiving(false);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ void LoggedIn(int a2, MapleClient a3) {
        HiredFishing hiredFishing;
        Object object;
        MapleClient mapleClient;
        MapleCharacter mapleCharacter;
        MapleClient mapleClient2;
        CharacterTransfer characterTransfer;
        Object object2;
        long l2;
        long l3;
        block70: {
            l3 = System.currentTimeMillis();
            l2 = System.currentTimeMillis();
            if (a3.getCloseSession()) {
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aeTuT.qB\u001buMu"), "\r\n" + FileoutputUtil.CurrentReadable_Time() + "\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                return;
            }
            MapleClient mapleClient3 = a3;
            mapleClient3.loadAccountInfoByPlayerid(a2);
            if (World.Find.findDisconnect(mapleClient3.getAccID()) > 0) {
                System.out.println("(Loggedin) \u983b\u9053<" + a3.getChannel() + "> \u89d2\u8272\u8907\u88fd: " + a2 + " \u5e33\u865fid: " + a3.getAccID());
                FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\t2\"8n\u8954\u88bc|\u8993\u8221\u8946\u88aeo'9'"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a2 + " \u983b\u9053: " + a3.getChannel() + " \u5e33\u865fid: " + a3.getAccID() + " \u89d2\u8272\u8907\u88fd (Loggedin)");
                World.Find.forceDeregisterDisconnect(a3.getAccID());
                if (ServerConfig.LOG_DC) {
                    FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aeTuT.qB\u001buMu"), "\r\n" + FileoutputUtil.CurrentReadable_Time() + "\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                }
                a3.getSession().close();
                return;
            }
            if (!MapleCharacterUtil.isExistCharacterInDataBase(a2)) {
                System.out.println("<\u522a\u9664\u89d2\u8272> (Loggedin  \u983b\u9053<" + a3.getChannel() + ">\u89d2\u8272\u8907\u88fd: " + a2 + " \u5e33\u865fid: " + a3.getAccID());
                FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\t2\"8n\u8954\u88bc|\u8993\u8221\u8946\u88aeo'9'"), FileoutputUtil.CurrentReadable_Time() + " <\u522a\u9664\u89d2\u8272\u8907\u88fd> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID());
                if (ServerConfig.LOG_DC) {
                    FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aeTuT.qB\u001buMu"), "\r\n" + FileoutputUtil.CurrentReadable_Time() + "\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                }
                a3.getSession().close();
                return;
            }
            object2 = a3.getChannelServer();
            characterTransfer = null;
            for (World world : LoginServer.getWorlds()) {
                for (ChannelServer channelServer : world.getChannels()) {
                    characterTransfer = channelServer.getPlayerStorage().getPendingCharacter(a2);
                    if (characterTransfer == null) continue;
                    mapleClient2 = a3;
                    break block70;
                }
            }
            mapleClient2 = a3;
        }
        byte by = mapleClient2.getLoginState();
        if (GameSetConstants.LOGIN_CHECK) {
            if (InterServerHandler.checkArgState(a3, a2, characterTransfer)) {
                return;
            }
            if (InterServerHandler.checkDoubleLogin(a3, a2, by, characterTransfer)) {
                return;
            }
            if (by != 1 && characterTransfer == null) {
                FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\t2\"8n\u8954\u88bc|\u763a\u5136\u8946\u88aeo'9'"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a2 + "\u539f\u56e0 : state != MapleClient.LOGIN_SERVER_TRANSITION && transfer == null");
                a3.getSession().close();
                return;
            }
            if (by == 1 && characterTransfer != null) {
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"mZfF.}`Vj\u001a\u8906\u88c8.\u764e\u5164\u8932\u88fc\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a2 + "\u539f\u56e0 : state == MapleClient.LOGIN_SERVER_TRANSITION && transfer != null");
                a3.getSession().close();
                return;
            }
            if (by != 1 && by != 6 && by != 9 && by != 10) {
                FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\t2\"8n\u8954\u88bc|\u763a\u5136\u8946\u88aeo'9'"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + a2 + "\u539f\u56e0 : state != MapleClient.LOGIN_SERVER_TRANSITION && state != MapleClient.CHANGE_CHANNEL && state != MapleClient.CASH_SHOP_TRANSITION_LEAVE && state != MapleClient.MAPLE_TRADE_TRANSITION_LEAVE");
                a3.getSession().close();
                return;
            }
        }
        if (characterTransfer == null) {
            LoginServer.removeClient(a3);
            mapleCharacter = MapleCharacter.loadCharFromDB(a2, a3, true);
            if (GameSetConstants.CHECK_MESO) {
                mapleCharacter.checkMeso();
            }
            mapleCharacter.setBuff(true);
        } else {
            mapleCharacter = MapleCharacter.ReconstructChr(characterTransfer, a3, true);
            if (!World.inClientChannelTransfer(mapleCharacter.getClient().getAccountName())) {
                System.out.println("<\u63db\u983b\u5361\u9ed1\u767b\u5165> (Loggedin  \u983b\u9053<" + a3.getChannel() + ">\u89d2\u8272\u8907\u88fd: " + a2 + " \u5e33\u865fid: " + a3.getAccID());
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"mZfF.}`Vj\u001a\u8906\u88c8.\u63ee\u983a\u5354\u9ed0\u764e\u5164\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " <\u63db\u983b\u5361\u9ed1\u767b\u5165> \u73a9\u5bb6id: " + a2 + " \u5e33\u865fid:" + a3.getAccID());
                World.removeClientChannelTransfer(mapleCharacter.getClient().getAccountName());
                a3.getSession().close();
                return;
            }
            World.removeClientChannelTransfer(mapleCharacter.getClient().getAccountName());
        }
        if (GameSetConstants.DCLOAD_LOGIN_SAVING && World.isPlayerSaving(a3.getAccID())) {
            FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\u0004+\"61'n\u5161\u5b19\u4e7e\u8f48\u5136o'9'"), FileoutputUtil.CurrentReadable_Time() + " \u89d2\u8272: " + a2 + "\u5e33\u865f: " + a3.getAccountName() + " \u904a\u6232\u9032\u5165\r\n ");
            a3.getSession().close();
            return;
        }
        if (characterTransfer == null) {
            MapleClient mapleClient4 = a3;
            LoginServer.forceRemoveClient(mapleClient4, false);
            ChannelServer.forceRemovePlayerByAccId(mapleClient4, mapleClient4.getAccID());
        }
        MapleClient mapleClient5 = a3;
        ChannelServer.forceRemovePlayerByIPandMac(mapleClient5, mapleClient5.getSessionIPAddress(), a3.getClientMac());
        if (GameSetConstants.CHECKIP_ADRESS && (!GameSetConstants.FOWARD_PROTECT || GameSetConstants.PROXY_IP) && !a3.CheckIPAddress()) {
            a3.getSession().close();
            if (GameSetConstants.LOG_DC) {
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aeTuT.qB\u001buMu"), "\r\n \u6642\u9593:" + FileoutputUtil.NowTime() + "\u5e33\u865f[" + a3.getAccountName() + "]\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            return;
        }
        int n2 = World.getChangeChannel(mapleCharacter.getClient().getAccID());
        if (characterTransfer != null) {
            if (!ChannelServer.containsPlayerTransfer(mapleCharacter.getId())) {
                a3.getSession().close();
                FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\t2\"8n\u8954\u88bc|\u9e90\u9868\u8946\u88aeo'9'"), FileoutputUtil.CurrentReadable_Time() + " <\u63db\u983b\u8907\u88fd> \u73a9\u5bb6\u540d\u7a31: " + mapleCharacter.getName() + " id: " + a2 + " \u7570\u5e38\u539f\u56e0: PlayerTransfer \u4e0d\u5b58\u5728 channelw:" + n2);
                return;
            }
            if (n2 == 0) {
                MapleClient mapleClient6 = a3;
                World.AddClientRemove(mapleClient6.getAccID());
                mapleClient6.getSession().close();
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"mZfF.}`Vj\u001a\u8906\u88c8.\u63ee\u983a\u8932\u88fc\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " <\u63db\u983b\u8907\u88fd> \u73a9\u5bb6\u540d\u7a31: " + mapleCharacter.getName() + " id: " + a2 + " \u7570\u5e38\u539f\u56e0: \u63db\u983b\u72c0\u614b channelw = 0");
                return;
            }
            if (n2 != mapleCharacter.getClient().getChannel()) {
                MapleClient mapleClient7 = a3;
                World.AddClientRemove(mapleClient7.getAccID());
                mapleClient7.getSession().close();
                FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\t2\"8n\u8954\u88bc|\u639a\u9868\u8946\u88aeo'9'"), FileoutputUtil.CurrentReadable_Time() + " <\u63db\u983b\u8907\u88fd> \u73a9\u5bb6\u540d\u7a31: " + mapleCharacter.getName() + " id: " + a2 + " \u7570\u5e38\u539f\u56e0: \u4f54\u5b58\u5668\u983b\u9053:" + n2 + " \u89d2\u8272\u9032\u5165\u983b\u9053:" + mapleCharacter.getClient().getChannel() + " \u4e0d\u76f8\u7b26!");
                return;
            }
            World.removeChangeChannel(mapleCharacter.getClient().getAccID());
            mapleClient = a3;
        } else {
            if (n2 != 0) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                World.removeChangeChannel(mapleCharacter2.getClient().getAccID());
                ChannelServer.RemoveChrTransfer(mapleCharacter2.getClient().getAccID());
                int n3 = n2;
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"mZfF.}`Vj\u001a\u8906\u88c8.\u63ee\u983a\u8932\u88fc\u001buMu"), FileoutputUtil.CurrentReadable_Time() + " <\u63db\u983b\u8907\u88fd> \u73a9\u5bb6\u540d\u7a31: " + mapleCharacter.getName() + " id: " + a2 + " \u7570\u5e38\u539f\u56e0: \u4f54\u5b58\u5668\u983b\u9053:" + n3 + " \u89d2\u8272\u525b\u767b\u5165 \u4f54\u5b58\u5668\u503c:" + n3 + " (\u56b4\u5224\u63db\u983b\u5361\u9ed1\u5f37\u767b)");
                if (GameSetConstants.CHANGE_CHANNEL_CHECK) {
                    a3.getSession().close();
                    return;
                }
            } else if (GameSetConstants.IP_GEO_SYSTEM) {
                IpGeoLocation.addPlayerLocation(mapleCharacter);
            }
            mapleClient = a3;
        }
        mapleClient.setPlayer(mapleCharacter);
        MapleClient mapleClient8 = a3;
        mapleClient8.setAccID(mapleCharacter.getAccountID());
        mapleClient8.loadAccountData(mapleCharacter.getAccountID());
        try {
            if (GameSetConstants.LOG_LOGIN) {
                FileoutputUtil.logToFile("logs/\u73a9\u5bb6\u7d00\u9304/\u983b\u9053\u767b\u5165/" + mapleCharacter.getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u5e33\u865f:" + mapleCharacter.getClient().getAccountName() + "(" + mapleCharacter.getAccountID() + ") \u89d2\u8272:" + mapleCharacter.getName() + "(" + mapleCharacter.getId() + ") \u8077\u696d: " + mapleCharacter.getJob() + " \u5730\u5716: " + mapleCharacter.getMap().getMapName() + "(" + mapleCharacter.getMapId() + ") \u9032\u5165\u983b\u9053 " + mapleCharacter.getClient().getChannel());
            }
            if (a3.getPlayer() != null && a3.isMonitored()) {
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u983b\u9053\u767b\u5165.txt", a3.getPlayer().getChrInfo("\u9032\u5165\u983b\u9053 " + mapleCharacter.getClient().getChannel() + " (LoggedIn)"));
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo("\u9032\u5165\u983b\u9053 " + mapleCharacter.getClient().getChannel() + " (LoggedIn)"));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        a3.updateLoginState(2, a3.getSessionIPAddress());
        MapleCharacter mapleCharacter3 = mapleCharacter;
        MapleCharacter mapleCharacter4 = mapleCharacter;
        mapleCharacter4.getStat().recalcLocalStats();
        ((ChannelServer)object2).addPlayer(mapleCharacter4);
        ChannelServer.deregisterAllPlayerTransfer(mapleCharacter3.getId());
        mapleCharacter3.setTransferTime(-1L);
        a3.sendPacket(MaplePacketCreator.getCharInfo(mapleCharacter3));
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            mapleCharacter.reloadAllSkills();
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a3.sendPacket(MTSCSPacket.enableCSUse());
        }
        a3.sendPacket(MaplePacketCreator.temporaryStats_Reset());
        mapleCharacter.getMap().addPlayer(mapleCharacter);
        try {
            Object object3;
            MapleCharacter mapleCharacter5;
            block73: {
                block71: {
                    block74: {
                        block72: {
                            MapleCharacter mapleCharacter6 = mapleCharacter;
                            int n4 = mapleCharacter6.getStat().hp;
                            int n5 = mapleCharacter6.getStat().mp;
                            mapleCharacter6.getStat().hp = n4;
                            mapleCharacter6.getStat().mp = n5;
                            mapleCharacter6.updateSingleStat(MapleStat.HP, n4);
                            mapleCharacter6.updateSingleStat(MapleStat.MP, n5);
                            if (mapleCharacter6.isAdmin() && !mapleCharacter.isInvincible()) {
                                MapleCharacter mapleCharacter7 = mapleCharacter;
                                mapleCharacter7.dropMessage(6, MTSCart.ALLATORIxDEMO("\u7172\u6534\u5da1\u7dd2\u95d8\u551e}"));
                                mapleCharacter7.setInvincible(true);
                            }
                            if (mapleCharacter.isGM()) {
                                SkillFactory.getSkill(9001004).getEffect(1).applyTo(mapleCharacter);
                            }
                            if (GameSetConstants.SERVER_NAME.equals(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u6952\u4e7e\u75d4"))) break block71;
                            if (mapleCharacter.getJob() / 100 != 2) break block72;
                            if (mapleCharacter.getSkillLevel(2001002) <= 0) break block71;
                            SkillFactory.getSkill(2001002).getEffect(mapleCharacter.getSkillLevel(2001002)).applyTo(mapleCharacter);
                            mapleCharacter5 = mapleCharacter;
                            break block73;
                        }
                        if (mapleCharacter.getJob() / 100 != 12) break block74;
                        if (mapleCharacter.getSkillLevel(12001001) <= 0) break block71;
                        SkillFactory.getSkill(12001001).getEffect(mapleCharacter.getSkillLevel(12001001)).applyTo(mapleCharacter);
                        mapleCharacter5 = mapleCharacter;
                        break block73;
                    }
                    if (mapleCharacter.getJob() / 100 == 4 && GameSetConstants.SERVER_NAME.equals(MTSCart.ALLATORIxDEMO("\u7dec\u5949\u5268\u4ecd")) && mapleCharacter.getSkillLevel(4001003) > 0) {
                        SkillFactory.getSkill(4001003).getEffect(mapleCharacter.getSkillLevel(4001003)).applyTo(mapleCharacter);
                        MapleBuffStat[] arrmapleBuffStat = new MapleBuffStat[1];
                        arrmapleBuffStat[0] = MapleBuffStat.DARKSIGHT;
                        mapleCharacter.cancelBuffStats(arrmapleBuffStat);
                    }
                }
                mapleCharacter5 = mapleCharacter;
            }
            mapleCharacter5.silentGiveBuffs(PlayerBuffStorage.getBuffsFromStorage(mapleCharacter.getId()));
            MapleCharacter mapleCharacter8 = mapleCharacter;
            mapleCharacter8.setBuff(false);
            mapleCharacter8.giveCoolDowns(PlayerBuffStorage.getCooldownsFromStorage(mapleCharacter8.getId()), true);
            mapleCharacter8.giveSilentDebuff(PlayerBuffStorage.getDiseaseFromStorage(mapleCharacter8.getId()));
            object = mapleCharacter8.getBuddylist().getBuddiesIds();
            World.Buddy.loggedOn(mapleCharacter8.getName(), mapleCharacter.getId(), a3.getChannel(), object, mapleCharacter.getGMLevel(), mapleCharacter.isHidden());
            if (mapleCharacter8.getParty() != null) {
                MapleExpedition mapleExpedition;
                MapleCharacter mapleCharacter9 = mapleCharacter;
                object2 = mapleCharacter9.getParty();
                World.Party.updateParty(mapleCharacter9.getParty().getId(), PartyOperation.LOG_ONOFF, new MaplePartyCharacter(mapleCharacter));
                if (GameSetConstants.MAPLE_VERSION >= 134 && object2 != null && ((MapleParty)object2).getExpeditionId() > 0 && (mapleExpedition = World.Party.getExped(((MapleParty)object2).getExpeditionId())) != null) {
                    a3.sendPacket(MaplePacketCreator.expeditionStatus(mapleExpedition, false));
                }
            }
            Object object4 = object2 = World.Find.multiBuddyFind(mapleCharacter.getId(), object);
            int n6 = ((CharacterIdChannelPair[])object4).length;
            int n7 = n2 = 0;
            while (n7 < n6) {
                CharacterIdChannelPair characterIdChannelPair = object4[n2];
                MapleCharacter mapleCharacter10 = mapleCharacter;
                object3 = mapleCharacter10.getBuddylist().get(characterIdChannelPair.getCharacterId());
                ((BuddyEntry)object3).setChannel(characterIdChannelPair.getChannel());
                mapleCharacter10.getBuddylist().put((BuddyEntry)object3);
                n7 = ++n2;
            }
            a3.sendPacket(MaplePacketCreator.updateBuddylist(mapleCharacter.getBuddylist().getBuddies()));
            object4 = mapleCharacter.getMessenger();
            if (object4 != null) {
                Object object5 = object4;
                World.Messenger.silentJoinMessenger(((MapleMessenger)object5).getId(), new MapleMessengerCharacter(a3.getPlayer()));
                World.Messenger.updateMessenger(((MapleMessenger)object5).getId(), a3.getPlayer().getName(), a3.getWorld(), a3.getChannel());
            }
            if (mapleCharacter.getGuildId() > 0) {
                MapleCharacter mapleCharacter11 = mapleCharacter;
                World.Guild.setGuildMemberOnline(mapleCharacter11.getMGC(), true, a3.getChannel());
                a3.sendPacket(MaplePacketCreator.showGuildInfo(mapleCharacter11));
                object2 = World.Guild.getGuild(mapleCharacter11.getGuildId());
                if (object2 != null) {
                    List<byte[]> list = World.Alliance.getAllianceInfo(((MapleGuild)object2).getAllianceId(), true);
                    if (list != null) {
                        for (byte[] arrby : list) {
                            object3 = arrby;
                            if (arrby == null) continue;
                            a3.sendPacket((byte[])object3);
                        }
                    }
                } else {
                    MapleCharacter mapleCharacter12 = mapleCharacter;
                    mapleCharacter.setGuildId(0);
                    mapleCharacter12.setGuildRank((byte)5);
                    mapleCharacter12.setAllianceRank((byte)5);
                    mapleCharacter.saveGuildStatus();
                }
            } else {
                a3.sendPacket(MaplePacketCreator.\u52f3\u7ae0(mapleCharacter));
            }
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                if (mapleCharacter.getFamilyId() > 0) {
                    World.Family.setFamilyMemberOnline(mapleCharacter.getMFC(), true, a3.getChannel());
                }
                a3.sendPacket(FamilyPacket.getFamilyData());
                a3.sendPacket(FamilyPacket.getFamilyInfo(mapleCharacter));
            }
        }
        catch (Exception exception) {
            FileoutputUtil.outputFileError("LoginError.txt", exception);
        }
        if (GameSetConstants.DEBUG_DC && mapleCharacter.isGM()) {
            System.out.println("LoggedIn-10:" + (System.currentTimeMillis() - l2));
            l2 = System.currentTimeMillis();
        }
        MapleCharacter mapleCharacter13 = mapleCharacter;
        mapleCharacter13.sendMacros();
        mapleCharacter13.sendImp();
        mapleCharacter13.showNote();
        mapleCharacter13.updatePartyMemberHP();
        if (LoginServer.CanFairy(mapleCharacter13.getId())) {
            LoginServer.addFairy((byte)0, mapleCharacter.getId());
        }
        MapleCharacter mapleCharacter14 = mapleCharacter;
        mapleCharacter14.startFairySchedule(false, true);
        mapleCharacter14.baseSkills();
        a3.sendPacket(MaplePacketCreator.getKeymap(mapleCharacter.getKeyLayout()));
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            a3.sendPacket(MaplePacketCreator.getInventoryStatus());
        }
        a3.sendPacket(MaplePacketCreator.OnClaimSvrStatusChanged(true));
        MapleCharacter mapleCharacter15 = mapleCharacter;
        mapleCharacter15.getInventory(MapleInventoryType.ETC).initBagItem();
        mapleCharacter15.updatePetAuto();
        for (MapleQuestStatus mapleQuestStatus : mapleCharacter15.getStartedQuests()) {
            if (!mapleQuestStatus.hasMobKills()) continue;
            a3.sendPacket(MaplePacketCreator.updateQuestMobKills(mapleQuestStatus));
        }
        BuddyEntry buddyEntry = mapleCharacter.getBuddylist().pollPendingRequest();
        if (buddyEntry != null) {
            mapleCharacter.getBuddylist().put(new BuddyEntry(buddyEntry.getName(), buddyEntry.getCharacterId(), buddyEntry.getGroup(), -1, -1, false, buddyEntry.getLevel(), buddyEntry.getJob(), buddyEntry.getSub()));
            a3.sendPacket(MaplePacketCreator.requestBuddylistAdd(buddyEntry.getCharacterId(), buddyEntry.getName(), buddyEntry.getLevel(), buddyEntry.getJob(), buddyEntry.getSub()));
        }
        if (mapleCharacter.canBerserk()) {
            mapleCharacter.doBerserk();
        }
        MapleCharacter mapleCharacter16 = mapleCharacter;
        mapleCharacter16.spawnClones();
        mapleCharacter16.spawnSavedPets();
        mapleCharacter16.selectExpChair();
        mapleCharacter16.handleResetDay();
        if (GameSetConstants.COPTITEMCHECK_STRICT) {
            mapleCharacter.checkCopyItems(true);
        }
        a3.setInGame(true);
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            MapleClient mapleClient9 = a3;
            mapleClient9.sendPacket(MaplePacketCreator.showAnyWhereDoor(a3.getPlayer().getAnyWhereDoor(), mapleClient9.getPlayer().getAnyWhereDoorCash()));
            mapleCharacter.applyItemCooldowns();
        }
        if (mapleCharacter.getMaxDamage() > 0) {
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.sendDamage(mapleCharacter.getMaxDamage()));
        }
        if (mapleCharacter.getEquipDamage() > 0) {
            MapleCharacter mapleCharacter17 = mapleCharacter;
            long l4 = (long)mapleCharacter17.getEquipDamage() + GameSetConstants.MAX_DAMAGE;
            mapleCharacter17.getClient().sendPacket(MaplePacketCreator.sendDamage((int)(l4 > Integer.MAX_VALUE ? Integer.MAX_VALUE : l4)));
        }
        if (GameSetConstants.SPECIAL_EQUIP) {
            SpecialEquipFactory.getInstance().getTotalEquipSkill(mapleCharacter);
        }
        if (GameSetConstants.SPECIAL_ITEM) {
            SpecialItemFactory.getInstance().handleBuff(mapleCharacter);
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleQuestStatus mapleQuestStatus = mapleCharacter.getQuestNoAdd(MapleQuest.getInstance(122700));
            a3.sendPacket(MaplePacketCreator.pendantSlot(mapleQuestStatus != null && mapleQuestStatus.getCustomData() != null && Long.parseLong(mapleQuestStatus.getCustomData()) > System.currentTimeMillis()));
            mapleQuestStatus = mapleCharacter.getQuestNoAdd(MapleQuest.getInstance(123000));
            a3.sendPacket(MaplePacketCreator.quickSlot(mapleQuestStatus != null && mapleQuestStatus.getCustomData() != null && mapleQuestStatus.getCustomData().length() == 8 ? mapleQuestStatus.getCustomData() : null));
            if (mapleCharacter.getSidekick() == null && (object = World.Sidekick.getSidekickByChr(mapleCharacter.getId())) != null) {
                mapleCharacter.setSidekick((MapleSidekick)object);
            }
            if (mapleCharacter.getSidekick() != null) {
                MapleCharacter mapleCharacter18 = mapleCharacter;
                a3.sendPacket(MaplePacketCreator.updateSidekick(mapleCharacter18, mapleCharacter18.getSidekick(), false));
            }
        }
        if ((hiredFishing = World.hasFishing(mapleCharacter.getAccountID())) != null) {
            MapleCharacter mapleCharacter19 = mapleCharacter;
            mapleCharacter19.setPlayerFishing(hiredFishing);
            mapleCharacter19.startHiredFishingTask();
        }
        a3.sendPacket(MaplePacketCreator.clearMidMsg());
        InterServerHandler.HandleInGame(mapleCharacter, characterTransfer == null, true);
        LoginServer.removeLoginKey(a3);
        mapleCharacter.setLoggedIn(true);
        mapleCharacter.dropGMMessage("LoggedIn \u6642\u9593: " + (System.currentTimeMillis() - l3) + " \u6beb\u79d2");
    }

    public static final /* synthetic */ void EnterMTS(MapleClient a2, MapleCharacter a3) {
        if (a2.getCloseSession()) {
            return;
        }
        if (GameSetConstants.DCLOAD_SAVING && World.isPlayerSaving(a2.getAccID())) {
            FileoutputUtil.logToFile(MTSCart.ALLATORIxDEMO("?.42|\u0004+\"61'n\u5161\u5b19\u4e7e\u8f48\u5136o'9'"), FileoutputUtil.CurrentReadable_Time() + " \u89d2\u8272: " + a3.getId() + "\u5e33\u865f: " + a2.getAccountName() + " \u62cd\u8ce3\r\n ");
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"YnRr\u001aeTuT.qB\u001buMu"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a2.getSession().close();
            return;
        }
        int n2 = Randomizer.rand(1, 5);
        if (World.isShutDown && !a3.isGM()) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.serverBlocked(2));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.getPlayer().inMapleLand() && !a2.getPlayer().isGM() || a2.getPlayer().getMapId() == 220080001 && !a2.getPlayer().isGM()) {
            a2.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
            a2.getPlayer().dropMessage(5, MTSCart.ALLATORIxDEMO("\u76bd\u520c\u7172\u6c94\u4f2c\u7569\u8caf\u7228\u5515\u578f\u3051"));
            return;
        }
        if (a2.isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a2.getPlayer().getChrInfo(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u9007\u5164\u62f8\u8ce2")));
        }
        try {
            n2 = a3.saveToDB(false, false);
            if (n2 == 1) {
                a3.dropMessage(5, MTSCart.ALLATORIxDEMO("\u8981\u8233\u4f8e\u5b19\u6243\u52de\uff52"));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        MapleClient mapleClient = a2;
        ChannelServer channelServer = ChannelServer.getInstance(mapleClient.getWorld(), a2.getChannel());
        ChannelServer channelServer2 = ChannelServer.getInstance(mapleClient.getWorld(), -10);
        if (a3 != null && channelServer != null) {
            MapleCharacter mapleCharacter = a3;
            World.addChangeChannel(a2.getAccID(), a2.getChannel());
            mapleCharacter.changeRemoval();
            if (mapleCharacter.getMessenger() != null) {
                MapleMessengerCharacter mapleMessengerCharacter = new MapleMessengerCharacter(a3);
                World.Messenger.leaveMessenger(a3.getMessenger().getId(), mapleMessengerCharacter);
            }
            MapleCharacter mapleCharacter2 = a3;
            MapleCharacter mapleCharacter3 = a3;
            PlayerBuffStorage.addBuffsToStorage(mapleCharacter2.getId(), mapleCharacter3.getAllBuffs());
            PlayerBuffStorage.addStackBuffsToStorage(mapleCharacter2.getId(), a3.getSpecialBuffInfo());
            PlayerBuffStorage.addCooldownsToStorage(mapleCharacter3.getId(), a3.getCooldowns());
            PlayerBuffStorage.addDiseaseToStorage(mapleCharacter2.getId(), a3.getAllDiseases());
            World.channelChangeData(new CharacterTransfer(a3), a2, a3.getId(), a3.getWorld(), -20);
            channelServer.removePlayer(mapleCharacter2);
            MapleClient mapleClient2 = a2;
            mapleClient2.updateLoginState(6, mapleClient2.getSessionIPAddress());
            a3.getMap().removePlayer(a3);
            MapleClient mapleClient3 = a2;
            MapleClient mapleClient4 = a2;
            mapleClient4.sendPacket(MaplePacketCreator.getChannelChange(channelServer2.getSocket().split(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)";"))[0], Integer.parseInt(channelServer2.getSocket().split(MTSCart.ALLATORIxDEMO("i"))[1])));
            mapleClient4.getPlayer().expirationTask(true, false);
            mapleClient3.setPlayer(null);
            mapleClient3.setReceiving(false);
        }
    }
}

