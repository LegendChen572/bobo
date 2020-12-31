/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.inventory.IItem;

public class MapleShopItem {
    private final /* synthetic */ short L;
    private final /* synthetic */ int i;
    private /* synthetic */ IItem ALLATORIxDEMO;
    private final /* synthetic */ boolean g;
    private final /* synthetic */ int F;
    private final /* synthetic */ int e;
    private final /* synthetic */ byte E;
    private final /* synthetic */ int H;
    private final /* synthetic */ int K;
    private final /* synthetic */ int I;
    private final /* synthetic */ int k;
    private /* synthetic */ int a;
    private final /* synthetic */ int J;
    private final /* synthetic */ int M;
    private final /* synthetic */ int C;
    private final /* synthetic */ short d;
    private final /* synthetic */ int j;
    private final /* synthetic */ int B;

    public /* synthetic */ int getReqItem() {
        MapleShopItem a2;
        return a2.J;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = 2 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ (3 ^ 5) << 1;
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

    public /* synthetic */ short getBuyable() {
        MapleShopItem a2;
        return a2.L;
    }

    public /* synthetic */ int getPrice() {
        MapleShopItem a2;
        return a2.i;
    }

    public /* synthetic */ int getReqItemQ() {
        MapleShopItem a2;
        return a2.M;
    }

    public /* synthetic */ int getExpiration() {
        MapleShopItem a2;
        return a2.e;
    }

    public /* synthetic */ int getReqItemQ2() {
        MapleShopItem a2;
        return a2.F;
    }

    public /* synthetic */ int getFriendPoints() {
        MapleShopItem a2;
        return a2.K;
    }

    public /* synthetic */ boolean hasPotential() {
        MapleShopItem a2;
        return a2.g;
    }

    public /* synthetic */ int getBuyTimesLimit() {
        MapleShopItem a2;
        return a2.B;
    }

    public /* synthetic */ IItem getReBuyItem() {
        MapleShopItem a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MapleShopItem(IItem a2, int a3, short a4) {
        MapleShopItem a5;
        MapleShopItem mapleShopItem = a5;
        MapleShopItem mapleShopItem2 = a5;
        MapleShopItem mapleShopItem3 = a5;
        MapleShopItem mapleShopItem4 = a5;
        MapleShopItem mapleShopItem5 = a5;
        MapleShopItem mapleShopItem6 = a5;
        MapleShopItem mapleShopItem7 = a5;
        MapleShopItem mapleShopItem8 = a5;
        MapleShopItem mapleShopItem9 = a5;
        mapleShopItem9.ALLATORIxDEMO = a2;
        mapleShopItem9.L = a4;
        mapleShopItem8.a = 1;
        mapleShopItem8.j = a2.getItemId();
        mapleShopItem7.i = a3;
        mapleShopItem7.d = 0;
        mapleShopItem6.J = 0;
        mapleShopItem6.M = 0;
        mapleShopItem5.I = 0;
        mapleShopItem5.F = 0;
        mapleShopItem4.E = (byte)0;
        mapleShopItem4.C = 0;
        mapleShopItem3.H = 0;
        mapleShopItem3.e = 0;
        mapleShopItem2.g = 0;
        mapleShopItem2.B = 0;
        mapleShopItem.k = 0;
        mapleShopItem.K = 0;
    }

    public /* synthetic */ MapleShopItem(int a2, int a3, short a4, short a5) {
        MapleShopItem a6;
        MapleShopItem mapleShopItem = a6;
        MapleShopItem mapleShopItem2 = a6;
        MapleShopItem mapleShopItem3 = a6;
        MapleShopItem mapleShopItem4 = a6;
        MapleShopItem mapleShopItem5 = a6;
        MapleShopItem mapleShopItem6 = a6;
        MapleShopItem mapleShopItem7 = a6;
        MapleShopItem mapleShopItem8 = a6;
        a6.L = a5;
        mapleShopItem8.a = 1;
        mapleShopItem8.j = a2;
        mapleShopItem7.i = a3;
        mapleShopItem7.d = a4;
        mapleShopItem6.J = 0;
        mapleShopItem6.M = 0;
        mapleShopItem5.I = 0;
        mapleShopItem5.F = 0;
        mapleShopItem4.E = (byte)0;
        mapleShopItem4.C = 0;
        mapleShopItem3.H = 0;
        mapleShopItem3.e = 0;
        mapleShopItem2.g = 0;
        mapleShopItem2.B = 0;
        mapleShopItem.k = 0;
        mapleShopItem.K = 0;
    }

    public /* synthetic */ int getMinLevel() {
        MapleShopItem a2;
        return a2.H;
    }

    public /* synthetic */ int getItemId() {
        MapleShopItem a2;
        return a2.j;
    }

    public /* synthetic */ byte getRank() {
        MapleShopItem a2;
        return a2.E;
    }

    public /* synthetic */ int getReqItem2() {
        MapleShopItem a2;
        return a2.I;
    }

    public /* synthetic */ int getCategory() {
        MapleShopItem a2;
        return a2.C;
    }

    public /* synthetic */ int getFriends() {
        MapleShopItem a2;
        return a2.k;
    }

    public /* synthetic */ MapleShopItem(short a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12) {
        MapleShopItem a13;
        MapleShopItem mapleShopItem = a13;
        MapleShopItem mapleShopItem2 = a13;
        MapleShopItem mapleShopItem3 = a13;
        MapleShopItem mapleShopItem4 = a13;
        MapleShopItem mapleShopItem5 = a13;
        MapleShopItem mapleShopItem6 = a13;
        MapleShopItem mapleShopItem7 = a13;
        MapleShopItem mapleShopItem8 = a13;
        a13.L = a2;
        mapleShopItem8.j = a3;
        mapleShopItem8.i = a4;
        mapleShopItem7.J = a5;
        mapleShopItem7.M = a6;
        mapleShopItem6.I = a7;
        mapleShopItem6.F = a8;
        mapleShopItem5.C = a9;
        mapleShopItem5.H = 0;
        mapleShopItem4.e = a10;
        mapleShopItem4.E = 0;
        mapleShopItem3.g = 0;
        mapleShopItem3.B = 0;
        mapleShopItem2.k = a11;
        mapleShopItem2.K = a12;
        mapleShopItem.a = 1;
        mapleShopItem.d = 0;
    }
}

