/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.AdminCommand$\u4e8b\u524d\u734e\u52f5
 *  client.messages.commands.AdminCommand$\u9ad8\u7d1a\u6aa2\u7d22
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 *  client.messages.commands.player.\u5408\u592a\u8c37
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 *  client.messages.commands.player.\u592f\u592f\u8c37
 *  client.messages.commands.player.\u5976\u8336\u8c37
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.messages.commands;

import FuckingHackerToby.K;
import FuckingHackerToby.L;
import FuckingHackerToby.fc;
import FuckingHackerToby.ka;
import client.ClientRedirector;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleCoolDownValueHolder;
import client.MapleCoreAura;
import client.MapleDiseaseValueHolder;
import client.MapleJob;
import client.MapleLieDetector;
import client.MapleStat;
import client.MapleTrait;
import client.PlayerRandomStream;
import client.PlayerStats;
import client.SkillEntry;
import client.SkillFactory;
import client.anticheat.CheatingOffense;
import client.inventory.CheckCopyItem;
import client.inventory.Equip;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.InventoryException;
import client.inventory.ItemFlag;
import client.inventory.MapleAndroid;
import client.inventory.MapleImp;
import client.inventory.MapleInventoryIdentifierPet;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.MapleRing;
import client.inventory.ModifyInventory;
import client.inventory.PetCommand;
import client.messages.CommandExecute;
import client.messages.CommandProcessor;
import client.messages.CommandProcessorUtil;
import client.messages.ConsoleCommandExecute;
import client.messages.ConsoleCommandObject;
import client.messages.commands.AdminCommand;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import client.messages.commands.GMCommand;
import client.messages.commands.InternCommand;
import client.messages.commands.PracticerCommand;
import client.messages.commands.SkilledCommand;
import client.messages.commands.player.eventSystem.AutoPickupSystem;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.eventSystem.MapOwner;
import client.messages.commands.player.eventSystem.SellSystem;
import client.messages.commands.player.\u53ef\u53ef\u8c37;
import client.messages.commands.player.\u5408\u592a\u8c37;
import client.messages.commands.player.\u592d\u58fd\u8c37;
import client.messages.commands.player.\u592f\u592f\u8c37;
import client.messages.commands.player.\u5976\u8336\u8c37;
import client.messages.commands.player.\u61a8\u61a8\u8c37;
import client.messages.commands.player.\u61b6\u6200\u8c37;
import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import client.messages.commands.player.\u738b\u4e4b\u8c37;
import client.messages.commands.player.\u83c7\u83c7\u8c37;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.BanAttackIP;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.MapConstants;
import constants.MobConstants;
import constants.ServerConstants;
import constants.SpecialSkillConstants;
import constants.skills.SkillType;
import database.DBConPool;
import database.DatabaseException;
import handling.MapleServerHandler;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import handling.cashshop.handler.CashShopOperation;
import handling.channel.ChannelServer;
import handling.channel.MapleRanking;
import handling.channel.handler.AllianceHandler;
import handling.channel.handler.BBSHandler;
import handling.channel.handler.BuddyListHandler;
import handling.channel.handler.HiredMerchantHandler;
import handling.channel.handler.NPCHandler;
import handling.channel.handler.PartyHandler;
import handling.channel.handler.PetHandler;
import handling.channel.handler.PlayerHandler;
import handling.channel.handler.PlayersHandler;
import handling.channel.handler.StatsHandling;
import handling.channel.handler.UserInterfaceHandler;
import handling.login.LoginServer;
import handling.opcodes.MapleBuffStat;
import handling.world.CharacterIdChannelPair;
import handling.world.CharacterTransfer;
import handling.world.MapleMessenger;
import handling.world.MapleMessengerCharacter;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import handling.world.exped.MapleExpedition;
import handling.world.family.MapleFamily;
import handling.world.family.MapleFamilyBuff;
import handling.world.family.MapleFamilyCharacter;
import handling.world.guild.MapleGuild;
import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import scripting.AbstractPlayerInteraction;
import scripting.AbstractScriptManager;
import scripting.npc.NPCScriptManager;
import server.Coupon.Coupon;
import server.Coupon.CouponCreate;
import server.Extend.SpecialEquipData;
import server.Extend.SpecialItemData;
import server.Framework.MapleExtendedSlots;
import server.ItemInformation;
import server.MTSCart;
import server.MTSStorage;
import server.MapleCarnivalChallenge;
import server.MapleDueyActions;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MaplePortal;
import server.MapleSquad;
import server.MerchItemPackage;
import server.RandomRewards;
import server.StructRewardItem;
import server.StructSetItem;
import server.Timer;
import server.buffs.AbstractBuffClass;
import server.characterCards.MapleCharacterCards;
import server.game.Baccarat;
import server.game.BlackJack;
import server.game.Cryptocurrency;
import server.game.NiuNiu;
import server.gashapon.GashaponFactory;
import server.gashapon.GashaponRewardSpecial;
import server.gashapon.GashaponSpecial;
import server.life.AbstractLoadedMapleLife;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleMonsterPet;
import server.life.MapleNPC;
import server.life.MobSkill;
import server.life.MobSkillFactory;
import server.life.MonsterGlobalDropEntry;
import server.life.OverrideMonsterStats;
import server.life.PlayerNPC;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.AbstractMapleMapObject;
import server.maps.Event_PyramidSubway;
import server.maps.FieldLimitType;
import server.maps.MapleFoothold;
import server.maps.MapleMap;
import server.maps.MapleMapEffect;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.SavedLocationType;
import server.shark.SharkLogger;
import server.shark.SharkReader;
import server.shops.HiredMerchant;
import server.shops.MaplePlayerShopItem;
import tools.CPUSampler;
import tools.ConcurrentEnumMap;
import tools.EmojiFilter;
import tools.Eval;
import tools.ExternalCodeLongTableGetter;
import tools.FileOperation;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.FixDropNullItem;
import tools.GZIPCompression;
import tools.HexTool;
import tools.LoadPacket;
import tools.MaplePacketCreator;
import tools.MockIOSession;
import tools.Quadra;
import tools.StringUtil;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;
import tools.data.MaplePacketLittleEndianWriter;
import tools.data.RandomAccessByteStream;
import tools.database.CashShopConvert;
import tools.database.UniqueIdReset;
import tools.html.getHtml;
import tools.npcgenerator.Instruction;
import tools.npcgenerator.NPCMessage;
import tools.otp.HmacOneTimePasswordGenerator;
import tools.packet.BeansPacket;
import tools.packet.FamilyPacket;
import tools.packet.MTSCSPacket;
import tools.packet.MobPacket;
import tools.use.GetMACAddress;
import tools.wztosql.DumpItemsAdditions;
import tools.wztosql.DumpMapName;
import tools.wztosql.DumpMobName;

public class AdminCommand {
    public /* synthetic */ AdminCommand() {
        AdminCommand a2;
    }

    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1;
    }

    public static class showM
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = ChannelServer.getAllChannelInstances().iterator();
            while (object.hasNext()) {
                int n2;
                ChannelServer channelServer = (ChannelServer)a3.next();
                a2.getPlayer().dropMessage("\u983b\u9053 " + channelServer.getChannel() + " :");
                a2.getPlayer().dropMessage(GZIPCompression.ALLATORIxDEMO("\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!\u001f!"));
                int n3 = n2 = 910000001;
                while (n3 <= 910000022) {
                    Iterator<MapleMapObject> iterator = channelServer.getMapFactory().getMap(n2).getAllHiredMerchantsThreadsafe().iterator();
                    while (iterator.hasNext()) {
                        Iterator<MapleMapObject> iterator2;
                        HiredMerchant hiredMerchant = (HiredMerchant)iterator2.next();
                        a2.getPlayer().dropMessage("\u73a9\u5bb6: " + hiredMerchant.getMCOwner().getName() + " \u958b\u7acb\u65bc\u5730\u5716: " + n2 + " \u958b\u7acb\u6642\u9593: " + hiredMerchant.getOpenMinute() + " \u5206\u9418");
                        iterator = iterator2;
                    }
                    n3 = ++n2;
                }
                a2.getPlayer().dropMessage(BBSHandler.ALLATORIxDEMO("\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e"));
                object = a3;
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + GZIPCompression.ALLATORIxDEMO("Ad]{\u007f,\u001f,\u985d\u7936\u6272\u6705\u7c8c\u9744\u5574\u4eb6");
        }

        public /* synthetic */ showM() {
            showM a2;
        }
    }

    public static class dpm
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + CashShopConvert.ALLATORIxDEMO("\t5\u0000e@e\u6e41\u8a23\u50da\u5bf6");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            dpm a4;
            if (a2.getPlayer().getMapId() / 100 == 7010002 && a2.getPlayer().getLevel() >= 70 || a2.getPlayer().isGM()) {
                if (a2.getPlayer().isTestingDPM()) {
                    a2.getPlayer().dropMessage(5, CashShopConvert.ALLATORIxDEMO("\u8a8e\u5125\u62cf\u4f0d\u76c1\u9074\u569b)\u0015 \u6e69\u8a0b\u5bc9\u750f\u3047"));
                    return true;
                }
            } else {
                a2.getPlayer().dropMessage(5, DatabaseException.ALLATORIxDEMO("\u53b6\u80d7\u5774z\nz\u597b\u64e8\u53ac\u5ec9\u5868\u6e06\u8a3an\fyt\u8ae1\u756d\u62e7\u8cbf\u76ae\u50ef\u902b\u95dc\u9018\u5139\u0003"));
                return true;
            }
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().toggleTestingDPM();
            mapleClient.getPlayer().dropMessage(5, DatabaseException.ALLATORIxDEMO("\u8ae1\u635d\u7ea6\u6567\u64e0\u6076\u7243m\u001f\u798e\uff26\u4fda\u6e06\u8a3a\u6082\u76d8\u6be5\u798e\u8f12\u51a6\uff2b"));
            a3 = MapleLifeFactory.getMonster(9001007);
            int n2 = mapleClient.getPlayer().getJob() >= 300 && a2.getPlayer().getJob() < 413 || a2.getPlayer().getJob() >= 1300 && a2.getPlayer().getJob() < 1500 || a2.getPlayer().getJob() >= 520 && a2.getPlayer().getJob() < 600 ? 125 : 50;
            Object object = new Point(a2.getPlayer().getPosition().x - n2, a2.getPlayer().getPosition().y);
            Object object2 = a3;
            Object object3 = a3;
            ((MapleMonster)object3).setDpmBelongTo(a2.getPlayer());
            long l2 = Long.MAX_VALUE;
            OverrideMonsterStats overrideMonsterStats = new OverrideMonsterStats();
            overrideMonsterStats.setOHp(Long.MAX_VALUE);
            ((MapleMonster)object3).setHp(Long.MAX_VALUE);
            ((MapleMonster)object2).getStats().setBoss(true);
            ((MapleMonster)object2).setOverrideStats(overrideMonsterStats);
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().getMap().spawnMonsterOnGroundBelow((MapleMonster)a3, (Point)object);
            object = mapleClient2.getPlayer().getMap();
            Timer.EventTimer.getInstance().schedule(new Runnable(){
                public final /* synthetic */ MapleMap a;
                public final /* synthetic */ MapleClient d;
                public final /* synthetic */ dpm ALLATORIxDEMO;
                public final /* synthetic */ MapleMonster K;

                @Override
                public /* synthetic */ void run() {
                    1 a2;
                    1 v0 = a2;
                    long l2 = v0.K.getHp();
                    v0.a.killMonsterDpm(a2.K);
                    long l3 = (Long.MAX_VALUE - l2) / 15L;
                    if (l3 > a2.d.getPlayer().getDPM()) {
                        a2.d.getPlayer().dropMessage(6, "\u4f60\u7684\u6bcf\u79d2\u8f38\u51fa\u662f " + l3 + ". \u9019\u662f\u4e00\u500b\u65b0\u7684\u7d00\u9304\uff01");
                        1 v1 = a2;
                        v1.d.getPlayer().setDPM(l3);
                        v1.d.getPlayer().toggleTestingDPM();
                        return;
                    }
                    a2.d.getPlayer().dropMessage(6, "\u4f60\u7684\u6bcf\u79d2\u8f38\u51fa\u662f " + l3 + ". \u60a8\u76ee\u524d\u7684\u7d00\u9304\u662f " + a2.d.getPlayer().getDPM() + ".");
                    a2.d.getPlayer().toggleTestingDPM();
                }
                {
                    1 a3;
                    1 v0 = a3;
                    v0.ALLATORIxDEMO = a2;
                    v0.K = mapleMonster;
                    a3.a = mapleMap;
                    a3.d = mapleClient;
                }
            }, 15000L);
            return true;
        }

        public /* synthetic */ dpm() {
            dpm a2;
        }
    }

    public static class uneq
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleCoreAura.ALLATORIxDEMO("y\u001ei\u0001,],\u6546\u8d7b\u5740\u571a\u6230\u6705\u4eca\u6b6a\u5618'\u62db\u98a4");
        }

        public /* synthetic */ uneq() {
            uneq a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            for (MapleCharacter mapleCharacter : a2.getPlayer().getMap().getCharactersThreadsafe()) {
                if (mapleCharacter == null || mapleCharacter.isGM()) continue;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.unequipAllPets();
                mapleCharacter2.dropMessage(5, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u7caa\u7d68\u5da3\u5e72\u60f9\u652f\u8d26\u6b7f\u5639\u5495\u62fa\u98b1\u3053"));
                MapleCharacter mapleCharacter3 = mapleCharacter;
                MapleInventoryManipulator.unequip(mapleCharacter2.getClient(), (short)-111, mapleCharacter3.getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
                MapleInventoryManipulator.unequip(mapleCharacter3.getClient(), (short)-109, mapleCharacter.getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
            }
            return true;
        }
    }

    public static class clearscripts
    extends CommandExecute {
        public /* synthetic */ clearscripts() {
            clearscripts a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + CommandExecute.ALLATORIxDEMO("6\u001d0\u0010'\u00026\u0003<\u0001!\u0002u\\u\u6e74\u9631\u00026\u0003<\u0001!\u66da\u5b0d");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            AbstractScriptManager.clearScripts();
            return true;
        }
    }

    public static class MinStats
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a2.getPlayer();
            ((MapleCharacter)a3).getStat().setHp(50);
            ((MapleCharacter)a3).getStat().setMp(50);
            Object object = a3;
            Object object2 = a3;
            Object object3 = a3;
            ((MapleCharacter)object3).getStat().setMaxHp(50);
            ((MapleCharacter)object3).getStat().setMaxMp(50);
            ((MapleCharacter)object3).getStat().setStr((short)4);
            ((MapleCharacter)object3).getStat().setDex((short)4);
            ((MapleCharacter)object3).getStat().setInt((short)4);
            ((MapleCharacter)object2).getStat().setLuk((short)4);
            ((MapleCharacter)object).setLevel((short)10);
            ((MapleCharacter)object2).updateSingleStat(MapleStat.HP, 50);
            ((MapleCharacter)object).updateSingleStat(MapleStat.MP, 50);
            ((MapleCharacter)object).updateSingleStat(MapleStat.MAXHP, 50);
            ((MapleCharacter)object).updateSingleStat(MapleStat.MAXMP, 50);
            ((MapleCharacter)object).updateSingleStat(MapleStat.STR, 4);
            ((MapleCharacter)object).updateSingleStat(MapleStat.DEX, 4);
            ((MapleCharacter)object).updateSingleStat(MapleStat.INT, 4);
            ((MapleCharacter)object).updateSingleStat(MapleStat.LUK, 4);
            ((MapleCharacter)object).updateSingleStat(MapleStat.LEVEL, 10);
            return true;
        }

        public /* synthetic */ MinStats() {
            MinStats a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + AutoPickupSystem.ALLATORIxDEMO("\na)[3i3{g%g\u9818\u8a6a\u5c64\u6060");
        }
    }

    public static class Maxstats
    extends CommandExecute {
        public /* synthetic */ Maxstats() {
            Maxstats a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + L.ALLATORIxDEMO("bNW\\[N[\\\u000f\u0002\u000f\u6ed0\u5c43\u6008");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a2.getPlayer();
            ((MapleCharacter)a3).getStat().setHp(30000);
            ((MapleCharacter)a3).getStat().setMp(30000);
            Object object = a3;
            Object object2 = a3;
            Object object3 = a3;
            ((MapleCharacter)object3).getStat().setMaxHp(30000);
            ((MapleCharacter)object3).getStat().setMaxMp(30000);
            ((MapleCharacter)object3).getStat().setStr((short)32767);
            ((MapleCharacter)object3).getStat().setDex((short)32767);
            ((MapleCharacter)object3).getStat().setInt((short)32767);
            ((MapleCharacter)object2).getStat().setLuk((short)32767);
            ((MapleCharacter)object).setLevel((short)199);
            ((MapleCharacter)object2).updateSingleStat(MapleStat.HP, 30000);
            ((MapleCharacter)object).updateSingleStat(MapleStat.MP, 30000);
            ((MapleCharacter)object).updateSingleStat(MapleStat.MAXHP, 30000);
            ((MapleCharacter)object).updateSingleStat(MapleStat.MAXMP, 30000);
            ((MapleCharacter)object).updateSingleStat(MapleStat.STR, 32767);
            ((MapleCharacter)object).updateSingleStat(MapleStat.DEX, 32767);
            ((MapleCharacter)object).updateSingleStat(MapleStat.INT, 32767);
            ((MapleCharacter)object).updateSingleStat(MapleStat.LUK, 32767);
            ((MapleCharacter)object).updateSingleStat(MapleStat.LEVEL, 199);
            return true;
        }
    }

    public static class MP
    extends CommandExecute {
        public /* synthetic */ MP() {
            MP a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleFoothold.ALLATORIxDEMO("\u001d\fp`\u80ad\u52c7\u506cbpqp\u4fb2\u6569\u80a1\u52cb\u5060");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            MapleCharacter mapleCharacter3 = mapleCharacter;
            mapleCharacter3.setMp(n2);
            mapleCharacter3.setMaxMp(n2);
            mapleCharacter2.updateSingleStat(MapleStat.MP, n2);
            mapleCharacter2.updateSingleStat(MapleStat.MAXMP, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524dMP\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }
    }

    public static class HP
    extends CommandExecute {
        public /* synthetic */ HP() {
            HP a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            MapleCharacter mapleCharacter3 = mapleCharacter;
            mapleCharacter3.setHp(n2);
            mapleCharacter3.setMaxHp(n2);
            mapleCharacter2.updateSingleStat(MapleStat.HP, n2);
            mapleCharacter2.updateSingleStat(MapleStat.MAXHP, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524dHP\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ConcurrentEnumMap.ALLATORIxDEMO("\u0011>yR\u80a4\u52f5\u5065PyCy\u4f80\u6560\u8093\u52c2\u5052");
        }
    }

    public static class Dex
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.setDex(n2);
            mapleCharacter2.updateSingleStat(MapleStat.DEX, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524d\u654f\u6377\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }

        public /* synthetic */ Dex() {
            Dex a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + DumpMobName.ALLATORIxDEMO("Y%~p)\u80ad\u528e\u506c+p8p\u4ffb\u6569\u80e8\u52cb\u5029");
        }
    }

    public static class Luk
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ConsoleCommandObject.ALLATORIxDEMO("viQ<\u0006\u80e1\u52a1\u5020\u0004<\u0017<\u4fd4\u6525\u80c7\u5287\u5006");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.setLuk(n2);
            mapleCharacter2.updateSingleStat(MapleStat.LUK, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524d\u5e78\u904b\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }

        public /* synthetic */ Luk() {
            Luk a2;
        }
    }

    public static class Int
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.setInt(n2);
            mapleCharacter2.updateSingleStat(MapleStat.INT, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524d\u667a\u529b\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }

        public /* synthetic */ Int() {
            Int a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + NPCHandler.ALLATORIxDEMO("J\twG?\u809a\u5298\u505b=G.G\u4fed\u655e\u80fe\u52fc\u503f");
        }
    }

    public static class Str
    extends CommandExecute {
        public /* synthetic */ Str() {
            Str a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.setStr(n2);
            mapleCharacter2.updateSingleStat(MapleStat.STR, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524d\u529b\u91cf\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + client.ItemVac.ALLATORIxDEMO("&a\u00075I\u80e8\u52ee\u5029K5X5\u4f9b\u652c\u8088\u528e\u5049");
        }
    }

    public static class hair
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleFamilyCharacter.ALLATORIxDEMO("l#M0\u0004~\u9aca\u57c9\u4ec7\u78fe\u001ab\tb\u4fca\u657b\u9aca\u57c9");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.setHair(n2);
            mapleCharacter2.updateSingleStat(MapleStat.HAIR, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524d\u9aee\u578b\u7684\uff29\uff24\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }

        public /* synthetic */ hair() {
            hair a2;
        }
    }

    public static class face
    extends CommandExecute {
        public /* synthetic */ face() {
            face a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            int n2 = 0;
            if (a3.length < 2) {
                return false;
            }
            n2 = Integer.parseInt(a3[1]);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.setFace(n2);
            mapleCharacter2.updateSingleStat(MapleStat.FACE, n2);
            mapleCharacter2.dropMessage(5, "\u60a8\u7576\u524d\u81c9\u578b\u7684\uff29\uff24\u5df2\u88ab\u6539\u70ba: " + n2);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + getHtml.ALLATORIxDEMO("-k\boK6\u81a2\u5781\u4e88\u78b6U*F*\u4f85\u6533\u81a2\u5781");
        }
    }

    public static class DCload
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SkillEntry.ALLATORIxDEMO("\u0010Qry^tU5uV]zPq");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.DCLOAD_LOGIN_SAVING = !GameSetConstants.DCLOAD_LOGIN_SAVING;
            return true;
        }

        public /* synthetic */ DCload() {
            DCload a2;
        }
    }

    public static class morempen
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ka.H("4\u000bz\u0014p\u000be\u0003{F\u6246\u95ed\u590f\u95ed");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.MORE_OPEN = -1;
            return true;
        }

        public /* synthetic */ morempen() {
            morempen a2;
        }
    }

    public static class closeban
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + StatsHandling.ALLATORIxDEMO("ZM\u0017A\bK\u0019O\u0015\u000e\u66d0\u666c\u95a7\u95a7\u623b\u6727\u596d\u63b5\u6ad9\u6e02");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.CHECK_TAKE_DAMAGE = false;
            GameSetConstants.ACCURATE_DMG_TO_MOB = false;
            GameSetConstants.ATTACKCHECK_MODIFY = false;
            GameSetConstants.AUTOBAN = false;
            GameSetConstants.AUTODC = false;
            GameSetConstants.ATTACKRANGE_CHECK = false;
            GameSetConstants.ITEMVAC_BAN = false;
            GameSetConstants.MOBVAC_BAN = false;
            GameSetConstants.ALLMAPATTACK_BAN = false;
            GameSetConstants.ATTACKSPEEDUP_BAN = false;
            GameSetConstants.COUNT_CHECK = false;
            GameSetConstants.DELAY_CHECK = false;
            GameSetConstants.CHECKDAMAGE_BAN = false;
            GameSetConstants.CHECK_ALLDAMAGE = false;
            GameSetConstants.MOB_VAC_DETECT = false;
            GameSetConstants.ATTACK_DELAY_DETECT = false;
            return true;
        }

        public /* synthetic */ closeban() {
            closeban a2;
        }
    }

    public static class dumpIP
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + LoadPacket.ALLATORIxDEMO("2SfZc~C\u0017\u91de\u6587\u8f1a\u5152\u6528\u64fdZg");
        }

        public /* synthetic */ dumpIP() {
            dumpIP a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            BanAttackIP.reDumpAtackIp();
            return true;
        }
    }

    public static class removeIP
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            BanAttackIP.ipban.remove(a3[1]);
            return true;
        }

        public /* synthetic */ removeIP() {
            removeIP a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleGuild.ALLATORIxDEMO("%\u0012a\rk\u0016a)T@m\u0010");
        }
    }

    public static class checkbuff
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + CashShopConvert.ALLATORIxDEMO("L&\u0005 \u000e.\u000f0\u000b#");
        }

        public /* synthetic */ checkbuff() {
            checkbuff a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.CHECK_BUFF = !GameSetConstants.CHECK_BUFF;
            a2.getPlayer().dropMessage(6, "CHECK_BUFF\u72c0\u614b:" + GameSetConstants.CHECK_BUFF);
            return true;
        }
    }

    public static class ChangeSet
    extends CommandExecute {
        public /* synthetic */ ChangeSet() {
            ChangeSet a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleCharacterCards.ALLATORIxDEMO("uO<m:k1_1x");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 3) {
                return false;
            }
            a2.getPlayer();
            MapleCharacter.getCharacterByName(a3[1]).setCharacterSet(a3[2], Integer.parseInt(a3[3]));
            return true;
        }
    }

    public static class showSet
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PracticerCommand.ALLATORIxDEMO("&\bo\u0014p(b\u000f");
        }

        public /* synthetic */ showSet() {
            showSet a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a2.getPlayer();
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(a3[1]);
            a2.getPlayer().dropMessage(6, MobConstants.ALLATORIxDEMO("\u739d\u5bb4\u8cf3\u659b\u59b6\u4e09\u000e"));
            a3 = mapleCharacter.getCharacterSet().entrySet().iterator();
            Object object = a3;
            while (object.hasNext()) {
                Map.Entry entry = (Map.Entry)a3.next();
                a2.getPlayer().dropMessage(6, "\u9805\u76ee: " + (String)entry.getKey() + " \u503c:" + entry.getValue());
                object = a3;
            }
            return true;
        }
    }

    public static class debugDC
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MaplePet.ALLATORIxDEMO("\u001dFIROCUXR");
        }

        public /* synthetic */ debugDC() {
            debugDC a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.DEBUG_DC = !GameSetConstants.DEBUG_DC;
            a2.getPlayer().dropMessage(6, "DEBUG_DC\u72c0\u614b:" + GameSetConstants.DEBUG_DC);
            return true;
        }
    }

    public static class question
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = a3[1];
            final boolean bl = a3[2].equals(PracticerCommand.ALLATORIxDEMO("s\tr\u001e"));
            final MapleMap mapleMap = a2.getPlayer().getMap();
            if (mapleMap.getId() == 109020001) {
                question a4;
                mapleMap.startMapEffect("OX\u554f\u7b54:" + (String)a3, 5120003);
                a3 = Timer.EventTimer.getInstance();
                int n2 = 12;
                mapleMap.broadcastMessage(MaplePacketCreator.getClock(12));
                ((Timer)a3).schedule(new Runnable(){
                    {
                        1 a3;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        1 a2;
                        for (MapleCharacter mapleCharacter : a2.mapleMap.getCharactersThreadsafe()) {
                            double d2 = mapleCharacter.getPosition().getX();
                            double d3 = mapleCharacter.getPosition().getY();
                            if (d2 > -234.0 && d3 > -26.0 && !a2.bl || d2 < -234.0 && d3 > -26.0 && a2.bl) {
                                mapleCharacter.dropMessage(6, BuddyListHandler.ALLATORIxDEMO("\u6057\u55eb\u56e4\u7b23\u6b59\u78cd\uff3b"));
                                continue;
                            }
                            MapleCharacter mapleCharacter2 = mapleCharacter;
                            mapleCharacter2.dropMessage(6, \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u5f89\u62cc\u6b48\u7b29\u932e\u4efb\uff00"));
                            mapleCharacter2.getStat().setHp(0);
                            mapleCharacter.updateSingleStat(MapleStat.HP, 0);
                        }
                    }
                }, 12000L);
            } else {
                a2.getPlayer().dropMessage(6, MapleImp.ALLATORIxDEMO("\u6097\u9750\u89be\u5778\u570f\u5746\u303fa\u000fi\u000fb\u000f`\u000fa\u303f\u621d\u53d0\u4eb5\u7396q"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PracticerCommand.ALLATORIxDEMO("Zv\u000eb\bs\u0012h\u0015");
        }

        public /* synthetic */ question() {
            question a2;
        }
    }

    public static class checkOpcode
    extends CommandExecute {
        public /* synthetic */ checkOpcode() {
            checkOpcode a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            SendPacketOpcode.checkValue();
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dropMessage(-1, Eval.ALLATORIxDEMO(":!:!:!:!:!:!:!:!:!"));
            mapleClient.getPlayer().getClient().sendPacket(MaplePacketCreator.partyInvite(a2.getPlayer(), false));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ExternalCodeLongTableGetter.ALLATORIxDEMO("s\b:\u000e1\u0000\u001d\u001b1\u00046\u000e");
        }
    }

    public static class effect
    extends CommandExecute {
        public /* synthetic */ effect() {
            effect a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a3[1];
            a2.sendPacket(MaplePacketCreator.showEffect((String)a3));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + HmacOneTimePasswordGenerator.ALLATORIxDEMO("v\u007f1|2y#:$n%s9}");
        }
    }

    public static class dice
    extends CommandExecute {
        public /* synthetic */ dice() {
            dice a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + StructSetItem.ALLATORIxDEMO("B\rE\u0001\u0006I\u0006\u574c\u5716\u5772\u4e2c\u9ad4\u51dcU\u000bR\u9ef8\u96cc\u6a79\u9eba\u655e");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            Iterator<MapleCharacter> iterator;
            int a32 = Integer.parseInt(a32[1]);
            if (a32 > 6 || a32 < 1) {
                return false;
            }
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getChatText(a2.getPlayer().getId(), "\u6211\u9ab0\u51fa\u4e86\u9ede\u6578 " + a32 + " \u9ede\uff01", false, 1));
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.serverNotice(a2.getPlayer().getName() + " \u9ab0\u51fa\u4e86\u9ede\u6578 " + a32 + " \u9ede\uff01"));
            Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                iterator.next().dropMessage(-1, a2.getPlayer().getName() + " \u9ab0\u51fa\u4e86\u9ede\u6578" + a32 + " \u9ede\uff01");
                iterator2 = iterator;
            }
            return true;
        }
    }

    public static class ClearRank
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleRanking.getInstance().ClearAllRank();
            return true;
        }

        public /* synthetic */ ClearRank() {
            ClearRank a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PlayerRandomStream.ALLATORIxDEMO("r\f?*2=\u0001.=$sbs\u9182\u8f5a\u620f\u675a\u63dd\u881f\u69d3");
        }
    }

    public static class loginfix
    extends CommandExecute {
        public /* synthetic */ loginfix() {
            loginfix a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            World.clearChangeChannel();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PlayerRandomStream.ALLATORIxDEMO("r#<(:!5&+o~o? 4&=):7");
        }
    }

    public static class copyinfo
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            CheckCopyItem.getInfo(a2.getPlayer());
            return true;
        }

        public /* synthetic */ copyinfo() {
            copyinfo a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + AbstractBuffClass.ALLATORIxDEMO("4}znlw{xz>8>vqeg|psq");
        }
    }

    public static class sign
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a3[1];
            int n2 = Integer.parseInt(a3[2]);
            MapleCharacter.getCharacterByName((String)a3).setSignLog(n2);
            a2.getPlayer().dropMessage(CharacterIdChannelPair.ALLATORIxDEMO("\u66ae\u6548\u73f3\u5bc7\u7c67\u5241\u6522\u6261\u52c5P"));
            return true;
        }

        public /* synthetic */ sign() {
            sign a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MTSStorage.ALLATORIxDEMO("\u0013u\u0007r@U$<\u6518\u91d3@1@\u66e8\u6559\u73b5\u5bd6\u7c21\u5250\u6564");
        }
    }

    public static class clearofflinebuffs
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + CharacterTransfer.ALLATORIxDEMO("\u0017eZcWtY`Pj_hSdC`Pu\u0016+\u0016\u6e03\u7430\u516e\u673b\u5366\u5b6eDc@p");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().clearofflinebuffs();
            return true;
        }

        public /* synthetic */ clearofflinebuffs() {
            clearofflinebuffs a2;
        }
    }

    public static class clearPlayerSaving
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PetCommand.ALLATORIxDEMO(">VsP~GOY~LzGLTi\\qR?\u0018?VsP~GOY~LzGLTi\\qR");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            World.clearPlayerSaving();
            return true;
        }

        public /* synthetic */ clearPlayerSaving() {
            clearPlayerSaving a2;
        }
    }

    public static class logincheck
    extends CommandExecute {
        public /* synthetic */ logincheck() {
            logincheck a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MobSkill.ALLATORIxDEMO("\u000bFEMCDIBOIA\n\u0007\nhfeiaufemmoncduiboia");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.BLOCK_LOGGEDIN_CHECK = !GameSetConstants.BLOCK_LOGGEDIN_CHECK;
            a2.getPlayer().dropMessage(5, "\u76ee\u524dBLOCK_LOGGEDIN_CHECK\u662f\u5426\u958b\u555f:" + GameSetConstants.BLOCK_LOGGEDIN_CHECK);
            return true;
        }
    }

    public static class savechaset
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.SAVE_CHARACTERSET = !GameSetConstants.SAVE_CHARACTERSET;
            a2.getPlayer().dropMessage(5, "\u76ee\u524dSAVE_CHARACTERSET\u662f\u5426\u958b\u555f:" + GameSetConstants.SAVE_CHARACTERSET);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + FileOperation.ALLATORIxDEMO(",\u007flzhoem~iy, ,^M[IROEM_MNXH^^IY");
        }

        public /* synthetic */ savechaset() {
            savechaset a2;
        }
    }

    public static class mapinfo
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            a3 = mapleClient.getPlayer().getMap();
            mapleClient.getPlayer().dropMessage(5, "\u5730\u5716\u4ee3\u78bc:" + ((MapleMap)a3).getId() + " \u5730\u5716\u540d\u7a31:" + ((MapleMap)a3).getMapName() + " \u5730\u5716\u7b49\u7d1a\u9650\u5236:" + ((MapleMap)a3).getLevelLimit());
            a2.getPlayer().dropMessage(5, "\u5730\u5716\u6642\u9593\u9650\u5236:" + ((MapleMap)a3).getTimeLimit() + " \u5730\u5716\u602a\u7269\u6578\u91cf:" + ((MapleMap)a3).getMobsSize());
            a2.getPlayer().dropMessage(5, "\u5730\u5716\u751f\u602a\u9ede:" + ((MapleMap)a3).getSpawnPoints().size() + " \u751f\u602a\u6578\u91cf\u500d\u7387:" + MobConstants.isMonsterSpawn((MapleMap)a3));
            a2.getPlayer().dropMessage(5, "\u5730\u5716\u662f\u5426\u9650\u5236\u79fb\u52d5\u6280\u80fd:" + FieldLimitType.MovementSkills.check(((MapleMap)a3).getFieldLimit()));
            return true;
        }

        public /* synthetic */ mapinfo() {
            mapinfo a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MaplePartyCharacter.ALLATORIxDEMO("'SgNoP`Q&\u0013&\u7548\u524b\u570e\u5710\u8cf9\u8a0c");
        }
    }

    public static class pvp
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().getMap().setPvP();
            if (mapleClient.getPlayer().getMap().getPvP()) {
                a2.getPlayer().dropMessage(5, InventoryException.ALLATORIxDEMO("\u6b05\u574a\u5777*7*\u95ea\u6544@"));
            } else {
                a2.getPlayer().dropMessage(5, SpecialItemData.ALLATORIxDEMO("\u6b57\u5718\u5725xex\u95ef\u95a1\u0012"));
            }
            return true;
        }

        public /* synthetic */ pvp() {
            pvp a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + InventoryException.ALLATORIxDEMO("[\u0011\f\u0011ZLZ\u0011\f\u0011");
        }
    }

    public static class Shuffle
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + HmacOneTimePasswordGenerator.ALLATORIxDEMO("vI?o1|;\u007fw7wI?o1|;\u007f");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int a32 = Integer.parseInt(a32[1]);
            if (a32 == 1) {
                a2.getPlayer().dropMessage(Baccarat.getInstance().getCards());
            } else if (a32 == 2) {
                a2.getPlayer().dropMessage(NiuNiu.getInstance().getNiuNiuBankerCard());
            } else if (a32 == 3) {
                a2.getPlayer().dropMessage(BlackJack.getInstance().ChangeBankerCard());
            }
            return true;
        }

        public /* synthetic */ Shuffle() {
            Shuffle a2;
        }
    }

    public static class Fly
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleAndroid.ALLATORIxDEMO("Rq\u001fnS:S\u98cc");
        }

        public /* synthetic */ Fly() {
            Fly a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a2.getPlayer();
            if (((MapleCharacter)a3).getBuffedValue(MapleBuffStat.SOARING) == null) {
                SkillFactory.getSkill(PlayerStats.getSkillByJob(1026, a2.getPlayer().getJob())).getEffect(1).applyTo((MapleCharacter)a3);
            } else {
                MapleBuffStat[] arrmapleBuffStat = new MapleBuffStat[1];
                arrmapleBuffStat[0] = MapleBuffStat.SOARING;
                ((MapleCharacter)a3).cancelBuffStats(arrmapleBuffStat);
                ((MapleCharacter)a3).cancelEffectFromBuffStat(MapleBuffStat.SOARING);
            }
            return true;
        }
    }

    public static class mesorain
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ItemInformation.ALLATORIxDEMO("z.>041:*5cvc\u5972\u4e48\u9379\u96ab");
        }

        public /* synthetic */ mesorain() {
            mesorain a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a2222) {
            if (a2222.length < 1) {
                return false;
            }
            int a2222 = Integer.parseInt(a2222[1]);
            try {
                a2.getPlayer().getMap().spawnMesoRain(a2.getPlayer(), a2222);
            }
            catch (InterruptedException a2222) {
                Logger.getLogger(AdminCommand.class.getName()).log(Level.SEVERE, null, a2222);
            }
            return true;
        }
    }

    public static class loadprize
    extends CommandExecute {
        public /* synthetic */ loadprize() {
            loadprize a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleFoothold.ALLATORIxDEMO("}<318 .9&5|}|\u8f59\u5139\u860b\u64b0\u8cf8\u5e3f\u50a9\u6860");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            try {
                Cryptocurrency.loadPrize();
            }
            catch (IOException a32) {
                Logger.getLogger(AdminCommand.class.getName()).log(Level.SEVERE, null, a32);
            }
            return true;
        }
    }

    public static class changemap
    extends CommandExecute {
        public /* synthetic */ changemap() {
            changemap a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SellSystem.ALLATORIxDEMO("N\u0016\u0007\u0014\u0001\u0012\n\u0018\u000e\u0005OI\u5462\u5b22QUS\u5745\u5779KOXO\u5e1e\u73c6\u5bc3\u63b4\u5745\u5779]\u5f58\u5243\u4f81\u654c\u5fe3\u5385F");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            a2.getPlayer();
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(a3[1]);
            int n2 = CommandProcessorUtil.getOptionalIntArg(a3, 2, 1);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + a3[1]);
            } else {
                mapleCharacter.setMap_Force(n2);
            }
            return true;
        }
    }

    public static class mpto
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            short s2 = (short)CommandProcessorUtil.getOptionalIntArg(a3, 2, 1);
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + a3[1]);
            } else {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                short s3 = s2;
                mapleCharacter2.addMP(s3);
                mapleCharacter2.setMaxMp(s3);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + Eval.ALLATORIxDEMO("e24++\u007fx\u5452\u5b13adc\u653c\u9190z\u007fi\u007f\u7d22\u73f6\u5bf2\u9b0b\u52df");
        }

        public /* synthetic */ mpto() {
            mpto a2;
        }
    }

    public static class hpto
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            short s2 = (short)CommandProcessorUtil.getOptionalIntArg(a3, 2, 1);
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + a3[1]);
            } else {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                short s3 = s2;
                mapleCharacter2.addHP(s3);
                mapleCharacter2.setMaxHp(s3);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SpecialItemData.ALLATORIxDEMO("\u0012@C\\\\\b\u000f\u5425\u5b64\u0016\u0013\u0014\u654b\u91e7\r\b\u001e\b\u7d55\u7381\u5b85\u8868\u91fc");
        }

        public /* synthetic */ hpto() {
            hpto a2;
        }
    }

    public static class coupon
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().dropMessage(CouponCreate.RandomItem());
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + Event_PyramidSubway.ALLATORIxDEMO("G5Q*K4\u0004w\u0004\u88a7\u4f789K/T5J\u5ed5\u867b");
        }

        public /* synthetic */ coupon() {
            coupon a2;
        }
    }

    public static class donatepoint
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MerchItemPackage.ALLATORIxDEMO("H[BUXQ\f\u0019\f\u7d52\u5209\u4e8e\u8d26\u529d\u9ef2\u654c");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            long l2 = 0L;
            a3 = a3[1];
            int n2 = Integer.parseInt(a3[2]);
            if ((a3 = MapleCharacter.getCharacterByName((String)a3)) != null) {
                ((MapleCharacter)a3).getClient().gainDonatePoints(n2);
                a2.getPlayer().dropMessage(MerchItemPackage.ALLATORIxDEMO("\u6584\u58b2\u8d3e\u5285\u9eea\u6554\u6224\u52b3\u0015"));
            } else {
                a2.getPlayer().dropMessage(MTSCart.ALLATORIxDEMO("\u623f\u4e5e\u5271\u8981\u8233r"));
            }
            return true;
        }

        public /* synthetic */ donatepoint() {
            donatepoint a2;
        }
    }

    public static class donate
    extends CommandExecute {
        public /* synthetic */ donate() {
            donate a2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            var3_4 = 0L;
            v0 = a;
            a = v0[1];
            var3_5 = Integer.parseInt((String)v0[2]);
            a = MapleCharacter.getCharacterByName((String)a);
            var4_6 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                v1 = var5_8 = var4_6.prepareStatement(Eval.ALLATORIxDEMO("\u0016\n\f\u0001\r\u0010\u007f\r\u0011\u0010\u0010d? 0*>0:$\u007fl?-;$sd?1,!-*>):$sd?%2+**+$sd?4>=2!10\u0012!+,0 ?h\u007f$;%+!?m\u007f\u0012\u001e\b\n\u0001\fdw\n\n\b\u0013h\u007f{sd`h\u007f{sd\u001c\u0011\r\u0016\u001a\n\u000b\u001b\u000b\r\u0012\u0001\f\u0010\u001e\t\u000fm"));
                var5_8.setString(1, a.getClient().getAccountName());
                v1.setInt(2, var3_5);
                v1.setString(3, a.getPlayer().getName() + "\u624b\u52d5\u65b0\u589e");
                v2 = var5_8;
                v2.execute();
                v2.close();
                ** if (var4_6 == null) goto lbl-1000
            }
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl30
                try {
                    var4_6.close();
                    v3 = var5_9;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        var5_9.addSuppressed(a);
lbl30:
                        // 2 sources

                        v3 = var5_9;
lbl31:
                        // 2 sources

                        throw v3;
                    }
                    catch (Exception var4_7) {
                        a.getPlayer().dropMessage("\u65b0\u589e\u5f8c\u53f0\u8d0a\u52a9\u9ede\u5931\u6557!\u932f\u8aa4:" + var4_7.getMessage());
                        return false;
                    }
                }
            }
