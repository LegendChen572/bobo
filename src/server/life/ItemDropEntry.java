/*
 * Decompiled with CFR 0.150.
 */
package server.life;

public class ItemDropEntry {
    public /* synthetic */ int dropperid;
    public /* synthetic */ int Minimum;
    public /* synthetic */ int chance;
    public /* synthetic */ short questid;
    public /* synthetic */ int Maximum;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 1 << 3 ^ 5;
        int cfr_ignored_0 = 2 << 3 ^ 3;
        int n5 = n3;
        int n6 = 3 << 3 ^ 2;
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

    public /* synthetic */ ItemDropEntry(int a2, int a3, int a4, int a5, short a6) {
        ItemDropEntry a7;
        ItemDropEntry itemDropEntry = a7;
        ItemDropEntry itemDropEntry2 = a7;
        a7.dropperid = a2;
        itemDropEntry2.chance = a3;
        itemDropEntry2.questid = a6;
        itemDropEntry.Minimum = a4;
        itemDropEntry.Maximum = a5;
    }
}

