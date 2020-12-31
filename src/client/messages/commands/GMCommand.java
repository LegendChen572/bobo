/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 *  client.messages.commands.player.\u5408\u592a\u8c37
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 *  client.messages.commands.player.\u592f\u592f\u8c37
 *  client.messages.commands.player.\u5976\u8336\u8c37
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 *  client.messages.commands.player.\u672a\u77e5\u8c37
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.messages.commands;

import client.ClientRedirector;
import client.ISkill;
import client.MapleBuffStatValueHolder;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleCoolDownValueHolder;
import client.MapleCoreAura;
import client.MapleDiseaseValueHolder;
import client.MapleLieDetector;
import client.MapleStat;
import client.MapleTrait;
import client.PlayerRandomStream;
import client.SkillEntry;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.ItemFlag;
import client.inventory.MapleImp;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryType;
import client.inventory.MapleRing;
import client.inventory.ModifyInventory;
import client.inventory.PetCommand;
import client.messages.CommandExecute;
import client.messages.CommandProcessorUtil;
import client.messages.ConsoleCommandExecute;
import client.messages.ConsoleCommandObject;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import client.messages.commands.SkilledCommand;
import client.messages.commands.player.eventSystem.AutoPickupSystem;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.eventSystem.MapOwner;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import client.messages.commands.player.eventSystem.SellSystem;
import client.messages.commands.player.\u5408\u592a\u8c37;
import client.messages.commands.player.\u592d\u58fd\u8c37;
import client.messages.commands.player.\u592f\u592f\u8c37;
import client.messages.commands.player.\u5976\u8336\u8c37;
import client.messages.commands.player.\u61a8\u61a8\u8c37;
import client.messages.commands.player.\u672a\u77e5\u8c37;
import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import client.messages.commands.player.\u738b\u4e4b\u8c37;
import client.messages.commands.player.\u83c7\u83c7\u8c37;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.MapConstants;
import constants.MobConstants;
import constants.ServerConfig;
import constants.ServerConstants;
import constants.SpecialSkillConstants;
import constants.skills.SkillType;
import database.DBConPool;
import database.DatabaseException;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import handling.auction.handler.MTSOperation;
import handling.channel.ChannelServer;
import handling.channel.handler.BBSHandler;
import handling.channel.handler.BuddyListHandler;
import handling.channel.handler.PartyHandler;
import handling.channel.handler.PetHandler;
import handling.channel.handler.PlayersHandler;
import handling.channel.handler.StatsHandling;
import handling.login.LoginServer;
import handling.opcodes.BuyCashShopType;
import handling.opcodes.CashShopType;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.PlayerInteraction;
import handling.opcodes.SpecialEffect;
import handling.world.MapleMessenger;
import handling.world.MapleMessengerCharacter;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.guild.MapleGuild;
import handling.world.sidekick.MapleSidekick;
import java.awt.Point;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import scripting.npc.NPCScriptManager;
import scripting.portal.PortalScriptManager;
import scripting.reactor.ReactorScriptManager;
import server.Auction.AuctionItemFactory;
import server.CashItemFactory;
import server.Extend.SpecialEquipData;
import server.Extend.SpecialEquipFactory;
import server.Extend.SpecialItemData;
import server.Extend.SpecialItemFactory;
import server.FishingRewardFactory;
import server.MapleCarnivalChallenge;
import server.MapleDueyActions;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MaplePortal;
import server.MapleShopFactory;
import server.MapleShopItem;
import server.MapleSquad;
import server.MerchItemPackage;
import server.MobSkillData;
import server.ShutdownServer;
import server.StructSetItem;
import server.Timer;
import server.characterCards.MapleCharacterCards;
import server.events.MapleOxQuizFactory;
import server.life.MapleLifeFactory;
import server.life.MapleMonsterInformationProvider;
import server.life.MapleNPC;
import server.life.MobNameData;
import server.life.MonsterDropEntry;
import server.maps.AbstractMapleMapObject;
import server.maps.Event_PyramidSubway;
import server.maps.MapleFoothold;
import server.maps.MapleMap;
import server.maps.MapleMapEffect;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleNodes;
import server.maps.MapleReactor;
import server.maps.MapleReactorFactory;
import server.maps.MapleReactorStats;
import server.quest.MapleQuest;
import server.shops.MaplePlayerShopItem;
import server.swing.autoupdate.GetSelfDocName;
import tools.ArrayMap;
import tools.EmojiFilter;
import tools.ExternalCodeLongTableGetter;
import tools.FileOperation;
import tools.FileoutputUtil;
import tools.FixDropNullItem;
import tools.LoadPacket;
import tools.MaplePacketCreator;
import tools.StringUtil;
import tools.damageSkin.AttackFont;
import tools.data.RandomAccessByteStream;
import tools.database.CashShopConvert;
import tools.database.UniqueIdReset;
import tools.googledrive.SyncServerData;
import tools.html.getHtml;
import tools.npcgenerator.NPCMessage;
import tools.otp.HmacOneTimePasswordGenerator;
import tools.packet.MTSCSPacket;
import tools.use.GetMACAddress;
import tools.use.donate;
import tools.wztosql.DumpItemsAdditions;
import tools.wztosql.DumpMapName;
import tools.wztosql.DumpMobName;

