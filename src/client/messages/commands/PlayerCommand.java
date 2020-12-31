/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.PlayerCommand$\u6389\u5bf6\u67e5\u8a62
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 */
package client.messages.commands;

import FuckingHackerToby.fc;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleFriendship;
import client.MapleStat;
import client.SkillEntry;
import client.inventory.Equip;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.messages.CommandExecute;
import client.messages.CommandProcessor;
import client.messages.commands.InternCommand;
import client.messages.commands.PlayerCommand;
import client.messages.commands.player.eventSystem.SellSystem;
import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.PiPiConfig;
import constants.ServerConstants;
import database.DatabaseException;
import handling.channel.handler.PetHandler;
import handling.world.World;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import scripting.npc.NPCScriptManager;
import scripting.reactor.ReactorScriptManager;
import server.Extend.SpecialEquipFactory;
import server.Framework.MapleExtendedSlots;
import server.MapleInventoryManipulator;
import server.MerchItemPackage;
import server.Timer;
import server.life.MapleMonster;
import server.life.MapleMonsterInformationProvider;
import server.maps.Event_PyramidSubway;
import server.maps.MapNameData;
import server.maps.MapleMap;
import server.maps.MapleMapEffect;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.swing.WvsCenter;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.JsonMapConverter;
import tools.LoadPacket;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.StringUtil;
import tools.data.RandomAccessByteStream;
import tools.npcgenerator.NPCMessage;
import tools.packet.MTSCSPacket;
import tools.wztosql.DumpItemsAdditions;

public class PlayerCommand {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ 2 << 1;
        int cfr_ignored_0 = 4 << 4 ^ 1 << 1;
        int n5 = n3;
        int n6 = 1 << 3 ^ (3 ^ 5);
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

    public /* synthetic */ PlayerCommand() {
        PlayerCommand a2;
    }

