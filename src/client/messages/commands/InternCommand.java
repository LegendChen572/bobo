/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.InternCommand$\u4efb\u52d9
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 *  client.messages.commands.player.\u5408\u592a\u8c37
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.messages.commands;

import FuckingHackerToby.K;
import FuckingHackerToby.fc;
import client.ItemVac;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleJob;
import client.MapleTrait;
import client.SkillFactory;
import client.inventory.MapleRing;
import client.inventory.PetCommand;
import client.messages.CommandExecute;
import client.messages.commands.GMCommand;
import client.messages.commands.InternCommand;
import client.messages.commands.PracticerCommand;
import client.messages.commands.player.eventSystem.SellSystem;
import client.messages.commands.player.\u53ef\u53ef\u8c37;
import client.messages.commands.player.\u5408\u592a\u8c37;
import client.messages.commands.player.\u61a8\u61a8\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameSetConstants;
import constants.MapConstants;
import constants.MobConstants;
import constants.ServerConstants;
import database.DBConPool;
import handling.channel.ChannelServer;
import handling.channel.handler.BuddyListHandler;
import handling.channel.handler.PlayersHandler;
import handling.login.LoginServer;
import handling.opcodes.MapleBuffStat;
import handling.world.CharacterTransfer;
import handling.world.CheaterData;
import handling.world.MapleMessenger;
import handling.world.World;
import java.util.Iterator;
import server.Extend.SpecialItemData;
import server.ItemInformation;
import server.MaplePortal;
import server.MapleShopItem;
import server.MerchItemPackage;
import server.StructRewardItem;
import server.buffs.AbstractBuffClass;
import server.maps.Event_PyramidSubway;
import server.maps.MapleFoothold;
import server.maps.MapleMap;
import server.maps.MapleNodes;
import server.swing.autoupdate.GetSelfDocName;
import tools.KoreanDateUtil;
import tools.MaplePacketOperation;
import tools.Pair;
import tools.Quadra;
import tools.StringUtil;
import tools.database.CashShopConvert;
import tools.database.UniqueIdReset;
import tools.googledrive.SyncServerData;

public class InternCommand {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ 1;
        int cfr_ignored_0 = (3 ^ 5) << 4;
        int n5 = n3;
        int n6 = 5;
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

    public /* synthetic */ InternCommand() {
        InternCommand a2;
    }

