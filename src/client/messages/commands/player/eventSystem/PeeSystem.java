/*
 * Decompiled with CFR 0.150.
 */
package client.messages.commands.player.eventSystem;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleStat;
import client.MapleTrait;
import client.inventory.IItem;
import client.inventory.Item;
import client.messages.CommandExecute;
import constants.GameSetConstants;
import constants.ServerConstants;
import handling.world.World;
import handling.world.family.MapleFamily;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.swing.autoupdate.GetSelfDocName;
import tools.GZIPCompression;
import tools.MaplePacketCreator;

public class PeeSystem {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public /* synthetic */ PeeSystem() {
        PeeSystem a2;
    }

    public static class poo
    extends CommandExecute {
        public /* synthetic */ poo() {
            poo a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + GetSelfDocName.ALLATORIxDEMO("y\u000bfD$D\u53b2\u4fdb\u4fb6");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter;
            MapleCharacter mapleCharacter2 = a2.getPlayer();
            if (((String[])a3).length < 2) {
                MapleCharacter mapleCharacter3 = mapleCharacter2;
                mapleCharacter3.dropMessage("\u8acb\u60a8\u518d\u6b21\u8f38\u5165 \"@poo " + mapleCharacter3.getPeeNumber() + "\" \u4f86\u5b8c\u6210\u4fbf\u4fbf(\u9632\u8173\u672c)");
                return true;
            }
            if (Integer.parseInt(a3[1]) != mapleCharacter2.getPeeNumber()) {
                MapleCharacter mapleCharacter4 = mapleCharacter2;
                mapleCharacter4.dropMessage("\u60a8\u7684\u4fbf\u4fbf\u8b58\u5225\u78bc\u70ba: " + mapleCharacter4.getPeeNumber() + " \u8acb\u91cd\u65b0\u8f38\u5165!");
                return true;
            }
            a3 = null;
            String string = null;
            String string2 = null;
            MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
            int n2 = -1;
            int n3 = mapleCharacter2.getPee();
            int n4 = -1;
            int n5 = -1;
            if (!GameSetConstants.PEETOPOO) {
                mapleCharacter2.dropMessage(6, GetSelfDocName.ALLATORIxDEMO("\u62c0\u5c2a\u7cf2\u7d15\u6723\u95ef\u6537\u55f0("));
                return true;
            }
            if (n3 < 50) {
                MapleCharacter mapleCharacter5 = mapleCharacter2;
                mapleCharacter5.dropMessage(6, "[\u8eab\u9ad4]: \u6211\u4e0d\u662f\u771f\u7684\u6709\u5fc3\u60c5\u53bb\u62c9\u5c4e\u3002\u8acb\u7a0d\u5f8c\u518d\u8a66.\u60f3\u62c9\u5c4e\u7684\u611f\u89ba: " + mapleCharacter5.getPee() + "%");
                return true;
            }
            if (Math.random() * 1000.0 <= 5.0) {
                n4 = GameSetConstants.PEE_CHAIR;
                n2 = 1;
                string2 = GZIPCompression.ALLATORIxDEMO("\u54f5 \u0012\u62c5\u4eb4\u4e01\u5c23-\u515a\u8ea7\u8f27\u76c4\u5928\u4e8a\uff33RmR");
                n5 = 6;
                string = "[!!\u72c2\u8cc0!!] " + mapleCharacter2.getName() + " \u525b\u525b\u5728\u8def\u908a\u62c9\u51fa\u4e86\u8d85\u7d1a\u7a00\u6709\u7684\u7269\u54c1 " + mapleItemInformationProvider.getName(n4) + " x " + n2 + "!";
                mapleCharacter = mapleCharacter2;
            } else if (n3 <= 70) {
                n4 = 4000377;
                n5 = 6;
                string2 = GetSelfDocName.ALLATORIxDEMO("\u54ceH\u5913\u8b79(\u62ad\u51f3\u4ee2\u4e09\u5c6b\u5761D\u6116\u89de\u5923\u8276\u66ab\u4ee2(");
                mapleCharacter = mapleCharacter2;
            } else {
                if (n3 <= 100) {
                    n4 = 4000378;
                    n5 = 6;
                    string2 = GZIPCompression.ALLATORIxDEMO("\u0012\u54cb\u001e\u5916\u8b2f-\u62fb\u51f6\u4eb4\u4e0c\u5915\u5764\u0012\u6113\u8988\u5926\u8220\u66ae\u4eb4-");
                }
                mapleCharacter = mapleCharacter2;
            }
            mapleCharacter.dropMessage(6, "[\u8eab\u9ad4]: " + string2);
            if (string != null) {
                World.Broadcast.broadcastMessage(MaplePacketCreator.broadcastMessage(n5, string));
            }
            a3 = new Item(n4, 0, (short)n2, 0);
            MapleCharacter mapleCharacter6 = mapleCharacter2;
            a3.setOwner(mapleCharacter2.getName());
            a3.setGMLog(mapleCharacter6.getName());
            MapleCharacter mapleCharacter7 = mapleCharacter2;
            mapleCharacter6.getMap().spawnItemDrop(mapleCharacter7, mapleCharacter7, (IItem)a3, mapleCharacter7.getPosition(), true, true);
            mapleCharacter6.resetPee();
            return true;
        }
    }

