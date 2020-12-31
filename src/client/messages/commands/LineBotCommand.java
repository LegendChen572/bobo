/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.LineBotCommand$\u4e8b\u524d\u734e\u52f5
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 */
package client.messages.commands;

import FuckingHackerToby.F;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleCoolDownValueHolder;
import client.anticheat.CheatingOffenseEntry;
import client.messages.CommandProcessor;
import client.messages.ConsoleCommandObject;
import client.messages.LineBotCommandExecute;
import client.messages.commands.LineBotCommand;
import client.messages.commands.SkilledCommand;
import client.messages.commands.player.\u61b6\u6200\u8c37;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import constants.GameSetConstants;
import constants.ServerConstants;
import database.DBConPool;
import handling.auction.handler.MTSOperation;
import handling.channel.ChannelServer;
import handling.channel.handler.NPCHandler;
import handling.world.World;
import handling.world.guild.MapleGuild;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import server.MapleItemInformationProvider;
import server.ShutdownServer;
import server.StructSetItem;
import server.Timer;
import server.maps.MapleMapEffect;
import tools.ExternalCodeLongTableGetter;
import tools.FileOperation;
import tools.FileoutputUtil;
import tools.GZIPCompression;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.StringUtil;
import tools.data.ByteArrayByteStream;
import tools.database.UniqueIdReset;
import tools.npcgenerator.NPCMessage;
import tools.otp.HmacOneTimePasswordGenerator;
import tools.use.GetMACAddress;

public class LineBotCommand {
    private static /* synthetic */ Thread a;
    private static /* synthetic */ int ALLATORIxDEMO;
    private static /* synthetic */ ScheduledFuture<?> d;

    public static /* synthetic */ {
        a = null;
        d = null;
        ALLATORIxDEMO = 0;
    }

    public /* synthetic */ LineBotCommand() {
        LineBotCommand a2;
    }

