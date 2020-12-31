/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 *  client.messages.commands.player.\u6070\u6070\u8c37
 *  com.mysql.jdbc.PreparedStatement
 */
package client.messages.commands;

import client.MapleCharacter;
import client.MapleDiseaseValueHolder;
import client.anticheat.CheatingOffenseEntry;
import client.inventory.MapleAndroid;
import client.inventory.MaplePet;
import client.messages.ConsoleCommandExecute;
import client.messages.commands.player.eventSystem.MapOwner;
import client.messages.commands.player.\u592d\u58fd\u8c37;
import client.messages.commands.player.\u6070\u6070\u8c37;
import com.mysql.jdbc.PreparedStatement;
import constants.GameSetConstants;
import constants.SpecialSkillConstants;
import constants.skills.SkillType;
import database.DBConPool;
import database.DatabaseConnection;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import handling.channel.ChannelServer;
import handling.channel.handler.BBSHandler;
import handling.channel.handler.PlayersHandler;
import handling.login.LoginServer;
import handling.world.World;
import handling.world.sidekick.MapleSidekick;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import scripting.portal.PortalScriptManager;
import scripting.reactor.ReactorScriptManager;
import server.Auction.AuctionItemFactory;
import server.CashItemFactory;
import server.FishingRewardFactory;
import server.Framework.MapleExtendedSlots;
import server.MTSStorage;
import server.MapleShopFactory;
import server.ShutdownServer;
import server.StructRewardItem;
import server.Timer;
import server.life.MapleMonsterInformationProvider;
import server.maps.MapleMapEffect;
import server.shark.SharkReader;
import server.shops.MaplePlayerShopItem;
import tools.MaplePacketCreator;
import tools.StringUtil;
import tools.otp.HmacOneTimePasswordGenerator;
import tools.packet.MTSCSPacket;

public class ConsoleCommand {
    public /* synthetic */ ConsoleCommand() {
        ConsoleCommand a2;
    }

    public static class dumpip
    extends ConsoleCommandExecute {
        public /* synthetic */ dumpip() {
            dumpip a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            AuctionItemFactory.getInstance().saveAuctionItem();
            return true;
        }
    }

    public static class ReloadEvents
    extends ConsoleCommandExecute {
        public /* synthetic */ ReloadEvents() {
            ReloadEvents a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            Iterator<ChannelServer> iterator;
            Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
            while (iterator2.hasNext()) {
                iterator.next().reloadEvents();
                iterator2 = iterator;
            }
            return true;
        }
    }

    public static class ReloadFishing
    extends ConsoleCommandExecute {
        public /* synthetic */ ReloadFishing() {
            ReloadFishing a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            FishingRewardFactory.getInstance().reloadItems();
            return true;
        }
    }

    public static class ReloadCS
    extends ConsoleCommandExecute {
        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            CashItemFactory.getInstance().clearItems();
            return true;
        }

