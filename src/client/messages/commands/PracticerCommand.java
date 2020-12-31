/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5154\u5154\u8c37
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 *  client.messages.commands.player.\u5408\u592a\u8c37
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.messages.commands;

import FuckingHackerToby.L;
import client.ClientRedirector;
import client.ItemVac;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleCoreAura;
import client.MapleDiseaseValueHolder;
import client.MapleLieDetector;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.InventoryException;
import client.inventory.ItemFlag;
import client.inventory.MapleImp;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.messages.CommandExecute;
import client.messages.CommandProcessorUtil;
import client.messages.commands.SkilledCommand;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.\u5154\u5154\u8c37;
import client.messages.commands.player.\u53ef\u53ef\u8c37;
import client.messages.commands.player.\u5408\u592a\u8c37;
import client.messages.commands.player.\u61b6\u6200\u8c37;
import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ServerConstants;
import database.DBConPool;
import handling.cashshop.handler.CashShopOperation;
import handling.channel.ChannelServer;
import handling.channel.handler.AllianceHandler;
import handling.channel.handler.PartyHandler;
import handling.channel.handler.PlayersHandler;
import handling.channel.handler.UserInterfaceHandler;
import handling.login.LoginServer;
import handling.world.MapleMessenger;
import handling.world.MapleParty;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.guild.MapleGuildSummary;
import handling.world.sidekick.MapleSidekick;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import server.Extend.SpecialItemData;
import server.Framework.MapleExtendedSlots;
import server.ItemInformation;
import server.MapleCarnivalChallenge;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.StructRewardItem;
import server.buffs.AbstractBuffClass;
import server.gashapon.GashaponRewardSpecial;
import server.life.MonsterQuestDropEntry;
import server.maps.MapNameData;
import server.maps.MapleMap;
import server.maps.SavedLocationType;
import server.shark.SharkReader;
import tools.EmojiFilter;
import tools.FileoutputUtil;
import tools.FixDropNullItem;
import tools.KoreanDateUtil;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.Pair;
import tools.StringUtil;
import tools.npcgenerator.NPCMessage;
import tools.packet.FamilyPacket;
import tools.packet.MTSCSPacket;
import tools.wztosql.DumpItemsAdditions;

public class PracticerCommand {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 ^ 5;
        int cfr_ignored_0 = 1 << 3 ^ 2;
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ (2 << 2 ^ 3);
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

    public /* synthetic */ PracticerCommand() {
        PracticerCommand a2;
    }

    public static class CItem
    extends CommandExecute {
        public /* synthetic */ CItem() {
            CItem a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleSidekick.ALLATORIxDEMO("3\n\u0004\u0006\u001dCL\u9030\u5107*4]PNP\u53b5\u5fe7\u9ebd\u6508\u88be\u50e9");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (((String[])a32).length < 2) {
                return false;
            }
            int n2 = 0;
            try {
                n2 = Integer.parseInt(a32[1]);
            }
            catch (NumberFormatException a32) {
                // empty catch block
            }
            Object a32 = MapleItemInformationProvider.getInstance();
            if (!((MapleItemInformationProvider)a32).itemExists(n2)) {
                a2.getPlayer().dropMessage(5, n2 + " - \u7269\u54c1\u4e0d\u5b58\u5728");
            } else if (!((MapleItemInformationProvider)a32).isCash(n2)) {
                a2.getPlayer().dropMessage(5, n2 + " - \u7269\u54c1\u7121\u6cd5\u53eb\u51fa");
            } else if (GameConstants.isEquip(n2) && ((MapleItemInformationProvider)a32).isCash(n2)) {
                Equip equip = null;
                int n3 = 0;
                n3 = (byte)(0 | ItemFlag.LOCK.getValue());
                if (GameConstants.getInventoryType(n2) == MapleInventoryType.EQUIP) {
                    Object object = a32;
                    equip = ((MapleItemInformationProvider)object).randomizeStats((Equip)((MapleItemInformationProvider)object).getEquipById(n2));
                    equip.setFlag(n3);
                }
                if (equip != null) {
                    Equip equip2 = equip;
                    MapleClient mapleClient = a2;
                    equip.setOwner(a2.getPlayer().getName());
                    equip2.setGMLog(mapleClient.getPlayer().getName());
                    MapleInventoryManipulator.addbyItem(mapleClient, equip2);
                }
            }
            return true;
        }
    }