    public static class pee
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleCharacter mapleCharacter;
            MapleCharacter mapleCharacter2 = a2.getPlayer();
            if (((String[])a3).length < 2) {
                MapleCharacter mapleCharacter3 = mapleCharacter2;
                mapleCharacter3.dropMessage("\u8acb\u60a8\u518d\u6b21\u8f38\u5165 \"@pee " + mapleCharacter3.getPeeNumber() + "\" \u4f86\u5b8c\u6210\u5c3f\u5c3f(\u9632\u8173\u672c)");
                return true;
            }
            if (Integer.parseInt(a3[1]) != mapleCharacter2.getPeeNumber()) {
                MapleCharacter mapleCharacter4 = mapleCharacter2;
                mapleCharacter4.dropMessage("\u60a8\u7684\u5c3f\u5c3f\u8b58\u5225\u78bc\u70ba: " + mapleCharacter4.getPeeNumber() + " \u8acb\u91cd\u65b0\u8f38\u5165!");
                return true;
            }
            a3 = null;
            String string = null;
            String string2 = null;
            MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
            int n2 = mapleCharacter2.getPee();
            int n3 = -1;
            int n4 = -1;
            int n5 = -1;
            if (GameSetConstants.PEETOPOO) {
                mapleCharacter2.dropMessage(6, MapleFamily.ALLATORIxDEMO("\u5c51\u5c7f\u7c95\u7d31\u6744\u95cb\u6550a\u8aa5\u4f3f\u7546\u6289\u5c20\u7cbb\u7d1f\u3042"));
                return true;
            }
            if (!GameSetConstants.PEE_SYSTEM) {
                mapleCharacter2.dropMessage(6, MapleTrait.ALLATORIxDEMO("\u76bc\u5214\u4e74\u7178\u95d9\u6567\u5c6d\u5c66\u7ca9\u7d28\u3050"));
                return false;
            }
            if (n2 < 50) {
                MapleCharacter mapleCharacter5 = mapleCharacter2;
                mapleCharacter5.dropMessage(6, "[\u8eab\u9ad4]: \u6211\u73fe\u5728\u5c3f\u610f\u4e0d\u8db3!\u9084\u5c3f\u4e0d\u51fa\u4f86.\u60f3\u5c3f\u5c3f\u7684\u611f\u89ba: " + mapleCharacter5.getPee() + "%");
                return true;
            }
            if (!GameSetConstants.SERVER_NAME.equals(MapleFamily.ALLATORIxDEMO("\u676a\u778b\u8c77")) && !mapleCharacter2.getMap().hasBoss() && mapleCharacter2.getMap().characterSize() > 1) {
                MapleCharacter mapleCharacter6 = mapleCharacter2;
                mapleCharacter2.getStat().setHp(0);
                mapleCharacter6.getStat().setMp(0);
                MapleCharacter mapleCharacter7 = mapleCharacter2;
                mapleCharacter7.updateSingleStat(MapleStat.HP, 0);
                mapleCharacter7.updateSingleStat(MapleStat.MP, 0);
                string2 = MapleTrait.ALLATORIxDEMO("\u4f39\u667d\u60aa\u5c6d\u5c66\u88f9\u8db6\u4ee8\u7752\u89d9\u5597m\u9040\u6243\u7d0c\u5c5f\u4e54\u5113\u8a68\uff53");
                string = mapleCharacter6.getName() + " \u60f3\u5728\u5927\u5ead\u5ee3\u773e\u4e4b\u4e0b\u5c3f\u5c3f\u88ab\u8001\u5929\u61f2\u7f70,\u771f\u662f\u7f9e\u7f9e\u81c9!";
                mapleCharacter = mapleCharacter2;
            } else if (Math.random() * 1000.0 <= 5.0) {
                n3 = GameSetConstants.PEE_CHAIR;
                n4 = 1;
                string2 = MapleFamily.ALLATORIxDEMO("\u54a9lN\u5c7f\u4ee8\u4e4d\u5c7fa\u5106\u8eeb\u8f7b\u7688\u5974\u4ec6\uff6f\u001e1\u001e");
                n5 = 6;
                MapleCharacter mapleCharacter8 = mapleCharacter2;
                if (GameSetConstants.SERVER_NAME.equals(MapleTrait.ALLATORIxDEMO("\u8750\u4e12\u8c65"))) {
                    string = "[!!\u72c2\u8cc0!!] " + mapleCharacter8.getName() + " \u525b\u525b\u5728\u8def\u908a\u5c3f\u51fa\u4e86\u7d50\u77f3\uff0c\u5be6\u5728\u58d5\u68d2\u68d2!!";
                    mapleCharacter = mapleCharacter2;
                } else {
                    string = "[!!\u72c2\u8cc0!!] " + mapleCharacter8.getName() + " \u525b\u525b\u5728\u8def\u908a\u5c3f\u51fa\u4e86\u8d85\u7d1a\u7a00\u6709\u7684\u7269\u54c1 " + mapleItemInformationProvider.getName(n3) + " x " + n4 + "!";
                    mapleCharacter = mapleCharacter2;
                }
            } else if (n2 <= 75) {
                n4 = Randomizer.rand(1, 5);
                n3 = 2000012;
                string2 = MapleFamily.ALLATORIxDEMO("\u54a9lN\u5c7f\u4ee8\u4e4d\u5c7fa\u5106\u8eeb\u8f7b\u7688\u5974\u4ec6\uff6f\u001e1\u001e");
                n5 = 6;
                string = mapleCharacter2.getName() + " \u525b\u525b\u5728\u8def\u908a\u5c3f\u51fa\u4e86" + mapleItemInformationProvider.getName(n3) + n4 + "\u74f6!";
                mapleCharacter = mapleCharacter2;
            } else {
                if (n2 <= 100) {
                    n4 = Randomizer.rand(1, 5);
                    n3 = 2000019;
                    string2 = MapleTrait.ALLATORIxDEMO("\u549e~y\u5c6d\u4edf\u4e52\u597e\u58a8x\u513a\u8ef2\u675b\u5979\u8240\u66fb\u5534\uff58\f\u0006\f");
                    n5 = 6;
                    string = mapleCharacter2.getName() + " \u525b\u525b\u5728\u8def\u908a\u5c3f\u51fa\u4e86" + mapleItemInformationProvider.getName(n3) + n4 + "\u74f6!";
                }
                mapleCharacter = mapleCharacter2;
            }
            mapleCharacter.dropMessage(-3, "[\u8eab\u9ad4]: " + string2);
            World.Broadcast.broadcastMessage(MaplePacketCreator.broadcastMessage(n5, string));
            a3 = new Item(n3, 0, (short)n4, 0);
            MapleCharacter mapleCharacter9 = mapleCharacter2;
            a3.setOwner(mapleCharacter2.getName());
            a3.setGMLog(mapleCharacter9.getName());
            MapleCharacter mapleCharacter10 = mapleCharacter2;
            mapleCharacter9.getMap().spawnItemDrop(mapleCharacter10, mapleCharacter10, (IItem)a3, mapleCharacter10.getPosition(), true, true);
            mapleCharacter9.resetPee();
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + MapleFamily.ALLATORIxDEMO("0\u000b%NmN\u53fb\u5c51\u5c7f");
        }

        public /* synthetic */ pee() {
            pee a2;
        }
    }
}