        public /* synthetic */ ReloadCS() {
            ReloadCS a2;
        }
    }

    public static class ReloadShops
    extends ConsoleCommandExecute {
        public /* synthetic */ ReloadShops() {
            ReloadShops a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            MapleShopFactory.getInstance().clear();
            return true;
        }
    }

    public static class ReloadPortals
    extends ConsoleCommandExecute {
        public /* synthetic */ ReloadPortals() {
            ReloadPortals a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            PortalScriptManager.getInstance().clearScripts();
            return true;
        }
    }

    public static class ReloadDrops
    extends ConsoleCommandExecute {
        public /* synthetic */ ReloadDrops() {
            ReloadDrops a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            MapleMonsterInformationProvider.getInstance().clearDrops();
            ReactorScriptManager.getInstance().clearDrops();
            return true;
        }
    }

    public static class ReloadOps
    extends ConsoleCommandExecute {
        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            SendPacketOpcode.reloadValues();
            RecvPacketOpcode.reloadValues();
            return true;
        }

        public /* synthetic */ ReloadOps() {
            ReloadOps a2;
        }
    }

    public static class Say
    extends ConsoleCommandExecute {
        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            if (a2.length <= 1) {
                System.out.println(PlayersHandler.ALLATORIxDEMO("\u6301\u4ece\u8989\u526d<\nuK\u007f\n:GcYuKaO8"));
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"/\u4f5c\u6779\u560e\u5118\u542c)F"));
            stringBuilder.append(StringUtil.joinStringFrom(a2, 1));
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(stringBuilder.toString()));
            return true;
        }

        public /* synthetic */ Say() {
            Say a2;
        }
    }

    public static class Online
    extends ConsoleCommandExecute {
        public /* synthetic */ Online() {
            Online a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            Iterator<ChannelServer> iterator;
            int n2 = 0;
            Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllInstances().iterator();
            while (iterator2.hasNext()) {
                ChannelServer channelServer = iterator.next();
                System.out.println(SharkReader.ALLATORIxDEMO("\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn"));
                System.out.println(new StringBuilder().insert(0, SpecialSkillConstants.ALLATORIxDEMO("\u9849\u9064H\u0017")).append(channelServer.getChannel()).append(SharkReader.ALLATORIxDEMO("c\u7d88\u4e49\u4ee8\u653bhc")).append(channelServer.getConnectedClients()).toString());
                n2 += channelServer.getConnectedClients();
                for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharacters()) {
                    if (mapleCharacter == null) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    stringBuilder.append(SpecialSkillConstants.ALLATORIxDEMO("R\u89e5\u8200\u6686\u7a43\u0017"));
                    stringBuilder.append(StringUtil.getRightPaddedStr(mapleCharacter2.getName(), ' ', 13));
                    stringBuilder.append(SharkReader.ALLATORIxDEMO("c\u001b\u0007hc"));
                    stringBuilder.append(mapleCharacter.getId());
                    stringBuilder.append(SpecialSkillConstants.ALLATORIxDEMO("\u0017\u7b3b\u7d2dH\u0017"));
                    stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(mapleCharacter.getLevel()), ' ', 3));
                    stringBuilder.append(SharkReader.ALLATORIxDEMO("c\u8025\u692ehc"));
                    stringBuilder.append(mapleCharacter.getJob());
                    if (mapleCharacter2.getMap() == null) continue;
                    stringBuilder.append(SpecialSkillConstants.ALLATORIxDEMO("\u0017\u5742\u5721H\u0017"));
                    stringBuilder.append(mapleCharacter.getMapId()).append(SharkReader.ALLATORIxDEMO("c\u007fc")).append(mapleCharacter.getMap().getMapName());
                    System.out.println(stringBuilder.toString());
                }
                System.out.println(new StringBuilder().insert(0, SpecialSkillConstants.ALLATORIxDEMO("\u7504\u527a\u9849\u9064\u7e4f\u8a3f\u7da8\u4e3d\u4ec8\u654fH\u0017")).append(n2).toString());
                System.out.println(SharkReader.ALLATORIxDEMO("n\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn\u007fn"));
                iterator2 = iterator;
            }
            System.out.println(new StringBuilder().insert(0, SpecialSkillConstants.ALLATORIxDEMO("\u7541\u523f\u4f0d\u677f\u565f\u7e4f\u8a3f\u7da8\u4e3d\u4ec8\u654fH\u0017")).append(n2).append(SharkReader.ALLATORIxDEMO("\u5048")).toString());
            System.out.println(SpecialSkillConstants.ALLATORIxDEMO("\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a_\u001a"));
            return true;
        }
    }

    public static class help
    extends ConsoleCommandExecute {
        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            System.out.println(MapleAndroid.ALLATORIxDEMO("\u251e\u300a\u2675\u6310\u4e97\u5200\u881b\u3009\u2676\u2579"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("r\u000bg\u0001v\u0007rS7\u7de0\u9a40\u507e\u7390"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("NWEUXD^@\n\u63ac\u5bdc\u5028\u73ad"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("z\u0016d\u001ce\u0012c\u00167\u91a2\u9335\u507e\u7390"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("IDYMXD^@\n\u9efb\u6552\u5028\u73ad"));
            System.out.println(MapleAndroid.ALLATORIxDEMO(":^:^:^:^:^:^:^:^:^:^:^:^:"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("VBP^AERD\u0005\u95f6\u95ac\u4f10\u6728\u5642"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("d\u001bx\u0007s\u001c`\u001dc\u001az\u00167O\u6655\u95e0)S\u5005\u650b\u95cb\u95fa\u671a\u52aa\u567f"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("iW_FCDFqCHO\u0005\u0016\u6667\u95b9\u001b\n\u95f9\u935f\u6667\u5211"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("\u0001r\u001fx\u0012s\u0010\u007f\u0012y\u001dr\u001f7\u91be\u65a7\u8f7a\u5172\u9848\u9044"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("WOIEDNHKU\n\u91e8\u659a\u8f2c\u514f\u5715\u573c"));
            System.out.println(MapleAndroid.ALLATORIxDEMO(":y\u0015xS\u67f2\u7778\u4f2d\u677e\u567f\u72b3\u6cd6"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("d_QEwOB\n\u81cf\u52ff\u8a1e\u51a0\u95ae\u95f6"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("{\u001cp\u001ay\u0017x\u001ceS\u7bb6\u7475\u54f6\u7608\u5172\u6a52\u5f18\u95f8\u95cb"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("E\u0016{\u001cv\u0017R\u0005r\u001dc\u00007\u91be\u65a7\u8f7a\u5172\u521c\u673b\u4ef8\u4ee1"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("wOIEDNcCVBLDB\n\u91e8\u659a\u8f2c\u514f\u91c6\u9b70\u736b\u52df"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("E\u0016{\u001cv\u0017T 7\u91be\u65a7\u8f7a\u5172\u8c8f\u727e\u5535\u57d9\u721a\u54d6"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("wOIEDNvBJZV\n\u91e8\u659a\u8f2c\u514f\u5563\u5ebd\u8a08\u5bb0"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("!r\u001fx\u0012s#x\u0001c\u0012{\u00007\u91be\u65a7\u8f7a\u5172\u95f3\u53f4\u8100\u673b"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("wOIEDNaXJZV\n\u91e8\u659a\u8f2c\u514f\u63ac\u8417\u724c\u54eb"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("!r\u001fx\u0012s<g\u00007\u91be\u65a7\u8f7a\u5172\u5c72\u5312\u5376\u983a"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007\b\u0007"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("x\u001d{\u001ay\u00167\u7da9\u4e1d\u73da\u5ba1"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("YDS\u0005\u4f10\u6728\u5642\u8a8f\u8a5b"));
            System.out.println(MapleAndroid.ALLATORIxDEMO("s\u001cs\u001c`\u001d7\u8990\u9673\u6233\u671e\u5312\u5e24"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("VKSODFI\n\u514d\u6727\u5b7d\u6abe"));
            System.out.println(MapleAndroid.ALLATORIxDEMO(":^:^:^:^:^:^:^:^:^:^:^:^:"));
            System.out.println(MTSCSPacket.ALLATORIxDEMO("\u255a\u3038\u262f\u6322\u4ece\u5232\u8842\u303b\u2545"));
            return true;
        }

        public /* synthetic */ help() {
            help a2;
        }
    }

    public static class ReloadMap
    extends ConsoleCommandExecute {
        public /* synthetic */ ReloadMap() {
            ReloadMap a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            int n2 = Integer.parseInt(a2[1]);
            for (World world : LoginServer.getWorlds()) {
                for (ChannelServer channelServer : world.getChannels()) {
                    if (!channelServer.getMapFactory().isMapLoaded(n2) || channelServer.getMapFactory().getMap(n2).getCharactersSize() <= 0) continue;
                    System.out.println(SkillType.ALLATORIxDEMO("\u8a41\u5714\u5725\u90a0\u673a\u4e9e\u5504"));
                    return false;
                }
            }
            try {
                for (World world : LoginServer.getWorlds()) {
                    for (ChannelServer channelServer : world.getChannels()) {
                        if (!channelServer.getMapFactory().isMapLoaded(n2)) continue;
                        channelServer.getMapFactory().removeMap(n2);
                    }
                }
            }
            catch (Exception exception) {
                System.out.println(BBSHandler.ALLATORIxDEMO("x\u6324\u4ec7\u750b\u6cf6~\u0003QFOLBGnBS\u0003\u001f\u5713\u5735jg\u001d"));
            }
            return true;
        }
    }

    public static class serverMsg
    extends ConsoleCommandExecute {
        public /* synthetic */ serverMsg() {
            serverMsg a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            StringBuilder stringBuilder;
            if (a2.length > 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(StringUtil.joinStringFrom(a2, 1));
                Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
                Iterator<ChannelServer> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    iterator.next().setServerMessage(stringBuilder.toString());
                    iterator2 = iterator;
                }
            } else {
                System.out.println(CheatingOffenseEntry.ALLATORIxDEMO("\u633b\u4ed9\u89b3\u527a\u0006\u001d\u001dNYOJXNpOZ\u001c\u0001QXON]ZY\u0003"));
                return false;
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.serverMessage(stringBuilder.toString()));
            return true;
        }
    }

    public static class logindoor
    extends ConsoleCommandExecute {
        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            GameSetConstants.ADMIN_ONLY = World.isShutDown;
            GameSetConstants.ADMIN_ONLY = !GameSetConstants.ADMIN_ONLY;
            World.isShutDown = !World.isShutDown;
            System.out.println("\u7ba1\u7406\u54e1\u767b\u5165\u6a21\u5f0f\u72c0\u614b: " + (GameSetConstants.ADMIN_ONLY ? MapleMapEffect.ALLATORIxDEMO("\u95bc\u5511") : MapOwner.ALLATORIxDEMO("\u95e2\u95c1")));
            System.out.println("[\u7981\u6b62\u73a9\u5bb6\u4f7f\u7528] " + (World.isShutDown ? MapleMapEffect.ALLATORIxDEMO("\u95bc\u5511") : MapOwner.ALLATORIxDEMO("\u95e2\u95c1")));
            return true;
        }

        public /* synthetic */ logindoor() {
            logindoor a2;
        }
    }

    public static class AutoReg
    extends ConsoleCommandExecute {
        public /* synthetic */ AutoReg() {
            AutoReg a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            LoginServer.setAutoReg(!LoginServer.getAutoReg());
            System.out.println("[autoreg] " + (LoginServer.getAutoReg() ? StructRewardItem.ALLATORIxDEMO("\u95bd\u5555") : SharkReader.ALLATORIxDEMO("\u958e\u95ca")));
            return true;
        }
    }

    public static class Saveall
    extends ConsoleCommandExecute {
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ Saveall() {
            Saveall a2;
            a2.ALLATORIxDEMO = 0;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            Saveall a3;
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                Iterator<ChannelServer> iterator2 = iterator.next().getChannels().iterator();
                while (iterator2.hasNext()) {
                    Iterator<MapleCharacter> iterator3 = iterator2.next().getPlayerStorage().getAllCharactersThreadSafe().iterator();
                    while (iterator3.hasNext()) {
                        Iterator<MapleCharacter> iterator4;
                        MapleCharacter mapleCharacter = iterator4.next();
                        iterator3 = iterator4;
                        ++a3.ALLATORIxDEMO;
                        mapleCharacter.saveToDB(false, true);
                    }
                }
            }
            System.out.println("[\u4fdd\u5b58] " + a3.ALLATORIxDEMO + "\u500b\u73a9\u5bb6\u6578\u64da\u4fdd\u5b58\u5230\u6578\u64da\u4e2d.");
            return true;
        }
    }

    public static class Dodown
    extends ConsoleCommandExecute {
        public /* synthetic */ Dodown() {
            Dodown a2;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            try {
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(HmacOneTimePasswordGenerator.ALLATORIxDEMO("O\u0007^\u0016N\u0012:6y4u\"t#iwI\u0012Nwv8}0\u007f3s9:j:g:\u0000R\u0012H\u0012:;u0}2~>tw'w+"));
                preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println(MaplePet.ALLATORIxDEMO("\u6277\u6735\u5e04\u8663\u89d4\u535d\u5bbb\u755e"));
            }
            catch (SQLException sQLException) {
                System.out.println(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u89b4\u537b\u7527\u5e22\u8a9c\u67ff\u775cW\u000eI\u0006V"));
            }
            return true;
        }
    }

    public static class ShutdownTime
    extends ConsoleCommandExecute {
        private /* synthetic */ int a;
        private static /* synthetic */ Thread d;
        private static /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;

        public /* synthetic */ ShutdownTime() {
            ShutdownTime a2;
            a2.a = 0;
        }

        public static /* synthetic */ {
            d = null;
            ALLATORIxDEMO = null;
        }

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            if (a2.length > 1) {
                ShutdownTime a3;
                a3.a = Integer.parseInt(a2[1]);
                if (a3.a < 10) {
                    World.isShutDown = true;
                }
                System.out.println(MaplePlayerShopItem.ALLATORIxDEMO("\u5dc4\u7de4\u9666\u5241\u739f\u5bc1\u4f49\u755f\u7c88\u973f\u5570\u4ecd\u3034"));
                GameSetConstants.AUTO_SAVE = 30000L;
                if (!(ALLATORIxDEMO != null || d != null && d.isAlive())) {
                    d = new Thread(ShutdownServer.getInstance());
                    ALLATORIxDEMO = Timer.EventTimer.getInstance().register(new Runnable(){

                        @Override
                        public /* synthetic */ void run() {
                            1 v1;
                            1 a2;
                            if (a2.a3.a == 1) {
                                Iterator<ChannelServer> iterator;
                                Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
                                while (iterator2.hasNext()) {
                                    iterator.next().closeAllMerchant();
                                    iterator2 = iterator;
                                }
                                System.out.println(MapleSidekick.ALLATORIxDEMO("\u7cce\u972b\u5536\u4ed9\u5142\u5b3b\u5bfc\u7501^"));
                                v1 = a2;
                            } else {
                                if (a2.a3.a == 0) {
                                    ShutdownServer.getInstance().run();
                                    d.start();
                                    ALLATORIxDEMO.cancel(false);
                                    return;
                                }
                                v1 = a2;
                            }
                            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u6953\u4e4b\u8c37\u516c\u544a] \u4f3a\u670d\u5668\u5c07\u5728 " + v1.a3.a + "\u5206\u9418\u5f8c\u95dc\u9589. \u8acb\u76e1\u901f@save\u5132\u5b58\u89d2\u8272 \u4e26\u4e14\u4e0b\u7dda."));
                            System.out.println("\u672c\u4f3a\u670d\u5668\u5c07\u5728 " + a2.a3.a + "\u5206\u9418\u5f8c\u95dc\u9589.");
                            a2.a3.a--;
                        }
                        {
                            1 a32;
                        }
                    }, 60000L);
                } else {
                    System.out.println(MapleDiseaseValueHolder.ALLATORIxDEMO("\u590a\u5404\u7768\u62dc\u4f17\u6cb1\u8fd1\u6cf6Y\r\u4f4d\u672e\u561f\u95ff\u95fe\u6661\u95e4\u4fcd\u654e\rY\r\u8abc\u7b6a\u5ff2\u95ff\u95fe\u5baf\u7515\rY\u8ae8\u5288\u5f14\u5241\u95ff\u95fe\u672e\u52ae\u564bY\r\u5451\u5264\u5ffb\u67bf\u819d\u8c83V"));
                }
            } else {
                System.out.println(MaplePlayerShopItem.ALLATORIxDEMO("\u4f49\u755f\u89b9\u5230\fWE\u001fC\u0003R\u0018A\u0019B\u001e[\u0012\u0016K\u95ea\u95fe\u6674\u95e4\b"));
                return false;
            }
            return true;
        }
    }

    public static class Shutdown
    extends ConsoleCommandExecute {
        private static /* synthetic */ Thread ALLATORIxDEMO;

        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            Iterator<ChannelServer> iterator;
            System.out.println(MTSStorage.ALLATORIxDEMO("\u5797\u8850\u95bc\u9595\u4f3c\u6971"));
            Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
            while (iterator2.hasNext()) {
                iterator.next().closeAllMerchant();
                iterator2 = iterator;
            }
            System.out.println(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u7cd0\u970b\u5528\u4ef9\u515c\u5b1b\u5be2\u7521@"));
            System.out.println(MTSStorage.ALLATORIxDEMO("\u4f26\u676d\u5674\u95bc\u9595\u4e4d2N2"));
            if (ALLATORIxDEMO == null || ALLATORIxDEMO.isAlive()) {
                try {
                    ALLATORIxDEMO = new Thread(ShutdownServer.getInstance());
                    ALLATORIxDEMO.start();
                }
                catch (Exception exception) {
                    Logger.getLogger(ConsoleCommand.class.getName()).log(Level.SEVERE, null, exception);
                }
            } else {
                System.out.println(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u5db1\u5746\u57b4\u8822\u4e6e@m@"));
            }
            return true;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = null;
        }

        public /* synthetic */ Shutdown() {
            Shutdown a2;
        }
    }

    public static class Info
    extends ConsoleCommandExecute {
        @Override
        public /* synthetic */ boolean execute(String[] a2) {
            Set<Thread> set = Thread.getAllStackTraces().keySet();
            Object object = Runtime.getRuntime();
            Serializable serializable = NumberFormat.getInstance();
            serializable = new StringBuilder();
            Runtime runtime = object;
            object = runtime.maxMemory();
            serializable = Long.valueOf(runtime.totalMemory());
            Long l2 = runtime.freeMemory();
            System.out.println(MapleExtendedSlots.ALLATORIxDEMO("\nu\nu\nu\nu\nu\nu\nu\nu\nu\u0007\u7ca3\u7d56\u8c9f\u8a2dx\nu\nu\nu\nu\nu\nu\nu\nu\nu"));
            System.out.println("\u7dda\u7a0b\u6578 :" + Integer.valueOf(set.size()).toString());
            System.out.println("SQL\u9023\u63a5\u6578 :" + DBConPool.getInstance().getDataSource().getActiveCount());
            System.out.println("\u8a18\u61b6\u9ad4\u6700\u5927\u9650\u5236 :" + ((Long)object).toString());
            System.out.println("\u5df2\u7533\u8acb\u8a18\u61b6\u9ad4 :" + ((Long)serializable).toString());
            System.out.println("\u5c1a\u672a\u4f7f\u7528\u8a18\u61b6\u9ad4 :" + l2.toString());
            return false;
        }

        public /* synthetic */ Info() {
            Info a2;
        }
    }
}

