/*
 * Decompiled with CFR 0.150.
 */
package client;

import java.io.Serializable;

public class SkillEntry
implements Serializable {
    public final /* synthetic */ byte position;
    public final /* synthetic */ int skillevel;
    public final /* synthetic */ long expiration;
    private static final /* synthetic */ long ALLATORIxDEMO = 9179541993413738569L;
    public final /* synthetic */ int teachId;
    public final /* synthetic */ int masterlevel;

    public /* synthetic */ SkillEntry(int a2, int a3, long a4, int a5, byte a6) {
        SkillEntry a7;
        SkillEntry skillEntry = a7;
        SkillEntry skillEntry2 = a7;
        a7.skillevel = a2;
        skillEntry2.masterlevel = a3;
        skillEntry2.expiration = a4;
        skillEntry.teachId = a5;
        skillEntry.position = a6;
    }

    public /* synthetic */ SkillEntry(int a2, int a3, long a4) {
        SkillEntry a5;
        SkillEntry skillEntry = a5;
        SkillEntry skillEntry2 = a5;
        a5.skillevel = a2;
        skillEntry2.masterlevel = a3;
        skillEntry2.expiration = a4;
        skillEntry.position = (byte)-1;
        skillEntry.teachId = 0;
    }

    public /* synthetic */ SkillEntry(int a2, int a3, long a4, int a5) {
        SkillEntry a6;
        SkillEntry skillEntry = a6;
        SkillEntry skillEntry2 = a6;
        a6.skillevel = a2;
        skillEntry2.masterlevel = a3;
        skillEntry2.expiration = a4;
        skillEntry.teachId = a5;
        skillEntry.position = (byte)-1;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ 1;
        int cfr_ignored_0 = 4 << 3 ^ 5;
        int n5 = n3;
        int n6 = 2 << 3 ^ 5;
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