    public static class onlinedelay
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a4) {
            Object object = new LinkedList<MapleCharacter>();
            boolean bl = false;
            if (((String[])a4).length > 1 && a4[1].equalsIgnoreCase(PracticerCommand.ALLATORIxDEMO("\u001ak\u0017"))) {
                bl = true;
            }
            if (bl) {
                ChannelServer.getAllInstances().forEach(a3 -> object.addAll(a3.getPlayerStorage().getAllCharactersThreadSafe()));
            } else {
                object.addAll(a2.getChannelServer().getPlayerStorage().getAllCharactersThreadSafe());
            }
            a4 = new StringBuilder();
            Object object2 = object = object.iterator();
            while (object2.hasNext()) {
                MapleCharacter mapleCharacter = (MapleCharacter)object.next();
                if (mapleCharacter.getClient().getLatency() == 0) {
                    object2 = object;
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                object2 = object;
                stringBuilder.append(UserInterfaceHandler.ALLATORIxDEMO("\u001b\u5439\u7a0a\u0014"));
                stringBuilder.append(StringUtil.getRightPaddedStr(mapleCharacter.getName(), ' ', 13));
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[\u7b4e\u7d61=["));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(mapleCharacter.getLevel()), ' ', 3));
                stringBuilder.append(UserInterfaceHandler.ALLATORIxDEMO("\u0014\u5ecd\u9046\u0001\u0014"));
                stringBuilder.append(mapleCharacter.getClient().getLatency());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("j\b"));
                ((StringBuilder)a4).append(FileoutputUtil.CurrentReadable_Time()).append(" ").append((CharSequence)stringBuilder).append(UserInterfaceHandler.ALLATORIxDEMO("6>"));
                a2.getPlayer().dropMessage(6, stringBuilder.toString());
            }
            FileoutputUtil.logToFile(PracticerCommand.ALLATORIxDEMO("\u0017h\u001ctTC\u001as\u001a(?b\u0017f\u0002)\u000f\u007f\u000f"), ((StringBuilder)a4).toString());
            return true;
        }

        public /* synthetic */ onlinedelay() {
            onlinedelay a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + UserInterfaceHandler.ALLATORIxDEMO("TZW]UQ_QWUB\u0014\u0013UWX\u0012\u0014\u0016\u0014\u67de\u773f\u754d\u5279\u0014\u515c\u90d3\u980f\u9068\u76b0\u7392\u5b82\u5ecd\u9046");
        }
    }

    public static class BanIP
    extends CommandExecute {
        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            boolean bl;
            block13: {
                if (((Object)a3).length < 2) {
                    return false;
                }
                bl = false;
                if (!((String)(a3 = a3[1])).contains("/") || !((String)a3).contains(AbstractBuffClass.ALLATORIxDEMO("0"))) {
                    a2.getPlayer().dropMessage(L.ALLATORIxDEMO("\u8f17\u514af\u007f\u5fea\u9827\u532a\u5404\u000f\b\u0000\b\u000f\u4eca\u53e5\u000f\b\u0001\b\u000f\u4fa4\u59ad\u0015\u000f\u000eMNAf\u007f\u000f\u0000\u001e\u001d\u0018\u0001\u001f\u0001\u001f\u0001\u001e"));
                    return true;
                }
                try {
                    DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(AbstractBuffClass.ALLATORIxDEMO("\\PF[GJ5W[JZ>|nw\u007f{m56|n<>C_YKPM56*7"));
                        preparedStatement.setString(1, (String)a3);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        if (druidPooledConnection == null) break block13;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                throw throwable2;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    druidPooledConnection.close();
                }
                catch (Exception exception) {
                    bl = true;
                }
            }
            try {
                for (ChannelServer channelServer : ChannelServer.getAllChannelInstances()) {
                    for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharactersThreadSafe()) {
                        if (!mapleCharacter.getClient().getSessionIPAddress().equals(a3) || mapleCharacter.getClient().isGm()) continue;
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        mapleCharacter2.getClient().disconnect();
                        mapleCharacter2.getClient().getSession().close();
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            a2.getPlayer().dropMessage("\u5c01\u9396IP [" + (String)a3 + "] " + (bl ? L.ALLATORIxDEMO("\u623f\u52b0\u000f") : AbstractBuffClass.ALLATORIxDEMO("\u5924\u6549")));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + L.ALLATORIxDEMO("mNAf\u007f\u000f\u0013f\u007f\u0011\u000f\u0002\u000f\u5c2e\u93b9f\u007f\u000f");
        }

        public /* synthetic */ BanIP() {
            BanIP a2;
        }
    }

    public static class banMac
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MaplePet.ALLATORIxDEMO("~VRz}t\u001c\u000bqv\u007f\t\u001c\u001a\u001c\u5c36\u93aaz}t\u001c");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (((String[])a32).length < 2) {
                return false;
            }
            if (((String)(a32 = a32[1])).equalsIgnoreCase(MapleCarnivalChallenge.ALLATORIxDEMO("A,\\,A1A,\\,A1A,\\,A")) || ((String)a32).length() != 17) {
                a2.getPlayer().dropMessage(MaplePet.ALLATORIxDEMO("\u5c36\u93aaz}t\u590d\u6560\uff30\u53d8\u80c1\u708d\u6800\u5f38\u9313\u8a93\u622a\u6618\u954b\u5e91\u9313\u8a93\u001crD\r\u001c\u0007\f\u001a\f\u0007\u0011\u0007\f\u001a\f\u0007\u0011\u0007\f\u001a\f\u0007\u001c"));
                return true;
            }
            a2.getPlayer().dropMessage("\u5c01\u9396MAC [" + (String)a32 + "] \u6210\u529f");
            try {
                DruidPooledConnection druidPooledConnection;
                DruidPooledConnection druidPooledConnection2;
                block16: {
                    druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        block15: {
                            PreparedStatement preparedStatement = druidPooledConnection2.prepareStatement(MapleCarnivalChallenge.ALLATORIxDEMO("U?O4N%<8R%SQq\u0010\u007f\u0013}\u001foQ4\u001c}\u00125QJ0P$Y\"<Y#X"));
                            try {
                                PreparedStatement preparedStatement2 = preparedStatement;
                                preparedStatement2.setString(1, (String)a32);
                                preparedStatement2.executeUpdate();
                                preparedStatement2.close();
                                if (preparedStatement == null) break block15;
                                druidPooledConnection = druidPooledConnection2;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable2;
                                block17: {
                                    if (preparedStatement != null) {
                                        try {
                                            preparedStatement.close();
                                            throwable2 = throwable;
                                            break block17;
                                        }
                                        catch (Throwable a32) {
                                            throwable.addSuppressed(a32);
                                        }
                                    }
                                    throwable2 = throwable;
                                }
                                throw throwable2;
                            }
                            preparedStatement.close();
                            break block16;
                        }
                        druidPooledConnection = druidPooledConnection2;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable3;
                        block19: {
                            if (druidPooledConnection2 != null) {
                                try {
                                    druidPooledConnection2.close();
                                    throwable3 = throwable;
                                    break block19;
                                }
                                catch (Throwable throwable4) {
                                    throwable.addSuppressed(throwable4);
                                }
                            }
                            throwable3 = throwable;
                        }
                        throw throwable3;
                    }
                }
                if (druidPooledConnection != null) {
                    druidPooledConnection2.close();
                }
            }
            catch (SQLException sQLException) {
                System.err.println("Error banning MACs" + sQLException);
                return true;
            }
            return true;
        }

        public /* synthetic */ banMac() {
            banMac a2;
        }
    }

    public static class BanStatus
    extends CommandExecute {
        public /* synthetic */ BanStatus() {
            BanStatus a2;
        }

        /*
         * Exception decompiling
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 3[TRYBLOCK]
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
             * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
             * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
             * org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:903)
             * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1015)
             * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
             * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
             * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
             * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
             * org.benf.cfr.reader.Main.main(Main.java:49)
             */
            throw new IllegalStateException(Decompilation failed);
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + FixDropNullItem.ALLATORIxDEMO("\u0004W(e2W2C5\u0016z\u739f\u5bf0\u543b\u7a77\bf\n(F%\bf\u001bf\u67d3\u774d\u739f\u5bf0\u6619\u5460\u889d\u5c47\u93a0\u538c\u53a9\u56a6");
        }
    }

    public static class WhereAmI
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().dropMessage(5, "\u76ee\u524d\u5730\u5716 " + a2.getPlayer().getMap().getId() + "\u5ea7\u6a19 (" + String.valueOf(a2.getPlayer().getPosition().x) + " , " + String.valueOf(a2.getPlayer().getPosition().y) + ")");
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + EmojiFilter.ALLATORIxDEMO(";k)q)b!jl.l\u76ed\u5201\u5733\u575a");
        }

        public /* synthetic */ WhereAmI() {
            WhereAmI a2;
        }
    }

    public static class Job
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int n2 = 0;
            try {
                n2 = Integer.parseInt(a32[1]);
            }
            catch (Exception a32) {
                return false;
            }
            a2.getPlayer().changeJob(n2);
            a2.getPlayer().dispelDebuffs();
            return true;
        }

        public /* synthetic */ Job() {
            Job a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"k\u0012c]=\u800a\u696c\u4e9e\u78bdC!P!\u6689\u63da\u800a\u696c");
        }
    }

    public static class fixac
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MonsterQuestDropEntry.ALLATORIxDEMO("H=V5Mt\u0012\u73fd\u5b98\u5459\u7a1fj\u000ey\u000e\u89b7\u5e1d\u860b\u534f\u8986");
        }

        public /* synthetic */ fixac() {
            fixac a2;
        }

        /*
         * Exception decompiling
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
             * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
             * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
             * org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:903)
             * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1015)
             * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
             * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
             * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
             * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
             * org.benf.cfr.reader.Main.main(Main.java:49)
             */
            throw new IllegalStateException(Decompilation failed);
        }
    }

    public static class fixch
    extends CommandExecute {
        public /* synthetic */ fixch() {
            fixch a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleImp.ALLATORIxDEMO("Y9G3Wp\u0003\u73f9\u5b89\u545d\u7a0en\u001f}\u001f\u89b3\u535e\u8982");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleClient mapleClient = a2;
            ChannelServer.forceRemovePlayerByCharName(mapleClient, a3[1]);
            mapleClient.getPlayer().dropMessage("\u5df2\u7d93\u89e3\u5361\u73a9\u5bb6<" + a3[1] + ">");
            return true;
        }
    }

    public static class DC2
    extends CommandExecute {
        public /* synthetic */ DC2() {
            DC2 a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + ClientRedirector.ALLATORIxDEMO("Q'\u0007d\t\u73ed\u5b83z\u0015i\u0015\u8bd7\u739c\u5bf2\u0018v\u0004p\u0002\u65f3\u7def");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            String string = a3[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0 && n2 != -10) {
                a2.getPlayer().dropMessage(MapNameData.ALLATORIxDEMO("\u8a37\u73b9\u5bf3\u4e1d\u576d\u7dca\u4e4f"));
                return true;
            }
            a3 = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            if (a3 != null) {
                ((MapleCharacter)a3).getClient().sendPacket(MaplePacketCreator.getNPCTalk(99, (byte)0, "", ClientRedirector.ALLATORIxDEMO("\u0005t\u0015t\u0005"), (byte)0));
            } else {
                a2.getPlayer().dropMessage(MapNameData.ALLATORIxDEMO("\u8a37\u73b9\u5bf3\u4e1d\u576d\u7dca\u4e4f"));
            }
            return true;
        }
    }

    public static class DC
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + PartyHandler.ALLATORIxDEMO("\u0007;Cd\u73ca\u5bee]xNx\u8bf0\u73f1\u5bd5\u65ef\u7db9");
        }

        public /* synthetic */ DC() {
            DC a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            String string = a3[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0 && n2 != -10) {
                a2.getPlayer().dropMessage(PartyHandler.ALLATORIxDEMO("\u8a11\u73f1\u5bd5\u4e55\u574b\u7d82\u4e69"));
                return true;
            }
            a3 = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            if (a3 != null) {
                Object object = a3;
                ((MapleCharacter)object).getClient().disconnect();
                ((MapleCharacter)object).getClient().getSession().close();
                ((MapleCharacter)a3).getClient().DcAllChannel();
            } else {
                a2.getPlayer().dropMessage(MaplePacketOperation.ALLATORIxDEMO("\u8a37\u7389\u5bf3\u4e2d\u576d\u7dfa\u4e4f"));
            }
            return true;
        }
    }

    public static class DCID
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            int n2 = Integer.parseInt(a3[1]);
            int n3 = World.Find.findChannel(n2);
            int n4 = World.Find.findWorld(n2);
            if (n3 <= 0 && n3 != -10) {
                a2.getPlayer().dropMessage(MapleExtendedSlots.ALLATORIxDEMO("\u8a2a\u738e\u5bee\u4e2a\u5770\u7dfd\u4e52"));
                return true;
            }
            a3 = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterById(n2);
            if (a3 != null) {
                Object object = a3;
                ((MapleCharacter)object).getClient().disconnect();
                ((MapleCharacter)object).getClient().getSession().close();
            } else {
                a2.getPlayer().dropMessage(AllianceHandler.ALLATORIxDEMO("\u8a62\u739f\u5ba6\u4e3b\u5738\u7dec\u4e1a"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleExtendedSlots.ALLATORIxDEMO("\u001cd\u0011cx\u001b\u73f1\u5b91\u0011cf\u0007u\u0007\u8bcb\u738e\u5bee\u6590\u7d82");
        }

        public /* synthetic */ DCID() {
            DCID a2;
        }
    }

    public static class UnBan
    extends CommandExecute {
        public /* synthetic */ boolean hellban;

        private /* synthetic */ String ALLATORIxDEMO() {
            return MapleCoreAura.ALLATORIxDEMO("Y\u001eN\u0011b");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            byte by;
            String[] arrstring;
            byte by2;
            UnBan a4;
            if (a3.length < 2) {
                return false;
            }
            if ((a4.hellban ? (by2 = MapleClient.unHellban(a3[1])) : (by2 = MapleClient.unban(a3[1]))) == -2) {
                a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] SQL \u932f\u8aa4");
                arrstring = a3;
            } else if (by2 == -1) {
                a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u76ee\u6a19\u73a9\u5bb6\u4e0d\u5b58\u5728");
                arrstring = a3;
            } else {
                a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u6210\u529f\u89e3\u9664\u9396\u5b9a");
                arrstring = a3;
            }
            by2 = MapleClient.unbanIPMacs(arrstring[1]);
            if (by2 == -2) {
                a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] SQL \u932f\u8aa4.");
                by = by2;
            } else if (by2 == -1) {
                a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u89d2\u8272\u4e0d\u5b58\u5728.");
                by = by2;
            } else if (by2 == 0) {
                a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] No IP or Mac with that character exists!");
                by = by2;
            } else if (by2 == 1) {
                a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] IP\u6216Mac\u5df2\u89e3\u9396\u5176\u4e2d\u4e00\u500b.");
                by = by2;
            } else {
                if (by2 == 2) {
                    a2.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] IP\u4ee5\u53caMac\u5df2\u6210\u529f\u89e3\u9396.");
                }
                by = by2;
            }
            if (by == 1 || by2 == 2) {
                FileoutputUtil.logToFile(PartyHandler.ALLATORIxDEMO("4\f?\u0010w+9\u00003L-\r:\u00026L\u89bb\u9607\u5c59\u93f5\u5455\u55cdv\u0017 \u0017"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a2.getSession().remoteAddress().toString().split(MapleCoreAura.ALLATORIxDEMO("6"))[0] + " " + a2.getPlayer().getName() + " \u89e3\u9396\u4e86 " + a3[1]);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + PartyHandler.ALLATORIxDEMO("\u00166\u00019\rx_\u73f1\u5bd5fCuC\u89bb\u93f5\u73f1\u5bd5");
        }

        public /* synthetic */ UnBan() {
            UnBan a2;
            a2.hellban = false;
        }
    }

    public static class UnHellBan
    extends UnBan {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleGuildSummary.ALLATORIxDEMO(";\\&W\u0002^,S\u0000\u0012R\u739b\u5bd8\fN\u001fN\u89d1\u93f8\u739b\u5bd8");
        }

        public /* synthetic */ UnHellBan() {
            UnHellBan a2;
            a2.hellban = true;
        }
    }

    public static class AutoRegister
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer();
            ((MapleCharacter)object).changeShow(1);
            ((MapleCharacter)object).dropMessage("\u76ee\u524d\u8a3b\u518a\u986f\u793a\u72c0\u614b: " + (((MapleCharacter)object).getShow(1) ? ItemInformation.ALLATORIxDEMO("\u95c8\u5504c") : ItemVac.ALLATORIxDEMO("\u95a9\u959cU")));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + ItemInformation.ALLATORIxDEMO("\u0002.74\u0011>$20/&)cvc\u95d0\u551c\u73f2\u5bf5\u8a60\u51c9\u8a51\u602c\u9834\u7979");
        }

        public /* synthetic */ AutoRegister() {
            AutoRegister a2;
        }
    }

    public static class AutoLogin
    extends CommandExecute {
        public /* synthetic */ AutoLogin() {
            AutoLogin a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + DumpItemsAdditions.ALLATORIxDEMO("g<R&j&A Hi\u000bi\u95ad\u5516\u738f\u5bff\u765d\u512c\u8a2c\u6026\u9849\u7973");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer();
            ((MapleCharacter)object).changeShow(2);
            ((MapleCharacter)object).dropMessage("\u76ee\u524d\u767b\u5165\u986f\u793a\u72c0\u614b: " + (((MapleCharacter)object).getShow(2) ? DumpItemsAdditions.ALLATORIxDEMO("\u95c2\u5579i") : BankSystem.ALLATORIxDEMO("\u95ab\u95faW")));
            return true;
        }
    }

    public static class Whoshere
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Iterator<MapleCharacter> iterator;
            a3 = new StringBuilder(CashShopOperation.ALLATORIxDEMO("\u571e\u5756\u5720\u4e6c\u76b2\u73cf\u5b80F\fF")).append(a2.getPlayer().getMap().getCharactersThreadsafe().size()).append(MapleGuildSummary.ALLATORIxDEMO("\u001eN"));
            Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                MapleCharacter mapleCharacter = iterator.next();
                if (((StringBuilder)a3).length() > 150) {
                    Object object = a3;
                    ((StringBuilder)object).setLength(((StringBuilder)object).length() - 2);
                    a2.getPlayer().dropMessage(6, ((StringBuilder)a3).toString());
                    a3 = new StringBuilder();
                }
                ((StringBuilder)a3).append(MapleCharacterUtil.makeMapleReadable(mapleCharacter.getName()));
                ((StringBuilder)a3).append(CashShopOperation.ALLATORIxDEMO("\u001aF"));
                iterator2 = iterator;
            }
            Object object = a3;
            ((StringBuilder)object).setLength(((StringBuilder)object).length() - 2);
            a2.getPlayer().dropMessage(6, ((StringBuilder)a3).toString());
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleGuildSummary.ALLATORIxDEMO("9Z\u0001A\u0006W\u001cWN\u001fN\u67d7\u575e\u5724\u4e64\u739b\u5bd8");
        }

        public /* synthetic */ Whoshere() {
            Whoshere a2;
        }
    }

    public static class WarpHere
    extends CommandExecute {
        public /* synthetic */ WarpHere() {
            WarpHere a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"}xxib|x|*\u6293\u73a3\u5baf\u50b9\u9018\u523a\u9000\u88eb");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter != null) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.saveLocation(SavedLocationType.fromString(FamilyPacket.ALLATORIxDEMO("\u0015o\ra\u001do\u001fc\u001cf")));
                mapleCharacter2.changeMap(a2.getPlayer().getMap(), a2.getPlayer().getMap().findClosestSpawnpoint(a2.getPlayer().getPosition()));
            } else {
                int n2 = World.Find.findChannel(a3[1]);
                int n3 = World.Find.findWorld(a3[1]);
                if (n2 < 0) {
                    a2.getPlayer().dropMessage(5, \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u6274\u4e14\u523a"));
                } else {
                    MapleCharacter mapleCharacter3 = mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(a3[1]);
                    mapleCharacter3.saveLocation(SavedLocationType.fromString(FamilyPacket.ALLATORIxDEMO("\u0015o\ra\u001do\u001fc\u001cf")));
                    a2.getPlayer().dropMessage(5, \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u6b69\u5731\u6280\u73b0\u5bbc\u50aa\u523a\u9000\u4f8c"));
                    mapleCharacter3.dropMessage(5, FamilyPacket.ALLATORIxDEMO("\u6b41\u577a\u5091\u9053\u5212\u0015o\u90f1\u90a8"));
                    if (mapleCharacter3.getMapId() != a2.getPlayer().getMapId()) {
                        MapleCharacter mapleCharacter4 = mapleCharacter;
                        MapleMap mapleMap = mapleCharacter4.getClient().getChannelServer().getMapFactory().getMap(a2.getPlayer().getMapId());
                        mapleCharacter4.changeMap(mapleMap, mapleMap.getPortal(0));
                    }
                    mapleCharacter.changeChannel(a2.getChannel());
                }
            }
            return true;
        }
    }

    public static class onlineGM
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + Pair.ALLATORIxDEMO("s\np\rr\u0001[)<I<\u6781\u7717\u7dbe\u4e16\u4ede\u6564#Q");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            int a322 = 0;
            int n2 = 0;
            int n3 = 0;
            LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
            for (MapleCharacter serializable : a2.getChannelServer().getPlayerStorage().getAllCharactersThreadSafe()) {
                if (serializable.getGMLevel() <= 0) continue;
                ++a322;
            }
            for (ChannelServer channelServer : LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels()) {
                for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharactersThreadSafe()) {
                    if (mapleCharacter == null || mapleCharacter.getGMLevel() <= 0) continue;
                    ++n2;
                }
            }
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dropMessage(6, SpecialItemData.ALLATORIxDEMO("\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e"));
            Iterator<Serializable> iterator = LoginServer.getWorldStatic(mapleClient.getPlayer().getMap().getWorld()).getChannels().iterator();
            Iterator<Serializable> iterator2 = iterator;
            while (iterator2.hasNext()) {
                ChannelServer channelServer = (ChannelServer)iterator.next();
                for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharactersThreadSafe()) {
                    if (mapleCharacter == null || mapleCharacter.getGMLevel() <= 0) continue;
                    linkedList.add(mapleCharacter);
                }
                n3 = linkedList.size();
                if (n3 > 0) {
                    a2.getPlayer().dropMessage(6, new StringBuilder().insert(0, Pair.ALLATORIxDEMO("\u985f\u904f^<")).append(channelServer.getChannel()).append(SpecialItemData.ALLATORIxDEMO("\u0013\u7df2\u4e39o~\u4e92\u654b\u0012\u0013")).append(n3).toString());
                    for (MapleCharacter mapleCharacter : linkedList) {
                        StringBuilder stringBuilder;
                        if (mapleCharacter == null) continue;
                        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
                        stringBuilder.append(Pair.ALLATORIxDEMO("D[)\u66ad\u7a55<"));
                        stringBuilder2.append(StringUtil.getRightPaddedStr(mapleCharacter.getName(), ' ', 13));
                        stringBuilder.append(SpecialItemData.ALLATORIxDEMO("\u0013aw\u0012\u0013"));
                        stringBuilder2.append(StringUtil.getRightPaddedStr("" + mapleCharacter.getId(), ' ', 5));
                        stringBuilder.append(Pair.ALLATORIxDEMO("<\u6b6e\u964c^<"));
                        stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(mapleCharacter.getGMLevel()), ' ', 3));
                        a2.getPlayer().dropMessage(6, stringBuilder.toString());
                    }
                }
                linkedList = new LinkedList();
                iterator2 = iterator;
            }
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().dropMessage(6, new StringBuilder().insert(0, SpecialItemData.ALLATORIxDEMO("\u755e\u527e\u9813\u9060\u7e15\u8a3bo~\u7df2\u4e39\u4e92\u654b\u0012\u0013")).append(a322).toString());
            mapleClient2.getPlayer().dropMessage(6, Pair.ALLATORIxDEMO("1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1I1"));
            mapleClient2.getPlayer().dropMessage(6, new StringBuilder().insert(0, SpecialItemData.ALLATORIxDEMO("\u7545\u5265\u4f09\u6725\u565bo~\u7e15\u8a3b\u7df2\u4e39\u4e92\u654b\u0012\u0013")).append(n2).append(Pair.ALLATORIxDEMO("\u5017")).toString());
            mapleClient2.getPlayer().dropMessage(6, SpecialItemData.ALLATORIxDEMO("\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e"));
            return true;
        }

        public /* synthetic */ onlineGM() {
            onlineGM a2;
        }
    }

    public static class online
    extends CommandExecute {
        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            block35: {
                block32: {
                    block31: {
                        v0 = a;
                        a = CommandProcessorUtil.getNamedIntArg((String[])v0, 1, UserInterfaceHandler.ALLATORIxDEMO("^TV"));
                        var3_3 = CommandProcessorUtil.getNamedIntArg((String[])v0, 1, SkilledCommand.ALLATORIxDEMO("\u0011D\u0019\u0019"));
                        var4_4 = CommandProcessorUtil.getNamedIntArg((String[])v0, 1, UserInterfaceHandler.ALLATORIxDEMO("WB"));
                        var5_5 = CommandProcessorUtil.getNamedIntArg((String[])v0, 1, SkilledCommand.ALLATORIxDEMO("G\r\u0019"));
                        var6_6 = CommandProcessorUtil.getNamedIntArg((String[])v0, 1, UserInterfaceHandler.ALLATORIxDEMO("VQH["));
                        var7_7 = CommandProcessorUtil.getNamedIntArg((String[])v0, 1, SkilledCommand.ALLATORIxDEMO("F\u001eX\u0014\u0019"));
                        var8_9 = CommandProcessorUtil.getNamedStringArg((String[])v0, 1, UserInterfaceHandler.ALLATORIxDEMO("UUVQ"));
                        var9_10 = false;
                        var10_15 = false;
                        var11_16 = false;
                        var12_17 = false;
                        var13_18 = false;
                        var14_19 = 0;
                        var15_20 = a.getChannelServer().getConnectedClients();
                        if (a != null && var3_3 != null) {
                            var11_16 = true;
                            var9_10 = true;
                        }
                        if (var4_4 != null && var5_5 != null) {
                            var10_15 = true;
                            var9_10 = true;
                        }
                        if (var6_6 != null && var7_7 != null) {
                            var12_17 = true;
                            var9_10 = true;
                        }
                        if (var8_9 != null) {
                            var13_18 = true;
                            var9_10 = true;
                        }
                        v1 = a;
                        v1.getPlayer().dropMessage(6, SkilledCommand.ALLATORIxDEMO("\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006"));
                        v1.getPlayer().dropMessage(6, new StringBuilder().insert(0, UserInterfaceHandler.ALLATORIxDEMO("\u9800\u9067\u0001\u0014")).append(a.getChannelServer().getChannel()).append(SkilledCommand.ALLATORIxDEMO("\u000b\u7da1\u4e21\u4ec1\u6553A\u000b")).append(var15_20).toString());
                        var14_19 += var15_20;
                        if (!var9_10) break block31;
                        var7_7 = LoginServer.getWorldStatic(a.getPlayer().getMap().getWorld()).getChannels().iterator();
                        break block32;
                    }
                    block0: for (World var9_11 : LoginServer.getWorlds()) {
                        var15_21 = var9_11.getChannels().iterator();
                        block1: while (true) {
                            v2 = var15_21;
                            while (v2.hasNext()) {
                                var16_26 = var15_21.next();
                                if (var16_26.getChannel() != a.getChannel()) {
                                    v2 = var15_21;
                                    continue;
                                }
                                if (!var16_26.getPlayerStorage().getAllCharactersThreadSafe().isEmpty()) {
                                    a.getPlayer().dropMessage(5, "<\u983b\u9053" + var16_26.getChannel() + ">");
                                }
                                v3 = var16_26.getPlayerStorage().getAllCharactersThreadSafe().iterator();
lbl48:
                                // 4 sources

                                while (true) {
                                    if (!v3.hasNext()) continue block1;
                                    break;
                                }
                            }
                            continue block0;
                            break;
                        }
                        {
                            block34: {
                                block33: {
                                    var18_28 = var17_27.next();
                                    if (var18_28 != null) break block33;
                                    v3 = var17_27;
                                    ** GOTO lbl48
                                }
                                if (var18_28.getGMLevel() <= a.getPlayer().getGMLevel()) break block34;
                                v3 = var17_27;
                                ** GOTO lbl48
                            }
                            v4 = var19_30 = new StringBuilder();
                            var19_30.append(UserInterfaceHandler.ALLATORIxDEMO("\u5439\u7a0a\u0014"));
                            v4.append(StringUtil.getRightPaddedStr(var18_28.getName(), ' ', 13));
                            var19_30.append(SkilledCommand.ALLATORIxDEMO("\u000b2oA\u000b"));
                            v4.append(StringUtil.getRightPaddedStr("" + var18_28.getId(), ' ', 5));
                            var19_30.append(UserInterfaceHandler.ALLATORIxDEMO("\u0014\u7b72\u7d2e\u0001\u0014"));
                            var19_30.append(StringUtil.getRightPaddedStr(String.valueOf(var18_28.getLevel()), ' ', 3));
                            var19_30.append(SkilledCommand.ALLATORIxDEMO("\u000b\u800c\u6946A\u000b"));
                            var19_30.append(StringUtil.getRightPaddedStr(String.valueOf(var18_28.getJob()), ' ', 4));
                            if (var18_28.getMap() != null) {
                                var19_30.append(UserInterfaceHandler.ALLATORIxDEMO("\u0014\u570b\u5722\u0001\u0014"));
                                var19_30.append(var18_28.getMapId());
                                var19_30.append(SkilledCommand.ALLATORIxDEMO("[\u0003"));
                                var19_30.append(var18_28.getMap().getMapName());
                                var19_30.append(UserInterfaceHandler.ALLATORIxDEMO("\u0012\u0014"));
                            }
                            a.getPlayer().dropMessage(6, var19_30.toString());
                            v3 = var17_27;
                            ** continue;
                            break;
                        }
                    }
                    break block35;
                }
                block4: while (var7_7.hasNext()) {
                    var9_12 = var7_7.next();
                    var15_22 = var9_12.getPlayerStorage().getAllCharactersThreadSafe().iterator();
                    block5: while (true) {
                        v5 = var15_22;
                        while (v5.hasNext()) {
                            var16_26 = var15_22.next();
                            if (var16_26 == null) {
                                v5 = var15_22;
                                continue;
                            }
                            if (var11_16) {
                                if (var16_26.getJob() < a.intValue()) continue block5;
                                if (var16_26.getJob() > var3_3) {
                                    v5 = var15_22;
                                    continue;
                                }
                            }
                            if (var10_15) {
                                if (var16_26.getLevel() < var4_4.intValue()) continue block5;
                                if (var16_26.getLevel() > var5_5) {
                                    v5 = var15_22;
                                    continue;
                                }
                            }
                            if (var12_17) {
                                if (var16_26.getMeso() < var6_6) continue block5;
                                if (var16_26.getMeso() > var6_6) {
                                    v5 = var15_22;
                                    continue;
                                }
                            }
                            if (var13_18 && var8_9 != null && var16_26.getName().toLowerCase().contains(var8_9.toLowerCase())) {
                                v5 = var15_22;
                                continue;
                            }
                            v6 = var17_27 = new StringBuilder();
                            var17_27.append(SkilledCommand.ALLATORIxDEMO("\u5426\u7a4a\u000b"));
                            v6.append(StringUtil.getRightPaddedStr(var16_26.getName(), ' ', 13));
                            var17_27.append(UserInterfaceHandler.ALLATORIxDEMO("\u0014rp\u0001\u0014"));
                            v6.append(StringUtil.getRightPaddedStr("" + var16_26.getId(), ' ', 5));
                            var17_27.append(SkilledCommand.ALLATORIxDEMO("\u000b\u7b32\u7d31A\u000b"));
                            var17_27.append(StringUtil.getRightPaddedStr(String.valueOf(var16_26.getLevel()), ' ', 3));
                            var17_27.append(UserInterfaceHandler.ALLATORIxDEMO("\u0014\u804c\u6959\u0001\u0014"));
                            var17_27.append(StringUtil.getRightPaddedStr(String.valueOf(var16_26.getJob()), ' ', 4));
                            if (var12_17) {
                                var17_27.append(SkilledCommand.ALLATORIxDEMO("\u000b\u6928\u5e48A\u000b"));
                                var17_27.append(StringUtil.getRightPaddedStr(String.valueOf(var16_26.getMeso()), ' ', 10));
                                a.getPlayer().dropMessage(6, var17_27.toString());
                                continue block5;
                            }
                            if (var16_26.getMap() == null) continue block5;
                            var17_27.append(UserInterfaceHandler.ALLATORIxDEMO("\u0014\u570b\u5722\u0001\u0014"));
                            var17_27.append(var16_26.getMapId());
                            a.getPlayer().dropMessage(6, var17_27.toString());
                            continue block5;
                        }
                        continue block4;
                        break;
                    }
                }
            }
            v7 = a;
            v7.getPlayer().dropMessage(6, new StringBuilder().insert(0, SkilledCommand.ALLATORIxDEMO("\u750d\u5266\u9840\u9078\u7e46\u8a23\u7da1\u4e21\u4ec1\u6553A\u000b")).append(var14_19).toString());
            v7.getPlayer().dropMessage(6, UserInterfaceHandler.ALLATORIxDEMO("\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019\u0016\u0019"));
            var7_8 = 0;
            v8 = var9_13 = LoginServer.getWorldStatic(a.getPlayer().getMap().getWorld()).getChannels().iterator();
            while (v8.hasNext()) {
                var15_23 = var9_13.next();
                var7_8 += var15_23.getConnectedClients();
                v8 = var9_13;
            }
            v9 = a;
            v9.getPlayer().dropMessage(6, new StringBuilder().insert(0, SkilledCommand.ALLATORIxDEMO("\u755d\u5236\u4f11\u6776\u5643\u7e46\u8a23\u7da1\u4e21\u4ec1\u6553A\u000b")).append(var7_8).append(UserInterfaceHandler.ALLATORIxDEMO("\u503f")).toString());
            v9.getPlayer().dropMessage(6, SkilledCommand.ALLATORIxDEMO("\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006V\u0006"));
            var9_14 = 0;
            v10 = var15_24 = LoginServer.getWorldStatic(a.getWorld()).getChannels().iterator();
            while (v10.hasNext()) {
                var16_26 = var15_24.next();
                var9_14 += var16_26.getConnectedClients();
                v10 = var15_24;
            }
            a.getPlayer().dropMessage(6, "\u76ee\u524d\u4e16\u754c\u4eba\u6578: " + var9_14);
            var15_25 = 0;
            v11 = a;
            var16_26 = ChannelServer.getInstance(v11.getWorld(), -10);
            var17_27 = ChannelServer.getInstance(v11.getWorld(), -20);
            if (var16_26.getPlayerStorage() != null) {
                var15_25 += var16_26.getPlayerStorage().getConnectedClients();
            }
            a.getPlayer().dropMessage(6, "\u76ee\u524d\u5546\u57ce\u4eba\u6578: " + var15_25);
            var18_29 = 0;
            if (GameSetConstants.AUCTION_SERVER) {
                if (var17_27.getPlayerStorage() != null) {
                    var18_29 += var17_27.getPlayerStorage().getConnectedClients();
                }
                a.getPlayer().dropMessage(6, "\u76ee\u524d\u62cd\u8ce3\u4eba\u6578: " + var18_29);
            }
            var19_31 = var15_25;
            a = LoginServer.getWorlds().iterator();
            block9: while (true) {
                if (!a.hasNext()) {
                    a.getPlayer().dropMessage(6, "\u76ee\u524d\u7e3d\u4e16\u754c\u7dda\u4e0a\u4eba\u6578: " + var19_31);
                    return true;
                }
                v12 = ((World)a.next()).getChannels().iterator();
                while (true) {
                    if (!v12.hasNext()) continue block9;
                    var4_4 = (ChannelServer)var3_3.next();
                    var19_31 += var4_4.getPlayerStorage().getAllCharactersThreadSafe().size();
                    v12 = var3_3;
                }
                break;
            }
        }

        public /* synthetic */ online() {
            online a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + UserInterfaceHandler.ALLATORIxDEMO("[UXRZ^\u0014\u0016\u0014\u67de\u773f\u7de1\u4e3e\u4e81\u654c");
        }
    }

    public static class UnHide
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dispelBuff(9001004);
            mapleClient.getPlayer().dropMessage(6, MTSCSPacket.ALLATORIxDEMO("\u7b84\u742c\u54c4\u969b\u85ea\n\u0018\n\u95f9\u95a3\u0005'/\n\u95ae\u5575\u8aee\u8f12\u5140\u000bMCAO"));
            return true;
        }

        public /* synthetic */ UnHide() {
            UnHide a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + PlayersHandler.ALLATORIxDEMO("sDnCbO&\u0007&\u89c9\u9662\u969b\u85c9");
        }
    }

    public static class Hide
    extends CommandExecute {
        public /* synthetic */ Hide() {
            Hide a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            SkillFactory.getSkill(9001004).getEffect(1).applyTo(a2.getPlayer());
            a2.getPlayer().dropMessage(6, AllianceHandler.ALLATORIxDEMO("\u7b97\u7416\u54d7\u96a1\u85f90\u000b0\u95bd\u554f\u0016\u001d<0\u89d5\u9674\u8afd\u8f28\u51531C~^yRu"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleLieDetector.ALLATORIxDEMO("UVYZ\u001d\u0012\u001d\u968e\u85f2");
        }
    }

    public static class MobSize
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleMessenger.ALLATORIxDEMO("U\u0014z(q\u0001}[\u67fd\u7770\u756e\u5236\u5728\u576d\u7e25\u510a\u769c\u6051\u7271\u6503\u91d7");
        }

        public /* synthetic */ MobSize() {
            MobSize a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient = a2;
            int a32 = mapleClient.getPlayer().getMap().mobCount();
            mapleClient.getPlayer().dropMessage(5, "\u7576\u524d\u5730\u5716\u602a\u7269\u6578\u91cf\u7e3d\u5171\u6709" + a32 + "\u96bb");
            return true;
        }
    }

    public static class CnGM
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + KoreanDateUtil.ALLATORIxDEMO("u\u0014q\u00176F\u8a1c\u6015(Z;ZQ7\u805c\u5953");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getErrorNotice("<GM\u804a\u5929\u8996\u7a97>\u983b\u9053" + a2.getPlayer().getClient().getChannel() + " [" + a2.getPlayer().getName() + "](" + a2.getPlayer().getId() + ") : " + StringUtil.joinStringFrom(a3, 1)));
            return true;
        }

        public /* synthetic */ CnGM() {
            CnGM a2;
        }
    }

    public static class BanID
    extends CommandExecute {
        public /* synthetic */ boolean hellban;

        public /* synthetic */ BanID() {
            BanID a2;
            a2.hellban = false;
        }

        private /* synthetic */ String ALLATORIxDEMO() {
            return MapleFamily.ALLATORIxDEMO("\u0002\u000f.");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            BanID a4;
            int n2;
            if (a3.length < 2) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder(a2.getPlayer().getName());
            stringBuilder.append(SharkReader.ALLATORIxDEMO("r\u5c42\u93c4c")).append(a3[1]).append(MapleFamily.ALLATORIxDEMO("T`")).append(StringUtil.joinStringFrom(a3, 2));
            boolean bl = false;
            boolean bl2 = false;
            int n3 = 0;
            String string = SharkReader.ALLATORIxDEMO("<6>/");
            try {
                n3 = Integer.parseInt(a3[1]);
                string = a3[2];
                n2 = n3;
            }
            catch (Exception exception) {
                n2 = n3;
            }
            int n4 = World.Find.findChannel(n2);
            int n5 = World.Find.findWorld(n3);
            a2.getPlayer();
            String string2 = MapleCharacter.getCharacterNameById(n3);
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterById(n3);
            if (mapleCharacter == null) {
                MapleClient mapleClient = a2;
                if (!a2.getPlayer().OfflineBanById(n3, stringBuilder.toString())) {
                    mapleClient.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u5c01\u9396\u5931\u6557 " + a3[1]);
                    return true;
                }
                mapleClient.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u6210\u529f\u96e2\u7dda\u5c01\u9396 " + string2 + ".");
                bl = true;
            } else {
                if (a4.Ban(a2, mapleCharacter, stringBuilder) != 1) {
                    return true;
                }
                string2 = mapleCharacter.getName();
            }
            FileoutputUtil.logToFile(MapleFamily.ALLATORIxDEMO("\u0002/\t3A\b\u000f#\u0005o\u6369\u4ea4\u5c6f\u93d6\u5463\u55ee@4\u00164"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a2.getSession().remoteAddress().toString().split(SharkReader.ALLATORIxDEMO("y"))[0] + " " + a2.getPlayer().getName() + " \u5c01\u9396\u4e86 " + string2 + " \u539f\u56e0: " + stringBuilder.toString() + " \u662f\u5426\u96e2\u7dda\u5c01\u9396: " + bl);
            String string3 = MapleFamily.ALLATORIxDEMO("\u00005\u0002,").equals(string) ? SharkReader.ALLATORIxDEMO("\u4f2d\u756b\u9007\u6c96\u7a59\u5f4c\u7da6\u52dc") : StringUtil.joinStringFrom(a3, 2);
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + string2 + " \u56e0\u70ba" + string3 + "\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + "  \u5c01\u9396\u4e86 " + string2 + " \u662f\u5426\u96e2\u7dda\u5c01\u9396 " + bl + " \u539f\u56e0\uff1a" + string3));
            return true;
        }

        public /* synthetic */ int Ban(MapleClient a2, MapleCharacter a3, StringBuilder a4) {
            BanID a5;
            if (a2.getPlayer().getGMLevel() >= a3.getGMLevel()) {
                StringBuilder stringBuilder = a4;
                MapleCharacter mapleCharacter = a3;
                stringBuilder.append(SharkReader.ALLATORIxDEMO("rk\u001b\u0013hc")).append(mapleCharacter.getClient().getSessionIPAddress()).append(MapleFamily.ALLATORIxDEMO("i"));
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
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleFamily.ALLATORIxDEMO(",!\u0000\t*`R\u73e9\u5bd8\t*~N|\u53f1\u56a0P`C`\u5c6f\u93d6\u73c7\u5bf6");
        }
    }

    public static class BanX
    extends CommandExecute {
        public /* synthetic */ boolean hellban;

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + StructRewardItem.ALLATORIxDEMO("TkX*\n\u73a3\u5b804\u00166\u53a9\u56ea\b*\u001b*\u5c37\u939c\u739f\u5bbc");
        }

        public /* synthetic */ BanX() {
            BanX a2;
            a2.hellban = false;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            BanX a4;
            String string;
            if (a3.length < 2) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder(a2.getPlayer().getName());
            stringBuilder.append(StructRewardItem.ALLATORIxDEMO("\u0016\u5c0b\u93a0*")).append(a3[1]).append(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"6\u0001")).append(StringUtil.joinStringFrom(a3, 2));
            boolean bl = false;
            MapleCharacter mapleCharacter = null;
            String string2 = "";
            String string3 = StructRewardItem.ALLATORIxDEMO("X\u007fZf");
            try {
                string2 = a3[1];
                string3 = a3[2];
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
                MapleClient mapleClient = a2;
                if (!a2.getPlayer().OfflineBanByName(string2, stringBuilder.toString())) {
                    mapleClient.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u5c01\u9396\u5931\u6557 " + a3[1]);
                    return true;
                }
                mapleClient.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u6210\u529f\u96e2\u7dda\u5c01\u9396 " + a3[1] + ".");
                bl = true;
            } else if (a4.Ban(a2, mapleCharacter, stringBuilder) != 1) {
                return true;
            }
            FileoutputUtil.logToFile(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"`NkR#imBg\u000e\u630b\u4ec5\u5c0d\u93b7\u5401\u558f\"UtU"), "\r\n " + FileoutputUtil.NowTime() + " " + a2.getPlayer().getName() + " \u5c01\u9396\u4e86 " + a3[1] + " \u539f\u56e0: " + stringBuilder.toString() + " \u662f\u5426\u96e2\u7dda\u5c01\u9396: " + bl);
            String string4 = StructRewardItem.ALLATORIxDEMO("X\u007fZf").equals(string3) ? \u5154\u5154\u8c37.ALLATORIxDEMO((String)"\u4f73\u7509\u9059\u6cf4\u7a07\u5f2e\u7df8\u52be") : StringUtil.joinStringFrom(a3, 2);
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + "  \u5c01\u9396\u4e86 " + a3[1] + " \u662f\u5426\u96e2\u7dda\u5c01\u9396 " + bl + " \u539f\u56e0\uff1a" + string4));
            return true;
        }

        public /* synthetic */ int Ban(MapleClient a2, MapleCharacter a3, StringBuilder a4) {
            BanX a5;
            if (a2.getPlayer().getGMLevel() >= a3.getGMLevel()) {
                StringBuilder stringBuilder = a4;
                MapleCharacter mapleCharacter = a3;
                stringBuilder.append(\u5154\u5154\u8c37.ALLATORIxDEMO((String)",\tEq6\u0001")).append(mapleCharacter.getClient().getSessionIPAddress()).append(StructRewardItem.ALLATORIxDEMO("#"));
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

        private /* synthetic */ String ALLATORIxDEMO() {
            return \u5154\u5154\u8c37.ALLATORIxDEMO((String)"cmO");
        }
    }

    public static class Ban
    extends CommandExecute {
        public /* synthetic */ boolean hellban;

        public /* synthetic */ int Ban(MapleClient a2, MapleCharacter a3, StringBuilder a4) {
            Ban a5;
            if (a2.getPlayer().getGMLevel() >= a3.getGMLevel()) {
                StringBuilder stringBuilder = a4;
                MapleCharacter mapleCharacter = a3;
                stringBuilder.append(MapleParty.ALLATORIxDEMO("P19IJ9")).append(mapleCharacter.getClient().getSessionIPAddress()).append(NPCMessage.ALLATORIxDEMO("["));
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

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Ban a4;
            String string;
            if (a3.length < 2) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder(a2.getPlayer().getName());
            stringBuilder.append(NPCMessage.ALLATORIxDEMO("M\u5c73\u93fbR")).append(a3[1]).append(MapleParty.ALLATORIxDEMO("J9")).append(StringUtil.joinStringFrom(a3, 2));
            boolean bl = false;
            MapleCharacter mapleCharacter = null;
            String string2 = "";
            String string3 = NPCMessage.ALLATORIxDEMO("\u0003\u0007\u0001\u001e");
            try {
                string2 = a3[1];
                string3 = a3[2];
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
                MapleClient mapleClient = a2;
                if (!a2.getPlayer().OfflineBanByName(string2, stringBuilder.toString())) {
                    mapleClient.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u5c01\u9396\u5931\u6557 " + a3[1]);
                    return true;
                }
                mapleClient.getPlayer().dropMessage(6, "[" + a4.ALLATORIxDEMO() + "] \u6210\u529f\u96e2\u7dda\u5c01\u9396 " + a3[1] + ".");
                bl = true;
            } else if (a4.Ban(a2, mapleCharacter, stringBuilder) != 1) {
                return true;
            }
            FileoutputUtil.logToFile(MapleParty.ALLATORIxDEMO("\u001cv\u0017j_Q\u0011z\u001b6\u6377\u4efd\u5c71\u938f\u547d\u55b7^m\bm"), "\r\n " + FileoutputUtil.NowTime() + " " + a2.getPlayer().getName() + " \u5c01\u9396\u4e86 " + a3[1] + " \u539f\u56e0: " + stringBuilder.toString() + " \u662f\u5426\u96e2\u7dda\u5c01\u9396: " + bl);
            String string4 = NPCMessage.ALLATORIxDEMO("\u0003\u0007\u0001\u001e").equals(string3) ? MapleParty.ALLATORIxDEMO("\u4f0f\u7531\u9025\u6ccc\u7a7b\u5f16\u7d84\u5286") : StringUtil.joinStringFrom(a3, 2);
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a3[1] + " \u56e0\u70ba" + string4 + "\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + "  \u5c01\u9396\u4e86 " + a3[1] + " \u662f\u5426\u96e2\u7dda\u5c01\u9396 " + bl + " \u539f\u56e0\uff1a" + string4));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + NPCMessage.ALLATORIxDEMO("\u000f\u0013\u0003RQ\u73db\u5bdbLMN\u53f2\u5692SR@R\u5c6c\u93e4\u73c4\u5bc4");
        }

        private /* synthetic */ String ALLATORIxDEMO() {
            return MapleParty.ALLATORIxDEMO("[\u0011w");
        }

        public /* synthetic */ Ban() {
            Ban a2;
            a2.hellban = false;
        }
    }

    public static class WarpID
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            if (a3.length < 2) {
                return false;
            }
            int n3 = 0;
            try {
                n2 = n3 = Integer.parseInt(a3[1]);
            }
            catch (Exception exception) {
                n2 = n3;
            }
            int n4 = World.Find.findChannel(n2);
            int n5 = World.Find.findWorld(n3);
            if (n4 < 1) {
                if (n4 == -20) {
                    a2.getPlayer().dropMessage("\u73a9\u5bb6\u7de8\u865f\u300c" + n3 + "\u300d\u76ee\u524d\u4f4d\u65bc\u62cd\u8ce3");
                    return true;
                }
                if (n4 == -10) {
                    a2.getPlayer().dropMessage("\u73a9\u5bb6\u7de8\u865f\u300c" + n3 + "\u300d\u76ee\u524d\u4f4d\u65bc\u5546\u57ce");
                    return true;
                }
                a2.getPlayer().dropMessage(6, "\u73a9\u5bb6\u7de8\u865f[" + n3 + "] \u4e0d\u5728\u7dda\u4e0a");
                return true;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterById(n3);
            if (mapleCharacter != null) {
                if (a3.length == 2) {
                    a2.getPlayer().changeMap(mapleCharacter.getMap(), mapleCharacter.getMap().findClosestSpawnpoint(mapleCharacter.getPosition()));
                } else {
                    MapleMap mapleMap = ChannelServer.getInstance(a2.getWorld(), a2.getChannel()).getMapFactory().getMap(Integer.parseInt(a3[2]));
                    if (mapleMap == null) {
                        a2.getPlayer().dropMessage(6, \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u573c\u5741\u4e01\u5b0f\u5724"));
                    } else {
                        MapleMap mapleMap2 = mapleMap;
                        mapleCharacter.changeMap(mapleMap2, mapleMap2.getPortal(0));
                    }
                }
            } else {
                try {
                    MapleCharacter mapleCharacter2;
                    try {
                        mapleCharacter2 = mapleCharacter = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterById(Integer.parseInt(a3[1]));
                    }
                    catch (Exception exception) {
                        a2.getPlayer().dropMessage(6, "\u51fa\u554f\u984c\u4e86 " + exception.getMessage());
                        mapleCharacter2 = mapleCharacter;
                    }
                    if (mapleCharacter2 != null) {
                        if (mapleCharacter.getMapId() != a2.getPlayer().getMapId()) {
                            MapleMap mapleMap;
                            MapleClient mapleClient = a2;
                            MapleMap mapleMap3 = mapleMap = mapleClient.getChannelServer().getMapFactory().getMap(mapleCharacter.getMapId());
                            mapleClient.getPlayer().changeMap(mapleMap3, mapleMap3.getPortal(0));
                        }
                        MapleClient mapleClient = a2;
                        mapleClient.getPlayer().dropMessage(6, GashaponRewardSpecial.ALLATORIxDEMO("\u6b44\u572c\u651e\u8b8e\u981c\u9057\u8aec\u7b4d\u5fa2"));
                        mapleClient.getPlayer().changeChannel(n4);
                    } else {
                        a2.getPlayer().dropMessage(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u89de\u8225\u4e01\u5b0f\u5724"));
                    }
                }
                catch (Exception exception) {
                    a2.getPlayer().dropMessage(6, "\u51fa\u554f\u984c\u4e86 " + exception.getMessage());
                }
            }
            return true;
        }

        public /* synthetic */ WarpID() {
            WarpID a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + GashaponRewardSpecial.ALLATORIxDEMO("sFvWMc$|\u73ad\u5b91\u7dec\u8678Y\u0007)\u0007\u79ff\u52f2\u5234\u67f7\u500f\u738e\u5bb2\u6267\u572c\u76a3\u5734\u659e");
        }
    }

    public static class Warp
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient;
            if (((String[])a3).length < 2) {
                return false;
            }
            String string = "";
            try {
                string = a3[1];
                mapleClient = a2;
            }
            catch (Exception exception) {
                mapleClient = a2;
            }
            MapleCharacter mapleCharacter = mapleClient.getChannelServer().getPlayerStorage().getCharacterByName(string);
            if (mapleCharacter != null) {
                if (((String[])a3).length == 2) {
                    a2.getPlayer().changeMap(mapleCharacter.getMap(), mapleCharacter.getMap().findClosestSpawnpoint(mapleCharacter.getPosition()));
                } else {
                    MapleMap mapleMap;
                    MapleMap mapleMap2 = null;
                    try {
                        mapleMap = mapleMap2 = ChannelServer.getInstance(a2.getWorld(), a2.getChannel()).getMapFactory().getMap(Integer.parseInt(a3[2]));
                    }
                    catch (Exception exception) {
                        mapleMap = mapleMap2;
                    }
                    if (mapleMap == null) {
                        a2.getPlayer().dropMessage(6, MapleParty.ALLATORIxDEMO("\u5729\u5766\u4e14\u5b28\u5731"));
                    } else {
                        MapleMap mapleMap3 = mapleMap2;
                        mapleCharacter.changeMap(mapleMap3, mapleMap3.getPortal(0));
                    }
                }
            } else {
                String string2 = string;
                int n2 = World.Find.findChannel(string2);
                int n3 = World.Find.findWorld(string2);
                if (n2 < 0) {
                    if (n2 == -10) {
                        a2.getPlayer().dropMessage("\u73a9\u5bb6\u300c" + string + "\u300d\u76ee\u524d\u4f4d\u65bc\u5546\u57ce");
                    } else if (n2 == -20) {
                        a2.getPlayer().dropMessage("\u73a9\u5bb6\u300c" + string + "\u300d\u76ee\u524d\u4f4d\u65bc\u62cd\u8ce3");
                    } else {
                        MapleMap mapleMap;
                        a3 = null;
                        MapleMap mapleMap4 = null;
                        try {
                            a3 = Integer.parseInt(string);
                            mapleMap = mapleMap4 = a2.getChannelServer().getMapFactory().getMap((Integer)a3);
                        }
                        catch (Exception exception) {
                            mapleMap = mapleMap4;
                        }
                        if (mapleMap == null) {
                            a2.getPlayer().dropMessage("\u73a9\u5bb6\u300c" + string + "\u300d\u6240\u5728\u5730\u5716\u4e0d\u5b58\u5728");
                        } else {
                            MapleMap mapleMap5 = mapleMap4;
                            a2.getPlayer().changeMap(mapleMap5, mapleMap5.getPortal(0));
                        }
                    }
                } else {
                    mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
                    if (mapleCharacter != null) {
                        if (mapleCharacter.getMapId() != a2.getPlayer().getMapId()) {
                            MapleClient mapleClient2 = a2;
                            Object object = a3 = mapleClient2.getChannelServer().getMapFactory().getMap(mapleCharacter.getMapId());
                            mapleClient2.getPlayer().changeMap((MapleMap)object, ((MapleMap)object).getPortal(0));
                        }
                        MapleClient mapleClient3 = a2;
                        mapleClient3.getPlayer().dropMessage(6, \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6b5a\u5726\u6500\u8b84\u9802\u905d\u8af2\u7b47\u5fbc"));
                        mapleClient3.getPlayer().changeChannel(n2);
                    } else {
                        a2.getPlayer().dropMessage(MapleParty.ALLATORIxDEMO("\u89cb\u8202\u4e14\u5b28\u5731"));
                    }
                }
            }
            return true;
        }

        public /* synthetic */ Warp() {
            Warp a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + \u5408\u592a\u8c37.ALLATORIxDEMO((String)"yX|I.b\u73a7\u5b8f\u5403\u7a08S\u00192\u5709\u5718pJ\u0007.\u0014.\u79c2\u52db\u5209\u67de\u5032\u573e\u572f\u6218\u67e9\u5005\u7390\u5bb8\u6279\u5726\u76bd\u573e\u6580");
        }
    }

    public static class WarpT
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((Object)a3).length < 2) {
                return false;
            }
            LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
            a3 = ((String)a3[1]).toLowerCase();
            MapleCharacter mapleCharacter = null;
            StringBuilder stringBuilder = new StringBuilder();
            for (ChannelServer serializable : LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels()) {
                for (MapleCharacter mapleCharacter2 : serializable.getPlayerStorage().getAllCharactersThreadSafe()) {
                    if (!mapleCharacter2.getName().toLowerCase().contains((CharSequence)a3)) continue;
                    if (mapleCharacter == null) {
                        mapleCharacter = mapleCharacter2;
                    }
                    linkedList.add(mapleCharacter2);
                }
            }
            if (linkedList.size() > 1) {
                stringBuilder.append(InventoryException.ALLATORIxDEMO("\u5c6a\u6204\u5251\u76fe\u73c8\u5bcc\u5110")).append(linkedList.size()).append(MapleDiseaseValueHolder.ALLATORIxDEMO("\u4f3a\u0003\u547a\u558d\u59f5\u4e28W\u0019W"));
                a2.getPlayer().dropMessage(5, stringBuilder.toString());
                Iterator<ChannelServer> iterator = linkedList.iterator();
                Iterator<ChannelServer> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    MapleCharacter mapleCharacter3 = (MapleCharacter)((Object)iterator.next());
                    a2.getPlayer().dropMessage(5, "\u983b\u9053" + mapleCharacter3.getClient().getChannel() + ": " + mapleCharacter3.getName() + "(" + mapleCharacter3.getId() + ") -- " + mapleCharacter3.getMapId() + "(" + mapleCharacter3.getMap().getMapName() + ")");
                    iterator2 = iterator;
                }
                return true;
            }
            if (linkedList.isEmpty()) {
                a2.getPlayer().dropMessage(6, "\u6c92\u6709\u641c\u5c0b\u5230\u540d\u7a31\u542b\u6709 '" + (String)a3 + "' \u7684\u89d2\u8272");
            } else {
                MapleClient mapleClient = a2;
                if (mapleCharacter != null) {
                    mapleClient.getPlayer().changeMap(mapleCharacter.getMap(), mapleCharacter.getMap().findClosestSpawnpoint(mapleCharacter.getTruePosition()));
                } else {
                    mapleClient.getPlayer().dropMessage(6, InventoryException.ALLATORIxDEMO("\u89b3\u8208\u4e6c\u5b22\u5749\u626c\u664e\u4e77\u5749\u7da0\u4e6b"));
                }
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + MapleDiseaseValueHolder.ALLATORIxDEMO("t\u0016Q\u0007wWx\u73de\u5b95\u547a\u7a12\u7230\u6b96*\u0003Z\u0003\u798c\u52f6\u5247\u67f3\u507c\u5713\u5761\u6235\u67a7\u5028\u73de\u5b95\u6237\u570b\u76f3\u5713\u65ce");
        }

        public /* synthetic */ WarpT() {
            WarpT a2;
        }
    }
}