lbl-1000:
            // 1 sources

            {
                var4_6.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            a.getPlayer().dropMessage(MapleAndroid.ALLATORIxDEMO("\u65c3\u5889\u5fff\u53e7\u8d79\u52be\u9ead\u6207\u52ec6"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + Eval.ALLATORIxDEMO(";+1%+!\u007fi\u007f\u7d22\u527a\u4efe\u5fd3\u53b4\u8d55\u52ed\u7d5f\u9340");
        }
    }

    public static class MesoRate
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            if (((String[])a3).length > 1) {
                int n2 = Integer.parseInt(a3[1]);
                if (((String[])a3).length > 2 && a3[2].equalsIgnoreCase(EmojiFilter.ALLATORIxDEMO("-o "))) {
                    Object object = a3 = LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels().iterator();
                    while (object.hasNext()) {
                        ((ChannelServer)a3.next()).setMesoRate(n2);
                        object = a3;
                    }
                    a2.getPlayer().dropMessage(6, "\u6240\u6709\u983b\u9053\u7684\u6953\u5e63\u5df2\u88ab\u8abf\u6210 " + n2 + "x");
                } else {
                    MapleClient mapleClient = a2;
                    mapleClient.getChannelServer().setMesoRate(n2);
                    mapleClient.getPlayer().dropMessage(6, "\u983b\u9053\u7684<" + a2.getChannel() + ">\u6953\u5e63\u5df2\u88ab\u8abf\u6210 " + n2 + "x");
                }
            } else {
                a2.getPlayer().dropMessage(6, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u4f28\u7532\u65ee\u6ccfm:vw2i8h6n2:k\u6949\u5e34\u5017\u73d0$wA6v;G"));
            }
            return true;
        }

        public /* synthetic */ MesoRate() {
            MesoRate a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + EmojiFilter.ALLATORIxDEMO("n)p#q-w)#p\u500e\u73cb=l.l\u66f7\u6575\u91d2\u936e\u509a\u73cb");
        }
    }

    public static class DropRate
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            if (((String[])a3).length > 1) {
                int n2 = Integer.parseInt(a3[1]);
                if (((String[])a3).length > 2 && a3[2].equalsIgnoreCase(AutoPickupSystem.ALLATORIxDEMO("&d+"))) {
                    Object object = a3 = LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels().iterator();
                    while (object.hasNext()) {
                        ((ChannelServer)a3.next()).setDropRate(n2);
                        object = a3;
                    }
                    a2.getPlayer().dropMessage(6, "\u6240\u6709\u983b\u9053\u7684\u6389\u5bf6\u5df2\u88ab\u8abf\u6210 " + n2 + "x");
                } else {
                    MapleClient mapleClient = a2;
                    mapleClient.getChannelServer().setDropRate(n2);
                    mapleClient.getPlayer().dropMessage(6, "\u983b\u9053\u7684<" + a2.getChannel() + ">\u6389\u5bf6\u5df2\u88ab\u8abf\u6210 " + n2 + "x");
                }
            } else {
                a2.getPlayer().dropMessage(6, GetMACAddress.ALLATORIxDEMO("\u4f66\u754b\u65a0\u6cb6#C8\u0007k\fi\u0011x\u0017|C%\u7df0\u9a4e\u506e\u739e]98x\u000fu>"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + AutoPickupSystem.ALLATORIxDEMO("l5g7z&|\"({\u5005\u73c06g%g\u66fc\u657e\u6381\u847a\u5091\u73c0");
        }

        public /* synthetic */ DropRate() {
            DropRate a2;
        }
    }

    public static class ExpRate
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            if (((String[])a3).length > 1) {
                int n2 = Integer.parseInt(a3[1]);
                if (((String[])a3).length > 2 && a3[2].equalsIgnoreCase(GashaponRewardSpecial.ALLATORIxDEMO("FhK"))) {
                    Object object = a3 = LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels().iterator();
                    while (object.hasNext()) {
                        ((ChannelServer)a3.next()).setExpRate(n2);
                        object = a3;
                    }
                    a2.getPlayer().dropMessage(6, "\u6240\u6709\u983b\u9053\u7684\u7d93\u9a57\u503c\u5df2\u88ab\u8abf\u6210 " + n2 + "x");
                } else {
                    MapleClient mapleClient = a2;
                    mapleClient.getChannelServer().setExpRate(n2);
                    mapleClient.getPlayer().dropMessage(6, "\u983b\u9053<" + a2.getChannel() + ">\u7684\u7d93\u9a57\u503c\u5df2\u88ab\u8abf\u6210" + n2 + "x");
                }
            } else {
                a2.getPlayer().dropMessage(6, tools.use.donate.ALLATORIxDEMO("\u4f39\u755b\u65ff\u6ca6|Sg\u0016>\u00034\u00122\u0016fO\u7dd5\u9a24\u504b\u73f4xS\u001d\u0012*\u001f\u001b"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + GashaponRewardSpecial.ALLATORIxDEMO("B|WvFpB$\u001b\u5009\u73a0:\u0007)\u0007\u66f0\u651e\u7d97\u9a70\u509d\u73a0");
        }

        public /* synthetic */ ExpRate() {
            ExpRate a2;
        }
    }

    public static class reborn
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0014\u0011\u0004\u001b\u0014\u001aFYF\u8f3d\u7579");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().doReborn(2, true);
            return true;
        }

        public /* synthetic */ reborn() {
            reborn a2;
        }
    }

    public static class ResetMonitored
    extends CommandExecute {
        public /* synthetic */ ResetMonitored() {
            ResetMonitored a2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            block15: {
                block14: {
                    a = DBConPool.getInstance().getDataSource().getConnection();
                    var3_4 = a.prepareStatement(MapleMessenger.ALLATORIxDEMO("M+\\:L>8\u001a{\u0018w\u000ev\u000fk[K>L[U\u0014v\u0012l\u0014j\u001e|[%[("));
                    var3_4.executeUpdate();
                    var4_6 = true;
                    if (var3_4 == null) break block14;
                    var3_4.close();
                }
                if (a == null) break block15;
                a.close();
            }
            return var4_6;
            {
                catch (Throwable var4_7) {
                    if (var3_4 == null) ** GOTO lbl27
                    try {
                        var3_4.close();
                        v0 = var4_7;
                        ** GOTO lbl28
                    }
                    catch (Throwable var5_9) {
                        try {
                            try {
                                var4_7.addSuppressed(var5_9);
lbl27:
                                // 2 sources

                                v0 = var4_7;
lbl28:
                                // 2 sources

                                throw v0;
                            }
                            catch (Throwable var3_5) {
                                block16: {
                                    if (a != null) {
                                        try {
                                            a.close();
                                            v1 = var3_5;
                                            break block16;
                                        }
                                        catch (Throwable var4_8) {
                                            var3_5.addSuppressed(var4_8);
                                        }
                                    }
                                    v1 = var3_5;
                                }
                                throw v1;
                            }
                        }
                        catch (SQLException a) {
                            System.out.println("ResetMonitored:" + a);
                            FileoutputUtil.printError(InternCommand.ALLATORIxDEMO("c`B`EH^kXq^wTa\u001fqIq"), a, MapleMessenger.ALLATORIxDEMO(")}\b}\u000fU\u0014v\u0012l\u0014j\u001e|[p\u001ak[K*T[]\u0003{\u001eh\u000fq\u0014v"));
                            return false;
                        }
                    }
                }
            }
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + InternCommand.ALLATORIxDEMO("c`B`EH^kXq^wTa\u0011(\u0011\u5218\u59fa\u5313\u6271\u670c\u5340\u96af\u5e02\u865a");
        }
    }

    public static class reset
    extends CommandExecute {
        public /* synthetic */ reset() {
            reset a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PartyHandler.ALLATORIxDEMO("*\u0006+\u0006,Cd\u0005-\r;\u00171\f6]xNx\u8a4e\u5bc2\u9873\u8a75\u52fc\u80a5\u70d9>\u00024\u0010=\u3061");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            boolean a32;
            block9: {
                if (((String[])a32).length < 2) {
                    return false;
                }
                a32 = a32[1];
                DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    PreparedStatement preparedStatement = null;
                    DruidPooledConnection druidPooledConnection2 = druidPooledConnection;
                    Statement statement = druidPooledConnection2.createStatement();
                    preparedStatement = druidPooledConnection2.prepareStatement(PartyHandler.ALLATORIxDEMO("6\b'\u00197\u001dC8\u00000\u0002*\u0002;\u0017=\u0011+<+\u0006,\u0003x0\u001d7x\r-\u000e:\u0006*CeChC\u000f+\u001d1\u001dC>\u00166\u0000,\n7\rx^x\\"));
                    preparedStatement.setString(1, (String)a32);
                    preparedStatement.execute();
                    preparedStatement.close();
                    a32 = true;
                    if (druidPooledConnection == null) break block9;
                }
                catch (Throwable throwable) {
                    try {
                        Throwable throwable2;
                        block10: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    throwable2 = throwable;
                                    break block10;
                                }
                                catch (Throwable throwable3) {
                                    throwable.addSuppressed(throwable3);
                                }
                            }
                            throwable2 = throwable;
                        }
                        throw throwable2;
                    }
                    catch (Exception exception) {
                        FilePrinter.printError(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"JkMhL`ZzPaW MvM"), exception);
                        return false;
                    }
                }
                druidPooledConnection.close();
            }
            return a32;
        }
    }

    public static class prize
    extends \u4e8b\u524d\u734e\u52f5 {
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, FamilyPacket.ALLATORIxDEMO("F\"\u0002n\u738b\u5be4\u542f\u7a63\u001cr\u001e\u731c\u52d7\u545f\u7a13l\u0002\u7629\u8a3a\u4ed9\u526f\u731c\u52d7")).toString();
        }

        public /* synthetic */ prize() {
            prize a2;
        }
    }

    public static class toggleChair
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().getMap().toggleChair();
            if (!mapleClient.getPlayer().getMap().canChair()) {
                int n2 = a3 = 0;
                while (n2 < 3) {
                    a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getItemNotice(AutoPickupSystem.ALLATORIxDEMO("\u001c\u690d\u5b17\u7989\u6b25\u4f77\u756f\u6288\u80ba\u8b6e\u540dUg\u8ac3\u52b8\u5720\u6b23\u5738\u5751\u4f77\u756f\u4ef3\u4f12\u690d\u5b17\u9028\u6257\u73a1\u5bf1\u65bf\u7d9d)f\u542e\u5200\u670b\u81ad\u52dd\u65fa\u4eed\u61b5\u7f78\u3045")));
                    n2 = ++a3;
                }
                a2.getPlayer().getMap().startMapEffect(MapleExtendedSlots.ALLATORIxDEMO("\u8aec\u52a7\u570f\u6b3c\u5717\u574e\u4f58\u7570\u4edc\u4f0d\u6922\u5b08\u9007\u6248\u738e\u5bee\u6590\u7d82\u0006y\u5401\u521f\u6724\u81b2\u52f2\u65e5\u4ec2\u61aa\u7f57\u305a"), 5120009);
            } else {
                MapleClient mapleClient2 = a2;
                mapleClient2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getItemNotice(AutoPickupSystem.ALLATORIxDEMO("\u001c\u690d\u5b17\u7989\u6b25\u4f77\u756f\u6288\u80ba\u89eb\u9623Ug\u76e6\u520a\u5dfa\u89a4\u966c\u5777\u571e\u6942\u5b58\u4f38\u7520\u9617\u523ek\u53e7\u4ebc\u6107\u4f38\u7520\u6942\u5b58\u3045")));
                mapleClient2.getPlayer().getMap().startMapEffect(MapleExtendedSlots.ALLATORIxDEMO("\u76c9\u5215\u5dd5\u89bb\u9643\u5768\u5731\u695d\u5b77\u4f27\u750f\u9608\u5211t\u53c8\u4ea3\u6128\u4f27\u750f\u695d\u5b77\u305a"), 5120009);
            }
            return true;
        }

        public /* synthetic */ toggleChair() {
            toggleChair a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + AutoPickupSystem.ALLATORIxDEMO("|(o d\"K/i.zg%g\u9583\u5518\u621e\u959b\u9581\u5777\u571e\u4f38\u7520\u6942\u5b58\u3045");
        }
    }

    public static class toggleSkill
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().getMap().toggleSkill();
            if (!mapleClient.getPlayer().getMap().canSkill()) {
                int n2 = a3 = 0;
                while (n2 < 3) {
                    a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getItemNotice(DumpMobName.ALLATORIxDEMO("N\u5760\u5703\u79d1\u6b77\u4f2f\u753d\u62d0\u80e8\u8b36\u545f\r5\u8a9b\u52ea\u5778\u6b71\u5760\u5703\u65ed\u652b\u4eab\u4f40\u62d0\u80e8\u9070\u6205\u73f9\u5ba3\u65e7\u7dcfq4\u5476\u5252\u6753\u81ff\u5285\u65a8\u4eb5\u61e7\u7f20\u3017")));
                    n2 = ++a3;
                }
                a2.getPlayer().getMap().startMapEffect(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u8ab6\u52b5\u5755\u6b2e\u574d\u575c\u65c0\u6574\u4e86\u4f1f\u62fd\u80b7\u905d\u625a\u73d4\u5bfc\u65ca\u7d90\\k\u545b\u520d\u677e\u81a0\u52a8\u65f7\u4e98\u61b8\u7f0d\u3048"), 5120009);
            } else {
                MapleClient mapleClient2 = a2;
                mapleClient2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getItemNotice(DumpMobName.ALLATORIxDEMO("N\u5760\u5703\u79d1\u6b77\u4f2f\u753d\u62d0\u80e8\u89b3\u9671\r5\u76be\u5258\u5da2\u89f6\u9634\u5725\u5746\u6295\u80ad\u4f6a\u7578\u9645\u52669\u53bf\u4eee\u615f\u4f6a\u7578\u6295\u80ad\u3017")));
                mapleClient2.getPlayer().getMap().startMapEffect(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u7693\u5207\u5d8f\u89a9\u9619\u577a\u576b\u62ca\u8080\u4f35\u7555\u961a\u524bf\u5392\u4eb1\u6172\u4f35\u7555\u62ca\u8080\u3048"), 5120009);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + DumpMobName.ALLATORIxDEMO("$z7r<p\u0003~9y<5}5\u95db\u554a\u6246\u95c9\u95d9\u5725\u5746\u4f6a\u7578\u6295\u80ad\u3017");
        }

        public /* synthetic */ toggleSkill() {
            toggleSkill a2;
        }
    }

    public static class preshutdown
    extends CommandExecute {
        public /* synthetic */ preshutdown() {
            preshutdown a2;
        }

        @Override
        public /* synthetic */ boolean execute(final MapleClient a2, String[] a32) {
            preshutdown a4;
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            int n2 = Integer.parseInt(a32[2]);
            CommandProcessor.processCommand(a2.getPlayer().getClient(), "!servermsg [\u7dad\u4fee\u516c\u544a] \u4eca\u65e5\u7cfb\u7d71\u5df2\u8a2d\u5b9a " + a32 + " \u9ede\u6574\u81ea\u52d5\u95dc\u670d,\u8acb\u5927\u5bb6\u63d0\u65e9@save\u4e26\u4e14\u4e0b\u7dda!", ServerConstants.CommandType.NORMAL);
            Timer.BuffTimer buffTimer = Timer.BuffTimer.getInstance();
            buffTimer.scheduleAtTimestamp(new Runnable(){

                @Override
                public /* synthetic */ void run() {
                    var a22;
                    Timer.BuffTimer buffTimer = Timer.BuffTimer.getInstance();
                    buffTimer.schedule(new Runnable(){

                        @Override
                        public /* synthetic */ void run() {
                            preshutdown.1 a2;
                            CommandProcessor.processCommand(a2.a2.getPlayer().getClient(), MapleGuild.ALLATORIxDEMO("Aw\bq\u0014`\u000fs\u000ep\ti\u0005$R"), ServerConstants.CommandType.NORMAL);
                            a2.a2.getPlayer().dropMessage(5, BeansPacket.ALLATORIxDEMO("\u6b21\u570d\u6ed4\u50bc\u959e\u6a7a"));
                        }
                        {
                            preshutdown.1 a3;
                        }
                    }, 60000L);
                    CommandProcessor.processCommand(a22.a2.getPlayer().getClient(), MapleImp.ALLATORIxDEMO("\u001e#^&Z1S<"), ServerConstants.CommandType.NORMAL);
                }
                {
                    1 a3;
                }
            }, Timer.DateToStamp(a32, n2, 0));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + UserInterfaceHandler.ALLATORIxDEMO("KF^GSAOPTCU\u0014\u0007\u5e4a\u9ee5\n\u001b\u0019\u001b\u556b\u7513\u81de\u52ee\u5106\u5b63\u4e12\u95e7\u6739");
        }
    }

    public static class restartbufftimer
    extends CommandExecute {
        public /* synthetic */ restartbufftimer() {
            restartbufftimer a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Timer.BuffTimer.getInstance().stop();
            Timer.BuffTimer.getInstance().start();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleMapEffect.ALLATORIxDEMO("E+D:V<C,B(Q:^#R<\u0017r\u91fa\u5511u\u001bq\b\u8a3f\u660c\u565fp");
        }
    }

    public static class monsterpet
    extends CommandExecute {
        public /* synthetic */ monsterpet() {
            monsterpet a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            if (a3.length == 2) {
                new MapleMonsterPet(Integer.parseInt(a3[1]), a2.getPlayer());
            } else if (a3.length == 3) {
                new MapleMonsterPet(Integer.parseInt(a3[1]), a2.getPlayer()).setSkills(Integer.parseInt(a3[2]));
            } else {
                return false;
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapOwner.ALLATORIxDEMO("\u0005Q&M<[:N-Jh\u0002\u0005Q*\u001e\u0001zv\u001etm#W$Rv");
        }
    }

    public static class news
    extends CommandExecute {
        public /* synthetic */ news() {
            news a2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            a = a[1];
            var3_5 = StringUtil.joinStringFrom(a, 2);
            var4_6 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                v0 = var5_8 = var4_6.prepareStatement(PetCommand.ALLATORIxDEMO("|QfZgK\u0015V{Kz?GzVmZqPhF?\u001d?AvAsP3\u0015rPlF~Rz\u0019?Q~Az\u00156\u0015ItS`Zf?\u001d?\n3\u0015 \u0019?\n?\u001c"));
                var5_8.setString(1, a);
                v0.setString(2, var3_5);
                var5_8.setString(3, FileoutputUtil.NowTime());
                v0.executeUpdate();
                var5_8.close();
                ** if (var4_6 == null) goto lbl-1000
            }
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl26
                try {
                    var4_6.close();
                    v1 = var5_9;
                    ** GOTO lbl27
                }
                catch (Throwable a) {
                    try {
                        var5_9.addSuppressed(a);
lbl26:
                        // 2 sources

                        v1 = var5_9;
lbl27:
                        // 2 sources

                        throw v1;
                    }
                    catch (SQLException var4_7) {
                        a.getPlayer().dropMessage(AbstractPlayerInteraction.ALLATORIxDEMO("Z\u0013s$n$\\v,vB7o8n\"!%` dvS3b$nvo3v% "));
                    }
                }
            }
lbl-1000:
            // 1 sources

            {
                var4_6.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PetCommand.ALLATORIxDEMO("~[k\\tF?\u0018?\u95be0\u95e9\u9596\u9607\u6429\u601f\u7ce4\u7d44");
        }
    }

    public static class Buffall
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
            while (object.hasNext()) {
                MapleCharacter mapleCharacter = (MapleCharacter)a3.next();
                SkillFactory.getSkill(9001003).getEffect(1).applyTo(mapleCharacter);
                SkillFactory.getSkill(9001008).getEffect(1).applyTo(mapleCharacter);
                SkillFactory.getSkill(9001001).getEffect(1).applyTo(mapleCharacter);
                SkillFactory.getSkill(3121002).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(3121008).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(3121009).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(2321004).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(21121003).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(2321003).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(1301006).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(4211003).getEffect(20).applyTo(mapleCharacter);
                SkillFactory.getSkill(4111001).getEffect(30).applyTo(mapleCharacter);
                SkillFactory.getSkill(4111002).getEffect(30).applyTo(mapleCharacter);
                object = a3;
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u795e.getCommandPrefix() + CommandProcessorUtil.ALLATORIxDEMO("$M\u0000^\u0007T\n\u0018K\u0018\u65db\u6506\u7bc7\u743e$m ~");
        }

        public /* synthetic */ Buffall() {
            Buffall a2;
        }
    }

    public static class VPoint
    extends CommandExecute {
        public /* synthetic */ VPoint() {
            VPoint a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleFamilyCharacter.ALLATORIxDEMO("cr\u0012K+J6\u0004\u73eb\u5b92\u544f\u7a15b\u655c\u918d");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, MapleFamilyCharacter.ALLATORIxDEMO("\u6b48\u9674\u4e4f\u8d97c"));
                return false;
            }
            String string = a3[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0) {
                a2.getPlayer().dropMessage(6, MapConstants.ALLATORIxDEMO("\u73d2\u5bae\u5fbe\u9810\u4e71\u7dc2"));
                return false;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            if (mapleCharacter == null) {
                MapleClient mapleClient = a2;
                mapleClient.gainVpoint(string, Integer.parseInt(a3[2]));
                mapleClient.getPlayer().dropMessage(5, "\u5df2\u96e2\u7dda\u7d66\u4e88\u73a9\u5bb6" + GameSetConstants.VPOINT_NAME + ",\u8acb\u518d\u6b21\u78ba\u8a8d\u3002");
            } else {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.setVPoints(mapleCharacter2.getVPoints() + Integer.parseInt(a3[2]));
                a2.getPlayer().dropMessage(6, "\u6210\u529f\u7d66\u4e88 " + mapleCharacter.getName() + " " + a3[2] + "\u9ede " + GameSetConstants.VPOINT_NAME + "\u9ede\u6578");
                FileoutputUtil.logToFile("logs/GM_LOG/\u7d66\u4eba" + GameSetConstants.VPOINT_NAME + ".txt", "\r\n " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u7d66\u4e86 " + mapleCharacter.getName() + " " + a3[2] + "\u9ede\u7d05\u5229\u9ede\u6578");
            }
            return true;
        }
    }

    public static class test
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"8\u0015|\u0012m");
        }

        public /* synthetic */ test() {
            test a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleFamilyBuff.getBuffEntry(6).applyTo(a2.getPlayer());
            return true;
        }
    }

    public static class changejob
    extends CommandExecute {
        public /* synthetic */ changejob() {
            changejob a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleMapEffect.ALLATORIxDEMO("oT&V P+]!Un\u000b\u5443\u5b60p\u0017r\u8040\u6923~\n\tn\u001an\u650e\u4ef4\u8040\u6923");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            short s2 = (short)CommandProcessorUtil.getOptionalIntArg(a3, 2, 1);
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + a3[1]);
            } else {
                mapleCharacter.changeJob(s2);
            }
            return true;
        }
    }

    public static class setpee
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            a2.getPlayer().setPee(a32);
            return true;
        }

        public /* synthetic */ setpee() {
            setpee a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + RandomAccessByteStream.ALLATORIxDEMO("$>`9u(`m\u60f6\u5c72\u5c3a\u76c9\u611a\u89f7\u5e7bh");
        }
    }

    public static class apto
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + K.ALLATORIxDEMO(";tjau5&\u5418\u5b4d+:)\u6562\u91da$575\u7d7c\u73bc\u5bac\u80e8\u5281\u5029\u9ec4\u656d");
        }

        public /* synthetic */ apto() {
            apto a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            short s2 = (short)CommandProcessorUtil.getOptionalIntArg(a3, 2, 1);
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + a3[1]);
            } else {
                mapleCharacter.gainAp(s2);
            }
            return true;
        }
    }

    public static class spto
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2 = CommandProcessorUtil.getOptionalIntArg(a3, 2, 1);
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + a3[1]);
            } else {
                mapleCharacter.gainSP(n2);
            }
            return true;
        }

        public /* synthetic */ spto() {
            spto a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + GetMACAddress.ALLATORIxDEMO("Bj\u0013m\f9_\u5414\u5b34'C%\u651b\u91d6]9N9\u7d05\u73b0\u5bd5\u6299\u809e\u9ec7\u651b");
        }
    }

    public static class IPStatus
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            if (a3.length < 2) {
                return false;
            }
            a3 = a2.getIPstatus(a3[1], true).split(MTSStorage.ALLATORIxDEMO("m\u0016"));
            int n3 = a3.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                String string = a3[n2];
                a2.getPlayer().dropMessage(string);
                n4 = ++n2;
            }
            return true;
        }

        public /* synthetic */ IPStatus() {
            IPStatus a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleExpedition.ALLATORIxDEMO("'lVvrDrPu\u0005:\u738c\u5bb0\u5428\u7a37\u001b&\b&\u67c0\u770d\u738c\u5bb0lV\u5eb0\u4e0d\u765e\u5163\u906b\u7682\u6265\u670f\u89f7\u8274");
        }
    }

    public static class ItemEveryone
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            int n2 = CommandProcessorUtil.getOptionalIntArg(a32, 2, 1);
            Iterator<ChannelServer> iterator = LoginServer.getWorldStatic(a2.getWorld()).getChannels().iterator();
            while (iterator.hasNext()) {
                Iterator<MapleCharacter> iterator2 = iterator.next().getPlayerStorage().getAllCharacters().iterator();
                while (iterator2.hasNext()) {
                    Iterator<MapleCharacter> iterator3;
                    iterator3.next().gainItem(a32, n2, a2.getPlayer().getName() + "\u5168\u670d\u767c\u9001");
                    iterator2 = iterator3;
                }
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u734e\u52f5\u516c\u544a]: " + a2.getPlayer().getName() + " \u7d66\u4e86 \u6240\u6709\u73a9\u5bb6  " + a32 + " " + n2 + "\u500b"));
            FileoutputUtil.logToFile(RandomAccessByteStream.ALLATORIxDEMO("!j*vbB\u0000Z\u0001J\n*\u7d2b\u516d\u6740\u726c\u548c+9}9"), "\r\n " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u7d66\u4e86 \u6240\u6709\u73a9\u5bb6 \u7269\u54c1: " + MapleItemInformationProvider.getInstance().getName(a32) + " " + n2 + "\u500b");
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + DumpItemsAdditions.ALLATORIxDEMO("hO=C$C?C;_&H,\u0006u\u9075\u513e\u0018i\u001a\u6531\u91e9w\u0006d\u0006\u7d2f\u6266\u6740\u738f\u5bff\u9075\u513e");
        }

        public /* synthetic */ ItemEveryone() {
            ItemEveryone a2;
        }
    }

    public static class GashEveryone
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"vK6\u007f?I!i%u8b2,k\u6574\u91982w!w\u7d6a\u6217\u6705\u73fe\u5bba\u0010m$d\u9e89\u6574");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u6b06\u9607\u4e01\u8de4-"));
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            Object object = LoginServer.getWorldStatic(a2.getWorld()).getChannels().iterator();
            while (object.hasNext()) {
                Iterator<MapleCharacter> iterator = object.next().getPlayerStorage().getAllCharacters().iterator();
                while (iterator.hasNext()) {
                    Iterator<MapleCharacter> iterator2;
                    iterator2.next().modifyCSPoints(true ? 1 : 0, a32, true);
                    iterator = iterator2;
                }
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u734e\u52f5\u516c\u544a]: " + a2.getPlayer().getName() + " \u767c\u9001\u7d66\u5168\u4f3a\u670d\u5668GASH " + a32 + " \u9ede"));
            FileoutputUtil.logToFile(BankSystem.ALLATORIxDEMO("\u001b\u001c\u0010\u0000X4:,;<0\\\u7d11\u511b\u677a\u9ead\u650f]\u0003\u000b\u0003"), "\r\n " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u767c\u9001\u7d66\u5168\u4f3a\u670d\u5668\u9ede\u6578 " + a32 + "\u9ede");
            object = "[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u7d66\u4e86 \u6240\u6709\u73a9\u5bb6 \u6953\u8449\u9ede\u6578 " + a32 + "\u9ede";
            return true;
        }

        public /* synthetic */ GashEveryone() {
            GashEveryone a2;
        }
    }

    public static class MaplePointEveryone
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + AbstractPlayerInteraction.ALLATORIxDEMO("wL7q:d\u0006n?o\"D d$x9o3!j\u6579\u9199?v,v\u7d67\u6216\u6708\u73ff\u5bb7\u0011`%i\u9e88\u6579");
        }

        public /* synthetic */ MaplePointEveryone() {
            MaplePointEveryone a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            Object object = LoginServer.getWorldStatic(a2.getWorld()).getChannels().iterator();
            while (object.hasNext()) {
                Iterator<MapleCharacter> iterator = object.next().getPlayerStorage().getAllCharacters().iterator();
                while (iterator.hasNext()) {
                    Iterator<MapleCharacter> iterator2;
                    iterator2.next().modifyCSPoints(2, a32, true);
                    iterator = iterator2;
                }
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u734e\u52f5\u516c\u544a]: " + a2.getPlayer().getName() + " \u767c\u9001\u7d66\u5168\u4f3a\u670d\u5668\u6953\u8449\u9ede\u6578 " + a32 + " \u9ede"));
            FileoutputUtil.logToFile(GZIPCompression.ALLATORIxDEMO("`]kA#uAm@}K\u001d\u7d6a\u515a\u6701\u6961\u8445\u9eec\u6574\u001cxJx"), "\r\n " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u767c\u9001\u7d66\u5168\u4f3a\u670d\u5668\u6953\u8449\u9ede\u6578 " + a32 + "\u9ede");
            object = "[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u7d66\u4e86 \u6240\u6709\u73a9\u5bb6 \u6953\u8449\u9ede\u6578 " + a32 + "\u9ede";
            return true;
        }
    }

    public static class WarpBack
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (a3 != null) {
                Integer n2 = ((MapleCharacter)a3).getSavedLocation(SavedLocationType.fromString(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u000e$\u0016*\u0006$\u0004(\u0007-")));
                if (n2 == null || n2 == -1) {
                    n2 = 910000000;
                }
                ((MapleCharacter)a3).changeMap(n2);
                ((MapleCharacter)a3).clearSavedLocation(SavedLocationType.fromString(GetMACAddress.ALLATORIxDEMO("^.F V.T\"W'")));
            } else {
                a2.getPlayer().dropMessage(5, \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u6b0d\u73e0\u5bdf\u4e44\u5741\u60e1\u8ec2\u90c3\u0017"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() + GetMACAddress.ALLATORIxDEMO("N\u0002k\u0013[\u0002z\b9\u62e9\u73b0\u5bd5\u50aa\u9062\u56c7\u5238\u5242\u76e7\u5729\u5775");
        }

        public /* synthetic */ WarpBack() {
            WarpBack a2;
        }
    }

    public static class WarpHereID
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + UserInterfaceHandler.ALLATORIxDEMO("\u001aCZFK\\^F^]_\u0014\u62b1\u739d\u5b8d\u5087\u903a\u5204\u9022\u88d5");
        }

        public /* synthetic */ WarpHereID() {
            WarpHereID a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int n2;
            if (a32.length < 2) {
                return false;
            }
            int n3 = 0;
            try {
                n2 = n3 = Integer.parseInt(a32[1]);
            }
            catch (Exception a32) {
                n2 = n3;
            }
            int a32 = World.Find.findChannel(n2);
            int n4 = World.Find.findWorld(n3);
            if (a32 < 0) {
                a2.getPlayer().dropMessage(6, "\u73a9\u5bb6\u7de8\u865f[" + n3 + "] \u4e0d\u5728\u7dda\u4e0a");
                return true;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterById(n3);
            if (mapleCharacter != null) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.saveLocation(SavedLocationType.fromString(UserInterfaceHandler.ALLATORIxDEMO("|ydwtyvuup")));
                mapleCharacter2.changeMap(a2.getPlayer().getMap(), a2.getPlayer().getMap().findClosestSpawnpoint(a2.getPlayer().getPosition()));
            } else {
                MapleCharacter mapleCharacter3 = mapleCharacter = ChannelServer.getInstance(n4, a32).getPlayerStorage().getCharacterById(n3);
                mapleCharacter3.saveLocation(SavedLocationType.fromString(MTSCSPacket.ALLATORIxDEMO("bgzijghkkn")));
                a2.getPlayer().dropMessage(5, UserInterfaceHandler.ALLATORIxDEMO("\u6b57\u5713\u62be\u7392\u5b82\u5088\u5204\u9022\u4fb2"));
                mapleCharacter3.dropMessage(5, MTSCSPacket.ALLATORIxDEMO("\u6b49\u570d\u5099\u9024\u521abg\u9086\u90a0"));
                if (mapleCharacter3.getMapId() != a2.getPlayer().getMapId()) {
                    MapleCharacter mapleCharacter4 = mapleCharacter;
                    MapleMap mapleMap = mapleCharacter4.getClient().getChannelServer().getMapFactory().getMap(a2.getPlayer().getMapId());
                    mapleCharacter4.changeMap(mapleMap, mapleMap.getPortal(0));
                }
                mapleCharacter.changeChannel(a2.getChannel());
            }
            return true;
        }
    }

    public static class Mobdrop
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.removeClickedNPC();
            NPCScriptManager.getInstance().start(a2, 9010000, DumpMapName.ALLATORIxDEMO("\u601c\u723a\u63bf\u5ba5\u67d3\u8a31"));
            return true;
        }

        public /* synthetic */ Mobdrop() {
            Mobdrop a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PlayerHandler.ALLATORIxDEMO("sX=w6g=er8r\u603f\u723b\u639c\u5ba4\u67f0\u8a30");
        }
    }

    public static class MYNPC
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + GetMACAddress.ALLATORIxDEMO("8.@-I 9N9\u95e8\u5546\u8189\u8a1b-I ");
        }

        public /* synthetic */ MYNPC() {
            MYNPC a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a3[1];
            a2.removeClickedNPC();
            NPCScriptManager.getInstance().start(a2, 9010000, (String)a3);
            return true;
        }
    }

    public static class Status
    extends CommandExecute {
        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int n2;
            String string;
            String string2;
            boolean bl;
            String string3;
            Object object;
            String string4;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            String string5;
            String string6;
            String string7;
            String a32;
            block54: {
                if (((String[])a32).length < 2) {
                    return false;
                }
                a32 = a32[1];
                string7 = "";
                string6 = "";
                string5 = "";
                n14 = 0;
                n13 = 0;
                n12 = 0;
                n12 = 0;
                n11 = 0;
                n10 = 0;
                n9 = 0;
                n8 = 0;
                n7 = 0;
                n6 = 0;
                n5 = 0;
                n4 = 0;
                n3 = 0;
                bl5 = false;
                bl4 = false;
                bl3 = false;
                bl2 = false;
                string4 = null;
                MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(a32);
                if (mapleCharacter == null) {
                    a2.getPlayer().dropMessage(5, SpecialItemData.ALLATORIxDEMO("\u624d\u4e25\u5203\u6b4c\u739a\u5b9e\u0012"));
                    return true;
                }
                if (mapleCharacter.getGMLevel() > a2.getPlayer().getGMLevel()) {
                    a2.getPlayer().dropMessage(5, fc.ALLATORIxDEMO("\u4f32\u4e1a\u80af\u67f2\u7759\u6bc3\u4f32\u9acf\u6b58\u9647\u76d6\u4eads"));
                    return true;
                }
                try {
                    mapleCharacter = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        Object object2;
                        block59: {
                            block53: {
                                MapleCharacter mapleCharacter2;
                                ResultSet resultSet;
                                block58: {
                                    block52: {
                                        MapleCharacter mapleCharacter3;
                                        block57: {
                                            block51: {
                                                MapleCharacter mapleCharacter4;
                                                block56: {
                                                    block50: {
                                                        MapleCharacter mapleCharacter5;
                                                        block55: {
                                                            block49: {
                                                                object = mapleCharacter.prepareStatement(SpecialItemData.ALLATORIxDEMO("`m\u007fmp|\u0013\u0002\u0013nag~\bP@RZRKGMA[\u0013\u007f{mam\u0013FREV\b\u000e\b\f"));
                                                                object.setString(1, a32);
                                                                resultSet = object.executeQuery();
                                                                try {
                                                                    if (resultSet.next()) {
                                                                        ResultSet resultSet2 = resultSet;
                                                                        n14 = resultSet2.getInt(fc.ALLATORIxDEMO("3t1x'y&~6"));
                                                                        n11 = resultSet2.getInt(SpecialItemData.ALLATORIxDEMO("AW"));
                                                                        n10 = resultSet2.getShort(fc.ALLATORIxDEMO(">r$r>"));
                                                                        n13 = resultSet2.getInt(SpecialItemData.ALLATORIxDEMO("EV[\\"));
                                                                        n12 = resultSet2.getByte(fc.ALLATORIxDEMO("p7y6r "));
                                                                        n3 = resultSet2.getInt(SpecialItemData.ALLATORIxDEMO("YGQ"));
                                                                    }
                                                                    if (resultSet == null) break block49;
                                                                    mapleCharacter5 = mapleCharacter;
                                                                }
                                                                catch (Throwable throwable) {
                                                                    Throwable throwable2;
                                                                    if (resultSet != null) {
                                                                        try {
                                                                            resultSet.close();
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
                                                                resultSet.close();
                                                                break block55;
                                                            }
                                                            mapleCharacter5 = mapleCharacter;
                                                        }
                                                        object = mapleCharacter5.prepareStatement(fc.ALLATORIxDEMO("D\u0017[\u0017T\u00067x7\u0014E\u001dZrv1t=b<c!7%\u007f7e77;sr~<7zD\u0017[\u0017T\u000673t1x'y&~67\u0014E\u001dZrt:v v1c7e!7\u0005_\u0017E\u00177<v?rr*r({"));
                                                        object.setString(1, a32);
                                                        resultSet = object.executeQuery();
                                                        try {
                                                            if (resultSet.next()) {
                                                                ResultSet resultSet3 = resultSet;
                                                                n8 = resultSet3.getInt(SpecialItemData.ALLATORIxDEMO("EX\\A]\\@"));
                                                                n9 = resultSet3.getInt(fc.ALLATORIxDEMO("g=~<c!"));
                                                                n7 = resultSet3.getInt(SpecialItemData.ALLATORIxDEMO("rKR[["));
                                                                string5 = resultSet3.getString(fc.ALLATORIxDEMO("y3z7"));
                                                                n6 = resultSet3.getInt(SpecialItemData.ALLATORIxDEMO("^x\\A]\\@"));
                                                            }
                                                            if (resultSet == null) break block50;
                                                            mapleCharacter4 = mapleCharacter;
                                                        }
                                                        catch (Throwable throwable) {
                                                            Throwable throwable4;
                                                            if (resultSet != null) {
                                                                try {
                                                                    resultSet.close();
                                                                    throwable4 = throwable;
                                                                    throw throwable4;
                                                                }
                                                                catch (Throwable throwable5) {
                                                                    throwable.addSuppressed(throwable5);
                                                                }
                                                            }
                                                            throwable4 = throwable;
                                                            throw throwable4;
                                                        }
                                                        resultSet.close();
                                                        break block56;
                                                    }
                                                    mapleCharacter4 = mapleCharacter;
                                                }
                                                object = mapleCharacter4.prepareStatement(fc.ALLATORIxDEMO("\u0001R\u001eR\u0011Cr=rQ\u0000X\u001f7!c=e3p7dr`:r rrv1t=b<c;sr~<7zD\u0017[\u0017T\u000673t1x'y&~67\u0014E\u001dZrt:v v1c7e!7\u0005_\u0017E\u00177<v?rr*r({"));
                                                object.setString(1, a32);
                                                resultSet = object.executeQuery();
                                                try {
                                                    if (resultSet.next()) {
                                                        n5 = resultSet.getInt(SpecialItemData.ALLATORIxDEMO("EV[\\"));
                                                    }
                                                    if (resultSet == null) break block51;
                                                    mapleCharacter3 = mapleCharacter;
                                                }
                                                catch (Throwable throwable) {
                                                    Throwable throwable6;
                                                    if (resultSet != null) {
                                                        try {
                                                            resultSet.close();
                                                            throwable6 = throwable;
                                                            throw throwable6;
                                                        }
                                                        catch (Throwable throwable7) {
                                                            throwable.addSuppressed(throwable7);
                                                        }
                                                    }
                                                    throwable6 = throwable;
                                                    throw throwable6;
                                                }
                                                resultSet.close();
                                                break block57;
                                            }
                                            mapleCharacter3 = mapleCharacter;
                                        }
                                        object = mapleCharacter3.prepareStatement(fc.ALLATORIxDEMO("\u0001R\u001eR\u0011Crd'zzv?x'y&>rQ\u0000X\u001f72s=y3c7wr`:r rrb!r y3z77o7m"));
                                        object.setString(1, string5);
                                        resultSet = object.executeQuery();
                                        try {
                                            if (resultSet.next()) {
                                                n4 = resultSet.getInt(SpecialItemData.ALLATORIxDEMO("@]^\u0000RE\\]]\\\u001a"));
                                            }
                                            if (resultSet == null) break block52;
                                            mapleCharacter2 = mapleCharacter;
                                        }
                                        catch (Throwable throwable) {
                                            Throwable throwable8;
                                            if (resultSet != null) {
                                                try {
                                                    resultSet.close();
                                                    throwable8 = throwable;
                                                    throw throwable8;
                                                }
                                                catch (Throwable throwable9) {
                                                    throwable.addSuppressed(throwable9);
                                                }
                                            }
                                            throwable8 = throwable;
                                            throw throwable8;
                                        }
                                        resultSet.close();
                                        break block58;
                                    }
                                    mapleCharacter2 = mapleCharacter;
                                }
                                object = mapleCharacter2.prepareStatement(fc.ALLATORIxDEMO("d7{7t&70v<y7s~70v<e7v!x<;rz3t!;rD7d!~=y;grq x?73t1x'y&dr`:r rr~67o7m"));
                                object.setInt(1, n14);
                                resultSet = object.executeQuery();
                                try {
                                    if (resultSet.next()) {
                                        bl5 = resultSet.getInt(SpecialItemData.ALLATORIxDEMO("JRF]MW")) == 2;
                                        bl4 = resultSet.getInt(fc.ALLATORIxDEMO("u3y<r6")) == 1 || resultSet.getInt(SpecialItemData.ALLATORIxDEMO("JRF]MW")) == 2;
                                        ResultSet resultSet4 = resultSet;
                                        string4 = resultSet4.getString(fc.ALLATORIxDEMO("0v<e7v!x<"));
                                        string7 = resultSet4.getString(SpecialItemData.ALLATORIxDEMO("ERK@"));
                                        string6 = resultSet4.getString(fc.ALLATORIxDEMO("\u0001r!d;x<~\""));
                                    }
                                    if (resultSet == null) break block53;
                                    object2 = object;
                                }
                                catch (Throwable throwable) {
                                    Throwable throwable10;
                                    if (resultSet != null) {
                                        try {
                                            resultSet.close();
                                            throwable10 = throwable;
                                            throw throwable10;
                                        }
                                        catch (Throwable throwable11) {
                                            throwable.addSuppressed(throwable11);
                                        }
                                    }
                                    throwable10 = throwable;
                                    throw throwable10;
                                }
                                resultSet.close();
                                break block59;
                            }
                            object2 = object;
                        }
                        object2.close();
                        if (mapleCharacter == null) break block54;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable12;
                        if (mapleCharacter != null) {
                            try {
                                mapleCharacter.close();
                                throwable12 = throwable;
                                throw throwable12;
                            }
                            catch (Throwable throwable13) {
                                throwable.addSuppressed(throwable13);
                            }
                        }
                        throwable12 = throwable;
                        throw throwable12;
                    }
                    mapleCharacter.close();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            if (string4 == null || string4.isEmpty()) {
                string4 = SpecialItemData.ALLATORIxDEMO("\u7112");
            }
            if (a2.isBannedIP(string6)) {
                bl3 = true;
            }
            if (a2.hasBannedMac()) {
                bl2 = true;
            }
            a2.getPlayer().dropMessage("[\u73a9\u5bb6\u540d\u7a31]:" + a32 + " [\u73a9\u5bb6\u7de8\u865f]:" + n11 + "[\u5e33\u865f\u7de8\u865f]:" + n14 + " [\u904a\u6232\u5e33\u865f]:" + string5);
            a2.getPlayer().dropMessage("[\u7b49\u7d1a]:" + n10 + " [\u6027\u5225]:" + n12 + " [\u8077\u696d]: " + MapleJob.getById(n3));
            a2.getPlayer().dropMessage("[\u64c1\u6709GASH]:" + n7 + " [\u6953\u8449\u9ede\u6578]:" + n6 + " [\u6953\u5e63]:" + n13 + " [\u5009\u5eab\u6953\u5e63]:" + n5 + "  ");
            a2.getPlayer().dropMessage("[\u8d0a\u52a9]: " + n4 + " \u5143 [" + GameSetConstants.POINT_NAME + "\u9ede\u6578]: " + n9 + " \u9ede [" + GameSetConstants.VPOINT_NAME + "\u9ede\u6578]: " + n8 + " \u9ede");
            MapleCharacter mapleCharacter = a2.getPlayer();
            if (bl4) {
                string3 = "\u662f";
                bl = bl5;
            } else {
                string3 = "\u5426";
                bl = bl5;
            }
            if (bl) {
                string2 = fc.ALLATORIxDEMO("?\u7ca9\u7d66\u81b8\u52c2\u5c53\u9381{");
                string = string4;
            } else {
                string2 = "";
                string = string4;
            }
            mapleCharacter.dropMessage("[\u662f\u5426\u88ab\u5c01\u9396]: " + string3 + string2 + ", \u539f\u56e0: " + string);
            a2.getPlayer().dropMessage("IP: " + string6 + " \u662f\u5426\u5728\u5c01\u9396IP\u540d\u55ae: " + (bl3 ? "\u662f" : "\u5426"));
            a2.getPlayer().dropMessage("[\u73a9\u5bb6IP\u5e95\u4e0b\u6240\u6709\u89d2\u8272]:" + a2.getIPstatus(a32, false));
            int n15 = 0;
            object = string7.split(SpecialItemData.ALLATORIxDEMO("\u0004\u0013"));
            int n16 = ((String[])object).length;
            int n17 = n2 = 0;
            while (n17 < n16) {
                String string8 = object[n2];
                if (n15 <= 5) {
                    String string9 = string8;
                    ++n15;
                    a2.getPlayer().dropMessage("MAC: " + string9 + " \u662f\u5426\u5728\u5c01\u9396MAC\u540d\u55ae: " + (a2.isBannedMac(string9) ? "\u662f" : "\u5426"));
                }
                n17 = ++n2;
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + fc.ALLATORIxDEMO("sD&v&b!7n\u73be\u5be4\u541a\u7a63)r:r\u67f2\u7759\u96f5\u7d88\u73be\u5be4\u72d7\u6119");
        }

        public /* synthetic */ Status() {
            Status a2;
        }
    }

    public static class ReloadCoupon
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Coupon.getInstance().reloadItems();
            return true;
        }

        public /* synthetic */ ReloadCoupon() {
            ReloadCoupon a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, ByteArrayByteStream.ALLATORIxDEMO("\u0016\u007fRAXLSnXXGBY\r\u001a\r\u91fa\u659d\u8f3e\u5148\u517b\u63f6\u520f\u7244\u54f6")).toString();
        }
    }

    public static class ReloadReward
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            RandomRewards.getInstance().ReloadItems();
            Coupon.getInstance().reloadItems();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, BankSystem.ALLATORIxDEMO("R%\u0016\u001b\u001c\u0016\u0017%\u0016\u0000\u0012\u0005\u0017W^W\u91be\u65c7\u8f7a\u5112\u5477\u7a59\u733d\u5282")).toString();
        }

        public /* synthetic */ ReloadReward() {
            ReloadReward a2;
        }
    }

    public static class ReloadGameSet
    extends CommandExecute {
        public /* synthetic */ ReloadGameSet() {
            ReloadGameSet a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, MerchItemPackage.ALLATORIxDEMO("\u0015~Q@[MPkUAQ\u007fQX\u0014\u0001\u0014\u91e1\u6584\u8f25\u5151\u9066\u6206\u8a01\u5bae")).toString();
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.loadsetting();
            GameSetConstants.reloadset();
            return true;
        }
    }

    public static class ReloadSkill
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"pK4u>x5J:p=uq4q\u91d4\u65e1\u8f10\u5134\u6299\u80ac")).toString();
        }

        public /* synthetic */ ReloadSkill() {
            ReloadSkill a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            SkillFactory.LoadSkillInformaion(true);
            return true;
        }
    }

    public static class ReloadGS
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, MapleSquad.ALLATORIxDEMO("4^p`zmqKF,8,\u91d8\u65bc\u8f1c\u5169\u4e15\u7566\u8ccb\u8f45\u86de\u6a53")).toString();
        }

        public /* synthetic */ ReloadGS() {
            ReloadGS a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GashaponSpecial.getInstance().reloadItems();
            return true;
        }
    }

    public static class ReloadItem
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleItemInformationProvider.getInstance().loadEtc(true);
            MapleItemInformationProvider.getInstance().loadItems(true);
            return true;
        }

        public /* synthetic */ ReloadItem() {
            ReloadItem a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, RandomAccessByteStream.ALLATORIxDEMO("$\u001f`!j,a\u0004q(hm(m\u91c8\u65fd\u8f0c\u5128\u726c\u548c")).toString();
        }
    }

    public static class ReloadMonster
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleLifeFactory.reloadMonster();
            return true;
        }

        public /* synthetic */ ReloadMonster() {
            ReloadMonster a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, EmojiFilter.ALLATORIxDEMO("mQ)o#b(N#m?w)ql.l\u91ce\u65fc\u8f0a\u5129\u6029\u7225")).toString();
        }
    }

    public static class ReloadGashapon
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, SpecialItemData.ALLATORIxDEMO("\u0012ZVD\\IWoR[[ICG]\b\u001e\b\u91fe\u6598\u8f3a\u514d\u8f7a\u86e3\u6a6c")).toString();
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GashaponFactory.getInstance().reloadGashapons();
            return true;
        }

        public /* synthetic */ ReloadGashapon() {
            ReloadGashapon a2;
        }
    }

    public static class setExRate
    extends CommandExecute {
        public /* synthetic */ setExRate() {
            setExRate a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleDiseaseValueHolder.ALLATORIxDEMO("P\u0012W2[%B\u0003FW\u001f\u7de4\u9a74X\u63aa\u5b81\f\u6924\u5e40I\u0003K\u502e\u73f0\u001dW\u000eW\u986e\u5961\u502e\u73f0\u76d7\u63d2\u8a0e\u7f19");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a3[1];
            int n2 = Integer.parseInt(a3[2]);
            if (((String)a3).equals(GashaponRewardSpecial.ALLATORIxDEMO("\u7d97\u9a70"))) {
                Iterator<ChannelServer> iterator;
                Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
                while (iterator2.hasNext()) {
                    ChannelServer channelServer;
                    ChannelServer channelServer2 = channelServer = iterator.next();
                    channelServer2.setExExpRate(n2);
                    channelServer2.broadcastPacket(MaplePacketCreator.getItemNotice("\u7d93\u9a57\u500d\u7387\u5df2\u7d93\u6210\u529f\u4fee\u6539\u70ba " + n2 + "\u500d\u3002\u795d\u5927\u5bb6\u904a\u6232\u958b\u5fc3\uff01"));
                    iterator2 = iterator;
                }
            } else if (((String)a3).equals(MapleDiseaseValueHolder.ALLATORIxDEMO("\u63aa\u5b81"))) {
                Iterator<ChannelServer> iterator;
                Iterator<ChannelServer> iterator3 = iterator = ChannelServer.getAllChannelInstances().iterator();
                while (iterator3.hasNext()) {
                    ChannelServer channelServer;
                    ChannelServer channelServer3 = channelServer = iterator.next();
                    channelServer3.setExDropRate(n2);
                    channelServer3.broadcastPacket(MaplePacketCreator.getItemNotice("\u6389\u5bf6\u500d\u7387\u5df2\u7d93\u6210\u529f\u4fee\u6539\u70ba " + n2 + "\u500d\u3002\u795d\u5927\u5bb6\u904a\u6232\u958b\u5fc3\uff01"));
                    iterator3 = iterator;
                }
            } else if (((String)a3).equals(GashaponRewardSpecial.ALLATORIxDEMO("\u6957\u5e44"))) {
                Iterator<ChannelServer> iterator;
                Iterator<ChannelServer> iterator4 = iterator = ChannelServer.getAllChannelInstances().iterator();
                while (iterator4.hasNext()) {
                    ChannelServer channelServer;
                    ChannelServer channelServer4 = channelServer = iterator.next();
                    channelServer4.setExMesoRate(n2);
                    channelServer4.broadcastPacket(MaplePacketCreator.getItemNotice("\u6953\u5e63\u500d\u7387\u5df2\u7d93\u6210\u529f\u4fee\u6539\u70ba " + n2 + "\u500d\u3002\u795d\u5927\u5bb6\u904a\u6232\u958b\u5fc3\uff01"));
                    iterator4 = iterator;
                }
            } else {
                return false;
            }
            return true;
        }
    }

    public static class setRate
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + K.ALLATORIxDEMO("ipnG{a\u007f5&\u7d86\u9a4d:\u6393\u5be35\u6946\u5e79+:)\u5017\u7392$5&\u5213\u9402\u656d$575\u9857\u5903\u5017\u7392\u8a37\u7f7b2\u5b8f\u6658\u95c9\u9593<");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            MapleCharacter mapleCharacter = a2.getPlayer();
            if (((String[])a3).length > 3) {
                a3 = a3[1];
                int n3 = Integer.parseInt(a3[2]);
                n2 = Integer.parseInt(a3[3]);
                boolean bl = true;
                if (((String)a3).equals(DumpMapName.ALLATORIxDEMO("\u7da5\u9a04"))) {
                    Iterator<ChannelServer> iterator;
                    Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
                    while (iterator2.hasNext()) {
                        ChannelServer channelServer;
                        ChannelServer channelServer2 = channelServer = iterator.next();
                        channelServer2.setExExpRate(n3);
                        channelServer2.broadcastPacket(MaplePacketCreator.getItemNotice("\u7d93\u9a57\u500d\u7387\u5df2\u7d93\u6210\u529f\u4fee\u6539\u70ba " + n3 + "\u500d\u3002\u795d\u5927\u5bb6\u904a\u6232\u958b\u5fc3.\u7d93\u9a57\u500d\u7387\u5c07\u5728\u6642\u9593\u5230\u5f8c\u81ea\u52d5\u66f4\u6b63\uff01"));
                        iterator2 = iterator;
                    }
                } else if (((String)a3).equals(K.ALLATORIxDEMO("\u6393\u5be3"))) {
                    Iterator<ChannelServer> iterator;
                    Iterator<ChannelServer> iterator3 = iterator = ChannelServer.getAllChannelInstances().iterator();
                    while (iterator3.hasNext()) {
                        ChannelServer channelServer;
                        ChannelServer channelServer3 = channelServer = iterator.next();
                        channelServer3.setExDropRate(n3);
                        channelServer3.broadcastPacket(MaplePacketCreator.getItemNotice("\u6389\u5bf6\u500d\u7387\u5df2\u7d93\u6210\u529f\u4fee\u6539\u70ba " + n3 + "\u500d\u3002\u795d\u5927\u5bb6\u904a\u6232\u958b\u5fc3.\u6389\u5bf6\u500d\u7387\u5c07\u5728\u6642\u9593\u5230\u5f8c\u81ea\u52d5\u66f4\u6b63\uff01"));
                        iterator3 = iterator;
                    }
                } else if (((String)a3).equals(DumpMapName.ALLATORIxDEMO("\u6965\u5e30"))) {
                    Iterator<ChannelServer> iterator;
                    Iterator<ChannelServer> iterator4 = iterator = ChannelServer.getAllChannelInstances().iterator();
                    while (iterator4.hasNext()) {
                        ChannelServer channelServer;
                        ChannelServer channelServer4 = channelServer = iterator.next();
                        channelServer4.setExMesoRate(n3);
                        channelServer4.broadcastPacket(MaplePacketCreator.getItemNotice("\u6953\u5e63\u500d\u7387\u5df2\u7d93\u8abf\u6574\u70ba " + n3 + "\u500d\u3002\u795d\u5927\u5bb6\u904a\u6232\u958b\u5fc3.\u6953\u5e63\u500d\u7387\u5c07\u5728\u6642\u9593\u5230\u5f8c\u81ea\u52d5\u66f4\u6b63\uff01"));
                        iterator4 = iterator;
                    }
                } else {
                    bl = false;
                }
                if (!bl) {
                    return false;
                }
            } else {
                return false;
            }
            World.scheduleRateDelay((String)a3, n2);
            return true;
        }

        public /* synthetic */ setRate() {
            setRate a2;
        }
    }

    public static class unbanGuild
    extends CommandExecute {
        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            if (a.length < 2) {
                return false;
            }
            try {
                var3_5 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    var4_7 = a[1];
                    a = 0;
                    var5_9 = new LinkedList<String>();
                    var6_10 = new LinkedList<String>();
                    var7_11 = new LinkedList<String>();
                    var8_12 = var3_5.prepareStatement(CharacterTransfer.ALLATORIxDEMO("EcZcUr\u0016aCoZb_b\u0016`Di[&Qs_jRu\u0016Q~CdC\u0016hWkS&\u000b&\t"));
                    var8_12.setString(1, var4_7);
                    var9_13 = var8_12.executeQuery();
                    try {
                        while (var9_13.next()) {
                            a = var9_13.getInt(BBSHandler.ALLATORIxDEMO("DVJOGJG"));
                        }
                    }
                    catch (Throwable var10_17) {
                        if (var9_13 != null) {
                            try {
                                var9_13.close();
                                v0 = var10_17;
                                throw v0;
                            }
                            catch (Throwable var11_21) {
                                var10_17.addSuppressed(var11_21);
                            }
                        }
                        v0 = var10_17;
                        throw v0;
                    }
                }
                catch (Throwable var4_8) {
                    if (var3_5 != null) {
                        try {
                            var3_5.close();
                            v1 = var4_8;
                            throw v1;
                        }
                        catch (Throwable a) {
                            var4_8.addSuppressed(a);
                        }
                    }
                    v1 = var4_8;
                    throw v1;
                }
            }
            catch (SQLException var3_6) {
                a.getPlayer().dropMessage(6, CharacterTransfer.ALLATORIxDEMO("\u6301\u4ed2\u57f1\u887a\u5937\u6561"));
                return true;
            }
            if (var9_13 != null) {
                v2 = a;
                var9_13.close();
            } else {
                v2 = a;
            }
            if (v2 != 0) ** GOTO lbl-1000
            a.getPlayer().dropMessage(5, "\u516c\u6703[" + var4_7 + "]\u4e0d\u5b58\u5728");
            var9_14 = true;
            if (var3_5 == null) return var9_14;
            var3_5.close();
            return var9_14;
