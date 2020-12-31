/*
 * Decompiled with CFR 0.150.
 */
package client.messages.commands;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleCoreAura;
import client.MapleStat;
import client.messages.CommandExecute;
import constants.JobConstants;
import constants.PiPiConfig;
import constants.ServerConstants;
import handling.channel.ChannelServer;
import handling.world.CheaterData;
import handling.world.MapleMessengerCharacter;
import handling.world.World;
import server.life.ItemDropEntry;
import tools.ArrayMap;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.data.ByteArrayByteStream;

public class SkilledCommand {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u8001\u5be6\u7fd2\u751f;
    }

    public /* synthetic */ SkilledCommand() {
        SkilledCommand a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int cfr_ignored_0 = 4 << 4 ^ (2 << 2 ^ 3);
        int n5 = n3;
        int n6 = 5 << 3 ^ 3;
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

    public static class HealMap
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            for (MapleCharacter mapleCharacter : a2.getPlayer().getMap().getCharacters()) {
                if (mapleCharacter == null) continue;
                mapleCharacter.getStat().setHp(mapleCharacter.getStat().getCurrentMaxHp());
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.updateSingleStat(MapleStat.HP, mapleCharacter2.getStat().getCurrentMaxHp());
                mapleCharacter2.getStat().setMp(mapleCharacter.getStat().getCurrentMaxMp());
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.updateSingleStat(MapleStat.MP, mapleCharacter3.getStat().getCurrentMaxMp());
                mapleCharacter3.dispelDebuffs();
            }
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8001\u5be6\u7fd2\u751f.getCommandPrefix() + MapleCoreAura.ALLATORIxDEMO("\u0018i\u0011`\u001dm\u0000,P!P\u6cb7\u7622\u573c\u5766\u4e06\u6230\u6705\u76f4\u4eb6");
        }

        public /* synthetic */ HealMap() {
            HealMap a2;
        }
    }

    public static class HealPVP
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient = a2;
            MapleCharacter mapleCharacter = mapleClient.getPlayer();
            int a32 = Integer.parseInt(a32[1]);
            int n2 = JobConstants.getPvpMaxHp(mapleCharacter, false);
            mapleCharacter.getStat().setHp(a32);
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.updateSingleStat(MapleStat.HP, a32);
            mapleCharacter2.getStat().setMp(mapleCharacter.getStat().getCurrentMaxMp());
            MapleCharacter mapleCharacter3 = mapleCharacter;
            mapleCharacter3.updateSingleStat(MapleStat.MP, mapleCharacter3.getStat().getCurrentMaxMp());
            mapleCharacter3.dispelDebuffs();
            mapleClient.getPlayer().dropMessage("\u6700\u5927\u8840\u91cf:" + n2);
            return true;
        }

        public /* synthetic */ HealPVP() {
            HealPVP a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8001\u5be6\u7fd2\u751f.getCommandPrefix() + CheaterData.ALLATORIxDEMO("mpdyhtu5%8%\u6cae\u7657\u5725\u5713\u4e1f\u6245\u671c\u7681\u4eaf");
        }
    }

    public static class Heal
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().getStat().setHp(a2.getPlayer().getStat().getCurrentMaxHp());
            a2.getPlayer().getStat().setMp(a2.getPlayer().getStat().getCurrentMaxMp());
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().updateSingleStat(MapleStat.HP, a2.getPlayer().getStat().getCurrentMaxHp());
            MapleClient mapleClient2 = a2;
            mapleClient.getPlayer().updateSingleStat(MapleStat.MP, mapleClient2.getPlayer().getStat().getCurrentMaxMp());
            mapleClient2.getPlayer().dispelDebuffs();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8001\u5be6\u7fd2\u751f.getCommandPrefix() + ByteArrayByteStream.ALLATORIxDEMO("_HVA\u0017\u0000\u0017\u88f1\u6ec8\u886d\u9b63");
        }

        public /* synthetic */ Heal() {
            Heal a2;
        }
    }

    public static class FakeReport
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (((String[])a3).length < 2) {
                return false;
            }
            a3 = a3[1];
            int n2 = World.Find.findChannel((String)a3);
            int n3 = World.Find.findWorld((String)a3);
            if (n2 <= 0) {
                a2.getPlayer().dropMessage("\u73a9\u5bb6[" + (String)a3 + "]\u4e0d\u5728\u7dda\u4e0a");
                return true;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName((String)a3);
            if (mapleCharacter.isGM()) {
                a2.getPlayer().dropMessage(1, ItemDropEntry.ALLATORIxDEMO("\u713b\u6cd8\u9ecb\u55a3]@\u552d"));
                return true;
            }
            PiPiConfig.setBlackList(mapleCharacter.getAccountID(), (String)a3);
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] GM " + a2.getPlayer().getName() + " \u5728\u56de\u5831\u7cfb\u7d71\u9ed1\u55ae\u4e86 " + (String)a3));
            FileoutputUtil.logToFile(ArrayMap.ALLATORIxDEMO("\u00039\b%@\u0012\u000e\"\u000ey\u73c6\u5be0\u56b1\u5867\u9ebe\u55f8A\"\u0017\""), "\r\n  " + FileoutputUtil.NowTime() + " GM " + a2.getPlayer().getName() + " \u5728\u56de\u5831\u7cfb\u7d71\u9ed1\u55ae\u4e86 " + (String)a3);
            return true;
        }

        public /* synthetic */ FakeReport() {
            FakeReport a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8001\u5be6\u7fd2\u751f.getCommandPrefix() + ItemDropEntry.ALLATORIxDEMO("K{f\u007f_\u007f}u\u007fn-&\u73a4\u5bac\u5400\u7a2b3: :\u5c0a\u73b3\u5bbb\u8a37\u5b97\u70a0\u712c\u6ccf\u56d3\u582b\u7689\u9ecb\u5400\u55b4");
        }
    }

    public static class Level
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a32) {
            MapleClient mapleClient;
            if (a32.length < 2) {
                return false;
            }
            short s2 = a2.getPlayer().getLevel();
            try {
                s2 = Short.parseShort(a32[1]);
                mapleClient = a2;
            }
            catch (Exception a32) {
                mapleClient = a2;
            }
            mapleClient.getPlayer().setLevel(s2);
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().updateSingleStat(MapleStat.LEVEL, s2);
            mapleClient2.getPlayer().setExp(0);
            return true;
        }

        public /* synthetic */ Level() {
            Level a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u8001\u5be6\u7fd2\u751f.getCommandPrefix() + MapleMessengerCharacter.ALLATORIxDEMO("Hkrkh.8\u7b47\u7d1e0$#$\u6537\u8b8e\u7b47\u7d1e");
        }
    }
}

