/*
 * Decompiled with CFR 0.150.
 */
package server.shops;

import client.inventory.IItem;

public class MaplePlayerShopItem {
    public /* synthetic */ IItem item;
    public /* synthetic */ short bundles;
    public /* synthetic */ int price;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ (2 ^ 5);
        int cfr_ignored_0 = (3 ^ 5) << 3;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ (3 ^ 5);
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

    public /* synthetic */ MaplePlayerShopItem(IItem a2, short a3, int a4) {
        MaplePlayerShopItem a5;
        MaplePlayerShopItem maplePlayerShopItem = a5;
        a5.item = a2;
        maplePlayerShopItem.bundles = a3;
        maplePlayerShopItem.price = a4;
    }
}

