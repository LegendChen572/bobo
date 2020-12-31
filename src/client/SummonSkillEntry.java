/*
 * Decompiled with CFR 0.150.
 */
package client;

import java.awt.Point;

public class SummonSkillEntry {
    public /* synthetic */ byte type;
    public /* synthetic */ int delay;
    public /* synthetic */ short attackAfter;
    public /* synthetic */ byte attackCount;
    public /* synthetic */ byte dieMobCount;
    public /* synthetic */ Point rb;
    public /* synthetic */ byte mobCount;
    public /* synthetic */ Point lt;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 1 << 3 ^ 3;
        int cfr_ignored_0 = 2 << 3 ^ 4;
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

    public /* synthetic */ SummonSkillEntry() {
        SummonSkillEntry a2;
    }
}

