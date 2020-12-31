/*
 * Decompiled with CFR 0.150.
 */
package server.Extend;

public class SpecialItemData {
    private final /* synthetic */ int J;
    private final /* synthetic */ int K;
    private final /* synthetic */ int e;
    private final /* synthetic */ int E;
    private final /* synthetic */ int M;
    private final /* synthetic */ int j;
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int F;
    private final /* synthetic */ int C;
    private final /* synthetic */ int k;
    private final /* synthetic */ int L;
    private final /* synthetic */ int B;
    private final /* synthetic */ int I;
    private final /* synthetic */ int g;
    private final /* synthetic */ int a;
    private final /* synthetic */ int i;
    private final /* synthetic */ int d;
    private final /* synthetic */ int H;

    public /* synthetic */ int getMdef() {
        SpecialItemData a2;
        return a2.C;
    }

    public /* synthetic */ int getExp() {
        SpecialItemData a2;
        return a2.j;
    }

    public /* synthetic */ int getWatk() {
        SpecialItemData a2;
        return a2.M;
    }

    public /* synthetic */ int getMeso() {
        SpecialItemData a2;
        return a2.J;
    }

    public /* synthetic */ int getJump() {
        SpecialItemData a2;
        return a2.E;
    }

    public /* synthetic */ int getStr() {
        SpecialItemData a2;
        return a2.K;
    }

    public /* synthetic */ int getHpRate() {
        SpecialItemData a2;
        return a2.B;
    }

    public /* synthetic */ int getWdef() {
        SpecialItemData a2;
        return a2.F;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3;
        int cfr_ignored_0 = 2 << 3 ^ 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 3;
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

    public /* synthetic */ int getMatk() {
        SpecialItemData a2;
        return a2.I;
    }

    public /* synthetic */ int getMpRate() {
        SpecialItemData a2;
        return a2.k;
    }

    public /* synthetic */ int getAvoid() {
        SpecialItemData a2;
        return a2.e;
    }

    public /* synthetic */ int getInt() {
        SpecialItemData a2;
        return a2.d;
    }

    public /* synthetic */ int getDex() {
        SpecialItemData a2;
        return a2.a;
    }

    public /* synthetic */ int getDrop() {
        SpecialItemData a2;
        return a2.i;
    }

    public /* synthetic */ int getItemId() {
        SpecialItemData a2;
        return a2.L;
    }

    public /* synthetic */ SpecialItemData(int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, int a18, int a19) {
        SpecialItemData a20;
        SpecialItemData specialItemData = a20;
        SpecialItemData specialItemData2 = a20;
        SpecialItemData specialItemData3 = a20;
        SpecialItemData specialItemData4 = a20;
        SpecialItemData specialItemData5 = a20;
        SpecialItemData specialItemData6 = a20;
        SpecialItemData specialItemData7 = a20;
        SpecialItemData specialItemData8 = a20;
        SpecialItemData specialItemData9 = a20;
        specialItemData9.L = a2;
        specialItemData9.j = a3;
        specialItemData8.i = a4;
        specialItemData8.J = a5;
        specialItemData7.M = a6;
        specialItemData7.I = a7;
        specialItemData6.F = a8;
        specialItemData6.C = a9;
        specialItemData5.H = a10;
        specialItemData5.e = a11;
        specialItemData4.E = a12;
        specialItemData4.g = a13;
        specialItemData3.B = a14;
        specialItemData3.k = a15;
        specialItemData2.K = a16;
        specialItemData2.a = a17;
        specialItemData.d = a18;
        specialItemData.ALLATORIxDEMO = a19;
    }

    public /* synthetic */ int getSpeed() {
        SpecialItemData a2;
        return a2.g;
    }

    public /* synthetic */ int getLuk() {
        SpecialItemData a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getAcc() {
        SpecialItemData a2;
        return a2.H;
    }
}

