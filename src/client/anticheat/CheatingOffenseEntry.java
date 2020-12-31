/*
 * Decompiled with CFR 0.150.
 */
package client.anticheat;

import client.anticheat.CheatingOffense;

public class CheatingOffenseEntry {
    private /* synthetic */ int B;
    private /* synthetic */ int k;
    private /* synthetic */ long a;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ String d;
    private /* synthetic */ long K;
    private /* synthetic */ CheatingOffense g;

    public /* synthetic */ CheatingOffenseEntry(CheatingOffense a2, int a3) {
        CheatingOffenseEntry a4;
        CheatingOffenseEntry cheatingOffenseEntry = a4;
        CheatingOffenseEntry cheatingOffenseEntry2 = a4;
        cheatingOffenseEntry2.B = 0;
        cheatingOffenseEntry2.ALLATORIxDEMO = -1;
        cheatingOffenseEntry.g = a2;
        cheatingOffenseEntry.k = a3;
        cheatingOffenseEntry.a = System.currentTimeMillis();
    }

    public /* synthetic */ void incrementCount() {
        CheatingOffenseEntry a2;
        ++a2.B;
        a2.K = System.currentTimeMillis();
    }

    public /* synthetic */ void setParam(String a2) {
        a.d = a2;
    }

    public /* synthetic */ String getParam() {
        CheatingOffenseEntry a2;
        return a2.d;
    }

    public /* synthetic */ boolean isExpired() {
        CheatingOffenseEntry a2;
        return a2.K < System.currentTimeMillis() - a2.g.getValidityDuration();
    }

    public /* synthetic */ int getChrfor() {
        CheatingOffenseEntry a2;
        return a2.k;
    }

    public /* synthetic */ int getDbId() {
        CheatingOffenseEntry a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ long getLastOffenseTime() {
        CheatingOffenseEntry a2;
        return a2.K;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ 4;
        int cfr_ignored_0 = 4 << 4 ^ (3 << 2 ^ 1);
        int n5 = n3;
        int n6 = (2 ^ 5) << 3 ^ 5;
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

    public /* synthetic */ CheatingOffense getOffense() {
        CheatingOffenseEntry a2;
        return a2.g;
    }

    public /* synthetic */ int getPoints() {
        CheatingOffenseEntry a2;
        CheatingOffenseEntry cheatingOffenseEntry = a2;
        return cheatingOffenseEntry.B * cheatingOffenseEntry.g.getPoints();
    }

    public /* synthetic */ void setDbId(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getCount() {
        CheatingOffenseEntry a2;
        return a2.B;
    }
}

