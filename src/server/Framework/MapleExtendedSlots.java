/*
 * Decompiled with CFR 0.150.
 */
package server.Framework;

public class MapleExtendedSlots {
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int d;

    public /* synthetic */ MapleExtendedSlots(int a2, int a3) {
        MapleExtendedSlots a4;
        MapleExtendedSlots mapleExtendedSlots = a4;
        mapleExtendedSlots.d = a2;
        mapleExtendedSlots.ALLATORIxDEMO = a3;
    }

    public /* synthetic */ int getUniqueid() {
        MapleExtendedSlots a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getItemId() {
        MapleExtendedSlots a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = 4 << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = 5 << 4 ^ 4 << 1;
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
}