public class GMCommand {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ 2;
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 5;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ 1 << 1;
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

    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005;
    }

    public /* synthetic */ GMCommand() {
        GMCommand a2;
    }

    public static class ClearSquads
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = new ArrayList<MapleSquad>(a2.getChannelServer().getAllSquads().values()).iterator();
            while (object.hasNext()) {
                ((MapleSquad)a3.next()).clear();
                object = a3;
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + UniqueIdReset.ALLATORIxDEMO("$j\u0002g\u0015U\u0016s\u0006b\u0014&J&$j\u0002g\u0015U\u0016s\u0006b\u0014");
        }

        public /* synthetic */ ClearSquads() {
            ClearSquads a2;
        }
    }

    public static class removenpc
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + BuddyListHandler.ALLATORIxDEMO("H\u0012W\u0018L\u0012T\u0007YW\u0017WH\u0012W\u0018L\u0012T\u0007Y");
        }

        public /* synthetic */ removenpc() {
            removenpc a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int a32 = Integer.parseInt(a32[1]);
            a2.getChannelServer().getMapFactory().getMap(a2.getPlayer().getMapId()).removeNpc(a32);
            return true;
        }
    }

    public static class fixface
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (((String[])a32).length < 2) {
                return false;
            }
            a32 = a32[1];
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName((String)a32);
            int n2 = World.Find.findChannel((String)a32);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, SpecialEquipData.ALLATORIxDEMO("\u6252\u4e34\u521c\u6b5d\u7385\u5b8f\u0002"));
            } else {
                MapleClient mapleClient = a2;
                if (n2 > 0) {
                    mapleClient.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u6b35\u739d\u5be7\u76da\u521c\u571c\u7d8b\u4e3e}\u7115\u0013a\u0016\u81fd\u551e\u9878p"));
                } else {
                    mapleClient.getPlayer().dropMessage("\u5243\u9664 [" + (String)a32 + "] \u982d\u9aee\u6210\u529f");
                    try {
                        MapleCharacter mapleCharacter2;
                        block19: {
                            mapleCharacter = DBConPool.getInstance().getDataSource().getConnection();
                            try {
                                block18: {
                                    PreparedStatement preparedStatement = mapleCharacter.prepareStatement(SpecialEquipData.ALLATORIxDEMO("yihxx|\fZDX^XOMIK_\u0019\u007f|x\u0019JXO\\\f\u0004\f\u000b\u001c\t\u001c\t\fnd|~|\fWMTI\u0019\u0011\u0019\u0013"));
                                    try {
                                        PreparedStatement preparedStatement2 = preparedStatement;
                                        preparedStatement2.setString(1, (String)a32);
                                        preparedStatement2.executeUpdate();
                                        preparedStatement2.close();
                                        if (preparedStatement == null) break block18;
                                        mapleCharacter2 = mapleCharacter;
                                    }
                                    catch (Throwable throwable) {
                                        Throwable throwable2;
                                        block20: {
                                            if (preparedStatement != null) {
                                                try {
                                                    preparedStatement.close();
                                                    throwable2 = throwable;
                                                    break block20;
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
                                    break block19;
                                }
                                mapleCharacter2 = mapleCharacter;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable3;
                                block22: {
                                    if (mapleCharacter != null) {
                                        try {
                                            mapleCharacter.close();
                                            throwable3 = throwable;
                                            break block22;
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
                        if (mapleCharacter2 != null) {
                            mapleCharacter.close();
                        }
                    }
                    catch (SQLException sQLException) {
                        // empty catch block
                    }
                }
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u00157])R0W4\u0014m\u739d\u5be7\u5439\u7a60\nq\u0019q\u63ef\u4eeb\u9824\u8a7c\u81fd\u57da");
        }

        public /* synthetic */ fixface() {
            fixface a2;
        }
    }

    public static class haircut
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + SyncServerData.ALLATORIxDEMO("Tb\u0014c\u0001i\u0000~U6\u73dc\u5bbc\u5478\u7a3bK*X*\u5236\u4eb0\u9858\u9ae4");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (((String[])a32).length < 2) {
                return false;
            }
            a32 = a32[1];
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName((String)a32);
            int n2 = World.Find.findChannel((String)a32);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, Event_PyramidSubway.ALLATORIxDEMO("\u625a\u4e57\u5214\u6b3e\u738d\u5bec\n"));
            } else {
                MapleClient mapleClient = a2;
                if (n2 > 0) {
                    mapleClient.getPlayer().dropMessage(5, SyncServerData.ALLATORIxDEMO("\u6b6e\u73dc\u5bbc\u769b\u5247\u575d\u7dd0\u4e7f&\u7154H M\u9858\u5545\u9839+"));
                } else {
                    mapleClient.getPlayer().dropMessage("\u5243\u9664 [" + (String)a32 + "] \u982d\u9aee\u6210\u529f");
                    try {
                        MapleCharacter mapleCharacter2;
                        block19: {
                            mapleCharacter = DBConPool.getInstance().getDataSource().getConnection();
                            try {
                                block18: {
                                    PreparedStatement preparedStatement = mapleCharacter.prepareStatement(Event_PyramidSubway.ALLATORIxDEMO("q\n`\u001bp\u001f\u00049L;V;G.A(Wzw\u001fpzL;M(\u0004g\u0004i\u0014j\u0017j\u0004\rl\u001fv\u001f\u00044E7Az\u0019z\u001b"));
                                    try {
                                        PreparedStatement preparedStatement2 = preparedStatement;
                                        preparedStatement2.setString(1, (String)a32);
                                        preparedStatement2.executeUpdate();
                                        preparedStatement2.close();
                                        if (preparedStatement == null) break block18;
                                        mapleCharacter2 = mapleCharacter;
                                    }
                                    catch (Throwable throwable) {
                                        Throwable throwable2;
                                        block20: {
                                            if (preparedStatement != null) {
                                                try {
                                                    preparedStatement.close();
                                                    throwable2 = throwable;
                                                    break block20;
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
                                    break block19;
                                }
                                mapleCharacter2 = mapleCharacter;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable3;
                                block22: {
                                    if (mapleCharacter != null) {
                                        try {
                                            mapleCharacter.close();
                                            throwable3 = throwable;
                                            break block22;
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
                        if (mapleCharacter2 != null) {
                            mapleCharacter.close();
                        }
                    }
                    catch (SQLException sQLException) {
                        // empty catch block
                    }
                }
            }
            return true;
        }

        public /* synthetic */ haircut() {
            haircut a2;
        }
    }

    public static class maplepointmap
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + BBSHandler.ALLATORIxDEMO("\u0002NBSOFSLJMWNBS\u0003\u001f\u655b\u91ec\u001d\u0003\u000e\u0003\u7d45\u6263\u672a\u738a\u5b95\u6970\u9efd");
        }

        public /* synthetic */ maplepointmap() {
            maplepointmap a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            Iterator<MapleCharacter> iterator;
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                iterator.next().modifyCSPoints(2, a32, true);
                iterator2 = iterator;
            }
            FileoutputUtil.logToFile(SyncServerData.ALLATORIxDEMO("\u0019e\u0012yZM8U9E2%\u7d13\u5162\u5745\u571c\u6926\u9ed4[~\r~"), "\r\n " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u7d66\u4e86 \u7576\u524d\u5730\u5716:" + a2.getPlayer().getMapId() + " \u73a9\u5bb6\u6953\u9ede " + a32 + "\u9ede");
            return true;
        }
    }

    public static class gashmap
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"k\u001a+\u000e\"\u0010+\rjA\u6532\u91b2t]g]\u7d2c\u623d\u6743\u73d4\u5bfc\u001a+\u000e\"");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            Iterator<MapleCharacter> iterator;
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                iterator.next().modifyCSPoints(true ? 1 : 0, a32, true);
                iterator2 = iterator;
            }
            FileoutputUtil.logToFile(GetMACAddress.ALLATORIxDEMO("u\f~\u00106$T<U,^L\u7d7f\u510b\u5729\u5775^\"J+7\u0017a\u0017"), "\r\n " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u7d66\u4e86 \u7576\u524d\u5730\u5716:" + a2.getPlayer().getMapId() + " \u73a9\u5bb6GASH " + a32 + "\u9ede");
            return true;
        }

        public /* synthetic */ gashmap() {
            gashmap a2;
        }
    }

    public static class Itemmap
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + RandomAccessByteStream.ALLATORIxDEMO("$\u0004q(h d=%q\u9056\u513a;m9\u6535\u91cas%`%\u7d2b\u6245\u6744\u73ac\u5bfb\u9056\u513a");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            Object object;
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            int n2 = CommandProcessorUtil.getOptionalIntArg(a32, 2, 1);
            Object object2 = object = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
            while (object2.hasNext()) {
                object.next().gainItem(a32, n2);
                object2 = object;
            }
            object = "[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u7d66\u4e86\u7576\u524d\u5730\u5716\u73a9\u5bb6  " + a32 + n2 + "\u500b";
            FileoutputUtil.logToFile(ExternalCodeLongTableGetter.ALLATORIxDEMO(">\u00045\u0018},\u001f4\u001e$\u0015D\u7d34\u5103\u5762\u577d\u723b\u54aa|\u001f*\u001f"), "\r\n " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u7d66\u4e86 \u7576\u524d\u5730\u5716:" + a2.getPlayer().getMapId() + " \u73a9\u5bb6 \u7269\u54c1: " + MapleItemInformationProvider.getInstance().getName(a32) + " " + n2 + "\u500b");
            return true;
        }

        public /* synthetic */ Itemmap() {
            Itemmap a2;
        }
    }

    public static class RemoveItemOff
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MobSkillData.ALLATORIxDEMO("_\u0005`\u000f{\u0005D\u0014h\rB\u0006k@1\u7209\u54cc)I^-\\\u89df\u8212\u5400\u7a513@ @\u79f6\u9604\u73a4\u5bd6\u8ea6\u4e6a\u7689\u9033\u517a");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (((String[])a32).length < 3) {
                return false;
            }
            try {
                boolean bl;
                Object object;
                PreparedStatement preparedStatement;
                boolean bl2;
                LinkedList<Long> linkedList;
                int n2;
                int n3;
                int n4;
                DruidPooledConnection druidPooledConnection;
                block25: {
                    int n5;
                    block26: {
                        block24: {
                            block23: {
                                druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                                n4 = Integer.parseInt(a32[1]);
                                a32 = a32[2];
                                n3 = 0;
                                n2 = 0;
                                linkedList = new LinkedList<Long>();
                                bl2 = GameConstants.isEquip(n4);
                                if (MapleCharacter.getCharacterByName((String)a32) != null) break block23;
                                a2.getPlayer().dropMessage(5, MobConstants.ALLATORIxDEMO("\u89e6\u8270\u4e39\u5b5a\u571c\u8cc5\u65ad\u5ea9\u3036"));
                                boolean bl3 = true;
                                if (druidPooledConnection == null) return bl3;
                                druidPooledConnection.close();
                                return bl3;
                            }
                            n3 = MapleCharacter.getCharacterByName((String)a32).getId();
                            PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(MobSkillData.ALLATORIxDEMO("~\u0005a\u0005n\u0014-\tc\u0016h\u000ey\u000f\u007f\u0019d\u0014h\rd\u0004!@|\u0015l\u000ey\ty\u0019-\u0006\u007f\u000f`@d\u000e{\u0005c\u0014b\u0012t\ty\u0005`\u0013-7E%_%-\ty\u0005`\ti@0@2@l\u000ei@n\bl\u0012l\u0003y\u0005\u007f\ti@0@2"));
                            preparedStatement2.setInt(1, n4);
                            preparedStatement2.setInt(2, n3);
                            object = preparedStatement2.executeQuery();
                            try {
                                block13: while (true) {
                                    Object object2 = object;
                                    while (object2.next()) {
                                        if (bl2) {
                                            long l2 = object.getLong(MobConstants.ALLATORIxDEMO("]lBgZv[pMk@gYkP"));
                                            if (l2 != 0L) {
                                                linkedList.add(l2);
                                            }
                                            ++n2;
                                            object2 = object;
                                            continue;
                                        }
                                        n2 += object.getInt(MobSkillData.ALLATORIxDEMO("\u0011x\u0001c\u0014d\u0014t"));
                                        continue block13;
                                    }
                                    break;
                                }
                                if (object == null) break block24;
                                n5 = n2;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable2;
                                if (object != null) {
                                    try {
                                        object.close();
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
                            object.close();
                            break block26;
                        }
                        n5 = n2;
                    }
                    if (n5 != 0) break block25;
                    a2.getPlayer().dropMessage(5, "\u73a9\u5bb6[" + (String)a32 + "]\u6c92\u6709\u7269\u54c1[" + n4 + "]\u5728\u80cc\u5305\u3002");
                    boolean bl4 = true;
                    if (druidPooledConnection == null) return bl4;
                    druidPooledConnection.close();
                    return bl4;
                }
                try {
                    if (bl2) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(MobConstants.ALLATORIxDEMO("pgXg@g\u0014dFmY\"]lBgZv[pMgEw]rYgZv\u0014U|GfG\u0014kZtQl@mF{]vQo]f\u0014?\u0014"));
                        int n6 = 0;
                        int n7 = n6;
                        while (n7 < linkedList.size()) {
                            int n8 = n6;
                            ((StringBuilder)object).append(linkedList.get(n8));
                            if (n8 < linkedList.size() - 1) {
                                ((StringBuilder)object).append(MobSkillData.ALLATORIxDEMO("@B2-\tc\u0016h\u000ey\u000f\u007f\u0019d\u0014h\rd\u0004-]-"));
                            }
                            n7 = ++n6;
                        }
                        preparedStatement = druidPooledConnection.prepareStatement(((StringBuilder)object).toString());
                        preparedStatement.executeUpdate();
                    }
                    PreparedStatement preparedStatement3 = preparedStatement = druidPooledConnection.prepareStatement(MobConstants.ALLATORIxDEMO("pgXg@g\u0014dFmY\"]lBgZv[pMk@gYq\u0014U|GfG\u0014k@gYkP\"\t\"\u000b\"UlP\"WjUpUa@gFkP\"\t\"\u000b"));
                    preparedStatement3.setInt(1, n4);
                    preparedStatement3.setInt(2, n3);
                    preparedStatement3.executeUpdate();
                    preparedStatement.close();
                    a2.getPlayer().dropMessage(6, "\u5df2\u7d93\u5f9e " + (String)a32 + " \u8eab\u4e0a\u88ab\u79fb\u9664\u4e86\u9053\u5177 ID[" + n4 + "] \u6578\u91cfx" + n2);
                    bl = true;
                    if (druidPooledConnection == null) return bl;
                }
                catch (Throwable throwable) {
                    Throwable throwable4;
                    if (druidPooledConnection != null) {
                        try {
                            druidPooledConnection.close();
                            throwable4 = throwable;
                            throw throwable4;
                        }
                        catch (Throwable a32) {
                            throwable.addSuppressed(a32);
                        }
                    }
                    throwable4 = throwable;
                    throw throwable4;
                }
                druidPooledConnection.close();
                return bl;
            }
            catch (SQLException sQLException) {
                return true;
            }
        }

        public /* synthetic */ RemoveItemOff() {
            RemoveItemOff a2;
        }
    }

    public static class RemoveItem
    extends CommandExecute {
        public /* synthetic */ RemoveItem() {
            RemoveItem a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"&\u0003\u0019\t\u0002\u0003=\u0012\u0011\u000bTZ\u89a6\u8214\u5479\u7a57JFH\u720f\u54b5/0XTKT\u799d\u9610\u73cf\u5bc2\u8ecd\u4e7e\u76e2\u9027\u5111");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 3) {
                return false;
            }
            String string = a3[1];
            int n2 = Integer.parseInt(a3[2]);
            String string2 = string;
            int n3 = World.Find.findChannel(string2);
            int n4 = World.Find.findWorld(string2);
            if (n3 <= 0) {
                a2.getPlayer().dropMessage(6, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u73dd\u5bd0\u5fb1\u986e\u4e7e\u7dbc"));
                return true;
            }
            a3 = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName(string);
            if (a3 == null) {
                a2.getPlayer().dropMessage(6, StringUtil.ALLATORIxDEMO("\u6b55\u7383\u5b87\u4e0c\u4e3c\u5b72\u5719"));
            } else {
                ((MapleCharacter)a3).removeAll(n2, false, true);
                a2.getPlayer().dropMessage(6, "\u6240\u6709ID\u70ba " + n2 + " \u7684\u9053\u5177\u5df2\u7d93\u5f9e " + string + " \u8eab\u4e0a\u88ab\u79fb\u9664\u4e86");
            }
            return true;
        }
    }

    public static class log
    extends CommandExecute {
        /*
         * Enabled aggressive block sorting
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient;
            int n2;
            Object object;
            String string;
            boolean bl;
            block30: {
                String[] arrstring;
                int n3;
                StringBuilder stringBuilder;
                boolean bl2;
                block29: {
                    int n4;
                    int n5;
                    bl2 = false;
                    bl = false;
                    string = null;
                    String[] arrstring2 = new String[9];
                    arrstring2[0] = ArrayMap.ALLATORIxDEMO("\u50d8\u5be5");
                    arrstring2[1] = SpecialSkillConstants.ALLATORIxDEMO("\u8038\u591e");
                    arrstring2[2] = ArrayMap.ALLATORIxDEMO("\u5529\u5798");
                    arrstring2[3] = SpecialSkillConstants.ALLATORIxDEMO("\u5e91\u649a");
                    arrstring2[4] = ArrayMap.ALLATORIxDEMO("\u7cd1\u971e\u5529\u4eec");
                    arrstring2[5] = SpecialSkillConstants.ALLATORIxDEMO("\u9ea3\u6748");
                    arrstring2[6] = ArrayMap.ALLATORIxDEMO("\u5318\u8eae");
                    arrstring2[7] = SpecialSkillConstants.ALLATORIxDEMO("\u65c5\u7ded");
                    arrstring2[8] = ArrayMap.ALLATORIxDEMO("\u7614\u5133");
                    String[] arrstring3 = arrstring2;
                    stringBuilder = new StringBuilder();
                    String[] arrstring4 = arrstring3;
                    n3 = arrstring3.length;
                    int n6 = n5 = 0;
                    while (n6 < n3) {
                        String string2 = arrstring4[n5];
                        stringBuilder.append(string2);
                        stringBuilder.append(SpecialSkillConstants.ALLATORIxDEMO("\u0017]\u0017"));
                        n6 = ++n5;
                    }
                    if (a3.length < 3) {
                        a2.getPlayer().dropMessage("\u76ee\u524dLog\u7a2e\u985e: " + stringBuilder.toString());
                        return false;
                    }
                    if (!a3[1].contains(ArrayMap.ALLATORIxDEMO("\u95dd")) && !a3[1].contains(SpecialSkillConstants.ALLATORIxDEMO("\u95eb"))) {
                        return false;
                    }
                    if (a3[1].contains(ArrayMap.ALLATORIxDEMO("\u95dd")) && a3[1].contains(SpecialSkillConstants.ALLATORIxDEMO("\u95eb"))) {
                        a2.getPlayer().dropMessage(ArrayMap.ALLATORIxDEMO("\u8a9d\u5520\u904f\u4f22\u7bf7\u7469\u54b7\u525f\u5ec3\u6640\u89d7\u95e4\u90d2\u6640\u958a\u540di"));
                        return true;
                    }
                    int n7 = n4 = 0;
                    while (n7 < arrstring3.length) {
                        if (a3[2].contains(arrstring3[n4])) {
                            bl2 = true;
                            string = arrstring3[n4];
                            arrstring = a3;
                            break block29;
                        }
                        n7 = ++n4;
                    }
                    arrstring = a3;
                }
                bl = arrstring[1].contains(SpecialSkillConstants.ALLATORIxDEMO("\u95bc"));
                if (!bl2) {
                    a2.getPlayer().dropMessage("\u76ee\u524dLog\u7a2e\u985e: " + stringBuilder.toString());
                    return true;
                }
                object = string;
                n3 = -1;
                switch (((String)object).hashCode()) {
                    case 778794: {
                        if (!((String)object).equals(ArrayMap.ALLATORIxDEMO("\u5e8c\u64fb"))) break;
                        n2 = n3 = 0;
                        break block30;
                    }
                    case 664028: {
                        if (!((String)object).equals(SpecialSkillConstants.ALLATORIxDEMO("\u50c5\u5b84"))) break;
                        n2 = n3 = 1;
                        break block30;
                    }
                    case 1040927: {
                        if (!((String)object).equals(ArrayMap.ALLATORIxDEMO("\u8025\u597f"))) break;
                        n2 = n3 = 2;
                        break block30;
                    }
                    case 699208: {
                        if (!((String)object).equals(SpecialSkillConstants.ALLATORIxDEMO("\u5534\u57f9"))) break;
                        n2 = n3 = 3;
                        break block30;
                    }
                    case 989260286: {
                        if (!((String)object).equals(ArrayMap.ALLATORIxDEMO("\u7cd1\u971e\u5529\u4eec"))) break;
                        n2 = n3 = 4;
                        break block30;
                    }
                    case 1286862: {
                        if (!((String)object).equals(SpecialSkillConstants.ALLATORIxDEMO("\u9ea3\u6748"))) break;
                        n2 = n3 = 5;
                        break block30;
                    }
                    case 698977: {
                        if (!((String)object).equals(ArrayMap.ALLATORIxDEMO("\u5318\u8eae"))) break;
                        n2 = n3 = 6;
                        break block30;
                    }
                    case 839427: {
                        if (!((String)object).equals(SpecialSkillConstants.ALLATORIxDEMO("\u65c5\u7ded"))) break;
                        n2 = n3 = 7;
                        break block30;
                    }
                    case 961098: {
                        if (!((String)object).equals(ArrayMap.ALLATORIxDEMO("\u7614\u5133"))) break;
                        n3 = 8;
                    }
                }
                n2 = n3;
            }
            switch (n2) {
                case 0: {
                    ServerConfig.LOG_MEGA = bl;
                    mapleClient = a2;
                    break;
                }
                case 1: {
                    ServerConfig.LOG_DAMAGE = bl;
                    mapleClient = a2;
                    break;
                }
                case 2: {
                    ServerConfig.LOG_CHAT = bl;
                    mapleClient = a2;
                    break;
                }
                case 3: {
                    ServerConfig.LOG_CSBUY = bl;
                    mapleClient = a2;
                    break;
                }
                case 4: {
                    ServerConfig.LOG_MERCHANT = bl;
                    mapleClient = a2;
                    break;
                }
                case 5: {
                    ServerConfig.LOG_CHALKBOARD = bl;
                    mapleClient = a2;
                    break;
                }
                case 6: {
                    ServerConfig.LOG_SCROLL = bl;
                    mapleClient = a2;
                    break;
                }
                case 7: {
                    ServerConfig.LOG_DC = bl;
                    mapleClient = a2;
                    break;
                }
                case 8: {
                    GameSetConstants.LOG_LOGIN = bl;
                }
                default: {
                    mapleClient = a2;
                }
            }
            object = "[GM \u5bc6\u8a9e] \u7ba1\u7406\u54e1[" + mapleClient.getPlayer().getName() + "] " + a3[1] + "\u4e86" + string + "\u7684Log";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice((String)object));
            return true;
        }

        public /* synthetic */ log() {
            log a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + SpecialSkillConstants.ALLATORIxDEMO("[\u001dPR\u95bc]\u95ebR{\u001dP\u7a5c\u9869\u547f\u7a06");
        }
    }

    public static class FCompleteOther
    extends CommandExecute {
        public /* synthetic */ FCompleteOther() {
            FCompleteOther a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MTSOperation.ALLATORIxDEMO("E/L!S F8F#W$F>\u0003a\u0003\u4e41\u77c6\u901f\u5546");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleQuest.getInstance(Integer.parseInt(a3[2])).forceComplete(a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]), Integer.parseInt(a3[3]));
            return true;
        }
    }

    public static class FStartOther
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleQuest.getInstance(Integer.parseInt(a3[2])).forceStart(a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]), Integer.parseInt(a3[3]), a3.length >= 4 ? a3[4] : null);
            return true;
        }

        public /* synthetic */ FStartOther() {
            FStartOther a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleShopItem.ALLATORIxDEMO("A\u000fS\u001dU\bH\bO\u0019U\\\n\\\u4e2a\u7799\u9074\u5519");
        }
    }

    public static class FCompleteQuest
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleQuest.getInstance(Integer.parseInt(a3[1])).forceComplete(a2.getPlayer(), Integer.parseInt(a3[2]));
            return true;
        }

        public /* synthetic */ FCompleteQuest() {
            FCompleteQuest a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleNodes.ALLATORIxDEMO("hOaA~@kXk]{I}X.\u0010\u4ef5\u52f5Gh0\f#\f\u5f39\u521a\u5b82\u623c\u4ef5\u52f5");
        }
    }

    public static class FStartQuest
    extends CommandExecute {
        public /* synthetic */ FStartQuest() {
            FStartQuest a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u000f:\u001d(\u001b=\u0018<\f:\u001diU\u4eb2\u52b0\u0000-wIdI\u5f7e\u525f\u95c2\u59a2\u4eb2\u52b0");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleQuest.getInstance(Integer.parseInt(a3[1])).forceStart(a2.getPlayer(), Integer.parseInt(a3[2]), a3.length >= 4 ? a3[3] : null);
            return true;
        }
    }

    public static class CompleteQuest
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleQuest.getInstance(Integer.parseInt(a3[1])).complete(a2.getPlayer(), Integer.parseInt(a3[2]), Integer.parseInt(a3[3]));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleDueyActions.ALLATORIxDEMO("4Y:F;S#S&C2E#\u0016k\u4ecd\u528e\u007f\u0013\bw\u001bw\u5bba\u6247\u4ecd\u528e");
        }

        public /* synthetic */ CompleteQuest() {
            CompleteQuest a2;
        }
    }

    public static class StartQuest
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + GMCommand.ALLATORIxDEMO("A\u0016S\u0010F\u0013G\u0007A\u0016\u0012^\u4ec9\u52bb{&\fB\u001fB\u95b9\u59a9\u4ec9\u52bb");
        }

        public /* synthetic */ StartQuest() {
            StartQuest a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleQuest.getInstance(Integer.parseInt(a3[1])).start(a2.getPlayer(), Integer.parseInt(a3[2]));
            return true;
        }
    }

    public static class ResetQuest
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleQuest.getInstance(Integer.parseInt(a3[1])).forfeit(a2.getPlayer());
            return true;
        }

        public /* synthetic */ ResetQuest() {
            ResetQuest a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleCoolDownValueHolder.ALLATORIxDEMO(")F(F/R.F(W{\u001f\u4ea0\u52fa\u0012ge\u0003v\u0003\u9196\u7f4d\u4ea0\u52fa");
        }
    }

    public static class SetReactor
    extends CommandExecute {
        public /* synthetic */ SetReactor() {
            SetReactor a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            a2.getPlayer().getMap().setReactorState(Byte.parseByte(a3[1]));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + NPCMessage.ALLATORIxDEMO("\u0005\u001b\u0019\u0000\b\u0013\u000e\u0006\u0002\u0000M_M\u898a\u78dd \b\u0013\u000e\u0006\u0002\u0000");
        }
    }

    public static class ResetReactors
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u5976\u8336\u8c37.ALLATORIxDEMO((String)"#|\"|%k4x2m>k\"9|9\u919c\u7f77\u6b35\u5729\u5747\u6259\u6758\u769d\u0003|0z%v#");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getMap().resetReactors();
            return true;
        }

        public /* synthetic */ ResetReactors() {
            ResetReactors a2;
        }
    }

    public static class DestroyReactor
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MonsterPetSystem.ALLATORIxDEMO("<!+'*<!!=2;'7!x~x\u79a8\u963c\u0001=2;'7!");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = MapleMapObjectType.REACTOR;
            Object object = a2.getPlayer().getMap().getMapObjectsInRange(a2.getPlayer().getPosition(), Double.POSITIVE_INFINITY, Arrays.asList(arrmapleMapObjectType));
            if (a3[1].equals(MapleSidekick.ALLATORIxDEMO("\u0011\u000f\u001c"))) {
                Object object2 = object = object.iterator();
                while (object2.hasNext()) {
                    MapleReactor mapleReactor = (MapleReactor)((MapleMapObject)object.next());
                    object2 = object;
                    a2.getPlayer().getMap().destroyReactor(mapleReactor.getObjectId());
                }
            } else {
                a2.getPlayer().getMap().destroyReactor(Integer.parseInt(a3[1]));
            }
            return true;
        }

        public /* synthetic */ DestroyReactor() {
            DestroyReactor a2;
        }
    }

    public static class HReactor
    extends CommandExecute {
        public /* synthetic */ HReactor() {
            HReactor a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + ConsoleCommandObject.ALLATORIxDEMO("tShHy[\u007fNsH<\u0017<\u89c2\u78achy[\u007fNsH");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            a2.getPlayer().getMap().getReactorByOid(Integer.parseInt(a3[1])).hitReactor(a2);
            return true;
        }
    }

    public static class SpawnReactor
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            MapleReactorStats mapleReactorStats = MapleReactorFactory.getReactor(Integer.parseInt(a3[1]));
            a3 = new MapleReactor(mapleReactorStats, Integer.parseInt(a3[1]), a2.getWorld());
            MapleClient mapleClient = a2;
            ((MapleReactor)a3).setDelay(-1);
            ((AbstractMapleMapObject)a3).setPosition(mapleClient.getPlayer().getPosition());
            mapleClient.getPlayer().getMap().spawnReactor((MapleReactor)a3);
            return true;
        }

        public /* synthetic */ SpawnReactor() {
            SpawnReactor a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MTSCSPacket.ALLATORIxDEMO("VZD]KX@KF^JX\u0005\u0007\u0005\u8a07\u7aeex@KF^JX");
        }
    }

    public static class MapRelog
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + RandomAccessByteStream.ALLATORIxDEMO("c,n(w(i\"bm(m\u5042\u7636\u51ff\u51c0\u767e\u5128");
        }

        public /* synthetic */ MapRelog() {
            MapRelog a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().MapReload(910000000);
            return true;
        }
    }

    public static class FakeRelog
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0007x\n|\u0013|\rv\u00069L9\u5026\u7662\u519b\u5194\u761a\u517c");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            a3 = mapleClient.getPlayer();
            mapleClient.sendPacket(MaplePacketCreator.getCharInfo((MapleCharacter)a3));
            Object object = a3;
            ((MapleCharacter)a3).getMap().removePlayer((MapleCharacter)object);
            ((MapleCharacter)object).getMap().addPlayer((MapleCharacter)a3);
            return true;
        }

        public /* synthetic */ FakeRelog() {
            FakeRelog a2;
        }
    }

    public static class LevelUp
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient;
            if (a32.length < 2) {
                MapleClient mapleClient2 = a2;
                mapleClient = mapleClient2;
                mapleClient2.getPlayer().levelUp();
            } else {
                int n2 = 0;
                try {
                    n2 = Integer.parseInt(a32[1]);
                }
                catch (Exception a32) {
                    // empty catch block
                }
                int n3 = a32 = 0;
                while (n3 < n2) {
                    a2.getPlayer().levelUp();
                    n3 = ++a32;
                }
                mapleClient = a2;
            }
            mapleClient.getPlayer().setExp(0);
            a2.getPlayer().updateSingleStat(MapleStat.EXP, 0);
            return true;
        }

        public /* synthetic */ LevelUp() {
            LevelUp a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + CashShopConvert.ALLATORIxDEMO("\u0001 \u001b \u00010\u001de@e\u7b24\u7d5f\u4e67\u5302");
        }
    }

    public static class logindoor
    extends CommandExecute {
        public /* synthetic */ logindoor() {
            logindoor a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + DumpItemsAdditions.ALLATORIxDEMO("J&A H-I&Ti\u0006d\u0006\u7be8\u7420\u54a8\u765d\u512c\u6a07\u5f46\u95ad\u9595");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.ADMIN_ONLY = !GameSetConstants.ADMIN_ONLY;
            a2.getPlayer().dropMessage(0, "[logindoor] " + (GameSetConstants.ADMIN_ONLY ? DumpItemsAdditions.ALLATORIxDEMO("\u95ad\u5516") : SkilledCommand.ALLATORIxDEMO("\u95a7\u95a2")));
            System.out.println("[logindoor] " + (GameSetConstants.ADMIN_ONLY ? DumpItemsAdditions.ALLATORIxDEMO("\u95ad\u5516") : SkilledCommand.ALLATORIxDEMO("\u95a7\u95a2")));
            return true;
        }
    }

    public static class autoreg
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapOwner.ALLATORIxDEMO(")K<Q:[/\u001eh\u0013h\u81d4\u529d\u8a05\u51c2\u95b5\u9594");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            LoginServer.setAutoReg(!LoginServer.getAutoReg());
            a2.getPlayer().dropMessage(0, "[autoreg] " + (LoginServer.getAutoReg() ? MapOwner.ALLATORIxDEMO("\u95b5\u5517") : StatsHandling.ALLATORIxDEMO("\u95a7\u95a7")));
            System.out.println("[autoreg] " + (LoginServer.getAutoReg() ? MapOwner.ALLATORIxDEMO("\u95b5\u5517") : StatsHandling.ALLATORIxDEMO("\u95a7\u95a7")));
            return true;
        }

        public /* synthetic */ autoreg() {
            autoreg a2;
        }
    }

    public static class KillID
    extends CommandExecute {
        public /* synthetic */ KillID() {
            KillID a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MobSkillData.ALLATORIxDEMO("+d\fa)I@1\u73c9\u5bbb)I^-M-\u6bda\u6384\u73c9\u5bbb");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            MapleCharacter mapleCharacter = a2.getPlayer();
            if (((String[])a3).length < 2) {
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
            if (n4 <= 0) {
                return false;
            }
            a3 = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterById(n3);
            if (a3 == null) {
                a2.getPlayer().dropMessage(6, "[kill] \u73a9\u5bb6ID " + n3 + " \u4e0d\u5b58\u5728.");
            } else if (mapleCharacter.allowedToTarget((MapleCharacter)a3)) {
                ((MapleCharacter)a3).getStat().setHp(0);
                ((MapleCharacter)a3).getStat().setMp(0);
                Object object = a3;
                ((MapleCharacter)object).updateSingleStat(MapleStat.HP, 0);
                ((MapleCharacter)object).updateSingleStat(MapleStat.MP, 0);
            }
            return true;
        }
    }

    public static class Marry
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 3) {
                return false;
            }
            int n2 = Integer.parseInt(a3[2]);
            if (!GameConstants.isEffectRing(n2)) {
                a2.getPlayer().dropMessage(6, \u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u9359\u8ad5\u76f2\u6263\u637182_"));
            } else {
                Object object = a3[1];
                int n3 = World.Find.findChannel((String)object);
                int n4 = World.Find.findWorld((String)object);
                if (n3 <= 0) {
                    a2.getPlayer().dropMessage(6, NPCMessage.ALLATORIxDEMO("\u73c4\u5bc4\u5fa8\u987a\u4e67\u7da8"));
                    return false;
                }
                a3 = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName((String)object);
                if (a3 == null) {
                    a2.getPlayer().dropMessage(6, \u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u73df\u5bc7\u5fb3\u9879\u4e7c\u7dab"));
                } else {
                    int[] arrn = new int[2];
                    arrn[0] = MapleInventoryIdentifier.getInstance();
                    arrn[1] = MapleInventoryIdentifier.getInstance();
                    object = arrn;
                    try {
                        MapleCharacter[] arrmapleCharacter = new MapleCharacter[2];
                        arrmapleCharacter[0] = a3;
                        arrmapleCharacter[1] = a2.getPlayer();
                        MapleCharacter[] arrmapleCharacter2 = arrmapleCharacter;
                        int n5 = n4 = 0;
                        while (n5 < arrmapleCharacter2.length) {
                            Equip equip = (Equip)MapleItemInformationProvider.getInstance().getEquipById(n2);
                            if (equip == null) {
                                a2.getPlayer().dropMessage(6, NPCMessage.ALLATORIxDEMO("\u9342\u8ad6\u76e9\u6260\u636a;)\\"));
                                return true;
                            }
                            equip.setUniqueId((int)object[n4]);
                            MapleInventoryManipulator.addbyItem(arrmapleCharacter2[n4].getClient(), equip.copy());
                            arrmapleCharacter2[n4].dropMessage(6, "\u6210\u529f\u8207  " + arrmapleCharacter2[n4 == 0 ? 1 : 0].getName() + " \u7d50\u5a5a");
                            n5 = ++n4;
                        }
                        MapleRing.addToDB(n2, a2.getPlayer(), ((MapleCharacter)a3).getName(), ((MapleCharacter)a3).getId(), (int[])object);
                    }
                    catch (SQLException sQLException) {
                        // empty catch block
                    }
                }
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u001b\u0010\u0004\u0003\u000fQJ\u73d8\u5bc0\u547c\u7a47OVM\u6264\u6376\u4e95\u78cdHQ[Q\u7d26\u5a2b");
        }

        public /* synthetic */ Marry() {
            Marry a2;
        }
    }

    public static class Letter
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            int n3;
            String[] arrstring;
            int n4;
            int n5;
            if (((String[])a3).length < 3) {
                a2.getPlayer().dropMessage(6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u637a\u4eae\u89f2\u520dGj"));
                return false;
            }
            if (a3[1].equalsIgnoreCase(FileOperation.ALLATORIxDEMO("j~hic"))) {
                n5 = 3991026;
                n4 = 3990019;
                arrstring = a3;
            } else if (a3[1].equalsIgnoreCase(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"8\u0018."))) {
                n5 = 3991000;
                n4 = 3990009;
                arrstring = a3;
            } else {
                a2.getPlayer().dropMessage(6, FileOperation.ALLATORIxDEMO("\u6726\u77e8\u7688\u9842\u827e,"));
                return true;
            }
            a3 = StringUtil.joinStringFrom(arrstring, 2);
            Serializable serializable = new ArrayList<Integer>();
            a3 = ((String)a3).toUpperCase();
            int n6 = n3 = 0;
            while (n6 < ((String)a3).length()) {
                n2 = ((String)a3).charAt(n3);
                if (n2 == 32) {
                    serializable.add(-1);
                } else if (n2 >= 65 && n2 <= 90) {
                    serializable.add(n2);
                } else if (n2 >= 48 && n2 <= 57) {
                    serializable.add(n2 + 200);
                }
                n6 = ++n3;
            }
            n3 = 32;
            n2 = a2.getPlayer().getPosition().x - ((String)a3).length() / 2 * 32;
            a3 = serializable.iterator();
            while (a3.hasNext()) {
                Item item2;
                serializable = (Integer)a3.next();
                if ((Integer)serializable == -1) {
                    n2 += 32;
                    continue;
                }
                if ((Integer)serializable < 200) {
                    n3 = n5 + (Integer)serializable - 65;
                    Point point = new Point(n2, a2.getPlayer().getPosition().y);
                    n2 += 32;
                    a2.getPlayer().getMap().spawnItemDrop(a2.getPlayer(), a2.getPlayer(), item2 = new Item(n3, 0, 1), point, false, false);
                    continue;
                }
                if ((Integer)serializable < 200 || (Integer)serializable > 300) continue;
                n3 = n4 + (Integer)serializable - 48 - 200;
                item2 = new Item(n3, 0, 1);
                Point point = new Point(n2, a2.getPlayer().getPosition().y);
                n2 += 32;
                a2.getPlayer().getMap().spawnItemDrop(a2.getPlayer(), a2.getPlayer(), item2, point, false, false);
            }
            return true;
        }

        public /* synthetic */ Letter() {
            Letter a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0011/\t>\u00188]v\u001e%\u0011%\u000fjU-\u000f/\u0018$R8\u0018.Tt]v\n%\u000f.CjPj\u907c\u4fab");
        }
    }

    public static class UnlockInv
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object;
            ArrayMap<IItem, MapleInventoryType> arrayMap = new ArrayMap<IItem, MapleInventoryType>();
            boolean bl = false;
            if (a3.length < 2 || a3[1].equals(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u511c\u908e"))) {
                int n2;
                object = MapleInventoryType.values();
                int n3 = ((MapleInventoryType[])object).length;
                int n4 = n2 = 0;
                while (n4 < n3) {
                    MapleInventoryType mapleInventoryType = object[n2];
                    Iterator<IItem> iterator = a2.getPlayer().getInventory(mapleInventoryType).iterator();
                    while (iterator.hasNext()) {
                        Iterator<IItem> iterator2;
                        IItem iItem = iterator2.next();
                        if (ItemFlag.LOCK.check(iItem.getFlag())) {
                            IItem iItem2 = iItem;
                            iItem2.setFlag(iItem2.getFlag() - ItemFlag.LOCK.getValue());
                            bl = true;
                            a2.getPlayer().reloadC();
                            a2.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5da5\u7d89\u89b4\u938c"));
                        }
                        if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                            IItem iItem3 = iItem;
                            iItem3.setFlag(iItem3.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                            bl = true;
                            a2.getPlayer().reloadC();
                            a2.getPlayer().dropMessage(5, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d86\u7df5\u8997\u93f0"));
                        }
                        if (bl) {
                            arrayMap.put(iItem, mapleInventoryType);
                        }
                        bl = false;
                        iterator = iterator2;
                    }
                    n4 = ++n2;
                }
            } else if (a3[1].equals(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5de8\u888a\u5083\u9004\u516d"))) {
                Object object2 = object = a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).iterator();
                while (object2.hasNext()) {
                    IItem iItem = (IItem)object.next();
                    if (ItemFlag.LOCK.check(iItem.getFlag())) {
                        IItem iItem4 = iItem;
                        iItem4.setFlag(iItem4.getFlag() - ItemFlag.LOCK.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d86\u7df5\u8997\u93f0"));
                    }
                    if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                        IItem iItem5 = iItem;
                        iItem5.setFlag(iItem5.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5da5\u7d89\u89b4\u938c"));
                    }
                    if (bl) {
                        arrayMap.put(iItem, MapleInventoryType.EQUIP);
                    }
                    bl = false;
                    object2 = object;
                }
            } else if (a3[1].equals(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6b12\u560e"))) {
                Object object3 = object = a2.getPlayer().getInventory(MapleInventoryType.EQUIP).iterator();
                while (object3.hasNext()) {
                    IItem iItem = (IItem)object.next();
                    if (ItemFlag.LOCK.check(iItem.getFlag())) {
                        IItem iItem6 = iItem;
                        iItem6.setFlag(iItem6.getFlag() - ItemFlag.LOCK.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5da5\u7d89\u89b4\u938c"));
                    }
                    if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                        IItem iItem7 = iItem;
                        iItem7.setFlag(iItem7.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d86\u7df5\u8997\u93f0"));
                    }
                    if (bl) {
                        arrayMap.put(iItem, MapleInventoryType.EQUIP);
                    }
                    bl = false;
                    object3 = object;
                }
            } else if (a3[1].equals(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u6ddf\u800d"))) {
                Object object4 = object = a2.getPlayer().getInventory(MapleInventoryType.USE).iterator();
                while (object4.hasNext()) {
                    IItem iItem = (IItem)object.next();
                    if (ItemFlag.LOCK.check(iItem.getFlag())) {
                        IItem iItem8 = iItem;
                        iItem8.setFlag(iItem8.getFlag() - ItemFlag.LOCK.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d86\u7df5\u8997\u93f0"));
                    }
                    if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                        IItem iItem9 = iItem;
                        iItem9.setFlag(iItem9.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5da5\u7d89\u89b4\u938c"));
                    }
                    if (bl) {
                        arrayMap.put(iItem, MapleInventoryType.USE);
                    }
                    bl = false;
                    object4 = object;
                }
            } else if (a3[1].equals(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u88a9\u9898"))) {
                Object object5 = object = a2.getPlayer().getInventory(MapleInventoryType.SETUP).iterator();
                while (object5.hasNext()) {
                    IItem iItem = (IItem)object.next();
                    if (ItemFlag.LOCK.check(iItem.getFlag())) {
                        IItem iItem10 = iItem;
                        iItem10.setFlag(iItem10.getFlag() - ItemFlag.LOCK.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5da5\u7d89\u89b4\u938c"));
                    }
                    if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                        IItem iItem11 = iItem;
                        iItem11.setFlag(iItem11.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d86\u7df5\u8997\u93f0"));
                    }
                    if (bl) {
                        arrayMap.put(iItem, MapleInventoryType.SETUP);
                    }
                    bl = false;
                    object5 = object;
                }
            } else if (a3[1].equals(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5121\u4ecc"))) {
                Object object6 = object = a2.getPlayer().getInventory(MapleInventoryType.ETC).iterator();
                while (object6.hasNext()) {
                    IItem iItem = (IItem)object.next();
                    if (ItemFlag.LOCK.check(iItem.getFlag())) {
                        IItem iItem12 = iItem;
                        iItem12.setFlag(iItem12.getFlag() - ItemFlag.LOCK.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d86\u7df5\u8997\u93f0"));
                    }
                    if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                        IItem iItem13 = iItem;
                        iItem13.setFlag(iItem13.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5da5\u7d89\u89b4\u938c"));
                    }
                    if (bl) {
                        arrayMap.put(iItem, MapleInventoryType.ETC);
                    }
                    bl = false;
                    object6 = object;
                }
            } else if (a3[1].equals(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u720d\u6bec"))) {
                Object object7 = object = a2.getPlayer().getInventory(MapleInventoryType.CASH).iterator();
                while (object7.hasNext()) {
                    IItem iItem = (IItem)object.next();
                    if (ItemFlag.LOCK.check(iItem.getFlag())) {
                        IItem iItem14 = iItem;
                        iItem14.setFlag(iItem14.getFlag() - ItemFlag.LOCK.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5da5\u7d89\u89b4\u938c"));
                    }
                    if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                        IItem iItem15 = iItem;
                        iItem15.setFlag(iItem15.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                        bl = true;
                        a2.getPlayer().reloadC();
                        a2.getPlayer().dropMessage(5, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d86\u7df5\u8997\u93f0"));
                    }
                    if (bl) {
                        arrayMap.put(iItem, MapleInventoryType.CASH);
                    }
                    bl = false;
                    object7 = object;
                }
            } else {
                return false;
            }
            Object object8 = object = arrayMap.entrySet().iterator();
            while (object8.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                a2.getPlayer().forceReAddItem_NoUpdate(((IItem)entry.getKey()).copy(), (MapleInventoryType)((Object)entry.getValue()));
                object8 = object;
            }
            return true;
        }

        public /* synthetic */ UnlockInv() {
            UnlockInv a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + HmacOneTimePasswordGenerator.ALLATORIxDEMO("\"t;u4q>t!:k\u5172\u90bf5\u5da5\u88c7\u50ce\u9049\u51205\u6b31\u5672x\u6d92\u80405\u888a\u98e4x\u516c\u4e815\u722e\u6b90i:z:\u89b4\u938c\u9004\u516d");
        }
    }

    public static class Shop
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + Timer.ALLATORIxDEMO("g\b{\u00104M4\u95eb\u554b\u5526\u5e83");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleShopFactory mapleShopFactory;
            MapleShopFactory mapleShopFactory2 = MapleShopFactory.getInstance();
            int n2 = 0;
            try {
                n2 = Integer.parseInt(a32[1]);
                mapleShopFactory = mapleShopFactory2;
            }
            catch (Exception a32) {
                mapleShopFactory = mapleShopFactory2;
            }
            if (mapleShopFactory.getShop(n2) != null) {
                mapleShopFactory2.getShop(n2).sendShop(a2);
            } else {
                a2.getPlayer().dropMessage(5, "\u6b64\u5546\u5e97ID[" + n2 + "]\u4e0d\u5b58\u5728");
            }
            return true;
        }

        public /* synthetic */ Shop() {
            Shop a2;
        }
    }

    public static class AP
    extends CommandExecute {
        public /* synthetic */ AP() {
            AP a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int a32 = CommandProcessorUtil.getOptionalIntArg(a32, 1, 1);
            if (a32 + mapleCharacter.getRemainingAp() > 32767) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.setRemainingAp((short)32767);
                mapleCharacter2.updateSingleStat(MapleStat.AVAILABLEAP, 32767);
            } else {
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.setRemainingAp((short)(a32 + mapleCharacter3.getRemainingAp()));
                mapleCharacter.updateSingleStat(MapleStat.AVAILABLEAP, mapleCharacter.getRemainingAp());
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"Tq\u0015Z\u654d\u91ceh!\u0018!\u58ab\u52a1tQ");
        }
    }

    public static class SP
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + SellSystem.ALLATORIxDEMO("\u0006\u001fU4\u650d\u91a0(OXO\u58eb\u52cf&?");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().setRemainingSp(CommandProcessorUtil.getOptionalIntArg(a3, 1, 1));
            mapleClient.sendPacket(MaplePacketCreator.updateSp(mapleClient.getPlayer(), false));
            return true;
        }

        public /* synthetic */ SP() {
            SP a2;
        }
    }

    public static class ClearSkills
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u5408\u592a\u8c37.ALLATORIxDEMO((String)"MUkX|jePbU}\u0019#\u0019\u628e\u80c4\u5166\u6db1");
        }

        public /* synthetic */ ClearSkills() {
            ClearSkills a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().clearSkills();
            return true;
        }
    }

    public static class MaxSkills
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + DumpMapName.ALLATORIxDEMO("{2N\u0000]:Z?Es\u001bs\u62b6\u80ae\u515e\u6eac");
        }

        public /* synthetic */ MaxSkills() {
            MaxSkills a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().maxSkills();
            return true;
        }
    }

    public static class MaxSkillsByJob2
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + PlayersHandler.ALLATORIxDEMO("KK~ymCjFuh\u007f`iH4\n+\n\u8071\u6947\u6286\u80d7\u516e\u6ed5&\u63b8\u9662\u001a\u8f4f");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().maxSkillsByJob2();
            return true;
        }

        public /* synthetic */ MaxSkillsByJob2() {
            MaxSkillsByJob2 a2;
        }
    }

    public static class MaxSkillsByJob
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().maxSkillsByJob();
            return true;
        }

        public /* synthetic */ MaxSkillsByJob() {
            MaxSkillsByJob a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleBuffStatValueHolder.ALLATORIxDEMO("\r18\u0003+9,<3\u00129\u001a/2`}`\u8027\u692d\u62d0\u80bd\u5138\u6ebf");
        }
    }

    public static class GiveSkill
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 3) {
                return false;
            }
            String string = a3[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0) {
                return false;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            a3 = SkillFactory.getSkill(Integer.parseInt(a3[2]));
            byte by = (byte)CommandProcessorUtil.getOptionalIntArg((String[])a3, 3, 1);
            n2 = (byte)CommandProcessorUtil.getOptionalIntArg((String[])a3, 4, 1);
            if (by > a3.getMaxLevel()) {
                by = a3.getMaxLevel();
            }
            mapleCharacter.changeSkillLevel((ISkill)a3, (int)by, n2);
            return true;
        }

        public /* synthetic */ GiveSkill() {
            GiveSkill a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleSidekick.ALLATORIxDEMO("\u0004\u0019\u0015\u0015\u0010\u001b\n\u001c\u000fP_\u73d9\u5bd5\u547d\u7a52NCL\u62e3\u808d*4]P8\u62f0\u809e\u7b39\u7d79-C+\u62e3\u808d\u6763\u5957\u7b2a\u7d6a>PNP\u7d05\u4ef8\u62e3\u808d");
        }
    }

    public static class Skill
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleNodes.ALLATORIxDEMO("}Gg@b\f2\u62ac\u80f3eJ\u0012.w\u628e\u80d1\u7b47\u7d36S\fU\u62ac\u80f3\u672c\u5929\u7b65\u7d14q.\u0002 \u0002.\f#\f\u5b76\u7ffe\u628e\u80d1");
        }

        public /* synthetic */ Skill() {
            Skill a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = SkillFactory.getSkill(Integer.parseInt(a3[1]));
            byte by = (byte)CommandProcessorUtil.getOptionalIntArg((String[])a3, 2, 1);
            byte by2 = (byte)CommandProcessorUtil.getOptionalIntArg((String[])a3, 3, 1);
            if (by > a3.getMaxLevel()) {
                by = a3.getMaxLevel();
            }
            a2.getPlayer().changeSkillLevel((ISkill)a3, (int)by, (int)by2);
            return true;
        }
    }

    public static class Reloadall
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + DumpItemsAdditions.ALLATORIxDEMO("t,J&G-G%Ji\u000bi\u91eb\u7f27\u514e\u4f73\u672b\u5621");
        }

        public /* synthetic */ Reloadall() {
            Reloadall a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = ChannelServer.getAllChannelInstances().iterator();
            while (object.hasNext()) {
                ((ChannelServer)a3.next()).reloadEvents();
                object = a3;
            }
            MapleShopFactory.getInstance().clear();
            PortalScriptManager.getInstance().clearScripts();
            MapleItemInformationProvider.getInstance().loadEtc(true);
            MapleItemInformationProvider.getInstance().loadItems(true);
            CashItemFactory.getInstance().initialize(true, true);
            MapleMonsterInformationProvider.getInstance().clearDrops();
            MapleGuild.loadAll();
            MapleFamily.loadAll();
            MapleLifeFactory.loadQuestCounts(true);
            MapleQuest.initQuests(true);
            MapleOxQuizFactory.getInstance();
            ReactorScriptManager.getInstance().clearDrops();
            SendPacketOpcode.reloadValues();
            RecvPacketOpcode.reloadValues();
            AttackFont.LoadAllFont();
            a2.getPlayer().dropMessage(6, MapleSidekick.ALLATORIxDEMO("\u5d82\u91ae\u7f1e\u5bef\u6260"));
            return true;
        }
    }

    public static class ReloadOX
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleOxQuizFactory.getInstance().reloadOX();
            a2.getPlayer().dropMessage(6, donate.ALLATORIxDEMO("\t+\u4ebd\u52aa\u5db4\u91be\u7f28\u5bff\u6256"));
            return true;
        }

        public /* synthetic */ ReloadOX() {
            ReloadOX a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"sPmZ`QnM!\u0018!\u91f8\u65b1\u8f3c\u5164zY\u9879\u76ef");
        }
    }

    public static class ReloadQuests
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleCarnivalChallenge.ALLATORIxDEMO("\u0003y\u001ds\u0010x\u0000i\u0014o\u0005oQ1Q\u91d1\u65c1\u8f15\u5114\u4ee7\u52a8");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleQuest.clearQuests();
            a2.getPlayer().dropMessage(6, MapleMessengerCharacter.ALLATORIxDEMO("\u4eff\u52d7\u5df6\u91c3\u7f6a\u5b82\u6214"));
            return true;
        }

        public /* synthetic */ ReloadQuests() {
            ReloadQuests a2;
        }
    }

    public static class ReloadEvent
    extends CommandExecute {
        public /* synthetic */ ReloadEvent() {
            ReloadEvent a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Iterator<ChannelServer> iterator;
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = a3[1];
            Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
            while (iterator2.hasNext()) {
                iterator.next().reloadEvent((String)a3);
                iterator2 = iterator;
            }
            a2.getPlayer().dropMessage(6, PlayerRandomStream.ALLATORIxDEMO("\u5220\u677f\u5dbd\u919e\u7f21\u5bdf\u625f"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleMessenger.ALLATORIxDEMO("J\u001et\u0014y\u001f]\r}\u0015l[C\u0015y\u0016}&8V8\u91b6\u65a8\u8f72\u517d\u637c\u5b82\u6d40\u52cd\u8108\u6734");
        }
    }

    public static class ReloadEvents
    extends CommandExecute {
        public /* synthetic */ ReloadEvents() {
            ReloadEvents a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = ChannelServer.getAllChannelInstances().iterator();
            while (object.hasNext()) {
                ((ChannelServer)a3.next()).reloadEvents();
                object = a3;
            }
            a2.getPlayer().dropMessage(6, MapleFoothold.ALLATORIxDEMO("\u5233\u677c\u5dae\u919d\u7f32\u5bdc\u624c"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + ConsoleCommandExecute.ALLATORIxDEMO("u(k\"f)b;b#s>'`'\u9180\u65b7\u8f44\u5162\u6d76\u52d2\u813e\u672b");
        }
    }

    public static class loadevents
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MonsterDropEntry.ALLATORIxDEMO("EZ[PV[RIRQCL\u0017\u0012\u0017\u91f2\u6587\u8f36\u5152\u6d04\u52e2\u814c\u671b");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Iterator<ChannelServer> iterator;
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = a3[1];
            Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
            while (iterator2.hasNext()) {
                iterator.next().updateEvents((String)a3);
                iterator2 = iterator;
            }
            return true;
        }

        public /* synthetic */ loadevents() {
            loadevents a2;
        }
    }

    public static class ReloadFishing
    extends CommandExecute {
        public /* synthetic */ ReloadFishing() {
            ReloadFishing a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleImp.ALLATORIxDEMO("M5S?^4y9L8V>Xp\u0012p\u91f2\u65e0\u8f36\u5135\u91dc\u9b0a\u7371\u52a5");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            FishingRewardFactory.getInstance().reloadItems();
            a2.getPlayer().dropMessage(6, SkillEntry.ALLATORIxDEMO("\u91f6\u9b6b\u5de7\u91fc\u7f7b\u5bbd\u6205"));
            return true;
        }
    }

    public static class ReloadNpcNames
    extends CommandExecute {
        public /* synthetic */ ReloadNpcNames() {
            ReloadNpcNames a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleLifeFactory.ReloadNpcNames();
            a2.getPlayer().dropMessage(6, DumpMobName.ALLATORIxDEMO("\u91d8\u65e0\u8f1c\u5135[\u0000V\u545d\u7a24"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + DumpMobName.ALLATORIxDEMO("\u0002p<z1q\u001ee3[1x5fp8p\u91d8\u65e0\u8f1c\u5135[\u0000V\u545d\u7a24");
        }
    }

    public static class ReloadSE
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MobNameData.ALLATORIxDEMO("|WB]OV}w\u000e\u001f\u000e\u91ff\u659e\u8f3b\u514b\u724b\u6ba4\u88ef\u50b7\u0012\u0005\u0012\u7247\u54f3");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            SpecialEquipFactory.getInstance().loadSpecialEquip();
            SpecialItemFactory.getInstance().loadSpecialItem();
            a2.getPlayer().dropMessage(6, MapleSquad.ALLATORIxDEMO("\u5dfe\u91d8\u7f62\u5b99\u621c"));
            return true;
        }

        public /* synthetic */ ReloadSE() {
            ReloadSE a2;
        }
    }

    public static class ReloadAuction
    extends CommandExecute {
        public /* synthetic */ ReloadAuction() {
            ReloadAuction a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            AuctionItemFactory.getInstance().reload();
            a2.getPlayer().dropMessage(6, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u5dec\u91ea\u7f70\u5bab\u620e"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MaplePlayerShopItem.ALLATORIxDEMO("%S\u001bY\u0016R6C\u0014B\u001eY\u0019\u0016Z\u0016\u91ba\u6586\u8f7e\u5153\u7a81\u6a2f\u62ba\u8cd5");
        }
    }

    public static class ReloadCS
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + CashShopConvert.ALLATORIxDEMO("7\b)\u0002$\t\u0006>e@e\u91a0\u65f5\u8f64\u5120\u8c91\u722c\u552b\u578b");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            CashItemFactory.getInstance().clearItems();
            a2.getPlayer().dropMessage(6, PetHandler.ALLATORIxDEMO("\u8cfd\u7207\u5547\u57a0\u5df3\u91a3\u7f6f\u5be2\u6211"));
            return true;
        }

        public /* synthetic */ ReloadCS() {
            ReloadCS a2;
        }
    }

    public static class ReloadShops
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + BBSHandler.ALLATORIxDEMO("QFOLBGPKLSP\u0003\u000e\u0003\u91ee\u6593\u8f2a\u5146\u5565\u5eb4");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleShopFactory.getInstance().clear();
            a2.getPlayer().dropMessage(6, MobNameData.ALLATORIxDEMO("`bm\u5574\u57e0\u5dc0\u91e3\u7f5c\u5ba2\u6222"));
            return true;
        }

        public /* synthetic */ ReloadShops() {
            ReloadShops a2;
        }
    }

    public static class ReloadPortals
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            PortalScriptManager.getInstance().clearScripts();
            a2.getPlayer().dropMessage(6, PartyHandler.ALLATORIxDEMO("\u50d0\u9059\u8110\u6774\u5d91\u9195\u7f0d\u5bd4\u6273"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + SpecialItemData.ALLATORIxDEMO("AM_GRLCGA\\RD@\b\u001e\b\u91fe\u6598\u8f3a\u514d\u9001\u514d\u9eed");
        }

        public /* synthetic */ ReloadPortals() {
            ReloadPortals a2;
        }
    }

    public static class ReloadDrops
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleMonsterInformationProvider.getInstance().clearDrops();
            ReactorScriptManager.getInstance().clearDrops();
            a2.getPlayer().dropMessage(6, BankSystem.ALLATORIxDEMO("\u63fe\u844e\u768f\u95af\u9024\u5104\u5d85\u91be\u7f19\u5bff\u6267"));
            return true;
        }

        public /* synthetic */ ReloadDrops() {
            ReloadDrops a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleDiseaseValueHolder.ALLATORIxDEMO("Q\u0012O\u0018B\u0013G\u0005L\u0007PW\u000eW\u91ee\u65c7\u8f2a\u5112\u63aa\u5b81");
        }
    }

    public static class ReloadAllOps
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            PlayerInteraction.reloadValues();
            CashShopType.reloadValues();
            BuyCashShopType.reloadValues();
            SpecialEffect.reloadValues();
            SendPacketOpcode.reloadValues();
            RecvPacketOpcode.reloadValues();
            MapleBuffStat.reloadValues();
            a2.getPlayer().dropMessage(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5c18\u5364\u5deb\u91ac\u65a9\u8f68\u517c\u5bed\u6209"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + ArrayMap.ALLATORIxDEMO("\u0004\n:\u00007\u000b\u0017\u0003: &\u001cvBv\u91a2\u65e6\u8f66\u5133\u5107\u90be &,9\u000b3");
        }

        public /* synthetic */ ReloadAllOps() {
            ReloadAllOps a2;
        }
    }

    public static class ReloadOps
    extends CommandExecute {
        public /* synthetic */ ReloadOps() {
            ReloadOps a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            SendPacketOpcode.reloadValues();
            RecvPacketOpcode.reloadValues();
            a2.getPlayer().dropMessage(6, SkilledCommand.ALLATORIxDEMO("\u6776\u52f2\u7a94\u532e\u9856\u5dd9\u91b6\u7f45\u5bf7\u623b"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + BuddyListHandler.ALLATORIxDEMO("\u0005_\u001bU\u0016^\u0018J\u0004\u001aZ\u001a\u91ba\u658a\u8f7e\u515f8J4U\u0013_");
        }
    }

    public static class Kill
    extends CommandExecute {
        public /* synthetic */ Kill() {
            Kill a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleCarnivalChallenge.ALLATORIxDEMO("w\u0018p\u001d<M\u73b5\u5bc7\u5411\u7a40\"Q1Q\u6ba6\u63f8\u73b5\u5bc7");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            MapleCharacter mapleCharacter = a2.getPlayer();
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter2 = null;
            int n3 = n2 = 1;
            while (n3 < a3.length) {
                String string = a3[n2];
                int n4 = World.Find.findChannel(string);
                int n5 = World.Find.findWorld(string);
                if (n4 == -10) {
                    a2.getPlayer().dropMessage(6, "\u73a9\u5bb6[" + string + "]\u5728\u8cfc\u7269\u5546\u57ce");
                    break;
                }
                if (n4 <= 0) {
                    a2.getPlayer().dropMessage(6, "\u73a9\u5bb6[" + string + "]\u4e0d\u5728\u7dda\u4e0a");
                    break;
                }
                mapleCharacter2 = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterByName(string);
                if (mapleCharacter2 != null) {
                    if (mapleCharacter.allowedToTarget(mapleCharacter2)) {
                        mapleCharacter2.getStat().setHp(0);
                        mapleCharacter2.getStat().setMp(0);
                        MapleCharacter mapleCharacter3 = mapleCharacter2;
                        mapleCharacter3.updateSingleStat(MapleStat.HP, 0);
                        mapleCharacter3.updateSingleStat(MapleStat.MP, 0);
                    }
                } else {
                    a2.getPlayer().dropMessage(6, "\u73a9\u5bb6 " + string + " \u672a\u4e0a\u7dda.");
                }
                n3 = ++n2;
            }
            return true;
        }
    }

    public static class Song
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.musicChange(a3[1]));
            return true;
        }

        public /* synthetic */ Song() {
            Song a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleCoolDownValueHolder.ALLATORIxDEMO("P4M<\u0003v\u0003\u64f6\u651d\u97a8\u6a21");
        }
    }

    public static class Clock
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleTrait.ALLATORIxDEMO("15=:9yn-;47gr\u661b\u944a");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getClock(CommandProcessorUtil.getOptionalIntArg(a3, 1, 60)));
            return true;
        }

        public /* synthetic */ Clock() {
            Clock a2;
        }
    }

    public static class copyInv
    extends CommandExecute {
        public /* synthetic */ copyInv() {
            copyInv a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            Object a322;
            int n2;
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n3 = 1;
            if (((String[])a322).length < 2) {
                return false;
            }
            Object object = a322[1];
            int n4 = World.Find.findChannel((String)object);
            int n5 = World.Find.findWorld((String)object);
            if (n4 <= 0) {
                a2.getPlayer().dropMessage(6, MerchItemPackage.ALLATORIxDEMO("\u7385\u5b82\u5fe9\u983c\u4e26\u7dee"));
                return false;
            }
            MapleCharacter mapleCharacter2 = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterByName((String)object);
            if (mapleCharacter2 == null) {
                mapleCharacter.dropMessage(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u6259\u4e13\u5217\u8a6c\u738e\u5ba8"));
                return true;
            }
            try {
                n2 = n3 = Integer.parseInt(a322[2]);
            }
            catch (Exception a322) {
                n2 = n3;
            }
            if (n2 == 0) {
                a322 = mapleCharacter2.getInventory(MapleInventoryType.EQUIPPED).list().iterator();
                Object object2 = a322;
                while (object2.hasNext()) {
                    object = (IItem)a322.next();
                    IItem iItem = object.copy();
                    object2 = a322;
                    mapleCharacter.getInventory(MapleInventoryType.EQUIP).addItem(mapleCharacter, iItem);
                }
                mapleCharacter.fakeRelog();
            } else {
                Object object3;
                switch (n3) {
                    case 1: {
                        while (false) {
                        }
                        a322 = MapleInventoryType.EQUIP;
                        object3 = a322;
                        break;
                    }
                    case 2: {
                        a322 = MapleInventoryType.USE;
                        object3 = a322;
                        break;
                    }
                    case 3: {
                        a322 = MapleInventoryType.ETC;
                        object3 = a322;
                        break;
                    }
                    case 4: {
                        a322 = MapleInventoryType.SETUP;
                        object3 = a322;
                        break;
                    }
                    case 5: {
                        a322 = MapleInventoryType.CASH;
                        object3 = a322;
                        break;
                    }
                    default: {
                        a322 = null;
                        object3 = a322;
                    }
                }
                if (object3 == null) {
                    a2.getPlayer().dropMessage(MerchItemPackage.ALLATORIxDEMO("\u7650\u752b\u9303\u8a90"));
                    return true;
                }
                object = new int[97];
                int n6 = n4 = 1;
                while (n6 < 97) {
                    if (mapleCharacter2.getInventory((MapleInventoryType)((Object)a322)).getItem((short)n4) != null) {
                        int n7 = n4;
                        object[n7] = n7;
                    }
                    n6 = ++n4;
                }
                int n8 = n4 = 0;
                while (n8 < ((Object)object).length) {
                    if (object[n4] != false) {
                        IItem iItem = mapleCharacter2.getInventory((MapleInventoryType)((Object)a322)).getItem((short)object[n4]).copy();
                        iItem.setEquipOnlyId(-1L);
                        mapleCharacter.getInventory((MapleInventoryType)((Object)a322)).addItem(mapleCharacter, iItem);
                        a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, iItem)));
                    }
                    n8 = ++n4;
                }
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"DqWgNpQ>\u738e\u5ba8\u542a\u7a2f\u0007\u88c3\u50be\u6b1a\u4f6a6\u0017>\u001a>\u88fa\u5087\u4e0a>\u0016#\u88fa\u5087\u6b23>\u0015#\u6daf\u8009\u6b23>\u0014#\u5151\u4ec8\u6b23>\u0013#\u88fa\u98e0\u6b23>\u0012#\u9ef9\u6566\u6b237\u000f\u980e\u8a0a\u88c3\u50be\u6b1a\u000e>\n>\u8920\u88e3\u738e\u5ba8\u9074\u5169");
        }
    }

    public static class copyAll
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleCoreAura.ALLATORIxDEMO("o\u001f|\tm\u001c`P\u73a5\u5bc6\u5401\u7a41,],\u8977\u88f1\u73d9\u5bba");
        }

        public /* synthetic */ copyAll() {
            copyAll a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a2.getPlayer();
            if (((Object)a3).length < 2) {
                return false;
            }
            Object object2 = a3[1];
            int n2 = World.Find.findChannel((String)object2);
            int s2 = World.Find.findWorld((String)object2);
            if (n2 <= 0) {
                a2.getPlayer().dropMessage(6, MapleCoreAura.ALLATORIxDEMO("\u73d9\u5bba\u5fb5\u9804\u4e7a\u7dd6"));
                return true;
            }
            a3 = ChannelServer.getInstance(s2, n2).getPlayerStorage().getCharacterByName((String)object2);
            if (a3 == null) {
                ((MapleCharacter)object).dropMessage(Event_PyramidSubway.ALLATORIxDEMO("\u6224\u4e29\u526a\u8a56\u73f3\u5b92"));
                return true;
            }
            MapleClient mapleClient = a2;
            object = mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIPPED);
            object2 = mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIP);
            LinkedList<Short> linkedList = new LinkedList<Short>();
            Object object3 = object = ((MapleInventory)object).list().iterator();
            while (object3.hasNext()) {
                IItem iItem = (IItem)object.next();
                object3 = object;
                linkedList.add(iItem.getPosition());
            }
            Object object4 = object = linkedList.iterator();
            while (object4.hasNext()) {
                short string = (Short)object.next();
                object4 = object;
                MapleInventoryManipulator.unequip(a2, string, ((MapleInventory)object2).getNextFreeSlot(), true);
            }
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().clearSkills();
            mapleClient2.getPlayer().setStr(((MapleCharacter)a3).getStr());
            mapleClient2.getPlayer().setDex(((MapleCharacter)a3).getDex());
            mapleClient2.getPlayer().setInt(((MapleCharacter)a3).getInt());
            mapleClient2.getPlayer().setLuk(((MapleCharacter)a3).getLuk());
            mapleClient2.getPlayer().setMeso(((MapleCharacter)a3).getMeso());
            mapleClient2.getPlayer().setLevel(((MapleCharacter)a3).getLevel());
            mapleClient2.getPlayer().changeJob(((MapleCharacter)a3).getJob());
            mapleClient2.getPlayer().setHp(((MapleCharacter)a3).getHp());
            mapleClient2.getPlayer().setMp(((MapleCharacter)a3).getMp());
            mapleClient2.getPlayer().setMaxHp(((MapleCharacter)a3).getMaxHp());
            mapleClient2.getPlayer().setMaxMp(((MapleCharacter)a3).getMaxMp());
            object = ((MapleCharacter)a3).getName();
            String string = (String)object + "x2";
            if (string.length() <= 12) {
                a2.getPlayer().setName(((MapleCharacter)a3).getName() + "x2");
            }
            MapleClient mapleClient3 = a2;
            mapleClient3.getPlayer().setRemainingAp(((MapleCharacter)a3).getRemainingAp());
            mapleClient3.getPlayer().setRemainingSp(((MapleCharacter)a3).getRemainingSp());
            mapleClient3.getPlayer().addSameSkill((MapleCharacter)a3);
            mapleClient3.getPlayer().setFame(((MapleCharacter)a3).getFame());
            mapleClient3.getPlayer().setHair(((MapleCharacter)a3).getHair());
            mapleClient3.getPlayer().setFace(((MapleCharacter)a3).getFace());
            mapleClient3.getPlayer().setSkinColor(((MapleCharacter)a3).getSkinColor() == 0 ? a2.getPlayer().getSkinColor() : ((MapleCharacter)a3).getSkinColor());
            Object object5 = a3;
            a2.getPlayer().setGender(((MapleCharacter)object5).getGender());
            Object object6 = a3 = ((MapleCharacter)object5).getInventory(MapleInventoryType.EQUIPPED).list().iterator();
            while (object6.hasNext()) {
                object = ((IItem)a3.next()).copy();
                object6 = a3;
                Object object7 = object;
                Object object8 = object;
                object8.setPosition(object8.getPosition());
                object7.setQuantity((short)1);
                object7.setEquipOnlyId(-1L);
                a2.getPlayer().forceReAddItem_NoUpdate((IItem)object, MapleInventoryType.EQUIPPED);
            }
            a2.getPlayer().fakeRelog();
            return true;
        }
    }

    public static class TempBan
    extends CommandExecute {
        public /* synthetic */ TempBan() {
            TempBan a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u5408\u592a\u8c37.ALLATORIxDEMO((String)"MkT~[oW.\u0005\u73a7\u5b8f\u5403\u7a080\u0019#\u0019\u66a5\u667b\u9398\u5ba3\u73a7\u5b8f");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            String string = a3[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0) {
                return false;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            int n4 = Integer.parseInt(a3[2]);
            n2 = Integer.parseInt(a3[3]);
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, n2);
            DateFormat dateFormat = DateFormat.getInstance();
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(6, ConsoleCommandObject.ALLATORIxDEMO("ah_qJ~[rg<\u6244\u4e11\u520a\u76f2\u6a23\u89ce\u8248"));
            } else {
                mapleCharacter.tempban("\u7531" + a2.getPlayer().getName() + "\u66ab\u6642\u9396\u5b9a\u4e86", calendar, n4, true);
                a2.getPlayer().dropMessage(6, "[tempban] " + a3[1] + " \u5df2\u6210\u529f\u88ab\u66ab\u6642\u9396\u5b9a\u81f3 " + dateFormat.format(calendar.getTime()));
            }
            return true;
        }
    }

    public static class UnbanIP
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MonsterPetSystem.ALLATORIxDEMO("&619=1#xo\u73f1\u5be5\u5455\u7a62fsus\u89bb\u93c5\u73f1\u5be5");
        }

        public /* synthetic */ UnbanIP() {
            UnbanIP a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            byte a32 = MapleClient.unbanIP(a32[1]);
            if (a32 == -2) {
                a2.getPlayer().dropMessage(6, FixDropNullItem.ALLATORIxDEMO("\u001dC(T'X/F\u001b\u0016\u0015g\n\u0016\u9369\u8a92h"));
            } else if (a32 == -1) {
                a2.getPlayer().dropMessage(6, MonsterPetSystem.ALLATORIxDEMO("\u0003&619=1#\u0005s\u898a\u8221\u4e55\u5b0b\u5770}"));
            } else if (a32 == 0) {
                a2.getPlayer().dropMessage(6, FixDropNullItem.ALLATORIxDEMO("m3X$W(_6kfx)\u0016\u000fffY4\u0016\u000bW%\u00161_2^fB.W2\u0016%^'D'U2S4\u0016#N/E2Eg"));
            } else if (a32 == 1) {
                a2.getPlayer().dropMessage(6, MonsterPetSystem.ALLATORIxDEMO("\u0003&619=1#\u0005s\u0011\u0003\u624e\u001e90\u5daa\u89b0\u93ce\u5125\u4e75\u4e53\u5053}"));
            } else if (a32 == 2) {
                a2.getPlayer().dropMessage(6, FixDropNullItem.ALLATORIxDEMO("\u001dC(T'X/F\u001b\u0016\u000ff\u4ea3\u53fc\u000bW%\u5dc4\u6256\u52a9\u89a5\u93a0h"));
            }
            return true;
        }
    }

    public static class ShutdownTime
    extends CommandExecute {
        private /* synthetic */ int d;
        private static /* synthetic */ ScheduledFuture<?> a;
        private static /* synthetic */ Thread ALLATORIxDEMO;

        public static /* synthetic */ {
            a = null;
            ALLATORIxDEMO = null;
        }

        @Override
        public /* synthetic */ boolean execute(final MapleClient a2, String[] a3) {
            ShutdownTime a4;
            if (a3.length < 2) {
                return false;
            }
            a4.d = Integer.parseInt(a3[1]);
            a2.getPlayer().dropMessage(6, "\u4f3a\u670d\u5668\u5c07\u5728 " + a4.d + "\u5206\u9418\u5f8c\u95dc\u9589\uff0c\u8acb\u505a\u597d\u5b89\u5168\u63aa\u65bd\u5f8c\u4e26\u4e14\u76e1\u5feb\u767b\u51fa.");
            GameSetConstants.ADMIN_ONLY = true;
            a2.getPlayer().dropMessage(6, MapOwner.ALLATORIxDEMO("\u5dcc\u7ddb\u95b5\u5517\u7b9f\u744e\u54df\u6a69\u5f31\u304a"));
            if (!(a != null || ALLATORIxDEMO != null && ALLATORIxDEMO.isAlive())) {
                ALLATORIxDEMO = new Thread(ShutdownServer.getInstance());
                a = Timer.EventTimer.getInstance().register(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        1 a22;
                        if (a22.a4.d > 0 && a22.a4.d <= 11 && !World.isShutDown) {
                            World.isShutDown = true;
                            if (a22.a2 != null && a22.a2.getPlayer() != null) {
                                a22.a2.getPlayer().dropMessage(6, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u5da3\u7da7\u9601\u5202\u73f8\u5b82\u73f8\u5b82\u6211\u673d\u881d\u52e1\u3053"));
                            }
                        }
                        if (a22.a4.d == 0) {
                            ShutdownServer.getInstance().run();
                            ALLATORIxDEMO.start();
                            a.cancel(false);
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(SkillType.ALLATORIxDEMO("\u007f\u6960\u4e6f\u8c04\u5148\u5479y\u0013\u4f1e\u673e\u564c\u5c34\u570c\u0013"));
                        stringBuilder.append(a22.a4.d);
                        stringBuilder.append(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0014\u5257\u942c\u5fdd\u95e8\u95d8\uff38\u8a9a\u506e\u592c\u5bbd\u5139\u639e\u65ec\u5fb8\u4e77\u4e20\u76b0\u5fdf\u762a\u51ce\u3053"));
                        StringBuilder stringBuilder2 = stringBuilder;
                        World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(stringBuilder2.toString()));
                        World.Broadcast.broadcastMessage(MaplePacketCreator.serverMessage(stringBuilder2.toString()));
                        Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
                        Iterator<ChannelServer> iterator2 = iterator;
                        while (iterator2.hasNext()) {
                            iterator.next().setServerMessage("\u4f3a\u670d\u5668\u5c07\u65bc " + a22.a4.d + " \u5206\u9418\u5f8c\u95dc\u6a5f");
                            iterator2 = iterator;
                        }
                        System.out.println("\u4f3a\u670d\u5668\u5c07\u65bc " + a22.a4.d + " \u5206\u9418\u5f8c\u95dc\u6a5f");
                        a22.a4.d--;
                    }
                    {
                        1 a3;
                    }
                }, 60000L);
            } else {
                a2.getPlayer().dropMessage(6, new StringBuilder().insert(0, PetCommand.ALLATORIxDEMO("\u4f0f\u6712\u565d\u95c3\u95bc\u665d\u95a6\u4ff1\u650c\u70a5\u0015")).append(a4.d).append(MapOwner.ALLATORIxDEMO("\u5238\u9450\u5fb2\uff44\u8af5\u7a45\u7b77\u4f72\u6733\u5620\u95e2\u95c1")).toString());
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + PetCommand.ALLATORIxDEMO("l]jA{Zh[k\\rP?\t\u5219\u942d\u6567\u000b?\u0018?\u95e9\u9596\u4f0f\u6712\u565d");
        }

        public /* synthetic */ ShutdownTime() {
            ShutdownTime a2;
            a2.d = 0;
        }
    }

    public static class Shutdown
    extends CommandExecute {
        private static /* synthetic */ Thread ALLATORIxDEMO;

        public /* synthetic */ Shutdown() {
            Shutdown a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + getHtml.ALLATORIxDEMO("\u0018b\u001e~\u000fe\u001cdK'K\u95d6\u95e2\u4f30\u6766\u5662");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().dropMessage(6, getHtml.ALLATORIxDEMO("\u95d6\u95e2\u4f30\u6766\u5662\u4e46$E$"));
            if (ALLATORIxDEMO == null || !ALLATORIxDEMO.isAlive()) {
                ALLATORIxDEMO = new Thread(ShutdownServer.getInstance());
                ALLATORIxDEMO.start();
            } else {
                a2.getPlayer().dropMessage(6, MerchItemPackage.ALLATORIxDEMO("\u5dde\u571c\u57db\u8878\u4e01\u001a\u0002\u001a"));
            }
            return true;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = null;
        }
    }

    public static class Say
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleLieDetector.ALLATORIxDEMO("L\\F\u001d\u8a35\u6052\u001f\u0010\u001f\u4f07\u6732\u5655\u5153\u5477");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length <= 1) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(MapleLieDetector.ALLATORIxDEMO("f"));
            stringBuilder.append(a2.getPlayer().getName());
            stringBuilder.append(SpecialSkillConstants.ALLATORIxDEMO("/\u0017"));
            stringBuilder.append(StringUtil.joinStringFrom(a3, 1));
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(stringBuilder.toString()));
            return true;
        }

        public /* synthetic */ Say() {
            Say a2;
        }
    }

    public static class SpeakMega
    extends CommandExecute {
        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleCharacter mapleCharacter = null;
            if (a32.length >= 2) {
                mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a32[1]);
            }
            try {
                World.Broadcast.broadcastSmega(a2.getWorld(), MaplePacketCreator.getSuperMegaphone((String)(mapleCharacter == null ? a32[1] : mapleCharacter.getName() + " : " + StringUtil.joinStringFrom(a32, 2)), true, mapleCharacter == null ? a2.getChannel() : mapleCharacter.getClient().getChannel()));
                return true;
            }
            catch (Exception a32) {
                return false;
            }
        }

        public /* synthetic */ SpeakMega() {
            SpeakMega a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MaplePlayerShopItem.ALLATORIxDEMO("\u0004F\u0012W\u001c[\u0012Q\u0016\u0016,\u739f\u5bc1\u543b\u7a46kW\n\u8a7d\u6059I\u0016Z\u0016\u5c7a\u67e6\u507c\u739f\u5bc1\u76b2\u984c\u9065\u9045\u887a\u5e94\u649b");
        }
    }

    public static class SpeakWorld
    extends CommandExecute {
        public /* synthetic */ SpeakWorld() {
            SpeakWorld a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapConstants.ALLATORIxDEMO("\bh\u001ey\u0010{\u0013y\u0015v\u001et[$\u8a71\u6077E8V8\u5c76\u76f6\u5236\u4f22\u6776\u5670\u9049\u8854\u50c8\u9019\u8a71\u6077");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Iterator<ChannelServer> iterator = LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels().iterator();
            while (iterator.hasNext()) {
                for (MapleCharacter mapleCharacter : iterator.next().getPlayerStorage().getAllCharactersThreadSafe()) {
                    if (mapleCharacter.getId() == a2.getPlayer().getId()) continue;
                    mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.getChatText(mapleCharacter.getId(), StringUtil.joinStringFrom(a3, 1), mapleCharacter.isGM(), 0));
                }
            }
            return true;
        }
    }

    public static class SpeakChannel
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + AutoPickupSystem.ALLATORIxDEMO("4x\"i,k/i)f\"dg4\u8a4d\u6067y(j(\u5c4a\u76e6\u520a\u9833\u9014\u903a\u880b\u50bb\u9046\u8a02\u6028");
        }

        public /* synthetic */ SpeakChannel() {
            SpeakChannel a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            for (MapleCharacter mapleCharacter : a2.getChannelServer().getPlayerStorage().getAllCharactersThreadSafe()) {
                if (mapleCharacter.getId() == a2.getPlayer().getId()) continue;
                mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.getChatText(mapleCharacter.getId(), StringUtil.joinStringFrom(a3, 1), mapleCharacter.isGM(), 0));
            }
            return true;
        }
    }

    public static class SpeakMap
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            for (MapleCharacter mapleCharacter : a2.getPlayer().getMap().getCharactersThreadsafe()) {
                if (mapleCharacter.getId() == a2.getPlayer().getId()) continue;
                mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.getChatText(mapleCharacter.getId(), StringUtil.joinStringFrom(a3, 1), mapleCharacter.isGM(), 0));
            }
            return true;
        }

        public /* synthetic */ SpeakMap() {
            SpeakMap a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + PlayersHandler.ALLATORIxDEMO("uZcKmGgZ&\u0016\u8a0c\u60458\n+\n\u5c0b\u76c4\u524b\u571a\u5710\u9018\u884a\u5099\u9007\u8a20\u6069");
        }
    }

    public static class Speak
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            String string = a3[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0) {
                a2.getPlayer().dropMessage(6, FixDropNullItem.ALLATORIxDEMO("\u739f\u5bf0\u5ff3\u984e\u4e3c\u7d9c"));
                return true;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + a3[1]);
                return false;
            }
            mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.getChatText(mapleCharacter.getId(), StringUtil.joinStringFrom(a3, 2), mapleCharacter.isGM(), 0));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"G!Q0_q\b\u73f8\u5b82\u545c\u7a05o\u0014m\u8a3e\u603e\nq\u0019q\u5c39\u6781\u503f\u73f8\u5b82\u50e2\u8a3e\u603e");
        }

        public /* synthetic */ Speak() {
            Speak a2;
        }
    }

    public static class SpawnDebug
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().dropMessage(6, a2.getPlayer().getMap().spawnDebug());
            return true;
        }

        public /* synthetic */ SpawnDebug() {
            SpawnDebug a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleDiseaseValueHolder.ALLATORIxDEMO("P\u0007B\u0000M\u0013F\u0015V\u0010\u0003Z\u0003\u0013F\u0015V\u0010\u6009\u721e\u51d9\u7568");
        }
    }

    public static class NearestPortal
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + SpecialEquipData.ALLATORIxDEMO("WIX^\\_M\\V^MMU\f\u0014\f\u4e34\u77c9\u906a\u5549");
        }

        public /* synthetic */ NearestPortal() {
            NearestPortal a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            a3 = a2.getPlayer().getMap().findClosestSpawnpoint(mapleClient.getPlayer().getPosition());
            mapleClient.getPlayer().dropMessage(6, a3.getName() + " id: " + a3.getId() + " script: " + a3.getScriptName());
            return true;
        }
    }

    public static class RemoveDrops
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().dropMessage(5, "\u6e05\u9664\u4e86 " + a2.getPlayer().getMap().getNumItems() + " \u500b\u6389\u843d\u7269");
            a2.getPlayer().getMap().removeDrops();
            return true;
        }

        public /* synthetic */ RemoveDrops() {
            RemoveDrops a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + DatabaseException.ALLATORIxDEMO("X9G3\\9N.E,Y|\u0007|\u79d1\u9638\u571a\u4e56\u76ae\u7235\u54eb");
        }
    }

    public static class cleardrops
    extends RemoveDrops {
        public /* synthetic */ cleardrops() {
            cleardrops a2;
        }
    }

    public static class GoTo
    extends CommandExecute {
        public /* synthetic */ List<String> ALLATORIxDEMO;
        private static final /* synthetic */ HashMap<String, Integer> d;

        public /* synthetic */ GoTo() {
            GoTo a2;
            GoTo goTo = a2;
            goTo.ALLATORIxDEMO = new LinkedList<String>();
        }

        public static /* synthetic */ {
            d = new HashMap();
            d.put(SpecialEquipData.ALLATORIxDEMO("\u54ba\u5558\u5b9a"), 262030300);
            d.put(BuddyListHandler.ALLATORIxDEMO("]\u001aW\u0016J"), 180000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u697f\u4e72\u6e03"), 2000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u51e5\u9690\u8072\u4fd4\u7d83\u580e\u5112\u53d9"), 1010000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u5f2a\u7b81\u6272\u677d"), 100000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u9b23\u6cef\u6899\u67ad"), 101000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u52fe\u58c7\u4e72\u677d"), 102000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u58d9\u8407\u57b9\u5e38"), 103000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u7d81\u5923\u5205\u4ea7\u6e03"), 104000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u597d\u5e0c\u676b"), 105040300);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u9efa\u91fd\u6d4e\u7074"), 110000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u595e\u7a40\u4e3c\u57f4"), 200000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u5e54\u79b6\u677d"), 209000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u51c7\u53a5\u969d\u57e5"), 211000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u7385\u514e\u57e2"), 220000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u6c0e\u4e61\u7576"), 230000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u7972\u6711\u677d"), 240000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u6834\u828b\u4eae\u58b9"), 250000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u9771\u85c9\u5e42\u58af"), 251000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u5747\u7439\u9645\u8861\u675b\u90d2"), 221000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u7ac9\u8a48\u677d"), 222000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u658a\u843e\u57f4"), 600000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u5a2d\u5ef0\u76a8\u53dd\u580d"), 990000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u6d4d\u6065\u6595"), 230040420);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u95fe\u9efd\u9fb4\u73a7"), 240060200);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u6dcd\u6cfb\u95fd\u9ea6\u9fb7\u73fc\u76be\u6d69\u7aa5"), 240060201);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u83fe\u83eb\u73b2\u51d6\u6cab\u571c"), 100000005);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u684b\u7464\u82db\u5920"), 240020101);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u5658\u7052\u9fa1"), 240020401);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u70f9\u9b6e"), 280030000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u6dce\u6ca0\u70b7\u9b78"), 280030001);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u62f3\u5761\u6595"), 220080001);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u6601\u54b5\u677d"), 801000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u5393\u4ed9\u7929\u7904"), 800000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u7d34\u5e20\u6ca0\u6f0c"), 260000100);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u9bd2\u9b2d\u8665"), 120000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u659c\u5299\u574d"), 541000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u99db\u4fbc\u8908\u4ea4"), 550000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u8953\u95b9\u7516"), 740000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u6c87\u5731"), 500000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u801a\u96ce\u5f3b"), 130000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u8209\u9772\u6899\u67ad"), 300000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u9125\u6768\u9382"), 551000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u4e17\u5fb4\u557c\u52ae\u537a"), 540000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u7d69\u5a76\u5c36\u9382"), 680000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u6635\u95a9\u4e3c\u8dd5"), 270000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u7967\u6b93\u6dc8\u8679"), 270050100);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u7d3f\u9e69\u5b94"), 700000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u81d3\u751d\u5e3b\u5818"), 910000000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u0018B\u0006O\u001e@"), 109020001);
            d.put(SpecialEquipData.ALLATORIxDEMO("CUM"), 109030101);
            d.put(BuddyListHandler.ALLATORIxDEMO("\\\u001eN\u0019_\u0004I"), 109040000);
            d.put(SpecialEquipData.ALLATORIxDEMO("JBV[[MU@"), 109060000);
            d.put(BuddyListHandler.ALLATORIxDEMO("Y\u0016I\u001fW\u0016J"), 741010200);
            d.put(SpecialEquipData.ALLATORIxDEMO("^CUH\\B"), 950100000);
            d.put(BuddyListHandler.ALLATORIxDEMO("J\u001f[\u0019N\u0018W"), 610010000);
            d.put(SpecialEquipData.ALLATORIxDEMO("ONG"), 610030000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u7464\u601e\u676b"), 140000000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u5c23\u92c5\u73cc"), 809030000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u6b11\u5652\u507e\u5e91"), 800040208);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u5910\u5ba4\u959a\u5b88"), 800040410);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u5955\u5e41\u4e4c\u9876\u511b\u5728"), 551030200);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u95fe\u9efd\u9fb4\u73a7\u6d27\u7a58\u515c\u53cf"), 0xE4EE0E0);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u8a5c\u713e\u4e71\u7a03\u215a"), 240060000);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u8a4a\u7170\u4e67\u7a4d\u214d"), 240060100);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u95b0\u9eeb\u9ffa\u73b1\u6d69\u7a4e"), 240060200);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u9fb4\u001d"), 240060000);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u9ffa\b"), 240060100);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u9fb4\u001f"), 240060200);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u71b0"), 551030200);
            d.put(SpecialEquipData.ALLATORIxDEMO("\u9b78\u73b2\u5dd8\u6d22\u53c8"), 105100300);
            d.put(BuddyListHandler.ALLATORIxDEMO("\u8f73\u86bc\u5c71"), 749050400);
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + BuddyListHandler.ALLATORIxDEMO("]\u0018N\u0018\u001aK\u5437\u7a46\u0004W\u0017W\u520a\u67a7\u5031\u5747\u572c");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object2;
            GoTo a4;
            LinkedList<String> linkedList = new LinkedList<String>();
            linkedList.clear();
            a4.ALLATORIxDEMO.clear();
            Object object = object2 = d.keySet().iterator();
            while (object.hasNext()) {
                String object4 = object2.next();
                object = object2;
                a4.ALLATORIxDEMO.add(object4);
            }
            for (String string : a4.ALLATORIxDEMO) {
                if (!string.contains((CharSequence)a3[1])) continue;
                linkedList.add(string);
            }
            if (linkedList.size() == 1) {
                a3[1] = (String)linkedList.get(0);
            }
            if (((Object)a3).length < 2) {
                a2.getPlayer().dropMessage(6, SpecialEquipData.ALLATORIxDEMO("\u4f46\u7504\u6580\u6cf9\u0003\f\u0018KVXV\f\u0005\u571c\u572f\u5421\u7a08\u0012"));
            } else if (d.containsKey(a3[1])) {
                object2 = a2.getChannelServer().getMapFactory().getMap(d.get(a3[1]));
                MaplePortal maplePortal = ((MapleMap)object2).getPortal(0);
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().changeMap((MapleMap)object2, maplePortal);
                mapleClient.getPlayer().dropMessage(6, "\u81ea\u52d5\u8b58\u5225\u95dc\u806f\u5730\u5716:" + (String)linkedList.get(0));
            } else if (((String)a3[1]).equals(BuddyListHandler.ALLATORIxDEMO("\u76d4\u76f3\u570a"))) {
                Iterator<String> iterator;
                a2.getPlayer().dropMessage(6, SpecialEquipData.ALLATORIxDEMO("\u4f46\u7504\u0019\r^CMC\u0019\u0010\u76d7\u76a8\u5709\u0012\u0017\f\u76d7\u76a8\u5709\u571c\u572f\u59ae\u4e32\u0016"));
                object2 = new StringBuilder();
                Iterator<String> iterator2 = iterator = d.keySet().iterator();
                while (iterator2.hasNext()) {
                    a3 = iterator.next();
                    iterator2 = iterator;
                    ((StringBuilder)object2).append((String)a3).append(BuddyListHandler.ALLATORIxDEMO("[\u001a"));
                }
                Object object3 = object2;
                a2.getPlayer().dropMessage(6, ((StringBuilder)object3).substring(0, ((StringBuilder)object3).length() - 2));
            } else {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(6, SpecialEquipData.ALLATORIxDEMO("\u9316\u8a88\u76bd\u632b\u4edd\u89a3\u527e\f\u0014\f\u4f46\u7504\u0019\r^CMC\u0019\u0010\u76d7\u76a8\u5709\u0012\u0017\f\u4fbf\u7727\u76d7\u76a8\u5709\u571c\u572f\u6e29\u5597\u0000\u0019\u6389\u846e\u4f53\u7511\f\u0018KVXV\f\u76d7\u76a8\u5709\u571c\u572f\u5421\u7a08\u0002"));
                mapleClient.getPlayer().dropMessage(6, "\u76f8\u95dc\u5730\u5716:" + ((Object)linkedList).toString());
            }
            return true;
        }
    }

    public static class LookPortals
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer().getMap().getPortals().iterator();
            while (object.hasNext()) {
                MaplePortal maplePortal = (MaplePortal)a3.next();
                a2.getPlayer().dropMessage(5, "Portal: ID: " + maplePortal.getId() + " script: " + maplePortal.getScriptName() + " name: " + maplePortal.getName() + " pos: " + maplePortal.getPosition().x + "," + maplePortal.getPosition().y + " target: " + maplePortal.getTargetMapId() + " / " + maplePortal.getTarget());
                object = a3;
            }
            return true;
        }

        public /* synthetic */ LookPortals() {
            LookPortals a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\n\u001b\t\u001f\u0016\u001b\u0014\u0000\u0007\u0018\u0015TKT\u6783\u777f\u6226\u677d\u53ab\u61bd\u5860");
        }
    }

    public static class LookReactors
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer().getMap().getAllReactorsThreadsafe().iterator();
            while (object.hasNext()) {
                MapleReactor mapleReactor = (MapleReactor)((MapleMapObject)a3.next());
                a2.getPlayer().dropMessage(5, "Reactor: oID: " + mapleReactor.getObjectId() + " reactorID: " + mapleReactor.getReactorId() + " Position: " + mapleReactor.getPosition().toString() + " State: " + mapleReactor.getState() + " Name: " + mapleReactor.getName());
                object = a3;
            }
            return true;
        }

        public /* synthetic */ LookReactors() {
            LookReactors a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + GetSelfDocName.ALLATORIxDEMO("\bf\u000bb\u0016l\u0005j\u0010f\u0016zD$D\u67ec\u776f\u6249\u676d\u53c4\u61ad\u580f");
        }
    }

    public static class LookNPCs
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer().getMap().getAllNPCsThreadsafe().iterator();
            while (object.hasNext()) {
                MapleNPC mapleNPC = (MapleNPC)((MapleMapObject)a3.next());
                a2.getPlayer().dropMessage(5, "NPC: oID: " + mapleNPC.getObjectId() + " npcID: " + mapleNPC.getId() + " Position: " + mapleNPC.getPosition().toString() + " Name: " + mapleNPC.getName());
                object = a3;
            }
            return true;
        }

        public /* synthetic */ LookNPCs() {
            LookNPCs a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleImp.ALLATORIxDEMO("S?P;Q \\#\u001f}\u001f\u67b5\u7734\u6210\u6736\u001eo\u0013");
        }
    }

    public static class RemoveNPCs
    extends CommandExecute {
        public /* synthetic */ RemoveNPCs() {
            RemoveNPCs a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getMap().resetNPCs();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + getHtml.ALLATORIxDEMO("\u0019o\u0006e\u001do\u0005z\byK'K\u5220\u960f\u624a\u6762D;I");
        }
    }

    public static class CancelBuffs
    extends CommandExecute {
        public /* synthetic */ CancelBuffs() {
            CancelBuffs a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().cancelAllBuffs();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + MapleMapEffect.ALLATORIxDEMO("t/Y-R\"u;Q(Dn\u001an\u53e1\u6dc6\u6277\u6747u\u001bq\b");
        }
    }

    public static class opennpc
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int n2;
            if (((String[])a32).length < 2) {
                return false;
            }
            int n3 = 0;
            try {
                n2 = n3 = Integer.parseInt(a32[1]);
            }
            catch (NumberFormatException a32) {
                n2 = n3;
            }
            Object a32 = MapleLifeFactory.getNPC(n2);
            if (a32 != null && !((MapleNPC)a32).getName().equalsIgnoreCase("MISSINGNO")) {
                NPCScriptManager.getInstance().start(a2, n3);
            } else {
                a2.getPlayer().dropMessage(6, MapleCharacterCards.ALLATORIxDEMO("\u6726\u77b1B\u0004O"));
            }
            return true;
        }

        public /* synthetic */ opennpc() {
            opennpc a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"n\rd\u0013O\rb]=3Q>\u4ee2\u78c1?],]\u958a\u5522O-B");
        }
    }

    public static class Y
    extends Yellow {
        public /* synthetic */ Y() {
            Y a2;
        }
    }

    public static class Yellow
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + ClientRedirector.ALLATORIxDEMO("L!Y(Z3\u0015xX8V8Bz\u0015xX!F7T#Pz\u0015i\u0015\u9e87\u8247\u5128\u547f");
        }

        public /* synthetic */ Yellow() {
            Yellow a2;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            String[] arrstring;
            Object object;
            int n2;
            int n3;
            Object object2;
            int n4;
            block18: {
                n4 = -1;
                object2 = a3[1];
                int n5 = -1;
                switch (((String)object2).hashCode()) {
                    case 109: {
                        if (!((String)object2).equals(ClientRedirector.ALLATORIxDEMO("X"))) break;
                        n3 = n5 = 0;
                        break block18;
                    }
                    case 99: {
                        if (!((String)object2).equals(StatsHandling.ALLATORIxDEMO("M"))) break;
                        n3 = n5 = 1;
                        break block18;
                    }
                    case 119: {
                        if (!((String)object2).equals(ClientRedirector.ALLATORIxDEMO("B"))) break;
                        n5 = 2;
                    }
                }
                n3 = n5;
            }
            switch (n3) {
                case 0: {
                    n2 = n4 = 0;
                    break;
                }
                case 1: {
                    n2 = n4 = 1;
                    break;
                }
                case 2: {
                    n4 = 2;
                }
                default: {
                    n2 = n4;
                }
            }
            if (n2 == -1) {
                n4 = 2;
            }
            if (a3[0].equals(StatsHandling.ALLATORIxDEMO("ZW"))) {
                object = "[" + a2.getPlayer().getName() + "] ";
                arrstring = a3;
            } else {
                object = "";
                arrstring = a3;
            }
            object2 = MaplePacketCreator.yellowChat((String)object + StringUtil.joinStringFrom(arrstring, 2));
            switch (n4) {
                case 0: {
                    a2.getPlayer().getMap().broadcastMessage((byte[])object2);
                    return true;
                }
                case 1: {
                    ChannelServer.getInstance(a2.getWorld(), a2.getChannel()).broadcastPacket((byte[])object2);
                    return true;
                }
                case 2: {
                    World.Broadcast.broadcastMessage((byte[])object2);
                    return true;
                }
            }
            return true;
        }
    }

    public static class Notice
    extends CommandExecute {
        public /* synthetic */ Notice() {
            Notice a2;
        }

        /*
         * Enabled aggressive block sorting
         */
        private static /* synthetic */ int ALLATORIxDEMO(String a2) {
            int n2;
            block16: {
                String string = a2;
                int n3 = -1;
                switch (string.hashCode()) {
                    case 110: {
                        if (!string.equals(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"$"))) break;
                        n2 = n3 = 0;
                        break block16;
                    }
                    case 112: {
                        if (!string.equals(LoadPacket.ALLATORIxDEMO("G"))) break;
                        n2 = n3 = 1;
                        break block16;
                    }
                    case 108: {
                        if (!string.equals(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"&"))) break;
                        n2 = n3 = 2;
                        break block16;
                    }
                    case 3528: {
                        if (!string.equals(LoadPacket.ALLATORIxDEMO("}A"))) break;
                        n2 = n3 = 3;
                        break block16;
                    }
                    case 118: {
                        if (!string.equals(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"<"))) break;
                        n2 = n3 = 4;
                        break block16;
                    }
                    case 98: {
                        if (!string.equals(LoadPacket.ALLATORIxDEMO("U"))) break;
                        n3 = 5;
                    }
                }
                n2 = n3;
            }
            switch (n2) {
                case 0: {
                    return 0;
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    return 2;
                }
                case 3: {
                    return 5;
                }
                case 4: {
                    return 5;
                }
                case 5: {
                    return 6;
                }
            }
            return -1;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + LoadPacket.ALLATORIxDEMO("}Xg^pR3\u000b}KcK\u007fK}AoAoU-\u0017/ZoTo@-\u0017/ZvD`VtR-\u0017>\u0017\u517f\u547d");
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            StringBuilder stringBuilder;
            int n3;
            int n4;
            int n5;
            int n6;
            block22: {
                n6 = 1;
                n5 = -1;
                if (a3.length < 2) {
                    return false;
                }
                String string = a3[1];
                n4 = -1;
                switch (string.hashCode()) {
                    case 109: {
                        if (!string.equals(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"'"))) break;
                        n3 = n4 = 0;
                        break block22;
                    }
                    case 99: {
                        if (!string.equals(LoadPacket.ALLATORIxDEMO("T"))) break;
                        n3 = n4 = 1;
                        break block22;
                    }
                    case 119: {
                        if (!string.equals(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"="))) break;
                        n4 = 2;
                    }
                }
                n3 = n4;
            }
            switch (n3) {
                case 0: {
                    n5 = 0;
                    break;
                }
                case 1: {
                    n5 = 1;
                    break;
                }
                case 2: {
                    n5 = 2;
                    break;
                }
            }
            int n7 = 2;
            if (n5 == -1) {
                n5 = 2;
                n7 = 1;
            }
            if (a3.length < n7 + 1) {
                return false;
            }
            n4 = Notice.ALLATORIxDEMO(a3[n7]);
            if (n4 == -1) {
                n4 = 0;
                n6 = 0;
            }
            StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
            if (a3[n7].equals(LoadPacket.ALLATORIxDEMO("}A"))) {
                stringBuilder2.append(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"&\u0004\u0012>\u0014)\u0018\u0017"));
                n2 = n6;
            } else {
                stringBuilder2.append("");
                n2 = n6;
            }
            n6 = n2 + n7;
            if (a3.length < n6 + 1) {
                return false;
            }
            stringBuilder.append(StringUtil.joinStringFrom(a3, n6));
            a3 = MaplePacketCreator.broadcastMessage(n4, stringBuilder.toString());
            switch (n5) {
                case 0: {
                    a2.getPlayer().getMap().broadcastMessage((byte[])a3);
                    return true;
                }
                case 1: {
                    ChannelServer.getInstance(a2.getWorld(), a2.getChannel()).broadcastPacket((byte[])a3);
                    return true;
                }
                case 2: {
                    World.Broadcast.broadcastMessage((byte[])a3);
                    return true;
                }
            }
            return true;
        }
    }

    public static class MyPos
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            a3 = mapleClient.getPlayer().getPosition();
            mapleClient.getPlayer().dropMessage(6, "X: " + a3.x + " | Y: " + a3.y + " | RX0: " + (a3.x + 50) + " | RX1: " + (a3.x - 50) + " | FH: " + a2.getPlayer().getFh() + "| CY:" + a3.y);
            return true;
        }

        public /* synthetic */ MyPos() {
            MyPos a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + EmojiFilter.ALLATORIxDEMO("n5s#pl.l\u6212\u76c8\u4f4e\u7f22");
        }
    }

    public static class LowHP
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + StructSetItem.ALLATORIxDEMO("\bI\u0013N\u0014\u0006I\u0006\u8824\u9b72\u6b1c\u3101");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getStat().setHp(1);
            a2.getPlayer().getStat().setMp(1);
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().updateSingleStat(MapleStat.HP, 1);
            mapleClient.getPlayer().updateSingleStat(MapleStat.MP, 1);
            return true;
        }

        public /* synthetic */ LowHP() {
            LowHP a2;
        }
    }

    public static class SaveAll
    extends CommandExecute {
        public /* synthetic */ SaveAll() {
            SaveAll a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int a32 = 0;
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                Iterator<ChannelServer> iterator2 = iterator.next().getChannels().iterator();
                while (iterator2.hasNext()) {
                    Iterator<MapleCharacter> iterator3 = iterator2.next().getPlayerStorage().getAllCharactersThreadSafe().iterator();
                    while (iterator3.hasNext()) {
                        Iterator<MapleCharacter> iterator4;
                        ++a32;
                        MapleCharacter mapleCharacter = iterator4.next();
                        iterator3 = iterator4;
                        mapleCharacter.saveToDB(false, true);
                    }
                }
            }
            if (a2 != null && a2.getPlayer() != null) {
                a2.getPlayer().dropMessage("[\u4fdd\u5b58] " + a32 + "\u500b\u73a9\u5bb6\u6578\u64da\u4fdd\u5b58\u5230\u6578\u64da\u4e2d.");
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u9818\u5c0e\u8005.getCommandPrefix() + DumpMapName.ALLATORIxDEMO("E2@6W?Zs\u001bs\u5104\u5b0b\u6276\u675a\u89e4\u8221\u8cf1\u65ca");
        }
    }
}