    public static class dcIPmap
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + K.ALLATORIxDEMO("vvzipwtj575\u95c6\u959c\u572a\u5703");
        }

        public /* synthetic */ dcIPmap() {
            dcIPmap a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient = a2;
            int a32 = mapleClient.getPlayer().getMap().DC_SameIPCharacter();
            mapleClient.getPlayer().dropMessage("\u5df2\u65b7\u958bIP\u76f8\u540c\u7684 " + a32 + " \u4f4d\u89d2\u8272");
            return true;
        }
    }

    public static class closemap
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + Quadra.ALLATORIxDEMO("*Z&E,[(Fi\u001bi\u95ea\u95c0\u5706\u575f");
        }

        public /* synthetic */ closemap() {
            closemap a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient;
            int n2 = 0;
            String string = null;
            Object var5_6 = null;
            if (((String[])a32).length < 2) {
                return false;
            }
            try {
                string = a32[1];
                n2 = Integer.parseInt(string);
                mapleClient = a2;
            }
            catch (Exception a32) {
                mapleClient = a2;
            }
            if (mapleClient.getChannelServer().getMapFactory().getMap(n2) == null) {
                a2.getPlayer().dropMessage(AbstractBuffClass.ALLATORIxDEMO("\u572e\u5703\u4e13\u5b4d\u5736"));
                return true;
            }
            Object object = a32 = LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels().iterator();
            while (object.hasNext()) {
                ((ChannelServer)a32.next()).getMapFactory().destroyMap(n2, true);
                object = a32;
            }
            return true;
        }
    }

    public static class openmap
    extends CommandExecute {
        public /* synthetic */ openmap() {
            openmap a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + SpecialItemData.ALLATORIxDEMO("GCM]ERX\u0013\u0005\u0013\u95a3\u650d\u5718\u5725");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient;
            int n2 = 0;
            String string = null;
            Object var5_6 = null;
            if (((String[])a32).length < 2) {
                return false;
            }
            try {
                string = a32[1];
                n2 = Integer.parseInt(string);
                mapleClient = a2;
            }
            catch (Exception a32) {
                mapleClient = a2;
            }
            Object object = a32 = LoginServer.getWorldStatic(mapleClient.getPlayer().getMap().getWorld()).getChannels().iterator();
            while (object.hasNext()) {
                ((ChannelServer)a32.next()).getMapFactory().HealMap(n2);
                object = a32;
            }
            return true;
        }
    }

    public static class Connected
    extends CommandExecute {
        public /* synthetic */ Connected() {
            Connected a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + MapleNodes.ALLATORIxDEMO("OaB`ImXkH.\u0001.\u67c9\u7705\u5dde\u902d\u7df6\u768a\u5b8e\u6238\u7ac3");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = World.getConnected();
            StringBuilder stringBuilder = new StringBuilder(CashShopConvert.ALLATORIxDEMO("\u5db7\u904e\u63e0\u76e9\u5be7\u625b\u7aaaWe"));
            boolean bl = true;
            Iterator iterator = a3.keySet().iterator();
            while (iterator.hasNext()) {
                int n2;
                int n3 = (Integer)iterator.next();
                if (!bl) {
                    n2 = n3;
                    stringBuilder.append(MapleNodes.ALLATORIxDEMO("\"\f"));
                } else {
                    bl = false;
                    n2 = n3;
                }
                if (n2 == 0) {
                    stringBuilder.append(CashShopConvert.ALLATORIxDEMO("\u622d\u674cWe"));
                    stringBuilder.append(a3.get(n3));
                    continue;
                }
                stringBuilder.append(MapleNodes.ALLATORIxDEMO("\u9817\u905d\f"));
                stringBuilder.append(n3);
                stringBuilder.append(CashShopConvert.ALLATORIxDEMO("We"));
                stringBuilder.append(a3.get(n3));
            }
            a2.getPlayer().dropMessage(6, stringBuilder.toString());
            return true;
        }
    }

    public static class whoishere
    extends CommandExecute {
        public /* synthetic */ whoishere() {
            whoishere a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Iterator<MapleCharacter> iterator;
            a3 = new StringBuilder(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u5741\u6b2d\u5759\u575f\u76ed\u73e0\u5bdfsI"));
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
                ((StringBuilder)a3).append(K.ALLATORIxDEMO("65"));
                iterator2 = iterator;
            }
            Object object = a3;
            ((StringBuilder)object).setLength(((StringBuilder)object).length() - 2);
            a2.getPlayer().dropMessage(6, ((StringBuilder)a3).toString());
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)">\u0001&\u0000:\u0001,\u001b,IdI\u67ac\u7762\u76a7\u5224\u5779\u577f\u4e43\u76ed\u73e0\u5bdf");
        }
    }

    public static class CheckGash
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            String string = a3[1];
            int n2 = World.Find.findWorld(string);
            int n3 = World.Find.findChannel(string);
            if (n3 <= 0) {
                a2.getPlayer().dropMessage(6, MaplePacketOperation.ALLATORIxDEMO("\u7389\u5bf3\u5fe5\u984d\u4e2a\u7d9f"));
                return true;
            }
            a3 = ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterByName(string);
            MapleClient mapleClient = a2;
            if (a3 == null) {
                mapleClient.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("\u6205\u4e15\u524b\u8a6a\u89a9\u826a"));
            } else {
                mapleClient.getPlayer().dropMessage(6, ((MapleCharacter)a3).getName() + " \u6709 " + ((MapleCharacter)a3).getCSPoints(1) + " \u9ede\u6578.");
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + MaplePacketOperation.ALLATORIxDEMO("&H C.G$S-\u0000y\u7389\u5bf3\u542d\u7a74\u001ee\re\u6a82\u67a0\u9efe\u653d");
        }

        public /* synthetic */ CheckGash() {
            CheckGash a2;
        }
    }

    public static class ItemCheck
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 3 || a32[1] == null || a32[1].equals("") || a32[2] == null || a32[2].equals("")) {
                return false;
            }
            int a32 = Integer.parseInt(a32[2]);
            String string = a32[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0) {
                a2.getPlayer().dropMessage(6, ItemInformation.ALLATORIxDEMO("\u73f2\u5bf5\u5f9e\u984b\u4e51\u7d99"));
                return true;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            int n4 = mapleCharacter.getItemQuantity(a32, true);
            MapleClient mapleClient = a2;
            if (n4 > 0) {
                mapleClient.getPlayer().dropMessage(6, mapleCharacter.getName() + " \u6709 " + n4 + " (" + a32 + ").");
            } else {
                mapleClient.getPlayer().dropMessage(6, mapleCharacter.getName() + " \u4e26\u6c92\u6709 (" + a32 + ")");
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + CharacterTransfer.ALLATORIxDEMO("oBc[e^cUm\u0016:FjW\u007fStXg[c\b&\noBc[oR8\u0016+\u0016\u6aa4\u67d3\u726f\u54f7");
        }

        public /* synthetic */ ItemCheck() {
            ItemCheck a2;
        }
    }

    public static class Cheaters
    extends CommandExecute {
        public /* synthetic */ Cheaters() {
            Cheaters a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + MapleTrait.ALLATORIxDEMO("1178&< *rtr\u67bc\u7759\u4f05\u5f58\u898b\u8220");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            int n2;
            a3 = World.getCheaters();
            int n3 = n2 = a3.size() - 1;
            while (n3 >= 0) {
                CheaterData cheaterData = (CheaterData)a3.get(n2);
                a2.getPlayer().dropMessage(6, cheaterData.getInfo());
                n3 = --n2;
            }
            return true;
        }
    }

    public static class CharInfo
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + PracticerCommand.ALLATORIxDEMO("d\u0013f\tn\u0015a\u0014'G\u89d5\u8209\u540a\u7a4a9[*[\u67e2\u7770\u89d5\u8209\u72c7\u6130");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String string = a3[1];
            int n2 = World.Find.findChannel(string);
            int n3 = World.Find.findWorld(string);
            if (n2 <= 0) {
                a2.getPlayer().dropMessage(6, PracticerCommand.ALLATORIxDEMO("\u73ae\u5bcd\u5fc2\u9873\u4e0d\u7da1"));
                return true;
            }
            a3 = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(string);
            if (a3 == null) {
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("\u89d8\u8207\u4e07\u5b2d\u5722"));
                a2.getPlayer().dropMessage(6, stringBuilder.toString());
            } else {
                if (((MapleCharacter)a3).getClient().getLastPing() <= 0L) {
                    ((MapleCharacter)a3).getClient().sendPing();
                }
                StringBuilder stringBuilder2 = stringBuilder;
                Object object = a3;
                stringBuilder2.append(MapleClient.getLogMessage((MapleCharacter)a3, ""));
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[\u572f[")).append(object.getPosition().x);
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("U%")).append(a3.getPosition().y);
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u883b\u91c8[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getHp());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("U%"));
                stringBuilder.append(((MapleCharacter)a3).getStat().getCurrentMaxHp());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u9b2f\u91c8[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getMp());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("U%"));
                stringBuilder.append(((MapleCharacter)a3).getStat().getCurrentMaxMp());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("'\u0007{[\u726e\u747d\u653c\u64b1\u529c[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getTotalWatk());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("Uv\t*\u9b21\u6cdf\u654e\u64c0\u52ee*O*"));
                stringBuilder.append(((MapleCharacter)a3).getStat().getTotalMagic());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u677b\u9adf\u6540\u64cd[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getCurrentMaxBaseDamage());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("*\tvU\u6531\u64bf/\u650d*O*"));
                stringBuilder.append(a3.getStat().dam_r);
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'9H(T\u6540\u64cd^\u657f[=["));
                stringBuilder.append(a3.getStat().bossdam_r);
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("*\tvU\u5291\u91ba*O*"));
                stringBuilder.append(((MapleCharacter)a3).getStat().getStr());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u6534\u6370[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getDex());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("*\tvU\u6670\u52ee*O*"));
                stringBuilder.append(((MapleCharacter)a3).getStat().getInt());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u5e03\u904c[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getLuk());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("*\tvU\u5162\u909d\u5291\u91ba*O*"));
                stringBuilder.append(((MapleCharacter)a3).getStat().getTotalStr());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u5113\u90ef\u6534\u6370[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getTotalDex());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("*\tvU\u5162\u909d\u6670\u52ee*O*"));
                stringBuilder.append(((MapleCharacter)a3).getStat().getTotalInt());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u5113\u90ef\u5e03\u904c[=["));
                stringBuilder.append(((MapleCharacter)a3).getStat().getTotalLuk());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("Uv\t*\u7de6\u9a5d\u5049*O*"));
                stringBuilder.append(((MapleCharacter)a3).getExp());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'\u7d3f\u968d\u72bb\u614c[=["));
                stringBuilder2.append(((MapleCharacter)object).getParty() != null);
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("Uv\t*\u4ed1\u6619\u72b5\u6141O*"));
                stringBuilder.append(((MapleCharacter)a3).getTrade() != null);
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("[{\u0007'7f\u000fb\u0015d\u0002=["));
                stringBuilder.append(((MapleCharacter)a3).getClient().getLatency());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("Uv\t*\u6775\u5f86%C;MO*"));
                stringBuilder.append(((MapleCharacter)a3).getClient().getLastPing());
                stringBuilder.append(PracticerCommand.ALLATORIxDEMO("'\u0007{[\u6707\u5ff7W4I<=["));
                stringBuilder.append(((MapleCharacter)a3).getClient().getLastPong());
                stringBuilder.append(SyncServerData.ALLATORIxDEMO("Uv\t*<ZO*"));
                stringBuilder.append(((MapleCharacter)a3).getClient().getSessionIPAddress());
                ((MapleCharacter)a3).getClient().DebugMessage(stringBuilder);
                a2.getPlayer().dropMessage(6, stringBuilder.toString());
            }
            return true;
        }

        public /* synthetic */ CharInfo() {
            CharInfo a2;
        }
    }

    public static class q
    extends \u4efb\u52d9 {
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, fc.ALLATORIxDEMO("\u0012fr:r\u67f2\u7759\u4eec\u528b\u72d7\u6119")).toString();
        }

        public /* synthetic */ q() {
            q a2;
        }
    }

    public static class Debug
    extends CommandExecute {
        public /* synthetic */ Debug() {
            Debug a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().setDebugMessage(!a2.getPlayer().getDebugMessage());
            a2.getPlayer().dropMessage("DeBug\u8a0a\u606f\u5df2\u7d93" + (a2.getPlayer().getDebugMessage() ? MobConstants.ALLATORIxDEMO("\u9589\u556b") : MapleRing.ALLATORIxDEMO("\u95c6\u95d5")));
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + MobConstants.ALLATORIxDEMO("pgVwS\"\u0019\"\u95bf\u555dpgVwS\u8a08\u605b");
        }
    }

    public static class WDebug
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u0019Y}k[{^.\u0014.\u95b2\u5551\u0016\u95d2\u95b0\u8d7e\u8dd6\u8ab1\u8a5f\u8a04\u6056");
        }

        public /* synthetic */ WDebug() {
            WDebug a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().setWalkDebugMessage(!a2.getPlayer().getWalkDebugMessage());
            a2.getPlayer().dropMessage(6, "\u76ee\u524d\u8d70\u8def\u8abf\u8a66\u8a0a\u606f : " + a2.getPlayer().getWalkDebugMessage());
            return true;
        }
    }

    public static class AttDebug
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + KoreanDateUtil.ALLATORIxDEMO(">s\u0018c\u001d6W6\u95f1\u5549>s\u0018c\u001d\u8a1c\u6015");
        }

        public /* synthetic */ AttDebug() {
            AttDebug a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().setAttackDebugMessage(!a2.getPlayer().getAttackDebugMessage());
            a2.getPlayer().dropMessage(6, "\u76ee\u524d\u653b\u64ca\u901f\u5ea6\u8abf\u8a66\u8a0a\u606f : " + a2.getPlayer().getAttackDebugMessage());
            return true;
        }
    }

    public static class WarpMap
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            block4: {
                a32 = a2.getChannelServer().getMapFactory().getMap(Integer.parseInt(a32[1]));
                if (a32 != null) break block4;
                a2.getPlayer().dropMessage(6, MerchItemPackage.ALLATORIxDEMO("\u571c\u5722\u4e21\u5b6c\u5704\u3036"));
                return false;
            }
            try {
                Iterator<MapleCharacter> iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
                while (iterator.hasNext()) {
                    Object object = a32;
                    iterator.next().changeMap((MapleMap)object, ((MapleMap)object).getPortal(0));
                }
            }
            catch (Exception a32) {
                System.out.println(a32);
                return false;
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + SellSystem.ALLATORIxDEMO("8\u0014\u001d\u0005\"\u0014\u001fUf\u5745\u5779\u4e96\u78d3eOXO\u62ff\u575f\u5763\u4e65\u76f1\u4ed5\u511d\u9087\u50c6\u525f\u90d6\u5f5a\u5745\u5779");
        }

        public /* synthetic */ WarpMap() {
            WarpMap a2;
        }
    }

    public static class Map
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleMap mapleMap;
            block9: {
                if (a32.length < 2) {
                    return false;
                }
                mapleMap = a2.getChannelServer().getMapFactory().getMap(Integer.parseInt(a32[1]));
                if (mapleMap != null) break block9;
                a2.getPlayer().dropMessage(5, \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u5767\u571a\u4e5a\u5b54\u577f\""));
                return true;
            }
            try {
                MaplePortal maplePortal;
                MaplePortal maplePortal2;
                block10: {
                    maplePortal2 = null;
                    if (a32.length > 2) {
                        try {
                            maplePortal = maplePortal2 = mapleMap.getPortal(Integer.parseInt(a32[2]));
                            break block10;
                        }
                        catch (IndexOutOfBoundsException a32) {
                            maplePortal = maplePortal2;
                            a2.getPlayer().dropMessage(5, Event_PyramidSubway.ALLATORIxDEMO("\u50e9\u9025\u9e84\u930b\u8afe\n"));
                            break block10;
                        }
                        catch (NumberFormatException a32) {
                            // empty catch block
                        }
                    }
                    maplePortal = maplePortal2;
                }
                if (maplePortal == null) {
                    maplePortal2 = mapleMap.getPortal(0);
                }
                a2.getPlayer().changeMap(mapleMap, maplePortal2);
            }
            catch (Exception exception) {
                a2.getPlayer().dropMessage(5, "Error: " + exception.getMessage());
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)":m',ka6|>h+o?m%b6a22wW'c%x6`\n,z,\u50e4\u900d\u5267\u67dc\u5767\u571ax\u4eb6");
        }

        public /* synthetic */ Map() {
            Map a2;
        }
    }

    public static class spyID
    extends CommandExecute {
        public /* synthetic */ spyID() {
            spyID a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            spyID a2;
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + "" + a2.getClass().getSimpleName().toLowerCase() + BuddyListHandler.ALLATORIxDEMO("W\u0006\u73de\u5b8c\u547a\u5b6dI\u001aZ\u001a\u89b7\u5be5\u73de\u5b8c");
        }

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
            catch (Exception a32) {
                n2 = n3;
            }
            Object a32 = MapleCharacter.getCharacterById(n2);
            n3 = World.Find.findChannel(n3);
            if (a32 != null) {
                if (((MapleCharacter)a32).getGMLevel() > a2.getPlayer().getGMLevel()) {
                    a2.getPlayer().dropMessage(5, BuddyListHandler.ALLATORIxDEMO("\u4f5a\u4e7a\u80c7\u6792\u7731\u6ba3\u4f5a\u9aaf\u6b30\u9627\u76be\u4ecd\u001b"));
                } else {
                    int n4 = 0;
                    try {
                        if (((MapleCharacter)a32).getStorage() != null) {
                            n4 = ((MapleCharacter)a32).getStorage().getMeso();
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    MapleClient mapleClient = a2;
                    mapleClient.getPlayer().dropMessage(5, MapleShopItem.ALLATORIxDEMO("\u6b43\u73d5\u5b91\u72bc\u616cF"));
                    mapleClient.getPlayer().dropMessage(5, "\u73a9\u5bb6\u540d\u7a31: " + ((MapleCharacter)a32).getName() + " \u73a9\u5bb6\u7de8\u865f: " + ((MapleCharacter)a32).getId() + " \u5e33\u865f: " + ((MapleCharacter)a32).getClient().getAccountName() + " \u5e33\u865fID: " + ((MapleCharacter)a32).getAccountID());
                    a2.getPlayer().dropMessage(5, "\u73a9\u5bb6VIP: " + ((MapleCharacter)a32).getVip() + " \u73a9\u5bb6\u6b0a\u9650: " + ((MapleCharacter)a32).getGMLevel() + " \u7b49\u7d1a: " + ((MapleCharacter)a32).getLevel() + " \u8077\u696d: " + ((MapleCharacter)a32).getJob() + " \u540d\u8072: " + ((MapleCharacter)a32).getFame());
                    a2.getPlayer().dropMessage(5, "\u5730\u5716: " + ((MapleCharacter)a32).getMapId() + " - " + ((MapleCharacter)a32).getMap().getMapName());
                    a2.getPlayer().dropMessage(5, "\u76ee\u524dHP: " + ((MapleCharacter)a32).getStat().getHp() + " \u76ee\u524dMP: " + ((MapleCharacter)a32).getStat().getMp());
                    a2.getPlayer().dropMessage(5, "\u6700\u5927HP: " + ((MapleCharacter)a32).getStat().getCurrentMaxHp() + " \u6700\u5927MP: " + ((MapleCharacter)a32).getStat().getCurrentMaxMp());
                    a2.getPlayer().dropMessage(5, "\u529b\u91cf: " + ((MapleCharacter)a32).getStat().getStr() + "  ||  \u654f\u6377: " + ((MapleCharacter)a32).getStat().getDex() + "  ||  \u667a\u529b: " + ((MapleCharacter)a32).getStat().getInt() + "  ||  \u5e78\u904b: " + ((MapleCharacter)a32).getStat().getLuk());
                    a2.getPlayer().dropMessage(5, "\u7269\u7406\u653b\u64ca: " + ((MapleCharacter)a32).getStat().getTotalWatk() + "  ||  \u9b54\u6cd5\u653b\u64ca: " + ((MapleCharacter)a32).getStat().getTotalMagic());
                    a2.getPlayer().dropMessage(5, "\u7d93\u9a57\u500d\u7387: " + a32.getStat().expBuff + " \u91d1\u9322\u500d\u7387: " + a32.getStat().mesoBuff + " \u6389\u5bf6\u500d\u7387: " + a32.getStat().dropBuff);
                    Object object = a32;
                    a2.getPlayer().dropMessage(5, "GASH: " + ((MapleCharacter)object).getOfflineAcash((MapleCharacter)object) + " \u6953\u8449\u9ede\u6578: " + ((MapleCharacter)a32).getCSPoints(2) + " \u6953\u5e63: " + ((MapleCharacter)a32).getMeso() + " \u5009\u5eab\u6953\u5e63 " + n4);
                    MapleClient mapleClient2 = a2;
                    if (n3 <= 0) {
                        mapleClient2.getPlayer().dropMessage(5, BuddyListHandler.ALLATORIxDEMO("\u8a05\u89e8\u8205\u7080\u9695\u7de0\u72b7\u6171"));
                    } else {
                        mapleClient2.getPlayer().dropMessage(5, "IP:" + ((MapleCharacter)a32).getClient().getSessionIPAddress() + " \u76ee\u524dMAC:" + ((MapleCharacter)a32).getNowMacs() + " \u6240\u6709MAC:" + ((MapleCharacter)a32).getClient().getMacs());
                        a2.getPlayer().dropMessage(5, "\u5c0d\u4f3a\u670d\u5668\u5ef6\u9072: " + ((MapleCharacter)a32).getClient().getLatency());
                    }
                }
            } else {
                a2.getPlayer().dropMessage(5, MapleShopItem.ALLATORIxDEMO("\u6202\u4e2a\u524c\u6b43\u73d5\u5b91R"));
            }
            return true;
        }
    }

    public static class spy
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            spy a2;
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + "" + a2.getClass().getSimpleName().toLowerCase() + GetSelfDocName.ALLATORIxDEMO("D5\u73cd\u5bbf\u5469\u5b5eZ)I)\u89a4\u5bd6\u73cd\u5bbf");
        }

        public /* synthetic */ spy() {
            spy a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            boolean bl = false;
            if (((String[])a32).length < 2) {
                return false;
            }
            a32 = a32[1];
            MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName((String)a32);
            int n2 = World.Find.findChannel((String)a32);
            if (mapleCharacter == null) {
                a2.getPlayer().dropMessage(5, \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6270\u4e34\u523e\u6b5d\u73a7\u5b8f\u768a\u5434\u7a3f\u0015\u81e4\u52ec\u8b56\u521c\u73a7\u5b8fG}\u4e23\u0017 \u4e30\u79dc\u515e\u712f\u53f4\u61c7\u527e\u8b56\u521c\u593f\u656e"));
                bl = true;
                n2 = World.Find.findChannel(Integer.parseInt((String)a32));
                mapleCharacter = MapleCharacter.getCharacterById(Integer.parseInt((String)a32));
                if (mapleCharacter != null) {
                    a2.getPlayer().dropMessage(5, "\u5df2\u81ea\u52d5\u8b58\u5225\u73a9\u5bb6ID\u6210\u529f,ID\u70ba" + Integer.parseInt((String)a32) + ",\u4ee5\u4e0b\u70ba\u60a8\u986f\u793a\u6b64\u73a9\u5bb6\u8cc7\u6599\u3002");
                    a2.getPlayer().dropMessage(5, GetSelfDocName.ALLATORIxDEMO("4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4Y4"));
                }
            }
            if (mapleCharacter != null) {
                if (mapleCharacter.getGMLevel() > a2.getPlayer().getGMLevel()) {
                    a2.getPlayer().dropMessage(5, \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f59\u4e03\u80c4\u67eb\u7732\u6bda\u4f59\u9ad6\u6b33\u965e\u76bd\u4eb4\u0018"));
                } else {
                    int a32 = 0;
                    try {
                        if (mapleCharacter.getStorage() != null) {
                            a32 = mapleCharacter.getStorage().getMeso();
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    MapleClient mapleClient = a2;
                    mapleClient.getPlayer().dropMessage(5, GetSelfDocName.ALLATORIxDEMO("\u6b00\u73a0\u5bd2\u72c9\u612f3"));
                    mapleClient.getPlayer().dropMessage(5, "\u73a9\u5bb6\u540d\u7a31: " + mapleCharacter.getName() + " \u73a9\u5bb6\u7de8\u865f: " + mapleCharacter.getId() + " \u5e33\u865f: " + mapleCharacter.getClient().getAccountName() + " \u5e33\u865fID: " + mapleCharacter.getAccountID());
                    a2.getPlayer().dropMessage(5, "\u73a9\u5bb6VIP: " + mapleCharacter.getVip() + " \u73a9\u5bb6\u6b0a\u9650: " + mapleCharacter.getGMLevel() + " \u7b49\u7d1a: " + mapleCharacter.getLevel() + " \u8077\u696d: " + MapleJob.getById(mapleCharacter.getJob()) + " \u540d\u8072: " + mapleCharacter.getFame());
                    a2.getPlayer().dropMessage(5, "\u5730\u5716: " + mapleCharacter.getMapId() + " - " + mapleCharacter.getMap().getMapName());
                    a2.getPlayer().dropMessage(5, "\u76ee\u524dHP: " + mapleCharacter.getStat().getHp() + " \u76ee\u524dMP: " + mapleCharacter.getStat().getMp());
                    a2.getPlayer().dropMessage(5, "\u6700\u5927HP: " + mapleCharacter.getStat().getCurrentMaxHp() + " \u6700\u5927MP: " + mapleCharacter.getStat().getCurrentMaxMp());
                    a2.getPlayer().dropMessage(5, "\u529b\u91cf: " + mapleCharacter.getStat().getStr() + "  ||  \u654f\u6377: " + mapleCharacter.getStat().getDex() + "  ||  \u667a\u529b: " + mapleCharacter.getStat().getInt() + "  ||  \u5e78\u904b: " + mapleCharacter.getStat().getLuk());
                    a2.getPlayer().dropMessage(5, "\u7269\u7406\u653b\u64ca: " + mapleCharacter.getStat().getTotalWatk() + "  ||  \u9b54\u6cd5\u653b\u64ca: " + mapleCharacter.getStat().getTotalMagic());
                    a2.getPlayer().dropMessage(5, "\u7d93\u9a57\u500d\u7387: " + mapleCharacter.getStat().expBuff + " \u91d1\u9322\u500d\u7387: " + mapleCharacter.getStat().mesoBuff + " \u6389\u5bf6\u500d\u7387: " + mapleCharacter.getStat().dropBuff);
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    a2.getPlayer().dropMessage(5, "GASH: " + mapleCharacter2.getOfflineAcash(mapleCharacter2) + " \u6953\u8449\u9ede\u6578: " + mapleCharacter.getCSPoints(2) + " \u6953\u5e63: " + mapleCharacter.getMeso() + " \u5009\u5eab\u6953\u5e63 " + a32);
                    a2.getPlayer().dropMessage(5, GameSetConstants.POINT_NAME + "\u9ede\u6578: " + mapleCharacter.getPoints() + " " + GameSetConstants.VPOINT_NAME + "\u9ede\u6578: " + mapleCharacter.getVPoints());
                    a2.getPlayer().dropMessage(6, "\u6b64\u5e33\u865f\u5df2\u8d0a\u52a9 " + mapleCharacter.getClient().getTotalDonate() + " \u5143 \u672c\u6708\u5df2\u8d0a\u52a9 " + mapleCharacter.getClient().getMonthDonate() + " \u5143 \u672c\u65e5\u5df2\u8d0a\u52a9 " + mapleCharacter.getClient().getTodayDonate() + " \u5143 \u6628\u65e5\u5df2\u8d0a\u52a9 " + mapleCharacter.getClient().getYesturdayDonate() + " \u5143" + (String)(GameSetConstants.VIPSYSTEM ? "VIP\u7b49\u7d1a:" + mapleCharacter.getClient().getVip() : ""));
                    a2.getPlayer().dropMessage(6, "\u4eca\u65e5\u8d0a\u52a9\u6392\u884c: " + mapleCharacter.getClient().getTodayDonateRank() + " \u540d \u6628\u65e5\u8d0a\u52a9\u6392\u884c: " + mapleCharacter.getClient().getYesturdayDonateRank() + " \u540d");
                    a2.getPlayer().dropMessage(6, "\u662f\u5426\u5df2\u7d93\u904e\u624b\u6a5f\u9a57\u8b49: " + mapleCharacter.isPhoneVerified());
                    boolean bl2 = false;
                    if (n2 <= 0 && bl2) {
                        a2.getPlayer().dropMessage(5, \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u8a7c\u89eb\u827c\u7083\u96ec\u7de3\u72ce\u6172"));
                    } else {
                        int n3;
                        a2.getPlayer().dropMessage(5, "IP:" + mapleCharacter.getClient().getSessionIPAddress() + " \u76ee\u524dMAC:" + mapleCharacter.getNowMacs());
                        a32 = 0;
                        String[] arrstring = mapleCharacter.getNowMacs().split(GetSelfDocName.ALLATORIxDEMO("H)"));
                        n2 = arrstring.length;
                        int n4 = n3 = 0;
                        while (n4 < n2) {
                            String string = arrstring[n3];
                            if (a32 <= 5) {
                                ++a32;
                                a2.getPlayer().dropMessage(5, "\u6240\u6709MAC:" + string);
                            }
                            n4 = ++n3;
                        }
                        a2.getPlayer().dropMessage(5, "\u5c0d\u4f3a\u670d\u5668\u5ef6\u9072: " + mapleCharacter.getClient().getLatency());
                    }
                }
            } else {
                a2.getPlayer().dropMessage(5, \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6247\u4e03\u5209\u6b6a\u7390\u5bb8\u7dd1\u8651\u0017"));
            }
            return true;
        }
    }

    public static class spybuff
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = a3[1];
            int n2 = World.Find.findChannel((String)a3);
            int n3 = World.Find.findWorld((String)a3);
            MapleCharacter mapleCharacter = null;
            if (n2 == -10) {
                a2.getPlayer().dropMessage("\u76ee\u524d\u73a9\u5bb6[" + (String)a3 + "]\u6b63\u5728\u5546\u57ce\u4e2d");
                return true;
            }
            if (n2 > 0) {
                mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName((String)a3);
            }
            if (mapleCharacter != null) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                n2 = mapleCharacter2.getBuffSource(MapleBuffStat.WATK);
                n3 = mapleCharacter2.getBuffSource(MapleBuffStat.MATK);
                int n4 = mapleCharacter2.getBuffSource(MapleBuffStat.MAPLE_WARRIOR);
                int n5 = mapleCharacter2.getBuffSource(MapleBuffStat.SHARP_EYES);
                int n6 = mapleCharacter2.getBuffSource(MapleBuffStat.SPEED);
                int n7 = mapleCharacter2.getBuffSource(MapleBuffStat.JUMP);
                int n8 = mapleCharacter2.getBuffSource(MapleBuffStat.BOOSTER);
                int n9 = mapleCharacter2.getBuffSource(MapleBuffStat.SPEED_INFUSION);
                int n10 = mapleCharacter2.getBuffSource(MapleBuffStat.INFINITY);
                int n11 = mapleCharacter2.getBuffSource(MapleBuffStat.SHADOWPARTNER);
                int n12 = mapleCharacter2.getBuffSource(MapleBuffStat.MAGIC_GUARD);
                int n13 = mapleCharacter2.getBuffSource(MapleBuffStat.EXPRATE);
                int n14 = mapleCharacter2.getBuffSource(MapleBuffStat.MESO_RATE);
                int n15 = mapleCharacter2.getBuffSource(MapleBuffStat.DROP_RATE);
                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + (String)a3 + "] \u76ee\u524d\u88dc\u52a9\u6280\u80fd\u5982\u4e0b");
                if (n2 != -1) {
                    int n16 = n2;
                    a2.getPlayer().dropMessage("\u7269\u7406\u653b\u64ca\u6280\u80fd: " + n16 + " (" + SkillFactory.getSkillName(n16) + ")");
                }
                if (n3 != -1) {
                    int n17 = n3;
                    a2.getPlayer().dropMessage("\u9b54\u6cd5\u653b\u64ca\u6280\u80fd: " + n17 + " (" + SkillFactory.getSkillName(n17) + ")");
                }
                if (n4 != -1) {
                    int n18 = n4;
                    a2.getPlayer().dropMessage("\u6953\u8449\u795d\u798f\u6280\u80fd: " + n18 + " (" + SkillFactory.getSkillName(n18) + ")");
                }
                if (n5 != -1) {
                    int n19 = n5;
                    a2.getPlayer().dropMessage("\u6703\u5fc3\u4e4b\u773c\u6280\u80fd: " + n19 + " (" + SkillFactory.getSkillName(n19) + ")");
                }
                if (n6 != -1) {
                    int n20 = n6;
                    a2.getPlayer().dropMessage("\u79fb\u52d5\u901f\u5ea6\u6280\u80fd: " + n20 + " (" + SkillFactory.getSkillName(n20) + ")");
                }
                if (n7 != -1) {
                    int n21 = n7;
                    a2.getPlayer().dropMessage("\u8df3\u8d8a\u9ad8\u5ea6\u6280\u80fd: " + n21 + " (" + SkillFactory.getSkillName(n21) + ")");
                }
                if (n8 != -1) {
                    int n22 = n8;
                    a2.getPlayer().dropMessage("\u653b\u64ca\u901f\u5ea6\u6280\u80fd: " + n22 + " (" + SkillFactory.getSkillName(n22) + ")");
                }
                if (n9 != -1) {
                    int n23 = n9;
                    a2.getPlayer().dropMessage("\u6700\u7d42\u6975\u901f\u6280\u80fd: " + n23 + " (" + SkillFactory.getSkillName(n23) + ")");
                }
                if (n10 != -1) {
                    int n24 = n10;
                    a2.getPlayer().dropMessage("\u9b54\u7121\u9650\u6280\u80fd: " + n24 + " (" + SkillFactory.getSkillName(n24) + ")");
                }
                if (n11 != -1) {
                    int n25 = n11;
                    a2.getPlayer().dropMessage("\u5f71\u5206\u8eab\u6280\u80fd: " + n25 + " (" + SkillFactory.getSkillName(n25) + ")");
                }
                if (n12 != -1) {
                    int n26 = n12;
                    a2.getPlayer().dropMessage("\u9b54\u5fc3\u9632\u79a6\u6280\u80fd: " + n26 + " (" + SkillFactory.getSkillName(n26) + ")");
                }
                if (n13 != -1) {
                    int n27 = n13;
                    a2.getPlayer().dropMessage("\u7d93\u9a57\u500d\u7387\u6280\u80fd: " + n27 + " (" + SkillFactory.getSkillName(n27) + ")");
                }
                if (n15 != -1) {
                    int n28 = n15;
                    a2.getPlayer().dropMessage("\u6389\u843d\u500d\u7387\u6280\u80fd: " + n28 + " (" + SkillFactory.getSkillName(n28) + ")");
                }
                if (n14 != -1) {
                    int n29 = n14;
                    a2.getPlayer().dropMessage("\u6953\u5e63\u500d\u7387\u6280\u80fd: " + n29 + " (" + SkillFactory.getSkillName(n29) + ")");
                }
                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + (String)a3 + "] \u88dc\u52a9\u6280\u80fd\u5982\u4e0a");
            } else {
                a2.getPlayer().dropMessage(5, UniqueIdReset.ALLATORIxDEMO("\u6219\u4e0b\u5257\u6b62\u73ce\u5bb0I"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            spybuff a2;
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + "" + a2.getClass().getSimpleName().toLowerCase() + PetCommand.ALLATORIxDEMO("?\t\u73b6\u5b83\u5412\u5b62!\u00152\u0015\u67fa\u773e\u73b6\u5b83\u88c3\u529c\u629f\u80c8");
        }

        public /* synthetic */ spybuff() {
            spybuff a2;
        }
    }

    public static class ChangeChannel
    extends CommandExecute {
        public /* synthetic */ ChangeChannel() {
            ChangeChannel a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            if (a32.length < 2) {
                return false;
            }
            int a32 = Integer.parseInt(a32[1]);
            if (a2.getChannel() != a32) {
                a2.getPlayer().changeChannel(a32);
            } else {
                a2.getPlayer().dropMessage(5, ItemVac.ALLATORIxDEMO("\u8abe\u8f2d\u5110\u6b76\u78cf\u7691\u984e\u9046\u3077"));
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + MapleMessenger.ALLATORIxDEMO("{\u0013y\u0015\u007f\u001e{\u0013y\u0015v\u001et[$\u9840\u904bE8V8\u668f\u63c3\u9840\u904b");
        }
    }

    public static class CC
    extends ChangeChannel {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + StructRewardItem.ALLATORIxDEMO("Ui\u00166\u980d\u9059\b*\u001b*\u66c2\u63d1\u980d\u9059");
        }

        public /* synthetic */ CC() {
            CC a2;
        }
    }

    public static class MuteMap
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u001ay#i\u001am',z,\u8bc4\u573c\u5741\u73a5\u5be1\u9585\u5663\u621a\u53b8\u4ee9\u8afd\u8a7d");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            Object object = a3 = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
            while (object.hasNext()) {
                StringBuilder stringBuilder;
                MapleCharacter mapleCharacter;
                mapleCharacter.canTalk(!(mapleCharacter = (MapleCharacter)a3.next()).getCanTalk());
                StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
                stringBuilder.append(InternCommand.ALLATORIxDEMO("\u0011\u89d7\u8243\u66b4\u7a00%"));
                stringBuilder2.append(StringUtil.getRightPaddedStr(mapleCharacter.getName(), ' ', 13));
                stringBuilder.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)",\u001eHm,"));
                stringBuilder2.append(StringUtil.getRightPaddedStr("" + mapleCharacter.getId(), ' ', 5));
                stringBuilder.append(InternCommand.ALLATORIxDEMO("%\u76df\u5248\u5dc3\u7d96\u000b%"));
                stringBuilder.append(mapleCharacter.getCanTalk() ? \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u53b8\u4ee9\u8afd\u8a7d") : InternCommand.ALLATORIxDEMO("\u95b8\u5631"));
                a2.getPlayer().dropMessage(stringBuilder.toString());
                object = a3;
            }
            return true;
        }

        public /* synthetic */ MuteMap() {
            MuteMap a2;
        }
    }

    public static class MuteList
    extends CommandExecute {
        public /* synthetic */ MuteList() {
            MuteList a2;
        }

        /*
         * Exception decompiling
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + fc.ALLATORIxDEMO("Z'c7[;d&7r:r\u67f2\u7759\u7996\u8a52\u541a\u55fc");
        }
    }

    public static class MuteID
    extends CommandExecute {
        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            int n2;
            if (((Object)a322).length < 2) {
                return false;
            }
            int n3 = 0;
            try {
                n2 = n3 = Integer.parseInt((String)a322[1]);
            }
            catch (Exception exception) {
                n2 = n3;
            }
            int n5 = World.Find.findChannel(n2);
            int n22 = World.Find.findWorld(n3);
            if (n5 > 0) {
                MapleCharacter mapleCharacter;
                mapleCharacter.canTalk(!(mapleCharacter = ChannelServer.getInstance(n22, n5).getPlayerStorage().getCharacterById(n3)).getCanTalk());
                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + mapleCharacter.getName() + "] \u76ee\u524d\u5df2\u7d93" + (mapleCharacter.getCanTalk() ? Pair.ALLATORIxDEMO("\u538b\u4ef9\u8ace\u8a6d") : GMCommand.ALLATORIxDEMO("\u95bb\u5656")));
                return true;
            }
            if (n5 == -10) {
                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + (String)a322[1] + "] \u76ee\u524d\u6b63\u5728\u8cfc\u7269\u5546\u57ce");
                return true;
            }
            try {
                MapleClient mapleClient;
                DruidPooledConnection druidPooledConnection;
                block20: {
                    block19: {
                        AutoCloseable autoCloseable;
                        boolean bl;
                        block18: {
                            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                            try {
                                bl = true;
                                a322 = druidPooledConnection.prepareStatement(Pair.ALLATORIxDEMO("O!P!_0<\u0007}\nH\u0005p\u000f<\"N+QD\u007f\f}\u0016}\u0007h\u0001n\u0017<3T!N!<\rxD!D#"));
                                a322.setInt(1, n3);
                                autoCloseable = a322.executeQuery();
                                if (autoCloseable.next()) break block18;
                                a322.close();
                                autoCloseable.close();
                                a2.getPlayer().dropMessage("\u73a9\u5bb6\u7de8\u865f[" + n3 + "] \u4e0d\u5b58\u5728\u65bc\u8cc7\u6599\u5eab");
                                n22 = 1;
                                if (druidPooledConnection == null) return n22 != 0;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable2;
                                if (druidPooledConnection != null) {
                                    try {
                                        druidPooledConnection.close();
                                        throwable2 = throwable;
                                        throw throwable2;
                                    }
                                    catch (Throwable a322) {
                                        throwable.addSuppressed(a322);
                                    }
                                }
                                throwable2 = throwable;
                                throw throwable2;
                            }
                            druidPooledConnection.close();
                            return n22 != 0;
                        }
                        bl = autoCloseable.getInt(GMCommand.ALLATORIxDEMO("\u0001S\ff\u0003^\t")) == 1;
                        n22 = bl ? 0 : 1;
                        autoCloseable = druidPooledConnection.prepareStatement("Update characters set canTalk = " + n22 + " Where id = " + n3);
                        try {
                            autoCloseable.executeUpdate();
                            if (autoCloseable == null) break block19;
                            mapleClient = a2;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable3;
                            if (autoCloseable != null) {
                                try {
                                    autoCloseable.close();
                                    throwable3 = throwable;
                                    throw throwable3;
                                }
                                catch (Throwable throwable32) {
                                    throwable.addSuppressed(throwable32);
                                }
                            }
                            throwable3 = throwable;
                            throw throwable3;
                        }
                        autoCloseable.close();
                        break block20;
                    }
                    mapleClient = a2;
                }
                mapleClient.getPlayer().dropMessage("\u73a9\u5bb6[" + n3 + "] \u76ee\u524d\u5df2\u7d93" + (n22 == 1 ? Pair.ALLATORIxDEMO("\u538b\u4ef9\u8ace\u8a6d") : GMCommand.ALLATORIxDEMO("\u95bb\u5656")));
                if (druidPooledConnection == null) return true;
                druidPooledConnection.close();
                return true;
            }
            catch (Exception exception) {
                a2.getPlayer().dropMessage("\u767c\u751f\u7570\u5e38\u60c5\u6cc1 " + exception);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + Pair.ALLATORIxDEMO("Q\u0011h\u0001U <m\u73b5\u5bd2\u7df4\u863b<I<\u8bf7\u73b5\u5bd2\u9595\u5650\u620a\u538b\u4ef9\u8ace\u8a6d");
        }

        public /* synthetic */ MuteID() {
            MuteID a2;
        }
    }

    public static class Mute
    extends CommandExecute {
        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a322) {
            Object object;
            if (((Object)a322).length < 2) {
                return false;
            }
            Object object2 = "";
            try {
                object = object2 = a322[1];
            }
            catch (Exception exception) {
                object = object2;
            }
            int n3 = World.Find.findChannel((String)object);
            int n2 = World.Find.findWorld((String)object2);
            if (n3 > 0) {
                MapleCharacter mapleCharacter;
                mapleCharacter.canTalk(!(mapleCharacter = ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterByName((String)object2)).getCanTalk());
                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + mapleCharacter.getName() + "] \u76ee\u524d\u5df2\u7d93" + (mapleCharacter.getCanTalk() ? MapleFoothold.ALLATORIxDEMO("\u53bf\u4eb9\u8afa\u8a2d") : PlayersHandler.ALLATORIxDEMO("\u95a3\u5632")));
                return true;
            }
            if (n3 == -10) {
                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + (String)a322[1] + "] \u76ee\u524d\u6b63\u5728\u8cfc\u7269\u5546\u57ce");
                return true;
            }
            try {
                MapleClient mapleClient;
                DruidPooledConnection druidPooledConnection;
                block20: {
                    block19: {
                        AutoCloseable autoCloseable;
                        boolean bl;
                        block18: {
                            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                            try {
                                bl = true;
                                a322 = druidPooledConnection.prepareStatement(MapleFoothold.ALLATORIxDEMO("\u000f\u0015\u0010\u0015\u001f\u0004|3=>\b10;|\u0016\u000e\u001f\u0011p?8=\"=3(5.#|\u0007\u0014\u0015\u000e\u0015|>==9papc"));
                                a322.setString(1, (String)object2);
                                autoCloseable = a322.executeQuery();
                                if (autoCloseable.next()) break block18;
                                a322.close();
                                autoCloseable.close();
                                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + (String)object2 + "] \u4e0d\u5b58\u5728\u65bc\u8cc7\u6599\u5eab");
                                n2 = 1;
                                if (druidPooledConnection == null) return n2 != 0;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable2;
                                if (druidPooledConnection != null) {
                                    try {
                                        druidPooledConnection.close();
                                        throwable2 = throwable;
                                        throw throwable2;
                                    }
                                    catch (Throwable a322) {
                                        throwable.addSuppressed(a322);
                                    }
                                }
                                throwable2 = throwable;
                                throw throwable2;
                            }
                            druidPooledConnection.close();
                            return n2 != 0;
                        }
                        bl = autoCloseable.getInt(PlayersHandler.ALLATORIxDEMO("eKh~gFm")) == 1;
                        n2 = bl ? 0 : 1;
                        autoCloseable = druidPooledConnection.prepareStatement("Update characters set canTalk = " + n2 + " Where name = " + (String)object2);
                        try {
                            autoCloseable.executeUpdate();
                            if (autoCloseable == null) break block19;
                            mapleClient = a2;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable3;
                            if (autoCloseable != null) {
                                try {
                                    autoCloseable.close();
                                    throwable3 = throwable;
                                    throw throwable3;
                                }
                                catch (Throwable throwable32) {
                                    throwable.addSuppressed(throwable32);
                                }
                            }
                            throwable3 = throwable;
                            throw throwable3;
                        }
                        autoCloseable.close();
                        break block20;
                    }
                    mapleClient = a2;
                }
                mapleClient.getPlayer().dropMessage("\u73a9\u5bb6[" + (String)object2 + "] \u76ee\u524d\u5df2\u7d93" + (n2 == 1 ? MapleFoothold.ALLATORIxDEMO("\u53bf\u4eb9\u8afa\u8a2d") : PlayersHandler.ALLATORIxDEMO("\u95a3\u5632")));
                if (druidPooledConnection == null) return true;
                druidPooledConnection.close();
                return true;
            }
            catch (Exception exception) {
                a2.getPlayer().dropMessage("\u767c\u751f\u7570\u5e38\u60c5\u6cc1 " + exception);
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u5de1\u908f\u8005.getCommandPrefix() + MapleFoothold.ALLATORIxDEMO("\u0011%(5|Y\u73f5\u5be6\u5451\u7a61|}|\u8bc3\u73f5\u5be6\u95d5\u5664\u624a\u53bf\u4eb9\u8afa\u8a2d");
        }

        public /* synthetic */ Mute() {
            Mute a2;
        }
    }
}

