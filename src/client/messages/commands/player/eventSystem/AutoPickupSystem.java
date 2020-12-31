/*
 * Decompiled with CFR 0.150.
 */
package client.messages.commands.player.eventSystem;

import client.MapleClient;
import client.MapleKeyLayout;
import client.messages.CommandExecute;
import constants.ServerConstants;
import tools.packet.BeansPacket;

public class AutoPickupSystem {
    public /* synthetic */ AutoPickupSystem() {
        AutoPickupSystem a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 1 << 3;
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ 3;
        int n5 = n3;
        int n6 = 4 << 4 ^ (2 ^ 5);
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
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public static class pick
    extends CommandExecute {
        public /* synthetic */ pick() {
            pick a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + MapleKeyLayout.ALLATORIxDEMO("Z\u0014I\u0016\nP\n\u95f6\u5575\u626b\u95f6\u95f4\u4e90\u7214\u81c0\u52a8\u6495\u7214");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a2.getPlayer().setAutoPickup(!a2.getPlayer().isAutoPickup());
            a2.getPlayer().dropMessage("\u5df2\u7d93 " + (a2.getPlayer().isAutoPickup() ? MapleKeyLayout.ALLATORIxDEMO("\u95a1\u5522") : BeansPacket.ALLATORIxDEMO("\u959e\u95ac")) + " \u4eba\u7269\u81ea\u52d5\u64bf\u53d6\u7269\u54c1\u529f\u80fd");
            return true;
        }
    }
}

