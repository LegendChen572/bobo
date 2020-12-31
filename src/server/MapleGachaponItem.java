/*
 * Decompiled with CFR 0.150.
 */
package server;

public class MapleGachaponItem {
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int k;
    private final /* synthetic */ int K;
    private final /* synthetic */ int g;
    private /* synthetic */ int B;
    private final /* synthetic */ int d;
    private final /* synthetic */ int a;
    private final /* synthetic */ int E;

    public /* synthetic */ MapleGachaponItem(int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9) {
        MapleGachaponItem a10;
        MapleGachaponItem mapleGachaponItem = a10;
        MapleGachaponItem mapleGachaponItem2 = a10;
        MapleGachaponItem mapleGachaponItem3 = a10;
        MapleGachaponItem mapleGachaponItem4 = a10;
        mapleGachaponItem4.E = a2;
        mapleGachaponItem4.g = a3;
        mapleGachaponItem3.B = a4;
        mapleGachaponItem3.k = a5;
        mapleGachaponItem2.K = a6;
        mapleGachaponItem2.a = a7;
        mapleGachaponItem.d = a8;
        mapleGachaponItem.ALLATORIxDEMO = a9;
    }

    public /* synthetic */ int getSmegaType() {
        MapleGachaponItem a2;
        return a2.d;
    }

    public /* synthetic */ int getMinQuantity() {
        MapleGachaponItem a2;
        return a2.k;
    }

    public /* synthetic */ int getItemId() {
        MapleGachaponItem a2;
        return a2.E;
    }

    public /* synthetic */ int getRemainingQuantity() {
        MapleGachaponItem a2;
        return a2.B;
    }

    public /* synthetic */ int getChance() {
        MapleGachaponItem a2;
        return a2.a;
    }

    public /* synthetic */ int getGachaponType() {
        MapleGachaponItem a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getQuantity() {
        MapleGachaponItem a2;
        return a2.g;
    }

    public /* synthetic */ void setRemainingQuantity(int a2) {
        a.B = a2;
    }

    public /* synthetic */ int getMaxQuantity() {
        MapleGachaponItem a2;
        return a2.K;
    }
}