lbl-1000:
            // 1 sources

            {
                block31: {
                    var8_12 = var3_5.prepareStatement(CharacterTransfer.ALLATORIxDEMO("EcZcUr\u0016hWkS&PtYk\u0016e^gDgUrStE&aNsTs&Qs_jRoR&\u000b&\t"));
                    var8_12.setInt(1, a);
                    var9_13 = var8_12.executeQuery();
                    try {
                        while (var9_13.next()) {
                            var5_9.add(var9_13.getString(BBSHandler.ALLATORIxDEMO("MBNF")));
                        }
                        if (var9_13 == null) break block31;
                    }
                    catch (Throwable var10_18) {
                        if (var9_13 != null) {
                            try {
                                var9_13.close();
                                v3 = var10_18;
                                throw v3;
                            }
                            catch (Throwable var11_22) {
                                var10_18.addSuppressed(var11_22);
                            }
                        }
                        v3 = var10_18;
                        throw v3;
                    }
                    var9_13.close();
                }
                v4 = var9_15 = 0;
                while (v4 < var5_9.size()) {
                    var10_19 = (String)var5_9.get(var9_15);
                    if (MapleClient.Fullyunban(var10_19)) {
                        var6_10.add(var10_19);
                    } else {
                        var7_11.add(var10_19);
                    }
                    v4 = ++var9_15;
                }
                var9_16 = CharacterTransfer.ALLATORIxDEMO("\u6216\u52a9\u89e5\u5c37<\u0016");
                v5 = var10_20 = 0;
                while (v5 < var6_10.size()) {
                    v6 = var6_10.get(var10_20);
                    var9_16 = (String)var9_16 + (String)v6 + ", ";
                    v5 = ++var10_20;
                }
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)var9_16));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(BBSHandler.ALLATORIxDEMO("\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e")));
                var9_16 = CharacterTransfer.ALLATORIxDEMO("\u5937\u6561\u89e5\u5c37<\u0016");
                v7 = var10_20 = 0;
                while (v7 < var7_11.size()) {
                    v8 = var7_11.get(var10_20);
                    var9_16 = (String)var9_16 + (String)v8 + ", ";
                    v7 = ++var10_20;
                }
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)var9_16));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(BBSHandler.ALLATORIxDEMO("\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e\u000e")));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(CharacterTransfer.ALLATORIxDEMO("\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b+\u001b")));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] \u4e00\u5171\u6709" + var6_10.size() + "\u4eba\u89e3\u5c01," + var7_11.size() + "\u4eba\u89e3\u5c01\u5931\u6557\u3002"));
                FileoutputUtil.logToFile(BBSHandler.ALLATORIxDEMO("OLDP\fkB@H\f\u514f\u6720\u89c0\u5c22\u542e\u558d\rW[W"), "\r\n " + FileoutputUtil.CurrentReadable_TimeGMT() + " " + a.getPlayer().getName() + " \u89e3\u5c01\u4e86\u516c\u6703<" + var4_7 + ">");
                if (var3_5 == null) return true;
            }
            var3_5.close();
            return true;
        }

        public /* synthetic */ unbanGuild() {
            unbanGuild a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + BBSHandler.ALLATORIxDEMO("VMABMdVJOG\u0003\u001f\u514f\u6720\u542e\u7a12\u001d\u0003\u000e\u0003\u89c0\u5c22\u514f\u6720");
        }
    }

    public static class BanGuild
    extends CommandExecute {
        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            if (a /* !! */ .length < 3) {
                return false;
            }
            try {
                var3_4 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    var4_6 = a /* !! */ [1];
                    a /* !! */  = a /* !! */ [2];
                    var5_8 = 0;
                    var6_11 = new LinkedList<String>();
                    var7_12 = new LinkedList<String>();
                    var8_13 = new LinkedList<String>();
                    var9_14 = new LinkedList<String>();
                    var10_15 = new LinkedList<String>();
                    var11_16 = var3_4.prepareStatement(Instruction.ALLATORIxDEMO("\u0012\u007f\r\u007f\u0002nA}\u0014s\r~\b~A|\u0013u\f:\u0006o\bv\u0005iAM)_3_At\u0000w\u0004:\\:^"));
                    var11_16.setString(1, var4_6);
                    var12_17 = var11_16.executeQuery();
                    try {
                        while (var12_17.next()) {
                            var5_8 = var12_17.getInt(FixDropNullItem.ALLATORIxDEMO("!C/Z\"_\""));
                        }
                    }
                    catch (Throwable var13_21) {
                        if (var12_17 != null) {
                            try {
                                var12_17.close();
                                v0 = var13_21;
                                throw v0;
                            }
                            catch (Throwable var14_24) {
                                var13_21.addSuppressed(var14_24);
                            }
                        }
                        v0 = var13_21;
                        throw v0;
                    }
                }
                catch (Throwable var4_7) {
                    if (var3_4 != null) {
                        try {
                            var3_4.close();
                            v1 = var4_7;
                            throw v1;
                        }
                        catch (Throwable a) {
                            var4_7.addSuppressed(a);
                        }
                    }
                    v1 = var4_7;
                    throw v1;
                }
            }
            catch (SQLException var3_5) {
                a.getPlayer().dropMessage(6, FixDropNullItem.ALLATORIxDEMO("\u6331\u4ea2\u57c1\u880a\u5907\u6511"));
                return true;
            }
            if (var12_17 != null) {
                v2 = var5_8;
                var12_17.close();
            } else {
                v2 = var5_8;
            }
            if (v2 != 0) ** GOTO lbl-1000
            a.getPlayer().dropMessage(5, "\u516c\u6703[" + var4_6 + "]\u4e0d\u5b58\u5728");
            var12_18 = true;
            if (var3_4 == null) return var12_18;
            var3_4.close();
            return var12_18;
