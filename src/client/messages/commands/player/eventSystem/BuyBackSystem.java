/*
 * Decompiled with CFR 0.150.
 */
package client.messages.commands.player.eventSystem;

import client.MapleClient;
import client.messages.CommandExecute;
import constants.ServerConstants;
import server.MapleShopFactory;
import tools.wztosql.DumpItemsAdditions;

public class BuyBackSystem {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public /* synthetic */ BuyBackSystem() {
        BuyBackSystem a2;
    }

    public static class SellShop
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + DumpItemsAdditions.ALLATORIxDEMO("\u001aC%J\u001aN&Vi\u000bi\u95ad\u5516\u5560\u5ede\u8c91\u5697");
        }

        public /* synthetic */ SellShop() {
            SellShop a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            MapleShopFactory.getInstance().getShopSell(a2.getPlayer()).sendShop(a2);
            return true;
        }
    }
}