    public static class prize
    extends \u4e8b\u524d\u734e\u52f5 {
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, Pair.ALLATORIxDEMO("x\u0014<X\u73b5\u5bd2\u5411\u7a55\"D \u732a\u52e9\u5469\u7a2dZ<\u761f\u8a04\u4eef\u5251\u732a\u52e9")).toString();
        }

        public /* synthetic */ prize() {
            prize a2;
        }
    }

    public static class Ban
    extends LineBotCommandExecute {
        public /* synthetic */ boolean hellban;

        private /* synthetic */ String ALLATORIxDEMO() {
            return StructSetItem.ALLATORIxDEMO("d\u0005H");
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + UniqueIdReset.ALLATORIxDEMO("d\u0006hG:\u73ce\u5bb0Y&[\u5399\u56878G+G\u5c07\u93f1\u73af\u5bd1");
        }

        public /* synthetic */ Ban() {
            Ban a2;
            a2.hellban = false;
        }

        public /* synthetic */ int Ban(MapleClient a2, MapleCharacter a3, StringBuilder a4) {
            Ban a5;
            if (a2.getPlayer().getGMLevel() >= a3.getGMLevel()) {
                StringBuilder stringBuilder = a4;
                MapleCharacter mapleCharacter = a3;
                stringBuilder.append(StructSetItem.ALLATORIxDEMO("D\u000e-v^\u0006")).append(mapleCharacter.getClient().getSessionIPAddress()).append(UniqueIdReset.ALLATORIxDEMO("N"));
                if (mapleCharacter.ban(stringBuilder.toString(), a2.getPlayer().hasGmLevel(5), false, a5.hellban)) {
                    a3.getClient().getSession().close();
                    a3.getClient().disconnect();
                    a2.getPlayer().dropMessage(6, "[" + a5.ALLATORIxDEMO() + "] \u6210\u529f\u5c01\u9396 " + a3.getName() + ".");
                    return 1;
                }
                a2.getPlayer().dropMessage(6, "[" + a5.ALLATORIxDEMO() + "] \u5c01\u9396\u5931\u6557.");
                return 0;
            }
            a2.getPlayer().dropMessage(6, "[" + a5.ALLATORIxDEMO() + "] \u7121\u6cd5\u5c01\u9396GMs...");
            return 0;
        }

        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            Ban a4;
            String string;
            if (a2.length < 2) {
                return UniqueIdReset.ALLATORIxDEMO("\u8acd\u8f5f\u5163G'\u0005g\t&[\u73af\u5bd18G:\u53f8\u56e6Y");
            }
            if ((a3 = MapleCharacter.getCharacterByName((String)a3)) == null) {
                return StructSetItem.ALLATORIxDEMO("\u7514\u5e1eE\u0006\u4e69\u5b7e\u574c\u76a2\u7de5\u5bbc\u89b6\u8254");
            }
            CharSequence charSequence = new StringBuilder(((MapleCharacter)a3).getName());
            StringBuilder stringBuilder = new StringBuilder(((MapleCharacter)a3).getName());
            charSequence.append(UniqueIdReset.ALLATORIxDEMO("&\u5c66\u9390G")).append(a2[1]).append(StructSetItem.ALLATORIxDEMO("^\u0006")).append(StringUtil.joinStringFrom(a2, 2));
            boolean bl = false;
            MapleCharacter mapleCharacter = null;
            String string2 = "";
            String string3 = UniqueIdReset.ALLATORIxDEMO("h\u0012j\u000b");
            try {
                string2 = a2[1];
                string3 = a2[2];
                string = string2;
            }
            catch (Exception exception) {
                string = string2;
            }
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string2);
            if (n2 != -1) {
                mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string2);
            }
            if (mapleCharacter == null) {
                StringBuilder stringBuilder2 = stringBuilder;
                if (((MapleCharacter)a3).OfflineBanByName(string2, charSequence.toString())) {
                    stringBuilder2.append("[" + a4.ALLATORIxDEMO() + "] \u6210\u529f\u96e2\u7dda\u5c01\u9396 " + a2[1] + ".");
                    bl = true;
                } else {
                    stringBuilder2.append("[" + a4.ALLATORIxDEMO() + "] \u5c01\u9396\u5931\u6557 " + a2[1]);
                }
            } else if (a4.Ban(((MapleCharacter)a3).getClient(), mapleCharacter, (StringBuilder)charSequence) != 1) {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] \u6210\u529f\u5c01\u9396 " + a2[1]);
            }
            FileoutputUtil.logToFile(StructSetItem.ALLATORIxDEMO("\bI\u0003UKn\u0005E\u000f\t\u6363\u4ec2\u5c65\u93b0\u5469\u5588JR\u001cR"), "\r\n " + FileoutputUtil.NowTime() + " " + ((MapleCharacter)a3).getName() + " \u5c01\u9396\u4e86 " + a2[1] + " \u539f\u56e0: " + charSequence.toString() + " \u662f\u5426\u96e2\u7dda\u5c01\u9396: " + bl);
            charSequence = UniqueIdReset.ALLATORIxDEMO("h\u0012j\u000b").equals(string3) ? StructSetItem.ALLATORIxDEMO("\u4f1b\u750e\u9031\u6cf3\u7a6f\u5f29\u7d90\u52b9") : StringUtil.joinStringFrom(a2, 2);
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a2[1] + " \u56e0\u70ba" + (String)charSequence + "\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] GM " + ((MapleCharacter)a3).getName() + "  \u5c01\u9396\u4e86 " + a2[1] + " \u662f\u5426\u96e2\u7dda\u5c01\u9396 " + bl + " \u539f\u56e0\uff1a" + (String)charSequence));
            return stringBuilder.toString();
        }
    }

    public static class unban
    extends LineBotCommandExecute {
        public /* synthetic */ boolean hellban;

        public /* synthetic */ unban() {
            unban a2;
            a2.hellban = false;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + HmacOneTimePasswordGenerator.ALLATORIxDEMO("o9x6tw&\u73fe\u5baci:z:\u89b4\u938c\u73fe\u5bac");
        }

        private /* synthetic */ String ALLATORIxDEMO() {
            return MapleGuild.ALLATORIxDEMO("5j\"e\u000e");
        }

        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            byte by;
            String[] arrstring;
            byte by2;
            unban a4;
            if (a2.length < 2) {
                return HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u8ad1\u8f6f\u517fw;\"t5{9:k\u73b3\u5be1$");
            }
            StringBuilder stringBuilder = new StringBuilder();
            if ((a4.hellban ? (by2 = MapleClient.unHellban(a2[1])) : (by2 = MapleClient.unban(a2[1]))) == -2) {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] SQL \u932f\u8aa4");
                arrstring = a2;
            } else if (by2 == -1) {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] \u76ee\u6a19\u73a9\u5bb6\u4e0d\u5b58\u5728");
                arrstring = a2;
            } else {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] \u6210\u529f\u89e3\u9664\u9396\u5b9a");
                arrstring = a2;
            }
            by2 = MapleClient.unbanIPMacs(arrstring[1]);
            if (by2 == -2) {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] SQL \u932f\u8aa4.");
                by = by2;
            } else if (by2 == -1) {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] \u89d2\u8272\u4e0d\u5b58\u5728.");
                by = by2;
            } else if (by2 == 0) {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] No IP or Mac with that character exists!");
                by = by2;
            } else if (by2 == 1) {
                stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] IP\u6216Mac\u5df2\u89e3\u9396\u5176\u4e2d\u4e00\u500b.");
                by = by2;
            } else {
                if (by2 == 2) {
                    stringBuilder.append("[" + a4.ALLATORIxDEMO() + "] IP\u4ee5\u53caMac\u5df2\u6210\u529f\u89e3\u9396.");
                }
                by = by2;
            }
            if (by == 1 || by2 == 2) {
                FileoutputUtil.logToFile(MapleGuild.ALLATORIxDEMO("h\u000fc\u0013+(e\u0003oOq\u000ef\u0001jO\u89e7\u9604\u5c05\u93f6\u5409\u55ce*\u0014|\u0014"), "\r\n " + FileoutputUtil.NowTime() + " " + a3 + " \u89e3\u9396\u4e86 " + a2[1]);
            }
            return stringBuilder.toString();
        }
    }

    public static class logindoor
    extends LineBotCommandExecute {
        public /* synthetic */ logindoor() {
            logindoor a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + F.ALLATORIxDEMO(" G+A\"L#G>\b\u95c7\u95f4\u7637\u514d\u53af");
        }

        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            a3 = new StringBuilder();
            GameSetConstants.ADMIN_ONLY = World.isShutDown;
            GameSetConstants.ADMIN_ONLY = !GameSetConstants.ADMIN_ONLY;
            World.isShutDown = !World.isShutDown;
            ((StringBuilder)a3).append("[\u7ba1\u7406\u54e1\u767b\u5165\u6a21\u5f0f\u72c0\u614b] " + (GameSetConstants.ADMIN_ONLY ? F.ALLATORIxDEMO("\u95a3\u5513") : NPCMessage.ALLATORIxDEMO("\u95b1\u95fb")) + "\r\n");
            ((StringBuilder)a3).append("[\u7981\u6b62\u73a9\u5bb6\u4f7f\u7528] " + (World.isShutDown ? F.ALLATORIxDEMO("\u95a3\u5513") : NPCMessage.ALLATORIxDEMO("\u95b1\u95fb")));
            return ((StringBuilder)a3).toString();
        }
    }

    public static class itemall
    extends LineBotCommandExecute {
        public /* synthetic */ itemall() {
            itemall a2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        public /* synthetic */ String execute(String[] a, String a) {
            a = new StringBuilder();
            if (a.length < 3) {
                v0 = a;
                v1 = v0;
                v0.append(MapleCoolDownValueHolder.ALLATORIxDEMO("\u635c\u4ec7\u4f24\u750b\u9374\u8a87a\u0003zJ/F6B7O{\u724a\u549aj\u001f\u0003\u6523\u91ec"));
                return v1.toString();
            }
            var3_3 = Integer.parseInt(a[1]);
            var4_4 = Integer.parseInt(a[2]);
            if (!MapleItemInformationProvider.getInstance().itemExists(var3_3)) {
                a.append("\u627e\u4e0d\u5230 " + var3_3 + " \u7269\u54c1");
                v1 = a;
                return v1.toString();
            }
            v2 = var5_5 = "\u7372\u5f97\u4e86 " + MapleItemInformationProvider.getInstance().getName(var3_3) + " " + var4_4 + "\u500b";
            var5_5 = GameSetConstants.SERVER_NAME.equals(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u6720\u77fc\u8c3d")) != false ? v2 + "\r\n\u8acb\u81f3 \u672a\u77e5NPC>>\u734e\u52f5\u9818\u53d6>>\u9053\u5177\u90f5\u4ef6 \u9818\u53d6\u3002" : v2 + "\r\n\u8acb\u81f3 \u734e\u52f5\u4fdd\u7ba1\u5009\u5eab \u9818\u53d6\u3002";
            try {
                var6_6 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    var7_8 = var6_6.prepareStatement(MapleCoolDownValueHolder.ALLATORIxDEMO("(F7F8W{\t{E)L6\u0003:@8L.M/P"));
                    var8_10 = var7_8.executeQuery();
                    block8: while (var8_10.next()) {
                        v3 = var9_13 = var6_6.prepareStatement(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"cwy|xm*pdme9e\u007flucwop~|g9\"xizeldmc}&9cmotc}&9iv\u007fw~0*oku\u007f|y9\"&&955*&#"));
                        var9_13.setInt(1, var8_10.getInt(MapleCoolDownValueHolder.ALLATORIxDEMO("2G")));
                        v3.setInt(2, var3_3);
                        v3.setInt(3, var4_4);
                        v3.execute();
                        var9_13.close();
                        MapleCharacterUtil.sendNote(var8_10.getString(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"wkto")), MapleCoolDownValueHolder.ALLATORIxDEMO("d\u0016\u7d45\u60f3\u765f\u905a\u4ea5\u79f5\u724a"), var5_5, 0);
                        var9_12 = false;
                        if (var9_12) continue;
                        var10_14 = ChannelServer.getAllChannelInstances().iterator();
                        while (var10_14.hasNext()) {
                            for (MapleCharacter var12_16 : var10_14.next().getPlayerStorage().getAllCharactersThreadSafe()) {
                                if (var12_16 == null || var12_16.getAccountID() != var8_10.getInt(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"pn"))) continue;
                                var9_12 = true;
                                var12_16.showNote();
                                continue block8;
                            }
                        }
                    }
                    var7_8.close();
                    var8_10.close();
                    a.append(MapleCoolDownValueHolder.ALLATORIxDEMO("\u6233\u52c4\u765f\u6565\u514b\u6756\u724a\u549a\u3021"));
                    ** if (var6_6 == null) goto lbl-1000
                }
                catch (Throwable var7_9) {
                    if (var6_6 != null) {
                        try {
                            var6_6.close();
                            v4 = var7_9;
                            throw v4;
                        }
                        catch (Throwable var8_11) {
                            var7_9.addSuppressed(var8_11);
                        }
                    }
                    v4 = var7_9;
                    throw v4;
                }
lbl-1000:
                // 1 sources

                {
                    var6_6.close();
                }
lbl-1000:
                // 2 sources

                {
                }
            }
            catch (SQLException var6_7) {
                System.err.println(var6_7);
            }
            v1 = a;
            return v1.toString();
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"cmotkuf9\u7263\u54d8C]*\u6561\u91c5");
        }
    }

    public static class item
    extends LineBotCommandExecute {
        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            CharSequence charSequence;
            a3 = new StringBuilder();
            if (a2.length < 4) {
                CharSequence charSequence2 = a3;
                charSequence = charSequence2;
                ((StringBuilder)charSequence2).append(ConsoleCommandObject.ALLATORIxDEMO("\u60b4\u8f02\u5179\u76be\u6820\u5f35\u9333\u8a9e=\u001a\u8ad7\u8f02\u5179\u001a=Sh_q\u001a\u5411\u7a0b<\u7253\u54dd\u001a\u6564\u91f5"));
            } else {
                Object object = a2[1];
                int n2 = Integer.parseInt(a2[2]);
                int n3 = Integer.parseInt(a2[3]);
                if (!MapleItemInformationProvider.getInstance().itemExists(n2)) {
                    ((StringBuilder)a3).append("\u627e\u4e0d\u5230 " + n2 + " \u7269\u54c1");
                    charSequence = a3;
                } else {
                    String string = "\u7372\u5f97\u4e86 " + MapleItemInformationProvider.getInstance().getName(n2) + " " + n3 + "\u500b";
                    string = string + "\r\n\u8acb\u81f3 \u734e\u52f5\u4fdd\u7ba1\u5009\u5eab \u9818\u53d6\u3002";
                    if ((object = MapleCharacter.getCharacterByName((String)object)) != null) {
                        CharSequence charSequence3;
                        block7: {
                            Object object2 = object;
                            ((MapleCharacter)object2).gainOfflineItem(n2, n3);
                            MapleCharacterUtil.sendAccNote(((MapleCharacter)object2).getClient().getAccountName(), FileOperation.ALLATORIxDEMO("JA\u7d6b\u60a4\u7671\u900d\u4e8b\u79a2\u7264"), string, 0);
                            Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
                            while (iterator.hasNext()) {
                                MapleCharacter mapleCharacter = iterator.next().getPlayerStorage().getCharacterById(((MapleCharacter)object).getId());
                                if (mapleCharacter == null) continue;
                                charSequence3 = a3;
                                mapleCharacter.showNote();
                                break block7;
                            }
                            charSequence3 = a3;
                        }
                        ((StringBuilder)charSequence3).append(ConsoleCommandObject.ALLATORIxDEMO("\u7646\u901d\u622a\u5283\u001b<\u8af1\u73b5\u5b8c\u81ef\u96d8\u7dc6\u80f6\u5319\u9822\u53ca\u001b"));
                        charSequence = a3;
                    } else {
                        CharSequence charSequence4 = a3;
                        charSequence = charSequence4;
                        ((StringBuilder)charSequence4).append(FileOperation.ALLATORIxDEMO("\u67e8\u712d\u6b69\u4eb6,"));
                    }
                }
            }
            return ((StringBuilder)charSequence).toString();
        }

        public /* synthetic */ item() {
            item a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ConsoleCommandObject.ALLATORIxDEMO("Sh_q\u001a\u5411\u7a0b<\u7253\u54dd\u001a\u6564\u91f5");
        }
    }

    public static class dc
    extends LineBotCommandExecute {
        public /* synthetic */ dc() {
            dc a2;
        }

        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            CharSequence charSequence;
            a3 = new StringBuilder();
            if (a2.length <= 1) {
                CharSequence charSequence2 = a3;
                charSequence = charSequence2;
                ((StringBuilder)charSequence2).append(MTSOperation.ALLATORIxDEMO("\u60e4\u8f1b\u5129\u76a7\u6870\u5f2c\u9363\u8a87m\u0003\u8a87\u8f1b\u5129\u0003mG/\u0003\u73e5\u5b95\u0005g"));
            } else {
                String string = a2[1];
                int n2 = World.Find.findChannel(string);
                int n3 = World.Find.findWorld(string);
                if (n2 <= 0 && n2 != -10) {
                    CharSequence charSequence3 = a3;
                    charSequence = charSequence3;
                    ((StringBuilder)charSequence3).append(NPCHandler.ALLATORIxDEMO("\u8a15\u73aa\u5bd1\u4e0e\u574f\u7dd9\u4e6d/\u6271\u662c\u6cf5\u670a\u6b03\u73aa\u5bd1\""));
                } else {
                    MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
                    if (mapleCharacter != null) {
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        mapleCharacter2.getClient().disconnect();
                        mapleCharacter2.getClient().getSession().close();
                        mapleCharacter.getClient().DcAllChannel();
                        ((StringBuilder)a3).append("\u5df2\u9806\u5229\u5c07\u73a9\u5bb6: " + string + " \u5f9e\u7dda\u4e0a\u8e22\u9664!");
                        charSequence = a3;
                    } else {
                        CharSequence charSequence4 = a3;
                        charSequence = charSequence4;
                        ((StringBuilder)charSequence4).append(MTSOperation.ALLATORIxDEMO("\u8a51\u73e5\u5b95\u4e41\u570b\u7d96\u4e29"));
                    }
                }
            }
            return ((StringBuilder)charSequence).toString();
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + NPCHandler.ALLATORIxDEMO("g\u0004#\u73ce\u5bb5.G");
        }
    }

    public static class shutdowntime
    extends LineBotCommandExecute {
        public /* synthetic */ shutdowntime() {
            shutdowntime a2;
        }

        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            CharSequence charSequence;
            a3 = new StringBuilder();
            if (a2.length <= 1) {
                CharSequence charSequence2 = a3;
                charSequence = charSequence2;
                ((StringBuilder)charSequence2).append(CheatingOffenseEntry.ALLATORIxDEMO("\u6094\u8f05\u5159\u76b9\u6800\u5f32\u9313\u8a99\u001d\u001d\u8af7\u8f05\u5159\u001d\u001dNTHHYSJRIUPY\u001d\u523a\u9425"));
            } else {
                ALLATORIxDEMO = Integer.parseInt(a2[1]);
                if (ALLATORIxDEMO < 10) {
                    World.isShutDown = true;
                }
                if (!(d != null || a != null && a.isAlive())) {
                    shutdowntime a4;
                    a = new Thread(ShutdownServer.getInstance());
                    d = Timer.EventTimer.getInstance().register(new Runnable(){
                        {
                            1 a3;
                        }

                        @Override
                        public /* synthetic */ void run() {
                            if (ALLATORIxDEMO == 1) {
                                Iterator<ChannelServer> iterator;
                                Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
                                while (iterator2.hasNext()) {
                                    iterator.next().closeAllMerchant();
                                    iterator2 = iterator;
                                }
                                System.out.println(GZIPCompression.ALLATORIxDEMO("\u7cb2\u977a\u554a\u4e88\u513e\u5b6a\u5b80\u7550\""));
                            } else if (ALLATORIxDEMO == 0) {
                                ShutdownServer.getInstance().run();
                                a.start();
                                d.cancel(false);
                                return;
                            }
                            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u6953\u4e4b\u8c37\u516c\u544a] \u4f3a\u670d\u5668\u5c07\u5728 " + ALLATORIxDEMO + "\u5206\u9418\u5f8c\u95dc\u9589. \u8acb\u76e1\u901f@save\u5132\u5b58\u89d2\u8272 \u4e26\u4e14\u4e0b\u7dda."));
                            System.out.println("\u672c\u4f3a\u670d\u5668\u5c07\u5728 " + ALLATORIxDEMO + "\u5206\u9418\u5f8c\u95dc\u9589.");
                            ALLATORIxDEMO--;
                        }
                    }, 60000L);
                    ((StringBuilder)a3).append("\u5df2\u5e6b\u60a8\u7684\u4f3a\u670d\u5668\u5b89\u6392\u9032\u884c\u95dc\u9589," + ALLATORIxDEMO + "\u5206\u9418\u5f8c\u5c07\u95dc\u9589\u904a\u6232!");
                    charSequence = a3;
                } else {
                    ((StringBuilder)a3).append("\u60a8\u7684\u4f3a\u670d\u5668\u76ee\u524d\u5df2\u5b89\u6392\u9032\u884c\u95dc\u9589," + ALLATORIxDEMO + "\u5206\u9418\u5f8c\u5c07\u95dc\u9589\u904a\u6232!");
                    charSequence = a3;
                }
            }
            return ((StringBuilder)charSequence).toString();
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0007%\u00019\u0010\"\u0003#\u0000$\u0019(T\u524b\u946c");
        }
    }

    public static class online
    extends LineBotCommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0004<\u0007;\u00057K\u007fK\u577a\u7db1\u73fb\u5bdd\u652a\u91a4");
        }

        @Override
        public /* synthetic */ String execute(String[] a3, String a4) {
            a4 = new StringBuilder();
            ((StringBuilder)a4).append(ByteArrayByteStream.ALLATORIxDEMO("\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\r\u571f\u7df7\u8cf0\u8a27\u0017\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a ="));
            ((StringBuilder)a4).append("\u76ee\u524d\u5728\u7dda\u73a9\u5bb6\u6578\u91cf :" + ChannelServer.getAllInstances().stream().map(a2 -> a2.getConnectedClients()).reduce(0, Integer::sum) + "\r\n");
            return ((StringBuilder)a4).toString();
        }

        public /* synthetic */ online() {
            online a2;
        }
    }

    public static class info
    extends LineBotCommandExecute {
        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            a3 = Thread.getAllStackTraces().keySet();
            Object object = Runtime.getRuntime();
            Serializable serializable = NumberFormat.getInstance();
            serializable = new StringBuilder();
            Runtime runtime = object;
            object = runtime.maxMemory();
            Long l2 = runtime.totalMemory();
            Long l3 = runtime.freeMemory();
            Serializable serializable2 = serializable;
            ((StringBuilder)serializable2).append(MapleMapEffect.ALLATORIxDEMO("\u001ac\u001ac\u001ac\u001ac\u0017\u7cb5\u7d46\u8c89\u8a3dn\u001ac\u001ac\u001ac\u001ac:D"));
            ((StringBuilder)serializable2).append("\u7dda\u7a0b\u6578 :" + Integer.valueOf(a3.size()).toString() + "\r\n");
            ((StringBuilder)serializable).append("SQL\u9023\u63a5\u6578 :" + DBConPool.getInstance().getDataSource().getActiveCount() + "\r\n");
            ((StringBuilder)serializable).append("\u8a18\u61b6\u9ad4\u6700\u5927\u9650\u5236 :" + ((Long)object).toString() + "\r\n");
            ((StringBuilder)serializable).append("\u5df2\u7533\u8acb\u8a18\u61b6\u9ad4 :" + l2.toString() + "\r\n");
            ((StringBuilder)serializable).append("\u5c1a\u672a\u4f7f\u7528\u8a18\u61b6\u9ad4 :" + l3.toString() + "\r\n");
            return ((StringBuilder)serializable).toString();
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + GetMACAddress.ALLATORIxDEMO("\nw\u0005vC4C\u76f7\u522e\u7ce2\u7d12\u8cde\u8a69");
        }

        public /* synthetic */ info() {
            info a2;
        }
    }

    public static class help
    extends LineBotCommandExecute {
        public /* synthetic */ help() {
            help a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SkilledCommand.ALLATORIxDEMO("C\u001eG\u000b\u000bV\u000b\u679e\u7720\u637c\u4ecf");
        }

        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            return CommandProcessor.dropLineBotHelp();
        }
    }
}

