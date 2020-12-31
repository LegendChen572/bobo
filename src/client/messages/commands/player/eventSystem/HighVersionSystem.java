/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package client.messages.commands.player.eventSystem;

import client.MapleClient;
import client.MapleJob;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.messages.CommandExecute;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import client.messages.commands.player.eventSystem.MapOwner;
import constants.ServerConstants;
import handling.channel.handler.HiredMerchantHandler;
import handling.channel.handler.NPCHandler;
import server.MapleInventoryManipulator;

public class HighVersionSystem {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public /* synthetic */ HighVersionSystem() {
        HighVersionSystem a2;
    }

    public static class ee
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + NPCHandler.ALLATORIxDEMO("\u0002fG.G\u91de\u5c6a\u8074\u690a\u8128\u8ecc\u4e09\u9a69\u5bf6\u9034\u5174\u5528\u984f");
        }

        public /* synthetic */ ee() {
            ee a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleClient mapleClient = a2;
            a3 = mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18);
            IItem iItem = mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-19);
            IItem iItem2 = mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-118);
            IItem iItem3 = mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-119);
            if (mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() <= 4) {
                a2.getPlayer().dropMessage(6, NPCHandler.ALLATORIxDEMO("\u814c\u8ea8\u4e6d\u9a0d\u5b92\u9050\u5110\u932c\u8ac3\uff0f\u8aac\u78b9\u8aea\u88de\u50fe\u6b07\u6648\u5425\u676e7\u685b\u7a79\u4f2a\u3001"));
                return true;
            }
            if (a3 != null) {
                MapleClient mapleClient2 = a2;
                MapleInventoryManipulator.unequip(mapleClient2, (short)-18, mapleClient2.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
            }
            if (iItem != null) {
                MapleClient mapleClient3 = a2;
                MapleInventoryManipulator.unequip(mapleClient3, (short)-19, mapleClient3.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
            }
            if (iItem2 != null) {
                MapleClient mapleClient4 = a2;
                MapleInventoryManipulator.unequip(mapleClient4, (short)-118, mapleClient4.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
            }
            if (iItem3 != null) {
                MapleClient mapleClient5 = a2;
                MapleInventoryManipulator.unequip(mapleClient5, (short)-119, mapleClient5.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
            }
            a2.getPlayer().dropMessage(6, MapOwner.ALLATORIxDEMO("e\u9a46\u5bcb\u901b\u5149\u0015\u001e\u539e\u4e35\u6258\u52a1i"));
            return true;
        }
    }

    public static class ew
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            if (MapleJob.is\u5f71\u6b66\u8005(a2.getPlayer().getJob())) {
                a3 = a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-110);
                if (a3 == null || a2.getPlayer().getInventory(MapleInventoryType.EQUIP).isFull()) {
                    a2.getPlayer().dropMessage(6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u53ab\u4e41\u5212\u6b2c\u5615\u9365\u8ad9\uff46\u5212\u6b2c\u5615\u4f07\u7f13\u753c\u5230\u7a30\u76f9\u9019\u510a\uff46\u626b\u804f\u88a0\u50d3\u6b79\u5db8\u6e82\u3048"));
                    return true;
                }
                MapleClient mapleClient = a2;
                MapleInventoryManipulator.unequip(mapleClient, (short)-110, mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
                a2.getPlayer().dropMessage(6, HiredMerchantHandler.ALLATORIxDEMO("U\u521b\u6b68\u561cST\u53d8\u4e7f\u621e\u52eb/"));
                return true;
            }
            a3 = a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-10);
            if (a3 == null || a2.getPlayer().getInventory(MapleInventoryType.EQUIP).isFull()) {
                a2.getPlayer().dropMessage(6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u53ab\u4e41\u5212\u6b2c\u5615\u9365\u8ad9\uff46\u5212\u6b2c\u5615\u4f07\u7f13\u753c\u5230\u7a30\u76f9\u9019\u510a\uff46\u626b\u804f\u88a0\u50d3\u6b79\u5db8\u6e82\u3048"));
                return true;
            }
            MapleClient mapleClient = a2;
            MapleInventoryManipulator.unequip(mapleClient, (short)-10, mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
            a2.getPlayer().dropMessage(6, HiredMerchantHandler.ALLATORIxDEMO("U\u521b\u6b68\u561cST\u53d8\u4e7f\u621e\u52eb/"));
            return true;
        }

        public /* synthetic */ ew() {
            ew a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0018=]g]\u9197\u5c70\u803d\u6910\u539c\u4e76\u5225\u6b1b\u5622\u5532\u9806");
        }
    }
}

