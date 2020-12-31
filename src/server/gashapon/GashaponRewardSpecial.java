/*
 * Decompiled with CFR 0.150.
 */
package server.gashapon;

public class GashaponRewardSpecial {
    private final /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ int d;

    public /* synthetic */ int getItemId() {
        GashaponRewardSpecial a2;
        return a2.d;
    }

    public /* synthetic */ GashaponRewardSpecial(int a2, boolean a3) {
        GashaponRewardSpecial a4;
        GashaponRewardSpecial gashaponRewardSpecial = a4;
        gashaponRewardSpecial.d = a2;
        gashaponRewardSpecial.ALLATORIxDEMO = a3;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4;
        int cfr_ignored_0 = 4 << 4 ^ (3 << 2 ^ 1);
        int n5 = n3;
        int n6 = 4 << 3 ^ (2 ^ 5);
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

    public /* synthetic */ boolean canShowMsg() {
        GashaponRewardSpecial a2;
        return a2.ALLATORIxDEMO;
    }
}

