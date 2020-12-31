/*
 * Decompiled with CFR 0.150.
 */
package client;

import handling.opcodes.MapleBuffStat;
import java.io.Serializable;

public class MapleDiseaseValueHolder
implements Serializable {
    public /* synthetic */ MapleBuffStat disease;
    public /* synthetic */ long length;
    public /* synthetic */ long startTime;
    private static final /* synthetic */ long ALLATORIxDEMO = 9179541993413738569L;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ 3;
        int cfr_ignored_0 = 5 << 4 ^ 2 << 1;
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ (2 ^ 5);
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

    public /* synthetic */ MapleDiseaseValueHolder(MapleBuffStat a2, long a3, long a4) {
        MapleDiseaseValueHolder a5;
        MapleDiseaseValueHolder mapleDiseaseValueHolder = a5;
        a5.disease = a2;
        mapleDiseaseValueHolder.startTime = a3;
        mapleDiseaseValueHolder.length = a4;
    }
}