    public static class Kill
    extends CommandExecute {
        public /* synthetic */ Kill() {
            Kill a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, MaplePacketOperation.ALLATORIxDEMO("`.I)Le\u6b9a\u6b3e\u67f0\u4ede\u7259\u5bdf\u600a\u722c")).toString();
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleMap mapleMap = a2.getPlayer().getMap();
            double d2 = Double.POSITIVE_INFINITY;
            boolean bl = false;
            bl = false;
            if (mapleMap == null) {
                a2.getPlayer().dropMessage("\u5730\u5716[" + (String)a32[2] + "] \u4e0d\u5b58\u5728\u3002");
                return true;
            }
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
            List<MapleMapObject> list = mapleMap.getMapObjectsInRange(a2.getPlayer().getPosition(), d2, Arrays.asList(arrmapleMapObjectType));
            Iterator<MapleMapObject> iterator = list.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    a2.getPlayer().dropMessage("\u60a8\u7e3d\u5171\u6bba\u4e86 " + list.size() + " \u602a\u7269");
                    return true;
                }
                MapleMonster a32 = (MapleMonster)iterator.next();
                boolean bl2 = false;
                switch (a32.getId()) {
                    case 8090000: {
                        bl2 = true;
                        break;
                    }
                }
                if (!bl2) continue;
                mapleMap.killMonster(a32, a2.getPlayer(), false, false, (byte)1);
            }
        }
    }

    public static class eq
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\r\u0011<Tq\u6848\u6535J`T\u634a\u4e90\u7a32\u88a9")).toString();
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            short a32 = Short.parseShort(a32[1]);
            short[] arrs = ItemConstants.getEquipedSlot(((Equip)a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a32)).getItemId());
            MapleInventoryManipulator.equip(a2, a32, arrs[0]);
            return true;
        }

        public /* synthetic */ eq() {
            eq a2;
        }
    }

    public static class look
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"=m\u0012n\u0016!P!\u6798\u770a\u73d4\u5bb7\u72bd\u614a")).toString();
        }

        public /* synthetic */ look() {
            look a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            String string = a3[1];
            a3 = MapleCharacter.getCharacterByName(string);
            int n2 = World.Find.findChannel(string);
            if (a3 != null) {
                if (((MapleCharacter)a3).getGMLevel() > a2.getPlayer().getGMLevel()) {
                    a2.getPlayer().dropMessage(5, DatabaseException.ALLATORIxDEMO("\u4f4a\u4e51\u80d7\u67b9\u7721\u6b88\u4f4a\u9a84\u6b20\u960c\u76ae\u4ee6\u000b"));
                } else {
                    n2 = 0;
                    try {
                        if (((MapleCharacter)a3).getStorage() != null) {
                            n2 = ((MapleCharacter)a3).getStorage().getMeso();
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    MapleClient mapleClient = a2;
                    mapleClient.getPlayer().dropMessage(5, \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u6b19\u73a8\u5bcb\u72c1\u6136;"));
                    mapleClient.getPlayer().dropMessage(5, "\u73a9\u5bb6\u540d\u7a31: " + ((MapleCharacter)a3).getName());
                    a2.getPlayer().dropMessage(5, " \u7b49\u7d1a: " + ((MapleCharacter)a3).getLevel() + " \u8077\u696d: " + ((MapleCharacter)a3).getJob() + " \u540d\u8072: " + ((MapleCharacter)a3).getFame());
                    a2.getPlayer().dropMessage(5, "\u76ee\u524dHP: " + ((MapleCharacter)a3).getStat().getHp() + " \u76ee\u524dMP: " + ((MapleCharacter)a3).getStat().getMp());
                    a2.getPlayer().dropMessage(5, "\u6700\u5927HP: " + ((MapleCharacter)a3).getStat().getMaxHp() + " \u6700\u5927MP: " + ((MapleCharacter)a3).getStat().getMaxMp());
                }
            } else {
                a2.getPlayer().dropMessage(5, DatabaseException.ALLATORIxDEMO("\u6254\u4e51\u521a\u6b38\u7383\u5bea\u0004"));
            }
            return true;
        }
    }

    public static class dp
    extends \u6389\u5bf6\u67e5\u8a62 {
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, LoadPacket.ALLATORIxDEMO("SSc\u0017>\u0017\u67f6\u8a55\u6039\u725e\u639a\u5bc1")).toString();
        }

        public /* synthetic */ dp() {
            dp a2;
        }
    }

    public static class mobdrop
    extends \u6389\u5bf6\u67e5\u8a62 {
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, Event_PyramidSubway.ALLATORIxDEMO("d7K8@(K*\u0004w\u0004\u67bf\u8a46\u6070\u724d\u63d3\u5bd2")).toString();
        }

        public /* synthetic */ mobdrop() {
            mobdrop a2;
        }
    }

    public static class dice
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + MapleFriendship.ALLATORIxDEMO("|B{N8\u00068\u5703\u5728\u573d\u4e12\u9a9b\u51e2\u001a5\u001d\u9ec6\u9683\u6a47\u9ef5\u6560");
        }

        @Override
        public /* synthetic */ boolean execute(final MapleClient a2, String[] a3) {
            dice a4;
            a3 = Timer.BuffTimer.getInstance();
            if (a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).findById(1142522) == null) {
                a2.getPlayer().dropMessage(5, SkillEntry.ALLATORIxDEMO("\u6099\u9715\u89b0\u9158\u62055\u5b55\u96e7\u4e27\u7559\u62a4\u9aa5\u907b\u6227\u0011\u52e6\u7ad19\u627c\u53fa\u4ed4\u4f6a\u7519\u9aa5\u9eef\u7691\u52ae\u80e8\u55064"));
                return true;
            }
            int n2 = 10;
            if (a2.getPlayer().getCanDice()) {
                Iterator<MapleCharacter> iterator;
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().setCanDice(false);
                n2 = (int)Math.floor(Math.random() * 6.0 + 1.0);
                mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getChatText(a2.getPlayer().getId(), "\u6211\u9ab0\u51fa\u4e86\u9ede\u6578 " + n2 + " \u9ede\uff01", false, 1));
                a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.serverNotice(a2.getPlayer().getName() + " \u9ab0\u51fa\u4e86\u9ede\u6578 " + n2 + " \u9ede\uff01"));
                Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
                while (iterator2.hasNext()) {
                    iterator.next().dropMessage(-1, a2.getPlayer().getName() + " \u9ab0\u51fa\u4e86\u9ede\u6578" + n2 + " \u9ede\uff01");
                    iterator2 = iterator;
                }
            } else {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(5, MapleFriendship.ALLATORIxDEMO("\u9a9b\u5b48\u519c\u5363\u6669\u958b\u6701\u5228\u000b$\u519c\u5363\u6669\u958b\u001a\u521e\u9433&"));
                mapleClient.getPlayer().dropMessage(-1, SkillEntry.ALLATORIxDEMO("\u9a81\u5b45\u5186\u536e\u6673\u9586\u671b\u5225\u0011)\u5186\u536e\u6673\u9586\u0000\u5213\u9429+"));
                return false;
            }
            ((Timer)a3).schedule(new Runnable(){

                @Override
                public /* synthetic */ void run() {
                    1 a22;
                    1 v0 = a22;
                    v0.a2.getPlayer().setCanDice(true);
                    v0.a2.getPlayer().dropMessage(5, Event_PyramidSubway.ALLATORIxDEMO("\u9a94\u5b0a\u5193\u5321\u6666\u95c9\u7d74\u6705\u0005"));
                }
                {
                    1 a3;
                }
            }, 10000L);
            return true;
        }

        public /* synthetic */ dice() {
            dice a2;
        }
    }

    public static class CGM
    extends CommandExecute {
        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            block24: {
                block27: {
                    block26: {
                        block25: {
                            block23: {
                                var3_3 = 0;
                                if (a.length < 2) {
                                    return false;
                                }
                                var4_4 = StringUtil.joinStringFrom(a, 1);
                                if (a.getPlayer().isGM()) {
                                    a.getPlayer().dropMessage(6, DumpItemsAdditions.ALLATORIxDEMO("\u56a9\u709c\u4f29\u81cc\u5db8\u6609\u000ek\u6209\u4ec3\u7168\u6cf3\u4f36\u750e\u6b2d\u6321\u4ead\n\u53a6\u4ec3\u565e\u8a40hE'A$\u0006u\u8a2c\u6026\u0018i\u4fa0\u5eb3\u7aed\u000ek\u8003\u590f\u9872\u90757"));
                                    return true;
                                }
                                if (a.getPlayer().getCheatTracker().GMSpam(100000, 1)) {
                                    a.getPlayer().dropMessage(6, DumpItemsAdditions.ALLATORIxDEMO("\u70f3\u4ea0\u967b\u6b44\u5c44a\u0004\u5211\u5c06\u6266\u4eac\u6be9x\u5220\u9451\u53cc\u80b4\u765a\u4e49\u6b07g"));
                                    return true;
                                }
                                var5_5 = 0;
                                var6_6 = true;
                                if (PiPiConfig.getBlackList().containsKey(a.getAccID())) {
                                    var5_5 = 1;
                                }
                                if (var4_4.contains(PetHandler.ALLATORIxDEMO("\u6437")) && var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u575f"))) {
                                    v0 = var4_4;
                                    a.getPlayer().dropMessage(1, PetHandler.ALLATORIxDEMO("\u6458\u5717\u8184\u884d\u898d\u6c7b\uff6f\uff00"));
                                    var5_5 = 1;
                                    var6_6 = false;
                                } else if (var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u88e2")) && var4_4.contains(PetHandler.ALLATORIxDEMO("\u9a18")) || var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u9e97")) && var4_4.contains(PetHandler.ALLATORIxDEMO("\u9a18"))) {
                                    a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u88e2\u9a3f\u8a82\u81cc\u8805\u89c5\u6c33"));
                                    var5_5 = 1;
                                    var6_6 = false;
                                    v0 = var4_4;
                                } else if (var4_4.contains(PetHandler.ALLATORIxDEMO("\u88aa")) && var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u7695"))) {
                                    v0 = var4_4;
                                    a.getPlayer().dropMessage(1, PetHandler.ALLATORIxDEMO("\u88aa\u76b2\u8aca\u8184\u884d\u898d\u6c7b"));
                                    var5_5 = 1;
                                    var6_6 = false;
                                } else if (var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u5263")) && (var4_4.contains(PetHandler.ALLATORIxDEMO("\u89d3")) || var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u813a"))) && var4_4.contains(PetHandler.ALLATORIxDEMO("\u932e"))) {
                                    v0 = var4_4;
                                    a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u5263\u9309\u899b\u8254\u8a82\u81cc\u8805\u89c5\u6c33"));
                                    var5_5 = 1;
                                    var6_6 = false;
                                } else if (var4_4.contains(PetHandler.ALLATORIxDEMO("\u4e83")) && var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u5444")) && var4_4.contains(PetHandler.ALLATORIxDEMO("\u8073"))) {
                                    v0 = var4_4;
                                    a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u8a82\u81cc\u8805\u89c5\u6c33"));
                                    var5_5 = 1;
                                    var6_6 = false;
                                } else if (var4_4.contains(PetHandler.ALLATORIxDEMO("\u5bc7")) && var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u54db")) && var4_4.contains(PetHandler.ALLATORIxDEMO("\u8ce2"))) {
                                    v0 = var4_4;
                                    a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u5be0\u54db\u8cc5\u76cd\u50df\u6875\u5dd4\u7dda\u66d2\u6570\u709cx\u6975\u5e2a\u7107\u8aed"));
                                    var5_5 = 1;
                                    var6_6 = false;
                                } else {
                                    if (var4_4.contains(PetHandler.ALLATORIxDEMO("\u6538")) && var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u5b8f")) && var4_4.contains(PetHandler.ALLATORIxDEMO("\u78bd"))) {
                                        a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u76c8\u5204\u7b0a\u4ec5\u7d62\u5b8f\u789a\u5383\u5be0\u78f5\u7107\u6c9c\u67c3\u8a2b\u53ec\u66bd\u651fe"));
                                        var5_5 = 1;
                                        var6_6 = false;
                                    }
                                    v0 = var4_4;
                                }
                                if ((!v0.contains(PetHandler.ALLATORIxDEMO("\u5528\u4ebb")) && !var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u7c98\u9701")) || !var4_4.contains(PetHandler.ALLATORIxDEMO("\u5402"))) && (!var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u5560\u5ede")) || !var4_4.contains(PetHandler.ALLATORIxDEMO("\u88b2\u511e")))) break block23;
                                a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u76a7\u526b\u7cf7\u976e\u550f\u4e9c\u8894\u50bf\u54c5\u6975\u5e2a\u672f\u6a16\u73a1\u88e2\u5425D,\u59cb\u888d\u544a\u4ea0\u8a82\u52ff\u5f8c\u5c21\u753f\u6664\u76cd\u60e3\u6c88\u5baa\u653d\u63e9\u8fb9\u7d40\u7be8\u7420\u54a8+C+Cv\u001a\u001ci\u4e2b\u674a\u88fa\u5156\u4edd\u4f1c\u724f\u5488"));
                                var3_3 = 1;
                                v1 = var6_6;
                                break block24;
                            }
                            if (!var4_4.contains(PetHandler.ALLATORIxDEMO("\u6a95")) || !var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u6801")) || !var4_4.contains(PetHandler.ALLATORIxDEMO("\u53d6")) || !var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u6444"))) break block25;
                            a.getPlayer().dropMessage(1, PetHandler.ALLATORIxDEMO("\u6afa\u6849\u53b9\u640c\u8aa5\u91cc\u65de\u89e2\u58bd\u7e2f\u4e55\u7a0a\u5f61\u5536"));
                            var3_3 = 1;
                            v1 = var6_6;
                            break block24;
                        }
                        if (!var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u7f73")) && !var4_4.contains(PetHandler.ALLATORIxDEMO("\u5c10")) || (!var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u62c9")) || !var4_4.contains(PetHandler.ALLATORIxDEMO("\u80fc")) || !var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u9e97"))) && !var4_4.toUpperCase().contains(PetHandler.ALLATORIxDEMO("=Q"))) break block26;
                        a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u7f73\u5c37\u62c9\u80db\u9e97\u8aed\u9184\u7dd2\uff45\u6cb4\u6740\u5150\u4e9f\u659f\u6c9c\u4ea0\u557e"));
                        var3_3 = 1;
                        v1 = var6_6;
                        break block24;
                    }
                    if (!var4_4.contains(PetHandler.ALLATORIxDEMO("\u6ba3\u66f9"))) break block27;
                    if (!var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u7022\u6d67\u6656"))) ** GOTO lbl91
                    a.getPlayer().dropMessage(1, PetHandler.ALLATORIxDEMO("\u62ee\u80fc5\u706a\u6d2f\u661e3!\u4e48\u6c93\u6767\u6bcc\u6696\u5536"));
                    var3_3 = 1;
                    v1 = var6_6;
                    break block24;
                }
                if (var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u9ef7\u7b6f")) && var4_4.contains(PetHandler.ALLATORIxDEMO("\u4e0c")) && (var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u63c0")) || var4_4.contains(PetHandler.ALLATORIxDEMO("\u5675")))) {
                    MapleMonsterInformationProvider.getInstance().clearDrops();
                    ReactorScriptManager.getInstance().clearDrops();
                    a.getPlayer().dropMessage(1, DumpItemsAdditions.ALLATORIxDEMO("\u9ef7\u7b6f\u63af\u8474\u6a79\u73ce\u5069\u4f07+C\u8aed\u621a\u0017|\u0016\u587d\u4ec3\u4e43\u6cb4\u6740\u5652\u51c4\u56f8\u5878"));
                    var3_3 = 1;
                    v1 = var6_6;
                } else {
                    if (var4_4.contains(PetHandler.ALLATORIxDEMO("\u9397")) && var4_4.contains(DumpItemsAdditions.ALLATORIxDEMO("\u5bbf"))) {
                        a.getPlayer().dropMessage(1, PetHandler.ALLATORIxDEMO("\u672d\u4f54\u670c\u5606\u76ef\u5223\u4e27\u6744\u9397\u5b98\fd\u53eb\u6767\u5c1b\u6744\u6dfa\u52ce\u7685\u63e7\u5bf7\u8ca9\u6598\u6278\u662e\u63e7\u843c\u6a31\u7386\u5021\u4f4f"));
                        var3_3 = 1;
                    }
lbl91:
                    // 4 sources

                    v1 = var6_6;
                }
            }
            if (v1) {
                v2 = a;
                v2.sendCGMLog(v2, var4_4);
                v2.getPlayer().dropMessage(6, DumpItemsAdditions.ALLATORIxDEMO("\u8a43\u6049\u5dbb\u7db5\u5b8d\u9027\u7d2fa\u0004\u4ea0h"));
            }
            if (var5_5 == 0) {
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getWhisper(a.getPlayer().getName(), 1, "[\u7ba1\u7406\u54e1\u5e6b\u5e6b\u5fd9] " + var4_4 + (var3_3 != 0 ? PetHandler.ALLATORIxDEMO("!C,N)\u7c95\u7d70\u5d9c\u81eb\u52bb\u56df\u5fc7(") : "")));
                if (System.getProperty(DumpItemsAdditions.ALLATORIxDEMO("u=G;R\u000b_\u001aQ H.")) != null) {
                    WvsCenter.addChatLog("[\u7ba1\u7406\u54e1\u5e6b\u5e6b\u5fd9] " + a.getPlayer().getName() + ": " + StringUtil.joinStringFrom(a, 1) + (var3_3 != 0 ? PetHandler.ALLATORIxDEMO("!C,N)\u7c95\u7d70\u5d9c\u81eb\u52bb\u56df\u5fc7(") : "") + "\r\n");
                }
            }
            FileoutputUtil.logToFile(DumpItemsAdditions.ALLATORIxDEMO("J&A:\t\rG=Gf\u7b87\u744f\u54c7\u5e22\u5e4d\u5f90\b=^="), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6[" + a.getPlayer().getName() + "] \u5e33\u865f[" + a.getAccountName() + "]: " + var4_4 + (var3_3 != 0 ? PetHandler.ALLATORIxDEMO("!C,N)\u7c95\u7d70\u5d9c\u81eb\u52bb\u56df\u5fc7(") : "") + "\r\n");
            return true;
        }

        public /* synthetic */ CGM() {
            CGM a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + PetHandler.ALLATORIxDEMO("b\tlN,N\u8dde)L\u56b0\u5830");
        }
    }

    public static class mob
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + MapleExtendedSlots.ALLATORIxDEMO("J7Ex\nx\u67c2\u7753\u600d\u7231\u72e7\u6113");
        }

        public /* synthetic */ mob() {
            mob a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            a3 = a2.getPlayer().getMap().getAllMonstersThreadsafe();
            int n3 = n2 = 0;
            while (n3 < a3.size()) {
                MapleMonster mapleMonster = (MapleMonster)a3.get(n2);
                if (mapleMonster.isAlive()) {
                    a2.getPlayer().dropMessage(6, "\u602a\u7269 " + mapleMonster.toStringPlayer());
                }
                n3 = ++n2;
            }
            if (a3 == null) {
                a2.getPlayer().dropMessage(6, MapNameData.ALLATORIxDEMO("\u623b\u4e1d\u5275\u5720\u5753\u4e1a\u76c1\u603a\u722c"));
            }
            return true;
        }
    }

    public static class ea
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + InternCommand.ALLATORIxDEMO("`P%\u001c%\u89d2\u5364");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            MapleClient mapleClient = a2;
            mapleClient.removeClickedNPC();
            MapleClient mapleClient2 = a2;
            NPCScriptManager.getInstance().dispose(mapleClient2);
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            mapleClient2.getPlayer().dropMessage(-1, InternCommand.ALLATORIxDEMO("\u89d2\u5364\u5bbd\u7567\u001f+"));
            mapleClient.getPlayer().dropMessage(5, "\u73fe\u5728\u6642\u9593:" + FileoutputUtil.NowTime2());
            if (SpecialEquipFactory.getInstance().getTotalEquipExp(a2.getPlayer()) > 0 || SpecialEquipFactory.getInstance().getTotalEquipDrop(a2.getPlayer()) > 0 || SpecialEquipFactory.getInstance().getTotalEquipMeso(a2.getPlayer()) > 0) {
                MapleClient mapleClient3 = a2;
                mapleClient3.getPlayer().dropMessage(5, MaplePet.ALLATORIxDEMO("\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31"));
                mapleClient3.getPlayer().dropMessage(5, InternCommand.ALLATORIxDEMO("\u987c\u5913\u88ec\u509c\u5291\u6304"));
                mapleClient3.getPlayer().dropMessage(5, "\u88dd\u5099\u52a0\u6301\u7d93\u9a57\u500d\u7387: " + SpecialEquipFactory.getInstance().getTotalEquipExp(a2.getPlayer()) + "% \u88dd\u5099\u52a0\u6301\u6389\u5bf6\u500d\u7387: " + SpecialEquipFactory.getInstance().getTotalEquipDrop(a2.getPlayer()) + "% \u88dd\u5099\u52a0\u6301\u6953\u5e63\u500d\u7387: " + SpecialEquipFactory.getInstance().getTotalEquipMeso(a2.getPlayer()) + "%");
                a2.getPlayer().dropMessage(5, MaplePet.ALLATORIxDEMO("\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31"));
            }
            if (a2.getChannelServer().getExpRate(a2.getPlayer().getWorld()) > (double)GameSetConstants.EXP_RATE || a2.getChannelServer().getDropRate(a2.getPlayer().getWorld()) > (double)GameSetConstants.DROP_RATE || a2.getChannelServer().getMesoRate(a2.getPlayer().getWorld()) > GameSetConstants.MESO_RATE) {
                MapleClient mapleClient4 = a2;
                mapleClient4.getPlayer().dropMessage(5, InternCommand.ALLATORIxDEMO("\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08"));
                mapleClient4.getPlayer().dropMessage(5, MaplePet.ALLATORIxDEMO("\u76d9\u5271\u708d\u4f06\u673a\u5654\u5297\u5031\u6675\u6b89"));
                mapleClient4.getPlayer().dropMessage(5, "\u4f3a\u670d\u5668\u7576\u524d\u7d93\u9a57\u500d\u7387: " + a2.getChannelServer().getExpRate(a2.getPlayer().getWorld()) * 100.0 + "% \u4f3a\u670d\u5668\u7576\u524d\u6389\u5bf6\u500d\u7387: " + a2.getChannelServer().getDropRate(a2.getPlayer().getWorld()) * 100.0 + "% \u4f3a\u670d\u5668\u7576\u524d\u6953\u5e63\u500d\u7387: " + a2.getChannelServer().getMesoRate(a2.getPlayer().getWorld()) * 100 + "%");
                a2.getPlayer().dropMessage(5, InternCommand.ALLATORIxDEMO("\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08\uff3c\uff08"));
            }
            if (GameSetConstants.isHell(a2.getPlayer().getClient().getChannel())) {
                MapleClient mapleClient5 = a2;
                mapleClient5.getPlayer().dropMessage(5, MaplePet.ALLATORIxDEMO("\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31"));
                mapleClient5.getPlayer().dropMessage(5, InternCommand.ALLATORIxDEMO("\u76eb\u527c\u70bf\u76df\u5248\u4f7c\u65b9\u5701\u7341\u980a\u9056"));
                mapleClient5.getPlayer().dropMessage(5, "\u984d\u5916\u7d93\u9a57\u503c\u500d\u7387 " + GameSetConstants.HELL_RATE[5] + "\u500d, \u984d\u5916\u6389\u5bf6\u500d\u7387 " + GameSetConstants.HELL_RATE[1] + " \u500d, \u984d\u5916\u6953\u5e63\u500d\u7387 " + GameSetConstants.HELL_RATE[0] + " \u500d");
                a2.getPlayer().dropMessage(5, MaplePet.ALLATORIxDEMO("\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31\uff3a\uff31"));
            }
            a2.getPlayer().dropMessage(6, "\u7576\u524d\u7cfb\u7d71\u6642\u9593" + FilePrinter.getLocalDateString() + " \u661f\u671f" + ea.getDayOfWeek());
            double d2 = a2.getPlayer().getStat().getTotalDropBuff(0) <= 0.0 ? 100.0 : a2.getPlayer().getStat().getTotalDropBuff(0);
            int a322 = (int)Math.round(a2.getPlayer().getAllMesoRate() * 100.0);
            MapleClient mapleClient6 = a2;
            int n2 = (int)(d2 / 100.0 * mapleClient6.getPlayer().getAllDropRate(a2.getPlayer().getMap(), null) * 100.0);
            mapleClient6.getPlayer().dropMessage(6, "\u7d93\u9a57\u503c\u500d\u7387: " + (a2.getChannelServer().getExpRate(a2.getPlayer().getWorld(), a2.getPlayer()) * a2.getPlayer().getAllExpRateMultiply(null, 0) * 100.0 + a2.getPlayer().getAllExpRateAdd() * 100.0 + (double)(a2.getPlayer().getStat().equippedFairy ? a2.getPlayer().getFairyExp() : (byte)0)) + "%, \u6389\u5bf6\u500d\u7387: " + n2 + "%, \u6953\u5e63\u500d\u7387: " + a322 + "% " + (String)(GameSetConstants.VIPEXP ? " VIP\u7d93\u9a57\u52a0\u6210:" + a2.getPlayer().getVipExpRate() + "%" : "") + (String)(GameSetConstants.VIPDROP ? " VIP\u6389\u5bf6\u52a0\u6210:" + a2.getPlayer().getVipDropRate() + "%" : ""));
            if (a2.getChannelServer().getExExpRate() > 1 || a2.getChannelServer().getExDropRate() > 1 || a2.getChannelServer().getExMesoRate() > 1) {
                a2.getPlayer().dropMessage(6, "\u984d\u5916\u7d93\u9a57\u503c\u500d\u7387 " + a2.getChannelServer().getExExpRate() + "\u500d, \u6389\u5bf6\u500d\u7387 " + a2.getChannelServer().getExDropRate() + "\u500d, \u6953\u5e63\u500d\u7387 " + a2.getChannelServer().getExMesoRate() + "\u500d");
            }
            if (GameSetConstants.MARRY_DROP_BONUS > 1.0) {
                for (MapleCharacter mapleCharacter : a2.getPlayer().getMap().getCharactersThreadsafe()) {
                    if (mapleCharacter.getId() != a2.getPlayer().getMarriageId()) continue;
                    a2.getPlayer().dropMessage(6, "\u7d50\u5a5a\u540c\u5730\u5716\u734e\u52f5: \u984d\u5916\u6389\u5bf6\u500d\u7387 " + GameSetConstants.MARRY_DROP_BONUS + "\u500d");
                }
            }
            a2.getPlayer().dropMessage(6, "\u76ee\u524d\u5269\u9918 " + a2.getPlayer().getCSPoints(1) + " GASH " + a2.getPlayer().getCSPoints(2) + " \u6953\u8449\u9ede\u6578 ");
            a2.getPlayer().dropMessage(6, "\u7576\u524d\u5ef6\u9072 " + a2.getPlayer().getClient().getLatency() + " \u6beb\u79d2  \u64c1\u6709" + a2.getPlayer().getPoints() + GameSetConstants.POINT_NAME + "\u9ede\u6578 ");
            if (!GameSetConstants.VPOINT_NAME.equals("\u9080\u8acb")) {
                a2.getPlayer().dropMessage(6, "\u64c1\u6709" + a2.getPlayer().getVPoints() + GameSetConstants.VPOINT_NAME + "\u9ede\u6578 ");
            }
            a2.getPlayer().dropMessage(6, "\u5df2\u4f7f\u7528:" + a2.getPlayer().getHpMpApUsed() + " \u5f35\u80fd\u529b\u91cd\u7f6e\u6372");
            a2.getPlayer().dropMessage(6, "DPM(\u653b\u64ca\u8f38\u51fa): " + a2.getPlayer().getDPM());
            if (GameSetConstants.PEE_SYSTEM) {
                a2.getPlayer().dropMessage(6, "\u60f3\u5c3f\u5c3f\u7684\u611f\u89ba: " + a2.getPlayer().getPee() + "%");
            }
            if (GameSetConstants.REBORN_SYSTEM) {
                a2.getPlayer().dropMessage(6, "\u8f49\u751f\u6b21\u6578: " + a2.getPlayer().getReborn() + "%");
            }
            if (GameSetConstants.MobDropPOINT[0] > 0.0) {
                String a322 = GameSetConstants.MobDropPOINT[2] == 1.0 ? InternCommand.ALLATORIxDEMO("vDbM") : MaplePet.ALLATORIxDEMO("\u6964\u9ee2");
                long l2 = (long)GameSetConstants.MobDropPOINT[4];
                if (GameSetConstants.VIPMONSTERPOINT) {
                    l2 += a2.getTotalDonate();
                }
                a2.getPlayer().dropMessage(6, "\u4eca\u65e5\u5df2\u6253: " + a2.getPlayer().getMonsterPoint() + " \u9ede" + (String)(l2 > 0L ? a322 + "(MAX:" + l2 + "\u9ede/\u5929)" : ""));
            }
            a2.getPlayer().dropMessage(6, "\u60a8\u5728\u6b64\u4f3a\u670d\u5668\u5df2\u7d93\u64ca\u6bba:" + a2.getPlayer().getMobCount() + "\u96bb\u602a\u7269.");
            a2.getPlayer().dropMessage(6, "\u6b64\u5e33\u865f\u5df2\u8d0a\u52a9 " + a2.getTotalDonate() + " \u5143 \u672c\u6708\u5df2\u8d0a\u52a9 " + a2.getMonthDonate() + " \u5143 \u672c\u65e5\u5df2\u8d0a\u52a9 " + a2.getTodayDonate() + " \u5143 \u6628\u65e5\u5df2\u8d0a\u52a9 " + a2.getYesturdayDonate() + " \u5143" + (String)(GameSetConstants.VIPSYSTEM ? "VIP\u7b49\u7d1a:" + a2.getPlayer().getVip() : ""));
            a2.getPlayer().dropMessage(6, "\u4eca\u65e5\u8d0a\u52a9\u6392\u884c: " + a2.getTodayDonateRank() + " \u540d \u6628\u65e5\u8d0a\u52a9\u6392\u884c: " + a2.getYesturdayDonateRank() + " \u540d \u672c\u6708\u8d0a\u52a9\u6392\u884c: " + a2.getMonthDonateRank() + " \u540d");
            if (a2.getPlayer().isAdmin()) {
                a2.getPlayer().dropMessage(6, "MAC: " + a2.getPlayer().getNowMacs());
                a2.getPlayer().dropMessage(6, "\u983b\u9053: " + a2.getChannel() + " ch2: " + World.Find.findChannel(a2.getPlayer().getName()) + " ch3: " + World.Find.findChannel(a2.getPlayer().getId()));
            }
            if (GameSetConstants.BANK_SYSTEM) {
                a2.getPlayer().dropMessage(6, "\u76ee\u524d\u9280\u884c\u5b58\u6b3e: " + a2.getPlayer().getBank() + " \u5143");
            }
            if (a2.getPlayer().getReborn() >= 1) {
                a2.getPlayer().dropMessage(6, "\u76ee\u524d\u8f49\u751f\u6b21\u6578: " + a2.getPlayer().getReborn() + " \u6b21");
            }
            return true;
        }

        public /* synthetic */ ea() {
            ea a2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ String getDayOfWeek() {
            int n2 = Calendar.getInstance().get(7) - 1;
            String string = String.valueOf(n2);
            switch (n2) {
                case 0: {
                    return MaplePet.ALLATORIxDEMO("\u65d9");
                }
                case 1: {
                    return InternCommand.ALLATORIxDEMO("\u4e05");
                }
                case 2: {
                    return MaplePet.ALLATORIxDEMO("\u4eb0");
                }
                case 3: {
                    return InternCommand.ALLATORIxDEMO("\u4e0c");
                }
                case 4: {
                    return MaplePet.ALLATORIxDEMO("\u56e7");
                }
                case 5: {
                    return InternCommand.ALLATORIxDEMO("\u4e91");
                }
                case 6: {
                    return MaplePet.ALLATORIxDEMO("\u5151");
                }
            }
            return string;
        }
    }

    public static class GashaponMega
    extends CommandExecute {
        public /* synthetic */ GashaponMega() {
            GashaponMega a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + RandomAccessByteStream.ALLATORIxDEMO("\nd>m,u\"k\u0000`*dm(m\u958eb\u95d9\u95c4\u7da5\u823f\u5ee6\u64e0");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().setGashaponMega();
            return true;
        }
    }

    public static class TSmega
    extends CommandExecute {
        public /* synthetic */ TSmega() {
            TSmega a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().setSmega();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + MapleMapEffect.ALLATORIxDEMO("\u001ad#R)Vn\u001an\u95bca\u95eb\u95c7\u5ed4\u64e3");
        }
    }

    public static class expfix
    extends CommandExecute {
        public /* synthetic */ expfix() {
            expfix a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().setExp(0);
            MapleClient mapleClient2 = a2;
            mapleClient.getPlayer().updateSingleStat(MapleStat.EXP, mapleClient2.getPlayer().getExp());
            mapleClient2.getPlayer().dropMessage(5, MTSCSPacket.ALLATORIxDEMO("\u7db6\u9a7d\u4fcb\u5f83\u5ba9\u623a"));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + NPCMessage.ALLATORIxDEMO("\u0017\u0015\u0002\u000b\u001b\u0015R@R\u7dfe\u9a25\u6b15\u9684");
        }
    }

    public static class save
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + MerchItemPackage.ALLATORIxDEMO("GMBI\u0014\u0001\u0014\u5b74\u6aa0");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            block3: {
                long l2 = System.currentTimeMillis();
                if (a2.getPlayer().saveToDB(true, false) != 1) break block3;
                a2.getPlayer().dropMessage(5, "\u4fdd\u5b58\u6210\u529f\uff01 \u82b1\u8cbb : " + (System.currentTimeMillis() - l2) + " \u6beb\u79d2");
            }
            try {
                a2.getPlayer().dropMessage(5, fc.ALLATORIxDEMO("\u4f8f\u5b4f\u5963\u6540\uff53"));
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
            return true;
        }

        public /* synthetic */ save() {
            save a2;
        }
    }

    public static class help
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + SellSystem.ALLATORIxDEMO("\u0007\u0010\u0003\u0005OXO\u5e1e\u52c6");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (GameSetConstants.SERVER_NAME.equals(JsonMapConverter.ALLATORIxDEMO("\u6005\u6074\u8c42"))) {
                CommandProcessor.dropPlayerHelp2(a2, 0);
            } else {
                CommandProcessor.dropPlayerHelp(a2, 0);
            }
            return true;
        }

        public /* synthetic */ help() {
            help a2;
        }
    }
}

