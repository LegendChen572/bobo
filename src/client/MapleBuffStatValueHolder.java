/*
 * Decompiled with CFR 0.150.
 */
package client;

import server.MapleStatEffect;

public class MapleBuffStatValueHolder {
    public /* synthetic */ long startTime;
    public /* synthetic */ int value;
    public /* synthetic */ int localDuration;
    public /* synthetic */ MapleStatEffect effect;
    public /* synthetic */ int cid;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 4 << 1;
        int n5 = n3;
        int n6 = 4 << 4;
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

    public /* synthetic */ MapleBuffStatValueHolder(MapleStatEffect a2, long a3, int a4, int a5, int a6) {
        MapleBuffStatValueHolder a7;
        MapleBuffStatValueHolder mapleBuffStatValueHolder = a7;
        MapleBuffStatValueHolder mapleBuffStatValueHolder2 = a7;
        a7.effect = a2;
        mapleBuffStatValueHolder2.startTime = a3;
        mapleBuffStatValueHolder2.value = a4;
        mapleBuffStatValueHolder.localDuration = a5;
        mapleBuffStatValueHolder.cid = a6;
    }
}

