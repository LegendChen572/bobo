/*
 * Decompiled with CFR 0.150.
 */
package server;

public class StructRewardItem {
    public /* synthetic */ int itemid;
    public /* synthetic */ String effect;
    public /* synthetic */ short quantity;
    public /* synthetic */ long period;
    public /* synthetic */ int prob;
    public /* synthetic */ String worldmsg;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 4 << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = 1 << 3 ^ 2;
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

    public /* synthetic */ StructRewardItem() {
        StructRewardItem a2;
    }
}

