/*
 * Decompiled with CFR 0.150.
 */
package server.buffs;

import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import tools.Pair;

public abstract class AbstractBuffClass {
    public /* synthetic */ boolean containsJob(int a2) {
        return false;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ 5;
        int cfr_ignored_0 = (2 ^ 5) << 4;
        int n5 = n3;
        int n6 = 3 << 3 ^ (3 ^ 5);
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

    public /* synthetic */ AbstractBuffClass() {
        AbstractBuffClass a2;
    }

    public abstract /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> handleBuff(MapleStatEffect var1, int var2);
}

