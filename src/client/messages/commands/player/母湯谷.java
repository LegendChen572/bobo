/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 */
package client.messages.commands.player;

import constants.ServerConstants;

public class \u6bcd\u6e6f\u8c37 {
    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public /* synthetic */ \u6bcd\u6e6f\u8c37() {
        \u6bcd\u6e6f\u8c37 a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ (3 << 2 ^ 1);
        int cfr_ignored_0 = (3 ^ 5) << 3 ^ (2 ^ 5);
        int n5 = n3;
        char c2 = '\u0001';
        while (n5 >= 0) {
            int n6 = n3--;
            arrc[n6] = (char)(a2.charAt(n6) ^ c2);
            if (n3 < 0) break;
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }
}

