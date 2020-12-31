/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import java.io.Serializable;
import java.util.Objects;

public class CheaterData
implements Serializable,
Comparable<CheaterData> {
    private final /* synthetic */ int d;
    private static final /* synthetic */ long a = -8733673311051249885L;
    private final /* synthetic */ String ALLATORIxDEMO;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5;
        int cfr_ignored_0 = (3 ^ 5) << 3 ^ (2 ^ 5);
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

    public /* synthetic */ int getPoints() {
        CheaterData a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ int compareTo(CheaterData a22) {
        int n2;
        CheaterData a3;
        int a22 = a3.getPoints();
        if (a22 < (n2 = a22.getPoints())) {
            return 1;
        }
        if (a22 == n2) {
            return 0;
        }
        return -1;
    }

    public /* synthetic */ String getInfo() {
        CheaterData a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ CheaterData(int a2, String a3) {
        CheaterData a4;
        CheaterData cheaterData = a4;
        cheaterData.d = a2;
        cheaterData.ALLATORIxDEMO = a3;
    }

    public /* synthetic */ int hashCode() {
        CheaterData a2;
        int n2 = 5;
        n2 = 83 * n2 + a2.d;
        n2 = 83 * n2 + Objects.hashCode(a2.ALLATORIxDEMO);
        return n2;
    }

    public /* synthetic */ boolean equals(Object a2) {
        CheaterData a3;
        if (!(a2 instanceof CheaterData)) {
            return false;
        }
        a2 = (CheaterData)a2;
        return ((CheaterData)a2).d == a3.d && ((CheaterData)a2).ALLATORIxDEMO.equals(a3.ALLATORIxDEMO);
    }
}