lbl-1000:
            // 1 sources

            {
                block41: {
                    var11_16 = var3_4.prepareStatement(Instruction.ALLATORIxDEMO("\u0012\u007f\r\u007f\u0002nAt\u0000w\u0004:\u0007h\u000ewAy\t{\u0013{\u0002n\u0004h\u0012:6R$H$:\u0006o\bv\u0005s\u0005:\\:^"));
                    var11_16.setInt(1, var5_8);
                    var12_17 = var11_16.executeQuery();
                    try {
                        while (var12_17.next()) {
                            var6_11.add(var12_17.getString(FixDropNullItem.ALLATORIxDEMO("X'[#")));
                        }
                        if (var12_17 == null) break block41;
                    }
                    catch (Throwable var13_22) {
                        if (var12_17 != null) {
                            try {
                                var12_17.close();
                                v3 = var13_22;
                                throw v3;
                            }
                            catch (Throwable var14_25) {
                                var13_22.addSuppressed(var14_25);
                            }
                        }
                        v3 = var13_22;
                        throw v3;
                    }
                    var12_17.close();
                }
                v4 = var12_19 = 0;
                while (v4 < var6_11.size()) {
                    var13_23 = World.Find.findChannel((String)var6_11.get(var12_19));
                    var14_26 = World.Find.findWorld((String)var6_11.get(var12_19));
                    var5_9 = (String)var6_11.get(var12_19);
                    if (var13_23 <= 0) {
                        var11_16 = MapleCharacter.getCharacterByName(var5_9);
                        if (var11_16 != null && var11_16.getGMLevel() == 0) {
                            if (a.getPlayer().OfflineBanByName(var5_9, (String)a /* !! */ )) {
                                var7_12.add(var5_9);
                            } else {
                                var8_13.add(var5_9);
                            }
                        }
                    } else {
                        try {
                            var11_16 = ChannelServer.getInstance(var14_26, var13_23).getPlayerStorage().getCharacterByName(var5_9);
                            if (var11_16 != null && var11_16.getGMLevel() == 0) {
                                if (var11_16.ban((String)a /* !! */ , true, false, false)) {
                                    var11_16.getClient().getSession().close();
                                    var11_16.getClient().disconnect();
                                    var9_14.add(var5_9);
                                } else {
                                    var10_15.add(var5_9);
                                }
                            }
                        }
                        catch (Exception var5_10) {
                            // empty catch block
                        }
                    }
                    v4 = ++var12_19;
                }
                var12_20 = Instruction.ALLATORIxDEMO("\u620a\u52fe\u5732\u7dbb\u5c1b\u93f7 A");
                var13_23 = var7_12.size() + var9_14.size();
                v5 = var14_26 = 0;
                while (v5 < var9_14.size()) {
                    v6 = var9_14.get(var14_26);
                    var12_20 = (String)var12_20 + (String)v6 + ", ";
                    v5 = ++var14_26;
                }
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)var12_20));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(FixDropNullItem.ALLATORIxDEMO("k\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk")));
                var12_20 = Instruction.ALLATORIxDEMO("\u620a\u52fe\u96f8\u7dbb\u5c1b\u93f7 A");
                v7 = var14_26 = 0;
                while (v7 < var7_12.size()) {
                    v8 = var7_12.get(var14_26);
                    var12_20 = (String)var12_20 + (String)v8 + ", ";
                    v7 = ++var14_26;
                }
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)var12_20));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(FixDropNullItem.ALLATORIxDEMO("k\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk")));
                var12_20 = Instruction.ALLATORIxDEMO("\u592b\u6536\u5732\u7dbb\u5c1b\u93f7 A");
                v9 = var14_26 = 0;
                while (v9 < var10_15.size()) {
                    v10 = var10_15.get(var14_26);
                    var12_20 = (String)var12_20 + (String)v10 + ", ";
                    v9 = ++var14_26;
                }
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)var12_20));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(FixDropNullItem.ALLATORIxDEMO("k\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk")));
                var12_20 = Instruction.ALLATORIxDEMO("\u592b\u6536\u96f8\u7dbb\u5c1b\u93f7 A");
                v11 = var14_26 = 0;
                while (v11 < var8_13.size()) {
                    v12 = var8_13.get(var14_26);
                    var12_20 = (String)var12_20 + (String)v12 + ", ";
                    v11 = ++var14_26;
                }
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)var12_20));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(FixDropNullItem.ALLATORIxDEMO("k\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk\u001bk")));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] \u4e00\u5171\u6709" + var13_23 + "\u4eba\u906d\u5230\u5c01\u9396," + (var10_15.size() + var8_13.size()) + "\u4eba\u5c01\u9396\u5931\u6557\u3002"));
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] \u516c\u6703<" + var4_6 + "> \u56e0\u70ba\u8cc7\u6599\u7570\u5e38\u800c\u88ab\u7ba1\u7406\u54e1\u66ab\u6642\u95dc\u9589\u67e5\u8a62\u3002"));
                FileoutputUtil.logToFile(Instruction.ALLATORIxDEMO("v\u000e}\u00125){\u0002qN\u5176\u6762\u5c1b\u93f7\u5417\u55cf4\u0015b\u0015"), "\r\n " + FileoutputUtil.CurrentReadable_TimeGMT() + " " + a.getPlayer().getName() + " \u5c01\u9396\u4e86\u516c\u6703<" + var4_6 + "> \u539f\u56e0: " + (String)a /* !! */ );
                if (var3_4 == null) return true;
            }
            var3_4.close();
            return true;
        }

        public /* synthetic */ BanGuild() {
            BanGuild a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + Instruction.ALLATORIxDEMO("#{\u000f]\u0014s\r~A&\u510d\u6719\u546c\u7a2b_:]\u5385\u5681$A7A\u5c1b\u93f7\u5176\u6762");
        }
    }

    public static class ResetMobs
    extends CommandExecute {
        public /* synthetic */ ResetMobs() {
            ResetMobs a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + HiredMerchantHandler.ALLATORIxDEMO("|\u0011}\u0011z\u0019a\u0016}T#T\u91c3\u7f1a\u573e\u5762\u4e04\u6234\u6707\u605e\u7267");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getMap().killAllMonsters(false);
            return true;
        }
    }

    public static class GiveAllMP
    extends CommandExecute {
        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        public /* synthetic */ HashMap<Integer, Integer> getOfflineAcc() {
            hashMap = new HashMap<Integer, Integer>();
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            preparedStatement = druidPooledConnection.prepareStatement(AutoPickupSystem.ALLATORIxDEMO("\u0014M\u000bM\u0004\\ga#$ge\u0017g.f3{gN\u0015G\n(&k$g2f3{g_\u000fM\u0015Mgd(o m#a)(z(w"));
            v0 = resultSet = preparedStatement.executeQuery();
            while (v0.next()) {
                v1 = resultSet;
                v0 = v1;
                hashMap.put(resultSet.getInt(PracticerCommand.ALLATORIxDEMO("n\u001f")), v1.getInt(AutoPickupSystem.ALLATORIxDEMO("*X(a)|4")));
            }
            resultSet.close();
            preparedStatement.close();
            ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
            // 1 sources

            {
                druidPooledConnection.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            {
                catch (Throwable throwable) {
                    try {
                        block12: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    v2 = throwable;
                                    break block12;
                                }
                                catch (Throwable throwable3) {
                                    throwable.addSuppressed(throwable3);
                                }
                            }
                            v2 = throwable;
                        }
                        throw v2;
                    }
                    catch (Exception exception) {
                        System.err.println("getOfflineAcc \u51fa\u73fe\u554f\u984c(DB):" + exception);
                    }
                }
            }
            return hashMap;
        }

        @Override
        public /* synthetic */ String getMessage() {
            GiveAllMP a2;
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + a2.getClass().getSimpleName().toLowerCase() + PracticerCommand.ALLATORIxDEMO("[;\u6503\u91c8E'V'\u7d1d\u4e8f\u9699\u7ddd\u53b1\u7ddd\u4e71\u7683\u4ec1\u6954\u8432\u9ed9\u6503");
        }

        public /* synthetic */ GiveAllMP() {
            GiveAllMP a2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            int n3;
            block13: {
                GiveAllMP a4;
                DruidPooledConnection druidPooledConnection;
                if (a3.length < 2) {
                    return false;
                }
                n3 = 0;
                n2 = 0;
                try {
                    n3 = Integer.parseInt(a3[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
                for (ChannelServer channelServer : ChannelServer.getAllChannelInstances()) {
                    DruidPooledConnection druidPooledConnection2 = channelServer.getPlayerStorage().getAllCharactersThreadSafe().iterator();
                    while (druidPooledConnection2.hasNext()) {
                        ++n2;
                        MapleCharacter mapleCharacter = (MapleCharacter)druidPooledConnection.next();
                        mapleCharacter.modifyCSPoints(2, n3, true);
                        a2.getPlayer().dropMessage("[\u5728\u7dda] \u73a9\u5bb6<" + mapleCharacter.getName() + "> Lv." + mapleCharacter.getLevel() + " \u5730\u5716<" + mapleCharacter.getMap().getMapName() + "> \u767c\u653e\u9ede\u6578[" + n3 + "] \u767c\u653e\u5f8c\u9ede\u6578[" + mapleCharacter.getCSPoints(2) + "]");
                        druidPooledConnection2 = druidPooledConnection;
                    }
                }
                Map.Entry entry2 = a4.getOfflineAcc();
                Object var6_9 = null;
                druidPooledConnection = null;
                boolean bl = true;
                try {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        for (Map.Entry entry2 : ((HashMap)((Object)entry2)).entrySet()) {
                            String string = "UPDATE accounts SET mPoints = " + ((Integer)entry2.getValue() + n3) + " where id = " + entry2.getKey();
                            PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(string);
                            preparedStatement.execute();
                            preparedStatement.close();
                            ++n2;
                            a2.getPlayer().dropMessage("[\u96e2\u7dda] \u5e33\u865f\u7de8\u865f<" + entry2.getKey() + "> \u767c\u653e\u9ede\u6578[" + n3 + "] \u767c\u653e\u5f8c\u9ede\u6578[" + ((Integer)entry2.getValue() + n3) + "]");
                        }
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
                    // empty catch block
                }
            }
            int n4 = n2;
            a2.getPlayer().dropMessage("\u5171\u767c\u653e\u4e86" + n4 + "\u500b\u5e33\u865f, \u4e00\u5171\u70ba" + n4 * n3 + "\u9ede");
            int n5 = n2;
            FileoutputUtil.logToFile(PracticerCommand.ALLATORIxDEMO("k\u0014`\b(?f\u000ffT\u9ed9\u6503\u6300\u4e9f)\u000f\u007f\u000f"), "\r\n " + FileoutputUtil.CurrentReadable_Time() + " <" + a2.getPlayer().getName() + "> \u4f7f\u7528\u4e86" + a3[0] + " \u5171\u767c\u653e\u4e86" + n5 + "\u500b\u5e33\u865f, \u4e00\u5171\u70ba" + n5 * n3 + " \u6953\u9ede");
            return true;
        }
    }

    public static class GiveAllCash
    extends CommandExecute {
        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        public /* synthetic */ HashMap<Integer, Integer> getOfflineAcc() {
            hashMap = new HashMap<Integer, Integer>();
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            preparedStatement = druidPooledConnection.prepareStatement(SellSystem.ALLATORIxDEMO("<0#0,!O\u001c\u000bYO4\f\u0014\u001c\u001dO3=:\"U\u000e\u0016\f\u001a\u001a\u001b\u001b\u0006O\"'0=0O\u0019\u0000\u0012\b\u0010\u000b\u001c\u0001URU_"));
            v0 = resultSet = preparedStatement.executeQuery();
            while (v0.next()) {
                v1 = resultSet;
                v0 = v1;
                hashMap.put(resultSet.getInt(MapConstants.ALLATORIxDEMO("\u0012|")), v1.getInt(SellSystem.ALLATORIxDEMO(".\u0016\u000e\u0006\u0007")));
            }
            resultSet.close();
            preparedStatement.close();
            ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
            // 1 sources

            {
                druidPooledConnection.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            {
                catch (Throwable throwable) {
                    try {
                        block12: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    v2 = throwable;
                                    break block12;
                                }
                                catch (Throwable throwable3) {
                                    throwable.addSuppressed(throwable3);
                                }
                            }
                            v2 = throwable;
                        }
                        throw v2;
                    }
                    catch (Exception exception) {
                        System.err.println("getOfflineAcc \u51fa\u73fe\u554f\u984c(DB):" + exception);
                    }
                }
            }
            return hashMap;
        }

        @Override
        public /* synthetic */ String getMessage() {
            GiveAllCash a2;
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + a2.getClass().getSimpleName().toLowerCase() + MapConstants.ALLATORIxDEMO("8G\u6560\u91b4&[5[\u7d7e\u4ef3\u96fa\u7da1\u53d2\u7da1\u4e12\u76ff\u4ea2<y\bp");
        }

        public /* synthetic */ GiveAllCash() {
            GiveAllCash a2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            int n3;
            block14: {
                GiveAllCash a4;
                DruidPooledConnection druidPooledConnection;
                if (a3.length < 2) {
                    return false;
                }
                if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                    a2.getPlayer().dropMessage(5, SellSystem.ALLATORIxDEMO("\u6b65\u9625\u4e62\u8dc6N"));
                    return false;
                }
                n3 = 0;
                n2 = 0;
                try {
                    n3 = Integer.parseInt(a3[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
                for (ChannelServer channelServer : ChannelServer.getAllChannelInstances()) {
                    DruidPooledConnection druidPooledConnection2 = channelServer.getPlayerStorage().getAllCharactersThreadSafe().iterator();
                    while (druidPooledConnection2.hasNext()) {
                        ++n2;
                        MapleCharacter mapleCharacter = (MapleCharacter)druidPooledConnection.next();
                        mapleCharacter.modifyCSPoints(true ? 1 : 0, n3, true);
                        a2.getPlayer().dropMessage("[\u5728\u7dda] \u73a9\u5bb6<" + mapleCharacter.getName() + "> Lv." + mapleCharacter.getLevel() + " \u5730\u5716<" + mapleCharacter.getMap().getMapName() + "> \u767c\u653e\u9ede\u6578[" + n3 + "] \u767c\u653e\u5f8c\u9ede\u6578[" + mapleCharacter.getCSPoints(1) + "]");
                        druidPooledConnection2 = druidPooledConnection;
                    }
                }
                Map.Entry entry2 = a4.getOfflineAcc();
                Object var6_9 = null;
                druidPooledConnection = null;
                boolean bl = true;
                try {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        for (Map.Entry entry2 : ((HashMap)((Object)entry2)).entrySet()) {
                            String string = "UPDATE accounts SET Acash = " + ((Integer)entry2.getValue() + n3) + " where id = " + entry2.getKey();
                            PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(string);
                            preparedStatement.execute();
                            preparedStatement.close();
                            ++n2;
                            a2.getPlayer().dropMessage("[\u96e2\u7dda] \u5e33\u865f\u7de8\u865f<" + entry2.getKey() + "> \u767c\u653e\u9ede\u6578[" + n3 + "] \u767c\u653e\u5f8c\u9ede\u6578[" + ((Integer)entry2.getValue() + n3) + "]");
                        }
                        if (druidPooledConnection == null) break block14;
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
                    // empty catch block
                }
            }
            int n4 = n2;
            a2.getPlayer().dropMessage("\u5171\u767c\u653e\u4e86" + n4 + "\u500b\u5e33\u865f, \u4e00\u5171\u70ba" + n4 * n3 + "\u9ede");
            int n5 = n2;
            FileoutputUtil.logToFile(MapConstants.ALLATORIxDEMO("7w\u001ckT\\\u001al\u001a7\u9ea5\u6560\u637c\u4efcUl\u0003l"), "\r\n " + FileoutputUtil.CurrentReadable_Time() + " <" + a2.getPlayer().getName() + "> \u4f7f\u7528\u4e86" + a3[0] + " \u5171\u767c\u653e\u4e86" + n5 + "\u500b\u5e33\u865f, \u4e00\u5171\u70ba" + n5 * n3 + " GASH\u9ede");
            return true;
        }
    }

    public static class ProItem
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            int n2;
            if (a322.length < 3) {
                return false;
            }
            int n3 = 0;
            boolean bl = true;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = 0;
            int n10 = 0;
            int n11 = 0;
            int n12 = 0;
            int n13 = 0;
            int n14 = 0;
            int n15 = 0;
            int n16 = 0;
            int n17 = 0;
            int n18 = 0;
            int n19 = 0;
            int n20 = 0;
            try {
                int n21 = 1;
                n3 = Integer.parseInt(a322[n21]);
                n4 = Integer.parseInt(a322[++n21]);
                n5 = Integer.parseInt(a322[++n21]);
                n6 = Integer.parseInt(a322[++n21]);
                n7 = Integer.parseInt(a322[++n21]);
                n8 = Integer.parseInt(a322[++n21]);
                n9 = Integer.parseInt(a322[++n21]);
                n10 = Integer.parseInt(a322[++n21]);
                n11 = Integer.parseInt(a322[++n21]);
                n12 = Integer.parseInt(a322[++n21]);
                n13 = Integer.parseInt(a322[++n21]);
                n15 = Integer.parseInt(a322[++n21]);
                n16 = Integer.parseInt(a322[++n21]);
                n17 = Integer.parseInt(a322[++n21]);
                n19 = Integer.parseInt(a322[++n21]);
                n18 = Integer.parseInt(a322[++n21]);
                n14 = Integer.parseInt(a322[++n21]);
                int n22 = Integer.parseInt(a322[++n21]);
                ++n21;
                n20 = n22;
                n2 = n4;
            }
            catch (Exception exception) {
                n2 = n4;
            }
            boolean bl2 = n2 != 0;
            boolean a322 = n6 != 0;
            boolean bl3 = n5 != 0;
            boolean bl4 = n7 != 0;
            boolean bl5 = n8 != 0;
            boolean bl6 = n9 != 0;
            boolean bl7 = n10 != 0;
            boolean bl8 = n11 != 0;
            boolean bl9 = n12 != 0;
            boolean bl10 = n13 != 0;
            boolean bl11 = true;
            boolean bl12 = n15 != 0;
            boolean bl13 = n16 != 0;
            boolean bl14 = n17 != 0;
            boolean bl15 = n18 != 0;
            boolean bl16 = n19 != 0;
            boolean bl17 = n20 != 0;
            Object object = MapleItemInformationProvider.getInstance();
            if (GameConstants.isPet(n3)) {
                a2.getPlayer().dropMessage(5, MonsterGlobalDropEntry.ALLATORIxDEMO("\u8aa5\u5fa4\u5528\u57f4\u8c92\u8c8d\u5b9b\u7253@"));
                return true;
            }
            if (!((MapleItemInformationProvider)object).itemExists(n3)) {
                a2.getPlayer().dropMessage(5, n3 + " \u4e0d\u5b58\u5728");
                return true;
            }
            if (GameConstants.getInventoryType(n3) == MapleInventoryType.EQUIP) {
                MapleItemInformationProvider mapleItemInformationProvider = object;
                object = mapleItemInformationProvider.randomizeStats((Equip)mapleItemInformationProvider.getEquipById(n3));
                ((client.inventory.Item)object).setGMLog(a2.getPlayer().getName() + " \u4f7f\u7528 !Proitem");
                if (bl2) {
                    ((Equip)object).setStr((short)n4);
                }
                if (bl4) {
                    ((Equip)object).setLuk((short)n7);
                }
                if (bl3) {
                    ((Equip)object).setDex((short)n5);
                }
                if (a322) {
                    ((Equip)object).setInt((short)n6);
                }
                if (bl5) {
                    ((Equip)object).setHp((short)n8);
                }
                if (bl6) {
                    ((Equip)object).setMp((short)n9);
                }
                if (bl7) {
                    ((Equip)object).setWatk((short)n10);
                }
                if (bl8) {
                    ((Equip)object).setMatk((short)n11);
                }
                if (bl9) {
                    ((Equip)object).setWdef((short)n12);
                }
                if (bl10) {
                    ((Equip)object).setMdef((short)n13);
                }
                if (bl13) {
                    ((Equip)object).setAcc((short)n16);
                }
                if (bl14) {
                    ((Equip)object).setAvoid((short)n17);
                }
                if (bl11) {
                    ((Equip)object).setUpgradeSlots((byte)n14);
                }
                if (bl12) {
                    ((Equip)object).setLevel((byte)n15);
                }
                if (bl15) {
                    ((Equip)object).setJump((short)n18);
                }
                if (bl16) {
                    ((Equip)object).setSpeed((short)n19);
                }
                if (bl17) {
                    ((client.inventory.Item)object).setExpiration(System.currentTimeMillis() + (long)(n20 * 24 * 60 * 60 * 1000));
                }
                MapleInventoryManipulator.addbyItem(a2, (IItem)object);
            } else {
                client.inventory.Item a322 = new client.inventory.Item(n3, 0, (short)(bl ? 1 : 0), 0);
                a322.setGMLog(a2.getPlayer().getName() + " \u4f7f\u7528 !ProItem");
                MapleInventoryManipulator.addbyItem(a2, a322);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MTSCSPacket.ALLATORIxDEMO("uXJcQOH\n\u0019\u7243\u54e4\u4ec9\u7899\u0014\u0005\u0002\u0019\u52b1\u91ea\u0014\u0005\u0016\u656a\u635d\u001b\n\u0019\u6650\u52be\u0014\u0005\u0016\u5e5d\u9061\u001b\n\u0019bu\u0014\u0005\u0016hz\u001b\n\u0019\u7243\u651e\u0014\u0005\u0016\u9b71\u6511\u001b\n\u0019\u7243\u9617\u0014\u0005\u0016\u9b71\u9618\u001b\n\u0019\u6b4c\u564d\u0001]\u0014\u0005\u0016\u5458\u4e07\u001b\n\u0019\u8fde\u905a\u0014\u0005\u0016\u79de\u52ff\u001b\n\u0019\u8dd9\u8ea8\u0014\u0005\u0016\u8878\u6358\u655d\u0014\u0005\u0016\u590c\u6552\u001b\u0003");
        }

        public /* synthetic */ ProItem() {
            ProItem a2;
        }
    }

    public static class ProDrop
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            int n2;
            if (a322.length < 3) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, FixDropNullItem.ALLATORIxDEMO("\u6b4c\u9666\u4e4b\u8d85g"));
                return false;
            }
            int n3 = 0;
            boolean bl = true;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = 0;
            int n10 = 0;
            int n11 = 0;
            int n12 = 0;
            int n13 = 0;
            int n14 = 0;
            int n15 = 0;
            int n16 = 0;
            int n17 = 0;
            int n18 = 0;
            int n19 = 0;
            int n20 = 0;
            try {
                int n21 = 1;
                n3 = Integer.parseInt(a322[n21]);
                n4 = Integer.parseInt(a322[++n21]);
                n5 = Integer.parseInt(a322[++n21]);
                n6 = Integer.parseInt(a322[++n21]);
                n7 = Integer.parseInt(a322[++n21]);
                n8 = Integer.parseInt(a322[++n21]);
                n9 = Integer.parseInt(a322[++n21]);
                n10 = Integer.parseInt(a322[++n21]);
                n11 = Integer.parseInt(a322[++n21]);
                n12 = Integer.parseInt(a322[++n21]);
                n13 = Integer.parseInt(a322[++n21]);
                n15 = Integer.parseInt(a322[++n21]);
                n16 = Integer.parseInt(a322[++n21]);
                n17 = Integer.parseInt(a322[++n21]);
                n19 = Integer.parseInt(a322[++n21]);
                n18 = Integer.parseInt(a322[++n21]);
                n14 = Integer.parseInt(a322[++n21]);
                int n22 = Integer.parseInt(a322[++n21]);
                ++n21;
                n20 = n22;
                n2 = n4;
            }
            catch (Exception exception) {
                n2 = n4;
            }
            boolean bl2 = n2 != 0;
            boolean a322 = n6 != 0;
            boolean bl3 = n5 != 0;
            boolean bl4 = n7 != 0;
            boolean bl5 = n8 != 0;
            boolean bl6 = n9 != 0;
            boolean bl7 = n10 != 0;
            boolean bl8 = n11 != 0;
            boolean bl9 = n12 != 0;
            boolean bl10 = n13 != 0;
            boolean bl11 = true;
            boolean bl12 = n15 != 0;
            boolean bl13 = n16 != 0;
            boolean bl14 = n17 != 0;
            boolean bl15 = n18 != 0;
            boolean bl16 = n19 != 0;
            boolean bl17 = n20 != 0;
            Object object = MapleItemInformationProvider.getInstance();
            if (GameConstants.isPet(n3)) {
                a2.getPlayer().dropMessage(5, PartyHandler.ALLATORIxDEMO("\u8aa8\u5fc6\u5525\u5796\u8c9f\u8cef\u5b96\u7231M"));
                return true;
            }
            if (!((MapleItemInformationProvider)object).itemExists(n3)) {
                a2.getPlayer().dropMessage(5, n3 + " \u4e0d\u5b58\u5728");
                return true;
            }
            if (GameConstants.getInventoryType(n3) == MapleInventoryType.EQUIP) {
                MapleItemInformationProvider mapleItemInformationProvider = object;
                object = mapleItemInformationProvider.randomizeStats((Equip)mapleItemInformationProvider.getEquipById(n3));
                ((client.inventory.Item)object).setGMLog(a2.getPlayer().getName() + " \u4f7f\u7528 !Prodrop");
                if (bl2) {
                    ((Equip)object).setStr((short)n4);
                }
                if (bl4) {
                    ((Equip)object).setLuk((short)n7);
                }
                if (bl3) {
                    ((Equip)object).setDex((short)n5);
                }
                if (a322) {
                    ((Equip)object).setInt((short)n6);
                }
                if (bl5) {
                    ((Equip)object).setHp((short)n8);
                }
                if (bl6) {
                    ((Equip)object).setMp((short)n9);
                }
                if (bl7) {
                    ((Equip)object).setWatk((short)n10);
                }
                if (bl8) {
                    ((Equip)object).setMatk((short)n11);
                }
                if (bl9) {
                    ((Equip)object).setWdef((short)n12);
                }
                if (bl10) {
                    ((Equip)object).setMdef((short)n13);
                }
                if (bl13) {
                    ((Equip)object).setAcc((short)n16);
                }
                if (bl14) {
                    ((Equip)object).setAvoid((short)n17);
                }
                if (bl11) {
                    ((Equip)object).setUpgradeSlots((byte)n14);
                }
                if (bl12) {
                    ((Equip)object).setLevel((byte)n15);
                }
                if (bl15) {
                    ((Equip)object).setJump((short)n18);
                }
                if (bl16) {
                    ((Equip)object).setSpeed((short)n19);
                }
                if (bl17) {
                    ((client.inventory.Item)object).setExpiration(System.currentTimeMillis() + (long)(n20 * 24 * 60 * 60 * 1000));
                }
                ((client.inventory.Item)object).setOwner(a2.getPlayer().getName());
                a2.getPlayer().getMap().spawnItemDrop(a2.getPlayer(), a2.getPlayer(), (IItem)object, a2.getPlayer().getPosition(), true, true);
            } else {
                client.inventory.Item a322 = new client.inventory.Item(n3, 0, (short)(bl ? 1 : 0), 0);
                a322.setGMLog(a2.getPlayer().getName() + " \u4f7f\u7528 !Prodrop");
                if (GameSetConstants.GM_OWNNAME) {
                    a322.setOwner(a2.getPlayer().getName());
                }
                a2.getPlayer().getMap().spawnItemDrop(a2.getPlayer(), a2.getPlayer(), a322, a2.getPlayer().getPosition(), true, true);
            }
            return true;
        }

        public /* synthetic */ ProDrop() {
            ProDrop a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + FixDropNullItem.ALLATORIxDEMO("f4Y\u0002D)Ff\n\u722f\u54f7\u4ea5\u788ax\u0016n\n\u52dd\u91f9x\u0016z\u6579\u6331\bf\n\u663c\u52adx\u0016z\u5e4e\u900d\bf\n\u000efx\u0016z{\u0016\bf\n\u722f\u650dx\u0016z\u9b62\u657d\bf\n\u722f\u9604x\u0016z\u9b62\u9674\bf\n\u6b20\u565emNx\u0016z\u544b\u4e6b\bf\n\u8fb2\u9049x\u0016z\u79cd\u5293\bf\n\u8db5\u8ebbx\u0016z\u886b\u6334\u654ex\u0016z\u591f\u653e\bo");
        }
    }

    public static class Drop
    extends CommandExecute {
        public /* synthetic */ Drop() {
            Drop a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + getHtml.ALLATORIxDEMO("/x\u0004zK6\u9038\u517d\"NU*F*\u63e2\u8437\u9038\u517d");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            String[] arrstring;
            if (((String[])a322).length < 2) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, getHtml.ALLATORIxDEMO("\u6b00\u963b\u4e07\u8dd8+"));
                return false;
            }
            int n2 = 0;
            String string = null;
            try {
                n2 = Integer.parseInt(a322[1]);
                string = a322[3];
                arrstring = a322;
            }
            catch (Exception exception) {
                arrstring = a322;
            }
            short s2 = (short)CommandProcessorUtil.getOptionalIntArg(arrstring, 2, 1);
            a322 = MapleItemInformationProvider.getInstance();
            if (GameConstants.isPet(n2)) {
                a2.getPlayer().dropMessage(5, \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u5bcc\u7267\u8af2\u523e\u8cc5\u7267\u557f\u57c0\u8cc5\u8cb9\u0017"));
            } else if (!((MapleItemInformationProvider)a322).itemExists(n2)) {
                a2.getPlayer().dropMessage(5, n2 + " - \u7269\u54c1\u4e0d\u5b58\u5728");
            } else {
                client.inventory.Item item2;
                if (GameConstants.getInventoryType(n2) == MapleInventoryType.EQUIP) {
                    Object object = a322;
                    item2 = ((MapleItemInformationProvider)object).randomizeStats((Equip)((MapleItemInformationProvider)object).getEquipById(n2));
                } else {
                    item2 = new client.inventory.Item(n2, 0, s2, 0);
                }
                if (GameSetConstants.GM_OWNNAME) {
                    item2.setOwner(a2.getPlayer().getName());
                }
                item2.setGMLog(a2.getPlayer().getName());
                if (string != null) {
                    String string2 = string;
                    int a322 = World.Find.findChannel(string2);
                    int n3 = World.Find.findWorld(string2);
                    if (a322 > 0) {
                        MapleCharacter a322 = ChannelServer.getInstance(n3, a322).getPlayerStorage().getCharacterByName(string);
                        if (a322 != null) {
                            item2 = new client.inventory.Item(n2, 0, 1, 0);
                            item2.setOwner(string);
                            int n4 = n2 = 0;
                            while (n4 < s2) {
                                MapleCharacter mapleCharacter = a322;
                                a322.getMap().spawnItemDrop(mapleCharacter, mapleCharacter, item2, mapleCharacter.getPosition(), true, true);
                                n4 = ++n2;
                            }
                        }
                    } else {
                        a2.getPlayer().dropMessage("\u73a9\u5bb6: [" + string + "] \u4e0d\u5728\u7dda\u4e0a\u5537");
                    }
                } else {
                    a2.getPlayer().getMap().spawnItemDrop(a2.getPlayer(), a2.getPlayer(), item2, a2.getPlayer().getPosition(), true, true);
                }
            }
            return true;
        }
    }

    public static class Dropp
    extends CommandExecute {
        public /* synthetic */ Dropp() {
            Dropp a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleMessengerCharacter.ALLATORIxDEMO("Jvat.8\u905d\u5173G@0$#$\u6387\u8439\u905d\u5173");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            String[] arrstring;
            if (((String[])a3).length < 2) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, MapleMessengerCharacter.ALLATORIxDEMO("\u6b0e\u965e\u4e09\u8dbd%"));
                return false;
            }
            int n2 = 0;
            int n3 = 0;
            try {
                n2 = Integer.parseInt(a3[1]);
                n3 = Integer.parseInt(a3[3]);
                arrstring = a3;
            }
            catch (Exception exception) {
                arrstring = a3;
            }
            short s2 = (short)CommandProcessorUtil.getOptionalIntArg(arrstring, 2, 1);
            a3 = MapleItemInformationProvider.getInstance();
            if (GameConstants.isPet(n2)) {
                a2.getPlayer().dropMessage(5, MapleMapEffect.ALLATORIxDEMO("\u5bbb\u725e\u8a85\u5207\u8cb2\u725e\u5508\u57f9\u8cb2\u8c80`"));
            } else if (!((MapleItemInformationProvider)a3).itemExists(n2)) {
                a2.getPlayer().dropMessage(5, n2 + " - \u7269\u54c1\u4e0d\u5b58\u5728");
            } else {
                client.inventory.Item item2;
                if (GameConstants.getInventoryType(n2) == MapleInventoryType.EQUIP) {
                    Object object = a3;
                    item2 = ((MapleItemInformationProvider)object).randomizeStats((Equip)((MapleItemInformationProvider)object).getEquipById(n2));
                } else {
                    item2 = new client.inventory.Item(n2, 0, s2, 0);
                }
                if (GameSetConstants.COMMAND_NAME) {
                    item2.setOwner(a2.getPlayer().getName());
                }
                client.inventory.Item item3 = item2;
                item3.setGMLog(a2.getPlayer().getName());
                item3.setExpiration(System.currentTimeMillis() + (long)(n3 * 60 * 1000));
                a2.getPlayer().getMap().spawnItemDrop(a2.getPlayer(), a2.getPlayer(), item2, a2.getPlayer().getPosition(), true, true);
            }
            return true;
        }
    }

    public static class mesos
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient;
            if (a32.length < 2) {
                return false;
            }
            int n2 = 0;
            try {
                n2 = Integer.parseInt(a32[1]);
                mapleClient = a2;
            }
            catch (Exception a32) {
                mapleClient = a2;
            }
            mapleClient.getPlayer().gainMeso(n2, true);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + InternCommand.ALLATORIxDEMO("\\`BjB%\r\u9705\u89b0\u7681\u6549\u91ca\u000f%\u001c%\u5fa6\u5235\u6962\u5e66");
        }

        public /* synthetic */ mesos() {
            mesos a2;
        }
    }

    public static class maxmeso
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + Quadra.ALLATORIxDEMO("$W1[,E&\u0016d\u0016\u691a\u5e55\u6eb6");
        }

        public /* synthetic */ maxmeso() {
            maxmeso a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().gainMeso(Integer.MAX_VALUE - a2.getPlayer().getMeso(), true);
            return true;
        }
    }

    public static class UpdateMap
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter = a2.getPlayer();
            if (((String[])a3).length < 2) {
                return false;
            }
            boolean bl = ((String[])a3).length >= 2;
            int n2 = bl ? Integer.parseInt(a3[1]) : mapleCharacter.getMapId();
            MapleCharacter mapleCharacter2 = mapleCharacter;
            Object object = a3 = bl ? mapleCharacter2.getClient().getChannelServer().getMapFactory().getMap(n2) : mapleCharacter2.getMap();
            if (mapleCharacter.getClient().getChannelServer().getMapFactory().destroyMap(n2)) {
                MapleMap mapleMap = mapleCharacter.getClient().getChannelServer().getMapFactory().getMap(n2);
                MaplePortal maplePortal = mapleMap.getPortal(0);
                Object object2 = a3 = new LinkedHashSet<MapleCharacter>(((MapleMap)a3).getCharacters()).iterator();
                block2: while (object2.hasNext()) {
                    int n3;
                    MapleCharacter mapleCharacter3 = (MapleCharacter)a3.next();
                    int n4 = n3 = 0;
                    while (n4 < 5) {
                        try {
                            mapleCharacter3.changeMap(mapleMap, maplePortal);
                            object2 = a3;
                            continue block2;
                        }
                        catch (Throwable throwable) {
                            n4 = ++n3;
                        }
                    }
                    mapleCharacter.dropMessage("\u50b3\u9001\u73a9\u5bb6 " + mapleCharacter3.getName() + " \u5230\u65b0\u5730\u5716\u5931\u6557. \u81ea\u52d5\u7701\u7565...");
                    object2 = a3;
                }
                mapleCharacter.dropMessage(SkillType.ALLATORIxDEMO("\u5703\u5732\u5204\u6594\u5bbf\u6234\u001d"));
                return true;
            }
            mapleCharacter.dropMessage(CharacterIdChannelPair.ALLATORIxDEMO("\u5246\u65ea\u5741\u574c\u5940\u650dP"));
            return true;
        }

        public /* synthetic */ UpdateMap() {
            UpdateMap a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SkillType.ALLATORIxDEMO("qC@RPViRT\u0013\u0018^ECMW\u001a\u0013\t\u0013\u5213\u6583\u67f4\u5038\u5714\u5725");
        }
    }

    public static class loginlog
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = MapleCharacter.getCharacterByName(a3[1]);
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter.writeShort(1407);
            if (a3 != null) {
                ((MapleCharacter)a3).getClient().sendPacket(maplePacketLittleEndianWriter.getPacket());
            }
            return true;
        }

        public /* synthetic */ loginlog() {
            loginlog a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MaplePlayerShopItem.ALLATORIxDEMO("n/n/n/n/n/n/n/n/n");
        }
    }

    public static class RecvPacket
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            boolean bl = true;
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.resetInnerPotential((byte)1, 70000017, 0));
            mapleClient.getPlayer().updateInfoQuest(7785, a3[1]);
            return true;
        }

        public /* synthetic */ RecvPacket() {
            RecvPacket a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + DumpMobName.ALLATORIxDEMO("E1v;p$5}5l\u5c14\u5355\u5172\u5be9+");
        }
    }

    public static class SendPacket
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + StructSetItem.ALLATORIxDEMO("v\u0005E\u000fC\u0010\u0006I\u0006X\u5c27\u5361\u5141\u5bdd\u0018");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient;
            int n2;
            a3 = new MaplePacketLittleEndianWriter();
            short s2 = 112;
            String string = client.ItemVac.ALLATORIxDEMO("E&U-M5EWU!75E%U%E54#U#35E%U%E5A-U\"A5E%U%E51VU\"A5E%U%E5B'U M5E%U%E57SU\"D5E%U%E5GSU#35E%U%E5MQU\"C5E%U%E5M-U\"A5E%U%E5D&U-D5E%U%E5DQU-D5E%U%E50&U&45E%U%E5FQU A5E%U%E5A'U-D5E%U%E5A'U-C5E%U%E5L'U\"B5E%U%E5L#U\"B5E%U%E5@$U\"75E%U%E5G U-D5E%U%E5DTU-D5E%U%E53SU\"45E%U%E5MPU\"65E%U%E5B U\"M5E%U%E57 U'F5E%U%E5LVU'E5E%U%E5F%U\"B5E%U%E5G!U-D5E%U%E5BVU\"M5E%U%E5G-U\"L5E%U%E5DTU!D5E%U%E56\"U\"A5E%U%E5L&U#L5E%U%E5E!U-G5E%U%E5@,U-D5E%U%E5@,U 15E%U%E50QU\"75E%U%E5C,U 15E%U%E5L\"U#65E%U%E5LTU#35E%U%E57,U 45E%U%E5F#U\"M5E%U%E50&U\"F5E%U%E54%U'65E%U%E57&U%15E%U%E5C'U!A5E%U%E5@%U&75E%U%E5LSU$M5E%U%E57TU$45E%U%E5B'U\"75E%U%E56,U!15E%U%E53-U#B5E%U%E5A,U\"15E%U%E50,U&L5E%U%E53WU\"35E%U%E57PU#F5E%U%E51,U!65E%U%E57TU'E5E%U%E5C'U$15E%U%E53&U&G5E%U%E54,U#65E%U%E53TU 15E%U%E54QU\"05E%U%E51$U%15E%U%E57,U'35E%U%E5E#U!A5E%U%E50\"U\"05E%U%E54,U$65E%U%E56\"U\"D5E%U%E5L#U-D5E%U%E5G!U-@5E%U%E57&U!65E%U%E5@#U 35E%U%E5AVU 45E%U%E51!U!45E%U%E50SU%05E%U%E53SU\"M5E%U%E5A&U!05E%U%E51'U\"45E%U%E53WU\"L5E%U%E54WU\"15E%U%E51PU\"65E%U%E5C'U#75E%U%E5BTU%15E%U%E5G%U L5E%U%E57'U&L5E%U%E5M-U$D5E%U%E5M\"U!D5E%U%E5C&U!G5E%U%E54VU#@5E%U%E56\"U$B5E%U%E53,U#75E%U%E56WU\"35E%U%E5L'U\"L5E%U%E54,U!G5E%U%E5A\"U D5E%U%E53!U-E5E%U%E56-U\"B5E%U%E50QU\"65E%U%E5MTU#F5E%U%E5C,U&C5E%U%E53%U#@5E%U%E5@ U A5E%U%E5E&U\"C5E%U%E5ATU!F5E%U%E5BPU-A5E%U%E5GWU#C5E%U%E56!U!35E%U%E56$U&75E%U%E50SU#@5E%U%E5DQU-@5E%U%E5E'U 65E%U%E5E#U'G5E%U%E56,U#L5E%U%E54 U%05E%U%E5CPU F5E%U%E5F&U\"75E%U%E5BTU$65E%U%E5DTU\"05E%U%E51TU-G5E%U%E5MVU-E5E%U%E50TU 65E%U%E51TU'A5E%U%E56-U!G5E%U%E5@,U!35E%U%E5C\"U\"45E%U%E5B%U#05E%U%E56!U-A5E%U%E5ETU\"05E%U%E53&U\"05E%U%E54'U\"15E%U%E56SU$G5E%U%E5MPU!75E%U%E5C%U-@5E%U%E51TU#D5E%U%E5D#U-C5E%U%E5M$U\"15E%U%E5E#U%E5F#U&C5F#U&C5F#U&C");
            RecvPacketOpcode recvPacketOpcode = null;
            Object object = RecvPacketOpcode.values();
            int n3 = ((RecvPacketOpcode[])object).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                RecvPacketOpcode recvPacketOpcode2 = object[n2];
                if (recvPacketOpcode2.getValue() == s2) {
                    recvPacketOpcode = recvPacketOpcode2;
                }
                n4 = ++n2;
            }
            object = new LittleEndianAccessor(new ByteArrayByteStream(HexTool.getByteArrayFromHexString(string)));
            try {
                MapleClient mapleClient2 = a2;
                MapleServerHandler.handlePacket(recvPacketOpcode, (LittleEndianAccessor)object, mapleClient2, false, mapleClient2.getcs());
                mapleClient = a2;
            }
            catch (Exception exception) {
                Logger.getLogger(AdminCommand.class.getName()).log(Level.SEVERE, null, exception);
                mapleClient = a2;
            }
            short s3 = s2;
            mapleClient.getPlayer().dropMessage(s3 + "\u5df2\u50b3\u9001\u5c01\u5305[" + s3 + "] : " + ((MaplePacketLittleEndianWriter)a3).toString());
            return true;
        }

        public /* synthetic */ SendPacket() {
            SendPacket a2;
        }
    }

    public static class search
    extends \u9ad8\u7d1a\u6aa2\u7d22 {
        public /* synthetic */ search() {
            search a2;
        }
    }

    public static class autoban
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + LoadPacket.ALLATORIxDEMO("RBgXqV}\u0017>\u0017\u81f9\u52e2\u5c12\u93a1\u9598\u95eb");
        }

        public /* synthetic */ autoban() {
            autoban a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.setAutoBan(!GameSetConstants.getAutoBan());
            a2.getPlayer().dropMessage("\u81ea\u52d5\u5c01\u9396: " + (GameSetConstants.getAutoBan() ? LoadPacket.ALLATORIxDEMO("\u9598\u5568") : NPCMessage.ALLATORIxDEMO("\u95b1\u95fb")));
            System.out.println("\u81ea\u52d5\u5c01\u9396: " + (GameSetConstants.getAutoBan() ? LoadPacket.ALLATORIxDEMO("\u9598\u5568") : NPCMessage.ALLATORIxDEMO("\u95b1\u95fb")));
            return true;
        }
    }

    public static class autodc
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + DatabaseException.ALLATORIxDEMO("k)^3N?\nq\n\u81b6\u52ff\u65eb\u7df0\u95d7\u95f6");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            GameSetConstants.setAutoDc(!GameSetConstants.getAutoDc());
            a2.getPlayer().dropMessage("\u81ea\u52d5\u65b7\u7dda: " + (GameSetConstants.getAutoDc() ? DatabaseException.ALLATORIxDEMO("\u95d7\u5575") : PetHandler.ALLATORIxDEMO("\u95b2\u9588")));
            System.out.println("\u81ea\u52d5\u65b7\u7dda: " + (GameSetConstants.getAutoDc() ? DatabaseException.ALLATORIxDEMO("\u95d7\u5575") : PetHandler.ALLATORIxDEMO("\u95b2\u9588")));
            return true;
        }

        public /* synthetic */ autodc() {
            autodc a2;
        }
    }

    public static class pmob
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            MapleMonster mapleMonster;
            if (a322.length < 3) {
                return false;
            }
            int a322 = Integer.parseInt(a322[1]);
            int n2 = Integer.parseInt(a322[2]);
            try {
                mapleMonster = MapleLifeFactory.getMonster(a322);
            }
            catch (RuntimeException runtimeException) {
                a2.getPlayer().dropMessage(6, "Error: " + runtimeException.getMessage());
                return true;
            }
            if (mapleMonster != null) {
                Object object;
                Object object2;
                MapleClient mapleClient = a2;
                int n3 = mapleClient.getPlayer().getPosition().x;
                int n4 = mapleClient.getPlayer().getPosition().y;
                int n5 = mapleClient.getPlayer().getMap().getFootholds().findBelow(a2.getPlayer().getPosition()).getId();
                MapleMonster mapleMonster2 = mapleMonster;
                int n6 = n3;
                MapleMonster mapleMonster3 = mapleMonster;
                mapleMonster3.setPosition(a2.getPlayer().getPosition());
                mapleMonster3.setCy(n4);
                mapleMonster.setRx0(n6);
                mapleMonster2.setRx1(n6);
                mapleMonster2.setFh(n5);
                try {
                    Object object3;
                    block20: {
                        object2 = DBConPool.getInstance().getDataSource().getConnection();
                        try {
                            block19: {
                                object = object2.prepareStatement(MapleTrait.ALLATORIxDEMO("\u001b\u0017\u0001\u001c\u0000\rr\u0010\u001c\r\u001dy%#\r:'*&6?5;?7yz06=~y4ur1;=7ur?:ur:+ur+*i~y !cur-+)7ur!~y+ur4;=~y?60-;47u%6 56pr\u000f\u0013\u0015\u0007\u001c\u0001yzf~ymurf~ymurf~ymurf~ymurf~ymurf~ymurf{"));
                                try {
                                    PreparedStatement preparedStatement = object;
                                    PreparedStatement preparedStatement2 = object;
                                    Object object4 = object;
                                    Object object5 = object;
                                    Object object6 = object;
                                    Object object7 = object;
                                    object.setInt(1, a322);
                                    object7.setInt(2, 0);
                                    object7.setInt(3, 0);
                                    object6.setInt(4, n5);
                                    object6.setInt(5, n4);
                                    object5.setInt(6, n3);
                                    object5.setInt(7, n3);
                                    object4.setString(8, MapleFamily.ALLATORIxDEMO("-"));
                                    object4.setInt(9, n3);
                                    preparedStatement2.setInt(10, n4);
                                    preparedStatement2.setInt(11, a2.getPlayer().getMapId());
                                    preparedStatement.setInt(12, n2);
                                    preparedStatement.setInt(13, 0);
                                    object.executeUpdate();
                                    if (object == null) break block19;
                                    object3 = object2;
                                }
                                catch (Throwable throwable) {
                                    Throwable throwable2;
                                    block21: {
                                        if (object != null) {
                                            try {
                                                object.close();
                                                throwable2 = throwable;
                                                break block21;
                                            }
                                            catch (Throwable a322) {
                                                throwable.addSuppressed(a322);
                                            }
                                        }
                                        throwable2 = throwable;
                                    }
                                    throw throwable2;
                                }
                                object.close();
                                break block20;
                            }
                            object3 = object2;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable3;
                            block23: {
                                if (object2 != null) {
                                    try {
                                        object2.close();
                                        throwable3 = throwable;
                                        break block23;
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
                    if (object3 != null) {
                        object2.close();
                    }
                }
                catch (SQLException sQLException) {
                    a2.getPlayer().dropMessage(6, "mob\u5b58\u5165\u8cc7\u6599\u5eab\u5931\u6557" + sQLException);
                    System.err.println(sQLException);
                }
                object2 = ChannelServer.getAllInstances().iterator();
                Iterator<ChannelServer> iterator = object2;
                while (iterator.hasNext()) {
                    object = (ChannelServer)object2.next();
                    iterator = object2;
                    ((ChannelServer)object).getMapFactory().getMap(a2.getPlayer().getMapId()).addMonsterSpawn(mapleMonster, n2, (byte)-1, null, true);
                    Object object8 = object;
                    ((ChannelServer)object8).getMapFactory().getMap(a2.getPlayer().getMapId()).addMaxMobInMap();
                    ((ChannelServer)object8).getMapFactory().getMap(a2.getPlayer().getMapId()).resetlastSpawnTime();
                }
            } else {
                a2.getPlayer().dropMessage(6, MapleFamily.ALLATORIxDEMO("\u4e4d\u5b36\u5768\u76ea`#/\fm'$"));
                return true;
            }
            a2.getPlayer().dropMessage(6, MapleTrait.ALLATORIxDEMO("\u8a99\u4e54\u89d3\u9194\u65e2\u8f50\u5137\u6775\u5762\u574f|"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + " pmob <\u602a\u7269\u4ee3\u78bc> <\u91cd\u751f\u9593\u9694> - \u53ec\u559a\u6c38\u4e45\u56fa\u5b9a\u602a\u7269";
        }

        public /* synthetic */ pmob() {
            pmob a2;
        }
    }

    public static class PNPC
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + BeansPacket.ALLATORIxDEMO("2K2Fb\bb\u5edf\u7a89\u6c1d\u4e07k\u0012f");
        }

        /*
         * Exception decompiling
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

        public /* synthetic */ PNPC() {
            PNPC a2;
        }
    }

    public static class ResetMap
    extends CommandExecute {
        public /* synthetic */ ResetMap() {
            ResetMap a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"kojzx}w*4*\u91d4\u7f64\u9000\u5001\u5729\u571c");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getMap().resetFully();
            return true;
        }
    }

    public static class Respawn
    extends CommandExecute {
        public /* synthetic */ Respawn() {
            Respawn a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getMap().respawn(true);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PlayersHandler.ALLATORIxDEMO("XcYvKqD&\u0007&\u91e7\u65b6\u9018\u5163\u571a\u5710");
        }
    }

    public static class ReloadMap
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            for (ChannelServer channelServer : LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels()) {
                if (!channelServer.getMapFactory().isMapLoaded(a32) || channelServer.getMapFactory().getMap(a32).getCharactersSize() <= 0) continue;
                a2.getPlayer().dropMessage(5, "\u9084\u6709\u73a9\u5bb6\u5728\u983b\u9053 " + channelServer.getChannel());
                return true;
            }
            for (ChannelServer channelServer : LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels()) {
                if (!channelServer.getMapFactory().isMapLoaded(a32)) continue;
                channelServer.getMapFactory().removeMap(a32);
            }
            return true;
        }

        public /* synthetic */ ReloadMap() {
            ReloadMap a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + LoadPacket.ALLATORIxDEMO("Ev[|VwZrG3\u000b~VzGzS-\u0017>\u0017\u91de\u7f59\u67c3\u503c\u5723\u5721");
        }
    }

    public static class StopProfiling
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)":\u001d&\u00199\u001b&\u000f \u0005 \u0007.Iu\u000f \u0005,\u0007(\u0004,WiDi\u53bf\u6dc1\u7d69\u934d#\u001f$\u8c8e\u8a63\u4e6f\u515b\u5b11\u5259\u6add\u6821");
        }

        public /* synthetic */ StopProfiling() {
            StopProfiling a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            Object a322;
            CPUSampler cPUSampler;
            block9: {
                cPUSampler = CPUSampler.getInstance();
                String string = \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u0006-\u0000'\u0019;\u0006/\u0000%\fg\u001d1\u001d");
                if (((String[])a322).length > 1) {
                    string = a322[1];
                }
                if (!((File)(a322 = new File(string))).exists()) break block9;
                a2.getPlayer().dropMessage(6, HmacOneTimePasswordGenerator.ALLATORIxDEMO("N?\u007fw\u007f9n2h2~w|>v2t6w2:6v%\u007f6~.:2b>i#i{:4r8u$\u007fw{w~>|1\u007f%\u007f9nwu9\u007f"));
                return true;
            }
            cPUSampler.stop();
            a322 = new FileWriter((File)a322);
            try {
                cPUSampler.save((Writer)a322, 1, 10);
            }
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    try {
                        ((OutputStreamWriter)a322).close();
                        throwable2 = throwable;
                    }
                    catch (Throwable a322) {
                        Throwable throwable3 = throwable;
                        throwable2 = throwable3;
                        throwable3.addSuppressed(a322);
                    }
                    throw throwable2;
                }
                catch (IOException iOException) {
                    System.err.println("Error saving profile" + iOException);
                }
            }
            ((OutputStreamWriter)a322).close();
            cPUSampler.reset();
            return true;
        }
    }

    public static class StartProfiling
    extends CommandExecute {
        public /* synthetic */ StartProfiling() {
            StartProfiling a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = CPUSampler.getInstance();
            Object object2 = a3;
            Object object3 = a3;
            Object object4 = a3;
            ((CPUSampler)object4).addIncluded("client");
            ((CPUSampler)object4).addIncluded(ConsoleCommandObject.ALLATORIxDEMO("YsToN}ThI"));
            ((CPUSampler)object3).addIncluded(MapleParty.ALLATORIxDEMO("\u0014x\u0004x\u0012x\u0003|"));
            ((CPUSampler)object3).addIncluded(ConsoleCommandObject.ALLATORIxDEMO("t[r^pSr]"));
            ((CPUSampler)object2).addIncluded(MapleParty.ALLATORIxDEMO("\u0000k\u001fo\u0019}\u0015k"));
            ((CPUSampler)object2).addIncluded(ConsoleCommandObject.ALLATORIxDEMO("I\u007fHuJhSr]"));
            ((CPUSampler)object).addIncluded("server");
            ((CPUSampler)object).addIncluded(MapleParty.ALLATORIxDEMO("m\u001fv\u001cj"));
            ((CPUSampler)object).start();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ConsoleCommandObject.ALLATORIxDEMO("oN}HhJnUzSpSr]<\u95b1\u59d7\u7d3a\u9318pJw\u8cdb\u8a30");
        }
    }

    public static class LOLCastle
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length != 2) {
                return false;
            }
            Object object = a3 = a2.getChannelServer().getEventSM().getEventManager(K.ALLATORIxDEMO("yuyytiavp")).getInstance("lolcastle" + a3[1]).getMapFactory().getMap(990000300, false, false);
            a2.getPlayer().changeMap((MapleMap)object, ((MapleMap)object).getPortal(0));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SkilledCommand.ALLATORIxDEMO("G\u0014G\u0018J\b_\u0017N[G\u001e]\u001eG[\u0003\u0017N\rN\u0017\u000bF\u000bJ\u0006N\u0002[\u0006[\u4e26\u779e\u9078\u6654\u554e");
        }

        public /* synthetic */ LOLCastle() {
            LOLCastle a2;
        }
    }

    public static class WarpAllHere
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + GZIPCompression.ALLATORIxDEMO("em@|s`^DW~W,\u62b8\u624c\u673b\u73a5\u5b84\u50bf\u9033\u523c\u902b\u88ed");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = ChannelServer.getAllChannelInstances().iterator();
            while (a3.hasNext()) {
                for (MapleCharacter mapleCharacter : ((ChannelServer)a3.next()).getPlayerStorage().getAllCharactersThreadSafe()) {
                    if (mapleCharacter.getMapId() != a2.getPlayer().getMapId()) {
                        mapleCharacter.changeMap(a2.getPlayer().getMap(), a2.getPlayer().getPosition());
                    }
                    if (mapleCharacter.getClient().getChannel() == a2.getPlayer().getClient().getChannel()) continue;
                    mapleCharacter.changeChannel(a2.getPlayer().getClient().getChannel());
                }
            }
            return true;
        }

        public /* synthetic */ WarpAllHere() {
            WarpAllHere a2;
        }
    }

    public static class WarpPlayersTo
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"IFlWNK\u007f^{Umsq\u0007\"J\u007fNnNz\u0019>\u62ad\u625e\u672e\u73b7\u5b91\u50ad\u9026\u522e\u67f7\u5015\u5717\u5708");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            try {
                MapleClient mapleClient = a2;
                a32 = mapleClient.getChannelServer().getMapFactory().getMap(Integer.parseInt(a32[1]));
                Iterator<MapleCharacter> iterator = mapleClient.getPlayer().getMap().getCharactersThreadsafe().iterator();
                while (iterator.hasNext()) {
                    Object object = a32;
                    iterator.next().changeMap((MapleMap)object, ((MapleMap)object).getPortal(0));
                }
            }
            catch (Exception a32) {
                return false;
            }
            return true;
        }

        public /* synthetic */ WarpPlayersTo() {
            WarpPlayersTo a2;
        }
    }

    public static class Spawn
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + GMCommand.ALLATORIxDEMO("A\u0012S\u0015\\B\u000e\u6048\u725b+v\\\u0012^Z\u0012N\u0007J\u0012N\u0012Z\u0012N\u001eB\u0007J\u0012\u0012_\u0012]\fB\u001fB\u53de\u55f8\u6018\u720b");
        }

        public /* synthetic */ Spawn() {
            Spawn a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            long l2;
            int n3;
            int n4;
            Integer n5;
            long l3;
            Integer n6;
            MapleMonster mapleMonster;
            String[] arrstring;
            if (((String[])a3).length < 2) {
                return false;
            }
            int n7 = 0;
            try {
                n7 = Integer.parseInt(a3[1]);
                arrstring = a3;
            }
            catch (Exception exception) {
                arrstring = a3;
            }
            int n8 = Math.min(CommandProcessorUtil.getOptionalIntArg(arrstring, 2, 1), 500);
            if (n8 > 1000) {
                n8 = 1000;
            }
            String[] arrstring2 = a3;
            a3 = CommandProcessorUtil.getNamedLongArg((String[])a3, 1, GMCommand.ALLATORIxDEMO("Z\u0012"));
            Integer n9 = CommandProcessorUtil.getNamedIntArg(arrstring2, 1, MapleExtendedSlots.ALLATORIxDEMO("J("));
            Object object = CommandProcessorUtil.getNamedIntArg((String[])a3, 1, GMCommand.ALLATORIxDEMO("\u0007J\u0012"));
            Double d2 = CommandProcessorUtil.getNamedDoubleArg(arrstring2, 1, MapleExtendedSlots.ALLATORIxDEMO("(O("));
            Double d3 = CommandProcessorUtil.getNamedDoubleArg((String[])a3, 1, GMCommand.ALLATORIxDEMO("\u0012_\u0012"));
            Double d4 = CommandProcessorUtil.getNamedDoubleArg(arrstring2, 1, MapleExtendedSlots.ALLATORIxDEMO("W=_("));
            try {
                mapleMonster = MapleLifeFactory.getMonster(n7);
            }
            catch (RuntimeException runtimeException) {
                a2.getPlayer().dropMessage(5, "\u932f\u8aa4: " + runtimeException.getMessage());
                return true;
            }
            if (a3 != null) {
                n6 = n9;
                l3 = (Long)a3;
            } else {
                MapleMonster mapleMonster2 = mapleMonster;
                if (d2 != null) {
                    l3 = (long)((double)mapleMonster2.getMobMaxHp() * (d2 / 100.0));
                    n6 = n9;
                } else {
                    l3 = mapleMonster2.getMobMaxHp();
                    n6 = n9;
                }
            }
            if (n6 != null) {
                n5 = object;
                n4 = n9;
            } else {
                MapleMonster mapleMonster3 = mapleMonster;
                if (d3 != null) {
                    n4 = (int)((double)mapleMonster3.getMobMaxMp() * (d3 / 100.0));
                    n5 = object;
                } else {
                    n4 = mapleMonster3.getMobMaxMp();
                    n5 = object;
                }
            }
            if (n5 != null) {
                n3 = (Integer)object;
                l2 = l3;
            } else {
                MapleMonster mapleMonster4 = mapleMonster;
                if (d4 != null) {
                    n3 = (int)((double)mapleMonster4.getMobExp() * (d4 / 100.0));
                    l2 = l3;
                } else {
                    n3 = mapleMonster4.getMobExp();
                    l2 = l3;
                }
            }
            if (l2 < 1L) {
                l3 = 1L;
            }
            a3 = new OverrideMonsterStats(l3, mapleMonster.getMobMaxMp(), n3, false);
            int n10 = n2 = 0;
            while (n10 < n8) {
                Object object2 = object = MapleLifeFactory.getMonster(n7);
                ((MapleMonster)object2).setHp(l3);
                ((MapleMonster)object2).setOverrideStats((OverrideMonsterStats)a3);
                a2.getPlayer().getMap().spawnMonsterOnGroundBelow((MapleMonster)object, a2.getPlayer().getPosition());
                n10 = ++n2;
            }
            return true;
        }
    }

    public static class DestroyPNPC
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + Timer.ALLATORIxDEMO("p\u0005g\u0014f\u000fm\u0010z\u0010w@O\u000fv\nq\u0003`\tp=4M4\u524a\u96700Z0W");
        }

        public /* synthetic */ DestroyPNPC() {
            DestroyPNPC a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            block3: {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u000e\u00189\t8\u00123\u0014$\u001aj\r&\u001c3\u001883\u001a>dSd"));
                a32 = mapleClient.getPlayer().getMap().getNPCByOid(Integer.parseInt(a32[1]));
                if (!(a32 instanceof PlayerNPC)) break block3;
                ((PlayerNPC)a32).destroy(true);
                a2.getPlayer().dropMessage(6, Timer.ALLATORIxDEMO("${\u000eq"));
            }
            try {
                a2.getPlayer().dropMessage(6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"k\u0019/\u000e>\u000f%\u0004:\u0013:\u001ej&%\u001f \u0018)\t#\u0019\u0017"));
            }
            catch (Exception a32) {
                a2.getPlayer().dropMessage(6, "NPC failed... : " + a32.getMessage());
            }
            return true;
        }
    }

    public static class MakeOfflineP
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter;
            block3: {
                a2.getPlayer().dropMessage(6, Instruction.ALLATORIxDEMO(",{\ns\u000f}Aj\r{\u0018\u007f\u0013T1YO4O"));
                MapleClient mapleClient = new MapleClient(null, null, new MockIOSession());
                mapleCharacter = MapleCharacter.loadCharFromDB(MapleCharacterUtil.getIdByName(a3[1]), mapleClient, false);
                if (mapleCharacter != null) break block3;
                a2.getPlayer().dropMessage(6, a3[1] + " does not exist");
            }
            try {
                new PlayerNPC(mapleCharacter, Integer.parseInt(a3[2]), a2.getPlayer().getMap(), a2.getPlayer()).addToServer();
                a2.getPlayer().dropMessage(6, \u592f\u592f\u8c37.ALLATORIxDEMO((String)"2\u001e\u0018\u0014"));
            }
            catch (Exception exception) {
                a2.getPlayer().dropMessage(6, "NPC failed... : " + exception.getMessage());
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + Instruction.ALLATORIxDEMO("W\u0000q\u0004U\u0007|\rs\u000f\u007f1:]y\t{\u0013t\u0000w\u0004$A&\u000fj\u0002s\u0005$A7A\u526f\u9041\u96f8\u7dbbJ/J\"");
        }

        public /* synthetic */ MakeOfflineP() {
            MakeOfflineP a2;
        }
    }

    public static class MakePNPC
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + CashShopOperation.ALLATORIxDEMO("\u000bW\rS\u0016X\u0016UF\n\u0016Z\u0007O\u0003D\bW\u000bSX\u0016ZX\u0016U\u000fRX\u0016K\u0016\u5213\u9016\u73cf\u5b80(f%");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            int n3;
            String string;
            block8: {
                if (((String[])a3).length < 2) {
                    return false;
                }
                a2.getPlayer().dropMessage(6, CashShopOperation.ALLATORIxDEMO("+W\r_\bQFF\nW\u001fS\u0014x6uH\u0018H"));
                string = a3[1];
                n3 = World.Find.findChannel(string);
                n2 = World.Find.findWorld(string);
                if (n3 > 0) break block8;
                a2.getPlayer().dropMessage(6, FileOperation.ALLATORIxDEMO("\u73a5\u5bbb\u5fc9\u9805\u4e06\u7dd7"));
                return true;
            }
            try {
                MapleCharacter mapleCharacter = ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterByName(string);
                if (mapleCharacter == null) {
                    a2.getPlayer().dropMessage(6, a3[1] + " is not online");
                } else {
                    int n4 = 9901600;
                    if (((String[])a3).length > 2) {
                        n4 = Integer.parseInt(a3[2]);
                    }
                    if ((a3 = MapleLifeFactory.getNPC(n4)) == null || ((MapleNPC)a3).getName().equals("MISSINGNO")) {
                        a2.getPlayer().dropMessage(6, CashShopOperation.ALLATORIxDEMO("x6u\u4e6b\u5b6e\u574e"));
                        return true;
                    }
                    new PlayerNPC(mapleCharacter, n4, a2.getPlayer().getMap(), a2.getPlayer()).addToServer();
                    a2.getPlayer().dropMessage(6, FileOperation.ALLATORIxDEMO("Hbbh"));
                }
            }
            catch (Exception exception) {
                a2.getPlayer().dropMessage(6, "NPC failed... : " + exception.getMessage());
            }
            return true;
        }

        public /* synthetic */ MakePNPC() {
            MakePNPC a2;
        }
    }

    public static class NPC
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            int n2;
            int n3 = 0;
            try {
                n2 = n3 = Integer.parseInt(a32[1]);
            }
            catch (Exception a32) {
                n2 = n3;
            }
            Object a32 = MapleLifeFactory.getNPC(n2);
            if (a32 != null && !((MapleNPC)a32).getName().equals("MISSINGNO")) {
                MapleClient mapleClient = a2;
                Object object = a32;
                MapleClient mapleClient2 = a2;
                Object object2 = a32;
                MapleClient mapleClient3 = a2;
                ((AbstractMapleMapObject)a32).setPosition(mapleClient3.getPlayer().getPosition());
                ((AbstractLoadedMapleLife)object2).setCy(mapleClient3.getPlayer().getPosition().y);
                ((AbstractLoadedMapleLife)object2).setRx0(a2.getPlayer().getPosition().x + 50);
                ((AbstractLoadedMapleLife)a32).setRx1(mapleClient2.getPlayer().getPosition().x - 50);
                ((AbstractAnimatedMapleMapObject)object).setFh(mapleClient2.getPlayer().getMap().getFootholds().findBelow(a2.getPlayer().getPosition()).getId());
                ((AbstractLoadedMapleLife)object).setCustom(true);
                mapleClient.getPlayer().getMap().addMapObject((MapleMapObject)a32);
                mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.spawnNPC((MapleNPC)a32, true));
            } else {
                a2.getPlayer().dropMessage(6, "\u627e\u4e0d\u5230\u6b64\u4ee3\u78bc\u70ba" + n3 + "\u7684Npc");
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MobSkill.ALLATORIxDEMO("DZI\n\u0016DZICN\u0014\n\u0007\n\u5456\u53c1\u51d0dzi");
        }

        public /* synthetic */ NPC() {
            NPC a2;
        }
    }

    public static class HitMonsterByOID
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + StructRewardItem.ALLATORIxDEMO("b_~[eXyBoDhOe_n\u00166[eTe_n\b*\nnWgWmS4\u0016'\u0016\u78ba\u64a8\u573a\u5720\u4e00\u67e6\u5001\u601c\u7263");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleMap mapleMap = a2.getPlayer().getMap();
            int a32 = Integer.parseInt(a32[1]);
            int n2 = Integer.parseInt(a32[2]);
            MapleMonster mapleMonster = mapleMap.getMonsterByOid(a32);
            if (mapleMonster != null) {
                mapleMap.broadcastMessage(MobPacket.damageMonster(a32, n2));
                mapleMonster.damage(a2.getPlayer(), n2, false);
            }
            return true;
        }

        public /* synthetic */ HitMonsterByOID() {
            HitMonsterByOID a2;
        }
    }

    public static class KillMonsterByOID
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            MapleMap mapleMap = a2.getPlayer().getMap();
            a3 = mapleMap.getMonsterByOid(Integer.parseInt(a3[1]));
            if (a3 != null) {
                mapleMap.killMonster((MapleMonster)a3, a2.getPlayer(), false, false, (byte)1);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleRing.ALLATORIxDEMO("7s0v1u2i(\u007f.x%u5~|&1u>u5~b:q:\u6be6\u6393\u576c\u570c\u4e56\u67ca\u5057\u6030\u7235");
        }

        public /* synthetic */ KillMonsterByOID() {
            KillMonsterByOID a2;
        }
    }

    public static class KillMonster
    extends CommandExecute {
        public /* synthetic */ KillMonster() {
            KillMonster a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MaplePartyCharacter.ALLATORIxDEMO("mWjRkQhMr[t\u001e:Si\\oZ8\u001e+\u001e\u6bbc\u63b7\u5736\u5728\u4e0c\u67ee\u500d\u6014\u726f");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleMap object2 = a2.getPlayer().getMap();
            double d2 = Double.POSITIVE_INFINITY;
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
            for (MapleMonster mapleMonster : object2.getMapObjectsInRange(a2.getPlayer().getPosition(), d2, Arrays.asList(arrmapleMapObjectType))) {
                if (mapleMonster.getId() != Integer.parseInt(a3[1])) continue;
                MapleMonster mapleMonster2 = mapleMonster;
                mapleMonster2.damage(a2.getPlayer(), mapleMonster2.getHp(), false);
            }
            return true;
        }
    }

    public static class MonsterHp
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + AllianceHandler.ALLATORIxDEMO("{\u007fXcBuDXF0\u8876\u91df\u0016=\u0016\u6529\u601c\u7279\u8876\u91df");
        }

        public /* synthetic */ MonsterHp() {
            MonsterHp a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            Iterator<MapleMapObject> iterator;
            if (a32.length < 2) {
                return false;
            }
            Object object = a2.getPlayer().getMap();
            double d2 = Double.POSITIVE_INFINITY;
            boolean bl = false;
            bl = false;
            int a32 = Integer.parseInt(a32[1]);
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
            object = ((MapleMap)object).getMapObjectsInRange(a2.getPlayer().getPosition(), d2, Arrays.asList(arrmapleMapObjectType));
            Iterator<MapleMapObject> iterator2 = iterator = object.iterator();
            while (iterator2.hasNext()) {
                ((MapleMonster)iterator.next()).setHp(a32);
                iterator2 = iterator;
            }
            a2.getPlayer().dropMessage("\u60a8\u7e3d\u5171\u6539\u4e86 " + object.size() + " \u602a\u7269\u8840\u91cf");
            return true;
        }
    }

    public static class KillAll
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + UserInterfaceHandler.ALLATORIxDEMO("_RXWUWX\u001bo\u6b5f\u8661\u9693\u613b\u8f03\u5151\u5348\u53db\u4e36\u6e31\u8f11\u8fc0\u77c8\u78a5f\u0014\u0016\u0014\u6b81\u63bd\u627b\u673d\u7392\u5b82");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object;
            MapleMap mapleMap = a2.getPlayer().getMap();
            double d2 = Double.POSITIVE_INFINITY;
            boolean bl = false;
            boolean bl2 = false;
            if (((String[])a3).length > 1) {
                object = a3[1];
                boolean bl3 = bl2 = !((String)object).isEmpty();
            }
            if (mapleMap == null) {
                a2.getPlayer().dropMessage("\u5730\u5716[" + a3[2] + "] \u4e0d\u5b58\u5728\u3002");
                return true;
            }
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
            a3 = mapleMap.getMapObjectsInRange(a2.getPlayer().getPosition(), d2, Arrays.asList(arrmapleMapObjectType));
            Iterator<MapleMapObject> iterator = a3.iterator();
            while (iterator.hasNext()) {
                object = (MapleMonster)iterator.next();
                if (bl2) {
                    if (MobConstants.isReincarnationMob(((AbstractLoadedMapleLife)object).getId())) continue;
                    mapleMap.killMonster((MapleMonster)object, a2.getPlayer(), bl, false, (byte)1);
                    continue;
                }
                mapleMap.killMonster((MapleMonster)object, a2.getPlayer(), bl, false, (byte)1);
            }
            a2.getPlayer().dropMessage("\u60a8\u7e3d\u5171\u6bba\u4e86 " + a3.size() + " \u602a\u7269");
            return true;
        }

        public /* synthetic */ KillAll() {
            KillAll a2;
        }
    }

    public static class ToggleMegaphone
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleDueyActions.ALLATORIxDEMO("#Y0Q;S:S0W'^8X2\u0016z\u0016\u95dc\u5569\u6241\u95ea\u95de\u5ed5\u64fa");
        }

        public /* synthetic */ ToggleMegaphone() {
            ToggleMegaphone a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            World.toggleMegaphoneMuteState();
            a2.getPlayer().dropMessage(6, "\u5ee3\u64ad\u662f\u5426\u5c01\u9396 : " + (a2.getChannelServer().getMegaphoneMuteState() ? "\u662f" : "\u5426"));
            return true;
        }
    }

    public static class toggleDrop
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + StatsHandling.ALLATORIxDEMO("\u000fA\u001cI\u0017K\u001f\\\u0014^[\u0003[\u95a5\u5524\u6238\u95a7\u95a7\u63f2\u8413");
        }

        public /* synthetic */ toggleDrop() {
            toggleDrop a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getMap().toggleDrops();
            return true;
        }
    }

    public static class ToggleOffense
    extends CommandExecute {
        public /* synthetic */ ToggleOffense() {
            ToggleOffense a2;
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            boolean bl;
            CheatingOffense cheatingOffense;
            if (a3.length < 2) {
                return false;
            }
            try {
                CheatingOffense cheatingOffense2;
                cheatingOffense = cheatingOffense2 = CheatingOffense.valueOf(a3[1]);
                bl = !cheatingOffense2.isEnabled();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                a2.getPlayer().dropMessage(6, "Offense " + a3[1] + " not found");
                return true;
            }
            {
                cheatingOffense.setEnabled(bl);
                return true;
            }
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleFamilyCharacter.ALLATORIxDEMO("6K%C.A-B$A,W'\u0004~k$B'J1A|\u0004o\u0004\u95c9\u557b\u6254\u95f8\u95cbg*A#P\rB$A,W'");
        }
    }

    public static class ShowTrace
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapConstants.ALLATORIxDEMO("k\u0013w\fl\ty\u0018}[5[k\u0013w\f8\u000fj\u001a{\u001e8\u0012v\u001dw");
        }

        public /* synthetic */ ShowTrace() {
            ShowTrace a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            if (((String[])a3).length < 2) {
                return false;
            }
            Thread[] arrthread = new Thread[Thread.activeCount()];
            Thread.enumerate(arrthread);
            a3 = arrthread[Integer.parseInt(a3[1])];
            a2.getPlayer().dropMessage(6, ((Thread)a3).toString() + ":");
            a3 = ((Thread)a3).getStackTrace();
            int n3 = ((StackTraceElement[])a3).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                Object object = a3[n2];
                a2.getPlayer().dropMessage(6, ((StackTraceElement)object).toString());
                n4 = ++n2;
            }
            return true;
        }
    }

    public static class Threads
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + FileOperation.ALLATORIxDEMO("yd\u007filh~, ,\u67e8\u7707Yd\u007filh~\u8ccb\u8a07");
        }

        public /* synthetic */ Threads() {
            Threads a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Thread[] arrthread = new Thread[Thread.activeCount()];
            Thread.enumerate(arrthread);
            String string = "";
            if (a3.length > 1) {
                string = a3[1];
            }
            int n2 = a3 = 0;
            while (n2 < arrthread.length) {
                String string2 = arrthread[a3].toString();
                if (string2.toLowerCase().contains(string.toLowerCase())) {
                    a2.getPlayer().dropMessage(6, a3 + ": " + string2);
                }
                n2 = ++a3;
            }
            return true;
        }
    }

    public static class PermWeather
    extends CommandExecute {
        public /* synthetic */ PermWeather() {
            PermWeather a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"D4F<C4U%\\4Fq\u0019q\u8a19\u5bcb\u591d\u6c72");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a2.getPlayer().getMap().getPermanentWeather() > 0) {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().getMap().setPermanentWeather(0);
                mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.removeMapEffect());
                mapleClient.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"y0DqC4U%\\4Fq\\0GqV4Q?\u00145]\"U3X4P\u007f"));
            } else {
                int a32 = CommandProcessorUtil.getOptionalIntArg(a32, 1, 5120000);
                if (!MapleItemInformationProvider.getInstance().itemExists(a32) || a32 / 10000 != 512) {
                    a2.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0018Z'U=]5\u0014\u0018p\u007f"));
                } else {
                    MapleClient mapleClient = a2;
                    mapleClient.getPlayer().getMap().setPermanentWeather(a32);
                    mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.startMapEffect("", a32, false));
                    mapleClient.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u001cU!\u0014&Q0@9Q#\u00149U\"\u00143Q4ZqQ?U3X4P\u007f"));
                }
            }
            return true;
        }
    }

    public static class unMonitor
    extends CommandExecute {
        public /* synthetic */ unMonitor() {
            unMonitor a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(a3[1]);
            mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter != null) {
                mapleCharacter.getClient().setMonitored(false);
                a2.getPlayer().dropMessage(5, "\u76e3\u63a7 " + mapleCharacter.getName() + "\u89e3\u9664");
            } else {
                a2.SetMonitored(a3[1], false);
                MapleClient mapleClient = a2;
                if (!a2.getMonitored(a3[1])) {
                    mapleClient.getPlayer().dropMessage(5, "\u96e2\u7dda\u89e3\u9664 Monitor " + a3[1] + " \u6210\u529f");
                } else {
                    mapleClient.getPlayer().dropMessage(5, "\u96e2\u7dda\u89e3\u9664 Monitor " + a3[1] + " \u5931\u6557");
                }
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MobSkill.ALLATORIxDEMO("_DgEDC^EX\n\u0016\u7383\u5b9c\u0014\n\u0007\n\u89c9\u964e\u8a32\u932e\u7383\u5b9c\u8ced\u8a20");
        }
    }

    public static class Monitor
    extends CommandExecute {
        public /* synthetic */ Monitor() {
            Monitor a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 2) {
                return false;
            }
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(a3[1]);
            mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter != null) {
                mapleCharacter.getClient().setMonitored(true);
                a2.getPlayer().dropMessage(5, "\u76e3\u63a7 " + mapleCharacter.getName() + "\u555f\u7528");
            } else {
                a2.SetMonitored(a3[1], true);
                MapleClient mapleClient = a2;
                if (a2.getMonitored(a3[1])) {
                    mapleClient.getPlayer().dropMessage(5, "\u96e2\u7dda\u8a2d\u5b9a Monitor " + a3[1] + " \u6210\u529f");
                } else {
                    mapleClient.getPlayer().dropMessage(5, "\u96e2\u7dda\u8a2d\u5b9a Monitor " + a3[1] + " \u5931\u6557");
                }
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ClientRedirector.ALLATORIxDEMO("X+[-A+Gd\t\u73ed\u5b83z\u0015i\u0015\u8a5c\u9331\u73ed\u5b83\u8c83\u8a3f");
        }
    }

    public static class DisposeClones
    extends CommandExecute {
        public /* synthetic */ DisposeClones() {
            DisposeClones a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().dropMessage(6, a2.getPlayer().getCloneSize() + "\u500b\u514b\u9f8d\u9ad4\u6d88\u5931\u4e86.");
            a2.getPlayer().disposeClones();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + UserInterfaceHandler.ALLATORIxDEMO("PRGK[HQXXTZ^G\u001b\u0019\u001b\u6453\u6bfb\u517f\u9fb6\u9ae0");
        }
    }

    public static class Clone
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(final MapleClient a2, String[] a3) {
            Clone a4;
            a3 = Timer.CloneTimer.getInstance();
            int n2 = 60;
            if (!a2.getPlayer().getCanClone()) {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(5, CharacterIdChannelPair.ALLATORIxDEMO("\u539d\u55c0\u513a\u96dc\u9aa5\u51ed\u530a\u6618\u95e2\u6770\u5241zM\u51ed\u530a\u6618\u95e2lA\u7988O"));
                mapleClient.getPlayer().dropMessage(-1, EmojiFilter.ALLATORIxDEMO("\u53a0\u5599\u5107\u9685\u9a98\u51b4\u5337\u6641\u95df\u6729\u527c#p\u51b4\u5337\u6641\u95df5|\u79d1r"));
                return false;
            }
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().setCanClone(false);
            mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getChatText(a2.getPlayer().getId(), EmojiFilter.ALLATORIxDEMO("\u53ef\u55d6\u5148\u96ca\u9ad7\uff4d"), false, 1));
            mapleClient.getPlayer().cloneLook(10);
            ((Timer)a3).schedule(new Runnable(){
                {
                    1 a3;
                }

                @Override
                public /* synthetic */ void run() {
                    1 a22;
                    1 v0 = a22;
                    v0.a2.getPlayer().setCanClone(true);
                    v0.a2.getPlayer().dropMessage(5, SpecialSkillConstants.ALLATORIxDEMO("\u5139\u96b1\u9aa6\u5180\u5309\u6675\u95e1\u7d67\u672d\u0016"));
                }
            }, 60000L);
            return true;
        }

        public /* synthetic */ Clone() {
            Clone a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + CharacterIdChannelPair.ALLATORIxDEMO("26\u001e4\u0014z\\z\u539d\u55c0\u513a\u96dc\u9aa5");
        }
    }

    public static class Clones
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().cloneLook();
            return true;
        }

        public /* synthetic */ Clones() {
            Clones a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleCarnivalChallenge.ALLATORIxDEMO("\u0012p\u001er\u0014q\u0014<\\<\u7553\u7503\u513a\u9f91\u9aa5");
        }
    }

    public static class CloneMe
    extends CommandExecute {
        public /* synthetic */ CloneMe() {
            CloneMe a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + CharacterTransfer.ALLATORIxDEMO("UjYhSkS&\u001b&\u7514\u7519\u517d\u9f8b\u9ae2");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().cloneLook();
            return true;
        }
    }

    public static class MesoEveryone
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            Object object = LoginServer.getWorldStatic(a2.getWorld()).getChannels().iterator();
            while (object.hasNext()) {
                Iterator<MapleCharacter> iterator = object.next().getPlayerStorage().getAllCharactersThreadSafe().iterator();
                while (iterator.hasNext()) {
                    Iterator<MapleCharacter> iterator2;
                    iterator2.next().gainMeso(a32, true);
                    iterator = iterator2;
                }
            }
            object = "[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u7d66\u4e86 \u6240\u6709\u73a9\u5bb6 \u6953\u5e63 " + a32 + "\u9ede";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice((String)object));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + UniqueIdReset.ALLATORIxDEMO("\nc\u0014i\u0002p\u0002t\u001ei\tcG:\u651f\u91c9Y&J&\u7d01\u6246\u676e\u73af\u5bd1\u6955\u5e04");
        }

        public /* synthetic */ MesoEveryone() {
            MesoEveryone a2;
        }
    }

    public static class giveMeso
    extends CommandExecute {
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
                a2.getPlayer().dropMessage(6, CashShopConvert.ALLATORIxDEMO("\u73c4\u5bf3\u5fa8\u984d\u4e67\u7d9f"));
                return true;
            }
            a3 = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName(string);
            if (a3 == null) {
                a2.getPlayer().dropMessage(5, "\u627e\u4e0d\u5230 '" + string);
            } else {
                ((MapleCharacter)a3).gainMeso(n2, false);
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u7d66\u4e86 " + ((MapleCharacter)a3).getName() + " \u6953\u5e63 " + n2 + "\u9ede"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleCoolDownValueHolder.ALLATORIxDEMO("<B2M6F(L{\u001f\u5456\u5b74e\u0003g\u655b\u9194\u001d{\u000e{\u7d45\u73f2\u5b95\u6908\u5e40");
        }

        public /* synthetic */ giveMeso() {
            giveMeso a2;
        }
    }

    public static class SendAllNote
    extends CommandExecute {
        public /* synthetic */ SendAllNote() {
            SendAllNote a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ClientRedirector.ALLATORIxDEMO("7P*Q%Y([+A!\u0015x\u65b2\u5b13\u000bd\u5086\u9045{+A!\u7d53\u76aa\u5278\u987f\u9066\u76c0\u6275\u674d\u4e8f");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length >= 1) {
                Iterator<MapleCharacter> iterator;
                a3 = StringUtil.joinStringFrom(a3, 1);
                Iterator<MapleCharacter> iterator2 = iterator = a2.getChannelServer().getPlayerStorage().getAllCharactersThreadSafe().iterator();
                while (iterator2.hasNext()) {
                    MapleCharacter mapleCharacter = iterator.next();
                    iterator2 = iterator;
                    a2.getPlayer().sendNote(mapleCharacter.getName(), (String)a3);
                }
            } else {
                return false;
            }
            return true;
        }
    }

    public static class Disease
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            int n3;
            if (a3.length < 3) {
                return false;
            }
            if (a3[1].equalsIgnoreCase(NPCHandler.ALLATORIxDEMO("4F&O"))) {
                n2 = n3 = 120;
            } else if (a3[1].equalsIgnoreCase(UserInterfaceHandler.ALLATORIxDEMO("\u007fui\u007fuqhg"))) {
                n2 = n3 = 121;
            } else if (a3[1].equalsIgnoreCase(NPCHandler.ALLATORIxDEMO("0F&H\"M"))) {
                n2 = n3 = 122;
            } else if (a3[1].equalsIgnoreCase(UserInterfaceHandler.ALLATORIxDEMO("h`nz"))) {
                n2 = n3 = 123;
            } else if (a3[1].equalsIgnoreCase(NPCHandler.ALLATORIxDEMO("@2Q4F"))) {
                n2 = n3 = 124;
            } else if (a3[1].equalsIgnoreCase(UserInterfaceHandler.ALLATORIxDEMO("k{rgtz"))) {
                n2 = n3 = 125;
            } else if (a3[1].equalsIgnoreCase(NPCHandler.ALLATORIxDEMO("4O(T"))) {
                n2 = n3 = 126;
            } else if (a3[1].equalsIgnoreCase(UserInterfaceHandler.ALLATORIxDEMO("hq\u007faxq"))) {
                n2 = n3 = 128;
            } else if (a3[1].equalsIgnoreCase(NPCHandler.ALLATORIxDEMO("Q\"U\"Q4F"))) {
                n2 = n3 = 132;
            } else if (a3[1].equalsIgnoreCase(UserInterfaceHandler.ALLATORIxDEMO("ntyy}}m"))) {
                n2 = n3 = 133;
            } else if (a3[1].equalsIgnoreCase(NPCHandler.ALLATORIxDEMO("7L3J(M"))) {
                n2 = n3 = 134;
            } else if (a3[1].equalsIgnoreCase(UserInterfaceHandler.ALLATORIxDEMO("h|zptc"))) {
                n2 = n3 = 135;
            } else if (a3[1].equalsIgnoreCase(NPCHandler.ALLATORIxDEMO("A+J)G"))) {
                n2 = n3 = 136;
            } else if (a3[1].equalsIgnoreCase(UserInterfaceHandler.ALLATORIxDEMO("}f~qaq"))) {
                n2 = n3 = 137;
            } else {
                return false;
            }
            MapleBuffStat mapleBuffStat = MobSkill.getByMobSkill(n2);
            if (a3.length == 4) {
                String string = a3[2];
                int n4 = World.Find.findChannel(string);
                int n5 = World.Find.findWorld(string);
                if (n4 <= 0) {
                    a2.getPlayer().dropMessage(6, NPCHandler.ALLATORIxDEMO("\u73ce\u5bb5\u5fa2\u980b\u4e6d\u7dd9"));
                    return true;
                }
                MapleCharacter mapleCharacter = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterByName(string);
                if (mapleCharacter == null) {
                    a2.getPlayer().dropMessage(5, UserInterfaceHandler.ALLATORIxDEMO("\u6245\u4e39\u520b\u6b50\u7392\u5b82"));
                } else {
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    mapleCharacter2.setChair(0);
                    mapleCharacter2.getClient().sendPacket(MaplePacketCreator.cancelChair(-1));
                    mapleCharacter2.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showChair(a2.getPlayer().getId(), 0, 0), false);
                    mapleCharacter.getDiseaseBuff(mapleBuffStat, MobSkillFactory.getMobSkill(n3, CommandProcessorUtil.getOptionalIntArg(a3, 3, 1)));
                }
            } else {
                Iterator<MapleCharacter> iterator;
                Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
                while (iterator2.hasNext()) {
                    MapleCharacter mapleCharacter = iterator.next();
                    iterator2 = iterator;
                    MapleCharacter mapleCharacter3 = mapleCharacter;
                    MapleCharacter mapleCharacter4 = mapleCharacter;
                    mapleCharacter4.setChair(0);
                    mapleCharacter4.getClient().sendPacket(MaplePacketCreator.cancelChair(-1));
                    mapleCharacter3.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showChair(a2.getPlayer().getId(), 0, 0), false);
                    mapleCharacter3.getDiseaseBuff(mapleBuffStat, MobSkillFactory.getMobSkill(n3, CommandProcessorUtil.getOptionalIntArg(a3, 2, 1)));
                }
            }
            return true;
        }

        public /* synthetic */ Disease() {
            Disease a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + NPCHandler.ALLATORIxDEMO("\u0003j\u0014f\u0006p\u0002#[P\"B+,#B5H)F4PHT\"B,F),4W2MH@2Q4FHS(J4L),4O(THP\"G2@\",5F1F5P\",=L*A.E>,7L3J(MHP/B#L0,%O.M#,!Q\"F=FY#<\u89d1\u8215\u540e\u7a56^G?\u72a7\u6148\u7b2e\u7d19Y#J#\u8bf4\u4eb9\u5ff0\u5233\u721e\u6b89\u72a7\u6148");
        }
    }

    public static class KillMap
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            for (MapleCharacter mapleCharacter : a2.getPlayer().getMap().getCharactersThreadsafe()) {
                if (mapleCharacter == null || mapleCharacter.isGM()) continue;
                mapleCharacter.getStat().setHp(0);
                mapleCharacter.getStat().setMp(0);
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.updateSingleStat(MapleStat.HP, 0);
                mapleCharacter2.updateSingleStat(MapleStat.MP, 0);
            }
            return true;
        }

        public /* synthetic */ KillMap() {
            KillMap a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + RandomAccessByteStream.ALLATORIxDEMO("n$i!h,um(m\u6bbf\u63c4\u6245\u6744\u73ac\u5bfb");
        }
    }

    public static class LockItem
    extends CommandExecute {
        public /* synthetic */ LockItem() {
            LockItem a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleDiseaseValueHolder.ALLATORIxDEMO("O\u0018@\u001cJ\u0003F\u001a\u0003K\u89f1\u8205\u542e\u7a46\u001dW\u001f\u721e\u54e2>gI\u0003Z\u0003\u4e7d\u93b5\u73de\u5b95\u8edc\u4e29\u76f3\u9070\u5100");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (a3.length < 3) {
                return false;
            }
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a3[1]);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(6, ExternalCodeLongTableGetter.ALLATORIxDEMO("\u6b0f\u73fb\u5bdd\u4e74\u4e66\u5b0a\u5743"));
            } else {
                IItem iItem;
                Iterator<IItem> iterator;
                int n2 = Integer.parseInt(a3[2]);
                MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(n2);
                Iterator<IItem> iterator2 = iterator = mapleCharacter.getInventory(mapleInventoryType).listById(n2).iterator();
                while (iterator2.hasNext()) {
                    iItem = iterator.next();
                    iterator2 = iterator;
                    IItem iItem2 = iItem;
                    iItem2.setFlag(iItem2.getFlag() | ItemFlag.LOCK.getValue());
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, iItem)));
                }
                if (mapleInventoryType == MapleInventoryType.EQUIP) {
                    mapleInventoryType = MapleInventoryType.EQUIPPED;
                    iterator = mapleCharacter.getInventory(mapleInventoryType).listById(n2).iterator();
                    Iterator<IItem> iterator3 = iterator;
                    while (iterator3.hasNext()) {
                        iItem = iterator.next();
                        iterator3 = iterator;
                        IItem iItem3 = iItem;
                        iItem3.setFlag(iItem3.getFlag() | ItemFlag.LOCK.getValue());
                        mapleCharacter.getClient().sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, iItem)));
                    }
                }
                a2.getPlayer().dropMessage(6, "\u73a9\u5bb6 " + a3[1] + "\u8eab\u4e0a\u6240\u6709ID\u70ba " + a3[2] + " \u7684\u9053\u5177\u5df2\u7d93\u5f9e\u9396\u5b9a\u4e86");
            }
            return true;
        }
    }

    public static class ItemVac
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + FixDropNullItem.ALLATORIxDEMO("\u007f2S+`'Uf\u001bf\u515e\u5750\u540e\u722f\u95bd\u959a");
        }

        public /* synthetic */ ItemVac() {
            ItemVac a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient;
            boolean a32 = a2.getPlayer().getItemVac();
            if (!a32) {
                MapleClient mapleClient2 = a2;
                mapleClient = mapleClient2;
                mapleClient2.getPlayer().stopItemVac();
                mapleClient2.getPlayer().startItemVac();
            } else {
                MapleClient mapleClient3 = a2;
                mapleClient = mapleClient3;
                mapleClient3.getPlayer().stopItemVac();
            }
            mapleClient.getPlayer().dropMessage(6, "\u76ee\u524d\u81ea\u52d5\u64bf\u7269\u72c0\u614b:" + (!a32 ? FixDropNullItem.ALLATORIxDEMO("\u95bd\u5519") : CommandProcessorUtil.ALLATORIxDEMO("\u95ba\u95b1")));
            return true;
        }
    }

    public static class MobVac
    extends CommandExecute {
        public /* synthetic */ MobVac() {
            MobVac a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer().getMap().getAllMonstersThreadsafe().iterator();
            while (object.hasNext()) {
                MapleMonster mapleMonster = (MapleMonster)((MapleMapObject)a3.next());
                object = a3;
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().getMap().broadcastMessage(MobPacket.moveMonster(0 != 0, 0, 0, 0, 0, mapleMonster.getObjectId(), mapleMonster.getPosition(), a2.getPlayer().getPosition(), a2.getPlayer().getLastRes(), null, null));
                mapleMonster.setPosition(mapleClient.getPlayer().getPosition());
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + ConsoleCommandExecute.ALLATORIxDEMO("j\"e;f.'`'\u5125\u5711\u5475\u602d");
        }
    }

    public static class serverMsg
    extends CommandExecute {
        public /* synthetic */ serverMsg() {
            serverMsg a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MerchItemPackage.ALLATORIxDEMO("GIFZQ^Y_S\f\u8a3e\u6043\u0014\u0001\u0014\u66d8\u650d\u4e26\u658d\u9eef\u8246\u5140\u547e");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            StringBuilder stringBuilder;
            if (((String[])a3).length > 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(StringUtil.joinStringFrom((String[])a3, 1));
                a3 = ChannelServer.getAllChannelInstances().iterator();
                Object object = a3;
                while (object.hasNext()) {
                    ((ChannelServer)a3.next()).setServerMessage(stringBuilder.toString());
                    object = a3;
                }
            } else {
                return false;
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.serverMessage(stringBuilder.toString()));
            return true;
        }
    }

    public static class Item
    extends CommandExecute {
        public /* synthetic */ Item() {
            Item a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SharkLogger.ALLATORIxDEMO("EUIL\f\u001d\u907f\u5156ee\u0012\u0001\u0001\u0001\u53fa\u5fb6\u907f\u5156");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            String[] arrstring;
            if (a32.length < 2) {
                return false;
            }
            int n2 = 0;
            try {
                n2 = Integer.parseInt(a32[1]);
                arrstring = a32;
            }
            catch (Exception exception) {
                arrstring = a32;
            }
            short s2 = (short)CommandProcessorUtil.getOptionalIntArg(arrstring, 2, 1);
            int a32 = CommandProcessorUtil.getOptionalIntArg(a32, 3, 0);
            MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
            if (GameConstants.isPet(n2)) {
                MaplePet maplePet = MaplePet.createPet(n2, MapleInventoryIdentifierPet.getInstance());
                if (maplePet != null) {
                    MapleClient mapleClient = a2;
                    MapleInventoryManipulator.addById(mapleClient, n2, (short)1, mapleClient.getPlayer().getName(), maplePet, mapleItemInformationProvider.getPetLife(n2));
                }
            } else if (!mapleItemInformationProvider.itemExists(n2)) {
                a2.getPlayer().dropMessage(5, n2 + " - \u7269\u54c1\u4e0d\u5b58\u5728");
            } else if (a32 != 0) {
                int n3;
                int n4 = n3 = n2;
                while (n4 <= a32) {
                    if (MapleItemInformationProvider.getInstance().itemExists(n3)) {
                        client.inventory.Item item2;
                        int n5 = 0;
                        n5 = (byte)(0 | ItemFlag.LOCK.getValue());
                        if (GameConstants.getInventoryType(n3) == MapleInventoryType.EQUIP) {
                            MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
                            item2 = mapleItemInformationProvider2.randomizeStats((Equip)mapleItemInformationProvider2.getEquipById(n3));
                        } else {
                            item2 = new client.inventory.Item(n3, 0, s2, 0);
                            if (GameConstants.getInventoryType(n3) != MapleInventoryType.USE) {
                                // empty if block
                            }
                        }
                        if (GameSetConstants.COMMAND_NAME) {
                            item2.setOwner(a2.getPlayer().getName());
                        }
                        item2.setGMLog(a2.getPlayer().getName());
                        MapleInventoryManipulator.addbyItem(a2, item2);
                    }
                    n4 = ++n3;
                }
            } else {
                client.inventory.Item item3;
                if (GameConstants.getInventoryType(n2) == MapleInventoryType.EQUIP) {
                    MapleItemInformationProvider mapleItemInformationProvider3 = mapleItemInformationProvider;
                    item3 = mapleItemInformationProvider3.randomizeStats((Equip)mapleItemInformationProvider3.getEquipById(n2));
                } else {
                    item3 = new client.inventory.Item(n2, 0, s2, 0);
                    if (GameConstants.getInventoryType(n2) != MapleInventoryType.USE) {
                        // empty if block
                    }
                }
                if (GameSetConstants.COMMAND_NAME) {
                    item3.setOwner(a2.getPlayer().getName());
                }
                item3.setGMLog(a2.getPlayer().getName());
                MapleInventoryManipulator.addbyItem(a2, item3);
            }
            return true;
        }
    }

    public static class GainVP
    extends GainPoint {
        public /* synthetic */ GainVP() {
            GainVP a2;
        }
    }

    public static class GainPoint
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            String string;
            if (((String[])a3).length < 3) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, DumpItemsAdditions.ALLATORIxDEMO("\u6b43\u9676\u4e44\u8d95h"));
                return false;
            }
            int n2 = 0;
            String string2 = "";
            try {
                n2 = Integer.parseInt(a3[1]);
                string = string2 = a3[2];
            }
            catch (Exception exception) {
                string = string2;
            }
            int n3 = World.Find.findChannel(string);
            int n4 = World.Find.findWorld(string2);
            if (n3 <= 0) {
                a2.getPlayer().dropMessage(MaplePet.ALLATORIxDEMO("\u8a4e\u739e\u5b8a\u4e3a\u5714\u7ded\u4e36"));
                return true;
            }
            a3 = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName(string2);
            if (a3 == null) {
                a2.getPlayer().dropMessage(DumpItemsAdditions.ALLATORIxDEMO("\u8a3b\u738f\u5bff\u4e2b\u5761\u7dfc\u4e43"));
                return true;
            }
            Object object = a3;
            ((MapleCharacter)object).setPoints(((MapleCharacter)object).getPoints() + n2);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MaplePet.ALLATORIxDEMO("[VUYLXUYH\u0017\u0000\u654f\u91f3\t\u001c\u000b\u7395\u5b81\u0002\u0017\u0011\u0017\u53ea\u5fa0lXUYH");
        }

        public /* synthetic */ GainPoint() {
            GainPoint a2;
        }
    }

    public static class GainMaplePoint
    extends CommandExecute {
        public /* synthetic */ GainMaplePoint() {
            GainMaplePoint a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            String string;
            if (((String[])a3).length < 3) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, MapleLieDetector.ALLATORIxDEMO("\u6b37\u966f\u4e30\u8d8c\u001c"));
                return false;
            }
            int n2 = 0;
            String string2 = "";
            try {
                n2 = Integer.parseInt(a3[1]);
                string = string2 = a3[2];
            }
            catch (Exception exception) {
                string = string2;
            }
            int n3 = World.Find.findChannel(string);
            int n4 = World.Find.findWorld(string2);
            if (n3 <= 0) {
                a2.getPlayer().dropMessage(fc.ALLATORIxDEMO("\u8a20\u73be\u5be4\u4e1a\u577a\u7dcd\u4e58"));
                return true;
            }
            a3 = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName(string2);
            if (a3 == null) {
                a2.getPlayer().dropMessage(MapleLieDetector.ALLATORIxDEMO("\u8a4f\u7396\u5b8b\u4e32\u5715\u7de5\u4e37"));
                return true;
            }
            ((MapleCharacter)a3).modifyCSPoints(2, n2, true);
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u7d66\u4e86 " + ((MapleCharacter)a3).getName() + " \u6953\u8449\u9ede\u6578 " + n2 + "\u9ede"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + fc.ALLATORIxDEMO("5v;y?v\"{7g=~<cr+\u652a\u91d8l7n\u73be\u5be4)r:r\u53c1\u5fc5\u6944\u841b\u9ec9\u652a");
        }
    }

    public static class GainCash
    extends CommandExecute {
        public /* synthetic */ GainCash() {
            GainCash a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + PetHandler.ALLATORIxDEMO("f\u000fh\u0000f\u000fr\u0006!R\u6579\u91a1?N=\u73c7\u5bb7P!C!\u53b8\u5f96)`\u001di\u9eb0\u6579");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 3) {
                return false;
            }
            if (GameSetConstants.isLimitGM(a2.getPlayer())) {
                a2.getPlayer().dropMessage(5, SpecialEquipData.ALLATORIxDEMO("\u6b26\u9669\u4e21\u8d8a\r"));
                return false;
            }
            int n2 = 0;
            Object object = "";
            try {
                n2 = Integer.parseInt(a3[1]);
                object = a3[2];
            }
            catch (Exception exception) {
                return false;
            }
            int n3 = World.Find.findChannel((String)object);
            int n4 = World.Find.findWorld((String)object);
            if (n3 <= 0) {
                a2.getPlayer().dropMessage(PetHandler.ALLATORIxDEMO("\u8a73\u73c7\u5bb7\u4e63\u5729\u7db4\u4e0b"));
                return true;
            }
            a3 = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName((String)object);
            if (a3 == null) {
                a2.getPlayer().dropMessage(SpecialEquipData.ALLATORIxDEMO("\u8a5e\u7390\u5b9a\u4e34\u5704\u7de3\u4e26"));
                return true;
            }
            Object object2 = a3;
            int n5 = n2;
            ((MapleCharacter)object2).modifyCSPoints(1, n5, true);
            ((MapleCharacter)object2).dropMessage("\u5df2\u7d93\u6536\u5230Gash\u9ede\u6578" + n5 + "\u9ede");
            object = "[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u7d66\u4e86 " + ((MapleCharacter)a3).getName() + " Gash\u9ede\u6578 " + n2 + "\u9ede";
            FileoutputUtil.logToFile(PetHandler.ALLATORIxDEMO("\u0002n\trAF#^\"N).\u7d08\u4e89\u9eb0\u6579@u\u0016u"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a2.getSession().remoteAddress().toString().split(SpecialEquipData.ALLATORIxDEMO("\u0016"))[0] + " GM " + a2.getPlayer().getName() + " \u7d66\u4e86 " + ((MapleCharacter)a3).getName() + " Gash\u9ede\u6578 " + n2 + "\u9ede");
            return true;
        }
    }

    public static class GodMode
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a2.getPlayer();
            if (((MapleCharacter)a3).isInvincible()) {
                Object object = a3;
                ((MapleCharacter)object).setInvincible(false);
                ((MapleCharacter)object).dropMessage(6, MTSCSPacket.ALLATORIxDEMO("\u7104\u655f\u5dd7\u7db9\u95f9\u95a3"));
            } else {
                Object object = a3;
                ((MapleCharacter)object).setInvincible(true);
                ((MapleCharacter)object).clearAllCooldowns();
                ((MapleCharacter)a3).dropMessage(6, \u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u7150\u6503\u5d83\u7de5\u95fa\u5529_"));
            }
            return true;
        }

        public /* synthetic */ GodMode() {
            GodMode a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MTSCSPacket.ALLATORIxDEMO("MJNHEAO\u0005\n\b\n\u7104\u655f\u95ae\u95f6");
        }
    }

    public static class Fame
    extends CommandExecute {
        public /* synthetic */ Fame() {
            Fame a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            short a32;
            MapleCharacter mapleCharacter = a2.getPlayer();
            if (a32.length < 2) {
                return false;
            }
            String string = a32[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0) {
                return false;
            }
            MapleCharacter mapleCharacter2 = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            try {
                a32 = Short.parseShort(a32[2]);
            }
            catch (Exception exception) {
                a2.getPlayer().dropMessage(6, EmojiFilter.ALLATORIxDEMO("\u4e0e\u5444\u6cd6\u76c8\u657b\u5b1b"));
                return false;
            }
            if (mapleCharacter2 != null && mapleCharacter.allowedToTarget(mapleCharacter2)) {
                mapleCharacter2.addFame(a32);
                MapleCharacter mapleCharacter3 = mapleCharacter2;
                mapleCharacter3.updateSingleStat(MapleStat.FAME, mapleCharacter3.getFame());
            } else {
                a2.getPlayer().dropMessage(6, FixDropNullItem.ALLATORIxDEMO("m W+S\u001b\u0016\u8994\u8244\u4e4b\u5b6e\u576e"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + EmojiFilter.ALLATORIxDEMO("e-n)#p\u89d1\u823e\u540e\u7a7d=l?\u5441\u8071r#b-b#l.l\u540e\u803e");
        }
    }

    public static class SavePlayerShops
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MobConstants.ALLATORIxDEMO("qUtQRXcMgFQ\\mDq\u0014/\u0014\u5130\u5b6c\u7cbc\u977c\u5544\u4e8e");
        }

        public /* synthetic */ SavePlayerShops() {
            SavePlayerShops a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = ChannelServer.getAllChannelInstances().iterator();
            while (object.hasNext()) {
                ((ChannelServer)a3.next()).closeAllMerchant();
                object = a3;
            }
            a2.getPlayer().dropMessage(6, BankSystem.ALLATORIxDEMO("\u7cc9\u973b\u5531\u4ec9\u5145\u5b2b\u5bfb\u7511Y"));
            return true;
        }
    }

    public static class GC
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            System.gc();
            System.out.println("\u7cfb\u7d71\u91cb\u653e\u8a18\u61b6\u9ad4 ---- " + FileoutputUtil.NowTime());
            return true;
        }

        public /* synthetic */ GC() {
            GC a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleMessengerCharacter.ALLATORIxDEMO("IG.).\u7cff\u7d7f\u91cf\u6530\u8a1c\u61b8\u9ad0");
        }
    }

    public static class itemlog
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + SharkReader.ALLATORIxDEMO("\n&&?\u000f=$r\u007f\u73fb\u5bf5\u545f\u7a72lc\u007fc\u5245\u51b9\u73fb\u5bf5\u8ef9\u4e49\u888f\u50da");
        }

        public /* synthetic */ itemlog() {
            itemlog a2;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object;
            int n2;
            Object object2;
            Object object3;
            block20: {
                if (((String[])a3).length < 2) {
                    return false;
                }
                a3 = a3[1];
                object2 = object3 = a3[2];
                int n3 = -1;
                switch (((String)object2).hashCode()) {
                    case 34337576: {
                        if (!((String)object2).equals(SharkReader.ALLATORIxDEMO("\u889e\u50cb\u6b47"))) break;
                        n2 = n3 = 0;
                        break block20;
                    }
                    case 27990357: {
                        if (!((String)object2).equals(BeansPacket.ALLATORIxDEMO("\u6dad\u8055\u6b21"))) break;
                        n2 = n3 = 1;
                        break block20;
                    }
                    case 34912099: {
                        if (!((String)object2).equals(SharkReader.ALLATORIxDEMO("\u889e\u98ac\u6b47"))) break;
                        n2 = n3 = 2;
                        break block20;
                    }
                    case 20693732: {
                        if (!((String)object2).equals(BeansPacket.ALLATORIxDEMO("\u5153\u4e94\u6b21"))) break;
                        n2 = n3 = 3;
                        break block20;
                    }
                    case 29042931: {
                        if (!((String)object2).equals(SharkReader.ALLATORIxDEMO("\u723a\u6bd8\u6b47"))) break;
                        n3 = 4;
                    }
                }
                n2 = n3;
            }
            switch (n2) {
                case 0: {
                    object = MapleInventoryType.EQUIP;
                    break;
                }
                case 1: {
                    object = MapleInventoryType.USE;
                    break;
                }
                case 2: {
                    object = MapleInventoryType.SETUP;
                    break;
                }
                case 3: {
                    object = MapleInventoryType.ETC;
                    break;
                }
                case 4: {
                    object = MapleInventoryType.CASH;
                    break;
                }
                default: {
                    object = null;
                }
            }
            object2 = new MapleClient(null, null, new MockIOSession());
            Object object4 = MapleCharacter.getCharacterByName((String)a3);
            if (object4 == null) {
                a2.getPlayer().dropMessage(5, BeansPacket.ALLATORIxDEMO("\u623c\u4e28\u5272\u6b41\u70f8\u738c\u5bf4\u0004"));
                return false;
            }
            if (object == null) {
                a2.getPlayer().dropMessage(5, SharkReader.ALLATORIxDEMO("\u8f7b\u5137\u57c8\u6119\u936c\u8af6b\u8a99\u8f7b\u5137b;77.>,5c\u001b\u0007r\u889e\u50cb\u6b47}\u6dcb\u8045\u6b47}\u889e\u98ac\u6b47}\u5135\u4e84\u6b47}\u723a\u6bd8\u6b47"));
                return false;
            }
            if (((MapleCharacter)object4).getInventory((MapleInventoryType)((Object)object)).list().isEmpty()) {
                a2.getPlayer().dropMessage(5, "\u60a8\u7684 " + (String)object3 + " \u7121\u4efb\u4f55\u7269\u54c1\u3002");
                return true;
            }
            a3 = "<" + ((MapleCharacter)object4).getName() + ">\r\n";
            Object object5 = object3 = ((MapleCharacter)object4).getInventory((MapleInventoryType)((Object)object)).list().iterator();
            while (true) {
                if (!object5.hasNext()) {
                    a3 = (String)a3 + "-----------------------------------------------------------------";
                    FileoutputUtil.logToFile(BeansPacket.ALLATORIxDEMO("\u000eJ%Vmb\u000fz\u000ej\u0005\n\u000bQ'H\u000eJ%\u000b6]6\n"), (String)a3 + "\r\n");
                    ((MapleClient)object2).getSession().close();
                    return true;
                }
                int n4 = ((IItem)object3.next()).getItemId();
                object4 = MapleItemInformationProvider.getInstance().getName(n4);
                object = "\u7269\u54c1\u7de8\u865f:" + n4 + " \u7269\u54c1\u540d\u7a31:" + (String)object4;
                a3 = (String)a3 + (String)object + "\r\n";
                object5 = object3;
                a2.getPlayer().dropMessage((String)object);
            }
        }
    }

    public static class ItemList
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getCommandPrefix() + MapleLieDetector.ALLATORIxDEMO("vIZPsTLI\u001f\u0001\u7396\u5b8b\u5432\u7a0c\u0001\u001d\u0012\u001d\u5fa8\u520d\u7396\u5b8b\u8e94\u4e37\u88e2\u50a4");
        }

        public /* synthetic */ ItemList() {
            ItemList a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = a3[1];
            MapleClient mapleClient = new MapleClient(null, null, new MockIOSession());
            a3 = MapleCharacter.loadCharFromDB(MapleCharacterUtil.getIdByName((String)a3), mapleClient, true);
            String string = "<" + ((MapleCharacter)a3).getName() + ">\r\n";
            Object object = a3 = ((MapleCharacter)a3).getInventory(MapleInventoryType.EQUIPPED).list().iterator();
            while (object.hasNext()) {
                IEquip iEquip = (IEquip)((IItem)a3.next()).copy();
                int n2 = iEquip.getItemId();
                short s2 = iEquip.getStr();
                short s3 = iEquip.getDex();
                short s4 = iEquip.getInt();
                short s5 = iEquip.getLuk();
                short s6 = iEquip.getHp();
                short s7 = iEquip.getMp();
                short s8 = iEquip.getWatk();
                short s9 = iEquip.getMatk();
                short s10 = iEquip.getWdef();
                short s11 = iEquip.getMdef();
                byte by = iEquip.getLevel();
                short s12 = iEquip.getAcc();
                short s13 = iEquip.getAvoid();
                short s14 = iEquip.getSpeed();
                short s15 = iEquip.getJump();
                byte by2 = iEquip.getUpgradeSlots();
                String string2 = "!ProItem " + n2 + " " + s2 + " " + s3 + " " + s4 + " " + s5 + " " + s6 + " " + s7 + " " + s8 + " " + s9 + " " + s10 + " " + s11 + " " + by + " " + s12 + " " + s13 + " " + s14 + " " + s15 + " " + by2 + " -1";
                string = string + string2 + "\r\n";
                object = a3;
                a2.getPlayer().dropMessage(string2);
            }
            FileoutputUtil.logToFile(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"8\"\u0013>[\n9\u00128\u00023b=9\u0011 8$\u00079Z9\f9["), string + "\r\n");
            mapleClient.getSession().close();
            return true;
        }
    }
}

